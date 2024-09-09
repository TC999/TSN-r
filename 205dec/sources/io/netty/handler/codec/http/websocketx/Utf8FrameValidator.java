package io.netty.handler.codec.http.websocketx;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.CorruptedFrameException;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class Utf8FrameValidator extends ChannelInboundHandlerAdapter {
    private int fragmentedFramesCount;
    private Utf8Validator utf8Validator;

    private void checkUTF8String(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf) {
        try {
            if (this.utf8Validator == null) {
                this.utf8Validator = new Utf8Validator();
            }
            this.utf8Validator.check(byteBuf);
        } catch (CorruptedFrameException unused) {
            if (channelHandlerContext.channel().isActive()) {
                channelHandlerContext.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
            }
        }
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        Utf8Validator utf8Validator;
        if (obj instanceof WebSocketFrame) {
            WebSocketFrame webSocketFrame = (WebSocketFrame) obj;
            if (webSocketFrame.isFinalFragment()) {
                if (!(webSocketFrame instanceof PingWebSocketFrame)) {
                    this.fragmentedFramesCount = 0;
                    if ((webSocketFrame instanceof TextWebSocketFrame) || ((utf8Validator = this.utf8Validator) != null && utf8Validator.isChecking())) {
                        checkUTF8String(channelHandlerContext, webSocketFrame.content());
                        this.utf8Validator.finish();
                    }
                }
            } else {
                if (this.fragmentedFramesCount == 0) {
                    if (webSocketFrame instanceof TextWebSocketFrame) {
                        checkUTF8String(channelHandlerContext, webSocketFrame.content());
                    }
                } else {
                    Utf8Validator utf8Validator2 = this.utf8Validator;
                    if (utf8Validator2 != null && utf8Validator2.isChecking()) {
                        checkUTF8String(channelHandlerContext, webSocketFrame.content());
                    }
                }
                this.fragmentedFramesCount++;
            }
        }
        super.channelRead(channelHandlerContext, obj);
    }
}
