package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultFullHttpResponse;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WebSocketServerHandshaker07 extends WebSocketServerHandshaker {
    public static final String WEBSOCKET_07_ACCEPT_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;

    public WebSocketServerHandshaker07(String str, String str2, boolean z3, int i4) {
        this(str, str2, z3, i4, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected FullHttpResponse newHandshakeResponse(FullHttpRequest fullHttpRequest, HttpHeaders httpHeaders) {
        DefaultFullHttpResponse defaultFullHttpResponse = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.SWITCHING_PROTOCOLS);
        if (httpHeaders != null) {
            defaultFullHttpResponse.headers().add(httpHeaders);
        }
        String str = fullHttpRequest.headers().get(HttpHeaderNames.SEC_WEBSOCKET_KEY);
        if (str != null) {
            String base64 = WebSocketUtil.base64(WebSocketUtil.sha1((((Object) str) + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes(CharsetUtil.US_ASCII)));
            InternalLogger internalLogger = WebSocketServerHandshaker.logger;
            if (internalLogger.isDebugEnabled()) {
                internalLogger.debug("WebSocket version 07 server handshake key: {}, response: {}.", str, base64);
            }
            defaultFullHttpResponse.headers().add(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET);
            defaultFullHttpResponse.headers().add(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE);
            defaultFullHttpResponse.headers().add(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT, base64);
            HttpHeaders headers = fullHttpRequest.headers();
            AsciiString asciiString = HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL;
            String str2 = headers.get(asciiString);
            if (str2 != null) {
                String selectSubprotocol = selectSubprotocol(str2);
                if (selectSubprotocol == null) {
                    if (internalLogger.isDebugEnabled()) {
                        internalLogger.debug("Requested subprotocol(s) not supported: {}", str2);
                    }
                } else {
                    defaultFullHttpResponse.headers().add(asciiString, selectSubprotocol);
                }
            }
            return defaultFullHttpResponse;
        }
        throw new WebSocketHandshakeException("not a WebSocket request: missing key");
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket07FrameEncoder(false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker
    protected WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket07FrameDecoder(true, this.allowExtensions, maxFramePayloadLength(), this.allowMaskMismatch);
    }

    public WebSocketServerHandshaker07(String str, String str2, boolean z3, int i4, boolean z4) {
        super(WebSocketVersion.V07, str, str2, i4);
        this.allowExtensions = z3;
        this.allowMaskMismatch = z4;
    }
}
