package com.p521ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* renamed from: com.ss.android.downloadlib.guide.install.ClipImageView */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ClipImageView extends ImageView {

    /* renamed from: a */
    private Path f34438a;

    /* renamed from: bl */
    private RectF f34439bl;

    /* renamed from: n */
    private float[] f34440n;

    /* renamed from: ok */
    private boolean f34441ok;

    /* renamed from: s */
    private Paint f34442s;

    public ClipImageView(Context context) {
        super(context);
        this.f34441ok = true;
        m18842ok(context);
    }

    /* renamed from: ok */
    protected void m18842ok(Context context) {
        this.f34438a = new Path();
        this.f34439bl = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f34441ok) {
            this.f34438a.reset();
            this.f34439bl.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f34440n;
            if (fArr != null) {
                this.f34438a.addRoundRect(this.f34439bl, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f34438a);
            Paint paint = this.f34442s;
            if (paint != null) {
                canvas.drawPath(this.f34438a, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i) {
        Paint paint = new Paint(1);
        this.f34442s = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f34442s.setColor(i);
    }

    public void setClip(boolean z) {
        this.f34441ok = z;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f34440n = fArr;
    }

    public void setRoundRadius(int i) {
        if (i > 0) {
            float f = i;
            setRadius(new float[]{f, f, f, f, f, f, f, f});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f34441ok = true;
        m18842ok(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34441ok = true;
        m18842ok(context);
    }
}
