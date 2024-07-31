package com.kwad.components.p208ad.reward.presenter;

import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.core.response.p409b.C10483a;
import com.kwad.sdk.core.response.p409b.C10487e;
import com.kwad.sdk.mvp.Presenter;

/* renamed from: com.kwad.components.ad.reward.presenter.b */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class C8094b extends Presenter {
    public AdTemplate mAdTemplate;

    /* renamed from: qo */
    public C7907g f26957qo;

    @Override // com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public void mo24610aj() {
        super.mo24610aj();
        C7907g c7907g = (C7907g) m24613Jx();
        this.f26957qo = c7907g;
        this.mAdTemplate = c7907g.mAdTemplate;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: hp */
    public final void m31613hp() {
        this.f26957qo.m30013hp();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: hq */
    public final boolean m31612hq() {
        return C10483a.m25876bd(C10487e.m25641dQ(this.f26957qo.mAdTemplate));
    }
}
