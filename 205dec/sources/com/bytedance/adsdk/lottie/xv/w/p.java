package com.bytedance.adsdk.lottie.xv.w;

import android.graphics.PointF;
import com.bytedance.adsdk.lottie.c.c.t;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class p implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f25883a;

    /* renamed from: b  reason: collision with root package name */
    private final c f25884b;

    /* renamed from: c  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25885c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> f25886d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25887e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25888f;

    /* renamed from: g  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25889g;

    /* renamed from: h  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25890h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25891i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f25892j;

    /* renamed from: k  reason: collision with root package name */
    private final boolean f25893k;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        STAR(1),
        POLYGON(2);
        
        private final int xv;

        c(int i4) {
            this.xv = i4;
        }

        public static c c(int i4) {
            c[] values;
            for (c cVar : values()) {
                if (cVar.xv == i4) {
                    return cVar;
                }
            }
            return null;
        }
    }

    public p(String str, c cVar, com.bytedance.adsdk.lottie.xv.c.m mVar, com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> bVar, com.bytedance.adsdk.lottie.xv.c.m mVar2, com.bytedance.adsdk.lottie.xv.c.m mVar3, com.bytedance.adsdk.lottie.xv.c.m mVar4, com.bytedance.adsdk.lottie.xv.c.m mVar5, com.bytedance.adsdk.lottie.xv.c.m mVar6, boolean z3, boolean z4) {
        this.f25883a = str;
        this.f25884b = cVar;
        this.f25885c = mVar;
        this.f25886d = bVar;
        this.f25887e = mVar2;
        this.f25888f = mVar3;
        this.f25889g = mVar4;
        this.f25890h = mVar5;
        this.f25891i = mVar6;
        this.f25892j = z3;
        this.f25893k = z4;
    }

    @Override // com.bytedance.adsdk.lottie.xv.w.l
    public t a(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar, com.bytedance.adsdk.lottie.xv.xv.a aVar) {
        return new com.bytedance.adsdk.lottie.c.c.p(dVar, aVar, this);
    }

    public String b() {
        return this.f25883a;
    }

    public com.bytedance.adsdk.lottie.xv.c.m c() {
        return this.f25891i;
    }

    public com.bytedance.adsdk.lottie.xv.c.m d() {
        return this.f25889g;
    }

    public boolean e() {
        return this.f25892j;
    }

    public boolean f() {
        return this.f25893k;
    }

    public com.bytedance.adsdk.lottie.xv.c.m g() {
        return this.f25890h;
    }

    public c getType() {
        return this.f25884b;
    }

    public com.bytedance.adsdk.lottie.xv.c.m h() {
        return this.f25887e;
    }

    public com.bytedance.adsdk.lottie.xv.c.m i() {
        return this.f25888f;
    }

    public com.bytedance.adsdk.lottie.xv.c.m j() {
        return this.f25885c;
    }

    public com.bytedance.adsdk.lottie.xv.c.b<PointF, PointF> k() {
        return this.f25886d;
    }
}
