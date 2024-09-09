package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelOutboundHandlerAdapter;
import io.netty.channel.ChannelPromise;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.internal.TypeParameterMatcher;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class MessageToByteEncoder<I> extends ChannelOutboundHandlerAdapter {
    private final TypeParameterMatcher matcher;
    private final boolean preferDirect;

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageToByteEncoder() {
        this(true);
    }

    public boolean acceptOutboundMessage(Object obj) throws Exception {
        return this.matcher.match(obj);
    }

    protected ByteBuf allocateBuffer(ChannelHandlerContext channelHandlerContext, I i4, boolean z3) throws Exception {
        if (z3) {
            return channelHandlerContext.alloc().ioBuffer();
        }
        return channelHandlerContext.alloc().heapBuffer();
    }

    protected abstract void encode(ChannelHandlerContext channelHandlerContext, I i4, ByteBuf byteBuf) throws Exception;

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.channel.ChannelOutboundHandlerAdapter, io.netty.channel.ChannelOutboundHandler
    public void write(ChannelHandlerContext channelHandlerContext, Object obj, ChannelPromise channelPromise) throws Exception {
        try {
            try {
                if (acceptOutboundMessage(obj)) {
                    ByteBuf allocateBuffer = allocateBuffer(channelHandlerContext, obj, this.preferDirect);
                    try {
                        encode(channelHandlerContext, obj, allocateBuffer);
                        ReferenceCountUtil.release(obj);
                        if (allocateBuffer.isReadable()) {
                            channelHandlerContext.write(allocateBuffer, channelPromise);
                            return;
                        }
                        allocateBuffer.release();
                        channelHandlerContext.write(Unpooled.EMPTY_BUFFER, channelPromise);
                        return;
                    } catch (Throwable th) {
                        ReferenceCountUtil.release(obj);
                        throw th;
                    }
                }
                channelHandlerContext.write(obj, channelPromise);
            } catch (EncoderException e4) {
                throw e4;
            }
        }
    }

    protected MessageToByteEncoder(Class<? extends I> cls) {
        this(cls, true);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageToByteEncoder(boolean z3) {
        this.matcher = TypeParameterMatcher.find(this, MessageToByteEncoder.class, "I");
        this.preferDirect = z3;
    }

    protected MessageToByteEncoder(Class<? extends I> cls, boolean z3) {
        this.matcher = TypeParameterMatcher.get(cls);
        this.preferDirect = z3;
    }
}
