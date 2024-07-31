package com.kwad.components.p208ad.reward.presenter.p272f;

import com.kwad.components.core.webview.jshandler.C9109aw;
import com.kwad.components.p208ad.reward.C7907g;

/* renamed from: com.kwad.components.ad.reward.presenter.f.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8179e implements C7907g.InterfaceC7920a {

    /* renamed from: wA */
    private boolean f27101wA;

    /* renamed from: wB */
    private boolean f27102wB;

    /* renamed from: wz */
    private C9109aw f27103wz;

    /* renamed from: iY */
    private void m31338iY() {
        C9109aw c9109aw = this.f27103wz;
        if (c9109aw == null || !this.f27102wB) {
            return;
        }
        if (!this.f27101wA) {
            c9109aw.m29268sr();
            this.f27103wz.m29267ss();
            this.f27101wA = true;
            return;
        }
        c9109aw.m29264sv();
    }

    /* renamed from: b */
    public final void m31340b(C9109aw c9109aw) {
        this.f27103wz = c9109aw;
    }

    /* renamed from: bF */
    public final void m31339bF() {
        m31338iY();
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fU */
    public final void mo31309fU() {
        this.f27102wB = true;
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fV */
    public final void mo31308fV() {
        this.f27102wB = true;
        m31338iY();
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fW */
    public final void mo31307fW() {
        this.f27102wB = false;
        C9109aw c9109aw = this.f27103wz;
        if (c9109aw != null) {
            c9109aw.m29263sw();
        }
    }

    @Override // com.kwad.components.p208ad.reward.C7907g.InterfaceC7920a
    /* renamed from: fX */
    public final void mo31306fX() {
        this.f27102wB = false;
    }

    /* renamed from: iZ */
    public final void m31337iZ() {
        C9109aw c9109aw = this.f27103wz;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f27103wz.m29265su();
        }
    }

    /* renamed from: y */
    public final void m31336y(C7907g c7907g) {
        c7907g.m32049a(this);
    }

    /* renamed from: z */
    public final void m31335z(C7907g c7907g) {
        C9109aw c9109aw = this.f27103wz;
        if (c9109aw != null) {
            c9109aw.m29266st();
            this.f27103wz.m29265su();
        }
        c7907g.m32033b(this);
    }
}
