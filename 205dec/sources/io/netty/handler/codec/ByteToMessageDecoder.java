package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.socket.ChannelInputShutdownEvent;
import io.netty.util.internal.StringUtil;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class ByteToMessageDecoder extends ChannelInboundHandlerAdapter {
    ByteBuf cumulation;
    private boolean decodeWasNull;
    private boolean first;
    private int numReads;
    private boolean singleDecode;
    public static final Cumulator MERGE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.1
        @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            if (byteBuf.writerIndex() > byteBuf.maxCapacity() - byteBuf2.readableBytes() || byteBuf.refCnt() > 1) {
                byteBuf = ByteToMessageDecoder.expandCumulation(byteBufAllocator, byteBuf, byteBuf2.readableBytes());
            }
            byteBuf.writeBytes(byteBuf2);
            byteBuf2.release();
            return byteBuf;
        }
    };
    public static final Cumulator COMPOSITE_CUMULATOR = new Cumulator() { // from class: io.netty.handler.codec.ByteToMessageDecoder.2
        @Override // io.netty.handler.codec.ByteToMessageDecoder.Cumulator
        public ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2) {
            CompositeByteBuf compositeBuffer;
            if (byteBuf.refCnt() > 1) {
                ByteBuf expandCumulation = ByteToMessageDecoder.expandCumulation(byteBufAllocator, byteBuf, byteBuf2.readableBytes());
                expandCumulation.writeBytes(byteBuf2);
                byteBuf2.release();
                return expandCumulation;
            }
            if (byteBuf instanceof CompositeByteBuf) {
                compositeBuffer = (CompositeByteBuf) byteBuf;
            } else {
                compositeBuffer = byteBufAllocator.compositeBuffer(Integer.MAX_VALUE);
                compositeBuffer.addComponent(true, byteBuf);
            }
            compositeBuffer.addComponent(true, byteBuf2);
            return compositeBuffer;
        }
    };
    private Cumulator cumulator = MERGE_CUMULATOR;
    private int discardAfterReads = 16;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface Cumulator {
        ByteBuf cumulate(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, ByteBuf byteBuf2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteToMessageDecoder() {
        CodecUtil.ensureNotSharable(this);
    }

    private void channelInputClosed(ChannelHandlerContext channelHandlerContext, boolean z3) throws Exception {
        CodecOutputList newInstance = CodecOutputList.newInstance();
        try {
            try {
                channelInputClosed(channelHandlerContext, newInstance);
                try {
                    ByteBuf byteBuf = this.cumulation;
                    if (byteBuf != null) {
                        byteBuf.release();
                        this.cumulation = null;
                    }
                    int size = newInstance.size();
                    fireChannelRead(channelHandlerContext, newInstance, size);
                    if (size > 0) {
                        channelHandlerContext.fireChannelReadComplete();
                    }
                    if (z3) {
                        channelHandlerContext.fireChannelInactive();
                    }
                } finally {
                }
            } catch (DecoderException e4) {
                throw e4;
            } catch (Exception e5) {
                throw new DecoderException(e5);
            }
        } catch (Throwable th) {
            try {
                ByteBuf byteBuf2 = this.cumulation;
                if (byteBuf2 != null) {
                    byteBuf2.release();
                    this.cumulation = null;
                }
                int size2 = newInstance.size();
                fireChannelRead(channelHandlerContext, newInstance, size2);
                if (size2 > 0) {
                    channelHandlerContext.fireChannelReadComplete();
                }
                if (z3) {
                    channelHandlerContext.fireChannelInactive();
                }
                throw th;
            } finally {
            }
        }
    }

    static ByteBuf expandCumulation(ByteBufAllocator byteBufAllocator, ByteBuf byteBuf, int i4) {
        ByteBuf buffer = byteBufAllocator.buffer(byteBuf.readableBytes() + i4);
        buffer.writeBytes(byteBuf);
        byteBuf.release();
        return buffer;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void fireChannelRead(ChannelHandlerContext channelHandlerContext, List<Object> list, int i4) {
        if (list instanceof CodecOutputList) {
            fireChannelRead(channelHandlerContext, (CodecOutputList) list, i4);
            return;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            channelHandlerContext.fireChannelRead(list.get(i5));
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int actualReadableBytes() {
        return internalBuffer().readableBytes();
    }

    protected void callDecode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) {
        while (byteBuf.isReadable()) {
            try {
                int size = list.size();
                if (size > 0) {
                    fireChannelRead(channelHandlerContext, list, size);
                    list.clear();
                    if (channelHandlerContext.isRemoved()) {
                        return;
                    }
                    size = 0;
                }
                int readableBytes = byteBuf.readableBytes();
                decode(channelHandlerContext, byteBuf, list);
                if (channelHandlerContext.isRemoved()) {
                    return;
                }
                if (size == list.size()) {
                    if (readableBytes == byteBuf.readableBytes()) {
                        return;
                    }
                } else if (readableBytes != byteBuf.readableBytes()) {
                    if (isSingleDecode()) {
                        return;
                    }
                } else {
                    throw new DecoderException(StringUtil.simpleClassName(getClass()) + ".decode() did not read anything but decoded a message.");
                }
            } catch (DecoderException e4) {
                throw e4;
            } catch (Throwable th) {
                throw new DecoderException(th);
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        channelInputClosed(channelHandlerContext, true);
    }

    /* JADX WARN: Finally extract failed */
    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof ByteBuf) {
            CodecOutputList newInstance = CodecOutputList.newInstance();
            try {
                try {
                    ByteBuf byteBuf = (ByteBuf) obj;
                    boolean z3 = this.cumulation == null;
                    this.first = z3;
                    if (z3) {
                        this.cumulation = byteBuf;
                    } else {
                        this.cumulation = this.cumulator.cumulate(channelHandlerContext.alloc(), this.cumulation, byteBuf);
                    }
                    callDecode(channelHandlerContext, this.cumulation, newInstance);
                    ByteBuf byteBuf2 = this.cumulation;
                    if (byteBuf2 != null && !byteBuf2.isReadable()) {
                        this.numReads = 0;
                        this.cumulation.release();
                        this.cumulation = null;
                    } else {
                        int i4 = this.numReads + 1;
                        this.numReads = i4;
                        if (i4 >= this.discardAfterReads) {
                            this.numReads = 0;
                            discardSomeReadBytes();
                        }
                    }
                    int size = newInstance.size();
                    this.decodeWasNull = !newInstance.insertSinceRecycled();
                    fireChannelRead(channelHandlerContext, newInstance, size);
                    newInstance.recycle();
                    return;
                } catch (DecoderException e4) {
                    throw e4;
                } catch (Throwable th) {
                    throw new DecoderException(th);
                }
            } catch (Throwable th2) {
                ByteBuf byteBuf3 = this.cumulation;
                if (byteBuf3 != null && !byteBuf3.isReadable()) {
                    this.numReads = 0;
                    this.cumulation.release();
                    this.cumulation = null;
                } else {
                    int i5 = this.numReads + 1;
                    this.numReads = i5;
                    if (i5 >= this.discardAfterReads) {
                        this.numReads = 0;
                        discardSomeReadBytes();
                    }
                }
                int size2 = newInstance.size();
                this.decodeWasNull = true ^ newInstance.insertSinceRecycled();
                fireChannelRead(channelHandlerContext, newInstance, size2);
                newInstance.recycle();
                throw th2;
            }
        }
        channelHandlerContext.fireChannelRead(obj);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelReadComplete(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.numReads = 0;
        discardSomeReadBytes();
        if (this.decodeWasNull) {
            this.decodeWasNull = false;
            if (!channelHandlerContext.channel().config().isAutoRead()) {
                channelHandlerContext.read();
            }
        }
        channelHandlerContext.fireChannelReadComplete();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public abstract void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception;

    /* JADX INFO: Access modifiers changed from: protected */
    public void decodeLast(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
        if (byteBuf.isReadable()) {
            decode(channelHandlerContext, byteBuf, list);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void discardSomeReadBytes() {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf == null || this.first || byteBuf.refCnt() != 1) {
            return;
        }
        this.cumulation.discardSomeReadBytes();
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public final void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            this.cumulation = null;
            int readableBytes = byteBuf.readableBytes();
            if (readableBytes > 0) {
                ByteBuf readBytes = byteBuf.readBytes(readableBytes);
                byteBuf.release();
                channelHandlerContext.fireChannelRead((Object) readBytes);
            } else {
                byteBuf.release();
            }
            this.numReads = 0;
            channelHandlerContext.fireChannelReadComplete();
        }
        handlerRemoved0(channelHandlerContext);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void handlerRemoved0(ChannelHandlerContext channelHandlerContext) throws Exception {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ByteBuf internalBuffer() {
        ByteBuf byteBuf = this.cumulation;
        return byteBuf != null ? byteBuf : Unpooled.EMPTY_BUFFER;
    }

    public boolean isSingleDecode() {
        return this.singleDecode;
    }

    public void setCumulator(Cumulator cumulator) {
        if (cumulator != null) {
            this.cumulator = cumulator;
            return;
        }
        throw new NullPointerException("cumulator");
    }

    public void setDiscardAfterReads(int i4) {
        if (i4 > 0) {
            this.discardAfterReads = i4;
            return;
        }
        throw new IllegalArgumentException("discardAfterReads must be > 0");
    }

    public void setSingleDecode(boolean z3) {
        this.singleDecode = z3;
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void userEventTriggered(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        if (obj instanceof ChannelInputShutdownEvent) {
            channelInputClosed(channelHandlerContext, false);
        }
        super.userEventTriggered(channelHandlerContext, obj);
    }

    static void fireChannelRead(ChannelHandlerContext channelHandlerContext, CodecOutputList codecOutputList, int i4) {
        for (int i5 = 0; i5 < i4; i5++) {
            channelHandlerContext.fireChannelRead(codecOutputList.getUnsafe(i5));
        }
    }

    void channelInputClosed(ChannelHandlerContext channelHandlerContext, List<Object> list) throws Exception {
        ByteBuf byteBuf = this.cumulation;
        if (byteBuf != null) {
            callDecode(channelHandlerContext, byteBuf, list);
            decodeLast(channelHandlerContext, this.cumulation, list);
            return;
        }
        decodeLast(channelHandlerContext, Unpooled.EMPTY_BUFFER, list);
    }
}
