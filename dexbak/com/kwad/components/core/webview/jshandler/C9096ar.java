package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.jshandler.ar */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9096ar implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29186VX;

    /* renamed from: XM */
    private C9097a f29187XM = new C9097a();

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.ar$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public class C9097a extends C10482a implements InterfaceC9914b {

        /* renamed from: id */
        public int f29189id;
        public int status;

        public C9097a() {
        }
    }

    /* renamed from: r */
    private void m29279r(int i, int i2) {
        InterfaceC10627c interfaceC10627c = this.f29186VX;
        if (interfaceC10627c != null) {
            C9097a c9097a = this.f29187XM;
            c9097a.f29189id = i;
            c9097a.status = 2;
            interfaceC10627c.mo25251a(c9097a);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29186VX = interfaceC10627c;
    }

    /* renamed from: aP */
    public final void m29280aP(int i) {
        m29279r(1, 2);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerAnimationListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29186VX = null;
    }
}
