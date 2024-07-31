package io.netty.handler.codec.compression;

import com.tencent.bugly.BUGLY;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPromise;
import io.netty.channel.ChannelPromiseNotifier;
import io.netty.handler.codec.MessageToByteEncoder;
import io.netty.util.concurrent.EventExecutor;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class Bzip2Encoder extends MessageToByteEncoder<ByteBuf> {
    private Bzip2BlockCompressor blockCompressor;
    private volatile ChannelHandlerContext ctx;
    private State currentState;
    private volatile boolean finished;
    private final int streamBlockSize;
    private int streamCRC;
    private final Bzip2BitWriter writer;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: io.netty.handler.codec.compression.Bzip2Encoder$4 */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public static /* synthetic */ class C137794 {
        static final /* synthetic */ int[] $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State = iArr;
            try {
                iArr[State.INIT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.INIT_BLOCK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.WRITE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State[State.CLOSE_BLOCK.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public enum State {
        INIT,
        INIT_BLOCK,
        WRITE_DATA,
        CLOSE_BLOCK
    }

    public Bzip2Encoder() {
        this(9);
    }

    private void closeBlock(ByteBuf byteBuf) {
        Bzip2BlockCompressor bzip2BlockCompressor = this.blockCompressor;
        if (bzip2BlockCompressor.isEmpty()) {
            return;
        }
        bzip2BlockCompressor.close(byteBuf);
        int crc = bzip2BlockCompressor.crc();
        int i = this.streamCRC;
        this.streamCRC = crc ^ ((i >>> 31) | (i << 1));
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
        ByteBuf buffer = channelHandlerContext.alloc().buffer();
        closeBlock(buffer);
        int i = this.streamCRC;
        Bzip2BitWriter bzip2BitWriter = this.writer;
        try {
            bzip2BitWriter.writeBits(buffer, 24, 1536581L);
            bzip2BitWriter.writeBits(buffer, 24, 3690640L);
            bzip2BitWriter.writeInt(buffer, i);
            bzip2BitWriter.flush(buffer);
            this.blockCompressor = null;
            return channelHandlerContext.writeAndFlush(buffer, channelPromise);
        } catch (Throwable th) {
            this.blockCompressor = null;
            throw th;
        }
    }

    public ChannelFuture close() {
        return close(ctx().newPromise());
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    public boolean isClosed() {
        return this.finished;
    }

    public Bzip2Encoder(int i) {
        this.currentState = State.INIT;
        this.writer = new Bzip2BitWriter();
        if (i >= 1 && i <= 9) {
            this.streamBlockSize = i * BUGLY.C12768a.MAX_USERDATA_VALUE_LENGTH;
            return;
        }
        throw new IllegalArgumentException("blockSizeMultiplier: " + i + " (expected: 1-9)");
    }

    public ChannelFuture close(final ChannelPromise channelPromise) {
        ChannelHandlerContext ctx = ctx();
        EventExecutor executor = ctx.executor();
        if (executor.inEventLoop()) {
            return finishEncode(ctx, channelPromise);
        }
        executor.execute(new Runnable() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.1
            @Override // java.lang.Runnable
            public void run() {
                Bzip2Encoder bzip2Encoder = Bzip2Encoder.this;
                bzip2Encoder.finishEncode(bzip2Encoder.ctx(), channelPromise).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelPromiseNotifier(channelPromise));
            }
        });
        return channelPromise;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0052 A[SYNTHETIC] */
    @Override // io.netty.handler.codec.MessageToByteEncoder
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void encode(io.netty.channel.ChannelHandlerContext r3, io.netty.buffer.ByteBuf r4, io.netty.buffer.ByteBuf r5) throws java.lang.Exception {
        /*
            r2 = this;
            boolean r3 = r2.finished
            if (r3 == 0) goto L8
            r5.writeBytes(r4)
            return
        L8:
            int[] r3 = io.netty.handler.codec.compression.Bzip2Encoder.C137794.$SwitchMap$io$netty$handler$codec$compression$Bzip2Encoder$State
            io.netty.handler.codec.compression.Bzip2Encoder$State r0 = r2.currentState
            int r0 = r0.ordinal()
            r3 = r3[r0]
            r0 = 1
            r1 = 4
            if (r3 == r0) goto L25
            r0 = 2
            if (r3 == r0) goto L3d
            r0 = 3
            if (r3 == r0) goto L4c
            if (r3 != r1) goto L1f
            goto L7e
        L1f:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r3.<init>()
            throw r3
        L25:
            r5.ensureWritable(r1)
            r3 = 4348520(0x425a68, float:6.093574E-39)
            r5.writeMedium(r3)
            int r3 = r2.streamBlockSize
            r0 = 100000(0x186a0, float:1.4013E-40)
            int r3 = r3 / r0
            int r3 = r3 + 48
            r5.writeByte(r3)
            io.netty.handler.codec.compression.Bzip2Encoder$State r3 = io.netty.handler.codec.compression.Bzip2Encoder.State.INIT_BLOCK
            r2.currentState = r3
        L3d:
            io.netty.handler.codec.compression.Bzip2BlockCompressor r3 = new io.netty.handler.codec.compression.Bzip2BlockCompressor
            io.netty.handler.codec.compression.Bzip2BitWriter r0 = r2.writer
            int r1 = r2.streamBlockSize
            r3.<init>(r0, r1)
            r2.blockCompressor = r3
            io.netty.handler.codec.compression.Bzip2Encoder$State r3 = io.netty.handler.codec.compression.Bzip2Encoder.State.WRITE_DATA
            r2.currentState = r3
        L4c:
            boolean r3 = r4.isReadable()
            if (r3 != 0) goto L53
            return
        L53:
            io.netty.handler.codec.compression.Bzip2BlockCompressor r3 = r2.blockCompressor
            int r0 = r4.readableBytes()
            int r1 = r3.availableSize()
            int r0 = java.lang.Math.min(r0, r1)
            int r1 = r4.readerIndex()
            int r0 = r3.write(r4, r1, r0)
            r4.skipBytes(r0)
            boolean r3 = r3.isFull()
            if (r3 != 0) goto L7a
            boolean r3 = r4.isReadable()
            if (r3 == 0) goto L79
            goto L8
        L79:
            return
        L7a:
            io.netty.handler.codec.compression.Bzip2Encoder$State r3 = io.netty.handler.codec.compression.Bzip2Encoder.State.CLOSE_BLOCK
            r2.currentState = r3
        L7e:
            r2.closeBlock(r5)
            io.netty.handler.codec.compression.Bzip2Encoder$State r3 = io.netty.handler.codec.compression.Bzip2Encoder.State.INIT_BLOCK
            r2.currentState = r3
            goto L8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.netty.handler.codec.compression.Bzip2Encoder.encode(io.netty.channel.ChannelHandlerContext, io.netty.buffer.ByteBuf, io.netty.buffer.ByteBuf):void");
    }

    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void close(final ChannelHandlerContext channelHandlerContext, final ChannelPromise channelPromise) throws Exception {
        ChannelFuture finishEncode = finishEncode(channelHandlerContext, channelHandlerContext.newPromise());
        finishEncode.addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.2
            @Override // io.netty.util.concurrent.GenericFutureListener
            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                channelHandlerContext.close(channelPromise);
            }
        });
        if (finishEncode.isDone()) {
            return;
        }
        channelHandlerContext.executor().schedule(new Runnable() { // from class: io.netty.handler.codec.compression.Bzip2Encoder.3
            @Override // java.lang.Runnable
            public void run() {
                channelHandlerContext.close(channelPromise);
            }
        }, 10L, TimeUnit.SECONDS);
    }
}
