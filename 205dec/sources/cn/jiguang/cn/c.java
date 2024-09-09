package cn.jiguang.cn;

import android.content.Context;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import cn.jiguang.internal.JConstants;
import java.io.File;
import java.util.UUID;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f3479a = 1;

    public static String a(Context context) {
        int i4;
        String b4 = b(context);
        if (cn.jiguang.f.g.h(b4)) {
            i4 = 3;
        } else {
            b4 = b(context, b4);
            if (cn.jiguang.f.g.h(b4)) {
                i4 = 1;
            } else {
                b4 = d(context);
                if (!cn.jiguang.f.g.h(b4)) {
                    String d4 = Build.VERSION.SDK_INT < 23 ? cn.jiguang.f.a.d(context, b4) : "";
                    String k4 = cn.jiguang.f.a.k(context);
                    String uuid = UUID.randomUUID().toString();
                    long currentTimeMillis = System.currentTimeMillis();
                    String d5 = cn.jiguang.f.g.d(d4 + k4 + uuid + currentTimeMillis);
                    if (TextUtils.isEmpty(d5)) {
                        d5 = uuid;
                    }
                    f3479a = 0;
                    new cn.jiguang.cc.c().b(d4).c(k4).d(uuid).a(currentTimeMillis).a(d5).a(context);
                    c(context, d5);
                    return d5;
                }
                i4 = 2;
            }
        }
        f3479a = i4;
        c(context, b4);
        return b4;
    }

    private static String a(Context context, String str, String str2) {
        try {
            return Settings.System.getString(context.getContentResolver(), str2);
        } catch (Throwable unused) {
            cn.jiguang.bq.d.l("DeviceIdUtils", "Can not read from settings");
            return str;
        }
    }

    public static void a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a(context, str, true);
    }

    private static void a(Context context, String str, boolean z3) {
        int i4;
        int i5;
        String a4 = g.a(str, cn.jiguang.a.a.f2017i);
        if (z3 || (i5 = f3479a) == 1 || i5 == 0) {
            d(context, a4);
        }
        if (z3 || (i4 = f3479a) == 2 || i4 == 0) {
            e(context, a4);
        }
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.b().a((cn.jiguang.g.a<String>) a4));
        c(context);
    }

    public static String b(Context context) {
        String str = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.b());
        if (TextUtils.isEmpty(str)) {
            String str2 = (String) cn.jiguang.g.b.a(context, cn.jiguang.g.a.a());
            if (TextUtils.isEmpty(str2)) {
                return null;
            }
            return str2;
        }
        return g.b(str, cn.jiguang.a.a.f2017i);
    }

    private static String b(Context context, String str) {
        if (cn.jiguang.f.a.c(context, "android.permission.WRITE_SETTINGS")) {
            String a4 = a(context, str, "dig_n");
            if (TextUtils.isEmpty(a4)) {
                String a5 = a(context, str, "dig");
                if (TextUtils.isEmpty(a5)) {
                    return null;
                }
                return a5;
            }
            return g.b(a4, cn.jiguang.a.a.f2017i);
        }
        return null;
    }

    private static void c(Context context) {
        if (cn.jiguang.f.a.c(context, "android.permission.WRITE_SETTINGS")) {
            Settings.System.putString(context.getContentResolver(), "dig", "");
        }
        if (!JConstants.isAndroidQ(context, true, "not write deviceId to SD") && cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            try {
                String h4 = cn.jiguang.f.a.h(context);
                if (!TextUtils.isEmpty(h4)) {
                    cn.jiguang.f.c.a(new File(h4 + ".push_deviceid"));
                }
            } catch (Throwable unused) {
            }
        }
        cn.jiguang.g.b.a(context, cn.jiguang.g.a.a().a((cn.jiguang.g.a<String>) null));
    }

    private static void c(Context context, String str) {
        a(context, str, false);
    }

    private static String d(Context context) {
        if (!JConstants.isAndroidQ(context, true, "do not get deviceId from SD") && cn.jiguang.f.a.c(context, "android.permission.READ_EXTERNAL_STORAGE")) {
            String f4 = f(context, ".p");
            if (!TextUtils.isEmpty(f4)) {
                return g.b(f4, cn.jiguang.a.a.f2017i);
            }
            String f5 = f(context, ".push_deviceid");
            if (!TextUtils.isEmpty(f5)) {
                return f5;
            }
        }
        return null;
    }

    private static String d(Context context, String str) {
        if (cn.jiguang.f.a.c(context, "android.permission.WRITE_SETTINGS")) {
            try {
                if (Settings.System.putString(context.getContentResolver(), "dig_n", str)) {
                    return str;
                }
                return null;
            } catch (Throwable unused) {
                cn.jiguang.bq.d.l("DeviceIdUtils", "Can not write settings");
                return null;
            }
        }
        return null;
    }

    private static String e(Context context, String str) {
        if (JConstants.isAndroidQ(context, true, "not write deviceId to SD")) {
            return str;
        }
        if (cn.jiguang.f.a.c(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
            try {
                String h4 = cn.jiguang.f.a.h(context);
                if (TextUtils.isEmpty(h4)) {
                    cn.jiguang.bq.d.l("DeviceIdUtils", "can't get sdcard data path");
                    return null;
                }
                cn.jiguang.f.c.c(new File(h4 + ".p"), str);
                return str;
            } catch (Throwable unused) {
                return null;
            }
        }
        return null;
    }

    private static String f(Context context, String str) {
        String h4 = cn.jiguang.f.a.h(context);
        if (TextUtils.isEmpty(h4)) {
            cn.jiguang.bq.d.l("DeviceIdUtils", "can't get sdcard data path");
            return null;
        }
        String d4 = cn.jiguang.f.c.d(new File(h4 + str));
        if (d4 != null) {
            int indexOf = d4.indexOf("\n");
            return indexOf < 0 ? d4.trim() : d4.substring(0, indexOf).trim();
        }
        return null;
    }
}
