package com.kwad.components.ad.interstitial.report;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private static final d lt = new d();
    }

    private static void a(boolean z3, com.kwad.sdk.commercial.c.a aVar) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu("ad_client_apm_log").i(z3 ? 1.0d : 0.01d).N("ad_sdk_interstitial_play", "status").a(BusinessType.AD_INTERSTITIAL).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static d dS() {
        return a.lt;
    }

    public final void b(@NonNull AdTemplate adTemplate, int i4, String str) {
        AdInfo dQ = e.dQ(adTemplate);
        a(true, new InterstitialReportInfo(adTemplate).setCreativeId(com.kwad.sdk.core.response.b.a.J(dQ)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i4).setAdTemplate(adTemplate));
    }

    public final void v(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(1).setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, long j4) {
        AdInfo dQ = e.dQ(adTemplate);
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setCreativeId(e.ea(adTemplate)).setVideoUrl(com.kwad.sdk.core.response.b.a.K(dQ)).setVideoDuration(com.kwad.sdk.core.response.b.a.L(dQ) * 1000).setPlayStartedDuration(j4).setAdTemplate(adTemplate));
    }
}
