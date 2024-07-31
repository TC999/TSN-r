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
import com.github.mikephil.charting.utils.Utils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.MBSDKContext;
import com.mbridge.msdk.foundation.controller.authoritycontroller.SDKAuthorityController;
import com.mbridge.msdk.foundation.tools.SameOptimizedController;
import com.mbridge.msdk.mbjscommon.webEnvCheck.WebEnvCheckEntry;
import com.mbridge.msdk.optimize.SensitiveDataUtil;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import tv.cjump.jni.DeviceUtils;

/* renamed from: com.mbridge.msdk.foundation.tools.e */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DomainSameDiTool {

    /* renamed from: a */
    private static String f31049a = "";

    /* renamed from: b */
    private static String f31050b = "";

    /* renamed from: c */
    private static int f31051c = -1;

    /* renamed from: d */
    private static String f31052d = "";

    /* renamed from: e */
    private static String f31053e = "";

    /* renamed from: f */
    private static String f31054f = "";

    /* renamed from: g */
    private static JSONObject f31055g = null;

    /* renamed from: h */
    private static String f31056h = "";

    /* renamed from: i */
    private static String f31057i = "";

    /* renamed from: j */
    private static String f31058j = "";

    /* renamed from: k */
    private static String f31059k = "";

    /* renamed from: l */
    private static String f31060l = "";

    /* renamed from: m */
    private static String f31061m;

    /* renamed from: n */
    private static String f31062n;

    /* renamed from: a */
    public static int m21922a() {
        return 0;
    }

    /* renamed from: a */
    public static String m21921a(Context context) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            if (SDKAuthorityController.m22828g()) {
                if (context == null) {
                    return "";
                }
                if (!TextUtils.isEmpty(f31049a)) {
                    return f31049a;
                }
                try {
                    String oaid = SensitiveDataUtil.getOaid(context);
                    f31049a = oaid;
                    if (!TextUtils.isEmpty(oaid)) {
                        return f31049a;
                    }
                } catch (Throwable th) {
                    SameLogTool.m21737a("DomainSameDiTool", th.getMessage(), th);
                }
                return f31049a;
            }
            return f31049a;
        }
        return "";
    }

    /* renamed from: b */
    public static String m21918b(Context context) {
        if (SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) {
            if (SDKAuthorityController.m22828g()) {
                if (context == null) {
                    return "";
                }
                try {
                    String imei = SensitiveDataUtil.getIMEI(context);
                    f31059k = imei;
                    if (!TextUtils.isEmpty(imei)) {
                        return f31059k;
                    }
                } catch (Throwable th) {
                    SameLogTool.m21737a("DomainSameDiTool", th.getMessage(), th);
                }
                return "";
            }
            return f31059k;
        }
        return "";
    }

    /* renamed from: c */
    public static String m21915c(Context context) {
        if (SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) {
            if (SDKAuthorityController.m22828g()) {
                if (context == null) {
                    return "";
                }
                try {
                    String imsi = SensitiveDataUtil.getImsi(context);
                    f31060l = imsi;
                    if (!TextUtils.isEmpty(imsi)) {
                        return f31060l;
                    }
                } catch (Throwable th) {
                    SameLogTool.m21737a("DomainSameDiTool", th.getMessage(), th);
                }
                return "";
            }
            return f31060l;
        }
        return "";
    }

    /* renamed from: d */
    public static String m21912d(Context context) {
        return f31057i;
    }

    /* renamed from: e */
    public static String m21909e(Context context) {
        return f31058j;
    }

    /* renamed from: f */
    public static String m21906f(Context context) {
        if (context == null) {
            return f31052d;
        }
        try {
            if (TextUtils.isEmpty(f31052d)) {
                f31052d = SameBase64Tool.m21813a(SensitiveDataUtil.getAndroidID(context));
            }
        } catch (Throwable th) {
            SameLogTool.m21737a("DomainSameDiTool", th.getMessage(), th);
        }
        return f31052d;
    }

    /* renamed from: g */
    public static String m21903g(Context context) {
        if (SDKAuthorityController.m22842a().m22840a("authority_android_id")) {
            if (SDKAuthorityController.m22828g()) {
                if (context == null) {
                    return f31061m;
                }
                try {
                    if (TextUtils.isEmpty(f31061m)) {
                        f31061m = SensitiveDataUtil.getAndroidID(context);
                    }
                } catch (Throwable th) {
                    SameLogTool.m21737a("DomainSameDiTool", th.getMessage(), th);
                }
                return f31061m;
            }
            return f31052d;
        }
        return "";
    }

    /* renamed from: h */
    public static String m21901h(Context context) {
        if (context == null) {
            return "";
        }
        f31062n = null;
        try {
            if (TextUtils.isEmpty(null)) {
                String m21903g = m21903g(context);
                f31062n = m21903g;
                f31062n = SameMD5.getUPMD5(m21903g);
            }
        } catch (Throwable th) {
            SameLogTool.m21735b("DomainSameDiTool", th.getMessage(), th);
        }
        return f31062n;
    }

    /* renamed from: i */
    public static String m21899i(Context context) {
        if (SDKAuthorityController.m22842a().m22840a("authority_imei_mac")) {
            if (SDKAuthorityController.m22828g()) {
                if (context == null) {
                    return f31053e;
                }
                try {
                    if (TextUtils.isEmpty(f31053e)) {
                        f31053e = SensitiveDataUtil.getMacAddress(context);
                    }
                } catch (Throwable th) {
                    SameLogTool.m21737a("DomainSameDiTool", th.getMessage(), th);
                }
                return f31053e;
            }
            return f31053e;
        }
        return "";
    }

    /* renamed from: j */
    public static String m21897j(Context context) {
        if (context == null) {
            return "";
        }
        if (TextUtils.isEmpty(f31054f)) {
            try {
                String str = context.getPackageManager().getPackageInfo("com.android.vending", 0).versionName;
                f31054f = str;
                return str;
            } catch (Exception unused) {
                return "";
            }
        }
        return f31054f;
    }

    /* renamed from: k */
    public static String m21896k() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.VERSION.INCREMENTAL;
    }

    /* renamed from: l */
    public static String m21894l() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_SERIAL_ID) ? "" : Build.SERIAL;
    }

    /* renamed from: m */
    public static String m21892m() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.DISPLAY;
    }

    /* renamed from: n */
    public static String m21890n() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.BOARD;
    }

    /* renamed from: o */
    public static String m21888o() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.TYPE;
    }

    /* renamed from: p */
    public static String m21886p() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.VERSION.RELEASE;
    }

    /* renamed from: q */
    public static int m21884q() {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return Build.VERSION.SDK_INT;
        }
        return -1;
    }

    /* renamed from: r */
    public static int m21883r() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? -1 : 1;
    }

    /* renamed from: s */
    public static String m21882s() {
        if (TextUtils.isEmpty(f31050b)) {
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                f31050b = (!SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) || i < 21) ? "" : Arrays.asList(Build.SUPPORTED_ABIS).toString();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.add(m21916c());
                arrayList.add(m21919b());
                f31050b = arrayList.toString();
            }
        }
        return f31050b;
    }

    /* renamed from: t */
    public static JSONObject m21881t() {
        if (f31055g == null) {
            f31055g = new JSONObject();
        }
        if (f31055g.length() > 0) {
            return f31055g;
        }
        try {
            boolean z = false;
            if (SameOptimizedController.C11437a.f31178a.m21724a("e_c", false)) {
                f31055g.put("qemu", "1".equals(m21905f("ro.kernel.qemu")));
                JSONObject jSONObject = f31055g;
                String m21905f = m21905f("ro.product.cpu.abi");
                if (m21905f != null && !TextUtils.isEmpty(m21905f) && m21905f.contains(DeviceUtils.f47125a)) {
                    z = true;
                }
                jSONObject.put("abi", z);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return f31055g;
    }

    /* renamed from: u */
    public static String m21880u() {
        if (TextUtils.isEmpty(f31056h)) {
            String jSONObject = m21881t().toString();
            SameLogTool.m21738a("DomainSameDiTool", "emuStr:" + jSONObject);
            f31056h = SameBase64Tool.m21813a(jSONObject);
            SameLogTool.m21738a("DomainSameDiTool", "_emuBase64String:" + f31056h);
        }
        return f31056h;
    }

    /* renamed from: d */
    public static String m21913d() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.TAGS;
    }

    /* renamed from: e */
    public static String m21910e() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.USER;
    }

    /* renamed from: k */
    public static int m21895k(Context context) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                if (registerReceiver == null || registerReceiver.getExtras() == null) {
                    return 0;
                }
                int intExtra = registerReceiver.getIntExtra("status", -1);
                return (intExtra == 2 || intExtra == 5) ? 1 : 0;
            } catch (Exception e) {
                SameLogTool.m21735b("DomainSameDiTool", e.getMessage(), e);
                return 0;
            }
        }
        return -1;
    }

    /* renamed from: l */
    public static String m21893l(Context context) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            double d = Utils.DOUBLE_EPSILON;
            if (context != null) {
                return "";
            }
            try {
                d = ((Double) Class.forName("com.android.internal.os.PowerProfile").getMethod("getBatteryCapacity", new Class[0]).invoke(Class.forName("com.android.internal.os.PowerProfile").getConstructor(Context.class).newInstance(context), new Object[0])).doubleValue();
            } catch (Exception e) {
                SameLogTool.m21735b("DomainSameDiTool", e.getMessage(), e);
            } catch (Throwable th) {
                SameLogTool.m21735b("DomainSameDiTool", th.getMessage(), th);
            }
            return String.valueOf(d + " mAh");
        }
        return "";
    }

    /* renamed from: m */
    public static int m21891m(Context context) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
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
            } catch (Exception e) {
                SameLogTool.m21735b("DomainSameDiTool", e.getMessage(), e);
                return -1;
            }
        }
        return -1;
    }

    /* renamed from: n */
    public static int m21889n(Context context) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                return ((SensorManager) context.getSystemService(UMCommonContent.f37799ac)).getSensorList(-1).size();
            } catch (Exception e) {
                SameLogTool.m21735b("DomainSameDiTool", e.getMessage(), e);
                return -1;
            } catch (Throwable th) {
                SameLogTool.m21735b("DomainSameDiTool", th.getMessage(), th);
                return -1;
            }
        }
        return -1;
    }

    /* renamed from: o */
    public static String m21887o(Context context) {
        if (SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) && context != null) {
            try {
                List<InputMethodInfo> inputMethodList = ((InputMethodManager) context.getSystemService("input_method")).getInputMethodList();
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < inputMethodList.size(); i++) {
                    CharSequence loadLabel = inputMethodList.get(i).loadLabel(context.getPackageManager());
                    sb.append("keybroad" + i + ((Object) loadLabel) + " ");
                }
                return sb.toString();
            } catch (Exception e) {
                SameLogTool.m21735b("DomainSameDiTool", e.getMessage(), e);
                return "";
            } catch (Throwable th) {
                SameLogTool.m21735b("DomainSameDiTool", th.getMessage(), th);
                return "";
            }
        }
        return "";
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: p */
    public static void m21885p(Context context) {
        if (context == null) {
            return;
        }
        try {
            WebEnvCheckEntry.class.getMethod("check", Context.class).invoke(WebEnvCheckEntry.class.newInstance(), context);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    public static void m21911d(String str) {
        f31049a = str;
    }

    /* renamed from: e */
    public static void m21908e(String str) {
        f31052d = str;
    }

    /* renamed from: f */
    public static String m21907f() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.RADIO;
    }

    /* renamed from: j */
    public static String m21898j() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.VERSION.CODENAME;
    }

    /* renamed from: h */
    public static String m21902h() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.HARDWARE;
    }

    /* renamed from: b */
    public static String m21919b() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.CPU_ABI2;
    }

    /* renamed from: c */
    public static String m21916c() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.CPU_ABI;
    }

    /* renamed from: f */
    private static String m21905f(String str) {
        try {
            Context m22861j = MBSDKContext.m22865f().m22861j();
            if (m22861j == null) {
                return null;
            }
            Class<?> loadClass = m22861j.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod("get", String.class).invoke(loadClass, str);
        } catch (Exception e) {
            Log.e("DomainSameDiTool", e.toString());
            return null;
        }
    }

    /* renamed from: g */
    public static String m21904g() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.BOOTLOADER;
    }

    /* renamed from: i */
    public static String m21900i() {
        return !SDKAuthorityController.m22842a().m22840a(MBridgeConstans.AUTHORITY_GENERAL_DATA) ? "" : Build.HOST;
    }

    /* renamed from: b */
    public static void m21917b(String str) {
        f31060l = str;
    }

    /* renamed from: c */
    public static void m21914c(String str) {
        f31053e = str;
    }

    /* renamed from: a */
    public static void m21920a(String str) {
        f31059k = str;
    }
}
