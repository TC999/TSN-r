package com.kwad.sdk.commercial.d;

import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class d {
    private static void a(SceneImpl sceneImpl, com.kwad.sdk.commercial.c.a aVar) {
        com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu("ad_client_apm_log").i(0.001d).a(com.kwad.sdk.commercial.d.ca(sceneImpl.getAdStyle())).N("ad_convert_method_call", "method_name").u(aVar));
    }

    public static void b(SceneImpl sceneImpl) {
        try {
            a(sceneImpl, b.AM().cy("loadRequest").ci(sceneImpl.getAdNum()).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void b(SceneImpl sceneImpl, String str) {
        try {
            a(sceneImpl, b.AM().cy("requestStart").ci(sceneImpl.getAdNum()).cz(str).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, String str, String str2) {
        try {
            a(sceneImpl, b.AM().cy("requestFinish").ci(sceneImpl.getAdNum()).cz(str).cA(str2).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(SceneImpl sceneImpl, int i4) {
        try {
            a(sceneImpl, b.AM().cy("dataReady").ci(i4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    public static void a(int i4, int i5, String str, String str2) {
        try {
            com.kwad.sdk.commercial.b.d(com.kwad.sdk.commercial.c.AJ().cu("ad_client_error_log").i(1.0d).a(com.kwad.sdk.commercial.d.ca(i4)).N("ad_convert_method_call", "method_name").u(b.AM().cy("requestError").cz(str2).setErrorCode(com.kwad.sdk.commercial.d.cb(i5)).setErrorMsg(str)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
