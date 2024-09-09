package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.C1421ca;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.S;
import com.acse.ottn.util.V;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class t {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5472a = "OnePlusUtils";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5473b;

    /* renamed from: c  reason: collision with root package name */
    public static TimerTask f5474c;

    /* renamed from: d  reason: collision with root package name */
    private static AccessibilityNodeInfo f5475d;

    public static int a() {
        String a4 = B.a("ro.miui.ui.version.name");
        if (a4 != null) {
            try {
                return Integer.parseInt(a4.substring(1));
            } catch (Exception e4) {
                ra.b("OnePlusUtils", "get miui version code error, version : " + a4);
                ra.b("OnePlusUtils", Log.getStackTraceString(e4));
                return -1;
            }
        }
        return -1;
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, "\u9ad8\u7ea7");
        if (g4 == null) {
            return;
        }
        C1442n.c().f(g4);
        C1442n.c().a(V.a().b(200));
        AccessibilityNodeInfo g5 = C1442n.c().g(accessibilityService, "\u7535\u6c60");
        if (g5 == null) {
            return;
        }
        CommonUtil.setButteryState(true);
        C1442n.c().f(g5);
        C1442n.c().a(V.a().b(500));
        AccessibilityNodeInfo g6 = C1442n.c().g(accessibilityService, "\u4e0d\u4f18\u5316");
        if (g6 == null) {
            return;
        }
        C1442n.c().f(g6);
        C1442n.c().d(accessibilityService);
        C1442n.c().a(V.a().b(100));
        C1442n.c().d(accessibilityService);
    }

    public static void a(Activity activity, int i4) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        String str = CommonUtil.PACKAGE_NAME;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", str, null));
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i4);
        } else {
            ra.b("OnePlusUtils", "intent is not available!");
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                Log.d("samon-->", accessibilityNodeInfo.getChild(i4).getClassName().toString());
                if (accessibilityNodeInfo.getChild(i4) != null && "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                    f5475d = accessibilityNodeInfo.getChild(i4);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    a(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    @RequiresApi(api = 16)
    private static void a(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, str);
        if (g4 != null) {
            for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
                if (g4.getParent().getChild(i4) != null && "android.widget.CheckBox".equals(g4.getParent().getChild(i4).getClassName())) {
                    if (!g4.getParent().getChild(i4).isChecked()) {
                        C1442n.c().f(g4.getParent().getChild(i4));
                    }
                    CommonUtil.setButteryState(true);
                    return;
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
        ra.b("OnePlusUtils", str);
        return false;
    }

    private static boolean a(Intent intent, Activity activity) {
        return (intent == null || activity == null || activity.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService) {
        f5474c = S.a().b(V.a().b(10000), V.a().b(100), new s(accessibilityService, C1421ca.c().b()));
    }

    public static void b(Activity activity, int i4) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i4);
        } else {
            ra.b("OnePlusUtils", "Intent is not available!");
        }
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, "\u5141\u8bb8\u663e\u793a\u5728\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42");
        AccessibilityNodeInfo g5 = C1442n.c().g(accessibilityService, "\u6388\u4e88\u60ac\u6d6e\u7a97\u6743\u9650");
        if (g4 != null) {
            C1442n.c().f(g4);
            C1442n.c().d(accessibilityService);
            if (Build.VERSION.SDK_INT < 30) {
                return;
            }
        } else if (g5 == null) {
            return;
        } else {
            C1442n.c().f(g5);
            C1442n.c().d(accessibilityService);
            if (Build.VERSION.SDK_INT < 30) {
                return;
            }
        }
        C1442n.c().d(accessibilityService);
    }

    public static void c(Activity activity, int i4) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
        intent.setFlags(268435456);
        if (a(intent, activity)) {
            activity.startActivityForResult(intent, i4);
        } else {
            ra.b("OnePlusUtils", "Intent is not available!");
        }
    }

    @RequiresApi(api = 16)
    public static void d(AccessibilityService accessibilityService) {
        String b4 = C1421ca.c().b();
        ra.a("OnePlusUtils", b4);
        f5474c = S.a().b(V.a().b(20000), V.a().b(500), new r(accessibilityService, b4));
    }

    @SuppressLint({"NewApi"})
    private static void e(AccessibilityService accessibilityService) {
        a(accessibilityService.getRootInActiveWindow());
    }
}
