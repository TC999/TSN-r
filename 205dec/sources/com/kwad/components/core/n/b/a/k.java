package com.kwad.components.core.n.b.a;

import com.kwad.components.offline.api.core.api.IOfflineCompoLogcat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class k implements IOfflineCompoLogcat {
    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void d(String str, String str2) {
        com.kwad.sdk.core.e.c.d(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void e(String str, String str2) {
        com.kwad.sdk.core.e.c.e(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void i(String str, String str2) {
        com.kwad.sdk.core.e.c.i(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.IOfflineCompoLogcat
    public final boolean isLoggable() {
        return com.kwad.sdk.core.e.c.avj;
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTrace(Throwable th) {
        com.kwad.sdk.core.e.c.printStackTrace(th);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void printStackTraceOnly(Throwable th) {
        com.kwad.sdk.core.e.c.printStackTraceOnly(th);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void v(String str, String str2) {
        com.kwad.sdk.core.e.c.v(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void w(String str, String str2) {
        com.kwad.sdk.core.e.c.w(str, str2);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void e(String str, String str2, Throwable th) {
        com.kwad.sdk.core.e.c.e(str, str2, th);
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void v(String str, String str2, boolean z3) {
        if (z3) {
            com.kwad.sdk.core.e.c.T(str, str2);
        } else {
            com.kwad.sdk.core.e.c.v(str, str2);
        }
    }

    @Override // com.kwad.components.offline.api.core.api.ILogcat
    public final void w(String str, String str2, boolean z3) {
        if (z3 || com.kwad.components.core.a.md.booleanValue()) {
            com.kwad.sdk.core.e.c.w(str, str2);
        }
    }
}
