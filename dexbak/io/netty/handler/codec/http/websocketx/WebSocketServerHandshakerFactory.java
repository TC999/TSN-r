package io.netty.handler.codec.http.websocketx;

import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelPromise;
import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpUtil;
import io.netty.handler.codec.http.HttpVersion;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WebSocketServerHandshakerFactory {
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;
    private final int maxFramePayloadLength;
    private final String subprotocols;
    private final String webSocketURL;

    public WebSocketServerHandshakerFactory(String str, String str2, boolean z) {
        this(str, str2, z, 65536);
    }

    public static ChannelFuture sendUnsupportedVersionResponse(Channel channel) {
        return sendUnsupportedVersionResponse(channel, channel.newPromise());
    }

    @Deprecated
    public static void sendUnsupportedWebSocketVersionResponse(Channel channel) {
        sendUnsupportedVersionResponse(channel);
    }

    public WebSocketServerHandshaker newHandshaker(HttpRequest httpRequest) {
        String str = httpRequest.headers().get(HttpHeaderNames.SEC_WEBSOCKET_VERSION);
        if (str != null) {
            if (str.equals(WebSocketVersion.V13.toHttpHeaderValue())) {
                return new WebSocketServerHandshaker13(this.webSocketURL, this.subprotocols, this.allowExtensions, this.maxFramePayloadLength, this.allowMaskMismatch);
            }
            if (str.equals(WebSocketVersion.V08.toHttpHeaderValue())) {
                return new WebSocketServerHandshaker08(this.webSocketURL, this.subprotocols, this.allowExtensions, this.maxFramePayloadLength, this.allowMaskMismatch);
            }
            if (str.equals(WebSocketVersion.V07.toHttpHeaderValue())) {
                return new WebSocketServerHandshaker07(this.webSocketURL, this.subprotocols, this.allowExtensions, this.maxFramePayloadLength, this.allowMaskMismatch);
            }
            return null;
        }
        return new WebSocketServerHandshaker00(this.webSocketURL, this.subprotocols, this.maxFramePayloadLength);
    }

    public WebSocketServerHandshakerFactory(String str, String str2, boolean z, int i) {
        this(str, str2, z, i, false);
    }

    public static ChannelFuture sendUnsupportedVersionResponse(Channel channel, ChannelPromise channelPromise) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.UPGRADE_REQUIRED);
        defaultFullHttpResponse.headers().set(HttpHeaderNames.SEC_WEBSOCKET_VERSION, WebSocketVersion.V13.toHttpHeaderValue());
        HttpUtil.setContentLength(defaultFullHttpResponse, 0L);
        return channel.writeAndFlush(defaultFullHttpResponse, channelPromise);
    }

    public WebSocketServerHandshakerFactory(String str, String str2, boolean z, int i, boolean z2) {
        this.webSocketURL = str;
        this.subprotocols = str2;
        this.allowExtensions = z;
        this.maxFramePayloadLength = i;
        this.allowMaskMismatch = z2;
    }
}
