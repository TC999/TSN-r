package com.bytedance.adsdk.lottie.c.w;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.n;
import java.util.Collections;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class m extends c<PointF, PointF> {

    /* renamed from: i  reason: collision with root package name */
    private final PointF f25509i;

    /* renamed from: j  reason: collision with root package name */
    private final PointF f25510j;

    /* renamed from: k  reason: collision with root package name */
    private final c<Float, Float> f25511k;

    /* renamed from: l  reason: collision with root package name */
    private final c<Float, Float> f25512l;

    /* renamed from: m  reason: collision with root package name */
    protected n.k<Float> f25513m;

    /* renamed from: n  reason: collision with root package name */
    protected n.k<Float> f25514n;

    public m(c<Float, Float> cVar, c<Float, Float> cVar2) {
        super(Collections.emptyList());
        this.f25509i = new PointF();
        this.f25510j = new PointF();
        this.f25511k = cVar;
        this.f25512l = cVar2;
        e(g());
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c
    public void e(float f4) {
        this.f25511k.e(f4);
        this.f25512l.e(f4);
        this.f25509i.set(this.f25511k.j().floatValue(), this.f25512l.j().floatValue());
        for (int i4 = 0; i4 < this.f25470a.size(); i4++) {
            this.f25470a.get(i4).c();
        }
    }

    @Override // com.bytedance.adsdk.lottie.c.w.c
    /* renamed from: o */
    public PointF j() {
        return b(null, 0.0f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.bytedance.adsdk.lottie.c.w.c
    /* renamed from: p */
    public PointF b(n.h<PointF> hVar, float f4) {
        Float f5;
        n.h<Float> n4;
        n.h<Float> n5;
        Float f6 = null;
        if (this.f25513m == null || (n5 = this.f25511k.n()) == null) {
            f5 = null;
        } else {
            float l4 = this.f25511k.l();
            Float f7 = n5.f25672h;
            n.k<Float> kVar = this.f25513m;
            float f8 = n5.f25671g;
            f5 = kVar.a(f8, f7 == null ? f8 : f7.floatValue(), n5.f25666b, n5.f25667c, f4, f4, l4);
        }
        if (this.f25514n != null && (n4 = this.f25512l.n()) != null) {
            float l5 = this.f25512l.l();
            Float f9 = n4.f25672h;
            n.k<Float> kVar2 = this.f25514n;
            float f10 = n4.f25671g;
            f6 = kVar2.a(f10, f9 == null ? f10 : f9.floatValue(), n4.f25666b, n4.f25667c, f4, f4, l5);
        }
        if (f5 == null) {
            this.f25510j.set(this.f25509i.x, 0.0f);
        } else {
            this.f25510j.set(f5.floatValue(), 0.0f);
        }
        if (f6 == null) {
            PointF pointF = this.f25510j;
            pointF.set(pointF.x, this.f25509i.y);
        } else {
            PointF pointF2 = this.f25510j;
            pointF2.set(pointF2.x, f6.floatValue());
        }
        return this.f25510j;
    }
}
