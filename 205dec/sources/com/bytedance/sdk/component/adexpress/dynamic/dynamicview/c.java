package com.bytedance.sdk.component.adexpress.dynamic.dynamicview;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class c extends w {
    private final Bitmap xv;

    /* renamed from: w  reason: collision with root package name */
    private final Rect f29220w = new Rect();
    private final Paint sr = new Paint(1);

    public c(Bitmap bitmap, w wVar) {
        this.xv = bitmap;
        if (wVar != null) {
            this.f29221c = wVar.f29221c;
        }
    }

    @Override // com.bytedance.sdk.component.adexpress.dynamic.dynamicview.w
    protected void c(Canvas canvas) {
        canvas.drawBitmap(this.xv, this.f29220w, getBounds(), this.sr);
    }

    @Override // android.graphics.drawable.GradientDrawable, android.graphics.drawable.Drawable
    protected void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        int height = rect.height();
        int width = rect.width();
        int width2 = this.xv.getWidth();
        int height2 = this.xv.getHeight();
        this.f29220w.set(0, 0, width2, height2);
        if (height2 >= height && width2 >= width) {
            if (width2 > width) {
                Rect rect2 = this.f29220w;
                int i4 = (width2 - width) / 2;
                rect2.left = i4;
                rect2.right = i4 + width;
            }
            if (height2 > height) {
                Rect rect3 = this.f29220w;
                int i5 = (height2 - height) / 2;
                rect3.top = i5;
                rect3.bottom = i5 + height;
                return;
            }
            return;
        }
        float f4 = height;
        float f5 = f4 * 1.0f;
        float f6 = height2;
        float f7 = f5 / f6;
        float f8 = width;
        float f9 = 1.0f * f8;
        float f10 = width2;
        if (Math.max(f7, f9 / f10) > f7) {
            int i6 = (int) ((f5 / f8) * f10);
            Rect rect4 = this.f29220w;
            int i7 = (height2 - i6) / 2;
            rect4.top = i7;
            rect4.bottom = i7 + i6;
            return;
        }
        int i8 = (int) ((f9 / f4) * f6);
        Rect rect5 = this.f29220w;
        int i9 = (width2 - i8) / 2;
        rect5.left = i9;
        rect5.right = i9 + i8;
    }
}
