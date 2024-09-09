package com.kwad.sdk.commercial.d;

import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    private static void a(AdTemplate adTemplate, com.kwad.sdk.commercial.c.a aVar) {
        aVar.setAdTemplate(adTemplate);
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu("ad_client_apm_log").i(0.001d).a(com.kwad.sdk.commercial.d.aS(adTemplate)).N("ad_convert_method_call", "method_name").u(aVar));
    }

    public static void by(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("callShow"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void bz(AdTemplate adTemplate) {
        try {
            a(adTemplate, b.AM().cy("adShowSuccess"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
