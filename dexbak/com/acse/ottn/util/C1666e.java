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
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.p042d.C1530i;
import com.bxkj.student.C4229c;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.acse.ottn.util.e */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1666e {

    /* renamed from: a */
    private static C1666e f3309a = null;

    /* renamed from: b */
    private static String f3310b = "AccessibilityUtil";

    /* renamed from: c */
    static final int f3311c = 3;

    /* renamed from: d */
    static final long f3312d = 60000;

    /* renamed from: e */
    private boolean f3313e = false;

    /* renamed from: f */
    public boolean f3314f = false;

    /* renamed from: g */
    public boolean f3315g = false;

    /* renamed from: h */
    long[] f3316h = new long[3];

    private C1666e() {
    }

    /* renamed from: c */
    public static C1666e m56042c() {
        if (f3309a == null) {
            synchronized (C1666e.class) {
                if (f3309a == null) {
                    f3309a = new C1666e();
                }
            }
        }
        return f3309a;
    }

    /* renamed from: f */
    private void m56027f(AccessibilityService accessibilityService) {
        if (C1661ba.m56097a() == null && C1661ba.m56097a().m56096a("show_red_package")) {
            return;
        }
        long[] jArr = this.f3316h;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.f3316h;
        if (jArr2[1] == jArr2[2] || jArr2[2] == 0) {
            return;
        }
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        long[] jArr3 = this.f3316h;
        long j = jArr3[jArr3.length - 1];
        long j2 = jArr3[0];
    }

    /* renamed from: f */
    private boolean m56028f() {
        return Build.VERSION.SDK_INT >= 19 && ((AppOpsManager) AcseHelpManager.mContext.getSystemService("appops")).checkOpNoThrow("android:picture_in_picture", AcseHelpManager.mContext.getApplicationInfo().uid, AcseHelpManager.mContext.getPackageName()) == 0 && AcseHelpManager.mContext.getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    /* renamed from: f */
    private boolean m56025f(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo.performAction(16);
        }
        m56025f(accessibilityNodeInfo.getParent());
        return false;
    }

    /* renamed from: g */
    private Object m56024g() throws ObjectStreamException {
        return f3309a;
    }

    /* renamed from: g */
    private boolean m56022g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isLongClickable()) {
            return accessibilityNodeInfo.performAction(32);
        }
        m56022g(accessibilityNodeInfo.getParent());
        return false;
    }

    @RequiresApi(api = 16)
    /* renamed from: a */
    public AccessibilityNodeInfo m56063a(AccessibilityService accessibilityService, String str, boolean z) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            C1694ra.m55915b("AccessibilityUtil", "accessibilityNodeInfo is null");
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.isClickable() == z) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @TargetApi(18)
    /* renamed from: a */
    public AccessibilityNodeInfo m56056a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
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
    /* renamed from: a */
    public AccessibilityNodeInfo m56055a(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2) {
        for (int childCount = accessibilityNodeInfo.getChildCount() - 1; childCount >= 0; childCount--) {
            if (accessibilityNodeInfo.getChild(childCount) != null && !str2.equals(accessibilityNodeInfo.getChild(childCount).getText())) {
                return accessibilityNodeInfo.getChild(childCount);
            }
        }
        return null;
    }

    /* renamed from: a */
    public AccessibilityNodeInfo m56054a(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        if (accessibilityNodeInfo != null && (findAccessibilityNodeInfosByText = accessibilityNodeInfo.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo2 : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo2 != null && accessibilityNodeInfo2.isClickable() == z) {
                    return accessibilityNodeInfo2;
                }
            }
        }
        return null;
    }

    /* renamed from: a */
    public void m56073a(long j) {
        try {
            Thread.sleep(j);
        } catch (Exception unused) {
            System.exit(0);
        }
    }

    @RequiresApi(api = 24)
    /* renamed from: a */
    protected void m56071a(AccessibilityService accessibilityService, float f, float f2, int i, AccessibilityService.GestureResultCallback gestureResultCallback) {
        Path path = new Path();
        path.moveTo(f, f2);
        m56068a(accessibilityService, path, 0L, i, gestureResultCallback);
    }

    @RequiresApi(api = 24)
    /* renamed from: a */
    public void m56068a(AccessibilityService accessibilityService, Path path, long j, long j2, AccessibilityService.GestureResultCallback gestureResultCallback) {
        GestureDescription.Builder builder = new GestureDescription.Builder();
        builder.addStroke(new GestureDescription.StrokeDescription(path, j, j2));
        accessibilityService.dispatchGesture(builder.build(), gestureResultCallback, null);
    }

    /* renamed from: a */
    public void m56067a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return;
        }
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(i);
            if ("android.widget.Button".equals(child.getClassName())) {
                child.performAction(16);
            }
            m56067a(accessibilityService, child);
        }
    }

    /* renamed from: a */
    public void m56062a(Activity activity, int i) {
        String m56193b = C1638Ka.m56193b();
        if ("redmi".equals(m56193b) || C4229c.f16088d.equals(m56193b) || C1710ya.m55883a().m55880b() || "vivo".equals(m56193b) || "oppo".equals(m56193b) || "realme".equals(m56193b) || "oneplus".equals(m56193b) || "samsung".equals(m56193b)) {
            new Handler().postDelayed(new RunnableC1664d(this, activity), 500L);
        }
        C1703va.m55903a().m55901a("show_accessiblity_open_view");
        C1661ba.m56097a().m56092a("battery_white", true);
        try {
            activity.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), i);
        } catch (Exception e) {
            activity.startActivityForResult(new Intent("android.settings.SETTINGS"), i);
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m56061a(Activity activity, boolean z) {
        if (activity != null) {
            C1703va.m55903a().m55901a(z ? "close_shophelp" : "open_shophelp");
        }
        C1661ba.m56097a().m56092a("AccessiblityOnOrOff", z);
    }

    /* renamed from: a */
    public void m56060a(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
    }

    /* renamed from: a */
    public void m56058a(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getParcelableData() == null || !(accessibilityEvent.getParcelableData() instanceof Notification)) {
            return;
        }
        try {
            ((Notification) accessibilityEvent.getParcelableData()).contentIntent.send();
        } catch (PendingIntent.CanceledException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m56053a(AppCompatActivity appCompatActivity, int i) {
        C1530i.m56512b().m56516a(appCompatActivity, i);
    }

    /* renamed from: a */
    public void m56052a(boolean z) {
        this.f3313e = z;
    }

    /* renamed from: a */
    public boolean m56074a() {
        return C1530i.m56512b().m56518a(HelpShopAppUtil.getContext());
    }

    @SuppressLint({"ObsoleteSdkInt"})
    /* renamed from: a */
    public boolean m56072a(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return false;
        }
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return accessibilityService.performGlobalAction(1);
    }

    @RequiresApi(api = 24)
    /* renamed from: a */
    public boolean m56070a(AccessibilityService accessibilityService, int i, int i2) {
        Path path = new Path();
        path.moveTo(i, i2);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 200L)).build(), new C1657a(this), null);
    }

    @RequiresApi(api = 24)
    /* renamed from: a */
    public boolean m56069a(AccessibilityService accessibilityService, int i, int i2, int i3, int i4, int i5) {
        Path path = new Path();
        path.moveTo(i, i2);
        path.lineTo(i3, i4);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, i5)).build(), new C1662c(this), null);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    /* renamed from: a */
    public boolean m56066a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        if (accessibilityService == null) {
            return false;
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            Bundle bundle = new Bundle();
            bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
            return accessibilityNodeInfo.performAction(2097152, bundle);
        }
        if (i >= 18) {
            ClipboardManager clipboardManager = (ClipboardManager) accessibilityService.getSystemService("clipboard");
            ClipData newPlainText = ClipData.newPlainText(TTDownloadField.TT_LABEL, str);
            if (clipboardManager != null) {
                clipboardManager.setPrimaryClip(newPlainText);
            }
            accessibilityNodeInfo.performAction(1);
            accessibilityNodeInfo.performAction(32768);
        }
        return false;
    }

    @RequiresApi(api = 18)
    /* renamed from: a */
    public boolean m56065a(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return m56025f(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    /* renamed from: a */
    public boolean m56064a(AccessibilityService accessibilityService, String str, int i) {
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
        return m56025f((AccessibilityNodeInfo) (arrayList.size() > i ? arrayList.get(i) : arrayList.get(0)));
    }

    /* renamed from: a */
    public boolean m56059a(Context context, Class cls) {
        if (Settings.Secure.getInt(context.getContentResolver(), "accessibility_enabled", 0) != 1) {
            return false;
        }
        String string = Settings.Secure.getString(context.getContentResolver(), "enabled_accessibility_services");
        if (!TextUtils.isEmpty(string)) {
            TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                String next = simpleStringSplitter.next();
                if (next.equalsIgnoreCase(context.getPackageName() + "/" + cls.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: a */
    public boolean m56057a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.performAction(8192);
    }

    /* renamed from: b */
    public String m56044b(Context context) {
        if (C1661ba.m56097a() == null) {
            return "";
        }
        if (TextUtils.isEmpty(C1661ba.m56097a().m56086d("appName"))) {
            try {
                C1661ba.m56097a().m56088b("appName", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return C1661ba.m56097a().m56086d("appName");
    }

    /* renamed from: b */
    public void m56048b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            Bundle bundle = new Bundle();
            bundle.putCharSequence(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE, str);
            accessibilityNodeInfo.performAction(2097152, bundle);
        } else if (i >= 18) {
            ((ClipboardManager) accessibilityService.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(TTDownloadField.TT_LABEL, str));
            accessibilityNodeInfo.performAction(1);
            accessibilityNodeInfo.performAction(32768);
        }
    }

    /* renamed from: b */
    public void m56045b(Activity activity, boolean z) {
        C1661ba.m56097a().m56092a("red_package_state", z);
    }

    /* renamed from: b */
    public boolean m56051b() {
        return C1661ba.m56097a().m56096a("AccessiblityOnOrOff");
    }

    @SuppressLint({"ObsoleteSdkInt"})
    /* renamed from: b */
    public boolean m56050b(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return false;
        }
        try {
            Thread.sleep(200L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return accessibilityService.performGlobalAction(2);
    }

    @RequiresApi(api = 24)
    /* renamed from: b */
    public boolean m56049b(AccessibilityService accessibilityService, int i, int i2) {
        Path path = new Path();
        path.moveTo(i, i2);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 1000L)).build(), new C1660b(this), null);
    }

    @RequiresApi(api = 16)
    /* renamed from: b */
    public boolean m56047b(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    return m56025f(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 16)
    /* renamed from: b */
    public boolean m56046b(AccessibilityService accessibilityService, String str, int i) {
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
        return m56025f((AccessibilityNodeInfo) (arrayList.size() > i ? arrayList.get(i) : arrayList.get(0)));
    }

    /* renamed from: b */
    public boolean m56043b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isScrollable()) {
            return false;
        }
        return accessibilityNodeInfo.performAction(4096);
    }

    @RequiresApi(api = 16)
    /* renamed from: c */
    public void m56041c(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(150L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accessibilityService.performGlobalAction(1);
    }

    @TargetApi(18)
    /* renamed from: c */
    public void m56040c(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) == null || findAccessibilityNodeInfosByViewId.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
            if (accessibilityNodeInfo != null) {
                m56029e(accessibilityNodeInfo);
                return;
            }
        }
    }

    /* renamed from: c */
    public void m56038c(AccessibilityNodeInfo accessibilityNodeInfo) {
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            AccessibilityNodeInfo m56056a = m56056a(accessibilityNodeInfo.getChild(i), "com.tencent.mm:id/e7t");
            if (m56056a != null && m56056a.getText() != null && m56056a.getText().toString().contains("[微信红包]")) {
                m56029e(m56056a);
                return;
            }
        }
    }

    @RequiresApi(api = 18)
    /* renamed from: c */
    public boolean m56039c(AccessibilityService accessibilityService, String str, int i) {
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
        return m56022g((AccessibilityNodeInfo) (arrayList.size() > i ? arrayList.get(i) : arrayList.get(0)));
    }

    @RequiresApi(api = 16)
    /* renamed from: d */
    public void m56036d(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accessibilityService.performGlobalAction(8192);
    }

    @RequiresApi(api = 16)
    /* renamed from: d */
    public void m56035d(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) == null || findAccessibilityNodeInfosByText.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
            if (accessibilityNodeInfo != null) {
                m56029e(accessibilityNodeInfo);
                return;
            }
        }
    }

    @RequiresApi(api = 18)
    /* renamed from: d */
    public void m56033d(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo != null) {
            for (int childCount = accessibilityNodeInfo.getChildCount() - 1; childCount >= 0; childCount--) {
                AccessibilityNodeInfo child = accessibilityNodeInfo.getChild(childCount);
                if (child != null) {
                    CharSequence text = child.getText();
                    if (text != null && (text.toString().equals("微信红包") || text.toString().contains("[微信红包]"))) {
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
                    if (this.f3315g) {
                        return;
                    }
                    m56033d(child);
                }
            }
        }
    }

    /* renamed from: d */
    public boolean m56037d() {
        return C1661ba.m56097a().m56096a("red_package_state");
    }

    @RequiresApi(api = 16)
    /* renamed from: d */
    public boolean m56034d(AccessibilityService accessibilityService, String str, int i) {
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
        return m56022g((AccessibilityNodeInfo) (arrayList.size() > i ? arrayList.get(i) : arrayList.get(0)));
    }

    @TargetApi(18)
    /* renamed from: e */
    public AccessibilityNodeInfo m56030e(AccessibilityService accessibilityService, String str) {
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
    /* renamed from: e */
    public void m56031e(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accessibilityService.performGlobalAction(4096);
    }

    /* renamed from: e */
    public void m56029e(AccessibilityNodeInfo accessibilityNodeInfo) {
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

    /* renamed from: e */
    public boolean m56032e() {
        return this.f3313e;
    }

    @RequiresApi(api = 16)
    /* renamed from: f */
    public AccessibilityNodeInfo m56026f(AccessibilityService accessibilityService, String str) {
        return m56063a(accessibilityService, str, false);
    }

    @TargetApi(18)
    /* renamed from: g */
    public List<AccessibilityNodeInfo> m56023g(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return null;
        }
        return rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
    }

    @RequiresApi(api = 16)
    /* renamed from: h */
    public boolean m56021h(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    return m56022g(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    /* renamed from: i */
    public boolean m56020i(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return m56022g(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }
}
