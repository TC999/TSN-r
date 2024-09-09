package com.tencent.bugly.proguard;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bs extends m implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f51186a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f51187b = "";

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f51186a, 0);
        lVar.a(this.f51187b, 1);
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i4) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f51186a = kVar.b(0, true);
        this.f51187b = kVar.b(1, true);
    }
}
