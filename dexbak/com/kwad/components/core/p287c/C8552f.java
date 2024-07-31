package com.kwad.components.core.p287c;

import com.kwad.sdk.core.response.model.AdResultData;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* renamed from: com.kwad.components.core.c.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8552f {

    /* renamed from: Je */
    private Map<Integer, AdResultData> f28099Je = new ConcurrentHashMap();

    /* renamed from: Jf */
    private AtomicInteger f28100Jf = new AtomicInteger(0);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.core.c.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C8553a {

        /* renamed from: Jg */
        static C8552f f28101Jg = new C8552f();
    }

    /* renamed from: mE */
    public static C8552f m30378mE() {
        return C8553a.f28101Jg;
    }

    /* renamed from: d */
    public final AdResultData m30380d(int i, boolean z) {
        AdResultData adResultData = this.f28099Je.get(Integer.valueOf(i));
        this.f28099Je.remove(Integer.valueOf(i));
        return adResultData;
    }

    /* renamed from: i */
    public final int m30379i(AdResultData adResultData) {
        if (adResultData == null) {
            return 0;
        }
        int incrementAndGet = this.f28100Jf.incrementAndGet();
        this.f28099Je.put(Integer.valueOf(incrementAndGet), adResultData);
        return incrementAndGet;
    }
}
