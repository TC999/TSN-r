package com.bytedance.adsdk.lottie.xv.c;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.n;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements b<PointF, PointF> {

    /* renamed from: a  reason: collision with root package name */
    private final m f25768a;

    /* renamed from: b  reason: collision with root package name */
    private final m f25769b;

    public f(m mVar, m mVar2) {
        this.f25768a = mVar;
        this.f25769b = mVar2;
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.b
    public com.bytedance.adsdk.lottie.c.w.c<PointF, PointF> c() {
        return new com.bytedance.adsdk.lottie.c.w.m(this.f25768a.c(), this.f25769b.c());
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.b
    public boolean w() {
        return this.f25768a.w() && this.f25769b.w();
    }

    @Override // com.bytedance.adsdk.lottie.xv.c.b
    public List<n.h<PointF>> xv() {
        throw new UnsupportedOperationException("Cannot call getKeyframes on AnimatableSplitDimensionPathValue.");
    }
}
