package com.kwad.sdk.core.adlog.b;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, b bVar) {
        a(aVar, cVar, false, bVar);
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i4) {
        try {
            a(aVar, cVar, b.Bp().cs(2).cx(i4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i4) {
        try {
            a(aVar, cVar, true, b.Bp().cs(3).cx(i4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i4) {
        try {
            a(aVar, cVar, b.Bp().cs(4).cx(i4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void e(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i4) {
        try {
            a(aVar, cVar, true, b.Bp().cs(7).cx(i4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, boolean z3, b bVar) {
        com.kwad.sdk.core.adlog.c.a aVar2 = aVar.apr;
        AdTemplate adTemplate = aVar2.adTemplate;
        bVar.ct(aVar2.aoM).cu(aVar.retryCount).cv(aVar.apt).cZ(aVar.apu).cw(cVar.apC).setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu("ad_client_apm_log").i(z3 ? 1.0d : 0.1d).a(com.kwad.sdk.commercial.d.aS(adTemplate)).N("ad_sdk_adlog_retry", "status").u(bVar));
    }

    public static void b(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i4, long j4) {
        try {
            a(aVar, cVar, true, b.Bp().cs(6).cx(i4).ae(j4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i4) {
        try {
            a(aVar, cVar, b.Bp().cs(1).cx(i4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(com.kwad.sdk.core.adlog.a.a aVar, com.kwad.sdk.core.adlog.a.c cVar, int i4, long j4) {
        try {
            a(aVar, cVar, b.Bp().cs(5).cx(i4).ae(j4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
