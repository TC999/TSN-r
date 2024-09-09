package com.scwang.smartrefresh.header.storehouse;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: StoreHouseBarItem.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class a extends Animation {

    /* renamed from: a  reason: collision with root package name */
    public PointF f47796a;

    /* renamed from: b  reason: collision with root package name */
    public float f47797b;

    /* renamed from: c  reason: collision with root package name */
    public int f47798c;

    /* renamed from: d  reason: collision with root package name */
    private final Paint f47799d;

    /* renamed from: e  reason: collision with root package name */
    private float f47800e;

    /* renamed from: f  reason: collision with root package name */
    private float f47801f;

    /* renamed from: g  reason: collision with root package name */
    private PointF f47802g;

    /* renamed from: h  reason: collision with root package name */
    private PointF f47803h;

    public a(int i4, PointF pointF, PointF pointF2, int i5, int i6) {
        Paint paint = new Paint();
        this.f47799d = paint;
        this.f47800e = 1.0f;
        this.f47801f = 0.4f;
        this.f47798c = i4;
        this.f47796a = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        float f4 = pointF.x;
        PointF pointF3 = this.f47796a;
        this.f47802g = new PointF(f4 - pointF3.x, pointF.y - pointF3.y);
        float f5 = pointF2.x;
        PointF pointF4 = this.f47796a;
        this.f47803h = new PointF(f5 - pointF4.x, pointF2.y - pointF4.y);
        d(i5);
        e(i6);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void a(Canvas canvas) {
        PointF pointF = this.f47802g;
        float f4 = pointF.x;
        float f5 = pointF.y;
        PointF pointF2 = this.f47803h;
        canvas.drawLine(f4, f5, pointF2.x, pointF2.y, this.f47799d);
    }

    @Override // android.view.animation.Animation
    protected void applyTransformation(float f4, Transformation transformation) {
        float f5 = this.f47800e;
        c(f5 + ((this.f47801f - f5) * f4));
    }

    public void b(int i4) {
        this.f47797b = (-new Random().nextInt(i4)) + i4;
    }

    public void c(float f4) {
        this.f47799d.setAlpha((int) (f4 * 255.0f));
    }

    public void d(int i4) {
        this.f47799d.setColor(i4);
    }

    public void e(int i4) {
        this.f47799d.setStrokeWidth(i4);
    }

    public void f(float f4, float f5) {
        this.f47800e = f4;
        this.f47801f = f5;
        super.start();
    }
}
