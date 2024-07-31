package com.kwad.components.p208ad.interstitial.p242e;

import com.kwad.sdk.mvp.Presenter;
import java.util.List;

/* renamed from: com.kwad.components.ad.interstitial.e.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C7760b extends Presenter {

    /* renamed from: jK */
    public C7761c f26196jK;

    @Override // com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public void mo24610aj() {
        super.mo24610aj();
        this.f26196jK = (C7761c) m24613Jx();
    }

    /* renamed from: cP */
    public void mo32406cP() {
        List<Presenter> m24614Jw = m24614Jw();
        if (m24614Jw == null) {
            return;
        }
        for (Presenter presenter : m24614Jw) {
            if (presenter instanceof C7760b) {
                ((C7760b) presenter).mo32406cP();
            }
        }
    }

    /* renamed from: cQ */
    public void mo32405cQ() {
        List<Presenter> m24614Jw = m24614Jw();
        if (m24614Jw == null) {
            return;
        }
        for (Presenter presenter : m24614Jw) {
            if (presenter instanceof C7760b) {
                ((C7760b) presenter).mo32405cQ();
            }
        }
    }
}
