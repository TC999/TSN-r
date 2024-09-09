package com.beizi.fusion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.beizi.fusion.R;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class BackArrowView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f15140a;

    /* renamed from: b  reason: collision with root package name */
    private int f15141b;

    /* renamed from: c  reason: collision with root package name */
    private float f15142c;

    /* renamed from: d  reason: collision with root package name */
    private float f15143d;

    /* renamed from: e  reason: collision with root package name */
    private int f15144e;

    /* renamed from: f  reason: collision with root package name */
    private float f15145f;

    /* renamed from: g  reason: collision with root package name */
    private int f15146g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f15147h;

    /* renamed from: i  reason: collision with root package name */
    private Path f15148i;

    public BackArrowView(Context context) {
        this(context, null);
    }

    private void a(Context context, @Nullable AttributeSet attributeSet, int i4) {
        b(context, attributeSet, i4);
        Paint paint = new Paint();
        this.f15147h = paint;
        paint.setColor(this.f15144e);
        this.f15147h.setStyle(Paint.Style.STROKE);
        this.f15147h.setAntiAlias(true);
        this.f15147h.setStrokeWidth(this.f15145f);
        this.f15147h.setStrokeJoin(Paint.Join.ROUND);
    }

    private void b(Context context, @Nullable AttributeSet attributeSet, int i4) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.BeiZi_BackArrowView, i4, 0);
        this.f15144e = obtainStyledAttributes.getColor(R.styleable.BeiZi_BackArrowView_beizi_bav_color, Color.argb(255, 0, 0, 0));
        this.f15145f = obtainStyledAttributes.getDimension(R.styleable.BeiZi_BackArrowView_beizi_bav_stroke_width, dip2px(context, 2.0f));
        this.f15146g = obtainStyledAttributes.getInt(R.styleable.BeiZi_BackArrowView_beizi_bav_arrow_style, 1);
        obtainStyledAttributes.recycle();
    }

    public static int dip2px(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate((this.f15140a / 2.0f) - this.f15142c, this.f15141b / 2);
        canvas.rotate(45.0f);
        if (this.f15148i == null) {
            this.f15148i = new Path();
        }
        this.f15148i.reset();
        this.f15148i.lineTo(0.0f, this.f15143d);
        this.f15148i.moveTo(0.0f, 0.0f);
        this.f15148i.lineTo(-this.f15143d, 0.0f);
        if (this.f15146g == 1) {
            this.f15148i.moveTo(0.0f, 0.0f);
            Path path = this.f15148i;
            float f4 = this.f15143d;
            path.lineTo(f4, -f4);
        }
        this.f15148i.close();
        canvas.drawPath(this.f15148i, this.f15147h);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        setMeasuredDimension(a(i4), a(i5));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i4, int i5, int i6, int i7) {
        super.onSizeChanged(i4, i5, i6, i7);
        this.f15140a = i4;
        this.f15141b = i5;
        float min = Math.min(i4, i5) / 2.0f;
        int i8 = this.f15146g;
        if (i8 == 1) {
            this.f15142c = min / 3.0f;
        } else if (i8 == 2) {
            this.f15142c = min / 4.0f;
        }
        this.f15143d = min * 0.63f;
    }

    public void setViewColor(int i4) {
        Paint paint = this.f15147h;
        if (paint != null) {
            paint.setColor(i4);
            invalidate();
        }
    }

    public BackArrowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackArrowView(Context context, @Nullable AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        a(context, attributeSet, i4);
    }

    private int a(int i4) {
        int mode = View.MeasureSpec.getMode(i4);
        int size = View.MeasureSpec.getSize(i4);
        if (mode == 1073741824) {
            return size;
        }
        if (mode == Integer.MIN_VALUE) {
            return Math.min(150, size);
        }
        return 150;
    }
}
