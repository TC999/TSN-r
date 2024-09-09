package cn.jpush.android.cache;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import cn.jpush.android.ad.l;
import cn.jpush.android.ad.m;
import cn.jpush.android.api.JPushInterface;
import cn.jpush.android.helper.Logger;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    private static SharedPreferences f4119a;

    public static void a(Context context) {
        f4119a = context.getSharedPreferences("cn.jpush.config", 0);
    }

    public static void a(Context context, int i4) {
        t(context).edit().putInt("service_stoped", i4).apply();
    }

    public static void a(Context context, long j4) {
        if (j4 < 0) {
            Logger.w("PushConfig", "freeze end time was incorrect!");
            return;
        }
        if (j4 > 1800) {
            Logger.i("PushConfig", "freeze end time was greate than half an hour");
            j4 = 1800;
        }
        t(context).edit().putLong("TAFreezeSetTime", System.currentTimeMillis()).putLong("TAFreezeEndTime", j4 * 1000).apply();
    }

    public static void a(Context context, String str) {
        if (!TextUtils.isEmpty(str)) {
            str = l.a(str, m.f4027a);
        }
        t(context).edit().putString("mobile_number", str).apply();
    }

    public static void a(Context context, String str, String str2) {
        SharedPreferences.Editor edit = t(context).edit();
        edit.putString("jpush_save_custom_builder" + str, str2).apply();
    }

    public static void a(Context context, boolean z3) {
        t(context).edit().putBoolean("ups_state", z3).apply();
    }

    public static int b(Context context) {
        SharedPreferences reload = Sp.reload(context, "cn.jpush.config");
        if (reload == null) {
            reload = t(context);
        }
        int i4 = reload.getInt("service_stoped", -1);
        if (i4 < 0) {
            int i5 = context.getSharedPreferences("cn.jpush.android.user.profile", 0).getInt("service_stoped", 0);
            a(context, i5);
            return i5;
        }
        return i4;
    }

    public static void b(Context context, long j4) {
        t(context).edit().putLong("geofence_interval", j4).apply();
    }

    public static void b(Context context, String str) {
        t(context).edit().putString("setting_push_time", str).apply();
    }

    public static void b(Context context, String str, String str2) {
        Sp.set(context, Key.JAppKey(str).set(str2));
    }

    public static void b(Context context, boolean z3) {
        t(context).edit().putBoolean("notification_enabled", z3).apply();
    }

    public static boolean b(Context context, int i4) {
        String str;
        if (i4 != 0 && b(context) >= 1) {
            str = "The service is stopped, it will give up all the actions until you call resumePush method to resume the service.";
        } else if (i4 != 1 && !c(context)) {
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.trunOn method to resume the service.";
        } else if (i4 == 2 || ((Boolean) Sp.get(context, Key.UPSRegister())).booleanValue()) {
            return false;
        } else {
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.registerToken method to resume the service.";
        }
        Logger.ww("PushConfig", str);
        return true;
    }

    public static long c(Context context, long j4) {
        long j5 = t(context).getLong("geofence_interval", -1L);
        if (j5 == -1) {
            j5 = context.getSharedPreferences("cn.jpush.android.user.profile", 0).getLong("geofence_interval", -1L);
            if (j5 != -1) {
                b(context, j5);
            }
        }
        return j5 == -1 ? j4 : j5;
    }

    public static void c(Context context, int i4) {
        t(context).edit().putInt("notification_num", i4).apply();
    }

    public static void c(Context context, String str) {
        t(context).edit().putString("setting_silence_push_time", str).apply();
    }

    public static void c(Context context, String str, String str2) {
        Sp.set(context, Key.MAppKey(str).set(str2));
    }

    public static void c(Context context, boolean z3) {
        t(context).edit().putBoolean("geofence_pull_enable", z3).apply();
    }

    public static boolean c(Context context) {
        return t(context).getBoolean("ups_state", true);
    }

    public static String d(Context context, String str) {
        SharedPreferences t3 = t(context);
        String string = t3.getString("jpush_save_custom_builder" + str, "");
        if (TextUtils.isEmpty(string)) {
            SharedPreferences sharedPreferences = context.getSharedPreferences("cn.jpush.android.user.profile", 0);
            String string2 = sharedPreferences.getString("jpush_save_custom_builder" + str, "");
            a(context, str, string2);
            return string2;
        }
        return string;
    }

    public static void d(Context context, int i4) {
        t(context).edit().putInt("geofence_max_num", i4).apply();
    }

    public static void d(Context context, long j4) {
        t(context).edit().putLong("p_last_time", j4).apply();
    }

    public static void d(Context context, String str, String str2) {
        Sp.set(context, Key.MAppId(str).set(str2));
    }

    public static void d(Context context, boolean z3) {
        t(context).edit().putBoolean("push_geofence_enable", z3).apply();
    }

    public static boolean d(Context context) {
        String str;
        if (b(context) >= 1) {
            str = "The service is stopped, it will give up all the actions until you call resumePush method to resume the service.";
        } else if (!c(context)) {
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.trunOn method to resume the service.";
        } else if (((Boolean) Sp.get(context, Key.UPSRegister())).booleanValue()) {
            return false;
        } else {
            str = "The service is stopped, it will give up all the actions until you call JPushUPSManager.registerToken method to resume the service.";
        }
        Logger.dd("PushConfig", str);
        return true;
    }

    public static int e(Context context, int i4) {
        int i5 = t(context).getInt("geofence_max_num", -1);
        if (i5 == -1 && (i5 = context.getSharedPreferences("cn.jpush.android.user.profile", 0).getInt("geofence_max_num", -1)) != -1) {
            d(context, i5);
        }
        return i5 == -1 ? i4 : i5;
    }

    public static String e(Context context) {
        String string = t(context).getString("mobile_number", null);
        return !TextUtils.isEmpty(string) ? l.b(string, m.f4027a) : string;
    }

    public static void e(Context context, String str) {
        t(context).edit().putString("geofence_pull_limit", str).apply();
    }

    public static void e(Context context, String str, String str2) {
        Sp.set(context, Key.MAppSecret(str).set(str2));
    }

    public static void e(Context context, boolean z3) {
        t(context).edit().putBoolean("push_link_enable", z3).apply();
    }

    public static void f(Context context, int i4) {
        Sp.set(context, Key.registerType().set(Integer.valueOf(i4)));
    }

    public static void f(Context context, String str) {
        t(context).edit().putString("geofence_last_pull_state", str).apply();
    }

    public static void f(Context context, boolean z3) {
        t(context).edit().putBoolean("push_notification_callback_enable", z3).apply();
    }

    public static boolean f(Context context) {
        return t(context).getBoolean("notification_enabled", true);
    }

    public static String g(Context context) {
        return t(context).getString("setting_push_time", "");
    }

    public static String g(Context context, String str) {
        return (String) Sp.get(context, Key.JAppKey(str));
    }

    public static void g(Context context, boolean z3) {
        t(context).edit().putBoolean("push_smart_enable", z3).apply();
    }

    public static String h(Context context) {
        return t(context).getString("setting_silence_push_time", "");
    }

    public static String h(Context context, String str) {
        return (String) Sp.get(context, Key.MAppKey(str));
    }

    public static int i(Context context) {
        return t(context).getInt("notification_num", JPushInterface.DEFAULT_NOTIFICATION_NUM);
    }

    public static String i(Context context, String str) {
        return (String) Sp.get(context, Key.MAppId(str));
    }

    public static String j(Context context, String str) {
        return (String) Sp.get(context, Key.MAppSecret(str));
    }

    public static boolean j(Context context) {
        long j4 = t(context).getLong("TAFreezeEndTime", -1L);
        if (j4 > 1800) {
            j4 = 0;
        }
        long j5 = t(context).getLong("TAFreezeSetTime", -1L);
        if (j4 == -1 || j5 == -1) {
            return false;
        }
        if (System.currentTimeMillis() - j5 < 0 || System.currentTimeMillis() - j5 > j4) {
            t(context).edit().putLong("TAFreezeSetTime", -1L).putLong("TAFreezeEndTime", -1L).apply();
            Logger.w("PushConfig", "incorrect timestamp");
            return true;
        }
        return false;
    }

    public static boolean k(Context context) {
        return t(context).getBoolean("geofence_pull_enable", false);
    }

    public static String l(Context context) {
        return t(context).getString("geofence_pull_limit", "");
    }

    public static String m(Context context) {
        return t(context).getString("geofence_last_pull_state", "");
    }

    public static boolean n(Context context) {
        return t(context).getBoolean("push_geofence_enable", true);
    }

    public static boolean o(Context context) {
        return t(context).getBoolean("push_link_enable", true);
    }

    public static boolean p(Context context) {
        return t(context).getBoolean("push_notification_callback_enable", false);
    }

    public static boolean q(Context context) {
        return t(context).getBoolean("push_smart_enable", true);
    }

    public static long r(Context context) {
        return t(context).getLong("p_last_time", 0L);
    }

    public static int s(Context context) {
        return ((Integer) Sp.get(context, Key.registerType())).intValue();
    }

    private static SharedPreferences t(Context context) {
        if (f4119a == null) {
            a(context);
        }
        return f4119a;
    }
}
