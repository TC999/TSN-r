package cn.jiguang.bj;

import android.util.Base64;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2686a = cn.jiguang.bh.a.b(new byte[]{33, 1, 18, 42, 60, 35, 39, 7, 24, 32, 73, 84, 82, 116, 101, 95});

    /* renamed from: b  reason: collision with root package name */
    public static final String f2687b = cn.jiguang.bh.a.b(new byte[]{87, 69, 109, 65, 120, 98, 68, 65, 119, 107, 115});

    /* renamed from: c  reason: collision with root package name */
    public static final String f2688c = cn.jiguang.bh.a.b(new byte[]{124, 112, 70, 65, 55, 123, 115, 114, 69, 82, 112, 124, 111, 63, 125, 69, 106, 123, 119, 118, 85, 100, 112, 111, 115, 98, 68});

    /* renamed from: d  reason: collision with root package name */
    private static HashMap<String, MessageDigest> f2689d = new HashMap<>();

    public static String a(String str) {
        return new String(Base64.decode(str.getBytes(), 2));
    }

    public static String a(byte[] bArr) {
        if (bArr == null) {
            return "";
        }
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b4 : bArr) {
            a(stringBuffer, b4);
        }
        return stringBuffer.toString();
    }

    private static void a(StringBuffer stringBuffer, byte b4) {
        String str = f2686a;
        stringBuffer.append(str.charAt((b4 >> 4) & 15));
        stringBuffer.append(str.charAt(b4 & 15));
    }

    public static String b(String str) {
        return c(str) ? "" : Pattern.compile("[^\\w#$@\\-\u4e00-\u9fa5]+").matcher(str).replaceAll("");
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public static String d(String str) {
        if (str != null && !"".equals(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(i.f2684a);
                messageDigest.update(str.getBytes());
                return a(messageDigest.digest());
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
