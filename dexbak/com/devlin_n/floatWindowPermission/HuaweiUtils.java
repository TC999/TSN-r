package com.devlin_n.floatWindowPermission;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.widget.Toast;

/* renamed from: com.devlin_n.floatWindowPermission.c */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class HuaweiUtils {

    /* renamed from: a */
    private static final String f23185a = "HuaweiUtils";

    /* renamed from: a */
    public static void m35808a(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            if (C6595g.m35785e() == 3.1d) {
                WindowUtil.m35782a(context).startActivityForResult(intent, 1);
            } else {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                WindowUtil.m35782a(context).startActivityForResult(intent, 1);
            }
        } catch (ActivityNotFoundException e) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            WindowUtil.m35782a(context).startActivityForResult(intent2, 1);
            e.printStackTrace();
            Log.e(f23185a, Log.getStackTraceString(e));
        } catch (SecurityException e2) {
            Intent intent3 = new Intent();
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            WindowUtil.m35782a(context).startActivityForResult(intent3, 1);
            Log.e(f23185a, Log.getStackTraceString(e2));
        } catch (Exception e3) {
            Toast.makeText(context, "进入设置页面失败，请手动设置", 1).show();
            Log.e(f23185a, Log.getStackTraceString(e3));
        }
    }

    /* renamed from: b */
    public static boolean m35807b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m35806c(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: c */
    private static boolean m35806c(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e) {
                Log.e(f23185a, Log.getStackTraceString(e));
            }
        } else {
            Log.e(f23185a, "Below API 19 cannot invoke!");
        }
        return false;
    }
}
