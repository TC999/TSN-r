package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class PerMessageDeflateServerExtensionHandshaker implements WebSocketServerExtensionHandshaker {
    static final String CLIENT_MAX_WINDOW = "client_max_window_bits";
    static final String CLIENT_NO_CONTEXT = "client_no_context_takeover";
    public static final int MAX_WINDOW_SIZE = 15;
    public static final int MIN_WINDOW_SIZE = 8;
    static final String PERMESSAGE_DEFLATE_EXTENSION = "permessage-deflate";
    static final String SERVER_MAX_WINDOW = "server_max_window_bits";
    static final String SERVER_NO_CONTEXT = "server_no_context_takeover";
    private final boolean allowServerNoContext;
    private final boolean allowServerWindowSize;
    private final int compressionLevel;
    private final boolean preferredClientNoContext;
    private final int preferredClientWindowSize;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class PermessageDeflateExtension implements WebSocketServerExtension {
        private final boolean clientNoContext;
        private final int clientWindowSize;
        private final int compressionLevel;
        private final boolean serverNoContext;
        private final int serverWindowSize;

        public PermessageDeflateExtension(int i, boolean z, int i2, boolean z2, int i3) {
            this.compressionLevel = i;
            this.serverNoContext = z;
            this.serverWindowSize = i2;
            this.clientNoContext = z2;
            this.clientWindowSize = i3;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionDecoder newExtensionDecoder() {
            return new PerMessageDeflateDecoder(this.serverNoContext);
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionEncoder newExtensionEncoder() {
            return new PerMessageDeflateEncoder(this.compressionLevel, this.clientWindowSize, this.clientNoContext);
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtension
        public WebSocketExtensionData newReponseData() {
            HashMap hashMap = new HashMap(4);
            if (this.serverNoContext) {
                hashMap.put(PerMessageDeflateServerExtensionHandshaker.SERVER_NO_CONTEXT, null);
            }
            if (this.clientNoContext) {
                hashMap.put(PerMessageDeflateServerExtensionHandshaker.CLIENT_NO_CONTEXT, null);
            }
            int i = this.serverWindowSize;
            if (i != 15) {
                hashMap.put(PerMessageDeflateServerExtensionHandshaker.SERVER_MAX_WINDOW, Integer.toString(i));
            }
            int i2 = this.clientWindowSize;
            if (i2 != 15) {
                hashMap.put(PerMessageDeflateServerExtensionHandshaker.CLIENT_MAX_WINDOW, Integer.toString(i2));
            }
            return new WebSocketExtensionData(PerMessageDeflateServerExtensionHandshaker.PERMESSAGE_DEFLATE_EXTENSION, hashMap);
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public int rsv() {
            return 4;
        }
    }

    public PerMessageDeflateServerExtensionHandshaker() {
        this(6, ZlibCodecFactory.isSupportingWindowSizeAndMemLevel(), 15, false, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketServerExtensionHandshaker
    public WebSocketServerExtension handshakeExtension(WebSocketExtensionData webSocketExtensionData) {
        if (PERMESSAGE_DEFLATE_EXTENSION.equals(webSocketExtensionData.name())) {
            Iterator<Map.Entry<String, String>> it = webSocketExtensionData.parameters().entrySet().iterator();
            boolean z = true;
            boolean z2 = false;
            int i = 15;
            boolean z3 = false;
            int i2 = 15;
            while (z && it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if (CLIENT_MAX_WINDOW.equalsIgnoreCase(next.getKey())) {
                    i2 = this.preferredClientWindowSize;
                } else if (SERVER_MAX_WINDOW.equalsIgnoreCase(next.getKey())) {
                    if (this.allowServerWindowSize && (i = Integer.parseInt(next.getValue())) <= 15 && i >= 8) {
                    }
                    z = false;
                } else if (CLIENT_NO_CONTEXT.equalsIgnoreCase(next.getKey())) {
                    z3 = this.preferredClientNoContext;
                } else {
                    if (SERVER_NO_CONTEXT.equalsIgnoreCase(next.getKey()) && this.allowServerNoContext) {
                        z2 = true;
                    }
                    z = false;
                }
            }
            if (z) {
                return new PermessageDeflateExtension(this.compressionLevel, z2, i, z3, i2);
            }
            return null;
        }
        return null;
    }

    public PerMessageDeflateServerExtensionHandshaker(int i, boolean z, int i2, boolean z2, boolean z3) {
        if (i2 > 15 || i2 < 8) {
            throw new IllegalArgumentException("preferredServerWindowSize: " + i2 + " (expected: 8-15)");
        } else if (i >= 0 && i <= 9) {
            this.compressionLevel = i;
            this.allowServerWindowSize = z;
            this.preferredClientWindowSize = i2;
            this.allowServerNoContext = z2;
            this.preferredClientNoContext = z3;
        } else {
            throw new IllegalArgumentException("compressionLevel: " + i + " (expected: 0-9)");
        }
    }
}
