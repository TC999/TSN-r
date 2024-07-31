package com.acse.ottn.p042d.p044b;

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
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.connect.common.Constants;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.b.q */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1514q {

    /* renamed from: a */
    private static final String f2789a = "NubiaUtils";

    /* renamed from: b */
    public static TimerTask f2790b;

    /* renamed from: c */
    private static AccessibilityNodeInfo f2791c;

    /* renamed from: a */
    public static void m56565a(Activity activity) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        Intent intent = new Intent();
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra(TTDownloadField.TT_PACKAGE_NAME, CommonUtil.PACKAGE_NAME);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivityForResult(intent, 10013);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", CommonUtil.PACKAGE_NAME, null));
                activity.startActivityForResult(intent2, 10013);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra(Constants.PARAM_PKG_NAME, CommonUtil.PACKAGE_NAME);
            intent.putExtra("app_name", C1663ca.m56080c().m56081b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivityForResult(intent, 10013);
        }
    }

    /* renamed from: a */
    public static void m56564a(Activity activity, int i) {
        try {
            Intent intent = new Intent();
            intent.setFlags(268435456);
            intent.setComponent(new ComponentName("com.coloros.safecenter", "com.coloros.safecenter.sysfloatwindow.FloatWindowListActivity"));
            activity.startActivityForResult(intent, i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    public static void m56561a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if ("android.support.v7.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i).getClassName())) {
                    f2791c = accessibilityNodeInfo.getChild(i);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56561a(accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m56563a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m56562a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: a */
    private static boolean m56562a(Context context, int i) {
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
        C1694ra.m55915b(f2789a, str);
        return false;
    }

    @RequiresApi(api = 16)
    /* renamed from: c */
    public static void m56558c(ShopHelperService shopHelperService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(shopHelperService, "耗电管理");
        AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(shopHelperService, "耗电保护");
        if (m55955g == null && m55955g2 == null) {
            return;
        }
        if (C1661ba.m56097a() != null) {
            C1661ba.m56097a().m56092a("battery_white", true);
        }
        if (m55955g != null) {
            C1684n.m55975c().m55958f(m55955g);
        } else {
            C1684n.m55975c().m55958f(m55955g2);
        }
        f2790b = C1648S.m56165a().m56163b(TTAdConstant.STYLE_SIZE_RADIO_3_2, 200, new C1512o(shopHelperService));
    }

    @RequiresApi(api = 16)
    /* renamed from: d */
    public static void m56557d(ShopHelperService shopHelperService) {
        if (C1684n.m55975c().m55984b()) {
            C1694ra.m55917a(f2789a, "悬浮窗权限已开启");
            return;
        }
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(shopHelperService, "允许显示在其他应用的上层");
        if (m55955g == null) {
            return;
        }
        C1684n.m55975c().m55958f(m55955g);
        C1684n.m55975c().m55969d(shopHelperService);
        if (Build.VERSION.SDK_INT >= 30) {
            C1684n.m55975c().m55969d(shopHelperService);
        }
    }

    /* renamed from: e */
    public static void m56556e(ShopHelperService shopHelperService) {
        if (C1684n.m55975c().m55984b()) {
            C1694ra.m55917a(f2789a, "悬浮窗权限已开启");
            return;
        }
        f2790b = C1648S.m56165a().m56163b(20000, 100, new C1511n(shopHelperService, C1663ca.m56080c().m56081b()));
    }

    @RequiresApi(api = 16)
    /* renamed from: f */
    public static void m56555f(ShopHelperService shopHelperService) {
        if (C1684n.m55975c().m55984b()) {
            C1694ra.m55917a(f2789a, "悬浮窗权限已开启");
            return;
        }
        f2790b = C1648S.m56165a().m56163b(20000, 100, new C1510m(shopHelperService, C1663ca.m56080c().m56081b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static void m56554g(ShopHelperService shopHelperService) {
        f2790b = C1648S.m56165a().m56163b(1000, 100, new C1513p(shopHelperService));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: h */
    public static void m56553h(ShopHelperService shopHelperService) {
        m56561a(shopHelperService.getRootInActiveWindow());
    }
}
