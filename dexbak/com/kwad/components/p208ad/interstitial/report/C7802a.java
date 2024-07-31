package com.kwad.components.p208ad.interstitial.report;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.C11160a;

/* renamed from: com.kwad.components.ad.interstitial.report.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7802a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.interstitial.report.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7803a {

        /* renamed from: lq */
        private static final C7802a f26350lq = new C7802a();
    }

    /* renamed from: a */
    private static void m32301a(String str, AbstractC9822a abstractC9822a) {
        if (C10829k.m24699zd().m24700ys()) {
            try {
                C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.01d).m27635N("ad_sdk_interstitial_callback", str).m27634a(BusinessType.AD_INTERSTITIAL).m27625u(abstractC9822a).m27632a(C11160a.aTL));
            } catch (Throwable th) {
                ServiceProvider.reportSdkCaughtException(th);
            }
        }
    }

    /* renamed from: dM */
    public static C7802a m32299dM() {
        return C7803a.f26350lq;
    }

    /* renamed from: b */
    public final void m32300b(AdTemplate adTemplate, long j, long j2) {
        m32301a("callback_type", new InterstitialReportInfo().setCallbackType(2L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }

    /* renamed from: l */
    public final void m32298l(AdTemplate adTemplate) {
        m32301a("action_type", new InterstitialReportInfo().setActionType(2L).setAdTemplate(adTemplate));
    }

    /* renamed from: m */
    public final void m32297m(AdTemplate adTemplate) {
        m32301a("callback_type", new InterstitialReportInfo().setCallbackType(1L).setAdTemplate(adTemplate));
    }

    /* renamed from: n */
    public final void m32296n(AdTemplate adTemplate) {
        m32301a("callback_type", new InterstitialReportInfo().setCallbackType(3L).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public final void m32302a(AdTemplate adTemplate, long j, long j2) {
        m32301a("action_type", new InterstitialReportInfo().setActionType(1L).setClickSceneType(j).setItemClickType(j2).setAdTemplate(adTemplate));
    }
}
