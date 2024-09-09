package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.HttpHeaders;
import java.net.URI;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class WebSocketClientHandshakerFactory {
    private WebSocketClientHandshakerFactory() {
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z3, HttpHeaders httpHeaders) {
        return newHandshaker(uri, webSocketVersion, str, z3, httpHeaders, 65536);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z3, HttpHeaders httpHeaders, int i4) {
        return newHandshaker(uri, webSocketVersion, str, z3, httpHeaders, i4, true, false);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z3, HttpHeaders httpHeaders, int i4, boolean z4, boolean z5) {
        WebSocketVersion webSocketVersion2 = WebSocketVersion.V13;
        if (webSocketVersion == webSocketVersion2) {
            return new WebSocketClientHandshaker13(uri, webSocketVersion2, str, z3, httpHeaders, i4, z4, z5);
        }
        WebSocketVersion webSocketVersion3 = WebSocketVersion.V08;
        if (webSocketVersion == webSocketVersion3) {
            return new WebSocketClientHandshaker08(uri, webSocketVersion3, str, z3, httpHeaders, i4, z4, z5);
        }
        WebSocketVersion webSocketVersion4 = WebSocketVersion.V07;
        if (webSocketVersion == webSocketVersion4) {
            return new WebSocketClientHandshaker07(uri, webSocketVersion4, str, z3, httpHeaders, i4, z4, z5);
        }
        WebSocketVersion webSocketVersion5 = WebSocketVersion.V00;
        if (webSocketVersion == webSocketVersion5) {
            return new WebSocketClientHandshaker00(uri, webSocketVersion5, str, httpHeaders, i4);
        }
        throw new WebSocketHandshakeException("Protocol version " + webSocketVersion + " not supported.");
    }
}
