package com.devlin_n.floatWindowPermission;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import com.acse.ottn.d3;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: QikuUtils.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36855a = "QikuUtils";

    public static void a(Context context) {
        Intent intent = new Intent();
        intent.setClassName("com.android.settings", "com.android.settings.Settings$OverlaySettingsActivity");
        if (d(intent, context)) {
            context.startActivity(intent);
            return;
        }
        intent.setClassName("com.qihoo360.mobilesafe", "com.qihoo360.mobilesafe.ui.index.AppEnterActivity");
        if (d(intent, context)) {
            h.a(context).startActivityForResult(intent, 1);
        } else {
            Log.e(d3.f5549a, "can't open permission page with particular name, please use \"adb shell dumpsys activity\" command and tell me the name of the float window permission page");
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
                Log.e(d3.f5549a, Log.getStackTraceString(e4));
            }
        } else {
            Log.e("", "Below API 19 cannot invoke!");
        }
        return false;
    }

    private static boolean d(Intent intent, Context context) {
        return intent != null && context.getPackageManager().queryIntentActivities(intent, 65536).size() > 0;
    }
}
