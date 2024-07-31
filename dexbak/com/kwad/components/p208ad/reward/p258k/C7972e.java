package com.kwad.components.p208ad.reward.p258k;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.ad.reward.k.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7972e implements InterfaceC10625a {

    /* renamed from: xf */
    private InterfaceC7973a f26685xf;

    /* renamed from: com.kwad.components.ad.reward.k.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC7973a {
        /* renamed from: iW */
        void mo31346iW();
    }

    /* renamed from: a */
    public final void m31910a(InterfaceC7973a interfaceC7973a) {
        this.f26685xf = interfaceC7973a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "clickGift";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f26685xf = null;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        InterfaceC7973a interfaceC7973a = this.f26685xf;
        if (interfaceC7973a != null) {
            interfaceC7973a.mo31346iW();
        }
    }
}
