package com.acse.ottn.util;

import android.content.Context;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DecimalFormat;
import kotlin.UByte;

/* renamed from: com.acse.ottn.util.za */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1712za {

    /* renamed from: a */
    private char[] f3393a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: a */
    public static void m55873a(String str) {
        C1694ra.m55913d("PgyerAnalytics", str);
    }

    /* renamed from: a */
    public static boolean m55874a(Context context, String str) {
        return context != null && context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    /* renamed from: c */
    public static String m55869c(String str) {
        if (str != null && str.length() != 0) {
            try {
                String str2 = "";
                for (byte b : MessageDigest.getInstance("MD5").digest(str.getBytes())) {
                    String hexString = Integer.toHexString(b & UByte.f41242c);
                    if (hexString.length() == 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("0");
                        sb.append(hexString);
                        hexString = sb.toString();
                    }
                    str2 = str2 + hexString;
                }
                return str2.toLowerCase();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }
        }
        return "";
    }

    /* renamed from: a */
    public String m55875a(long j) {
        float f;
        String str;
        if (j >= 1000) {
            f = (float) (j / 1000);
            if (f >= 1000.0f) {
                f /= 1000.0f;
                str = "GHz";
            } else {
                str = "MHz";
            }
            if (f >= 1000.0f) {
                f /= 1000.0f;
                str = "THz";
            }
        } else {
            f = (float) j;
            str = "KHz";
        }
        return new DecimalFormat("#0.0").format(f) + str;
    }

    /* renamed from: a */
    public String m55872a(byte[] bArr) {
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        for (int i = 0; i < bArr.length; i++) {
            sb.append(this.f3393a[(bArr[i] & 240) >>> 4]);
            sb.append(this.f3393a[bArr[i] & 15]);
        }
        return sb.toString();
    }

    /* renamed from: b */
    public String m55871b(long j) {
        float f;
        String str;
        if (j >= 1000) {
            f = (float) (j / 1000);
            if (f >= 1000.0f) {
                f /= 1000.0f;
                str = "MB";
            } else {
                str = "KB";
            }
            if (f >= 1000.0f) {
                f /= 1000.0f;
                str = "GB";
            }
        } else {
            f = (float) j;
            str = "B";
        }
        return new DecimalFormat("#0.0").format(f) + str;
    }

    /* renamed from: b */
    public String m55870b(String str) {
        byte[] bArr = new byte[1024];
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    fileInputStream.close();
                    return m55872a(messageDigest.digest());
                }
                messageDigest.update(bArr, 0, read);
            }
        } catch (Exception unused) {
            System.out.println("error");
            return null;
        }
    }
}
