package com.kwad.components.p208ad.splashscreen.p278c;

import com.kwad.components.p208ad.splashscreen.monitor.C8497b;
import com.kwad.sdk.core.p403h.InterfaceC10385c;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;

/* renamed from: com.kwad.components.ad.splashscreen.c.k */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8437k extends C8421e implements InterfaceC10385c {
    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aM */
    public final void mo26182aM() {
        this.f27734Dg.m30627Q(getContext());
    }

    @Override // com.kwad.sdk.core.p403h.InterfaceC10385c
    /* renamed from: aN */
    public final void mo26181aN() {
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        this.f27734Dg.f27881Cs.mo26187a(this);
        C8497b.m30550kV();
        C8497b.m30578Z(this.f27734Dg.mAdTemplate);
        C8497b.m30550kV();
        C8497b.m30569ab(this.f27734Dg.mAdTemplate);
        if (C10483a.m25800cz(C10487e.m25641dQ(this.f27734Dg.mAdTemplate))) {
            this.f27734Dg.m30627Q(getContext());
        }
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        this.f27734Dg.f27881Cs.mo26186b(this);
    }
}
