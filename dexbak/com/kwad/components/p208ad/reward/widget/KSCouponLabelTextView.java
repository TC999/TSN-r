package com.kwad.components.p208ad.reward.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.annotation.ColorInt;
import androidx.annotation.RequiresApi;
import com.kwad.components.core.widget.C9374e;
import com.kwad.components.core.widget.InterfaceC9373d;
import com.kwad.sdk.C9659R;

@SuppressLint({"AppCompatCustomView"})
/* renamed from: com.kwad.components.ad.reward.widget.KSCouponLabelTextView */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class KSCouponLabelTextView extends TextView implements InterfaceC9373d {

    /* renamed from: AA */
    private boolean f27480AA;

    /* renamed from: Am */
    private final Rect f27481Am;

    /* renamed from: An */
    private final RectF f27482An;

    /* renamed from: Aq */
    private final RectF f27483Aq;

    /* renamed from: As */
    private float f27484As;

    /* renamed from: At */
    private float f27485At;

    /* renamed from: Au */
    private float f27486Au;

    /* renamed from: Av */
    private final RectF f27487Av;

    /* renamed from: Aw */
    private final RectF f27488Aw;

    /* renamed from: Ax */
    private final Path f27489Ax;

    /* renamed from: Ay */
    private Path f27490Ay;

    /* renamed from: Az */
    private Path f27491Az;
    private final Paint mPaint;
    @ColorInt
    private int strokeColor;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.f27481Am = new Rect();
        this.f27482An = new RectF();
        this.f27487Av = new RectF();
        this.f27488Aw = new RectF();
        this.f27489Ax = new Path();
        this.f27483Aq = new RectF();
        this.f27480AA = true;
        m30995a(context, null, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    /* renamed from: a */
    private void m30995a(Context context, AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C9659R.styleable.ksad_KSCouponLabelTextView, i, 0);
        int color = context.getResources().getColor(C9659R.C9660color.ksad_reward_main_color);
        this.f27484As = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.f27485At = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.strokeColor = obtainStyledAttributes.getColor(C9659R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.f27486Au = obtainStyledAttributes.getDimension(C9659R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        obtainStyledAttributes.recycle();
        m30990kd();
    }

    /* renamed from: b */
    private void m30992b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.f27484As);
        this.f27483Aq.set(rectF);
        RectF rectF4 = this.f27483Aq;
        float f = rectF4.top;
        float f2 = this.f27484As;
        rectF4.bottom = f + (f2 * 2.0f);
        rectF4.right = rectF4.left + (f2 * 2.0f);
        path.arcTo(rectF4, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.f27484As, rectF.top);
        this.f27483Aq.set(rectF);
        RectF rectF5 = this.f27483Aq;
        float f3 = rectF5.right;
        float f4 = this.f27484As;
        rectF5.left = f3 - (f4 * 2.0f);
        rectF5.bottom = rectF5.top + (f4 * 2.0f);
        path.arcTo(rectF5, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.f27484As);
        this.f27483Aq.set(rectF);
        RectF rectF6 = this.f27483Aq;
        float f5 = rectF6.right;
        float f6 = this.f27484As;
        rectF6.left = f5 - (f6 * 2.0f);
        rectF6.top = rectF6.bottom - (f6 * 2.0f);
        path.arcTo(rectF6, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.f27484As, rectF.bottom);
        this.f27483Aq.set(rectF);
        RectF rectF7 = this.f27483Aq;
        float f7 = rectF7.left;
        float f8 = this.f27484As;
        rectF7.right = f7 + (f8 * 2.0f);
        rectF7.top = rectF7.bottom - (f8 * 2.0f);
        path.arcTo(rectF7, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    /* renamed from: kd */
    private void m30990kd() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.f27485At);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.f27481Am.setEmpty();
        getDrawingRect(this.f27481Am);
        float f = this.f27485At / 2.0f;
        this.f27482An.set(this.f27481Am);
        RectF rectF = this.f27482An;
        rectF.left += f;
        rectF.top += f;
        rectF.right -= f;
        rectF.bottom -= f;
        m30993a(rectF, this.f27487Av);
        m30991b(this.f27482An, this.f27488Aw);
        if (Build.VERSION.SDK_INT >= 19) {
            Path path = this.f27490Ay;
            if (path == null) {
                this.f27490Ay = new Path();
            } else {
                path.reset();
            }
            Path path2 = this.f27491Az;
            if (path2 == null) {
                this.f27491Az = new Path();
            } else {
                path2.reset();
            }
            m30994a(this.f27489Ax, this.f27490Ay, this.f27491Az, this.f27482An, this.f27487Av, this.f27488Aw);
            canvas.drawPath(this.f27489Ax, this.mPaint);
            return;
        }
        m30992b(this.f27489Ax, this.f27482An, this.f27487Av, this.f27488Aw);
        canvas.drawPath(this.f27489Ax, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f27480AA) {
            if (((float) (getPaddingLeft() + getPaddingRight())) + getPaint().measureText(getText().toString()) <= ((float) getMeasuredWidth())) {
                return;
            }
            setVisibility(8);
        }
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.f27481Am = new Rect();
        this.f27482An = new RectF();
        this.f27487Av = new RectF();
        this.f27488Aw = new RectF();
        this.f27489Ax = new Path();
        this.f27483Aq = new RectF();
        this.f27480AA = true;
        m30995a(context, attributeSet, 0);
    }

    @RequiresApi(api = 19)
    /* renamed from: a */
    private void m30994a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f = this.f27484As;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        path.op(this.f27490Ay, Path.Op.DIFFERENCE);
        path.op(this.f27491Az, Path.Op.DIFFERENCE);
    }

    /* renamed from: a */
    private void m30993a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f = rectF2.left;
        float f2 = this.f27486Au;
        float f3 = f - f2;
        rectF2.left = f3;
        rectF2.right = f3 + (f2 * 2.0f);
        float height = rectF.height();
        float f4 = this.f27486Au;
        float f5 = rectF2.top + ((height - (f4 * 2.0f)) / 2.0f);
        rectF2.top = f5;
        rectF2.bottom = f5 + (f4 * 2.0f);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mPaint = new Paint();
        this.f27481Am = new Rect();
        this.f27482An = new RectF();
        this.f27487Av = new RectF();
        this.f27488Aw = new RectF();
        this.f27489Ax = new Path();
        this.f27483Aq = new RectF();
        this.f27480AA = true;
        m30995a(context, attributeSet, i);
    }

    @Override // com.kwad.components.core.widget.InterfaceC9373d
    /* renamed from: a */
    public final void mo28874a(C9374e c9374e) {
        int color = getResources().getColor(C9659R.C9660color.ksad_reward_main_color);
        this.strokeColor = color;
        setTextColor(color);
        m30990kd();
        invalidate();
    }

    /* renamed from: b */
    private void m30991b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f = rectF2.right;
        float f2 = this.f27486Au;
        float f3 = f + f2;
        rectF2.right = f3;
        rectF2.left = f3 - (f2 * 2.0f);
        float height = rectF.height();
        float f4 = this.f27486Au;
        float f5 = rectF2.top + ((height - (f4 * 2.0f)) / 2.0f);
        rectF2.top = f5;
        rectF2.bottom = f5 + (f4 * 2.0f);
    }
}
