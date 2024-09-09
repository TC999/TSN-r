package com.bytedance.adsdk.lottie.c.c;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.c.w.c;
import com.bytedance.adsdk.lottie.xv.w.fz;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n implements b, c.b {

    /* renamed from: b  reason: collision with root package name */
    private final String f25416b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f25417c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.d f25418d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.c.w.b f25419e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f25420f;

    /* renamed from: a  reason: collision with root package name */
    private final Path f25415a = new Path();

    /* renamed from: g  reason: collision with root package name */
    private final s f25421g = new s();

    public n(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.xv.xv.a aVar, com.bytedance.adsdk.lottie.xv.w.f fVar) {
        this.f25416b = fVar.b();
        this.f25417c = fVar.d();
        this.f25418d = dVar;
        com.bytedance.adsdk.lottie.c.w.b c4 = fVar.c().c();
        this.f25419e = c4;
        aVar.l(c4);
        c4.f(this);
    }

    private void d() {
        this.f25420f = false;
        this.f25418d.invalidateSelf();
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c.b
    public void c() {
        d();
    }

    @Override // com.bytedance.adsdk.lottie.c.c.b
    public Path sr() {
        if (this.f25420f) {
            return this.f25415a;
        }
        this.f25415a.reset();
        if (this.f25417c) {
            this.f25420f = true;
            return this.f25415a;
        }
        Path j4 = this.f25419e.j();
        if (j4 == null) {
            return this.f25415a;
        }
        this.f25415a.set(j4);
        this.f25415a.setFillType(Path.FillType.EVEN_ODD);
        this.f25421g.a(this.f25415a);
        this.f25420f = true;
        return this.f25415a;
    }

    @Override // com.bytedance.adsdk.lottie.c.c.t
    public void c(List<t> list, List<t> list2) {
        ArrayList arrayList = null;
        for (int i4 = 0; i4 < list.size(); i4++) {
            t tVar = list.get(i4);
            if (tVar instanceof i) {
                i iVar = (i) tVar;
                if (iVar.getType() == fz.c.SIMULTANEOUSLY) {
                    this.f25421g.b(iVar);
                    iVar.d(this);
                }
            }
            if (tVar instanceof g) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add((g) tVar);
            }
        }
        this.f25419e.o(arrayList);
    }
}
