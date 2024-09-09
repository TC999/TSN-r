package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
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
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1421ca;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.S;
import com.acse.ottn.util.V;
import com.acse.ottn.util.ra;
import java.util.List;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5484a = "OppoUtils";

    /* renamed from: c  reason: collision with root package name */
    public static TimerTask f5486c;

    /* renamed from: e  reason: collision with root package name */
    List<String> f5488e;

    /* renamed from: b  reason: collision with root package name */
    private static Long f5485b = 0L;

    /* renamed from: d  reason: collision with root package name */
    private static AccessibilityNodeInfo f5487d = null;

    public static void a(AccessibilityService accessibilityService, long j4) {
        if (j4 - f5485b.longValue() < 1000) {
            ra.a("OppoUtils", "\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            ra.a("OppoUtils", "\u95f4\u9694 time=" + f5485b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5485b.longValue()));
            return;
        }
        ra.a("OppoUtils", "\u65e0\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        ra.a("OppoUtils", "\u65e0\u95f4\u9694 time=" + f5485b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5485b.longValue()));
        f5485b = Long.valueOf(j4);
        C1442n.c().a(500L);
        f5486c = S.a().b(V.a().b(1500), V.a().b(500), new x(accessibilityService));
    }

    public static void a(Activity activity) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        C1419ba.a().a("open_battery_white", true);
        Intent intent = new Intent();
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra("packageName", CommonUtil.PACKAGE_NAME);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivity(intent);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", CommonUtil.PACKAGE_NAME, null));
                activity.startActivity(intent2);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra("pkg_name", CommonUtil.PACKAGE_NAME);
            intent.putExtra("app_name", C1421ca.c().b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivity(intent);
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
                if (accessibilityNodeInfo.getChild(i4) != null && "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                    f5487d = accessibilityNodeInfo.getChild(i4);
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
        ra.b("OppoUtils", str);
        return false;
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, "\u8017\u7535\u7ba1\u7406");
        AccessibilityNodeInfo g5 = C1442n.c().g(accessibilityService, "\u8017\u7535\u4fdd\u62a4");
        if (g4 == null && g5 == null) {
            t.a(accessibilityService);
            return;
        }
        if (g4 != null) {
            ra.a("OppoUtils", "nodeInfo is null");
            C1442n.c().f(g4);
        } else {
            C1442n.c().f(g5);
        }
        C1419ba.a().a("battery_white", true);
        a(accessibilityService, System.currentTimeMillis());
    }

    @SuppressLint({"NewApi"})
    public static void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if ((accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) && accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    b(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    public static void c(AccessibilityService accessibilityService) {
        C1442n.c().a(V.a().b(50));
        if (C1442n.c().h(accessibilityService, C1421ca.c().b()) != null) {
            AccessibilityNodeInfo j4 = C1442n.c().j(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8\u6253\u5f00");
            if (j4 != null) {
                C1442n.c().f(j4);
            }
            AccessibilityNodeInfo j5 = C1442n.c().j(accessibilityService, "\u6253\u5f00");
            if (j5 != null) {
                C1442n.c().f(j5);
            }
        }
    }

    public static void d(AccessibilityService accessibilityService) {
        f5486c = S.a().b(V.a().b(20000), V.a().b(100), new w(accessibilityService, C1421ca.c().b()));
    }

    public static void e(AccessibilityService accessibilityService) {
        f5486c = S.a().b(V.a().b(20000), V.a().b(400), new v(accessibilityService, C1421ca.c().b()));
    }

    @RequiresApi(api = 16)
    public static void f(AccessibilityService accessibilityService) {
        f5486c = S.a().b(V.a().b(20000), V.a().b(100), new u(accessibilityService, C1421ca.c().b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void g(AccessibilityService accessibilityService) {
        f5486c = S.a().b(V.a().b(1000), V.a().b(100), new y(accessibilityService));
    }

    @SuppressLint({"NewApi"})
    private static void h(AccessibilityService accessibilityService) {
        a(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    private static void i(AccessibilityService accessibilityService) {
        b(accessibilityService.getRootInActiveWindow());
    }
}
