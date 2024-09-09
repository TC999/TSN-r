package com.bytedance.adsdk.lottie;

import android.graphics.Rect;
import android.util.LongSparseArray;
import android.util.SparseArray;
import com.bytedance.adsdk.lottie.xv.xv.sr;
import com.bytedance.component.sdk.annotation.RestrictTo;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class e {

    /* renamed from: c  reason: collision with root package name */
    private Map<String, List<sr>> f25580c;

    /* renamed from: d  reason: collision with root package name */
    private Map<String, h> f25581d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, com.bytedance.adsdk.lottie.xv.f> f25582e;

    /* renamed from: f  reason: collision with root package name */
    private List<com.bytedance.adsdk.lottie.xv.b> f25583f;

    /* renamed from: g  reason: collision with root package name */
    private SparseArray<com.bytedance.adsdk.lottie.xv.d> f25584g;

    /* renamed from: h  reason: collision with root package name */
    private LongSparseArray<sr> f25585h;

    /* renamed from: i  reason: collision with root package name */
    private List<sr> f25586i;

    /* renamed from: j  reason: collision with root package name */
    private Rect f25587j;

    /* renamed from: k  reason: collision with root package name */
    private float f25588k;

    /* renamed from: l  reason: collision with root package name */
    private float f25589l;

    /* renamed from: m  reason: collision with root package name */
    private float f25590m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f25591n;

    /* renamed from: a  reason: collision with root package name */
    private final r f25578a = new r();

    /* renamed from: b  reason: collision with root package name */
    private final HashSet<String> f25579b = new HashSet<>();

    /* renamed from: o  reason: collision with root package name */
    private int f25592o = 0;

    public Map<String, h> a() {
        return this.f25581d;
    }

    public float b() {
        return this.f25589l - this.f25588k;
    }

    public float c(float f4) {
        return com.bytedance.adsdk.lottie.f.d.a(this.f25588k, this.f25589l, f4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public sr d(long j4) {
        return this.f25585h.get(j4);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void e(int i4) {
        this.f25592o += i4;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void f(Rect rect, float f4, float f5, float f6, List<sr> list, LongSparseArray<sr> longSparseArray, Map<String, List<sr>> map, Map<String, h> map2, SparseArray<com.bytedance.adsdk.lottie.xv.d> sparseArray, Map<String, com.bytedance.adsdk.lottie.xv.f> map3, List<com.bytedance.adsdk.lottie.xv.b> list2) {
        this.f25587j = rect;
        this.f25588k = f4;
        this.f25589l = f5;
        this.f25590m = f6;
        this.f25586i = list;
        this.f25585h = longSparseArray;
        this.f25580c = map;
        this.f25581d = map2;
        this.f25584g = sparseArray;
        this.f25582e = map3;
        this.f25583f = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void g(String str) {
        com.bytedance.adsdk.lottie.f.e.c(str);
        this.f25579b.add(str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void h(boolean z3) {
        this.f25591n = z3;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean i() {
        return this.f25591n;
    }

    public float j() {
        return this.f25590m;
    }

    public float k() {
        return this.f25588k;
    }

    public List<sr> l() {
        return this.f25586i;
    }

    public Map<String, com.bytedance.adsdk.lottie.xv.f> m() {
        return this.f25582e;
    }

    public SparseArray<com.bytedance.adsdk.lottie.xv.d> n() {
        return this.f25584g;
    }

    public float o() {
        return this.f25589l;
    }

    public Rect p() {
        return this.f25587j;
    }

    public float q() {
        return (b() / this.f25590m) * 1000.0f;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int r() {
        return this.f25592o;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<sr> s(String str) {
        return this.f25580c.get(str);
    }

    public void t(boolean z3) {
        this.f25578a.b(z3);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        for (sr srVar : this.f25586i) {
            sb.append(srVar.d("\t"));
        }
        return sb.toString();
    }

    public r u() {
        return this.f25578a;
    }

    public com.bytedance.adsdk.lottie.xv.b v(String str) {
        int size = this.f25583f.size();
        for (int i4 = 0; i4 < size; i4++) {
            com.bytedance.adsdk.lottie.xv.b bVar = this.f25583f.get(i4);
            if (bVar.a(str)) {
                return bVar;
            }
        }
        return null;
    }
}
