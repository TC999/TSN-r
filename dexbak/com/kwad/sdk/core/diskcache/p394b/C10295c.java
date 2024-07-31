package com.kwad.sdk.core.diskcache.p394b;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import kotlin.UByte;

/* renamed from: com.kwad.sdk.core.diskcache.b.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C10295c {
    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: dt */
    public static String m26384dt(String str) {
        if (str == null) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            return m26383e(messageDigest.digest());
        } catch (NoSuchAlgorithmException unused) {
            return String.valueOf(str.hashCode());
        }
    }

    /* renamed from: e */
    private static String m26383e(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UByte.f41242c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }
}
