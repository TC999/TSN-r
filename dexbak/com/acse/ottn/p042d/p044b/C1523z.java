package com.acse.ottn.p042d.p044b;

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
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.tencent.connect.common.Constants;
import java.util.List;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.b.z */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1523z {

    /* renamed from: a */
    private static final String f2808a = "OppoUtils";

    /* renamed from: c */
    public static TimerTask f2810c;

    /* renamed from: e */
    List<String> f2812e;

    /* renamed from: b */
    private static Long f2809b = 0L;

    /* renamed from: d */
    private static AccessibilityNodeInfo f2811d = null;

    /* renamed from: a */
    public static void m56537a(AccessibilityService accessibilityService, long j) {
        if (j - f2809b.longValue() < 1000) {
            C1694ra.m55917a(f2808a, "间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            C1694ra.m55917a(f2808a, "间隔 time=" + f2809b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f2809b.longValue()));
            return;
        }
        C1694ra.m55917a(f2808a, "无间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        C1694ra.m55917a(f2808a, "无间隔 time=" + f2809b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f2809b.longValue()));
        f2809b = Long.valueOf(j);
        C1684n.m55975c().m56005a(500L);
        f2810c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(TTAdConstant.STYLE_SIZE_RADIO_3_2), C1652V.m56140a().m56132b(500), new C1521x(accessibilityService));
    }

    /* renamed from: a */
    public static void m56536a(Activity activity) {
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        C1661ba.m56097a().m56092a("open_battery_white", true);
        Intent intent = new Intent();
        try {
            try {
                intent.setFlags(268435456);
                intent.putExtra(TTDownloadField.TT_PACKAGE_NAME, CommonUtil.PACKAGE_NAME);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                activity.startActivity(intent);
            } catch (Exception unused) {
                Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                intent2.setData(Uri.fromParts("package", CommonUtil.PACKAGE_NAME, null));
                activity.startActivity(intent2);
            }
        } catch (Exception unused2) {
            intent.setFlags(268435456);
            intent.putExtra(Constants.PARAM_PKG_NAME, CommonUtil.PACKAGE_NAME);
            intent.putExtra("app_name", C1663ca.m56080c().m56081b());
            intent.putExtra("class_name", "com.welab.notificationdemo.MainActivity");
            intent.setComponent(new ComponentName("com.coloros.notificationmanager", "com.coloros.notificationmanager.AppDetailPreferenceActivity"));
            activity.startActivity(intent);
        }
    }

    /* renamed from: a */
    public static void m56535a(Activity activity, int i) {
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
    public static void m56532a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null && "androidx.recyclerview.widget.RecyclerView".equals(accessibilityNodeInfo.getChild(i).getClassName())) {
                    f2811d = accessibilityNodeInfo.getChild(i);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56532a(accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m56534a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m56533a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: a */
    private static boolean m56533a(Context context, int i) {
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
        C1694ra.m55915b(f2808a, str);
        return false;
    }

    @RequiresApi(api = 16)
    /* renamed from: b */
    public static void m56531b(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, "耗电管理");
        AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(accessibilityService, "耗电保护");
        if (m55955g == null && m55955g2 == null) {
            C1517t.m56551a(accessibilityService);
            return;
        }
        if (m55955g != null) {
            C1694ra.m55917a(f2808a, "nodeInfo is null");
            C1684n.m55975c().m55958f(m55955g);
        } else {
            C1684n.m55975c().m55958f(m55955g2);
        }
        C1661ba.m56097a().m56092a("battery_white", true);
        m56537a(accessibilityService, System.currentTimeMillis());
    }

    @SuppressLint({"NewApi"})
    /* renamed from: b */
    public static void m56530b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if ((accessibilityNodeInfo == null || accessibilityNodeInfo.getChildCount() != 0) && accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56530b(accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    /* renamed from: c */
    public static void m56529c(AccessibilityService accessibilityService) {
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(50));
        if (C1684n.m55975c().m55953h(accessibilityService, C1663ca.m56080c().m56081b()) != null) {
            AccessibilityNodeInfo m55951j = C1684n.m55975c().m55951j(accessibilityService, "始终允许打开");
            if (m55951j != null) {
                C1684n.m55975c().m55958f(m55951j);
            }
            AccessibilityNodeInfo m55951j2 = C1684n.m55975c().m55951j(accessibilityService, "打开");
            if (m55951j2 != null) {
                C1684n.m55975c().m55958f(m55951j2);
            }
        }
    }

    /* renamed from: d */
    public static void m56528d(AccessibilityService accessibilityService) {
        f2810c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(20000), C1652V.m56140a().m56132b(100), new C1520w(accessibilityService, C1663ca.m56080c().m56081b()));
    }

    /* renamed from: e */
    public static void m56527e(AccessibilityService accessibilityService) {
        f2810c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(20000), C1652V.m56140a().m56132b(FontStyle.WEIGHT_NORMAL), new C1519v(accessibilityService, C1663ca.m56080c().m56081b()));
    }

    @RequiresApi(api = 16)
    /* renamed from: f */
    public static void m56526f(AccessibilityService accessibilityService) {
        f2810c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(20000), C1652V.m56140a().m56132b(100), new C1518u(accessibilityService, C1663ca.m56080c().m56081b()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public static void m56525g(AccessibilityService accessibilityService) {
        f2810c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(1000), C1652V.m56140a().m56132b(100), new C1522y(accessibilityService));
    }

    @SuppressLint({"NewApi"})
    /* renamed from: h */
    private static void m56524h(AccessibilityService accessibilityService) {
        m56532a(accessibilityService.getRootInActiveWindow());
    }

    @SuppressLint({"NewApi"})
    /* renamed from: i */
    private static void m56523i(AccessibilityService accessibilityService) {
        m56530b(accessibilityService.getRootInActiveWindow());
    }
}
