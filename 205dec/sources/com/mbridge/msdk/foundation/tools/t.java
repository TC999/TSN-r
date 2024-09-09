package com.mbridge.msdk.foundation.tools;

import android.app.ActivityManager;
import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.acse.ottn.c4;
import com.mbridge.msdk.MBridgeConstans;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: SameDiTool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class t extends e {

    /* renamed from: a  reason: collision with root package name */
    private static String f39902a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f39903b = null;

    /* renamed from: c  reason: collision with root package name */
    private static int f39904c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static int f39905d = -1;

    /* renamed from: e  reason: collision with root package name */
    private static volatile int f39906e = -1;

    /* renamed from: f  reason: collision with root package name */
    private static String f39907f = "";

    /* renamed from: g  reason: collision with root package name */
    private static String f39908g = "";

    /* renamed from: h  reason: collision with root package name */
    private static String f39909h = "";

    /* renamed from: i  reason: collision with root package name */
    private static String f39910i = "";

    /* renamed from: j  reason: collision with root package name */
    private static int f39911j = 0;

    /* renamed from: k  reason: collision with root package name */
    private static String f39912k = "";

    /* renamed from: l  reason: collision with root package name */
    private static String f39913l = "";

    /* renamed from: m  reason: collision with root package name */
    private static int f39914m = -1;

    /* renamed from: n  reason: collision with root package name */
    private static String f39915n = "";

    /* renamed from: o  reason: collision with root package name */
    private static int f39916o = 0;

    /* renamed from: p  reason: collision with root package name */
    private static String f39917p = "";

    /* renamed from: q  reason: collision with root package name */
    private static String f39918q = null;

    /* renamed from: r  reason: collision with root package name */
    private static int f39919r = 0;

    /* renamed from: s  reason: collision with root package name */
    private static int f39920s = -1;

    /* renamed from: t  reason: collision with root package name */
    private static int f39921t = -1;

    /* renamed from: u  reason: collision with root package name */
    private static Object f39922u = null;

    /* renamed from: v  reason: collision with root package name */
    private static int f39923v = 0;

    /* renamed from: w  reason: collision with root package name */
    private static int f39924w = 0;

    /* renamed from: x  reason: collision with root package name */
    private static int f39925x = -1;

    public static String A(Context context) {
        if (context == null) {
            return f39909h;
        }
        try {
            if (TextUtils.isEmpty(f39909h)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                f39909h = str;
                return str;
            }
            return f39909h;
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static void B(final Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                e.p(context);
            } else {
                new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.t.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        e.p(context);
                    }
                });
            }
        } catch (Exception e4) {
            x.b("SameDiTool", "", e4);
        }
    }

    public static String C(final Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            if (TextUtils.isEmpty(f39907f)) {
                try {
                    f39907f = ae.b(context, "mbridge_ua", "").toString();
                } catch (Throwable th) {
                    x.b("SameDiTool", th.getMessage(), th);
                }
            }
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    if (TextUtils.isEmpty(f39907f)) {
                        try {
                            f39907f = WebSettings.getDefaultUserAgent(context);
                        } catch (Throwable unused) {
                        }
                        if (TextUtils.isEmpty(f39907f)) {
                            Constructor declaredConstructor = WebSettings.class.getDeclaredConstructor(Context.class, WebView.class);
                            declaredConstructor.setAccessible(true);
                            f39907f = ((WebSettings) declaredConstructor.newInstance(context, null)).getUserAgentString();
                            declaredConstructor.setAccessible(false);
                            if (TextUtils.isEmpty(f39907f)) {
                                f39907f = new WebView(context).getSettings().getUserAgentString();
                            }
                            if (TextUtils.isEmpty(f39907f)) {
                                Q();
                            }
                        }
                    } else {
                        try {
                            new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.t.2
                                @Override // java.lang.Runnable
                                public final void run() {
                                    String str;
                                    try {
                                        try {
                                            str = WebSettings.getDefaultUserAgent(context);
                                        } catch (Throwable th2) {
                                            th2.printStackTrace();
                                            return;
                                        }
                                    } catch (Exception unused2) {
                                        str = null;
                                    }
                                    if (TextUtils.isEmpty(str) || str.equals(t.f39907f)) {
                                        return;
                                    }
                                    String unused3 = t.f39907f = str;
                                    t.H(context);
                                }
                            }).start();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                } else {
                    Q();
                }
            } catch (Throwable th2) {
                x.b("SameDiTool", th2.getMessage(), th2);
            }
            H(context);
            return f39907f;
        }
        return null;
    }

    public static int D(Context context) {
        try {
            final Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                if (j4 == null) {
                    return f39906e;
                }
                if (f39906e != -1) {
                    Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.t.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                ConnectivityManager connectivityManager = (ConnectivityManager) j4.getSystemService("connectivity");
                                if (connectivityManager != null && com.mbridge.msdk.foundation.same.a.f39379g) {
                                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                    if (activeNetworkInfo == null) {
                                        int unused = t.f39906e = 0;
                                    } else if (activeNetworkInfo.getType() == 1) {
                                        int unused2 = t.f39906e = 9;
                                    } else {
                                        TelephonyManager telephonyManager = (TelephonyManager) j4.getSystemService("phone");
                                        if (telephonyManager == null) {
                                            int unused3 = t.f39906e = 0;
                                        } else {
                                            int unused4 = t.f39906e = t.a(telephonyManager.getNetworkType());
                                        }
                                    }
                                }
                            } catch (Exception e4) {
                                x.b("SameDiTool", e4.getMessage(), e4);
                                int unused5 = t.f39906e = 0;
                            }
                        }
                    };
                    if (com.mbridge.msdk.foundation.same.f.b.c().getActiveCount() < 1) {
                        com.mbridge.msdk.foundation.same.f.b.c().execute(runnable);
                    }
                    return f39906e;
                }
                f39906e = 0;
                return f39906e;
            }
            return f39906e;
        } catch (Exception e4) {
            x.b("SameDiTool", e4.getMessage(), e4);
            f39906e = 0;
            return f39906e;
        }
    }

    public static String E() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID) ? "" : !com.mbridge.msdk.foundation.controller.authoritycontroller.a.g() ? TextUtils.isEmpty(f39902a) ? "" : f39902a : TextUtils.isEmpty(f39902a) ? "" : f39902a;
    }

    public static String F() {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                return TextUtils.isEmpty(f39903b) ? "" : f39903b;
            }
            String str = f39903b;
            return str == null ? "" : str;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void H(Context context) {
        try {
            ae.a(context, "mbridge_ua", f39907f);
        } catch (Throwable th) {
            x.b("SameDiTool", th.getMessage(), th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v11, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v17 */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.io.BufferedReader] */
    /* JADX WARN: Type inference failed for: r1v3, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9, types: [java.io.BufferedReader] */
    public static String I() {
        FileReader fileReader;
        Throwable th;
        Exception e4;
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            if (f39919r > 0) {
                return f39919r + "GB";
            }
            ?? r12 = "/proc/meminfo";
            f39919r = 0;
            try {
            } catch (IOException e5) {
                e5.printStackTrace();
            }
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        r12 = new BufferedReader(fileReader, 8192);
                        try {
                            String str = r12.readLine().split("\\s+")[1];
                            r12.close();
                            if (str != null) {
                                f39919r = (int) Math.ceil(new Float(Float.valueOf(str).floatValue() / 1048576.0f).doubleValue());
                            }
                            try {
                                fileReader.close();
                            } catch (IOException unused) {
                            }
                            r12.close();
                        } catch (Exception e6) {
                            e4 = e6;
                            x.b("SameDiTool", e4.getMessage(), e4);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (r12 != 0) {
                                r12.close();
                            }
                            return f39919r + "GB";
                        } catch (Throwable th2) {
                            th = th2;
                            x.b("SameDiTool", th.getMessage(), th);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (r12 != 0) {
                                r12.close();
                            }
                            return f39919r + "GB";
                        }
                    } catch (Exception e7) {
                        e4 = e7;
                        r12 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        r12 = 0;
                    }
                } catch (Exception e8) {
                    fileReader = null;
                    e4 = e8;
                    r12 = 0;
                } catch (Throwable th4) {
                    fileReader = null;
                    th = th4;
                    r12 = 0;
                }
                return f39919r + "GB";
            } catch (Throwable th5) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException unused4) {
                    }
                }
                if (r12 != 0) {
                    try {
                        r12.close();
                    } catch (IOException e9) {
                        e9.printStackTrace();
                    }
                }
                throw th5;
            }
        }
        return "";
    }

    public static String J() {
        Context j4;
        long currentTimeMillis;
        long R;
        String str;
        String str2;
        String str3 = "";
        try {
            j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            R = R();
            str = "app_tki_" + currentTimeMillis + "_" + R;
            str2 = (String) ae.b(j4, str, "");
            try {
            } catch (Exception e4) {
                e = e4;
                str3 = str2;
                e.printStackTrace();
                return str3;
            }
        } catch (Exception e5) {
            e = e5;
        }
        if (TextUtils.isEmpty(str2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("1", "");
                jSONObject.put("2", String.valueOf(R));
                jSONObject.put("3", String.valueOf(currentTimeMillis));
                jSONObject.put("4", "");
                jSONObject.put("5", "");
            } catch (Exception e6) {
                e6.printStackTrace();
            }
            str3 = a.a(jSONObject.toString());
            ae.a(j4, str, str3);
            return str3;
        }
        return str2;
    }

    public static int K() {
        try {
        } catch (Throwable th) {
            x.b("SameDiTool", th.getMessage(), th);
        }
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            long j5 = 0;
            long longValue = ((Long) ae.b(j4, "FreeRamSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || f39905d == -1) {
                Context j6 = com.mbridge.msdk.foundation.controller.a.f().j();
                if (j6 != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) j6.getSystemService("activity")).getMemoryInfo(memoryInfo);
                    j5 = memoryInfo.availMem;
                }
                f39905d = Long.valueOf((j5 / 1000) / 1000).intValue();
                ae.a(j4, "FreeRamSize", Long.valueOf(currentTimeMillis));
            }
            return f39905d;
        }
        return 0;
    }

    public static int L() {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            if (f39904c < 1) {
                try {
                    Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
                    long longValue = ((Long) ae.b(j4, "TotalRamSize", 0L)).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - longValue > 1800000 || f39904c == -1) {
                        f39904c = Long.valueOf((R() / 1000) / 1000).intValue();
                        ae.a(j4, "TotalRamSize", Long.valueOf(currentTimeMillis));
                    }
                } catch (Throwable th) {
                    x.b("SameDiTool", th.getMessage(), th);
                }
            }
            return f39904c;
        }
        return 0;
    }

    public static int M() {
        return f39914m;
    }

    public static String N() {
        if (!TextUtils.isEmpty(f39917p)) {
            return f39917p;
        }
        JSONObject jSONObject = new JSONObject();
        String str = null;
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable th) {
            x.d("SameDiTool", th.getMessage());
        }
        try {
            if (!TextUtils.isEmpty(str) && str.equals(c4.f5363a)) {
                jSONObject.put("osType", str);
                Class<?> cls2 = Class.forName("ohos.system.version.SystemVersion");
                jSONObject.put("version", (String) cls2.getMethod("getVersion", new Class[0]).invoke(cls2, new Object[0]));
                jSONObject.put("pure_state", Settings.Secure.getInt(com.mbridge.msdk.foundation.controller.a.f().j().getContentResolver(), "pure_mode_state", -1));
                String jSONObject2 = jSONObject.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    jSONObject2 = s.a(jSONObject2);
                }
                f39917p = jSONObject2;
            } else {
                f39917p = "android";
            }
        } catch (Throwable th2) {
            x.d("SameDiTool", th2.getMessage());
        }
        return f39917p;
    }

    public static int O() {
        return f39925x;
    }

    private static void Q() {
        String str = Build.VERSION.RELEASE;
        String x3 = x();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(x3)) {
            f39907f = "Mozilla/5.0 (Linux; Android " + str + "; " + x3 + " Build/) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
            return;
        }
        f39907f = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
    }

    private static long R() {
        Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
        if (j4 != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) j4.getSystemService("activity")).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        return 0L;
    }

    public static int a(int i4) {
        switch (i4) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                return 2;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                return 3;
            case 13:
            case 18:
            case 19:
                return 4;
            case 20:
                return 5;
            default:
                return 0;
        }
    }

    public static String a(Context context, int i4) {
        TelephonyManager telephonyManager;
        if (i4 == 0 || i4 == 9) {
            return "";
        }
        try {
            return (!com.mbridge.msdk.foundation.same.a.f39379g || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : String.valueOf(telephonyManager.getNetworkType());
        } catch (Throwable th) {
            x.b("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    public static void b(int i4) {
        f39925x = i4;
    }

    public static Object f(String str) {
        if (f39922u == null) {
            f39922u = ac.d(str);
        }
        return f39922u;
    }

    public static int g(String str) {
        if (f39923v == 0) {
            f39923v = ac.e(str);
        }
        return f39923v;
    }

    public static void h(String str) {
        f39903b = s.a(str);
        f39902a = str;
    }

    public static void q(Context context) {
        try {
            C();
            A(context);
            v(context);
            u(context);
            t(context);
            x();
            z();
            E();
            s(context);
            B();
            com.mbridge.msdk.foundation.same.a.f39380h = false;
            com.mbridge.msdk.foundation.same.a.f39379g = ac.a("android.permission.ACCESS_NETWORK_STATE", context);
            w(context);
            try {
                e.g(context);
                e.b(context);
                e.c(context);
                e.i(context);
                e.j(context);
                try {
                    int D = D();
                    if (D >= 17 && D < 21) {
                        f39914m = Settings.Global.getInt(com.mbridge.msdk.foundation.controller.a.f().j().getContentResolver(), "install_non_market_apps", 0);
                    } else if (D >= 21 || (D < 17 && D > 10)) {
                        f39914m = Settings.Secure.getInt(com.mbridge.msdk.foundation.controller.a.f().j().getContentResolver(), "install_non_market_apps", 0);
                    }
                } catch (Throwable th) {
                    x.b("SameDiTool", th.getMessage(), th);
                }
                x.d("SameDiTool", "getUSSForPe:" + f39914m);
                com.mbridge.msdk.foundation.same.a.f39382j = ac.a("android.permission.GET_TASKS", context);
                com.mbridge.msdk.foundation.same.a.f39381i = false;
                e.a(context);
            } catch (Throwable unused) {
            }
            N();
        } catch (Throwable unused2) {
        }
    }

    public static int r(Context context) {
        if (f39920s == -1) {
            f39920s = ac.c(context, "com.tencent.mm") ? 1 : 0;
        }
        return f39920s;
    }

    public static String s(Context context) {
        Locale locale;
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            if (TextUtils.isEmpty(f39912k)) {
                if (context == null) {
                    return "en-US";
                }
                try {
                    if (context.getResources() == null || context.getResources().getConfiguration() == null || (locale = context.getResources().getConfiguration().locale) == null) {
                        return "en-US";
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        f39912k = locale.toLanguageTag();
                    } else {
                        f39912k = locale.getLanguage() + "-" + locale.getCountry();
                    }
                    return f39912k;
                } catch (Throwable th) {
                    x.a("SameDiTool", th.getMessage());
                    f39912k = "en-US";
                }
            }
            return f39912k;
        }
        return "";
    }

    public static int t(Context context) {
        Configuration configuration;
        return (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null || configuration.orientation != 2) ? 1 : 2;
    }

    public static int u(Context context) {
        if (context == null) {
            return f39911j;
        }
        int i4 = f39911j;
        if (i4 == 0) {
            try {
                int i5 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                f39911j = i5;
                return i5;
            } catch (Exception e4) {
                e4.printStackTrace();
                return -1;
            }
        }
        return i4;
    }

    public static int v() {
        if (f39921t == -1) {
            f39921t = ac.c() ? 1 : 0;
        }
        return f39921t;
    }

    public static int w() {
        if (f39924w == 0) {
            f39924w = ac.d();
        }
        return f39924w;
    }

    public static String x() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MODEL;
    }

    public static String y() {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return Build.MANUFACTURER + " " + Build.MODEL;
        }
        return "";
    }

    public static String z() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.BRAND;
    }

    public static UUID G() {
        try {
            return UUID.randomUUID();
        } catch (Throwable th) {
            x.b("SameDiTool", th.getMessage(), th);
            return null;
        }
    }

    public static String H() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MANUFACTURER;
    }

    public static int x(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                HashMap z3 = z(context);
                return z3.get("width") == null ? displayMetrics.widthPixels : ((Integer) z3.get("width")).intValue();
            } catch (Exception e4) {
                e4.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static int y(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                HashMap z3 = z(context);
                return z3.get("height") == null ? displayMetrics.heightPixels : ((Integer) z3.get("height")).intValue();
            } catch (Exception e4) {
                e4.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    public static HashMap z(Context context) {
        HashMap hashMap = new HashMap();
        if (context == null) {
            return hashMap;
        }
        try {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            hashMap.put("height", Integer.valueOf(displayMetrics.heightPixels));
            hashMap.put("width", Integer.valueOf(displayMetrics.widthPixels));
        } catch (Exception e4) {
            x.b("SameDiTool", e4.getMessage(), e4);
        }
        return hashMap;
    }

    public static String v(Context context) {
        if (context == null) {
            return f39910i;
        }
        try {
            if (TextUtils.isEmpty(f39910i)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                f39910i = str;
                return str;
            }
            return f39910i;
        } catch (Exception e4) {
            e4.printStackTrace();
            return "";
        }
    }

    public static int w(Context context) {
        if (context == null) {
            return f39916o;
        }
        if (f39916o == 0) {
            try {
                f39916o = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e4) {
                x.d("SameDiTool", e4.getMessage());
            }
        }
        return f39916o;
    }

    public static String B() {
        try {
        } catch (Throwable th) {
            x.b("SameDiTool", th.getMessage(), th);
        }
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_OTHER)) {
            if (TextUtils.isEmpty(f39913l)) {
                new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.t.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            String unused = t.f39913l = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }).start();
                return f39913l;
            }
            return f39913l;
        }
        return "";
    }

    public static String F(Context context) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            if (!TextUtils.isEmpty(f39918q)) {
                return f39918q;
            }
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    try {
                        fileReader = new FileReader("/proc/meminfo");
                        try {
                            bufferedReader = new BufferedReader(fileReader, 8192);
                        } catch (IOException e4) {
                            e = e4;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (IOException e5) {
                        e = e5;
                        fileReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader = null;
                    }
                    try {
                        String formatFileSize = Formatter.formatFileSize(context, Long.valueOf(bufferedReader.readLine().split("\\s+")[1]).longValue() * 1024);
                        f39918q = formatFileSize;
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            x.b("SameDiTool", e6.getMessage(), e6);
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e7) {
                            x.b("SameDiTool", e7.getMessage(), e7);
                        }
                        return formatFileSize;
                    } catch (IOException e8) {
                        e = e8;
                        bufferedReader2 = bufferedReader;
                        x.b("SameDiTool", e.getMessage(), e);
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e9) {
                                x.b("SameDiTool", e9.getMessage(), e9);
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return "";
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader2 = bufferedReader;
                        x.b("SameDiTool", th.getMessage(), th);
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e10) {
                                x.b("SameDiTool", e10.getMessage(), e10);
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return "";
                    }
                } catch (IOException e11) {
                    x.b("SameDiTool", e11.getMessage(), e11);
                    return "";
                }
            } catch (Throwable th4) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e12) {
                        x.b("SameDiTool", e12.getMessage(), e12);
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e13) {
                        x.b("SameDiTool", e13.getMessage(), e13);
                    }
                }
                throw th4;
            }
        }
        return "";
    }

    public static String E(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                return Settings.System.getString(context.getContentResolver(), "time_12_24");
            } catch (Exception e4) {
                x.b("SameDiTool", e4.getMessage(), e4);
                return "";
            } catch (Throwable th) {
                x.b("SameDiTool", th.getMessage(), th);
                return "";
            }
        }
        return "";
    }

    public static String a(String str, Context context) {
        try {
        } catch (Exception e4) {
            x.b("SameDiTool", e4.getMessage(), e4);
        }
        if (!TextUtils.isEmpty(f39915n)) {
            return f39915n;
        }
        if (!TextUtils.isEmpty(str) && context != null) {
            f39915n = context.getPackageManager().getInstallerPackageName(str);
            x.a("SameDiTool", "PKGSource:" + f39915n);
        }
        return f39915n;
    }

    public static String A() {
        if (TextUtils.isEmpty(f39907f)) {
            C(com.mbridge.msdk.foundation.controller.a.f().j());
        }
        return f39907f;
    }

    public static int D() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    public static String C() {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            if (TextUtils.isEmpty(f39908g)) {
                int D = D();
                f39908g = D + "";
            }
            return f39908g;
        }
        return "";
    }
}
