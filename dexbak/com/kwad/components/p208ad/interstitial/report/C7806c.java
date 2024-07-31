package com.kwad.components.p208ad.interstitial.report;

import android.os.SystemClock;
import androidx.annotation.NonNull;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.C10829k;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10484b;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.C11160a;

/* renamed from: com.kwad.components.ad.interstitial.report.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7806c {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.interstitial.report.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7807a {

        /* renamed from: ls */
        private static final C7806c f26352ls = new C7806c();
    }

    /* renamed from: a */
    private static void m32285a(boolean z, AbstractC9822a abstractC9822a) {
        if (C10829k.m24699zd().m24700ys()) {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).m27628i(z ? 1.0d : 0.01d).m27635N("ad_sdk_interstitial_load", "status").m27634a(BusinessType.AD_INTERSTITIAL).m27625u(abstractC9822a).m27632a(C11160a.aTL));
        }
    }

    /* renamed from: dQ */
    public static C7806c m32283dQ() {
        return C7807a.f26352ls;
    }

    /* renamed from: b */
    public final void m32284b(@NonNull AdTemplate adTemplate, boolean z) {
        adTemplate.notNetworkRequest = z;
        m32285a(false, new InterstitialReportInfo(adTemplate).setStatus(3).setType(adTemplate.notNetworkRequest ? 2 : 1).setDownloadDuration(adTemplate.downloadDuration).setDownloadSize(adTemplate.getDownloadSize()).setDownloadType(adTemplate.getDownloadType()).setAdTemplate(adTemplate));
    }

    /* renamed from: i */
    public final void m32282i(long j) {
        m32285a(false, new InterstitialReportInfo().setStatus(1).setPosId(j));
    }

    /* renamed from: p */
    public final void m32281p(AdTemplate adTemplate) {
        m32285a(false, new InterstitialReportInfo(adTemplate).setStatus(6).setAdTemplate(adTemplate));
    }

    /* renamed from: q */
    public final void m32280q(AdTemplate adTemplate) {
        try {
            m32285a(false, new InterstitialReportInfo(adTemplate).setStatus(8).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(C10483a.m25875be(C10487e.m25641dQ(adTemplate))).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: r */
    public final void m32279r(@NonNull AdTemplate adTemplate) {
        m32285a(false, new InterstitialReportInfo(adTemplate).setStatus(10).setAdTemplate(adTemplate));
    }

    /* renamed from: s */
    public final void m32278s(@NonNull AdTemplate adTemplate) {
        m32285a(false, new InterstitialReportInfo(adTemplate).setStatus(7).setAdTemplate(adTemplate));
    }

    /* renamed from: t */
    public final void m32277t(@NonNull AdTemplate adTemplate) {
        m32285a(true, new InterstitialReportInfo(adTemplate).setStatus(12).setRenderType(C10484b.m25773cS(adTemplate) ? 3 : 1).setAdTemplate(adTemplate));
    }

    /* renamed from: u */
    public final void m32276u(@NonNull AdTemplate adTemplate) {
        m32285a(true, new InterstitialReportInfo(adTemplate).setStatus(11).setRenderType(1).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public final void m32287a(AdTemplate adTemplate, int i, String str) {
        m32285a(true, new InterstitialReportInfo(adTemplate).setStatus(9).setErrorCode(i).setErrorMsg(str).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public final void m32286a(@NonNull AdTemplate adTemplate, boolean z) {
        m32285a(false, new InterstitialReportInfo(adTemplate).setStatus(2).setType(z ? 2 : 1).setLoadDataTime(adTemplate.loadDataTime).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public final void m32288a(@NonNull AdTemplate adTemplate, int i) {
        m32285a(false, new InterstitialReportInfo(adTemplate).setStatus(4).setType(adTemplate.notNetworkRequest ? 2 : 1).setMaterialType(C10483a.m25875be(C10487e.m25641dQ(adTemplate))).setRenderDuration(SystemClock.elapsedRealtime() - adTemplate.adShowStartTimeStamp).setRenderType(i).setExpectedRenderType().setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    public final void m32289a(int i, String str, long j) {
        m32285a(true, new InterstitialReportInfo().setStatus(5).setErrorCode(i).setErrorMsg(str).setPosId(j));
    }
}
