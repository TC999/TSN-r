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
import com.beizi.fusion.C3025R;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class BackArrowView extends View {

    /* renamed from: a */
    private int f11555a;

    /* renamed from: b */
    private int f11556b;

    /* renamed from: c */
    private float f11557c;

    /* renamed from: d */
    private float f11558d;

    /* renamed from: e */
    private int f11559e;

    /* renamed from: f */
    private float f11560f;

    /* renamed from: g */
    private int f11561g;

    /* renamed from: h */
    private Paint f11562h;

    /* renamed from: i */
    private Path f11563i;

    public BackArrowView(Context context) {
        this(context, null);
    }

    /* renamed from: a */
    private void m48084a(Context context, @Nullable AttributeSet attributeSet, int i) {
        m48083b(context, attributeSet, i);
        Paint paint = new Paint();
        this.f11562h = paint;
        paint.setColor(this.f11559e);
        this.f11562h.setStyle(Paint.Style.STROKE);
        this.f11562h.setAntiAlias(true);
        this.f11562h.setStrokeWidth(this.f11560f);
        this.f11562h.setStrokeJoin(Paint.Join.ROUND);
    }

    /* renamed from: b */
    private void m48083b(Context context, @Nullable AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3025R.styleable.BeiZi_BackArrowView, i, 0);
        this.f11559e = obtainStyledAttributes.getColor(C3025R.styleable.BeiZi_BackArrowView_beizi_bav_color, Color.argb(255, 0, 0, 0));
        this.f11560f = obtainStyledAttributes.getDimension(C3025R.styleable.BeiZi_BackArrowView_beizi_bav_stroke_width, dip2px(context, 2.0f));
        this.f11561g = obtainStyledAttributes.getInt(C3025R.styleable.BeiZi_BackArrowView_beizi_bav_arrow_style, 1);
        obtainStyledAttributes.recycle();
    }

    public static int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate((this.f11555a / 2.0f) - this.f11557c, this.f11556b / 2);
        canvas.rotate(45.0f);
        if (this.f11563i == null) {
            this.f11563i = new Path();
        }
        this.f11563i.reset();
        this.f11563i.lineTo(0.0f, this.f11558d);
        this.f11563i.moveTo(0.0f, 0.0f);
        this.f11563i.lineTo(-this.f11558d, 0.0f);
        if (this.f11561g == 1) {
            this.f11563i.moveTo(0.0f, 0.0f);
            Path path = this.f11563i;
            float f = this.f11558d;
            path.lineTo(f, -f);
        }
        this.f11563i.close();
        canvas.drawPath(this.f11563i, this.f11562h);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(m48085a(i), m48085a(i2));
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f11555a = i;
        this.f11556b = i2;
        float min = Math.min(i, i2) / 2.0f;
        int i5 = this.f11561g;
        if (i5 == 1) {
            this.f11557c = min / 3.0f;
        } else if (i5 == 2) {
            this.f11557c = min / 4.0f;
        }
        this.f11558d = min * 0.63f;
    }

    public void setViewColor(int i) {
        Paint paint = this.f11562h;
        if (paint != null) {
            paint.setColor(i);
            invalidate();
        }
    }

    public BackArrowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BackArrowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m48084a(context, attributeSet, i);
    }

    /* renamed from: a */
    private int m48085a(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        return mode == 1073741824 ? size : mode == Integer.MIN_VALUE ? Math.min((int) TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME, size) : TTDownloadField.CALL_DOWNLOAD_MODEL_SET_VERSION_NAME;
    }
}
