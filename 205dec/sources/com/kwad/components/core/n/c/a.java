package com.kwad.components.core.n.c;

import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class a {
    private static void a(b bVar) {
        a(bVar, false);
    }

    public static void b(String str, long j4, int i4) {
        try {
            a(new b().am(str).B(j4).aw(i4).A(2L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j4) {
        try {
            a(new b().am(str).B(j4).A(1L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(String str, long j4) {
        try {
            a(new b().am(str).B(j4).A(6L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    private static void a(b bVar, boolean z3) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(z3 ? "ad_client_error_log" : "ad_client_apm_log").i(z3 ? 1.0d : 0.01d).N("ad_sdk_offline_component_monitor", "load_status").u(bVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
    }

    public static void c(String str, long j4, String str2) {
        try {
            a(new b().am(str).B(j4).ao(str2).A(4L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(String str, long j4, String str2) {
        try {
            a(new b().am(str).B(j4).ao(str2).A(3L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j4, int i4, String str2, String str3) {
        try {
            a(new b().am(str).B(j4).setErrorCode(i4).ao(str3).an(str2).A(7L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void c(String str, long j4, int i4) {
        try {
            a(new b().am(str).A(8L).aw(i4).B(j4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j4, String str2) {
        try {
            a(new b().am(str).ao(str2).B(j4).A(5L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
