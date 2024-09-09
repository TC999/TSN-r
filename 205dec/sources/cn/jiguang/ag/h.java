package cn.jiguang.ag;

import android.content.Context;
import android.text.TextUtils;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.regex.Pattern;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static final String f2202a = cn.jiguang.ao.c.b(new byte[]{87, 69, 109, 65, 120, 98, 68, 65, 119, 107, 115});

    /* renamed from: b  reason: collision with root package name */
    public static final String f2203b = cn.jiguang.ao.c.b(new byte[]{124, 112, 70, 65, 55, 123, 115, 114, 69, 82, 112, 124, 111, 63, 125, 69, 106, 123, 119, 118, 85, 100, 112, 111, 115, 98, 68});

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, MessageDigest> f2204c = new HashMap<>();

    /* renamed from: d  reason: collision with root package name */
    private static Pattern f2205d = Pattern.compile("((2[0-4]\\d|25[0-5]|[01]?\\d{1,2})\\.){3}(2[0-4]\\d|25[0-5]|[01]?\\d{1,2})");

    /* renamed from: e  reason: collision with root package name */
    private static SimpleDateFormat f2206e = new SimpleDateFormat("HHH:mm:ss:SSS", Locale.ENGLISH);

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

    public static void a(Context context, List<String> list) {
        if (!cn.jiguang.h.a.b(context) || list == null || list.size() < 2 || list.get(0).contains("ipv6")) {
            return;
        }
        Collections.swap(list, 0, 1);
    }

    private static void a(StringBuffer stringBuffer, byte b4) {
        stringBuffer.append("0123456789ABCDEF".charAt((b4 >> 4) & 15));
        stringBuffer.append("0123456789ABCDEF".charAt(b4 & 15));
    }

    public static boolean a(String str) {
        return str == null || str.length() == 0 || str.trim().length() == 0;
    }

    public static String b(String str) {
        return a(str) ? "" : Pattern.compile("[^\\w#$@\\-\u4e00-\u9fa5]+").matcher(str).replaceAll("");
    }

    public static String c(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(cn.jiguang.ap.b.f2348a);
            char[] charArray = str.toCharArray();
            byte[] bArr = new byte[charArray.length];
            for (int i4 = 0; i4 < charArray.length; i4++) {
                bArr[i4] = (byte) charArray[i4];
            }
            byte[] digest = messageDigest.digest(bArr);
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                int i5 = b4 & 255;
                if (i5 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i5));
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static String d(String str) {
        try {
            byte[] digest = MessageDigest.getInstance(cn.jiguang.ap.b.f2348a).digest(str.getBytes("utf-8"));
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                int i4 = b4 & 255;
                if (i4 < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i4));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            cn.jiguang.w.a.b("StringUtils", "Get hash error");
            return "";
        }
    }

    public static boolean e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Pattern.compile("[\\x20-\\x7E]+").matcher(str).matches();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean f(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return Pattern.compile("([A-Fa-f0-9]{2}[-:]){5,}[A-Fa-f0-9]{2}").matcher(str).matches();
        } catch (Throwable unused) {
            return true;
        }
    }

    public static byte[] g(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        try {
            return str.getBytes("UTF-8");
        } catch (Throwable th) {
            cn.jiguang.w.a.i("StringUtils", "stringToUtf8Bytes error:" + th.getMessage());
            return str.getBytes();
        }
    }

    public static String h(String str) {
        if (str != null && !"".equals(str)) {
            try {
                MessageDigest messageDigest = MessageDigest.getInstance(cn.jiguang.ap.b.f2348a);
                messageDigest.update(str.getBytes());
                return a(messageDigest.digest());
            } catch (Throwable unused) {
            }
        }
        return null;
    }
}
