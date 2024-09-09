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
import com.scwang.smartrefresh.layout.util.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WaterDropView extends View {

    /* renamed from: g  reason: collision with root package name */
    private static int f47805g = 2;

    /* renamed from: h  reason: collision with root package name */
    private static final int f47806h = 180;

    /* renamed from: a  reason: collision with root package name */
    private com.scwang.smartrefresh.header.waterdrop.a f47807a;

    /* renamed from: b  reason: collision with root package name */
    private com.scwang.smartrefresh.header.waterdrop.a f47808b;

    /* renamed from: c  reason: collision with root package name */
    private Path f47809c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f47810d;

    /* renamed from: e  reason: collision with root package name */
    private int f47811e;

    /* renamed from: f  reason: collision with root package name */
    private int f47812f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    class a implements ValueAnimator.AnimatorUpdateListener {
        a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaterDropView.this.d(((Float) valueAnimator.getAnimatedValue()).floatValue());
            WaterDropView.this.postInvalidate();
        }
    }

    public WaterDropView(Context context) {
        super(context);
        b(context, null);
    }

    private void b(Context context, AttributeSet attributeSet) {
        this.f47807a = new com.scwang.smartrefresh.header.waterdrop.a();
        this.f47808b = new com.scwang.smartrefresh.header.waterdrop.a();
        this.f47809c = new Path();
        Paint paint = new Paint();
        this.f47810d = paint;
        paint.setColor(-7829368);
        this.f47810d.setAntiAlias(true);
        this.f47810d.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = this.f47810d;
        int b4 = c.b(0.5f);
        f47805g = b4;
        paint2.setStrokeWidth(b4);
        this.f47810d.setShadowLayer(f47805g, 0.0f, 0.0f, -872415232);
        setLayerType(1, null);
        int i4 = f47805g * 4;
        setPadding(i4, i4, i4, i4);
        this.f47810d.setColor(-7829368);
        int b5 = c.b(20.0f);
        this.f47811e = b5;
        this.f47812f = b5 / 5;
        com.scwang.smartrefresh.header.waterdrop.a aVar = this.f47807a;
        aVar.f47816c = b5;
        com.scwang.smartrefresh.header.waterdrop.a aVar2 = this.f47808b;
        aVar2.f47816c = b5;
        int i5 = f47805g;
        aVar.f47814a = i5 + b5;
        aVar.f47815b = i5 + b5;
        aVar2.f47814a = i5 + b5;
        aVar2.f47815b = i5 + b5;
    }

    private void c() {
        this.f47809c.reset();
        Path path = this.f47809c;
        com.scwang.smartrefresh.header.waterdrop.a aVar = this.f47807a;
        path.addCircle(aVar.f47814a, aVar.f47815b, aVar.f47816c, Path.Direction.CCW);
        if (this.f47808b.f47815b > this.f47807a.f47815b + c.b(1.0f)) {
            Path path2 = this.f47809c;
            com.scwang.smartrefresh.header.waterdrop.a aVar2 = this.f47808b;
            path2.addCircle(aVar2.f47814a, aVar2.f47815b, aVar2.f47816c, Path.Direction.CCW);
            double angle = getAngle();
            com.scwang.smartrefresh.header.waterdrop.a aVar3 = this.f47807a;
            double d4 = aVar3.f47814a;
            double d5 = aVar3.f47816c;
            double cos = Math.cos(angle);
            Double.isNaN(d5);
            Double.isNaN(d4);
            float f4 = (float) (d4 - (d5 * cos));
            com.scwang.smartrefresh.header.waterdrop.a aVar4 = this.f47807a;
            double d6 = aVar4.f47815b;
            double d7 = aVar4.f47816c;
            double sin = Math.sin(angle);
            Double.isNaN(d7);
            Double.isNaN(d6);
            float f5 = (float) (d6 + (d7 * sin));
            com.scwang.smartrefresh.header.waterdrop.a aVar5 = this.f47807a;
            double d8 = aVar5.f47814a;
            double d9 = aVar5.f47816c;
            double cos2 = Math.cos(angle);
            Double.isNaN(d9);
            Double.isNaN(d8);
            float f6 = (float) (d8 + (d9 * cos2));
            com.scwang.smartrefresh.header.waterdrop.a aVar6 = this.f47808b;
            double d10 = aVar6.f47814a;
            double d11 = aVar6.f47816c;
            double cos3 = Math.cos(angle);
            Double.isNaN(d11);
            Double.isNaN(d10);
            float f7 = (float) (d10 - (d11 * cos3));
            com.scwang.smartrefresh.header.waterdrop.a aVar7 = this.f47808b;
            double d12 = aVar7.f47815b;
            double d13 = aVar7.f47816c;
            double sin2 = Math.sin(angle);
            Double.isNaN(d13);
            Double.isNaN(d12);
            float f8 = (float) (d12 + (d13 * sin2));
            com.scwang.smartrefresh.header.waterdrop.a aVar8 = this.f47808b;
            double d14 = aVar8.f47814a;
            double d15 = aVar8.f47816c;
            double cos4 = Math.cos(angle);
            Double.isNaN(d15);
            Double.isNaN(d14);
            Path path3 = this.f47809c;
            com.scwang.smartrefresh.header.waterdrop.a aVar9 = this.f47807a;
            path3.moveTo(aVar9.f47814a, aVar9.f47815b);
            this.f47809c.lineTo(f4, f5);
            Path path4 = this.f47809c;
            com.scwang.smartrefresh.header.waterdrop.a aVar10 = this.f47808b;
            path4.quadTo(aVar10.f47814a - aVar10.f47816c, (aVar10.f47815b + this.f47807a.f47815b) / 2.0f, f7, f8);
            this.f47809c.lineTo((float) (d14 + (d15 * cos4)), f8);
            Path path5 = this.f47809c;
            com.scwang.smartrefresh.header.waterdrop.a aVar11 = this.f47808b;
            path5.quadTo(aVar11.f47814a + aVar11.f47816c, (aVar11.f47815b + f5) / 2.0f, f6, f5);
        }
        this.f47809c.close();
    }

    private double getAngle() {
        com.scwang.smartrefresh.header.waterdrop.a aVar = this.f47808b;
        float f4 = aVar.f47816c;
        com.scwang.smartrefresh.header.waterdrop.a aVar2 = this.f47807a;
        float f5 = aVar2.f47816c;
        if (f4 <= f5) {
            return Math.asin((f5 - f4) / (aVar.f47815b - aVar2.f47815b));
        }
        throw new IllegalStateException("bottomCircle's radius must be less than the topCircle's");
    }

    public Animator a() {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.001f).setDuration(180L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new a());
        return duration;
    }

    public void d(float f4) {
        int i4 = this.f47811e;
        double d4 = i4;
        double d5 = f4;
        Double.isNaN(d5);
        double d6 = i4;
        Double.isNaN(d6);
        Double.isNaN(d4);
        float f5 = f4 * 4.0f * i4;
        com.scwang.smartrefresh.header.waterdrop.a aVar = this.f47807a;
        aVar.f47816c = (float) (d4 - ((d5 * 0.25d) * d6));
        com.scwang.smartrefresh.header.waterdrop.a aVar2 = this.f47808b;
        aVar2.f47816c = ((this.f47812f - i4) * f4) + i4;
        aVar2.f47815b = aVar.f47815b + f5;
    }

    public void e(int i4) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i5 = this.f47811e;
        float f4 = (i5 * 2) + paddingTop + paddingBottom;
        float f5 = i4;
        if (f5 < f4) {
            com.scwang.smartrefresh.header.waterdrop.a aVar = this.f47807a;
            aVar.f47816c = i5;
            com.scwang.smartrefresh.header.waterdrop.a aVar2 = this.f47808b;
            aVar2.f47816c = i5;
            aVar2.f47815b = aVar.f47815b;
            return;
        }
        float max = Math.max(0.0f, f5 - f4);
        Double.isNaN(r4);
        float pow = (float) (r4 * (1.0d - Math.pow(100.0d, (-max) / c.b(200.0f))));
        com.scwang.smartrefresh.header.waterdrop.a aVar3 = this.f47807a;
        int i6 = this.f47811e;
        aVar3.f47816c = i6 - (pow / 4.0f);
        com.scwang.smartrefresh.header.waterdrop.a aVar4 = this.f47808b;
        float f6 = i6 - pow;
        aVar4.f47816c = f6;
        aVar4.f47815b = ((i4 - paddingTop) - paddingBottom) - f6;
    }

    public void f(int i4, int i5) {
    }

    public com.scwang.smartrefresh.header.waterdrop.a getBottomCircle() {
        return this.f47808b;
    }

    public int getIndicatorColor() {
        return this.f47810d.getColor();
    }

    public int getMaxCircleRadius() {
        return this.f47811e;
    }

    public com.scwang.smartrefresh.header.waterdrop.a getTopCircle() {
        return this.f47807a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        canvas.save();
        float f4 = height;
        float f5 = this.f47807a.f47816c;
        float f6 = paddingTop;
        float f7 = paddingBottom;
        if (f4 <= (f5 * 2.0f) + f6 + f7) {
            canvas.translate(paddingLeft, (f4 - (f5 * 2.0f)) - f7);
            com.scwang.smartrefresh.header.waterdrop.a aVar = this.f47807a;
            canvas.drawCircle(aVar.f47814a, aVar.f47815b, aVar.f47816c, this.f47810d);
        } else {
            canvas.translate(paddingLeft, f6);
            c();
            canvas.drawPath(this.f47809c, this.f47810d);
        }
        canvas.restore();
    }

    @Override // android.view.View
    protected void onLayout(boolean z3, int i4, int i5, int i6, int i7) {
        super.onLayout(z3, i4, i5, i6, i7);
        e(getHeight());
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        int i6 = this.f47811e;
        int i7 = f47805g;
        com.scwang.smartrefresh.header.waterdrop.a aVar = this.f47808b;
        setMeasuredDimension(((i6 + i7) * 2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(((int) Math.ceil(aVar.f47815b + aVar.f47816c + (i7 * 2))) + getPaddingTop() + getPaddingBottom(), i5));
    }

    public void setIndicatorColor(@ColorInt int i4) {
        this.f47810d.setColor(i4);
    }

    public WaterDropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context, attributeSet);
    }

    public WaterDropView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        b(context, attributeSet);
    }
}
