package com.bxkj.base.util;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: DES.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static byte[] f18373a = {1, 2, 3, 4, 5, 6, 7, 8};

    /* JADX WARN: Can't wrap try/catch for region: R(10:1|(2:2|3)|4|5|6|7|(2:8|9)|10|11|(1:(0))) */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x0028, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0029, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002e, code lost:
        r0.printStackTrace();
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(java.lang.String r3, java.lang.String r4) {
        /*
            javax.crypto.spec.IvParameterSpec r0 = new javax.crypto.spec.IvParameterSpec
            byte[] r1 = com.bxkj.base.util.e.f18373a
            r0.<init>(r1)
            javax.crypto.spec.SecretKeySpec r1 = new javax.crypto.spec.SecretKeySpec
            byte[] r4 = r4.getBytes()
            java.lang.String r2 = "DES"
            r1.<init>(r4, r2)
            java.lang.String r4 = "DES/CBC/PKCS5Padding"
            javax.crypto.Cipher r4 = javax.crypto.Cipher.getInstance(r4)     // Catch: javax.crypto.NoSuchPaddingException -> L19 java.security.NoSuchAlgorithmException -> L1e
            goto L23
        L19:
            r4 = move-exception
            r4.printStackTrace()
            goto L22
        L1e:
            r4 = move-exception
            r4.printStackTrace()
        L22:
            r4 = 0
        L23:
            r2 = 1
            r4.init(r2, r1, r0)     // Catch: java.security.InvalidAlgorithmParameterException -> L28 java.security.InvalidKeyException -> L2d
            goto L31
        L28:
            r0 = move-exception
            r0.printStackTrace()
            goto L31
        L2d:
            r0 = move-exception
            r0.printStackTrace()
        L31:
            r0 = 0
            byte[] r0 = new byte[r0]
            byte[] r3 = r3.getBytes()     // Catch: javax.crypto.BadPaddingException -> L3d javax.crypto.IllegalBlockSizeException -> L42
            byte[] r0 = r4.doFinal(r3)     // Catch: javax.crypto.BadPaddingException -> L3d javax.crypto.IllegalBlockSizeException -> L42
            goto L46
        L3d:
            r3 = move-exception
            r3.printStackTrace()
            goto L46
        L42:
            r3 = move-exception
            r3.printStackTrace()
        L46:
            java.lang.String r3 = cn.bluemobi.dylan.base.utils.b.b(r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bxkj.base.util.e.a(java.lang.String, java.lang.String):java.lang.String");
    }
}
