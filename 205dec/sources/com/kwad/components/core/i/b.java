package com.kwad.components.core.i;

import androidx.annotation.NonNull;
import com.kwad.sdk.api.KsInnerAd;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class b implements KsInnerAd {
    private final int Md;
    @NonNull
    private final AdTemplate mAdTemplate;

    public b(@NonNull AdTemplate adTemplate, int i4) {
        this.mAdTemplate = adTemplate;
        this.Md = i4;
    }

    @NonNull
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }

    @Override // com.kwad.sdk.api.KsInnerAd
    public final int getType() {
        return this.Md;
    }
}
