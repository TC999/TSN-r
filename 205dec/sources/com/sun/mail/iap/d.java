package com.sun.mail.iap;

import java.io.ByteArrayInputStream;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ByteArray.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private byte[] f50267a;

    /* renamed from: b  reason: collision with root package name */
    private int f50268b;

    /* renamed from: c  reason: collision with root package name */
    private int f50269c;

    public d(byte[] bArr, int i4, int i5) {
        this.f50267a = bArr;
        this.f50268b = i4;
        this.f50269c = i5;
    }

    public byte[] a() {
        return this.f50267a;
    }

    public int b() {
        return this.f50269c;
    }

    public byte[] c() {
        int i4 = this.f50269c;
        byte[] bArr = new byte[i4];
        System.arraycopy(this.f50267a, this.f50268b, bArr, 0, i4);
        return bArr;
    }

    public int d() {
        return this.f50268b;
    }

    public void e(int i4) {
        byte[] bArr = this.f50267a;
        byte[] bArr2 = new byte[bArr.length + i4];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        this.f50267a = bArr2;
    }

    public void f(int i4) {
        this.f50269c = i4;
    }

    public ByteArrayInputStream g() {
        return new ByteArrayInputStream(this.f50267a, this.f50268b, this.f50269c);
    }

    public d(int i4) {
        this(new byte[i4], 0, i4);
    }
}
