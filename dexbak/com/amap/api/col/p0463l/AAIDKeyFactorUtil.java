package com.amap.api.col.p0463l;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import kotlin.UByte;

/* renamed from: com.amap.api.col.3l.u4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class AAIDKeyFactorUtil {
    /* renamed from: a */
    public static String m53800a() {
        String str;
        str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/sys/kernel/random/boot_id"));
            String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    /* renamed from: b */
    public static String m53799b(Context context) {
        String uuid;
        try {
            String m54140a = AAIDCache.m54140a(context);
            try {
                if (TextUtils.isEmpty(m54140a)) {
                    uuid = UUID.randomUUID().toString();
                    AAIDCache.m54138c(context, uuid);
                    return uuid;
                }
                return m54140a;
            } catch (Throwable unused) {
                return uuid;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    /* renamed from: c */
    private static Date m53798c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: d */
    public static byte[] m53797d(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = (byte) ((bArr[i] ^ bArr2[i % bArr2.length]) ^ (i & 255));
            }
        }
        return bArr;
    }

    /* renamed from: e */
    public static String m53796e() {
        String trim;
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %z /data/app").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date m53798c = m53798c(split[0]);
                if (!TextUtils.isEmpty(split[1] != null ? split[1].split("\\+")[0].trim() : "")) {
                    str = (m53798c.getTime() / 1000) + "." + m53794g(trim);
                } else {
                    str = String.valueOf(m53798c.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    /* renamed from: f */
    private static String m53795f(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                stringBuffer.append(Integer.toHexString(b & UByte.f41242c));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: g */
    private static int m53794g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: h */
    public static String m53793h() {
        String trim;
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %z /data/").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date m53798c = m53798c(split[0]);
                if (!TextUtils.isEmpty(split[1] != null ? split[1].split("\\+")[0].trim() : "")) {
                    str = (m53798c.getTime() / 1000) + "." + m53794g(trim);
                } else {
                    str = String.valueOf(m53798c.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    /* renamed from: i */
    public static String m53792i() {
        String trim;
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %x /data/data").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date m53798c = m53798c(split[0]);
                if (!TextUtils.isEmpty(split[1] != null ? split[1].split("\\+")[0].trim() : "")) {
                    str = (m53798c.getTime() / 1000) + "." + m53794g(trim);
                } else {
                    str = String.valueOf(m53798c.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    /* renamed from: j */
    public static String m53791j() {
        String trim;
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %x /data/app").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date m53798c = m53798c(split[0]);
                if (!TextUtils.isEmpty(split[1] != null ? split[1].split("\\+")[0].trim() : "")) {
                    str = (m53798c.getTime() / 1000) + "." + m53794g(trim);
                } else {
                    str = String.valueOf(m53798c.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    /* renamed from: k */
    public static String m53790k() {
        String str;
        str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %i /data/data").getInputStream()));
            String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    /* renamed from: l */
    public static String m53789l() {
        String str;
        str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %i /data/app").getInputStream()));
            String readLine = bufferedReader.readLine();
            str = readLine != null ? readLine : "";
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    /* renamed from: m */
    public static String m53788m() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String obj = declaredMethod.invoke(null, "net.hostname").toString();
            return (obj == null || obj.equalsIgnoreCase("")) ? obj : m53795f(obj);
        } catch (Exception unused) {
            return null;
        }
    }
}
