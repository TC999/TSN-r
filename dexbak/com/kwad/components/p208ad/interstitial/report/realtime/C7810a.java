package com.kwad.components.p208ad.interstitial.report.realtime;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.components.p208ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.core.network.C10419e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.BusinessType;
import com.kwai.adclient.kscommerciallogger.model.C11160a;

/* renamed from: com.kwad.components.ad.interstitial.report.realtime.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7810a {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.components.ad.interstitial.report.realtime.a$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C7811a {

        /* renamed from: lu */
        private static final C7810a f26354lu = new C7810a((byte) 0);
    }

    /* synthetic */ C7810a(byte b) {
        this();
    }

    /* renamed from: a */
    public static void m32268a(C10419e c10419e) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setErrorCode(c10419e.errorCode);
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N("ad_sdk_interstitial_data_result_monitor", "error_code").m27634a(BusinessType.AD_INTERSTITIAL).m27625u(interstitialRealTimeInfo).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: b */
    public static void m32266b(String str, AdTemplate adTemplate) {
        try {
            AdInfo m25641dQ = C10487e.m25641dQ(adTemplate);
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            interstitialRealTimeInfo.setMaterialUrl(C10483a.m25977K(m25641dQ));
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N("ad_sdk_interstitial_resource_monitor", "monitor_index").m27634a(BusinessType.AD_INTERSTITIAL).m27625u(interstitialRealTimeInfo).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: dU */
    public static C7810a m32265dU() {
        return C7811a.f26354lu;
    }

    /* renamed from: w */
    public static void m32264w(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setRenderType(C10487e.m25641dQ(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType);
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N("ad_sdk_interstitial_data_check_monitor", "monitor_index").m27634a(BusinessType.AD_INTERSTITIAL).m27625u(interstitialRealTimeInfo).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: x */
    public static void m32263x(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N("ad_sdk_interstitial_service_call_monitor", "monitor_index").m27634a(BusinessType.AD_INTERSTITIAL).m27625u(interstitialRealTimeInfo).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private C7810a() {
    }

    /* renamed from: a */
    public static void m32267a(String str, AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27635N("ad_sdk_interstitial_render_result_monitor", "monitor_index").m27634a(BusinessType.AD_INTERSTITIAL).m27625u(interstitialRealTimeInfo).m27632a(C11160a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
