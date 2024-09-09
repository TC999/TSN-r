package com.qq.e.comm.plugin.dl.p0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class c extends View implements d {

    /* renamed from: c  reason: collision with root package name */
    private final float f42527c;

    /* renamed from: d  reason: collision with root package name */
    private final float f42528d;

    /* renamed from: e  reason: collision with root package name */
    private final float f42529e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f42530f;

    /* renamed from: g  reason: collision with root package name */
    private final RectF f42531g;

    /* renamed from: h  reason: collision with root package name */
    private float f42532h;

    /* renamed from: i  reason: collision with root package name */
    private boolean f42533i;

    /* renamed from: j  reason: collision with root package name */
    private long f42534j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f42535k;

    public c(Context context, int i4) {
        super(context);
        this.f42535k = false;
        float f4 = i4 / 2.0f;
        this.f42527c = f4;
        this.f42528d = 0.75f * f4;
        this.f42529e = f4 * 0.06666667f;
        setLayerType(1, null);
        Paint paint = new Paint();
        this.f42530f = paint;
        paint.setAntiAlias(true);
        this.f42530f.setDither(true);
        float f5 = this.f42527c;
        float f6 = this.f42528d;
        float f7 = f5 - f6;
        float f8 = f5 + f6;
        this.f42531g = new RectF(f7, f7, f8, f8);
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a() {
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a(int i4, int i5, int i6, int i7, float f4) {
        if (this.f42533i) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f42534j < 40) {
            return;
        }
        boolean z3 = f4 >= 0.5f;
        this.f42535k = z3;
        this.f42534j = currentTimeMillis;
        if (z3) {
            f4 -= 0.5f;
        }
        float f5 = f4 * 60.0f * 2.0f;
        if (Math.abs(this.f42532h - f5) >= 1.0f || this.f42535k) {
            this.f42532h = f5;
            invalidate();
        }
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void c() {
        this.f42533i = false;
        this.f42535k = false;
        this.f42532h = 0.0f;
        this.f42534j = 0L;
        invalidate();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float f4 = this.f42527c * 2.0f;
        int saveLayer = canvas.saveLayer(0.0f, 0.0f, f4, f4, null, 31);
        this.f42530f.setStrokeWidth(this.f42529e);
        this.f42530f.setColor(1073741823);
        this.f42530f.setStyle(Paint.Style.STROKE);
        this.f42530f.setStrokeCap(Paint.Cap.ROUND);
        canvas.drawArc(this.f42531g, -150.0f, 120.0f, false, this.f42530f);
        this.f42530f.setStyle(Paint.Style.STROKE);
        this.f42530f.setStrokeCap(Paint.Cap.ROUND);
        this.f42530f.setColor(-1);
        this.f42530f.setStrokeWidth(this.f42529e);
        if (!this.f42535k) {
            RectF rectF = this.f42531g;
            float f5 = this.f42532h;
            canvas.drawArc(rectF, (-90.0f) - f5, f5, false, this.f42530f);
        } else {
            canvas.drawArc(this.f42531g, -150.0f, this.f42532h + 60.0f, false, this.f42530f);
        }
        canvas.restoreToCount(saveLayer);
    }

    @Override // com.qq.e.comm.plugin.k0.f.d
    public void a(int i4, int i5, int i6, int i7, long j4) {
        this.f42533i = true;
        this.f42532h = 60.0f;
        invalidate();
    }
}
