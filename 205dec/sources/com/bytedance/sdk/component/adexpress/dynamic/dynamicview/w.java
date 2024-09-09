package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.drawable.GradientDrawable;
import com.bytedance.component.sdk.annotation.ColorInt;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class w extends GradientDrawable {

    /* renamed from: c  reason: collision with root package name */
    protected Path f29221c;

    /* renamed from: w  reason: collision with root package name */
    private final Paint f29222w;

    public w() {
        this.f29221c = new Path();
        Paint paint = new Paint(1);
        this.f29222w = paint;
        paint.setColor(-1);
    }

    protected void c(Canvas canvas) {
        super.draw(canvas);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Path path = this.f29221c;
        if (path != null && !path.isEmpty()) {
            int saveLayer = canvas.saveLayer(0.0f, 0.0f, canvas.getWidth(), canvas.getHeight(), this.f29222w, 31);
            c(canvas);
            this.f29222w.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
            canvas.drawPath(this.f29221c, this.f29222w);
            this.f29222w.setXfermode(null);
            canvas.restoreToCount(saveLayer);
            return;
        }
        c(canvas);
    }

    public void update(int i4, int i5, int i6, int i7) {
        this.f29221c.addRect(i4, i5, i6, i7, Path.Direction.CW);
        invalidateSelf();
    }

    public w(GradientDrawable.Orientation orientation, @ColorInt int[] iArr) {
        super(orientation, iArr);
        this.f29221c = new Path();
        Paint paint = new Paint(1);
        this.f29222w = paint;
        paint.setColor(-1);
    }
}
