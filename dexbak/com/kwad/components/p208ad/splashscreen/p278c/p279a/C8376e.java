package com.kwad.components.p208ad.splashscreen.p278c.p279a;

import com.kwad.components.core.webview.tachikoma.p336d.C9283b;
import com.kwad.components.core.webview.tachikoma.p337e.AbstractC9293e;
import com.kwad.components.p208ad.splashscreen.p278c.C8421e;

/* renamed from: com.kwad.components.ad.splashscreen.c.a.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8376e extends C8421e {

    /* renamed from: jR */
    private AbstractC9293e f27667jR = new AbstractC9293e() { // from class: com.kwad.components.ad.splashscreen.c.a.e.1
        @Override // com.kwad.components.core.webview.tachikoma.p337e.InterfaceC9290b
        /* renamed from: q */
        public final void mo29101q(String str) {
            if ("tk_splash_end_card".equals(str)) {
                C8376e.this.m24611a(new C8373d(), true);
                C8376e.this.m24611a(new C8369a(), true);
                C8376e.this.m24611a(new View$OnClickListenerC8370b(), true);
                C8376e.this.m24611a(new View$OnClickListenerC8371c(), true);
            }
        }
    };

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        C9283b.m29107tc().m29113a(this.f27667jR);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        C9283b.m29107tc().m29112b(this.f27667jR);
    }
}
