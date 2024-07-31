package com.kwad.components.core.webview.tachikoma;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.tachikoma.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9238b implements InterfaceC10625a {

    /* renamed from: Yq */
    private InterfaceC9239a f29313Yq;

    /* renamed from: com.kwad.components.core.webview.tachikoma.b$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC9239a {
        /* renamed from: dL */
        void mo29166dL();
    }

    public C9238b(InterfaceC9239a interfaceC9239a) {
        this.f29313Yq = interfaceC9239a;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        InterfaceC9239a interfaceC9239a = this.f29313Yq;
        if (interfaceC9239a != null) {
            interfaceC9239a.mo29166dL();
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "cardImpression";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
