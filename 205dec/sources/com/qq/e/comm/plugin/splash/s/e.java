package com.qq.e.comm.plugin.splash.s;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.ImageView;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.t;
import java.io.File;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class e extends ImageView implements com.qq.e.comm.plugin.r0.g {

    /* renamed from: c  reason: collision with root package name */
    private int f46201c;

    /* renamed from: d  reason: collision with root package name */
    private int f46202d;

    /* renamed from: e  reason: collision with root package name */
    private int f46203e;

    /* renamed from: f  reason: collision with root package name */
    private int f46204f;

    /* renamed from: g  reason: collision with root package name */
    private int f46205g;

    /* renamed from: h  reason: collision with root package name */
    private Movie f46206h;

    /* renamed from: i  reason: collision with root package name */
    private int f46207i;

    /* renamed from: j  reason: collision with root package name */
    private long f46208j;

    /* renamed from: k  reason: collision with root package name */
    private float f46209k;

    /* renamed from: l  reason: collision with root package name */
    private float f46210l;

    /* renamed from: m  reason: collision with root package name */
    private Bitmap f46211m;

    public e(Context context) {
        super(context);
        this.f46208j = -1L;
        this.f46209k = -1.0f;
        this.f46210l = 0.0f;
        setId(1);
    }

    public void a(File file) {
        Movie b4 = t.b(file);
        if (b4 != null) {
            a(b4);
        } else {
            setImageBitmap(t.b(file, this));
        }
        if (this.f46202d >= this.f46201c) {
            setScaleType(ImageView.ScaleType.FIT_CENTER);
        } else {
            setScaleType(ImageView.ScaleType.FIT_XY);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        Bitmap bitmap = this.f46211m;
        if (bitmap == null || !bitmap.isRecycled()) {
            this.f46204f = getHeight();
            int width = getWidth();
            this.f46205g = width;
            if (width != 0 && this.f46202d != 0) {
                if (this.f46206h != null) {
                    a(canvas);
                    super.onDraw(canvas);
                    return;
                }
                if (getScaleType() != ImageView.ScaleType.FIT_CENTER) {
                    double doubleValue = Double.valueOf(this.f46204f).doubleValue();
                    double d4 = this.f46205g;
                    Double.isNaN(d4);
                    double d5 = doubleValue / d4;
                    double doubleValue2 = Double.valueOf(this.f46201c).doubleValue();
                    int i4 = this.f46202d;
                    double d6 = i4;
                    Double.isNaN(d6);
                    if (d5 < doubleValue2 / d6) {
                        this.f46203e = (this.f46201c * this.f46205g) / i4;
                        getDrawable().setBounds(0, 0, this.f46205g, this.f46203e);
                    } else {
                        this.f46203e = (((i4 * this.f46204f) / this.f46201c) - this.f46205g) / 2;
                        Drawable drawable = getDrawable();
                        int i5 = this.f46203e;
                        drawable.setBounds(-i5, 0, this.f46205g + i5, this.f46204f);
                    }
                }
                super.onDraw(canvas);
                return;
            }
            super.onDraw(canvas);
        }
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            this.f46201c = bitmap.getHeight();
            this.f46202d = bitmap.getWidth();
            this.f46211m = bitmap;
            super.setImageBitmap(bitmap);
        }
    }

    @Override // com.qq.e.comm.plugin.r0.g
    public void a(Movie movie) {
        if (movie == null) {
            d1.a("movie is null");
            return;
        }
        if (Build.VERSION.SDK_INT >= 11) {
            setLayerType(1, null);
        }
        this.f46206h = movie;
        int duration = movie.duration();
        this.f46207i = duration;
        if (duration == 0) {
            this.f46207i = 2500;
            d1.a("gif duration = 0, reset to 2500");
        }
        this.f46202d = movie.width();
        this.f46201c = movie.height();
    }

    private void a(Canvas canvas) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f46208j < 0) {
            this.f46208j = currentTimeMillis;
        }
        this.f46206h.setTime(((int) (currentTimeMillis - this.f46208j)) % this.f46207i);
        if (this.f46209k < 0.0f) {
            double doubleValue = Double.valueOf(this.f46204f).doubleValue();
            double d4 = this.f46205g;
            Double.isNaN(d4);
            double d5 = doubleValue / d4;
            double doubleValue2 = Double.valueOf(this.f46201c).doubleValue();
            int i4 = this.f46202d;
            double d6 = i4;
            Double.isNaN(d6);
            if (d5 < doubleValue2 / d6) {
                this.f46209k = this.f46205g / i4;
            } else {
                float f4 = this.f46204f / this.f46201c;
                this.f46209k = f4;
                this.f46210l = (-(((i4 * f4) - this.f46205g) / 2.0f)) / f4;
            }
        }
        float f5 = this.f46209k;
        canvas.scale(f5, f5);
        this.f46206h.draw(canvas, this.f46210l, 0.0f);
        invalidate();
    }
}
