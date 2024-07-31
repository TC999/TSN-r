package com.acse.ottn.util;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ObjectStreamException;
import java.math.BigInteger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* renamed from: com.acse.ottn.util.E */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1625E {

    /* renamed from: a */
    private static final String f3144a = "AES/ECB/PKCS5Padding";

    /* renamed from: b */
    private static C1625E f3145b;

    /* renamed from: a */
    public static C1625E m56283a() {
        if (f3145b == null) {
            synchronized (C1625E.class) {
                if (f3145b == null) {
                    f3145b = new C1625E();
                }
            }
        }
        return f3145b;
    }

    /* renamed from: a */
    public static String m56279a(byte[] bArr) {
        return new String(Base64.encode(bArr, 0));
    }

    /* renamed from: a */
    public static String m56278a(byte[] bArr, int i) {
        return new BigInteger(1, bArr).toString(i);
    }

    /* renamed from: a */
    public static String m56277a(byte[] bArr, String str) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance(f3144a);
        cipher.init(2, new SecretKeySpec(str.getBytes(), "AES"));
        return new String(cipher.doFinal(bArr));
    }

    /* renamed from: a */
    public static byte[] m56282a(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    /* renamed from: b */
    private Object m56276b() throws ObjectStreamException {
        return f3145b;
    }

    /* renamed from: c */
    public static byte[] m56273c(String str, String str2) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance(f3144a);
        cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"));
        return cipher.doFinal(str.getBytes("utf-8"));
    }

    /* renamed from: a */
    public String m56281a(String str, String str2) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return m56277a(m56282a(jSONObject.getString("content")), str2);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: a */
    public String m56280a(String str, boolean z) {
        String decryptKey = CommonUtil.getDecryptKey(z);
        if (TextUtils.isEmpty(decryptKey)) {
            return str;
        }
        try {
            return m56281a(str, decryptKey);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: b */
    public String m56275b(String str, String str2) throws Exception {
        return m56279a(m56273c(str, str2));
    }

    /* renamed from: b */
    public String m56274b(String str, boolean z) {
        String decryptKey = CommonUtil.getDecryptKey(z);
        if (TextUtils.isEmpty(decryptKey)) {
            return str;
        }
        try {
            return m56275b(str, decryptKey);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
