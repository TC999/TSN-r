package com.tencent.turingfd.sdk.ams.au;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class Hydra {
    public static String a(byte[] bArr) {
        byte[] bArr2;
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(bArr);
            bArr2 = messageDigest.digest();
        } catch (NoSuchAlgorithmException unused) {
            bArr2 = null;
        }
        return Cherry.a(bArr2);
    }
}
