package com.bytedance.sdk.openadsdk.core.component.reward.draw;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.a;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;
import com.bytedance.sdk.openadsdk.res.ux;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class RewardGuideSlideUp extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f32267c;

    /* renamed from: f  reason: collision with root package name */
    private final AnimatorSet f32268f;

    /* renamed from: r  reason: collision with root package name */
    private final AnimatorSet f32269r;
    private AnimatorSet sr;
    private final AnimatorSet ux;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f32270w;
    private ImageView xv;

    public RewardGuideSlideUp(Context context) {
        super(context);
        this.ux = new AnimatorSet();
        this.f32268f = new AnimatorSet();
        this.f32269r = new AnimatorSet();
        c(context);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.sr;
    }

    public void w() {
        try {
            AnimatorSet animatorSet = this.sr;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.f32268f;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.ux;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.f32269r;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable th) {
            a.xv(th.getMessage());
        }
    }

    private void c(Context context) {
        if (context == null) {
            context = ls.getContext();
        }
        addView(ux.a(context));
        this.f32267c = (ImageView) findViewById(2114387643);
        this.f32270w = (ImageView) findViewById(2114387945);
        this.xv = (ImageView) findViewById(2114387638);
    }

    public void c() {
        this.sr = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f32267c, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f32267c, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f32267c, "translationY", 0.0f, xk.ux(getContext(), -110.0f));
        ofFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, xk.ux(getContext(), 110.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.reward.draw.RewardGuideSlideUp.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) RewardGuideSlideUp.this.f32270w.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                RewardGuideSlideUp.this.f32270w.setLayoutParams(layoutParams);
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f32270w, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f32270w, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.xv, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.xv, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.xv, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.xv, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.xv, "translationY", 0.0f, xk.ux(getContext(), -110.0f));
        ofFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.ux.setDuration(50L);
        this.f32269r.setDuration(3000L);
        this.f32268f.setDuration(50L);
        this.ux.playTogether(ofFloat2, ofFloat7, ofFloat5);
        this.f32268f.playTogether(ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4);
        this.f32269r.playTogether(ofFloat3, ofInt, ofFloat10);
        this.sr.playSequentially(this.f32268f, this.f32269r, this.ux);
    }
}
