package com.kwad.sdk.core.adlog.p387b;

import androidx.annotation.Nullable;
import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.core.adlog.p386a.C9895a;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.sdk.core.adlog.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9906c {
    /* renamed from: a */
    private static void m27370a(AdTemplate adTemplate, @Nullable C9895a c9895a, C9907d c9907d) {
        m27369a(adTemplate, c9895a, false, c9907d);
    }

    /* renamed from: b */
    public static void m27368b(AdTemplate adTemplate, int i, C9895a c9895a) {
        try {
            m27370a(adTemplate, c9895a, C9907d.m27364Bq().m27359cy(2).m27358cz(i).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: c */
    public static void m27366c(AdTemplate adTemplate, int i, String str, int i2, String str2, C9895a c9895a) {
        try {
            m27369a(adTemplate, c9895a, true, C9907d.m27364Bq().m27359cy(4).m27358cz(i).m27357da(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: d */
    public static void m27365d(AdTemplate adTemplate, int i, String str, int i2, String str2, C9895a c9895a) {
        try {
            m27369a(adTemplate, c9895a, true, C9907d.m27364Bq().m27359cy(3).m27358cz(i).m27357da(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static void m27369a(AdTemplate adTemplate, @Nullable C9895a c9895a, boolean z, C9907d c9907d) {
        if (c9895a != null) {
            c9907d.m27362cA(1).m27361cB(c9895a.retryCount);
        }
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).m27628i(z ? 0.01d : 1.0E-4d).m27627j(z ? 1.0d : 0.01d).m27634a(C9825d.m27624aS(adTemplate)).m27635N("ad_sdk_adlog_performance", "status").m27625u(c9907d));
    }

    /* renamed from: b */
    public static void m27367b(AdTemplate adTemplate, int i, String str, int i2, String str2, C9895a c9895a) {
        try {
            m27369a(adTemplate, c9895a, true, C9907d.m27364Bq().m27359cy(5).m27358cz(i).m27357da(str).setErrorCode(i2).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27372a(AdTemplate adTemplate, int i, C9895a c9895a) {
        try {
            m27370a(adTemplate, c9895a, C9907d.m27364Bq().m27359cy(1).m27358cz(i).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27371a(AdTemplate adTemplate, int i, String str, int i2, String str2, C9895a c9895a) {
        try {
            m27370a(adTemplate, c9895a, C9907d.m27364Bq().m27359cy(5).m27358cz(i).m27357da(str).setErrorCode(100004).setErrorMsg(str2).setAdTemplate(adTemplate));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
