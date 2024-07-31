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
import com.scwang.smartrefresh.layout.util.C11925c;
import p638r0.RefreshHeader;
import p638r0.RefreshKernel;
import p638r0.RefreshLayout;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BezierCircleHeader extends View implements RefreshHeader {

    /* renamed from: r */
    private static final int f32999r = 800;

    /* renamed from: s */
    private static final int f33000s = 270;

    /* renamed from: a */
    private Path f33001a;

    /* renamed from: b */
    private Paint f33002b;

    /* renamed from: c */
    private Paint f33003c;

    /* renamed from: d */
    private Paint f33004d;

    /* renamed from: e */
    private float f33005e;

    /* renamed from: f */
    private float f33006f;

    /* renamed from: g */
    private float f33007g;

    /* renamed from: h */
    private float f33008h;

    /* renamed from: i */
    private RefreshState f33009i;

    /* renamed from: j */
    private float f33010j;

    /* renamed from: k */
    private boolean f33011k;

    /* renamed from: l */
    private boolean f33012l;

    /* renamed from: m */
    private boolean f33013m;

    /* renamed from: n */
    private float f33014n;

    /* renamed from: o */
    private int f33015o;

    /* renamed from: p */
    private int f33016p;

    /* renamed from: q */
    private boolean f33017q;

    /* renamed from: com.scwang.smartrefresh.header.BezierCircleHeader$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11840a implements ValueAnimator.AnimatorUpdateListener {

        /* renamed from: b */
        float f33019b;

        /* renamed from: e */
        final /* synthetic */ float f33022e;

        /* renamed from: a */
        float f33018a = 0.0f;

        /* renamed from: c */
        float f33020c = 0.0f;

        /* renamed from: d */
        int f33021d = 0;

        C11840a(float f) {
            this.f33022e = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (this.f33021d == 0 && floatValue <= 0.0f) {
                this.f33021d = 1;
                this.f33018a = Math.abs(floatValue - BezierCircleHeader.this.f33005e);
            }
            if (this.f33021d == 1) {
                float f = (-floatValue) / this.f33022e;
                this.f33020c = f;
                if (f >= BezierCircleHeader.this.f33007g) {
                    BezierCircleHeader.this.f33007g = this.f33020c;
                    BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
                    bezierCircleHeader.f33010j = bezierCircleHeader.f33006f + floatValue;
                    this.f33018a = Math.abs(floatValue - BezierCircleHeader.this.f33005e);
                } else {
                    this.f33021d = 2;
                    BezierCircleHeader.this.f33007g = 0.0f;
                    BezierCircleHeader.this.f33011k = true;
                    BezierCircleHeader.this.f33012l = true;
                    this.f33019b = BezierCircleHeader.this.f33010j;
                }
            }
            if (this.f33021d == 2 && BezierCircleHeader.this.f33010j > BezierCircleHeader.this.f33006f / 2.0f) {
                BezierCircleHeader bezierCircleHeader2 = BezierCircleHeader.this;
                bezierCircleHeader2.f33010j = Math.max(bezierCircleHeader2.f33006f / 2.0f, BezierCircleHeader.this.f33010j - this.f33018a);
                float animatedFraction = valueAnimator.getAnimatedFraction();
                float f2 = this.f33019b;
                float f3 = (animatedFraction * ((BezierCircleHeader.this.f33006f / 2.0f) - f2)) + f2;
                if (BezierCircleHeader.this.f33010j > f3) {
                    BezierCircleHeader.this.f33010j = f3;
                }
            }
            if (BezierCircleHeader.this.f33012l && floatValue < BezierCircleHeader.this.f33005e) {
                BezierCircleHeader.this.f33013m = true;
                BezierCircleHeader.this.f33012l = false;
                BezierCircleHeader.this.f33017q = true;
                BezierCircleHeader.this.f33016p = 90;
                BezierCircleHeader.this.f33015o = 90;
            }
            BezierCircleHeader.this.f33005e = floatValue;
            BezierCircleHeader.this.invalidate();
        }
    }

    /* renamed from: com.scwang.smartrefresh.header.BezierCircleHeader$b */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11841b implements ValueAnimator.AnimatorUpdateListener {
        C11841b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierCircleHeader.this.f33008h = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            BezierCircleHeader.this.invalidate();
        }
    }

    public BezierCircleHeader(Context context) {
        super(context, null, 0);
        this.f33015o = 90;
        this.f33016p = 90;
        this.f33017q = true;
        m20244S(context, null);
    }

    /* renamed from: M */
    private void m20250M(Canvas canvas, int i) {
        if (this.f33011k) {
            canvas.drawCircle(i / 2, this.f33010j, this.f33014n, this.f33003c);
            float f = this.f33006f;
            m20249N(canvas, i, (this.f33005e + f) / f);
        }
    }

    /* renamed from: N */
    private void m20249N(Canvas canvas, int i, float f) {
        float f2;
        if (this.f33012l) {
            float f3 = this.f33006f + this.f33005e;
            float f4 = this.f33010j + ((this.f33014n * f) / 2.0f);
            float f5 = i / 2;
            float sqrt = ((float) Math.sqrt(f2 * f2 * (1.0f - ((f * f) / 4.0f)))) + f5;
            float f6 = this.f33014n;
            float f7 = f5 + (((3.0f * f6) / 4.0f) * (1.0f - f));
            float f8 = f6 + f7;
            this.f33001a.reset();
            this.f33001a.moveTo(sqrt, f4);
            this.f33001a.quadTo(f7, f3, f8, f3);
            float f9 = i;
            this.f33001a.lineTo(f9 - f8, f3);
            this.f33001a.quadTo(f9 - f7, f3, f9 - sqrt, f4);
            canvas.drawPath(this.f33001a, this.f33003c);
        }
    }

    /* renamed from: O */
    private void m20248O(Canvas canvas, int i) {
        int i2;
        int i3;
        if (this.f33008h > 0.0f) {
            int color = this.f33004d.getColor();
            if (this.f33008h < 0.3d) {
                canvas.drawCircle(i / 2, this.f33010j, this.f33014n, this.f33003c);
                float f = this.f33014n;
                float f2 = this.f33008h;
                int strokeWidth = (int) (f + (this.f33004d.getStrokeWidth() * 2.0f * ((f2 / 0.3f) + 1.0f)));
                this.f33004d.setColor(Color.argb((int) ((1.0f - (f2 / 0.3f)) * 255.0f), Color.red(color), Color.green(color), Color.blue(color)));
                float f3 = this.f33010j;
                float f4 = strokeWidth;
                canvas.drawArc(new RectF(i3 - strokeWidth, f3 - f4, i3 + strokeWidth, f3 + f4), 0.0f, 360.0f, false, this.f33004d);
            }
            this.f33004d.setColor(color);
            float f5 = this.f33008h;
            if (f5 >= 0.3d && f5 < 0.7d) {
                float f6 = (f5 - 0.3f) / 0.4f;
                float f7 = this.f33006f;
                float f8 = (int) ((f7 / 2.0f) + ((f7 - (f7 / 2.0f)) * f6));
                this.f33010j = f8;
                canvas.drawCircle(i / 2, f8, this.f33014n, this.f33003c);
                if (this.f33010j >= this.f33006f - (this.f33014n * 2.0f)) {
                    this.f33012l = true;
                    m20249N(canvas, i, f6);
                }
                this.f33012l = false;
            }
            float f9 = this.f33008h;
            if (f9 < 0.7d || f9 > 1.0f) {
                return;
            }
            float f10 = (f9 - 0.7f) / 0.3f;
            float f11 = i / 2;
            float f12 = this.f33014n;
            this.f33001a.reset();
            this.f33001a.moveTo((int) ((f11 - f12) - ((f12 * 2.0f) * f10)), this.f33006f);
            Path path = this.f33001a;
            float f13 = this.f33006f;
            path.quadTo(f11, f13 - (this.f33014n * (1.0f - f10)), i - i2, f13);
            canvas.drawPath(this.f33001a, this.f33003c);
        }
    }

    /* renamed from: P */
    private void m20247P(Canvas canvas, int i) {
        if (this.f33013m) {
            float strokeWidth = this.f33014n + (this.f33004d.getStrokeWidth() * 2.0f);
            int i2 = this.f33016p;
            boolean z = this.f33017q;
            int i3 = i2 + (z ? 3 : 10);
            this.f33016p = i3;
            int i4 = this.f33015o + (z ? 10 : 3);
            this.f33015o = i4;
            int i5 = i3 % 360;
            this.f33016p = i5;
            int i6 = i4 % 360;
            this.f33015o = i6;
            int i7 = i6 - i5;
            if (i7 < 0) {
                i7 += 360;
            }
            float f = i / 2;
            float f2 = this.f33010j;
            canvas.drawArc(new RectF(f - strokeWidth, f2 - strokeWidth, f + strokeWidth, f2 + strokeWidth), this.f33016p, i7, false, this.f33004d);
            if (i7 >= 270) {
                this.f33017q = false;
            } else if (i7 <= 10) {
                this.f33017q = true;
            }
            invalidate();
        }
    }

    /* renamed from: Q */
    private void m20246Q(Canvas canvas, int i) {
        float f = this.f33007g;
        if (f > 0.0f) {
            float f2 = i / 2;
            float f3 = this.f33014n;
            float f4 = (f2 - (4.0f * f3)) + (3.0f * f * f3);
            if (f < 0.9d) {
                this.f33001a.reset();
                this.f33001a.moveTo(f4, this.f33010j);
                Path path = this.f33001a;
                float f5 = this.f33010j;
                path.quadTo(f2, f5 - ((this.f33014n * this.f33007g) * 2.0f), i - f4, f5);
                canvas.drawPath(this.f33001a, this.f33003c);
                return;
            }
            canvas.drawCircle(f2, this.f33010j, f3, this.f33003c);
        }
    }

    /* renamed from: R */
    private void m20245R(Canvas canvas, int i, int i2) {
        float min = Math.min(this.f33006f, i2);
        if (this.f33005e != 0.0f) {
            this.f33001a.reset();
            float f = i;
            this.f33001a.lineTo(f, 0.0f);
            this.f33001a.lineTo(f, min);
            this.f33001a.quadTo(i / 2, (this.f33005e * 2.0f) + min, 0.0f, min);
            this.f33001a.close();
            canvas.drawPath(this.f33001a, this.f33002b);
            return;
        }
        canvas.drawRect(0.0f, 0.0f, i, min, this.f33002b);
    }

    /* renamed from: S */
    private void m20244S(Context context, AttributeSet attributeSet) {
        setMinimumHeight(C11925c.m19766b(100.0f));
        Paint paint = new Paint();
        this.f33002b = paint;
        paint.setColor(-15614977);
        this.f33002b.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.f33003c = paint2;
        paint2.setColor(-1);
        this.f33003c.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.f33004d = paint3;
        paint3.setAntiAlias(true);
        this.f33004d.setColor(-1);
        this.f33004d.setStyle(Paint.Style.STROKE);
        this.f33004d.setStrokeWidth(C11925c.m19766b(2.0f));
        this.f33001a = new Path();
    }

    @Override // p642s0.OnStateChangedListener
    /* renamed from: b */
    public void mo329b(RefreshLayout refreshLayout, RefreshState refreshState, RefreshState refreshState2) {
        this.f33009i = refreshState2;
    }

    @Override // p638r0.RefreshInternal
    public SpinnerStyle getSpinnerStyle() {
        return SpinnerStyle.Scale;
    }

    @Override // p638r0.RefreshInternal
    @NonNull
    public View getView() {
        return this;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: i */
    public void mo2102i(float f, int i, int i2, int i3) {
        RefreshState refreshState = this.f33009i;
        if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.RefreshReleased) {
            return;
        }
        mo2100w(f, i, i2, i3);
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: j */
    public void mo2101j(RefreshLayout refreshLayout, int i, int i2) {
        this.f33006f = i;
        this.f33014n = i / 6;
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        float min = Math.min(this.f33005e * 0.8f, this.f33006f / 2.0f);
        ValueAnimator ofFloat = ValueAnimator.ofFloat(this.f33005e, 0.0f, -(1.0f * min), 0.0f, -(0.4f * min), 0.0f);
        ofFloat.addUpdateListener(new C11840a(min));
        ofFloat.setInterpolator(decelerateInterpolator);
        ofFloat.setDuration(1000L);
        ofFloat.start();
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: n */
    public void mo2099n(float f, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: o */
    public void mo2098o(RefreshKernel refreshKernel, int i, int i2) {
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (isInEditMode()) {
            this.f33011k = true;
            this.f33013m = true;
            float height = getHeight();
            this.f33006f = height;
            this.f33015o = 270;
            this.f33010j = height / 2.0f;
            this.f33014n = height / 6.0f;
        }
        int width = getWidth();
        m20245R(canvas, width, getHeight());
        m20246Q(canvas, width);
        m20250M(canvas, width);
        m20247P(canvas, width);
        m20248O(canvas, width);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: p */
    public boolean mo2097p() {
        return false;
    }

    @Override // p638r0.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.f33002b.setColor(iArr[0]);
            if (iArr.length > 1) {
                this.f33003c.setColor(iArr[1]);
                this.f33004d.setColor(iArr[1]);
            }
        }
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: u */
    public void mo2096u(RefreshLayout refreshLayout, int i, int i2) {
    }

    @Override // p638r0.RefreshInternal
    /* renamed from: v */
    public int mo2095v(RefreshLayout refreshLayout, boolean z) {
        this.f33013m = false;
        this.f33011k = false;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        ofFloat.addUpdateListener(new C11841b());
        ofFloat.setInterpolator(new AccelerateInterpolator());
        ofFloat.setDuration(800L);
        ofFloat.start();
        return 800;
    }

    @Override // p638r0.RefreshHeader
    /* renamed from: w */
    public void mo2100w(float f, int i, int i2, int i3) {
        this.f33006f = i2;
        this.f33005e = Math.max(i - i2, 0) * 0.8f;
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.f33015o = 90;
        this.f33016p = 90;
        this.f33017q = true;
        m20244S(context, attributeSet);
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33015o = 90;
        this.f33016p = 90;
        this.f33017q = true;
        m20244S(context, attributeSet);
    }

    @RequiresApi(21)
    public BezierCircleHeader(Context context, @Nullable AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.f33015o = 90;
        this.f33016p = 90;
        this.f33017q = true;
        m20244S(context, attributeSet);
    }
}
