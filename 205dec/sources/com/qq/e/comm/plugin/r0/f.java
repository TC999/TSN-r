package com.qq.e.comm.plugin.r0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Movie;
import android.os.SystemClock;
import android.widget.ImageView;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f extends ImageView implements g {

    /* renamed from: c  reason: collision with root package name */
    protected Movie f45714c;

    /* renamed from: d  reason: collision with root package name */
    protected int f45715d;

    /* renamed from: e  reason: collision with root package name */
    protected int f45716e;

    /* renamed from: f  reason: collision with root package name */
    private long f45717f;

    /* renamed from: g  reason: collision with root package name */
    private float f45718g;

    /* renamed from: h  reason: collision with root package name */
    protected int f45719h;

    /* renamed from: i  reason: collision with root package name */
    protected int f45720i;

    public f(Context context) {
        super(context);
        this.f45718g = -1.0f;
        setLayerType(1, null);
    }

    @Override // com.qq.e.comm.plugin.r0.g
    public void a(Movie movie) {
        this.f45714c = movie;
        if (movie != null) {
            this.f45719h = movie.width();
            int height = this.f45714c.height();
            this.f45720i = height;
            this.f45716e = this.f45719h;
            this.f45715d = height;
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDraw(Canvas canvas) {
        if (this.f45714c == null) {
            super.onDraw(canvas);
        } else if (a(canvas)) {
        } else {
            invalidate();
        }
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onMeasure(int i4, int i5) {
        super.onMeasure(i4, i5);
        if (this.f45714c != null) {
            setMeasuredDimension(this.f45716e, this.f45715d);
        }
    }

    private boolean a(Canvas canvas) {
        long uptimeMillis = SystemClock.uptimeMillis();
        if (this.f45717f == 0) {
            this.f45717f = uptimeMillis;
        }
        int duration = this.f45714c.duration();
        if (duration == 0) {
            duration = 1000;
        }
        this.f45714c.setTime((int) ((uptimeMillis - this.f45717f) % duration));
        if (this.f45718g < 0.0f) {
            float f4 = this.f45715d;
            float f5 = this.f45716e;
            float f6 = this.f45720i;
            float f7 = this.f45719h;
            if (f4 / f5 < f6 / f7) {
                this.f45718g = f5 / f7;
            } else {
                this.f45718g = f4 / f6;
            }
        }
        float f8 = this.f45718g;
        canvas.scale(f8, f8);
        this.f45714c.draw(canvas, 0.0f, 0.0f);
        invalidate();
        return false;
    }
}
