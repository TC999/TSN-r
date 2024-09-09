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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class PerMessageDeflateClientExtensionHandshaker implements WebSocketClientExtensionHandshaker {
    private final boolean allowClientNoContext;
    private final boolean allowClientWindowSize;
    private final int compressionLevel;
    private final boolean requestedServerNoContext;
    private final int requestedServerWindowSize;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private final class PermessageDeflateExtension implements WebSocketClientExtension {
        private final boolean clientNoContext;
        private final int clientWindowSize;
        private final boolean serverNoContext;
        private final int serverWindowSize;

        public PermessageDeflateExtension(boolean z3, int i4, boolean z4, int i5) {
            this.serverNoContext = z3;
            this.serverWindowSize = i4;
            this.clientNoContext = z4;
            this.clientWindowSize = i5;
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
            boolean z3 = false;
            boolean z4 = true;
            boolean z5 = false;
            int i4 = 15;
            boolean z6 = false;
            int i5 = 15;
            while (z4 && it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if ("client_max_window_bits".equalsIgnoreCase(next.getKey())) {
                    if (this.allowClientWindowSize) {
                        i5 = Integer.parseInt(next.getValue());
                    } else {
                        z4 = false;
                    }
                } else if ("server_max_window_bits".equalsIgnoreCase(next.getKey())) {
                    i4 = Integer.parseInt(next.getValue());
                    if (i5 <= 15 && i5 >= 8) {
                    }
                    z4 = false;
                } else if ("client_no_context_takeover".equalsIgnoreCase(next.getKey())) {
                    if (this.allowClientNoContext) {
                        z6 = true;
                    } else {
                        z4 = false;
                    }
                } else {
                    if ("server_no_context_takeover".equalsIgnoreCase(next.getKey()) && this.requestedServerNoContext) {
                        z5 = true;
                    }
                    z4 = false;
                }
            }
            if ((!this.requestedServerNoContext || z5) && this.requestedServerWindowSize == i4) {
                z3 = z4;
            }
            if (z3) {
                return new PermessageDeflateExtension(z5, i4, z6, i5);
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
        int i4 = this.requestedServerWindowSize;
        if (i4 != 15) {
            hashMap.put("server_max_window_bits", Integer.toString(i4));
        }
        if (this.allowClientWindowSize) {
            hashMap.put("client_max_window_bits", null);
        }
        return new WebSocketExtensionData("permessage-deflate", hashMap);
    }

    public PerMessageDeflateClientExtensionHandshaker(int i4, boolean z3, int i5, boolean z4, boolean z5) {
        if (i5 > 15 || i5 < 8) {
            throw new IllegalArgumentException("requestedServerWindowSize: " + i5 + " (expected: 8-15)");
        } else if (i4 >= 0 && i4 <= 9) {
            this.compressionLevel = i4;
            this.allowClientWindowSize = z3;
            this.requestedServerWindowSize = i5;
            this.allowClientNoContext = z4;
            this.requestedServerNoContext = z5;
        } else {
            throw new IllegalArgumentException("compressionLevel: " + i4 + " (expected: 0-9)");
        }
    }
}
