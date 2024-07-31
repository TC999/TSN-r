package com.scwang.smartrefresh.layout.header.bezierradar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class WaveView extends View {

    /* renamed from: a */
    private int f33681a;

    /* renamed from: b */
    private int f33682b;

    /* renamed from: c */
    private Path f33683c;

    /* renamed from: d */
    private Paint f33684d;

    /* renamed from: e */
    private int f33685e;

    public WaveView(Context context) {
        this(context, null, 0);
    }

    /* renamed from: a */
    private void m19845a() {
        this.f33683c = new Path();
        Paint paint = new Paint();
        this.f33684d = paint;
        paint.setColor(-14736346);
        this.f33684d.setAntiAlias(true);
    }

    public int getHeadHeight() {
        return this.f33682b;
    }

    public int getWaveHeight() {
        return this.f33681a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int width = getWidth();
        this.f33683c.reset();
        this.f33683c.lineTo(0.0f, this.f33682b);
        Path path = this.f33683c;
        int i2 = this.f33685e;
        if (i2 < 0) {
            i2 = width / 2;
        }
        float f = width;
        path.quadTo(i2, this.f33681a + i, f, this.f33682b);
        this.f33683c.lineTo(f, 0.0f);
        canvas.drawPath(this.f33683c, this.f33684d);
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    public void setHeadHeight(int i) {
        this.f33682b = i;
    }

    public void setWaveColor(@ColorInt int i) {
        this.f33684d.setColor(i);
    }

    public void setWaveHeight(int i) {
        this.f33681a = i;
    }

    public void setWaveOffsetX(int i) {
        this.f33685e = i;
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f33685e = -1;
        m19845a();
    }
}
