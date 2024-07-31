package com.kwad.sdk;

import com.kwad.components.offline.api.core.api.ILoggerReporter;
import com.kwad.sdk.commercial.C9815b;
import com.kwad.sdk.commercial.model.SDKInitMsg;
import com.kwad.sdk.utils.AbstractRunnableC11033ay;
import com.kwad.sdk.utils.C11095g;
import com.kwai.adclient.kscommerciallogger.model.C11160a;
import com.kwai.adclient.kscommerciallogger.model.C11164d;

/* renamed from: com.kwad.sdk.l */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10848l {
    private static int alh;

    /* renamed from: Y */
    public static void m24646Y(long j) {
        final long currentTimeMillis = j > 0 ? System.currentTimeMillis() - j : -1L;
        alh++;
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.l.1
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9815b.m27688a(ILoggerReporter.Category.APM_LOG, C11160a.aTJ, new SDKInitMsg().setLaunchIntervalTime(currentTimeMillis).setInitCount(C10848l.alh).setInitStatus(0));
            }
        });
    }

    /* renamed from: Z */
    public static void m24645Z(final long j) {
        if (j > 10000) {
            j = -1;
        }
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.l.2
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9815b.m27688a(ILoggerReporter.Category.APM_LOG, C11160a.aTJ, new SDKInitMsg().setTotalDurationTime(j).setInitCount(C10848l.alh).setInitStatus(1));
            }
        });
    }

    /* renamed from: a */
    public static void m24644a(final C11164d c11164d, final String str) {
        C11095g.execute(new AbstractRunnableC11033ay() { // from class: com.kwad.sdk.l.3
            @Override // com.kwad.sdk.utils.AbstractRunnableC11033ay
            public final void doTask() {
                C9815b.m27688a(ILoggerReporter.Category.ERROR_LOG, C11164d.this, new SDKInitMsg().setInitCount(C10848l.alh).setErrorReason(str).setInitStatus(2));
            }
        });
    }
}
