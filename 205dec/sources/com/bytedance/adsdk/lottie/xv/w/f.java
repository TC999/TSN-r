package com.bytedance.adsdk.lottie.xv.w;

import com.bytedance.adsdk.lottie.c.c.n;
import com.bytedance.adsdk.lottie.c.c.t;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class f implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f25834a;

    /* renamed from: b  reason: collision with root package name */
    private final int f25835b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.d f25836c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f25837d;

    public f(String str, int i4, com.bytedance.adsdk.lottie.xv.c.d dVar, boolean z3) {
        this.f25834a = str;
        this.f25835b = i4;
        this.f25836c = dVar;
        this.f25837d = z3;
    }

    @Override // com.bytedance.adsdk.lottie.xv.w.l
    public t a(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar, com.bytedance.adsdk.lottie.xv.xv.a aVar) {
        return new n(dVar, aVar, this);
    }

    public String b() {
        return this.f25834a;
    }

    public com.bytedance.adsdk.lottie.xv.c.d c() {
        return this.f25836c;
    }

    public boolean d() {
        return this.f25837d;
    }

    public String toString() {
        return "ShapePath{name=" + this.f25834a + ", index=" + this.f25835b + '}';
    }
}
