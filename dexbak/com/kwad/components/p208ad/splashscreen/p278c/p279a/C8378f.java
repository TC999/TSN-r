package com.kwad.components.p208ad.splashscreen.p278c.p279a;

import com.kwad.components.p208ad.splashscreen.InterfaceC8482f;
import com.kwad.components.p208ad.splashscreen.p278c.C8421e;

/* renamed from: com.kwad.components.ad.splashscreen.c.a.f */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8378f extends C8421e {

    /* renamed from: ER */
    InterfaceC8482f f27669ER = new InterfaceC8482f() { // from class: com.kwad.components.ad.splashscreen.c.a.f.1
        @Override // com.kwad.components.p208ad.splashscreen.InterfaceC8482f
        /* renamed from: kw */
        public final void mo30643kw() {
            C8378f.this.m24611a(new C8376e(), true);
            C8378f.this.m24611a(new C8380g(), true);
        }
    };

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27734Dg.m30623a(this.f27669ER);
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f27734Dg.m30621b(this.f27669ER);
    }
}
