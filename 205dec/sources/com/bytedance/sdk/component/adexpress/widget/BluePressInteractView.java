package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class BluePressInteractView extends FrameLayout {

    /* renamed from: c  reason: collision with root package name */
    private AnimatorSet f29479c;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private View f29480f;
    private int gd;

    /* renamed from: p  reason: collision with root package name */
    private Context f29481p;

    /* renamed from: r  reason: collision with root package name */
    private ImageView f29482r;
    private View sr;
    private View ux;

    /* renamed from: w  reason: collision with root package name */
    private ObjectAnimator f29483w;
    private boolean xv;

    public BluePressInteractView(Context context, int i4, int i5) {
        super(context);
        this.xv = false;
        this.f29479c = new AnimatorSet();
        this.ev = i4;
        this.gd = i5;
        this.f29481p = context;
        xv();
        sr();
    }

    private void sr() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.sr, "scaleX", 1.0f, 2.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.sr, "scaleY", 1.0f, 2.0f, 1.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.ux, "scaleX", 1.0f, 2.5f, 1.0f);
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.ux, "scaleY", 1.0f, 2.5f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.f29480f, "scaleX", 1.0f, 1.5f, 1.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f29480f, "scaleY", 1.0f, 1.5f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f29482r, "rotation", 0.0f, -20.0f, 0.0f);
        this.f29483w = ofFloat7;
        ofFloat7.setDuration(1000L);
        this.f29479c.setDuration(1500L);
        this.f29479c.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f29479c.play(ofFloat).with(ofFloat2).with(ofFloat3).with(ofFloat4).with(ofFloat5).with(ofFloat6);
        this.f29479c.addListener(new Animator.AnimatorListener() { // from class: com.bytedance.sdk.component.adexpress.widget.BluePressInteractView.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                BluePressInteractView.this.xv = true;
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (BluePressInteractView.this.xv) {
                    return;
                }
                BluePressInteractView.this.f29483w.start();
                BluePressInteractView.this.f29479c.start();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
    }

    private void xv() {
        View view = new View(this.f29481p);
        this.sr = view;
        view.setBackground(c("#1A7BBEFF", "#337BBEFF"));
        double d4 = this.ev;
        Double.isNaN(d4);
        int i4 = (int) (d4 * 0.45d);
        double d5 = this.gd;
        Double.isNaN(d5);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(i4, (int) (d5 * 0.45d));
        layoutParams.gravity = 17;
        this.sr.setLayoutParams(layoutParams);
        addView(this.sr);
        View view2 = new View(this.f29481p);
        this.ux = view2;
        view2.setBackground(c("#337BBEFF", "#807BBEFF"));
        double d6 = this.ev;
        Double.isNaN(d6);
        int i5 = (int) (d6 * 0.25d);
        double d7 = this.gd;
        Double.isNaN(d7);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(i5, (int) (d7 * 0.25d));
        layoutParams2.gravity = 17;
        this.ux.setLayoutParams(layoutParams2);
        addView(this.ux);
        View view3 = new View(this.f29481p);
        this.f29480f = view3;
        view3.setBackground(c("#807BBEFF", "#FF7BBEFF"));
        int i6 = this.ev;
        double d8 = i6;
        Double.isNaN(d8);
        double d9 = i6;
        Double.isNaN(d9);
        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams((int) (d8 * 0.25d), (int) (d9 * 0.25d));
        layoutParams3.gravity = 17;
        this.f29480f.setLayoutParams(layoutParams3);
        addView(this.f29480f);
        ImageView imageView = new ImageView(this.f29481p);
        this.f29482r = imageView;
        imageView.setImageResource(i.sr(getContext(), "tt_blue_hand"));
        this.f29482r.setScaleType(ImageView.ScaleType.FIT_CENTER);
        double d10 = this.ev;
        Double.isNaN(d10);
        double d11 = this.gd;
        Double.isNaN(d11);
        FrameLayout.LayoutParams layoutParams4 = new FrameLayout.LayoutParams((int) (d10 * 0.62d), (int) (d11 * 0.53d));
        layoutParams4.gravity = 17;
        layoutParams4.topMargin = (layoutParams4.width / 2) - 5;
        layoutParams4.leftMargin = (layoutParams4.height / 2) - 5;
        this.f29482r.setLayoutParams(layoutParams4);
        addView(this.f29482r);
    }

    public void w() {
        this.xv = true;
        ObjectAnimator objectAnimator = this.f29483w;
        if (objectAnimator == null || this.f29479c == null) {
            return;
        }
        objectAnimator.cancel();
        this.f29479c.cancel();
    }

    private GradientDrawable c(String str, String str2) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor(str));
        gradientDrawable.setStroke(1, Color.parseColor(str2));
        return gradientDrawable;
    }

    public void c() {
        this.xv = false;
        ObjectAnimator objectAnimator = this.f29483w;
        if (objectAnimator == null || this.f29479c == null) {
            return;
        }
        objectAnimator.start();
        this.f29479c.start();
    }
}
