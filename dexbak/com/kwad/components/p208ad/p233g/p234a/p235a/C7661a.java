package com.kwad.components.p208ad.p233g.p234a.p235a;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.ad.g.a.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7661a implements InterfaceC10625a {

    /* renamed from: ns */
    private InterfaceC10627c f25964ns;

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f25964ns = interfaceC10627c;
    }

    /* renamed from: eE */
    public final void m32709eE() {
        InterfaceC10627c interfaceC10627c = this.f25964ns;
        if (interfaceC10627c != null) {
            interfaceC10627c.mo25251a(null);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerPlayStateResetListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f25964ns = null;
    }
}
