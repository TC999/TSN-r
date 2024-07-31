package com.kwad.sdk.commercial.p375d;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.commercial.C9825d;
import com.kwad.sdk.commercial.p374c.AbstractC9822a;
import com.kwad.sdk.internal.api.SceneImpl;
import com.kwad.sdk.service.ServiceProvider;

/* renamed from: com.kwad.sdk.commercial.d.d */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9829d {
    /* renamed from: a */
    private static void m27585a(SceneImpl sceneImpl, AbstractC9822a abstractC9822a) {
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.APM_LOG).m27628i(0.001d).m27634a(C9825d.m27622ca(sceneImpl.getAdStyle())).m27635N("ad_convert_method_call", "method_name").m27625u(abstractC9822a));
    }

    /* renamed from: b */
    public static void m27583b(SceneImpl sceneImpl) {
        try {
            m27585a(sceneImpl, C9827b.m27596AM().m27592cy("loadRequest").m27593ci(sceneImpl.getAdNum()).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: b */
    public static void m27582b(SceneImpl sceneImpl, String str) {
        try {
            m27585a(sceneImpl, C9827b.m27596AM().m27592cy("requestStart").m27593ci(sceneImpl.getAdNum()).m27591cz(str).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27584a(SceneImpl sceneImpl, String str, String str2) {
        try {
            m27585a(sceneImpl, C9827b.m27596AM().m27592cy("requestFinish").m27593ci(sceneImpl.getAdNum()).m27591cz(str).m27594cA(str2).setPosId(sceneImpl.getPosId()));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27586a(SceneImpl sceneImpl, int i) {
        try {
            m27585a(sceneImpl, C9827b.m27596AM().m27592cy("dataReady").m27593ci(i));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m27587a(int i, int i2, String str, String str2) {
        try {
            C9815b.m27672d(C9821c.m27636AJ().m27631cu(ILoggerReporter.Category.ERROR_LOG).m27628i(1.0d).m27634a(C9825d.m27622ca(i)).m27635N("ad_convert_method_call", "method_name").m27625u(C9827b.m27596AM().m27592cy("requestError").m27591cz(str2).setErrorCode(C9825d.m27621cb(i2)).setErrorMsg(str)));
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
