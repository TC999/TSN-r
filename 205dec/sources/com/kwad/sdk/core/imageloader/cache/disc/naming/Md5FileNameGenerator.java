package com.kwad.sdk.core.imageloader.cache.disc.naming;

import com.kwad.sdk.core.imageloader.utils.L;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class Md5FileNameGenerator implements FileNameGenerator {
    private static final String HASH_ALGORITHM = "MD5";
    private static final int RADIX = 36;

    private byte[] getMD5(byte[] bArr) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            return messageDigest.digest();
        } catch (NoSuchAlgorithmException e4) {
            L.e(e4);
            return null;
        }
    }

    @Override // com.kwad.sdk.core.imageloader.cache.disc.naming.FileNameGenerator
    public String generate(String str) {
        return new BigInteger(getMD5(str.getBytes())).abs().toString(36);
    }
}
