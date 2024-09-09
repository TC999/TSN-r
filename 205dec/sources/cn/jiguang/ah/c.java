package cn.jiguang.ah;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.jiguang.ag.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@SuppressLint({"CommitPrefEdits"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static List<Integer> f2236a;

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f2237b;

    /* renamed from: c  reason: collision with root package name */
    private static HashMap<String, Long> f2238c;

    static {
        ArrayList arrayList = new ArrayList();
        f2236a = arrayList;
        arrayList.add(2012);
        f2236a.add(1015);
        f2236a.add(2009);
        f2236a.add(2002);
        f2236a.add(2006);
        f2236a.add(2008);
        f2236a.add(2014);
        f2236a.add(1020);
    }

    public static String a(Context context, int i4, boolean z3) {
        String string = o(context).getString(b(i4, c(i4)), "");
        if (TextUtils.isEmpty(string)) {
            return "";
        }
        if (z3) {
            string = d.f(string);
        }
        return string;
    }

    private static String a(String str, String str2) {
        return str + str2;
    }

    private static void a() {
        HashMap<String, Long> hashMap = new HashMap<>();
        f2238c = hashMap;
        hashMap.put(a("JDataConfigManager", "_bi"), 86400000L);
        f2238c.put(a("JWakeReport", "_ri"), 3600000L);
    }

    public static void a(Context context) {
        String p3 = p(context);
        o(context).edit().putInt(p3, o(context).getInt(p3, 0) + 1).apply();
    }

    public static void a(Context context, int i4) {
        o(context).edit().putInt("rrat", i4).apply();
    }

    public static void a(Context context, int i4, long j4) {
        if (j4 < 0) {
            return;
        }
        String b4 = b(i4, "method_freq_time_");
        cn.jiguang.w.a.e("JCommonConfig", "update " + i4 + " method time :" + j4);
        o(context).edit().putLong(b4, j4).apply();
    }

    public static void a(final Context context, final int i4, final String str, final boolean z3) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b(new Runnable() { // from class: cn.jiguang.ah.c.1
            @Override // java.lang.Runnable
            public void run() {
                int i5 = i4;
                String b4 = c.b(i5, c.c(i5));
                cn.jiguang.w.a.e("JCommonConfig", "update " + i4 + " method cache :" + str);
                String str2 = str;
                if (z3) {
                    str2 = d.e(str2);
                }
                c.o(context).edit().putString(b4, str2).apply();
            }
        });
    }

    public static void a(Context context, String str, int i4) {
        o(context).edit().putInt(a("JType", "ktsv_" + str), i4).apply();
    }

    public static void a(Context context, String str, long j4) {
        if (j4 < 0) {
            return;
        }
        if (!str.contains("JLocation") || j4 <= j(context, "JLocationv2")) {
            String a4 = a(str, "_bi");
            cn.jiguang.w.a.e("JCommonConfig", "update " + str + " businessInterval:" + j4);
            o(context).edit().putLong(a4, j4).apply();
        }
    }

    public static void a(Context context, String str, String str2) {
        o(context).edit().putString(a("JType", str), str2).apply();
    }

    public static void a(Context context, String str, boolean z3) {
        o(context).edit().putBoolean(a(str, "_ace"), z3).apply();
    }

    public static void a(Context context, boolean z3) {
        o(context).edit().putBoolean(a("user_wake", "_aue"), z3).apply();
    }

    public static boolean a(int i4) {
        boolean z3 = !d.e() && cn.jiguang.ar.a.a().c(i4) == 0;
        cn.jiguang.w.a.a(i4, "JCommonConfig", "configId : " + i4 + ", isBackgroundBusiness : " + z3);
        return z3;
    }

    public static boolean a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long f4 = f(context, str);
        long b4 = cn.jiguang.ar.a.a().b(str);
        boolean z3 = currentTimeMillis - f4 > b4;
        cn.jiguang.w.a.e("JCommonConfig", "is " + str + " businessTime:" + z3 + ",curTime:" + currentTimeMillis + ",lastBusinessTime:" + f4 + ",businessInterval:" + b4);
        return z3;
    }

    private static long b(String str, String str2) {
        try {
            return f2238c.get(a(str, str2)).longValue();
        } catch (NullPointerException unused) {
            return 0L;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(int i4, String str) {
        return str + i4;
    }

    public static void b(Context context, int i4) {
        o(context).edit().putInt("rrpt", i4).apply();
    }

    public static void b(Context context, int i4, long j4) {
        if (j4 < 0) {
            return;
        }
        String b4 = b(i4, "method_freq_ex_time_");
        cn.jiguang.w.a.e("JCommonConfig", "update " + i4 + " method time :" + j4);
        o(context).edit().putLong(b4, j4).apply();
    }

    public static void b(Context context, String str, long j4) {
        if (j4 < 0) {
            return;
        }
        String a4 = a(str, "_ri");
        cn.jiguang.w.a.e("JCommonConfig", "update " + str + " reportInterval:" + j4);
        o(context).edit().putLong(a4, j4).apply();
    }

    public static void b(Context context, String str, boolean z3) {
        o(context).edit().putBoolean(a(str, "_aue"), z3).apply();
    }

    public static void b(Context context, boolean z3) {
        o(context).edit().putBoolean("del_acm", z3).apply();
    }

    public static boolean b(Context context) {
        return o(context).getBoolean(a("user_wake", "_aue"), true);
    }

    public static boolean b(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long f4 = f(context, str);
        long g4 = g(context, str);
        boolean z3 = currentTimeMillis - f4 > g4;
        cn.jiguang.w.a.e("JCommonConfig", "is " + str + " businessTime:" + z3 + ",curTime:" + currentTimeMillis + ",lastBusinessTime:" + f4 + ",businessInterval:" + g4);
        return z3;
    }

    public static long c(Context context, int i4) {
        return o(context).getLong(b(i4, "method_freq_time_"), 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String c(int i4) {
        return f2236a.contains(Integer.valueOf(i4)) ? "method_freq_cache_new" : "method_freq_cache_";
    }

    public static String c(Context context) {
        return o(context).getString("JWakeLocalState", "");
    }

    public static boolean c(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long i4 = i(context, str);
        long d4 = cn.jiguang.ar.a.a().d(str);
        boolean z3 = currentTimeMillis - i4 > d4;
        cn.jiguang.w.a.e("JCommonConfig", "is " + str + " reportTime:" + z3 + ",curTime:" + currentTimeMillis + ",lastReportTime:" + i4 + ",reportInterval:" + d4);
        return z3;
    }

    public static int d(Context context) {
        return o(context).getInt("rrat", 1);
    }

    public static long d(Context context, int i4) {
        return o(context).getLong(b(i4, "method_freq_ex_time_"), 0L);
    }

    public static boolean d(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long i4 = i(context, str);
        long j4 = j(context, str);
        boolean z3 = currentTimeMillis - i4 > j4;
        cn.jiguang.w.a.e("JCommonConfig", "is " + str + " reportTime:" + z3 + ",curTime:" + currentTimeMillis + ",lastReportTime:" + i4 + ",reportInterval:" + j4);
        return z3;
    }

    public static int e(Context context) {
        return o(context).getInt("rrpt", 1);
    }

    public static void e(Context context, String str) {
        String a4 = a(str, "_blt");
        long currentTimeMillis = System.currentTimeMillis();
        cn.jiguang.w.a.e("JCommonConfig", "update " + str + " lastBusinessTime");
        o(context).edit().putLong(a4, currentTimeMillis).apply();
    }

    public static long f(Context context, String str) {
        return o(context).getLong(a(str, "_blt"), 0L);
    }

    public static String f(Context context) {
        return o(context).getString(a("JLocation", "info"), "");
    }

    public static long g(Context context, String str) {
        return o(context).getLong(a(str, "_bi"), b(str, "_bi"));
    }

    public static String g(Context context) {
        return o(context).getString(a("JLocation", "wifiSSID"), "");
    }

    public static String h(Context context) {
        return o(context).getString("JNotificationState", "");
    }

    public static void h(Context context, String str) {
        cn.jiguang.w.a.e("JCommonConfig", "update " + str + " lastReportTime");
        long currentTimeMillis = System.currentTimeMillis();
        o(context).edit().putLong(a(str, "_rlt"), currentTimeMillis).apply();
    }

    public static long i(Context context, String str) {
        return o(context).getLong(a(str, "_rlt"), 0L);
    }

    public static String i(Context context) {
        return o(context).getString("JDevicesession", "");
    }

    public static long j(Context context, String str) {
        return o(context).getLong(a(str, "_ri"), b(str, "_ri"));
    }

    public static boolean j(Context context) {
        return o(context).getBoolean("del_acm", false);
    }

    public static String k(Context context) {
        return o(context).getString("JDeviceIds", "");
    }

    public static boolean k(Context context, String str) {
        return o(context).getBoolean(a(str, "_ace"), true);
    }

    public static String l(Context context) {
        return o(context).getString("lo_cf", "");
    }

    public static boolean l(Context context, String str) {
        return o(context).getBoolean(a(str, "_aue"), true);
    }

    public static void m(Context context, String str) {
        if (h.a(str)) {
            return;
        }
        String p3 = p(context);
        if (p3 != null && !p3.equals(str)) {
            o(context).edit().remove(p3).apply();
        }
        o(context).edit().putString("current_time_key", str).apply();
    }

    public static int n(Context context, String str) {
        if (h.a(str)) {
            return Integer.MAX_VALUE;
        }
        return o(context).getInt(str, 0);
    }

    private static void n(Context context) {
        f2237b = context.getSharedPreferences("cn.jiguang.common", 0);
        a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SharedPreferences o(Context context) {
        if (f2237b == null) {
            n(context);
        }
        return f2237b;
    }

    public static void o(Context context, String str) {
        o(context).edit().putString("JWakeLocalState", str).apply();
    }

    private static String p(Context context) {
        return o(context).getString("current_time_key", null);
    }

    public static String p(Context context, String str) {
        return o(context).getString(a("JType", str), "-1,-1");
    }

    public static int q(Context context, String str) {
        return o(context).getInt(a("JType", "ktsv_" + str), 0);
    }

    public static void r(Context context, String str) {
        o(context).edit().putString(a("JLocation", "info"), str).apply();
    }

    public static void s(Context context, String str) {
        o(context).edit().putString(a("JLocation", "wifiSSID"), str).apply();
    }

    public static void t(Context context, String str) {
        o(context).edit().putString("JNotificationState", str).apply();
    }

    public static void u(Context context, String str) {
        cn.jiguang.w.a.e("JCommonConfig", "update deviceSession");
        o(context).edit().putString("JDevicesession", str).apply();
    }

    public static void v(Context context, String str) {
        o(context).edit().putString("JDeviceIds", str).apply();
    }

    public static void w(Context context, String str) {
        o(context).edit().putString("lo_cf", str).apply();
    }

    public static boolean x(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long f4 = f(context, str);
        long b4 = cn.jiguang.ar.a.a().b("JAppAll");
        boolean z3 = currentTimeMillis - f4 > b4;
        cn.jiguang.w.a.e("JCommonConfig", "is " + str + " businessTime:" + z3 + ",curTime:" + currentTimeMillis + ",lastBusinessTime:" + f4 + ",businessInterval:" + b4);
        return z3;
    }

    public static boolean y(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        long i4 = i(context, str);
        long d4 = cn.jiguang.ar.a.a().d("JAppAll");
        boolean z3 = currentTimeMillis - i4 > d4;
        cn.jiguang.w.a.e("JCommonConfig", "is " + str + " reportTime:" + z3 + ",curTime:" + currentTimeMillis + ",lastReportTime:" + i4 + ",reportInterval:" + d4);
        return z3;
    }
}
