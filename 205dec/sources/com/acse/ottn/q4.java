package com.acse.ottn;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.HelpShopAppUtil;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class q4 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f6186a = "isHuawei";

    /* renamed from: b  reason: collision with root package name */
    public static final String f6187b = "isXiaomi";

    /* renamed from: c  reason: collision with root package name */
    public static final String f6188c = "isOppo";

    /* renamed from: d  reason: collision with root package name */
    public static final String f6189d = "isVivo";

    /* renamed from: e  reason: collision with root package name */
    public static final String f6190e = "isMeizu";

    /* renamed from: f  reason: collision with root package name */
    public static final String f6191f = "isSamsung";

    /* renamed from: g  reason: collision with root package name */
    public static final String f6192g = "isLetv";

    /* renamed from: h  reason: collision with root package name */
    public static final String f6193h = "isSmartisan";

    /* renamed from: i  reason: collision with root package name */
    public static volatile q4 f6194i;

    public static q4 a() {
        if (f6194i == null) {
            synchronized (q4.class) {
                if (f6194i == null) {
                    f6194i = new q4();
                }
            }
        }
        return f6194i;
    }

    public boolean b(String str) {
        PowerManager powerManager;
        if ("".equals(str)) {
            return true;
        }
        if (!"xiaomi".equals(c4.b()) && !"redmi".equals(c4.b()) && !"blackshark".equals(c4.b())) {
            if ("samsung".equals(c4.b()) && (powerManager = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power")) != null) {
                if (Build.VERSION.SDK_INT >= 23) {
                    return powerManager.isIgnoringBatteryOptimizations(str);
                }
                return false;
            }
            return g1.a().a("open_battery_white");
        } else if (Build.VERSION.SDK_INT >= 19) {
            return a(str);
        } else {
            return false;
        }
    }

    @RequiresApi(api = 19)
    public boolean a(String str) {
        AppOpsManager appOpsManager = Build.VERSION.SDK_INT >= 19 ? (AppOpsManager) HelpShopAppUtil.getContext().getSystemService("appops") : null;
        try {
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, 10021, Integer.valueOf(Process.myUid()), str)).intValue() == 0;
        } catch (Exception unused) {
            if (g1.a() != null) {
                g1.a().a("open_battery_white");
            }
            return true;
        }
    }

    public boolean b() {
        String b4 = c4.b();
        if ("samsung".equals(b4)) {
            if (Build.VERSION.SDK_INT > 23) {
                PowerManager powerManager = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power");
                if (powerManager != null) {
                    return powerManager.isIgnoringBatteryOptimizations(HelpShopAppUtil.getContext().getPackageName());
                }
                return false;
            }
            return true;
        } else if (!h1.c().e() && !"oppo".equals(b4) && !"vivo".equals(b4) && !"realme".equals(b4) && !"oneplus".equals(b4)) {
            if (!"xiaomi".equals(b4) && !"redmi".equals(b4) && !"blackshark".equals(b4)) {
                if (g1.a() != null) {
                    g1.a().a("open_battery_white", true);
                    return true;
                }
                return true;
            }
            return a(HelpShopAppUtil.getContext().getPackageName());
        } else if (g1.a() == null) {
            return true;
        } else {
            return g1.a().a("open_battery_white");
        }
    }

    public void a(Activity activity, String str) {
        String b4 = c4.b();
        if (g1.a() != null) {
            g1.a().b("packageName", str);
            g1.a().a("battery_white", true);
            g1.a().a("open_battery_white", true);
        }
        if (h1.c().e()) {
            if (!g1.a().a("open_battery_white_size")) {
                g1.a().a("open_battery_white_size", true);
                g1.a().a("open_battery_white", false);
            } else {
                i2.a().a("no_find_auto_start");
                g1.a().a("open_battery_white", true);
            }
            l1.a(activity);
        } else if ("vivo".equals(b4)) {
            o4.b(activity);
        } else if (!"oppo".equals(b4) && !"realme".equals(b4)) {
            if ("samsung".equals(b4)) {
                try {
                    Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                    intent.setData(Uri.parse("package:" + str));
                    activity.startActivityForResult(intent, 10013);
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            } else if (!"xiaomi".equals(b4) && !"redmi".equals(b4) && !"blackshark".equals(b4)) {
                if ("oneplus".equals(b4)) {
                    Intent intent2 = new Intent();
                    intent2.addFlags(268435456);
                    intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent2.setData(Uri.fromParts("package", str, null));
                    activity.startActivityForResult(intent2, 10013);
                    return;
                }
                z1.b("WhiteListPermission", "current phone is no open battery white");
                g1.a().a("open_battery_white", true);
            } else {
                if (g1.a() != null) {
                    g1.a().b("OpenPermissionName", "\u540e\u53f0\u5f39\u51fa\u754c\u9762");
                }
                h2.b(activity);
            }
        } else {
            x2.a(activity);
        }
    }
}
