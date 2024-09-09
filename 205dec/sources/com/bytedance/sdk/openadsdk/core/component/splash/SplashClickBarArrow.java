package com.bytedance.sdk.openadsdk.core.component.splash;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.bytedance.sdk.component.utils.i;
import com.bytedance.sdk.openadsdk.core.eq.xk;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SplashClickBarArrow extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private AnimatorSet f32805a;

    /* renamed from: c  reason: collision with root package name */
    private View f32806c;
    private SplashDiffuseView ev;

    /* renamed from: f  reason: collision with root package name */
    private FrameLayout f32807f;
    private RelativeLayout gd;

    /* renamed from: k  reason: collision with root package name */
    private int f32808k;

    /* renamed from: p  reason: collision with root package name */
    private boolean f32809p;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f32810r;
    private ImageView sr;
    private ImageView ux;

    /* renamed from: w  reason: collision with root package name */
    private RelativeLayout f32811w;
    private ImageView xv;

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

    public SplashClickBarArrow(Context context) {
        super(context);
        this.f32809p = true;
        this.f32805a = new AnimatorSet();
        w(context);
    }

    public Animator getAnimator() {
        return this.f32805a;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        try {
            AnimatorSet animatorSet = this.f32805a;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
        } catch (Exception e4) {
            com.bytedance.sdk.component.utils.a.xv(e4.getMessage());
        }
    }

    private void w(Context context) {
        View c4 = c(getContext());
        if (c4 == null) {
            return;
        }
        addView(c4);
        SplashDiffuseView splashDiffuseView = new SplashDiffuseView(getContext());
        this.ev = splashDiffuseView;
        this.f32807f.addView(splashDiffuseView, 0);
        ViewGroup.LayoutParams layoutParams = this.ev.getLayoutParams();
        layoutParams.width = -1;
        layoutParams.height = -1;
        this.ev.setVisibility(4);
    }

    private void xv() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f32810r, "scaleX", 1.0f, 0.9f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (SplashClickBarArrow.this.f32809p) {
                    SplashClickBarArrow.this.ev.c();
                }
                SplashClickBarArrow splashClickBarArrow = SplashClickBarArrow.this;
                splashClickBarArrow.f32809p = !splashClickBarArrow.f32809p;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(SplashClickBarArrow.this.f32810r, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.start();
                SplashClickBarArrow.this.f32810r.setVisibility(0);
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f32810r, "scaleY", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.f32805a.playTogether(ofFloat, ofFloat2);
        this.f32805a.setStartDelay(1000L);
    }

    public void c(int i4) {
        this.f32808k = i4;
        c();
    }

    private View c(Context context) {
        Resources resources = context.getResources();
        FrameLayout frameLayout = new FrameLayout(context);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
        frameLayout.setClipChildren(false);
        frameLayout.setLayoutParams(layoutParams);
        this.f32806c = new ImageView(context);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) TypedValue.applyDimension(1, 14.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 16.0f, resources.getDisplayMetrics()));
        this.f32806c.setId(2114387591);
        layoutParams2.gravity = 16;
        this.f32806c.setBackground(i.xv(context, "tt_splash_click_bar_go"));
        this.f32806c.setLayoutParams(layoutParams2);
        frameLayout.addView(this.f32806c);
        xk.c(this.f32806c, 8);
        RelativeLayout relativeLayout = new RelativeLayout(context);
        this.f32811w = relativeLayout;
        relativeLayout.setId(2114387590);
        new FrameLayout.LayoutParams(-2, -2).gravity = 16;
        this.f32811w.setPadding(xk.ux(context, 4.0f), 0, 0, 0);
        frameLayout.addView(this.f32811w);
        xk.c((View) this.f32811w, 8);
        ImageView imageView = new ImageView(context);
        this.xv = imageView;
        imageView.setId(2114387589);
        RelativeLayout.LayoutParams layoutParams3 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.xv.setAlpha(0.0f);
        this.xv.setBackground(i.xv(context, "tt_splash_arrow"));
        this.xv.setLayoutParams(layoutParams3);
        this.f32811w.addView(this.xv);
        ImageView imageView2 = new ImageView(context);
        this.sr = imageView2;
        imageView2.setId(2114387588);
        RelativeLayout.LayoutParams layoutParams4 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.sr.setAlpha(0.0f);
        this.sr.setBackground(i.xv(context, "tt_splash_arrow"));
        this.sr.setLayoutParams(layoutParams4);
        this.f32811w.addView(this.sr);
        ImageView imageView3 = new ImageView(context);
        this.ux = imageView3;
        imageView3.setId(2114387587);
        RelativeLayout.LayoutParams layoutParams5 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 8.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics()));
        this.ux.setAlpha(0.0f);
        this.ux.setBackground(i.xv(context, "tt_splash_arrow"));
        this.ux.setLayoutParams(layoutParams5);
        this.f32811w.addView(this.ux);
        View view = new View(context);
        view.setLayoutParams(new RelativeLayout.LayoutParams(-1, (int) TypedValue.applyDimension(1, 10.0f, resources.getDisplayMetrics())));
        this.f32811w.addView(view);
        FrameLayout frameLayout2 = new FrameLayout(context);
        this.f32807f = frameLayout2;
        frameLayout2.setId(2114387586);
        FrameLayout.LayoutParams layoutParams6 = new FrameLayout.LayoutParams(-1, -1);
        this.f32807f.setClipChildren(false);
        this.f32807f.setLayoutParams(layoutParams6);
        frameLayout.addView(this.f32807f);
        xk.c((View) this.f32807f, 8);
        RelativeLayout relativeLayout2 = new RelativeLayout(context);
        this.gd = relativeLayout2;
        relativeLayout2.setId(2114387585);
        FrameLayout.LayoutParams layoutParams7 = new FrameLayout.LayoutParams(-1, -1);
        this.gd.setClipChildren(false);
        this.gd.setLayoutParams(layoutParams7);
        this.f32807f.addView(this.gd);
        ImageView imageView4 = new ImageView(context);
        this.f32810r = imageView4;
        imageView4.setId(2114387584);
        RelativeLayout.LayoutParams layoutParams8 = new RelativeLayout.LayoutParams((int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()), (int) TypedValue.applyDimension(1, 50.0f, resources.getDisplayMetrics()));
        this.f32810r.setImageDrawable(i.xv(context, "tt_splash_hand"));
        this.f32810r.setLayoutParams(layoutParams8);
        this.gd.addView(this.f32810r);
        xk.c((View) this.f32810r, 4);
        return frameLayout;
    }

    private void w() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.xv, "alpha", 0.0f, 1.0f);
        ofFloat.setInterpolator(new c());
        ofFloat.setDuration(1300L);
        ofFloat.setStartDelay(700L);
        ofFloat.setRepeatCount(-1);
        ofFloat.setRepeatMode(1);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.xv, "translationX", 0.0f, xk.ux(getContext(), 20.0f));
        ofFloat2.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat2.setDuration(1300L);
        ofFloat2.setStartDelay(700L);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setRepeatMode(1);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.sr, "alpha", 0.0f, 1.0f);
        ofFloat3.setInterpolator(new c());
        ofFloat3.setDuration(1300L);
        ofFloat3.setStartDelay(500L);
        ofFloat3.setRepeatCount(-1);
        ofFloat3.setRepeatMode(1);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.sr, "translationX", xk.ux(getContext(), 23.0f));
        ofFloat4.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat4.setDuration(1300L);
        ofFloat4.setStartDelay(500L);
        ofFloat4.setRepeatCount(-1);
        ofFloat4.setRepeatMode(1);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.ux, "alpha", 0.0f, 1.0f);
        ofFloat5.setInterpolator(new c());
        ofFloat5.setDuration(1300L);
        ofFloat5.setStartDelay(200L);
        ofFloat5.setRepeatCount(-1);
        ofFloat5.setRepeatMode(1);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.ux, "translationX", xk.ux(getContext(), 25.0f));
        ofFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        ofFloat6.setDuration(1300L);
        ofFloat6.setStartDelay(200L);
        ofFloat6.setRepeatCount(-1);
        ofFloat6.setRepeatMode(1);
        this.f32805a.playTogether(ofFloat, ofFloat3, ofFloat5, ofFloat2, ofFloat4, ofFloat6);
    }

    private void c() {
        this.f32806c.setVisibility(8);
        this.f32811w.setVisibility(8);
        int i4 = this.f32808k;
        if (i4 == 1) {
            this.f32811w.setVisibility(0);
            w();
        } else if (i4 == 2) {
            this.f32807f.setVisibility(0);
            post(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.SplashClickBarArrow.1
                @Override // java.lang.Runnable
                public void run() {
                    FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SplashClickBarArrow.this.gd.getLayoutParams();
                    layoutParams.topMargin = (int) ((SplashClickBarArrow.this.ev.getMeasuredHeight() / 2.0f) - xk.ux(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.leftMargin = (int) ((SplashClickBarArrow.this.ev.getMeasuredWidth() / 2.0f) - xk.ux(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.bottomMargin = (int) (((-SplashClickBarArrow.this.ev.getMeasuredHeight()) / 2.0f) + xk.ux(SplashClickBarArrow.this.getContext(), 5.0f));
                    layoutParams.rightMargin = (int) (((-SplashClickBarArrow.this.ev.getMeasuredWidth()) / 2.0f) + xk.ux(SplashClickBarArrow.this.getContext(), 5.0f));
                    SplashClickBarArrow.this.gd.setLayoutParams(layoutParams);
                }
            });
            xv();
        } else if (i4 == 3 || i4 == 4 || i4 == 5 || i4 == 7) {
        } else {
            this.f32806c.setVisibility(0);
        }
    }
}
