package com.acse.ottn.d.b;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.ra;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5450a = "MeizuUtils";

    public static void a(AppCompatActivity appCompatActivity, int i4) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.putExtra("packageName", CommonUtil.PACKAGE_NAME);
            intent.setFlags(268435456);
            appCompatActivity.startActivityForResult(intent, i4);
        } catch (Exception e4) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("\u83b7\u53d6\u60ac\u6d6e\u7a97\u6743\u9650, \u6253\u5f00AppSecActivity\u5931\u8d25, ");
                sb.append(Log.getStackTraceString(e4));
                ra.b("MeizuUtils", sb.toString());
                com.acse.ottn.d.i.b(appCompatActivity, i4);
            } catch (Exception e5) {
                ra.b("MeizuUtils", "\u83b7\u53d6\u60ac\u6d6e\u7a97\u6743\u9650\u5931\u8d25, \u901a\u7528\u83b7\u53d6\u65b9\u6cd5\u5931\u8d25, " + Log.getStackTraceString(e5));
            }
        }
    }

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    private static boolean a(Context context, int i4) {
        String str;
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
                str = Log.getStackTraceString(e4);
            }
        } else {
            str = "Below API 19 cannot invoke!";
        }
        ra.b("MeizuUtils", str);
        return false;
    }
}
