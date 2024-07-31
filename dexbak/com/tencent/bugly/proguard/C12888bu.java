package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bu */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12888bu extends AbstractC12901m {

    /* renamed from: i */
    static Map<String, String> f36836i;

    /* renamed from: a */
    public long f36837a = 0;

    /* renamed from: b */
    public byte f36838b = 0;

    /* renamed from: c */
    public String f36839c = "";

    /* renamed from: d */
    public String f36840d = "";

    /* renamed from: e */
    public String f36841e = "";

    /* renamed from: f */
    public Map<String, String> f36842f = null;

    /* renamed from: g */
    public String f36843g = "";

    /* renamed from: h */
    public boolean f36844h = true;

    static {
        HashMap hashMap = new HashMap();
        f36836i = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15578a(C12900l c12900l) {
        c12900l.m15597a(this.f36837a, 0);
        c12900l.m15602a(this.f36838b, 1);
        String str = this.f36839c;
        if (str != null) {
            c12900l.m15593a(str, 2);
        }
        String str2 = this.f36840d;
        if (str2 != null) {
            c12900l.m15593a(str2, 3);
        }
        String str3 = this.f36841e;
        if (str3 != null) {
            c12900l.m15593a(str3, 4);
        }
        Map<String, String> map = this.f36842f;
        if (map != null) {
            c12900l.m15591a((Map) map, 5);
        }
        String str4 = this.f36843g;
        if (str4 != null) {
            c12900l.m15593a(str4, 6);
        }
        c12900l.m15589a(this.f36844h, 7);
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15579a(C12898k c12898k) {
        this.f36837a = c12898k.m15625a(this.f36837a, 0, true);
        this.f36838b = c12898k.m15631a(this.f36838b, 1, true);
        this.f36839c = c12898k.m15611b(2, false);
        this.f36840d = c12898k.m15611b(3, false);
        this.f36841e = c12898k.m15611b(4, false);
        this.f36842f = (Map) c12898k.m15621a((C12898k) f36836i, 5, false);
        this.f36843g = c12898k.m15611b(6, false);
        this.f36844h = c12898k.m15626a(7, false);
    }
}
