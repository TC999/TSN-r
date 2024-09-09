package com.bytedance.adsdk.lottie.c.w;

import android.graphics.Path;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.n;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class g extends n.h<PointF> {

    /* renamed from: q  reason: collision with root package name */
    private Path f25501q;

    /* renamed from: r  reason: collision with root package name */
    private final n.h<PointF> f25502r;

    public g(com.bytedance.adsdk.lottie.e eVar, n.h<PointF> hVar) {
        super(eVar, hVar.f25666b, hVar.f25667c, hVar.f25668d, hVar.f25669e, hVar.f25670f, hVar.f25671g, hVar.f25672h);
        this.f25502r = hVar;
        j();
    }

    public void j() {
        Object obj;
        Object obj2;
        Object obj3 = this.f25667c;
        boolean z3 = (obj3 == null || (obj2 = this.f25666b) == null || !((PointF) obj2).equals(((PointF) obj3).x, ((PointF) obj3).y)) ? false : true;
        Object obj4 = this.f25666b;
        if (obj4 == null || (obj = this.f25667c) == null || z3) {
            return;
        }
        n.h<PointF> hVar = this.f25502r;
        this.f25501q = com.bytedance.adsdk.lottie.f.b.f((PointF) obj4, (PointF) obj, hVar.f25679o, hVar.f25680p);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Path k() {
        return this.f25501q;
    }
}
