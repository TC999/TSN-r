package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.DefaultFullHttpRequest;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.FullHttpResponse;
import io.netty.handler.codec.http.HttpHeaderNames;
import io.netty.handler.codec.http.HttpHeaderValues;
import io.netty.handler.codec.http.HttpHeaders;
import io.netty.handler.codec.http.HttpMethod;
import io.netty.handler.codec.http.HttpResponseStatus;
import io.netty.handler.codec.http.HttpVersion;
import io.netty.util.AsciiString;
import io.netty.util.CharsetUtil;
import io.netty.util.internal.logging.InternalLogger;
import io.netty.util.internal.logging.InternalLoggerFactory;
import java.net.URI;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WebSocketClientHandshaker08 extends WebSocketClientHandshaker {
    public static final String MAGIC_GUID = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(WebSocketClientHandshaker08.class);
    private final boolean allowExtensions;
    private final boolean allowMaskMismatch;
    private String expectedChallengeResponseString;
    private final boolean performMasking;

    public WebSocketClientHandshaker08(URI uri, WebSocketVersion webSocketVersion, String str, boolean z3, HttpHeaders httpHeaders, int i4) {
        this(uri, webSocketVersion, str, z3, httpHeaders, i4, true, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected FullHttpRequest newHandshakeRequest() {
        URI uri = uri();
        String rawPath = WebSocketClientHandshaker.rawPath(uri);
        String base64 = WebSocketUtil.base64(WebSocketUtil.randomBytes(16));
        this.expectedChallengeResponseString = WebSocketUtil.base64(WebSocketUtil.sha1((base64 + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").getBytes(CharsetUtil.US_ASCII)));
        InternalLogger internalLogger = logger;
        if (internalLogger.isDebugEnabled()) {
            internalLogger.debug("WebSocket version 08 client handshake key: {}, expected response: {}", base64, this.expectedChallengeResponseString);
        }
        int websocketPort = WebSocketClientHandshaker.websocketPort(uri);
        String host = uri.getHost();
        DefaultFullHttpRequest defaultFullHttpRequest = new DefaultFullHttpRequest(HttpVersion.HTTP_1_1, HttpMethod.GET, rawPath);
        HttpHeaders headers = defaultFullHttpRequest.headers();
        headers.add(HttpHeaderNames.UPGRADE, HttpHeaderValues.WEBSOCKET).add(HttpHeaderNames.CONNECTION, HttpHeaderValues.UPGRADE).add(HttpHeaderNames.SEC_WEBSOCKET_KEY, base64).add(HttpHeaderNames.HOST, host).add(HttpHeaderNames.SEC_WEBSOCKET_ORIGIN, WebSocketClientHandshaker.websocketOriginValue(host, websocketPort));
        String expectedSubprotocol = expectedSubprotocol();
        if (expectedSubprotocol != null && !expectedSubprotocol.isEmpty()) {
            headers.add(HttpHeaderNames.SEC_WEBSOCKET_PROTOCOL, expectedSubprotocol);
        }
        headers.add(HttpHeaderNames.SEC_WEBSOCKET_VERSION, "8");
        HttpHeaders httpHeaders = this.customHeaders;
        if (httpHeaders != null) {
            headers.add(httpHeaders);
        }
        return defaultFullHttpRequest;
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected WebSocketFrameEncoder newWebSocketEncoder() {
        return new WebSocket08FrameEncoder(this.performMasking);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected WebSocketFrameDecoder newWebsocketDecoder() {
        return new WebSocket08FrameDecoder(false, this.allowExtensions, maxFramePayloadLength(), this.allowMaskMismatch);
    }

    @Override // io.netty.handler.codec.http.websocketx.WebSocketClientHandshaker
    protected void verify(FullHttpResponse fullHttpResponse) {
        HttpResponseStatus httpResponseStatus = HttpResponseStatus.SWITCHING_PROTOCOLS;
        HttpHeaders headers = fullHttpResponse.headers();
        if (fullHttpResponse.status().equals(httpResponseStatus)) {
            String str = headers.get(HttpHeaderNames.UPGRADE);
            if (HttpHeaderValues.WEBSOCKET.contentEqualsIgnoreCase(str)) {
                AsciiString asciiString = HttpHeaderNames.CONNECTION;
                if (headers.containsValue(asciiString, HttpHeaderValues.UPGRADE, true)) {
                    String str2 = headers.get(HttpHeaderNames.SEC_WEBSOCKET_ACCEPT);
                    if (str2 == null || !str2.equals(this.expectedChallengeResponseString)) {
                        throw new WebSocketHandshakeException(String.format("Invalid challenge. Actual: %s. Expected: %s", str2, this.expectedChallengeResponseString));
                    }
                    return;
                }
                throw new WebSocketHandshakeException("Invalid handshake response connection: " + headers.get(asciiString));
            }
            throw new WebSocketHandshakeException("Invalid handshake response upgrade: " + ((Object) str));
        }
        throw new WebSocketHandshakeException("Invalid handshake response getStatus: " + fullHttpResponse.status());
    }

    public WebSocketClientHandshaker08(URI uri, WebSocketVersion webSocketVersion, String str, boolean z3, HttpHeaders httpHeaders, int i4, boolean z4, boolean z5) {
        super(uri, webSocketVersion, str, httpHeaders, i4);
        this.allowExtensions = z3;
        this.performMasking = z4;
        this.allowMaskMismatch = z5;
    }
}
