package com.bytedance.adsdk.lottie.c.w;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.n;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i extends k<PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f25504i;

    public i(List<n.h<PointF>> list) {
        super(list);
        this.f25504i = new PointF();
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c
    /* renamed from: o */
    public PointF b(n.h<PointF> hVar, float f4) {
        return c(hVar, f4, f4, f4);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.bytedance.adsdk.lottie.c.w.c
    /* renamed from: p */
    public PointF c(n.h<PointF> hVar, float f4, float f5, float f6) {
        PointF pointF;
        PointF pointF2;
        PointF pointF3 = hVar.f25666b;
        if (pointF3 != null && (pointF = hVar.f25667c) != null) {
            PointF pointF4 = pointF3;
            PointF pointF5 = pointF;
            n.k<A> kVar = this.f25474e;
            if (kVar == 0 || (pointF2 = (PointF) kVar.a(hVar.f25671g, hVar.f25672h.floatValue(), pointF4, pointF5, f4, k(), g())) == null) {
                PointF pointF6 = this.f25504i;
                float f7 = pointF4.x;
                float f8 = f7 + (f5 * (pointF5.x - f7));
                float f9 = pointF4.y;
                pointF6.set(f8, f9 + (f6 * (pointF5.y - f9)));
                return this.f25504i;
            }
            return pointF2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
