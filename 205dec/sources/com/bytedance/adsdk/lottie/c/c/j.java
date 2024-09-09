package com.bytedance.adsdk.lottie.c.c;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.c.w.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class j implements g, c.b {

    /* renamed from: a  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.d f25398a;

    /* renamed from: b  reason: collision with root package name */
    private final String f25399b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<Float, Float> f25400c;

    /* renamed from: d  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.xv.w.i f25401d;

    public j(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, com.bytedance.adsdk.lottie.xv.w.b bVar) {
        this.f25398a = dVar;
        this.f25399b = bVar.b();
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c4 = bVar.c().c();
        this.f25400c = c4;
        aVar.l(c4);
        c4.f(this);
    }

    private static int d(int i4, int i5) {
        return i4 - (f(i4, i5) * i5);
    }

    private static int f(int i4, int i5) {
        int i6 = i4 / i5;
        return ((i4 ^ i5) >= 0 || i5 * i6 == i4) ? i6 : i6 - 1;
    }

    private com.bytedance.adsdk.lottie.xv.w.i h(com.bytedance.adsdk.lottie.xv.w.i iVar) {
        List<com.bytedance.adsdk.lottie.xv.a> f4 = iVar.f();
        boolean e4 = iVar.e();
        int size = f4.size() - 1;
        int i4 = 0;
        while (size >= 0) {
            com.bytedance.adsdk.lottie.xv.a aVar = f4.get(size);
            com.bytedance.adsdk.lottie.xv.a aVar2 = f4.get(d(size - 1, f4.size()));
            PointF e5 = (size != 0 || e4) ? aVar2.e() : iVar.a();
            i4 = (((size != 0 || e4) ? aVar2.c() : e5).equals(e5) && aVar.a().equals(e5) && !(!iVar.e() && size == 0 && size == f4.size() - 1)) ? i4 + 2 : i4 + 1;
            size--;
        }
        com.bytedance.adsdk.lottie.xv.w.i iVar2 = this.f25401d;
        if (iVar2 == null || iVar2.f().size() != i4) {
            ArrayList arrayList = new ArrayList(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.add(new com.bytedance.adsdk.lottie.xv.a());
            }
            this.f25401d = new com.bytedance.adsdk.lottie.xv.w.i(new PointF(0.0f, 0.0f), false, arrayList);
        }
        this.f25401d.d(e4);
        return this.f25401d;
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        this.f25398a.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
    }

    @Override // com.bytedance.adsdk.lottie.c.c.g
    public com.bytedance.adsdk.lottie.xv.w.i e(com.bytedance.adsdk.lottie.xv.w.i iVar) {
        List<com.bytedance.adsdk.lottie.xv.a> list;
        List<com.bytedance.adsdk.lottie.xv.a> f4 = iVar.f();
        if (f4.size() <= 2) {
            return iVar;
        }
        float floatValue = this.f25400c.j().floatValue();
        if (floatValue == 0.0f) {
            return iVar;
        }
        com.bytedance.adsdk.lottie.xv.w.i h4 = h(iVar);
        h4.b(iVar.a().x, iVar.a().y);
        List<com.bytedance.adsdk.lottie.xv.a> f5 = h4.f();
        boolean e4 = iVar.e();
        int i4 = 0;
        int i5 = 0;
        while (i4 < f4.size()) {
            com.bytedance.adsdk.lottie.xv.a aVar = f4.get(i4);
            com.bytedance.adsdk.lottie.xv.a aVar2 = f4.get(d(i4 - 1, f4.size()));
            com.bytedance.adsdk.lottie.xv.a aVar3 = f4.get(d(i4 - 2, f4.size()));
            PointF e5 = (i4 != 0 || e4) ? aVar2.e() : iVar.a();
            PointF c4 = (i4 != 0 || e4) ? aVar2.c() : e5;
            PointF a4 = aVar.a();
            PointF e6 = aVar3.e();
            PointF e7 = aVar.e();
            boolean z3 = !iVar.e() && i4 == 0 && i4 == f4.size() + (-1);
            if (c4.equals(e5) && a4.equals(e5) && !z3) {
                float f6 = e5.x;
                float f7 = f6 - e6.x;
                float f8 = e5.y;
                float f9 = e7.x - f6;
                list = f4;
                float min = Math.min(floatValue / ((float) Math.hypot(f7, f8 - e6.y)), 0.5f);
                float min2 = Math.min(floatValue / ((float) Math.hypot(f9, e7.y - f8)), 0.5f);
                float f10 = e5.x;
                float f11 = ((e6.x - f10) * min) + f10;
                float f12 = e5.y;
                float f13 = ((e6.y - f12) * min) + f12;
                float f14 = ((e7.x - f10) * min2) + f10;
                float f15 = ((e7.y - f12) * min2) + f12;
                float f16 = f11 - ((f11 - f10) * 0.5519f);
                float f17 = f13 - ((f13 - f12) * 0.5519f);
                float f18 = f14 - ((f14 - f10) * 0.5519f);
                float f19 = f15 - ((f15 - f12) * 0.5519f);
                com.bytedance.adsdk.lottie.xv.a aVar4 = f5.get(d(i5 - 1, f5.size()));
                com.bytedance.adsdk.lottie.xv.a aVar5 = f5.get(i5);
                aVar4.d(f11, f13);
                aVar4.f(f11, f13);
                if (i4 == 0) {
                    h4.b(f11, f13);
                }
                aVar5.b(f16, f17);
                i5++;
                aVar5.d(f18, f19);
                aVar5.f(f14, f15);
                f5.get(i5).b(f14, f15);
            } else {
                list = f4;
                com.bytedance.adsdk.lottie.xv.a aVar6 = f5.get(d(i5 - 1, f5.size()));
                aVar6.d(aVar2.c().x, aVar2.c().y);
                aVar6.f(aVar2.e().x, aVar2.e().y);
                f5.get(i5).b(aVar.a().x, aVar.a().y);
            }
            i5++;
            i4++;
            f4 = list;
        }
        return h4;
    }

    public com.bytedance.adsdk.lottie.c.w.c<Float, Float> g() {
        return this.f25400c;
    }
}
