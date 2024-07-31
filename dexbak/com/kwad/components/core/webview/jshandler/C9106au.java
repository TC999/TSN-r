package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.jshandler.au */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9106au implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29199VX;

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29199VX = interfaceC10627c;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerDeeplinkListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29199VX = null;
    }

    public final void onFailed() {
        InterfaceC10627c interfaceC10627c = this.f29199VX;
        if (interfaceC10627c != null) {
            interfaceC10627c.onError(-1, "deep link error");
        }
    }

    public final void onSuccess() {
        InterfaceC10627c interfaceC10627c = this.f29199VX;
        if (interfaceC10627c != null) {
            interfaceC10627c.mo25251a(null);
        }
    }
}
