package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bu extends m {

    /* renamed from: i  reason: collision with root package name */
    static Map<String, String> f51203i;

    /* renamed from: a  reason: collision with root package name */
    public long f51204a = 0;

    /* renamed from: b  reason: collision with root package name */
    public byte f51205b = 0;

    /* renamed from: c  reason: collision with root package name */
    public String f51206c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f51207d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f51208e = "";

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f51209f = null;

    /* renamed from: g  reason: collision with root package name */
    public String f51210g = "";

    /* renamed from: h  reason: collision with root package name */
    public boolean f51211h = true;

    static {
        HashMap hashMap = new HashMap();
        f51203i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f51204a, 0);
        lVar.a(this.f51205b, 1);
        String str = this.f51206c;
        if (str != null) {
            lVar.a(str, 2);
        }
        String str2 = this.f51207d;
        if (str2 != null) {
            lVar.a(str2, 3);
        }
        String str3 = this.f51208e;
        if (str3 != null) {
            lVar.a(str3, 4);
        }
        Map<String, String> map = this.f51209f;
        if (map != null) {
            lVar.a((Map) map, 5);
        }
        String str4 = this.f51210g;
        if (str4 != null) {
            lVar.a(str4, 6);
        }
        lVar.a(this.f51211h, 7);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f51204a = kVar.a(this.f51204a, 0, true);
        this.f51205b = kVar.a(this.f51205b, 1, true);
        this.f51206c = kVar.b(2, false);
        this.f51207d = kVar.b(3, false);
        this.f51208e = kVar.b(4, false);
        this.f51209f = (Map) kVar.a((k) f51203i, 5, false);
        this.f51210g = kVar.b(6, false);
        this.f51211h = kVar.a(7, false);
    }
}
