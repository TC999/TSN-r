package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.C10605b;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.jshandler.ae */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9053ae implements InterfaceC10625a {

    /* renamed from: Wf */
    private final C10605b f29110Wf;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.ae$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static final class C9054a extends C10482a {
        public String playableExtraData;
    }

    public C9053ae(C10605b c10605b) {
        this.f29110Wf = c10605b;
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        if (this.f29110Wf.m25325GN()) {
            interfaceC10627c.onError(-1, "native adTemplate is null");
            return;
        }
        C9054a c9054a = new C9054a();
        try {
            c9054a.playableExtraData = this.f29110Wf.getAdTemplate().adInfoList.get(0).adStyleInfo.playableExtraData;
        } catch (Exception e) {
            C10331c.printStackTraceOnly(e);
        }
        interfaceC10627c.mo25251a(c9054a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getKsPlayableAdData";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
