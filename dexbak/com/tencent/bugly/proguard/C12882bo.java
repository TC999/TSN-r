package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bo */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12882bo extends AbstractC12901m {

    /* renamed from: A */
    static ArrayList<C12881bn> f36752A;

    /* renamed from: B */
    static Map<String, String> f36753B;

    /* renamed from: C */
    static Map<String, String> f36754C;

    /* renamed from: v */
    static Map<String, String> f36755v;

    /* renamed from: w */
    static C12880bm f36756w;

    /* renamed from: x */
    static C12879bl f36757x;

    /* renamed from: y */
    static ArrayList<C12879bl> f36758y;

    /* renamed from: z */
    static ArrayList<C12879bl> f36759z;

    /* renamed from: a */
    public String f36760a = "";

    /* renamed from: b */
    public long f36761b = 0;

    /* renamed from: c */
    public String f36762c = "";

    /* renamed from: d */
    public String f36763d = "";

    /* renamed from: e */
    public String f36764e = "";

    /* renamed from: f */
    public String f36765f = "";

    /* renamed from: g */
    public String f36766g = "";

    /* renamed from: h */
    public Map<String, String> f36767h = null;

    /* renamed from: i */
    public String f36768i = "";

    /* renamed from: j */
    public C12880bm f36769j = null;

    /* renamed from: k */
    public int f36770k = 0;

    /* renamed from: l */
    public String f36771l = "";

    /* renamed from: m */
    public String f36772m = "";

    /* renamed from: n */
    public C12879bl f36773n = null;

    /* renamed from: o */
    public ArrayList<C12879bl> f36774o = null;

    /* renamed from: p */
    public ArrayList<C12879bl> f36775p = null;

    /* renamed from: q */
    public ArrayList<C12881bn> f36776q = null;

    /* renamed from: r */
    public Map<String, String> f36777r = null;

    /* renamed from: s */
    public Map<String, String> f36778s = null;

    /* renamed from: t */
    public String f36779t = "";

    /* renamed from: u */
    public boolean f36780u = true;

    static {
        HashMap hashMap = new HashMap();
        f36755v = hashMap;
        hashMap.put("", "");
        f36756w = new C12880bm();
        f36757x = new C12879bl();
        f36758y = new ArrayList<>();
        f36758y.add(new C12879bl());
        f36759z = new ArrayList<>();
        f36759z.add(new C12879bl());
        f36752A = new ArrayList<>();
        f36752A.add(new C12881bn());
        HashMap hashMap2 = new HashMap();
        f36753B = hashMap2;
        hashMap2.put("", "");
        HashMap hashMap3 = new HashMap();
        f36754C = hashMap3;
        hashMap3.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15578a(C12900l c12900l) {
        c12900l.m15593a(this.f36760a, 0);
        c12900l.m15597a(this.f36761b, 1);
        c12900l.m15593a(this.f36762c, 2);
        String str = this.f36763d;
        if (str != null) {
            c12900l.m15593a(str, 3);
        }
        String str2 = this.f36764e;
        if (str2 != null) {
            c12900l.m15593a(str2, 4);
        }
        String str3 = this.f36765f;
        if (str3 != null) {
            c12900l.m15593a(str3, 5);
        }
        String str4 = this.f36766g;
        if (str4 != null) {
            c12900l.m15593a(str4, 6);
        }
        Map<String, String> map = this.f36767h;
        if (map != null) {
            c12900l.m15591a((Map) map, 7);
        }
        String str5 = this.f36768i;
        if (str5 != null) {
            c12900l.m15593a(str5, 8);
        }
        C12880bm c12880bm = this.f36769j;
        if (c12880bm != null) {
            c12900l.m15596a((AbstractC12901m) c12880bm, 9);
        }
        c12900l.m15598a(this.f36770k, 10);
        String str6 = this.f36771l;
        if (str6 != null) {
            c12900l.m15593a(str6, 11);
        }
        String str7 = this.f36772m;
        if (str7 != null) {
            c12900l.m15593a(str7, 12);
        }
        C12879bl c12879bl = this.f36773n;
        if (c12879bl != null) {
            c12900l.m15596a((AbstractC12901m) c12879bl, 13);
        }
        ArrayList<C12879bl> arrayList = this.f36774o;
        if (arrayList != null) {
            c12900l.m15592a((Collection) arrayList, 14);
        }
        ArrayList<C12879bl> arrayList2 = this.f36775p;
        if (arrayList2 != null) {
            c12900l.m15592a((Collection) arrayList2, 15);
        }
        ArrayList<C12881bn> arrayList3 = this.f36776q;
        if (arrayList3 != null) {
            c12900l.m15592a((Collection) arrayList3, 16);
        }
        Map<String, String> map2 = this.f36777r;
        if (map2 != null) {
            c12900l.m15591a((Map) map2, 17);
        }
        Map<String, String> map3 = this.f36778s;
        if (map3 != null) {
            c12900l.m15591a((Map) map3, 18);
        }
        String str8 = this.f36779t;
        if (str8 != null) {
            c12900l.m15593a(str8, 19);
        }
        c12900l.m15589a(this.f36780u, 20);
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15579a(C12898k c12898k) {
        this.f36760a = c12898k.m15611b(0, true);
        this.f36761b = c12898k.m15625a(this.f36761b, 1, true);
        this.f36762c = c12898k.m15611b(2, true);
        this.f36763d = c12898k.m15611b(3, false);
        this.f36764e = c12898k.m15611b(4, false);
        this.f36765f = c12898k.m15611b(5, false);
        this.f36766g = c12898k.m15611b(6, false);
        this.f36767h = (Map) c12898k.m15621a((C12898k) f36755v, 7, false);
        this.f36768i = c12898k.m15611b(8, false);
        this.f36769j = (C12880bm) c12898k.m15622a((AbstractC12901m) f36756w, 9, false);
        this.f36770k = c12898k.m15627a(this.f36770k, 10, false);
        this.f36771l = c12898k.m15611b(11, false);
        this.f36772m = c12898k.m15611b(12, false);
        this.f36773n = (C12879bl) c12898k.m15622a((AbstractC12901m) f36757x, 13, false);
        this.f36774o = (ArrayList) c12898k.m15621a((C12898k) f36758y, 14, false);
        this.f36775p = (ArrayList) c12898k.m15621a((C12898k) f36759z, 15, false);
        this.f36776q = (ArrayList) c12898k.m15621a((C12898k) f36752A, 16, false);
        this.f36777r = (Map) c12898k.m15621a((C12898k) f36753B, 17, false);
        this.f36778s = (Map) c12898k.m15621a((C12898k) f36754C, 18, false);
        this.f36779t = c12898k.m15611b(19, false);
        this.f36780u = c12898k.m15626a(20, false);
    }
}
