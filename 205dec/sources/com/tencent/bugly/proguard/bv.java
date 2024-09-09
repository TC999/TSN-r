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
public final class bv extends m implements Cloneable {

    /* renamed from: f  reason: collision with root package name */
    static ArrayList<bu> f51212f;

    /* renamed from: g  reason: collision with root package name */
    static Map<String, String> f51213g;

    /* renamed from: a  reason: collision with root package name */
    public byte f51214a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String f51215b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f51216c = "";

    /* renamed from: d  reason: collision with root package name */
    public ArrayList<bu> f51217d = null;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f51218e = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f51214a, 0);
        String str = this.f51215b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f51216c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        ArrayList<bu> arrayList = this.f51217d;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f51218e;
        if (map != null) {
            lVar.a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i4) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f51214a = kVar.a(this.f51214a, 0, true);
        this.f51215b = kVar.b(1, false);
        this.f51216c = kVar.b(2, false);
        if (f51212f == null) {
            f51212f = new ArrayList<>();
            f51212f.add(new bu());
        }
        this.f51217d = (ArrayList) kVar.a((k) f51212f, 3, false);
        if (f51213g == null) {
            HashMap hashMap = new HashMap();
            f51213g = hashMap;
            hashMap.put("", "");
        }
        this.f51218e = (Map) kVar.a((k) f51213g, 4, false);
    }
}
