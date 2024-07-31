package com.kwad.components.p208ad.reward.p258k.p259a;

import com.kwad.components.core.webview.tachikoma.p335c.C9267b;
import com.kwad.components.p208ad.reward.C7907g;
import com.kwad.components.p208ad.reward.p250c.C7863a;
import com.kwad.components.p208ad.reward.p250c.C7864b;

/* renamed from: com.kwad.components.ad.reward.k.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C7959a extends C9267b {

    /* renamed from: xq */
    private C7907g f26668xq;

    public C7959a(C7907g c7907g) {
        this.f26668xq = c7907g;
    }

    /* renamed from: b */
    public final void m31923b(C7864b c7864b) {
        C7863a.m32133gL().m32136a(this.mAdTemplate, c7864b);
    }

    /* renamed from: ji */
    public final C7907g m31922ji() {
        return this.f26668xq;
    }

    @Override // com.kwad.components.core.webview.tachikoma.p335c.C9267b, com.kwad.sdk.mvp.AbstractC10868a
    public final void release() {
        super.release();
        this.f26668xq = null;
    }
}
