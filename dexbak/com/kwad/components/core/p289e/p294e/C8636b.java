package com.kwad.components.core.p289e.p294e;

import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.mvp.Presenter;

/* renamed from: com.kwad.components.core.e.e.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8636b extends Presenter {

    /* renamed from: Lq */
    protected C8637c f28277Lq;
    protected AdInfo mAdInfo;

    @Override // com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public void mo24610aj() {
        super.mo24610aj();
        C8637c c8637c = (C8637c) m24613Jx();
        this.f28277Lq = c8637c;
        this.mAdInfo = C10487e.m25641dQ(c8637c.f28279Lp.getAdTemplate());
    }
}
