package com.kwad.components.offline.b;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class c implements com.kwad.sdk.core.e.a.a {
    private final IObiwanLogcat acR;

    public c(IObiwanLogcat iObiwanLogcat) {
        this.acR = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void d(String str, String str2) {
        this.acR.d(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void e(String str, String str2) {
        this.acR.e(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void i(String str, String str2) {
        this.acR.i(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void printStackTraceOnly(Throwable th) {
        this.acR.printStackTraceOnly(th);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2) {
        this.acR.v(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2) {
        this.acR.w(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2, boolean z3) {
        this.acR.v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2, boolean z3) {
        this.acR.w(str, str2, z3);
    }
}
