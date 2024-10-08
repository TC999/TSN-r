package cn.bluemobi.dylan.http;

import android.annotation.SuppressLint;
import java.security.MessageDigest;
import kotlin.UByte;

@SuppressLint({"DefaultLocale"})
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class MD5Utils {
    public static String md5(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes("UTF-8"));
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i = 0; i < charArray.length; i++) {
                bArr[i] = (byte) charArray[i];
            }
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i2 = b & UByte.f41242c;
                if (i2 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i2));
            }
            String stringBuffer2 = stringBuffer.toString();
            System.out.println("===" + stringBuffer2);
            return stringBuffer2;
        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
            return null;
        }
    }
}
