package com.acse.ottn.util;

import android.content.Context;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class za {

    /* renamed from: a  reason: collision with root package name */
    private char[] f6903a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    public static void a(String str) {
        ra.d("PgyerAnalytics", str);
    }

    public static boolean a(Context context, String str) {
        return context != null && context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static String c(String str) {
        if (str != null && str.length() != 0) {
            try {
                String str2 = "";
                for (byte b4 : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                    String hexString = Integer.toHexString(b4 & 255);
                    if (hexString.length() == 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("0");
                        sb.append(hexString);
                        hexString = sb.toString();
                    }
                    str2 = str2 + hexString;
                }
                return str2.toLowerCase();
            } catch (NoSuchAlgorithmException e4) {
                e4.printStackTrace();
            }
        }
        return "";
    }

    public String a(long j4) {
        float f4;
        String str;
        if (j4 >= 1000) {
            f4 = (float) (j4 / 1000);
            if (f4 >= 1000.0f) {
                f4 /= 1000.0f;
                str = "GHz";
            } else {
                str = "MHz";
            }
            if (f4 >= 1000.0f) {
                f4 /= 1000.0f;
                str = "THz";
            }
        } else {
            f4 = (float) j4;
            str = "KHz";
        }
        return new DecimalFormat("#0.0").format(f4) + str;
    }

    public String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i4 = 0; i4 < bArr.length; i4++) {
            sb.append(this.f6903a[(bArr[i4] & 240) >>> 4]);
            sb.append(this.f6903a[bArr[i4] & 15]);
        }
        return sb.toString();
    }

    public String b(long j4) {
        float f4;
        String str;
        if (j4 >= 1000) {
            f4 = (float) (j4 / 1000);
            if (f4 >= 1000.0f) {
                f4 /= 1000.0f;
                str = "MB";
            } else {
                str = "KB";
            }
            if (f4 >= 1000.0f) {
                f4 /= 1000.0f;
                str = "GB";
            }
        } else {
            f4 = (float) j4;
            str = "B";
        }
        return new DecimalFormat("#0.0").format(f4) + str;
    }

    public String b(String str) {
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    return a(messageDigest.digest());
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception unused) {
            System.out.println("error");
            return null;
        }
    }
}
