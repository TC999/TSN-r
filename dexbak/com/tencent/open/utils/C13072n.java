package com.tencent.open.utils;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C13072n implements Cloneable {

    /* renamed from: a */
    private long f37456a;

    public C13072n(long j) {
        this.f37456a = j;
    }

    /* renamed from: a */
    public byte[] m14915a() {
        long j = this.f37456a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    /* renamed from: b */
    public long m14914b() {
        return this.f37456a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof C13072n) && this.f37456a == ((C13072n) obj).m14914b();
    }

    public int hashCode() {
        return (int) this.f37456a;
    }
}
