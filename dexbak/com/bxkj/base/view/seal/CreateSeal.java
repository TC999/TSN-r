package com.bxkj.base.view.seal;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Typeface;
import androidx.core.internal.view.SupportMenu;

/* renamed from: com.bxkj.base.view.seal.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class CreateSeal {

    /* renamed from: a */
    private int f15304a;

    /* renamed from: c */
    private String f15306c;

    /* renamed from: d */
    private Canvas f15307d;

    /* renamed from: f */
    private Bitmap f15309f;

    /* renamed from: g */
    private int f15310g;

    /* renamed from: h */
    private int f15311h;

    /* renamed from: b */
    float f15305b = 50.0f;

    /* renamed from: i */
    private int f15312i = Color.parseColor("#99FF0000");

    /* renamed from: e */
    private Paint f15308e = new Paint();

    public CreateSeal(int i, String str, Bitmap bitmap) {
        this.f15304a = 10;
        this.f15304a = i;
        this.f15306c = str;
        this.f15309f = bitmap;
        this.f15307d = new Canvas(bitmap);
    }

    /* renamed from: a */
    private void m43482a() {
        double d = this.f15311h / 2;
        Double.isNaN(d);
        float f = (float) (d * 1.1d);
        int i = this.f15310g;
        float f2 = i;
        float f3 = i - f;
        double d2 = i;
        double d3 = f;
        double radians = (float) Math.toRadians(72.0d);
        double sin = Math.sin(radians);
        Double.isNaN(d3);
        Double.isNaN(d2);
        float f4 = (float) (d2 - (sin * d3));
        double d4 = i;
        double cos = Math.cos(radians);
        Double.isNaN(d3);
        Double.isNaN(d4);
        double sin2 = Math.sin(radians);
        Double.isNaN(d3);
        Double.isNaN(d2);
        double cos2 = Math.cos(radians);
        Double.isNaN(d3);
        Double.isNaN(d4);
        float f5 = (float) (d4 - (cos2 * d3));
        double radians2 = (float) Math.toRadians(36.0d);
        double sin3 = Math.sin(radians2);
        Double.isNaN(d3);
        Double.isNaN(d2);
        double cos3 = Math.cos(radians2);
        Double.isNaN(d3);
        Double.isNaN(d4);
        double sin4 = Math.sin(radians2);
        Double.isNaN(d3);
        Double.isNaN(d2);
        double cos4 = Math.cos(radians2);
        Double.isNaN(d3);
        Double.isNaN(d4);
        Path path = new Path();
        path.moveTo(f2, f3);
        path.lineTo((float) (d2 + (sin4 * d3)), (float) (d4 + (d3 * cos4)));
        path.lineTo(f4, (float) (d4 - (cos * d3)));
        path.lineTo((float) ((sin2 * d3) + d2), f5);
        path.lineTo((float) (d2 - (sin3 * d3)), (float) (d4 + (cos3 * d3)));
        path.close();
        Paint paint = new Paint();
        paint.setColor(this.f15312i);
        this.f15307d.drawPath(path, paint);
    }

    /* renamed from: b */
    private void m43481b() {
        Paint paint = new Paint();
        paint.setColor(SupportMenu.CATEGORY_MASK);
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.setTextSize((this.f15311h / 5) + 5);
        paint.setTextAlign(Paint.Align.CENTER);
        int i = this.f15311h;
        RectF rectF = new RectF(0.0f, 0.0f, i * 2, i * 2);
        float length = (((this.f15305b * this.f15306c.length()) / 4.0f) + 90.0f) - (this.f15305b / 8.0f);
        for (int i2 = 0; i2 < this.f15306c.length(); i2++) {
            Path path = new Path();
            float f = this.f15305b;
            path.addArc(rectF, -(length - ((i2 * f) / 2.0f)), f);
            Canvas canvas = this.f15307d;
            String valueOf = String.valueOf(this.f15306c.charAt(i2));
            int i3 = this.f15311h;
            canvas.drawTextOnPath(valueOf, path, -(i3 / 3), i3 / 3, paint);
        }
    }

    /* renamed from: d */
    private void m43479d() {
        int width = this.f15307d.getWidth() / 2;
        this.f15310g = width;
        this.f15311h = width - (this.f15304a / 2);
        this.f15308e.setColor(this.f15312i);
        this.f15308e.setStyle(Paint.Style.STROKE);
        this.f15308e.setStrokeWidth(this.f15304a);
        this.f15308e.setAntiAlias(true);
        Canvas canvas = this.f15307d;
        int i = this.f15310g;
        canvas.drawCircle(i, i, this.f15311h, this.f15308e);
    }

    /* renamed from: f */
    private void m43477f() {
        m43479d();
        m43482a();
        m43481b();
    }

    /* renamed from: c */
    public Bitmap m43480c() {
        m43477f();
        return this.f15309f;
    }

    /* renamed from: e */
    public int m43478e() {
        return this.f15304a;
    }
}
