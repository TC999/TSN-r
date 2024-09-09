package bykvm_19do.bykvm_19do.bykvm_19do.bykvm_new1;

import android.text.TextUtils;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES.java */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class a {
    public static String a(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(com.acse.ottn.f.f5641a);
            cipher.init(2, secretKeySpec);
            return new String(cipher.doFinal(decode));
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String b(String str, String str2) {
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(str2.getBytes(), "AES");
            Cipher cipher = Cipher.getInstance(com.acse.ottn.f.f5641a);
            cipher.init(1, secretKeySpec);
            return Base64.encodeToString(cipher.doFinal(str.getBytes("utf-8")), 0);
        } catch (Exception e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String a() {
        String b4 = b0.b();
        if (b4 == null || b4.length() != 16) {
            return null;
        }
        return b4;
    }

    public static String a(String str) {
        if (str == null || str.length() != 16) {
            return null;
        }
        return str.concat(str).substring(8, 24);
    }
}
