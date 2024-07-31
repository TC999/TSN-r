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
import com.kwai.adclient.kscommerciallogger.model.C11160a;

/* renamed from: com.kwad.components.ad.interstitial.report.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7808d {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.interstitial.report.d$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7809a {

        /* renamed from: lt */
        private static final C7808d f26353lt = new C7808d();
    }

    /* renamed from: a */
    private static void m32273a(boolean z, AbstractC9822a abstractC9822a) {
        try {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(z ? 1.0d : 0.01d).m27635N("ad_sdk_interstitial_play", "status").m27634a(BusinessType.AD_INTERSTITIAL).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: dS */
    public static C7808d m32271dS() {
        return C7809a.f26353lt;
    }

    /* renamed from: b */
    public final void m32272b(@NonNull AdTemplate adTemplate, int i, String str) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        m32273a(true, new InterstitialReportInfo(adTemplate).setCreativeId(C10483a.m25978J(m25641dQ)).setVideoUrl(C10483a.m25977K(m25641dQ)).setDownloadType(adTemplate.getDownloadType()).setDownloadSize(adTemplate.getDownloadSize()).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setStatus(2).setErrorMsg(str).setErrorCode(i).setAdTemplate(adTemplate));
    }

    /* renamed from: v */
    public final void m32270v(@NonNull AdTemplate adTemplate) {
        m32273a(false, new InterstitialReportInfo(adTemplate).setStatus(1).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public final void m32274a(@NonNull AdTemplate adTemplate, long j) {
        AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
        m32273a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setCreativeId(C10487e.m25631ea(adTemplate)).setVideoUrl(C10483a.m25977K(m25641dQ)).setVideoDuration(C10483a.m25976L(m25641dQ) * 1000).setPlayStartedDuration(j).setAdTemplate(adTemplate));
    }
}
