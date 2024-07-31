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
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1648S;
import com.acse.ottn.util.C1652V;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1663ca;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import com.autonavi.base.p048ae.gmap.glyph.FontStyle;
import java.util.TimerTask;

/* renamed from: com.acse.ottn.d.b.F */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1497F {

    /* renamed from: a */
    private static final String f2749a = "acse_VivoUtils";

    /* renamed from: c */
    public static TimerTask f2751c;

    /* renamed from: b */
    private static Long f2750b = 0L;

    /* renamed from: d */
    private static AccessibilityNodeInfo f2752d = null;

    @RequiresApi(api = 16)
    /* renamed from: a */
    public static void m56641a(AccessibilityService accessibilityService, long j) {
        C1661ba.m56097a().m56092a("battery_white", false);
        if (j - f2750b.longValue() < 5000) {
            C1694ra.m55917a(f2749a, "间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            C1694ra.m55917a(f2749a, "间隔 time=" + f2750b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f2750b.longValue()));
            return;
        }
        C1694ra.m55917a(f2749a, "无间隔 t=" + j + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        C1694ra.m55917a(f2749a, "无间隔 time=" + f2750b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f2750b.longValue()));
        f2750b = Long.valueOf(j);
        C1694ra.m55917a(f2749a, "buttery backgroundHightBattery");
        f2751c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(5000), C1652V.m56140a().m56132b(FontStyle.WEIGHT_NORMAL), new C1496E(accessibilityService, C1663ca.m56080c().m56081b()));
    }

    @RequiresApi(api = 16)
    /* renamed from: a */
    public static void m56640a(AccessibilityService accessibilityService, boolean z) {
        f2751c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(15000), C1652V.m56140a().m56132b(100), new C1495D(accessibilityService, C1663ca.m56080c().m56081b(), z));
    }

    /* renamed from: a */
    public static void m56639a(Activity activity) {
        try {
            if (C1661ba.m56097a() != null) {
                C1661ba.m56097a().m56092a("background_battery_hignt", true);
                C1661ba.m56097a().m56092a("battery_white", true);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.iqoo.powersaving", "com.iqoo.powersaving.PowerSavingManagerActivity"));
            activity.startActivityForResult(intent, 10014);
        } catch (Exception e) {
            C1694ra.m55917a(f2749a, e.getMessage());
            CommonUtil.setServiceHightButteryState(true);
        }
    }

    /* renamed from: a */
    public static void m56638a(Activity activity, int i) {
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
    public static void m56635a(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
                if (accessibilityNodeInfo.getChild(i) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i).getClassName())) {
                    f2752d = accessibilityNodeInfo.getChild(i);
                    return;
                }
                if (accessibilityNodeInfo.getChild(i) != null) {
                    m56635a(accessibilityNodeInfo.getChild(i));
                }
            }
        }
    }

    /* renamed from: a */
    public static boolean m56637a(Context context) {
        if (Build.VERSION.SDK_INT >= 19) {
            return m56636a(context, 24);
        }
        return true;
    }

    @TargetApi(19)
    /* renamed from: a */
    private static boolean m56636a(Context context, int i) {
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
        C1694ra.m55915b(f2749a, str);
        return false;
    }

    /* renamed from: b */
    public static void m56634b(AccessibilityService accessibilityService) {
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, "自启动");
        if (m55955g != null && m55955g.getParent() != null) {
            C1694ra.m55917a(f2749a, "find auto start");
            for (int i = 0; i < m55955g.getParent().getChildCount(); i++) {
                if (m55955g.getParent().getChild(i) != null && "android.widget.Switch".equals(m55955g.getParent().getChild(i).getClassName()) && !m55955g.getParent().getChild(i).isChecked()) {
                    Rect rect = new Rect();
                    m55955g.getParent().getChild(i).getBoundsInScreen(rect);
                    int i2 = rect.right;
                    int i3 = rect.left;
                    int i4 = ((i2 - i3) / 2) + i3;
                    int i5 = rect.bottom;
                    int i6 = rect.top;
                    int i7 = ((i5 - i6) / 2) + i6;
                    if (Build.VERSION.SDK_INT >= 24) {
                        C1684n.m55975c().m56002a(accessibilityService, i4, i7);
                    }
                }
            }
            CommonUtil.setButteryState(true);
        }
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
        AccessibilityNodeInfo m55955g2 = C1684n.m55975c().m55955g(accessibilityService, "悬浮窗");
        if (m55955g2 != null && m55955g2.getParent() != null) {
            C1694ra.m55917a(f2749a, "find flow window");
            for (int i8 = 0; i8 < m55955g2.getParent().getChildCount(); i8++) {
                if (m55955g2.getParent().getChild(i8) != null && "android.widget.Switch".equals(m55955g2.getParent().getChild(i8).getClassName()) && !m55955g2.getParent().getChild(i8).isChecked()) {
                    Rect rect2 = new Rect();
                    m55955g2.getParent().getChild(i8).getBoundsInScreen(rect2);
                    int i9 = rect2.right;
                    int i10 = rect2.left;
                    int i11 = ((i9 - i10) / 2) + i10;
                    int i12 = rect2.bottom;
                    int i13 = rect2.top;
                    int i14 = ((i12 - i13) / 2) + i13;
                    if (Build.VERSION.SDK_INT >= 24) {
                        C1684n.m55975c().m56002a(accessibilityService, i11, i14);
                    }
                }
            }
        }
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
        AccessibilityNodeInfo m55955g3 = C1684n.m55975c().m55955g(accessibilityService, "后台弹出界面");
        if (m55955g3 != null && m55955g3.getParent() != null) {
            for (int i15 = 0; i15 < m55955g3.getParent().getChildCount(); i15++) {
                if (m55955g3.getParent().getChild(i15) != null && "android.widget.Switch".equals(m55955g3.getParent().getChild(i15).getClassName()) && !m55955g3.getParent().getChild(i15).isChecked()) {
                    Rect rect3 = new Rect();
                    m55955g3.getParent().getChild(i15).getBoundsInScreen(rect3);
                    int i16 = rect3.right;
                    int i17 = rect3.left;
                    int i18 = ((i16 - i17) / 2) + i17;
                    int i19 = rect3.bottom;
                    int i20 = rect3.top;
                    int i21 = ((i19 - i20) / 2) + i20;
                    if (Build.VERSION.SDK_INT >= 24) {
                        C1684n.m55975c().m56002a(accessibilityService, i18, i21);
                    }
                }
            }
        }
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
        C1684n.m55975c().m55969d(accessibilityService);
    }

    /* renamed from: b */
    public static void m56633b(Activity activity) {
        Intent intent;
        String str;
        if (C1661ba.m56097a() != null) {
            C1661ba.m56097a().m56092a("battery_white", true);
        }
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        try {
            String m56093a = C1661ba.m56097a().m56093a("flow_window_state", "1");
            if (!C1638Ka.m56193b().equals("vivo") || m56093a.equals("2")) {
                intent = new Intent();
                intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity");
                str = CommonUtil.PACKAGE_NAME;
            } else {
                C1661ba.m56097a().m56088b("flow_window_state", "2");
                intent = new Intent();
                intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity");
                str = CommonUtil.PACKAGE_NAME;
            }
            intent.putExtra("packagename", str);
            intent.putExtra("tabId", "1");
            activity.startActivityForResult(intent, 10013);
        } catch (Exception unused) {
            Intent intent2 = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent2.setData(Uri.fromParts("package", CommonUtil.PACKAGE_NAME, null));
            activity.startActivityForResult(intent2, 10013);
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: c */
    public static void m56632c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo m55955g = C1684n.m55975c().m55955g(accessibilityService, "允许显示在其他应用的上层");
        if (m55955g != null || m55955g.getParent() == null) {
            for (int i = 0; i < m55955g.getParent().getChildCount(); i++) {
                if (m55955g.getParent().getChild(i) != null && "android.widget.Switch".equals(m55955g.getParent().getChild(i).getClassName())) {
                    C1684n.m55975c().m55958f(m55955g.getParent().getChild(i));
                    C1684n.m55975c().m55969d(accessibilityService);
                    return;
                }
            }
        }
    }

    /* renamed from: d */
    public static void m56631d(AccessibilityService accessibilityService) {
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(200));
        AccessibilityNodeInfo m55951j = C1684n.m55975c().m55951j(accessibilityService, "后台耗电管理");
        AccessibilityNodeInfo m55951j2 = C1684n.m55975c().m55951j(accessibilityService, "后台高耗电");
        if (m55951j != null) {
            C1694ra.m55917a(f2749a, "clickServiceBackgroundHight info is not null");
            if (C1661ba.m56097a() != null) {
                C1661ba.m56097a().m56092a("battery_white", true);
            }
            C1684n.m55975c().m55958f(m55951j);
        } else if (m55951j2 == null) {
            return;
        } else {
            C1694ra.m55917a(f2749a, "clickServiceBackgroundHight info2 is not null");
            if (C1661ba.m56097a() != null) {
                C1694ra.m55917a(f2749a, "clickServiceBackgroundHight HelpShopSharedPreferencesUtils is not null");
                C1661ba.m56097a().m56092a("battery_white", true);
            }
            C1684n.m55975c().m55958f(m55951j2);
        }
        C1684n.m55975c().m56005a(1000L);
        m56641a(accessibilityService, Long.valueOf(System.currentTimeMillis()).longValue());
    }

    /* renamed from: e */
    public static void m56630e(AccessibilityService accessibilityService) {
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(50));
        if (C1684n.m55975c().m55953h(accessibilityService, C1663ca.m56080c().m56081b()) != null) {
            AccessibilityNodeInfo m55951j = C1684n.m55975c().m55951j(accessibilityService, "始终打开");
            if (m55951j != null) {
                C1684n.m55975c().m55958f(m55951j);
            } else {
                C1684n.m55975c().m55952i(accessibilityService, "允许");
            }
        }
    }

    /* renamed from: f */
    public static void m56629f(AccessibilityService accessibilityService) {
        C1684n.m55975c().m55958f(C1684n.m55975c().m55996a(accessibilityService, "权限", true));
        C1684n.m55975c().m56005a(C1652V.m56140a().m56132b(500));
        AccessibilityNodeInfo m55996a = C1684n.m55975c().m55996a(accessibilityService, "自启动", true);
        if (m55996a != null) {
            C1684n.m55975c().m55958f(m55996a);
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: g */
    public static void m56628g(AccessibilityService accessibilityService) {
        String m56081b = C1663ca.m56080c().m56081b();
        C1694ra.m55917a(f2749a, m56081b);
        f2751c = C1648S.m56165a().m56163b(C1652V.m56140a().m56132b(20000), C1652V.m56140a().m56132b(100), new C1494C(accessibilityService, m56081b));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    /* renamed from: h */
    public static void m56627h(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        }
        m56635a(rootInActiveWindow);
    }
}
