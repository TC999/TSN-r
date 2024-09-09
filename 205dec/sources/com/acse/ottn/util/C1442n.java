package com.acse.ottn.util;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.GestureDescription;
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.graphics.Path;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.activity.AcseHelpManager;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* renamed from: com.acse.ottn.util.n  reason: case insensitive filesystem */
/* loaded from: E:\TSN-r\205dec\6276784.dex */
public class C1442n {

    /* renamed from: a  reason: collision with root package name */
    private static C1442n f6851a = null;

    /* renamed from: b  reason: collision with root package name */
    private static String f6852b = "acse_AccessibilityUtil";

    /* renamed from: c  reason: collision with root package name */
    static final int f6853c = 3;

    /* renamed from: d  reason: collision with root package name */
    static final long f6854d = 60000;

    /* renamed from: h  reason: collision with root package name */
    public CountDownTimer f6858h;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6855e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f6856f = false;

    /* renamed from: g  reason: collision with root package name */
    public boolean f6857g = false;

    /* renamed from: i  reason: collision with root package name */
    long[] f6859i = new long[3];

    private C1442n() {
    }

    @RequiresApi(api = 24)
    public static boolean a(AccessibilityService accessibilityService, int i4, int i5, int i6, int i7, int i8) {
        Path path = new Path();
        path.moveTo(i4, i5);
        path.lineTo(i6, i7);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, i8)).build(), new C1430h(), null);
    }

    public static C1442n c() {
        if (f6851a == null) {
            synchronized (C1442n.class) {
                if (f6851a == null) {
                    f6851a = new C1442n();
                }
            }
        }
        return f6851a;
    }

    private Object g() throws ObjectStreamException {
        return f6851a;
    }

    private void g(AccessibilityService accessibilityService) {
        if (C1419ba.a().a("show_red_package")) {
            return;
        }
        long[] jArr = this.f6859i;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.f6859i;
        if (jArr2[1] == jArr2[2] || jArr2[2] == 0) {
            return;
        }
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        long[] jArr3 = this.f6859i;
        long j4 = jArr3[jArr3.length - 1];
        long j5 = jArr3[0];
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
            String str2 = f6852b;
            ra.b(str2, "findViewByText accessibilityNodeInfo is null text =" + str);
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.getText() != null && str.equals(accessibilityNodeInfo.getText().toString().trim()) && accessibilityNodeInfo.isClickable() == z3) {
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

    public void a(AcseHelpManager.OnAccessiblityStateCallBack onAccessiblityStateCallBack) {
        if (AcseHelpManager.mIsDebug) {
            if (onAccessiblityStateCallBack != null) {
                onAccessiblityStateCallBack.onSuccess(c().e() ? "1" : "0");
                return;
            }
            return;
        }
        String a4 = C1419ba.a().a("accessiblity_type", "3");
        if (!"3".equals(a4)) {
            if (onAccessiblityStateCallBack != null) {
                onAccessiblityStateCallBack.onSuccess(a4);
                return;
            }
            return;
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("version", "1");
        treeMap.put("accessiblitystate", c().e() ? "1" : "0");
        new com.acse.ottn.a.a().b(V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).subscribe(new C1438l(this, onAccessiblityStateCallBack), new C1440m(this));
    }

    public void a(String str) {
        if (C1419ba.a() != null) {
            C1419ba.a().b("plunin_id", str);
        }
    }

    public void a(boolean z3) {
        this.f6855e = z3;
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
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 200L)).build(), new C1426f(this), null);
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
                    return c(accessibilityNodeInfo);
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
        return c((AccessibilityNodeInfo) (arrayList.size() > i4 ? arrayList.get(i4) : arrayList.get(0)));
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

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo b(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        return a(accessibilityNodeInfo, str, false);
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

    public void b(String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put("ak", HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("is_snt", "0");
        if (TextUtils.isEmpty(str)) {
            str = "n";
        }
        treeMap.put("state", str);
        new com.acse.ottn.a.a().j(V.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).subscribe(new C1434j(this), new C1436k(this));
    }

    public boolean b() {
        return com.acse.ottn.d.i.b().a(HelpShopAppUtil.getContext());
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
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 1000L)).build(), new C1428g(this), null);
    }

    @RequiresApi(api = 16)
    public boolean b(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    return c(accessibilityNodeInfo);
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
        return c((AccessibilityNodeInfo) (arrayList.size() > i4 ? arrayList.get(i4) : arrayList.get(0)));
    }

    public boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isScrollable()) {
            return false;
        }
        return accessibilityNodeInfo.performAction(4096);
    }

    public void c(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        CountDownTimer countDownTimer = this.f6858h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f6858h = null;
        }
        CountDownTimer a4 = S.a().a(2000, 50, new C1432i(this, accessibilityService));
        this.f6858h = a4;
        a4.start();
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
                f(accessibilityNodeInfo);
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

    public boolean c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo.performAction(16);
        }
        c(accessibilityNodeInfo.getParent());
        return false;
    }

    public String d() {
        return TextUtils.isEmpty(C1419ba.a().d("plunin_id")) ? "" : C1419ba.a().d("plunin_id");
    }

    @RequiresApi(api = 16)
    public void d(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(150L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        accessibilityService.performGlobalAction(1);
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
                f(accessibilityNodeInfo);
                return;
            }
        }
    }

    public void d(AccessibilityNodeInfo accessibilityNodeInfo) {
        for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
            AccessibilityNodeInfo a4 = a(accessibilityNodeInfo.getChild(i4), "com.tencent.mm:id/e7t");
            if (a4 != null && a4.getText() != null && a4.getText().toString().contains("[\u5fae\u4fe1\u7ea2\u5305]")) {
                f(a4);
                return;
            }
        }
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

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo e(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            ra.b(f6852b, "findViewByText3 accessibilityNodeInfo is null");
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
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
        accessibilityService.performGlobalAction(8192);
    }

    @RequiresApi(api = 18)
    public void e(AccessibilityNodeInfo accessibilityNodeInfo) {
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
                    if (this.f6857g) {
                        return;
                    }
                    e(child);
                }
            }
        }
    }

    public boolean e() {
        int i4;
        String string;
        String str = C1424e.c().b(HelpShopAppUtil.getContext()) + "/com.acse.ottn.service.ShopHelperService";
        try {
            i4 = Settings.Secure.getInt(HelpShopAppUtil.getContext().getContentResolver(), "accessibility_enabled");
        } catch (Exception e4) {
            ra.b("AccessibilityIntroduce", "Error finding setting, default accessibility to not found: " + e4.getMessage());
            i4 = 0;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        if (i4 == 1 && (string = Settings.Secure.getString(HelpShopAppUtil.getContext().getContentResolver(), "enabled_accessibility_services")) != null) {
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        if (C1419ba.a() != null) {
            C1419ba.a().b("flow_window_state", "1");
            C1419ba.a().a("open_battery_white", false);
            C1419ba.a().a("background_battery_hignt", false);
            C1419ba.a().a("open_battery_white_size", false);
        }
        return false;
    }

    @TargetApi(18)
    public AccessibilityNodeInfo f(AccessibilityService accessibilityService, String str) {
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
    public void f(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        accessibilityService.performGlobalAction(4096);
    }

    public void f(AccessibilityNodeInfo accessibilityNodeInfo) {
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

    public boolean f() {
        return this.f6855e;
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo g(AccessibilityService accessibilityService, String str) {
        return a(accessibilityService, str, false);
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo h(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            ra.b(f6852b, "findViewByText1 accessibilityNodeInfo is null");
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @RequiresApi(api = 16)
    public void i(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            ra.a(f6852b, "findViewByText2 accessibilityNodeInfo is null");
            return;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText == null || findAccessibilityNodeInfosByText.isEmpty()) {
            return;
        }
        String str2 = f6852b;
        ra.a(str2, "nodeInfoList size =" + findAccessibilityNodeInfosByText.size());
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
            if (accessibilityNodeInfo != null) {
                c().f(accessibilityNodeInfo);
            }
        }
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo j(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            ra.b(f6852b, "findViewByText3 accessibilityNodeInfo is null");
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.getText() != null && str.equals(accessibilityNodeInfo.getText().toString().trim())) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @TargetApi(18)
    public List<AccessibilityNodeInfo> k(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return null;
        }
        return rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
    }

    @RequiresApi(api = 16)
    public boolean l(AccessibilityService accessibilityService, String str) {
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
    public boolean m(AccessibilityService accessibilityService, String str) {
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
