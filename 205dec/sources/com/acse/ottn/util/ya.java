package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.app.Service;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.acse.ottn.l1;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class ya {

    /* renamed from: a  reason: collision with root package name */
    private static ya f6900a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6901b = "OpenMobilePermissionUtil";

    private ya() {
    }

    public static ya a() {
        if (f6900a == null) {
            synchronized (ya.class) {
                if (f6900a == null) {
                    f6900a = new ya();
                }
            }
        }
        return f6900a;
    }

    private void a(Service service) {
        new Handler(Looper.getMainLooper()).post(new xa(this));
    }

    private Object f() throws ObjectStreamException {
        return f6900a;
    }

    public boolean a(AccessibilityService accessibilityService, String str) {
        if (C1419ba.a() == null) {
            return false;
        }
        if (str.equals("com.android.settings.Settings$OverlaySettingsActivity")) {
            if (C1419ba.a().a("battery_white")) {
                A.b().c(accessibilityService);
                C1419ba.a().a("battery_white", false);
                if ("redmi".equals(Ka.b()) || "xiaomi".equals(Ka.b()) || "blackshark".equals(Ka.b())) {
                    C1442n.c().a(true);
                    com.acse.ottn.d.b.l.h(accessibilityService);
                    return true;
                } else if ("oneplus".equals(Ka.b())) {
                    C1442n.c().a(true);
                    com.acse.ottn.d.b.t.d(accessibilityService);
                    return true;
                } else if ("samsung".equals(Ka.b())) {
                    C1442n.c().a(true);
                    com.acse.ottn.d.b.l.h(accessibilityService);
                    return true;
                } else {
                    if ("oppo".equals(Ka.b()) || "realme".equals(Ka.b())) {
                        if (Build.VERSION.SDK_INT >= 33) {
                            C1442n.c().a(true);
                            com.acse.ottn.d.b.t.d(accessibilityService);
                        }
                    } else if (b()) {
                        C1442n.c().a(true);
                        com.acse.ottn.d.b.h.d(accessibilityService);
                    }
                    return true;
                }
            }
            return true;
        } else if (str.equals("com.android.settings.SubSettings")) {
            if (C1419ba.a().a("battery_white")) {
                A.b().c(accessibilityService);
                C1419ba.a().a("battery_white", false);
                if (("redmi".equals(Ka.b()) || "xiaomi".equals(Ka.b())) && Build.VERSION.SDK_INT >= 30) {
                    com.acse.ottn.d.b.l.d(accessibilityService);
                } else if ("oneplus".equals(Ka.b()) || "oppo".equals(Ka.b()) || "realme".equals(Ka.b())) {
                    com.acse.ottn.d.b.t.c(accessibilityService);
                }
                return true;
            }
            return true;
        } else if (str.equals("com.android.settings.Settings$AppDrawOverlaySettingsActivity")) {
            String str2 = f6901b;
            ra.a(str2, "current phone is " + Ka.b());
            if (C1419ba.a().a("battery_white")) {
                A.b().c(accessibilityService);
                C1419ba.a().a("battery_white", false);
                if (b()) {
                    C1442n.c().a(200L);
                    com.acse.ottn.d.b.h.a(accessibilityService, System.currentTimeMillis(), false);
                } else if ("vivo".equals(Ka.b())) {
                    com.acse.ottn.d.b.F.c(accessibilityService);
                } else if ("redmi".equals(Ka.b()) || "xiaomi".equals(Ka.b()) || "blackshark".equals(Ka.b())) {
                    com.acse.ottn.d.b.l.d(accessibilityService);
                } else if ("oneplus".equals(Ka.b())) {
                    com.acse.ottn.d.b.t.c(accessibilityService);
                }
                return true;
            }
            return true;
        } else if ("com.android.settings.applications.InstalledAppDetailsTop".equals(str)) {
            if (C1419ba.a().a("battery_white")) {
                A.b().c(accessibilityService);
                C1419ba.a().a("battery_white", false);
                if ("oppo".equals(Ka.b()) || "realme".equals(Ka.b()) || "oneplus".equals(Ka.b())) {
                    if (C1419ba.a().a("location_permission")) {
                        C1419ba.a().a("location_permission", false);
                        C1442n.c().a(300L);
                        com.acse.ottn.d.a.f.f(accessibilityService);
                    } else {
                        com.acse.ottn.d.b.z.b(accessibilityService);
                    }
                }
                return true;
            }
            return true;
        } else {
            if ("com.coloros.powermanager.fuelgaue.PowerControlActivity".equals(str) || "com.oplus.powermanager.fuelgaue.PowerControlActivity".equals(str)) {
                if (!C1419ba.a().a("battery_white")) {
                    return true;
                }
                A.b().c(accessibilityService);
                C1419ba.a().a("battery_white", false);
                com.acse.ottn.d.b.z.a(accessibilityService, System.currentTimeMillis());
            } else if ("com.android.settings.Settings$AppAndNotificationDashboardActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    if (b()) {
                        if (C1419ba.a().a("location_permission")) {
                            C1419ba.a().a("location_permission", false);
                            com.acse.ottn.d.a.f.c(accessibilityService);
                        } else {
                            com.acse.ottn.d.b.h.c(accessibilityService);
                        }
                    }
                    return true;
                }
                return true;
            } else if ("com.oplusos.securitypermission.permission.ui.handheld.PermissionAppsActivityNew".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    if (("realme".equals(Ka.b()) || "oppo".equals(Ka.b()) || "oneplus".equals(Ka.b())) && !C1442n.c().f()) {
                        com.acse.ottn.d.b.z.d(accessibilityService);
                        return true;
                    }
                    return true;
                }
                return true;
            } else if ("com.huawei.systemmanager.startupmgr.ui.StartupNormalAppListActivity".equals(str) || "com.huawei.systemmanager.appcontrol.activity.StartupAppControlActivity".equals(str) || "com.hihonor.systemmanager.appcontrol.activity.StartupAppControlActivity".equals(str)) {
                ra.a(l1.f5876a, "find");
                if (!C1419ba.a().a("battery_white")) {
                    ra.a(l1.f5876a, "battery_white is false");
                    return true;
                }
                ra.a(l1.f5876a, "battery_white is true =SystemUtil.getDeviceBrand()=" + Ka.b());
                A.b().c(accessibilityService);
                C1419ba.a().a("battery_white", false);
                if (b()) {
                    ra.a(l1.f5876a, "ok");
                    com.acse.ottn.d.b.h.b(accessibilityService, true);
                }
                return true;
            } else if ("com.miui.permcenter.permissions.PermissionsEditorActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    if (C1419ba.a().a("location_permission")) {
                        C1419ba.a().a("location_permission", false);
                        com.acse.ottn.d.a.f.e(accessibilityService);
                    } else {
                        com.acse.ottn.d.b.l.c(accessibilityService);
                    }
                    return true;
                }
                return true;
            } else if ("com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    if (("oppo".equals(Ka.b()) || "realme".equals(Ka.b())) && !C1442n.c().f()) {
                        com.acse.ottn.d.b.z.f(accessibilityService);
                        return true;
                    }
                    return true;
                }
                return true;
            } else if ("com.coloros.floatwindow.sysfloatwindow.FloatWindowListActivity".equals(str) || "com.oplusos.floatwindow.sysfloatwindow.FloatWindowListActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    if (("realme".equals(Ka.b()) || "oppo".equals(Ka.b()) || "oneplus".equals(Ka.b())) && !C1442n.c().f()) {
                        com.acse.ottn.d.b.z.e(accessibilityService);
                        return true;
                    }
                    return true;
                }
                return true;
            } else if ("com.vivo.permissionmanager.activity.FloatWindowManagerActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    com.acse.ottn.d.b.F.a(accessibilityService, false);
                    return true;
                }
                return true;
            } else if ("com.vivo.permissionmanager.activity.BgStartUpManagerActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    com.acse.ottn.d.b.F.a(accessibilityService, true);
                    return true;
                }
                return true;
            } else if ("com.iqoo.powersaving.PowerSavingManagerActivity".equals(str) || "com.iqoo.powersaving.fuelgauge.PowerRankActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    com.acse.ottn.d.b.F.d(accessibilityService);
                    return true;
                }
                return true;
            } else if ("com.vivo.applicationbehaviorengine.ui.ExcessivePowerManagerActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    ra.a(f6901b, "clickServiceBackgroundHight init");
                    C1419ba.a().a("battery_white", false);
                    A.b().c(accessibilityService);
                    C1442n.c().a(1000L);
                    com.acse.ottn.d.b.F.a(accessibilityService, System.currentTimeMillis());
                    return true;
                }
                return true;
            } else if ("com.vivo.permissionmanager.activity.SoftPermissionDetailActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    if (C1419ba.a().a("location_permission")) {
                        C1419ba.a().a("location_permission", false);
                        C1442n.c().a(200L);
                        com.acse.ottn.d.a.f.d(accessibilityService);
                    } else {
                        C1442n.c().a(100L);
                        com.acse.ottn.d.b.F.b(accessibilityService);
                    }
                    return true;
                }
                return true;
            } else if ("com.miui.appmanager.ApplicationsDetailsActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    com.acse.ottn.d.b.l.b("\u81ea\u542f\u52a8", accessibilityService);
                    return true;
                }
                return true;
            } else if ("com.huawei.securitycenter.permission.ui.activity.MainActivity".equals(str) || "com.huawei.security.permission.ui.activity.MainActivity".equals(str) || "com.hihonor.securitycenter.permission.ui.activity.MainActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    if (C1419ba.a().a("location_permission")) {
                        C1442n.c().a(100L);
                        C1419ba.a().a("location_permission", false);
                        com.acse.ottn.d.a.f.a(accessibilityService, true);
                    } else {
                        com.acse.ottn.d.b.h.c(accessibilityService, true);
                    }
                    return true;
                }
                return true;
            } else if ("com.huawei.securitycenter.permission.ui.activity.PermissionSettingActivity".equals(str) || "com.huawei.security.permission.ui.activity.PermissionSettingActivity".equals(str) || "com.hihonor.securitycenter.permission.ui.activity.PermissionSettingActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    if (C1419ba.a().a("location_permission")) {
                        C1419ba.a().a("location_permission", false);
                        com.acse.ottn.d.a.f.a(accessibilityService, false);
                    } else {
                        com.acse.ottn.d.b.h.c(accessibilityService, false);
                    }
                    return true;
                }
                return true;
            } else if ("com.miui.permcenter.autostart.AutoStartDetailManagementActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    com.acse.ottn.d.b.l.g(accessibilityService);
                    return true;
                }
                return true;
            } else if ("com.miui.permcenter.settings.OtherPermissionsActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    com.acse.ottn.d.b.l.c(accessibilityService);
                    return true;
                }
                return true;
            } else if ("com.oplusos.securitypermission.permission.PermissionGroupsActivity".equals(str) || "com.coloros.securitypermission.permission.PermissionGroupsActivity".equals(str) || "com.android.permissioncontroller.permission.ui.ManagePermissionsActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    ra.a(f6901b, "oppo location");
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    if ("realme".equals(Ka.b()) || "oppo".equals(Ka.b()) || "oneplus".equals(Ka.b())) {
                        com.acse.ottn.d.a.f.h(accessibilityService);
                    } else if ("huawei".equals(Ka.b()) || "honor".equals(Ka.b())) {
                        C1442n.c().a(200L);
                        com.acse.ottn.d.a.f.b(accessibilityService);
                    }
                    return true;
                }
                return true;
            } else if ("com.android.packageinstaller.permission.ui.AppPermissionActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    com.acse.ottn.d.a.f.g(accessibilityService);
                    return true;
                }
                return true;
            } else if ("com.miui.permcenter.permissions.PermissionAppsModifyActivity".equals(str)) {
                if (C1419ba.a().a("battery_white")) {
                    A.b().c(accessibilityService);
                    C1419ba.a().a("battery_white", false);
                    com.acse.ottn.d.a.f.a(accessibilityService, System.currentTimeMillis());
                    return true;
                }
                return true;
            }
            return false;
        }
    }

    public boolean b() {
        return "huawei".equals(Ka.b()) || "honor".equals(Ka.b()) || "tdtech".equals(Ka.b()) || "tyh612m".equals(Ka.p());
    }

    public boolean c() {
        return "huawei".equals(Ka.b()) || "honor".equals(Ka.b()) || "oppo".equals(Ka.b()) || "vivo".equals(Ka.b()) || "xiaomi".equals(Ka.b()) || "redmi".equals(Ka.b()) || "realme".equals(Ka.b()) || "oneplus".equals(Ka.b()) || "blackshark".equals(Ka.b()) || "samsung".equals(Ka.b());
    }

    public boolean d() {
        return e() || c();
    }

    public boolean e() {
        return "tyh612m".equals(Ka.p());
    }
}
