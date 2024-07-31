package com.kwad.components.p208ad.reward.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.kwad.sdk.C9659R;

/* renamed from: com.kwad.components.ad.reward.widget.JinniuCouponLayout */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class JinniuCouponLayout extends LinearLayout {

    /* renamed from: Al */
    private float f27473Al;

    /* renamed from: Am */
    private Rect f27474Am;

    /* renamed from: An */
    private RectF f27475An;

    /* renamed from: Ao */
    private RectF f27476Ao;

    /* renamed from: Ap */
    private RectF f27477Ap;

    /* renamed from: Aq */
    private RectF f27478Aq;

    /* renamed from: Ar */
    private Path f27479Ar;
    @ColorInt
    private int endColor;
    private Paint mPaint;
    private float mRadius;
    @ColorInt
    private int startColor;

    public JinniuCouponLayout(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.f27473Al = 4.0f;
        this.mRadius = 10.0f;
        this.f27474Am = new Rect();
        this.f27475An = new RectF();
        this.f27476Ao = new RectF();
        this.f27477Ap = new RectF();
        this.f27478Aq = new RectF();
        this.f27479Ar = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        m30997a(context, null, 0);
    }

    /* renamed from: a */
    private void m30997a(Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_JinniuCouponLayout, i, 0);
        this.mRadius = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_JinniuCouponLayout_ksad_outerRadius, 4.0f);
        this.f27473Al = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_JinniuCouponLayout_ksad_verticalRadius, 10.0f);
        obtainStyledAttributes.recycle();
        this.mPaint.setAntiAlias(true);
    }

    private void setGradientPaint(RectF rectF) {
        this.mPaint.setShader(new LinearGradient(rectF.left, rectF.top, rectF.right, rectF.bottom, this.startColor, this.endColor, Shader.TileMode.CLAMP));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        this.f27474Am.setEmpty();
        getDrawingRect(this.f27474Am);
        this.f27475An.set(this.f27474Am);
        if (getChildCount() > 1) {
            View childAt = getChildAt(0);
            RectF rectF = this.f27476Ao;
            if (rectF == null) {
                this.f27476Ao = new RectF();
            } else {
                rectF.setEmpty();
            }
            RectF rectF2 = this.f27477Ap;
            if (rectF2 == null) {
                this.f27477Ap = new RectF();
            } else {
                rectF2.setEmpty();
            }
            Rect rect = this.f27474Am;
            float measuredWidth = rect.left + childAt.getMeasuredWidth();
            RectF rectF3 = this.f27476Ao;
            int i = rect.top;
            float f = this.f27473Al;
            rectF3.set(measuredWidth, i - f, (2.0f * f) + measuredWidth, i + f);
            RectF rectF4 = this.f27477Ap;
            RectF rectF5 = this.f27476Ao;
            float f2 = rectF5.left;
            int i2 = this.f27474Am.bottom;
            float f3 = this.f27473Al;
            rectF4.set(f2, i2 - f3, rectF5.right, i2 + f3);
            m30996a(this.f27479Ar, this.f27475An, this.f27476Ao, this.f27477Ap);
            setGradientPaint(this.f27475An);
            canvas.drawPath(this.f27479Ar, this.mPaint);
        }
        super.dispatchDraw(canvas);
    }

    /* renamed from: a */
    private void m30996a(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        RectF rectF4 = this.f27475An;
        path.moveTo(rectF4.left, rectF4.top + this.mRadius);
        this.f27478Aq.set(rectF);
        RectF rectF5 = this.f27478Aq;
        float f = rectF5.top;
        float f2 = this.mRadius;
        rectF5.bottom = f + (f2 * 2.0f);
        rectF5.right = rectF5.left + (f2 * 2.0f);
        path.arcTo(rectF5, 180.0f, 90.0f);
        path.lineTo(rectF2.left, rectF2.top);
        path.arcTo(rectF2, -180.0f, -180.0f);
        path.lineTo(rectF.width() - this.mRadius, rectF.top);
        this.f27478Aq.set(rectF);
        RectF rectF6 = this.f27478Aq;
        float f3 = rectF6.right;
        float f4 = this.mRadius;
        rectF6.left = f3 - (f4 * 2.0f);
        rectF6.bottom = rectF6.top + (f4 * 2.0f);
        path.arcTo(rectF6, 270.0f, 90.0f);
        this.f27478Aq.set(rectF);
        RectF rectF7 = this.f27478Aq;
        float f5 = rectF7.right;
        float f6 = this.mRadius;
        rectF7.left = f5 - (f6 * 2.0f);
        rectF7.top = rectF7.bottom - (f6 * 2.0f);
        path.arcTo(rectF7, 0.0f, 90.0f);
        path.lineTo(rectF3.right, rectF3.bottom);
        path.arcTo(rectF3, 0.0f, -180.0f);
        path.lineTo(rectF.left + this.mRadius, rectF.bottom);
        this.f27478Aq.set(rectF);
        RectF rectF8 = this.f27478Aq;
        float f7 = rectF8.left;
        float f8 = this.mRadius;
        rectF8.right = f7 + (f8 * 2.0f);
        rectF8.top = rectF8.bottom - (f8 * 2.0f);
        path.arcTo(rectF8, 90.0f, 90.0f);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.f27473Al = 4.0f;
        this.mRadius = 10.0f;
        this.f27474Am = new Rect();
        this.f27475An = new RectF();
        this.f27476Ao = new RectF();
        this.f27477Ap = new RectF();
        this.f27478Aq = new RectF();
        this.f27479Ar = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        m30997a(context, attributeSet, 0);
    }

    public JinniuCouponLayout(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.f27473Al = 4.0f;
        this.mRadius = 10.0f;
        this.f27474Am = new Rect();
        this.f27475An = new RectF();
        this.f27476Ao = new RectF();
        this.f27477Ap = new RectF();
        this.f27478Aq = new RectF();
        this.f27479Ar = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        m30997a(context, attributeSet, i);
    }

    @RequiresApi(api = 21)
    public JinniuCouponLayout(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.mPaint = new Paint();
        this.f27473Al = 4.0f;
        this.mRadius = 10.0f;
        this.f27474Am = new Rect();
        this.f27475An = new RectF();
        this.f27476Ao = new RectF();
        this.f27477Ap = new RectF();
        this.f27478Aq = new RectF();
        this.f27479Ar = new Path();
        this.startColor = Color.parseColor("#FFFE3666");
        this.endColor = Color.parseColor("#FFFD7200");
        m30997a(context, attributeSet, i);
    }
}
