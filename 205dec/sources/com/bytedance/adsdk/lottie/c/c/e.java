package com.bytedance.adsdk.lottie.c.c;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.c.w.c;
import com.bytedance.adsdk.lottie.xv.w.fz;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class e implements b, k, c.b {

    /* renamed from: b  reason: collision with root package name */
    private final String f25365b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.d f25366c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, PointF> f25367d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.c<?, PointF> f25368e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.w.k f25369f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f25371h;

    /* renamed from: a  reason: collision with root package name */
    private final Path f25364a = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final s f25370g = new s();

    public e(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, com.bytedance.adsdk.lottie.xv.w.k kVar) {
        this.f25365b = kVar.b();
        this.f25366c = dVar;
        com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> c4 = kVar.f().c();
        this.f25367d = c4;
        com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> c5 = kVar.e().c();
        this.f25368e = c5;
        this.f25369f = kVar;
        aVar.l(c4);
        aVar.l(c5);
        c4.f(this);
        c5.f(this);
    }

    private void d() {
        this.f25371h = false;
        this.f25366c.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        d();
    }

    @Override // com.bytedance.adsdk.lottie.c.c.b
    public Path sr() {
        if (this.f25371h) {
            return this.f25364a;
        }
        this.f25364a.reset();
        if (this.f25369f.d()) {
            this.f25371h = true;
            return this.f25364a;
        }
        PointF j4 = this.f25367d.j();
        float f4 = j4.x / 2.0f;
        float f5 = j4.y / 2.0f;
        float f6 = f4 * 0.55228f;
        float f7 = 0.55228f * f5;
        this.f25364a.reset();
        if (this.f25369f.c()) {
            float f8 = -f5;
            this.f25364a.moveTo(0.0f, f8);
            float f9 = 0.0f - f6;
            float f10 = -f4;
            float f11 = 0.0f - f7;
            this.f25364a.cubicTo(f9, f8, f10, f11, f10, 0.0f);
            float f12 = f7 + 0.0f;
            this.f25364a.cubicTo(f10, f12, f9, f5, 0.0f, f5);
            float f13 = f6 + 0.0f;
            this.f25364a.cubicTo(f13, f5, f4, f12, f4, 0.0f);
            this.f25364a.cubicTo(f4, f11, f13, f8, 0.0f, f8);
        } else {
            float f14 = -f5;
            this.f25364a.moveTo(0.0f, f14);
            float f15 = f6 + 0.0f;
            float f16 = 0.0f - f7;
            this.f25364a.cubicTo(f15, f14, f4, f16, f4, 0.0f);
            float f17 = f7 + 0.0f;
            this.f25364a.cubicTo(f4, f17, f15, f5, 0.0f, f5);
            float f18 = 0.0f - f6;
            float f19 = -f4;
            this.f25364a.cubicTo(f18, f5, f19, f17, f19, 0.0f);
            this.f25364a.cubicTo(f19, f16, f18, f14, 0.0f, f14);
        }
        PointF j5 = this.f25368e.j();
        this.f25364a.offset(j5.x, j5.y);
        this.f25364a.close();
        this.f25370g.a(this.f25364a);
        this.f25371h = true;
        return this.f25364a;
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
        for (int i4 = 0; i4 < list.size(); i4++) {
            t tVar = list.get(i4);
            if (tVar instanceof i) {
                i iVar = (i) tVar;
                if (iVar.getType() == fz.c.SIMULTANEOUSLY) {
                    this.f25370g.b(iVar);
                    iVar.d(this);
                }
            }
        }
    }
}
