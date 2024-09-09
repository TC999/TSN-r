package com.bytedance.adsdk.w.w.sr;

import java.util.HashMap;
import java.util.Map;
import p0.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public enum sr implements a {
    LEFT_PAREN("("),
    RIGHT_PAREN(")"),
    LEFT_BRACKET("["),
    RIGHT_BRACKET("]"),
    COMMA(",");
    

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, sr> f26433f;

    /* renamed from: r  reason: collision with root package name */
    private final String f26435r;

    static {
        HashMap hashMap = new HashMap(128);
        f26433f = hashMap;
        for (sr srVar : hashMap.values()) {
            f26433f.put(srVar.c(), srVar);
        }
    }

    sr(String str) {
        this.f26435r = str;
    }

    public static boolean c(a aVar) {
        return aVar instanceof sr;
    }

    public String c() {
        return this.f26435r;
    }
}
