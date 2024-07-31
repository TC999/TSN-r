package com.kwad.components.p208ad.reward;

import com.kwad.sdk.core.response.model.AdTemplate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.kwad.components.ad.reward.i */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7947i {

    /* renamed from: qe */
    private Map<String, List<AdTemplate>> f26659qe;

    /* renamed from: com.kwad.components.ad.reward.i$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C7948a {

        /* renamed from: qf */
        private static final C7947i f26660qf = new C7947i((byte) 0);
    }

    /* synthetic */ C7947i(byte b) {
        this();
    }

    /* renamed from: gj */
    public static C7947i m31941gj() {
        return C7948a.f26660qf;
    }

    /* renamed from: B */
    public final void m31942B(String str) {
        this.f26659qe.remove(str);
    }

    private C7947i() {
        this.f26659qe = new ConcurrentHashMap();
    }
}
