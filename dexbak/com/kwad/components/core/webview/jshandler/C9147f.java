package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.jshandler.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9147f implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29239VX;

    /* renamed from: VY */
    private int f29240VY;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.f$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9148a extends C10482a {
        public int loadType;
    }

    public C9147f(int i) {
        this.f29240VY = i;
    }

    /* renamed from: aO */
    private void m29236aO(int i) {
        if (this.f29239VX == null) {
            return;
        }
        C9148a c9148a = new C9148a();
        c9148a.loadType = i;
        this.f29239VX.mo25251a(c9148a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29239VX = interfaceC10627c;
        m29236aO(this.f29240VY);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getLoadInfo";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29239VX = null;
    }
}
