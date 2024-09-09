package com.bytedance.adsdk.lottie.xv.w;

import com.bytedance.adsdk.lottie.c.c.t;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class fz implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f25838a;

    /* renamed from: b  reason: collision with root package name */
    private final c f25839b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25840c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25841d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25842e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f25843f;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        SIMULTANEOUSLY,
        INDIVIDUALLY;

        public static c c(int i4) {
            if (i4 != 1) {
                if (i4 == 2) {
                    return INDIVIDUALLY;
                }
                throw new IllegalArgumentException("Unknown trim path type " + i4);
            }
            return SIMULTANEOUSLY;
        }
    }

    public fz(String str, c cVar, com.bytedance.adsdk.lottie.xv.c.m mVar, com.bytedance.adsdk.lottie.xv.c.m mVar2, com.bytedance.adsdk.lottie.xv.c.m mVar3, boolean z3) {
        this.f25838a = str;
        this.f25839b = cVar;
        this.f25840c = mVar;
        this.f25841d = mVar2;
        this.f25842e = mVar3;
        this.f25843f = z3;
    }

    @Override // com.bytedance.adsdk.lottie.xv.w.l
    public t a(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar, com.bytedance.adsdk.lottie.xv.xv.a aVar) {
        return new com.bytedance.adsdk.lottie.c.c.i(aVar, this);
    }

    public String b() {
        return this.f25838a;
    }

    public com.bytedance.adsdk.lottie.xv.c.m c() {
        return this.f25842e;
    }

    public boolean d() {
        return this.f25843f;
    }

    public com.bytedance.adsdk.lottie.xv.c.m e() {
        return this.f25841d;
    }

    public com.bytedance.adsdk.lottie.xv.c.m f() {
        return this.f25840c;
    }

    public c getType() {
        return this.f25839b;
    }

    public String toString() {
        return "Trim Path: {start: " + this.f25840c + ", end: " + this.f25841d + ", offset: " + this.f25842e + "}";
    }
}
