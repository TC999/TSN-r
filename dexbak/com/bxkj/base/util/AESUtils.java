package com.bxkj.base.util;

import androidx.annotation.NonNull;
import cn.bluemobi.dylan.base.utils.C1138b;
import com.orhanobut.logger.C11792j;
import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.bxkj.base.util.a */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class AESUtils {

    /* renamed from: a */
    private static String f14863a = "AES/ECB/PKCS5Padding";

    /* renamed from: b */
    private static int f14864b = 24;

    /* renamed from: a */
    public static String m44140a(String str, @NonNull String str2) throws Exception {
        try {
            int length = str2.length();
            if (length != 16 && length != 24 && length != 32) {
                C11792j.m20470c("长度必须为16/24/32");
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
            Cipher cipher = Cipher.getInstance(f14863a);
            cipher.init(2, secretKeySpec);
            try {
                return new String(cipher.doFinal(C1138b.m57769a(str)), "utf-8");
            } catch (Exception e) {
                C11792j.m20470c(e.toString());
                return null;
            }
        } catch (Exception e2) {
            C11792j.m20470c(e2.toString());
            return null;
        }
    }

    /* renamed from: b */
    public static String m44139b(String str, @NonNull String str2) throws Exception {
        int length = str2.length();
        if (length != 16 && length != 24 && length != 32) {
            C11792j.m20470c("长度必须为16/24/32");
            return null;
        }
        SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance(f14863a);
        cipher.init(1, secretKeySpec);
        return C1138b.m57768b(cipher.doFinal(str.getBytes("utf-8")));
    }

    /* renamed from: c */
    public static String m44138c(int i) {
        if (i != 16 && i != 24 && i != 32) {
            C11792j.m20470c("长度必须为16/24/32");
            return null;
        }
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".charAt(random.nextInt(62)));
        }
        return sb.toString();
    }

    /* renamed from: d */
    public static void m44137d(String[] strArr) {
        String m44138c = m44138c(f14864b);
        C11792j.m20470c("随机生成的key：" + m44138c);
        try {
            String m44139b = m44139b("{'fig':1,'message':'登录成功'}", m44138c);
            C11792j.m20470c("加密后的数据：" + m44139b);
            String m44140a = m44140a(m44139b, m44138c);
            C11792j.m20470c("解密后的数据：" + m44140a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
