package com.bxkj.base.util;

import androidx.annotation.NonNull;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* compiled from: AESUtils.java */
/* loaded from: E:\TSN-r\205dec\7241516.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f18347a = "AES/ECB/PKCS5Padding";

    /* renamed from: b  reason: collision with root package name */
    private static int f18348b = 24;

    public static String a(String str, @NonNull String str2) throws Exception {
        try {
            int length = str2.length();
            if (length != 16 && length != 24 && length != 32) {
                com.orhanobut.logger.j.c("\u957f\u5ea6\u5fc5\u987b\u4e3a16/24/32");
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
            Cipher cipher = Cipher.getInstance(f18347a);
            cipher.init(2, secretKeySpec);
            try {
                return new String(cipher.doFinal(cn.bluemobi.dylan.base.utils.b.a(str)), "utf-8");
            } catch (Exception e4) {
                com.orhanobut.logger.j.c(e4.toString());
                return null;
            }
        } catch (Exception e5) {
            com.orhanobut.logger.j.c(e5.toString());
            return null;
        }
    }

    public static String b(String str, @NonNull String str2) throws Exception {
        int length = str2.length();
        if (length != 16 && length != 24 && length != 32) {
            com.orhanobut.logger.j.c("\u957f\u5ea6\u5fc5\u987b\u4e3a16/24/32");
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance(f18347a);
        cipher.init(1, secretKeySpec);
        return cn.bluemobi.dylan.base.utils.b.b(cipher.doFinal(str.getBytes("utf-8")));
    }

    public static String c(int i4) {
        if (i4 != 16 && i4 != 24 && i4 != 32) {
            com.orhanobut.logger.j.c("\u957f\u5ea6\u5fc5\u987b\u4e3a16/24/32");
            return null;
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < i4; i5++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    public static void d(String[] strArr) {
        String c4 = c(f18348b);
        com.orhanobut.logger.j.c("\u968f\u673a\u751f\u6210\u7684key\uff1a" + c4);
        try {
            String b4 = b("{'fig':1,'message':'\u767b\u5f55\u6210\u529f'}", c4);
            com.orhanobut.logger.j.c("\u52a0\u5bc6\u540e\u7684\u6570\u636e\uff1a" + b4);
            String a4 = a(b4, c4);
            com.orhanobut.logger.j.c("\u89e3\u5bc6\u540e\u7684\u6570\u636e\uff1a" + a4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }
}
