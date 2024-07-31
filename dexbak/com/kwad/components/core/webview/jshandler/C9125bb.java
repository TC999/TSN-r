package com.kwad.components.core.webview.jshandler;

import androidx.annotation.NonNull;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.response.p408a.C10482a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10625a;
import com.kwad.sdk.core.webview.p422c.InterfaceC10627c;

/* renamed from: com.kwad.components.core.webview.jshandler.bb */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9125bb implements InterfaceC10625a {

    /* renamed from: VX */
    private InterfaceC10627c f29219VX;

    @KsJson
    /* renamed from: com.kwad.components.core.webview.jshandler.bb$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class C9126a extends C10482a {

        /* renamed from: Yc */
        public int f29220Yc;

        public C9126a(int i) {
            this.f29220Yc = i;
        }
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    /* renamed from: a */
    public final void mo25241a(String str, @NonNull InterfaceC10627c interfaceC10627c) {
        this.f29219VX = interfaceC10627c;
    }

    /* renamed from: ag */
    public final void m29250ag(boolean z) {
        if (this.f29219VX == null) {
            C10331c.m26254d("WebCardRewardTaskStatusHandler", "notifyTaskStatus , status:" + (z ? 1 : 0));
            return;
        }
        this.f29219VX.mo25251a(new C9126a(z ? 1 : 0));
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    @NonNull
    public final String getKey() {
        return "rewardTaskStatus";
    }

    @Override // com.kwad.sdk.core.webview.p422c.InterfaceC10625a
    public final void onDestroy() {
    }
}
