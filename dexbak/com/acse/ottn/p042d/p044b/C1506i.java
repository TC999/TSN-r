package com.acse.ottn.p042d.p044b;

import android.annotation.TargetApi;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.p042d.C1530i;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;

/* renamed from: com.acse.ottn.d.b.i */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1506i {

    /* renamed from: a */
    private static final String f2774a = "MeizuUtils";

    /* renamed from: a */
    public static void m56594a(AppCompatActivity appCompatActivity, int i) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        try {
            Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
            intent.putExtra(TTDownloadField.TT_PACKAGE_NAME, CommonUtil.PACKAGE_NAME);
            intent.setFlags(268435456);
            appCompatActivity.startActivityForResult(intent, i);
        } catch (Exception e) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append("获取悬浮窗权限, 打开AppSecActivity失败, ");
                sb.append(Log.getStackTraceString(e));
                C1694ra.m55915b(f2774a, sb.toString());
                C1530i.m56510b(appCompatActivity, i);
            } catch (Exception e2) {
                C1694ra.m55915b(f2774a, "获取悬浮窗权限失败, 通用获取方法失败, " + Log.getStackTraceString(e2));
            }
        }
    }

    /* renamed from: a */
    public static boolean m56596a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m56595a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: a */
    private static boolean m56595a(Context context, int i) {
        String str;
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
                str = Log.getStackTraceString(e);
            }
        } else {
            str = "Below API 19 cannot invoke!";
        }
        C1694ra.m55915b(f2774a, str);
        return false;
    }
}
