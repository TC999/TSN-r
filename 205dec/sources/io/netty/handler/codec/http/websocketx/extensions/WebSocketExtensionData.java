package io.netty.handler.codec.http.websocketx.extensions;

import java.util.Collections;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class WebSocketExtensionData {
    private final String name;
    private final Map<String, String> parameters;

    public WebSocketExtensionData(String str, Map<String, String> map) {
        if (str == null) {
            throw new NullPointerException("name");
        }
        if (map != null) {
            this.name = str;
            this.parameters = Collections.unmodifiableMap(map);
            return;
        }
        throw new NullPointerException("parameters");
    }

    public String name() {
        return this.name;
    }

    public Map<String, String> parameters() {
        return this.parameters;
    }
}
