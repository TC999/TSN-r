package com.tencent.bugly.proguard;

import java.util.HashMap;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bt */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12887bt extends AbstractC12901m implements Cloneable {

    /* renamed from: n */
    static Map<String, String> f36822n;

    /* renamed from: a */
    public boolean f36824a = true;

    /* renamed from: b */
    public boolean f36825b = true;

    /* renamed from: c */
    public boolean f36826c = true;

    /* renamed from: d */
    public String f36827d = "";

    /* renamed from: e */
    public String f36828e = "";

    /* renamed from: f */
    public C12886bs f36829f = null;

    /* renamed from: g */
    public Map<String, String> f36830g = null;

    /* renamed from: h */
    public long f36831h = 0;

    /* renamed from: i */
    public String f36832i = "";

    /* renamed from: j */
    public String f36833j = "";

    /* renamed from: k */
    public int f36834k = 0;

    /* renamed from: l */
    public int f36835l = 0;

    /* renamed from: o */
    static final /* synthetic */ boolean f36823o = true;

    /* renamed from: m */
    static C12886bs f36821m = new C12886bs();

    static {
        HashMap hashMap = new HashMap();
        f36822n = hashMap;
        hashMap.put("", "");
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15578a(C12900l c12900l) {
        c12900l.m15589a(this.f36824a, 0);
        c12900l.m15589a(this.f36825b, 1);
        c12900l.m15589a(this.f36826c, 2);
        String str = this.f36827d;
        if (str != null) {
            c12900l.m15593a(str, 3);
        }
        String str2 = this.f36828e;
        if (str2 != null) {
            c12900l.m15593a(str2, 4);
        }
        C12886bs c12886bs = this.f36829f;
        if (c12886bs != null) {
            c12900l.m15596a((AbstractC12901m) c12886bs, 5);
        }
        Map<String, String> map = this.f36830g;
        if (map != null) {
            c12900l.m15591a((Map) map, 6);
        }
        c12900l.m15597a(this.f36831h, 7);
        String str3 = this.f36832i;
        if (str3 != null) {
            c12900l.m15593a(str3, 8);
        }
        String str4 = this.f36833j;
        if (str4 != null) {
            c12900l.m15593a(str4, 9);
        }
        c12900l.m15598a(this.f36834k, 10);
        c12900l.m15598a(this.f36835l, 11);
    }

    public final Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            if (f36823o) {
                return null;
            }
            throw new AssertionError();
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        C12887bt c12887bt = (C12887bt) obj;
        return C12902n.m15572a(this.f36824a, c12887bt.f36824a) && C12902n.m15572a(this.f36825b, c12887bt.f36825b) && C12902n.m15572a(this.f36826c, c12887bt.f36826c) && C12902n.m15574a(this.f36827d, c12887bt.f36827d) && C12902n.m15574a(this.f36828e, c12887bt.f36828e) && C12902n.m15574a(this.f36829f, c12887bt.f36829f) && C12902n.m15574a(this.f36830g, c12887bt.f36830g) && C12902n.m15575a(this.f36831h, c12887bt.f36831h) && C12902n.m15574a(this.f36832i, c12887bt.f36832i) && C12902n.m15574a(this.f36833j, c12887bt.f36833j) && C12902n.m15576a(this.f36834k, c12887bt.f36834k) && C12902n.m15576a(this.f36835l, c12887bt.f36835l);
    }

    public final int hashCode() {
        try {
            throw new Exception("Need define key first!");
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15579a(C12898k c12898k) {
        this.f36824a = c12898k.m15626a(0, true);
        this.f36825b = c12898k.m15626a(1, true);
        this.f36826c = c12898k.m15626a(2, true);
        this.f36827d = c12898k.m15611b(3, false);
        this.f36828e = c12898k.m15611b(4, false);
        this.f36829f = (C12886bs) c12898k.m15622a((AbstractC12901m) f36821m, 5, false);
        this.f36830g = (Map) c12898k.m15621a((C12898k) f36822n, 6, false);
        this.f36831h = c12898k.m15625a(this.f36831h, 7, false);
        this.f36832i = c12898k.m15611b(8, false);
        this.f36833j = c12898k.m15611b(9, false);
        this.f36834k = c12898k.m15627a(this.f36834k, 10, false);
        this.f36835l = c12898k.m15627a(this.f36835l, 11, false);
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15577a(StringBuilder sb, int i) {
        C12896i c12896i = new C12896i(sb, i);
        c12896i.m15641a(this.f36824a, "enable");
        c12896i.m15641a(this.f36825b, "enableUserInfo");
        c12896i.m15641a(this.f36826c, "enableQuery");
        c12896i.m15645a(this.f36827d, "url");
        c12896i.m15645a(this.f36828e, "expUrl");
        c12896i.m15648a((AbstractC12901m) this.f36829f, "security");
        c12896i.m15643a((Map) this.f36830g, "valueMap");
        c12896i.m15649a(this.f36831h, "strategylastUpdateTime");
        c12896i.m15645a(this.f36832i, "httpsUrl");
        c12896i.m15645a(this.f36833j, "httpsExpUrl");
        c12896i.m15650a(this.f36834k, "eventRecordCount");
        c12896i.m15650a(this.f36835l, "eventTimeInterval");
    }
}
