package com.bytedance.adsdk.w.w.sr;

import java.util.HashMap;
import java.util.Map;
import p0.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum c implements a {
    TRUE,
    FALSE,
    NULL;
    
    private static final Map<String, c> sr = new HashMap(128);

    static {
        c[] values;
        for (c cVar : values()) {
            sr.put(cVar.name().toLowerCase(), cVar);
        }
    }

    public static c c(String str) {
        return sr.get(str.toLowerCase());
    }
}
