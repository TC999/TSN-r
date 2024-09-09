package io.netty.handler.codec.compression;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import java.util.zip.Checksum;
import net.jpountz.lz4.LZ4Compressor;
import net.jpountz.lz4.LZ4Exception;
import net.jpountz.lz4.LZ4Factory;
import net.jpountz.xxhash.XXHashFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Lz4FrameEncoder extends MessageToByteEncoder<ByteBuf> {
    private final int blockSize;
    private ByteBuf buffer;
    private Checksum checksum;
    private final int compressedBlockSize;
    private final int compressionLevel;
    private LZ4Compressor compressor;
    private volatile ChannelHandlerContext ctx;
    private int currentBlockLength;
    private volatile boolean finished;

    public Lz4FrameEncoder() {
        this(false);
    }

    private void cleanup() {
        this.compressor = null;
        this.checksum = null;
        ByteBuf byteBuf = this.buffer;
        if (byteBuf != null) {
            byteBuf.release();
            this.buffer = null;
        }
    }

    private static int compressionLevel(int i4) {
        if (i4 >= 64 && i4 <= 33554432) {
            return Math.max(0, (32 - Integer.numberOfLeadingZeros(i4 - 1)) - 10);
        }
        throw new IllegalArgumentException(String.format("blockSize: %d (expected: %d-%d)", Integer.valueOf(i4), 64, 33554432));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelHandlerContext ctx() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return channelHandlerContext;
        }
        throw new IllegalStateException("not added to a pipeline");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public ChannelFuture finishEncode(ChannelHandlerContext channelHandlerContext, ChannelPromise channelPromise) {
        if (this.finished) {
            channelPromise.setSuccess();
            return channelPromise;
        }
        this.finished = true;
        try {
            ByteBuf heapBuffer = channelHandlerContext.alloc().heapBuffer(this.compressor.maxCompressedLength(this.currentBlockLength) + 21);
            flushBufferedData(heapBuffer);
            int writerIndex = heapBuffer.writerIndex();
            heapBuffer.setLong(writerIndex, 5501767354678207339L);
            heapBuffer.setByte(writerIndex + 8, (byte) (this.compressionLevel | 16));
            heapBuffer.setInt(writerIndex + 9, 0);
            heapBuffer.setInt(writerIndex + 13, 0);
            heapBuffer.setInt(writerIndex + 17, 0);
            heapBuffer.writerIndex(writerIndex + 21);
            return channelHandlerContext.writeAndFlush(heapBuffer, channelPromise);
        } finally {
            cleanup();
        }
    }

    private void flushBufferedData(ByteBuf byteBuf) {
        int i4;
        int i5;
        int i6 = this.currentBlockLength;
        if (i6 == 0) {
            return;
        }
        this.checksum.reset();
        this.checksum.update(this.buffer.array(), this.buffer.arrayOffset(), i6);
        int value = (int) this.checksum.getValue();
        byteBuf.ensureWritable(this.compressedBlockSize);
        int writerIndex = byteBuf.writerIndex();
        int i7 = writerIndex + 21;
        try {
            ByteBuffer internalNioBuffer = byteBuf.internalNioBuffer(i7, byteBuf.writableBytes() - 21);
            int position = internalNioBuffer.position();
            this.compressor.compress(this.buffer.internalNioBuffer(0, i6), internalNioBuffer);
            int position2 = internalNioBuffer.position() - position;
            if (position2 >= i6) {
                i5 = 16;
                byteBuf.setBytes(i7, this.buffer, 0, i6);
                i4 = i6;
            } else {
                i4 = position2;
                i5 = 32;
            }
            byteBuf.setLong(writerIndex, 5501767354678207339L);
            byteBuf.setByte(writerIndex + 8, (byte) (i5 | this.compressionLevel));
            byteBuf.setIntLE(writerIndex + 9, i4);
            byteBuf.setIntLE(writerIndex + 13, i6);
            byteBuf.setIntLE(writerIndex + 17, value);
            byteBuf.writerIndex(i7 + i4);
            this.currentBlockLength = 0;
        } catch (LZ4Exception e4) {
            throw new CompressionException((Throwable) e4);
        }
    }

    public ChannelFuture close() {
        return close(ctx().newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
        this.buffer = Unpooled.wrappedBuffer(new byte[this.blockSize]);
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerRemoved(channelHandlerContext);
        cleanup();
    }

    public boolean isClosed() {
        return this.finished;
    }

    public Lz4FrameEncoder(boolean z3) {
        this(LZ4Factory.fastestInstance(), z3, 65536, XXHashFactory.fastestInstance().newStreamingHash32(-1756908916).asChecksum());
    }

    public ChannelFuture close(final ChannelPromise channelPromise) {
        ChannelHandlerContext ctx = ctx();
        EventExecutor executor = ctx.executor();
        if (executor.inEventLoop()) {
            return finishEncode(ctx, channelPromise);
        }
        executor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.Lz4FrameEncoder.1
            @Override // java.lang.Runnable
            public void run() {
                Lz4FrameEncoder lz4FrameEncoder = Lz4FrameEncoder.this;
                lz4FrameEncoder.finishEncode(lz4FrameEncoder.ctx(), channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(channelPromise));
            }
        });
        return channelPromise;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    public void encode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, ByteBuf byteBuf2) throws Exception {
        if (this.finished) {
            byteBuf2.writeBytes(byteBuf);
            return;
        }
        int readableBytes = byteBuf.readableBytes();
        ByteBuf byteBuf3 = this.buffer;
        int capacity = byteBuf3.capacity();
        while (true) {
            int i4 = this.currentBlockLength;
            if (i4 + readableBytes >= capacity) {
                int i5 = capacity - i4;
                byteBuf.getBytes(byteBuf.readerIndex(), byteBuf3, this.currentBlockLength, i5);
                this.currentBlockLength = capacity;
                flushBufferedData(byteBuf2);
                byteBuf.skipBytes(i5);
                readableBytes -= i5;
            } else {
                byteBuf.readBytes(byteBuf3, i4, readableBytes);
                this.currentBlockLength += readableBytes;
                return;
            }
        }
    }

    public Lz4FrameEncoder(LZ4Factory lZ4Factory, boolean z3, int i4, Checksum checksum) {
        if (lZ4Factory == null) {
            throw new NullPointerException("factory");
        }
        if (checksum != null) {
            this.compressor = z3 ? lZ4Factory.highCompressor() : lZ4Factory.fastCompressor();
            this.checksum = checksum;
            this.compressionLevel = compressionLevel(i4);
            this.blockSize = i4;
            this.currentBlockLength = 0;
            this.compressedBlockSize = this.compressor.maxCompressedLength(i4) + 21;
            this.finished = false;
            return;
        }
        throw new NullPointerException("checksum");
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) throws Exception {
        ChannelFuture finishEncode = finishEncode(channelHandlerContext, channelHandlerContext.newPromise());
        finishEncode.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.Lz4FrameEncoder.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                channelHandlerContext.close(channelPromise);
            }
        });
        if (finishEncode.isDone()) {
            return;
        }
        channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.compression.Lz4FrameEncoder.3
            @Override // java.lang.Runnable
            public void run() {
                channelHandlerContext.close(channelPromise);
            }
        }, 10L, TimeUnit.SECONDS);
    }
}
