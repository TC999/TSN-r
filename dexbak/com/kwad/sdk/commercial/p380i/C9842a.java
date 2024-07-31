package com.kwad.sdk.commercial.p380i;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.sdk.commercial.i.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9842a {
    /* renamed from: a */
    private static void m27543a(AdTemplate adTemplate, AbstractC9822a abstractC9822a) {
        m27540a(adTemplate, false, abstractC9822a);
    }

    /* renamed from: b */
    public static void m27539b(AdTemplate adTemplate, String str, String str2, String str3) {
        try {
            m27543a(adTemplate, C9843b.m27537AT().m27533cm(2).m27534cK(str).m27535cJ(str2).m27536cI(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: c */
    public static void m27538c(AdTemplate adTemplate, String str, String str2, String str3) {
        try {
            m27543a(adTemplate, C9843b.m27537AT().m27533cm(3).m27534cK(str).m27535cJ(str2).m27536cI(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static void m27540a(AdTemplate adTemplate, boolean z, AbstractC9822a abstractC9822a) {
        abstractC9822a.setAdTemplate(adTemplate);
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(z ? 0.1d : 0.01d).m27634a(C9825d.m27624aS(adTemplate)).m27635N("ad_sdk_small_app_performance", "status").m27625u(abstractC9822a));
    }

    /* renamed from: a */
    public static void m27542a(AdTemplate adTemplate, String str, String str2, String str3) {
        try {
            m27543a(adTemplate, C9843b.m27537AT().m27533cm(1).m27534cK(str).m27535cJ(str2).m27536cI(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27541a(AdTemplate adTemplate, String str, String str2, String str3, String str4) {
        try {
            m27540a(adTemplate, true, C9843b.m27537AT().m27533cm(4).m27534cK(str).m27535cJ(str2).m27536cI(str3).setErrorCode(100008).setErrorMsg(str4));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
