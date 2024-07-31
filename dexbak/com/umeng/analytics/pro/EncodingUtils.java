package com.umeng.analytics.pro;

import kotlin.UByte;

/* renamed from: com.umeng.analytics.pro.bo */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class EncodingUtils {
    /* renamed from: a */
    public static final void m14564a(int i, byte[] bArr) {
        m14563a(i, bArr, 0);
    }

    /* renamed from: a */
    public static final boolean m14566a(int i, int i2) {
        return (i & (1 << i2)) != 0;
    }

    /* renamed from: a */
    public static final boolean m14562a(long j, int i) {
        return (j & (1 << i)) != 0;
    }

    /* renamed from: b */
    public static final byte m14556b(byte b, int i) {
        return (byte) m14555b((int) b, i);
    }

    /* renamed from: b */
    public static final int m14555b(int i, int i2) {
        return i & ((1 << i2) ^ (-1));
    }

    /* renamed from: b */
    public static final long m14554b(long j, int i) {
        return j & ((1 << i) ^ (-1));
    }

    /* renamed from: a */
    public static final void m14563a(int i, byte[] bArr, int i2) {
        bArr[i2] = (byte) ((i >> 24) & 255);
        bArr[i2 + 1] = (byte) ((i >> 16) & 255);
        bArr[i2 + 2] = (byte) ((i >> 8) & 255);
        bArr[i2 + 3] = (byte) (i & 255);
    }

    /* renamed from: b */
    public static final short m14553b(short s, int i) {
        return (short) m14555b((int) s, i);
    }

    /* renamed from: a */
    public static final int m14558a(byte[] bArr) {
        return m14557a(bArr, 0);
    }

    /* renamed from: a */
    public static final int m14557a(byte[] bArr, int i) {
        return (bArr[i + 3] & UByte.f41242c) | ((bArr[i] & UByte.f41242c) << 24) | ((bArr[i + 1] & UByte.f41242c) << 16) | ((bArr[i + 2] & UByte.f41242c) << 8);
    }

    /* renamed from: a */
    public static final boolean m14568a(byte b, int i) {
        return m14566a((int) b, i);
    }

    /* renamed from: a */
    public static final boolean m14560a(short s, int i) {
        return m14566a((int) s, i);
    }

    /* renamed from: a */
    public static final byte m14567a(byte b, int i, boolean z) {
        return (byte) m14565a((int) b, i, z);
    }

    /* renamed from: a */
    public static final short m14559a(short s, int i, boolean z) {
        return (short) m14565a((int) s, i, z);
    }

    /* renamed from: a */
    public static final int m14565a(int i, int i2, boolean z) {
        return z ? i | (1 << i2) : m14555b(i, i2);
    }

    /* renamed from: a */
    public static final long m14561a(long j, int i, boolean z) {
        return z ? j | (1 << i) : m14554b(j, i);
    }
}
