package com.bytedance.adsdk.lottie.xv.w;

import com.bytedance.adsdk.lottie.c.c.t;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class gd implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f25851a;

    /* renamed from: b  reason: collision with root package name */
    private final c f25852b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f25853c;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static c c(int i4) {
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        if (i4 != 4) {
                            if (i4 != 5) {
                                return MERGE;
                            }
                            return EXCLUDE_INTERSECTIONS;
                        }
                        return INTERSECT;
                    }
                    return SUBTRACT;
                }
                return ADD;
            }
            return MERGE;
        }
    }

    public gd(String str, c cVar, boolean z3) {
        this.f25851a = str;
        this.f25852b = cVar;
        this.f25853c = z3;
    }

    @Override // com.bytedance.adsdk.lottie.xv.w.l
    public t a(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar, com.bytedance.adsdk.lottie.xv.xv.a aVar) {
        if (!dVar.w()) {
            com.bytedance.adsdk.lottie.f.e.c("Animation contains merge paths but they are disabled.");
            return null;
        }
        return new com.bytedance.adsdk.lottie.c.c.a(this);
    }

    public String b() {
        return this.f25851a;
    }

    public c c() {
        return this.f25852b;
    }

    public boolean d() {
        return this.f25853c;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f25852b + '}';
    }
}
