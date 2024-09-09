package com.bytedance.sdk.component.adexpress.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.bytedance.sdk.component.utils.i;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class WriggleGuideView extends View {

    /* renamed from: c  reason: collision with root package name */
    private int f29645c;
    private boolean ev;

    /* renamed from: f  reason: collision with root package name */
    private int f29646f;
    private c gd;

    /* renamed from: r  reason: collision with root package name */
    private boolean f29647r;
    private Bitmap sr;
    private Paint ux;

    /* renamed from: w  reason: collision with root package name */
    private int f29648w;
    private Bitmap xv;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c();
    }

    private Bitmap c(int i4, int i5) {
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), i.sr(getContext(), "tt_wriggle_union"));
        if (decodeResource != null) {
            canvas.drawBitmap(decodeResource, (Rect) null, new RectF(0.0f, 0.0f, i4, i5), this.ux);
        }
        return createBitmap;
    }

    private Bitmap w(int i4, int i5) {
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        Bitmap decodeResource = BitmapFactory.decodeResource(getContext().getResources(), i.sr(getContext(), "tt_wriggle_union_white"));
        if (decodeResource != null) {
            canvas.drawBitmap(decodeResource, (Rect) null, new RectF(0.0f, 0.0f, i4, i5), paint);
        }
        return createBitmap;
    }

    private Bitmap xv(int i4, int i5) {
        Bitmap createBitmap = Bitmap.createBitmap(i4, i5, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint(1);
        paint.setColor(-1);
        canvas.drawCircle(i4 / 2, 10.0f, this.f29646f, paint);
        return createBitmap;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.gd != null) {
            this.gd = null;
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f29647r) {
            this.f29645c = getWidth();
            int height = getHeight();
            this.f29648w = height;
            this.xv = c(this.f29645c, height);
            this.sr = w(this.f29645c, this.f29648w);
            this.f29647r = false;
        }
        Bitmap bitmap = this.xv;
        if (bitmap != null) {
            canvas.drawBitmap(bitmap, 0.0f, 0.0f, this.ux);
        }
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, getWidth(), getHeight(), null, 31);
        Bitmap bitmap2 = this.sr;
        if (bitmap2 != null) {
            canvas.drawBitmap(bitmap2, 0.0f, 0.0f, this.ux);
        }
        this.ux.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(xv(this.f29645c, this.f29648w), 0.0f, 0.0f, this.ux);
        this.ux.setXfermode(null);
        canvas.restoreToCount(saveLayer);
        if (this.ev) {
            this.f29646f += 5;
            invalidate();
            if (this.f29646f >= this.f29645c) {
                c cVar = this.gd;
                if (cVar != null) {
                    cVar.c();
                }
                this.ev = false;
            }
        }
    }
}
