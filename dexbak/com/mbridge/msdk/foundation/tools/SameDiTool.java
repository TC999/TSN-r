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
import com.baidu.idl.face.platform.FaceEnvironment;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7282g;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.same.CommonConst;
import com.mbridge.msdk.foundation.same.p479f.ThreadPoolUtils;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Locale;
import java.util.TimeZone;
import java.util.UUID;
import org.json.JSONObject;

/* renamed from: com.mbridge.msdk.foundation.tools.t */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class SameDiTool extends DomainSameDiTool {

    /* renamed from: a */
    private static String f31129a = null;

    /* renamed from: b */
    private static String f31130b = null;

    /* renamed from: c */
    private static int f31131c = -1;

    /* renamed from: d */
    private static int f31132d = -1;

    /* renamed from: e */
    private static volatile int f31133e = -1;

    /* renamed from: f */
    private static String f31134f = "";

    /* renamed from: g */
    private static String f31135g = "";

    /* renamed from: h */
    private static String f31136h = "";

    /* renamed from: i */
    private static String f31137i = "";

    /* renamed from: j */
    private static int f31138j = 0;

    /* renamed from: k */
    private static String f31139k = "";

    /* renamed from: l */
    private static String f31140l = "";

    /* renamed from: m */
    private static int f31141m = -1;

    /* renamed from: n */
    private static String f31142n = "";

    /* renamed from: o */
    private static int f31143o = 0;

    /* renamed from: p */
    private static String f31144p = "";

    /* renamed from: q */
    private static String f31145q = null;

    /* renamed from: r */
    private static int f31146r = 0;

    /* renamed from: s */
    private static int f31147s = -1;

    /* renamed from: t */
    private static int f31148t = -1;

    /* renamed from: u */
    private static Object f31149u = null;

    /* renamed from: v */
    private static int f31150v = 0;

    /* renamed from: w */
    private static int f31151w = 0;

    /* renamed from: x */
    private static int f31152x = -1;

    /* renamed from: A */
    public static String m21810A(Context context) {
        if (context == null) {
            return f31136h;
        }
        try {
            if (TextUtils.isEmpty(f31136h)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName;
                f31136h = str;
                return str;
            }
            return f31136h;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: B */
    public static void m21808B(final Context context) {
        if (context == null) {
            return;
        }
        try {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                DomainSameDiTool.m21885p(context);
            } else {
                new Handler(context.getMainLooper()).post(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.t.1
                    @Override // java.lang.Runnable
                    public final void run() {
                        DomainSameDiTool.m21885p(context);
                    }
                });
            }
        } catch (Exception e) {
            SameLogTool.m21735b("SameDiTool", "", e);
        }
    }

    /* renamed from: C */
    public static String m21806C(final Context context) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            if (TextUtils.isEmpty(f31134f)) {
                try {
                    f31134f = C11400ae.m21961b(context, "mbridge_ua", "").toString();
                } catch (Throwable th) {
                    SameLogTool.m21735b("SameDiTool", th.getMessage(), th);
                }
            }
            try {
                if (Looper.myLooper() == Looper.getMainLooper()) {
                    if (TextUtils.isEmpty(f31134f)) {
                        try {
                            f31134f = WebSettings.getDefaultUserAgent(context);
                        } catch (Throwable unused) {
                        }
                        if (TextUtils.isEmpty(f31134f)) {
                            Constructor declaredConstructor = WebSettings.class.getDeclaredConstructor(Context.class, WebView.class);
                            declaredConstructor.setAccessible(true);
                            f31134f = ((WebSettings) declaredConstructor.newInstance(context, null)).getUserAgentString();
                            declaredConstructor.setAccessible(false);
                            if (TextUtils.isEmpty(f31134f)) {
                                f31134f = new WebView(context).getSettings().getUserAgentString();
                            }
                            if (TextUtils.isEmpty(f31134f)) {
                                m21787Q();
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
                                    if (TextUtils.isEmpty(str) || str.equals(SameDiTool.f31134f)) {
                                        return;
                                    }
                                    String unused3 = SameDiTool.f31134f = str;
                                    SameDiTool.m21796H(context);
                                }
                            }).start();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    m21787Q();
                }
            } catch (Throwable th2) {
                SameLogTool.m21735b("SameDiTool", th2.getMessage(), th2);
            }
            m21796H(context);
            return f31134f;
        }
        return null;
    }

    /* renamed from: D */
    public static int m21804D(Context context) {
        try {
            final Context m22861j = MBSDKContext.m22865f().m22861j();
            if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
                if (m22861j == null) {
                    return f31133e;
                }
                if (f31133e != -1) {
                    Runnable runnable = new Runnable() { // from class: com.mbridge.msdk.foundation.tools.t.3
                        @Override // java.lang.Runnable
                        public final void run() {
                            try {
                                ConnectivityManager connectivityManager = (ConnectivityManager) m22861j.getSystemService("connectivity");
                                if (connectivityManager != null && CommonConst.f30584g) {
                                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                                    if (activeNetworkInfo == null) {
                                        int unused = SameDiTool.f31133e = 0;
                                    } else if (activeNetworkInfo.getType() == 1) {
                                        int unused2 = SameDiTool.f31133e = 9;
                                    } else {
                                        TelephonyManager telephonyManager = (TelephonyManager) m22861j.getSystemService("phone");
                                        if (telephonyManager == null) {
                                            int unused3 = SameDiTool.f31133e = 0;
                                        } else {
                                            int unused4 = SameDiTool.f31133e = SameDiTool.m21785a(telephonyManager.getNetworkType());
                                        }
                                    }
                                }
                            } catch (Exception e) {
                                SameLogTool.m21735b("SameDiTool", e.getMessage(), e);
                                int unused5 = SameDiTool.f31133e = 0;
                            }
                        }
                    };
                    if (ThreadPoolUtils.m22307c().getActiveCount() < 1) {
                        ThreadPoolUtils.m22307c().execute(runnable);
                    }
                    return f31133e;
                }
                f31133e = 0;
                return f31133e;
            }
            return f31133e;
        } catch (Exception e) {
            SameLogTool.m21735b("SameDiTool", e.getMessage(), e);
            f31133e = 0;
            return f31133e;
        }
    }

    /* renamed from: E */
    public static String m21803E() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID) ? "" : !SDKAuthorityController.m22828g() ? TextUtils.isEmpty(f31129a) ? "" : f31129a : TextUtils.isEmpty(f31129a) ? "" : f31129a;
    }

    /* renamed from: F */
    public static String m21801F() {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            if (!SDKAuthorityController.m22828g()) {
                return TextUtils.isEmpty(f31130b) ? "" : f31130b;
            }
            String str = f31130b;
            return str == null ? "" : str;
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public static void m21796H(Context context) {
        try {
            C11400ae.m21963a(context, "mbridge_ua", f31134f);
        } catch (Throwable th) {
            SameLogTool.m21735b("SameDiTool", th.getMessage(), th);
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
    /* renamed from: I */
    public static String m21795I() {
        FileReader fileReader;
        Throwable th;
        Exception e;
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            if (f31146r > 0) {
                return f31146r + "GB";
            }
            ?? r1 = "/proc/meminfo";
            f31146r = 0;
            try {
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            try {
                try {
                    fileReader = new FileReader("/proc/meminfo");
                    try {
                        r1 = new BufferedReader(fileReader, 8192);
                        try {
                            String str = r1.readLine().split("\\s+")[1];
                            r1.close();
                            if (str != null) {
                                f31146r = (int) Math.ceil(new Float(Float.valueOf(str).floatValue() / 1048576.0f).doubleValue());
                            }
                            try {
                                fileReader.close();
                            } catch (IOException unused) {
                            }
                            r1.close();
                        } catch (Exception e3) {
                            e = e3;
                            SameLogTool.m21735b("SameDiTool", e.getMessage(), e);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException unused2) {
                                }
                            }
                            if (r1 != 0) {
                                r1.close();
                            }
                            return f31146r + "GB";
                        } catch (Throwable th2) {
                            th = th2;
                            SameLogTool.m21735b("SameDiTool", th.getMessage(), th);
                            if (fileReader != null) {
                                try {
                                    fileReader.close();
                                } catch (IOException unused3) {
                                }
                            }
                            if (r1 != 0) {
                                r1.close();
                            }
                            return f31146r + "GB";
                        }
                    } catch (Exception e4) {
                        e = e4;
                        r1 = 0;
                    } catch (Throwable th3) {
                        th = th3;
                        r1 = 0;
                    }
                } catch (Exception e5) {
                    fileReader = null;
                    e = e5;
                    r1 = 0;
                } catch (Throwable th4) {
                    fileReader = null;
                    th = th4;
                    r1 = 0;
                }
                return f31146r + "GB";
            } catch (Throwable th5) {
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException unused4) {
                    }
                }
                if (r1 != 0) {
                    try {
                        r1.close();
                    } catch (IOException e6) {
                        e6.printStackTrace();
                    }
                }
                throw th5;
            }
        }
        return "";
    }

    /* renamed from: J */
    public static String m21794J() {
        Context m22861j;
        long currentTimeMillis;
        long m21786R;
        String str;
        String str2;
        String str3 = "";
        try {
            m22861j = MBSDKContext.m22865f().m22861j();
            currentTimeMillis = System.currentTimeMillis() - SystemClock.elapsedRealtime();
            m21786R = m21786R();
            str = "app_tki_" + currentTimeMillis + "_" + m21786R;
            str2 = (String) C11400ae.m21961b(m22861j, str, "");
            try {
            } catch (Exception e) {
                e = e;
                str3 = str2;
                e.printStackTrace();
                return str3;
            }
        } catch (Exception e2) {
            e = e2;
        }
        if (TextUtils.isEmpty(str2)) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("1", "");
                jSONObject.put("2", String.valueOf(m21786R));
                jSONObject.put("3", String.valueOf(currentTimeMillis));
                jSONObject.put("4", "");
                jSONObject.put("5", "");
            } catch (Exception e3) {
                e3.printStackTrace();
            }
            str3 = AESCBCUtil.m22044a(jSONObject.toString());
            C11400ae.m21963a(m22861j, str, str3);
            return str3;
        }
        return str2;
    }

    /* renamed from: K */
    public static int m21793K() {
        try {
        } catch (Throwable th) {
            SameLogTool.m21735b("SameDiTool", th.getMessage(), th);
        }
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            long j = 0;
            long longValue = ((Long) C11400ae.m21961b(m22861j, "FreeRamSize", 0L)).longValue();
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - longValue > 1800000 || f31132d == -1) {
                Context m22861j2 = MBSDKContext.m22865f().m22861j();
                if (m22861j2 != null) {
                    ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
                    ((ActivityManager) m22861j2.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
                    j = memoryInfo.availMem;
                }
                f31132d = Long.valueOf((j / 1000) / 1000).intValue();
                C11400ae.m21963a(m22861j, "FreeRamSize", Long.valueOf(currentTimeMillis));
            }
            return f31132d;
        }
        return 0;
    }

    /* renamed from: L */
    public static int m21792L() {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            if (f31131c < 1) {
                try {
                    Context m22861j = MBSDKContext.m22865f().m22861j();
                    long longValue = ((Long) C11400ae.m21961b(m22861j, "TotalRamSize", 0L)).longValue();
                    long currentTimeMillis = System.currentTimeMillis();
                    if (currentTimeMillis - longValue > 1800000 || f31131c == -1) {
                        f31131c = Long.valueOf((m21786R() / 1000) / 1000).intValue();
                        C11400ae.m21963a(m22861j, "TotalRamSize", Long.valueOf(currentTimeMillis));
                    }
                } catch (Throwable th) {
                    SameLogTool.m21735b("SameDiTool", th.getMessage(), th);
                }
            }
            return f31131c;
        }
        return 0;
    }

    /* renamed from: M */
    public static int m21791M() {
        return f31141m;
    }

    /* renamed from: N */
    public static String m21790N() {
        if (!TextUtils.isEmpty(f31144p)) {
            return f31144p;
        }
        JSONObject jSONObject = new JSONObject();
        String str = null;
        try {
            Class<?> cls = Class.forName("com.huawei.system.BuildEx");
            str = (String) cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0]);
        } catch (Throwable th) {
            SameLogTool.m21733d("SameDiTool", th.getMessage());
        }
        try {
            if (!TextUtils.isEmpty(str) && str.equals("harmony")) {
                jSONObject.put("osType", str);
                Class<?> cls2 = Class.forName("ohos.system.version.SystemVersion");
                jSONObject.put(ConstantHelper.LOG_VS, (String) cls2.getMethod("getVersion", new Class[0]).invoke(cls2, new Object[0]));
                jSONObject.put("pure_state", Settings.Secure.getInt(MBSDKContext.m22865f().m22861j().getContentResolver(), "pure_mode_state", -1));
                String jSONObject2 = jSONObject.toString();
                if (!TextUtils.isEmpty(jSONObject2)) {
                    jSONObject2 = SameBase64Tool.m21813a(jSONObject2);
                }
                f31144p = jSONObject2;
            } else {
                f31144p = FaceEnvironment.f8430OS;
            }
        } catch (Throwable th2) {
            SameLogTool.m21733d("SameDiTool", th2.getMessage());
        }
        return f31144p;
    }

    /* renamed from: O */
    public static int m21789O() {
        return f31152x;
    }

    /* renamed from: Q */
    private static void m21787Q() {
        String str = Build.VERSION.RELEASE;
        String m21766x = m21766x();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(m21766x)) {
            f31134f = "Mozilla/5.0 (Linux; Android " + str + "; " + m21766x + " Build/) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
            return;
        }
        f31134f = "Mozilla/5.0 (Linux; Android 4.0.4; Galaxy Nexus Build/IMM76B) AppleWebKit/535.19 (KHTML, like Gecko) Chrome/18.0.1025.133 Mobile Safari/535.19";
    }

    /* renamed from: R */
    private static long m21786R() {
        Context m22861j = MBSDKContext.m22865f().m22861j();
        if (m22861j != null) {
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
            ((ActivityManager) m22861j.getSystemService(TTDownloadField.TT_ACTIVITY)).getMemoryInfo(memoryInfo);
            return memoryInfo.totalMem;
        }
        return 0L;
    }

    /* renamed from: a */
    public static int m21785a(int i) {
        switch (i) {
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

    /* renamed from: a */
    public static String m21784a(Context context, int i) {
        TelephonyManager telephonyManager;
        if (i == 0 || i == 9) {
            return "";
        }
        try {
            return (!CommonConst.f30584g || (telephonyManager = (TelephonyManager) context.getSystemService("phone")) == null) ? "" : String.valueOf(telephonyManager.getNetworkType());
        } catch (Throwable th) {
            SameLogTool.m21735b("SameDiTool", th.getMessage(), th);
            return "";
        }
    }

    /* renamed from: b */
    public static void m21782b(int i) {
        f31152x = i;
    }

    /* renamed from: f */
    public static Object m21780f(String str) {
        if (f31149u == null) {
            f31149u = SameTool.m21987d(str);
        }
        return f31149u;
    }

    /* renamed from: g */
    public static int m21779g(String str) {
        if (f31150v == 0) {
            f31150v = SameTool.m21984e(str);
        }
        return f31150v;
    }

    /* renamed from: h */
    public static void m21778h(String str) {
        f31130b = SameBase64Tool.m21813a(str);
        f31129a = str;
    }

    /* renamed from: q */
    public static void m21775q(Context context) {
        try {
            m21807C();
            m21810A(context);
            m21769v(context);
            m21771u(context);
            m21772t(context);
            m21766x();
            m21762z();
            m21803E();
            m21773s(context);
            m21809B();
            CommonConst.f30585h = false;
            CommonConst.f30584g = SameTool.m22011a(C7282g.f24944b, context);
            m21767w(context);
            try {
                DomainSameDiTool.m21903g(context);
                DomainSameDiTool.m21918b(context);
                DomainSameDiTool.m21915c(context);
                DomainSameDiTool.m21899i(context);
                DomainSameDiTool.m21897j(context);
                try {
                    int m21805D = m21805D();
                    if (m21805D >= 17 && m21805D < 21) {
                        f31141m = Settings.Global.getInt(MBSDKContext.m22865f().m22861j().getContentResolver(), "install_non_market_apps", 0);
                    } else if (m21805D >= 21 || (m21805D < 17 && m21805D > 10)) {
                        f31141m = Settings.Secure.getInt(MBSDKContext.m22865f().m22861j().getContentResolver(), "install_non_market_apps", 0);
                    }
                } catch (Throwable th) {
                    SameLogTool.m21735b("SameDiTool", th.getMessage(), th);
                }
                SameLogTool.m21733d("SameDiTool", "getUSSForPe:" + f31141m);
                CommonConst.f30587j = SameTool.m22011a(C7282g.f24947e, context);
                CommonConst.f30586i = false;
                DomainSameDiTool.m21921a(context);
            } catch (Throwable unused) {
            }
            m21790N();
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: r */
    public static int m21774r(Context context) {
        if (f31147s == -1) {
            f31147s = SameTool.m21992c(context, "com.tencent.mm") ? 1 : 0;
        }
        return f31147s;
    }

    /* renamed from: s */
    public static String m21773s(Context context) {
        Locale locale;
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            if (TextUtils.isEmpty(f31139k)) {
                if (context == null) {
                    return "en-US";
                }
                try {
                    if (context.getResources() == null || context.getResources().getConfiguration() == null || (locale = context.getResources().getConfiguration().locale) == null) {
                        return "en-US";
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        f31139k = locale.toLanguageTag();
                    } else {
                        f31139k = locale.getLanguage() + "-" + locale.getCountry();
                    }
                    return f31139k;
                } catch (Throwable th) {
                    SameLogTool.m21738a("SameDiTool", th.getMessage());
                    f31139k = "en-US";
                }
            }
            return f31139k;
        }
        return "";
    }

    /* renamed from: t */
    public static int m21772t(Context context) {
        Configuration configuration;
        return (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null || configuration.orientation != 2) ? 1 : 2;
    }

    /* renamed from: u */
    public static int m21771u(Context context) {
        if (context == null) {
            return f31138j;
        }
        int i = f31138j;
        if (i == 0) {
            try {
                int i2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
                f31138j = i2;
                return i2;
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return i;
    }

    /* renamed from: v */
    public static int m21770v() {
        if (f31148t == -1) {
            f31148t = SameTool.m21995c() ? 1 : 0;
        }
        return f31148t;
    }

    /* renamed from: w */
    public static int m21768w() {
        if (f31151w == 0) {
            f31151w = SameTool.m21990d();
        }
        return f31151w;
    }

    /* renamed from: x */
    public static String m21766x() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MODEL;
    }

    /* renamed from: y */
    public static String m21764y() {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return Build.MANUFACTURER + " " + Build.MODEL;
        }
        return "";
    }

    /* renamed from: z */
    public static String m21762z() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.BRAND;
    }

    /* renamed from: G */
    public static UUID m21799G() {
        try {
            return UUID.randomUUID();
        } catch (Throwable th) {
            SameLogTool.m21735b("SameDiTool", th.getMessage(), th);
            return null;
        }
    }

    /* renamed from: H */
    public static String m21797H() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.MANUFACTURER;
    }

    /* renamed from: x */
    public static int m21765x(Context context) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                HashMap m21761z = m21761z(context);
                return m21761z.get("width") == null ? displayMetrics.widthPixels : ((Integer) m21761z.get("width")).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    /* renamed from: y */
    public static int m21763y(Context context) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                HashMap m21761z = m21761z(context);
                return m21761z.get("height") == null ? displayMetrics.heightPixels : ((Integer) m21761z.get("height")).intValue();
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
        return 0;
    }

    /* renamed from: z */
    public static HashMap m21761z(Context context) {
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
        } catch (Exception e) {
            SameLogTool.m21735b("SameDiTool", e.getMessage(), e);
        }
        return hashMap;
    }

    /* renamed from: v */
    public static String m21769v(Context context) {
        if (context == null) {
            return f31137i;
        }
        try {
            if (TextUtils.isEmpty(f31137i)) {
                String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
                f31137i = str;
                return str;
            }
            return f31137i;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /* renamed from: w */
    public static int m21767w(Context context) {
        if (context == null) {
            return f31143o;
        }
        if (f31143o == 0) {
            try {
                f31143o = context.getApplicationInfo().targetSdkVersion;
            } catch (Exception e) {
                SameLogTool.m21733d("SameDiTool", e.getMessage());
            }
        }
        return f31143o;
    }

    /* renamed from: B */
    public static String m21809B() {
        try {
        } catch (Throwable th) {
            SameLogTool.m21735b("SameDiTool", th.getMessage(), th);
        }
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_OTHER)) {
            if (TextUtils.isEmpty(f31140l)) {
                new Thread(new Runnable() { // from class: com.mbridge.msdk.foundation.tools.t.4
                    @Override // java.lang.Runnable
                    public final void run() {
                        try {
                            String unused = SameDiTool.f31140l = TimeZone.getDefault().getDisplayName(false, 0, Locale.ENGLISH);
                        } catch (Throwable th2) {
                            th2.printStackTrace();
                        }
                    }
                }).start();
                return f31140l;
            }
            return f31140l;
        }
        return "";
    }

    /* renamed from: F */
    public static String m21800F(Context context) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            if (!TextUtils.isEmpty(f31145q)) {
                return f31145q;
            }
            BufferedReader bufferedReader2 = null;
            try {
                try {
                    try {
                        fileReader = new FileReader("/proc/meminfo");
                        try {
                            bufferedReader = new BufferedReader(fileReader, 8192);
                        } catch (IOException e) {
                            e = e;
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (IOException e2) {
                        e = e2;
                        fileReader = null;
                    } catch (Throwable th2) {
                        th = th2;
                        fileReader = null;
                    }
                    try {
                        String formatFileSize = Formatter.formatFileSize(context, Long.valueOf(bufferedReader.readLine().split("\\s+")[1]).longValue() * 1024);
                        f31145q = formatFileSize;
                        try {
                            bufferedReader.close();
                        } catch (IOException e3) {
                            SameLogTool.m21735b("SameDiTool", e3.getMessage(), e3);
                        }
                        try {
                            fileReader.close();
                        } catch (IOException e4) {
                            SameLogTool.m21735b("SameDiTool", e4.getMessage(), e4);
                        }
                        return formatFileSize;
                    } catch (IOException e5) {
                        e = e5;
                        bufferedReader2 = bufferedReader;
                        SameLogTool.m21735b("SameDiTool", e.getMessage(), e);
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e6) {
                                SameLogTool.m21735b("SameDiTool", e6.getMessage(), e6);
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return "";
                    } catch (Throwable th3) {
                        th = th3;
                        bufferedReader2 = bufferedReader;
                        SameLogTool.m21735b("SameDiTool", th.getMessage(), th);
                        if (bufferedReader2 != null) {
                            try {
                                bufferedReader2.close();
                            } catch (IOException e7) {
                                SameLogTool.m21735b("SameDiTool", e7.getMessage(), e7);
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        return "";
                    }
                } catch (IOException e8) {
                    SameLogTool.m21735b("SameDiTool", e8.getMessage(), e8);
                    return "";
                }
            } catch (Throwable th4) {
                if (bufferedReader2 != null) {
                    try {
                        bufferedReader2.close();
                    } catch (IOException e9) {
                        SameLogTool.m21735b("SameDiTool", e9.getMessage(), e9);
                    }
                }
                if (fileReader != null) {
                    try {
                        fileReader.close();
                    } catch (IOException e10) {
                        SameLogTool.m21735b("SameDiTool", e10.getMessage(), e10);
                    }
                }
                throw th4;
            }
        }
        return "";
    }

    /* renamed from: E */
    public static String m21802E(Context context) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                return Settings.System.getString(context.getContentResolver(), "time_12_24");
            } catch (Exception e) {
                SameLogTool.m21735b("SameDiTool", e.getMessage(), e);
                return "";
            } catch (Throwable th) {
                SameLogTool.m21735b("SameDiTool", th.getMessage(), th);
                return "";
            }
        }
        return "";
    }

    /* renamed from: a */
    public static String m21783a(String str, Context context) {
        try {
        } catch (Exception e) {
            SameLogTool.m21735b("SameDiTool", e.getMessage(), e);
        }
        if (!TextUtils.isEmpty(f31142n)) {
            return f31142n;
        }
        if (!TextUtils.isEmpty(str) && context != null) {
            f31142n = context.getPackageManager().getInstallerPackageName(str);
            SameLogTool.m21738a("SameDiTool", "PKGSource:" + f31142n);
        }
        return f31142n;
    }

    /* renamed from: A */
    public static String m21811A() {
        if (TextUtils.isEmpty(f31134f)) {
            m21806C(MBSDKContext.m22865f().m22861j());
        }
        return f31134f;
    }

    /* renamed from: D */
    public static int m21805D() {
        try {
            return Build.VERSION.SDK_INT;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /* renamed from: C */
    public static String m21807C() {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            if (TextUtils.isEmpty(f31135g)) {
                int m21805D = m21805D();
                f31135g = m21805D + "";
            }
            return f31135g;
        }
        return "";
    }
}
