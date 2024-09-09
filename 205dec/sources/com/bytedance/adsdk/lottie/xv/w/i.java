package com.bytedance.adsdk.lottie.xv.w;

import android.graphics.PointF;
import com.bytedance.component.sdk.annotation.FloatRange;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.xv.a> f25859a;

    /* renamed from: b  reason: collision with root package name */
    private PointF f25860b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f25861c;

    public i(PointF pointF, boolean z3, List<com.bytedance.adsdk.lottie.xv.a> list) {
        this.f25860b = pointF;
        this.f25861c = z3;
        this.f25859a = new ArrayList(list);
    }

    public PointF a() {
        return this.f25860b;
    }

    public void b(float f4, float f5) {
        if (this.f25860b == null) {
            this.f25860b = new PointF();
        }
        this.f25860b.set(f4, f5);
    }

    public void c(i iVar, i iVar2, @FloatRange(from = 0.0d, to = 1.0d) float f4) {
        if (this.f25860b == null) {
            this.f25860b = new PointF();
        }
        this.f25861c = iVar.e() || iVar2.e();
        if (iVar.f().size() != iVar2.f().size()) {
            com.bytedance.adsdk.lottie.f.e.c("Curves must have the same number of control points. Shape 1: " + iVar.f().size() + "\tShape 2: " + iVar2.f().size());
        }
        int min = Math.min(iVar.f().size(), iVar2.f().size());
        if (this.f25859a.size() < min) {
            for (int size = this.f25859a.size(); size < min; size++) {
                this.f25859a.add(new com.bytedance.adsdk.lottie.xv.a());
            }
        } else if (this.f25859a.size() > min) {
            for (int size2 = this.f25859a.size() - 1; size2 >= min; size2--) {
                List<com.bytedance.adsdk.lottie.xv.a> list = this.f25859a;
                list.remove(list.size() - 1);
            }
        }
        PointF a4 = iVar.a();
        PointF a5 = iVar2.a();
        b(com.bytedance.adsdk.lottie.f.d.a(a4.x, a5.x, f4), com.bytedance.adsdk.lottie.f.d.a(a4.y, a5.y, f4));
        for (int size3 = this.f25859a.size() - 1; size3 >= 0; size3--) {
            com.bytedance.adsdk.lottie.xv.a aVar = iVar.f().get(size3);
            com.bytedance.adsdk.lottie.xv.a aVar2 = iVar2.f().get(size3);
            PointF a6 = aVar.a();
            PointF c4 = aVar.c();
            PointF e4 = aVar.e();
            PointF a7 = aVar2.a();
            PointF c5 = aVar2.c();
            PointF e5 = aVar2.e();
            this.f25859a.get(size3).b(com.bytedance.adsdk.lottie.f.d.a(a6.x, a7.x, f4), com.bytedance.adsdk.lottie.f.d.a(a6.y, a7.y, f4));
            this.f25859a.get(size3).d(com.bytedance.adsdk.lottie.f.d.a(c4.x, c5.x, f4), com.bytedance.adsdk.lottie.f.d.a(c4.y, c5.y, f4));
            this.f25859a.get(size3).f(com.bytedance.adsdk.lottie.f.d.a(e4.x, e5.x, f4), com.bytedance.adsdk.lottie.f.d.a(e4.y, e5.y, f4));
        }
    }

    public void d(boolean z3) {
        this.f25861c = z3;
    }

    public boolean e() {
        return this.f25861c;
    }

    public List<com.bytedance.adsdk.lottie.xv.a> f() {
        return this.f25859a;
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.f25859a.size() + "closed=" + this.f25861c + '}';
    }

    public i() {
        this.f25859a = new ArrayList();
    }
}
