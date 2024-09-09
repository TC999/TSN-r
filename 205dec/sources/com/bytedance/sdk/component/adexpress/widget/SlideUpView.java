package com.bytedance.sdk.component.adexpress.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.view.animation.PathInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bytedance.sdk.component.adexpress.c.w.sr;
import com.bytedance.sdk.component.adexpress.sr.f;
import com.bytedance.sdk.component.utils.a;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class SlideUpView extends RelativeLayout {

    /* renamed from: c  reason: collision with root package name */
    private ImageView f29619c;
    private AnimatorSet ev;

    /* renamed from: f  reason: collision with root package name */
    private AnimatorSet f29620f;
    private AnimatorSet gd;

    /* renamed from: k  reason: collision with root package name */
    private int f29621k;

    /* renamed from: p  reason: collision with root package name */
    private String f29622p;

    /* renamed from: r  reason: collision with root package name */
    private AnimatorSet f29623r;
    private TextView sr;
    private TextView ux;

    /* renamed from: w  reason: collision with root package name */
    private ImageView f29624w;
    private ImageView xv;

    public SlideUpView(Context context) {
        super(context);
        this.f29620f = new AnimatorSet();
        this.f29623r = new AnimatorSet();
        this.ev = new AnimatorSet();
        this.gd = new AnimatorSet();
        this.f29621k = 100;
        c(context);
    }

    public AnimatorSet getSlideUpAnimatorSet() {
        return this.f29620f;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        w();
    }

    public void setGuideText(String str) {
        TextView textView = this.sr;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setSlideText(String str) {
        if (this.ux != null) {
            if (TextUtils.isEmpty(str)) {
                this.ux.setText("");
            } else {
                this.ux.setText(str);
            }
        }
    }

    public void xv() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.f29619c, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.f29619c, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.f29619c, "translationY", 0.0f, f.c(getContext(), -this.f29621k));
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            ofFloat3.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            ofFloat3.setInterpolator(sr.c(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(0, (int) f.c(getContext(), this.f29621k));
        ofInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (SlideUpView.this.xv != null) {
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) SlideUpView.this.xv.getLayoutParams();
                    layoutParams.height = ((Integer) valueAnimator.getAnimatedValue()).intValue();
                    SlideUpView.this.xv.setLayoutParams(layoutParams);
                }
            }
        });
        if (i4 >= 21) {
            ofInt.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            ofInt.setInterpolator(sr.c(0.2f, 0.0f, 0.3f, 1.0f));
        }
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.xv, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat5 = ObjectAnimator.ofFloat(this.xv, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat6 = ObjectAnimator.ofFloat(this.f29624w, "alpha", 0.0f, 1.0f);
        ObjectAnimator ofFloat7 = ObjectAnimator.ofFloat(this.f29624w, "alpha", 1.0f, 0.0f);
        ObjectAnimator ofFloat8 = ObjectAnimator.ofFloat(this.f29624w, "scaleX", 0.0f, 1.0f);
        ObjectAnimator ofFloat9 = ObjectAnimator.ofFloat(this.f29624w, "scaleY", 0.0f, 1.0f);
        ObjectAnimator ofFloat10 = ObjectAnimator.ofFloat(this.f29624w, "translationY", 0.0f, f.c(getContext(), -this.f29621k));
        if (i4 >= 21) {
            ofFloat10.setInterpolator(new PathInterpolator(0.2f, 0.0f, 0.3f, 1.0f));
        } else {
            ofFloat10.setInterpolator(sr.c(0.2f, 0.0f, 0.3f, 1.0f));
        }
        this.f29623r.setDuration(50L);
        this.gd.setDuration(1500L);
        this.ev.setDuration(50L);
        this.f29623r.playTogether(ofFloat2, ofFloat7, ofFloat5);
        this.ev.playTogether(ofFloat, ofFloat6, ofFloat8, ofFloat9, ofFloat4);
        this.gd.playTogether(ofFloat3, ofInt, ofFloat10);
        this.f29620f.playSequentially(this.ev, this.gd, this.f29623r);
    }

    protected void c(Context context) {
        if (context == null) {
            context = com.bytedance.sdk.component.adexpress.sr.getContext();
        }
        if ("5".equals(this.f29622p)) {
            addView(com.bytedance.sdk.component.adexpress.xv.c.r(context));
            double d4 = this.f29621k;
            Double.isNaN(d4);
            this.f29621k = (int) (d4 * 1.25d);
        } else {
            addView(com.bytedance.sdk.component.adexpress.xv.c.f(context));
        }
        this.f29619c = (ImageView) findViewById(2097610734);
        this.f29624w = (ImageView) findViewById(2097610735);
        this.sr = (TextView) findViewById(2097610730);
        this.xv = (ImageView) findViewById(2097610733);
        this.ux = (TextView) findViewById(2097610731);
    }

    public void w() {
        try {
            AnimatorSet animatorSet = this.f29620f;
            if (animatorSet != null) {
                animatorSet.cancel();
            }
            AnimatorSet animatorSet2 = this.ev;
            if (animatorSet2 != null) {
                animatorSet2.cancel();
            }
            AnimatorSet animatorSet3 = this.f29623r;
            if (animatorSet3 != null) {
                animatorSet3.cancel();
            }
            AnimatorSet animatorSet4 = this.gd;
            if (animatorSet4 != null) {
                animatorSet4.cancel();
            }
        } catch (Exception e4) {
            a.xv(e4.getMessage());
        }
    }

    public SlideUpView(Context context, String str) {
        super(context);
        this.f29620f = new AnimatorSet();
        this.f29623r = new AnimatorSet();
        this.ev = new AnimatorSet();
        this.gd = new AnimatorSet();
        this.f29621k = 100;
        setClipChildren(false);
        this.f29622p = str;
        c(context);
    }

    public void c() {
        xv();
        this.f29620f.start();
        this.f29620f.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                super.onAnimationEnd(animator);
                SlideUpView.this.postDelayed(new Runnable() { // from class: com.bytedance.sdk.component.adexpress.widget.SlideUpView.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        SlideUpView.this.f29620f.start();
                    }
                }, 200L);
            }
        });
    }
}
