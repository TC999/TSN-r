package com.kwad.components.p208ad.splashscreen.p284f;

import android.text.TextUtils;
import com.kwad.components.p208ad.splashscreen.C8474d;
import com.kwad.sdk.core.download.p395a.AbstractC10298a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.splashscreen.f.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public abstract class AbstractC8483a extends AbstractC10298a {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public AbstractC8483a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = C10487e.m25641dQ(adTemplate);
    }

    /* renamed from: i */
    private void m30642i(int i, int i2) {
        String m30659a = C8474d.m30659a(this.mAdTemplate, this.mAdInfo, i, i2);
        if (TextUtils.isEmpty(m30659a)) {
            return;
        }
        mo30633k(i, m30659a);
    }

    /* renamed from: k */
    protected abstract void mo30633k(int i, String str);

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        m30642i(7, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        m30642i(8, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        m30642i(0, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        m30642i(12, 0);
    }

    @Override // com.kwad.sdk.core.download.p395a.AbstractC10298a
    public final void onPaused(int i) {
        m30642i(4, i);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i) {
        m30642i(2, i);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
