package com.acse.ottn.d;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.acse.ottn.util.A;
import com.acse.ottn.util.C1419ba;
import com.acse.ottn.util.C1442n;
import com.acse.ottn.util.ra;
import com.mbridge.msdk.MBridgeConstans;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private static j f5523a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f5524b = "OpenMobileLocationPermissionUtil";

    private j() {
    }

    public static j a() {
        if (f5523a == null) {
            synchronized (j.class) {
                if (f5523a == null) {
                    f5523a = new j();
                }
            }
        }
        return f5523a;
    }

    private Object b() throws ObjectStreamException {
        return f5523a;
    }

    public boolean a(AccessibilityService accessibilityService, String str) {
        ra.a(f5524b, "openPermission");
        if (str.contains(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && str.contains(".ui.GrantPermissionsActivity")) {
            A.b().c(accessibilityService);
            if (C1419ba.a().a("battery_white")) {
                C1419ba.a().a("battery_white", false);
                C1442n.c().a(300L);
                String d4 = C1419ba.a().d("location_permission_state");
                if (d4.equals("1")) {
                    AccessibilityNodeInfo a4 = C1442n.c().a(accessibilityService, "\u5141\u8bb8\u672c\u6b21\u4f7f\u7528", true);
                    if (a4 != null) {
                        C1442n.c().f(a4);
                        return true;
                    }
                    AccessibilityNodeInfo a5 = C1442n.c().a(accessibilityService, "\u4ec5\u5728\u4f7f\u7528\u4e2d\u5141\u8bb8", true);
                    if (a5 != null) {
                        C1442n.c().f(a5);
                        return true;
                    }
                    AccessibilityNodeInfo a6 = C1442n.c().a(accessibilityService, "\u4ec5\u4f7f\u7528\u671f\u95f4\u5141\u8bb8", true);
                    if (a6 != null) {
                        C1442n.c().f(a6);
                        return true;
                    }
                    AccessibilityNodeInfo a7 = C1442n.c().a(accessibilityService, "\u672c\u6b21\u4f7f\u7528\u5141\u8bb8", true);
                    if (a7 != null) {
                        C1442n.c().f(a7);
                        return true;
                    }
                    AccessibilityNodeInfo a8 = C1442n.c().a(accessibilityService, "\u672c\u6b21\u8fd0\u884c\u5141\u8bb8", true);
                    if (a8 != null) {
                        C1442n.c().f(a8);
                        return true;
                    }
                    AccessibilityNodeInfo a9 = C1442n.c().a(accessibilityService, "\u672c\u6b21\u4f7f\u7528\u65f6\u5141\u8bb8", true);
                    if (a9 != null) {
                        C1442n.c().f(a9);
                        return true;
                    }
                    AccessibilityNodeInfo a10 = C1442n.c().a(accessibilityService, "\u4ec5\u672c\u6b21\u4f7f\u7528\u65f6\u5141\u8bb8", true);
                    if (a10 != null) {
                        C1442n.c().f(a10);
                        return true;
                    }
                    AccessibilityNodeInfo a11 = C1442n.c().a(accessibilityService, "\u5141\u8bb8", true);
                    if (a11 != null) {
                        C1442n.c().f(a11);
                        return true;
                    }
                } else if (d4.equals("2")) {
                    AccessibilityNodeInfo h4 = C1442n.c().h(accessibilityService, "\u6743\u9650\u7ba1\u7406");
                    if (h4 != null) {
                        Rect rect = new Rect();
                        h4.getBoundsInScreen(rect);
                        int i4 = (rect.left + rect.right) / 2;
                        String str2 = f5524b;
                        ra.a(str2, "x=" + i4);
                        int i5 = rect.bottom;
                        int i6 = rect.top;
                        int i7 = ((i5 - i6) / 2) + i6;
                        if (Build.VERSION.SDK_INT >= 24) {
                            C1419ba.a().a("battery_white", true);
                            C1442n.c().a(accessibilityService, i4, i7);
                            ra.a(f5524b, "\u70b9\u51fb\u4e86");
                            return true;
                        }
                    }
                    AccessibilityNodeInfo h5 = C1442n.c().h(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8");
                    if (h5 != null) {
                        ra.a(f5524b, h5.toString());
                        if (h5.getText().equals("\u59cb\u7ec8\u5141\u8bb8")) {
                            C1442n.c().f(h5);
                            return true;
                        } else if (h5.getText().toString().equals("\u82e5\u540c\u610f\uff0c\u60a8\u53ef\u4ee5\u53bb\u8bbe\u7f6e\u4e3a\u59cb\u7ec8\u5141\u8bb8\u3002")) {
                            Rect rect2 = new Rect();
                            h5.getBoundsInScreen(rect2);
                            int i8 = rect2.right - rect2.left;
                            String str3 = f5524b;
                            ra.a(str3, "x=" + i8);
                            int i9 = rect2.bottom;
                            int i10 = rect2.top;
                            int i11 = ((i9 - i10) / 2) + i10;
                            if (Build.VERSION.SDK_INT >= 24) {
                                if (C1442n.c().a(accessibilityService, i8, i11)) {
                                    C1442n.c().a(1000L);
                                    C1442n.c().a(accessibilityService, i8, i11);
                                }
                                ra.a(f5524b, "\u70b9\u51fb\u4e86");
                                C1419ba.a().a("battery_white", true);
                            }
                            return true;
                        }
                    }
                    AccessibilityNodeInfo h6 = C1442n.c().h(accessibilityService, "\u5728\u201c\u8bbe\u7f6e\u201d\u4e2d\u5141\u8bb8");
                    if (h6 != null) {
                        ra.a(f5524b, "\u5728\u201c\u8bbe\u7f6e\u201d\u4e2d\u5141\u8bb8");
                        Rect rect3 = new Rect();
                        h6.getBoundsInScreen(rect3);
                        int i12 = (rect3.left + rect3.right) / 2;
                        String str4 = f5524b;
                        ra.a(str4, "x=" + i12);
                        int i13 = rect3.bottom + (-30);
                        if (Build.VERSION.SDK_INT >= 24) {
                            C1442n.c().a(accessibilityService, i12, i13);
                            ra.a(f5524b, "\u70b9\u51fb\u4e86");
                            C1419ba.a().a("battery_white", true);
                        }
                        return true;
                    }
                    AccessibilityNodeInfo h7 = C1442n.c().h(accessibilityService, "\u53bb\u8bbe\u4e3a\u59cb\u7ec8\u5141\u8bb8");
                    if (h7 != null) {
                        Rect rect4 = new Rect();
                        h7.getBoundsInScreen(rect4);
                        int i14 = (rect4.left + rect4.right) / 2;
                        String str5 = f5524b;
                        ra.a(str5, "x=" + i14);
                        int i15 = rect4.bottom + (-30);
                        if (Build.VERSION.SDK_INT >= 24) {
                            C1442n.c().a(accessibilityService, i14, i15);
                            ra.a(f5524b, "\u70b9\u51fb\u4e86");
                            C1419ba.a().a("battery_white", true);
                        }
                        return true;
                    }
                    AccessibilityNodeInfo a12 = C1442n.c().a(accessibilityService, "\u5141\u8bb8", true);
                    if (a12 != null) {
                        C1442n.c().f(a12);
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }
}
