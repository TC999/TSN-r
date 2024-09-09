package com.acse.ottn.d.b;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.service.ShopHelperService;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1421ca;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.S;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5465a = "NubiaUtils";

    /* renamed from: b  reason: collision with root package name */
    public static TimerTask f5466b;

    /* renamed from: c  reason: collision with root package name */
    private static AccessibilityNodeInfo f5467c;

    public static void a(Activity activity) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        Intent intent = new Intent();
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra("packageName", CommonUtil.PACKAGE_NAME);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivityForResult(intent, 10013);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", CommonUtil.PACKAGE_NAME, null));
                activity.startActivityForResult(intent2, 10013);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra("pkg_name", CommonUtil.PACKAGE_NAME);
            intent.putExtra("app_name", C1421ca.c().b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivityForResult(intent, 10013);
        }
    }

    public static void a(Activity activity, int i4) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
            activity.startActivityForResult(intent, i4);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if ("android.support.v7.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                    f5467c = accessibilityNodeInfo.getChild(i4);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    a(accessibilityNodeInfo.getChild(i4));
                }
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
            return true;
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
        ra.b("NubiaUtils", str);
        return false;
    }

    @RequiresApi(api = 16)
    public static void c(ShopHelperService shopHelperService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(shopHelperService, "\u8017\u7535\u7ba1\u7406");
        AccessibilityNodeInfo g5 = C1442n.c().g(shopHelperService, "\u8017\u7535\u4fdd\u62a4");
        if (g4 == null && g5 == null) {
            return;
        }
        if (C1419ba.a() != null) {
            C1419ba.a().a("battery_white", true);
        }
        if (g4 != null) {
            C1442n.c().f(g4);
        } else {
            C1442n.c().f(g5);
        }
        f5466b = S.a().b(1500, 200, new o(shopHelperService));
    }

    @RequiresApi(api = 16)
    public static void d(ShopHelperService shopHelperService) {
        if (C1442n.c().b()) {
            ra.a("NubiaUtils", "\u60ac\u6d6e\u7a97\u6743\u9650\u5df2\u5f00\u542f");
            return;
        }
        AccessibilityNodeInfo g4 = C1442n.c().g(shopHelperService, "\u5141\u8bb8\u663e\u793a\u5728\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42");
        if (g4 == null) {
            return;
        }
        C1442n.c().f(g4);
        C1442n.c().d(shopHelperService);
        if (Build.VERSION.SDK_INT >= 30) {
            C1442n.c().d(shopHelperService);
        }
    }

    public static void e(ShopHelperService shopHelperService) {
        if (C1442n.c().b()) {
            ra.a("NubiaUtils", "\u60ac\u6d6e\u7a97\u6743\u9650\u5df2\u5f00\u542f");
            return;
        }
        f5466b = S.a().b(20000, 100, new n(shopHelperService, C1421ca.c().b()));
    }

    @RequiresApi(api = 16)
    public static void f(ShopHelperService shopHelperService) {
        if (C1442n.c().b()) {
            ra.a("NubiaUtils", "\u60ac\u6d6e\u7a97\u6743\u9650\u5df2\u5f00\u542f");
            return;
        }
        f5466b = S.a().b(20000, 100, new m(shopHelperService, C1421ca.c().b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(ShopHelperService shopHelperService) {
        f5466b = S.a().b(1000, 100, new p(shopHelperService));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static void h(ShopHelperService shopHelperService) {
        a(shopHelperService.getRootInActiveWindow());
    }
}
