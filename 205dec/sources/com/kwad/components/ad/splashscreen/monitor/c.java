package com.kwad.components.ad.splashscreen.monitor;

import com.kwad.sdk.core.response.model.AdTemplate;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c {
    public static void a(AdTemplate adTemplate, String str, long j4, int i4, String str2) {
        com.kwad.sdk.commercial.b.f(new SplashWebMonitorInfo().setEvent("webview_timeout").setSceneId("ad_splash").setDurationMs(j4).setTimeType(i4).setUrl(str).setErrorMsg(str2).setAdTemplate(adTemplate));
    }

    public static void af(AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.f(new SplashWebMonitorInfo().setEvent("ad_show").setSceneId("ad_splash").setAdTemplate(adTemplate));
    }

    public static void ag(AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.f(new SplashWebMonitorInfo().setEvent("webview_init").setSceneId("ad_splash").setAdTemplate(adTemplate));
    }

    public static void b(AdTemplate adTemplate, String str, long j4) {
        com.kwad.sdk.commercial.b.f(new SplashWebMonitorInfo().setEvent("webview_load_finish").setSceneId("ad_splash").setDurationMs(j4).setUrl(str).setAdTemplate(adTemplate));
    }

    public static void d(String str, AdTemplate adTemplate) {
        com.kwad.sdk.commercial.b.f(new SplashWebMonitorInfo().setEvent("webview_load_url").setSceneId("ad_splash").setUrl(str).setAdTemplate(adTemplate));
    }
}
