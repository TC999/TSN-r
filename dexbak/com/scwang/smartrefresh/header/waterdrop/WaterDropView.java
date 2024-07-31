package com.scwang.smartrefresh.header.waterdrop;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import com.scwang.smartrefresh.layout.util.C11925c;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WaterDropView extends View {

    /* renamed from: g */
    private static int f33420g = 2;

    /* renamed from: h */
    private static final int f33421h = 180;

    /* renamed from: a */
    private Circle f33422a;

    /* renamed from: b */
    private Circle f33423b;

    /* renamed from: c */
    private Path f33424c;

    /* renamed from: d */
    private Paint f33425d;

    /* renamed from: e */
    private int f33426e;

    /* renamed from: f */
    private int f33427f;

    /* renamed from: com.scwang.smartrefresh.header.waterdrop.WaterDropView$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    class C11876a implements ValueAnimator.AnimatorUpdateListener {
        C11876a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaterDropView.this.m20021d(((Float) valueAnimator.getAnimatedValue()).floatValue());
            WaterDropView.this.postInvalidate();
        }
    }

    public WaterDropView(Context context) {
        super(context);
        m20023b(context, null);
    }

    /* renamed from: b */
    private void m20023b(Context context, AttributeSet attributeSet) {
        this.f33422a = new Circle();
        this.f33423b = new Circle();
        this.f33424c = new Path();
        Paint paint = new Paint();
        this.f33425d = paint;
        paint.setColor(-7829368);
        this.f33425d.setAntiAlias(true);
        this.f33425d.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = this.f33425d;
        int m19766b = C11925c.m19766b(0.5f);
        f33420g = m19766b;
        paint2.setStrokeWidth(m19766b);
        this.f33425d.setShadowLayer(f33420g, 0.0f, 0.0f, -872415232);
        setLayerType(1, null);
        int i = f33420g * 4;
        setPadding(i, i, i, i);
        this.f33425d.setColor(-7829368);
        int m19766b2 = C11925c.m19766b(20.0f);
        this.f33426e = m19766b2;
        this.f33427f = m19766b2 / 5;
        Circle circle = this.f33422a;
        circle.f33431c = m19766b2;
        Circle circle2 = this.f33423b;
        circle2.f33431c = m19766b2;
        int i2 = f33420g;
        circle.f33429a = i2 + m19766b2;
        circle.f33430b = i2 + m19766b2;
        circle2.f33429a = i2 + m19766b2;
        circle2.f33430b = i2 + m19766b2;
    }

    /* renamed from: c */
    private void m20022c() {
        this.f33424c.reset();
        Path path = this.f33424c;
        Circle circle = this.f33422a;
        path.addCircle(circle.f33429a, circle.f33430b, circle.f33431c, Path.Direction.CCW);
        if (this.f33423b.f33430b > this.f33422a.f33430b + C11925c.m19766b(1.0f)) {
            Path path2 = this.f33424c;
            Circle circle2 = this.f33423b;
            path2.addCircle(circle2.f33429a, circle2.f33430b, circle2.f33431c, Path.Direction.CCW);
            double angle = getAngle();
            Circle circle3 = this.f33422a;
            double d = circle3.f33429a;
            double d2 = circle3.f33431c;
            double cos = Math.cos(angle);
            Double.isNaN(d2);
            Double.isNaN(d);
            float f = (float) (d - (d2 * cos));
            Circle circle4 = this.f33422a;
            double d3 = circle4.f33430b;
            double d4 = circle4.f33431c;
            double sin = Math.sin(angle);
            Double.isNaN(d4);
            Double.isNaN(d3);
            float f2 = (float) (d3 + (d4 * sin));
            Circle circle5 = this.f33422a;
            double d5 = circle5.f33429a;
            double d6 = circle5.f33431c;
            double cos2 = Math.cos(angle);
            Double.isNaN(d6);
            Double.isNaN(d5);
            float f3 = (float) (d5 + (d6 * cos2));
            Circle circle6 = this.f33423b;
            double d7 = circle6.f33429a;
            double d8 = circle6.f33431c;
            double cos3 = Math.cos(angle);
            Double.isNaN(d8);
            Double.isNaN(d7);
            float f4 = (float) (d7 - (d8 * cos3));
            Circle circle7 = this.f33423b;
            double d9 = circle7.f33430b;
            double d10 = circle7.f33431c;
            double sin2 = Math.sin(angle);
            Double.isNaN(d10);
            Double.isNaN(d9);
            float f5 = (float) (d9 + (d10 * sin2));
            Circle circle8 = this.f33423b;
            double d11 = circle8.f33429a;
            double d12 = circle8.f33431c;
            double cos4 = Math.cos(angle);
            Double.isNaN(d12);
            Double.isNaN(d11);
            Path path3 = this.f33424c;
            Circle circle9 = this.f33422a;
            path3.moveTo(circle9.f33429a, circle9.f33430b);
            this.f33424c.lineTo(f, f2);
            Path path4 = this.f33424c;
            Circle circle10 = this.f33423b;
            path4.quadTo(circle10.f33429a - circle10.f33431c, (circle10.f33430b + this.f33422a.f33430b) / 2.0f, f4, f5);
            this.f33424c.lineTo((float) (d11 + (d12 * cos4)), f5);
            Path path5 = this.f33424c;
            Circle circle11 = this.f33423b;
            path5.quadTo(circle11.f33429a + circle11.f33431c, (circle11.f33430b + f2) / 2.0f, f3, f2);
        }
        this.f33424c.close();
    }

    private double getAngle() {
        Circle circle = this.f33423b;
        float f = circle.f33431c;
        Circle circle2 = this.f33422a;
        float f2 = circle2.f33431c;
        if (f <= f2) {
            return Math.asin((f2 - f) / (circle.f33430b - circle2.f33430b));
        }
        throw new IllegalStateException("bottomCircle's radius must be less than the topCircle's");
    }

    /* renamed from: a */
    public Animator m20024a() {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.001f).setDuration(180L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new C11876a());
        return duration;
    }

    /* renamed from: d */
    public void m20021d(float f) {
        int i = this.f33426e;
        double d = i;
        double d2 = f;
        Double.isNaN(d2);
        double d3 = i;
        Double.isNaN(d3);
        Double.isNaN(d);
        float f2 = f * 4.0f * i;
        Circle circle = this.f33422a;
        circle.f33431c = (float) (d - ((d2 * 0.25d) * d3));
        Circle circle2 = this.f33423b;
        circle2.f33431c = ((this.f33427f - i) * f) + i;
        circle2.f33430b = circle.f33430b + f2;
    }

    /* renamed from: e */
    public void m20020e(int i) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i2 = this.f33426e;
        float f = (i2 * 2) + paddingTop + paddingBottom;
        float f2 = i;
        if (f2 < f) {
            Circle circle = this.f33422a;
            circle.f33431c = i2;
            Circle circle2 = this.f33423b;
            circle2.f33431c = i2;
            circle2.f33430b = circle.f33430b;
            return;
        }
        float max = Math.max(0.0f, f2 - f);
        Double.isNaN(r4);
        float pow = (float) (r4 * (1.0d - Math.pow(100.0d, (-max) / C11925c.m19766b(200.0f))));
        Circle circle3 = this.f33422a;
        int i3 = this.f33426e;
        circle3.f33431c = i3 - (pow / 4.0f);
        Circle circle4 = this.f33423b;
        float f3 = i3 - pow;
        circle4.f33431c = f3;
        circle4.f33430b = ((i - paddingTop) - paddingBottom) - f3;
    }

    /* renamed from: f */
    public void m20019f(int i, int i2) {
    }

    public Circle getBottomCircle() {
        return this.f33423b;
    }

    public int getIndicatorColor() {
        return this.f33425d.getColor();
    }

    public int getMaxCircleRadius() {
        return this.f33426e;
    }

    public Circle getTopCircle() {
        return this.f33422a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        canvas.save();
        float f = height;
        float f2 = this.f33422a.f33431c;
        float f3 = paddingTop;
        float f4 = paddingBottom;
        if (f <= (f2 * 2.0f) + f3 + f4) {
            canvas.translate(paddingLeft, (f - (f2 * 2.0f)) - f4);
            Circle circle = this.f33422a;
            canvas.drawCircle(circle.f33429a, circle.f33430b, circle.f33431c, this.f33425d);
        } else {
            canvas.translate(paddingLeft, f3);
            m20022c();
            canvas.drawPath(this.f33424c, this.f33425d);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        m20020e(getHeight());
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int i3 = this.f33426e;
        int i4 = f33420g;
        Circle circle = this.f33423b;
        setMeasuredDimension(((i3 + i4) * 2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(((int) Math.ceil(circle.f33430b + circle.f33431c + (i4 * 2))) + getPaddingTop() + getPaddingBottom(), i2));
    }

    public void setIndicatorColor(@ColorInt int i) {
        this.f33425d.setColor(i);
    }

    public WaterDropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20023b(context, attributeSet);
    }

    public WaterDropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20023b(context, attributeSet);
    }
}
