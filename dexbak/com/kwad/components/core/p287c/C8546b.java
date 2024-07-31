package com.kwad.components.core.p287c;

import com.kwad.sdk.C10829k;
import com.kwad.sdk.components.C9861c;
import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.C11128v;

/* renamed from: com.kwad.components.core.c.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8546b {
    /* renamed from: Y */
    private static void m30398Y(String str) {
        if (m30396mw() && C10829k.m24699zd().m24700ys()) {
            C11128v.m23672O(ServiceProvider.getContext(), str);
        }
    }

    /* renamed from: b */
    public static void m30397b(C8551e c8551e) {
        int m30385mA = c8551e.m30385mA();
        m30398Y("使用缓存策略: " + m30385mA);
    }

    /* renamed from: mw */
    public static boolean m30396mw() {
        DevelopMangerComponents developMangerComponents = (DevelopMangerComponents) C9861c.m27501f(DevelopMangerComponents.class);
        return false;
    }
}
