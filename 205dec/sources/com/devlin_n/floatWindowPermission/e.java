package com.devlin_n.floatWindowPermission;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: MiuiUtils.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36854a = "MiuiUtils";

    public static void a(Context context) {
        int d4 = d();
        if (d4 == 5) {
            e(context);
        } else if (d4 == 6) {
            f(context);
        } else if (d4 == 7) {
            g(context);
        } else if (d4 == 8) {
            h(context);
        } else {
            Log.e("MiuiUtils", "this is a special MIUI rom version, its version code " + d4);
        }
    }

    public static boolean b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return c(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    private static boolean c(Context context, int i4) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i4), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e4) {
                Log.e("MiuiUtils", Log.getStackTraceString(e4));
            }
        } else {
            Log.e("MiuiUtils", "Below API 19 cannot invoke!");
        }
        return false;
    }

    public static int d() {
        String g4 = g.g("ro.miui.ui.version.name");
        if (g4 != null) {
            try {
                return Integer.parseInt(g4.substring(1));
            } catch (Exception e4) {
                Log.e("MiuiUtils", "get miui version code error, version : " + g4);
                Log.e("MiuiUtils", Log.getStackTraceString(e4));
                return -1;
            }
        }
        return -1;
    }

    public static void e(Context context) {
        String packageName = context.getPackageName();
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", packageName, null));
        if (i(intent, context)) {
            h.a(context).startActivityForResult(intent, 1);
        } else {
            Log.e("MiuiUtils", "intent is not available!");
        }
    }

    public static void f(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (i(intent, context)) {
            h.a(context).startActivityForResult(intent, 1);
        } else {
            Log.e("MiuiUtils", "Intent is not available!");
        }
    }

    public static void g(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (i(intent, context)) {
            h.a(context).startActivityForResult(intent, 1);
        } else {
            Log.e("MiuiUtils", "Intent is not available!");
        }
    }

    public static void h(Context context) {
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", context.getPackageName());
        if (i(intent, context)) {
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent2.setPackage("com.miui.securitycenter");
        intent2.putExtra("extra_pkgname", context.getPackageName());
        if (i(intent2, context)) {
            h.a(context).startActivityForResult(intent2, 1);
        } else {
            Log.e("MiuiUtils", "Intent is not available!");
        }
    }

    private static boolean i(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
