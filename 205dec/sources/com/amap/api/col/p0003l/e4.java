package com.amap.api.col.p0003l;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.util.Locale;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* compiled from: AppInfo.java */
/* renamed from: com.amap.api.col.3l.e4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class e4 {

    /* renamed from: a  reason: collision with root package name */
    private static String f7480a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f7481b = "";

    /* renamed from: c  reason: collision with root package name */
    private static String f7482c = "";

    /* renamed from: d  reason: collision with root package name */
    private static String f7483d = "";

    /* renamed from: e  reason: collision with root package name */
    static String f7484e;

    /* renamed from: f  reason: collision with root package name */
    static boolean f7485f;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
    /* compiled from: AppInfo.java */
    /* renamed from: com.amap.api.col.3l.e4$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    final class a extends a8 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Context f7486a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f7487b;

        a(Context context, String str) {
            this.f7486a = context;
            this.f7487b = str;
        }

        @Override // com.amap.api.col.p0003l.a8
        public final void runTask() {
            FileOutputStream fileOutputStream;
            FileOutputStream fileOutputStream2 = null;
            try {
                File file = new File(r5.i(this.f7486a, "k.store"));
                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }
                fileOutputStream = new FileOutputStream(file);
            } catch (Throwable th) {
                th = th;
            }
            try {
                fileOutputStream.write(q4.o(this.f7487b));
                try {
                    fileOutputStream.close();
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            } catch (Throwable th3) {
                th = th3;
                fileOutputStream2 = fileOutputStream;
                try {
                    q5.e(th, "AI", "stf");
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th4) {
                            th4.printStackTrace();
                        }
                    }
                } catch (Throwable th5) {
                    if (fileOutputStream2 != null) {
                        try {
                            fileOutputStream2.close();
                        } catch (Throwable th6) {
                            th6.printStackTrace();
                        }
                    }
                    throw th5;
                }
            }
        }
    }

    public static String a(Context context) {
        try {
            return l(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f7483d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void b(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f7483d = str;
        if (context != null) {
            z7.h().b(new a(context, str));
        }
    }

    public static void c(String str) {
        f7481b = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean d() {
        if (f7485f) {
            return true;
        }
        if (f(f7484e)) {
            f7485f = true;
            return true;
        } else if (!TextUtils.isEmpty(f7484e)) {
            f7485f = false;
            f7484e = null;
            return false;
        } else if (f(f7481b)) {
            f7485f = true;
            return true;
        } else {
            if (!TextUtils.isEmpty(f7481b)) {
                f7485f = false;
                f7481b = null;
                return false;
            }
            return true;
        }
    }

    public static String e(Context context) {
        try {
        } catch (Throwable th) {
            q5.e(th, "AI", "gAN");
        }
        if (!"".equals(f7480a)) {
            return f7480a;
        }
        PackageManager packageManager = context.getPackageManager();
        f7480a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f7480a;
    }

    private static boolean f(String str) {
        char[] charArray;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c4 : str.toCharArray()) {
            if (('A' > c4 || c4 > 'z') && (('0' > c4 || c4 > ':') && c4 != '.')) {
                try {
                    u5.o(q4.a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    public static String g(Context context) {
        String str;
        try {
            str = f7481b;
        } catch (Throwable th) {
            q5.e(th, "AI", "gpck");
        }
        if (str != null && !"".equals(str)) {
            return f7481b;
        }
        String packageName = context.getPackageName();
        f7481b = packageName;
        if (!f(packageName)) {
            f7481b = context.getPackageName();
        }
        return f7481b;
    }

    public static String h(Context context) {
        try {
        } catch (Throwable th) {
            q5.e(th, "AI", "gAV");
        }
        if (!"".equals(f7482c)) {
            return f7482c;
        }
        f7482c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        String str = f7482c;
        return str == null ? "" : str;
    }

    public static String i(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(q4.u("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
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
            if (f(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(f7481b)) {
                str = g(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            f7484e = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            q5.e(th, "AI", "gsp");
            return f7484e;
        }
    }

    public static String j(Context context) {
        try {
            g4.g(context);
        } catch (Throwable unused) {
        }
        try {
            return l(context);
        } catch (Throwable th) {
            q5.e(th, "AI", "gKy");
            return f7483d;
        }
    }

    private static String k(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(r5.i(context, "k.store"));
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
                String g4 = q4.g(bArr);
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
                    q5.e(th, "AI", "gKe");
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

    private static String l(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = f7483d;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                String string = bundle.getString("com.amap.api.v2.apikey");
                f7483d = string;
                if (string == null) {
                    f7483d = k(context);
                }
            } else {
                return f7483d;
            }
        }
        return f7483d;
    }
}
