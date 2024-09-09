package com.acse.ottn;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class g2 {

    /* renamed from: a  reason: collision with root package name */
    public static final String f5671a = "MeizuUtils";

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context, 24);
        }
        return true;
    }

    public static void a(AppCompatActivity appCompatActivity, int i4) {
        if ("".equals(j0.f5781w)) {
            return;
        }
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.putExtra("packageName", j0.f5781w);
            intent.setFlags(268435456);
            appCompatActivity.startActivityForResult(intent, i4);
        } catch (Exception e4) {
            try {
                z1.b(f5671a, "\u83b7\u53d6\u60ac\u6d6e\u7a97\u6743\u9650, \u6253\u5f00AppSecActivity\u5931\u8d25, " + Log.getStackTraceString(e4));
                b1.e(appCompatActivity, i4);
            } catch (Exception e5) {
                z1.b(f5671a, "\u83b7\u53d6\u60ac\u6d6e\u7a97\u6743\u9650\u5931\u8d25, \u901a\u7528\u83b7\u53d6\u65b9\u6cd5\u5931\u8d25, " + Log.getStackTraceString(e5));
            }
        }
    }

    @TargetApi(19)
    public static boolean a(Context context, int i4) {
        int i5 = Build.VERSION.SDK_INT;
        if ("".equals(j0.f5781w)) {
            return false;
        }
        if (i5 >= 19) {
            AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
            try {
                Class cls = Integer.TYPE;
                return ((Integer) AppOpsManager.class.getDeclaredMethod("checkOp", cls, cls, String.class).invoke(appOpsManager, Integer.valueOf(i4), Integer.valueOf(Binder.getCallingUid()), j0.f5781w)).intValue() == 0;
            } catch (Exception e4) {
                z1.b(f5671a, Log.getStackTraceString(e4));
            }
        } else {
            z1.b(f5671a, "Below API 19 cannot invoke!");
        }
        return false;
    }
}
