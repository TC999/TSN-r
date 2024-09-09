package com.bytedance.sdk.openadsdk.core.ls;

import com.bytedance.sdk.openadsdk.core.eq.ba;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: c  reason: collision with root package name */
    private static volatile c f33873c;

    /* renamed from: w  reason: collision with root package name */
    private Map<String, w> f33874w = new HashMap();

    private c() {
        c(com.bytedance.sdk.openadsdk.core.ls.xv.c.xv());
        c(com.bytedance.sdk.openadsdk.core.ls.c.c.w());
        c(com.bytedance.sdk.openadsdk.core.ls.sr.c.xv());
    }

    public static c c() {
        if (f33873c == null) {
            synchronized (c.class) {
                if (f33873c == null) {
                    f33873c = new c();
                }
            }
        }
        return f33873c;
    }

    private void c(w wVar) {
        this.f33874w.put(wVar.c(), wVar);
    }

    public String c(String str, String str2) {
        if (this.f33874w.containsKey(str)) {
            return this.f33874w.get(str).c(str2);
        }
        return ba.c(str).w(str2, "");
    }

    public void c(String str, String str2, String str3) {
        if (this.f33874w.containsKey(str)) {
            this.f33874w.get(str).c(str2, str3);
        } else {
            ba.c(str).c(str2, str3);
        }
    }
}
