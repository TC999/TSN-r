package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.bm */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12880bm extends AbstractC12901m implements Cloneable {

    /* renamed from: c */
    static ArrayList<String> f36745c;

    /* renamed from: a */
    public String f36746a = "";

    /* renamed from: b */
    public ArrayList<String> f36747b = null;

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15578a(C12900l c12900l) {
        c12900l.m15593a(this.f36746a, 0);
        ArrayList<String> arrayList = this.f36747b;
        if (arrayList != null) {
            c12900l.m15592a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15577a(StringBuilder sb, int i) {
    }

    @Override // com.tencent.bugly.proguard.AbstractC12901m
    /* renamed from: a */
    public final void mo15579a(C12898k c12898k) {
        this.f36746a = c12898k.m15611b(0, true);
        if (f36745c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f36745c = arrayList;
            arrayList.add("");
        }
        this.f36747b = (ArrayList) c12898k.m15621a((C12898k) f36745c, 1, false);
    }
}
