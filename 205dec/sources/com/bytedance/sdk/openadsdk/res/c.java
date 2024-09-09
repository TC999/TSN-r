package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c extends Drawable {

    /* renamed from: c  reason: collision with root package name */
    private Paint f36265c;

    /* renamed from: w  reason: collision with root package name */
    private int f36266w;
    private float xv;

    public c(int i4) {
        this.f36266w = i4;
        Paint paint = new Paint();
        this.f36265c = paint;
        paint.setAntiAlias(true);
        this.f36265c.setFilterBitmap(true);
    }

    public void c(int i4) {
        this.f36265c.setColor(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float centerX = getBounds().centerX();
        float centerY = getBounds().centerY();
        float f4 = this.f36266w / 2.0f;
        float f5 = centerX - ((3.0f * f4) / 4.0f);
        float f6 = centerX + (f4 / 4.0f);
        float f7 = f6 - f5;
        canvas.drawLine(f5, centerY + (this.xv / 4.0f), f6, centerY - f7, this.f36265c);
        canvas.drawLine(f5, centerY - (this.xv / 4.0f), f6, f7 + centerY, this.f36265c);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        double d4 = this.f36266w;
        Double.isNaN(d4);
        return (int) (d4 * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        double d4 = this.f36266w;
        Double.isNaN(d4);
        return (int) (d4 * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f36265c.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f36265c.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f36265c.setColorFilter(colorFilter);
    }

    public void c(float f4) {
        this.f36265c.setStrokeWidth(f4);
        this.xv = f4;
    }
}
