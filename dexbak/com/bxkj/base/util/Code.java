package com.bxkj.base.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import cn.bluemobi.dylan.base.utils.Tools;
import com.bxkj.base.BaseApp;
import java.util.Random;

/* renamed from: com.bxkj.base.util.d */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class Code {

    /* renamed from: w */
    private static final char[] f14865w = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /* renamed from: x */
    private static Code f14866x;

    /* renamed from: a */
    private final int f14867a = 4;

    /* renamed from: b */
    private final int f14868b;

    /* renamed from: c */
    private final int f14869c;

    /* renamed from: d */
    private final int f14870d;

    /* renamed from: e */
    private final int f14871e;

    /* renamed from: f */
    private final int f14872f;

    /* renamed from: g */
    private final int f14873g;

    /* renamed from: h */
    private final int f14874h;

    /* renamed from: i */
    private final int f14875i;

    /* renamed from: j */
    private int f14876j;

    /* renamed from: k */
    private int f14877k;

    /* renamed from: l */
    private int f14878l;

    /* renamed from: m */
    private int f14879m;

    /* renamed from: n */
    private int f14880n;

    /* renamed from: o */
    private int f14881o;

    /* renamed from: p */
    private int f14882p;

    /* renamed from: q */
    private int f14883q;

    /* renamed from: r */
    private int f14884r;

    /* renamed from: s */
    private String f14885s;

    /* renamed from: t */
    private int f14886t;

    /* renamed from: u */
    private int f14887u;

    /* renamed from: v */
    private Random f14888v;

    public Code() {
        int m44123j = m44123j(BaseApp.m44341b(), 25.0f);
        this.f14868b = m44123j;
        this.f14869c = 10;
        int m57620a = Tools.m57620a(10.0f, BaseApp.m44341b());
        this.f14870d = m57620a;
        int m57620a2 = Tools.m57620a(15.0f, BaseApp.m44341b());
        this.f14871e = m57620a2;
        int m57620a3 = Tools.m57620a(15.0f, BaseApp.m44341b());
        this.f14872f = m57620a3;
        int m57620a4 = Tools.m57620a(20.0f, BaseApp.m44341b());
        this.f14873g = m57620a4;
        int m57620a5 = Tools.m57620a(100.0f, BaseApp.m44341b());
        this.f14874h = m57620a5;
        int m57620a6 = Tools.m57620a(40.0f, BaseApp.m44341b());
        this.f14875i = m57620a6;
        this.f14876j = m57620a5;
        this.f14877k = m57620a6;
        this.f14878l = m57620a;
        this.f14879m = m57620a2;
        this.f14880n = m57620a3;
        this.f14881o = m57620a4;
        this.f14882p = 4;
        this.f14883q = 10;
        this.f14884r = m44123j;
        this.f14888v = new Random();
    }

    /* renamed from: b */
    private String m44131b() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.f14882p; i++) {
            char[] cArr = f14865w;
            sb.append(cArr[this.f14888v.nextInt(cArr.length)]);
        }
        return sb.toString();
    }

    /* renamed from: c */
    private void m44130c(Canvas canvas, Paint paint) {
        int m44127f = m44127f();
        int nextInt = this.f14888v.nextInt(this.f14876j);
        int nextInt2 = this.f14888v.nextInt(this.f14877k);
        int nextInt3 = this.f14888v.nextInt(this.f14876j);
        int nextInt4 = this.f14888v.nextInt(this.f14877k);
        paint.setStrokeWidth(Tools.m57620a(1.0f, BaseApp.m44341b()));
        paint.setColor(m44127f);
        canvas.drawLine(nextInt, nextInt2, nextInt3, nextInt4, paint);
    }

    /* renamed from: e */
    public static Code m44128e() {
        if (f14866x == null) {
            f14866x = new Code();
        }
        return f14866x;
    }

    /* renamed from: f */
    private int m44127f() {
        return m44126g(1);
    }

    /* renamed from: g */
    private int m44126g(int i) {
        return Color.rgb(this.f14888v.nextInt(256) / i, this.f14888v.nextInt(256) / i, this.f14888v.nextInt(256) / i);
    }

    /* renamed from: h */
    private void m44125h() {
        this.f14886t += this.f14878l + this.f14888v.nextInt(this.f14879m);
        this.f14887u = this.f14880n + this.f14888v.nextInt(this.f14881o);
    }

    /* renamed from: i */
    private void m44124i(Paint paint) {
        paint.setColor(m44127f());
        paint.setFakeBoldText(this.f14888v.nextBoolean());
        float nextInt = this.f14888v.nextInt(11) / 10;
        if (!this.f14888v.nextBoolean()) {
            nextInt = -nextInt;
        }
        paint.setTextSkewX(nextInt);
    }

    /* renamed from: a */
    public Bitmap m44132a() {
        this.f14886t = 0;
        Bitmap createBitmap = Bitmap.createBitmap(this.f14876j, this.f14877k, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f14885s = m44131b();
        canvas.drawColor(-1);
        Paint paint = new Paint();
        paint.setTextSize(this.f14884r);
        for (int i = 0; i < this.f14885s.length(); i++) {
            m44124i(paint);
            m44125h();
            canvas.drawText(this.f14885s.charAt(i) + "", this.f14886t, this.f14887u, paint);
        }
        for (int i2 = 0; i2 < this.f14883q; i2++) {
            m44130c(canvas, paint);
        }
        canvas.save();
        canvas.restore();
        return createBitmap;
    }

    /* renamed from: d */
    public String m44129d() {
        return this.f14885s;
    }

    /* renamed from: j */
    public int m44123j(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
