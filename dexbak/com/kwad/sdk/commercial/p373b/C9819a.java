package com.kwad.sdk.commercial.p373b;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.sdk.commercial.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9819a {
    /* renamed from: a */
    private static void m27647a(AdTemplate adTemplate, AbstractC9822a abstractC9822a) {
        m27644a(adTemplate, false, abstractC9822a);
    }

    /* renamed from: b */
    public static void m27643b(AdTemplate adTemplate, String str, String str2, int i, int i2) {
        try {
            m27647a(adTemplate, C9820b.m27642AL().m27641cf(2).m27638cw(str).m27637cx(str2).m27639ch(i).m27640cg(i2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static void m27644a(AdTemplate adTemplate, boolean z, AbstractC9822a abstractC9822a) {
        abstractC9822a.setAdTemplate(adTemplate);
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(z ? 0.1d : 0.01d).m27634a(C9825d.m27624aS(adTemplate)).m27635N("ad_sdk_appstore_performance", "status").m27625u(abstractC9822a));
    }

    /* renamed from: a */
    public static void m27646a(AdTemplate adTemplate, String str, String str2, int i, int i2) {
        try {
            m27647a(adTemplate, C9820b.m27642AL().m27641cf(1).m27638cw(str).m27637cx(str2).m27639ch(i).m27640cg(i2));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27645a(AdTemplate adTemplate, String str, String str2, int i, int i2, String str3) {
        try {
            m27644a(adTemplate, true, C9820b.m27642AL().m27641cf(4).m27638cw(str).m27637cx(str2).m27639ch(i).m27640cg(i2).setErrorCode(100006).setErrorMsg(str3));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
