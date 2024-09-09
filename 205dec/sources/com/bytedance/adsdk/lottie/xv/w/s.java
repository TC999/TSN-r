package com.bytedance.adsdk.lottie.xv.w;

import android.graphics.Paint;
import com.bytedance.adsdk.lottie.c.c.q;
import com.bytedance.adsdk.lottie.c.c.t;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class s implements l {

    /* renamed from: a  reason: collision with root package name */
    private final String f25898a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25899b;

    /* renamed from: c  reason: collision with root package name */
    private final List<com.bytedance.adsdk.lottie.xv.c.m> f25900c;

    /* renamed from: d  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.c f25901d;

    /* renamed from: e  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.j f25902e;

    /* renamed from: f  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.m f25903f;

    /* renamed from: g  reason: collision with root package name */
    private final c f25904g;

    /* renamed from: h  reason: collision with root package name */
    private final w f25905h;

    /* renamed from: i  reason: collision with root package name */
    private final float f25906i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f25907j;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25908a;

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f25909b;

        static {
            int[] iArr = new int[w.values().length];
            f25909b = iArr;
            try {
                iArr[w.BEVEL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f25909b[w.MITER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f25909b[w.ROUND.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[c.values().length];
            f25908a = iArr2;
            try {
                iArr2[c.BUTT.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f25908a[c.ROUND.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f25908a[c.UNKNOWN.ordinal()] = 3;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        BUTT,
        ROUND,
        UNKNOWN;

        public Paint.Cap c() {
            int i4 = a.f25908a[ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    return Paint.Cap.SQUARE;
                }
                return Paint.Cap.ROUND;
            }
            return Paint.Cap.BUTT;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum w {
        MITER,
        ROUND,
        BEVEL;

        public Paint.Join c() {
            int i4 = a.f25909b[ordinal()];
            if (i4 != 1) {
                if (i4 != 2) {
                    if (i4 != 3) {
                        return null;
                    }
                    return Paint.Join.ROUND;
                }
                return Paint.Join.MITER;
            }
            return Paint.Join.BEVEL;
        }
    }

    public s(String str, com.bytedance.adsdk.lottie.xv.c.m mVar, List<com.bytedance.adsdk.lottie.xv.c.m> list, com.bytedance.adsdk.lottie.xv.c.c cVar, com.bytedance.adsdk.lottie.xv.c.j jVar, com.bytedance.adsdk.lottie.xv.c.m mVar2, c cVar2, w wVar, float f4, boolean z3) {
        this.f25898a = str;
        this.f25899b = mVar;
        this.f25900c = list;
        this.f25901d = cVar;
        this.f25902e = jVar;
        this.f25903f = mVar2;
        this.f25904g = cVar2;
        this.f25905h = wVar;
        this.f25906i = f4;
        this.f25907j = z3;
    }

    @Override // com.bytedance.adsdk.lottie.xv.w.l
    public t a(com.bytedance.adsdk.lottie.d dVar, com.bytedance.adsdk.lottie.e eVar, com.bytedance.adsdk.lottie.xv.xv.a aVar) {
        return new q(dVar, aVar, this);
    }

    public String b() {
        return this.f25898a;
    }

    public w c() {
        return this.f25905h;
    }

    public com.bytedance.adsdk.lottie.xv.c.m d() {
        return this.f25899b;
    }

    public float e() {
        return this.f25906i;
    }

    public boolean f() {
        return this.f25907j;
    }

    public c g() {
        return this.f25904g;
    }

    public com.bytedance.adsdk.lottie.xv.c.m h() {
        return this.f25903f;
    }

    public List<com.bytedance.adsdk.lottie.xv.c.m> i() {
        return this.f25900c;
    }

    public com.bytedance.adsdk.lottie.xv.c.c j() {
        return this.f25901d;
    }

    public com.bytedance.adsdk.lottie.xv.c.j k() {
        return this.f25902e;
    }
}
