package com.bytedance.adsdk.lottie.c.c;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.c.w.c;
import com.bytedance.adsdk.lottie.xv.w.fz;
import com.bytedance.adsdk.lottie.xv.w.p;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p implements b, k, c.b {

    /* renamed from: b  reason: collision with root package name */
    private final String f25434b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.d f25435c;

    /* renamed from: d  reason: collision with root package name */
    private final p.c f25436d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25437e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f25438f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25439g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, PointF> f25440h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25441i;

    /* renamed from: j  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25442j;

    /* renamed from: k  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25443k;

    /* renamed from: l  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25444l;

    /* renamed from: m  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25445m;

    /* renamed from: o  reason: collision with root package name */
    private boolean f25447o;

    /* renamed from: a  reason: collision with root package name */
    private final Path f25433a = new Path();

    /* renamed from: n  reason: collision with root package name */
    private final s f25446n = new s();

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25448a;

        static {
            int[] iArr = new int[p.c.values().length];
            f25448a = iArr;
            try {
                iArr[p.c.STAR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25448a[p.c.POLYGON.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public p(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, com.bytedance.adsdk.lottie.xv.w.p pVar) {
        this.f25435c = dVar;
        this.f25434b = pVar.b();
        p.c type = pVar.getType();
        this.f25436d = type;
        this.f25437e = pVar.e();
        this.f25438f = pVar.f();
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c4 = pVar.j().c();
        this.f25439g = c4;
        com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> c5 = pVar.k().c();
        this.f25440h = c5;
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c6 = pVar.h().c();
        this.f25441i = c6;
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c7 = pVar.d().c();
        this.f25443k = c7;
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c8 = pVar.c().c();
        this.f25445m = c8;
        p.c cVar = p.c.STAR;
        if (type == cVar) {
            this.f25442j = pVar.i().c();
            this.f25444l = pVar.g().c();
        } else {
            this.f25442j = null;
            this.f25444l = null;
        }
        aVar.l(c4);
        aVar.l(c5);
        aVar.l(c6);
        aVar.l(c7);
        aVar.l(c8);
        if (type == cVar) {
            aVar.l(this.f25442j);
            aVar.l(this.f25444l);
        }
        c4.f(this);
        c5.f(this);
        c6.f(this);
        c7.f(this);
        c8.f(this);
        if (type == cVar) {
            this.f25442j.f(this);
            this.f25444l.f(this);
        }
    }

    private void d() {
        com.bytedance.adsdk.lottie.c.w.c<?, Float> cVar;
        double d4;
        double d5;
        double d6;
        int i4;
        int floor = (int) Math.floor(this.f25439g.j().floatValue());
        double radians = Math.toRadians((this.f25441i == null ? 0.0d : cVar.j().floatValue()) - 90.0d);
        double d7 = floor;
        Double.isNaN(d7);
        float floatValue = this.f25445m.j().floatValue() / 100.0f;
        float floatValue2 = this.f25443k.j().floatValue();
        double d8 = floatValue2;
        double cos = Math.cos(radians);
        Double.isNaN(d8);
        float f4 = (float) (cos * d8);
        double sin = Math.sin(radians);
        Double.isNaN(d8);
        float f5 = (float) (sin * d8);
        this.f25433a.moveTo(f4, f5);
        double d9 = (float) (6.283185307179586d / d7);
        Double.isNaN(d9);
        double d10 = radians + d9;
        double ceil = Math.ceil(d7);
        int i5 = 0;
        while (i5 < ceil) {
            double cos2 = Math.cos(d10);
            Double.isNaN(d8);
            float f6 = (float) (cos2 * d8);
            double sin2 = Math.sin(d10);
            Double.isNaN(d8);
            double d11 = ceil;
            float f7 = (float) (d8 * sin2);
            if (floatValue != 0.0f) {
                d5 = d8;
                i4 = i5;
                d4 = d10;
                double atan2 = (float) (Math.atan2(f5, f4) - 1.5707963267948966d);
                float cos3 = (float) Math.cos(atan2);
                d6 = d9;
                double atan22 = (float) (Math.atan2(f7, f6) - 1.5707963267948966d);
                float f8 = floatValue2 * floatValue * 0.25f;
                this.f25433a.cubicTo(f4 - (cos3 * f8), f5 - (((float) Math.sin(atan2)) * f8), f6 + (((float) Math.cos(atan22)) * f8), f7 + (f8 * ((float) Math.sin(atan22))), f6, f7);
            } else {
                d4 = d10;
                d5 = d8;
                d6 = d9;
                i4 = i5;
                this.f25433a.lineTo(f6, f7);
            }
            Double.isNaN(d6);
            d10 = d4 + d6;
            i5 = i4 + 1;
            f5 = f7;
            f4 = f6;
            ceil = d11;
            d8 = d5;
            d9 = d6;
        }
        PointF j4 = this.f25440h.j();
        this.f25433a.offset(j4.x, j4.y);
        this.f25433a.close();
    }

    private void f() {
        this.f25447o = false;
        this.f25435c.invalidateSelf();
    }

    private void g() {
        com.bytedance.adsdk.lottie.c.w.c<?, Float> cVar;
        double d4;
        float f4;
        float f5;
        float f6;
        float f7;
        double d5;
        float f8;
        float f9;
        float f10;
        float f11;
        float f12;
        float f13;
        double d6;
        float f14;
        float f15;
        float floatValue = this.f25439g.j().floatValue();
        double radians = Math.toRadians((this.f25441i == null ? 0.0d : cVar.j().floatValue()) - 90.0d);
        double d7 = floatValue;
        Double.isNaN(d7);
        float f16 = (float) (6.283185307179586d / d7);
        if (this.f25438f) {
            f16 *= -1.0f;
        }
        float f17 = f16 / 2.0f;
        float f18 = floatValue - ((int) floatValue);
        if (f18 != 0.0f) {
            double d8 = (1.0f - f18) * f17;
            Double.isNaN(d8);
            radians += d8;
        }
        float floatValue2 = this.f25443k.j().floatValue();
        float floatValue3 = this.f25442j.j().floatValue();
        com.bytedance.adsdk.lottie.c.w.c<?, Float> cVar2 = this.f25444l;
        float floatValue4 = cVar2 != null ? cVar2.j().floatValue() / 100.0f : 0.0f;
        com.bytedance.adsdk.lottie.c.w.c<?, Float> cVar3 = this.f25445m;
        float floatValue5 = cVar3 != null ? cVar3.j().floatValue() / 100.0f : 0.0f;
        if (f18 != 0.0f) {
            float f19 = ((floatValue2 - floatValue3) * f18) + floatValue3;
            double d9 = f19;
            double cos = Math.cos(radians);
            Double.isNaN(d9);
            d4 = d7;
            float f20 = (float) (d9 * cos);
            double sin = Math.sin(radians);
            Double.isNaN(d9);
            float f21 = (float) (d9 * sin);
            this.f25433a.moveTo(f20, f21);
            double d10 = (f16 * f18) / 2.0f;
            Double.isNaN(d10);
            d5 = radians + d10;
            f6 = f20;
            f8 = f19;
            f4 = floatValue2;
            f7 = f21;
            f5 = f17;
        } else {
            d4 = d7;
            f4 = floatValue2;
            double d11 = f4;
            double cos2 = Math.cos(radians);
            Double.isNaN(d11);
            f5 = f17;
            f6 = (float) (d11 * cos2);
            double sin2 = Math.sin(radians);
            Double.isNaN(d11);
            f7 = (float) (d11 * sin2);
            this.f25433a.moveTo(f6, f7);
            double d12 = f5;
            Double.isNaN(d12);
            d5 = radians + d12;
            f8 = 0.0f;
        }
        double ceil = Math.ceil(d4) * 2.0d;
        int i4 = 0;
        float f22 = floatValue5;
        boolean z3 = false;
        while (true) {
            double d13 = i4;
            if (d13 < ceil) {
                float f23 = z3 ? f4 : floatValue3;
                float f24 = (f8 == 0.0f || d13 != ceil - 2.0d) ? f5 : (f16 * f18) / 2.0f;
                if (f8 == 0.0f || d13 != ceil - 1.0d) {
                    f9 = f16;
                    f10 = f23;
                    f11 = f4;
                } else {
                    f9 = f16;
                    f11 = f4;
                    f10 = f8;
                }
                double d14 = f10;
                double cos3 = Math.cos(d5);
                Double.isNaN(d14);
                float f25 = (float) (d14 * cos3);
                double sin3 = Math.sin(d5);
                Double.isNaN(d14);
                float f26 = (float) (d14 * sin3);
                if (floatValue4 == 0.0f && f22 == 0.0f) {
                    this.f25433a.lineTo(f25, f26);
                    d6 = d5;
                    f12 = floatValue3;
                    f13 = floatValue4;
                    f14 = f5;
                    f15 = f24;
                } else {
                    f12 = floatValue3;
                    f13 = floatValue4;
                    double atan2 = (float) (Math.atan2(f7, f6) - 1.5707963267948966d);
                    float cos4 = (float) Math.cos(atan2);
                    float sin4 = (float) Math.sin(atan2);
                    d6 = d5;
                    f14 = f5;
                    f15 = f24;
                    double atan22 = (float) (Math.atan2(f26, f25) - 1.5707963267948966d);
                    float cos5 = (float) Math.cos(atan22);
                    float sin5 = (float) Math.sin(atan22);
                    float f27 = z3 ? f13 : f22;
                    float f28 = z3 ? f22 : f13;
                    float f29 = (z3 ? f12 : f11) * f27 * 0.47829f;
                    float f30 = cos4 * f29;
                    float f31 = f29 * sin4;
                    float f32 = (z3 ? f11 : f12) * f28 * 0.47829f;
                    float f33 = cos5 * f32;
                    float f34 = f32 * sin5;
                    if (f18 != 0.0f) {
                        if (i4 == 0) {
                            f30 *= f18;
                            f31 *= f18;
                        } else if (d13 == ceil - 1.0d) {
                            f33 *= f18;
                            f34 *= f18;
                        }
                    }
                    this.f25433a.cubicTo(f6 - f30, f7 - f31, f25 + f33, f26 + f34, f25, f26);
                }
                double d15 = f15;
                Double.isNaN(d15);
                z3 = !z3;
                i4++;
                f7 = f26;
                d5 = d6 + d15;
                f5 = f14;
                f6 = f25;
                f4 = f11;
                f16 = f9;
                floatValue3 = f12;
                floatValue4 = f13;
            } else {
                PointF j4 = this.f25440h.j();
                this.f25433a.offset(j4.x, j4.y);
                this.f25433a.close();
                return;
            }
        }
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        f();
    }

    @Override // com.bytedance.adsdk.lottie.c.c.b
    public Path sr() {
        if (this.f25447o) {
            return this.f25433a;
        }
        this.f25433a.reset();
        if (this.f25437e) {
            this.f25447o = true;
            return this.f25433a;
        }
        int i4 = a.f25448a[this.f25436d.ordinal()];
        if (i4 == 1) {
            g();
        } else if (i4 == 2) {
            d();
        }
        this.f25433a.close();
        this.f25446n.a(this.f25433a);
        this.f25447o = true;
        return this.f25433a;
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            t tVar = list.get(i4);
            if (tVar instanceof i) {
                i iVar = (i) tVar;
                if (iVar.getType() == fz.c.SIMULTANEOUSLY) {
                    this.f25446n.b(iVar);
                    iVar.d(this);
                }
            }
        }
    }
}
