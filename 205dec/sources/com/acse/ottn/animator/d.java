package com.acse.ottn.animator;

import com.acse.ottn.R;
import com.acse.ottn.animator.a.AbstractC1361a;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class d extends a {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ SwitchOnAnimSmallView f5044a;

    d(SwitchOnAnimSmallView switchOnAnimSmallView) {
        this.f5044a = switchOnAnimSmallView;
    }

    @Override // com.acse.ottn.animator.a, com.acse.ottn.animator.a.AbstractC1361a.InterfaceC0082a
    public void a(AbstractC1361a abstractC1361a) {
        if (this.f5044a.f4795c == null || this.f5044a.f4793a == null) {
            return;
        }
        this.f5044a.f4795c.setBackgroundResource(R.mipmap.finger_click);
        this.f5044a.f4793a.postDelayed(new c(this), 200L);
    }
}
