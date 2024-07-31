package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.br */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12885br extends AbstractC12901m {

    /* renamed from: i */
    static byte[] f36809i;

    /* renamed from: j */
    static Map<String, String> f36810j;

    /* renamed from: a */
    public byte f36811a = 0;

    /* renamed from: b */
    public int f36812b = 0;

    /* renamed from: c */
    public byte[] f36813c = null;

    /* renamed from: d */
    public String f36814d = "";

    /* renamed from: e */
    public long f36815e = 0;

    /* renamed from: f */
    public String f36816f = "";

    /* renamed from: g */
    public String f36817g = "";

    /* renamed from: h */
    public Map<String, String> f36818h = null;

    static {
        f36809i = r0;
        byte[] bArr = {0};
        HashMap hashMap = new HashMap();
        f36810j = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15578a(C12900l c12900l) {
        c12900l.m15602a(this.f36811a, 0);
        c12900l.m15598a(this.f36812b, 1);
        byte[] bArr = this.f36813c;
        if (bArr != null) {
            c12900l.m15588a(bArr, 2);
        }
        String str = this.f36814d;
        if (str != null) {
            c12900l.m15593a(str, 3);
        }
        c12900l.m15597a(this.f36815e, 4);
        String str2 = this.f36816f;
        if (str2 != null) {
            c12900l.m15593a(str2, 5);
        }
        String str3 = this.f36817g;
        if (str3 != null) {
            c12900l.m15593a(str3, 6);
        }
        Map<String, String> map = this.f36818h;
        if (map != null) {
            c12900l.m15591a((Map) map, 7);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15579a(C12898k c12898k) {
        this.f36811a = c12898k.m15631a(this.f36811a, 0, true);
        this.f36812b = c12898k.m15627a(this.f36812b, 1, true);
        this.f36813c = c12898k.m15609c(2, false);
        this.f36814d = c12898k.m15611b(3, false);
        this.f36815e = c12898k.m15625a(this.f36815e, 4, false);
        this.f36816f = c12898k.m15611b(5, false);
        this.f36817g = c12898k.m15611b(6, false);
        this.f36818h = (Map) c12898k.m15621a((C12898k) f36810j, 7, false);
    }
}
