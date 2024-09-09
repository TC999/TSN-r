package com.bytedance.adsdk.lottie.xv.w;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.c.c.t;
import com.bytedance.adsdk.lottie.c.c.u;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class g implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f25846a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> f25847b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> f25848c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25849d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25850e;

    public g(String str, com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> bVar, com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> bVar2, com.bytedance.adsdk.lottie.xv.c.m mVar, boolean z3) {
        this.f25846a = str;
        this.f25847b = bVar;
        this.f25848c = bVar2;
        this.f25849d = mVar;
        this.f25850e = z3;
    }

    @Override // com.bytedance.adsdk.lottie.xv.w.l
    public t a(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar, com.bytedance.adsdk.lottie.xv.xv.a aVar) {
        return new u(dVar, aVar, this);
    }

    public String b() {
        return this.f25846a;
    }

    public com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> c() {
        return this.f25847b;
    }

    public boolean d() {
        return this.f25850e;
    }

    public com.bytedance.adsdk.lottie.xv.c.m e() {
        return this.f25849d;
    }

    public com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> f() {
        return this.f25848c;
    }

    public String toString() {
        return "RectangleShape{position=" + this.f25847b + ", size=" + this.f25848c + '}';
    }
}
