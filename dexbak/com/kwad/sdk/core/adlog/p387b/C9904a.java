package com.kwad.sdk.core.adlog.p387b;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.core.adlog.p386a.C9895a;
import com.kwad.sdk.core.adlog.p386a.C9900c;
import com.kwad.sdk.core.adlog.p388c.C9912a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.sdk.core.adlog.b.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9904a {
    /* renamed from: a */
    private static void m27389a(C9895a c9895a, C9900c c9900c, C9905b c9905b) {
        m27388a(c9895a, c9900c, false, c9905b);
    }

    /* renamed from: b */
    public static void m27387b(C9895a c9895a, C9900c c9900c, int i) {
        try {
            m27389a(c9895a, c9900c, C9905b.m27382Bp().m27378cs(2).m27373cx(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: c */
    public static void m27385c(C9895a c9895a, C9900c c9900c, int i) {
        try {
            m27388a(c9895a, c9900c, true, C9905b.m27382Bp().m27378cs(3).m27373cx(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: d */
    public static void m27384d(C9895a c9895a, C9900c c9900c, int i) {
        try {
            m27389a(c9895a, c9900c, C9905b.m27382Bp().m27378cs(4).m27373cx(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: e */
    public static void m27383e(C9895a c9895a, C9900c c9900c, int i) {
        try {
            m27388a(c9895a, c9900c, true, C9905b.m27382Bp().m27378cs(7).m27373cx(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static void m27388a(C9895a c9895a, C9900c c9900c, boolean z, C9905b c9905b) {
        C9912a c9912a = c9895a.apr;
        AdTemplate adTemplate = c9912a.adTemplate;
        c9905b.m27377ct(c9912a.aoM).m27376cu(c9895a.retryCount).m27375cv(c9895a.apt).m27379cZ(c9895a.apu).m27374cw(c9900c.apC).setAdTemplate(adTemplate);
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(z ? 1.0d : 0.1d).m27634a(C9825d.m27624aS(adTemplate)).m27635N("ad_sdk_adlog_retry", "status").m27625u(c9905b));
    }

    /* renamed from: b */
    public static void m27386b(C9895a c9895a, C9900c c9900c, int i, long j) {
        try {
            m27388a(c9895a, c9900c, true, C9905b.m27382Bp().m27378cs(6).m27373cx(i).m27381ae(j));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27391a(C9895a c9895a, C9900c c9900c, int i) {
        try {
            m27389a(c9895a, c9900c, C9905b.m27382Bp().m27378cs(1).m27373cx(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27390a(C9895a c9895a, C9900c c9900c, int i, long j) {
        try {
            m27389a(c9895a, c9900c, C9905b.m27382Bp().m27378cs(5).m27373cx(i).m27381ae(j));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
