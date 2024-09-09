package com.mbridge.msdk.widget.custom.baseview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* compiled from: CircularProgressDrawable.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
final class b extends Drawable {

    /* renamed from: c  reason: collision with root package name */
    private int f41265c;

    /* renamed from: d  reason: collision with root package name */
    private int f41266d;

    /* renamed from: e  reason: collision with root package name */
    private int f41267e;

    /* renamed from: f  reason: collision with root package name */
    private RectF f41268f;

    /* renamed from: g  reason: collision with root package name */
    private Paint f41269g;

    /* renamed from: h  reason: collision with root package name */
    private Path f41270h;

    /* renamed from: b  reason: collision with root package name */
    private float f41264b = -90.0f;

    /* renamed from: a  reason: collision with root package name */
    private float f41263a = 0.0f;

    public b(int i4, int i5, int i6) {
        this.f41265c = i4;
        this.f41266d = i5;
        this.f41267e = i6;
    }

    public final void a(float f4) {
        this.f41263a = f4;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i4;
        Rect bounds = getBounds();
        if (this.f41270h == null) {
            this.f41270h = new Path();
        }
        this.f41270h.reset();
        Path path = this.f41270h;
        if (this.f41268f == null) {
            float f4 = this.f41266d / 2;
            int i5 = this.f41265c;
            this.f41268f = new RectF(f4, f4, i5 - i4, i5 - i4);
        }
        path.addArc(this.f41268f, this.f41264b, this.f41263a);
        this.f41270h.offset(bounds.left, bounds.top);
        Path path2 = this.f41270h;
        if (this.f41269g == null) {
            Paint paint = new Paint();
            this.f41269g = paint;
            paint.setAntiAlias(true);
            this.f41269g.setStyle(Paint.Style.STROKE);
            this.f41269g.setStrokeWidth(this.f41266d);
            this.f41269g.setColor(this.f41267e);
        }
        canvas.drawPath(path2, this.f41269g);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i4) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
