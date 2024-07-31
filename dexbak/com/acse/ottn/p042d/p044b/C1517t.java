package com.acse.ottn.p042d.p044b;

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
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import com.clj.fastble.BleManager;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.b.t */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1517t {

    /* renamed from: a */
    private static final String f2796a = "OnePlusUtils";

    /* renamed from: b */
    private static boolean f2797b;

    /* renamed from: c */
    public static TimerTask f2798c;

    /* renamed from: d */
    private static AccessibilityNodeInfo f2799d;

    /* renamed from: a */
    public static int m56552a() {
        String m56650a = C1493B.m56650a("ro.miui.ui.version.name");
        if (m56650a != null) {
            try {
                return Integer.parseInt(m56650a.substring(1));
            } catch (Exception e) {
                C1694ra.m55915b(f2796a, "get miui version code error, version : " + m56650a);
                C1694ra.m55915b(f2796a, Log.getStackTraceString(e));
                return -1;
            }
        }
        return -1;
    }

    @RequiresApi(api = 16)
    /* renamed from: a */
    public static void m56551a(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, "高级");
        if (m55955g == null) {
            return;
        }
        C1684n.m55975c().m55958f(m55955g);
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
        AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(accessibilityService, "电池");
        if (m55955g2 == null) {
            return;
        }
        CommonUtil.setButteryState(true);
        C1684n.m55975c().m55958f(m55955g2);
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(500));
        AccessibilityNodeInfo m55955g3 = C1684n.m55975c().m55955g(accessibilityService, "不优化");
        if (m55955g3 == null) {
            return;
        }
        C1684n.m55975c().m55958f(m55955g3);
        C1684n.m55975c().m55969d(accessibilityService);
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(100));
        C1684n.m55975c().m55969d(accessibilityService);
    }

    /* renamed from: a */
    public static void m56550a(Activity activity, int i) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        String str = CommonUtil.PACKAGE_NAME;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", str, null));
        intent.setFlags(268435456);
        if (m56547a(intent, activity)) {
            activity.startActivityForResult(intent, i);
        } else {
            C1694ra.m55915b(f2796a, "intent is not available!");
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m56546a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                Log.d("samon-->", accessibilityNodeInfo.getChild(i).getClassName().toString());
                if (accessibilityNodeInfo.getChild(i) != null && "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i).getClassName())) {
                    f2799d = accessibilityNodeInfo.getChild(i);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56546a(accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: a */
    private static void m56545a(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, str);
        if (m55955g != null) {
            for (int i = 0; i < m55955g.getParent().getChildCount(); i++) {
                if (m55955g.getParent().getChild(i) != null && "android.widget.CheckBox".equals(m55955g.getParent().getChild(i).getClassName())) {
                    if (!m55955g.getParent().getChild(i).isChecked()) {
                        C1684n.m55975c().m55958f(m55955g.getParent().getChild(i));
                    }
                    CommonUtil.setButteryState(true);
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m56549a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m56548a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: a */
    private static boolean m56548a(Context context, int i) {
        String str;
        int i2 = Build.VERSION.SDK_INT;
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return true;
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
        C1694ra.m55915b(f2796a, str);
        return false;
    }

    /* renamed from: a */
    private static boolean m56547a(Intent intent, Activity activity) {
        return (intent == null || activity == null || activity.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }

    @RequiresApi(api = 16)
    /* renamed from: b */
    public static void m56544b(AccessibilityService accessibilityService) {
        f2798c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(BleManager.f22896l), C1652V.m56140a().m56132b(100), new C1516s(accessibilityService, C1663ca.m56080c().m56081b()));
    }

    /* renamed from: b */
    public static void m56543b(Activity activity, int i) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
        intent.setFlags(268435456);
        if (m56547a(intent, activity)) {
            activity.startActivityForResult(intent, i);
        } else {
            C1694ra.m55915b(f2796a, "Intent is not available!");
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: c */
    public static void m56542c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, "允许显示在其他应用的上层");
        AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(accessibilityService, "授予悬浮窗权限");
        if (m55955g != null) {
            C1684n.m55975c().m55958f(m55955g);
            C1684n.m55975c().m55969d(accessibilityService);
            if (Build.VERSION.SDK_INT < 30) {
                return;
            }
        } else if (m55955g2 == null) {
            return;
        } else {
            C1684n.m55975c().m55958f(m55955g2);
            C1684n.m55975c().m55969d(accessibilityService);
            if (Build.VERSION.SDK_INT < 30) {
                return;
            }
        }
        C1684n.m55975c().m55969d(accessibilityService);
    }

    /* renamed from: c */
    public static void m56541c(Activity activity, int i) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
        intent.setFlags(268435456);
        if (m56547a(intent, activity)) {
            activity.startActivityForResult(intent, i);
        } else {
            C1694ra.m55915b(f2796a, "Intent is not available!");
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: d */
    public static void m56540d(AccessibilityService accessibilityService) {
        String m56081b = C1663ca.m56080c().m56081b();
        C1694ra.m55917a(f2796a, m56081b);
        f2798c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(20000), C1652V.m56140a().m56132b(500), new C1515r(accessibilityService, m56081b));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    private static void m56539e(AccessibilityService accessibilityService) {
        m56546a(accessibilityService.getRootInActiveWindow());
    }
}
