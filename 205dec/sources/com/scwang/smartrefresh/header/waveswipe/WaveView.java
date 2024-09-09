package com.scwang.smartrefresh.header.waveswipe;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import androidx.annotation.ColorInt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WaveView extends View implements ViewTreeObserver.OnPreDrawListener {
    private static final int A = -1728053248;
    private static final float[][] B = {new float[]{0.1655f, 0.0f}, new float[]{0.4188f, -0.0109f}, new float[]{0.4606f, -0.0049f}, new float[]{0.4893f, 0.0f}, new float[]{0.4893f, 0.0f}, new float[]{0.5f, 0.0f}};
    private static final float[][] C = {new float[]{0.1655f, 0.0f}, new float[]{0.5237f, 0.0553f}, new float[]{0.4557f, 0.0936f}, new float[]{0.3908f, 0.1302f}, new float[]{0.4303f, 0.2173f}, new float[]{0.5f, 0.2173f}};
    private static final float[][] D = {new float[]{0.1655f, 0.0f}, new float[]{0.5909f, 0.0f}, new float[]{0.4557f, 0.1642f}, new float[]{0.3941f, 0.2061f}, new float[]{0.4303f, 0.2889f}, new float[]{0.5f, 0.2889f}};

    /* renamed from: u  reason: collision with root package name */
    private static final long f47819u = 500;

    /* renamed from: v  reason: collision with root package name */
    private static final long f47820v = 500;

    /* renamed from: w  reason: collision with root package name */
    private static final long f47821w = 500;

    /* renamed from: x  reason: collision with root package name */
    private static final int f47822x = 200;

    /* renamed from: y  reason: collision with root package name */
    private static final int f47823y = 1000;

    /* renamed from: z  reason: collision with root package name */
    private static final float f47824z = 0.2f;

    /* renamed from: a  reason: collision with root package name */
    private float f47825a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f47826b;

    /* renamed from: c  reason: collision with root package name */
    private Path f47827c;

    /* renamed from: d  reason: collision with root package name */
    private Path f47828d;

    /* renamed from: e  reason: collision with root package name */
    private Path f47829e;

    /* renamed from: f  reason: collision with root package name */
    private Path f47830f;

    /* renamed from: g  reason: collision with root package name */
    private RectF f47831g;

    /* renamed from: h  reason: collision with root package name */
    private int f47832h;

    /* renamed from: i  reason: collision with root package name */
    private float f47833i;

    /* renamed from: j  reason: collision with root package name */
    private int f47834j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f47835k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f47836l;

    /* renamed from: m  reason: collision with root package name */
    private int f47837m;

    /* renamed from: n  reason: collision with root package name */
    private ValueAnimator f47838n;

    /* renamed from: o  reason: collision with root package name */
    private ValueAnimator f47839o;

    /* renamed from: p  reason: collision with root package name */
    private ValueAnimator f47840p;

    /* renamed from: q  reason: collision with root package name */
    private ValueAnimator f47841q;

    /* renamed from: r  reason: collision with root package name */
    private ValueAnimator f47842r;

    /* renamed from: s  reason: collision with root package name */
    private ValueAnimator f47843s;

    /* renamed from: t  reason: collision with root package name */
    private ValueAnimator.AnimatorUpdateListener f47844t;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.f47833i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.postInvalidateOnAnimation();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class c implements Animator.AnimatorListener {
        c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WaveView.this.n();
            WaveView.this.f47835k = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public class d implements ValueAnimator.AnimatorUpdateListener {
        d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.f47827c.moveTo(0.0f, 0.0f);
            float f4 = floatValue * 0.5f;
            WaveView.this.f47827c.quadTo(WaveView.this.f47832h * 0.25f, 0.0f, WaveView.this.f47832h * 0.333f, f4);
            WaveView.this.f47827c.quadTo(WaveView.this.f47832h * 0.5f, floatValue * 1.4f, WaveView.this.f47832h * 0.666f, f4);
            WaveView.this.f47827c.quadTo(WaveView.this.f47832h * 0.75f, 0.0f, WaveView.this.f47832h, 0.0f);
            WaveView.this.postInvalidate();
        }
    }

    public WaveView(Context context) {
        super(context);
        this.f47825a = 100.0f;
        this.f47835k = false;
        this.f47836l = false;
        this.f47844t = new a();
        getViewTreeObserver().addOnPreDrawListener(this);
        j();
    }

    private void j() {
        p();
        q();
        n();
        this.f47831g = new RectF();
        setLayerType(1, null);
    }

    private void m() {
        ValueAnimator valueAnimator = this.f47843s;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f47843s.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.f47838n = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.f47839o = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.f47840p = ValueAnimator.ofFloat(0.0f, 0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-1000.0f, -1000.0f);
        this.f47841q = ofFloat;
        ofFloat.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.f47842r = ofFloat2;
        ofFloat2.setDuration(1L);
        this.f47842r.start();
    }

    private void p() {
        float f4 = getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.f47826b = paint;
        paint.setColor(-14575885);
        this.f47826b.setAntiAlias(true);
        this.f47826b.setStyle(Paint.Style.FILL);
        this.f47826b.setShadowLayer((int) ((f4 * 2.0f) + 0.5f), 0.0f, 0.0f, -1728053248);
    }

    private void q() {
        this.f47827c = new Path();
        this.f47828d = new Path();
        this.f47829e = new Path();
        this.f47830f = new Path();
    }

    private void v(int i4) {
        float f4 = i4;
        if ((this.f47832h / 1440.0f) * 500.0f > f4) {
            Log.w("WaveView", "DropHeight is more than " + ((this.f47832h / 1440.0f) * 500.0f));
            return;
        }
        this.f47834j = (int) Math.min(f4, getHeight() - this.f47825a);
        if (this.f47835k) {
            this.f47835k = false;
            l();
        }
    }

    public void f() {
        if (this.f47842r.isRunning()) {
            return;
        }
        t();
        u(0.1f);
    }

    public void g(float f4, float f5) {
        m();
        this.f47827c.moveTo(0.0f, 0.0f);
        Path path = this.f47827c;
        int i4 = this.f47832h;
        float[][] fArr = C;
        float[][] fArr2 = B;
        path.cubicTo(fArr[0][0] * i4, fArr[0][1] * i4, Math.min(fArr2[1][0] + f5, fArr[1][0]) * i4, Math.max((fArr2[1][1] + f4) - f5, fArr[1][1]) * this.f47832h, Math.max(fArr2[2][0] - f5, fArr[2][0]) * this.f47832h, Math.max((fArr2[2][1] + f4) - f5, fArr[2][1]) * this.f47832h);
        Path path2 = this.f47827c;
        float max = this.f47832h * Math.max(fArr2[3][0] - f5, fArr[3][0]);
        float min = this.f47832h * Math.min(fArr2[3][1] + f4 + f5, fArr[3][1]);
        float max2 = this.f47832h * Math.max(fArr2[4][0] - f5, fArr[4][0]);
        float min2 = this.f47832h * Math.min(fArr2[4][1] + f4 + f5, fArr[4][1]);
        int i5 = this.f47832h;
        path2.cubicTo(max, min, max2, min2, i5 * fArr[5][0], i5 * Math.min(fArr2[0][1] + f4 + f5, fArr[5][1]));
        Path path3 = this.f47827c;
        int i6 = this.f47832h;
        float max3 = i6 - (i6 * Math.max(fArr2[4][0] - f5, fArr[4][0]));
        float min3 = this.f47832h * Math.min(fArr2[4][1] + f4 + f5, fArr[4][1]);
        int i7 = this.f47832h;
        float max4 = i7 - (i7 * Math.max(fArr2[3][0] - f5, fArr[3][0]));
        float min4 = this.f47832h * Math.min(fArr2[3][1] + f4 + f5, fArr[3][1]);
        int i8 = this.f47832h;
        path3.cubicTo(max3, min3, max4, min4, i8 - (i8 * Math.max(fArr2[2][0] - f5, fArr[2][0])), this.f47832h * Math.max((fArr2[2][1] + f4) - f5, fArr[2][1]));
        Path path4 = this.f47827c;
        int i9 = this.f47832h;
        float min5 = i9 - (i9 * Math.min(fArr2[1][0] + f5, fArr[1][0]));
        float max5 = this.f47832h * Math.max((fArr2[1][1] + f4) - f5, fArr[1][1]);
        int i10 = this.f47832h;
        path4.cubicTo(min5, max5, i10 - (i10 * fArr[0][0]), i10 * fArr[0][1], i10, 0.0f);
        this.f47833i = (this.f47832h * Math.min(fArr2[3][1] + f4 + f5, fArr[3][1])) + this.f47825a;
        postInvalidateOnAnimation();
    }

    public float getCurrentCircleCenterY() {
        return this.f47833i;
    }

    public void h(float f4) {
        m();
        this.f47827c.moveTo(0.0f, 0.0f);
        Path path = this.f47827c;
        int i4 = this.f47832h;
        float[][] fArr = B;
        path.cubicTo(fArr[0][0] * i4, fArr[0][1], fArr[1][0] * i4, (fArr[1][1] + f4) * i4, fArr[2][0] * i4, i4 * (fArr[2][1] + f4));
        Path path2 = this.f47827c;
        int i5 = this.f47832h;
        path2.cubicTo(i5 * fArr[3][0], i5 * (fArr[3][1] + f4), i5 * fArr[4][0], i5 * (fArr[4][1] + f4), i5 * fArr[5][0], i5 * (fArr[5][1] + f4));
        Path path3 = this.f47827c;
        int i6 = this.f47832h;
        path3.cubicTo(i6 - (i6 * fArr[4][0]), i6 * (fArr[4][1] + f4), i6 - (i6 * fArr[3][0]), i6 * (fArr[3][1] + f4), i6 - (i6 * fArr[2][0]), i6 * (fArr[2][1] + f4));
        Path path4 = this.f47827c;
        int i7 = this.f47832h;
        path4.cubicTo(i7 - (i7 * fArr[1][0]), i7 * (fArr[1][1] + f4), i7 - (i7 * fArr[0][0]), fArr[0][1], i7, 0.0f);
        postInvalidateOnAnimation();
    }

    public void i(float f4, float f5, float f6) {
        m();
        this.f47827c.moveTo(0.0f, 0.0f);
        Path path = this.f47827c;
        int i4 = this.f47832h;
        float[][] fArr = D;
        float[][] fArr2 = B;
        float[][] fArr3 = C;
        path.cubicTo(fArr[0][0] * i4, fArr[0][1] * i4, Math.min(Math.min(fArr2[1][0] + f5, fArr3[1][0]) + f6, fArr[1][0]) * i4, Math.max(Math.max((fArr2[1][1] + f4) - f5, fArr3[1][1]) - f6, fArr[1][1]) * this.f47832h, Math.max(fArr2[2][0] - f5, fArr[2][0]) * this.f47832h, Math.min(Math.max((fArr2[2][1] + f4) - f5, fArr3[2][1]) + f6, fArr[2][1]) * this.f47832h);
        Path path2 = this.f47827c;
        float min = this.f47832h * Math.min(Math.max(fArr2[3][0] - f5, fArr3[3][0]) + f6, fArr[3][0]);
        float min2 = this.f47832h * Math.min(Math.min(fArr2[3][1] + f4 + f5, fArr3[3][1]) + f6, fArr[3][1]);
        float max = this.f47832h * Math.max(fArr2[4][0] - f5, fArr[4][0]);
        float min3 = this.f47832h * Math.min(Math.min(fArr2[4][1] + f4 + f5, fArr3[4][1]) + f6, fArr[4][1]);
        int i5 = this.f47832h;
        path2.cubicTo(min, min2, max, min3, i5 * fArr[5][0], i5 * Math.min(Math.min(fArr2[0][1] + f4 + f5, fArr3[5][1]) + f6, fArr[5][1]));
        Path path3 = this.f47827c;
        int i6 = this.f47832h;
        float max2 = i6 - (i6 * Math.max(fArr2[4][0] - f5, fArr[4][0]));
        float min4 = this.f47832h * Math.min(Math.min(fArr2[4][1] + f4 + f5, fArr3[4][1]) + f6, fArr[4][1]);
        int i7 = this.f47832h;
        float min5 = i7 - (i7 * Math.min(Math.max(fArr2[3][0] - f5, fArr3[3][0]) + f6, fArr[3][0]));
        float min6 = this.f47832h * Math.min(Math.min(fArr2[3][1] + f4 + f5, fArr3[3][1]) + f6, fArr[3][1]);
        int i8 = this.f47832h;
        path3.cubicTo(max2, min4, min5, min6, i8 - (i8 * Math.max(fArr2[2][0] - f5, fArr[2][0])), this.f47832h * Math.min(Math.max((fArr2[2][1] + f4) - f5, fArr3[2][1]) + f6, fArr[2][1]));
        Path path4 = this.f47827c;
        int i9 = this.f47832h;
        float min7 = i9 - (i9 * Math.min(Math.min(fArr2[1][0] + f5, fArr3[1][0]) + f6, fArr[1][0]));
        float max3 = this.f47832h * Math.max(Math.max((fArr2[1][1] + f4) - f5, fArr3[1][1]) - f6, fArr[1][1]);
        int i10 = this.f47832h;
        path4.cubicTo(min7, max3, i10 - (i10 * fArr[0][0]), i10 * fArr[0][1], i10, 0.0f);
        this.f47833i = (this.f47832h * Math.min(Math.min(fArr2[3][1] + f4 + f5, fArr3[3][1]) + f6, fArr[3][1])) + this.f47825a;
        postInvalidateOnAnimation();
    }

    public boolean k() {
        return this.f47842r.isRunning();
    }

    public void l() {
        if (this.f47835k) {
            return;
        }
        this.f47835k = true;
        int i4 = this.f47834j;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i4, i4);
        this.f47841q = ofFloat;
        ofFloat.start();
        int i5 = this.f47834j;
        float f4 = this.f47825a;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(i5 - f4, i5 - f4);
        this.f47838n = ofFloat2;
        ofFloat2.start();
        this.f47833i = this.f47834j;
        postInvalidate();
    }

    public void o(int i4, int i5) {
        this.f47826b.setShadowLayer(i4, 0.0f, 0.0f, i5);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.f47842r;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f47842r.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.f47841q;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
            this.f47841q.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.f47838n;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
            this.f47838n.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.f47843s;
        if (valueAnimator4 != null) {
            valueAnimator4.end();
            this.f47843s.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator5 = this.f47840p;
        if (valueAnimator5 != null) {
            valueAnimator5.end();
            this.f47840p.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator6 = this.f47839o;
        if (valueAnimator6 != null) {
            valueAnimator6.end();
            this.f47839o.removeAllUpdateListeners();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f47827c, this.f47826b);
        if (!isInEditMode()) {
            this.f47827c.rewind();
            this.f47828d.rewind();
            this.f47829e.rewind();
        }
        float floatValue = ((Float) this.f47841q.getAnimatedValue()).floatValue();
        float f4 = this.f47832h / 2.0f;
        this.f47831g.setEmpty();
        float floatValue2 = ((Float) this.f47842r.getAnimatedValue()).floatValue();
        float floatValue3 = ((Float) this.f47839o.getAnimatedValue()).floatValue();
        float floatValue4 = ((Float) this.f47840p.getAnimatedValue()).floatValue();
        RectF rectF = this.f47831g;
        float f5 = this.f47825a;
        float f6 = floatValue3 + 1.0f;
        float f7 = 1.0f + floatValue4;
        rectF.set((f4 - ((f5 * f6) * floatValue2)) + ((f5 * floatValue4) / 2.0f), (((f5 * f7) * floatValue2) + floatValue) - ((f5 * floatValue3) / 2.0f), (((f6 * f5) * floatValue2) + f4) - ((floatValue4 * f5) / 2.0f), (floatValue - ((f7 * f5) * floatValue2)) + ((f5 * floatValue3) / 2.0f));
        float floatValue5 = ((Float) this.f47838n.getAnimatedValue()).floatValue();
        this.f47828d.moveTo(f4, floatValue5);
        double pow = Math.pow(this.f47825a, 2.0d);
        double d4 = floatValue * floatValue5;
        Double.isNaN(d4);
        double d5 = pow + d4;
        double d6 = floatValue;
        double pow2 = d5 - Math.pow(d6, 2.0d);
        double d7 = floatValue5 - floatValue;
        Double.isNaN(d7);
        double d8 = pow2 / d7;
        double d9 = this.f47832h;
        Double.isNaN(d9);
        double d10 = (d9 * (-2.0d)) / 2.0d;
        Double.isNaN(d6);
        double d11 = -d10;
        double pow3 = (d10 * d10) - (((Math.pow(d8 - d6, 2.0d) + Math.pow(f4, 2.0d)) - Math.pow(this.f47825a, 2.0d)) * 4.0d);
        float f8 = (float) d8;
        this.f47828d.lineTo((float) ((Math.sqrt(pow3) + d11) / 2.0d), f8);
        this.f47828d.lineTo((float) ((d11 - Math.sqrt(pow3)) / 2.0d), f8);
        this.f47828d.close();
        this.f47830f.set(this.f47828d);
        this.f47830f.addOval(this.f47831g, Path.Direction.CCW);
        this.f47829e.addOval(this.f47831g, Path.Direction.CCW);
        this.f47838n.isRunning();
        canvas.drawPath(this.f47828d, this.f47826b);
        canvas.drawPath(this.f47829e, this.f47826b);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f47836l) {
            v(this.f47837m);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        this.f47832h = i4;
        this.f47825a = i4 / 14.4f;
        v((int) Math.min(Math.min(i4, i5), getHeight() - this.f47825a));
        super.onSizeChanged(i4, i5, i6, i7);
    }

    @Override // android.view.View
    public void postInvalidateOnAnimation() {
        super.postInvalidateOnAnimation();
    }

    public void r(int i4, int i5, int i6, int i7) {
        this.f47826b.setARGB(i4, i5, i6, i7);
        invalidate();
    }

    public void s() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f47842r = ofFloat;
        ofFloat.addUpdateListener(this.f47844t);
        this.f47842r.setDuration(200L);
        this.f47842r.addListener(new c());
        this.f47842r.start();
    }

    public void setMaxDropHeight(int i4) {
        if (this.f47836l) {
            v(i4);
            return;
        }
        this.f47837m = i4;
        this.f47836l = true;
        if (getViewTreeObserver().isAlive()) {
            getViewTreeObserver().removeOnPreDrawListener(this);
            getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    public void setShadowRadius(int i4) {
        this.f47826b.setShadowLayer(i4, 0.0f, 0.0f, -1728053248);
    }

    public void setWaveColor(@ColorInt int i4) {
        this.f47826b.setColor(i4);
        invalidate();
    }

    public void t() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.f47842r = ofFloat;
        ofFloat.setDuration(1L);
        this.f47842r.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat((this.f47832h / 1440.0f) * 500.0f, this.f47834j);
        this.f47841q = ofFloat2;
        ofFloat2.setDuration(500L);
        this.f47841q.addUpdateListener(new b());
        this.f47841q.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f47841q.start();
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, this.f47834j - this.f47825a);
        this.f47838n = ofFloat3;
        ofFloat3.setDuration(500L);
        this.f47838n.addUpdateListener(this.f47844t);
        this.f47838n.start();
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f47839o = ofFloat4;
        ofFloat4.setDuration(500L);
        this.f47839o.addUpdateListener(this.f47844t);
        this.f47839o.setInterpolator(new com.scwang.smartrefresh.header.waveswipe.b());
        this.f47839o.setStartDelay(500L);
        this.f47839o.start();
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f47840p = ofFloat5;
        ofFloat5.setDuration(500L);
        this.f47840p.addUpdateListener(this.f47844t);
        this.f47840p.setInterpolator(new com.scwang.smartrefresh.header.waveswipe.b());
        this.f47840p.setStartDelay(625L);
        this.f47840p.start();
    }

    public void u(float f4) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(Math.min(f4, 0.2f) * this.f47832h, 0.0f);
        this.f47843s = ofFloat;
        ofFloat.setDuration(1000L);
        this.f47843s.addUpdateListener(new d());
        this.f47843s.setInterpolator(new BounceInterpolator());
        this.f47843s.start();
    }
}
