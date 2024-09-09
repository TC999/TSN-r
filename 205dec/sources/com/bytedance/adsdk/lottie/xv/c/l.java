package com.bytedance.adsdk.lottie.xv.c;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.n;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class l implements b<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final List<n.h<PointF>> f25775a;

    public l(List<n.h<PointF>> list) {
        this.f25775a = list;
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.b
    public com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> c() {
        if (this.f25775a.get(0).h()) {
            return new com.bytedance.adsdk.lottie.c.w.i(this.f25775a);
        }
        return new com.bytedance.adsdk.lottie.c.w.j(this.f25775a);
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.b
    public boolean w() {
        return this.f25775a.size() == 1 && this.f25775a.get(0).h();
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.b
    public List<n.h<PointF>> xv() {
        return this.f25775a;
    }
}
