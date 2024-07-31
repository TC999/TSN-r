package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bp */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12883bp extends AbstractC12901m implements Cloneable {

    /* renamed from: b */
    static ArrayList<C12882bo> f36781b;

    /* renamed from: a */
    public ArrayList<C12882bo> f36782a = null;

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15578a(C12900l c12900l) {
        c12900l.m15592a((Collection) this.f36782a, 0);
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15577a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15579a(C12898k c12898k) {
        if (f36781b == null) {
            f36781b = new ArrayList<>();
            f36781b.add(new C12882bo());
        }
        this.f36782a = (ArrayList) c12898k.m15621a((C12898k) f36781b, 0, true);
    }
}
