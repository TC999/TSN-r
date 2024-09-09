package com.bytedance.sdk.openadsdk.core.eq;

import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class y<K, V> extends HashMap<K, V> {
    /* JADX WARN: Multi-variable type inference failed */
    public y<String, Object> c(K k4, V v3) {
        put(k4, v3);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public y<String, Object> c(Map<? extends K, ? extends V> map) {
        putAll(map);
        return this;
    }
}
