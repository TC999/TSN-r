package com.kwad.components.core.p287c;

import androidx.annotation.NonNull;
import com.kwad.components.core.internal.api.InterfaceC8677a;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;
import java.lang.ref.WeakReference;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.kwad.components.core.c.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8554g {

    /* renamed from: Ji */
    private static volatile C8554g f28102Ji;

    /* renamed from: Jh */
    private ConcurrentHashMap<String, WeakReference<Object>> f28103Jh = new ConcurrentHashMap<>();

    /* renamed from: al */
    private static String m30375al(AdTemplate adTemplate) {
        long m25648dJ = C10487e.m25648dJ(adTemplate);
        long m25631ea = C10487e.m25631ea(adTemplate);
        return m25648dJ + "-" + m25631ea;
    }

    /* renamed from: b */
    private static String m30374b(C8555h c8555h) {
        String m30366mG = c8555h.m30366mG();
        String m30360mM = c8555h.m30360mM();
        return m30366mG + "-" + m30360mM;
    }

    @NonNull
    /* renamed from: mF */
    public static C8554g m30373mF() {
        if (f28102Ji == null) {
            synchronized (C8554g.class) {
                if (f28102Ji == null) {
                    f28102Ji = new C8554g();
                }
            }
        }
        return f28102Ji;
    }

    /* renamed from: a */
    public final boolean m30377a(C8555h c8555h) {
        String m30374b = m30374b(c8555h);
        C10331c.m26254d("AdMemCachePool", "contains key: " + m30374b);
        boolean z = false;
        if (this.f28103Jh.containsKey(m30374b)) {
            WeakReference<Object> weakReference = this.f28103Jh.get(m30374b);
            if (weakReference != null && weakReference.get() != null) {
                z = true;
            }
            if (z) {
                C10331c.m26254d("AdMemCachePool", "contains ad: " + weakReference.get());
            }
            return z;
        }
        return false;
    }

    public final void add(Object obj) {
        if (obj instanceof InterfaceC8677a) {
            this.f28103Jh.put(m30375al(((InterfaceC8677a) obj).getAdTemplate()), new WeakReference<>(obj));
        }
    }

    /* renamed from: ak */
    public final void m30376ak(AdTemplate adTemplate) {
        this.f28103Jh.remove(m30375al(adTemplate));
    }
}
