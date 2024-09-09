package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class au implements com.kwad.sdk.core.webview.c.a {
    private com.kwad.sdk.core.webview.c.c VX;

    @Override // com.kwad.sdk.core.webview.c.a
    public final void a(String str, @NonNull com.kwad.sdk.core.webview.c.c cVar) {
        this.VX = cVar;
    }

    @Override // com.kwad.sdk.core.webview.c.a
    @NonNull
    public final String getKey() {
        return "registerDeeplinkListener";
    }

    @Override // com.kwad.sdk.core.webview.c.a
    public final void onDestroy() {
        this.VX = null;
    }

    public final void onFailed() {
        com.kwad.sdk.core.webview.c.c cVar = this.VX;
        if (cVar != null) {
            cVar.onError(-1, "deep link error");
        }
    }

    public final void onSuccess() {
        com.kwad.sdk.core.webview.c.c cVar = this.VX;
        if (cVar != null) {
            cVar.a(null);
        }
    }
}
