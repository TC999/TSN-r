package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker;
import java.util.Collections;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class DeflateFrameServerExtensionHandshaker implements WebSocketServerExtensionHandshaker {
    static final String DEFLATE_FRAME_EXTENSION = "deflate-frame";
    static final String X_WEBKIT_DEFLATE_FRAME_EXTENSION = "x-webkit-deflate-frame";
    private final int compressionLevel;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class DeflateFrameServerExtension implements WebSocketServerExtension {
        private final int compressionLevel;
        private final String extensionName;

        public DeflateFrameServerExtension(int i, String str) {
            this.extensionName = str;
            this.compressionLevel = i;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionDecoder newExtensionDecoder() {
            return new PerFrameDeflateDecoder(false);
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionEncoder newExtensionEncoder() {
            return new PerFrameDeflateEncoder(this.compressionLevel, 15, false);
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension
        public WebSocketExtensionData newReponseData() {
            return new WebSocketExtensionData(this.extensionName, Collections.emptyMap());
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public int rsv() {
            return 4;
        }
    }

    public DeflateFrameServerExtensionHandshaker() {
        this(6);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker
    public WebSocketServerExtension handshakeExtension(WebSocketExtensionData webSocketExtensionData) {
        if ((X_WEBKIT_DEFLATE_FRAME_EXTENSION.equals(webSocketExtensionData.name()) || DEFLATE_FRAME_EXTENSION.equals(webSocketExtensionData.name())) && webSocketExtensionData.parameters().isEmpty()) {
            return new DeflateFrameServerExtension(this.compressionLevel, webSocketExtensionData.name());
        }
        return null;
    }

    public DeflateFrameServerExtensionHandshaker(int i) {
        if (i >= 0 && i <= 9) {
            this.compressionLevel = i;
            return;
        }
        throw new IllegalArgumentException("compressionLevel: " + i + " (expected: 0-9)");
    }
}
