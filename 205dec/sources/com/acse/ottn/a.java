package com.acse.ottn;

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
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.activity.TransparentGreenActivity;
import com.acse.ottn.util.HelpShopAppUtil;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a {

    /* renamed from: e  reason: collision with root package name */
    public static a f4565e = null;

    /* renamed from: f  reason: collision with root package name */
    public static String f4566f = "AccessibilityUtil";

    /* renamed from: g  reason: collision with root package name */
    public static final int f4567g = 3;

    /* renamed from: h  reason: collision with root package name */
    public static final long f4568h = 60000;

    /* renamed from: a  reason: collision with root package name */
    public boolean f4569a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f4570b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f4571c = false;

    /* renamed from: d  reason: collision with root package name */
    public long[] f4572d = new long[3];

    /* renamed from: com.acse.ottn.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class C0074a extends AccessibilityService.GestureResultCallback {
        public C0074a() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class b extends AccessibilityService.GestureResultCallback {
        public b() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c extends AccessibilityService.GestureResultCallback {
        public c() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Activity f4579a;

        public d(Activity activity) {
            this.f4579a = activity;
        }

        @Override // java.lang.Runnable
        public void run() {
            Intent intent = new Intent(this.f4579a, TransparentGreenActivity.class);
            intent.setFlags(268435456);
            this.f4579a.startActivity(intent);
        }
    }

    public static a c() {
        if (f4565e == null) {
            synchronized (a.class) {
                if (f4565e == null) {
                    f4565e = new a();
                }
            }
        }
        return f4565e;
    }

    public void a(boolean z3) {
        this.f4569a = z3;
    }

    public String b(Context context) {
        if (g1.a() == null) {
            return "";
        }
        if (TextUtils.isEmpty(g1.a().d("appName"))) {
            try {
                g1.a().b("appName", context.getPackageManager().getPackageInfo(context.getPackageName(), 0).packageName);
            } catch (Exception e4) {
                Log.d("error", e4.getMessage());
            }
        }
        return g1.a().d("appName");
    }

    public boolean d() {
        return g1.a().a("red_package_state");
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
                    if (this.f4571c) {
                        return;
                    }
                    e(child);
                }
            }
        }
    }

    public boolean f() {
        return this.f4569a;
    }

    public final Object g() throws ObjectStreamException {
        return f4565e;
    }

    @RequiresApi(api = 16)
    public boolean h(AccessibilityService accessibilityService, String str) {
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

    @RequiresApi(api = 18)
    public boolean i(AccessibilityService accessibilityService, String str) {
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

    public void a(Activity activity, boolean z3) {
        if (activity != null) {
            if (z3) {
                i2.a().a("close_shophelp");
            } else {
                i2.a().a("open_shophelp");
            }
        }
        g1.a().a("AccessiblityOnOrOff", z3);
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
        if (arrayList.size() > i4) {
            return f((AccessibilityNodeInfo) arrayList.get(i4));
        }
        return f((AccessibilityNodeInfo) arrayList.get(0));
    }

    public final boolean f(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isLongClickable()) {
            return accessibilityNodeInfo.performAction(32);
        }
        f(accessibilityNodeInfo.getParent());
        return false;
    }

    public void g(AccessibilityNodeInfo accessibilityNodeInfo) {
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

    public boolean a() {
        return b1.b().a(HelpShopAppUtil.getContext());
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

    @TargetApi(18)
    public List<AccessibilityNodeInfo> g(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return null;
        }
        return rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
    }

    public void a(AppCompatActivity appCompatActivity, int i4) {
        b1.b().b(appCompatActivity, i4);
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
        if (arrayList.size() > i4) {
            return f((AccessibilityNodeInfo) arrayList.get(i4));
        }
        return f((AccessibilityNodeInfo) arrayList.get(0));
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo f(AccessibilityService accessibilityService, String str) {
        return a(accessibilityService, str, false);
    }

    public void b(Activity activity, boolean z3) {
        g1.a().a("red_package_state", z3);
    }

    public boolean b() {
        return g1.a().a("AccessiblityOnOrOff");
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
        if (arrayList.size() > i4) {
            return c((AccessibilityNodeInfo) arrayList.get(i4));
        }
        return c((AccessibilityNodeInfo) arrayList.get(0));
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

    @RequiresApi(api = 16)
    public void d(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(150L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        accessibilityService.performGlobalAction(1);
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
        if (arrayList.size() > i4) {
            return c((AccessibilityNodeInfo) arrayList.get(i4));
        }
        return c((AccessibilityNodeInfo) arrayList.get(0));
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
    public void d(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) == null || findAccessibilityNodeInfosByText.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
            if (accessibilityNodeInfo != null) {
                g(accessibilityNodeInfo);
                return;
            }
        }
    }

    public final boolean c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo.performAction(16);
        }
        c(accessibilityNodeInfo.getParent());
        return false;
    }

    public final boolean e() {
        return Build.VERSION.SDK_INT >= 19 && ((AppOpsManager) AcseHelpManager.mContext.getSystemService("appops")).checkOpNoThrow("android:picture_in_picture", AcseHelpManager.mContext.getApplicationInfo().uid, AcseHelpManager.mContext.getPackageName()) == 0 && AcseHelpManager.mContext.getPackageManager().hasSystemFeature("android.software.picture_in_picture");
    }

    public final void c(AccessibilityService accessibilityService) {
        if (g1.a() == null && g1.a().a("show_red_package")) {
            return;
        }
        long[] jArr = this.f4572d;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.f4572d;
        long j4 = jArr2[1];
        long j5 = jArr2[2];
        if (j4 == j5 || j5 == 0) {
            return;
        }
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        long[] jArr3 = this.f4572d;
        long j6 = jArr3[jArr3.length - 1];
        long j7 = jArr3[0];
    }

    public void d(AccessibilityNodeInfo accessibilityNodeInfo) {
        for (int i4 = 0; i4 < accessibilityNodeInfo.getChildCount(); i4++) {
            AccessibilityNodeInfo a4 = a(accessibilityNodeInfo.getChild(i4), "com.tencent.mm:id/e7t");
            if (a4 != null && a4.getText() != null && a4.getText().toString().contains("[\u5fae\u4fe1\u7ea2\u5305]")) {
                g(a4);
                return;
            }
        }
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

    @TargetApi(18)
    public void c(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) == null || findAccessibilityNodeInfosByViewId.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
            if (accessibilityNodeInfo != null) {
                g(accessibilityNodeInfo);
                return;
            }
        }
    }

    @RequiresApi(api = 24)
    public boolean b(AccessibilityService accessibilityService, int i4, int i5) {
        Path path = new Path();
        path.moveTo(i4, i5);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 1000L)).build(), new b(), null);
    }

    @RequiresApi(api = 24)
    public boolean a(AccessibilityService accessibilityService, int i4, int i5) {
        Path path = new Path();
        path.moveTo(i4, i5);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 200L)).build(), new C0074a(), null);
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
    public boolean a(AccessibilityService accessibilityService, int i4, int i5, int i6, int i7, int i8) {
        Path path = new Path();
        path.moveTo(i4, i5);
        path.lineTo(i6, i7);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, i8)).build(), new c(), null);
    }

    public boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isScrollable()) {
            return false;
        }
        return accessibilityNodeInfo.performAction(4096);
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

    public boolean a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.performAction(8192);
    }

    public void a(long j4) {
        try {
            Thread.sleep(j4);
        } catch (Exception unused) {
            System.exit(0);
        }
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

    public void a(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
    }

    @RequiresApi(api = 24)
    public void a(AccessibilityService accessibilityService, float f4, float f5, int i4, AccessibilityService.GestureResultCallback gestureResultCallback) {
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

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo a(AccessibilityService accessibilityService, String str, boolean z3) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            z1.b("AccessibilityUtil", "accessibilityNodeInfo is null");
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

    @TargetApi(18)
    public AccessibilityNodeInfo a(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2) {
        for (int childCount = accessibilityNodeInfo.getChildCount() - 1; childCount >= 0; childCount--) {
            if (accessibilityNodeInfo.getChild(childCount) != null && !str2.equals(accessibilityNodeInfo.getChild(childCount).getText())) {
                return accessibilityNodeInfo.getChild(childCount);
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

    public void a(Activity activity, int i4) {
        String b4 = c4.b();
        if ("redmi".equals(b4) || "xiaomi".equals(b4) || w2.a().b() || "vivo".equals(b4) || "oppo".equals(b4) || "realme".equals(b4) || "oneplus".equals(b4) || "samsung".equals(b4)) {
            new Handler().postDelayed(new d(activity), 500L);
        }
        i2.a().a("show_accessiblity_open_view");
        g1.a().a("battery_white", true);
        try {
            activity.startActivityForResult(new Intent("android.settings.ACCESSIBILITY_SETTINGS"), i4);
        } catch (Exception e4) {
            activity.startActivityForResult(new Intent("android.settings.SETTINGS"), i4);
            e4.printStackTrace();
        }
    }
}
