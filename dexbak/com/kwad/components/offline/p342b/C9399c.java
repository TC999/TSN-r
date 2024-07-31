package com.kwad.components.offline.p342b;

import com.kwad.components.offline.api.obiwan.IObiwanLogcat;
import com.kwad.sdk.core.p397e.p398a.InterfaceC10329a;

/* renamed from: com.kwad.components.offline.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9399c implements InterfaceC10329a {
    private final IObiwanLogcat acR;

    public C9399c(IObiwanLogcat iObiwanLogcat) {
        this.acR = iObiwanLogcat;
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: d */
    public final void mo26267d(String str, String str2) {
        this.acR.mo28859d(str, str2);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: e */
    public final void mo26266e(String str, String str2) {
        this.acR.mo28858e(str, str2);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: i */
    public final void mo26265i(String str, String str2) {
        this.acR.mo28856i(str, str2);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    public final void printStackTraceOnly(Throwable th) {
        this.acR.printStackTraceOnly(th);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: v */
    public final void mo26264v(String str, String str2) {
        this.acR.mo28855v(str, str2);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: w */
    public final void mo26262w(String str, String str2) {
        this.acR.mo28853w(str, str2);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: v */
    public final void mo26263v(String str, String str2, boolean z) {
        this.acR.mo28854v(str, str2, true);
    }

    @Override // com.kwad.sdk.core.p397e.p398a.InterfaceC10329a
    /* renamed from: w */
    public final void mo26261w(String str, String str2, boolean z) {
        this.acR.mo28852w(str, str2, z);
    }
}
