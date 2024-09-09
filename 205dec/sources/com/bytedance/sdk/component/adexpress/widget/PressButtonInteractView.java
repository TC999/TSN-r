package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class PressButtonInteractView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private Context f29574c;
    private AnimatorSet sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f29575w;
    private SplashDiffuseView xv;

    public PressButtonInteractView(Context context) {
        super(context);
        this.ux = true;
        this.f29574c = context;
        this.sr = new AnimatorSet();
        xv();
        sr();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) PressButtonInteractView.this.f29575w.getLayoutParams();
                layoutParams.topMargin = (int) ((PressButtonInteractView.this.xv.getMeasuredHeight() / 2.0f) - f.c(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.leftMargin = (int) ((PressButtonInteractView.this.xv.getMeasuredWidth() / 2.0f) - f.c(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.bottomMargin = (int) (((-PressButtonInteractView.this.xv.getMeasuredHeight()) / 2.0f) + f.c(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-PressButtonInteractView.this.xv.getMeasuredWidth()) / 2.0f) + f.c(PressButtonInteractView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                PressButtonInteractView.this.f29575w.setLayoutParams(layoutParams);
            }
        });
    }

    private void sr() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f29575w, "scaleX", 1.0f, 0.9f);
        ofFloat.setDuration(800L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.PressButtonInteractView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (PressButtonInteractView.this.ux) {
                    PressButtonInteractView.this.xv.c();
                }
                PressButtonInteractView pressButtonInteractView = PressButtonInteractView.this;
                pressButtonInteractView.ux = !pressButtonInteractView.ux;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(PressButtonInteractView.this.f29575w, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
                ofFloat2.start();
                PressButtonInteractView.this.f29575w.setVisibility(0);
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f29575w, "scaleY", 1.0f, 0.9f);
        ofFloat2.setDuration(800L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        ofFloat2.setInterpolator(new AccelerateDecelerateInterpolator());
        this.sr.playTogether(ofFloat, ofFloat2);
    }

    private void xv() {
        this.xv = new SplashDiffuseView(this.f29574c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f.c(this.f29574c, 40.0f), (int) f.c(this.f29574c, 40.0f));
        layoutParams.gravity = 8388627;
        addView(this.xv, layoutParams);
        this.f29575w = new ImageView(this.f29574c);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) f.c(this.f29574c, 62.0f), (int) f.c(this.f29574c, 62.0f));
        layoutParams2.gravity = 16;
        this.f29575w.setImageResource(i.sr(this.f29574c, "tt_splash_hand"));
        addView(this.f29575w, layoutParams2);
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
        ImageView imageView = this.f29575w;
        if (imageView != null) {
            imageView.clearAnimation();
        }
    }

    public void c() {
        this.sr.start();
    }
}
