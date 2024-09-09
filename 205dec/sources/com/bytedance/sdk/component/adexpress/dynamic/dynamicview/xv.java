package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class xv extends Drawable {

    /* renamed from: c  reason: collision with root package name */
    private Paint f29223c;
    private RectF sr;

    /* renamed from: w  reason: collision with root package name */
    private int f29224w;
    private int xv;

    public xv(int i4, int i5) {
        this.xv = i4;
        this.f29224w = i5;
        Paint paint = new Paint();
        this.f29223c = paint;
        paint.setColor(0);
        this.f29223c.setAntiAlias(true);
        this.f29223c.setShadowLayer(i5, 0.0f, 0.0f, -16777216);
        this.f29223c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        RectF rectF = this.sr;
        int i4 = this.xv;
        canvas.drawRoundRect(rectF, i4, i4, this.f29223c);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f29223c.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setBounds(int i4, int i5, int i6, int i7) {
        super.setBounds(i4, i5, i6, i7);
        int i8 = this.f29224w;
        this.sr = new RectF(i4 + i8, i5 + i8, i6 - i8, i7 - i8);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f29223c.setColorFilter(colorFilter);
    }
}
