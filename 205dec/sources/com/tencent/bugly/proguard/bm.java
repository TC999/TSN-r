package com.tencent.bugly.proguard;

import java.util.ArrayList;
import java.util.Collection;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bm extends m implements Cloneable {

    /* renamed from: c  reason: collision with root package name */
    static ArrayList<String> f51115c;

    /* renamed from: a  reason: collision with root package name */
    public String f51116a = "";

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<String> f51117b = null;

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f51116a, 0);
        ArrayList<String> arrayList = this.f51117b;
        if (arrayList != null) {
            lVar.a((Collection) arrayList, 1);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i4) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f51116a = kVar.b(0, true);
        if (f51115c == null) {
            ArrayList<String> arrayList = new ArrayList<>();
            f51115c = arrayList;
            arrayList.add("");
        }
        this.f51117b = (ArrayList) kVar.a((k) f51115c, 1, false);
    }
}
