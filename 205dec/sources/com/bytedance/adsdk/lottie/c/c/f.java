package com.bytedance.adsdk.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.c.w.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements b, k, l, r, c.b {

    /* renamed from: a  reason: collision with root package name */
    private final Matrix f25372a = new Matrix();

    /* renamed from: b  reason: collision with root package name */
    private final Path f25373b = new Path();

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.d f25374c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.xv.a f25375d;

    /* renamed from: e  reason: collision with root package name */
    private final String f25376e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f25377f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<Float, Float> f25378g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<Float, Float> f25379h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.f f25380i;

    /* renamed from: j  reason: collision with root package name */
    private o f25381j;

    public f(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, com.bytedance.adsdk.lottie.xv.w.a aVar2) {
        this.f25374c = dVar;
        this.f25375d = aVar;
        this.f25376e = aVar2.b();
        this.f25377f = aVar2.d();
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c4 = aVar2.e().c();
        this.f25378g = c4;
        aVar.l(c4);
        c4.f(this);
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c5 = aVar2.f().c();
        this.f25379h = c5;
        aVar.l(c5);
        c5.f(this);
        com.bytedance.adsdk.lottie.c.w.f f4 = aVar2.c().f();
        this.f25380i = f4;
        f4.d(aVar);
        f4.c(this);
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void a(Canvas canvas, Matrix matrix, int i4) {
        float floatValue = this.f25378g.j().floatValue();
        float floatValue2 = this.f25379h.j().floatValue();
        float floatValue3 = this.f25380i.h().j().floatValue() / 100.0f;
        float floatValue4 = this.f25380i.i().j().floatValue() / 100.0f;
        for (int i5 = ((int) floatValue) - 1; i5 >= 0; i5--) {
            this.f25372a.set(matrix);
            float f4 = i5;
            this.f25372a.preConcat(this.f25380i.g(f4 + floatValue2));
            this.f25381j.a(canvas, this.f25372a, (int) (i4 * com.bytedance.adsdk.lottie.f.d.a(floatValue3, floatValue4, f4 / floatValue)));
        }
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void b(RectF rectF, Matrix matrix, boolean z3) {
        this.f25381j.b(rectF, matrix, z3);
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
        this.f25381j.c(list, list2);
    }

    @Override // com.bytedance.adsdk.lottie.c.c.l
    public void d(ListIterator<t> listIterator) {
        if (this.f25381j != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.f25381j = new o(this.f25374c, this.f25375d, "Repeater", this.f25377f, arrayList, null);
    }

    @Override // com.bytedance.adsdk.lottie.c.c.b
    public Path sr() {
        Path sr = this.f25381j.sr();
        this.f25373b.reset();
        float floatValue = this.f25378g.j().floatValue();
        float floatValue2 = this.f25379h.j().floatValue();
        for (int i4 = ((int) floatValue) - 1; i4 >= 0; i4--) {
            this.f25372a.set(this.f25380i.g(i4 + floatValue2));
            this.f25373b.addPath(sr, this.f25372a);
        }
        return this.f25373b;
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        this.f25374c.invalidateSelf();
    }
}
