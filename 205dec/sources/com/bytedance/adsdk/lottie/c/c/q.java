package com.bytedance.adsdk.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class q extends c {

    /* renamed from: r  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.xv.a f25449r;

    /* renamed from: s  reason: collision with root package name */
    private final String f25450s;

    /* renamed from: t  reason: collision with root package name */
    private final boolean f25451t;

    /* renamed from: u  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> f25452u;

    /* renamed from: v  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> f25453v;

    public q(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, com.bytedance.adsdk.lottie.xv.w.s sVar) {
        super(dVar, aVar, sVar.g().c(), sVar.c().c(), sVar.e(), sVar.k(), sVar.h(), sVar.i(), sVar.d());
        this.f25449r = aVar;
        this.f25450s = sVar.b();
        this.f25451t = sVar.f();
        com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> c4 = sVar.j().c();
        this.f25452u = c4;
        c4.f(this);
        aVar.l(c4);
    }

    @Override // com.bytedance.adsdk.lottie.c.c.c, com.bytedance.adsdk.lottie.c.c.r
    public void a(Canvas canvas, Matrix matrix, int i4) {
        if (this.f25451t) {
            return;
        }
        this.f25332i.setColor(((com.bytedance.adsdk.lottie.c.w.o) this.f25452u).o());
        com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> cVar = this.f25453v;
        if (cVar != null) {
            this.f25332i.setColorFilter(cVar.j());
        }
        super.a(canvas, matrix, i4);
    }
}
