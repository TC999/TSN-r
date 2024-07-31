package io.netty.handler.codec.http.websocketx;

import io.netty.handler.codec.http.HttpHeaders;
import java.net.URI;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class WebSocketClientHandshakerFactory {
    private WebSocketClientHandshakerFactory() {
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders) {
        return newHandshaker(uri, webSocketVersion, str, z, httpHeaders, 65536);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i) {
        return newHandshaker(uri, webSocketVersion, str, z, httpHeaders, i, true, false);
    }

    public static WebSocketClientHandshaker newHandshaker(URI uri, WebSocketVersion webSocketVersion, String str, boolean z, HttpHeaders httpHeaders, int i, boolean z2, boolean z3) {
        WebSocketVersion webSocketVersion2 = WebSocketVersion.V13;
        if (webSocketVersion == webSocketVersion2) {
            return new WebSocketClientHandshaker13(uri, webSocketVersion2, str, z, httpHeaders, i, z2, z3);
        }
        WebSocketVersion webSocketVersion3 = WebSocketVersion.V08;
        if (webSocketVersion == webSocketVersion3) {
            return new WebSocketClientHandshaker08(uri, webSocketVersion3, str, z, httpHeaders, i, z2, z3);
        }
        WebSocketVersion webSocketVersion4 = WebSocketVersion.V07;
        if (webSocketVersion == webSocketVersion4) {
            return new WebSocketClientHandshaker07(uri, webSocketVersion4, str, z, httpHeaders, i, z2, z3);
        }
        WebSocketVersion webSocketVersion5 = WebSocketVersion.V00;
        if (webSocketVersion == webSocketVersion5) {
            return new WebSocketClientHandshaker00(uri, webSocketVersion5, str, httpHeaders, i);
        }
        throw new WebSocketHandshakeException("Protocol version " + webSocketVersion + " not supported.");
    }
}
