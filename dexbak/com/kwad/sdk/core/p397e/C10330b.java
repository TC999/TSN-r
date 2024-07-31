package com.kwad.sdk.core.p397e;

import android.util.Log;
import com.kwad.sdk.core.p397e.p398a.InterfaceC10329a;

/* renamed from: com.kwad.sdk.core.e.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
final class C10330b implements InterfaceC10329a {
    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: d */
    public final void mo26267d(String str, String str2) {
        if (C10331c.avj && C10328a.f29548md.booleanValue()) {
            Log.d(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: e */
    public final void mo26266e(String str, String str2) {
        if (C10331c.avj) {
            Log.e(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: i */
    public final void mo26265i(String str, String str2) {
        if (C10331c.avj) {
            Log.i(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    public final void printStackTraceOnly(Throwable th) {
        if (C10331c.avj && C10328a.f29548md.booleanValue() && th != null) {
            th.printStackTrace();
        }
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: v */
    public final void mo26264v(String str, String str2) {
        if (C10331c.avj && C10328a.f29548md.booleanValue()) {
            Log.v(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: w */
    public final void mo26262w(String str, String str2) {
        if (C10331c.avj) {
            Log.w(str, str2);
        }
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: v */
    public final void mo26263v(String str, String str2, boolean z) {
        Log.v(str, str2);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: w */
    public final void mo26261w(String str, String str2, boolean z) {
        if (z) {
            Log.w(str, str2);
        }
    }
}
