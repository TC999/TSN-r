package com.qq.e.dl.l.j;

import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Region;
import android.view.MotionEvent;
import android.view.View;
import com.qq.e.dl.k.l;
import org.json.JSONObject;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class e implements g, com.qq.e.dl.l.i.d {

    /* renamed from: a  reason: collision with root package name */
    private final c f47143a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f47144b;

    /* renamed from: c  reason: collision with root package name */
    private final int f47145c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f47146d;

    /* renamed from: e  reason: collision with root package name */
    private final int f47147e;

    /* renamed from: f  reason: collision with root package name */
    private final int f47148f;

    /* renamed from: g  reason: collision with root package name */
    private final int f47149g;

    /* renamed from: h  reason: collision with root package name */
    private final int f47150h;

    /* renamed from: i  reason: collision with root package name */
    private final int f47151i;

    /* renamed from: j  reason: collision with root package name */
    private final Path f47152j = new Path();

    /* renamed from: k  reason: collision with root package name */
    private int f47153k;

    /* renamed from: l  reason: collision with root package name */
    private int f47154l;

    /* renamed from: m  reason: collision with root package name */
    private int f47155m;

    /* renamed from: n  reason: collision with root package name */
    private int f47156n;

    /* renamed from: o  reason: collision with root package name */
    private com.qq.e.lib.b.a f47157o;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(c cVar) {
        this.f47143a = cVar;
        JSONObject jSONObject = cVar.f47122c;
        if (jSONObject != null && jSONObject.length() > 0) {
            this.f47144b = jSONObject.optInt("dm") == 1;
            this.f47145c = jSONObject.optInt("imnd", 0);
            this.f47146d = true ^ d();
            this.f47147e = jSONObject.optInt("et");
            int a4 = l.c(jSONObject.opt("er")).a(new JSONObject[0]);
            this.f47148f = a4;
            this.f47149g = a4 * 2;
            this.f47150h = jSONObject.optInt("ers", 0);
            this.f47151i = jSONObject.optInt("erf", 0);
            return;
        }
        this.f47144b = false;
        this.f47147e = 0;
        this.f47148f = 0;
        this.f47149g = 0;
        this.f47150h = 0;
        this.f47151i = 0;
        this.f47145c = 0;
        this.f47146d = !d();
    }

    private boolean g() {
        return (this.f47157o.a() * 100) / this.f47157o.b() >= this.f47147e;
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF) {
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        if (this.f47153k <= 0) {
            this.f47155m = view.getWidth();
            this.f47156n = view.getHeight();
            double d4 = this.f47155m;
            Double.isNaN(d4);
            double d5 = this.f47149g;
            Double.isNaN(d5);
            this.f47153k = (int) Math.ceil((d4 * 1.0d) / d5);
            double d6 = this.f47156n;
            Double.isNaN(d6);
            double d7 = this.f47149g;
            Double.isNaN(d7);
            int ceil = (int) Math.ceil((d6 * 1.0d) / d7);
            this.f47154l = ceil;
            this.f47157o = new com.qq.e.lib.b.a(this.f47153k * ceil);
        }
        a(x3, y3);
        this.f47152j.addCircle(x3, y3, this.f47148f, Path.Direction.CW);
        view.invalidate();
        return null;
    }

    @Override // com.qq.e.dl.l.j.g
    public boolean a() {
        return true;
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean b(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        float x3 = motionEvent.getX();
        float y3 = motionEvent.getY();
        if (x3 < 0.0f || x3 > this.f47155m || y3 < 0.0f || y3 > this.f47156n) {
            return null;
        }
        a(x3, y3);
        boolean z3 = false;
        if (this.f47144b && this.f47146d && g()) {
            z3 = true;
        }
        if (!z3 || !a(true, view)) {
            this.f47152j.addCircle(x3, y3, this.f47148f, Path.Direction.CW);
            view.invalidate();
        }
        if (z3) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // com.qq.e.dl.l.i.d
    public void b(Canvas canvas, int i4, int i5) {
    }

    @Override // com.qq.e.dl.l.j.g
    public com.qq.e.dl.l.i.d c() {
        return this;
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean c(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        boolean z3 = false;
        if (!this.f47146d) {
            this.f47146d = true;
            if (this.f47144b && g()) {
                z3 = true;
            }
            a(z3, view);
        }
        if (z3) {
            return Boolean.TRUE;
        }
        return null;
    }

    @Override // com.qq.e.dl.l.j.g
    public boolean d() {
        return this.f47145c > 0;
    }

    @Override // com.qq.e.dl.l.j.g
    public c e() {
        return this.f47143a;
    }

    @Override // com.qq.e.dl.l.j.g
    public int f() {
        int i4 = this.f47145c;
        if (i4 > 0) {
            return i4;
        }
        return 0;
    }

    @Override // com.qq.e.dl.l.j.g
    public Boolean a(View view, MotionEvent motionEvent, PointF pointF, PointF pointF2) {
        boolean z3 = this.f47146d && g();
        a(z3, view);
        if (z3) {
            return Boolean.TRUE;
        }
        return null;
    }

    private boolean a(boolean z3, View view) {
        if ((z3 ? this.f47150h : this.f47151i) == 1) {
            this.f47152j.reset();
            view.invalidate();
            this.f47153k = 0;
            return true;
        }
        return false;
    }

    @Override // com.qq.e.dl.l.j.g
    public void b() {
        this.f47146d = !d();
    }

    private void a(float f4, float f5) {
        int i4;
        int i5 = 0;
        if (f4 <= 0.0f) {
            i4 = 0;
        } else if (f4 >= this.f47155m) {
            i4 = this.f47153k - 1;
        } else {
            i4 = ((int) f4) / this.f47149g;
        }
        if (f5 > 0.0f) {
            if (f5 >= this.f47156n) {
                i5 = this.f47154l - 1;
            } else {
                i5 = ((int) f5) / this.f47149g;
            }
        }
        this.f47157o.a((i4 * this.f47154l) + i5, true);
    }

    @Override // com.qq.e.dl.l.i.d
    public void a(Canvas canvas, int i4, int i5) {
        if (this.f47152j.isEmpty()) {
            return;
        }
        canvas.clipPath(this.f47152j, Region.Op.DIFFERENCE);
    }
}
