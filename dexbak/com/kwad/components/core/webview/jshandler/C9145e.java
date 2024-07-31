package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.jshandler.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9145e implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29236VX;

    /* renamed from: mt */
    private int f29237mt;

    /* renamed from: mu */
    private int f29238mu;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.e$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9146a extends C10482a {
        public int showLiveStatus;
        public int showLiveStyle;
    }

    public C9145e(int i, int i2) {
        this.f29237mt = i;
        this.f29238mu = i2;
    }

    /* renamed from: q */
    private void m29237q(int i, int i2) {
        if (this.f29236VX == null) {
            return;
        }
        C9146a c9146a = new C9146a();
        c9146a.showLiveStatus = i;
        c9146a.showLiveStyle = i2;
        this.f29236VX.mo25251a(c9146a);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29236VX = interfaceC10627c;
        m29237q(this.f29237mt, this.f29238mu);
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "getLiveInfo";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
        this.f29236VX = null;
    }
}
