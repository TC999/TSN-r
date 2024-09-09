package com.bytedance.adsdk.lottie.c.w;

import com.bytedance.adsdk.lottie.n;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class l extends k<Float> {
    public l(List<n.h<Float>> list) {
        super(list);
    }

    public float i() {
        return p(n(), l());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.c.w.c
    /* renamed from: o */
    public Float b(n.h<Float> hVar, float f4) {
        return Float.valueOf(p(hVar, f4));
    }

    float p(n.h<Float> hVar, float f4) {
        Float f5;
        if (hVar.f25666b != null && hVar.f25667c != null) {
            n.k<A> kVar = this.f25474e;
            if (kVar != 0 && (f5 = (Float) kVar.a(hVar.f25671g, hVar.f25672h.floatValue(), hVar.f25666b, hVar.f25667c, f4, k(), g())) != null) {
                return f5.floatValue();
            }
            return com.bytedance.adsdk.lottie.f.d.a(hVar.d(), hVar.f(), f4);
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
