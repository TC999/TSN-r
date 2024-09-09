package com.ss.android.downloadlib.guide.install;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.ImageView;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class ClipImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Path f48823a;
    private RectF bl;

    /* renamed from: n  reason: collision with root package name */
    private float[] f48824n;
    private boolean ok;

    /* renamed from: s  reason: collision with root package name */
    private Paint f48825s;

    public ClipImageView(Context context) {
        super(context);
        this.ok = true;
        ok(context);
    }

    protected void ok(Context context) {
        this.f48823a = new Path();
        this.bl = new RectF();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.ok) {
            this.f48823a.reset();
            this.bl.set(0.0f, 0.0f, getWidth(), getHeight());
            float[] fArr = this.f48824n;
            if (fArr != null) {
                this.f48823a.addRoundRect(this.bl, fArr, Path.Direction.CW);
            }
            canvas.setDrawFilter(new PaintFlagsDrawFilter(0, 3));
            canvas.clipPath(this.f48823a);
            Paint paint = this.f48825s;
            if (paint != null) {
                canvas.drawPath(this.f48823a, paint);
            }
        }
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        Paint paint = new Paint(1);
        this.f48825s = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f48825s.setColor(i4);
    }

    public void setClip(boolean z3) {
        this.ok = z3;
    }

    public void setRadius(float[] fArr) {
        if (fArr == null || fArr.length != 8) {
            return;
        }
        this.f48824n = fArr;
    }

    public void setRoundRadius(int i4) {
        if (i4 > 0) {
            float f4 = i4;
            setRadius(new float[]{f4, f4, f4, f4, f4, f4, f4, f4});
        }
    }

    public ClipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.ok = true;
        ok(context);
    }

    public ClipImageView(Context context, AttributeSet attributeSet, int i4) {
        super(context, attributeSet, i4);
        this.ok = true;
        ok(context);
    }
}
