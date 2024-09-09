package com.bytedance.adsdk.lottie.c.w;

import com.bytedance.adsdk.lottie.n;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class a extends k<n.i> {

    /* renamed from: i  reason: collision with root package name */
    private final n.i f25466i;

    public a(List<n.h<n.i>> list) {
        super(list);
        this.f25466i = new n.i();
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c
    /* renamed from: o */
    public n.i b(n.h<n.i> hVar, float f4) {
        n.i iVar;
        n.i iVar2;
        n.i iVar3 = hVar.f25666b;
        if (iVar3 != null && (iVar = hVar.f25667c) != null) {
            n.i iVar4 = iVar3;
            n.i iVar5 = iVar;
            n.k<A> kVar = this.f25474e;
            if (kVar == 0 || (iVar2 = (n.i) kVar.a(hVar.f25671g, hVar.f25672h.floatValue(), iVar4, iVar5, f4, k(), g())) == null) {
                this.f25466i.b(com.bytedance.adsdk.lottie.f.d.a(iVar4.a(), iVar5.a(), f4), com.bytedance.adsdk.lottie.f.d.a(iVar4.c(), iVar5.c(), f4));
                return this.f25466i;
            }
            return iVar2;
        }
        throw new IllegalStateException("Missing values for keyframe.");
    }
}
