package com.kwad.components.p208ad.splashscreen.monitor;

import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.core.response.model.AdTemplate;

/* renamed from: com.kwad.components.ad.splashscreen.monitor.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8498c {
    /* renamed from: a */
    public static void m30547a(AdTemplate adTemplate, String str, long j, int i, String str2) {
        C9815b.m27668f(new SplashWebMonitorInfo().setEvent("webview_timeout").setSceneId("ad_splash").setDurationMs(j).setTimeType(i).setUrl(str).setErrorMsg(str2).setAdTemplate(adTemplate));
    }

    /* renamed from: af */
    public static void m30546af(AdTemplate adTemplate) {
        C9815b.m27668f(new SplashWebMonitorInfo().setEvent("ad_show").setSceneId("ad_splash").setAdTemplate(adTemplate));
    }

    /* renamed from: ag */
    public static void m30545ag(AdTemplate adTemplate) {
        C9815b.m27668f(new SplashWebMonitorInfo().setEvent("webview_init").setSceneId("ad_splash").setAdTemplate(adTemplate));
    }

    /* renamed from: b */
    public static void m30544b(AdTemplate adTemplate, String str, long j) {
        C9815b.m27668f(new SplashWebMonitorInfo().setEvent("webview_load_finish").setSceneId("ad_splash").setDurationMs(j).setUrl(str).setAdTemplate(adTemplate));
    }

    /* renamed from: d */
    public static void m30543d(String str, AdTemplate adTemplate) {
        C9815b.m27668f(new SplashWebMonitorInfo().setEvent("webview_load_url").setSceneId("ad_splash").setUrl(str).setAdTemplate(adTemplate));
    }
}
