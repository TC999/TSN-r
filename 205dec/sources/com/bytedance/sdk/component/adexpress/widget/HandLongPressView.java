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
public class HandLongPressView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private Context f29569c;

    /* renamed from: f  reason: collision with root package name */
    private TextView f29570f;
    private AnimatorSet sr;
    private boolean ux;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f29571w;
    private CircleRippleView xv;

    public HandLongPressView(Context context) {
        super(context);
        this.ux = true;
        this.f29569c = context;
        this.sr = new AnimatorSet();
        xv();
        sr();
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) HandLongPressView.this.f29571w.getLayoutParams();
                layoutParams.topMargin = ((int) ((HandLongPressView.this.xv.getMeasuredHeight() / 2.0f) - f.c(HandLongPressView.this.getContext(), 5.0f))) + ((int) f.c(HandLongPressView.this.f29569c, 20.0f));
                layoutParams.leftMargin = ((int) ((HandLongPressView.this.xv.getMeasuredWidth() / 2.0f) - f.c(HandLongPressView.this.getContext(), 5.0f))) + ((int) f.c(HandLongPressView.this.f29569c, 20.0f));
                layoutParams.bottomMargin = (int) (((-HandLongPressView.this.xv.getMeasuredHeight()) / 2.0f) + f.c(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.rightMargin = (int) (((-HandLongPressView.this.xv.getMeasuredWidth()) / 2.0f) + f.c(HandLongPressView.this.getContext(), 5.0f));
                layoutParams.setMarginStart(layoutParams.leftMargin);
                layoutParams.setMarginEnd(layoutParams.rightMargin);
                HandLongPressView.this.f29571w.setLayoutParams(layoutParams);
            }
        });
    }

    public void setGuideText(String str) {
        this.f29570f.setText(str);
    }

    public void setGuideTextColor(int i4) {
        this.f29570f.setTextColor(i4);
    }

    private void sr() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f29571w, "scaleX", 1.0f, 0.8f);
        ofFloat.setDuration(1000L);
        ofFloat.setRepeatMode(2);
        ofFloat.setRepeatCount(-1);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.HandLongPressView.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
                if (HandLongPressView.this.ux) {
                    HandLongPressView.this.xv.c();
                    HandLongPressView.this.xv.setAlpha(1.0f);
                } else {
                    HandLongPressView.this.xv.w();
                    HandLongPressView.this.xv.setAlpha(0.0f);
                }
                HandLongPressView handLongPressView = HandLongPressView.this;
                handLongPressView.ux = !handLongPressView.ux;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(HandLongPressView.this.f29571w, "alpha", 0.0f, 1.0f);
                ofFloat2.setDuration(200L);
                ofFloat2.setInterpolator(new LinearInterpolator());
                ofFloat2.start();
                HandLongPressView.this.f29571w.setVisibility(0);
            }
        });
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f29571w, "scaleY", 1.0f, 0.8f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setRepeatMode(2);
        ofFloat2.setRepeatCount(-1);
        this.sr.playTogether(ofFloat, ofFloat2);
    }

    private void xv() {
        this.xv = new CircleRippleView(this.f29569c);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) f.c(this.f29569c, 80.0f), (int) f.c(this.f29569c, 80.0f));
        layoutParams.gravity = 8388659;
        layoutParams.topMargin = (int) f.c(this.f29569c, 20.0f);
        int c4 = (int) f.c(this.f29569c, 20.0f);
        layoutParams.leftMargin = c4;
        layoutParams.setMarginStart(c4);
        layoutParams.setMarginEnd(layoutParams.rightMargin);
        addView(this.xv, layoutParams);
        this.xv.c();
        this.f29571w = new ImageView(this.f29569c);
        ViewGroup.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) f.c(this.f29569c, 80.0f), (int) f.c(this.f29569c, 80.0f));
        this.f29571w.setImageResource(i.sr(this.f29569c, "tt_splash_hand"));
        addView(this.f29571w, layoutParams2);
        TextView textView = new TextView(this.f29569c);
        this.f29570f = textView;
        textView.setTextColor(-1);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 81;
        layoutParams3.bottomMargin = (int) f.c(this.f29569c, 10.0f);
        addView(this.f29570f, layoutParams3);
    }

    public void w() {
        AnimatorSet animatorSet = this.sr;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
        CircleRippleView circleRippleView = this.xv;
        if (circleRippleView != null) {
            circleRippleView.w();
        }
    }

    public void c() {
        this.sr.start();
    }
}
