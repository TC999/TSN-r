package com.bytedance.sdk.component.p.r;

import com.bytedance.sdk.component.p.c.c.xv;
import com.bytedance.sdk.component.p.c.w;
import com.bytedance.sdk.component.p.sr.sr;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c {

    /* renamed from: w  reason: collision with root package name */
    private static volatile c f29961w;

    /* renamed from: c  reason: collision with root package name */
    private Map<String, com.bytedance.sdk.component.p.c.c.c> f29962c = new HashMap();

    private c() {
    }

    public static c c() {
        if (f29961w != null) {
            return f29961w;
        }
        synchronized (c.class) {
            if (f29961w != null) {
                return f29961w;
            }
            f29961w = new c();
            return f29961w;
        }
    }

    public void c(String str, com.bytedance.sdk.component.p.c.c.c cVar) {
        this.f29962c.put(str, cVar);
    }

    public void c(String str, com.bytedance.sdk.component.p.c.c cVar, com.bytedance.sdk.component.p.sr.c cVar2) {
        com.bytedance.sdk.component.p.c.c.c cVar3 = this.f29962c.get(str);
        if (cVar3 == null) {
            return;
        }
        if (cVar == null) {
            if (cVar2 != null) {
                cVar2.w();
                return;
            }
            return;
        }
        Map<String, Object> c4 = cVar.c();
        sr ux = cVar.ux();
        if (ux instanceof w) {
            Map<String, Object> c5 = com.bytedance.sdk.component.p.ux.c.c().c(String.valueOf(ux.hashCode()));
            c4.putAll(c5);
            c5.clear();
            com.bytedance.sdk.component.p.f.c c6 = com.bytedance.sdk.component.p.f.c.c();
            cVar3 = c6.c(cVar3);
            HashMap hashMap = new HashMap();
            hashMap.putAll(cVar.w());
            hashMap.putAll(c4);
            c6.c(cVar3, hashMap);
        }
        boolean z3 = false;
        if (cVar3 instanceof xv) {
            z3 = ((xv) cVar3).c(cVar.w(), cVar.c(), cVar);
        } else if (cVar3 instanceof com.bytedance.sdk.component.p.c.c.w) {
            z3 = ((com.bytedance.sdk.component.p.c.c.w) cVar3).c(cVar.w(), cVar.c(), cVar);
        }
        if (z3) {
            cVar2.c();
        } else {
            cVar2.w();
        }
    }
}
