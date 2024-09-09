package com.bytedance.sdk.gromore.c.w;

import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w {
    public static Map<String, Object> c(Map<String, Object> map, Map<String, Object> map2) {
        if (map != null) {
            if (map2 != null) {
                map.putAll(map2);
            }
            return map;
        }
        return map2;
    }
}
