package com.acse.ottn.p042d;

import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.PowerManager;
import android.os.Process;
import androidx.annotation.RequiresApi;
import com.acse.ottn.p042d.p044b.C1497F;
import com.acse.ottn.p042d.p044b.C1505h;
import com.acse.ottn.p042d.p044b.C1509l;
import com.acse.ottn.p042d.p044b.C1523z;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.C1703va;
import com.acse.ottn.util.HelpShopAppUtil;
import com.bxkj.student.C4229c;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* renamed from: com.acse.ottn.d.k */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1533k {

    /* renamed from: a */
    static final String f2835a = "isHuawei";

    /* renamed from: b */
    static final String f2836b = "isXiaomi";

    /* renamed from: c */
    static final String f2837c = "isOppo";

    /* renamed from: d */
    static final String f2838d = "isVivo";

    /* renamed from: e */
    static final String f2839e = "isMeizu";

    /* renamed from: f */
    static final String f2840f = "isSamsung";

    /* renamed from: g */
    static final String f2841g = "isLetv";

    /* renamed from: h */
    static final String f2842h = "isSmartisan";

    /* renamed from: i */
    private static volatile C1533k f2843i;

    /* renamed from: a */
    public static C1533k m56493a() {
        if (f2843i == null) {
            synchronized (C1533k.class) {
                if (f2843i == null) {
                    f2843i = new C1533k();
                }
            }
        }
        return f2843i;
    }

    /* renamed from: a */
    public void m56492a(Activity activity, String str) {
        String m56193b = C1638Ka.m56193b();
        if (C1661ba.m56097a() != null) {
            C1661ba.m56097a().m56088b(TTDownloadField.TT_PACKAGE_NAME, str);
            C1661ba.m56097a().m56092a("battery_white", true);
            C1661ba.m56097a().m56092a("open_battery_white", true);
        }
        if (C1663ca.m56080c().m56078e()) {
            if (C1661ba.m56097a().m56096a("open_battery_white_size")) {
                C1703va.m55903a().m55901a("no_find_auto_start");
                C1661ba.m56097a().m56092a("open_battery_white", true);
            } else {
                C1661ba.m56097a().m56092a("open_battery_white_size", true);
                C1661ba.m56097a().m56092a("open_battery_white", false);
            }
            C1505h.m56621a(activity);
        } else if ("vivo".equals(m56193b)) {
            C1497F.m56633b(activity);
        } else if ("oppo".equals(m56193b) || "realme".equals(m56193b)) {
            C1523z.m56536a(activity);
        } else if ("samsung".equals(m56193b)) {
            try {
                Intent intent = new Intent("android.settings.REQUEST_IGNORE_BATTERY_OPTIMIZATIONS");
                StringBuilder sb = new StringBuilder();
                sb.append("package:");
                sb.append(str);
                intent.setData(Uri.parse(sb.toString()));
                activity.startActivityForResult(intent, 10013);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (C4229c.f16088d.equals(m56193b) || "redmi".equals(m56193b) || "blackshark".equals(m56193b)) {
            if (C1661ba.m56097a() != null) {
                C1661ba.m56097a().m56088b("OpenPermissionName", "后台弹出界面");
            }
            C1509l.m56590a(activity);
        } else if (!"oneplus".equals(m56193b)) {
            C1694ra.m55915b("WhiteListPermission", "current phone is no open battery white");
            C1661ba.m56097a().m56092a("open_battery_white", true);
        } else {
            Intent intent2 = new Intent();
            intent2.addFlags(268435456);
            intent2.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts("package", str, null));
            activity.startActivityForResult(intent2, 10013);
        }
    }

    @RequiresApi(api = 19)
    /* renamed from: a */
    public boolean m56491a(String str) {
        AppOpsManager appOpsManager = Build.VERSION.SDK_INT >= 19 ? (AppOpsManager) HelpShopAppUtil.getContext().getSystemService("appops") : null;
        try {
            Class<?> cls = appOpsManager.getClass();
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, 10021, Integer.valueOf(Process.myUid()), str)).intValue() == 0;
        } catch (Exception unused) {
            if (C1661ba.m56097a() != null) {
                C1661ba.m56097a().m56096a("open_battery_white");
            }
            return true;
        }
    }

    /* renamed from: b */
    public boolean m56490b() {
        String m56193b = C1638Ka.m56193b();
        if ("samsung".equals(m56193b)) {
            if (Build.VERSION.SDK_INT > 23) {
                PowerManager powerManager = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power");
                if (powerManager != null) {
                    return powerManager.isIgnoringBatteryOptimizations(HelpShopAppUtil.getContext().getPackageName());
                }
                return false;
            }
            return true;
        } else if (C1663ca.m56080c().m56078e() || "oppo".equals(m56193b) || "vivo".equals(m56193b) || "realme".equals(m56193b) || "oneplus".equals(m56193b)) {
            if (C1661ba.m56097a() == null) {
                return true;
            }
            return C1661ba.m56097a().m56096a("open_battery_white");
        } else if (C4229c.f16088d.equals(m56193b) || "redmi".equals(m56193b) || "blackshark".equals(m56193b)) {
            return m56491a(HelpShopAppUtil.getContext().getPackageName());
        } else {
            if (C1661ba.m56097a() != null) {
                C1661ba.m56097a().m56092a("open_battery_white", true);
                return true;
            }
            return true;
        }
    }

    /* renamed from: b */
    public boolean m56489b(String str) {
        PowerManager powerManager;
        if ("".equals(str)) {
            return true;
        }
        if (C4229c.f16088d.equals(C1638Ka.m56193b()) || "redmi".equals(C1638Ka.m56193b()) || "blackshark".equals(C1638Ka.m56193b())) {
            if (Build.VERSION.SDK_INT >= 19) {
                return m56491a(str);
            }
            return false;
        } else if (!"samsung".equals(C1638Ka.m56193b()) || (powerManager = (PowerManager) HelpShopAppUtil.getContext().getSystemService("power")) == null) {
            return C1661ba.m56097a().m56096a("open_battery_white");
        } else {
            if (Build.VERSION.SDK_INT >= 23) {
                return powerManager.isIgnoringBatteryOptimizations(str);
            }
            return false;
        }
    }
}
