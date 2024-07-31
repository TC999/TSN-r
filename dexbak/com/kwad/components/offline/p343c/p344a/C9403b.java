package com.kwad.components.offline.p343c.p344a;

import androidx.annotation.NonNull;
import com.kwad.components.offline.api.p341tk.jsbridge.IOfflineCompoBridgeHandler;
import com.kwad.components.offline.api.p341tk.jsbridge.IOfflineCompoCallBackFunction;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.utils.C11023ap;

/* renamed from: com.kwad.components.offline.c.a.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9403b implements IOfflineCompoBridgeHandler {
    private final InterfaceC10625a adi;

    public C9403b(InterfaceC10625a interfaceC10625a) {
        C11023ap.checkNotNull(interfaceC10625a);
        this.adi = interfaceC10625a;
    }

    @Override // com.kwad.components.offline.api.p341tk.jsbridge.IOfflineCompoBridgeHandler
    @NonNull
    public final String getKey() {
        return this.adi.getKey();
    }

    @Override // com.kwad.components.offline.api.p341tk.jsbridge.IOfflineCompoBridgeHandler
    public final void handleJsCall(String str, @NonNull IOfflineCompoCallBackFunction iOfflineCompoCallBackFunction) {
        this.adi.mo25241a(str, new C9402a(iOfflineCompoCallBackFunction));
    }

    @Override // com.kwad.components.offline.api.p341tk.jsbridge.IOfflineCompoBridgeHandler
    public final void onDestroy() {
        this.adi.onDestroy();
    }
}
