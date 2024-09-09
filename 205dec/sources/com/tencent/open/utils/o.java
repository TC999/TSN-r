package com.tencent.open.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class o implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private int f51857a;

    public o(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i4 = this.f51857a;
        return new byte[]{(byte) (i4 & 255), (byte) ((i4 & 65280) >> 8)};
    }

    public int b() {
        return this.f51857a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof o) && this.f51857a == ((o) obj).b();
    }

    public int hashCode() {
        return this.f51857a;
    }

    public o(byte[] bArr, int i4) {
        int i5 = (bArr[i4 + 1] << 8) & 65280;
        this.f51857a = i5;
        this.f51857a = i5 + (bArr[i4] & 255);
    }

    public o(int i4) {
        this.f51857a = i4;
    }
}
