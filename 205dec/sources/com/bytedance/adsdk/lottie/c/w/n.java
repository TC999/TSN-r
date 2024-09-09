package com.bytedance.adsdk.lottie.c.w;

import com.bytedance.adsdk.lottie.n;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class n extends k<com.bytedance.adsdk.lottie.xv.w.h> {

    /* renamed from: i  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.w.h f25515i;

    public n(List<n.h<com.bytedance.adsdk.lottie.xv.w.h>> list) {
        super(list);
        com.bytedance.adsdk.lottie.xv.w.h hVar = list.get(0).f25666b;
        int f4 = hVar != null ? hVar.f() : 0;
        this.f25515i = new com.bytedance.adsdk.lottie.xv.w.h(new float[f4], new int[f4]);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.c.w.c
    /* renamed from: o */
    public com.bytedance.adsdk.lottie.xv.w.h b(n.h<com.bytedance.adsdk.lottie.xv.w.h> hVar, float f4) {
        this.f25515i.c(hVar.f25666b, hVar.f25667c, f4);
        return this.f25515i;
    }
}
