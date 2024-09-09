package com.amap.api.col.p0003l;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: RSAUtil.java */
/* renamed from: com.amap.api.col.3l.m5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class m5 {
    public static PublicKey a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(q4.u("EUlNB")).generatePublic(new X509EncodedKeySpec(i5.c(str)));
        } catch (NullPointerException unused) {
            throw new Exception("\u516c\u94a5\u6570\u636e\u4e3a\u7a7a");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("\u65e0\u6b64\u7b97\u6cd5");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("\u516c\u94a5\u975e\u6cd5");
        }
    }

    public static byte[] b(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(q4.u("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
