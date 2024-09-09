package cn.jiguang.cn;

import android.util.Base64;
import java.security.KeyFactory;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f3482a = d.b(new byte[]{91, 85, 5});

    /* renamed from: b  reason: collision with root package name */
    public static final String f3483b = d.b(new byte[]{99, 104, 88, 37, 39});

    public static int a() {
        return Math.abs(new SecureRandom().nextInt()) & 16777215;
    }

    private static <T> T a(Class<T> cls, Object[] objArr, Class<?>[] clsArr) {
        return cls.getConstructor(clsArr).newInstance(objArr);
    }

    public static String a(long j4) {
        long j5;
        long j6;
        switch ((int) (j4 % 10)) {
            case 1:
                j5 = 5 * j4;
                j6 = 88;
                break;
            case 2:
                j5 = 23 * j4;
                j6 = 15;
                break;
            case 3:
                j5 = 3 * j4;
                j6 = 73;
                break;
            case 4:
                j5 = 13 * j4;
                j6 = 96;
                break;
            case 5:
                j5 = 17 * j4;
                j6 = 49;
                break;
            case 6:
                j5 = 7 * j4;
                j6 = 68;
                break;
            case 7:
                j5 = 31 * j4;
                j6 = 39;
                break;
            case 8:
                j5 = 29 * j4;
                j6 = 41;
                break;
            case 9:
                j5 = 37 * j4;
                j6 = 91;
                break;
            default:
                j5 = 8 * j4;
                j6 = 74;
                break;
        }
        long j7 = j5 + (j4 % j6);
        return cn.jiguang.f.g.d("JCKP" + j7);
    }

    public static String a(String str, String str2) {
        try {
            return a(str.getBytes(), str2, str2);
        } catch (Exception unused) {
            cn.jiguang.bq.d.i("", "Unexpected - failed to AES encrypt.");
            return "";
        }
    }

    public static String a(byte[] bArr, String str, String str2) {
        return Base64.encodeToString(a(bArr, str, str2, true), 2);
    }

    private static RSAPublicKey a(String str) {
        try {
            return (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 2)));
        } catch (Throwable unused) {
            return null;
        }
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

    private static synchronized byte[] a(String str, RSAPublicKey rSAPublicKey, String str2) {
        byte[] doFinal;
        synchronized (g.class) {
            Cipher cipher = Cipher.getInstance(str2);
            cipher.init(1, rSAPublicKey);
            doFinal = cipher.doFinal(str.getBytes());
        }
        return doFinal;
    }

    public static synchronized byte[] a(byte[] bArr, String str, String str2, boolean z3) {
        synchronized (g.class) {
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
            cn.jiguang.bq.d.i("", "Unexpected - failed to AES decrypt.");
            return "";
        }
    }

    public static String b(String str, String str2, String str3) {
        return new String(Base64.encode(a(str, a(str2), str3), 2), "UTF-8");
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
