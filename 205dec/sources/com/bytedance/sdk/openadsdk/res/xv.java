package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class xv extends Drawable {

    /* renamed from: c  reason: collision with root package name */
    private Paint f36271c;

    /* renamed from: w  reason: collision with root package name */
    private int f36272w;

    public xv(int i4) {
        this.f36272w = i4;
        Paint paint = new Paint();
        this.f36271c = paint;
        paint.setAntiAlias(true);
        this.f36271c.setFilterBitmap(true);
    }

    public void c(int i4) {
        this.f36271c.setColor(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        float centerX = getBounds().centerX();
        float centerY = getBounds().centerY();
        float f4 = ((this.f36272w / 2.0f) * 3.0f) / 4.0f;
        float f5 = centerX - f4;
        float f6 = centerY - f4;
        float f7 = centerX + f4;
        float f8 = centerY + f4;
        canvas.drawLine(f5, f6, f7, f8, this.f36271c);
        canvas.drawLine(f7, f6, f5, f8, this.f36271c);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        double d4 = this.f36272w;
        Double.isNaN(d4);
        return (int) (d4 * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        double d4 = this.f36272w;
        Double.isNaN(d4);
        return (int) (d4 * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f36271c.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f36271c.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f36271c.setColorFilter(colorFilter);
    }

    public void c(float f4) {
        this.f36271c.setStrokeWidth(f4);
    }
}
