package com.acse.ottn.activity;

import android.animation.AnimatorSet;
import android.view.View;
import com.acse.ottn.animator.SwitchOnAnimView;

/* renamed from: com.acse.ottn.activity.N */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
class View$OnClickListenerC1276N implements View.OnClickListener {

    /* renamed from: a */
    final /* synthetic */ TransparentGreenActivity f2120a;

    View$OnClickListenerC1276N(TransparentGreenActivity transparentGreenActivity) {
        this.f2120a = transparentGreenActivity;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        SwitchOnAnimView switchOnAnimView;
        SwitchOnAnimView switchOnAnimView2;
        SwitchOnAnimView switchOnAnimView3;
        SwitchOnAnimView switchOnAnimView4;
        AnimatorSet animatorSet = this.f2120a.f2182p;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        switchOnAnimView = this.f2120a.f2173g;
        if (switchOnAnimView != null) {
            switchOnAnimView4 = this.f2120a.f2173g;
            switchOnAnimView4.m57202b();
            this.f2120a.f2173g = null;
        }
        switchOnAnimView2 = this.f2120a.f2174h;
        if (switchOnAnimView2 != null) {
            switchOnAnimView3 = this.f2120a.f2174h;
            switchOnAnimView3.m57202b();
            this.f2120a.f2174h = null;
        }
        this.f2120a.finish();
    }
}
