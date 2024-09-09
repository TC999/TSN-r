package com.amap.api.col.s;

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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AAIDKeyFactorUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class n1 {
    public static String a() {
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

    public static String b(Context context) {
        String uuid;
        try {
            String a4 = k1.a(context);
            try {
                if (TextUtils.isEmpty(a4)) {
                    uuid = UUID.randomUUID().toString();
                    k1.c(context, uuid);
                    return uuid;
                }
                return a4;
            } catch (Throwable unused) {
                return uuid;
            }
        } catch (Throwable unused2) {
            return "";
        }
    }

    private static Date c(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static byte[] d(byte[] bArr, byte[] bArr2) {
        if (bArr != null && bArr.length != 0 && bArr2 != null && bArr2.length != 0) {
            for (int i4 = 0; i4 < bArr.length; i4++) {
                bArr[i4] = (byte) ((bArr[i4] ^ bArr2[i4 % bArr2.length]) ^ (i4 & 255));
            }
        }
        return bArr;
    }

    public static String e() {
        String trim;
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %z /data/app").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date c4 = c(split[0]);
                if (!TextUtils.isEmpty(split[1] != null ? split[1].split("\\+")[0].trim() : "")) {
                    str = (c4.getTime() / 1000) + "." + g(trim);
                } else {
                    str = String.valueOf(c4.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    private static String f(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                stringBuffer.append(Integer.toHexString(b4 & 255));
            }
            return stringBuffer.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    private static int g(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            return Integer.parseInt(str);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String h() {
        String trim;
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %z /data/").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date c4 = c(split[0]);
                if (!TextUtils.isEmpty(split[1] != null ? split[1].split("\\+")[0].trim() : "")) {
                    str = (c4.getTime() / 1000) + "." + g(trim);
                } else {
                    str = String.valueOf(c4.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String i() {
        String trim;
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %x /data/data").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date c4 = c(split[0]);
                if (!TextUtils.isEmpty(split[1] != null ? split[1].split("\\+")[0].trim() : "")) {
                    str = (c4.getTime() / 1000) + "." + g(trim);
                } else {
                    str = String.valueOf(c4.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String j() {
        String trim;
        String str = "";
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("stat -c %x /data/app").getInputStream()));
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                String[] split = readLine.split("\\.");
                Date c4 = c(split[0]);
                if (!TextUtils.isEmpty(split[1] != null ? split[1].split("\\+")[0].trim() : "")) {
                    str = (c4.getTime() / 1000) + "." + g(trim);
                } else {
                    str = String.valueOf(c4.getTime() / 1000);
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        return str;
    }

    public static String k() {
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

    public static String l() {
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

    public static String m() {
        try {
            Method declaredMethod = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod.setAccessible(true);
            String obj = declaredMethod.invoke(null, "net.hostname").toString();
            return (obj == null || obj.equalsIgnoreCase("")) ? obj : f(obj);
        } catch (Exception unused) {
            return null;
        }
    }
}
