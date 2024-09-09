package com.kwad.components.core.c;

import com.kwad.sdk.components.DevelopMangerComponents;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.v;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b {
    private static void Y(String str) {
        if (mw() && com.kwad.sdk.k.zd().ys()) {
            v.O(ServiceProvider.getContext(), str);
        }
    }

    public static void b(e eVar) {
        int mA = eVar.mA();
        Y("\u4f7f\u7528\u7f13\u5b58\u7b56\u7565: " + mA);
    }

    public static boolean mw() {
        DevelopMangerComponents developMangerComponents = (DevelopMangerComponents) com.kwad.sdk.components.c.f(DevelopMangerComponents.class);
        return false;
    }
}
