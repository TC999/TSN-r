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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: HuaweiUtils.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36852a = "HuaweiUtils";

    public static void a(Context context) {
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            if (g.e() == 3.1d) {
                h.a(context).startActivityForResult(intent, 1);
            } else {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                h.a(context).startActivityForResult(intent, 1);
            }
        } catch (ActivityNotFoundException e4) {
            Intent intent2 = new Intent();
            intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            h.a(context).startActivityForResult(intent2, 1);
            e4.printStackTrace();
            Log.e("HuaweiUtils", Log.getStackTraceString(e4));
        } catch (SecurityException e5) {
            Intent intent3 = new Intent();
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            h.a(context).startActivityForResult(intent3, 1);
            Log.e("HuaweiUtils", Log.getStackTraceString(e5));
        } catch (Exception e6) {
            Toast.makeText(context, "\u8fdb\u5165\u8bbe\u7f6e\u9875\u9762\u5931\u8d25\uff0c\u8bf7\u624b\u52a8\u8bbe\u7f6e", 1).show();
            Log.e("HuaweiUtils", Log.getStackTraceString(e6));
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
                Log.e("HuaweiUtils", Log.getStackTraceString(e4));
            }
        } else {
            Log.e("HuaweiUtils", "Below API 19 cannot invoke!");
        }
        return false;
    }
}
