package com.bytedance.adsdk.lottie.c.w;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.n;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class b extends c<com.bytedance.adsdk.lottie.xv.w.i, Path> {

    /* renamed from: i  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.w.i f25467i;

    /* renamed from: j  reason: collision with root package name */
    private final Path f25468j;

    /* renamed from: k  reason: collision with root package name */
    private List<com.bytedance.adsdk.lottie.c.c.g> f25469k;

    public b(List<n.h<com.bytedance.adsdk.lottie.xv.w.i>> list) {
        super(list);
        this.f25467i = new com.bytedance.adsdk.lottie.xv.w.i();
        this.f25468j = new Path();
    }

    public void o(List<com.bytedance.adsdk.lottie.c.c.g> list) {
        this.f25469k = list;
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c
    /* renamed from: p */
    public Path b(n.h<com.bytedance.adsdk.lottie.xv.w.i> hVar, float f4) {
        this.f25467i.c(hVar.f25666b, hVar.f25667c, f4);
        com.bytedance.adsdk.lottie.xv.w.i iVar = this.f25467i;
        List<com.bytedance.adsdk.lottie.c.c.g> list = this.f25469k;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                iVar = this.f25469k.get(size).e(iVar);
            }
        }
        com.bytedance.adsdk.lottie.f.d.g(iVar, this.f25468j);
        return this.f25468j;
    }
}
