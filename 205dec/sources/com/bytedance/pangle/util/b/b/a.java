package com.bytedance.pangle.util.b.b;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class a {

    /* renamed from: a  reason: collision with root package name */
    public List<c> f28986a = new ArrayList();

    public final void a(Set<String> set) {
        ArrayList arrayList = new ArrayList();
        for (c cVar : this.f28986a) {
            if (!set.contains(cVar.f28996h)) {
                arrayList.add(cVar);
            }
        }
        this.f28986a = arrayList;
    }
}
