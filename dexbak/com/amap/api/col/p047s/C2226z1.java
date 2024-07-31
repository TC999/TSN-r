package com.amap.api.col.p047s;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;

/* compiled from: RSAUtil.java */
/* renamed from: com.amap.api.col.s.z1 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2226z1 {
    /* renamed from: a */
    public static PublicKey m52178a(String str) throws Exception {
        try {
            return KeyFactory.getInstance(C2079j1.m52857t("EUlNB")).generatePublic(new X509EncodedKeySpec(C2187v1.m52393c(str)));
        } catch (NullPointerException unused) {
            throw new Exception("公钥数据为空");
        } catch (NoSuchAlgorithmException unused2) {
            throw new Exception("无此算法");
        } catch (InvalidKeySpecException unused3) {
            throw new Exception("公钥非法");
        }
    }

    /* renamed from: b */
    public static byte[] m52177b(byte[] bArr, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance(C2079j1.m52857t("CUlNBL0VDQi9QS0NTMVBhZGRpbmc"));
            cipher.init(1, publicKey);
            return cipher.doFinal(bArr);
        } catch (Throwable unused) {
            return null;
        }
    }
}
