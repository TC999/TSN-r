package cn.jiguang.bj;

import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2684a = cn.jiguang.bh.a.b(new byte[]{91, 85, 5});

    /* renamed from: b  reason: collision with root package name */
    public static final String f2685b = cn.jiguang.bh.a.b(new byte[]{99, 104, 88, 37, 39});

    private static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static String a(String str, String str2) {
        try {
            return new String(a(str, str2, str2));
        } catch (Throwable unused) {
            cn.jiguang.bi.b.e("", "Unexpected - failed to AES decrypt.");
            return "";
        }
    }

    public static String a(byte[] bArr, String str, String str2) {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    private static IvParameterSpec a(byte[] bArr) {
        try {
            return (IvParameterSpec) a(IvParameterSpec.class, new Object[]{bArr}, new Class[]{byte[].class});
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        return a(Base64.decode(str, 2), str2, str3, false);
    }

    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z3) {
        synchronized (i.class) {
            if (str == null) {
                return null;
            }
            try {
                SecretKeySpec secretKeySpec = new SecretKeySpec(b(str, "UTF-8"), "AES");
                IvParameterSpec a4 = a(str2.getBytes("UTF-8"));
                Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
                cipher.init(z3 ? 1 : 2, secretKeySpec, a4);
                return cipher.doFinal(bArr);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    private static byte[] b(String str, String str2) {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }
}
