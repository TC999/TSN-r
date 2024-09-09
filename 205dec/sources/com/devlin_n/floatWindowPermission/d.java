package com.devlin_n.floatWindowPermission;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import com.acse.ottn.g2;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5141176.dex
 */
/* compiled from: MeizuUtils.java */
/* loaded from: E:\TSN-r\205dec\6241084.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final String f36853a = "MeizuUtils";

    public static void a(Context context) {
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.setClassName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity");
        intent.putExtra("packageName", context.getPackageName());
        h.a(context).startActivityForResult(intent, 1);
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
                Log.e(g2.f5671a, Log.getStackTraceString(e4));
            }
        } else {
            Log.e(g2.f5671a, "Below API 19 cannot invoke!");
        }
        return false;
    }
}
