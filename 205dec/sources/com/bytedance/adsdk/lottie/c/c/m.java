package com.bytedance.adsdk.lottie.c.c;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.c.w.c;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class m implements k, r, c.b {

    /* renamed from: a  reason: collision with root package name */
    private final Path f25402a;

    /* renamed from: b  reason: collision with root package name */
    private final Paint f25403b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.xv.a f25404c;

    /* renamed from: d  reason: collision with root package name */
    private final String f25405d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25406e;

    /* renamed from: f  reason: collision with root package name */
    private final List<b> f25407f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> f25408g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> f25409h;

    /* renamed from: i  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> f25410i;

    /* renamed from: j  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.d f25411j;

    /* renamed from: k  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.c<Float, Float> f25412k;

    /* renamed from: l  reason: collision with root package name */
    float f25413l;

    /* renamed from: m  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.p f25414m;

    /* JADX WARN: Type inference failed for: r1v0, types: [android.graphics.Paint, h0.a] */
    public m(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, com.bytedance.adsdk.lottie.xv.w.m mVar) {
        Path path = new Path();
        this.f25402a = path;
        this.f25403b = new h0.a(1);
        this.f25407f = new ArrayList();
        this.f25404c = aVar;
        this.f25405d = mVar.b();
        this.f25406e = mVar.d();
        this.f25411j = dVar;
        if (aVar.q() != null) {
            com.bytedance.adsdk.lottie.c.w.c<Float, Float> c4 = aVar.q().a().c();
            this.f25412k = c4;
            c4.f(this);
            aVar.l(this.f25412k);
        }
        if (aVar.u() != null) {
            this.f25414m = new com.bytedance.adsdk.lottie.c.w.p(this, aVar, aVar.u());
        }
        if (mVar.e() != null && mVar.f() != null) {
            path.setFillType(mVar.c());
            com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> c5 = mVar.e().c();
            this.f25408g = c5;
            c5.f(this);
            aVar.l(c5);
            com.bytedance.adsdk.lottie.c.w.c<Integer, Integer> c6 = mVar.f().c();
            this.f25409h = c6;
            c6.f(this);
            aVar.l(c6);
            return;
        }
        this.f25408g = null;
        this.f25409h = null;
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void a(Canvas canvas, Matrix matrix, int i4) {
        if (this.f25406e) {
            return;
        }
        com.bytedance.adsdk.lottie.s.b("FillContent#draw");
        this.f25403b.setColor((com.bytedance.adsdk.lottie.f.d.e((int) ((((i4 / 255.0f) * this.f25409h.j().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.bytedance.adsdk.lottie.c.w.o) this.f25408g).o() & 16777215));
        com.bytedance.adsdk.lottie.c.w.c<ColorFilter, ColorFilter> cVar = this.f25410i;
        if (cVar != null) {
            this.f25403b.setColorFilter(cVar.j());
        }
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> cVar2 = this.f25412k;
        if (cVar2 != null) {
            float floatValue = cVar2.j().floatValue();
            if (floatValue == 0.0f) {
                this.f25403b.setMaskFilter(null);
            } else if (floatValue != this.f25413l) {
                this.f25403b.setMaskFilter(this.f25404c.z(floatValue));
            }
            this.f25413l = floatValue;
        }
        com.bytedance.adsdk.lottie.c.w.p pVar = this.f25414m;
        if (pVar != null) {
            pVar.a(this.f25403b);
        }
        this.f25402a.reset();
        for (int i5 = 0; i5 < this.f25407f.size(); i5++) {
            this.f25402a.addPath(this.f25407f.get(i5).sr(), matrix);
        }
        canvas.drawPath(this.f25402a, this.f25403b);
        com.bytedance.adsdk.lottie.s.d("FillContent#draw");
    }

    @Override // com.bytedance.adsdk.lottie.c.c.r
    public void b(RectF rectF, Matrix matrix, boolean z3) {
        this.f25402a.reset();
        for (int i4 = 0; i4 < this.f25407f.size(); i4++) {
            this.f25402a.addPath(this.f25407f.get(i4).sr(), matrix);
        }
        this.f25402a.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        this.f25411j.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
        for (int i4 = 0; i4 < list2.size(); i4++) {
            t tVar = list2.get(i4);
            if (tVar instanceof b) {
                this.f25407f.add((b) tVar);
            }
        }
    }
}
