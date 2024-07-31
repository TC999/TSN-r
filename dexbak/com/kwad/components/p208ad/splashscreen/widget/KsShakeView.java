package com.kwad.components.p208ad.splashscreen.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.ColorInt;
import androidx.annotation.DrawableRes;
import androidx.annotation.MainThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.animation.PathInterpolatorCompat;
import com.kwad.components.core.p330s.C8951n;
import com.kwad.sdk.C9659R;
import com.kwad.sdk.p430d.p431a.C10751a;
import com.kwad.sdk.widget.KSFrameLayout;

/* renamed from: com.kwad.components.ad.splashscreen.widget.KsShakeView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KsShakeView extends KSFrameLayout {

    /* renamed from: Gb */
    private int f27930Gb;

    /* renamed from: Gc */
    private float f27931Gc;
    @ColorInt

    /* renamed from: Gd */
    private int f27932Gd;
    @ColorInt

    /* renamed from: Ge */
    private int f27933Ge;
    @ColorInt

    /* renamed from: Gf */
    private int f27934Gf;

    /* renamed from: Gg */
    private float f27935Gg;

    /* renamed from: Gh */
    private float f27936Gh;
    @DrawableRes

    /* renamed from: Gi */
    private int f27937Gi;

    /* renamed from: Gj */
    private Animator f27938Gj;

    /* renamed from: Gk */
    private boolean f27939Gk;

    /* renamed from: fq */
    private ImageView f27940fq;
    @Nullable

    /* renamed from: fr */
    private Animator f27941fr;
    private Paint mPaint;

    public KsShakeView(@NonNull Context context) {
        this(context, null, 0);
    }

    /* renamed from: lR */
    private void m30504lR() {
        this.f27940fq.setImageResource(this.f27937Gi);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.f27933Ge);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f27935Gg);
        paint.setColor(this.f27934Gf);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.f27931Gc);
        paint.setColor(this.f27932Gd);
        paint.setAntiAlias(true);
    }

    /* renamed from: ac */
    public final void m30509ac(int i) {
        this.f27930Gb = i;
        if (i != 2) {
            setIconDrawableRes(C9659R.C9661drawable.ksad_ic_shake_hand);
        } else {
            setIconDrawableRes(C9659R.C9661drawable.ksad_ic_shake_phone);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    /* renamed from: ad */
    public final void mo23564ad() {
        super.mo23564ad();
        Animator animator = this.f27941fr;
        if (animator != null) {
            animator.cancel();
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        float min = Math.min(getWidth(), getHeight()) / 2.0f;
        setBgCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        setOuterCirclePaint(this.mPaint);
        canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min, this.mPaint);
        if (this.f27930Gb == 2) {
            setInnerCirclePaint(this.mPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.f27936Gh, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @MainThread
    /* renamed from: lV */
    public final void m30503lV() {
        this.f27939Gk = false;
        Animator animator = this.f27941fr;
        if (animator != null) {
            animator.cancel();
            this.f27941fr = null;
        }
        Animator m30511a = m30511a(this.f27940fq, 100L, 16.0f);
        this.f27941fr = m30511a;
        if (m30511a != null) {
            m30511a.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.KsShakeView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    KsShakeView.this.f27940fq.setRotation(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (KsShakeView.this.f27939Gk || KsShakeView.this.f27941fr == null) {
                        return;
                    }
                    KsShakeView.this.f27941fr.start();
                }
            });
            this.f27941fr.start();
        }
    }

    /* renamed from: lW */
    public final void m30502lW() {
        Animator animator = this.f27941fr;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.f27938Gj;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.f27941fr = null;
        this.f27938Gj = null;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    @MainThread
    public void setIconDrawableRes(@DrawableRes int i) {
        ImageView imageView = this.f27940fq;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    /* renamed from: a */
    private void m30512a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_KsShakeView, i, 0);
        this.f27931Gc = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_KsShakeView_ksad_outerStrokeWidth, 1.0f);
        this.f27932Gd = obtainStyledAttributes.getColor(C9659R.styleable.ksad_KsShakeView_ksad_outerStrokeColor, Color.parseColor("#4DFFFFFF"));
        this.f27933Ge = obtainStyledAttributes.getColor(C9659R.styleable.ksad_KsShakeView_ksad_solidColor, Color.parseColor("#66000000"));
        this.f27930Gb = obtainStyledAttributes.getInteger(C9659R.styleable.ksad_KsShakeView_ksad_shakeViewStyle, 1);
        this.f27934Gf = obtainStyledAttributes.getColor(C9659R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeColor, Color.parseColor("#B3FFFFFF"));
        this.f27935Gg = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeWidth, 1.0f);
        this.f27937Gi = obtainStyledAttributes.getResourceId(C9659R.styleable.ksad_KsShakeView_ksad_shakeIcon, C9659R.C9661drawable.ksad_ic_shake_hand);
        this.f27936Gh = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_KsShakeView_ksad_innerCirclePadding, C10751a.m24924a(context, 10.0f));
        obtainStyledAttributes.recycle();
        this.f27940fq = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.f27940fq, layoutParams);
        m30504lR();
    }

    /* renamed from: b */
    public final void m30508b(AnimatorListenerAdapter animatorListenerAdapter) {
        this.f27939Gk = true;
        Animator animator = this.f27941fr;
        if (animator != null) {
            animator.cancel();
        }
        this.f27940fq.setRotation(0.0f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(C9659R.dimen.ksad_splash_shake_animator_height);
        Animator animator2 = this.f27938Gj;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator m30507b = m30507b(this, 100L, dimensionPixelSize);
        this.f27938Gj = m30507b;
        m30507b.addListener(animatorListenerAdapter);
        this.f27938Gj.start();
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.f27939Gk = false;
        m30512a(context, attributeSet, i);
    }

    /* renamed from: b */
    private static Animator m30507b(View view, long j, float f) {
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", f).setDuration(100L);
        duration.setInterpolator(create);
        float f2 = -f;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(200L);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", f).setDuration(200L);
        duration3.setInterpolator(create);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "translationY", f2).setDuration(200L);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "translationY", f).setDuration(100L), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(100L));
        return animatorSet;
    }

    /* renamed from: a */
    private Animator m30511a(View view, long j, float f) {
        Interpolator create;
        if (view == null) {
            return null;
        }
        if (this.f27930Gb == 1) {
            create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else {
            create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth() / 2.0f);
            view.setPivotY(view.getHeight() / 2.0f);
        }
        return C8951n.m29529a(view, create, 100L, 16.0f);
    }
}
