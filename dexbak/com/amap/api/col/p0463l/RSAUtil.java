package com.amap.api.col.p0463l;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* renamed from: com.amap.api.col.3l.l5 */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public final class RSAUtil {
    /* renamed from: a */
    public static PublicKey m54578a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(C1925p4.m54183u("EUlNB")).generatePublic(new X509EncodedKeySpec(Base64Util.m54754c(str)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    /* renamed from: b */
    public static byte[] m54577b(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(C1925p4.m54183u("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
