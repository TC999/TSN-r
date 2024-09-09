package com.kwad.components.ad.interstitial.report;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.k;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.components.ad.interstitial.report.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0577a {
        private static final a lq = new a();
    }

    private static void a(String str, com.kwad.sdk.commercial.c.a aVar) {
        if (k.zd().ys()) {
            try {
                com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu("ad_client_apm_log").i(0.01d).N("ad_sdk_interstitial_callback", str).a(BusinessType.AD_INTERSTITIAL).u(aVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    public static a dM() {
        return C0577a.lq;
    }

    public final void b(AdTemplate adTemplate, long j4, long j5) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(2L).setClickSceneType(j4).setItemClickType(j5).setAdTemplate(adTemplate));
    }

    public final void l(AdTemplate adTemplate) {
        a("action_type", new InterstitialReportInfo().setActionType(2L).setAdTemplate(adTemplate));
    }

    public final void m(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(1L).setAdTemplate(adTemplate));
    }

    public final void n(AdTemplate adTemplate) {
        a("callback_type", new InterstitialReportInfo().setCallbackType(3L).setAdTemplate(adTemplate));
    }

    public final void a(AdTemplate adTemplate, long j4, long j5) {
        a("action_type", new InterstitialReportInfo().setActionType(1L).setClickSceneType(j4).setItemClickType(j5).setAdTemplate(adTemplate));
    }
}
