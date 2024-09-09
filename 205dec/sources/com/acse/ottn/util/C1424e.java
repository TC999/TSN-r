package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AppOpsManager;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.activity.AcseHelpManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.acse.ottn.util.e  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1424e {

    /* renamed from: a  reason: collision with root package name */
    private static C1424e f6819a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6820b = "AccessibilityUtil";

    /* renamed from: c  reason: collision with root package name */
    static final int f6821c = 3;

    /* renamed from: d  reason: collision with root package name */
    static final long f6822d = 60000;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6823e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6824f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6825g = false;

    /* renamed from: h  reason: collision with root package name */
    long[] f6826h = new long[3];

    private C1424e() {
    }

    public static C1424e c() {
        if (f6819a == null) {
            synchronized (C1424e.class) {
                if (f6819a == null) {
                    f6819a = new C1424e();
                }
            }
        }
        return f6819a;
    }

    private void f(AccessibilityService accessibilityService) {
        if (C1419ba.a() == null && C1419ba.a().a("show_red_package")) {
            return;
        }
        long[] jArr = this.f6826h;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.f6826h;
        if (jArr2[1] == jArr2[2] || jArr2[2] == 0) {
            return;
        }
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        long[] jArr3 = this.f6826h;
        long j4 = jArr3[jArr3.length - 1];
        long j5 = jArr3[0];
    }

    private boolean f() {
        return Build.VERSION.SDK_INT >= 19 && ((AppOpsManager) AcseHelpManager.mContext.getSystemService("appops")).checkOpNoThrow("android:picture_in_picture", AcseHelpManager.mContext.getApplicationInfo().uid, AcseHelpManager.mContext.getPackageName()) == 0 && AcseHelpManager.mContext.getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    private boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo.performAction(16);
        }
        f(accessibilityNodeInfo.getParent());
        return false;
    }

    private Object g() throws ObjectStreamException {
        return f6819a;
    }

    private boolean g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isLongClickable()) {
            return accessibilityNodeInfo.performAction(32);
        }
        g(accessibilityNodeInfo.getParent());
        return false;
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo a(AccessibilityService accessibilityService, String str, boolean z3) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            ra.b("AccessibilityUtil", "accessibilityNodeInfo is null");
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.isClickable() == z3) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @TargetApi(18)
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        if (accessibilityNodeInfo != null && (findAccessibilityNodeInfosByViewId = accessibilityNodeInfo.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo2 != null) {
                    return accessibilityNodeInfo2;
                }
            }
        }
        return null;
    }

    @TargetApi(18)
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2) {
        for (int childCount = accessibilityNodeInfo.getChildCount() - 1; childCount >= 0; childCount--) {
            if (accessibilityNodeInfo.getChild(childCount) != null && !str2.equals(accessibilityNodeInfo.getChild(childCount).getText())) {
                return accessibilityNodeInfo.getChild(childCount);
            }
        }
        return null;
    }

    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z3) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        if (accessibilityNodeInfo != null && (findAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2.isClickable() == z3) {
                    return accessibilityNodeInfo2;
                }
            }
        }
        return null;
    }

    public void a(long j4) {
        try {
            Thread.sleep(j4);
        } catch (Exception unused) {
            System.exit(0);
        }
    }

    @RequiresApi(api = 24)
    protected void a(AccessibilityService accessibilityService, float f4, float f5, int i4, AccessibilityService.GestureResultCallback gestureResultCallback) {
        Path path = new Path();
        path.moveTo(f4, f5);
        a(accessibilityService, path, 0L, i4, gestureResultCallback);
    }

    @RequiresApi(api = 24)
    public void a(AccessibilityService accessibilityService, Path path, long j4, long j5, AccessibilityService.GestureResultCallback gestureResultCallback) {
        GestureDescription.Builder builder = new GestureDescription.Builder();
        builder.addStroke(new GestureDescription.StrokeDescription(path, j4, j5));
        accessibilityService.dispatchGesture(builder.build(), gestureResultCallback, null);
    }

    public void a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i4);
            if ("android.widget.Button".equals(child.getClassName())) {
                child.performAction(16);
            }
            a(accessibilityService, child);
        }
    }

    public void a(Activity activity, int i4) {
        String b4 = Ka.b();
        if ("redmi".equals(b4) || "xiaomi".equals(b4) || ya.a().b() || "vivo".equals(b4) || "oppo".equals(b4) || "realme".equals(b4) || "oneplus".equals(b4) || "samsung".equals(b4)) {
            new Handler().postDelayed(new RunnableC1422d(this, activity), 500L);
        }
        va.a().a("show_accessiblity_open_view");
        C1419ba.a().a("battery_white", true);
        try {
            activity.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), i4);
        } catch (Exception e4) {
            activity.startActivityForResult(new Intent("android.settings.SETTINGS"), i4);
            e4.printStackTrace();
        }
    }

    public void a(Activity activity, boolean z3) {
        if (activity != null) {
            va.a().a(z3 ? "close_shophelp" : "open_shophelp");
        }
        C1419ba.a().a("AccessiblityOnOrOff", z3);
    }

    public void a(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
    }

    public void a(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getParcelableData() == null || !(accessibilityEvent.getParcelableData() instanceof Notification)) {
            return;
        }
        try {
            ((Notification) accessibilityEvent.getParcelableData()).contentIntent.send();
        } catch (PendingIntent.CanceledException e4) {
            e4.printStackTrace();
        }
    }

    public void a(AppCompatActivity appCompatActivity, int i4) {
        com.acse.ottn.d.i.b().a(appCompatActivity, i4);
    }

    public void a(boolean z3) {
        this.f6823e = z3;
    }

    public boolean a() {
        return com.acse.ottn.d.i.b().a(HelpShopAppUtil.getContext());
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean a(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return false;
        }
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        return accessibilityService.performGlobalAction(1);
    }

    @RequiresApi(api = 24)
    public boolean a(AccessibilityService accessibilityService, int i4, int i5) {
        Path path = new Path();
        path.moveTo(i4, i5);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 200L)).build(), new C1416a(this), null);
    }

    @RequiresApi(api = 24)
    public boolean a(AccessibilityService accessibilityService, int i4, int i5, int i6, int i7, int i8) {
        Path path = new Path();
        path.moveTo(i4, i5);
        path.lineTo(i6, i7);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, i8)).build(), new C1420c(this), null);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityService == null) {
            return false;
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", str);
            return accessibilityNodeInfo.performAction(2097152, bundle);
        }
        if (i4 >= 18) {
            ClipboardManager clipboardManager = (ClipboardManager) accessibilityService.getSystemService("clipboard");
            ClipData newPlainText = ClipData.newPlainText("label", str);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
            accessibilityNodeInfo.performAction(1);
            accessibilityNodeInfo.performAction(32768);
        }
        return false;
    }

    @RequiresApi(api = 18)
    public boolean a(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return f(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    public boolean a(AccessibilityService accessibilityService, String str, int i4) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        if (findAccessibilityNodeInfosByViewId != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return f((AccessibilityNodeInfo) (arrayList.size() > i4 ? arrayList.get(i4) : arrayList.get(0)));
    }

    public boolean a(Context context, Class cls) {
        if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
            return false;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        if (!TextUtils.isEmpty(string)) {
            TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                String next = simpleStringSplitter.next();
                if (next.equalsIgnoreCase(context.getPackageName() + TTPathConst.sSeparator + cls.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.performAction(8192);
    }

    public String b(Context context) {
        if (C1419ba.a() == null) {
            return "";
        }
        if (TextUtils.isEmpty(C1419ba.a().d("appName"))) {
            try {
                C1419ba.a().b("appName", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
        return C1419ba.a().d("appName");
    }

    public void b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 21) {
            Bundle bundle = new Bundle();
            bundle.putCharSequence("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE", str);
            accessibilityNodeInfo.performAction(2097152, bundle);
        } else if (i4 >= 18) {
            ((ClipboardManager) accessibilityService.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("label", str));
            accessibilityNodeInfo.performAction(1);
            accessibilityNodeInfo.performAction(32768);
        }
    }

    public void b(Activity activity, boolean z3) {
        C1419ba.a().a("red_package_state", z3);
    }

    public boolean b() {
        return C1419ba.a().a("AccessiblityOnOrOff");
    }

    @SuppressLint({"ObsoleteSdkInt"})
    public boolean b(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return false;
        }
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        return accessibilityService.performGlobalAction(2);
    }

    @RequiresApi(api = 24)
    public boolean b(AccessibilityService accessibilityService, int i4, int i5) {
        Path path = new Path();
        path.moveTo(i4, i5);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 1000L)).build(), new C1418b(this), null);
    }

    @RequiresApi(api = 16)
    public boolean b(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    return f(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 16)
    public boolean b(AccessibilityService accessibilityService, String str, int i4) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        ArrayList arrayList = new ArrayList();
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return f((AccessibilityNodeInfo) (arrayList.size() > i4 ? arrayList.get(i4) : arrayList.get(0)));
    }

    public boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isScrollable()) {
            return false;
        }
        return accessibilityNodeInfo.performAction(4096);
    }

    @RequiresApi(api = 16)
    public void c(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(150L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        accessibilityService.performGlobalAction(1);
    }

    @TargetApi(18)
    public void c(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) == null || findAccessibilityNodeInfosByViewId.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
            if (accessibilityNodeInfo != null) {
                e(accessibilityNodeInfo);
                return;
            }
        }
    }

    public void c(AccessibilityNodeInfo accessibilityNodeInfo) {
        for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
            AccessibilityNodeInfo a4 = a(accessibilityNodeInfo.getChild(i4), "com.tencent.mm:id/e7t");
            if (a4 != null && a4.getText() != null && a4.getText().toString().contains("[\u5fae\u4fe1\u7ea2\u5305]")) {
                e(a4);
                return;
            }
        }
    }

    @RequiresApi(api = 18)
    public boolean c(AccessibilityService accessibilityService, String str, int i4) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        if (findAccessibilityNodeInfosByViewId != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return g((AccessibilityNodeInfo) (arrayList.size() > i4 ? arrayList.get(i4) : arrayList.get(0)));
    }

    @RequiresApi(api = 16)
    public void d(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        accessibilityService.performGlobalAction(8192);
    }

    @RequiresApi(api = 16)
    public void d(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) == null || findAccessibilityNodeInfosByText.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
            if (accessibilityNodeInfo != null) {
                e(accessibilityNodeInfo);
                return;
            }
        }
    }

    @RequiresApi(api = 18)
    public void d(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int childCount = accessibilityNodeInfo.getChildCount() - 1; childCount >= 0; childCount--) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(childCount);
                if (child != null) {
                    CharSequence text = child.getText();
                    if (text != null && (text.toString().equals("\u5fae\u4fe1\u7ea2\u5305") || text.toString().contains("[\u5fae\u4fe1\u7ea2\u5305]"))) {
                        AccessibilityNodeInfo parent = child.getParent();
                        while (true) {
                            if (parent == null) {
                                break;
                            } else if (parent.getChildCount() == 2) {
                                parent.performAction(16);
                                break;
                            } else {
                                parent = parent.getParent();
                            }
                        }
                    }
                    if (this.f6825g) {
                        return;
                    }
                    d(child);
                }
            }
        }
    }

    public boolean d() {
        return C1419ba.a().a("red_package_state");
    }

    @RequiresApi(api = 16)
    public boolean d(AccessibilityService accessibilityService, String str, int i4) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return false;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        ArrayList arrayList = new ArrayList();
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    arrayList.add(accessibilityNodeInfo);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return false;
        }
        return g((AccessibilityNodeInfo) (arrayList.size() > i4 ? arrayList.get(i4) : arrayList.get(0)));
    }

    @TargetApi(18)
    public AccessibilityNodeInfo e(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @RequiresApi(api = 16)
    public void e(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        accessibilityService.performGlobalAction(4096);
    }

    public void e(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        while (accessibilityNodeInfo != null) {
            if (accessibilityNodeInfo.isClickable()) {
                accessibilityNodeInfo.performAction(16);
                return;
            }
            accessibilityNodeInfo = accessibilityNodeInfo.getParent();
        }
    }

    public boolean e() {
        return this.f6823e;
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo f(AccessibilityService accessibilityService, String str) {
        return a(accessibilityService, str, false);
    }

    @TargetApi(18)
    public List<AccessibilityNodeInfo> g(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return null;
        }
        return rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
    }

    @RequiresApi(api = 16)
    public boolean h(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    return g(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    public boolean i(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return g(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }
}
