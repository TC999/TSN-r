package com.kwad.sdk.commercial.g;

import com.kwad.sdk.commercial.c;
import com.kwad.sdk.commercial.d;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        a(adTemplate, false, aVar);
    }

    public static void j(AdTemplate adTemplate, int i4, String str) {
        try {
            a(adTemplate, b.AQ().ck(1).cG(str).cl(i4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void k(AdTemplate adTemplate, int i4, String str) {
        try {
            a(adTemplate, b.AQ().ck(2).cG(str).cl(i4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void l(AdTemplate adTemplate, int i4, String str) {
        try {
            a(adTemplate, b.AQ().ck(4).cG(str).cl(i4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void m(AdTemplate adTemplate, int i4, String str) {
        try {
            a(adTemplate, b.AQ().ck(5).cG(str).cl(i4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z3, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.AJ().cu("ad_client_apm_log").i(z3 ? 0.1d : 0.01d).a(d.aS(adTemplate)).N("ad_sdk_landing_page_performance", "status").u(aVar));
    }

    public static void a(AdTemplate adTemplate, int i4, String str, String str2) {
        try {
            a(adTemplate, true, b.AQ().ck(3).cG(str).cl(i4).setErrorCode(100009).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, int i4, String str, int i5, String str2) {
        try {
            a(adTemplate, true, b.AQ().ck(6).cG(str).cl(i4).setErrorCode(i5).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
