package com.bytedance.adsdk.lottie.xv.xv;

import com.bytedance.adsdk.lottie.n;
import com.bytedance.adsdk.lottie.s;
import com.bytedance.adsdk.lottie.xv.c.h;
import com.bytedance.adsdk.lottie.xv.c.m;
import com.bytedance.adsdk.lottie.xv.w.ev;
import com.bytedance.adsdk.lottie.xv.w.l;
import java.util.List;
import java.util.Locale;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class sr {

    /* renamed from: a  reason: collision with root package name */
    private final List<l> f25950a;

    /* renamed from: b  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.e f25951b;

    /* renamed from: c  reason: collision with root package name */
    private final String f25952c;

    /* renamed from: d  reason: collision with root package name */
    private final long f25953d;

    /* renamed from: e  reason: collision with root package name */
    private final c f25954e;

    /* renamed from: f  reason: collision with root package name */
    private final long f25955f;

    /* renamed from: g  reason: collision with root package name */
    private final String f25956g;

    /* renamed from: h  reason: collision with root package name */
    private final List<ev> f25957h;

    /* renamed from: i  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.a f25958i;

    /* renamed from: j  reason: collision with root package name */
    private final int f25959j;

    /* renamed from: k  reason: collision with root package name */
    private final int f25960k;

    /* renamed from: l  reason: collision with root package name */
    private final int f25961l;

    /* renamed from: m  reason: collision with root package name */
    private final float f25962m;

    /* renamed from: n  reason: collision with root package name */
    private final float f25963n;

    /* renamed from: o  reason: collision with root package name */
    private final float f25964o;

    /* renamed from: p  reason: collision with root package name */
    private final float f25965p;

    /* renamed from: q  reason: collision with root package name */
    private final h f25966q;

    /* renamed from: r  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.c.g f25967r;

    /* renamed from: s  reason: collision with root package name */
    private final m f25968s;

    /* renamed from: t  reason: collision with root package name */
    private final List<n.h<Float>> f25969t;

    /* renamed from: u  reason: collision with root package name */
    private final w f25970u;

    /* renamed from: v  reason: collision with root package name */
    private final boolean f25971v;

    /* renamed from: w  reason: collision with root package name */
    private final com.bytedance.adsdk.lottie.xv.w.c f25972w;

    /* renamed from: x  reason: collision with root package name */
    private final s.w f25973x;

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum c {
        PRE_COMP,
        SOLID,
        IMAGE,
        NULL,
        SHAPE,
        TEXT,
        UNKNOWN
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public enum w {
        NONE,
        ADD,
        INVERT,
        LUMA,
        LUMA_INVERTED,
        UNKNOWN
    }

    public sr(List<l> list, com.bytedance.adsdk.lottie.e eVar, String str, long j4, c cVar, long j5, String str2, List<ev> list2, com.bytedance.adsdk.lottie.xv.c.a aVar, int i4, int i5, int i6, float f4, float f5, float f6, float f7, h hVar, com.bytedance.adsdk.lottie.xv.c.g gVar, List<n.h<Float>> list3, w wVar, m mVar, boolean z3, com.bytedance.adsdk.lottie.xv.w.c cVar2, s.w wVar2) {
        this.f25950a = list;
        this.f25951b = eVar;
        this.f25952c = str;
        this.f25953d = j4;
        this.f25954e = cVar;
        this.f25955f = j5;
        this.f25956g = str2;
        this.f25957h = list2;
        this.f25958i = aVar;
        this.f25959j = i4;
        this.f25960k = i5;
        this.f25961l = i6;
        this.f25962m = f4;
        this.f25963n = f5;
        this.f25964o = f6;
        this.f25965p = f7;
        this.f25966q = hVar;
        this.f25967r = gVar;
        this.f25969t = list3;
        this.f25970u = wVar;
        this.f25968s = mVar;
        this.f25971v = z3;
        this.f25972w = cVar2;
        this.f25973x = wVar2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public w a() {
        return this.f25970u;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long b() {
        return this.f25955f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.adsdk.lottie.e c() {
        return this.f25951b;
    }

    public String d(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(f());
        sb.append("\n");
        sr d4 = this.f25951b.d(b());
        if (d4 != null) {
            sb.append("\t\tParents: ");
            sb.append(d4.f());
            sr d5 = this.f25951b.d(d4.b());
            while (d5 != null) {
                sb.append("->");
                sb.append(d5.f());
                d5 = this.f25951b.d(d5.b());
            }
            sb.append(str);
            sb.append("\n");
        }
        if (!o().isEmpty()) {
            sb.append(str);
            sb.append("\tMasks: ");
            sb.append(o().size());
            sb.append("\n");
        }
        if (r() != 0 && k() != 0) {
            sb.append(str);
            sb.append("\tBackground: ");
            sb.append(String.format(Locale.US, "%dx%d %X\n", Integer.valueOf(r()), Integer.valueOf(k()), Integer.valueOf(g())));
        }
        if (!this.f25950a.isEmpty()) {
            sb.append(str);
            sb.append("\tShapes:\n");
            for (l lVar : this.f25950a) {
                sb.append(str);
                sb.append("\t\t");
                sb.append(lVar);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float e() {
        return this.f25964o;
    }

    public String f() {
        return this.f25952c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int g() {
        return this.f25961l;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public h h() {
        return this.f25966q;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float i() {
        return this.f25965p;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public m j() {
        return this.f25968s;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int k() {
        return this.f25960k;
    }

    public com.bytedance.adsdk.lottie.xv.w.c l() {
        return this.f25972w;
    }

    public c m() {
        return this.f25954e;
    }

    public s.w n() {
        return this.f25973x;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ev> o() {
        return this.f25957h;
    }

    public boolean p() {
        return this.f25971v;
    }

    public String q() {
        return this.f25956g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int r() {
        return this.f25959j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<n.h<Float>> s() {
        return this.f25969t;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<l> t() {
        return this.f25950a;
    }

    public String toString() {
        return d("");
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.adsdk.lottie.xv.c.g u() {
        return this.f25967r;
    }

    public long v() {
        return this.f25953d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float w() {
        return this.f25962m;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public float x() {
        return this.f25963n / this.f25951b.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public com.bytedance.adsdk.lottie.xv.c.a y() {
        return this.f25958i;
    }
}
