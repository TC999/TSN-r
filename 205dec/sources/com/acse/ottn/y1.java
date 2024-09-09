package com.acse.ottn;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class y1 {

    /* renamed from: a  reason: collision with root package name */
    public static y1 f7003a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f7004b = "acse_LocationRequsesPermissionUtil";

    public static y1 a() {
        if (f7003a == null) {
            synchronized (y1.class) {
                if (f7003a == null) {
                    f7003a = new y1();
                }
            }
        }
        return f7003a;
    }

    public static void d(Activity activity) {
        ComponentName unflattenFromString;
        g1.a().b("OpenPermissionName", "\u6743\u9650\u7ba1\u7406");
        g1.a().a("battery_white", true);
        g1.a().a("location_permission", true);
        int i4 = Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        try {
            try {
                if (i4 >= 28) {
                    unflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity");
                } else if (i4 >= 26) {
                    unflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/.appcontrol.activity.StartupAppControlActivity");
                } else if (i4 >= 23) {
                    unflattenFromString = ComponentName.unflattenFromString("com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity");
                } else {
                    unflattenFromString = i4 >= 21 ? ComponentName.unflattenFromString("com.huawei.systemmanager/com.huawei.permissionmanager.ui.MainActivity") : null;
                }
                intent.setComponent(unflattenFromString);
                activity.startActivity(intent);
            } catch (Exception unused) {
            }
        } catch (Exception unused2) {
            intent.setComponent(ComponentName.unflattenFromString("com.android.settings/.Settings$AppAndNotificationDashboardActivity"));
            activity.startActivityForResult(intent, 10010);
        }
    }

    public final Object b() throws ObjectStreamException {
        return f7003a;
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
        String b4 = c4.b();
        if (h1.c().e()) {
            d(activity);
        } else if ("vivo".equals(b4)) {
            g(activity);
        } else if (!"oppo".equals(b4) && !"realme".equals(b4)) {
            if (!"xiaomi".equals(b4) && !"redmi".equals(b4) && !"blackshark".equals(b4)) {
                if ("oneplus".equals(b4)) {
                    f(activity);
                    return;
                }
                int b5 = g1.a().b("location_permission_size");
                if (b5 == 1) {
                    g1.a().b("location_permission_size", 2);
                    a().c(activity);
                } else if (b5 == 2) {
                    g1.a().b("location_permission_size", 3);
                }
                a().b(activity);
                return;
            }
            h(activity);
        } else {
            f(activity);
        }
    }

    public final void f(Activity activity) {
        if ("".equals(j0.f5781w)) {
            return;
        }
        Intent intent = new Intent();
        g1.a().a("location_permission", true);
        g1.a().a("battery_white", true);
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra("packageName", j0.f5781w);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivityForResult(intent, 10010);
            } catch (Exception unused) {
                intent.setFlags(268435456);
                intent.putExtra("pkg_name", j0.f5781w);
                intent.putExtra("app_name", h1.c().b());
                intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
                intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
                activity.startActivityForResult(intent, 10010);
            }
        } catch (Exception unused2) {
            Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts("package", j0.f5781w, null));
            activity.startActivityForResult(intent2, 10010);
        }
    }

    public final void g(Activity activity) {
        g1.a().a("battery_white", true);
        g1.a().b("location_permission_state", "2");
        try {
            g1.a().a("location_permission", true);
            Intent intent = new Intent();
            intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent.putExtra("packagename", j0.f5781w);
            intent.putExtra("tabId", "1");
            activity.startActivityForResult(intent, 10010);
        } catch (Exception unused) {
            g1.a().a("location_permission", false);
        }
    }

    public final void h(Activity activity) {
        g1.a().a("location_permission", true);
        g1.a().a("battery_white", true);
        g1.a().b("location_permission_state", "2");
        try {
            if (c4.b().equals("xiaomi") || c4.b().equals("redmi") || c4.b().equals("blackshark")) {
                g1.a().b("OpenPermissionName", "\u5b9a\u4f4d");
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
            g1.a().a("battery_white", true);
            activity.startActivityForResult(intent2, 10010);
        }
    }

    public boolean b(Context context) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") == 0;
    }

    public void b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            g1.a().a("battery_white", true);
            g1.a().b("location_permission_state", "2");
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 1000);
        }
    }

    public void c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            g1.a().a("battery_white", true);
            g1.a().b("location_permission_state", "1");
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 1018);
        }
    }

    public boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.checkSelfPermission("android.permission.ACCESS_COARSE_LOCATION") == 0 && context.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0;
        }
        return true;
    }

    public void a(Activity activity) {
        if (Build.VERSION.SDK_INT < 23 || activity.checkSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            return;
        }
        g1.a().a("battery_white", true);
        g1.a().b("location_permission_state", "2");
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 10019);
    }
}
