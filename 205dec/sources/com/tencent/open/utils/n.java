package com.tencent.open.utils;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: ProGuard */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public final class n implements Cloneable {

    /* renamed from: a  reason: collision with root package name */
    private long f51856a;

    public n(long j4) {
        this.f51856a = j4;
    }

    public byte[] a() {
        long j4 = this.f51856a;
        return new byte[]{(byte) (255 & j4), (byte) ((65280 & j4) >> 8), (byte) ((16711680 & j4) >> 16), (byte) ((j4 & 4278190080L) >> 24)};
    }

    public long b() {
        return this.f51856a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof n) && this.f51856a == ((n) obj).b();
    }

    public int hashCode() {
        return (int) this.f51856a;
    }
}
