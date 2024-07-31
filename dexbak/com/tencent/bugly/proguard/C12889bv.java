package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bv */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12889bv extends AbstractC12901m implements Cloneable {

    /* renamed from: f */
    static ArrayList<C12888bu> f36845f;

    /* renamed from: g */
    static Map<String, String> f36846g;

    /* renamed from: a */
    public byte f36847a = 0;

    /* renamed from: b */
    public String f36848b = "";

    /* renamed from: c */
    public String f36849c = "";

    /* renamed from: d */
    public ArrayList<C12888bu> f36850d = null;

    /* renamed from: e */
    public Map<String, String> f36851e = null;

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15578a(C12900l c12900l) {
        c12900l.m15602a(this.f36847a, 0);
        String str = this.f36848b;
        if (str != null) {
            c12900l.m15593a(str, 1);
        }
        String str2 = this.f36849c;
        if (str2 != null) {
            c12900l.m15593a(str2, 2);
        }
        ArrayList<C12888bu> arrayList = this.f36850d;
        if (arrayList != null) {
            c12900l.m15592a((Collection) arrayList, 3);
        }
        Map<String, String> map = this.f36851e;
        if (map != null) {
            c12900l.m15591a((Map) map, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15577a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15579a(C12898k c12898k) {
        this.f36847a = c12898k.m15631a(this.f36847a, 0, true);
        this.f36848b = c12898k.m15611b(1, false);
        this.f36849c = c12898k.m15611b(2, false);
        if (f36845f == null) {
            f36845f = new ArrayList<>();
            f36845f.add(new C12888bu());
        }
        this.f36850d = (ArrayList) c12898k.m15621a((C12898k) f36845f, 3, false);
        if (f36846g == null) {
            HashMap hashMap = new HashMap();
            f36846g = hashMap;
            hashMap.put("", "");
        }
        this.f36851e = (Map) c12898k.m15621a((C12898k) f36846g, 4, false);
    }
}
