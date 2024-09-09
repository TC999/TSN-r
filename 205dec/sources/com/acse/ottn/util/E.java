package com.acse.ottn.util;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ObjectStreamException;
import java.math.BigInteger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class E {

    /* renamed from: a  reason: collision with root package name */
    private static final String f6717a = "AES/ECB/PKCS5Padding";

    /* renamed from: b  reason: collision with root package name */
    private static E f6718b;

    public static E a() {
        if (f6718b == null) {
            synchronized (E.class) {
                if (f6718b == null) {
                    f6718b = new E();
                }
            }
        }
        return f6718b;
    }

    public static String a(byte[] bArr) {
        return new String(Base64.encode(bArr, 0));
    }

    public static String a(byte[] bArr, int i4) {
        return new BigInteger(1, bArr).toString(i4);
    }

    public static String a(byte[] bArr, String str) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, new SecretKeySpec(str.getBytes(), "AES"));
        return new String(cipher.doFinal(bArr));
    }

    public static byte[] a(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    private Object b() throws ObjectStreamException {
        return f6718b;
    }

    public static byte[] c(String str, String str2) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"));
        return cipher.doFinal(str.getBytes("utf-8"));
    }

    public String a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return a(a(jSONObject.getString("content")), str2);
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public String a(String str, boolean z3) {
        String decryptKey = CommonUtil.getDecryptKey(z3);
        if (TextUtils.isEmpty(decryptKey)) {
            return str;
        }
        try {
            return a(str, decryptKey);
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public String b(String str, String str2) throws Exception {
        return a(c(str, str2));
    }

    public String b(String str, boolean z3) {
        String decryptKey = CommonUtil.getDecryptKey(z3);
        if (TextUtils.isEmpty(decryptKey)) {
            return str;
        }
        try {
            return b(str, decryptKey);
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }
}
