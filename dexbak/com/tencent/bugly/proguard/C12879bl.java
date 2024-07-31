package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12879bl extends AbstractC12901m implements Cloneable {

    /* renamed from: a */
    public String f36740a = "";

    /* renamed from: b */
    public String f36741b = "";

    /* renamed from: c */
    public String f36742c = "";

    /* renamed from: d */
    public String f36743d = "";

    /* renamed from: e */
    public String f36744e = "";

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15578a(C12900l c12900l) {
        c12900l.m15593a(this.f36740a, 0);
        String str = this.f36741b;
        if (str != null) {
            c12900l.m15593a(str, 1);
        }
        String str2 = this.f36742c;
        if (str2 != null) {
            c12900l.m15593a(str2, 2);
        }
        String str3 = this.f36743d;
        if (str3 != null) {
            c12900l.m15593a(str3, 3);
        }
        String str4 = this.f36744e;
        if (str4 != null) {
            c12900l.m15593a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15577a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15579a(C12898k c12898k) {
        this.f36740a = c12898k.m15611b(0, true);
        this.f36741b = c12898k.m15611b(1, false);
        this.f36742c = c12898k.m15611b(2, false);
        this.f36743d = c12898k.m15611b(3, false);
        this.f36744e = c12898k.m15611b(4, false);
    }
}
