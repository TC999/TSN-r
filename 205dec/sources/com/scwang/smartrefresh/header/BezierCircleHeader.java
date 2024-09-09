package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.constant.SpinnerStyle;
import com.scwang.smartrefresh.layout.util.c;
import r0.e;
import r0.g;
import r0.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class BezierCircleHeader extends View implements e {

    /* renamed from: r  reason: collision with root package name */
    private static final int f47458r = 800;

    /* renamed from: s  reason: collision with root package name */
    private static final int f47459s = 270;

    /* renamed from: a  reason: collision with root package name */
    private Path f47460a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f47461b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f47462c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f47463d;

    /* renamed from: e  reason: collision with root package name */
    private float f47464e;

    /* renamed from: f  reason: collision with root package name */
    private float f47465f;

    /* renamed from: g  reason: collision with root package name */
    private float f47466g;

    /* renamed from: h  reason: collision with root package name */
    private float f47467h;

    /* renamed from: i  reason: collision with root package name */
    private RefreshState f47468i;

    /* renamed from: j  reason: collision with root package name */
    private float f47469j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f47470k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f47471l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f47472m;

    /* renamed from: n  reason: collision with root package name */
    private float f47473n;

    /* renamed from: o  reason: collision with root package name */
    private int f47474o;

    /* renamed from: p  reason: collision with root package name */
    private int f47475p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f47476q;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b  reason: collision with root package name */
        float f47478b;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ float f47481e;

        /* renamed from: a  reason: collision with root package name */
        float f47477a = 0.0f;

        /* renamed from: c  reason: collision with root package name */
        float f47479c = 0.0f;

        /* renamed from: d  reason: collision with root package name */
        int f47480d = 0;

        a(float f4) {
            this.f47481e = f4;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (this.f47480d == 0 && floatValue <= 0.0f) {
                this.f47480d = 1;
                this.f47477a = Math.abs(floatValue - BezierCircleHeader.this.f47464e);
            }
            if (this.f47480d == 1) {
                float f4 = (-floatValue) / this.f47481e;
                this.f47479c = f4;
                if (f4 >= BezierCircleHeader.this.f47466g) {
                    BezierCircleHeader.this.f47466g = this.f47479c;
                    BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
                    bezierCircleHeader.f47469j = bezierCircleHeader.f47465f + floatValue;
                    this.f47477a = Math.abs(floatValue - BezierCircleHeader.this.f47464e);
                } else {
                    this.f47480d = 2;
                    BezierCircleHeader.this.f47466g = 0.0f;
                    BezierCircleHeader.this.f47470k = true;
                    BezierCircleHeader.this.f47471l = true;
                    this.f47478b = BezierCircleHeader.this.f47469j;
                }
            }
            if (this.f47480d == 2 && BezierCircleHeader.this.f47469j > BezierCircleHeader.this.f47465f / 2.0f) {
                BezierCircleHeader bezierCircleHeader2 = BezierCircleHeader.this;
                bezierCircleHeader2.f47469j = Math.max(bezierCircleHeader2.f47465f / 2.0f, BezierCircleHeader.this.f47469j - this.f47477a);
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float f5 = this.f47478b;
                float f6 = (animatedFraction * ((BezierCircleHeader.this.f47465f / 2.0f) - f5)) + f5;
                if (BezierCircleHeader.this.f47469j > f6) {
                    BezierCircleHeader.this.f47469j = f6;
                }
            }
            if (BezierCircleHeader.this.f47471l && floatValue < BezierCircleHeader.this.f47464e) {
                BezierCircleHeader.this.f47472m = true;
                BezierCircleHeader.this.f47471l = false;
                BezierCircleHeader.this.f47476q = true;
                BezierCircleHeader.this.f47475p = 90;
                BezierCircleHeader.this.f47474o = 90;
            }
            BezierCircleHeader.this.f47464e = floatValue;
            BezierCircleHeader.this.invalidate();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class b implements ValueAnimator.AnimatorUpdateListener {
        b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierCircleHeader.this.f47467h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BezierCircleHeader.this.invalidate();
        }
    }

    public BezierCircleHeader(Context context) {
        super(context, null, 0);
        this.f47474o = 90;
        this.f47475p = 90;
        this.f47476q = true;
        S(context, null);
    }

    private void M(Canvas canvas, int i4) {
        if (this.f47470k) {
            canvas.drawCircle(i4 / 2, this.f47469j, this.f47473n, this.f47462c);
            float f4 = this.f47465f;
            N(canvas, i4, (this.f47464e + f4) / f4);
        }
    }

    private void N(Canvas canvas, int i4, float f4) {
        float f5;
        if (this.f47471l) {
            float f6 = this.f47465f + this.f47464e;
            float f7 = this.f47469j + ((this.f47473n * f4) / 2.0f);
            float f8 = i4 / 2;
            float sqrt = ((float) Math.sqrt(f5 * f5 * (1.0f - ((f4 * f4) / 4.0f)))) + f8;
            float f9 = this.f47473n;
            float f10 = f8 + (((3.0f * f9) / 4.0f) * (1.0f - f4));
            float f11 = f9 + f10;
            this.f47460a.reset();
            this.f47460a.moveTo(sqrt, f7);
            this.f47460a.quadTo(f10, f6, f11, f6);
            float f12 = i4;
            this.f47460a.lineTo(f12 - f11, f6);
            this.f47460a.quadTo(f12 - f10, f6, f12 - sqrt, f7);
            canvas.drawPath(this.f47460a, this.f47462c);
        }
    }

    private void O(Canvas canvas, int i4) {
        int i5;
        int i6;
        if (this.f47467h > 0.0f) {
            int color = this.f47463d.getColor();
            if (this.f47467h < 0.3d) {
                canvas.drawCircle(i4 / 2, this.f47469j, this.f47473n, this.f47462c);
                float f4 = this.f47473n;
                float f5 = this.f47467h;
                int strokeWidth = (int) (f4 + (this.f47463d.getStrokeWidth() * 2.0f * ((f5 / 0.3f) + 1.0f)));
                this.f47463d.setColor(Color.argb((int) ((1.0f - (f5 / 0.3f)) * 255.0f), Color.red(color), Color.green(color), Color.blue(color)));
                float f6 = this.f47469j;
                float f7 = strokeWidth;
                canvas.drawArc(new RectF(i6 - strokeWidth, f6 - f7, i6 + strokeWidth, f6 + f7), 0.0f, 360.0f, false, this.f47463d);
            }
            this.f47463d.setColor(color);
            float f8 = this.f47467h;
            if (f8 >= 0.3d && f8 < 0.7d) {
                float f9 = (f8 - 0.3f) / 0.4f;
                float f10 = this.f47465f;
                float f11 = (int) ((f10 / 2.0f) + ((f10 - (f10 / 2.0f)) * f9));
                this.f47469j = f11;
                canvas.drawCircle(i4 / 2, f11, this.f47473n, this.f47462c);
                if (this.f47469j >= this.f47465f - (this.f47473n * 2.0f)) {
                    this.f47471l = true;
                    N(canvas, i4, f9);
                }
                this.f47471l = false;
            }
            float f12 = this.f47467h;
            if (f12 < 0.7d || f12 > 1.0f) {
                return;
            }
            float f13 = (f12 - 0.7f) / 0.3f;
            float f14 = i4 / 2;
            float f15 = this.f47473n;
            this.f47460a.reset();
            this.f47460a.moveTo((int) ((f14 - f15) - ((f15 * 2.0f) * f13)), this.f47465f);
            Path path = this.f47460a;
            float f16 = this.f47465f;
            path.quadTo(f14, f16 - (this.f47473n * (1.0f - f13)), i4 - i5, f16);
            canvas.drawPath(this.f47460a, this.f47462c);
        }
    }

    private void P(Canvas canvas, int i4) {
        if (this.f47472m) {
            float strokeWidth = this.f47473n + (this.f47463d.getStrokeWidth() * 2.0f);
            int i5 = this.f47475p;
            boolean z3 = this.f47476q;
            int i6 = i5 + (z3 ? 3 : 10);
            this.f47475p = i6;
            int i7 = this.f47474o + (z3 ? 10 : 3);
            this.f47474o = i7;
            int i8 = i6 % 360;
            this.f47475p = i8;
            int i9 = i7 % 360;
            this.f47474o = i9;
            int i10 = i9 - i8;
            if (i10 < 0) {
                i10 += 360;
            }
            float f4 = i4 / 2;
            float f5 = this.f47469j;
            canvas.drawArc(new RectF(f4 - strokeWidth, f5 - strokeWidth, f4 + strokeWidth, f5 + strokeWidth), this.f47475p, i10, false, this.f47463d);
            if (i10 >= 270) {
                this.f47476q = false;
            } else if (i10 <= 10) {
                this.f47476q = true;
            }
            invalidate();
        }
    }

    private void Q(Canvas canvas, int i4) {
        float f4 = this.f47466g;
        if (f4 > 0.0f) {
            float f5 = i4 / 2;
            float f6 = this.f47473n;
            float f7 = (f5 - (4.0f * f6)) + (3.0f * f4 * f6);
            if (f4 < 0.9d) {
                this.f47460a.reset();
                this.f47460a.moveTo(f7, this.f47469j);
                Path path = this.f47460a;
                float f8 = this.f47469j;
                path.quadTo(f5, f8 - ((this.f47473n * this.f47466g) * 2.0f), i4 - f7, f8);
                canvas.drawPath(this.f47460a, this.f47462c);
                return;
            }
            canvas.drawCircle(f5, this.f47469j, f6, this.f47462c);
        }
    }

    private void R(Canvas canvas, int i4, int i5) {
        float min = Math.min(this.f47465f, i5);
        if (this.f47464e != 0.0f) {
            this.f47460a.reset();
            float f4 = i4;
            this.f47460a.lineTo(f4, 0.0f);
            this.f47460a.lineTo(f4, min);
            this.f47460a.quadTo(i4 / 2, (this.f47464e * 2.0f) + min, 0.0f, min);
            this.f47460a.close();
            canvas.drawPath(this.f47460a, this.f47461b);
            return;
        }
        canvas.drawRect(0.0f, 0.0f, i4, min, this.f47461b);
    }

    private void S(Context context, AttributeSet attributeSet) {
        setMinimumHeight(c.b(100.0f));
        Paint paint = new Paint();
        this.f47461b = paint;
        paint.setColor(-15614977);
        this.f47461b.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f47462c = paint2;
        paint2.setColor(-1);
        this.f47462c.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f47463d = paint3;
        paint3.setAntiAlias(true);
        this.f47463d.setColor(-1);
        this.f47463d.setStyle(Paint.Style.STROKE);
        this.f47463d.setStrokeWidth(c.b(2.0f));
        this.f47460a = new Path();
    }

    @Override // s0.f
    public void b(h hVar, RefreshState refreshState, RefreshState refreshState2) {
        this.f47468i = refreshState2;
    }

    @Override // r0.f
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    @Override // r0.f
    @NonNull
    public View getView() {
        return this;
    }

    @Override // r0.e
    public void i(float f4, int i4, int i5, int i6) {
        RefreshState refreshState = this.f47468i;
        if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.RefreshReleased) {
            return;
        }
        w(f4, i4, i5, i6);
    }

    @Override // r0.e
    public void j(h hVar, int i4, int i5) {
        this.f47465f = i4;
        this.f47473n = i4 / 6;
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        float min = Math.min(this.f47464e * 0.8f, this.f47465f / 2.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f47464e, 0.0f, -(1.0f * min), 0.0f, -(0.4f * min), 0.0f);
        ofFloat.addUpdateListener(new a(min));
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    @Override // r0.f
    public void n(float f4, int i4, int i5) {
    }

    @Override // r0.f
    public void o(g gVar, int i4, int i5) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            this.f47470k = true;
            this.f47472m = true;
            float height = getHeight();
            this.f47465f = height;
            this.f47474o = 270;
            this.f47469j = height / 2.0f;
            this.f47473n = height / 6.0f;
        }
        int width = getWidth();
        R(canvas, width, getHeight());
        Q(canvas, width);
        M(canvas, width);
        P(canvas, width);
        O(canvas, width);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i4), View.resolveSize(getSuggestedMinimumHeight(), i5));
    }

    @Override // r0.f
    public boolean p() {
        return false;
    }

    @Override // r0.f
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f47461b.setColor(iArr[0]);
            if (iArr.length > 1) {
                this.f47462c.setColor(iArr[1]);
                this.f47463d.setColor(iArr[1]);
            }
        }
    }

    @Override // r0.f
    public void u(h hVar, int i4, int i5) {
    }

    @Override // r0.f
    public int v(h hVar, boolean z3) {
        this.f47472m = false;
        this.f47470k = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new b());
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(800L);
        ofFloat.start();
        return 800;
    }

    @Override // r0.e
    public void w(float f4, int i4, int i5, int i6) {
        this.f47465f = i5;
        this.f47464e = Math.max(i4 - i5, 0) * 0.8f;
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f47474o = 90;
        this.f47475p = 90;
        this.f47476q = true;
        S(context, attributeSet);
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f47474o = 90;
        this.f47475p = 90;
        this.f47476q = true;
        S(context, attributeSet);
    }

    @RequiresApi(21)
    public BezierCircleHeader(Context context, @Nullable AttributeSet attributeSet, int i4, int i5) {
        super(context, attributeSet, i4, i5);
        this.f47474o = 90;
        this.f47475p = 90;
        this.f47476q = true;
        S(context, attributeSet);
    }
}
