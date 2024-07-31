package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.jshandler.ba */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9123ba implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29217VX;

    /* renamed from: Yb */
    private C9124a f29218Yb = new C9124a();

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.ba$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9124a extends C10482a implements InterfaceC9914b {
        public int status;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29217VX = interfaceC10627c;
    }

    /* renamed from: aQ */
    public final void m29251aQ(int i) {
        InterfaceC10627c interfaceC10627c = this.f29217VX;
        if (interfaceC10627c != null) {
            C9124a c9124a = this.f29218Yb;
            c9124a.status = i;
            interfaceC10627c.mo25251a(c9124a);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerVideoListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29217VX = null;
    }
}
