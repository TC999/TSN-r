package com.bytedance.adsdk.lottie.xv.w;

import android.graphics.Path;
import com.bytedance.adsdk.lottie.c.c.t;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class m implements l {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f25877a;

    /* renamed from: b  reason: collision with root package name */
    private final Path.FillType f25878b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25879c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.c f25880d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.j f25881e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f25882f;

    public m(String str, boolean z3, Path.FillType fillType, com.bytedance.adsdk.lottie.xv.c.c cVar, com.bytedance.adsdk.lottie.xv.c.j jVar, boolean z4) {
        this.f25879c = str;
        this.f25877a = z3;
        this.f25878b = fillType;
        this.f25880d = cVar;
        this.f25881e = jVar;
        this.f25882f = z4;
    }

    @Override // com.bytedance.adsdk.lottie.xv.w.l
    public t a(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar, com.bytedance.adsdk.lottie.xv.xv.a aVar) {
        return new com.bytedance.adsdk.lottie.c.c.m(dVar, aVar, this);
    }

    public String b() {
        return this.f25879c;
    }

    public Path.FillType c() {
        return this.f25878b;
    }

    public boolean d() {
        return this.f25882f;
    }

    public com.bytedance.adsdk.lottie.xv.c.c e() {
        return this.f25880d;
    }

    public com.bytedance.adsdk.lottie.xv.c.j f() {
        return this.f25881e;
    }

    public String toString() {
        return "ShapeFill{color=, fillEnabled=" + this.f25877a + '}';
    }
}
