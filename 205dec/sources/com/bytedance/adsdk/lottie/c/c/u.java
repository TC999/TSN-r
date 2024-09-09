package com.bytedance.adsdk.lottie.c.c;

import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RectF;
import com.bytedance.adsdk.lottie.c.w.c;
import com.bytedance.adsdk.lottie.xv.w.fz;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class u implements b, k, c.b {

    /* renamed from: c  reason: collision with root package name */
    private final String f25457c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f25458d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.d f25459e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, PointF> f25460f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, PointF> f25461g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, Float> f25462h;

    /* renamed from: k  reason: collision with root package name */
    private boolean f25465k;

    /* renamed from: a  reason: collision with root package name */
    private final Path f25455a = new Path();

    /* renamed from: b  reason: collision with root package name */
    private final RectF f25456b = new RectF();

    /* renamed from: i  reason: collision with root package name */
    private final s f25463i = new s();

    /* renamed from: j  reason: collision with root package name */
    private com.bytedance.adsdk.lottie.c.w.c<Float, Float> f25464j = null;

    public u(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, com.bytedance.adsdk.lottie.xv.w.g gVar) {
        this.f25457c = gVar.b();
        this.f25458d = gVar.d();
        this.f25459e = dVar;
        com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> c4 = gVar.c().c();
        this.f25460f = c4;
        com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> c5 = gVar.f().c();
        this.f25461g = c5;
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> c6 = gVar.e().c();
        this.f25462h = c6;
        aVar.l(c4);
        aVar.l(c5);
        aVar.l(c6);
        c4.f(this);
        c5.f(this);
        c6.f(this);
    }

    private void d() {
        this.f25465k = false;
        this.f25459e.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        d();
    }

    @Override // com.bytedance.adsdk.lottie.c.c.b
    public Path sr() {
        com.bytedance.adsdk.lottie.c.w.c<Float, Float> cVar;
        if (this.f25465k) {
            return this.f25455a;
        }
        this.f25455a.reset();
        if (this.f25458d) {
            this.f25465k = true;
            return this.f25455a;
        }
        PointF j4 = this.f25461g.j();
        float f4 = j4.x / 2.0f;
        float f5 = j4.y / 2.0f;
        com.bytedance.adsdk.lottie.c.w.c<?, Float> cVar2 = this.f25462h;
        float i4 = cVar2 == null ? 0.0f : ((com.bytedance.adsdk.lottie.c.w.l) cVar2).i();
        if (i4 == 0.0f && (cVar = this.f25464j) != null) {
            i4 = Math.min(cVar.j().floatValue(), Math.min(f4, f5));
        }
        float min = Math.min(f4, f5);
        if (i4 > min) {
            i4 = min;
        }
        PointF j5 = this.f25460f.j();
        this.f25455a.moveTo(j5.x + f4, (j5.y - f5) + i4);
        this.f25455a.lineTo(j5.x + f4, (j5.y + f5) - i4);
        if (i4 > 0.0f) {
            RectF rectF = this.f25456b;
            float f6 = j5.x;
            float f7 = i4 * 2.0f;
            float f8 = j5.y;
            rectF.set((f6 + f4) - f7, (f8 + f5) - f7, f6 + f4, f8 + f5);
            this.f25455a.arcTo(this.f25456b, 0.0f, 90.0f, false);
        }
        this.f25455a.lineTo((j5.x - f4) + i4, j5.y + f5);
        if (i4 > 0.0f) {
            RectF rectF2 = this.f25456b;
            float f9 = j5.x;
            float f10 = j5.y;
            float f11 = i4 * 2.0f;
            rectF2.set(f9 - f4, (f10 + f5) - f11, (f9 - f4) + f11, f10 + f5);
            this.f25455a.arcTo(this.f25456b, 90.0f, 90.0f, false);
        }
        this.f25455a.lineTo(j5.x - f4, (j5.y - f5) + i4);
        if (i4 > 0.0f) {
            RectF rectF3 = this.f25456b;
            float f12 = j5.x;
            float f13 = j5.y;
            float f14 = i4 * 2.0f;
            rectF3.set(f12 - f4, f13 - f5, (f12 - f4) + f14, (f13 - f5) + f14);
            this.f25455a.arcTo(this.f25456b, 180.0f, 90.0f, false);
        }
        this.f25455a.lineTo((j5.x + f4) - i4, j5.y - f5);
        if (i4 > 0.0f) {
            RectF rectF4 = this.f25456b;
            float f15 = j5.x;
            float f16 = i4 * 2.0f;
            float f17 = j5.y;
            rectF4.set((f15 + f4) - f16, f17 - f5, f15 + f4, (f17 - f5) + f16);
            this.f25455a.arcTo(this.f25456b, 270.0f, 90.0f, false);
        }
        this.f25455a.close();
        this.f25463i.a(this.f25455a);
        this.f25465k = true;
        return this.f25455a;
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            t tVar = list.get(i4);
            if (tVar instanceof i) {
                i iVar = (i) tVar;
                if (iVar.getType() == fz.c.SIMULTANEOUSLY) {
                    this.f25463i.b(iVar);
                    iVar.d(this);
                }
            }
            if (tVar instanceof j) {
                this.f25464j = ((j) tVar).g();
            }
        }
    }
}
