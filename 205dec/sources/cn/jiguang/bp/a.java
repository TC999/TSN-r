package cn.jiguang.bp;

import android.content.Context;
import android.content.pm.PackageInfo;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static String f2809a;

    /* renamed from: b  reason: collision with root package name */
    private static String f2810b;

    private static Object a(Class cls, String str) {
        return cls.getMethod(str, new Class[0]).invoke(cls, new Object[0]);
    }

    public static String a() {
        try {
            return String.valueOf(a(Class.forName("ohos.system.version.SystemVersion"), "getMajorVersion"));
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String a(Context context) {
        if (f2809a == null) {
            c(context);
        }
        String str = f2809a;
        return str == null ? "" : str;
    }

    public static String b(Context context) {
        if (f2810b == null) {
            c(context);
        }
        String str = f2810b;
        return str == null ? "" : str;
    }

    private static void c(Context context) {
        try {
            PackageInfo a4 = cn.jiguang.f.a.a(context, 0);
            if (a4 == null) {
                h.b("AndoridUtils", "NO versionName defined in manifest.");
                return;
            }
            String str = a4.versionName;
            f2810b = context.getResources().getString(a4.applicationInfo.labelRes);
            if (str.length() > 30) {
                str = str.substring(0, 30);
            }
            f2809a = str;
        } catch (Throwable unused) {
            h.b("AndoridUtils", "NO versionName defined in manifest.");
        }
    }
}
