package com.umeng.analytics.pro;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: TMemoryInputTransport.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class dd extends de {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f52885a;

    /* renamed from: b  reason: collision with root package name */
    private int f52886b;

    /* renamed from: c  reason: collision with root package name */
    private int f52887c;

    public dd() {
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.de
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.de
    public void b() throws df {
    }

    @Override // com.umeng.analytics.pro.de
    public void b(byte[] bArr, int i4, int i5) throws df {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.de
    public void c() {
    }

    public void c(byte[] bArr, int i4, int i5) {
        this.f52885a = bArr;
        this.f52886b = i4;
        this.f52887c = i4 + i5;
    }

    public void e() {
        this.f52885a = null;
    }

    @Override // com.umeng.analytics.pro.de
    public byte[] f() {
        return this.f52885a;
    }

    @Override // com.umeng.analytics.pro.de
    public int g() {
        return this.f52886b;
    }

    @Override // com.umeng.analytics.pro.de
    public int h() {
        return this.f52887c - this.f52886b;
    }

    public dd(byte[] bArr) {
        a(bArr);
    }

    @Override // com.umeng.analytics.pro.de
    public int a(byte[] bArr, int i4, int i5) throws df {
        int h4 = h();
        if (i5 > h4) {
            i5 = h4;
        }
        if (i5 > 0) {
            System.arraycopy(this.f52885a, this.f52886b, bArr, i4, i5);
            a(i5);
        }
        return i5;
    }

    public dd(byte[] bArr, int i4, int i5) {
        c(bArr, i4, i5);
    }

    @Override // com.umeng.analytics.pro.de
    public void a(int i4) {
        this.f52886b += i4;
    }
}
