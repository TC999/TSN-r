package com.acse.ottn.d;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import androidx.annotation.RequiresApi;
import com.acse.ottn.d.b.F;
import com.acse.ottn.d.b.l;
import com.acse.ottn.d.b.z;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1421ca;
import com.acse.ottn.util.HelpShopAppUtil;
import com.acse.ottn.util.Ka;
import com.acse.ottn.util.ra;
import com.acse.ottn.util.va;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class k {

    /* renamed from: a  reason: collision with root package name */
    static final String f5525a = "isHuawei";

    /* renamed from: b  reason: collision with root package name */
    static final String f5526b = "isXiaomi";

    /* renamed from: c  reason: collision with root package name */
    static final String f5527c = "isOppo";

    /* renamed from: d  reason: collision with root package name */
    static final String f5528d = "isVivo";

    /* renamed from: e  reason: collision with root package name */
    static final String f5529e = "isMeizu";

    /* renamed from: f  reason: collision with root package name */
    static final String f5530f = "isSamsung";

    /* renamed from: g  reason: collision with root package name */
    static final String f5531g = "isLetv";

    /* renamed from: h  reason: collision with root package name */
    static final String f5532h = "isSmartisan";

    /* renamed from: i  reason: collision with root package name */
    private static volatile k f5533i;

    public static k a() {
        if (f5533i == null) {
            synchronized (k.class) {
                if (f5533i == null) {
                    f5533i = new k();
                }
            }
        }
        return f5533i;
    }

    public void a(Activity activity, String str) {
        String b4 = Ka.b();
        if (C1419ba.a() != null) {
            C1419ba.a().b("packageName", str);
            C1419ba.a().a("battery_white", true);
            C1419ba.a().a("open_battery_white", true);
        }
        if (C1421ca.c().e()) {
            if (C1419ba.a().a("open_battery_white_size")) {
                va.a().a("no_find_auto_start");
                C1419ba.a().a("open_battery_white", true);
            } else {
                C1419ba.a().a("open_battery_white_size", true);
                C1419ba.a().a("open_battery_white", false);
            }
            com.acse.ottn.d.b.h.a(activity);
        } else if ("vivo".equals(b4)) {
            F.b(activity);
        } else if ("oppo".equals(b4) || "realme".equals(b4)) {
            z.a(activity);
        } else if ("samsung".equals(b4)) {
            try {
                Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                StringBuilder sb = new StringBuilder();
                sb.append("package:");
                sb.append(str);
                intent.setData(Uri.parse(sb.toString()));
                activity.startActivityForResult(intent, 10013);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } else if ("xiaomi".equals(b4) || "redmi".equals(b4) || "blackshark".equals(b4)) {
            if (C1419ba.a() != null) {
                C1419ba.a().b("OpenPermissionName", "\u540e\u53f0\u5f39\u51fa\u754c\u9762");
            }
            l.a(activity);
        } else if (!"oneplus".equals(b4)) {
            ra.b("WhiteListPermission", "current phone is no open battery white");
            C1419ba.a().a("open_battery_white", true);
        } else {
            Intent intent2 = new Intent();
            intent2.addFlags(268435456);
            intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts("package", str, null));
            activity.startActivityForResult(intent2, 10013);
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
            if (C1419ba.a() != null) {
                C1419ba.a().a("open_battery_white");
            }
            return true;
        }
    }

    public boolean b() {
        String b4 = Ka.b();
        if ("samsung".equals(b4)) {
            if (Build.VERSION.SDK_INT > 23) {
                PowerManager powerManager = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power");
                if (powerManager != null) {
                    return powerManager.isIgnoringBatteryOptimizations(HelpShopAppUtil.getContext().getPackageName());
                }
                return false;
            }
            return true;
        } else if (C1421ca.c().e() || "oppo".equals(b4) || "vivo".equals(b4) || "realme".equals(b4) || "oneplus".equals(b4)) {
            if (C1419ba.a() == null) {
                return true;
            }
            return C1419ba.a().a("open_battery_white");
        } else if ("xiaomi".equals(b4) || "redmi".equals(b4) || "blackshark".equals(b4)) {
            return a(HelpShopAppUtil.getContext().getPackageName());
        } else {
            if (C1419ba.a() != null) {
                C1419ba.a().a("open_battery_white", true);
                return true;
            }
            return true;
        }
    }

    public boolean b(String str) {
        PowerManager powerManager;
        if ("".equals(str)) {
            return true;
        }
        if ("xiaomi".equals(Ka.b()) || "redmi".equals(Ka.b()) || "blackshark".equals(Ka.b())) {
            if (Build.VERSION.SDK_INT >= 19) {
                return a(str);
            }
            return false;
        } else if (!"samsung".equals(Ka.b()) || (powerManager = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power")) == null) {
            return C1419ba.a().a("open_battery_white");
        } else {
            if (Build.VERSION.SDK_INT >= 23) {
                return powerManager.isIgnoringBatteryOptimizations(str);
            }
            return false;
        }
    }
}
