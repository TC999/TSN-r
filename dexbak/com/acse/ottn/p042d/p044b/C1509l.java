package com.acse.ottn.p042d.p044b;

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
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.b.l */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1509l {

    /* renamed from: a */
    private static final String f2779a = "acse_MiuiUtils";

    /* renamed from: b */
    private static boolean f2780b;

    /* renamed from: c */
    public static TimerTask f2781c;

    /* renamed from: d */
    private static AccessibilityNodeInfo f2782d;

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m56591a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if ((accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) && accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56591a(accessibilityService, accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    /* renamed from: a */
    public static void m56590a(Activity activity) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        try {
            Intent intent = new Intent();
            ComponentName componentName = new ComponentName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
            intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
            intent.setComponent(componentName);
            intent.addFlags(268435456);
            C1661ba.m56097a().m56092a("battery_white", true);
            activity.startActivityForResult(intent, 10013);
        } catch (Exception unused) {
            CommonUtil.setButteryState(true);
        }
    }

    /* renamed from: a */
    public static void m56589a(Activity activity, int i) {
        int m56583b = m56583b();
        if (m56583b == 5) {
            m56580b(activity, i);
        } else if (m56583b == 6) {
            m56575c(activity, i);
        } else if (m56583b == 7) {
            m56573d(activity, i);
        } else if (m56583b == 8) {
            m56571e(activity, i);
        } else {
            C1694ra.m55915b(f2779a, "this is a special MIUI rom version, its version code " + m56583b);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m56585a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            if (accessibilityNodeInfo.getChild(i) != null) {
                if ("androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getClassName())) {
                    f2782d = accessibilityNodeInfo;
                    return;
                }
                m56585a(accessibilityNodeInfo.getChild(i));
            }
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: a */
    public static void m56584a(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, str);
        if (m55955g == null || m55955g.getParent() == null) {
            return;
        }
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

    /* renamed from: a */
    public static boolean m56588a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m56587a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: a */
    private static boolean m56587a(Context context, int i) {
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
        C1694ra.m55915b(f2779a, str);
        return false;
    }

    /* renamed from: a */
    private static boolean m56586a(Intent intent, Activity activity) {
        return (intent == null || activity == null || activity.getPackageManager().queryIntentActivities(intent, 65536).size() <= 0) ? false : true;
    }

    /* renamed from: b */
    public static int m56583b() {
        String m56650a = C1493B.m56650a("ro.miui.ui.version.name");
        if (m56650a != null) {
            try {
                return Integer.parseInt(m56650a.substring(1));
            } catch (Exception e) {
                C1694ra.m55915b(f2779a, "get miui version code error, version : " + m56650a);
                C1694ra.m55915b(f2779a, Log.getStackTraceString(e));
                return -1;
            }
        }
        return -1;
    }

    @RequiresApi(api = 16)
    /* renamed from: b */
    public static void m56582b(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, "自启动");
        if (m55955g == null) {
            return;
        }
        C1684n.m55975c().m55958f(m55955g);
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(300));
        m56584a("允许系统唤醒", accessibilityService);
        C1684n.m55975c().m55969d(accessibilityService);
        C1661ba.m56097a().m56092a("battery_white", false);
        C1684n.m55975c().m55969d(accessibilityService);
    }

    /* renamed from: b */
    public static void m56581b(Activity activity) {
        m56576c(activity);
    }

    /* renamed from: b */
    public static void m56580b(Activity activity, int i) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        String str = CommonUtil.PACKAGE_NAME;
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", str, null));
        intent.setFlags(268435456);
        if (m56586a(intent, activity)) {
            activity.startActivityForResult(intent, i);
        } else {
            C1694ra.m55915b(f2779a, "intent is not available!");
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public static void m56579b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null && accessibilityNodeInfo.getChildCount() == 0) {
            TextUtils.isEmpty(accessibilityNodeInfo.getText());
        } else if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56579b(accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: b */
    public static void m56578b(String str, AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, str);
        if (m55955g == null || m55955g.getParent() == null) {
            return;
        }
        for (int i = 0; i < m55955g.getParent().getChildCount(); i++) {
            if (m55955g.getParent().getChild(i) != null && "android.widget.CheckBox".equals(m55955g.getParent().getChild(i).getClassName())) {
                C1694ra.m55917a("samon-->", "android.widget.CheckBox=" + m55955g.getParent().getChild(i).toString());
                if (!m55955g.getParent().getChild(i).isChecked()) {
                    C1684n.m55975c().m55958f(m55955g.getParent().getChild(i));
                    C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(100));
                    AccessibilityNodeInfo m55951j = C1684n.m55975c().m55951j(ShopHelperService.mService, "确定");
                    AccessibilityNodeInfo m55951j2 = C1684n.m55975c().m55951j(ShopHelperService.mService, "知道了");
                    if (m55951j != null) {
                        C1694ra.m55917a("samon-->", "commitInfo is not null");
                        C1684n.m55975c().m55958f(m55951j);
                    } else if (m55951j2 != null) {
                        C1694ra.m55917a("samon-->", "commitInfo1 is not null");
                        C1684n.m55975c().m55958f(m55951j2);
                    }
                    CommonUtil.setServiceHightButteryState(true);
                }
                C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(100));
                C1684n.m55975c().m55969d(accessibilityService);
                return;
            }
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: c */
    public static void m56577c(AccessibilityService accessibilityService) {
        C1684n.m55975c().m56005a(500L);
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, "其他权限");
        if (m55955g != null) {
            C1694ra.m55917a("samonp-->", "appNodeInfo is not null=");
            C1684n.m55975c().m55958f(m55955g);
            C1661ba.m56097a().m56092a("battery_white", true);
            C1661ba.m56097a().m56092a("is_pengpai", true);
            return;
        }
        TimerTask timerTask = f2781c;
        if (timerTask != null) {
            timerTask.cancel();
            f2781c = null;
        }
        String m56086d = C1661ba.m56097a().m56086d("OpenPermissionName");
        C1694ra.m55917a("samonp-->", "找到了悬浮窗=" + m56086d);
        f2781c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(2000), C1652V.m56140a().m56132b(300), new C1508k(m56086d, accessibilityService));
    }

    /* renamed from: c */
    private static void m56576c(Activity activity) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        C1661ba.m56097a().m56092a("battery_white", true);
        C1661ba.m56097a().m56092a("background_battery_hignt", true);
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", CommonUtil.PACKAGE_NAME, null));
        try {
            activity.startActivityForResult(intent, 10015);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public static void m56575c(Activity activity, int i) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
        intent.setFlags(268435456);
        if (m56586a(intent, activity)) {
            activity.startActivityForResult(intent, i);
        } else {
            C1694ra.m55915b(f2779a, "Intent is not available!");
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: d */
    public static void m56574d(AccessibilityService accessibilityService) {
        C1684n.m55975c().m56005a(200L);
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, "允许显示在其他应用的上层");
        if (m55955g == null) {
            AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(accessibilityService, "显示在其他应用的上层");
            AccessibilityNodeInfo m55955g3 = C1684n.m55975c().m55955g(accessibilityService, "允许此应用显示在您当前使用的其他应用的上层。此应用将能得知您点按的位置或更改屏幕上显示的内容。");
            Rect rect = new Rect();
            m55955g2.getBoundsInScreen(rect);
            Rect rect2 = new Rect();
            m55955g3.getBoundsInScreen(rect2);
            int i = rect.right / 2;
            int i2 = rect2.top;
            int i3 = rect.bottom;
            int i4 = ((i2 - i3) / 2) + i3;
            if (Build.VERSION.SDK_INT >= 24) {
                C1684n.m55975c().m56002a(accessibilityService, i, i4);
                C1694ra.m55917a(f2779a, "点击了");
            }
        } else {
            C1684n.m55975c().m55958f(m55955g);
        }
        C1684n.m55975c().m56005a(300L);
        C1684n.m55975c().m55969d(accessibilityService);
        if (Build.VERSION.SDK_INT >= 30) {
            C1684n.m55975c().m55969d(accessibilityService);
        }
    }

    /* renamed from: d */
    public static void m56573d(Activity activity, int i) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.AppPermissionsEditorActivity");
        intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
        intent.setFlags(268435456);
        if (m56586a(intent, activity)) {
            activity.startActivityForResult(intent, i);
        } else {
            C1694ra.m55915b(f2779a, "Intent is not available!");
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: e */
    public static void m56572e(AccessibilityService accessibilityService) {
        m56591a(accessibilityService, accessibilityService.getRootInActiveWindow());
    }

    /* renamed from: e */
    public static void m56571e(Activity activity, int i) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        C1661ba.m56097a().m56092a("battery_white", true);
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.setClassName("com.miui.securitycenter", "com.miui.permcenter.permissions.PermissionsEditorActivity");
        intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
        intent.setFlags(268435456);
        if (!m56586a(intent, activity)) {
            intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
            intent.setPackage("com.miui.securitycenter");
            intent.putExtra("extra_pkgname", CommonUtil.PACKAGE_NAME);
            intent.setFlags(268435456);
            if (!m56586a(intent, activity)) {
                C1694ra.m55915b(f2779a, "Intent is not available!");
                return;
            }
        }
        try {
            activity.startActivityForResult(intent, i);
        } catch (Exception unused) {
            CommonUtil.setButteryState(true);
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: f */
    public static void m56570f(AccessibilityService accessibilityService) {
        m56579b(accessibilityService.getRootInActiveWindow());
    }

    @RequiresApi(api = 16)
    /* renamed from: g */
    public static void m56569g(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, "允许系统唤醒");
        AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(accessibilityService, "允许被其他应用唤醒");
        int i = 0;
        if (m55955g != null && m55955g.getParent() != null) {
            int i2 = 0;
            while (true) {
                if (i2 >= m55955g.getParent().getChildCount()) {
                    break;
                } else if (m55955g.getParent().getChild(i2) == null || !"android.widget.CheckBox".equals(m55955g.getParent().getChild(i2).getClassName())) {
                    i2++;
                } else if (!m55955g.getParent().getChild(i2).isChecked()) {
                    C1684n.m55975c().m55958f(m55955g);
                }
            }
        }
        if (m55955g2 != null && m55955g2.getParent() != null) {
            while (true) {
                if (i >= m55955g2.getParent().getChildCount()) {
                    break;
                } else if (m55955g2.getParent().getChild(i) == null || !"android.widget.CheckBox".equals(m55955g2.getParent().getChild(i).getClassName())) {
                    i++;
                } else if (!m55955g2.getParent().getChild(i).isChecked()) {
                    C1684n.m55975c().m55958f(m55955g2);
                }
            }
        }
        C1684n.m55975c().m55969d(accessibilityService);
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
        C1684n.m55975c().m55969d(accessibilityService);
        CommonUtil.setServiceHightButteryState(true);
    }

    @RequiresApi(api = 16)
    /* renamed from: h */
    public static void m56568h(AccessibilityService accessibilityService) {
        String m56081b = C1663ca.m56080c().m56081b();
        C1694ra.m55917a(f2779a, m56081b);
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(500));
        f2781c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(20000), C1652V.m56140a().m56132b(100), new C1507j(accessibilityService, m56081b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: i */
    public static void m56567i(AccessibilityService accessibilityService) {
        m56585a(accessibilityService.getRootInActiveWindow());
    }
}
