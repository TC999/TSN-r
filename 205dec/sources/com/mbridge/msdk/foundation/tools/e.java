package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.SensorManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.inputmethod.InputMethodInfo;
import android.view.inputmethod.InputMethodManager;
import com.acse.ottn.f3;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.z;
import com.mbridge.msdk.mbjscommon.webEnvCheck.WebEnvCheckEntry;
import com.mbridge.msdk.optimize.SensitiveDataUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: DomainSameDiTool.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static String f39822a = "";

    /* renamed from: b  reason: collision with root package name */
    private static String f39823b = "";

    /* renamed from: c  reason: collision with root package name */
    private static int f39824c = -1;

    /* renamed from: d  reason: collision with root package name */
    private static String f39825d = "";

    /* renamed from: e  reason: collision with root package name */
    private static String f39826e = "";

    /* renamed from: f  reason: collision with root package name */
    private static String f39827f = "";

    /* renamed from: g  reason: collision with root package name */
    private static JSONObject f39828g = null;

    /* renamed from: h  reason: collision with root package name */
    private static String f39829h = "";

    /* renamed from: i  reason: collision with root package name */
    private static String f39830i = "";

    /* renamed from: j  reason: collision with root package name */
    private static String f39831j = "";

    /* renamed from: k  reason: collision with root package name */
    private static String f39832k = "";

    /* renamed from: l  reason: collision with root package name */
    private static String f39833l = "";

    /* renamed from: m  reason: collision with root package name */
    private static String f39834m;

    /* renamed from: n  reason: collision with root package name */
    private static String f39835n;

    public static int a() {
        return 0;
    }

    public static String a(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                if (context == null) {
                    return "";
                }
                if (!TextUtils.isEmpty(f39822a)) {
                    return f39822a;
                }
                try {
                    String oaid = SensitiveDataUtil.getOaid(context);
                    f39822a = oaid;
                    if (!TextUtils.isEmpty(oaid)) {
                        return f39822a;
                    }
                } catch (Throwable th) {
                    x.a("DomainSameDiTool", th.getMessage(), th);
                }
                return f39822a;
            }
            return f39822a;
        }
        return "";
    }

    public static String b(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                if (context == null) {
                    return "";
                }
                try {
                    String imei = SensitiveDataUtil.getIMEI(context);
                    f39832k = imei;
                    if (!TextUtils.isEmpty(imei)) {
                        return f39832k;
                    }
                } catch (Throwable th) {
                    x.a("DomainSameDiTool", th.getMessage(), th);
                }
                return "";
            }
            return f39832k;
        }
        return "";
    }

    public static String c(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                if (context == null) {
                    return "";
                }
                try {
                    String imsi = SensitiveDataUtil.getImsi(context);
                    f39833l = imsi;
                    if (!TextUtils.isEmpty(imsi)) {
                        return f39833l;
                    }
                } catch (Throwable th) {
                    x.a("DomainSameDiTool", th.getMessage(), th);
                }
                return "";
            }
            return f39833l;
        }
        return "";
    }

    public static String d(Context context) {
        return f39830i;
    }

    public static String e(Context context) {
        return f39831j;
    }

    public static String f(Context context) {
        if (context == null) {
            return f39825d;
        }
        try {
            if (TextUtils.isEmpty(f39825d)) {
                f39825d = s.a(SensitiveDataUtil.getAndroidID(context));
            }
        } catch (Throwable th) {
            x.a("DomainSameDiTool", th.getMessage(), th);
        }
        return f39825d;
    }

    public static String g(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_android_id")) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                if (context == null) {
                    return f39834m;
                }
                try {
                    if (TextUtils.isEmpty(f39834m)) {
                        f39834m = SensitiveDataUtil.getAndroidID(context);
                    }
                } catch (Throwable th) {
                    x.a("DomainSameDiTool", th.getMessage(), th);
                }
                return f39834m;
            }
            return f39825d;
        }
        return "";
    }

    public static String h(Context context) {
        if (context == null) {
            return "";
        }
        f39835n = null;
        try {
            if (TextUtils.isEmpty(null)) {
                String g4 = g(context);
                f39835n = g4;
                f39835n = SameMD5.getUPMD5(g4);
            }
        } catch (Throwable th) {
            x.b("DomainSameDiTool", th.getMessage(), th);
        }
        return f39835n;
    }

    public static String i(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a("authority_imei_mac")) {
            if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.g()) {
                if (context == null) {
                    return f39826e;
                }
                try {
                    if (TextUtils.isEmpty(f39826e)) {
                        f39826e = SensitiveDataUtil.getMacAddress(context);
                    }
                } catch (Throwable th) {
                    x.a("DomainSameDiTool", th.getMessage(), th);
                }
                return f39826e;
            }
            return f39826e;
        }
        return "";
    }

    public static String j(Context context) {
        if (context == null) {
            return "";
        }
        if (TextUtils.isEmpty(f39827f)) {
            try {
                String str = context.getPackageManager().getPackageInfo("com.android.vending", 0).versionName;
                f39827f = str;
                return str;
            } catch (Exception unused) {
                return "";
            }
        }
        return f39827f;
    }

    public static String k() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.VERSION.INCREMENTAL;
    }

    public static String l() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_SERIAL_ID) ? "" : Build.SERIAL;
    }

    public static String m() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.DISPLAY;
    }

    public static String n() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.BOARD;
    }

    public static String o() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.TYPE;
    }

    public static String p() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.VERSION.RELEASE;
    }

    public static int q() {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return Build.VERSION.SDK_INT;
        }
        return -1;
    }

    public static int r() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? -1 : 1;
    }

    public static String s() {
        if (TextUtils.isEmpty(f39823b)) {
            int i4 = Build.VERSION.SDK_INT;
            if (i4 >= 21) {
                f39823b = (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || i4 < 21) ? "" : Arrays.asList(Build.SUPPORTED_ABIS).toString();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(c());
                arrayList.add(b());
                f39823b = arrayList.toString();
            }
        }
        return f39823b;
    }

    public static JSONObject t() {
        if (f39828g == null) {
            f39828g = new JSONObject();
        }
        if (f39828g.length() > 0) {
            return f39828g;
        }
        try {
            boolean z3 = false;
            if (z.a.f39951a.a("e_c", false)) {
                f39828g.put("qemu", "1".equals(f("ro.kernel.qemu")));
                JSONObject jSONObject = f39828g;
                String f4 = f("ro.product.cpu.abi");
                if (f4 != null && !TextUtils.isEmpty(f4) && f4.contains("x86")) {
                    z3 = true;
                }
                jSONObject.put("abi", z3);
            }
        } catch (JSONException e4) {
            e4.printStackTrace();
        }
        return f39828g;
    }

    public static String u() {
        if (TextUtils.isEmpty(f39829h)) {
            String jSONObject = t().toString();
            x.a("DomainSameDiTool", "emuStr:" + jSONObject);
            f39829h = s.a(jSONObject);
            x.a("DomainSameDiTool", "_emuBase64String:" + f39829h);
        }
        return f39829h;
    }

    public static String d() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.TAGS;
    }

    public static String e() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.USER;
    }

    public static int k(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (registerReceiver == null || registerReceiver.getExtras() == null) {
                    return 0;
                }
                int intExtra = registerReceiver.getIntExtra("status", -1);
                return (intExtra == 2 || intExtra == 5) ? 1 : 0;
            } catch (Exception e4) {
                x.b("DomainSameDiTool", e4.getMessage(), e4);
                return 0;
            }
        }
        return -1;
    }

    public static String l(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            double d4 = 0.0d;
            if (context != null) {
                return "";
            }
            try {
                d4 = ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", new Class[0]).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), new Object[0])).doubleValue();
            } catch (Exception e4) {
                x.b("DomainSameDiTool", e4.getMessage(), e4);
            } catch (Throwable th) {
                x.b("DomainSameDiTool", th.getMessage(), th);
            }
            return String.valueOf(d4 + " mAh");
        }
        return "";
    }

    public static int m(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                String simOperator = ((TelephonyManager) context.getSystemService("phone")).getSimOperator();
                if (!"46000".equals(simOperator) && !"46002".equals(simOperator) && !"46007".equals(simOperator) && !"46008".equals(simOperator) && !"45412".equals(simOperator)) {
                    if (!"46001".equals(simOperator) && !"46006".equals(simOperator) && !"46009".equals(simOperator)) {
                        if (!"46003".equals(simOperator) && !"46005".equals(simOperator) && !"46011".equals(simOperator) && !"45502".equals(simOperator)) {
                            if (!"45507".equals(simOperator)) {
                                return -2;
                            }
                        }
                        return 2;
                    }
                    return 1;
                }
                return 0;
            } catch (Exception e4) {
                x.b("DomainSameDiTool", e4.getMessage(), e4);
                return -1;
            }
        }
        return -1;
    }

    public static int n(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                return ((SensorManager) context.getSystemService("sensor")).getSensorList(-1).size();
            } catch (Exception e4) {
                x.b("DomainSameDiTool", e4.getMessage(), e4);
                return -1;
            } catch (Throwable th) {
                x.b("DomainSameDiTool", th.getMessage(), th);
                return -1;
            }
        }
        return -1;
    }

    public static String o(Context context) {
        if (com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
                StringBuilder sb = new StringBuilder();
                for (int i4 = 0; i4 < inputMethodList.size(); i4++) {
                    CharSequence loadLabel = inputMethodList.get(i4).loadLabel(context.getPackageManager());
                    sb.append("keybroad" + i4 + ((Object) loadLabel) + " ");
                }
                return sb.toString();
            } catch (Exception e4) {
                x.b("DomainSameDiTool", e4.getMessage(), e4);
                return "";
            } catch (Throwable th) {
                x.b("DomainSameDiTool", th.getMessage(), th);
                return "";
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void p(Context context) {
        if (context == null) {
            return;
        }
        try {
            WebEnvCheckEntry.class.getMethod("check", Context.class).invoke(WebEnvCheckEntry.class.newInstance(), context);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public static void d(String str) {
        f39822a = str;
    }

    public static void e(String str) {
        f39825d = str;
    }

    public static String f() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.RADIO;
    }

    public static String j() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.VERSION.CODENAME;
    }

    public static String h() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.HARDWARE;
    }

    public static String b() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.CPU_ABI2;
    }

    public static String c() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.CPU_ABI;
    }

    private static String f(String str) {
        try {
            Context j4 = com.mbridge.msdk.foundation.controller.a.f().j();
            if (j4 == null) {
                return null;
            }
            Class<?> loadClass = j4.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod(f3.f5657f, String.class).invoke(loadClass, str);
        } catch (Exception e4) {
            Log.e("DomainSameDiTool", e4.toString());
            return null;
        }
    }

    public static String g() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.BOOTLOADER;
    }

    public static String i() {
        return !com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.HOST;
    }

    public static void b(String str) {
        f39833l = str;
    }

    public static void c(String str) {
        f39826e = str;
    }

    public static void a(String str) {
        f39832k = str;
    }
}
