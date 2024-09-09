package com.bytedance.sdk.component.adexpress.widget;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Interpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.utils.q;
import com.stub.StubApp;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ShakeAnimationView extends LinearLayout {

    /* renamed from: c  reason: collision with root package name */
    private TextView f29597c;
    private LinearLayout ev;

    /* renamed from: f  reason: collision with root package name */
    private TextView f29598f;
    private int gd;

    /* renamed from: k  reason: collision with root package name */
    private int f29599k;

    /* renamed from: p  reason: collision with root package name */
    private int f29600p;

    /* renamed from: r  reason: collision with root package name */
    private c f29601r;
    private q sr;
    private TextView ux;

    /* renamed from: w  reason: collision with root package name */
    private TextView f29602w;
    private ImageView xv;

    /* renamed from: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView$1  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    class AnonymousClass1 implements Runnable {
        AnonymousClass1() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (ShakeAnimationView.this.xv != null) {
                final RotateAnimation rotateAnimation = new RotateAnimation(-14.0f, 14.0f, 1, 0.9f, 1, 0.9f);
                rotateAnimation.setInterpolator(new w(null));
                rotateAnimation.setDuration(1000L);
                rotateAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1
                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        ShakeAnimationView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.1.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ShakeAnimationView.this.xv.startAnimation(rotateAnimation);
                            }
                        }, 250L);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                    }
                });
                ShakeAnimationView.this.xv.startAnimation(rotateAnimation);
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(boolean z3);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class w implements Interpolator {
        private w() {
        }

        @Override // android.animation.TimeInterpolator
        public float getInterpolation(float f4) {
            return f4 <= 0.25f ? (f4 * (-2.0f)) + 0.5f : f4 <= 0.5f ? (f4 * 4.0f) - 1.0f : f4 <= 0.75f ? (f4 * (-4.0f)) + 3.0f : (f4 * 2.0f) - 1.5f;
        }

        /* synthetic */ w(AnonymousClass1 anonymousClass1) {
            this();
        }
    }

    public ShakeAnimationView(Context context, View view, int i4, int i5, int i6) {
        super(context);
        this.gd = i4;
        this.f29600p = i5;
        this.f29599k = i6;
        c(context, view);
    }

    public LinearLayout getShakeLayout() {
        return this.ev;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (isShown()) {
            if (this.sr == null) {
                this.sr = new q(StubApp.getOrigApplicationContext(getContext().getApplicationContext()), 1);
            }
            this.sr.c(new q.c() { // from class: com.bytedance.sdk.component.adexpress.widget.ShakeAnimationView.2
                @Override // com.bytedance.sdk.component.utils.q.c
                public void c(int i4) {
                    boolean ux = ShakeAnimationView.this.sr != null ? ShakeAnimationView.this.sr.ux() : false;
                    if (i4 == 1 && ShakeAnimationView.this.isShown() && ShakeAnimationView.this.f29601r != null) {
                        ShakeAnimationView.this.f29601r.c(ux);
                    }
                }
            });
            this.sr.c(this.gd);
            this.sr.xv(this.f29600p);
            this.sr.c(this.f29599k);
            this.sr.c();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q qVar = this.sr;
        if (qVar != null) {
            qVar.w();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        q qVar = this.sr;
        if (qVar != null) {
            if (z3) {
                qVar.c();
            } else {
                qVar.w();
            }
        }
    }

    public void setOnShakeViewListener(c cVar) {
        this.f29601r = cVar;
    }

    public void setShakeText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.ux.setVisibility(8);
            this.f29598f.setVisibility(8);
            return;
        }
        this.ux.setText(str);
    }

    protected void c(Context context, View view) {
        addView(view);
        this.ev = (LinearLayout) findViewById(2097610727);
        this.xv = (ImageView) findViewById(2097610725);
        this.f29597c = (TextView) findViewById(2097610724);
        this.f29602w = (TextView) findViewById(2097610726);
        this.ux = (TextView) findViewById(2097610723);
        this.f29598f = (TextView) findViewById(2097610728);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setColor(Color.parseColor("#57000000"));
        this.ev.setBackground(gradientDrawable);
    }

    public void c() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this, "alpha", 0.0f, 1.0f);
        ofFloat.setDuration(300L);
        ofFloat.start();
        postDelayed(new AnonymousClass1(), 500L);
    }
}
