package com.bytedance.sdk.openadsdk.core.component.reward.view;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.view.View;
import android.view.animation.Interpolator;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;

@SuppressLint({"ViewConstructor"})
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SlideUpLoadMoreArrow extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private final int f32622c;

    /* renamed from: w  reason: collision with root package name */
    private final AnimatorSet f32623w;

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public static class c implements Interpolator {
        private c() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return f4 <= 0.38f ? f4 * 2.631579f : (f4 * (-1.6129032f)) + 1.6129032f;
        }
    }

    public SlideUpLoadMoreArrow(Context context, int i4, boolean z3) {
        super(context);
        this.f32623w = new AnimatorSet();
        if (z3) {
            xv();
        }
        this.f32622c = i4;
        sr();
    }

    private View c(Context context) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setClipChildren(false);
        linearLayout.setGravity(1);
        linearLayout.setOrientation(1);
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(i.xv(context, "ic_back_light"));
        imageView.setAlpha(0.0f);
        linearLayout.addView(imageView, -1, -2);
        ImageView imageView2 = new ImageView(context);
        imageView2.setImageDrawable(i.xv(context, "ic_back_light"));
        imageView2.setAlpha(0.0f);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = xk.ux(context, -8.0f);
        linearLayout.addView(imageView2, layoutParams);
        setClipChildren(false);
        c(imageView, imageView2);
        return linearLayout;
    }

    private void sr() {
        Context context = getContext();
        setOrientation(1);
        setClipChildren(false);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.topMargin = xk.ux(context, 80.0f);
        layoutParams.gravity = 1;
        addView(c(getContext()), layoutParams);
        TextView textView = new TextView(context);
        textView.setTextColor(-1);
        if (Build.VERSION.SDK_INT >= 28) {
            textView.setLineHeight(xk.ux(context, 17.0f));
        }
        textView.setTextSize(2, 12.0f);
        textView.setText(i.c(context, "tt_reward_slip_up_lp_tip"));
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.topMargin = xk.ux(context, 6.0f);
        layoutParams2.bottomMargin = xk.ux(context, this.f32622c);
        layoutParams2.gravity = 1;
        addView(textView, layoutParams2);
    }

    private void xv() {
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{Color.parseColor("#DD000000"), 0});
        gradientDrawable.setShape(0);
        gradientDrawable.setGradientType(0);
        setBackground(gradientDrawable);
    }

    public void w() {
        if (this.f32623w.isRunning()) {
            this.f32623w.cancel();
        }
    }

    private void c(View view, View view2) {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(new c());
        ofFloat.setDuration(1300L);
        ofFloat.setStartDelay(700L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(view, "translationY", 0.0f, xk.ux(getContext(), -5.0f));
        ofFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat2.setDuration(1300L);
        ofFloat2.setStartDelay(700L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(view2, "alpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(new c());
        ofFloat3.setDuration(1300L);
        ofFloat3.setStartDelay(500L);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(1);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(view2, "translationY", xk.ux(getContext(), -6.0f));
        ofFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat4.setDuration(1300L);
        ofFloat4.setStartDelay(500L);
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setRepeatMode(1);
        this.f32623w.playTogether(ofFloat, ofFloat3, ofFloat2, ofFloat4);
    }

    public void c() {
        if (this.f32623w.isStarted()) {
            return;
        }
        this.f32623w.start();
    }
}
