package com.tencent.bugly.proguard;

import java.nio.ByteBuffer;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public final class C12902n {

    /* renamed from: a */
    private static final byte[] f36887a;

    /* renamed from: b */
    private static final byte[] f36888b;

    static {
        byte[] bArr = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
        byte[] bArr2 = new byte[256];
        byte[] bArr3 = new byte[256];
        for (int i = 0; i < 256; i++) {
            bArr2[i] = bArr[i >>> 4];
            bArr3[i] = bArr[i & 15];
        }
        f36887a = bArr2;
        f36888b = bArr3;
    }

    /* renamed from: a */
    public static boolean m15576a(int i, int i2) {
        return i == i2;
    }

    /* renamed from: a */
    public static boolean m15575a(long j, long j2) {
        return j == j2;
    }

    /* renamed from: a */
    public static boolean m15574a(Object obj, Object obj2) {
        return obj.equals(obj2);
    }

    /* renamed from: a */
    public static boolean m15572a(boolean z, boolean z2) {
        return z == z2;
    }

    /* renamed from: a */
    public static byte[] m15573a(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        byte[] bArr = new byte[position];
        System.arraycopy(byteBuffer.array(), 0, bArr, 0, position);
        return bArr;
    }
}
