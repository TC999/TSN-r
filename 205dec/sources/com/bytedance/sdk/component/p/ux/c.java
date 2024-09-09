package com.bytedance.sdk.component.p.ux;

import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f29963c;

    /* renamed from: w  reason: collision with root package name */
    private static Map<String, Map<String, Object>> f29964w = new HashMap();

    private c() {
    }

    public static c c() {
        if (f29963c != null) {
            return f29963c;
        }
        synchronized (c.class) {
            if (f29963c != null) {
                return f29963c;
            }
            f29963c = new c();
            return f29963c;
        }
    }

    public Map<String, Object> c(String str) {
        Map<String, Object> map = f29964w.get(str);
        if (map != null) {
            return map;
        }
        HashMap hashMap = new HashMap();
        f29964w.put(str, hashMap);
        return hashMap;
    }
}
