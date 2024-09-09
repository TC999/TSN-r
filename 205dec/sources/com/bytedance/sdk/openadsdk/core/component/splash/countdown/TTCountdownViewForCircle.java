package com.bytedance.sdk.openadsdk.core.component.splash.countdown;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.sdk.openadsdk.core.ls;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class TTCountdownViewForCircle extends View implements w {

    /* renamed from: a  reason: collision with root package name */
    private float f32885a;
    private String bk;

    /* renamed from: c  reason: collision with root package name */
    private int f32886c;
    private boolean ck;
    private int ev;

    /* renamed from: f  reason: collision with root package name */
    private float f32887f;
    private Paint fp;
    private float fz;
    private ValueAnimator gb;
    private boolean gd;

    /* renamed from: i  reason: collision with root package name */
    private RectF f32888i;
    private Paint ia;

    /* renamed from: j  reason: collision with root package name */
    private AnimatorSet f32889j;

    /* renamed from: k  reason: collision with root package name */
    private float f32890k;
    private ValueAnimator ls;

    /* renamed from: n  reason: collision with root package name */
    private ValueAnimator f32891n;

    /* renamed from: p  reason: collision with root package name */
    private float f32892p;

    /* renamed from: q  reason: collision with root package name */
    private c f32893q;

    /* renamed from: r  reason: collision with root package name */
    private float f32894r;

    /* renamed from: s  reason: collision with root package name */
    private Paint f32895s;
    private int sr;

    /* renamed from: t  reason: collision with root package name */
    private boolean f32896t;

    /* renamed from: u  reason: collision with root package name */
    private float f32897u;
    private float ux;

    /* renamed from: w  reason: collision with root package name */
    private int f32898w;
    private int xv;
    private Paint ys;

    /* renamed from: z  reason: collision with root package name */
    private AtomicBoolean f32899z;

    public TTCountdownViewForCircle(Context context) {
        this(context, null);
    }

    private int f() {
        return (int) ((((this.ux / 2.0f) + this.f32894r) * 2.0f) + c(4.0f));
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.gb;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.gb = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.fz, 0.0f);
        this.gb = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.gb.setDuration(c(this.fz, this.f32892p) * 1000.0f);
        this.gb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.fz = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.gb;
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.ls;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.ls = null;
        }
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f32897u, 0.0f);
        this.ls = ofFloat;
        ofFloat.setInterpolator(new LinearInterpolator());
        this.ls.setDuration(c(this.f32897u, this.f32890k) * 1000.0f);
        this.ls.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.f32897u = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.ls;
    }

    private void r() {
        try {
            AnimatorSet animatorSet = this.f32889j;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.f32889j = null;
            }
            ValueAnimator valueAnimator = this.f32891n;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.f32891n = null;
            }
            ValueAnimator valueAnimator2 = this.ls;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.ls = null;
            }
            ValueAnimator valueAnimator3 = this.gb;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.gb = null;
            }
            this.fz = 1.0f;
            this.f32897u = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
    }

    private void sr() {
        Paint paint = new Paint(1);
        this.ys = paint;
        paint.setColor(this.f32886c);
        this.ys.setStrokeWidth(this.ux);
        this.ys.setAntiAlias(true);
        this.ys.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.fp = paint2;
        paint2.setColor(this.xv);
        this.fp.setAntiAlias(true);
        this.fp.setStrokeWidth(this.ux);
        this.fp.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.ia = paint3;
        paint3.setColor(this.f32898w);
        this.ia.setAntiAlias(true);
        this.ia.setStrokeWidth(this.ux / 2.0f);
        this.ia.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.f32895s = paint4;
        paint4.setColor(this.sr);
        this.ia.setAntiAlias(true);
        this.f32895s.setTextSize(this.f32887f);
        this.f32895s.setTextAlign(Paint.Align.CENTER);
    }

    private void ux() {
        float f4 = this.f32894r;
        this.f32888i = new RectF(-f4, -f4, f4, f4);
    }

    public float c(float f4, float f5) {
        return f4 * f5;
    }

    public float c(float f4, int i4) {
        return i4 * f4;
    }

    public c getCountdownListener() {
        return this.f32893q;
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.w
    public View getView() {
        return this;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        r();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        w(canvas);
        c(canvas);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        int size = View.MeasureSpec.getSize(i4);
        int mode = View.MeasureSpec.getMode(i4);
        int size2 = View.MeasureSpec.getSize(i5);
        int mode2 = View.MeasureSpec.getMode(i5);
        if (mode != 1073741824) {
            size = f();
        }
        if (mode2 != 1073741824) {
            size2 = f();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z3) {
        super.onWindowFocusChanged(z3);
        this.f32899z.set(z3);
        if (!this.f32899z.get()) {
            w();
            c cVar = this.f32893q;
            if (cVar != null) {
                cVar.xv();
                return;
            }
            return;
        }
        xv();
        c cVar2 = this.f32893q;
        if (cVar2 != null) {
            cVar2.c();
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.w
    public void setCountDownTime(int i4) {
        float f4 = i4;
        this.f32890k = f4;
        this.f32892p = f4;
        r();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.w
    public void setCountdownListener(c cVar) {
        this.f32893q = cVar;
        if (this.f32899z.get() || cVar == null) {
            return;
        }
        cVar.xv();
    }

    public void xv() {
        try {
            AnimatorSet animatorSet = this.f32889j;
            if (animatorSet == null || Build.VERSION.SDK_INT < 19) {
                return;
            }
            animatorSet.resume();
        } catch (Throwable unused) {
        }
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f32886c = Color.parseColor("#fce8b6");
        this.f32898w = Color.parseColor("#f0f0f0");
        this.xv = Color.parseColor("#ffffff");
        this.sr = Color.parseColor("#7c7c7c");
        this.ux = 2.0f;
        this.f32887f = 12.0f;
        this.f32894r = 18.0f;
        this.ev = 270;
        this.gd = false;
        this.f32892p = 5.0f;
        this.f32890k = 5.0f;
        this.f32885a = 0.8f;
        this.bk = "\u8df3\u8fc7";
        this.f32896t = false;
        this.fz = 1.0f;
        this.f32897u = 1.0f;
        this.ck = false;
        this.f32899z = new AtomicBoolean(true);
        this.ux = c(2.0f);
        this.f32894r = c(18.0f);
        this.f32887f = w(12.0f);
        this.ev %= 360;
        sr();
        ux();
    }

    private void w(Canvas canvas) {
        float f4;
        canvas.save();
        float c4 = c(this.fz, 360);
        if (this.gd) {
            f4 = this.ev - c4;
        } else {
            f4 = this.ev;
        }
        canvas.drawCircle(0.0f, 0.0f, this.f32894r, this.fp);
        canvas.drawCircle(0.0f, 0.0f, this.f32894r, this.ia);
        canvas.drawArc(this.f32888i, f4, c4, false, this.ys);
        canvas.restore();
    }

    private void c(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.f32895s.getFontMetrics();
        String ge = ls.w().ge();
        this.bk = ge;
        if (TextUtils.isEmpty(ge)) {
            this.bk = "\u8df3\u8fc7";
        }
        canvas.drawText(this.bk, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.f32895s);
        canvas.restore();
    }

    @Override // com.bytedance.sdk.openadsdk.core.component.splash.countdown.w
    public void c() {
        AnimatorSet animatorSet = this.f32889j;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.f32889j.cancel();
            this.f32889j = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.f32889j = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.f32889j.setInterpolator(new LinearInterpolator());
        this.f32889j.addListener(new AnimatorListenerAdapter() { // from class: com.bytedance.sdk.openadsdk.core.component.splash.countdown.TTCountdownViewForCircle.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownViewForCircle.this.ck = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (!TTCountdownViewForCircle.this.ck) {
                    if (TTCountdownViewForCircle.this.f32893q != null) {
                        TTCountdownViewForCircle.this.f32893q.w();
                        return;
                    }
                    return;
                }
                TTCountdownViewForCircle.this.ck = false;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (declaredField.getFloat(null) < 1.0f) {
                declaredField.setFloat(null, 1.0f);
            }
        } catch (Throwable unused) {
        }
        this.f32889j.start();
        if (this.f32899z.get()) {
            return;
        }
        w();
    }

    private float w(float f4) {
        return TypedValue.applyDimension(2, f4, getResources().getDisplayMetrics());
    }

    public void w() {
        try {
            AnimatorSet animatorSet = this.f32889j;
            if (animatorSet == null || Build.VERSION.SDK_INT < 19) {
                return;
            }
            animatorSet.pause();
        } catch (Throwable unused) {
        }
    }

    private float c(float f4) {
        return TypedValue.applyDimension(1, f4, getResources().getDisplayMetrics());
    }
}
