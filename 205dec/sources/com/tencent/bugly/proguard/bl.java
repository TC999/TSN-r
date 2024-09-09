package com.tencent.bugly.proguard;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bl extends m implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    public String f51110a = "";

    /* renamed from: b  reason: collision with root package name */
    public String f51111b = "";

    /* renamed from: c  reason: collision with root package name */
    public String f51112c = "";

    /* renamed from: d  reason: collision with root package name */
    public String f51113d = "";

    /* renamed from: e  reason: collision with root package name */
    public String f51114e = "";

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f51110a, 0);
        String str = this.f51111b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f51112c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        String str3 = this.f51113d;
        if (str3 != null) {
            lVar.a(str3, 3);
        }
        String str4 = this.f51114e;
        if (str4 != null) {
            lVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i4) {
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f51110a = kVar.b(0, true);
        this.f51111b = kVar.b(1, false);
        this.f51112c = kVar.b(2, false);
        this.f51113d = kVar.b(3, false);
        this.f51114e = kVar.b(4, false);
    }
}
