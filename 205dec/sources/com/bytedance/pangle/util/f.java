package com.bytedance.pangle.util;

import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* loaded from: E:\TSN-r\205dec\6465380.dex */
public final class f {

    /* renamed from: a  reason: collision with root package name */
    private static final char[] f29005a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public static String a(String str) {
        return a(str.getBytes());
    }

    public static String a(byte[] bArr) {
        int length;
        if (bArr != null && bArr.length > 0) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                messageDigest.update(bArr);
                byte[] digest = messageDigest.digest();
                if (digest != null && (length = digest.length) > 0) {
                    char[] cArr = new char[length << 1];
                    int i4 = 0;
                    for (int i5 = 0; i5 < length; i5++) {
                        int i6 = i4 + 1;
                        char[] cArr2 = f29005a;
                        cArr[i4] = cArr2[(digest[i5] >>> 4) & 15];
                        i4 = i6 + 1;
                        cArr[i6] = cArr2[digest[i5] & 15];
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
