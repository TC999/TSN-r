package com.devlin_n.floatWindowPermission;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;

/* renamed from: com.devlin_n.floatWindowPermission.f */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class QikuUtils {

    /* renamed from: a */
    private static final String f23188a = "QikuUtils";

    /* renamed from: a */
    public static void m35793a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
        if (m35790d(intent, context)) {
            context.startActivity(intent);
            return;
        }
        intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
        if (m35790d(intent, context)) {
            WindowUtil.m35782a(context).startActivityForResult(intent, 1);
        } else {
            Log.e(f23188a, "can't open permission page with particular name, please use \"adb shell dumpsys activity\" command and tell me the name of the float window permission page");
        }
    }

    /* renamed from: b */
    public static boolean m35792b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m35791c(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: c */
    private static boolean m35791c(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e) {
                Log.e(f23188a, Log.getStackTraceString(e));
            }
        } else {
            Log.e("", "Below API 19 cannot invoke!");
        }
        return false;
    }

    /* renamed from: d */
    private static boolean m35790d(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
