package com.kwad.components.offline.p343c.p344a;

import com.kwad.components.offline.api.p341tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.InterfaceC9873n;

/* renamed from: com.kwad.components.offline.c.a.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9411g implements IOfflineTKCallHandler {
    private final InterfaceC9873n adq;

    public C9411g(InterfaceC9873n interfaceC9873n) {
        this.adq = interfaceC9873n;
    }

    @Override // com.kwad.components.offline.api.p341tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        InterfaceC9873n interfaceC9873n = this.adq;
        if (interfaceC9873n != null) {
            interfaceC9873n.callJS(str);
        }
    }
}
