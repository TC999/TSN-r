package io.netty.handler.codec.http.websocketx.extensions.compression;

import io.netty.handler.codec.compression.ZlibCodecFactory;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtension;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionData;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionDecoder;
import io.netty.handler.codec.http.websocketx.extensions.WebSocketExtensionEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class PerMessageDeflateClientExtensionHandshaker implements WebSocketClientExtensionHandshaker {
    private final boolean allowClientNoContext;
    private final boolean allowClientWindowSize;
    private final int compressionLevel;
    private final boolean requestedServerNoContext;
    private final int requestedServerWindowSize;

    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private final class PermessageDeflateExtension implements WebSocketClientExtension {
        private final boolean clientNoContext;
        private final int clientWindowSize;
        private final boolean serverNoContext;
        private final int serverWindowSize;

        public PermessageDeflateExtension(boolean z, int i, boolean z2, int i2) {
            this.serverNoContext = z;
            this.serverWindowSize = i;
            this.clientNoContext = z2;
            this.clientWindowSize = i2;
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionDecoder newExtensionDecoder() {
            return new PerMessageDeflateDecoder(this.clientNoContext);
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public WebSocketExtensionEncoder newExtensionEncoder() {
            return new PerMessageDeflateEncoder(PerMessageDeflateClientExtensionHandshaker.this.compressionLevel, this.serverWindowSize, this.serverNoContext);
        }

        @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketExtension
        public int rsv() {
            return 4;
        }
    }

    public PerMessageDeflateClientExtensionHandshaker() {
        this(6, ZlibCodecFactory.isSupportingWindowSizeAndMemLevel(), 15, false, false);
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker
    public WebSocketClientExtension handshakeExtension(WebSocketExtensionData webSocketExtensionData) {
        if ("permessage-deflate".equals(webSocketExtensionData.name())) {
            Iterator<Map.Entry<String, String>> it = webSocketExtensionData.parameters().entrySet().iterator();
            boolean z = false;
            boolean z2 = true;
            boolean z3 = false;
            int i = 15;
            boolean z4 = false;
            int i2 = 15;
            while (z2 && it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if ("client_max_window_bits".equalsIgnoreCase(next.getKey())) {
                    if (this.allowClientWindowSize) {
                        i2 = Integer.parseInt(next.getValue());
                    } else {
                        z2 = false;
                    }
                } else if ("server_max_window_bits".equalsIgnoreCase(next.getKey())) {
                    i = Integer.parseInt(next.getValue());
                    if (i2 <= 15 && i2 >= 8) {
                    }
                    z2 = false;
                } else if ("client_no_context_takeover".equalsIgnoreCase(next.getKey())) {
                    if (this.allowClientNoContext) {
                        z4 = true;
                    } else {
                        z2 = false;
                    }
                } else {
                    if ("server_no_context_takeover".equalsIgnoreCase(next.getKey()) && this.requestedServerNoContext) {
                        z3 = true;
                    }
                    z2 = false;
                }
            }
            if ((!this.requestedServerNoContext || z3) && this.requestedServerWindowSize == i) {
                z = z2;
            }
            if (z) {
                return new PermessageDeflateExtension(z3, i, z4, i2);
            }
            return null;
        }
        return null;
    }

    @Override // io.netty.handler.codec.http.websocketx.extensions.WebSocketClientExtensionHandshaker
    public WebSocketExtensionData newRequestData() {
        HashMap hashMap = new HashMap(4);
        if (this.requestedServerWindowSize != 15) {
            hashMap.put("server_no_context_takeover", null);
        }
        if (this.allowClientNoContext) {
            hashMap.put("client_no_context_takeover", null);
        }
        int i = this.requestedServerWindowSize;
        if (i != 15) {
            hashMap.put("server_max_window_bits", Integer.toString(i));
        }
        if (this.allowClientWindowSize) {
            hashMap.put("client_max_window_bits", null);
        }
        return new WebSocketExtensionData("permessage-deflate", hashMap);
    }

    public PerMessageDeflateClientExtensionHandshaker(int i, boolean z, int i2, boolean z2, boolean z3) {
        if (i2 > 15 || i2 < 8) {
            throw new IllegalArgumentException("requestedServerWindowSize: " + i2 + " (expected: 8-15)");
        } else if (i >= 0 && i <= 9) {
            this.compressionLevel = i;
            this.allowClientWindowSize = z;
            this.requestedServerWindowSize = i2;
            this.allowClientNoContext = z2;
            this.requestedServerNoContext = z3;
        } else {
            throw new IllegalArgumentException("compressionLevel: " + i + " (expected: 0-9)");
        }
    }
}
