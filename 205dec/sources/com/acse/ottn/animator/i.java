package com.acse.ottn.animator;

import com.acse.ottn.R;
import com.acse.ottn.animator.a.AbstractC1361a;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class i extends a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwitchOnAnimView f5049a;

    i(SwitchOnAnimView switchOnAnimView) {
        this.f5049a = switchOnAnimView;
    }

    @Override // com.acse.ottn.animator.a, com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
    public void a(AbstractC1361a abstractC1361a) {
        if (this.f5049a.f4808c == null || this.f5049a.f4806a == null) {
            return;
        }
        this.f5049a.f4808c.setBackgroundResource(R.mipmap.finger_click);
        this.f5049a.f4806a.postDelayed(new h(this), 200L);
    }
}
