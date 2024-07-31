package com.bytedance.pangle.util;

import java.security.MessageDigest;

/* renamed from: com.bytedance.pangle.util.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public final class C6250f {

    /* renamed from: a */
    private static final char[] f22235a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: a */
    public static String m36903a(String str) {
        return m36902a(str.getBytes());
    }

    /* renamed from: a */
    public static String m36902a(byte[] bArr) {
        int length;
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                if (digest != null && (length = digest.length) > 0) {
                    char[] cArr = new char[length << 1];
                    int i = 0;
                    for (int i2 = 0; i2 < length; i2++) {
                        int i3 = i + 1;
                        char[] cArr2 = f22235a;
                        cArr[i] = cArr2[(digest[i2] >>> 4) & 15];
                        i = i3 + 1;
                        cArr[i3] = cArr2[digest[i2] & 15];
                    }
                    return new String(cArr);
                }
                return null;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
