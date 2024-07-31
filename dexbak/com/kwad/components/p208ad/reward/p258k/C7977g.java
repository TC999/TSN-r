package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import com.kwad.components.core.webview.tachikoma.p334b.C9245f;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.ad.reward.k.g */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7977g implements InterfaceC10625a {

    /* renamed from: xj */
    private int f26689xj;

    public C7977g(int i) {
        this.f26689xj = i;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        C9245f c9245f = new C9245f();
        c9245f.aai = this.f26689xj;
        interfaceC10627c.mo25251a(c9245f);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getCloseDelaySeconds";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
