package com.kwad.sdk.commercial.b;

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

    public static void b(AdTemplate adTemplate, String str, String str2, int i4, int i5) {
        try {
            a(adTemplate, b.AL().cf(2).cw(str).cx(str2).ch(i4).cg(i5));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(AdTemplate adTemplate, boolean z3, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(c.AJ().cu("ad_client_apm_log").i(z3 ? 0.1d : 0.01d).a(d.aS(adTemplate)).N("ad_sdk_appstore_performance", "status").u(aVar));
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i4, int i5) {
        try {
            a(adTemplate, b.AL().cf(1).cw(str).cx(str2).ch(i4).cg(i5));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(AdTemplate adTemplate, String str, String str2, int i4, int i5, String str3) {
        try {
            a(adTemplate, true, b.AL().cf(4).cw(str).cx(str2).ch(i4).cg(i5).setErrorCode(100006).setErrorMsg(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
