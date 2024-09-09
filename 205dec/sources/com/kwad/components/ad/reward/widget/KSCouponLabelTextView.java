package com.kwad.components.ad.reward.widget;

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
import com.kwad.components.core.widget.d;
import com.kwad.components.core.widget.e;
import com.kwad.sdk.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
@SuppressLint({"AppCompatCustomView"})
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class KSCouponLabelTextView extends TextView implements d {
    private boolean AA;
    private final Rect Am;
    private final RectF An;
    private final RectF Aq;
    private float As;
    private float At;
    private float Au;
    private final RectF Av;
    private final RectF Aw;
    private final Path Ax;
    private Path Ay;
    private Path Az;
    private final Paint mPaint;
    @ColorInt
    private int strokeColor;

    public KSCouponLabelTextView(Context context) {
        super(context);
        this.mPaint = new Paint();
        this.Am = new Rect();
        this.An = new RectF();
        this.Av = new RectF();
        this.Aw = new RectF();
        this.Ax = new Path();
        this.Aq = new RectF();
        this.AA = true;
        a(context, null, 0);
    }

    @SuppressLint({"CustomViewStyleable"})
    private void a(Context context, AttributeSet attributeSet, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_KSCouponLabelTextView, i4, 0);
        int color = context.getResources().getColor(R.color.ksad_reward_main_color);
        this.As = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_labelRadius, 8.0f);
        this.At = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeSize, 2.0f);
        this.strokeColor = obtainStyledAttributes.getColor(R.styleable.ksad_KSCouponLabelTextView_ksad_strokeColor, color);
        this.Au = obtainStyledAttributes.getDimension(R.styleable.ksad_KSCouponLabelTextView_ksad_sideRadius, 16.0f);
        obtainStyledAttributes.recycle();
        kd();
    }

    private void b(Path path, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        path.moveTo(rectF.left, rectF.top + this.As);
        this.Aq.set(rectF);
        RectF rectF4 = this.Aq;
        float f4 = rectF4.top;
        float f5 = this.As;
        rectF4.bottom = f4 + (f5 * 2.0f);
        rectF4.right = rectF4.left + (f5 * 2.0f);
        path.arcTo(rectF4, 180.0f, 90.0f);
        path.lineTo(rectF.width() - this.As, rectF.top);
        this.Aq.set(rectF);
        RectF rectF5 = this.Aq;
        float f6 = rectF5.right;
        float f7 = this.As;
        rectF5.left = f6 - (f7 * 2.0f);
        rectF5.bottom = rectF5.top + (f7 * 2.0f);
        path.arcTo(rectF5, 270.0f, 90.0f);
        path.lineTo(rectF.right, rectF3.top);
        path.arcTo(rectF3, 270.0f, -180.0f);
        path.lineTo(rectF.right, rectF.bottom - this.As);
        this.Aq.set(rectF);
        RectF rectF6 = this.Aq;
        float f8 = rectF6.right;
        float f9 = this.As;
        rectF6.left = f8 - (f9 * 2.0f);
        rectF6.top = rectF6.bottom - (f9 * 2.0f);
        path.arcTo(rectF6, 0.0f, 90.0f);
        path.lineTo(rectF.left + this.As, rectF.bottom);
        this.Aq.set(rectF);
        RectF rectF7 = this.Aq;
        float f10 = rectF7.left;
        float f11 = this.As;
        rectF7.right = f10 + (f11 * 2.0f);
        rectF7.top = rectF7.bottom - (f11 * 2.0f);
        path.arcTo(rectF7, 90.0f, 90.0f);
        path.lineTo(rectF.left, rectF2.bottom);
        path.arcTo(rectF2, 90.0f, -180.0f);
        path.close();
    }

    private void kd() {
        this.mPaint.setColor(this.strokeColor);
        this.mPaint.setStrokeWidth(this.At);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setAntiAlias(true);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.Am.setEmpty();
        getDrawingRect(this.Am);
        float f4 = this.At / 2.0f;
        this.An.set(this.Am);
        RectF rectF = this.An;
        rectF.left += f4;
        rectF.top += f4;
        rectF.right -= f4;
        rectF.bottom -= f4;
        a(rectF, this.Av);
        b(this.An, this.Aw);
        if (Build.VERSION.SDK_INT >= 19) {
            Path path = this.Ay;
            if (path == null) {
                this.Ay = new Path();
            } else {
                path.reset();
            }
            Path path2 = this.Az;
            if (path2 == null) {
                this.Az = new Path();
            } else {
                path2.reset();
            }
            a(this.Ax, this.Ay, this.Az, this.An, this.Av, this.Aw);
            canvas.drawPath(this.Ax, this.mPaint);
            return;
        }
        b(this.Ax, this.An, this.Av, this.Aw);
        canvas.drawPath(this.Ax, this.mPaint);
    }

    @Override // android.widget.TextView, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.AA) {
            if (((float) (getPaddingLeft() + getPaddingRight())) + getPaint().measureText(getText().toString()) <= ((float) getMeasuredWidth())) {
                return;
            }
            setVisibility(8);
        }
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mPaint = new Paint();
        this.Am = new Rect();
        this.An = new RectF();
        this.Av = new RectF();
        this.Aw = new RectF();
        this.Ax = new Path();
        this.Aq = new RectF();
        this.AA = true;
        a(context, attributeSet, 0);
    }

    @RequiresApi(api = 19)
    private void a(Path path, Path path2, Path path3, RectF rectF, RectF rectF2, RectF rectF3) {
        path.reset();
        float f4 = this.As;
        path.addRoundRect(rectF, f4, f4, Path.Direction.CW);
        path2.addArc(rectF2, 90.0f, -180.0f);
        path3.addArc(rectF3, 90.0f, 180.0f);
        path.op(this.Ay, Path.Op.DIFFERENCE);
        path.op(this.Az, Path.Op.DIFFERENCE);
    }

    private void a(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f4 = rectF2.left;
        float f5 = this.Au;
        float f6 = f4 - f5;
        rectF2.left = f6;
        rectF2.right = f6 + (f5 * 2.0f);
        float height = rectF.height();
        float f7 = this.Au;
        float f8 = rectF2.top + ((height - (f7 * 2.0f)) / 2.0f);
        rectF2.top = f8;
        rectF2.bottom = f8 + (f7 * 2.0f);
    }

    public KSCouponLabelTextView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.mPaint = new Paint();
        this.Am = new Rect();
        this.An = new RectF();
        this.Av = new RectF();
        this.Aw = new RectF();
        this.Ax = new Path();
        this.Aq = new RectF();
        this.AA = true;
        a(context, attributeSet, i4);
    }

    @Override // com.kwad.components.core.widget.d
    public final void a(e eVar) {
        int color = getResources().getColor(R.color.ksad_reward_main_color);
        this.strokeColor = color;
        setTextColor(color);
        kd();
        invalidate();
    }

    private void b(RectF rectF, RectF rectF2) {
        rectF2.set(rectF);
        float f4 = rectF2.right;
        float f5 = this.Au;
        float f6 = f4 + f5;
        rectF2.right = f6;
        rectF2.left = f6 - (f5 * 2.0f);
        float height = rectF.height();
        float f7 = this.Au;
        float f8 = rectF2.top + ((height - (f7 * 2.0f)) / 2.0f);
        rectF2.top = f8;
        rectF2.bottom = f8 + (f7 * 2.0f);
    }
}
