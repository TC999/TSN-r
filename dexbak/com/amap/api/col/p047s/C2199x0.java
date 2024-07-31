package com.amap.api.col.p047s;

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
import kotlin.UByte;

/* compiled from: AppInfo.java */
/* renamed from: com.amap.api.col.s.x0 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class C2199x0 {

    /* renamed from: a */
    private static String f6647a = "";

    /* renamed from: b */
    private static String f6648b = "";

    /* renamed from: c */
    private static String f6649c = "";

    /* renamed from: d */
    private static String f6650d = "";

    /* renamed from: e */
    static String f6651e;

    /* renamed from: f */
    static boolean f6652f;

    /* renamed from: a */
    public static String m52335a(Context context) {
        try {
            return m52325k(context);
        } catch (Throwable th) {
            th.printStackTrace();
            return f6650d;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: b */
    public static void m52334b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        f6650d = str;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: c */
    public static boolean m52333c() {
        if (f6652f) {
            return true;
        }
        if (m52331e(f6651e)) {
            f6652f = true;
            return true;
        } else if (!TextUtils.isEmpty(f6651e)) {
            f6652f = false;
            f6651e = null;
            return false;
        } else if (m52331e(f6648b)) {
            f6652f = true;
            return true;
        } else {
            if (!TextUtils.isEmpty(f6648b)) {
                f6652f = false;
                f6648b = null;
                return false;
            }
            return true;
        }
    }

    /* renamed from: d */
    public static String m52332d(Context context) {
        try {
        } catch (Throwable th) {
            C2041d2.m53085e(th, "AI", "gAN");
        }
        if (!"".equals(f6647a)) {
            return f6647a;
        }
        PackageManager packageManager = context.getPackageManager();
        f6647a = (String) packageManager.getApplicationLabel(packageManager.getApplicationInfo(context.getPackageName(), 0));
        return f6647a;
    }

    /* renamed from: e */
    private static boolean m52331e(String str) {
        char[] charArray;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        str.toCharArray();
        for (char c : str.toCharArray()) {
            if (('A' > c || c > 'z') && (('0' > c || c > ':') && c != '.')) {
                try {
                    C2060g2.m52975l(C2079j1.m52876a(), str, "errorPackage");
                } catch (Throwable unused) {
                }
                return false;
            }
        }
        return true;
    }

    /* renamed from: f */
    public static String m52330f(Context context) {
        String str;
        try {
            str = f6648b;
        } catch (Throwable th) {
            C2041d2.m53085e(th, "AI", "gpck");
        }
        if (str != null && !"".equals(str)) {
            return f6648b;
        }
        String packageName = context.getPackageName();
        f6648b = packageName;
        if (!m52331e(packageName)) {
            f6648b = context.getPackageName();
        }
        return f6648b;
    }

    /* renamed from: g */
    public static String m52329g(Context context) {
        try {
        } catch (Throwable th) {
            C2041d2.m53085e(th, "AI", "gAV");
        }
        if (!"".equals(f6649c)) {
            return f6649c;
        }
        f6649c = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        String str = f6649c;
        return str == null ? "" : str;
    }

    /* renamed from: h */
    public static String m52328h(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 64);
            byte[] digest = MessageDigest.getInstance(C2079j1.m52857t("IU0hBMQ")).digest(packageInfo.signatures[0].toByteArray());
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String upperCase = Integer.toHexString(b & UByte.f41242c).toUpperCase(Locale.US);
                if (upperCase.length() == 1) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(upperCase);
                stringBuffer.append(":");
            }
            String str = packageInfo.packageName;
            if (m52331e(str)) {
                str = packageInfo.packageName;
            }
            if (!TextUtils.isEmpty(f6648b)) {
                str = m52330f(context);
            }
            stringBuffer.append(str);
            String stringBuffer2 = stringBuffer.toString();
            f6651e = stringBuffer2;
            return stringBuffer2;
        } catch (Throwable th) {
            C2041d2.m53085e(th, "AI", "gsp");
            return f6651e;
        }
    }

    /* renamed from: i */
    public static String m52327i(Context context) {
        try {
            C2212y0.m52227e(context);
        } catch (Throwable unused) {
        }
        try {
            return m52325k(context);
        } catch (Throwable th) {
            C2041d2.m53085e(th, "AI", "gKy");
            return f6650d;
        }
    }

    /* renamed from: j */
    private static String m52326j(Context context) {
        FileInputStream fileInputStream;
        Throwable th;
        File file = new File(C2051e2.m53017i(context, "k.store"));
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
                String m52870g = C2079j1.m52870g(bArr);
                String str = m52870g.length() == 32 ? m52870g : "";
                try {
                    fileInputStream.close();
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
                return str;
            } catch (Throwable th4) {
                th = th4;
                try {
                    C2041d2.m53085e(th, "AI", "gKe");
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

    /* renamed from: k */
    private static String m52325k(Context context) throws PackageManager.NameNotFoundException {
        Bundle bundle;
        String str = f6650d;
        if (str == null || str.equals("")) {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null && (bundle = applicationInfo.metaData) != null) {
                String string = bundle.getString("com.amap.api.v2.apikey");
                f6650d = string;
                if (string == null) {
                    f6650d = m52326j(context);
                }
            } else {
                return f6650d;
            }
        }
        return f6650d;
    }
}
