package com.beizi.fusion.g;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.stub.StubApp;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: SystemUtil.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class aw {

    /* renamed from: a  reason: collision with root package name */
    private static String f14902a = "SystemUtil";

    public static boolean a(Context context, String str) {
        PackageInfo packageInfo;
        if (context == null || str == null || str.isEmpty()) {
            return false;
        }
        try {
            packageInfo = context.getPackageManager().getPackageInfo(str, 0);
        } catch (Throwable unused) {
            packageInfo = null;
        }
        return packageInfo != null;
    }

    public static long b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    public static String c(Context context) {
        return context.getPackageName();
    }

    public static String d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static int e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String f(Context context) {
        try {
            return (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean g(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean h(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean i(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
        } catch (Exception e4) {
            e4.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static float j(Context context) {
        float f4 = context.getResources().getDisplayMetrics().density;
        float f5 = context.getResources().getDisplayMetrics().widthPixels;
        if (f4 <= 0.0f) {
            f4 = 1.0f;
        }
        return (f5 / f4) + 0.5f;
    }

    public static float k(Context context) {
        return b(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    public static float l(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static float m(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int n(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels;
    }

    public static int o(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
    }

    public static Long p(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            return Long.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime);
        } catch (Exception unused) {
            return 0L;
        }
    }

    private static boolean c(String str) {
        Process process = null;
        try {
            try {
                Runtime runtime = Runtime.getRuntime();
                process = runtime.exec("ls -l " + str);
                String readLine = new BufferedReader(new InputStreamReader(process.getInputStream())).readLine();
                if (readLine != null && readLine.length() >= 4) {
                    char charAt = readLine.charAt(3);
                    if (charAt == 's' || charAt == 'x') {
                        process.destroy();
                        return true;
                    }
                }
            } catch (IOException e4) {
                e4.printStackTrace();
                if (process == null) {
                    return false;
                }
            }
            process.destroy();
            return false;
        } catch (Throwable th) {
            if (process != null) {
                process.destroy();
            }
            throw th;
        }
    }

    public static long a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000a A[Catch: all -> 0x002a, Exception -> 0x002f, TryCatch #2 {Exception -> 0x002f, all -> 0x002a, blocks: (B:2:0x0000, B:3:0x0004, B:5:0x000a, B:7:0x001c), top: B:17:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean b() {
        /*
            java.util.Enumeration r0 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2f
        L4:
            boolean r1 = r0.hasMoreElements()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2f
            if (r1 == 0) goto L33
            java.lang.Object r1 = r0.nextElement()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2f
            java.net.NetworkInterface r1 = (java.net.NetworkInterface) r1     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2f
            java.lang.String r2 = "tun0"
            java.lang.String r3 = r1.getName()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2f
            boolean r2 = r2.equals(r3)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2f
            if (r2 != 0) goto L28
            java.lang.String r2 = "ppp0"
            java.lang.String r1 = r1.getName()     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2f
            boolean r1 = r2.equals(r1)     // Catch: java.lang.Throwable -> L2a java.lang.Exception -> L2f
            if (r1 == 0) goto L4
        L28:
            r0 = 1
            return r0
        L2a:
            r0 = move-exception
            r0.printStackTrace()
            goto L33
        L2f:
            r0 = move-exception
            r0.printStackTrace()
        L33:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.g.aw.b():boolean");
    }

    public static String a() {
        return (new File("/system/bin/su").exists() && c("/system/bin/su")) ? "yes" : (new File("/system/xbin/su").exists() && c("/system/xbin/su")) ? "yes" : "no";
    }

    public static int a(Context context, float f4) {
        return (int) ((f4 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static boolean a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public static void a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    public static int b(Context context, float f4) {
        return (int) ((f4 / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static void b(String str) {
        new IllegalArgumentException(str).printStackTrace();
    }
}
