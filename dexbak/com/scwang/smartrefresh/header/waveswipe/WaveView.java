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

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WaveView extends View implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: A */
    private static final int f33434A = -1728053248;

    /* renamed from: B */
    private static final float[][] f33435B = {new float[]{0.1655f, 0.0f}, new float[]{0.4188f, -0.0109f}, new float[]{0.4606f, -0.0049f}, new float[]{0.4893f, 0.0f}, new float[]{0.4893f, 0.0f}, new float[]{0.5f, 0.0f}};

    /* renamed from: C */
    private static final float[][] f33436C = {new float[]{0.1655f, 0.0f}, new float[]{0.5237f, 0.0553f}, new float[]{0.4557f, 0.0936f}, new float[]{0.3908f, 0.1302f}, new float[]{0.4303f, 0.2173f}, new float[]{0.5f, 0.2173f}};

    /* renamed from: D */
    private static final float[][] f33437D = {new float[]{0.1655f, 0.0f}, new float[]{0.5909f, 0.0f}, new float[]{0.4557f, 0.1642f}, new float[]{0.3941f, 0.2061f}, new float[]{0.4303f, 0.2889f}, new float[]{0.5f, 0.2889f}};

    /* renamed from: u */
    private static final long f33438u = 500;

    /* renamed from: v */
    private static final long f33439v = 500;

    /* renamed from: w */
    private static final long f33440w = 500;

    /* renamed from: x */
    private static final int f33441x = 200;

    /* renamed from: y */
    private static final int f33442y = 1000;

    /* renamed from: z */
    private static final float f33443z = 0.2f;

    /* renamed from: a */
    private float f33444a;

    /* renamed from: b */
    private Paint f33445b;

    /* renamed from: c */
    private Path f33446c;

    /* renamed from: d */
    private Path f33447d;

    /* renamed from: e */
    private Path f33448e;

    /* renamed from: f */
    private Path f33449f;

    /* renamed from: g */
    private RectF f33450g;

    /* renamed from: h */
    private int f33451h;

    /* renamed from: i */
    private float f33452i;

    /* renamed from: j */
    private int f33453j;

    /* renamed from: k */
    private boolean f33454k;

    /* renamed from: l */
    private boolean f33455l;

    /* renamed from: m */
    private int f33456m;

    /* renamed from: n */
    private ValueAnimator f33457n;

    /* renamed from: o */
    private ValueAnimator f33458o;

    /* renamed from: p */
    private ValueAnimator f33459p;

    /* renamed from: q */
    private ValueAnimator f33460q;

    /* renamed from: r */
    private ValueAnimator f33461r;

    /* renamed from: s */
    private ValueAnimator f33462s;

    /* renamed from: t */
    private ValueAnimator.AnimatorUpdateListener f33463t;

    /* renamed from: com.scwang.smartrefresh.header.waveswipe.WaveView$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11877a implements ValueAnimator.AnimatorUpdateListener {
        C11877a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.postInvalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.waveswipe.WaveView$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11878b implements ValueAnimator.AnimatorUpdateListener {
        C11878b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.f33452i = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.postInvalidateOnAnimation();
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.waveswipe.WaveView$c */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11879c implements Animator.AnimatorListener {
        C11879c() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WaveView.this.m20005n();
            WaveView.this.f33454k = false;
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.scwang.smartrefresh.header.waveswipe.WaveView$d */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public class C11880d implements ValueAnimator.AnimatorUpdateListener {
        C11880d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.f33446c.moveTo(0.0f, 0.0f);
            float f = floatValue * 0.5f;
            WaveView.this.f33446c.quadTo(WaveView.this.f33451h * 0.25f, 0.0f, WaveView.this.f33451h * 0.333f, f);
            WaveView.this.f33446c.quadTo(WaveView.this.f33451h * 0.5f, floatValue * 1.4f, WaveView.this.f33451h * 0.666f, f);
            WaveView.this.f33446c.quadTo(WaveView.this.f33451h * 0.75f, 0.0f, WaveView.this.f33451h, 0.0f);
            WaveView.this.postInvalidate();
        }
    }

    public WaveView(Context context) {
        super(context);
        this.f33444a = 100.0f;
        this.f33454k = false;
        this.f33455l = false;
        this.f33463t = new C11877a();
        getViewTreeObserver().addOnPreDrawListener(this);
        m20009j();
    }

    /* renamed from: j */
    private void m20009j() {
        m20003p();
        m20002q();
        m20005n();
        this.f33450g = new RectF();
        setLayerType(1, null);
    }

    /* renamed from: m */
    private void m20006m() {
        ValueAnimator valueAnimator = this.f33462s;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.f33462s.cancel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m20005n() {
        this.f33457n = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.f33458o = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.f33459p = ValueAnimator.ofFloat(0.0f, 0.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(-1000.0f, -1000.0f);
        this.f33460q = ofFloat;
        ofFloat.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.f33461r = ofFloat2;
        ofFloat2.setDuration(1L);
        this.f33461r.start();
    }

    /* renamed from: p */
    private void m20003p() {
        float f = getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.f33445b = paint;
        paint.setColor(-14575885);
        this.f33445b.setAntiAlias(true);
        this.f33445b.setStyle(Paint.Style.FILL);
        this.f33445b.setShadowLayer((int) ((f * 2.0f) + 0.5f), 0.0f, 0.0f, -1728053248);
    }

    /* renamed from: q */
    private void m20002q() {
        this.f33446c = new Path();
        this.f33447d = new Path();
        this.f33448e = new Path();
        this.f33449f = new Path();
    }

    /* renamed from: v */
    private void m19997v(int i) {
        float f = i;
        if ((this.f33451h / 1440.0f) * 500.0f > f) {
            Log.w("WaveView", "DropHeight is more than " + ((this.f33451h / 1440.0f) * 500.0f));
            return;
        }
        this.f33453j = (int) Math.min(f, getHeight() - this.f33444a);
        if (this.f33454k) {
            this.f33454k = false;
            m20007l();
        }
    }

    /* renamed from: f */
    public void m20013f() {
        if (this.f33461r.isRunning()) {
            return;
        }
        m19999t();
        m19998u(0.1f);
    }

    /* renamed from: g */
    public void m20012g(float f, float f2) {
        m20006m();
        this.f33446c.moveTo(0.0f, 0.0f);
        Path path = this.f33446c;
        int i = this.f33451h;
        float[][] fArr = f33436C;
        float[][] fArr2 = f33435B;
        path.cubicTo(fArr[0][0] * i, fArr[0][1] * i, Math.min(fArr2[1][0] + f2, fArr[1][0]) * i, Math.max((fArr2[1][1] + f) - f2, fArr[1][1]) * this.f33451h, Math.max(fArr2[2][0] - f2, fArr[2][0]) * this.f33451h, Math.max((fArr2[2][1] + f) - f2, fArr[2][1]) * this.f33451h);
        Path path2 = this.f33446c;
        float max = this.f33451h * Math.max(fArr2[3][0] - f2, fArr[3][0]);
        float min = this.f33451h * Math.min(fArr2[3][1] + f + f2, fArr[3][1]);
        float max2 = this.f33451h * Math.max(fArr2[4][0] - f2, fArr[4][0]);
        float min2 = this.f33451h * Math.min(fArr2[4][1] + f + f2, fArr[4][1]);
        int i2 = this.f33451h;
        path2.cubicTo(max, min, max2, min2, i2 * fArr[5][0], i2 * Math.min(fArr2[0][1] + f + f2, fArr[5][1]));
        Path path3 = this.f33446c;
        int i3 = this.f33451h;
        float max3 = i3 - (i3 * Math.max(fArr2[4][0] - f2, fArr[4][0]));
        float min3 = this.f33451h * Math.min(fArr2[4][1] + f + f2, fArr[4][1]);
        int i4 = this.f33451h;
        float max4 = i4 - (i4 * Math.max(fArr2[3][0] - f2, fArr[3][0]));
        float min4 = this.f33451h * Math.min(fArr2[3][1] + f + f2, fArr[3][1]);
        int i5 = this.f33451h;
        path3.cubicTo(max3, min3, max4, min4, i5 - (i5 * Math.max(fArr2[2][0] - f2, fArr[2][0])), this.f33451h * Math.max((fArr2[2][1] + f) - f2, fArr[2][1]));
        Path path4 = this.f33446c;
        int i6 = this.f33451h;
        float min5 = i6 - (i6 * Math.min(fArr2[1][0] + f2, fArr[1][0]));
        float max5 = this.f33451h * Math.max((fArr2[1][1] + f) - f2, fArr[1][1]);
        int i7 = this.f33451h;
        path4.cubicTo(min5, max5, i7 - (i7 * fArr[0][0]), i7 * fArr[0][1], i7, 0.0f);
        this.f33452i = (this.f33451h * Math.min(fArr2[3][1] + f + f2, fArr[3][1])) + this.f33444a;
        postInvalidateOnAnimation();
    }

    public float getCurrentCircleCenterY() {
        return this.f33452i;
    }

    /* renamed from: h */
    public void m20011h(float f) {
        m20006m();
        this.f33446c.moveTo(0.0f, 0.0f);
        Path path = this.f33446c;
        int i = this.f33451h;
        float[][] fArr = f33435B;
        path.cubicTo(fArr[0][0] * i, fArr[0][1], fArr[1][0] * i, (fArr[1][1] + f) * i, fArr[2][0] * i, i * (fArr[2][1] + f));
        Path path2 = this.f33446c;
        int i2 = this.f33451h;
        path2.cubicTo(i2 * fArr[3][0], i2 * (fArr[3][1] + f), i2 * fArr[4][0], i2 * (fArr[4][1] + f), i2 * fArr[5][0], i2 * (fArr[5][1] + f));
        Path path3 = this.f33446c;
        int i3 = this.f33451h;
        path3.cubicTo(i3 - (i3 * fArr[4][0]), i3 * (fArr[4][1] + f), i3 - (i3 * fArr[3][0]), i3 * (fArr[3][1] + f), i3 - (i3 * fArr[2][0]), i3 * (fArr[2][1] + f));
        Path path4 = this.f33446c;
        int i4 = this.f33451h;
        path4.cubicTo(i4 - (i4 * fArr[1][0]), i4 * (fArr[1][1] + f), i4 - (i4 * fArr[0][0]), fArr[0][1], i4, 0.0f);
        postInvalidateOnAnimation();
    }

    /* renamed from: i */
    public void m20010i(float f, float f2, float f3) {
        m20006m();
        this.f33446c.moveTo(0.0f, 0.0f);
        Path path = this.f33446c;
        int i = this.f33451h;
        float[][] fArr = f33437D;
        float[][] fArr2 = f33435B;
        float[][] fArr3 = f33436C;
        path.cubicTo(fArr[0][0] * i, fArr[0][1] * i, Math.min(Math.min(fArr2[1][0] + f2, fArr3[1][0]) + f3, fArr[1][0]) * i, Math.max(Math.max((fArr2[1][1] + f) - f2, fArr3[1][1]) - f3, fArr[1][1]) * this.f33451h, Math.max(fArr2[2][0] - f2, fArr[2][0]) * this.f33451h, Math.min(Math.max((fArr2[2][1] + f) - f2, fArr3[2][1]) + f3, fArr[2][1]) * this.f33451h);
        Path path2 = this.f33446c;
        float min = this.f33451h * Math.min(Math.max(fArr2[3][0] - f2, fArr3[3][0]) + f3, fArr[3][0]);
        float min2 = this.f33451h * Math.min(Math.min(fArr2[3][1] + f + f2, fArr3[3][1]) + f3, fArr[3][1]);
        float max = this.f33451h * Math.max(fArr2[4][0] - f2, fArr[4][0]);
        float min3 = this.f33451h * Math.min(Math.min(fArr2[4][1] + f + f2, fArr3[4][1]) + f3, fArr[4][1]);
        int i2 = this.f33451h;
        path2.cubicTo(min, min2, max, min3, i2 * fArr[5][0], i2 * Math.min(Math.min(fArr2[0][1] + f + f2, fArr3[5][1]) + f3, fArr[5][1]));
        Path path3 = this.f33446c;
        int i3 = this.f33451h;
        float max2 = i3 - (i3 * Math.max(fArr2[4][0] - f2, fArr[4][0]));
        float min4 = this.f33451h * Math.min(Math.min(fArr2[4][1] + f + f2, fArr3[4][1]) + f3, fArr[4][1]);
        int i4 = this.f33451h;
        float min5 = i4 - (i4 * Math.min(Math.max(fArr2[3][0] - f2, fArr3[3][0]) + f3, fArr[3][0]));
        float min6 = this.f33451h * Math.min(Math.min(fArr2[3][1] + f + f2, fArr3[3][1]) + f3, fArr[3][1]);
        int i5 = this.f33451h;
        path3.cubicTo(max2, min4, min5, min6, i5 - (i5 * Math.max(fArr2[2][0] - f2, fArr[2][0])), this.f33451h * Math.min(Math.max((fArr2[2][1] + f) - f2, fArr3[2][1]) + f3, fArr[2][1]));
        Path path4 = this.f33446c;
        int i6 = this.f33451h;
        float min7 = i6 - (i6 * Math.min(Math.min(fArr2[1][0] + f2, fArr3[1][0]) + f3, fArr[1][0]));
        float max3 = this.f33451h * Math.max(Math.max((fArr2[1][1] + f) - f2, fArr3[1][1]) - f3, fArr[1][1]);
        int i7 = this.f33451h;
        path4.cubicTo(min7, max3, i7 - (i7 * fArr[0][0]), i7 * fArr[0][1], i7, 0.0f);
        this.f33452i = (this.f33451h * Math.min(Math.min(fArr2[3][1] + f + f2, fArr3[3][1]) + f3, fArr[3][1])) + this.f33444a;
        postInvalidateOnAnimation();
    }

    /* renamed from: k */
    public boolean m20008k() {
        return this.f33461r.isRunning();
    }

    /* renamed from: l */
    public void m20007l() {
        if (this.f33454k) {
            return;
        }
        this.f33454k = true;
        int i = this.f33453j;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(i, i);
        this.f33460q = ofFloat;
        ofFloat.start();
        int i2 = this.f33453j;
        float f = this.f33444a;
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat(i2 - f, i2 - f);
        this.f33457n = ofFloat2;
        ofFloat2.start();
        this.f33452i = this.f33453j;
        postInvalidate();
    }

    /* renamed from: o */
    public void m20004o(int i, int i2) {
        this.f33445b.setShadowLayer(i, 0.0f, 0.0f, i2);
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.f33461r;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.f33461r.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.f33460q;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
            this.f33460q.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.f33457n;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
            this.f33457n.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.f33462s;
        if (valueAnimator4 != null) {
            valueAnimator4.end();
            this.f33462s.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator5 = this.f33459p;
        if (valueAnimator5 != null) {
            valueAnimator5.end();
            this.f33459p.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator6 = this.f33458o;
        if (valueAnimator6 != null) {
            valueAnimator6.end();
            this.f33458o.removeAllUpdateListeners();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.f33446c, this.f33445b);
        if (!isInEditMode()) {
            this.f33446c.rewind();
            this.f33447d.rewind();
            this.f33448e.rewind();
        }
        float floatValue = ((Float) this.f33460q.getAnimatedValue()).floatValue();
        float f = this.f33451h / 2.0f;
        this.f33450g.setEmpty();
        float floatValue2 = ((Float) this.f33461r.getAnimatedValue()).floatValue();
        float floatValue3 = ((Float) this.f33458o.getAnimatedValue()).floatValue();
        float floatValue4 = ((Float) this.f33459p.getAnimatedValue()).floatValue();
        RectF rectF = this.f33450g;
        float f2 = this.f33444a;
        float f3 = floatValue3 + 1.0f;
        float f4 = 1.0f + floatValue4;
        rectF.set((f - ((f2 * f3) * floatValue2)) + ((f2 * floatValue4) / 2.0f), (((f2 * f4) * floatValue2) + floatValue) - ((f2 * floatValue3) / 2.0f), (((f3 * f2) * floatValue2) + f) - ((floatValue4 * f2) / 2.0f), (floatValue - ((f4 * f2) * floatValue2)) + ((f2 * floatValue3) / 2.0f));
        float floatValue5 = ((Float) this.f33457n.getAnimatedValue()).floatValue();
        this.f33447d.moveTo(f, floatValue5);
        double pow = Math.pow(this.f33444a, 2.0d);
        double d = floatValue * floatValue5;
        Double.isNaN(d);
        double d2 = pow + d;
        double d3 = floatValue;
        double pow2 = d2 - Math.pow(d3, 2.0d);
        double d4 = floatValue5 - floatValue;
        Double.isNaN(d4);
        double d5 = pow2 / d4;
        double d6 = this.f33451h;
        Double.isNaN(d6);
        double d7 = (d6 * (-2.0d)) / 2.0d;
        Double.isNaN(d3);
        double d8 = -d7;
        double pow3 = (d7 * d7) - (((Math.pow(d5 - d3, 2.0d) + Math.pow(f, 2.0d)) - Math.pow(this.f33444a, 2.0d)) * 4.0d);
        float f5 = (float) d5;
        this.f33447d.lineTo((float) ((Math.sqrt(pow3) + d8) / 2.0d), f5);
        this.f33447d.lineTo((float) ((d8 - Math.sqrt(pow3)) / 2.0d), f5);
        this.f33447d.close();
        this.f33449f.set(this.f33447d);
        this.f33449f.addOval(this.f33450g, Path.Direction.CCW);
        this.f33448e.addOval(this.f33450g, Path.Direction.CCW);
        this.f33457n.isRunning();
        canvas.drawPath(this.f33447d, this.f33445b);
        canvas.drawPath(this.f33448e, this.f33445b);
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        if (this.f33455l) {
            m19997v(this.f33456m);
            return false;
        }
        return false;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        this.f33451h = i;
        this.f33444a = i / 14.4f;
        m19997v((int) Math.min(Math.min(i, i2), getHeight() - this.f33444a));
        super.onSizeChanged(i, i2, i3, i4);
    }

    @Override // android.view.View
    public void postInvalidateOnAnimation() {
        super.postInvalidateOnAnimation();
    }

    /* renamed from: r */
    public void m20001r(int i, int i2, int i3, int i4) {
        this.f33445b.setARGB(i, i2, i3, i4);
        invalidate();
    }

    /* renamed from: s */
    public void m20000s() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.f33461r = ofFloat;
        ofFloat.addUpdateListener(this.f33463t);
        this.f33461r.setDuration(200L);
        this.f33461r.addListener(new C11879c());
        this.f33461r.start();
    }

    public void setMaxDropHeight(int i) {
        if (this.f33455l) {
            m19997v(i);
            return;
        }
        this.f33456m = i;
        this.f33455l = true;
        if (getViewTreeObserver().isAlive()) {
            getViewTreeObserver().removeOnPreDrawListener(this);
            getViewTreeObserver().addOnPreDrawListener(this);
        }
    }

    public void setShadowRadius(int i) {
        this.f33445b.setShadowLayer(i, 0.0f, 0.0f, -1728053248);
    }

    public void setWaveColor(@ColorInt int i) {
        this.f33445b.setColor(i);
        invalidate();
    }

    /* renamed from: t */
    public void m19999t() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.f33461r = ofFloat;
        ofFloat.setDuration(1L);
        this.f33461r.start();
        ValueAnimator ofFloat2 = ValueAnimator.ofFloat((this.f33451h / 1440.0f) * 500.0f, this.f33453j);
        this.f33460q = ofFloat2;
        ofFloat2.setDuration(500L);
        this.f33460q.addUpdateListener(new C11878b());
        this.f33460q.setInterpolator(new AccelerateDecelerateInterpolator());
        this.f33460q.start();
        ValueAnimator ofFloat3 = ValueAnimator.ofFloat(0.0f, this.f33453j - this.f33444a);
        this.f33457n = ofFloat3;
        ofFloat3.setDuration(500L);
        this.f33457n.addUpdateListener(this.f33463t);
        this.f33457n.start();
        ValueAnimator ofFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f33458o = ofFloat4;
        ofFloat4.setDuration(500L);
        this.f33458o.addUpdateListener(this.f33463t);
        this.f33458o.setInterpolator(new DropBounceInterpolator());
        this.f33458o.setStartDelay(500L);
        this.f33458o.start();
        ValueAnimator ofFloat5 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.f33459p = ofFloat5;
        ofFloat5.setDuration(500L);
        this.f33459p.addUpdateListener(this.f33463t);
        this.f33459p.setInterpolator(new DropBounceInterpolator());
        this.f33459p.setStartDelay(625L);
        this.f33459p.start();
    }

    /* renamed from: u */
    public void m19998u(float f) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(Math.min(f, 0.2f) * this.f33451h, 0.0f);
        this.f33462s = ofFloat;
        ofFloat.setDuration(1000L);
        this.f33462s.addUpdateListener(new C11880d());
        this.f33462s.setInterpolator(new BounceInterpolator());
        this.f33462s.start();
    }
}
