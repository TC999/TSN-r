package com.kwad.components.ad.interstitial.report.realtime;

import com.kwad.components.ad.interstitial.report.realtime.model.InterstitialRealTimeInfo;
import com.kwad.sdk.commercial.b;
import com.kwad.sdk.commercial.c;
import com.kwad.sdk.core.network.e;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
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
    /* renamed from: com.kwad.components.ad.interstitial.report.realtime.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class C0578a {
        private static final a lu = new a((byte) 0);
    }

    /* synthetic */ a(byte b4) {
        this();
    }

    public static void a(e eVar) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setErrorCode(eVar.errorCode);
            b.d(c.AJ().cu("ad_client_error_log").i(1.0d).N("ad_sdk_interstitial_data_result_monitor", "error_code").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, AdTemplate adTemplate) {
        try {
            AdInfo dQ = com.kwad.sdk.core.response.b.e.dQ(adTemplate);
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            interstitialRealTimeInfo.setMaterialUrl(com.kwad.sdk.core.response.b.a.K(dQ));
            b.d(c.AJ().cu("ad_client_error_log").i(1.0d).N("ad_sdk_interstitial_resource_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static a dU() {
        return C0578a.lu;
    }

    public static void w(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setRenderType(com.kwad.sdk.core.response.b.e.dQ(adTemplate).adMatrixInfo.adDataV2.interstitialCardInfo.renderType);
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            b.d(c.AJ().cu("ad_client_error_log").i(1.0d).N("ad_sdk_interstitial_data_check_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void x(AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            b.d(c.AJ().cu("ad_client_error_log").i(1.0d).N("ad_sdk_interstitial_service_call_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private a() {
    }

    public static void a(String str, AdTemplate adTemplate) {
        try {
            InterstitialRealTimeInfo interstitialRealTimeInfo = new InterstitialRealTimeInfo();
            interstitialRealTimeInfo.setAdTemplate(adTemplate);
            interstitialRealTimeInfo.setErrorMsg(str);
            b.d(c.AJ().cu("ad_client_error_log").i(1.0d).N("ad_sdk_interstitial_render_result_monitor", "monitor_index").a(BusinessType.AD_INTERSTITIAL).u(interstitialRealTimeInfo).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
