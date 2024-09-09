package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bo extends m {
    static ArrayList<bn> A;
    static Map<String, String> B;
    static Map<String, String> C;

    /* renamed from: v  reason: collision with root package name */
    static Map<String, String> f51122v;

    /* renamed from: w  reason: collision with root package name */
    static bm f51123w;

    /* renamed from: x  reason: collision with root package name */
    static bl f51124x;

    /* renamed from: y  reason: collision with root package name */
    static ArrayList<bl> f51125y;

    /* renamed from: z  reason: collision with root package name */
    static ArrayList<bl> f51126z;

    /* renamed from: a  reason: collision with root package name */
    public String f51127a = "";

    /* renamed from: b  reason: collision with root package name */
    public long f51128b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f51129c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f51130d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f51131e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f51132f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f51133g = "";

    /* renamed from: h  reason: collision with root package name */
    public Map<String, String> f51134h = null;

    /* renamed from: i  reason: collision with root package name */
    public String f51135i = "";

    /* renamed from: j  reason: collision with root package name */
    public bm f51136j = null;

    /* renamed from: k  reason: collision with root package name */
    public int f51137k = 0;

    /* renamed from: l  reason: collision with root package name */
    public String f51138l = "";

    /* renamed from: m  reason: collision with root package name */
    public String f51139m = "";

    /* renamed from: n  reason: collision with root package name */
    public bl f51140n = null;

    /* renamed from: o  reason: collision with root package name */
    public ArrayList<bl> f51141o = null;

    /* renamed from: p  reason: collision with root package name */
    public ArrayList<bl> f51142p = null;

    /* renamed from: q  reason: collision with root package name */
    public ArrayList<bn> f51143q = null;

    /* renamed from: r  reason: collision with root package name */
    public Map<String, String> f51144r = null;

    /* renamed from: s  reason: collision with root package name */
    public Map<String, String> f51145s = null;

    /* renamed from: t  reason: collision with root package name */
    public String f51146t = "";

    /* renamed from: u  reason: collision with root package name */
    public boolean f51147u = true;

    static {
        HashMap hashMap = new HashMap();
        f51122v = hashMap;
        hashMap.put("", "");
        f51123w = new bm();
        f51124x = new bl();
        f51125y = new ArrayList<>();
        f51125y.add(new bl());
        f51126z = new ArrayList<>();
        f51126z.add(new bl());
        A = new ArrayList<>();
        A.add(new bn());
        HashMap hashMap2 = new HashMap();
        B = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        C = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f51127a, 0);
        lVar.a(this.f51128b, 1);
        lVar.a(this.f51129c, 2);
        String str = this.f51130d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f51131e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        String str3 = this.f51132f;
        if (str3 != null) {
            lVar.a(str3, 5);
        }
        String str4 = this.f51133g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        Map<String, String> map = this.f51134h;
        if (map != null) {
            lVar.a((Map) map, 7);
        }
        String str5 = this.f51135i;
        if (str5 != null) {
            lVar.a(str5, 8);
        }
        bm bmVar = this.f51136j;
        if (bmVar != null) {
            lVar.a((m) bmVar, 9);
        }
        lVar.a(this.f51137k, 10);
        String str6 = this.f51138l;
        if (str6 != null) {
            lVar.a(str6, 11);
        }
        String str7 = this.f51139m;
        if (str7 != null) {
            lVar.a(str7, 12);
        }
        bl blVar = this.f51140n;
        if (blVar != null) {
            lVar.a((m) blVar, 13);
        }
        ArrayList<bl> arrayList = this.f51141o;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 14);
        }
        ArrayList<bl> arrayList2 = this.f51142p;
        if (arrayList2 != null) {
            lVar.a((Collection) arrayList2, 15);
        }
        ArrayList<bn> arrayList3 = this.f51143q;
        if (arrayList3 != null) {
            lVar.a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f51144r;
        if (map2 != null) {
            lVar.a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f51145s;
        if (map3 != null) {
            lVar.a((Map) map3, 18);
        }
        String str8 = this.f51146t;
        if (str8 != null) {
            lVar.a(str8, 19);
        }
        lVar.a(this.f51147u, 20);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f51127a = kVar.b(0, true);
        this.f51128b = kVar.a(this.f51128b, 1, true);
        this.f51129c = kVar.b(2, true);
        this.f51130d = kVar.b(3, false);
        this.f51131e = kVar.b(4, false);
        this.f51132f = kVar.b(5, false);
        this.f51133g = kVar.b(6, false);
        this.f51134h = (Map) kVar.a((k) f51122v, 7, false);
        this.f51135i = kVar.b(8, false);
        this.f51136j = (bm) kVar.a((m) f51123w, 9, false);
        this.f51137k = kVar.a(this.f51137k, 10, false);
        this.f51138l = kVar.b(11, false);
        this.f51139m = kVar.b(12, false);
        this.f51140n = (bl) kVar.a((m) f51124x, 13, false);
        this.f51141o = (ArrayList) kVar.a((k) f51125y, 14, false);
        this.f51142p = (ArrayList) kVar.a((k) f51126z, 15, false);
        this.f51143q = (ArrayList) kVar.a((k) A, 16, false);
        this.f51144r = (Map) kVar.a((k) B, 17, false);
        this.f51145s = (Map) kVar.a((k) C, 18, false);
        this.f51146t = kVar.b(19, false);
        this.f51147u = kVar.a(20, false);
    }
}
