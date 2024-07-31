package com.devlin_n.floatWindowPermission;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* renamed from: com.devlin_n.floatWindowPermission.d */
/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class MeizuUtils {

    /* renamed from: a */
    private static final String f23186a = "MeizuUtils";

    /* renamed from: a */
    public static void m35805a(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        intent.putExtra(TTDownloadField.TT_PACKAGE_NAME, context.getPackageName());
        WindowUtil.m35782a(context).startActivityForResult(intent, 1);
    }

    /* renamed from: b */
    public static boolean m35804b(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m35803c(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: c */
    private static boolean m35803c(Context context, int i) {
        if (Build.VERSION.SDK_INT >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i), Integer.valueOf(Binder.getCallingUid()), context.getPackageName())).intValue() == 0;
            } catch (Exception e) {
                Log.e(f23186a, Log.getStackTraceString(e));
            }
        } else {
            Log.e(f23186a, "Below API 19 cannot invoke!");
        }
        return false;
    }
}
