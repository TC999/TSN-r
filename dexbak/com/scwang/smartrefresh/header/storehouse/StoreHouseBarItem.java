package com.scwang.smartrefresh.header.storehouse;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

/* renamed from: com.scwang.smartrefresh.header.storehouse.a */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class StoreHouseBarItem extends Animation {

    /* renamed from: a */
    public PointF f33411a;

    /* renamed from: b */
    public float f33412b;

    /* renamed from: c */
    public int f33413c;

    /* renamed from: d */
    private final Paint f33414d;

    /* renamed from: e */
    private float f33415e;

    /* renamed from: f */
    private float f33416f;

    /* renamed from: g */
    private PointF f33417g;

    /* renamed from: h */
    private PointF f33418h;

    public StoreHouseBarItem(int i, PointF pointF, PointF pointF2, int i2, int i3) {
        Paint paint = new Paint();
        this.f33414d = paint;
        this.f33415e = 1.0f;
        this.f33416f = 0.4f;
        this.f33413c = i;
        this.f33411a = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        float f = pointF.x;
        PointF pointF3 = this.f33411a;
        this.f33417g = new PointF(f - pointF3.x, pointF.y - pointF3.y);
        float f2 = pointF2.x;
        PointF pointF4 = this.f33411a;
        this.f33418h = new PointF(f2 - pointF4.x, pointF2.y - pointF4.y);
        m20030d(i2);
        m20029e(i3);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    /* renamed from: a */
    public void m20033a(Canvas canvas) {
        PointF pointF = this.f33417g;
        float f = pointF.x;
        float f2 = pointF.y;
        PointF pointF2 = this.f33418h;
        canvas.drawLine(f, f2, pointF2.x, pointF2.y, this.f33414d);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f, Transformation transformation) {
        float f2 = this.f33415e;
        m20031c(f2 + ((this.f33416f - f2) * f));
    }

    /* renamed from: b */
    public void m20032b(int i) {
        this.f33412b = (-new Random().nextInt(i)) + i;
    }

    /* renamed from: c */
    public void m20031c(float f) {
        this.f33414d.setAlpha((int) (f * 255.0f));
    }

    /* renamed from: d */
    public void m20030d(int i) {
        this.f33414d.setColor(i);
    }

    /* renamed from: e */
    public void m20029e(int i) {
        this.f33414d.setStrokeWidth(i);
    }

    /* renamed from: f */
    public void m20028f(float f, float f2) {
        this.f33415e = f;
        this.f33416f = f2;
        super.start();
    }
}
