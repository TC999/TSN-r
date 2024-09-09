package com.amap.api.col.s;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: AppInfo.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class x0 {

    /* renamed from: a  reason: collision with root package name */
    private static String f10375a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f10376b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f10377c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f10378d = "";

    /* renamed from: e  reason: collision with root package name */
    static String f10379e;

    /* renamed from: f  reason: collision with root package name */
    static boolean f10380f;

    public static String a(Context context) {
        try {
            return k(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f10378d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f10378d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean c() {
        if (f10380f) {
            return true;
        }
        if (e(f10379e)) {
            f10380f = true;
            return true;
        } else if (!TextUtils.isEmpty(f10379e)) {
            f10380f = false;
            f10379e = null;
            return false;
        } else if (e(f10376b)) {
            f10380f = true;
            return true;
        } else {
            if (!TextUtils.isEmpty(f10376b)) {
                f10380f = false;
                f10376b = null;
                return false;
            }
            return true;
        }
    }

    public static String d(Context context) {
        try {
        } catch (Throwable th) {
            d2.e(th, "AI", "gAN");
        }
        if (!"".equals(f10375a)) {
            return f10375a;
        }
        PackageManager packageManager = context.getPackageManager();
        f10375a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f10375a;
    }

    private static boolean e(String str) {
        char[] charArray;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c4 : str.toCharArray()) {
            if (('A' > c4 || c4 > 'z') && (('0' > c4 || c4 > ':') && c4 != '.')) {
                try {
                    g2.l(j1.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String f(Context context) {
        String str;
        try {
            str = f10376b;
        } catch (Throwable th) {
            d2.e(th, "AI", "gpck");
        }
        if (str != null && !"".equals(str)) {
            return f10376b;
        }
        String packageName = context.getPackageName();
        f10376b = packageName;
        if (!e(packageName)) {
            f10376b = context.getPackageName();
        }
        return f10376b;
    }

    public static String g(Context context) {
        try {
        } catch (Throwable th) {
            d2.e(th, "AI", "gAV");
        }
        if (!"".equals(f10377c)) {
            return f10377c;
        }
        f10377c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        String str = f10377c;
        return str == null ? "" : str;
    }

    public static String h(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(j1.t("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b4 : digest) {
                String upperCase = Integer.toHexString(b4 & 255).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (e(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(f10376b)) {
                str = f(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            f10379e = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            d2.e(th, "AI", "gsp");
            return f10379e;
        }
    }

    public static String i(Context context) {
        try {
            y0.e(context);
        } catch (Throwable unused) {
        }
        try {
            return k(context);
        } catch (Throwable th) {
            d2.e(th, "AI", "gKy");
            return f10378d;
        }
    }

    private static String j(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(e2.i(context, "k.store"));
        if (file.exists()) {
            try {
                fileInputStream = new FileInputStream(file);
            } catch (Throwable th2) {
                fileInputStream = null;
                th = th2;
            }
            try {
                byte[] bArr = new byte[fileInputStream.available()];
                fileInputStream.read(bArr);
                String g4 = j1.g(bArr);
                String str = g4.length() == 32 ? g4 : "";
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                return str;
            } catch (Throwable th4) {
                th = th4;
                try {
                    d2.e(th, "AI", "gKe");
                    if (file.exists()) {
                        file.delete();
                    }
                    return "";
                } finally {
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (Throwable th5) {
                            th5.printStackTrace();
                        }
                    }
                }
            }
        }
        return "";
    }

    private static String k(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = f10378d;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                String string = bundle.getString("com.amap.api.v2.apikey");
                f10378d = string;
                if (string == null) {
                    f10378d = j(context);
                }
            } else {
                return f10378d;
            }
        }
        return f10378d;
    }
}
