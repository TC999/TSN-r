package cn.jiguang.ah;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import cn.jiguang.ag.h;
import cn.jiguang.ag.i;
import cn.jiguang.ah.a;
import cn.jiguang.api.JCoreManager;
import cn.jiguang.internal.JConstants;
import cn.jpush.android.local.JPushConstants;
import java.io.File;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class d {
    public static long a(Context context, long j4) {
        Object onEvent = JCoreManager.onEvent(context, null, 19, null, null, Long.valueOf(j4));
        return onEvent instanceof Long ? ((Long) onEvent).longValue() : System.currentTimeMillis() / 1000;
    }

    public static String a() {
        try {
            Object onEvent = JCoreManager.onEvent(null, null, 92, null, null, new Object[0]);
            return onEvent instanceof String ? (String) onEvent : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String a(int i4) {
        return i.a(i4);
    }

    public static String a(Context context) {
        return cn.jiguang.h.a.e(context);
    }

    public static String a(Context context, int i4) {
        return i.a(context, i4);
    }

    public static String a(File file) {
        return cn.jiguang.ag.d.c(file);
    }

    public static String a(String str) {
        return h.d(str);
    }

    public static JSONObject a(Context context, JSONObject jSONObject, String str) {
        return cn.jiguang.h.a.a(context, jSONObject, str);
    }

    public static void a(Context context, Bundle bundle) {
        JCoreManager.onEvent(context, "JCOMMON", 16, null, bundle, new Object[0]);
    }

    public static void a(Context context, Object obj) {
        JCoreManager.onEvent(context, "JCOMMON", 39, null, null, obj);
    }

    public static void a(Context context, Object obj, Object obj2) {
        JCoreManager.onEvent(context, "JCOMMON", 15, null, null, obj, obj2);
    }

    public static void a(Context context, JSONObject jSONObject) {
        cn.jiguang.s.b.b(context, jSONObject);
    }

    public static void a(Runnable runnable) {
        JCoreManager.onEvent(null, null, 78, null, null, runnable);
    }

    public static void a(Runnable runnable, int i4) {
        JCoreManager.onEvent(null, null, 83, null, null, runnable, Integer.valueOf(i4));
    }

    public static boolean a(Context context, String str) {
        return cn.jiguang.ag.a.a(context, str);
    }

    public static boolean a(Context context, boolean z3, String str) {
        return JConstants.isAndroidQ(context, z3, str);
    }

    public static boolean a(File file, String str) {
        return cn.jiguang.ag.d.a(file, str);
    }

    public static int b() {
        try {
            Object onEvent = JCoreManager.onEvent(null, null, 25, null, null, new Object[0]);
            if (onEvent instanceof Integer) {
                return ((Integer) onEvent).intValue();
            }
        } catch (Throwable unused) {
        }
        return 0;
    }

    public static String b(int i4) {
        return cn.jiguang.s.b.a(i4);
    }

    public static String b(Context context) {
        return cn.jiguang.h.a.c(context);
    }

    public static String b(String str) {
        return h.h(str);
    }

    public static void b(Runnable runnable) {
        JCoreManager.onEvent(null, null, 76, null, null, runnable);
    }

    public static boolean b(Context context, String str) {
        return cn.jiguang.ag.a.h(context, str);
    }

    public static long c(Context context) {
        return cn.jiguang.h.a.d(context);
    }

    public static String c(Context context, String str) {
        return cn.jiguang.ag.a.a(context, str, false);
    }

    public static String c(String str) {
        return h.b(str);
    }

    public static boolean c() {
        return cn.jiguang.s.b.c();
    }

    public static int d() {
        return JConstants.SDK_VERSION_INT;
    }

    public static String d(Context context) {
        return cn.jiguang.h.a.a(context);
    }

    public static String d(Context context, String str) {
        return cn.jiguang.ag.a.d(context, str);
    }

    public static byte[] d(String str) {
        return h.g(str);
    }

    public static String e(Context context, String str) {
        return cn.jiguang.ag.a.c(context, str);
    }

    public static String e(String str) {
        return cn.jiguang.ap.b.a(str, a.C0049a.f2223l);
    }

    public static boolean e() {
        return cn.jiguang.s.b.a();
    }

    public static boolean e(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 21, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static long f(Context context) {
        return ((Long) cn.jiguang.ai.b.a(context, cn.jiguang.ai.a.a())).longValue();
    }

    public static String f() {
        return cn.jiguang.ag.a.a();
    }

    public static String f(Context context, String str) {
        return cn.jiguang.ag.a.b(context, str);
    }

    public static String f(String str) {
        return cn.jiguang.ap.b.b(str, a.C0049a.f2223l);
    }

    public static long g() {
        return cn.jiguang.s.b.d();
    }

    public static File g(Context context, String str) {
        return cn.jiguang.ag.d.a(context, str);
    }

    public static String g(Context context) {
        return cn.jiguang.h.a.h(context);
    }

    public static int h() {
        try {
            Map<Integer, Bundle> e4 = cn.jiguang.s.b.e();
            cn.jiguang.w.a.b("JCommonPresenter", "map is " + e4.toString());
            if (e4.containsKey(2)) {
                String string = e4.get(2).getString("code");
                if (TextUtils.isDigitsOnly(string)) {
                    return Integer.parseInt(string);
                }
                return 0;
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static String h(Context context) {
        return cn.jiguang.h.a.f(context);
    }

    public static void h(Context context, String str) {
        JCoreManager.onEvent(context, "", 88, null, null, str);
    }

    public static int i() {
        try {
            Map<Integer, Bundle> e4 = cn.jiguang.s.b.e();
            cn.jiguang.w.a.b("JCommonPresenter", "map is " + e4.toString());
            if (e4.containsKey(23)) {
                String string = e4.get(23).getString("code");
                if (TextUtils.isDigitsOnly(string)) {
                    return Integer.parseInt(string);
                }
                return 0;
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static long i(Context context) {
        Object onEvent = JCoreManager.onEvent(context, null, 19, null, null, new Object[0]);
        return onEvent instanceof Long ? ((Long) onEvent).longValue() : System.currentTimeMillis() / 1000;
    }

    public static int j(Context context) {
        return cn.jiguang.h.a.g(context);
    }

    public static boolean j() {
        try {
            Object onEvent = JCoreManager.onEvent(null, null, 98, null, null, new Object[0]);
            if (onEvent instanceof Boolean) {
                return ((Boolean) onEvent).booleanValue();
            }
            return true;
        } catch (Throwable th) {
            cn.jiguang.w.a.c("JCommonPresenter", "isAuth", th);
            return true;
        }
    }

    public static boolean k(Context context) {
        return cn.jiguang.ag.a.l(context);
    }

    public static String l(Context context) {
        return i.a(context);
    }

    public static boolean m(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (a(context, "android.permission.ACCESS_NETWORK_STATE") && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && activeNetworkInfo.getType() == 0) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JCommonPresenter", "isMobileConnected failed, " + th.getMessage());
        }
        return false;
    }

    public static String n(Context context) {
        return cn.jiguang.ag.a.g(context);
    }

    public static boolean o(Context context) {
        if (!a(context, true, "canGetLbsInBackGround") || e() || cn.jiguang.ag.a.a(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            return true;
        }
        cn.jiguang.w.a.g("JCommonPresenter", "app is not in foreground and no android.permission.ACCESS_BACKGROUND_LOCATION");
        return false;
    }

    public static byte p(Context context) {
        return cn.jiguang.s.b.a(context);
    }

    public static String q(Context context) {
        return cn.jiguang.s.b.b(context);
    }

    public static String r(Context context) {
        Object a4 = cn.jiguang.s.b.a(context, JPushConstants.SDK_TYPE, 30000);
        if (a4 instanceof String) {
            return (String) a4;
        }
        return null;
    }

    public static String s(Context context) {
        Pair<String, Long> c4 = cn.jiguang.s.b.c(context);
        return (c4 == null || h.a((String) c4.first)) ? "" : (String) c4.first;
    }

    public static boolean t(Context context) {
        Object onEvent = JCoreManager.onEvent(context, "JCOMMON", 82, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static boolean u(Context context) {
        Object onEvent = JCoreManager.onEvent(context, "JCOMMON", 95, null, null, new Object[0]);
        if (onEvent instanceof Boolean) {
            return ((Boolean) onEvent).booleanValue();
        }
        return false;
    }

    public static String v(Context context) {
        String d4 = cn.jiguang.ag.a.d(context);
        if (TextUtils.isEmpty(d4)) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(d4);
        String str = File.separator;
        sb.append(str);
        sb.append("Android");
        sb.append(str);
        sb.append("data");
        return sb.toString();
    }

    public static boolean w(Context context) {
        NetworkInfo activeNetworkInfo;
        try {
            if (a(context, "android.permission.ACCESS_NETWORK_STATE") && (activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo()) != null && 1 == activeNetworkInfo.getType()) {
                return activeNetworkInfo.isConnected();
            }
            return false;
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JCommonPresenter", "isMobileConnected failed, " + th.getMessage());
        }
        return false;
    }
}
