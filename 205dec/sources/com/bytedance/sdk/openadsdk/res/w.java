package com.bytedance.sdk.openadsdk.res;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class w extends Drawable {

    /* renamed from: c  reason: collision with root package name */
    private Paint f36269c;

    /* renamed from: w  reason: collision with root package name */
    private int f36270w;

    public w(int i4) {
        this.f36270w = i4;
        Paint paint = new Paint();
        this.f36269c = paint;
        paint.setAntiAlias(true);
        this.f36269c.setFilterBitmap(true);
    }

    public void c(int i4) {
        this.f36269c.setColor(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        canvas.drawCircle(getBounds().centerX(), getBounds().centerY(), this.f36270w / 2.0f, this.f36269c);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        double d4 = this.f36270w;
        Double.isNaN(d4);
        return (int) (d4 * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        double d4 = this.f36270w;
        Double.isNaN(d4);
        return (int) (d4 * 1.3d);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f36269c.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f36269c.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f36269c.setColorFilter(colorFilter);
    }

    public void c(float f4) {
        this.f36269c.setStrokeWidth(f4);
    }
}
