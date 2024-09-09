package com.umeng.socialize.a;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: UMCryptXor.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class i {
    public static byte[] a(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i4 = 0; i4 < bArr.length; i4++) {
                bArr[i4] = (byte) ((bArr[i4] ^ bArr2[i4 % bArr2.length]) ^ (i4 & 255));
            }
        }
        return bArr;
    }
}
