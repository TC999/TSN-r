package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bt extends m implements Cloneable {

    /* renamed from: n  reason: collision with root package name */
    static Map<String, String> f51189n;

    /* renamed from: a  reason: collision with root package name */
    public boolean f51191a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51192b = true;

    /* renamed from: c  reason: collision with root package name */
    public boolean f51193c = true;

    /* renamed from: d  reason: collision with root package name */
    public String f51194d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f51195e = "";

    /* renamed from: f  reason: collision with root package name */
    public bs f51196f = null;

    /* renamed from: g  reason: collision with root package name */
    public Map<String, String> f51197g = null;

    /* renamed from: h  reason: collision with root package name */
    public long f51198h = 0;

    /* renamed from: i  reason: collision with root package name */
    public String f51199i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f51200j = "";

    /* renamed from: k  reason: collision with root package name */
    public int f51201k = 0;

    /* renamed from: l  reason: collision with root package name */
    public int f51202l = 0;

    /* renamed from: o  reason: collision with root package name */
    static final /* synthetic */ boolean f51190o = true;

    /* renamed from: m  reason: collision with root package name */
    static bs f51188m = new bs();

    static {
        HashMap hashMap = new HashMap();
        f51189n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f51191a, 0);
        lVar.a(this.f51192b, 1);
        lVar.a(this.f51193c, 2);
        String str = this.f51194d;
        if (str != null) {
            lVar.a(str, 3);
        }
        String str2 = this.f51195e;
        if (str2 != null) {
            lVar.a(str2, 4);
        }
        bs bsVar = this.f51196f;
        if (bsVar != null) {
            lVar.a((m) bsVar, 5);
        }
        Map<String, String> map = this.f51197g;
        if (map != null) {
            lVar.a((Map) map, 6);
        }
        lVar.a(this.f51198h, 7);
        String str3 = this.f51199i;
        if (str3 != null) {
            lVar.a(str3, 8);
        }
        String str4 = this.f51200j;
        if (str4 != null) {
            lVar.a(str4, 9);
        }
        lVar.a(this.f51201k, 10);
        lVar.a(this.f51202l, 11);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f51190o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        bt btVar = (bt) obj;
        return n.a(this.f51191a, btVar.f51191a) && n.a(this.f51192b, btVar.f51192b) && n.a(this.f51193c, btVar.f51193c) && n.a(this.f51194d, btVar.f51194d) && n.a(this.f51195e, btVar.f51195e) && n.a(this.f51196f, btVar.f51196f) && n.a(this.f51197g, btVar.f51197g) && n.a(this.f51198h, btVar.f51198h) && n.a(this.f51199i, btVar.f51199i) && n.a(this.f51200j, btVar.f51200j) && n.a(this.f51201k, btVar.f51201k) && n.a(this.f51202l, btVar.f51202l);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f51191a = kVar.a(0, true);
        this.f51192b = kVar.a(1, true);
        this.f51193c = kVar.a(2, true);
        this.f51194d = kVar.b(3, false);
        this.f51195e = kVar.b(4, false);
        this.f51196f = (bs) kVar.a((m) f51188m, 5, false);
        this.f51197g = (Map) kVar.a((k) f51189n, 6, false);
        this.f51198h = kVar.a(this.f51198h, 7, false);
        this.f51199i = kVar.b(8, false);
        this.f51200j = kVar.b(9, false);
        this.f51201k = kVar.a(this.f51201k, 10, false);
        this.f51202l = kVar.a(this.f51202l, 11, false);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i4) {
        i iVar = new i(sb, i4);
        iVar.a(this.f51191a, "enable");
        iVar.a(this.f51192b, "enableUserInfo");
        iVar.a(this.f51193c, "enableQuery");
        iVar.a(this.f51194d, "url");
        iVar.a(this.f51195e, "expUrl");
        iVar.a((m) this.f51196f, "security");
        iVar.a((Map) this.f51197g, "valueMap");
        iVar.a(this.f51198h, "strategylastUpdateTime");
        iVar.a(this.f51199i, "httpsUrl");
        iVar.a(this.f51200j, "httpsExpUrl");
        iVar.a(this.f51201k, "eventRecordCount");
        iVar.a(this.f51202l, "eventTimeInterval");
    }
}
