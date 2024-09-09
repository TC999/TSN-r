package com.tencent.ams.a.a.c;

import android.content.Context;
import android.content.pm.PackageManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.qq.e.comm.plugin.util.u0;
import java.util.HashMap;
import java.util.Map;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private static String f50684a;

    /* renamed from: b  reason: collision with root package name */
    private static String f50685b;

    /* renamed from: c  reason: collision with root package name */
    private static String f50686c;

    /* renamed from: d  reason: collision with root package name */
    private static HashMap<String, String> f50687d = new HashMap<>();

    public static String a() {
        return com.qq.e.comm.plugin.d0.a.d().c().f42280j;
    }

    public static String b() {
        return Build.VERSION.RELEASE;
    }

    public static String c(Context context) {
        if (f50685b == null && context != null) {
            f50685b = context.getPackageName();
        }
        return f50685b;
    }

    public static String d(Context context) {
        String str = f50686c;
        if (str != null) {
            return str;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null) {
            f50686c = "";
        } else {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
            f50686c = displayMetrics.widthPixels + "x" + displayMetrics.heightPixels;
        }
        return f50686c;
    }

    public static boolean e(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo networkInfo;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (networkInfo = connectivityManager.getNetworkInfo(1)) == null || networkInfo.getState() != NetworkInfo.State.CONNECTED) ? false : true;
    }

    public static Map<String, String> a(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        hashMap.put("OSVS", b());
        hashMap.put("TERM", a());
        hashMap.put("WIFI", e(context) ? "1" : "0");
        hashMap.put("ANAME", b(context));
        hashMap.put("AKEY", c(context));
        hashMap.put("OSVS", b());
        hashMap.put("OS", "0");
        hashMap.put("SCWH", d(context));
        hashMap.put("SDKVS", "1.2");
        return hashMap;
    }

    public static String b(Context context) {
        String str = f50684a;
        if (str != null) {
            return str;
        }
        PackageManager packageManager = context.getPackageManager();
        try {
            f50684a = packageManager.getApplicationInfo(context.getPackageName(), 128).loadLabel(packageManager).toString();
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return f50684a;
    }

    private static String c(Context context, String str, int i4) {
        String str2;
        WifiInfo connectionInfo;
        String str3 = str + i4 + "mac";
        String str4 = f50687d.get(str3);
        if (str4 != null) {
            return str4;
        }
        str2 = "";
        if (context != null && u0.c() && context.checkCallingOrSelfPermission("android.permission.ACCESS_WIFI_STATE") == 0) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (wifiManager != null && (connectionInfo = wifiManager.getConnectionInfo()) != null) {
                    str4 = connectionInfo.getMacAddress();
                    if (!TextUtils.isEmpty(str4)) {
                        str4 = a(i4, str4.replace(":", "").toUpperCase(), str);
                    }
                }
            } catch (Throwable unused) {
            }
            str2 = str4 != null ? str4 : "";
            f50687d.put(str3, str2);
        }
        return str2;
    }

    private static String b(Context context, String str, int i4) {
        String str2 = str + i4 + "imei";
        String str3 = f50687d.get(str2);
        if (str3 != null) {
            return str3;
        }
        if (u0.b()) {
            String a4 = com.qq.e.comm.plugin.m.b.f44639e.b().a(context);
            if (!TextUtils.isEmpty(a4)) {
                a4 = a(i4, a4, str);
            }
            String str4 = a4 != null ? a4 : "";
            f50687d.put(str2, str4);
            return str4;
        }
        return "";
    }

    public static HashMap<String, String> d(Context context, String str, int i4) {
        HashMap<String, String> hashMap = new HashMap<>(3);
        hashMap.put("MAC", c(context, str, i4));
        hashMap.put("IMEI", b(context, str, i4));
        hashMap.put("ANDROIDID", a(context, str, i4));
        return hashMap;
    }

    private static String a(Context context, String str, int i4) {
        String str2 = str + i4 + "androidId";
        String str3 = f50687d.get(str2);
        if (str3 != null) {
            return str3;
        }
        if (u0.a()) {
            try {
                String a4 = com.qq.e.comm.plugin.m.b.f44640f.b().a(context);
                str3 = (TextUtils.isEmpty(a4) || "9774d56d682e549c".equals(a4) || a4.length() < 15) ? "" : a(i4, a4, str);
            } catch (Throwable unused) {
            }
            f50687d.put(str2, str3);
            return str3;
        }
        return "";
    }

    private static String a(int i4, String str, String str2) {
        if (i4 == 1) {
            return a.c(str + str2);
        } else if (i4 == 2) {
            return a.c(a.c(str) + str2);
        } else {
            return a.c(str);
        }
    }
}
