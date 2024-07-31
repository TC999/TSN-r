package com.yalantis.ucrop.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* renamed from: com.yalantis.ucrop.util.d */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class FastBitmapDrawable extends Drawable {

    /* renamed from: b */
    private Bitmap f39877b;

    /* renamed from: d */
    private int f39879d;

    /* renamed from: e */
    private int f39880e;

    /* renamed from: a */
    private final Paint f39876a = new Paint(2);

    /* renamed from: c */
    private int f39878c = 255;

    public FastBitmapDrawable(Bitmap bitmap) {
        m13004b(bitmap);
    }

    /* renamed from: a */
    public Bitmap m13005a() {
        return this.f39877b;
    }

    /* renamed from: b */
    public void m13004b(Bitmap bitmap) {
        this.f39877b = bitmap;
        if (bitmap != null) {
            this.f39879d = bitmap.getWidth();
            this.f39880e = this.f39877b.getHeight();
            return;
        }
        this.f39880e = 0;
        this.f39879d = 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f39877b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f39877b, (Rect) null, getBounds(), this.f39876a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f39878c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f39880e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f39879d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f39880e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f39879d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f39878c = i;
        this.f39876a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f39876a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f39876a.setFilterBitmap(z);
    }
}
