package com.bytedance.adsdk.lottie.c.w;

import com.bytedance.adsdk.lottie.n;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class o extends k<Integer> {
    public o(List<n.h<Integer>> list) {
        super(list);
    }

    public int o() {
        return q(n(), l());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.c.w.c
    /* renamed from: p */
    public Integer b(n.h<Integer> hVar, float f4) {
        return Integer.valueOf(q(hVar, f4));
    }

    public int q(n.h<Integer> hVar, float f4) {
        Integer num;
        if (hVar.f25666b != null && hVar.f25667c != null) {
            n.k<A> kVar = this.f25474e;
            if (kVar != 0 && (num = (Integer) kVar.a(hVar.f25671g, hVar.f25672h.floatValue(), hVar.f25666b, hVar.f25667c, f4, k(), g())) != null) {
                return num.intValue();
            }
            return com.bytedance.adsdk.lottie.f.g.b(com.bytedance.adsdk.lottie.f.d.h(f4, 0.0f, 1.0f), hVar.f25666b.intValue(), hVar.f25667c.intValue());
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
