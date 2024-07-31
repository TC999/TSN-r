package com.acse.ottn.p042d.p044b;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;

/* renamed from: com.acse.ottn.d.b.A */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1492A {

    /* renamed from: a */
    private static final String f2740a = "QikuUtils";

    /* renamed from: a */
    public static void m56655a(Activity activity, int i) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
        intent.setFlags(268435456);
        if (!m56652a(intent, activity)) {
            intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
            if (!m56652a(intent, activity)) {
                C1694ra.m55915b(f2740a, "can't open permission page with particular name, please use \"adb shell dumpsys activity\" command and tell me the name of the float window permission page");
                return;
            }
        }
        activity.startActivityForResult(intent, i);
    }

    /* renamed from: a */
    public static boolean m56654a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m56653a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: a */
    private static boolean m56653a(Context context, int i) {
        int i2 = Build.VERSION.SDK_INT;
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return false;
        }
        if (i2 >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), CommonUtil.PACKAGE_NAME)).intValue() == 0;
            } catch (Exception e) {
                C1694ra.m55915b(f2740a, Log.getStackTraceString(e));
            }
        } else {
            C1694ra.m55915b("", "Below API 19 cannot invoke!");
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m56652a(Intent intent, Context context) {
        return (intent == null || context == null || context.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }
}
