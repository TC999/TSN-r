package com.kwad.sdk.commercial.p375d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.sdk.commercial.d.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9828c {
    /* renamed from: a */
    private static void m27590a(AdTemplate adTemplate, AbstractC9822a abstractC9822a) {
        abstractC9822a.setAdTemplate(adTemplate);
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.001d).m27634a(C9825d.m27624aS(adTemplate)).m27635N("ad_convert_method_call", "method_name").m27625u(abstractC9822a));
    }

    /* renamed from: by */
    public static void m27589by(AdTemplate adTemplate) {
        try {
            m27590a(adTemplate, C9827b.m27596AM().m27592cy("callShow"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: bz */
    public static void m27588bz(AdTemplate adTemplate) {
        try {
            m27590a(adTemplate, C9827b.m27596AM().m27592cy("adShowSuccess"));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
