package com.kwad.components.core.c;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.model.AdTemplate;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class g {
    private static volatile g Ji;
    private ConcurrentHashMap<String, WeakReference<Object>> Jh = new ConcurrentHashMap<>();

    private static String al(AdTemplate adTemplate) {
        long dJ = com.kwad.sdk.core.response.b.e.dJ(adTemplate);
        long ea = com.kwad.sdk.core.response.b.e.ea(adTemplate);
        return dJ + "-" + ea;
    }

    private static String b(h hVar) {
        String mG = hVar.mG();
        String mM = hVar.mM();
        return mG + "-" + mM;
    }

    @NonNull
    public static g mF() {
        if (Ji == null) {
            synchronized (g.class) {
                if (Ji == null) {
                    Ji = new g();
                }
            }
        }
        return Ji;
    }

    public final boolean a(h hVar) {
        String b4 = b(hVar);
        com.kwad.sdk.core.e.c.d("AdMemCachePool", "contains key: " + b4);
        boolean z3 = false;
        if (this.Jh.containsKey(b4)) {
            WeakReference<Object> weakReference = this.Jh.get(b4);
            if (weakReference != null && weakReference.get() != null) {
                z3 = true;
            }
            if (z3) {
                com.kwad.sdk.core.e.c.d("AdMemCachePool", "contains ad: " + weakReference.get());
            }
            return z3;
        }
        return false;
    }

    public final void add(Object obj) {
        if (obj instanceof com.kwad.components.core.internal.api.a) {
            this.Jh.put(al(((com.kwad.components.core.internal.api.a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }

    public final void ak(AdTemplate adTemplate) {
        this.Jh.remove(al(adTemplate));
    }
}
