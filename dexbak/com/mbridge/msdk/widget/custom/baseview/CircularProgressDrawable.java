package com.mbridge.msdk.widget.custom.baseview;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;

/* renamed from: com.mbridge.msdk.widget.custom.baseview.b */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
final class CircularProgressDrawable extends Drawable {

    /* renamed from: c */
    private int f32578c;

    /* renamed from: d */
    private int f32579d;

    /* renamed from: e */
    private int f32580e;

    /* renamed from: f */
    private RectF f32581f;

    /* renamed from: g */
    private Paint f32582g;

    /* renamed from: h */
    private Path f32583h;

    /* renamed from: b */
    private float f32577b = -90.0f;

    /* renamed from: a */
    private float f32576a = 0.0f;

    public CircularProgressDrawable(int i, int i2, int i3) {
        this.f32578c = i;
        this.f32579d = i2;
        this.f32580e = i3;
    }

    /* renamed from: a */
    public final void m20535a(float f) {
        this.f32576a = f;
    }

    @Override // android.graphics.drawable.Drawable
    public final void draw(Canvas canvas) {
        int i;
        Rect bounds = getBounds();
        if (this.f32583h == null) {
            this.f32583h = new Path();
        }
        this.f32583h.reset();
        Path path = this.f32583h;
        if (this.f32581f == null) {
            float f = this.f32579d / 2;
            int i2 = this.f32578c;
            this.f32581f = new RectF(f, f, i2 - i, i2 - i);
        }
        path.addArc(this.f32581f, this.f32577b, this.f32576a);
        this.f32583h.offset(bounds.left, bounds.top);
        Path path2 = this.f32583h;
        if (this.f32582g == null) {
            Paint paint = new Paint();
            this.f32582g = paint;
            paint.setAntiAlias(true);
            this.f32582g.setStyle(Paint.Style.STROKE);
            this.f32582g.setStrokeWidth(this.f32579d);
            this.f32582g.setColor(this.f32580e);
        }
        canvas.drawPath(path2, this.f32582g);
    }

    @Override // android.graphics.drawable.Drawable
    public final int getOpacity() {
        return 1;
    }

    @Override // android.graphics.drawable.Drawable
    public final void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public final void setColorFilter(ColorFilter colorFilter) {
    }
}
