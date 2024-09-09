package com.scwang.smartrefresh.layout.header.bezierradar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.annotation.ColorInt;
import com.scwang.smartrefresh.layout.util.c;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class RoundDotView extends View {

    /* renamed from: a  reason: collision with root package name */
    private int f48002a;

    /* renamed from: b  reason: collision with root package name */
    private Paint f48003b;

    /* renamed from: c  reason: collision with root package name */
    private float f48004c;

    /* renamed from: d  reason: collision with root package name */
    private float f48005d;

    public RoundDotView(Context context) {
        super(context);
        this.f48002a = 7;
        Paint paint = new Paint();
        this.f48003b = paint;
        paint.setAntiAlias(true);
        this.f48003b.setColor(-1);
        this.f48004c = c.b(7.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i4 = this.f48002a;
        float f4 = this.f48005d;
        float f5 = ((width / i4) * f4) - (f4 > 1.0f ? ((f4 - 1.0f) * (width / i4)) / f4 : 0.0f);
        float f6 = height;
        float f7 = 2.0f;
        float f8 = f6 - (f4 > 1.0f ? (((f4 - 1.0f) * f6) / 2.0f) / f4 : 0.0f);
        int i5 = 0;
        while (true) {
            int i6 = this.f48002a;
            if (i5 >= i6) {
                return;
            }
            float f9 = (i5 + 1.0f) - ((i6 + 1.0f) / f7);
            float d4 = c.d(f6);
            Paint paint = this.f48003b;
            double abs = (1.0f - ((Math.abs(f9) / this.f48002a) * f7)) * 255.0f;
            double d5 = d4;
            Double.isNaN(d5);
            float f10 = f5;
            Double.isNaN(abs);
            paint.setAlpha((int) (abs * (1.0d - (1.0d / Math.pow((d5 / 800.0d) + 1.0d, 15.0d)))));
            float f11 = this.f48004c * (1.0f - (1.0f / ((d4 / 10.0f) + 1.0f)));
            canvas.drawCircle(((width / 2) - (f11 / 2.0f)) + (f9 * f10), f8 / 2.0f, f11, this.f48003b);
            i5++;
            f5 = f10;
            f7 = 2.0f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i4, int i5) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i4), View.resolveSize(getSuggestedMinimumHeight(), i5));
    }

    public void setDotColor(@ColorInt int i4) {
        this.f48003b.setColor(i4);
    }

    public void setFraction(float f4) {
        this.f48005d = f4;
    }
}
