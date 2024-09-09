package com.kwad.components.core.n.c;

import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private static void a(d dVar, boolean z3) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu(z3 ? "ad_client_error_log" : "ad_client_apm_log").i(z3 ? 1.0d : 0.01d).N("ad_sdk_offline_component_update", "load_status").u(dVar).a(com.kwai.adclient.kscommerciallogger.model.a.aTL));
    }

    public static void b(String str, long j4, int i4, String str2, String str3) {
        try {
            a(new d().ap(str).D(j4).setErrorCode(i4).ar(str2).aq(str3).C(2L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void d(String str, long j4, String str2) {
        try {
            a(new d().ap(str).ar(str2).D(j4).C(1L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(String str, long j4, long j5, String str2) {
        try {
            a(new d().ap(str).D(j4).E(j5).ar(str2).C(3L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
