package com.kwad.components.offline.p343c.p344a;

import com.kwad.components.offline.api.p341tk.IOfflineTKRenderListener;
import com.kwad.sdk.components.InterfaceC9875p;

/* renamed from: com.kwad.components.offline.c.a.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9412h implements IOfflineTKRenderListener {
    private final InterfaceC9875p adr;

    public C9412h(InterfaceC9875p interfaceC9875p) {
        this.adr = interfaceC9875p;
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineTKRenderListener
    public final void onFailed(Throwable th) {
        InterfaceC9875p interfaceC9875p = this.adr;
        if (interfaceC9875p != null) {
            interfaceC9875p.onFailed(th);
        }
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineTKRenderListener
    public final void onSuccess() {
        InterfaceC9875p interfaceC9875p = this.adr;
        if (interfaceC9875p != null) {
            interfaceC9875p.onSuccess();
        }
    }
}
