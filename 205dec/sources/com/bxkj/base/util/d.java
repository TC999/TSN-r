package com.bxkj.base.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import com.bxkj.base.BaseApp;
import java.util.Random;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: Code.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class d {

    /* renamed from: w  reason: collision with root package name */
    private static final char[] f18349w = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: x  reason: collision with root package name */
    private static d f18350x;

    /* renamed from: a  reason: collision with root package name */
    private final int f18351a = 4;

    /* renamed from: b  reason: collision with root package name */
    private final int f18352b;

    /* renamed from: c  reason: collision with root package name */
    private final int f18353c;

    /* renamed from: d  reason: collision with root package name */
    private final int f18354d;

    /* renamed from: e  reason: collision with root package name */
    private final int f18355e;

    /* renamed from: f  reason: collision with root package name */
    private final int f18356f;

    /* renamed from: g  reason: collision with root package name */
    private final int f18357g;

    /* renamed from: h  reason: collision with root package name */
    private final int f18358h;

    /* renamed from: i  reason: collision with root package name */
    private final int f18359i;

    /* renamed from: j  reason: collision with root package name */
    private int f18360j;

    /* renamed from: k  reason: collision with root package name */
    private int f18361k;

    /* renamed from: l  reason: collision with root package name */
    private int f18362l;

    /* renamed from: m  reason: collision with root package name */
    private int f18363m;

    /* renamed from: n  reason: collision with root package name */
    private int f18364n;

    /* renamed from: o  reason: collision with root package name */
    private int f18365o;

    /* renamed from: p  reason: collision with root package name */
    private int f18366p;

    /* renamed from: q  reason: collision with root package name */
    private int f18367q;

    /* renamed from: r  reason: collision with root package name */
    private int f18368r;

    /* renamed from: s  reason: collision with root package name */
    private String f18369s;

    /* renamed from: t  reason: collision with root package name */
    private int f18370t;

    /* renamed from: u  reason: collision with root package name */
    private int f18371u;

    /* renamed from: v  reason: collision with root package name */
    private Random f18372v;

    public d() {
        int j4 = j(BaseApp.b(), 25.0f);
        this.f18352b = j4;
        this.f18353c = 10;
        int a4 = cn.bluemobi.dylan.base.utils.u.a(10.0f, BaseApp.b());
        this.f18354d = a4;
        int a5 = cn.bluemobi.dylan.base.utils.u.a(15.0f, BaseApp.b());
        this.f18355e = a5;
        int a6 = cn.bluemobi.dylan.base.utils.u.a(15.0f, BaseApp.b());
        this.f18356f = a6;
        int a7 = cn.bluemobi.dylan.base.utils.u.a(20.0f, BaseApp.b());
        this.f18357g = a7;
        int a8 = cn.bluemobi.dylan.base.utils.u.a(100.0f, BaseApp.b());
        this.f18358h = a8;
        int a9 = cn.bluemobi.dylan.base.utils.u.a(40.0f, BaseApp.b());
        this.f18359i = a9;
        this.f18360j = a8;
        this.f18361k = a9;
        this.f18362l = a4;
        this.f18363m = a5;
        this.f18364n = a6;
        this.f18365o = a7;
        this.f18366p = 4;
        this.f18367q = 10;
        this.f18368r = j4;
        this.f18372v = new Random();
    }

    private String b() {
        StringBuilder sb = new StringBuilder();
        for (int i4 = 0; i4 < this.f18366p; i4++) {
            char[] cArr = f18349w;
            sb.append(cArr[this.f18372v.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    private void c(Canvas canvas, Paint paint) {
        int f4 = f();
        int nextInt = this.f18372v.nextInt(this.f18360j);
        int nextInt2 = this.f18372v.nextInt(this.f18361k);
        int nextInt3 = this.f18372v.nextInt(this.f18360j);
        int nextInt4 = this.f18372v.nextInt(this.f18361k);
        paint.setStrokeWidth(cn.bluemobi.dylan.base.utils.u.a(1.0f, BaseApp.b()));
        paint.setColor(f4);
        canvas.drawLine(nextInt, nextInt2, nextInt3, nextInt4, paint);
    }

    public static d e() {
        if (f18350x == null) {
            f18350x = new d();
        }
        return f18350x;
    }

    private int f() {
        return g(1);
    }

    private int g(int i4) {
        return Color.rgb(this.f18372v.nextInt(256) / i4, this.f18372v.nextInt(256) / i4, this.f18372v.nextInt(256) / i4);
    }

    private void h() {
        this.f18370t += this.f18362l + this.f18372v.nextInt(this.f18363m);
        this.f18371u = this.f18364n + this.f18372v.nextInt(this.f18365o);
    }

    private void i(Paint paint) {
        paint.setColor(f());
        paint.setFakeBoldText(this.f18372v.nextBoolean());
        float nextInt = this.f18372v.nextInt(11) / 10;
        if (!this.f18372v.nextBoolean()) {
            nextInt = -nextInt;
        }
        paint.setTextSkewX(nextInt);
    }

    public Bitmap a() {
        this.f18370t = 0;
        Bitmap createBitmap = Bitmap.createBitmap(this.f18360j, this.f18361k, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f18369s = b();
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setTextSize(this.f18368r);
        for (int i4 = 0; i4 < this.f18369s.length(); i4++) {
            i(paint);
            h();
            canvas.drawText(this.f18369s.charAt(i4) + "", this.f18370t, this.f18371u, paint);
        }
        for (int i5 = 0; i5 < this.f18367q; i5++) {
            c(canvas, paint);
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    public String d() {
        return this.f18369s;
    }

    public int j(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
