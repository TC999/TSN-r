package com.kwad.components.core.p298i;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.core.response.model.AdTemplate;

/* renamed from: com.kwad.components.core.i.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C8673b implements KsInnerAd {

    /* renamed from: Md */
    private final int f28342Md;
    @NonNull
    private final AdTemplate mAdTemplate;

    public C8673b(@NonNull AdTemplate adTemplate, int i) {
        this.mAdTemplate = adTemplate;
        this.f28342Md = i;
    }

    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInnerAd
    public final int getType() {
        return this.f28342Md;
    }
}
