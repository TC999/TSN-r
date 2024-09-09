package com.acse.ottn.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class qa {

    /* renamed from: a  reason: collision with root package name */
    private static qa f6866a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6867b = "acse_LocationRequsesPermissionUtil";

    private qa() {
    }

    public static qa a() {
        if (f6866a == null) {
            synchronized (qa.class) {
                if (f6866a == null) {
                    f6866a = new qa();
                }
            }
        }
        return f6866a;
    }

    private Object b() throws ObjectStreamException {
        return f6866a;
    }

    public static void d(Activity activity) {
        ComponentName unflattenFromString;
        C1419ba.a().b("OpenPermissionName", "\u6743\u9650\u7ba1\u7406");
        C1419ba.a().a("battery_white", true);
        C1419ba.a().a("location_permission", true);
        int i4 = Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        String str = "com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity";
        try {
            if (i4 < 28) {
                if (i4 >= 26) {
                    str = "com.huawei.systemmanager/.appcontrol.activity.StartupAppControlActivity";
                } else if (i4 < 23) {
                    if (i4 < 21) {
                        unflattenFromString = null;
                        intent.setComponent(unflattenFromString);
                        activity.startActivity(intent);
                    }
                    str = "com.huawei.systemmanager/com.huawei.permissionmanager.ui.MainActivity";
                }
            }
            unflattenFromString = ComponentName.unflattenFromString(str);
            intent.setComponent(unflattenFromString);
            activity.startActivity(intent);
        } catch (Exception unused) {
            try {
                intent.setComponent(ComponentName.unflattenFromString("com.android.settings/.Settings$AppAndNotificationDashboardActivity"));
                activity.startActivityForResult(intent, 10010);
            } catch (Exception unused2) {
            }
        }
    }

    private void f(Activity activity) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        Intent intent = new Intent();
        C1419ba.a().a("location_permission", true);
        C1419ba.a().a("battery_white", true);
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra("packageName", CommonUtil.PACKAGE_NAME);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivityForResult(intent, 10010);
            } catch (Exception unused) {
                intent.setFlags(268435456);
                intent.putExtra("pkg_name", CommonUtil.PACKAGE_NAME);
                intent.putExtra("app_name", C1421ca.c().b());
                intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
                intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
                activity.startActivityForResult(intent, 10010);
            }
        } catch (Exception unused2) {
            Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts("package", CommonUtil.PACKAGE_NAME, null));
            activity.startActivityForResult(intent2, 10010);
        }
    }

    private void g(Activity activity) {
        C1419ba.a().a("battery_white", true);
        C1419ba.a().b("location_permission_state", "2");
        try {
            C1419ba.a().a("location_permission", true);
            Intent intent = new Intent();
            intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent.putExtra("packagename", CommonUtil.PACKAGE_NAME);
            intent.putExtra("tabId", "1");
            activity.startActivityForResult(intent, 10010);
        } catch (Exception unused) {
            C1419ba.a().a("location_permission", false);
        }
    }

    private void h(Activity activity) {
        C1419ba.a().a("battery_white", true);
        C1419ba.a().b("location_permission_state", "2");
        C1419ba.a().a("location_permission", true);
        try {
            if (Ka.b().equals("xiaomi") || Ka.b().equals("redmi") || Ka.b().equals("blackshark")) {
                C1419ba.a().b("OpenPermissionName", "\u5b9a\u4f4d");
                Intent intent = new Intent();
                ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
                intent.putExtra("extra_pkgname", activity.getPackageName());
                intent.setComponent(componentName);
                intent.addFlags(268435456);
                activity.startActivityForResult(intent, 10010);
            }
        } catch (Exception unused) {
            Intent intent2 = new Intent("android.settings.action.MANAGE_OVERLAY_PERMISSION");
            intent2.setData(Uri.parse("package:" + activity.getPackageName()));
            C1419ba.a().a("battery_white", true);
            activity.startActivityForResult(intent2, 10010);
        }
    }

    public void a(Activity activity) {
        if (Build.VERSION.SDK_INT < 23 || activity.checkSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            return;
        }
        C1419ba.a().a("battery_white", true);
        C1419ba.a().b("location_permission_state", "2");
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 10019);
    }

    public boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
        }
        return true;
    }

    public void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            C1419ba.a().a("battery_white", true);
            C1419ba.a().b("location_permission_state", "2");
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 1000);
        }
    }

    public boolean b(Context context) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") == 0;
    }

    public void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            C1419ba.a().a("battery_white", true);
            C1419ba.a().b("location_permission_state", "1");
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1018);
        }
    }

    public void c(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
                return;
            }
            ActivityCompat.requestPermissions((Activity) context, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1000);
        }
    }

    public void e(Activity activity) {
        String b4 = Ka.b();
        if (C1421ca.c().e()) {
            d(activity);
        } else if ("vivo".equals(b4)) {
            g(activity);
        } else {
            if (!"oppo".equals(b4) && !"realme".equals(b4)) {
                if ("xiaomi".equals(b4) || "redmi".equals(b4) || "blackshark".equals(b4)) {
                    h(activity);
                    return;
                } else if (!"oneplus".equals(b4)) {
                    int b5 = C1419ba.a().b("location_permission_size");
                    if (b5 == 1) {
                        C1419ba.a().b("location_permission_size", 2);
                        a().c(activity);
                    } else if (b5 == 2) {
                        C1419ba.a().b("location_permission_size", 3);
                    }
                    a().b(activity);
                    return;
                }
            }
            f(activity);
        }
    }
}
