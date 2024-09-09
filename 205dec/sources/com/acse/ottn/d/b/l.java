package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Binder;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.service.ShopHelperService;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1421ca;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.S;
import com.acse.ottn.util.V;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class l {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5455a = "acse_MiuiUtils";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5456b;

    /* renamed from: c  reason: collision with root package name */
    public static TimerTask f5457c;

    /* renamed from: d  reason: collision with root package name */
    private static AccessibilityNodeInfo f5458d;

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if ((accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) && accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    a(accessibilityService, accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    public static void a(Activity activity) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
            intent.setComponent(componentName);
            intent.addFlags(268435456);
            C1419ba.a().a("battery_white", true);
            activity.startActivityForResult(intent, 10013);
        } catch (Exception unused) {
            CommonUtil.setButteryState(true);
        }
    }

    public static void a(Activity activity, int i4) {
        int b4 = b();
        if (b4 == 5) {
            b(activity, i4);
        } else if (b4 == 6) {
            c(activity, i4);
        } else if (b4 == 7) {
            d(activity, i4);
        } else if (b4 == 8) {
            e(activity, i4);
        } else {
            ra.b("acse_MiuiUtils", "this is a special MIUI rom version, its version code " + b4);
        }
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
            if (accessibilityNodeInfo.getChild(i4) != null) {
                if ("androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getClassName())) {
                    f5458d = accessibilityNodeInfo;
                    return;
                }
                a(accessibilityNodeInfo.getChild(i4));
            }
        }
    }

    @RequiresApi(api = 16)
    public static void a(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, str);
        if (g4 == null || g4.getParent() == null) {
            return;
        }
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

    public static boolean a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    private static boolean a(Context context, int i4) {
        String str;
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
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
        ra.b("acse_MiuiUtils", str);
        return false;
    }

    private static boolean a(Intent intent, Activity activity) {
        return (intent == null || activity == null || activity.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }

    public static int b() {
        String a4 = B.a("ro.miui.ui.version.name");
        if (a4 != null) {
            try {
                return Integer.parseInt(a4.substring(1));
            } catch (Exception e4) {
                ra.b("acse_MiuiUtils", "get miui version code error, version : " + a4);
                ra.b("acse_MiuiUtils", Log.getStackTraceString(e4));
                return -1;
            }
        }
        return -1;
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, "\u81ea\u542f\u52a8");
        if (g4 == null) {
            return;
        }
        C1442n.c().f(g4);
        C1442n.c().a(V.a().b(300));
        a("\u5141\u8bb8\u7cfb\u7edf\u5524\u9192", accessibilityService);
        C1442n.c().d(accessibilityService);
        C1419ba.a().a("battery_white", false);
        C1442n.c().d(accessibilityService);
    }

    public static void b(Activity activity) {
        c(activity);
    }

    public static void b(Activity activity, int i4) {
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
            ra.b("acse_MiuiUtils", "intent is not available!");
        }
    }

    @SuppressLint({"NewApi"})
    public static void b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            TextUtils.isEmpty(accessibilityNodeInfo.getText());
        } else if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    b(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    @RequiresApi(api = 16)
    public static void b(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, str);
        if (g4 == null || g4.getParent() == null) {
            return;
        }
        for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
            if (g4.getParent().getChild(i4) != null && "android.widget.CheckBox".equals(g4.getParent().getChild(i4).getClassName())) {
                ra.a("samon-->", "android.widget.CheckBox=" + g4.getParent().getChild(i4).toString());
                if (!g4.getParent().getChild(i4).isChecked()) {
                    C1442n.c().f(g4.getParent().getChild(i4));
                    C1442n.c().a(V.a().b(100));
                    AccessibilityNodeInfo j4 = C1442n.c().j(ShopHelperService.mService, "\u786e\u5b9a");
                    AccessibilityNodeInfo j5 = C1442n.c().j(ShopHelperService.mService, "\u77e5\u9053\u4e86");
                    if (j4 != null) {
                        ra.a("samon-->", "commitInfo is not null");
                        C1442n.c().f(j4);
                    } else if (j5 != null) {
                        ra.a("samon-->", "commitInfo1 is not null");
                        C1442n.c().f(j5);
                    }
                    CommonUtil.setServiceHightButteryState(true);
                }
                C1442n.c().a(V.a().b(100));
                C1442n.c().d(accessibilityService);
                return;
            }
        }
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        C1442n.c().a(500L);
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, "\u5176\u4ed6\u6743\u9650");
        if (g4 != null) {
            ra.a("samonp-->", "appNodeInfo is not null=");
            C1442n.c().f(g4);
            C1419ba.a().a("battery_white", true);
            C1419ba.a().a("is_pengpai", true);
            return;
        }
        TimerTask timerTask = f5457c;
        if (timerTask != null) {
            timerTask.cancel();
            f5457c = null;
        }
        String d4 = C1419ba.a().d("OpenPermissionName");
        ra.a("samonp-->", "\u627e\u5230\u4e86\u60ac\u6d6e\u7a97=" + d4);
        f5457c = S.a().b(V.a().b(2000), V.a().b(300), new k(d4, accessibilityService));
    }

    private static void c(Activity activity) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        C1419ba.a().a("battery_white", true);
        C1419ba.a().a("background_battery_hignt", true);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", CommonUtil.PACKAGE_NAME, null));
        try {
            activity.startActivityForResult(intent, 10015);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
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
            ra.b("acse_MiuiUtils", "Intent is not available!");
        }
    }

    @RequiresApi(api = 16)
    public static void d(AccessibilityService accessibilityService) {
        C1442n.c().a(200L);
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, "\u5141\u8bb8\u663e\u793a\u5728\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42");
        if (g4 == null) {
            AccessibilityNodeInfo g5 = C1442n.c().g(accessibilityService, "\u663e\u793a\u5728\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42");
            AccessibilityNodeInfo g6 = C1442n.c().g(accessibilityService, "\u5141\u8bb8\u6b64\u5e94\u7528\u663e\u793a\u5728\u60a8\u5f53\u524d\u4f7f\u7528\u7684\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42\u3002\u6b64\u5e94\u7528\u5c06\u80fd\u5f97\u77e5\u60a8\u70b9\u6309\u7684\u4f4d\u7f6e\u6216\u66f4\u6539\u5c4f\u5e55\u4e0a\u663e\u793a\u7684\u5185\u5bb9\u3002");
            Rect rect = new Rect();
            g5.getBoundsInScreen(rect);
            Rect rect2 = new Rect();
            g6.getBoundsInScreen(rect2);
            int i4 = rect.right / 2;
            int i5 = rect2.top;
            int i6 = rect.bottom;
            int i7 = ((i5 - i6) / 2) + i6;
            if (Build.VERSION.SDK_INT >= 24) {
                C1442n.c().a(accessibilityService, i4, i7);
                ra.a("acse_MiuiUtils", "\u70b9\u51fb\u4e86");
            }
        } else {
            C1442n.c().f(g4);
        }
        C1442n.c().a(300L);
        C1442n.c().d(accessibilityService);
        if (Build.VERSION.SDK_INT >= 30) {
            C1442n.c().d(accessibilityService);
        }
    }

    public static void d(Activity activity, int i4) {
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
            ra.b("acse_MiuiUtils", "Intent is not available!");
        }
    }

    @SuppressLint({"NewApi"})
    public static void e(AccessibilityService accessibilityService) {
        a(accessibilityService, accessibilityService.getRootInActiveWindow());
    }

    public static void e(Activity activity, int i4) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        C1419ba.a().a("battery_white", true);
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
        intent.setFlags(268435456);
        if (!a(intent, activity)) {
            intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setPackage("com.miui.securitycenter");
            intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
            intent.setFlags(268435456);
            if (!a(intent, activity)) {
                ra.b("acse_MiuiUtils", "Intent is not available!");
                return;
            }
        }
        try {
            activity.startActivityForResult(intent, i4);
        } catch (Exception unused) {
            CommonUtil.setButteryState(true);
        }
    }

    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService) {
        b(accessibilityService.getRootInActiveWindow());
    }

    @RequiresApi(api = 16)
    public static void g(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, "\u5141\u8bb8\u7cfb\u7edf\u5524\u9192");
        AccessibilityNodeInfo g5 = C1442n.c().g(accessibilityService, "\u5141\u8bb8\u88ab\u5176\u4ed6\u5e94\u7528\u5524\u9192");
        int i4 = 0;
        if (g4 != null && g4.getParent() != null) {
            int i5 = 0;
            while (true) {
                if (i5 >= g4.getParent().getChildCount()) {
                    break;
                } else if (g4.getParent().getChild(i5) == null || !"android.widget.CheckBox".equals(g4.getParent().getChild(i5).getClassName())) {
                    i5++;
                } else if (!g4.getParent().getChild(i5).isChecked()) {
                    C1442n.c().f(g4);
                }
            }
        }
        if (g5 != null && g5.getParent() != null) {
            while (true) {
                if (i4 >= g5.getParent().getChildCount()) {
                    break;
                } else if (g5.getParent().getChild(i4) == null || !"android.widget.CheckBox".equals(g5.getParent().getChild(i4).getClassName())) {
                    i4++;
                } else if (!g5.getParent().getChild(i4).isChecked()) {
                    C1442n.c().f(g5);
                }
            }
        }
        C1442n.c().d(accessibilityService);
        C1442n.c().a(V.a().b(200));
        C1442n.c().d(accessibilityService);
        CommonUtil.setServiceHightButteryState(true);
    }

    @RequiresApi(api = 16)
    public static void h(AccessibilityService accessibilityService) {
        String b4 = C1421ca.c().b();
        ra.a("acse_MiuiUtils", b4);
        C1442n.c().a(V.a().b(500));
        f5457c = S.a().b(V.a().b(20000), V.a().b(100), new j(accessibilityService, b4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static void i(AccessibilityService accessibilityService) {
        a(accessibilityService.getRootInActiveWindow());
    }
}
