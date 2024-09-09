package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class f implements IOfflineCompoTKBridgeHandler {
    private final com.kwad.sdk.core.webview.c.g adp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(com.kwad.sdk.core.webview.c.g gVar) {
        this.adp = gVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoTKBridgeHandler
    public final void callTKBridge(String str) {
        com.kwad.sdk.core.webview.c.g gVar = this.adp;
        if (gVar != null) {
            gVar.callTKBridge(str);
        }
    }
}
