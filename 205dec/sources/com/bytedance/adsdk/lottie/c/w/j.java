package com.bytedance.adsdk.lottie.c.w;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import com.bytedance.adsdk.lottie.n;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class j extends k<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f25505i;

    /* renamed from: j  reason: collision with root package name */
    private final float[] f25506j;

    /* renamed from: k  reason: collision with root package name */
    private final PathMeasure f25507k;

    /* renamed from: l  reason: collision with root package name */
    private g f25508l;

    public j(List<? extends n.h<PointF>> list) {
        super(list);
        this.f25505i = new PointF();
        this.f25506j = new float[2];
        this.f25507k = new PathMeasure();
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c
    /* renamed from: o */
    public PointF b(n.h<PointF> hVar, float f4) {
        PointF pointF;
        g gVar = (g) hVar;
        Path k4 = gVar.k();
        if (k4 == null) {
            return hVar.f25666b;
        }
        n.k<A> kVar = this.f25474e;
        if (kVar == 0 || (pointF = (PointF) kVar.a(gVar.f25671g, gVar.f25672h.floatValue(), gVar.f25666b, gVar.f25667c, k(), f4, g())) == null) {
            if (this.f25508l != gVar) {
                this.f25507k.setPath(k4, false);
                this.f25508l = gVar;
            }
            PathMeasure pathMeasure = this.f25507k;
            pathMeasure.getPosTan(f4 * pathMeasure.getLength(), this.f25506j, null);
            PointF pointF2 = this.f25505i;
            float[] fArr = this.f25506j;
            pointF2.set(fArr[0], fArr[1]);
            return this.f25505i;
        }
        return pointF;
    }
}
