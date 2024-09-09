package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bp extends m implements Cloneable {

    /* renamed from: b  reason: collision with root package name */
    static ArrayList<bo> f51148b;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<bo> f51149a = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a((Collection) this.f51149a, 0);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i4) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        if (f51148b == null) {
            f51148b = new ArrayList<>();
            f51148b.add(new bo());
        }
        this.f51149a = (ArrayList) kVar.a((k) f51148b, 0, true);
    }
}
