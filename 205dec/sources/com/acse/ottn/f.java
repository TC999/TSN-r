package com.acse.ottn;

import android.text.TextUtils;
import android.util.Base64;
import java.io.ObjectStreamException;
import java.math.BigInteger;
import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5641a = "AES/ECB/PKCS5Padding";

    /* renamed from: b  reason: collision with root package name */
    public static f f5642b;

    public static f a() {
        if (f5642b == null) {
            synchronized (f.class) {
                if (f5642b == null) {
                    f5642b = new f();
                }
            }
        }
        return f5642b;
    }

    public static byte[] c(String str, String str2) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance(f5641a);
        cipher.init(1, new SecretKeySpec(str2.getBytes(), "AES"));
        return cipher.doFinal(str.getBytes("utf-8"));
    }

    public final Object b() throws ObjectStreamException {
        return f5642b;
    }

    public String b(String str, boolean z3) {
        String a4 = j0.a(z3);
        if (TextUtils.isEmpty(a4)) {
            return str;
        }
        try {
            return b(str, a4);
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public String b(String str, String str2) throws Exception {
        return a(c(str, str2));
    }

    public String a(String str, boolean z3) {
        String a4 = j0.a(z3);
        if (TextUtils.isEmpty(a4)) {
            return str;
        }
        try {
            return a(str, a4);
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static String a(byte[] bArr, int i4) {
        return new BigInteger(1, bArr).toString(i4);
    }

    public static String a(byte[] bArr) {
        return new String(Base64.encode(bArr, 0));
    }

    public static byte[] a(String str) throws Exception {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static String a(byte[] bArr, String str) throws Exception {
        KeyGenerator.getInstance("AES").init(128);
        Cipher cipher = Cipher.getInstance(f5641a);
        cipher.init(2, new SecretKeySpec(str.getBytes(), "AES"));
        return new String(cipher.doFinal(bArr));
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
}
