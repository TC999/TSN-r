package cn.jiguang.ap;

import android.util.Base64;
import cn.jiguang.ao.c;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2348a = c.b(new byte[]{91, 85, 5});

    /* renamed from: b  reason: collision with root package name */
    public static final String f2349b = c.b(new byte[]{99, 104, 88, 37, 39});

    /* renamed from: c  reason: collision with root package name */
    public static final String f2350c = c.b(new byte[]{74, 64, 87, 60, 2, 21, 47});

    private static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static String a(String str, String str2) {
        try {
            return a(str.getBytes(), str2, str2);
        } catch (Exception unused) {
            cn.jiguang.w.a.f("", "Unexpected - failed to AES encrypt.");
            return "";
        }
    }

    public static String a(byte[] bArr, String str, String str2) {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    private static IvParameterSpec a(byte[] bArr) {
        try {
            return (IvParameterSpec) a(IvParameterSpec.class, new Object[]{bArr}, new Class[]{byte[].class});
        } catch (Exception unused) {
            return null;
        }
    }

    public static byte[] a(String str, String str2, String str3) {
        return a(Base64.decode(str, 2), str2, str3, false);
    }

    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z3) {
        synchronized (b.class) {
            if (str == null) {
                return null;
            }
            SecretKeySpec secretKeySpec = new SecretKeySpec(c(str, "UTF-8"), "AES");
            IvParameterSpec a4 = a(str2.getBytes("UTF-8"));
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(z3 ? 1 : 2, secretKeySpec, a4);
            return cipher.doFinal(bArr);
        }
    }

    public static String b(String str, String str2) {
        try {
            return new String(a(str, str2, str2));
        } catch (Exception unused) {
            cn.jiguang.w.a.f("", "Unexpected - failed to AES decrypt.");
            return "";
        }
    }

    private static byte[] c(String str, String str2) {
        byte[] bArr = new byte[str.length()];
        byte[] bytes = str.substring(0, str.length() / 2).getBytes(str2);
        byte[] bytes2 = str.substring(str.length() / 2).getBytes(str2);
        System.arraycopy(bytes, 0, bArr, 0, bytes.length);
        System.arraycopy(bytes2, 0, bArr, bytes.length, bytes2.length);
        return bArr;
    }
}
