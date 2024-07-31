package com.bytedance.pangle.util.p127b.p129b;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* renamed from: com.bytedance.pangle.util.b.b.a */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6243a {

    /* renamed from: a */
    public List<C6245c> f22216a = new ArrayList();

    /* renamed from: a */
    public final void m36911a(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (C6245c c6245c : this.f22216a) {
            if (!set.contains(c6245c.f22226h)) {
                arrayList.add(c6245c);
            }
        }
        this.f22216a = arrayList;
    }
}
