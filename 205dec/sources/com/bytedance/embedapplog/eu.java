package com.bytedance.embedapplog;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class eu {

    /* renamed from: c  reason: collision with root package name */
    private static final ta f26724c = new ta();

    /* renamed from: w  reason: collision with root package name */
    private static final Map<String, String> f26725w = new ConcurrentHashMap();

    public static String c(String str) {
        Map<String, String> map = f26725w;
        String str2 = map.get(str);
        if (str2 != null) {
            return str2;
        }
        String c4 = f26724c.c(str);
        if (c4 != null) {
            map.put(str, c4);
        }
        return c4;
    }
}
