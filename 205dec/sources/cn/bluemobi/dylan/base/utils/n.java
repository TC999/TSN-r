package cn.bluemobi.dylan.base.utils;

import android.annotation.SuppressLint;
import java.security.MessageDigest;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: MD5Utils.java */
@SuppressLint({"DefaultLocale"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class n {
    public static String a(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i4 = 0; i4 < charArray.length; i4++) {
                bArr[i4] = (byte) charArray[i4];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                int i5 = b4 & 255;
                if (i5 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i5));
            }
            String stringBuffer2 = stringBuffer.toString();
            System.out.println("===" + stringBuffer2);
            return stringBuffer2;
        } catch (Exception e4) {
            System.out.println(e4.toString());
            e4.printStackTrace();
            return null;
        }
    }
}
