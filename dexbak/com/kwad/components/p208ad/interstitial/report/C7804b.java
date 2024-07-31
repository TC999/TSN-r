package com.kwad.components.p208ad.interstitial.report;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.C11161b;

/* renamed from: com.kwad.components.ad.interstitial.report.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7804b {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.interstitial.report.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7805a {

        /* renamed from: lr */
        private static final C7804b f26351lr = new C7804b();
    }

    /* renamed from: a */
    private static void m32294a(boolean z, AbstractC9822a abstractC9822a) {
        try {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(z ? 1.0d : 0.01d).m27635N("ad_sdk_interstitial_download_error", "status").m27634a(BusinessType.AD_INTERSTITIAL).m27625u(abstractC9822a).m27632a(C11161b.aUe));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: dO */
    public static C7804b m32292dO() {
        return C7805a.f26351lr;
    }

    /* renamed from: b */
    public final void m32293b(@NonNull AdTemplate adTemplate, String str) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        m32294a(true, new InterstitialReportInfo().setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setStatus(2).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    /* renamed from: o */
    public final void m32291o(@NonNull AdTemplate adTemplate) {
        m32294a(false, new InterstitialReportInfo().setDownloadType(adTemplate.getDownloadType()).setStatus(1).setAdTemplate(adTemplate));
    }
}
