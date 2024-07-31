package com.kwad.components.p208ad.reward.p264n;

import androidx.annotation.Nullable;
import com.kwad.components.core.p289e.p293d.C8619c;
import com.kwad.sdk.core.response.model.AdTemplate;

/* renamed from: com.kwad.components.ad.reward.n.r */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8074r {
    @Nullable
    private AdTemplate mAdTemplate;
    @Nullable
    private C8619c mApkDownloadHelper;

    private C8074r() {
    }

    /* renamed from: R */
    public static C8074r m31647R(AdTemplate adTemplate) {
        C8074r c8074r = new C8074r();
        c8074r.setAdTemplate(adTemplate);
        return c8074r;
    }

    /* renamed from: a */
    public static C8074r m31646a(AdTemplate adTemplate, C8619c c8619c) {
        C8074r c8074r = new C8074r();
        c8074r.setAdTemplate(adTemplate);
        c8074r.setApkDownloadHelper(c8619c);
        return c8074r;
    }

    private void setAdTemplate(@Nullable AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }

    private void setApkDownloadHelper(@Nullable C8619c c8619c) {
        this.mApkDownloadHelper = c8619c;
    }

    @Nullable
    /* renamed from: gZ */
    public final C8619c m31645gZ() {
        return this.mApkDownloadHelper;
    }

    @Nullable
    public final AdTemplate getAdTemplate() {
        return this.mAdTemplate;
    }
}
