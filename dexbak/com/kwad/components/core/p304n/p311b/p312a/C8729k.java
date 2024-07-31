package com.kwad.components.core.p304n.p311b.p312a;

import com.kwad.components.core.C8526a;
import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;
import com.kwad.sdk.core.p397e.C10331c;

/* renamed from: com.kwad.components.core.n.b.a.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C8729k implements IOfflineCompoLogcat {
    @Override // com.kwad.components.offline.api.core.api.ILogcat
    /* renamed from: d */
    public final void mo28859d(String str, String str2) {
        C10331c.m26254d(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    /* renamed from: e */
    public final void mo28858e(String str, String str2) {
        C10331c.m26250e(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    /* renamed from: i */
    public final void mo28856i(String str, String str2) {
        C10331c.m26248i(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoLogcat
    public final boolean isLoggable() {
        return C10331c.avj;
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTrace(Throwable th) {
        C10331c.printStackTrace(th);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTraceOnly(Throwable th) {
        C10331c.printStackTraceOnly(th);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    /* renamed from: v */
    public final void mo28855v(String str, String str2) {
        C10331c.m26247v(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    /* renamed from: w */
    public final void mo28853w(String str, String str2) {
        C10331c.m26246w(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    /* renamed from: e */
    public final void mo28857e(String str, String str2, Throwable th) {
        C10331c.m26249e(str, str2, th);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    /* renamed from: v */
    public final void mo28854v(String str, String str2, boolean z) {
        if (z) {
            C10331c.m26257T(str, str2);
        } else {
            C10331c.m26247v(str, str2);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    /* renamed from: w */
    public final void mo28852w(String str, String str2, boolean z) {
        if (z || C8526a.f28050md.booleanValue()) {
            C10331c.m26246w(str, str2);
        }
    }
}
