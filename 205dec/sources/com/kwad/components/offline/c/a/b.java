package com.kwad.components.offline.c.a;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler;
import com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.utils.ap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class b implements IOfflineCompoBridgeHandler {
    private final com.kwad.sdk.core.webview.c.a adi;

    public b(com.kwad.sdk.core.webview.c.a aVar) {
        ap.checkNotNull(aVar);
        this.adi = aVar;
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    @NonNull
    public final String getKey() {
        return this.adi.getKey();
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final void handleJsCall(String str, @NonNull IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.adi.a(str, new a(iOfflineCompoCallBackFunction));
    }

    @Override // com.kwad.components.offline.api.tk.jsbridge.IOfflineCompoBridgeHandler
    public final void onDestroy() {
        this.adi.onDestroy();
    }
}
