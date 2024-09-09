package com.kwad.components.offline.c.a;

import com.kwad.components.offline.api.tk.IOfflineTKCallHandler;
import com.kwad.sdk.components.n;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class g implements IOfflineTKCallHandler {
    private final n adq;

    public g(n nVar) {
        this.adq = nVar;
    }

    @Override // com.kwad.components.offline.api.tk.IOfflineTKCallHandler
    public final void callJS(String str) {
        n nVar = this.adq;
        if (nVar != null) {
            nVar.callJS(str);
        }
    }
}
