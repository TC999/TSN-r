package com.kwad.components.offline.p343c.p344a;

import com.kwad.components.offline.api.p341tk.jsbridge.IOfflineCompoTKBridgeHandler;
import com.kwad.sdk.core.webview.p422c.InterfaceC10631g;

/* renamed from: com.kwad.components.offline.c.a.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9410f implements IOfflineCompoTKBridgeHandler {
    private final InterfaceC10631g adp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9410f(InterfaceC10631g interfaceC10631g) {
        this.adp = interfaceC10631g;
    }

    @Override // com.kwad.components.offline.api.p341tk.jsbridge.IOfflineCompoTKBridgeHandler
    public final void callTKBridge(String str) {
        InterfaceC10631g interfaceC10631g = this.adp;
        if (interfaceC10631g != null) {
            interfaceC10631g.callTKBridge(str);
        }
    }
}
