package com.kwad.sdk.commercial.p377f;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.sdk.commercial.f.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9833a {
    /* renamed from: a */
    private static void m27569a(AdTemplate adTemplate, AbstractC9822a abstractC9822a) {
        m27568a(adTemplate, false, abstractC9822a);
    }

    /* renamed from: d */
    public static void m27567d(AdTemplate adTemplate, String str, String str2) {
        try {
            m27568a(adTemplate, true, C9834b.m27561AP().m27559cj(6).m27560cF(str).setErrorCode(100007).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: f */
    public static void m27566f(AdTemplate adTemplate, String str) {
        try {
            m27569a(adTemplate, C9834b.m27561AP().m27559cj(1).m27560cF(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: g */
    public static void m27565g(AdTemplate adTemplate, String str) {
        try {
            m27569a(adTemplate, C9834b.m27561AP().m27559cj(2).m27560cF(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: h */
    public static void m27564h(AdTemplate adTemplate, String str) {
        try {
            m27569a(adTemplate, C9834b.m27561AP().m27559cj(3).m27560cF(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: i */
    public static void m27563i(AdTemplate adTemplate, String str) {
        try {
            m27569a(adTemplate, C9834b.m27561AP().m27559cj(4).m27560cF(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: j */
    public static void m27562j(AdTemplate adTemplate, String str) {
        try {
            m27569a(adTemplate, C9834b.m27561AP().m27559cj(5).m27560cF(str));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static void m27568a(AdTemplate adTemplate, boolean z, AbstractC9822a abstractC9822a) {
        abstractC9822a.setAdTemplate(adTemplate);
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(z ? 0.1d : 0.01d).m27634a(C9825d.m27624aS(adTemplate)).m27635N("ad_sdk_deeplink_performance", "status").m27625u(abstractC9822a));
    }
}
