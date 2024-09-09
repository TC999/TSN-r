package io.netty.handler.codec.http.websocketx;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.ssl.SslHandler;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.FutureListener;
import io.netty.util.concurrent.GenericFutureListener;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
class WebSocketServerProtocolHandshakeHandler extends ChannelInboundHandlerAdapter {
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;
    private final int maxFramePayloadSize;
    private final String subprotocols;
    private final String websocketPath;

    /* renamed from: io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandshakeHandler$2  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ ChannelPromise val$localHandshakePromise;

        AnonymousClass2(ChannelPromise channelPromise) {
            this.val$localHandshakePromise = channelPromise;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.val$localHandshakePromise.isDone() || !this.val$localHandshakePromise.tryFailure(new WebSocketHandshakeException("handshake timed out"))) {
                return;
            }
            WebSocketServerProtocolHandshakeHandler.access$000(WebSocketServerProtocolHandshakeHandler.this).flush().fireUserEventTriggered((Object) WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_TIMEOUT).close();
        }
    }

    /* renamed from: io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandshakeHandler$3  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    class AnonymousClass3 implements FutureListener<Void> {
        final /* synthetic */ Future val$timeoutFuture;

        AnonymousClass3(Future future) {
            this.val$timeoutFuture = future;
        }

        @Override // io.netty.util.concurrent.GenericFutureListener
        public void operationComplete(Future<Void> future) throws Exception {
            this.val$timeoutFuture.cancel(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public WebSocketServerProtocolHandshakeHandler(String str, String str2, boolean z3, int i4, boolean z4) {
        this.websocketPath = str;
        this.subprotocols = str2;
        this.allowExtensions = z3;
        this.maxFramePayloadSize = i4;
        this.allowMaskMismatch = z4;
    }

    private static String getWebSocketLocation(ChannelPipeline channelPipeline, HttpRequest httpRequest, String str) {
        String str2 = channelPipeline.get(SslHandler.class) != null ? "wss" : "ws";
        return str2 + "://" + httpRequest.headers().get(HttpHeaderNames.HOST) + str;
    }

    private static void sendHttpResponse(ChannelHandlerContext channelHandlerContext, HttpRequest httpRequest, HttpResponse httpResponse) {
        ChannelFuture writeAndFlush = channelHandlerContext.channel().writeAndFlush(httpResponse);
        if (HttpUtil.isKeepAlive(httpRequest) && httpResponse.status().code() == 200) {
            return;
        }
        writeAndFlush.addListener((GenericFutureListener<? extends Future<? super Void>>) ChannelFutureListener.CLOSE);
    }

    @Override // io.netty.channel.ChannelInboundHandlerAdapter, io.netty.channel.ChannelInboundHandler
    public void channelRead(final ChannelHandlerContext channelHandlerContext, Object obj) throws Exception {
        FullHttpRequest fullHttpRequest = (FullHttpRequest) obj;
        if (!this.websocketPath.equals(fullHttpRequest.uri())) {
            channelHandlerContext.fireChannelRead(obj);
            return;
        }
        try {
            if (fullHttpRequest.method() != HttpMethod.GET) {
                sendHttpResponse(channelHandlerContext, fullHttpRequest, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.FORBIDDEN));
                return;
            }
            WebSocketServerHandshaker newHandshaker = new WebSocketServerHandshakerFactory(getWebSocketLocation(channelHandlerContext.pipeline(), fullHttpRequest, this.websocketPath), this.subprotocols, this.allowExtensions, this.maxFramePayloadSize, this.allowMaskMismatch).newHandshaker(fullHttpRequest);
            if (newHandshaker == null) {
                WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(channelHandlerContext.channel());
            } else {
                newHandshaker.handshake(channelHandlerContext.channel(), fullHttpRequest).addListener((GenericFutureListener<? extends Future<? super Void>>) new ChannelFutureListener() { // from class: io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandshakeHandler.1
                    @Override // io.netty.util.concurrent.GenericFutureListener
                    public void operationComplete(ChannelFuture channelFuture) throws Exception {
                        if (!channelFuture.isSuccess()) {
                            channelHandlerContext.fireExceptionCaught(channelFuture.cause());
                        } else {
                            channelHandlerContext.fireUserEventTriggered((Object) WebSocketServerProtocolHandler.ServerHandshakeStateEvent.HANDSHAKE_COMPLETE);
                        }
                    }
                });
                WebSocketServerProtocolHandler.setHandshaker(channelHandlerContext.channel(), newHandshaker);
                channelHandlerContext.pipeline().replace(this, "WS403Responder", WebSocketServerProtocolHandler.forbiddenHttpRequestResponder());
            }
        } finally {
            fullHttpRequest.release();
        }
    }
}
