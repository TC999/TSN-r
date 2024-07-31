package com.acse.ottn.p042d.p044b;

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
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import com.clj.fastble.BleManager;
import com.p518qq.p519e.comm.constants.ErrorCode;
import java.util.List;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.b.h */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1505h {

    /* renamed from: a */
    private static final String f2767a = "acse_HuaweiUtils";

    /* renamed from: b */
    private static boolean f2768b = true;

    /* renamed from: d */
    public static TimerTask f2770d;

    /* renamed from: g */
    List<String> f2773g;

    /* renamed from: c */
    private static Long f2769c = 0L;

    /* renamed from: e */
    private static AccessibilityNodeInfo f2771e = null;

    /* renamed from: f */
    private static AccessibilityNodeInfo f2772f = null;

    @RequiresApi(api = 16)
    /* renamed from: a */
    public static void m56624a(AccessibilityService accessibilityService, long j, boolean z) {
        if (j - f2769c.longValue() < 1000) {
            C1694ra.m55917a(f2767a, "间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            C1694ra.m55917a(f2767a, "间隔 time=" + f2769c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f2769c.longValue()));
            return;
        }
        C1694ra.m55917a(f2767a, "无间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        C1694ra.m55917a(f2767a, "无间隔 time=" + f2769c + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f2769c.longValue()));
        f2769c = Long.valueOf(j);
        f2770d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(5000), C1652V.m56140a().m56132b(100), new C1498a(accessibilityService, z));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m56623a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        AccessibilityNodeInfo accessibilityNodeInfo2;
        if (accessibilityNodeInfo != null) {
            int i = 0;
            while (true) {
                if (i >= accessibilityNodeInfo.getChildCount()) {
                    accessibilityNodeInfo2 = null;
                    break;
                } else if (accessibilityNodeInfo.getChild(i) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i).getClassName()) && accessibilityNodeInfo.getChild(i).getChildCount() > 0) {
                    accessibilityNodeInfo2 = accessibilityNodeInfo.getChild(i);
                    break;
                } else {
                    if (accessibilityNodeInfo.getChild(i) != null) {
                        m56623a(accessibilityService, accessibilityNodeInfo.getChild(i));
                    }
                    i++;
                }
            }
            if (accessibilityNodeInfo2 == null) {
                return;
            }
            f2770d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(3000), C1652V.m56140a().m56132b(100), new C1503f(accessibilityService, accessibilityNodeInfo2));
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: a */
    public static void m56622a(AccessibilityService accessibilityService, boolean z) {
        f2770d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(ErrorCode.UNKNOWN_ERROR), C1652V.m56140a().m56132b(100), new C1502e(accessibilityService));
    }

    /* renamed from: a */
    public static void m56621a(Activity activity) {
        if (C1661ba.m56097a().m56086d("OpenPermissionName").equals("权限管理")) {
            C1661ba.m56097a().m56092a("background_battery_hignt", true);
        }
        ComponentName componentName = null;
        int i = Build.VERSION.SDK_INT;
        Intent intent = new Intent();
        String str = "com.huawei.systemmanager/.startupmgr.ui.StartupNormalAppListActivity";
        try {
            if (i < 28) {
                if (i >= 26) {
                    str = "com.huawei.systemmanager/.appcontrol.activity.StartupAppControlActivity";
                } else if (i < 23) {
                    if (i >= 21) {
                        str = "com.huawei.systemmanager/com.huawei.permissionmanager.ui.MainActivity";
                    }
                    intent.setComponent(componentName);
                    activity.startActivity(intent);
                }
            }
            componentName = ComponentName.unflattenFromString(str);
            intent.setComponent(componentName);
            activity.startActivity(intent);
        } catch (Exception e) {
            try {
                intent.setComponent(ComponentName.unflattenFromString("com.android.settings/.Settings$AppAndNotificationDashboardActivity"));
                activity.startActivity(intent);
            } catch (Exception unused) {
                C1694ra.m55915b(f2767a, e.getMessage().toString());
            }
        }
    }

    /* renamed from: a */
    public static void m56620a(Activity activity, int i) {
        String stackTraceString;
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.systemmanager.addviewmonitor.AddViewMonitorActivity"));
            if (C1493B.m56645f() == 3.1d) {
                activity.startActivityForResult(intent, i);
            } else {
                intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.notificationmanager.ui.NotificationManagmentActivity"));
                activity.startActivity(intent);
            }
        } catch (ActivityNotFoundException e) {
            Intent intent2 = new Intent();
            intent2.setFlags(268435456);
            intent2.setComponent(new ComponentName("com.Android.settings", "com.android.settings.permission.TabItem"));
            activity.startActivityForResult(intent2, i);
            e.printStackTrace();
            stackTraceString = Log.getStackTraceString(e);
            C1694ra.m55915b(f2767a, stackTraceString);
        } catch (SecurityException e2) {
            Intent intent3 = new Intent();
            intent3.setFlags(268435456);
            intent3.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
            activity.startActivityForResult(intent3, i);
            stackTraceString = Log.getStackTraceString(e2);
            C1694ra.m55915b(f2767a, stackTraceString);
        } catch (Exception e3) {
            stackTraceString = Log.getStackTraceString(e3);
            C1694ra.m55915b(f2767a, stackTraceString);
        }
    }

    /* renamed from: a */
    public static boolean m56619a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m56618a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: a */
    private static boolean m56618a(Context context, int i) {
        String str;
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 19) {
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
        C1694ra.m55915b(f2767a, str);
        return false;
    }

    @RequiresApi(api = 16)
    /* renamed from: b */
    public static void m56613b(AccessibilityService accessibilityService, boolean z) {
        Log.d("samon-->", "clickOpenBatteryManage");
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(1300));
        if (C1684n.m55975c().m55953h(accessibilityService, "应用启动管理") == null) {
            C1694ra.m55917a(f2767a, "clickOpenBatteryManage");
            return;
        }
        C1694ra.m55917a(f2767a, "找到");
        m56603e(accessibilityService, z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 16)
    /* renamed from: b */
    public static void m56611b(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, str);
        if (m55955g == null || m55955g.getParent() == null) {
            return;
        }
        for (int i = 0; i < m55955g.getParent().getChildCount(); i++) {
            if (m55955g.getParent().getChild(i) != null && "android.widget.Switch".equals(m55955g.getParent().getChild(i).getClassName())) {
                if (m55955g.getParent().getChild(i).isChecked()) {
                    return;
                }
                C1684n.m55975c().m55958f(m55955g.getParent().getChild(i));
                return;
            }
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: c */
    public static void m56610c(AccessibilityService accessibilityService) {
        TimerTask timerTask = f2770d;
        if (timerTask != null) {
            timerTask.cancel();
            f2770d = null;
        }
        f2770d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(8000), C1652V.m56140a().m56132b(100), new C1499b(accessibilityService, C1661ba.m56097a().m56086d("OpenPermissionName")));
    }

    /* renamed from: c */
    public static void m56609c(AccessibilityService accessibilityService, boolean z) {
        m56600f(accessibilityService, z);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: c */
    public static void m56608c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i).getClassName())) {
                    f2771e = accessibilityNodeInfo.getChild(i);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56608c(accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    public static AccessibilityNodeInfo m56605d(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i).getClassName()) && accessibilityNodeInfo.getChild(i).isScrollable()) {
                    return accessibilityNodeInfo.getChild(i);
                }
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56605d(accessibilityNodeInfo.getChild(i));
                }
            }
            return null;
        }
        return null;
    }

    @RequiresApi(api = 16)
    /* renamed from: d */
    public static void m56607d(AccessibilityService accessibilityService) {
        String m56081b = C1663ca.m56080c().m56081b();
        C1694ra.m55915b(f2767a, m56081b);
        f2770d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(BleManager.f22896l), C1652V.m56140a().m56132b(100), new C1500c(accessibilityService, m56081b));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: d */
    public static void m56606d(AccessibilityService accessibilityService, boolean z) {
        C1694ra.m55917a(f2767a, "recycle 开始");
        f2770d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(ErrorCode.UNKNOWN_ERROR), C1652V.m56140a().m56132b(100), new C1501d(accessibilityService, C1663ca.m56080c().m56081b(), z));
    }

    /* renamed from: e */
    private static void m56604e(AccessibilityService accessibilityService) {
        f2770d = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(15000), C1652V.m56140a().m56132b(100), new C1504g(accessibilityService, C1663ca.m56080c().m56081b()));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    private static void m56603e(AccessibilityService accessibilityService, boolean z) {
        f2772f = null;
        m56606d(accessibilityService, z);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    public static void m56602e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if ((accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) && accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56602e(accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: f */
    public static void m56601f(AccessibilityService accessibilityService) {
        m56608c(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    /* renamed from: f */
    private static void m56600f(AccessibilityService accessibilityService, boolean z) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(1000));
        if (z) {
            m56623a(accessibilityService, rootInActiveWindow);
        } else {
            m56604e(accessibilityService);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static void m56599f(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            if (accessibilityNodeInfo.getChild(i) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i).getClassName())) {
                C1694ra.m55917a(f2767a, "android.widget.ListView = " + accessibilityNodeInfo.getChild(i).getChildCount());
                if (accessibilityNodeInfo.getChild(i).getChildCount() > 0) {
                    f2772f = accessibilityNodeInfo.getChild(i);
                }
            }
            if (accessibilityNodeInfo.getChild(i) != null) {
                m56599f(accessibilityNodeInfo.getChild(i));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: g */
    public static void m56598g(AccessibilityService accessibilityService) {
        m56602e(accessibilityService.getRootInActiveWindow());
    }

    /* JADX INFO: Access modifiers changed from: private */
    @RequiresApi(api = 16)
    /* renamed from: g */
    public static void m56597g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || accessibilityNodeInfo.getParent() == null) {
            return;
        }
        for (int i = 0; i < accessibilityNodeInfo.getParent().getChildCount(); i++) {
            if (accessibilityNodeInfo.getParent().getChild(i) != null && "android.widget.Switch".equals(accessibilityNodeInfo.getParent().getChild(i).getClassName())) {
                if (accessibilityNodeInfo.getParent().getChild(i).isChecked()) {
                    C1684n.m55975c().m55958f(accessibilityNodeInfo.getParent().getChild(i));
                    return;
                }
                return;
            }
        }
    }
}
