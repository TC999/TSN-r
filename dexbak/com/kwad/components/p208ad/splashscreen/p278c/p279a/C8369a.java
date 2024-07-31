package com.kwad.components.p208ad.splashscreen.p278c.p279a;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kwad.components.p208ad.splashscreen.p278c.C8421e;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.ad.splashscreen.c.a.a */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C8369a extends C8421e {

    /* renamed from: Er */
    private AnimatorSet f27639Er;

    /* renamed from: Es */
    private TextView f27640Es;

    /* renamed from: Et */
    private ViewGroup f27641Et;

    /* renamed from: Eu */
    private ViewGroup f27642Eu;

    private void initView() {
        this.f27640Es = (TextView) findViewById(C9659R.C9662id.ksad_ad_developer_text);
        this.f27641Et = (ViewGroup) findViewById(C9659R.C9662id.ksad_splash_end_card_native_view);
        this.f27642Eu = (ViewGroup) findViewById(C9659R.C9662id.ksad_splash_end_card_native_dialog_root);
    }

    /* renamed from: lA */
    private void m30875lA() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f27642Eu, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f27640Es, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f27641Et, "scaleX", 0.8f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f27641Et, "scaleY", 0.8f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f27639Er = animatorSet;
        animatorSet.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        this.f27639Er.setDuration(300L);
        this.f27639Er.start();
    }

    @Override // com.kwad.components.p208ad.splashscreen.p278c.C8421e, com.kwad.sdk.mvp.Presenter
    /* renamed from: aj */
    public final void mo24610aj() {
        super.mo24610aj();
        m30875lA();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onCreate() {
        super.onCreate();
        initView();
    }

    @Override // com.kwad.sdk.mvp.Presenter
    public final void onUnbind() {
        super.onUnbind();
        AnimatorSet animatorSet = this.f27639Er;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }
}
