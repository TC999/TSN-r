package com.kwad.sdk.commercial.p378g;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.sdk.commercial.g.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9835a {
    /* renamed from: a */
    private static void m27556a(AdTemplate adTemplate, AbstractC9822a abstractC9822a) {
        m27555a(adTemplate, false, abstractC9822a);
    }

    /* renamed from: j */
    public static void m27554j(AdTemplate adTemplate, int i, String str) {
        try {
            m27556a(adTemplate, C9836b.m27550AQ().m27548ck(1).m27549cG(str).m27547cl(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: k */
    public static void m27553k(AdTemplate adTemplate, int i, String str) {
        try {
            m27556a(adTemplate, C9836b.m27550AQ().m27548ck(2).m27549cG(str).m27547cl(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: l */
    public static void m27552l(AdTemplate adTemplate, int i, String str) {
        try {
            m27556a(adTemplate, C9836b.m27550AQ().m27548ck(4).m27549cG(str).m27547cl(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: m */
    public static void m27551m(AdTemplate adTemplate, int i, String str) {
        try {
            m27556a(adTemplate, C9836b.m27550AQ().m27548ck(5).m27549cG(str).m27547cl(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static void m27555a(AdTemplate adTemplate, boolean z, AbstractC9822a abstractC9822a) {
        abstractC9822a.setAdTemplate(adTemplate);
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(z ? 0.1d : 0.01d).m27634a(C9825d.m27624aS(adTemplate)).m27635N("ad_sdk_landing_page_performance", "status").m27625u(abstractC9822a));
    }

    /* renamed from: a */
    public static void m27557a(AdTemplate adTemplate, int i, String str, String str2) {
        try {
            m27555a(adTemplate, true, C9836b.m27550AQ().m27548ck(3).m27549cG(str).m27547cl(i).setErrorCode(100009).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27558a(AdTemplate adTemplate, int i, String str, int i2, String str2) {
        try {
            m27555a(adTemplate, true, C9836b.m27550AQ().m27548ck(6).m27549cG(str).m27547cl(i).setErrorCode(i2).setErrorMsg(str2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
