package com.acse.ottn.d.b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.ra;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class A {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5415a = "QikuUtils";

    public static void a(Activity activity, int i4) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
        intent.setFlags(268435456);
        if (!a(intent, activity)) {
            intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
            if (!a(intent, activity)) {
                ra.b("QikuUtils", "can't open permission page with particular name, please use \"adb shell dumpsys activity\" command and tell me the name of the float window permission page");
                return;
            }
        }
        activity.startActivityForResult(intent, i4);
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    private static boolean a(Context context, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return false;
        }
        if (i5 >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i4), Integer.valueOf(Binder.getCallingUid()), CommonUtil.PACKAGE_NAME)).intValue() == 0;
            } catch (Exception e4) {
                ra.b("QikuUtils", Log.getStackTraceString(e4));
            }
        } else {
            ra.b("", "Below API 19 cannot invoke!");
        }
        return false;
    }

    private static boolean a(Intent intent, Context context) {
        return (intent == null || context == null || context.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }
}
