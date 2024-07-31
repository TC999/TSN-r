package com.acse.ottn.util;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import androidx.core.app.ActivityCompat;
import androidx.core.view.PointerIconCompat;
import com.bxkj.student.C4229c;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.kuaishou.weapon.p205p0.C7282g;
import com.tencent.connect.common.Constants;
import java.io.ObjectStreamException;

/* renamed from: com.acse.ottn.util.qa */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1692qa {

    /* renamed from: a */
    private static C1692qa f3356a = null;

    /* renamed from: b */
    private static String f3357b = "acse_LocationRequsesPermissionUtil";

    private C1692qa() {
    }

    /* renamed from: a */
    public static C1692qa m55930a() {
        if (f3356a == null) {
            synchronized (C1692qa.class) {
                if (f3356a == null) {
                    f3356a = new C1692qa();
                }
            }
        }
        return f3356a;
    }

    /* renamed from: b */
    private Object m55927b() throws ObjectStreamException {
        return f3356a;
    }

    /* renamed from: d */
    public static void m55922d(Activity activity) {
        ComponentName unflattenFromString;
        C1661ba.m56097a().m56088b("OpenPermissionName", "权限管理");
        C1661ba.m56097a().m56092a("battery_white", true);
        C1661ba.m56097a().m56092a("location_permission", true);
        int i = Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        String str = "com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity";
        try {
            if (i < 28) {
                if (i >= 26) {
                    str = "com.huawei.systemmanager/.appcontrol.activity.StartupAppControlActivity";
                } else if (i < 23) {
                    if (i < 21) {
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

    /* renamed from: f */
    private void m55920f(Activity activity) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        Intent intent = new Intent();
        C1661ba.m56097a().m56092a("location_permission", true);
        C1661ba.m56097a().m56092a("battery_white", true);
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra(TTDownloadField.TT_PACKAGE_NAME, CommonUtil.PACKAGE_NAME);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivityForResult(intent, 10010);
            } catch (Exception unused) {
                intent.setFlags(268435456);
                intent.putExtra(Constants.PARAM_PKG_NAME, CommonUtil.PACKAGE_NAME);
                intent.putExtra("app_name", C1663ca.m56080c().m56081b());
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

    /* renamed from: g */
    private void m55919g(Activity activity) {
        C1661ba.m56097a().m56092a("battery_white", true);
        C1661ba.m56097a().m56088b("location_permission_state", "2");
        try {
            C1661ba.m56097a().m56092a("location_permission", true);
            Intent intent = new Intent();
            intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
            intent.putExtra("packagename", CommonUtil.PACKAGE_NAME);
            intent.putExtra("tabId", "1");
            activity.startActivityForResult(intent, 10010);
        } catch (Exception unused) {
            C1661ba.m56097a().m56092a("location_permission", false);
        }
    }

    /* renamed from: h */
    private void m55918h(Activity activity) {
        C1661ba.m56097a().m56092a("battery_white", true);
        C1661ba.m56097a().m56088b("location_permission_state", "2");
        C1661ba.m56097a().m56092a("location_permission", true);
        try {
            if (C1638Ka.m56193b().equals(C4229c.f16088d) || C1638Ka.m56193b().equals("redmi") || C1638Ka.m56193b().equals("blackshark")) {
                C1661ba.m56097a().m56088b("OpenPermissionName", "定位");
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
            C1661ba.m56097a().m56092a("battery_white", true);
            activity.startActivityForResult(intent2, 10010);
        }
    }

    /* renamed from: a */
    public void m55929a(Activity activity) {
        if (Build.VERSION.SDK_INT < 23 || activity.checkSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            return;
        }
        C1661ba.m56097a().m56092a("battery_white", true);
        C1661ba.m56097a().m56088b("location_permission_state", "2");
        ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 10019);
    }

    /* renamed from: a */
    public boolean m55928a(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            return context.checkSelfPermission(C7282g.f24950h) == 0 && context.checkSelfPermission(C7282g.f24949g) == 0;
        }
        return true;
    }

    /* renamed from: b */
    public void m55926b(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            C1661ba.m56097a().m56092a("battery_white", true);
            C1661ba.m56097a().m56088b("location_permission_state", "2");
            ActivityCompat.requestPermissions(activity, new String[]{"android.permission.ACCESS_BACKGROUND_LOCATION"}, 1000);
        }
    }

    /* renamed from: b */
    public boolean m55925b(Context context) {
        return Build.VERSION.SDK_INT < 23 || context.checkSelfPermission("android.permission.ACCESS_BACKGROUND_LOCATION") == 0;
    }

    /* renamed from: c */
    public void m55924c(Activity activity) {
        if (Build.VERSION.SDK_INT >= 23) {
            C1661ba.m56097a().m56092a("battery_white", true);
            C1661ba.m56097a().m56088b("location_permission_state", "1");
            ActivityCompat.requestPermissions(activity, new String[]{C7282g.f24949g, C7282g.f24950h}, PointerIconCompat.TYPE_ZOOM_IN);
        }
    }

    /* renamed from: c */
    public void m55923c(Context context) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (context.checkSelfPermission(C7282g.f24950h) == 0 && context.checkSelfPermission(C7282g.f24949g) == 0) {
                return;
            }
            ActivityCompat.requestPermissions((Activity) context, new String[]{C7282g.f24949g, C7282g.f24950h}, 1000);
        }
    }

    /* renamed from: e */
    public void m55921e(Activity activity) {
        String m56193b = C1638Ka.m56193b();
        if (C1663ca.m56080c().m56078e()) {
            m55922d(activity);
        } else if ("vivo".equals(m56193b)) {
            m55919g(activity);
        } else {
            if (!"oppo".equals(m56193b) && !"realme".equals(m56193b)) {
                if (C4229c.f16088d.equals(m56193b) || "redmi".equals(m56193b) || "blackshark".equals(m56193b)) {
                    m55918h(activity);
                    return;
                } else if (!"oneplus".equals(m56193b)) {
                    int m56090b = C1661ba.m56097a().m56090b("location_permission_size");
                    if (m56090b == 1) {
                        C1661ba.m56097a().m56089b("location_permission_size", 2);
                        m55930a().m55924c(activity);
                    } else if (m56090b == 2) {
                        C1661ba.m56097a().m56089b("location_permission_size", 3);
                    }
                    m55930a().m55926b(activity);
                    return;
                }
            }
            m55920f(activity);
        }
    }
}
