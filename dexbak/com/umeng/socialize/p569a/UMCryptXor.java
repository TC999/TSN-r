package com.umeng.socialize.p569a;

/* renamed from: com.umeng.socialize.a.i */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class UMCryptXor {
    /* renamed from: a */
    public static byte[] m13388a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((bArr[i] ^ bArr2[i % bArr2.length]) ^ (i & 255));
            }
        }
        return bArr;
    }
}
