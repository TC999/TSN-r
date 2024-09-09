package com.qq.e.comm.plugin.dl.p0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.view.View;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b extends View implements d {

    /* renamed from: w  reason: collision with root package name */
    private static final float f42505w = (float) Math.sin(Math.toRadians(55.0d));

    /* renamed from: x  reason: collision with root package name */
    private static final float f42506x = (float) Math.cos(Math.toRadians(55.0d));

    /* renamed from: c  reason: collision with root package name */
    private final float f42507c;

    /* renamed from: d  reason: collision with root package name */
    private final float f42508d;

    /* renamed from: e  reason: collision with root package name */
    private final float f42509e;

    /* renamed from: f  reason: collision with root package name */
    private final PorterDuffXfermode f42510f;

    /* renamed from: g  reason: collision with root package name */
    private final Paint f42511g;

    /* renamed from: h  reason: collision with root package name */
    private final RectF f42512h;

    /* renamed from: i  reason: collision with root package name */
    private final Path f42513i;

    /* renamed from: j  reason: collision with root package name */
    private final float f42514j;

    /* renamed from: k  reason: collision with root package name */
    private final float f42515k;

    /* renamed from: l  reason: collision with root package name */
    private final float f42516l;

    /* renamed from: m  reason: collision with root package name */
    private final float f42517m;

    /* renamed from: n  reason: collision with root package name */
    private final float f42518n;

    /* renamed from: o  reason: collision with root package name */
    private final float f42519o;

    /* renamed from: p  reason: collision with root package name */
    private final float f42520p;

    /* renamed from: q  reason: collision with root package name */
    private final float f42521q;

    /* renamed from: r  reason: collision with root package name */
    private final float f42522r;

    /* renamed from: s  reason: collision with root package name */
    private final float f42523s;

    /* renamed from: t  reason: collision with root package name */
    private float f42524t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f42525u;

    /* renamed from: v  reason: collision with root package name */
    private long f42526v;

    public b(Context context, int i4) {
        super(context);
        float f4 = i4 / 2.0f;
        this.f42507c = f4;
        this.f42508d = 0.75f * f4;
        this.f42509e = f4 * 0.06666667f;
        setLayerType(1, null);
        this.f42510f = new PorterDuffXfermode(PorterDuff.Mode.SRC);
        Paint paint = new Paint();
        this.f42511g = paint;
        paint.setAntiAlias(true);
        this.f42511g.setDither(true);
        float f5 = this.f42507c;
        float f6 = this.f42508d;
        float f7 = f5 - f6;
        float f8 = f5 + f6;
        this.f42512h = new RectF(f7, f7, f8, f8);
        this.f42513i = new Path();
        float f9 = this.f42509e;
        this.f42514j = 0.4f * f9;
        float f10 = this.f42507c;
        float f11 = this.f42508d;
        float f12 = f42505w;
        float f13 = f11 * f12;
        float f14 = f10 - f13;
        float f15 = f13 + f10;
        float f16 = f42506x;
        float f17 = f10 - (f11 * f16);
        float f18 = 2.0f * f9;
        float f19 = f18 * f16;
        this.f42515k = f14 - f19;
        this.f42516l = f19 + f15;
        this.f42517m = (f18 * f12) + f17;
        float f20 = f9 * 1.5f;
        float f21 = f12 * f20;
        this.f42518n = f14 - f21;
        this.f42519o = f15 + f21;
        float f22 = f20 * f16;
        this.f42520p = f17 - f22;
        this.f42521q = f14 + f21;
        this.f42522r = f15 - f21;
        this.f42523s = f17 + f22;
    }

    private void a(Canvas canvas) {
        if (this.f42525u) {
            this.f42511g.setColor(-1);
        } else {
            this.f42511g.setColor(1073741823);
        }
        this.f42511g.setStrokeWidth(1.0f);
        this.f42511g.setStyle(Paint.Style.FILL);
        this.f42511g.setPathEffect(new CornerPathEffect(this.f42514j));
        this.f42511g.setXfermode(this.f42510f);
        this.f42513i.moveTo(this.f42515k, this.f42517m);
        this.f42513i.lineTo(this.f42518n, this.f42520p);
        this.f42513i.lineTo(this.f42521q, this.f42523s);
        this.f42513i.close();
        canvas.drawPath(this.f42513i, this.f42511g);
        this.f42513i.moveTo(this.f42516l, this.f42517m);
        this.f42513i.lineTo(this.f42519o, this.f42520p);
        this.f42513i.lineTo(this.f42522r, this.f42523s);
        this.f42513i.close();
        canvas.drawPath(this.f42513i, this.f42511g);
        this.f42511g.setXfermode(null);
        this.f42511g.setPathEffect(null);
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void c() {
        this.f42525u = false;
        this.f42524t = 0.0f;
        this.f42526v = 0L;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f4 = this.f42507c * 2.0f;
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, f4, f4, null, 31);
        this.f42511g.setStrokeWidth(this.f42509e);
        this.f42511g.setColor(1073741823);
        this.f42511g.setStyle(Paint.Style.STROKE);
        this.f42511g.setStrokeCap(Paint.Cap.SQUARE);
        canvas.drawArc(this.f42512h, -145.0f, 110.0f, false, this.f42511g);
        this.f42511g.setStyle(Paint.Style.STROKE);
        this.f42511g.setStrokeCap(Paint.Cap.ROUND);
        this.f42511g.setColor(-1);
        this.f42511g.setStrokeWidth(this.f42509e);
        RectF rectF = this.f42512h;
        float f5 = this.f42524t;
        canvas.drawArc(rectF, (-90.0f) - f5, f5 * 2.0f, false, this.f42511g);
        a(canvas);
        canvas.restoreToCount(saveLayer);
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a(int i4, int i5, int i6, int i7, float f4) {
        if (this.f42525u) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f42526v < 40) {
            return;
        }
        this.f42526v = currentTimeMillis;
        float f5 = f4 * 55.0f;
        if (Math.abs(this.f42524t - f5) >= 1.0f) {
            this.f42524t = f5;
            invalidate();
        }
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a(int i4, int i5, int i6, int i7, long j4) {
        this.f42525u = true;
        this.f42524t = 55.0f;
        invalidate();
    }
}
