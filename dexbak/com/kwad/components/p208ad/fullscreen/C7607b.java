package com.kwad.components.p208ad.fullscreen;

import com.kwad.components.p208ad.reward.p248a.C7844b;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.fullscreen.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7607b {

    /* renamed from: gt */
    public final boolean f25856gt = C7844b.m32190gE();
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public C7607b(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
    }

    /* renamed from: bH */
    public final AdInfo m32794bH() {
        return this.mAdInfo;
    }

    /* renamed from: bI */
    public final boolean m32793bI() {
        return C10487e.m25629ec(this.mAdTemplate);
    }

    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }
}
