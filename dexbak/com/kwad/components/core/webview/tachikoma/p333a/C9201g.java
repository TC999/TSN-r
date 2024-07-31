package com.kwad.components.core.webview.tachikoma.p333a;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.p334b.C9250k;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.tachikoma.a.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9201g implements InterfaceC10625a {

    /* renamed from: ZG */
    private C9250k f29290ZG;

    public C9201g(C9250k c9250k) {
        this.f29290ZG = c9250k;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9250k c9250k = this.f29290ZG;
        if (c9250k != null) {
            interfaceC10627c.mo25251a(c9250k);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getKsAdExtraData";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
