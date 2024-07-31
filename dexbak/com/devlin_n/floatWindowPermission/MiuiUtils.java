package com.devlin_n.floatWindowPermission;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;

/* renamed from: com.devlin_n.floatWindowPermission.e */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MiuiUtils {

    /* renamed from: a */
    private static final String f23187a = "MiuiUtils";

    /* renamed from: a */
    public static void m35802a(Context context) {
        int m35799d = m35799d();
        if (m35799d == 5) {
            m35798e(context);
        } else if (m35799d == 6) {
            m35797f(context);
        } else if (m35799d == 7) {
            m35796g(context);
        } else if (m35799d == 8) {
            m35795h(context);
        } else {
            Log.e(f23187a, "this is a special MIUI rom version, its version code " + m35799d);
        }
    }

    /* renamed from: b */
    public static boolean m35801b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m35800c(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: c */
    private static boolean m35800c(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e) {
                Log.e(f23187a, Log.getStackTraceString(e));
            }
        } else {
            Log.e(f23187a, "Below API 19 cannot invoke!");
        }
        return false;
    }

    /* renamed from: d */
    public static int m35799d() {
        String m35783g = C6595g.m35783g("ro.miui.ui.version.name");
        if (m35783g != null) {
            try {
                return Integer.parseInt(m35783g.substring(1));
            } catch (Exception e) {
                Log.e(f23187a, "get miui version code error, version : " + m35783g);
                Log.e(f23187a, Log.getStackTraceString(e));
                return -1;
            }
        }
        return -1;
    }

    /* renamed from: e */
    public static void m35798e(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", packageName, null));
        if (m35794i(intent, context)) {
            WindowUtil.m35782a(context).startActivityForResult(intent, 1);
        } else {
            Log.e(f23187a, "intent is not available!");
        }
    }

    /* renamed from: f */
    public static void m35797f(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (m35794i(intent, context)) {
            WindowUtil.m35782a(context).startActivityForResult(intent, 1);
        } else {
            Log.e(f23187a, "Intent is not available!");
        }
    }

    /* renamed from: g */
    public static void m35796g(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (m35794i(intent, context)) {
            WindowUtil.m35782a(context).startActivityForResult(intent, 1);
        } else {
            Log.e(f23187a, "Intent is not available!");
        }
    }

    /* renamed from: h */
    public static void m35795h(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (m35794i(intent, context)) {
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setPackage("com.miui.securitycenter");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        if (m35794i(intent2, context)) {
            WindowUtil.m35782a(context).startActivityForResult(intent2, 1);
        } else {
            Log.e(f23187a, "Intent is not available!");
        }
    }

    /* renamed from: i */
    private static boolean m35794i(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
