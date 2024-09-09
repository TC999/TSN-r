package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;
import com.bytedance.sdk.openadsdk.core.ls;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SlideUpView extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f32796c;
    private AnimatorSet ev;

    /* renamed from: f  reason: collision with root package name */
    private AnimatorSet f32797f;

    /* renamed from: r  reason: collision with root package name */
    private AnimatorSet f32798r;
    private ImageView sr;
    private AnimatorSet ux;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f32799w;
    private ImageView xv;

    public SlideUpView(Context context) {
        super(context);
        this.f32797f = new AnimatorSet();
        this.f32798r = new AnimatorSet();
        this.ev = new AnimatorSet();
        w(context);
    }

    private void w(Context context) {
        if (context == null) {
            context = ls.getContext();
        }
        View c4 = c(context);
        if (c4 == null) {
            return;
        }
        addView(c4);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.ux;
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        RelativeLayout relativeLayout = new RelativeLayout(context);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        relativeLayout.setGravity(16);
        relativeLayout.setClipChildren(false);
        relativeLayout.setLayoutParams(layoutParams);
        ImageView imageView = new ImageView(context);
        this.xv = imageView;
        imageView.setId(2114387638);
        RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 60.0f, resources.getDisplayMetrics()));
        layoutParams2.addRule(14);
        layoutParams2.addRule(8, 2114387763);
        layoutParams2.bottomMargin = xk.ux(context, -24.0f);
        this.xv.setBackground(i.xv(context, "tt_splash_slide_up_circle"));
        this.xv.setAlpha(0.0f);
        this.xv.setLayoutParams(layoutParams2);
        relativeLayout.addView(this.xv);
        ImageView imageView2 = new ImageView(context);
        this.f32799w = imageView2;
        imageView2.setId(2114387945);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 0.0f, resources.getDisplayMetrics()));
        layoutParams3.addRule(14);
        layoutParams3.addRule(1, 2114387763);
        layoutParams3.addRule(8, 2114387763);
        this.f32799w.setBackground(i.xv(context, "tt_splash_slide_up_bg"));
        layoutParams3.leftMargin = xk.ux(context, -7.0f);
        this.f32799w.setLayoutParams(layoutParams3);
        relativeLayout.addView(this.f32799w);
        ImageView imageView3 = new ImageView(context);
        this.f32796c = imageView3;
        imageView3.setId(2114387643);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 91.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 68.0f, resources.getDisplayMetrics()));
        layoutParams4.addRule(14);
        layoutParams4.addRule(1, 2114387763);
        layoutParams4.addRule(8, 2114387763);
        this.f32796c.setBackground(i.xv(context, "tt_splash_slide_up_finger"));
        layoutParams4.leftMargin = xk.ux(context, -7.0f);
        layoutParams4.bottomMargin = xk.ux(context, -20.0f);
        this.f32796c.setAlpha(0.0f);
        this.f32796c.setLayoutParams(layoutParams4);
        relativeLayout.addView(this.f32796c);
        ImageView imageView4 = new ImageView(context);
        this.sr = imageView4;
        imageView4.setId(2114387763);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 124.0f, resources.getDisplayMetrics()));
        layoutParams5.addRule(14);
        this.sr.setBackground(i.xv(context, "tt_splash_slide_up_arrow"));
        this.sr.setLayoutParams(layoutParams5);
        relativeLayout.addView(this.sr);
        return relativeLayout;
    }

    public void w() {
        AnimatorSet animatorSet = this.ux;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        AnimatorSet animatorSet2 = this.f32798r;
        if (animatorSet2 != null) {
            animatorSet2.cancel();
        }
        AnimatorSet animatorSet3 = this.f32797f;
        if (animatorSet3 != null) {
            animatorSet3.cancel();
        }
        AnimatorSet animatorSet4 = this.ev;
        if (animatorSet4 != null) {
            animatorSet4.cancel();
        }
    }

    public void c() {
        this.ux = new AnimatorSet();
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f32796c, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f32796c, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f32796c, "translationY", 0.0f, xk.ux(getContext(), -110.0f));
        ofFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ValueAnimator ofInt = ValueAnimator.ofInt(0, xk.ux(getContext(), 110.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SlideUpView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.f32799w.getLayoutParams();
                layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SlideUpView.this.f32799w.setLayoutParams(layoutParams);
            }
        });
        ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.f32799w, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f32799w, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.xv, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.xv, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.xv, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.xv, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.xv, "translationY", 0.0f, xk.ux(getContext(), -110.0f));
        ofFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        this.f32797f.setDuration(50L);
        this.ev.setDuration(1500L);
        this.f32798r.setDuration(50L);
        this.f32797f.playTogether(ofFloat2, ofFloat7, ofFloat5);
        this.f32798r.playTogether(ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4);
        this.ev.playTogether(ofFloat3, ofInt, ofFloat10);
        this.ux.playSequentially(this.f32798r, this.ev, this.f32797f);
    }
}
