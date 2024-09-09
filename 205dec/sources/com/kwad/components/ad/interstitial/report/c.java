package com.kwad.components.ad.interstitial.report;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.response.b.e;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class a {
        private static final c ls = new c();
    }

    private static void a(boolean z3, com.kwad.sdk.commercial.c.a aVar) {
        if (k.zd().ys()) {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(z3 ? "ad_client_error_log" : "ad_client_apm_log").i(z3 ? 1.0d : 0.01d).N("ad_sdk_interstitial_load", "status").a(BusinessType.AD_INTERSTITIAL).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        }
    }

    public static c dQ() {
        return a.ls;
    }

    public final void b(@NonNull AdTemplate adTemplate, boolean z3) {
        adTemplate.notNetworkRequest = z3;
        a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setType(adTemplate.notNetworkRequest ? 2 : 1).setDownloadDuration(adTemplate.downloadDuration).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setAdTemplate(adTemplate));
    }

    public final void i(long j4) {
        a(false, new InterstitialReportInfo().setStatus(1).setPosId(j4));
    }

    public final void p(AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(6).setAdTemplate(adTemplate));
    }

    public final void q(AdTemplate adTemplate) {
        try {
            a(false, new InterstitialReportInfo(adTemplate).setStatus(8).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dQ(adTemplate))).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public final void r(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(10).setAdTemplate(adTemplate));
    }

    public final void s(@NonNull AdTemplate adTemplate) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(7).setAdTemplate(adTemplate));
    }

    public final void t(@NonNull AdTemplate adTemplate) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(12).setRenderType(com.kwad.sdk.core.response.b.b.cS(adTemplate) ? 3 : 1).setAdTemplate(adTemplate));
    }

    public final void u(@NonNull AdTemplate adTemplate) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(11).setRenderType(1).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, int i4, String str) {
        a(true, new InterstitialReportInfo(adTemplate).setStatus(9).setErrorCode(i4).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, boolean z3) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(2).setType(z3 ? 2 : 1).setLoadDataTime(adTemplate.loadDataTime).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void a(@NonNull AdTemplate adTemplate, int i4) {
        a(false, new InterstitialReportInfo(adTemplate).setStatus(4).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(com.kwad.sdk.core.response.b.a.be(e.dQ(adTemplate))).setRenderDuration(SystemClock.elapsedRealtime() - adTemplate.adShowStartTimeStamp).setRenderType(i4).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    public final void a(int i4, String str, long j4) {
        a(true, new InterstitialReportInfo().setStatus(5).setErrorCode(i4).setErrorMsg(str).setPosId(j4));
    }
}
