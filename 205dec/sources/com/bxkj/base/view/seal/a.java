package com.bxkj.base.view.seal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: CreateSeal.java */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f18874a;

    /* renamed from: c  reason: collision with root package name */
    private String f18876c;

    /* renamed from: d  reason: collision with root package name */
    private Canvas f18877d;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f18879f;

    /* renamed from: g  reason: collision with root package name */
    private int f18880g;

    /* renamed from: h  reason: collision with root package name */
    private int f18881h;

    /* renamed from: b  reason: collision with root package name */
    float f18875b = 50.0f;

    /* renamed from: i  reason: collision with root package name */
    private int f18882i = Color.parseColor("#99FF0000");

    /* renamed from: e  reason: collision with root package name */
    private Paint f18878e = new Paint();

    public a(int i4, String str, Bitmap bitmap) {
        this.f18874a = 10;
        this.f18874a = i4;
        this.f18876c = str;
        this.f18879f = bitmap;
        this.f18877d = new Canvas(bitmap);
    }

    private void a() {
        double d4 = this.f18881h / 2;
        Double.isNaN(d4);
        float f4 = (float) (d4 * 1.1d);
        int i4 = this.f18880g;
        float f5 = i4;
        float f6 = i4 - f4;
        double d5 = i4;
        double d6 = f4;
        double radians = (float) Math.toRadians(72.0d);
        double sin = Math.sin(radians);
        Double.isNaN(d6);
        Double.isNaN(d5);
        float f7 = (float) (d5 - (sin * d6));
        double d7 = i4;
        double cos = Math.cos(radians);
        Double.isNaN(d6);
        Double.isNaN(d7);
        double sin2 = Math.sin(radians);
        Double.isNaN(d6);
        Double.isNaN(d5);
        double cos2 = Math.cos(radians);
        Double.isNaN(d6);
        Double.isNaN(d7);
        float f8 = (float) (d7 - (cos2 * d6));
        double radians2 = (float) Math.toRadians(36.0d);
        double sin3 = Math.sin(radians2);
        Double.isNaN(d6);
        Double.isNaN(d5);
        double cos3 = Math.cos(radians2);
        Double.isNaN(d6);
        Double.isNaN(d7);
        double sin4 = Math.sin(radians2);
        Double.isNaN(d6);
        Double.isNaN(d5);
        double cos4 = Math.cos(radians2);
        Double.isNaN(d6);
        Double.isNaN(d7);
        Path path = new Path();
        path.moveTo(f5, f6);
        path.lineTo((float) (d5 + (sin4 * d6)), (float) (d7 + (d6 * cos4)));
        path.lineTo(f7, (float) (d7 - (cos * d6)));
        path.lineTo((float) ((sin2 * d6) + d5), f8);
        path.lineTo((float) (d5 - (sin3 * d6)), (float) (d7 + (cos3 * d6)));
        path.close();
        Paint paint = new Paint();
        paint.setColor(this.f18882i);
        this.f18877d.drawPath(path, paint);
    }

    private void b() {
        Paint paint = new Paint();
        paint.setColor(-65536);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextSize((this.f18881h / 5) + 5);
        paint.setTextAlign(Paint.Align.CENTER);
        int i4 = this.f18881h;
        RectF rectF = new RectF(0.0f, 0.0f, i4 * 2, i4 * 2);
        float length = (((this.f18875b * this.f18876c.length()) / 4.0f) + 90.0f) - (this.f18875b / 8.0f);
        for (int i5 = 0; i5 < this.f18876c.length(); i5++) {
            Path path = new Path();
            float f4 = this.f18875b;
            path.addArc(rectF, -(length - ((i5 * f4) / 2.0f)), f4);
            Canvas canvas = this.f18877d;
            String valueOf = String.valueOf(this.f18876c.charAt(i5));
            int i6 = this.f18881h;
            canvas.drawTextOnPath(valueOf, path, -(i6 / 3), i6 / 3, paint);
        }
    }

    private void d() {
        int width = this.f18877d.getWidth() / 2;
        this.f18880g = width;
        this.f18881h = width - (this.f18874a / 2);
        this.f18878e.setColor(this.f18882i);
        this.f18878e.setStyle(Paint.Style.STROKE);
        this.f18878e.setStrokeWidth(this.f18874a);
        this.f18878e.setAntiAlias(true);
        Canvas canvas = this.f18877d;
        int i4 = this.f18880g;
        canvas.drawCircle(i4, i4, this.f18881h, this.f18878e);
    }

    private void f() {
        d();
        a();
        b();
    }

    public Bitmap c() {
        f();
        return this.f18879f;
    }

    public int e() {
        return this.f18874a;
    }
}
