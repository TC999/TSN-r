package com.kwad.sdk.commercial.p372a;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.sdk.commercial.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9813a {
    /* renamed from: a */
    private static void m27718a(AdTemplate adTemplate, AbstractC9822a abstractC9822a) {
        m27717a(adTemplate, false, abstractC9822a);
    }

    /* renamed from: aU */
    public static void m27716aU(AdTemplate adTemplate) {
        m27718a(adTemplate, C9814b.m27705AK().m27702cc(3).setAdTemplate(adTemplate));
    }

    /* renamed from: aV */
    public static void m27715aV(AdTemplate adTemplate) {
        m27718a(adTemplate, C9814b.m27705AK().m27702cc(4).setAdTemplate(adTemplate));
    }

    /* renamed from: aW */
    public static void m27714aW(AdTemplate adTemplate) {
        m27718a(adTemplate, C9814b.m27705AK().m27702cc(5).setAdTemplate(adTemplate));
    }

    /* renamed from: aX */
    public static void m27713aX(AdTemplate adTemplate) {
        m27709h(adTemplate, 100002, "");
    }

    /* renamed from: aY */
    public static void m27712aY(AdTemplate adTemplate) {
        m27718a(adTemplate, C9814b.m27705AK().m27702cc(7).m27701cd(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate));
    }

    /* renamed from: aZ */
    public static void m27711aZ(AdTemplate adTemplate) {
        m27718a(adTemplate, C9814b.m27705AK().m27702cc(8).m27701cd(adTemplate.mInstallApkFormUser ? 1 : 2).m27700ce(adTemplate.mInstallApkFromSDK ? 1 : adTemplate.mClickOpenAppStore ? 2 : 0).setAdTemplate(adTemplate));
    }

    /* renamed from: ba */
    public static void m27710ba(AdTemplate adTemplate) {
        m27718a(adTemplate, C9814b.m27705AK().m27702cc(10).m27700ce(adTemplate.mInstallApkFromSDK ? 1 : adTemplate.mClickOpenAppStore ? 2 : 0).setAdTemplate(adTemplate));
    }

    /* renamed from: h */
    public static void m27709h(AdTemplate adTemplate, int i, String str) {
        m27717a(adTemplate, true, C9814b.m27705AK().m27702cc(6).setAdTemplate(adTemplate).setErrorCode(i).setErrorMsg(str));
    }

    /* renamed from: i */
    public static void m27708i(AdTemplate adTemplate, int i, String str) {
        m27717a(adTemplate, true, C9814b.m27705AK().m27702cc(9).m27701cd(adTemplate.mInstallApkFormUser ? 1 : 2).setAdTemplate(adTemplate).setErrorCode(100003).setErrorMsg(str));
    }

    /* renamed from: j */
    public static void m27707j(AdTemplate adTemplate, long j) {
        m27718a(adTemplate, C9814b.m27705AK().m27702cc(2).m27704ac(j).setAdTemplate(adTemplate));
    }

    /* renamed from: o */
    public static void m27706o(AdTemplate adTemplate) {
        m27718a(adTemplate, C9814b.m27705AK().m27702cc(1).setAdTemplate(adTemplate));
    }

    /* renamed from: a */
    private static void m27717a(AdTemplate adTemplate, boolean z, AbstractC9822a abstractC9822a) {
        try {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).m27628i(z ? 1.0d : 0.1d).m27634a(C9825d.m27624aS(adTemplate)).m27635N("ad_sdk_download_performance", "status").m27625u(abstractC9822a));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
