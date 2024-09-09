package com.kwad.sdk.core.e;

import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
final class b implements com.kwad.sdk.core.e.a.a {
    @Override // com.kwad.sdk.core.e.a.a
    public final void d(String str, String str2) {
        if (c.avj && a.md.booleanValue()) {
            Log.d(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void e(String str, String str2) {
        if (c.avj) {
            Log.e(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void i(String str, String str2) {
        if (c.avj) {
            Log.i(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void printStackTraceOnly(Throwable th) {
        if (c.avj && a.md.booleanValue() && th != null) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2) {
        if (c.avj && a.md.booleanValue()) {
            Log.v(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2) {
        if (c.avj) {
            Log.w(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void v(String str, String str2, boolean z3) {
        Log.v(str, str2);
    }

    @Override // com.kwad.sdk.core.e.a.a
    public final void w(String str, String str2, boolean z3) {
        if (z3) {
            Log.w(str, str2);
        }
    }
}
