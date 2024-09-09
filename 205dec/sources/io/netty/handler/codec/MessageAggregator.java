package io.netty.handler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufHolder;
import io.netty.buffer.CompositeByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelPipeline;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class MessageAggregator<I, S, C extends ByteBufHolder, O extends ByteBufHolder> extends MessageToMessageDecoder<I> {
    private static final int DEFAULT_MAX_COMPOSITEBUFFER_COMPONENTS = 1024;
    private ChannelFutureListener continueResponseWriteListener;
    private ChannelHandlerContext ctx;
    private O currentMessage;
    private boolean handlingOversizedMessage;
    private final int maxContentLength;
    private int maxCumulationBufferComponents;

    /* JADX INFO: Access modifiers changed from: protected */
    public MessageAggregator(int i4) {
        this.maxCumulationBufferComponents = 1024;
        validateMaxContentLength(i4);
        this.maxContentLength = i4;
    }

    private static void appendPartialContent(CompositeByteBuf compositeByteBuf, ByteBuf byteBuf) {
        if (byteBuf.isReadable()) {
            byteBuf.retain();
            compositeByteBuf.addComponent(true, byteBuf);
        }
    }

    private void invokeHandleOversizedMessage(ChannelHandlerContext channelHandlerContext, S s3) throws Exception {
        this.handlingOversizedMessage = true;
        this.currentMessage = null;
        try {
            handleOversizedMessage(channelHandlerContext, s3);
        } finally {
            ReferenceCountUtil.release(s3);
        }
    }

    private static void validateMaxContentLength(int i4) {
        if (i4 >= 0) {
            return;
        }
        throw new IllegalArgumentException("maxContentLength: " + i4 + " (expected: >= 0)");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public boolean acceptInboundMessage(Object obj) throws Exception {
        if (super.acceptInboundMessage(obj)) {
            return (isContentMessage(obj) || isStartMessage(obj)) && !isAggregated(obj);
        }
        return false;
    }

    protected void aggregate(O o4, C c4) throws Exception {
    }

    protected abstract O beginAggregation(S s3, ByteBuf byteBuf) throws Exception;

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelInactive(ChannelHandlerContext channelHandlerContext) throws Exception {
        O o4 = this.currentMessage;
        if (o4 != null) {
            o4.release();
            this.currentMessage = null;
        }
        super.channelInactive(channelHandlerContext);
    }

    protected abstract boolean closeAfterContinueResponse(Object obj) throws Exception;

    protected final ChannelHandlerContext ctx() {
        ChannelHandlerContext channelHandlerContext = this.ctx;
        if (channelHandlerContext != null) {
            return channelHandlerContext;
        }
        throw new IllegalStateException("not added to a pipeline yet");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // io.netty.handler.codec.MessageToMessageDecoder
    public void decode(final ChannelHandlerContext channelHandlerContext, I i4, List<Object> list) throws Exception {
        ByteBufHolder beginAggregation;
        O o4 = this.currentMessage;
        if (isStartMessage(i4)) {
            this.handlingOversizedMessage = false;
            if (o4 == null) {
                Object newContinueResponse = newContinueResponse(i4, this.maxContentLength, channelHandlerContext.pipeline());
                if (newContinueResponse != null) {
                    ChannelFutureListener channelFutureListener = this.continueResponseWriteListener;
                    if (channelFutureListener == null) {
                        channelFutureListener = new ChannelFutureListener() { // from class: io.netty.handler.codec.MessageAggregator.1
                            @Override // io.netty.util.concurrent.GenericFutureListener
                            public void operationComplete(ChannelFuture channelFuture) throws Exception {
                                if (channelFuture.isSuccess()) {
                                    return;
                                }
                                channelHandlerContext.fireExceptionCaught(channelFuture.cause());
                            }
                        };
                        this.continueResponseWriteListener = channelFutureListener;
                    }
                    boolean closeAfterContinueResponse = closeAfterContinueResponse(newContinueResponse);
                    this.handlingOversizedMessage = ignoreContentAfterContinueResponse(newContinueResponse);
                    Future<Void> addListener = channelHandlerContext.writeAndFlush(newContinueResponse).addListener((GenericFutureListener<? extends Future<? super Void>>) channelFutureListener);
                    if (closeAfterContinueResponse) {
                        addListener.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
                        return;
                    } else if (this.handlingOversizedMessage) {
                        return;
                    }
                } else if (isContentLengthInvalid(i4, this.maxContentLength)) {
                    invokeHandleOversizedMessage(channelHandlerContext, i4);
                    return;
                }
                if ((i4 instanceof DecoderResultProvider) && !((DecoderResultProvider) i4).decoderResult().isSuccess()) {
                    if (i4 instanceof ByteBufHolder) {
                        ByteBufHolder byteBufHolder = (ByteBufHolder) i4;
                        if (byteBufHolder.content().isReadable()) {
                            beginAggregation = beginAggregation(i4, byteBufHolder.content().retain());
                            finishAggregation(beginAggregation);
                            list.add(beginAggregation);
                            this.currentMessage = null;
                            return;
                        }
                    }
                    beginAggregation = beginAggregation(i4, Unpooled.EMPTY_BUFFER);
                    finishAggregation(beginAggregation);
                    list.add(beginAggregation);
                    this.currentMessage = null;
                    return;
                }
                CompositeByteBuf compositeBuffer = channelHandlerContext.alloc().compositeBuffer(this.maxCumulationBufferComponents);
                if (i4 instanceof ByteBufHolder) {
                    appendPartialContent(compositeBuffer, ((ByteBufHolder) i4).content());
                }
                this.currentMessage = (O) beginAggregation(i4, compositeBuffer);
                return;
            }
            throw new MessageAggregationException();
        } else if (isContentMessage(i4)) {
            ByteBufHolder byteBufHolder2 = (ByteBufHolder) i4;
            ByteBuf content = byteBufHolder2.content();
            boolean isLastContentMessage = isLastContentMessage(byteBufHolder2);
            if (this.handlingOversizedMessage) {
                if (isLastContentMessage) {
                    this.currentMessage = null;
                }
            } else if (o4 != null) {
                CompositeByteBuf compositeByteBuf = (CompositeByteBuf) o4.content();
                if (compositeByteBuf.readableBytes() > this.maxContentLength - content.readableBytes()) {
                    invokeHandleOversizedMessage(channelHandlerContext, o4);
                    return;
                }
                appendPartialContent(compositeByteBuf, content);
                aggregate(o4, byteBufHolder2);
                if (byteBufHolder2 instanceof DecoderResultProvider) {
                    DecoderResult decoderResult = ((DecoderResultProvider) byteBufHolder2).decoderResult();
                    if (!decoderResult.isSuccess()) {
                        if (o4 instanceof DecoderResultProvider) {
                            ((DecoderResultProvider) o4).setDecoderResult(DecoderResult.failure(decoderResult.cause()));
                        }
                        isLastContentMessage = true;
                    }
                }
                if (isLastContentMessage) {
                    finishAggregation(o4);
                    list.add(o4);
                    this.currentMessage = null;
                }
            } else {
                throw new MessageAggregationException();
            }
        } else {
            throw new MessageAggregationException();
        }
    }

    protected void finishAggregation(O o4) throws Exception {
    }

    protected void handleOversizedMessage(ChannelHandlerContext channelHandlerContext, S s3) throws Exception {
        channelHandlerContext.fireExceptionCaught((Throwable) new TooLongFrameException("content length exceeded " + maxContentLength() + " bytes."));
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerAdded(ChannelHandlerContext channelHandlerContext) throws Exception {
        this.ctx = channelHandlerContext;
    }

    @Override // io.netty.channel.ChannelHandlerAdapter, io.netty.channel.ChannelHandler
    public void handlerRemoved(ChannelHandlerContext channelHandlerContext) throws Exception {
        super.handlerRemoved(channelHandlerContext);
        O o4 = this.currentMessage;
        if (o4 != null) {
            o4.release();
            this.currentMessage = null;
        }
    }

    protected abstract boolean ignoreContentAfterContinueResponse(Object obj) throws Exception;

    protected abstract boolean isAggregated(I i4) throws Exception;

    protected abstract boolean isContentLengthInvalid(S s3, int i4) throws Exception;

    protected abstract boolean isContentMessage(I i4) throws Exception;

    public final boolean isHandlingOversizedMessage() {
        return this.handlingOversizedMessage;
    }

    protected abstract boolean isLastContentMessage(C c4) throws Exception;

    protected abstract boolean isStartMessage(I i4) throws Exception;

    public final int maxContentLength() {
        return this.maxContentLength;
    }

    public final int maxCumulationBufferComponents() {
        return this.maxCumulationBufferComponents;
    }

    protected abstract Object newContinueResponse(S s3, int i4, ChannelPipeline channelPipeline) throws Exception;

    public final void setMaxCumulationBufferComponents(int i4) {
        if (i4 >= 2) {
            if (this.ctx == null) {
                this.maxCumulationBufferComponents = i4;
                return;
            }
            throw new IllegalStateException("decoder properties cannot be changed once the decoder is added to a pipeline.");
        }
        throw new IllegalArgumentException("maxCumulationBufferComponents: " + i4 + " (expected: >= 2)");
    }

    protected MessageAggregator(int i4, Class<? extends I> cls) {
        super(cls);
        this.maxCumulationBufferComponents = 1024;
        validateMaxContentLength(i4);
        this.maxContentLength = i4;
    }
}
