package com.yalantis.ucrop.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: FastBitmapDrawable.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d extends Drawable {

    /* renamed from: b  reason: collision with root package name */
    private Bitmap f54413b;

    /* renamed from: d  reason: collision with root package name */
    private int f54415d;

    /* renamed from: e  reason: collision with root package name */
    private int f54416e;

    /* renamed from: a  reason: collision with root package name */
    private final Paint f54412a = new Paint(2);

    /* renamed from: c  reason: collision with root package name */
    private int f54414c = 255;

    public d(Bitmap bitmap) {
        b(bitmap);
    }

    public Bitmap a() {
        return this.f54413b;
    }

    public void b(Bitmap bitmap) {
        this.f54413b = bitmap;
        if (bitmap != null) {
            this.f54415d = bitmap.getWidth();
            this.f54416e = this.f54413b.getHeight();
            return;
        }
        this.f54416e = 0;
        this.f54415d = 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f54413b;
        if (bitmap == null || bitmap.isRecycled()) {
            return;
        }
        canvas.drawBitmap(this.f54413b, (Rect) null, getBounds(), this.f54412a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f54414c;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f54416e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f54415d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumHeight() {
        return this.f54416e;
    }

    @Override // android.graphics.drawable.Drawable
    public int getMinimumWidth() {
        return this.f54415d;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i4) {
        this.f54414c = i4;
        this.f54412a.setAlpha(i4);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f54412a.setColorFilter(colorFilter);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z3) {
        this.f54412a.setFilterBitmap(z3);
    }
}
