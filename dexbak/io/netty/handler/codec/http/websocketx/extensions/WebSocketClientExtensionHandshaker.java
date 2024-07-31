package io.netty.handler.codec.http.websocketx.extensions;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public interface WebSocketClientExtensionHandshaker {
    WebSocketClientExtension handshakeExtension(WebSocketExtensionData webSocketExtensionData);

    WebSocketExtensionData newRequestData();
}
