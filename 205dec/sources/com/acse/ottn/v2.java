package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.graphics.Rect;
import android.os.Build;
import android.view.accessibility.AccessibilityNodeInfo;
import com.mbridge.msdk.MBridgeConstans;
import java.io.ObjectStreamException;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class v2 {

    /* renamed from: a  reason: collision with root package name */
    public static v2 f6911a = null;

    /* renamed from: b  reason: collision with root package name */
    public static String f6912b = "OpenMobileLocationPermissionUtil";

    public static v2 a() {
        if (f6911a == null) {
            synchronized (v2.class) {
                if (f6911a == null) {
                    f6911a = new v2();
                }
            }
        }
        return f6911a;
    }

    public final Object b() throws ObjectStreamException {
        return f6911a;
    }

    public boolean a(AccessibilityService accessibilityService, String str) {
        z1.a(f6912b, "openPermission");
        if (str.contains(MBridgeConstans.APPLICATION_STACK_COM_ANDROID) && str.contains(".ui.GrantPermissionsActivity")) {
            d.b().d(accessibilityService);
            if (g1.a().a("battery_white")) {
                g1.a().a("battery_white", false);
                b.d().a(300L);
                String d4 = g1.a().d("location_permission_state");
                if (d4.equals("1")) {
                    AccessibilityNodeInfo a4 = b.d().a(accessibilityService, "\u5141\u8bb8\u672c\u6b21\u4f7f\u7528", true);
                    if (a4 != null) {
                        b.d().g(a4);
                        return true;
                    }
                    AccessibilityNodeInfo a5 = b.d().a(accessibilityService, "\u4ec5\u5728\u4f7f\u7528\u4e2d\u5141\u8bb8", true);
                    if (a5 != null) {
                        b.d().g(a5);
                        return true;
                    }
                    AccessibilityNodeInfo a6 = b.d().a(accessibilityService, "\u4ec5\u4f7f\u7528\u671f\u95f4\u5141\u8bb8", true);
                    if (a6 != null) {
                        b.d().g(a6);
                        return true;
                    }
                    AccessibilityNodeInfo a7 = b.d().a(accessibilityService, "\u672c\u6b21\u4f7f\u7528\u5141\u8bb8", true);
                    if (a7 != null) {
                        b.d().g(a7);
                        return true;
                    }
                    AccessibilityNodeInfo a8 = b.d().a(accessibilityService, "\u672c\u6b21\u8fd0\u884c\u5141\u8bb8", true);
                    if (a8 != null) {
                        b.d().g(a8);
                        return true;
                    }
                    AccessibilityNodeInfo a9 = b.d().a(accessibilityService, "\u672c\u6b21\u4f7f\u7528\u65f6\u5141\u8bb8", true);
                    if (a9 != null) {
                        b.d().g(a9);
                        return true;
                    }
                    AccessibilityNodeInfo a10 = b.d().a(accessibilityService, "\u4ec5\u672c\u6b21\u4f7f\u7528\u65f6\u5141\u8bb8", true);
                    if (a10 != null) {
                        b.d().g(a10);
                        return true;
                    }
                    AccessibilityNodeInfo a11 = b.d().a(accessibilityService, "\u5141\u8bb8", true);
                    if (a11 != null) {
                        b.d().g(a11);
                        return true;
                    }
                } else if (d4.equals("2")) {
                    AccessibilityNodeInfo h4 = b.d().h(accessibilityService, "\u6743\u9650\u7ba1\u7406");
                    if (h4 != null) {
                        Rect rect = new Rect();
                        h4.getBoundsInScreen(rect);
                        int i4 = (rect.left + rect.right) / 2;
                        String str2 = f6912b;
                        z1.a(str2, "x=" + i4);
                        int i5 = rect.bottom;
                        int i6 = rect.top;
                        int i7 = ((i5 - i6) / 2) + i6;
                        if (Build.VERSION.SDK_INT >= 24) {
                            g1.a().a("battery_white", true);
                            b.d().a(accessibilityService, i4, i7);
                            z1.a(f6912b, "\u70b9\u51fb\u4e86");
                            return true;
                        }
                    }
                    AccessibilityNodeInfo h5 = b.d().h(accessibilityService, "\u59cb\u7ec8\u5141\u8bb8");
                    if (h5 != null) {
                        z1.a(f6912b, h5.toString());
                        if (h5.getText().equals("\u59cb\u7ec8\u5141\u8bb8")) {
                            b.d().g(h5);
                            return true;
                        } else if (h5.getText().toString().equals("\u82e5\u540c\u610f\uff0c\u60a8\u53ef\u4ee5\u53bb\u8bbe\u7f6e\u4e3a\u59cb\u7ec8\u5141\u8bb8\u3002")) {
                            Rect rect2 = new Rect();
                            h5.getBoundsInScreen(rect2);
                            int i8 = rect2.right - rect2.left;
                            String str3 = f6912b;
                            z1.a(str3, "x=" + i8);
                            int i9 = rect2.bottom;
                            int i10 = rect2.top;
                            int i11 = ((i9 - i10) / 2) + i10;
                            if (Build.VERSION.SDK_INT >= 24) {
                                if (b.d().a(accessibilityService, i8, i11)) {
                                    b.d().a(1000L);
                                    b.d().a(accessibilityService, i8, i11);
                                }
                                z1.a(f6912b, "\u70b9\u51fb\u4e86");
                                g1.a().a("battery_white", true);
                            }
                            return true;
                        }
                    }
                    AccessibilityNodeInfo h6 = b.d().h(accessibilityService, "\u5728\u201c\u8bbe\u7f6e\u201d\u4e2d\u5141\u8bb8");
                    if (h6 != null) {
                        z1.a(f6912b, "\u5728\u201c\u8bbe\u7f6e\u201d\u4e2d\u5141\u8bb8");
                        Rect rect3 = new Rect();
                        h6.getBoundsInScreen(rect3);
                        int i12 = (rect3.left + rect3.right) / 2;
                        String str4 = f6912b;
                        z1.a(str4, "x=" + i12);
                        int i13 = rect3.bottom + (-30);
                        if (Build.VERSION.SDK_INT >= 24) {
                            b.d().a(accessibilityService, i12, i13);
                            z1.a(f6912b, "\u70b9\u51fb\u4e86");
                            g1.a().a("battery_white", true);
                        }
                        return true;
                    }
                    AccessibilityNodeInfo h7 = b.d().h(accessibilityService, "\u53bb\u8bbe\u4e3a\u59cb\u7ec8\u5141\u8bb8");
                    if (h7 != null) {
                        Rect rect4 = new Rect();
                        h7.getBoundsInScreen(rect4);
                        int i14 = (rect4.left + rect4.right) / 2;
                        String str5 = f6912b;
                        z1.a(str5, "x=" + i14);
                        int i15 = rect4.bottom + (-30);
                        if (Build.VERSION.SDK_INT >= 24) {
                            b.d().a(accessibilityService, i14, i15);
                            z1.a(f6912b, "\u70b9\u51fb\u4e86");
                            g1.a().a("battery_white", true);
                        }
                        return true;
                    }
                    AccessibilityNodeInfo a12 = b.d().a(accessibilityService, "\u5141\u8bb8", true);
                    if (a12 != null) {
                        b.d().g(a12);
                    }
                }
                return true;
            }
            return true;
        }
        return false;
    }
}
