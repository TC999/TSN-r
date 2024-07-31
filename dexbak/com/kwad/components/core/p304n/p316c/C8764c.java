package com.kwad.components.core.p304n.p316c;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.C9821c;
import com.kwad.sdk.service.ServiceProvider;
import com.kwai.adclient.kscommerciallogger.model.C11160a;

/* renamed from: com.kwad.components.core.n.c.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8764c {
    /* renamed from: a */
    private static void m29930a(C8765d c8765d, boolean z) {
        C9815b.m27672d(C9821c.m27636AJ().m27631cu(z ? ILoggerReporter.Category.ERROR_LOG : ILoggerReporter.Category.APM_LOG).m27628i(z ? 1.0d : 0.01d).m27635N("ad_sdk_offline_component_update", "load_status").m27625u(c8765d).m27632a(C11160a.aTL));
    }

    /* renamed from: b */
    public static void m29928b(String str, long j, int i, String str2, String str3) {
        try {
            m29930a(new C8765d().m29923ap(str).m29925D(j).setErrorCode(i).m29921ar(str2).m29922aq(str3).m29926C(2L), true);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: d */
    public static void m29927d(String str, long j, String str2) {
        try {
            m29930a(new C8765d().m29923ap(str).m29921ar(str2).m29925D(j).m29926C(1L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }

    /* renamed from: a */
    public static void m29929a(String str, long j, long j2, String str2) {
        try {
            m29930a(new C8765d().m29923ap(str).m29925D(j).m29924E(j2).m29921ar(str2).m29926C(3L), false);
        } catch (Throwable th) {
            ServiceProvider.reportSdkCaughtException(th);
        }
    }
}
