package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PressInteractView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private Context f29578c;

    /* renamed from: f  reason: collision with root package name */
    private TextView f29579f;
    private AnimatorSet sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f29580w;
    private SplashDiffuseView xv;

    public PressInteractView(Context context) {
        super(context);
        this.ux = true;
        this.f29578c = context;
        this.sr = new AnimatorSet();
        xv();
        sr();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                int c4 = (int) f.c(PressInteractView.this.f29578c, 50.0f);
                int c5 = (int) f.c(PressInteractView.this.f29578c, 50.0f);
                if (PressInteractView.this.xv.getMeasuredHeight() > 0) {
                    c4 = PressInteractView.this.xv.getMeasuredHeight();
                }
                if (PressInteractView.this.xv.getMeasuredWidth() > 0) {
                    c5 = PressInteractView.this.xv.getMeasuredWidth();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressInteractView.this.f29580w.getLayoutParams();
                layoutParams.topMargin = ((int) ((c4 / 2.0f) - f.c(PressInteractView.this.getContext(), 5.0f))) + ((int) f.c(PressInteractView.this.f29578c, 40.0f));
                layoutParams.leftMargin = ((int) ((c5 / 2.0f) - f.c(PressInteractView.this.getContext(), 5.0f))) + ((int) f.c(PressInteractView.this.f29578c, 20.0f));
                layoutParams.bottomMargin = (int) (((-c4) / 2.0f) + f.c(PressInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-c5) / 2.0f) + f.c(PressInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressInteractView.this.f29580w.setLayoutParams(layoutParams);
            }
        });
    }

    public void setGuideText(String str) {
        this.f29579f.setVisibility(0);
        this.f29579f.setText(str);
    }

    public void setGuideTextColor(int i4) {
        this.f29579f.setTextColor(i4);
    }

    private void sr() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f29580w, "scaleX", 1.0f, 1.0f, 1.0f, 0.9f);
        ofFloat.setDuration(600L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressInteractView.this.ux) {
                    PressInteractView.this.xv.c();
                }
                PressInteractView pressInteractView = PressInteractView.this;
                pressInteractView.ux = !pressInteractView.ux;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(PressInteractView.this.f29580w, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.start();
                PressInteractView.this.f29580w.setVisibility(0);
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f29580w, "scaleY", 1.0f, 1.0f, 1.0f, 0.9f);
        ofFloat2.setDuration(600L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.sr.playTogether(ofFloat, ofFloat2);
    }

    private void xv() {
        this.xv = new SplashDiffuseView(this.f29578c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f.c(this.f29578c, 50.0f), (int) f.c(this.f29578c, 50.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) f.c(this.f29578c, 40.0f);
        int c4 = (int) f.c(this.f29578c, 20.0f);
        layoutParams.leftMargin = c4;
        layoutParams.setMarginStart(c4);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.xv, layoutParams);
        this.f29580w = new ImageView(this.f29578c);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) f.c(this.f29578c, 78.0f), (int) f.c(this.f29578c, 78.0f));
        this.f29580w.setImageResource(i.sr(this.f29578c, "tt_splash_hand"));
        addView(this.f29580w, layoutParams2);
        TextView textView = new TextView(this.f29578c);
        this.f29579f = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) f.c(this.f29578c, 10.0f);
        addView(this.f29579f, layoutParams3);
        this.f29579f.setVisibility(8);
    }

    public void w() {
        AnimatorSet animatorSet = this.sr;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        SplashDiffuseView splashDiffuseView = this.xv;
        if (splashDiffuseView != null) {
            splashDiffuseView.w();
        }
        ImageView imageView = this.f29580w;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void c() {
        this.sr.start();
    }
}
