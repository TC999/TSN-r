package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.p042d.p043a.C1490f;
import com.acse.ottn.p042d.p044b.C1497F;
import com.acse.ottn.p042d.p044b.C1505h;
import com.acse.ottn.p042d.p044b.C1509l;
import com.acse.ottn.p042d.p044b.C1517t;
import com.acse.ottn.p042d.p044b.C1523z;
import com.bxkj.student.C4229c;
import java.io.ObjectStreamException;

/* renamed from: com.acse.ottn.util.ya */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1710ya {

    /* renamed from: a */
    private static C1710ya f3390a = null;

    /* renamed from: b */
    private static String f3391b = "OpenMobilePermissionUtil";

    private C1710ya() {
    }

    /* renamed from: a */
    public static C1710ya m55883a() {
        if (f3390a == null) {
            synchronized (C1710ya.class) {
                if (f3390a == null) {
                    f3390a = new C1710ya();
                }
            }
        }
        return f3390a;
    }

    /* renamed from: a */
    private void m55881a(Service service) {
        new Handler(Looper.getMainLooper()).post(new RunnableC1708xa(this));
    }

    /* renamed from: f */
    private Object m55876f() throws ObjectStreamException {
        return f3390a;
    }

    /* renamed from: a */
    public boolean m55882a(AccessibilityService accessibilityService, String str) {
        if (C1661ba.m56097a() == null) {
            return false;
        }
        if (str.equals("com.android.settings.Settings$OverlaySettingsActivity")) {
            if (C1661ba.m56097a().m56096a("battery_white")) {
                C1617A.m56331b().m56320c(accessibilityService);
                C1661ba.m56097a().m56092a("battery_white", false);
                if ("redmi".equals(C1638Ka.m56193b()) || C4229c.f16088d.equals(C1638Ka.m56193b()) || "blackshark".equals(C1638Ka.m56193b())) {
                    C1684n.m55975c().m55985a(true);
                    C1509l.m56568h(accessibilityService);
                    return true;
                } else if ("oneplus".equals(C1638Ka.m56193b())) {
                    C1684n.m55975c().m55985a(true);
                    C1517t.m56540d(accessibilityService);
                    return true;
                } else if ("samsung".equals(C1638Ka.m56193b())) {
                    C1684n.m55975c().m55985a(true);
                    C1509l.m56568h(accessibilityService);
                    return true;
                } else {
                    if ("oppo".equals(C1638Ka.m56193b()) || "realme".equals(C1638Ka.m56193b())) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            C1684n.m55975c().m55985a(true);
                            C1517t.m56540d(accessibilityService);
                        }
                    } else if (m55880b()) {
                        C1684n.m55975c().m55985a(true);
                        C1505h.m56607d(accessibilityService);
                    }
                    return true;
                }
            }
            return true;
        } else if (str.equals("com.android.settings.SubSettings")) {
            if (C1661ba.m56097a().m56096a("battery_white")) {
                C1617A.m56331b().m56320c(accessibilityService);
                C1661ba.m56097a().m56092a("battery_white", false);
                if (("redmi".equals(C1638Ka.m56193b()) || C4229c.f16088d.equals(C1638Ka.m56193b())) && Build.VERSION.SDK_INT >= 30) {
                    C1509l.m56574d(accessibilityService);
                } else if ("oneplus".equals(C1638Ka.m56193b()) || "oppo".equals(C1638Ka.m56193b()) || "realme".equals(C1638Ka.m56193b())) {
                    C1517t.m56542c(accessibilityService);
                }
                return true;
            }
            return true;
        } else if (str.equals("com.android.settings.Settings$AppDrawOverlaySettingsActivity")) {
            String str2 = f3391b;
            C1694ra.m55917a(str2, "current phone is " + C1638Ka.m56193b());
            if (C1661ba.m56097a().m56096a("battery_white")) {
                C1617A.m56331b().m56320c(accessibilityService);
                C1661ba.m56097a().m56092a("battery_white", false);
                if (m55880b()) {
                    C1684n.m55975c().m56005a(200L);
                    C1505h.m56624a(accessibilityService, System.currentTimeMillis(), false);
                } else if ("vivo".equals(C1638Ka.m56193b())) {
                    C1497F.m56632c(accessibilityService);
                } else if ("redmi".equals(C1638Ka.m56193b()) || C4229c.f16088d.equals(C1638Ka.m56193b()) || "blackshark".equals(C1638Ka.m56193b())) {
                    C1509l.m56574d(accessibilityService);
                } else if ("oneplus".equals(C1638Ka.m56193b())) {
                    C1517t.m56542c(accessibilityService);
                }
                return true;
            }
            return true;
        } else if ("com.android.settings.applications.InstalledAppDetailsTop".equals(str)) {
            if (C1661ba.m56097a().m56096a("battery_white")) {
                C1617A.m56331b().m56320c(accessibilityService);
                C1661ba.m56097a().m56092a("battery_white", false);
                if ("oppo".equals(C1638Ka.m56193b()) || "realme".equals(C1638Ka.m56193b()) || "oneplus".equals(C1638Ka.m56193b())) {
                    if (C1661ba.m56097a().m56096a("location_permission")) {
                        C1661ba.m56097a().m56092a("location_permission", false);
                        C1684n.m55975c().m56005a(300L);
                        C1490f.m56661f(accessibilityService);
                    } else {
                        C1523z.m56531b(accessibilityService);
                    }
                }
                return true;
            }
            return true;
        } else {
            if ("com.coloros.powermanager.fuelgaue.PowerControlActivity".equals(str) || "com.oplus.powermanager.fuelgaue.PowerControlActivity".equals(str)) {
                if (!C1661ba.m56097a().m56096a("battery_white")) {
                    return true;
                }
                C1617A.m56331b().m56320c(accessibilityService);
                C1661ba.m56097a().m56092a("battery_white", false);
                C1523z.m56537a(accessibilityService, System.currentTimeMillis());
            } else if ("com.android.settings.Settings$AppAndNotificationDashboardActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    if (m55880b()) {
                        if (C1661ba.m56097a().m56096a("location_permission")) {
                            C1661ba.m56097a().m56092a("location_permission", false);
                            C1490f.m56665c(accessibilityService);
                        } else {
                            C1505h.m56610c(accessibilityService);
                        }
                    }
                    return true;
                }
                return true;
            } else if ("com.oplusos.securitypermission.permission.ui.handheld.PermissionAppsActivityNew".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    if (("realme".equals(C1638Ka.m56193b()) || "oppo".equals(C1638Ka.m56193b()) || "oneplus".equals(C1638Ka.m56193b())) && !C1684n.m55975c().m55961f()) {
                        C1523z.m56528d(accessibilityService);
                        return true;
                    }
                    return true;
                }
                return true;
            } else if ("com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity".equals(str) || "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity".equals(str) || "com.hihonor.systemmanager.appcontrol.activity.StartupAppControlActivity".equals(str)) {
                C1694ra.m55917a("acse_HuaweiUtils", "find");
                if (!C1661ba.m56097a().m56096a("battery_white")) {
                    C1694ra.m55917a("acse_HuaweiUtils", "battery_white is false");
                    return true;
                }
                C1694ra.m55917a("acse_HuaweiUtils", "battery_white is true =SystemUtil.getDeviceBrand()=" + C1638Ka.m56193b());
                C1617A.m56331b().m56320c(accessibilityService);
                C1661ba.m56097a().m56092a("battery_white", false);
                if (m55880b()) {
                    C1694ra.m55917a("acse_HuaweiUtils", "ok");
                    C1505h.m56613b(accessibilityService, true);
                }
                return true;
            } else if ("com.miui.permcenter.permissions.PermissionsEditorActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    if (C1661ba.m56097a().m56096a("location_permission")) {
                        C1661ba.m56097a().m56092a("location_permission", false);
                        C1490f.m56662e(accessibilityService);
                    } else {
                        C1509l.m56577c(accessibilityService);
                    }
                    return true;
                }
                return true;
            } else if ("com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    if (("oppo".equals(C1638Ka.m56193b()) || "realme".equals(C1638Ka.m56193b())) && !C1684n.m55975c().m55961f()) {
                        C1523z.m56526f(accessibilityService);
                        return true;
                    }
                    return true;
                }
                return true;
            } else if ("com.coloros.floatwindow.sysfloatwindow.FloatWindowListActivity".equals(str) || "com.oplusos.floatwindow.sysfloatwindow.FloatWindowListActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    if (("realme".equals(C1638Ka.m56193b()) || "oppo".equals(C1638Ka.m56193b()) || "oneplus".equals(C1638Ka.m56193b())) && !C1684n.m55975c().m55961f()) {
                        C1523z.m56527e(accessibilityService);
                        return true;
                    }
                    return true;
                }
                return true;
            } else if ("com.vivo.permissionmanager.activity.FloatWindowManagerActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    C1497F.m56640a(accessibilityService, false);
                    return true;
                }
                return true;
            } else if ("com.vivo.permissionmanager.activity.BgStartUpManagerActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    C1497F.m56640a(accessibilityService, true);
                    return true;
                }
                return true;
            } else if ("com.iqoo.powersaving.PowerSavingManagerActivity".equals(str) || "com.iqoo.powersaving.fuelgauge.PowerRankActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    C1497F.m56631d(accessibilityService);
                    return true;
                }
                return true;
            } else if ("com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1694ra.m55917a(f3391b, "clickServiceBackgroundHight init");
                    C1661ba.m56097a().m56092a("battery_white", false);
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1684n.m55975c().m56005a(1000L);
                    C1497F.m56641a(accessibilityService, System.currentTimeMillis());
                    return true;
                }
                return true;
            } else if ("com.vivo.permissionmanager.activity.SoftPermissionDetailActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    if (C1661ba.m56097a().m56096a("location_permission")) {
                        C1661ba.m56097a().m56092a("location_permission", false);
                        C1684n.m55975c().m56005a(200L);
                        C1490f.m56663d(accessibilityService);
                    } else {
                        C1684n.m55975c().m56005a(100L);
                        C1497F.m56634b(accessibilityService);
                    }
                    return true;
                }
                return true;
            } else if ("com.miui.appmanager.ApplicationsDetailsActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    C1509l.m56578b("自启动", accessibilityService);
                    return true;
                }
                return true;
            } else if ("com.huawei.securitycenter.permission.ui.activity.MainActivity".equals(str) || "com.huawei.security.permission.ui.activity.MainActivity".equals(str) || "com.hihonor.securitycenter.permission.ui.activity.MainActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    if (C1661ba.m56097a().m56096a("location_permission")) {
                        C1684n.m55975c().m56005a(100L);
                        C1661ba.m56097a().m56092a("location_permission", false);
                        C1490f.m56674a(accessibilityService, true);
                    } else {
                        C1505h.m56609c(accessibilityService, true);
                    }
                    return true;
                }
                return true;
            } else if ("com.huawei.securitycenter.permission.ui.activity.PermissionSettingActivity".equals(str) || "com.huawei.security.permission.ui.activity.PermissionSettingActivity".equals(str) || "com.hihonor.securitycenter.permission.ui.activity.PermissionSettingActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    if (C1661ba.m56097a().m56096a("location_permission")) {
                        C1661ba.m56097a().m56092a("location_permission", false);
                        C1490f.m56674a(accessibilityService, false);
                    } else {
                        C1505h.m56609c(accessibilityService, false);
                    }
                    return true;
                }
                return true;
            } else if ("com.miui.permcenter.autostart.AutoStartDetailManagementActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    C1509l.m56569g(accessibilityService);
                    return true;
                }
                return true;
            } else if ("com.miui.permcenter.settings.OtherPermissionsActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    C1509l.m56577c(accessibilityService);
                    return true;
                }
                return true;
            } else if ("com.oplusos.securitypermission.permission.PermissionGroupsActivity".equals(str) || "com.coloros.securitypermission.permission.PermissionGroupsActivity".equals(str) || "com.android.permissioncontroller.permission.ui.ManagePermissionsActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1694ra.m55917a(f3391b, "oppo location");
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    if ("realme".equals(C1638Ka.m56193b()) || "oppo".equals(C1638Ka.m56193b()) || "oneplus".equals(C1638Ka.m56193b())) {
                        C1490f.m56659h(accessibilityService);
                    } else if ("huawei".equals(C1638Ka.m56193b()) || "honor".equals(C1638Ka.m56193b())) {
                        C1684n.m55975c().m56005a(200L);
                        C1490f.m56670b(accessibilityService);
                    }
                    return true;
                }
                return true;
            } else if ("com.android.packageinstaller.permission.ui.AppPermissionActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    C1490f.m56660g(accessibilityService);
                    return true;
                }
                return true;
            } else if ("com.miui.permcenter.permissions.PermissionAppsModifyActivity".equals(str)) {
                if (C1661ba.m56097a().m56096a("battery_white")) {
                    C1617A.m56331b().m56320c(accessibilityService);
                    C1661ba.m56097a().m56092a("battery_white", false);
                    C1490f.m56676a(accessibilityService, System.currentTimeMillis());
                    return true;
                }
                return true;
            }
            return false;
        }
    }

    /* renamed from: b */
    public boolean m55880b() {
        return "huawei".equals(C1638Ka.m56193b()) || "honor".equals(C1638Ka.m56193b()) || "tdtech".equals(C1638Ka.m56193b()) || "tyh612m".equals(C1638Ka.m56177p());
    }

    /* renamed from: c */
    public boolean m55879c() {
        return "huawei".equals(C1638Ka.m56193b()) || "honor".equals(C1638Ka.m56193b()) || "oppo".equals(C1638Ka.m56193b()) || "vivo".equals(C1638Ka.m56193b()) || C4229c.f16088d.equals(C1638Ka.m56193b()) || "redmi".equals(C1638Ka.m56193b()) || "realme".equals(C1638Ka.m56193b()) || "oneplus".equals(C1638Ka.m56193b()) || "blackshark".equals(C1638Ka.m56193b()) || "samsung".equals(C1638Ka.m56193b());
    }

    /* renamed from: d */
    public boolean m55878d() {
        return m55877e() || m55879c();
    }

    /* renamed from: e */
    public boolean m55877e() {
        return "tyh612m".equals(C1638Ka.m56177p());
    }
}
