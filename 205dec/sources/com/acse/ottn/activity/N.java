package com.acse.ottn.activity;

import android.animation.AnimatorSet;
import android.view.View;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
class N implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TransparentGreenActivity f4673a;

    N(TransparentGreenActivity transparentGreenActivity) {
        this.f4673a = transparentGreenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        AnimatorSet animatorSet = this.f4673a.p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        if (this.f4673a.f4719h != null) {
            this.f4673a.f4719h.b();
            this.f4673a.f4719h = null;
        }
        if (this.f4673a.f4720i != null) {
            this.f4673a.f4720i.b();
            this.f4673a.f4720i = null;
        }
        this.f4673a.finish();
    }
}
