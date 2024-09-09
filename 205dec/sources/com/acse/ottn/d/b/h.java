package com.acse.ottn.d.b;

import android.accessibilityservice.AccessibilityService;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
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
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import java.util.List;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5443a = "acse_HuaweiUtils";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f5444b = true;

    /* renamed from: d  reason: collision with root package name */
    public static TimerTask f5446d;

    /* renamed from: g  reason: collision with root package name */
    List<String> f5449g;

    /* renamed from: c  reason: collision with root package name */
    private static Long f5445c = 0L;

    /* renamed from: e  reason: collision with root package name */
    private static AccessibilityNodeInfo f5447e = null;

    /* renamed from: f  reason: collision with root package name */
    private static AccessibilityNodeInfo f5448f = null;

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, long j4, boolean z3) {
        if (j4 - f5445c.longValue() < 1000) {
            ra.a("acse_HuaweiUtils", "\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            ra.a("acse_HuaweiUtils", "\u95f4\u9694 time=" + f5445c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5445c.longValue()));
            return;
        }
        ra.a("acse_HuaweiUtils", "\u65e0\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        ra.a("acse_HuaweiUtils", "\u65e0\u95f4\u9694 time=" + f5445c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5445c.longValue()));
        f5445c = Long.valueOf(j4);
        f5446d = S.a().b(V.a().b(5000), V.a().b(100), new C1385a(accessibilityService, z3));
    }

    @SuppressLint({"NewApi"})
    public static void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        if (accessibilityNodeInfo != null) {
            int i4 = 0;
            while (true) {
                if (i4 >= accessibilityNodeInfo.getChildCount()) {
                    accessibilityNodeInfo2 = null;
                    break;
                } else if (accessibilityNodeInfo.getChild(i4) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i4).getClassName()) && accessibilityNodeInfo.getChild(i4).getChildCount() > 0) {
                    accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(i4);
                    break;
                } else {
                    if (accessibilityNodeInfo.getChild(i4) != null) {
                        a(accessibilityService, accessibilityNodeInfo.getChild(i4));
                    }
                    i4++;
                }
            }
            if (accessibilityNodeInfo2 == null) {
                return;
            }
            f5446d = S.a().b(V.a().b(3000), V.a().b(100), new C1390f(accessibilityService, accessibilityNodeInfo2));
        }
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, boolean z3) {
        f5446d = S.a().b(V.a().b(6000), V.a().b(100), new C1389e(accessibilityService));
    }

    public static void a(Activity activity) {
        if (C1419ba.a().d("OpenPermissionName").equals("\u6743\u9650\u7ba1\u7406")) {
            C1419ba.a().a("background_battery_hignt", true);
        }
        ComponentName componentName = null;
        int i4 = Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        String str = "com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity";
        try {
            if (i4 < 28) {
                if (i4 >= 26) {
                    str = "com.huawei.systemmanager/.appcontrol.activity.StartupAppControlActivity";
                } else if (i4 < 23) {
                    if (i4 >= 21) {
                        str = "com.huawei.systemmanager/com.huawei.permissionmanager.ui.MainActivity";
                    }
                    intent.setComponent(componentName);
                    activity.startActivity(intent);
                }
            }
            componentName = ComponentName.unflattenFromString(str);
            intent.setComponent(componentName);
            activity.startActivity(intent);
        } catch (Exception e4) {
            try {
                intent.setComponent(ComponentName.unflattenFromString("com.android.settings/.Settings$AppAndNotificationDashboardActivity"));
                activity.startActivity(intent);
            } catch (Exception unused) {
                ra.b("acse_HuaweiUtils", e4.getMessage().toString());
            }
        }
    }

    public static void a(Activity activity, int i4) {
        String stackTraceString;
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            if (B.f() == 3.1d) {
                activity.startActivityForResult(intent, i4);
            } else {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                activity.startActivity(intent);
            }
        } catch (ActivityNotFoundException e4) {
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            activity.startActivityForResult(intent2, i4);
            e4.printStackTrace();
            stackTraceString = Log.getStackTraceString(e4);
            ra.b("acse_HuaweiUtils", stackTraceString);
        } catch (SecurityException e5) {
            Intent intent3 = new Intent();
            intent3.setFlags(268435456);
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            activity.startActivityForResult(intent3, i4);
            stackTraceString = Log.getStackTraceString(e5);
            ra.b("acse_HuaweiUtils", stackTraceString);
        } catch (Exception e6) {
            stackTraceString = Log.getStackTraceString(e6);
            ra.b("acse_HuaweiUtils", stackTraceString);
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
        ra.b("acse_HuaweiUtils", str);
        return false;
    }

    @RequiresApi(api = 16)
    public static void b(AccessibilityService accessibilityService, boolean z3) {
        Log.d("samon-->", "clickOpenBatteryManage");
        C1442n.c().a(V.a().b(1300));
        if (C1442n.c().h(accessibilityService, "\u5e94\u7528\u542f\u52a8\u7ba1\u7406") == null) {
            ra.a("acse_HuaweiUtils", "clickOpenBatteryManage");
            return;
        }
        ra.a("acse_HuaweiUtils", "\u627e\u5230");
        e(accessibilityService, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 16)
    public static void b(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, str);
        if (g4 == null || g4.getParent() == null) {
            return;
        }
        for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
            if (g4.getParent().getChild(i4) != null && "android.widget.Switch".equals(g4.getParent().getChild(i4).getClassName())) {
                if (g4.getParent().getChild(i4).isChecked()) {
                    return;
                }
                C1442n.c().f(g4.getParent().getChild(i4));
                return;
            }
        }
    }

    @RequiresApi(api = 16)
    public static void c(AccessibilityService accessibilityService) {
        TimerTask timerTask = f5446d;
        if (timerTask != null) {
            timerTask.cancel();
            f5446d = null;
        }
        f5446d = S.a().b(V.a().b(AVMDLDataLoader.KeyIsLiveSetLoaderType), V.a().b(100), new C1386b(accessibilityService, C1419ba.a().d("OpenPermissionName")));
    }

    public static void c(AccessibilityService accessibilityService, boolean z3) {
        f(accessibilityService, z3);
    }

    @SuppressLint({"NewApi"})
    public static void c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                    f5447e = accessibilityNodeInfo.getChild(i4);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    c(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    public static AccessibilityNodeInfo d(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i4).getClassName()) && accessibilityNodeInfo.getChild(i4).isScrollable()) {
                    return accessibilityNodeInfo.getChild(i4);
                }
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    d(accessibilityNodeInfo.getChild(i4));
                }
            }
            return null;
        }
        return null;
    }

    @RequiresApi(api = 16)
    public static void d(AccessibilityService accessibilityService) {
        String b4 = C1421ca.c().b();
        ra.b("acse_HuaweiUtils", b4);
        f5446d = S.a().b(V.a().b(10000), V.a().b(100), new C1387c(accessibilityService, b4));
    }

    @SuppressLint({"NewApi"})
    public static void d(AccessibilityService accessibilityService, boolean z3) {
        ra.a("acse_HuaweiUtils", "recycle \u5f00\u59cb");
        f5446d = S.a().b(V.a().b(6000), V.a().b(100), new C1388d(accessibilityService, C1421ca.c().b(), z3));
    }

    private static void e(AccessibilityService accessibilityService) {
        f5446d = S.a().b(V.a().b(15000), V.a().b(100), new g(accessibilityService, C1421ca.c().b()));
    }

    @SuppressLint({"NewApi"})
    private static void e(AccessibilityService accessibilityService, boolean z3) {
        f5448f = null;
        d(accessibilityService, z3);
    }

    @SuppressLint({"NewApi"})
    public static void e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if ((accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) && accessibilityNodeInfo != null) {
            for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
                if (accessibilityNodeInfo.getChild(i4) != null) {
                    e(accessibilityNodeInfo.getChild(i4));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static void f(AccessibilityService accessibilityService) {
        c(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    private static void f(AccessibilityService accessibilityService, boolean z3) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        C1442n.c().a(V.a().b(1000));
        if (z3) {
            a(accessibilityService, rootInActiveWindow);
        } else {
            e(accessibilityService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void f(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
            if (accessibilityNodeInfo.getChild(i4) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                ra.a("acse_HuaweiUtils", "android.widget.ListView = " + accessibilityNodeInfo.getChild(i4).getChildCount());
                if (accessibilityNodeInfo.getChild(i4).getChildCount() > 0) {
                    f5448f = accessibilityNodeInfo.getChild(i4);
                }
            }
            if (accessibilityNodeInfo.getChild(i4) != null) {
                f(accessibilityNodeInfo.getChild(i4));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static void g(AccessibilityService accessibilityService) {
        e(accessibilityService.getRootInActiveWindow());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 16)
    public static void g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getParent() == null) {
            return;
        }
        for (int i4 = 0; i4 < accessibilityNodeInfo.getParent().getChildCount(); i4++) {
            if (accessibilityNodeInfo.getParent().getChild(i4) != null && "android.widget.Switch".equals(accessibilityNodeInfo.getParent().getChild(i4).getClassName())) {
                if (accessibilityNodeInfo.getParent().getChild(i4).isChecked()) {
                    C1442n.c().f(accessibilityNodeInfo.getParent().getChild(i4));
                    return;
                }
                return;
            }
        }
    }
}
