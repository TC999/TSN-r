package cn.jiguang.bp;

import android.content.Context;
import android.content.SharedPreferences;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g {

    /* renamed from: a  reason: collision with root package name */
    private static String f2822a = "cn.jiguang.joperate.jcore_config";

    /* renamed from: b  reason: collision with root package name */
    private static SharedPreferences f2823b;

    public static int a(Context context, int i4) {
        return a(context, "notification_state", i4);
    }

    private static int a(Context context, String str, int i4) {
        return q(context).getInt(str, i4);
    }

    public static long a(Context context) {
        return a(context, "user_version", 0L);
    }

    private static long a(Context context, String str, long j4) {
        return q(context).getLong(str, j4);
    }

    private static String a(Context context, String str, String str2) {
        return q(context).getString(str, str2);
    }

    public static void a(Context context, long j4) {
        b(context, "user_version", j4);
    }

    public static void a(Context context, String str) {
        b(context, "c_uid", str);
    }

    public static void a(Context context, boolean z3) {
        b(context, "install_first_start_app", z3);
    }

    private static boolean a(Context context, String str, boolean z3) {
        return q(context).getBoolean(str, z3);
    }

    public static long b(Context context) {
        return a(context, "event_version", 0L);
    }

    public static void b(Context context, int i4) {
        b(context, "notification_state", i4);
    }

    public static void b(Context context, long j4) {
        b(context, "event_version", j4);
    }

    public static void b(Context context, String str) {
        b(context, "orgId", str);
    }

    private static void b(Context context, String str, int i4) {
        SharedPreferences.Editor edit = q(context).edit();
        edit.putInt(str, i4);
        edit.apply();
    }

    private static void b(Context context, String str, long j4) {
        SharedPreferences.Editor edit = q(context).edit();
        edit.putLong(str, j4);
        edit.apply();
    }

    private static void b(Context context, String str, String str2) {
        SharedPreferences.Editor edit = q(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }

    private static void b(Context context, String str, boolean z3) {
        SharedPreferences.Editor edit = q(context).edit();
        edit.putBoolean(str, z3);
        edit.apply();
    }

    public static void b(Context context, boolean z3) {
        b(context, "jopetate_off", z3);
    }

    public static String c(Context context) {
        return a(context, "c_uid", (String) null);
    }

    public static void c(Context context, long j4) {
        b(context, "get_event_intervals", j4);
    }

    public static void c(Context context, String str) {
        b(context, "data_source_id", str);
    }

    public static String d(Context context) {
        return a(context, "orgId", (String) null);
    }

    public static void d(Context context, long j4) {
        b(context, "get_event_last_time", j4);
    }

    public static void d(Context context, String str) {
        b(context, "super_properties", str);
    }

    public static String e(Context context) {
        return a(context, "data_source_id", (String) null);
    }

    public static void e(Context context, long j4) {
        b(context, "app_hide_date", j4);
    }

    public static void e(Context context, String str) {
        b(context, "old_app_active", str);
    }

    public static String f(Context context) {
        return a(context, "super_properties", (String) null);
    }

    public static void f(Context context, String str) {
        b(context, "old_app_cuid", str);
    }

    public static long g(Context context) {
        return a(context, "report_last_time", 0L);
    }

    public static void h(Context context) {
        b(context, "report_last_time", System.currentTimeMillis());
    }

    public static boolean i(Context context) {
        return a(context, "install_first_start_app", true);
    }

    public static boolean j(Context context) {
        long a4 = a(context, "install_date", 0L);
        if (a4 > 0) {
            long j4 = a4 + 86400;
            return System.currentTimeMillis() / 1000 < j4 - (j4 % 86400);
        }
        b(context, "install_date", System.currentTimeMillis() / 1000);
        return true;
    }

    public static String k(Context context) {
        return a(context, "old_app_active", (String) null);
    }

    public static String l(Context context) {
        return a(context, "old_app_cuid", (String) null);
    }

    public static boolean m(Context context) {
        return a(context, "jopetate_off", false);
    }

    public static long n(Context context) {
        return a(context, "get_event_intervals", 0L);
    }

    public static long o(Context context) {
        return a(context, "get_event_last_time", 0L);
    }

    public static long p(Context context) {
        return a(context, "app_hide_date", 0L);
    }

    private static SharedPreferences q(Context context) {
        if (f2823b == null) {
            f2823b = context.getSharedPreferences(f2822a, 0);
        }
        return f2823b;
    }
}
