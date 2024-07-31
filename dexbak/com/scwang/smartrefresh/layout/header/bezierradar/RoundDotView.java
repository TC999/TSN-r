package com.scwang.smartrefresh.layout.header.bezierradar;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import androidx.annotation.ColorInt;
import com.scwang.smartrefresh.layout.util.C11925c;

/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RoundDotView extends View {

    /* renamed from: a */
    private int f33668a;

    /* renamed from: b */
    private Paint f33669b;

    /* renamed from: c */
    private float f33670c;

    /* renamed from: d */
    private float f33671d;

    public RoundDotView(Context context) {
        super(context);
        this.f33668a = 7;
        Paint paint = new Paint();
        this.f33669b = paint;
        paint.setAntiAlias(true);
        this.f33669b.setColor(-1);
        this.f33670c = C11925c.m19766b(7.0f);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth();
        int height = getHeight();
        int i = this.f33668a;
        float f = this.f33671d;
        float f2 = ((width / i) * f) - (f > 1.0f ? ((f - 1.0f) * (width / i)) / f : 0.0f);
        float f3 = height;
        float f4 = 2.0f;
        float f5 = f3 - (f > 1.0f ? (((f - 1.0f) * f3) / 2.0f) / f : 0.0f);
        int i2 = 0;
        while (true) {
            int i3 = this.f33668a;
            if (i2 >= i3) {
                return;
            }
            float f6 = (i2 + 1.0f) - ((i3 + 1.0f) / f4);
            float m19764d = C11925c.m19764d(f3);
            Paint paint = this.f33669b;
            double abs = (1.0f - ((Math.abs(f6) / this.f33668a) * f4)) * 255.0f;
            double d = m19764d;
            Double.isNaN(d);
            float f7 = f2;
            Double.isNaN(abs);
            paint.setAlpha((int) (abs * (1.0d - (1.0d / Math.pow((d / 800.0d) + 1.0d, 15.0d)))));
            float f8 = this.f33670c * (1.0f - (1.0f / ((m19764d / 10.0f) + 1.0f)));
            canvas.drawCircle(((width / 2) - (f8 / 2.0f)) + (f6 * f7), f5 / 2.0f, f8, this.f33669b);
            i2++;
            f2 = f7;
            f4 = 2.0f;
        }
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(View.resolveSize(getSuggestedMinimumWidth(), i), View.resolveSize(getSuggestedMinimumHeight(), i2));
    }

    public void setDotColor(@ColorInt int i) {
        this.f33669b.setColor(i);
    }

    public void setFraction(float f) {
        this.f33671d = f;
    }
}
