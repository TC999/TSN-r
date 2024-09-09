package com.kwad.components.ad.splashscreen.widget;

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
import com.kwad.components.core.s.n;
import com.kwad.sdk.R;
import com.kwad.sdk.widget.KSFrameLayout;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KsShakeView extends KSFrameLayout {
    private int Gb;
    private float Gc;
    @ColorInt
    private int Gd;
    @ColorInt
    private int Ge;
    @ColorInt
    private int Gf;
    private float Gg;
    private float Gh;
    @DrawableRes
    private int Gi;
    private Animator Gj;
    private boolean Gk;
    private ImageView fq;
    @Nullable
    private Animator fr;
    private Paint mPaint;

    public KsShakeView(@NonNull Context context) {
        this(context, null, 0);
    }

    private void lR() {
        this.fq.setImageResource(this.Gi);
    }

    private void setBgCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(this.Ge);
        paint.setAntiAlias(true);
    }

    private void setInnerCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Gg);
        paint.setColor(this.Gf);
        paint.setAntiAlias(true);
    }

    private void setOuterCirclePaint(Paint paint) {
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(this.Gc);
        paint.setColor(this.Gd);
        paint.setAntiAlias(true);
    }

    public final void ac(int i4) {
        this.Gb = i4;
        if (i4 != 2) {
            setIconDrawableRes(R.drawable.ksad_ic_shake_hand);
        } else {
            setIconDrawableRes(R.drawable.ksad_ic_shake_phone);
        }
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout
    public final void ad() {
        super.ad();
        Animator animator = this.fr;
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
        if (this.Gb == 2) {
            setInnerCirclePaint(this.mPaint);
            canvas.drawCircle(getWidth() / 2.0f, getHeight() / 2.0f, min - this.Gh, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    @MainThread
    public final void lV() {
        this.Gk = false;
        Animator animator = this.fr;
        if (animator != null) {
            animator.cancel();
            this.fr = null;
        }
        Animator a4 = a(this.fq, 100L, 16.0f);
        this.fr = a4;
        if (a4 != null) {
            a4.addListener(new AnimatorListenerAdapter() { // from class: com.kwad.components.ad.splashscreen.widget.KsShakeView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationCancel(Animator animator2) {
                    super.onAnimationCancel(animator2);
                    KsShakeView.this.fq.setRotation(0.0f);
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public final void onAnimationEnd(Animator animator2) {
                    super.onAnimationEnd(animator2);
                    if (KsShakeView.this.Gk || KsShakeView.this.fr == null) {
                        return;
                    }
                    KsShakeView.this.fr.start();
                }
            });
            this.fr.start();
        }
    }

    public final void lW() {
        Animator animator = this.fr;
        if (animator != null) {
            animator.cancel();
        }
        Animator animator2 = this.Gj;
        if (animator2 != null) {
            animator2.cancel();
        }
        this.fr = null;
        this.Gj = null;
    }

    @Override // com.kwad.sdk.widget.KSFrameLayout, android.widget.FrameLayout, android.view.View
    public void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
    }

    @MainThread
    public void setIconDrawableRes(@DrawableRes int i4) {
        ImageView imageView = this.fq;
        if (imageView != null) {
            imageView.setImageResource(i4);
        }
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KsShakeView, i4, 0);
        this.Gc = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_outerStrokeWidth, 1.0f);
        this.Gd = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_outerStrokeColor, Color.parseColor("#4DFFFFFF"));
        this.Ge = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_solidColor, Color.parseColor("#66000000"));
        this.Gb = obtainStyledAttributes.getInteger(R.styleable.ksad_KsShakeView_ksad_shakeViewStyle, 1);
        this.Gf = obtainStyledAttributes.getColor(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeColor, Color.parseColor("#B3FFFFFF"));
        this.Gg = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCircleStrokeWidth, 1.0f);
        this.Gi = obtainStyledAttributes.getResourceId(R.styleable.ksad_KsShakeView_ksad_shakeIcon, R.drawable.ksad_ic_shake_hand);
        this.Gh = obtainStyledAttributes.getDimension(R.styleable.ksad_KsShakeView_ksad_innerCirclePadding, com.kwad.sdk.d.a.a.a(context, 10.0f));
        obtainStyledAttributes.recycle();
        this.fq = new ImageView(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 17;
        addView(this.fq, layoutParams);
        lR();
    }

    public final void b(AnimatorListenerAdapter animatorListenerAdapter) {
        this.Gk = true;
        Animator animator = this.fr;
        if (animator != null) {
            animator.cancel();
        }
        this.fq.setRotation(0.0f);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.ksad_splash_shake_animator_height);
        Animator animator2 = this.Gj;
        if (animator2 != null) {
            animator2.cancel();
        }
        Animator b4 = b(this, 100L, dimensionPixelSize);
        this.Gj = b4;
        b4.addListener(animatorListenerAdapter);
        this.Gj.start();
    }

    public KsShakeView(@NonNull Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mPaint = new Paint();
        this.Gk = false;
        a(context, attributeSet, i4);
    }

    private static Animator b(View view, long j4, float f4) {
        Interpolator create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        ObjectAnimator duration = ObjectAnimator.ofFloat(view, "translationY", f4).setDuration(100L);
        duration.setInterpolator(create);
        float f5 = -f4;
        ObjectAnimator duration2 = ObjectAnimator.ofFloat(view, "translationY", f5).setDuration(200L);
        duration2.setInterpolator(create);
        ObjectAnimator duration3 = ObjectAnimator.ofFloat(view, "translationY", f4).setDuration(200L);
        duration3.setInterpolator(create);
        ObjectAnimator duration4 = ObjectAnimator.ofFloat(view, "translationY", f5).setDuration(200L);
        duration4.setInterpolator(create);
        animatorSet.playSequentially(duration, duration2, duration3, duration4, ObjectAnimator.ofFloat(view, "translationY", f4).setDuration(100L), ObjectAnimator.ofFloat(view, "alpha", 1.0f, 1.0f).setDuration(100L));
        return animatorSet;
    }

    private Animator a(View view, long j4, float f4) {
        Interpolator create;
        if (view == null) {
            return null;
        }
        if (this.Gb == 1) {
            create = PathInterpolatorCompat.create(0.22f, 0.59f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else {
            create = PathInterpolatorCompat.create(0.33f, 0.0f, 0.36f, 1.0f);
            view.setPivotX(view.getWidth() / 2.0f);
            view.setPivotY(view.getHeight() / 2.0f);
        }
        return n.a(view, create, 100L, 16.0f);
    }
}
