package com.qq.e.dl.l.m.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.graphics.NinePatch;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Build;
import android.os.SystemClock;
import android.util.Pair;
import android.view.View;
import android.widget.ImageView;
import com.qq.e.dl.l.e;
import com.qq.e.dl.l.h;
import com.qq.e.dl.l.i.d;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class c extends ImageView implements e {

    /* renamed from: c  reason: collision with root package name */
    private a f47245c;

    /* renamed from: d  reason: collision with root package name */
    protected Movie f47246d;

    /* renamed from: e  reason: collision with root package name */
    private long f47247e;

    /* renamed from: f  reason: collision with root package name */
    private float f47248f;

    /* renamed from: g  reason: collision with root package name */
    private float f47249g;

    /* renamed from: h  reason: collision with root package name */
    protected int f47250h;

    /* renamed from: i  reason: collision with root package name */
    protected int f47251i;

    public c(Context context) {
        super(context);
        this.f47248f = -1.0f;
        this.f47249g = 0.0f;
    }

    private void b(Canvas canvas) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f47247e == 0) {
            this.f47247e = uptimeMillis;
        }
        int duration = this.f47246d.duration();
        if (duration == 0) {
            duration = 1000;
        }
        int width = getWidth();
        int height = getHeight();
        this.f47246d.setTime((int) ((uptimeMillis - this.f47247e) % duration));
        if (this.f47248f < 0.0f) {
            float f4 = height;
            float f5 = width;
            float f6 = this.f47251i;
            float f7 = this.f47250h;
            if (f4 / f5 < f6 / f7) {
                this.f47248f = f5 / f7;
            } else {
                this.f47248f = f4 / f6;
                a aVar = this.f47245c;
                if (aVar != null && aVar.v() == 3) {
                    float f8 = this.f47248f;
                    this.f47249g = (-(((this.f47250h * f8) - f5) / 2.0f)) / f8;
                }
            }
        }
        float f9 = this.f47248f;
        canvas.scale(f9, f9);
        this.f47246d.draw(canvas, this.f47249g, 0.0f);
        invalidate();
    }

    @Override // com.qq.e.dl.l.e
    public void a(h hVar) {
        this.f47245c = (a) hVar;
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        int i4;
        a aVar = this.f47245c;
        d g4 = aVar == null ? null : aVar.g();
        int i5 = 0;
        if (g4 != null) {
            i5 = getWidth();
            i4 = getHeight();
            g4.a(canvas, i5, i4);
        } else {
            i4 = 0;
        }
        if (this.f47246d == null) {
            a(canvas);
            super.onDraw(canvas);
        } else {
            b(canvas);
        }
        if (g4 != null) {
            g4.b(canvas, i5, i4);
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        com.qq.e.dl.l.k.a i6 = this.f47245c.i();
        Pair<Integer, Integer> d4 = i6.d(i4, i5);
        super.onMeasure(((Integer) d4.first).intValue(), ((Integer) d4.second).intValue());
        Pair<Integer, Integer> c4 = i6.c(i4, i5);
        if (c4 != null) {
            super.setMeasuredDimension(View.MeasureSpec.getSize(((Integer) c4.first).intValue()), View.MeasureSpec.getSize(((Integer) c4.second).intValue()));
        }
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i4) {
        this.f47245c.a(view, i4);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i4) {
        this.f47245c.e(i4);
    }

    @Override // android.widget.ImageView
    public void setImageBitmap(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        byte[] ninePatchChunk = bitmap.getNinePatchChunk();
        if (ninePatchChunk != null && NinePatch.isNinePatchChunk(ninePatchChunk)) {
            super.setImageDrawable(new NinePatchDrawable(bitmap, ninePatchChunk, null, null));
        } else {
            super.setImageBitmap(bitmap);
        }
        this.f47250h = bitmap.getWidth();
        this.f47251i = bitmap.getHeight();
    }

    private void a(Canvas canvas) {
        if (this.f47250h <= 0 || this.f47251i <= 0 || this.f47245c == null) {
            return;
        }
        int height = getHeight();
        int width = getWidth();
        if (height <= 0 || width <= 0 || this.f47245c.v() != 3) {
            return;
        }
        double doubleValue = Double.valueOf(height).doubleValue();
        double d4 = width;
        Double.isNaN(d4);
        double d5 = doubleValue / d4;
        double doubleValue2 = Double.valueOf(this.f47251i).doubleValue();
        int i4 = this.f47250h;
        double d6 = i4;
        Double.isNaN(d6);
        if (d5 <= doubleValue2 / d6) {
            getDrawable().setBounds(0, 0, width, (this.f47251i * width) / i4);
            return;
        }
        int i5 = (((i4 * height) / this.f47251i) - width) / 2;
        getDrawable().setBounds(-i5, 0, width + i5, height);
    }

    public void a(Movie movie) {
        this.f47246d = movie;
        if (movie != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                setLayerType(1, null);
            }
            this.f47250h = this.f47246d.width();
            this.f47251i = this.f47246d.height();
            invalidate();
        }
    }
}
