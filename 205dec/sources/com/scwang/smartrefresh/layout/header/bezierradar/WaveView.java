package com.scwang.smartrefresh.layout.header.bezierradar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class WaveView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f48015a;

    /* renamed from: b  reason: collision with root package name */
    private int f48016b;

    /* renamed from: c  reason: collision with root package name */
    private Path f48017c;

    /* renamed from: d  reason: collision with root package name */
    private Paint f48018d;

    /* renamed from: e  reason: collision with root package name */
    private int f48019e;

    public WaveView(Context context) {
        this(context, null, 0);
    }

    private void a() {
        this.f48017c = new Path();
        Paint paint = new Paint();
        this.f48018d = paint;
        paint.setColor(-14736346);
        this.f48018d.setAntiAlias(true);
    }

    public int getHeadHeight() {
        return this.f48016b;
    }

    public int getWaveHeight() {
        return this.f48015a;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        int i4;
        super.onDraw(canvas);
        int width = getWidth();
        this.f48017c.reset();
        this.f48017c.lineTo(0.0f, this.f48016b);
        Path path = this.f48017c;
        int i5 = this.f48019e;
        if (i5 < 0) {
            i5 = width / 2;
        }
        float f4 = width;
        path.quadTo(i5, this.f48015a + i4, f4, this.f48016b);
        this.f48017c.lineTo(f4, 0.0f);
        canvas.drawPath(this.f48017c, this.f48018d);
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i4), View.resolveSize(getSuggestedMinimumHeight(), i5));
    }

    public void setHeadHeight(int i4) {
        this.f48016b = i4;
    }

    public void setWaveColor(@ColorInt int i4) {
        this.f48018d.setColor(i4);
    }

    public void setWaveHeight(int i4) {
        this.f48015a = i4;
    }

    public void setWaveOffsetX(int i4) {
        this.f48019e = i4;
    }

    public WaveView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WaveView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.f48019e = -1;
        a();
    }
}
