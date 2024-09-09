package com.bytedance.adsdk.lottie.xv.w;

import com.bytedance.adsdk.lottie.c.c.o;
import com.bytedance.adsdk.lottie.c.c.t;
import java.util.Arrays;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class e implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f25825a;

    /* renamed from: b  reason: collision with root package name */
    private final List<l> f25826b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f25827c;

    public e(String str, List<l> list, boolean z3) {
        this.f25825a = str;
        this.f25826b = list;
        this.f25827c = z3;
    }

    @Override // com.bytedance.adsdk.lottie.xv.w.l
    public t a(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar, com.bytedance.adsdk.lottie.xv.xv.a aVar) {
        return new o(dVar, aVar, this, eVar);
    }

    public String b() {
        return this.f25825a;
    }

    public List<l> c() {
        return this.f25826b;
    }

    public boolean d() {
        return this.f25827c;
    }

    public String toString() {
        return "ShapeGroup{name='" + this.f25825a + "' Shapes: " + Arrays.toString(this.f25826b.toArray()) + '}';
    }
}
