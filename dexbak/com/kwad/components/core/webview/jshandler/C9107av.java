package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.InterfaceC9914b;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.jshandler.av */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9107av implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29200VX;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.av$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9108a extends C10482a implements InterfaceC9914b {

        /* renamed from: XR */
        public String f29201XR;
    }

    /* renamed from: aM */
    private void m29271aM(String str) {
        if (this.f29200VX != null) {
            C9108a c9108a = new C9108a();
            c9108a.f29201XR = str;
            this.f29200VX.mo25251a(c9108a);
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29200VX = interfaceC10627c;
    }

    /* renamed from: aU */
    public final void m29270aU(boolean z) {
        if (z) {
            m29271aM("windowFocusGet");
        } else {
            m29271aM("windowFocusLost");
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "registerFocusListener";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29200VX = null;
    }
}
