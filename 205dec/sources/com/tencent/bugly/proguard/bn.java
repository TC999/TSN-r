package com.tencent.bugly.proguard;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BUGLY */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class bn extends m implements Cloneable {

    /* renamed from: d  reason: collision with root package name */
    static byte[] f51118d;

    /* renamed from: a  reason: collision with root package name */
    public byte f51119a;

    /* renamed from: b  reason: collision with root package name */
    public String f51120b;

    /* renamed from: c  reason: collision with root package name */
    public byte[] f51121c;

    public bn() {
        this.f51119a = (byte) 0;
        this.f51120b = "";
        this.f51121c = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(l lVar) {
        lVar.a(this.f51119a, 0);
        lVar.a(this.f51120b, 1);
        byte[] bArr = this.f51121c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(StringBuilder sb, int i4) {
    }

    public bn(byte b4, String str, byte[] bArr) {
        this.f51119a = b4;
        this.f51120b = str;
        this.f51121c = bArr;
    }

    @Override // com.tencent.bugly.proguard.m
    public final void a(k kVar) {
        this.f51119a = kVar.a(this.f51119a, 0, true);
        this.f51120b = kVar.b(1, true);
        if (f51118d == null) {
            f51118d = r0;
            byte[] bArr = {0};
        }
        this.f51121c = kVar.c(2, false);
    }
}
