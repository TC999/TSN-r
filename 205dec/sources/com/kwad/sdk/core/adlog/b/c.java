package com.kwad.sdk.core.adlog.b;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private static void a(AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.a.a aVar, d dVar) {
        a(adTemplate, aVar, false, dVar);
    }

    public static void b(AdTemplate adTemplate, int i4, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.Bq().cy(2).cz(i4).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(AdTemplate adTemplate, int i4, String str, int i5, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.Bq().cy(4).cz(i4).da(str).setErrorCode(i5).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(AdTemplate adTemplate, int i4, String str, int i5, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.Bq().cy(3).cz(i4).da(str).setErrorCode(i5).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, @Nullable com.kwad.sdk.core.adlog.a.a aVar, boolean z3, d dVar) {
        if (aVar != null) {
            dVar.cA(1).cB(aVar.retryCount);
        }
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(z3 ? "ad_client_error_log" : "ad_client_apm_log").i(z3 ? 0.01d : 1.0E-4d).j(z3 ? 1.0d : 0.01d).a(com.kwad.sdk.commercial.d.aS(adTemplate)).N("ad_sdk_adlog_performance", "status").u(dVar));
    }

    public static void b(AdTemplate adTemplate, int i4, String str, int i5, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, true, d.Bq().cy(5).cz(i4).da(str).setErrorCode(i5).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i4, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.Bq().cy(1).cz(i4).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i4, String str, int i5, String str2, com.kwad.sdk.core.adlog.a.a aVar) {
        try {
            a(adTemplate, aVar, d.Bq().cy(5).cz(i4).da(str).setErrorCode(100004).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
