package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.view.animation.PathInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.w.sr;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SlideRightView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private Context f29609c;
    private AnimatorSet ev;

    /* renamed from: f  reason: collision with root package name */
    private AnimatorSet f29610f;
    private AnimatorSet gd;

    /* renamed from: r  reason: collision with root package name */
    private AnimatorSet f29611r;
    private ImageView sr;
    private TextView ux;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f29612w;
    private ImageView xv;

    public SlideRightView(Context context) {
        super(context);
        this.f29610f = new AnimatorSet();
        this.f29611r = new AnimatorSet();
        this.ev = new AnimatorSet();
        this.gd = new AnimatorSet();
        this.f29609c = context;
        xv();
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
    }

    public void setGuideText(String str) {
        this.ux.setText(str);
    }

    private void sr() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f29612w, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.xv, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.xv, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.sr, "alpha", 0.0f, 1.0f);
        this.ev.setDuration(300L);
        this.ev.playTogether(ofFloat, ofFloat2, ofFloat3, ofFloat4);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f29612w, "translationX", 0.0f, f.c(getContext(), 90.0f));
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            ofFloat5.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            ofFloat5.setInterpolator(sr.c(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) f.c(getContext(), 90.0f));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) SlideRightView.this.sr.getLayoutParams();
                layoutParams.width = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                SlideRightView.this.sr.setLayoutParams(layoutParams);
            }
        });
        if (i4 >= 21) {
            ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            ofInt.setInterpolator(sr.c(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.xv, "translationX", 0.0f, f.c(getContext(), 90.0f));
        if (i4 >= 21) {
            ofFloat6.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            ofFloat6.setInterpolator(sr.c(0.2f, 0.0f, 0.3f, 1.0f));
        }
        this.gd.setDuration(1500L);
        this.gd.playTogether(ofFloat5, ofInt, ofFloat6);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f29612w, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.sr, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.xv, "alpha", 1.0f, 0.0f);
        this.f29611r.setDuration(50L);
        this.f29611r.playTogether(ofFloat7, ofFloat8, ofFloat9);
        this.f29610f.playSequentially(this.ev, this.gd, this.f29611r);
    }

    private void xv() {
        ImageView imageView = new ImageView(this.f29609c);
        this.sr = imageView;
        imageView.setBackgroundResource(i.sr(this.f29609c, "tt_splash_slide_right_bg"));
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(0, -2);
        layoutParams.gravity = 48;
        layoutParams.leftMargin = (int) f.c(this.f29609c, 30.0f);
        addView(this.sr, layoutParams);
        setClipChildren(false);
        setClipToPadding(false);
        ImageView imageView2 = new ImageView(this.f29609c);
        this.xv = imageView2;
        imageView2.setImageResource(i.sr(this.f29609c, "tt_splash_slide_right_circle"));
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams((int) f.c(this.f29609c, 50.0f), (int) f.c(this.f29609c, 50.0f));
        layoutParams2.gravity = 48;
        layoutParams2.leftMargin = (int) f.c(this.f29609c, 30.0f);
        addView(this.xv, layoutParams2);
        ImageView imageView3 = new ImageView(this.f29609c);
        this.f29612w = imageView3;
        imageView3.setImageResource(i.sr(this.f29609c, "tt_splash_hand2"));
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) f.c(this.f29609c, 80.0f), (int) f.c(this.f29609c, 80.0f));
        layoutParams3.gravity = 48;
        layoutParams3.leftMargin = (int) f.c(this.f29609c, 30.0f);
        addView(this.f29612w, layoutParams3);
        TextView textView = new TextView(this.f29609c);
        this.ux = textView;
        textView.setTextColor(-1);
        this.ux.setSingleLine();
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams4.gravity = 80;
        addView(this.ux, layoutParams4);
        post(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.1
            @Override // java.lang.Runnable
            public void run() {
                FrameLayout.LayoutParams layoutParams5 = (FrameLayout.LayoutParams) SlideRightView.this.f29612w.getLayoutParams();
                layoutParams5.topMargin = (int) ((SlideRightView.this.xv.getMeasuredHeight() / 2.0f) - f.c(SlideRightView.this.getContext(), 7.0f));
                int c4 = (-SlideRightView.this.xv.getMeasuredWidth()) + ((int) f.c(SlideRightView.this.f29609c, 30.0f));
                layoutParams5.leftMargin = c4;
                layoutParams5.setMarginStart(c4);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.f29612w.setLayoutParams(layoutParams5);
                FrameLayout.LayoutParams layoutParams6 = (FrameLayout.LayoutParams) SlideRightView.this.sr.getLayoutParams();
                layoutParams6.topMargin = (int) ((SlideRightView.this.xv.getMeasuredHeight() / 2.0f) - f.c(SlideRightView.this.getContext(), 5.0f));
                layoutParams6.leftMargin = (int) ((SlideRightView.this.xv.getMeasuredWidth() / 2.0f) + ((int) f.c(SlideRightView.this.f29609c, 30.0f)));
                layoutParams5.setMarginStart(layoutParams5.leftMargin);
                layoutParams5.setMarginEnd(layoutParams5.rightMargin);
                SlideRightView.this.sr.setLayoutParams(layoutParams6);
            }
        });
    }

    public void c() {
        sr();
        this.f29610f.start();
        this.f29610f.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideRightView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideRightView.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideRightView.this.f29610f.start();
                    }
                }, 200L);
            }
        });
    }

    public void w() {
        try {
            AnimatorSet animatorSet = this.f29610f;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.ev;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.gd;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.f29611r;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Throwable unused) {
        }
    }
}
