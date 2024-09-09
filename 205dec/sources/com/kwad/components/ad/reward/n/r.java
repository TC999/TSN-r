package com.kwad.components.ad.reward.n;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class r {
    @Nullable
    private AdTemplate mAdTemplate;
    @Nullable
    private com.kwad.components.core.e.d.c mApkDownloadHelper;

    private r() {
    }

    public static r R(AdTemplate adTemplate) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        return rVar;
    }

    public static r a(AdTemplate adTemplate, com.kwad.components.core.e.d.c cVar) {
        r rVar = new r();
        rVar.setAdTemplate(adTemplate);
        rVar.setApkDownloadHelper(cVar);
        return rVar;
    }

    private void setAdTemplate(@Nullable AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    private void setApkDownloadHelper(@Nullable com.kwad.components.core.e.d.c cVar) {
        this.mApkDownloadHelper = cVar;
    }

    @Nullable
    public final com.kwad.components.core.e.d.c gZ() {
        return this.mApkDownloadHelper;
    }

    @Nullable
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }
}
