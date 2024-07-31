package com.tencent.bugly.proguard;

import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.g */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12894g extends AbstractC12901m {

    /* renamed from: g */
    public byte[] f36875g;

    /* renamed from: i */
    public Map<String, String> f36877i;

    /* renamed from: j */
    public Map<String, String> f36878j;

    /* renamed from: m */
    static final /* synthetic */ boolean f36868m = true;

    /* renamed from: k */
    static byte[] f36866k = null;

    /* renamed from: l */
    static Map<String, String> f36867l = null;

    /* renamed from: a */
    public short f36869a = 0;

    /* renamed from: b */
    public byte f36870b = 0;

    /* renamed from: c */
    public int f36871c = 0;

    /* renamed from: d */
    public int f36872d = 0;

    /* renamed from: e */
    public String f36873e = null;

    /* renamed from: f */
    public String f36874f = null;

    /* renamed from: h */
    public int f36876h = 0;

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15578a(C12900l c12900l) {
        c12900l.m15590a(this.f36869a, 1);
        c12900l.m15602a(this.f36870b, 2);
        c12900l.m15598a(this.f36871c, 3);
        c12900l.m15598a(this.f36872d, 4);
        c12900l.m15593a(this.f36873e, 5);
        c12900l.m15593a(this.f36874f, 6);
        c12900l.m15588a(this.f36875g, 7);
        c12900l.m15598a(this.f36876h, 8);
        c12900l.m15591a((Map) this.f36877i, 9);
        c12900l.m15591a((Map) this.f36878j, 10);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f36868m) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        C12894g c12894g = (C12894g) obj;
        return C12902n.m15576a(1, (int) c12894g.f36869a) && C12902n.m15576a(1, (int) c12894g.f36870b) && C12902n.m15576a(1, c12894g.f36871c) && C12902n.m15576a(1, c12894g.f36872d) && C12902n.m15574a((Object) 1, (Object) c12894g.f36873e) && C12902n.m15574a((Object) 1, (Object) c12894g.f36874f) && C12902n.m15574a((Object) 1, (Object) c12894g.f36875g) && C12902n.m15576a(1, c12894g.f36876h) && C12902n.m15574a((Object) 1, (Object) c12894g.f36877i) && C12902n.m15574a((Object) 1, (Object) c12894g.f36878j);
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15579a(C12898k c12898k) {
        try {
            this.f36869a = c12898k.m15616a(this.f36869a, 1, true);
            this.f36870b = c12898k.m15631a(this.f36870b, 2, true);
            this.f36871c = c12898k.m15627a(this.f36871c, 3, true);
            this.f36872d = c12898k.m15627a(this.f36872d, 4, true);
            this.f36873e = c12898k.m15611b(5, true);
            this.f36874f = c12898k.m15611b(6, true);
            if (f36866k == null) {
                f36866k = new byte[]{0};
            }
            this.f36875g = c12898k.m15609c(7, true);
            this.f36876h = c12898k.m15627a(this.f36876h, 8, true);
            if (f36867l == null) {
                HashMap hashMap = new HashMap();
                f36867l = hashMap;
                hashMap.put("", "");
            }
            this.f36877i = (Map) c12898k.m15621a((C12898k) f36867l, 9, true);
            if (f36867l == null) {
                HashMap hashMap2 = new HashMap();
                f36867l = hashMap2;
                hashMap2.put("", "");
            }
            this.f36878j = (Map) c12898k.m15621a((C12898k) f36867l, 10, true);
        } catch (Exception e) {
            e.printStackTrace();
            PrintStream printStream = System.out;
            printStream.println("RequestPacket decode error " + C12893f.m15655a(this.f36875g));
            throw new RuntimeException(e);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15577a(StringBuilder sb, int i) {
        C12896i c12896i = new C12896i(sb, i);
        c12896i.m15642a(this.f36869a, "iVersion");
        c12896i.m15654a(this.f36870b, "cPacketType");
        c12896i.m15650a(this.f36871c, "iMessageType");
        c12896i.m15650a(this.f36872d, "iRequestId");
        c12896i.m15645a(this.f36873e, "sServantName");
        c12896i.m15645a(this.f36874f, "sFuncName");
        c12896i.m15640a(this.f36875g, "sBuffer");
        c12896i.m15650a(this.f36876h, "iTimeout");
        c12896i.m15643a((Map) this.f36877i, "context");
        c12896i.m15643a((Map) this.f36878j, "status");
    }
}
