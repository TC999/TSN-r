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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class PermessageDeflateExtension implements WebSocketServerExtension {
        private final boolean clientNoContext;
        private final int clientWindowSize;
        private final int compressionLevel;
        private final boolean serverNoContext;
        private final int serverWindowSize;

        public PermessageDeflateExtension(int i4, boolean z3, int i5, boolean z4, int i6) {
            this.compressionLevel = i4;
            this.serverNoContext = z3;
            this.serverWindowSize = i5;
            this.clientNoContext = z4;
            this.clientWindowSize = i6;
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
                hashMap.put("server_no_context_takeover", null);
            }
            if (this.clientNoContext) {
                hashMap.put("client_no_context_takeover", null);
            }
            int i4 = this.serverWindowSize;
            if (i4 != 15) {
                hashMap.put("server_max_window_bits", Integer.toString(i4));
            }
            int i5 = this.clientWindowSize;
            if (i5 != 15) {
                hashMap.put("client_max_window_bits", Integer.toString(i5));
            }
            return new WebSocketExtensionData("permessage-deflate", hashMap);
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
        if ("permessage-deflate".equals(webSocketExtensionData.name())) {
            Iterator<Map.Entry<String, String>> it = webSocketExtensionData.parameters().entrySet().iterator();
            boolean z3 = true;
            boolean z4 = false;
            int i4 = 15;
            boolean z5 = false;
            int i5 = 15;
            while (z3 && it.hasNext()) {
                Map.Entry<String, String> next = it.next();
                if ("client_max_window_bits".equalsIgnoreCase(next.getKey())) {
                    i5 = this.preferredClientWindowSize;
                } else if ("server_max_window_bits".equalsIgnoreCase(next.getKey())) {
                    if (this.allowServerWindowSize && (i4 = Integer.parseInt(next.getValue())) <= 15 && i4 >= 8) {
                    }
                    z3 = false;
                } else if ("client_no_context_takeover".equalsIgnoreCase(next.getKey())) {
                    z5 = this.preferredClientNoContext;
                } else {
                    if ("server_no_context_takeover".equalsIgnoreCase(next.getKey()) && this.allowServerNoContext) {
                        z4 = true;
                    }
                    z3 = false;
                }
            }
            if (z3) {
                return new PermessageDeflateExtension(this.compressionLevel, z4, i4, z5, i5);
            }
            return null;
        }
        return null;
    }

    public PerMessageDeflateServerExtensionHandshaker(int i4, boolean z3, int i5, boolean z4, boolean z5) {
        if (i5 > 15 || i5 < 8) {
            throw new IllegalArgumentException("preferredServerWindowSize: " + i5 + " (expected: 8-15)");
        } else if (i4 >= 0 && i4 <= 9) {
            this.compressionLevel = i4;
            this.allowServerWindowSize = z3;
            this.preferredClientWindowSize = i5;
            this.allowServerNoContext = z4;
            this.preferredClientNoContext = z5;
        } else {
            throw new IllegalArgumentException("compressionLevel: " + i4 + " (expected: 0-9)");
        }
    }
}
