package com.kwad.components.ad.splashscreen.f;

import android.text.TextUtils;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;

/* loaded from: E:\TSN-r\205dec\6520572.dex */
public abstract class a extends com.kwad.sdk.core.download.a.a {
    private AdInfo mAdInfo;
    private AdTemplate mAdTemplate;

    public a(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
        this.mAdInfo = e.dQ(adTemplate);
    }

    private void i(int i4, int i5) {
        String a4 = com.kwad.components.ad.splashscreen.d.a(this.mAdTemplate, this.mAdInfo, i4, i5);
        if (TextUtils.isEmpty(a4)) {
            return;
        }
        k(i4, a4);
    }

    protected abstract void k(int i4, String str);

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFailed() {
        i(7, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onDownloadFinished() {
        i(8, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onIdle() {
        i(0, 0);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onInstalled() {
        i(12, 0);
    }

    @Override // com.kwad.sdk.core.download.a.a
    public final void onPaused(int i4) {
        i(4, i4);
    }

    @Override // com.kwad.sdk.api.KsAppDownloadListener
    public void onProgressUpdate(int i4) {
        i(2, i4);
    }

    public final void setAdTemplate(AdTemplate adTemplate) {
        this.mAdTemplate = adTemplate;
    }
}
