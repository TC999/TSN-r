package com.bytedance.adsdk.lottie.c.w;

import com.bytedance.adsdk.lottie.n;
import com.bytedance.adsdk.lottie.xv.w;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class q extends k<w> {
    public q(List<n.h<w>> list) {
        super(list);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.c.w.c
    /* renamed from: o */
    public w b(n.h<w> hVar, float f4) {
        w wVar;
        n.k<A> kVar = this.f25474e;
        if (kVar == 0) {
            if (f4 == 1.0f && (wVar = hVar.f25667c) != null) {
                return wVar;
            }
            return hVar.f25666b;
        }
        float f5 = hVar.f25671g;
        Float f6 = hVar.f25672h;
        float floatValue = f6 == null ? Float.MAX_VALUE : f6.floatValue();
        w wVar2 = hVar.f25666b;
        w wVar3 = hVar.f25667c;
        return (w) kVar.a(f5, floatValue, wVar2, wVar3 == null ? wVar2 : wVar3, f4, l(), g());
    }
}
