package com.bytedance.adsdk.lottie.c.w;

import android.graphics.Matrix;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.c.w.c;
import com.bytedance.adsdk.lottie.n;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f25487a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Matrix f25488b;

    /* renamed from: c  reason: collision with root package name */
    private final Matrix f25489c;

    /* renamed from: d  reason: collision with root package name */
    private final Matrix f25490d;

    /* renamed from: e  reason: collision with root package name */
    private final float[] f25491e;

    /* renamed from: f  reason: collision with root package name */
    private c<PointF, PointF> f25492f;

    /* renamed from: g  reason: collision with root package name */
    private c<?, PointF> f25493g;

    /* renamed from: h  reason: collision with root package name */
    private c<n.i, n.i> f25494h;

    /* renamed from: i  reason: collision with root package name */
    private c<Float, Float> f25495i;

    /* renamed from: j  reason: collision with root package name */
    private c<Integer, Integer> f25496j;

    /* renamed from: k  reason: collision with root package name */
    private l f25497k;

    /* renamed from: l  reason: collision with root package name */
    private l f25498l;

    /* renamed from: m  reason: collision with root package name */
    private c<?, Float> f25499m;

    /* renamed from: n  reason: collision with root package name */
    private c<?, Float> f25500n;

    public f(com.bytedance.adsdk.lottie.xv.c.a aVar) {
        this.f25492f = aVar.b() == null ? null : aVar.b().c();
        this.f25493g = aVar.j() == null ? null : aVar.j().c();
        this.f25494h = aVar.k() == null ? null : aVar.k().c();
        this.f25495i = aVar.h() == null ? null : aVar.h().c();
        l lVar = aVar.c() == null ? null : (l) aVar.c().c();
        this.f25497k = lVar;
        if (lVar != null) {
            this.f25488b = new Matrix();
            this.f25489c = new Matrix();
            this.f25490d = new Matrix();
            this.f25491e = new float[9];
        } else {
            this.f25488b = null;
            this.f25489c = null;
            this.f25490d = null;
            this.f25491e = null;
        }
        this.f25498l = aVar.e() == null ? null : (l) aVar.e().c();
        if (aVar.i() != null) {
            this.f25496j = aVar.i().c();
        }
        if (aVar.d() != null) {
            this.f25499m = aVar.d().c();
        } else {
            this.f25499m = null;
        }
        if (aVar.g() != null) {
            this.f25500n = aVar.g().c();
        } else {
            this.f25500n = null;
        }
    }

    private void f() {
        for (int i4 = 0; i4 < 9; i4++) {
            this.f25491e[i4] = 0.0f;
        }
    }

    public c<?, Integer> a() {
        return this.f25496j;
    }

    public void b(float f4) {
        c<Integer, Integer> cVar = this.f25496j;
        if (cVar != null) {
            cVar.e(f4);
        }
        c<?, Float> cVar2 = this.f25499m;
        if (cVar2 != null) {
            cVar2.e(f4);
        }
        c<?, Float> cVar3 = this.f25500n;
        if (cVar3 != null) {
            cVar3.e(f4);
        }
        c<PointF, PointF> cVar4 = this.f25492f;
        if (cVar4 != null) {
            cVar4.e(f4);
        }
        c<?, PointF> cVar5 = this.f25493g;
        if (cVar5 != null) {
            cVar5.e(f4);
        }
        c<n.i, n.i> cVar6 = this.f25494h;
        if (cVar6 != null) {
            cVar6.e(f4);
        }
        c<Float, Float> cVar7 = this.f25495i;
        if (cVar7 != null) {
            cVar7.e(f4);
        }
        l lVar = this.f25497k;
        if (lVar != null) {
            lVar.e(f4);
        }
        l lVar2 = this.f25498l;
        if (lVar2 != null) {
            lVar2.e(f4);
        }
    }

    public void c(c.b bVar) {
        c<Integer, Integer> cVar = this.f25496j;
        if (cVar != null) {
            cVar.f(bVar);
        }
        c<?, Float> cVar2 = this.f25499m;
        if (cVar2 != null) {
            cVar2.f(bVar);
        }
        c<?, Float> cVar3 = this.f25500n;
        if (cVar3 != null) {
            cVar3.f(bVar);
        }
        c<PointF, PointF> cVar4 = this.f25492f;
        if (cVar4 != null) {
            cVar4.f(bVar);
        }
        c<?, PointF> cVar5 = this.f25493g;
        if (cVar5 != null) {
            cVar5.f(bVar);
        }
        c<n.i, n.i> cVar6 = this.f25494h;
        if (cVar6 != null) {
            cVar6.f(bVar);
        }
        c<Float, Float> cVar7 = this.f25495i;
        if (cVar7 != null) {
            cVar7.f(bVar);
        }
        l lVar = this.f25497k;
        if (lVar != null) {
            lVar.f(bVar);
        }
        l lVar2 = this.f25498l;
        if (lVar2 != null) {
            lVar2.f(bVar);
        }
    }

    public void d(com.bytedance.adsdk.lottie.xv.xv.a aVar) {
        aVar.l(this.f25496j);
        aVar.l(this.f25499m);
        aVar.l(this.f25500n);
        aVar.l(this.f25492f);
        aVar.l(this.f25493g);
        aVar.l(this.f25494h);
        aVar.l(this.f25495i);
        aVar.l(this.f25497k);
        aVar.l(this.f25498l);
    }

    public Matrix e() {
        PointF j4;
        float i4;
        PointF j5;
        this.f25487a.reset();
        c<?, PointF> cVar = this.f25493g;
        if (cVar != null && (j5 = cVar.j()) != null) {
            float f4 = j5.x;
            if (f4 != 0.0f || j5.y != 0.0f) {
                this.f25487a.preTranslate(f4, j5.y);
            }
        }
        c<Float, Float> cVar2 = this.f25495i;
        if (cVar2 != null) {
            if (cVar2 instanceof h) {
                i4 = cVar2.j().floatValue();
            } else {
                i4 = ((l) cVar2).i();
            }
            if (i4 != 0.0f) {
                this.f25487a.preRotate(i4);
            }
        }
        l lVar = this.f25497k;
        if (lVar != null) {
            l lVar2 = this.f25498l;
            float cos = lVar2 == null ? 0.0f : (float) Math.cos(Math.toRadians((-lVar2.i()) + 90.0f));
            l lVar3 = this.f25498l;
            float sin = lVar3 == null ? 1.0f : (float) Math.sin(Math.toRadians((-lVar3.i()) + 90.0f));
            float tan = (float) Math.tan(Math.toRadians(lVar.i()));
            f();
            float[] fArr = this.f25491e;
            fArr[0] = cos;
            fArr[1] = sin;
            float f5 = -sin;
            fArr[3] = f5;
            fArr[4] = cos;
            fArr[8] = 1.0f;
            this.f25488b.setValues(fArr);
            f();
            float[] fArr2 = this.f25491e;
            fArr2[0] = 1.0f;
            fArr2[3] = tan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.f25489c.setValues(fArr2);
            f();
            float[] fArr3 = this.f25491e;
            fArr3[0] = cos;
            fArr3[1] = f5;
            fArr3[3] = sin;
            fArr3[4] = cos;
            fArr3[8] = 1.0f;
            this.f25490d.setValues(fArr3);
            this.f25489c.preConcat(this.f25488b);
            this.f25490d.preConcat(this.f25489c);
            this.f25487a.preConcat(this.f25490d);
        }
        c<n.i, n.i> cVar3 = this.f25494h;
        if (cVar3 != null) {
            n.i j6 = cVar3.j();
            if (j6.a() != 1.0f || j6.c() != 1.0f) {
                this.f25487a.preScale(j6.a(), j6.c());
            }
        }
        c<PointF, PointF> cVar4 = this.f25492f;
        if (cVar4 != null && (((j4 = cVar4.j()) != null && j4.x != 0.0f) || j4.y != 0.0f)) {
            this.f25487a.preTranslate(-j4.x, -j4.y);
        }
        return this.f25487a;
    }

    public Matrix g(float f4) {
        c<?, PointF> cVar = this.f25493g;
        PointF j4 = cVar == null ? null : cVar.j();
        c<n.i, n.i> cVar2 = this.f25494h;
        n.i j5 = cVar2 == null ? null : cVar2.j();
        this.f25487a.reset();
        if (j4 != null) {
            this.f25487a.preTranslate(j4.x * f4, j4.y * f4);
        }
        if (j5 != null) {
            double d4 = f4;
            this.f25487a.preScale((float) Math.pow(j5.a(), d4), (float) Math.pow(j5.c(), d4));
        }
        c<Float, Float> cVar3 = this.f25495i;
        if (cVar3 != null) {
            float floatValue = cVar3.j().floatValue();
            c<PointF, PointF> cVar4 = this.f25492f;
            PointF j6 = cVar4 != null ? cVar4.j() : null;
            this.f25487a.preRotate(floatValue * f4, j6 == null ? 0.0f : j6.x, j6 != null ? j6.y : 0.0f);
        }
        return this.f25487a;
    }

    public c<?, Float> h() {
        return this.f25499m;
    }

    public c<?, Float> i() {
        return this.f25500n;
    }
}
