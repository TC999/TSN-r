package com.beizi.fusion.p072g;

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

/* compiled from: SystemUtil.java */
/* renamed from: com.beizi.fusion.g.av */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class C3138av {

    /* renamed from: a */
    private static String f11347a = "SystemUtil";

    /* renamed from: a */
    public static boolean m48303a(Context context, String str) {
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

    /* renamed from: b */
    public static long m48299b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    /* renamed from: c */
    public static String m48296c(Context context) {
        return context.getPackageName();
    }

    /* renamed from: d */
    public static String m48294d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    /* renamed from: e */
    public static int m48293e(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (Throwable unused) {
            return 0;
        }
    }

    /* renamed from: f */
    public static String m48292f(Context context) {
        try {
            return (String) context.getPackageManager().getApplicationLabel(context.getApplicationInfo());
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: g */
    public static boolean m48291g(Context context) {
        try {
            return (context.getApplicationInfo().flags & 2) != 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: h */
    public static boolean m48290h(Context context) {
        try {
            return Settings.Secure.getInt(context.getContentResolver(), "adb_enabled", 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: i */
    public static boolean m48289i(Context context) {
        try {
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            return (TextUtils.isEmpty(property) || Integer.parseInt(property2) == -1) ? false : true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* renamed from: j */
    public static float m48288j(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    /* renamed from: k */
    public static float m48287k(Context context) {
        return m48298b(context, context.getResources().getDisplayMetrics().heightPixels);
    }

    /* renamed from: l */
    public static float m48286l(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: m */
    public static float m48285m(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: n */
    public static int m48284n(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().widthPixels;
    }

    /* renamed from: o */
    public static int m48283o(Context context) {
        return StubApp.getOrigApplicationContext(context.getApplicationContext()).getResources().getDisplayMetrics().heightPixels;
    }

    /* renamed from: p */
    public static Long m48282p(Context context) {
        if (context == null) {
            return 0L;
        }
        try {
            return Long.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).lastUpdateTime);
        } catch (Exception unused) {
            return 0L;
        }
    }

    /* renamed from: c */
    private static boolean m48295c(String str) {
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
            } catch (IOException e) {
                e.printStackTrace();
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

    /* renamed from: a */
    public static long m48305a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).firstInstallTime;
        } catch (Throwable th) {
            th.printStackTrace();
            return 0L;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x000a A[Catch: all -> 0x002a, Exception -> 0x002f, TryCatch #2 {Exception -> 0x002f, all -> 0x002a, blocks: (B:2:0x0000, B:3:0x0004, B:5:0x000a, B:7:0x001c), top: B:17:0x0000 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean m48300b() {
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
        throw new UnsupportedOperationException("Method not decompiled: com.beizi.fusion.p072g.C3138av.m48300b():boolean");
    }

    /* renamed from: a */
    public static String m48306a() {
        return (new File("/system/bin/su").exists() && m48295c("/system/bin/su")) ? "yes" : (new File("/system/xbin/su").exists() && m48295c("/system/xbin/su")) ? "yes" : "no";
    }

    /* renamed from: a */
    public static int m48304a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static boolean m48301a(String str) {
        try {
            Class.forName(str);
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m48302a(View view) {
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view);
            }
        }
    }

    /* renamed from: b */
    public static int m48298b(Context context, float f) {
        return (int) ((f / context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: b */
    public static void m48297b(String str) {
        new IllegalArgumentException(str).printStackTrace();
    }
}
