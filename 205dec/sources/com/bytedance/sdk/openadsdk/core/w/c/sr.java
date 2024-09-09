package com.bytedance.sdk.openadsdk.core.w.c;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.u.me;
import com.bytedance.sdk.openadsdk.core.w.c.w.f;
import com.bytedance.sdk.openadsdk.core.w.c.w.gd;
import com.bytedance.sdk.openadsdk.core.w.c.w.r;
import com.bytedance.sdk.openadsdk.core.w.c.w.ux;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private final Map<Class, c> f35300c = new HashMap();

    /* renamed from: w  reason: collision with root package name */
    private final xv f35301w = new xv();

    private <T extends c> T w(Class<T> cls) {
        try {
            return cls.newInstance();
        } catch (Throwable unused) {
            try {
                Constructor<T> declaredConstructor = cls.getDeclaredConstructor(me.class, Context.class);
                declaredConstructor.setAccessible(true);
                return declaredConstructor.newInstance(null, null);
            } catch (Throwable unused2) {
                return null;
            }
        }
    }

    public xv c(me meVar, Context context, com.bytedance.sdk.openadsdk.core.w.sr srVar, boolean z3) {
        com.bytedance.sdk.openadsdk.core.w.c.c.w c4;
        com.bytedance.sdk.openadsdk.core.w.c.w.c cVar = new com.bytedance.sdk.openadsdk.core.w.c.w.c(meVar, context);
        this.f35300c.put(com.bytedance.sdk.openadsdk.core.w.c.w.c.class, cVar);
        w wVar = new w(meVar, context);
        this.f35300c.put(w.class, wVar);
        if (z3) {
            c4 = com.bytedance.sdk.openadsdk.core.w.c.c.xv.c(meVar, context);
        } else {
            c4 = com.bytedance.sdk.openadsdk.core.w.c.c.xv.c(meVar, context, 3);
        }
        this.f35300c.put(com.bytedance.sdk.openadsdk.core.w.c.c.w.class, c4);
        gd gdVar = new gd(meVar, context, srVar);
        this.f35300c.put(gd.class, gdVar);
        com.bytedance.sdk.openadsdk.core.w.c.w.xv xvVar = new com.bytedance.sdk.openadsdk.core.w.c.w.xv(meVar, context, srVar);
        this.f35300c.put(com.bytedance.sdk.openadsdk.core.w.c.w.xv.class, xvVar);
        f fVar = new f(meVar, context, srVar);
        this.f35300c.put(f.class, fVar);
        com.bytedance.sdk.openadsdk.core.w.c.xv.c cVar2 = new com.bytedance.sdk.openadsdk.core.w.c.xv.c(meVar, context);
        this.f35300c.put(com.bytedance.sdk.openadsdk.core.w.c.xv.c.class, cVar2);
        com.bytedance.sdk.openadsdk.core.w.c.xv.sr srVar2 = new com.bytedance.sdk.openadsdk.core.w.c.xv.sr(meVar, context);
        this.f35300c.put(com.bytedance.sdk.openadsdk.core.w.c.xv.sr.class, srVar2);
        com.bytedance.sdk.openadsdk.core.w.c.xv.xv xvVar2 = new com.bytedance.sdk.openadsdk.core.w.c.xv.xv(meVar, context);
        this.f35300c.put(com.bytedance.sdk.openadsdk.core.w.c.xv.xv.class, xvVar2);
        ux uxVar = new ux(meVar, context, srVar);
        this.f35300c.put(ux.class, uxVar);
        this.f35301w.c(cVar);
        this.f35301w.c(fVar);
        this.f35301w.c(gdVar);
        if (z3) {
            r rVar = new r(meVar, context);
            this.f35300c.put(r.class, rVar);
            this.f35301w.c(rVar);
        }
        this.f35301w.c(wVar);
        this.f35301w.c(xvVar);
        this.f35301w.c(uxVar);
        this.f35301w.c(c4);
        this.f35301w.c(xvVar2);
        this.f35301w.c(cVar2);
        this.f35301w.c(srVar2);
        return this.f35301w;
    }

    public <T extends c> T c(Class<T> cls) {
        T t3 = (T) this.f35300c.get(cls);
        return t3 == null ? (T) w(cls) : t3;
    }
}
