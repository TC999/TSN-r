package com.kwad.components.core.p304n.p316c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.C11160a;

/* renamed from: com.kwad.components.core.n.c.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8762a {
    /* renamed from: a */
    private static void m29947a(C8763b c8763b) {
        m29946a(c8763b, false);
    }

    /* renamed from: b */
    public static void m29943b(String str, long j, int i) {
        try {
            m29947a(new C8763b().m29935am(str).m29936B(j).m29932aw(i).m29937A(2L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: c */
    public static void m29941c(String str, long j) {
        try {
            m29947a(new C8763b().m29935am(str).m29936B(j).m29937A(1L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: d */
    public static void m29938d(String str, long j) {
        try {
            m29947a(new C8763b().m29935am(str).m29936B(j).m29937A(6L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    private static void m29946a(C8763b c8763b, boolean z) {
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).m27628i(z ? 1.0d : 0.01d).m27635N("ad_sdk_offline_component_monitor", "load_status").m27625u(c8763b).m27632a(C11160a.aTL));
    }

    /* renamed from: c */
    public static void m29939c(String str, long j, String str2) {
        try {
            m29947a(new C8763b().m29935am(str).m29936B(j).m29933ao(str2).m29937A(4L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: b */
    public static void m29942b(String str, long j, String str2) {
        try {
            m29947a(new C8763b().m29935am(str).m29936B(j).m29933ao(str2).m29937A(3L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m29945a(String str, long j, int i, String str2, String str3) {
        try {
            m29946a(new C8763b().m29935am(str).m29936B(j).setErrorCode(i).m29933ao(str3).m29934an(str2).m29937A(7L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: c */
    public static void m29940c(String str, long j, int i) {
        try {
            m29947a(new C8763b().m29935am(str).m29937A(8L).m29932aw(i).m29936B(j));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m29944a(String str, long j, String str2) {
        try {
            m29947a(new C8763b().m29935am(str).m29933ao(str2).m29936B(j).m29937A(5L));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
