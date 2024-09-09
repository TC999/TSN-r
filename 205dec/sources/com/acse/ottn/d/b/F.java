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
import android.util.Log;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1421ca;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.CommonUtil;
import com.acse.ottn.util.Ka;
import com.acse.ottn.util.S;
import com.acse.ottn.util.V;
import com.acse.ottn.util.ra;
import java.util.TimerTask;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class F {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5424a = "acse_VivoUtils";

    /* renamed from: c  reason: collision with root package name */
    public static TimerTask f5426c;

    /* renamed from: b  reason: collision with root package name */
    private static Long f5425b = 0L;

    /* renamed from: d  reason: collision with root package name */
    private static AccessibilityNodeInfo f5427d = null;

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, long j4) {
        C1419ba.a().a("battery_white", false);
        if (j4 - f5425b.longValue() < 5000) {
            ra.a("acse_VivoUtils", "\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
            ra.a("acse_VivoUtils", "\u95f4\u9694 time=" + f5425b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5425b.longValue()));
            return;
        }
        ra.a("acse_VivoUtils", "\u65e0\u95f4\u9694 t=" + j4 + "   System.currentTimeMillis() =" + System.currentTimeMillis());
        ra.a("acse_VivoUtils", "\u65e0\u95f4\u9694 time=" + f5425b + "   System.currentTimeMillis()-time =" + (System.currentTimeMillis() - f5425b.longValue()));
        f5425b = Long.valueOf(j4);
        ra.a("acse_VivoUtils", "buttery backgroundHightBattery");
        f5426c = S.a().b(V.a().b(5000), V.a().b(400), new E(accessibilityService, C1421ca.c().b()));
    }

    @RequiresApi(api = 16)
    public static void a(AccessibilityService accessibilityService, boolean z3) {
        f5426c = S.a().b(V.a().b(15000), V.a().b(100), new D(accessibilityService, C1421ca.c().b(), z3));
    }

    public static void a(Activity activity) {
        try {
            if (C1419ba.a() != null) {
                C1419ba.a().a("background_battery_hignt", true);
                C1419ba.a().a("battery_white", true);
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.iqoo.powersaving", "com.iqoo.powersaving.PowerSavingManagerActivity"));
            activity.startActivityForResult(intent, 10014);
        } catch (Exception e4) {
            ra.a("acse_VivoUtils", e4.getMessage());
            CommonUtil.setServiceHightButteryState(true);
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
                if (accessibilityNodeInfo.getChild(i4) != null && "android.widget.ListView".equals(accessibilityNodeInfo.getChild(i4).getClassName())) {
                    f5427d = accessibilityNodeInfo.getChild(i4);
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
        ra.b("acse_VivoUtils", str);
        return false;
    }

    public static void b(AccessibilityService accessibilityService) {
        C1442n.c().a(V.a().b(200));
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, "\u81ea\u542f\u52a8");
        if (g4 != null && g4.getParent() != null) {
            ra.a("acse_VivoUtils", "find auto start");
            for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
                if (g4.getParent().getChild(i4) != null && "android.widget.Switch".equals(g4.getParent().getChild(i4).getClassName()) && !g4.getParent().getChild(i4).isChecked()) {
                    Rect rect = new Rect();
                    g4.getParent().getChild(i4).getBoundsInScreen(rect);
                    int i5 = rect.right;
                    int i6 = rect.left;
                    int i7 = ((i5 - i6) / 2) + i6;
                    int i8 = rect.bottom;
                    int i9 = rect.top;
                    int i10 = ((i8 - i9) / 2) + i9;
                    if (Build.VERSION.SDK_INT >= 24) {
                        C1442n.c().a(accessibilityService, i7, i10);
                    }
                }
            }
            CommonUtil.setButteryState(true);
        }
        C1442n.c().a(V.a().b(200));
        AccessibilityNodeInfo g5 = C1442n.c().g(accessibilityService, "\u60ac\u6d6e\u7a97");
        if (g5 != null && g5.getParent() != null) {
            ra.a("acse_VivoUtils", "find flow window");
            for (int i11 = 0; i11 < g5.getParent().getChildCount(); i11++) {
                if (g5.getParent().getChild(i11) != null && "android.widget.Switch".equals(g5.getParent().getChild(i11).getClassName()) && !g5.getParent().getChild(i11).isChecked()) {
                    Rect rect2 = new Rect();
                    g5.getParent().getChild(i11).getBoundsInScreen(rect2);
                    int i12 = rect2.right;
                    int i13 = rect2.left;
                    int i14 = ((i12 - i13) / 2) + i13;
                    int i15 = rect2.bottom;
                    int i16 = rect2.top;
                    int i17 = ((i15 - i16) / 2) + i16;
                    if (Build.VERSION.SDK_INT >= 24) {
                        C1442n.c().a(accessibilityService, i14, i17);
                    }
                }
            }
        }
        C1442n.c().a(V.a().b(200));
        AccessibilityNodeInfo g6 = C1442n.c().g(accessibilityService, "\u540e\u53f0\u5f39\u51fa\u754c\u9762");
        if (g6 != null && g6.getParent() != null) {
            for (int i18 = 0; i18 < g6.getParent().getChildCount(); i18++) {
                if (g6.getParent().getChild(i18) != null && "android.widget.Switch".equals(g6.getParent().getChild(i18).getClassName()) && !g6.getParent().getChild(i18).isChecked()) {
                    Rect rect3 = new Rect();
                    g6.getParent().getChild(i18).getBoundsInScreen(rect3);
                    int i19 = rect3.right;
                    int i20 = rect3.left;
                    int i21 = ((i19 - i20) / 2) + i20;
                    int i22 = rect3.bottom;
                    int i23 = rect3.top;
                    int i24 = ((i22 - i23) / 2) + i23;
                    if (Build.VERSION.SDK_INT >= 24) {
                        C1442n.c().a(accessibilityService, i21, i24);
                    }
                }
            }
        }
        C1442n.c().a(V.a().b(200));
        C1442n.c().d(accessibilityService);
    }

    public static void b(Activity activity) {
        Intent intent;
        String str;
        if (C1419ba.a() != null) {
            C1419ba.a().a("battery_white", true);
        }
        if ("".equals(CommonUtil.PACKAGE_NAME)) {
            return;
        }
        try {
            String a4 = C1419ba.a().a("flow_window_state", "1");
            if (!Ka.b().equals("vivo") || a4.equals("2")) {
                intent = new Intent();
                intent.setClassName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.BgStartUpManagerActivity");
                str = CommonUtil.PACKAGE_NAME;
            } else {
                C1419ba.a().b("flow_window_state", "2");
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
    public static void c(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo g4 = C1442n.c().g(accessibilityService, "\u5141\u8bb8\u663e\u793a\u5728\u5176\u4ed6\u5e94\u7528\u7684\u4e0a\u5c42");
        if (g4 != null || g4.getParent() == null) {
            for (int i4 = 0; i4 < g4.getParent().getChildCount(); i4++) {
                if (g4.getParent().getChild(i4) != null && "android.widget.Switch".equals(g4.getParent().getChild(i4).getClassName())) {
                    C1442n.c().f(g4.getParent().getChild(i4));
                    C1442n.c().d(accessibilityService);
                    return;
                }
            }
        }
    }

    public static void d(AccessibilityService accessibilityService) {
        C1442n.c().a(V.a().b(200));
        AccessibilityNodeInfo j4 = C1442n.c().j(accessibilityService, "\u540e\u53f0\u8017\u7535\u7ba1\u7406");
        AccessibilityNodeInfo j5 = C1442n.c().j(accessibilityService, "\u540e\u53f0\u9ad8\u8017\u7535");
        if (j4 != null) {
            ra.a("acse_VivoUtils", "clickServiceBackgroundHight info is not null");
            if (C1419ba.a() != null) {
                C1419ba.a().a("battery_white", true);
            }
            C1442n.c().f(j4);
        } else if (j5 == null) {
            return;
        } else {
            ra.a("acse_VivoUtils", "clickServiceBackgroundHight info2 is not null");
            if (C1419ba.a() != null) {
                ra.a("acse_VivoUtils", "clickServiceBackgroundHight HelpShopSharedPreferencesUtils is not null");
                C1419ba.a().a("battery_white", true);
            }
            C1442n.c().f(j5);
        }
        C1442n.c().a(1000L);
        a(accessibilityService, Long.valueOf(System.currentTimeMillis()).longValue());
    }

    public static void e(AccessibilityService accessibilityService) {
        C1442n.c().a(V.a().b(50));
        if (C1442n.c().h(accessibilityService, C1421ca.c().b()) != null) {
            AccessibilityNodeInfo j4 = C1442n.c().j(accessibilityService, "\u59cb\u7ec8\u6253\u5f00");
            if (j4 != null) {
                C1442n.c().f(j4);
            } else {
                C1442n.c().i(accessibilityService, "\u5141\u8bb8");
            }
        }
    }

    public static void f(AccessibilityService accessibilityService) {
        C1442n.c().f(C1442n.c().a(accessibilityService, "\u6743\u9650", true));
        C1442n.c().a(V.a().b(500));
        AccessibilityNodeInfo a4 = C1442n.c().a(accessibilityService, "\u81ea\u542f\u52a8", true);
        if (a4 != null) {
            C1442n.c().f(a4);
        }
    }

    @RequiresApi(api = 16)
    public static void g(AccessibilityService accessibilityService) {
        String b4 = C1421ca.c().b();
        ra.a("acse_VivoUtils", b4);
        f5426c = S.a().b(V.a().b(20000), V.a().b(100), new C(accessibilityService, b4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"NewApi"})
    public static void h(AccessibilityService accessibilityService) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        }
        a(rootInActiveWindow);
    }
}
