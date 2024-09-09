package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class w2 {

    /* renamed from: a  reason: collision with root package name */
    public static w2 f6933a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f6934b = "OpenMobilePermissionUtil";

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f6935a;

        public a(AccessibilityService accessibilityService) {
            this.f6935a = accessibilityService;
        }

        @Override // java.lang.Runnable
        public void run() {
            o4.b(this.f6935a);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
        }
    }

    public static w2 a() {
        if (f6933a == null) {
            synchronized (w2.class) {
                if (f6933a == null) {
                    f6933a = new w2();
                }
            }
        }
        return f6933a;
    }

    public boolean b() {
        return "huawei".equals(c4.b()) || "honor".equals(c4.b()) || "tdtech".equals(c4.b()) || "tyh612m".equals(c4.p());
    }

    public boolean c() {
        return "huawei".equals(c4.b()) || "honor".equals(c4.b()) || "oppo".equals(c4.b()) || "vivo".equals(c4.b()) || "xiaomi".equals(c4.b()) || "redmi".equals(c4.b()) || "realme".equals(c4.b()) || "oneplus".equals(c4.b()) || "blackshark".equals(c4.b()) || "samsung".equals(c4.b());
    }

    public boolean d() {
        return e() || c();
    }

    public boolean e() {
        return "tyh612m".equals(c4.p());
    }

    public final Object f() throws ObjectStreamException {
        return f6933a;
    }

    public boolean a(AccessibilityService accessibilityService, String str) {
        if (g1.a() == null) {
            return false;
        }
        str.hashCode();
        char c4 = '\uffff';
        switch (str.hashCode()) {
            case -1837416467:
                if (str.equals("com.iqoo.powersaving.fuelgauge.PowerRankActivity")) {
                    c4 = 0;
                    break;
                }
                break;
            case -1736638048:
                if (str.equals("com.oplusos.securitypermission.permission.PermissionGroupsActivity")) {
                    c4 = 1;
                    break;
                }
                break;
            case -1697916220:
                if (str.equals("com.android.packageinstaller.permission.ui.AppPermissionActivity")) {
                    c4 = 2;
                    break;
                }
                break;
            case -1508581269:
                if (str.equals("com.huawei.securitycenter.permission.ui.activity.PermissionSettingActivity")) {
                    c4 = 3;
                    break;
                }
                break;
            case -1504769691:
                if (str.equals("com.iqoo.powersaving.PowerSavingManagerActivity")) {
                    c4 = 4;
                    break;
                }
                break;
            case -1473395485:
                if (str.equals("com.miui.permcenter.autostart.AutoStartDetailManagementActivity")) {
                    c4 = 5;
                    break;
                }
                break;
            case -1213771616:
                if (str.equals("com.huawei.security.permission.ui.activity.PermissionSettingActivity")) {
                    c4 = 6;
                    break;
                }
                break;
            case -1150447007:
                if (str.equals("com.oplus.powermanager.fuelgaue.PowerControlActivity")) {
                    c4 = 7;
                    break;
                }
                break;
            case -1138471325:
                if (str.equals("com.coloros.powermanager.fuelgaue.PowerControlActivity")) {
                    c4 = '\b';
                    break;
                }
                break;
            case -888547196:
                if (str.equals("com.android.settings.SubSettings")) {
                    c4 = '\t';
                    break;
                }
                break;
            case -801027931:
                if (str.equals("com.hihonor.securitycenter.permission.ui.activity.MainActivity")) {
                    c4 = '\n';
                    break;
                }
                break;
            case -638199557:
                if (str.equals("com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity")) {
                    c4 = 11;
                    break;
                }
                break;
            case -347181517:
                if (str.equals("com.vivo.permissionmanager.activity.SoftPermissionDetailActivity")) {
                    c4 = '\f';
                    break;
                }
                break;
            case -102088186:
                if (str.equals("com.coloros.securitypermission.permission.PermissionGroupsActivity")) {
                    c4 = '\r';
                    break;
                }
                break;
            case -3605999:
                if (str.equals("com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity")) {
                    c4 = 14;
                    break;
                }
                break;
            case 335974848:
                if (str.equals("com.android.settings.Settings$AppAndNotificationDashboardActivity")) {
                    c4 = 15;
                    break;
                }
                break;
            case 362914745:
                if (str.equals("com.hihonor.systemmanager.appcontrol.activity.StartupAppControlActivity")) {
                    c4 = 16;
                    break;
                }
                break;
            case 366917116:
                if (str.equals("com.android.permissioncontroller.permission.ui.ManagePermissionsActivity")) {
                    c4 = 17;
                    break;
                }
                break;
            case 408505592:
                if (str.equals("com.huawei.security.permission.ui.activity.MainActivity")) {
                    c4 = 18;
                    break;
                }
                break;
            case 626548678:
                if (str.equals("com.android.settings.applications.InstalledAppDetailsTop")) {
                    c4 = 19;
                    break;
                }
                break;
            case 844891404:
                if (str.equals("com.miui.permcenter.permissions.PermissionAppsModifyActivity")) {
                    c4 = 20;
                    break;
                }
                break;
            case 1064378975:
                if (str.equals("com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity")) {
                    c4 = 21;
                    break;
                }
                break;
            case 1157708154:
                if (str.equals("com.oplusos.floatwindow.sysfloatwindow.FloatWindowListActivity")) {
                    c4 = 22;
                    break;
                }
                break;
            case 1356567262:
                if (str.equals("com.vivo.permissionmanager.activity.BgStartUpManagerActivity")) {
                    c4 = 23;
                    break;
                }
                break;
            case 1388125120:
                if (str.equals("com.android.settings.Settings$OverlaySettingsActivity")) {
                    c4 = 24;
                    break;
                }
                break;
            case 1535820958:
                if (str.equals("com.miui.permcenter.permissions.PermissionsEditorActivity")) {
                    c4 = 25;
                    break;
                }
                break;
            case 1577225874:
                if (str.equals("com.oplusos.securitypermission.permission.ui.handheld.PermissionAppsActivityNew")) {
                    c4 = 26;
                    break;
                }
                break;
            case 1647376138:
                if (str.equals("com.vivo.permissionmanager.activity.FloatWindowManagerActivity")) {
                    c4 = 27;
                    break;
                }
                break;
            case 1664890045:
                if (str.equals("com.miui.appmanager.ApplicationsDetailsActivity")) {
                    c4 = 28;
                    break;
                }
                break;
            case 1722840595:
                if (str.equals("com.hihonor.securitycenter.permission.ui.activity.PermissionSettingActivity")) {
                    c4 = 29;
                    break;
                }
                break;
            case 1784217206:
                if (str.equals("com.miui.permcenter.settings.OtherPermissionsActivity")) {
                    c4 = 30;
                    break;
                }
                break;
            case 1799810893:
                if (str.equals("com.huawei.securitycenter.permission.ui.activity.MainActivity")) {
                    c4 = 31;
                    break;
                }
                break;
            case 1916443872:
                if (str.equals("com.coloros.floatwindow.sysfloatwindow.FloatWindowListActivity")) {
                    c4 = ' ';
                    break;
                }
                break;
            case 2095881023:
                if (str.equals("com.android.settings.Settings$AppDrawOverlaySettingsActivity")) {
                    c4 = '!';
                    break;
                }
                break;
            case 2141154850:
                if (str.equals("com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity")) {
                    c4 = '\"';
                    break;
                }
                break;
        }
        switch (c4) {
            case 0:
            case 4:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    o4.d(accessibilityService);
                    return true;
                }
                return true;
            case 1:
            case '\r':
            case 17:
                if (g1.a().a("battery_white")) {
                    z1.a(f6934b, "oppo location");
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if (!"realme".equals(c4.b()) && !"oppo".equals(c4.b()) && !"oneplus".equals(c4.b())) {
                        if ("huawei".equals(c4.b()) || "honor".equals(c4.b())) {
                            com.acse.ottn.b.d().a(200L);
                            x1.b(accessibilityService);
                        }
                    } else {
                        x1.k(accessibilityService);
                    }
                    return true;
                }
                return true;
            case 2:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    x1.j(accessibilityService);
                    return true;
                }
                return true;
            case 3:
            case 6:
            case 29:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if (g1.a().a("location_permission")) {
                        g1.a().a("location_permission", false);
                        x1.a(accessibilityService, false);
                    } else {
                        l1.c(accessibilityService, false);
                    }
                    return true;
                }
                return true;
            case 5:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    h2.d(accessibilityService);
                    return true;
                }
                return true;
            case 7:
            case '\b':
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    x2.a(accessibilityService, System.currentTimeMillis());
                    return true;
                }
                return true;
            case '\t':
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if (("redmi".equals(c4.b()) || "xiaomi".equals(c4.b())) && Build.VERSION.SDK_INT >= 30) {
                        h2.c(accessibilityService);
                    } else if ("oneplus".equals(c4.b()) || "oppo".equals(c4.b()) || "realme".equals(c4.b())) {
                        u2.c(accessibilityService);
                    }
                    return true;
                }
                return true;
            case '\n':
            case 18:
            case 31:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if (g1.a().a("location_permission")) {
                        com.acse.ottn.b.d().a(100L);
                        g1.a().a("location_permission", false);
                        x1.a(accessibilityService, true);
                    } else {
                        l1.c(accessibilityService, true);
                    }
                    return true;
                }
                return true;
            case 11:
            case 14:
            case 16:
                z1.a(l1.f5876a, "find");
                if (!g1.a().a("battery_white")) {
                    z1.a(l1.f5876a, "battery_white is false");
                    return true;
                }
                z1.a(l1.f5876a, "battery_white is true =SystemUtil.getDeviceBrand()=" + c4.b());
                d.b().d(accessibilityService);
                g1.a().a("battery_white", false);
                if (b()) {
                    z1.a(l1.f5876a, "ok");
                    l1.b(accessibilityService, true);
                }
                return true;
            case '\f':
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if (g1.a().a("location_permission")) {
                        g1.a().a("location_permission", false);
                        com.acse.ottn.b.d().a(200L);
                        x1.e(accessibilityService);
                    } else {
                        new Handler(Looper.getMainLooper()).postDelayed(new a(accessibilityService), 200L);
                    }
                    return true;
                }
                return true;
            case 15:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if (b()) {
                        if (g1.a().a("location_permission")) {
                            g1.a().a("location_permission", false);
                            x1.c(accessibilityService);
                        } else {
                            l1.c(accessibilityService);
                        }
                    }
                    return true;
                }
                return true;
            case 19:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if ("oppo".equals(c4.b()) || "realme".equals(c4.b()) || "oneplus".equals(c4.b())) {
                        if (g1.a().a("location_permission")) {
                            g1.a().a("location_permission", false);
                            com.acse.ottn.b.d().a(300L);
                            x1.i(accessibilityService);
                        } else {
                            x2.d(accessibilityService);
                        }
                    }
                    return true;
                }
                return true;
            case 20:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    x1.a(accessibilityService, System.currentTimeMillis());
                    return true;
                }
                return true;
            case 21:
                if (g1.a().a("battery_white")) {
                    z1.a(f6934b, "clickServiceBackgroundHight init");
                    g1.a().a("battery_white", false);
                    d.b().d(accessibilityService);
                    com.acse.ottn.b.d().a(200L);
                    o4.a(accessibilityService, System.currentTimeMillis());
                    return true;
                }
                return true;
            case 22:
            case ' ':
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if (("realme".equals(c4.b()) || "oppo".equals(c4.b()) || "oneplus".equals(c4.b())) && !com.acse.ottn.b.d().g()) {
                        x2.h(accessibilityService);
                        return true;
                    }
                    return true;
                }
                return true;
            case 23:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    o4.a(accessibilityService, true);
                    return true;
                }
                return true;
            case 24:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if (!"redmi".equals(c4.b()) && !"xiaomi".equals(c4.b()) && !"blackshark".equals(c4.b())) {
                        if ("oneplus".equals(c4.b())) {
                            com.acse.ottn.b.d().a(true);
                            u2.e(accessibilityService);
                            return true;
                        } else if ("samsung".equals(c4.b())) {
                            com.acse.ottn.b.d().a(true);
                            h2.e(accessibilityService);
                            return true;
                        } else {
                            if (!"oppo".equals(c4.b()) && !"realme".equals(c4.b())) {
                                if (b()) {
                                    com.acse.ottn.b.d().a(true);
                                    l1.h(accessibilityService);
                                }
                            } else if (Build.VERSION.SDK_INT >= 33) {
                                com.acse.ottn.b.d().a(true);
                                u2.e(accessibilityService);
                            }
                            return true;
                        }
                    }
                    com.acse.ottn.b.d().a(true);
                    h2.e(accessibilityService);
                    return true;
                }
                return true;
            case 25:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    z1.a("samon-->", "clickHouTaiShowPage\u5012\u8ba1\u65f6 =3" + g1.a().a("location_permission"));
                    if (g1.a().a("location_permission")) {
                        g1.a().a("location_permission", false);
                        x1.f(accessibilityService);
                    } else {
                        z1.a("samon-->", "clickHouTaiShowPage\u5012\u8ba1\u65f6 =1");
                        h2.b(accessibilityService);
                    }
                    return true;
                }
                return true;
            case 26:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if (("realme".equals(c4.b()) || "oppo".equals(c4.b()) || "oneplus".equals(c4.b())) && !com.acse.ottn.b.d().g()) {
                        x2.g(accessibilityService);
                        return true;
                    }
                    return true;
                }
                return true;
            case 27:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    o4.a(accessibilityService, false);
                    return true;
                }
                return true;
            case 28:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    h2.b("\u81ea\u542f\u52a8", accessibilityService);
                    return true;
                }
                return true;
            case 30:
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    z1.a("samon-->", "clickHouTaiShowPage\u5012\u8ba1\u65f6 =2");
                    h2.b(accessibilityService);
                    return true;
                }
                return true;
            case '!':
                String str2 = f6934b;
                z1.a(str2, "current phone is " + c4.b());
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if (b()) {
                        l1.a(accessibilityService, System.currentTimeMillis(), false);
                    } else if ("vivo".equals(c4.b())) {
                        o4.c(accessibilityService);
                    } else if (!"redmi".equals(c4.b()) && !"xiaomi".equals(c4.b()) && !"blackshark".equals(c4.b())) {
                        if ("oneplus".equals(c4.b())) {
                            u2.c(accessibilityService);
                        }
                    } else {
                        h2.c(accessibilityService);
                    }
                    return true;
                }
                return true;
            case '\"':
                if (g1.a().a("battery_white")) {
                    d.b().d(accessibilityService);
                    g1.a().a("battery_white", false);
                    if (("oppo".equals(c4.b()) || "realme".equals(c4.b())) && !com.acse.ottn.b.d().g()) {
                        x2.i(accessibilityService);
                        return true;
                    }
                    return true;
                }
                return true;
            default:
                return false;
        }
    }

    public final void a(Service service) {
        new Handler(Looper.getMainLooper()).post(new b());
    }
}
