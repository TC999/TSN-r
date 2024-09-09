package com.bytedance.adsdk.lottie.xv.w;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.c.c.t;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class k implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f25872a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> f25873b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.e f25874c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f25875d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f25876e;

    public k(String str, com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> bVar, com.bytedance.adsdk.lottie.xv.c.e eVar, boolean z3, boolean z4) {
        this.f25872a = str;
        this.f25873b = bVar;
        this.f25874c = eVar;
        this.f25875d = z3;
        this.f25876e = z4;
    }

    @Override // com.bytedance.adsdk.lottie.xv.w.l
    public t a(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar, com.bytedance.adsdk.lottie.xv.xv.a aVar) {
        return new com.bytedance.adsdk.lottie.c.c.e(dVar, aVar, this);
    }

    public String b() {
        return this.f25872a;
    }

    public boolean c() {
        return this.f25875d;
    }

    public boolean d() {
        return this.f25876e;
    }

    public com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> e() {
        return this.f25873b;
    }

    public com.bytedance.adsdk.lottie.xv.c.e f() {
        return this.f25874c;
    }
}
