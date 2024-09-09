package com.acse.ottn;

import android.accessibilityservice.AccessibilityService;
import android.accessibilityservice.AccessibilityServiceInfo;
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
import android.util.Log;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.l0;
import com.acse.ottn.util.HelpShopAppUtil;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.google.gson.Gson;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    public static b f5052f = null;

    /* renamed from: g  reason: collision with root package name */
    public static String f5053g = "acse_AccessibilityUtil";

    /* renamed from: h  reason: collision with root package name */
    public static final int f5054h = 3;

    /* renamed from: i  reason: collision with root package name */
    public static final long f5055i = 60000;

    /* renamed from: d  reason: collision with root package name */
    public CountDownTimer f5059d;

    /* renamed from: a  reason: collision with root package name */
    public boolean f5056a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5057b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f5058c = false;

    /* renamed from: e  reason: collision with root package name */
    public long[] f5060e = new long[3];

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends AccessibilityService.GestureResultCallback {
        public a() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    /* renamed from: com.acse.ottn.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class C0085b extends AccessibilityService.GestureResultCallback {
        public C0085b() {
        }

        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class c extends AccessibilityService.GestureResultCallback {
        @Override // android.accessibilityservice.AccessibilityService.GestureResultCallback
        public void onCompleted(GestureDescription gestureDescription) {
            super.onCompleted(gestureDescription);
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class e implements Consumer<String> {
        public e() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class f implements Consumer<Throwable> {
        public f() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class g implements Consumer<String> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AcseHelpManager.OnAccessiblityStateCallBack f5115a;

        public g(AcseHelpManager.OnAccessiblityStateCallBack onAccessiblityStateCallBack) {
            this.f5115a = onAccessiblityStateCallBack;
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(String str) throws Exception {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.getInt("r") == 1) {
                String string = jSONObject.getString("state");
                if (!"0".equals(jSONObject.getString("save_local"))) {
                    g1.a().b("accessiblity_type", string);
                }
                AcseHelpManager.OnAccessiblityStateCallBack onAccessiblityStateCallBack = this.f5115a;
                if (onAccessiblityStateCallBack != null) {
                    onAccessiblityStateCallBack.onSuccess(string);
                }
            }
        }
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class h implements Consumer<Throwable> {
        public h() {
        }

        @Override // io.reactivex.functions.Consumer
        /* renamed from: a */
        public void accept(Throwable th) throws Exception {
            String str = b.f5053g;
            Log.d(str, "throwable=" + th.getMessage());
        }
    }

    public static b d() {
        if (f5052f == null) {
            synchronized (b.class) {
                if (f5052f == null) {
                    f5052f = new b();
                }
            }
        }
        return f5052f;
    }

    public boolean b() {
        return b1.b().a(HelpShopAppUtil.getContext());
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
                    if (this.f5058c) {
                        return;
                    }
                    e(child);
                }
            }
        }
    }

    public boolean f() {
        int i4;
        String string;
        String b4 = com.acse.ottn.a.c().b(HelpShopAppUtil.getContext());
        try {
            i4 = Settings.Secure.getInt(HelpShopAppUtil.getContext().getContentResolver(), "accessibility_enabled");
        } catch (Exception e4) {
            z1.b("AccessibilityIntroduce", "Error finding setting, default accessibility to not found: " + e4.getMessage());
            i4 = 0;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        if (i4 == 1 && (string = Settings.Secure.getString(HelpShopAppUtil.getContext().getContentResolver(), "enabled_accessibility_services")) != null) {
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().contains(b4)) {
                    return true;
                }
            }
        }
        if (g1.a() != null) {
            g1.a().b("flow_window_state", "1");
            g1.a().a("open_battery_white", false);
            g1.a().a("background_battery_hignt", false);
            g1.a().a("open_battery_white_size", false);
        }
        return false;
    }

    public boolean g() {
        return this.f5056a;
    }

    public final Object h() throws ObjectStreamException {
        return f5052f;
    }

    @RequiresApi(api = 16)
    public void i(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            z1.a(f5053g, "findViewByText2 accessibilityNodeInfo is null");
            return;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText == null || findAccessibilityNodeInfosByText.isEmpty()) {
            return;
        }
        String str2 = f5053g;
        z1.a(str2, "nodeInfoList size =" + findAccessibilityNodeInfosByText.size());
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
            if (accessibilityNodeInfo != null) {
                d().g(accessibilityNodeInfo);
            }
        }
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo j(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            z1.b(f5053g, "findViewByText3 accessibilityNodeInfo is null");
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
                    return f(accessibilityNodeInfo);
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
                    return f(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    public void a(boolean z3) {
        this.f5056a = z3;
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

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo h(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            z1.b(f5053g, "findViewByText1 accessibilityNodeInfo is null");
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

    @RequiresApi(api = 16)
    public void g(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        accessibilityService.performGlobalAction(4096);
    }

    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class d implements l0.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AccessibilityService f5097a;

        public d(AccessibilityService accessibilityService) {
            this.f5097a = accessibilityService;
        }

        @Override // com.acse.ottn.l0.d
        public void a(long j4) {
            if (this.f5097a == null || b.d().f(this.f5097a, "com.tencent.mm:id/gix") == null) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 18) {
                b.d().a(this.f5097a, "com.tencent.mm:id/gix");
            }
            CountDownTimer countDownTimer = b.this.f5059d;
            if (countDownTimer != null) {
                countDownTimer.cancel();
                b.this.f5059d = null;
            }
        }

        @Override // com.acse.ottn.l0.d
        public void a() {
            b.this.f5059d = null;
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
        if (arrayList.size() > i4) {
            return f((AccessibilityNodeInfo) arrayList.get(i4));
        }
        return f((AccessibilityNodeInfo) arrayList.get(0));
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo g(AccessibilityService accessibilityService, String str) {
        return a(accessibilityService, str, false);
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

    @RequiresApi(api = 16)
    public void e(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(150L);
        } catch (InterruptedException e4) {
            e4.printStackTrace();
        }
        accessibilityService.performGlobalAction(1);
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

    public final void c(AccessibilityService accessibilityService) {
        if (g1.a().a("show_red_package")) {
            return;
        }
        long[] jArr = this.f5060e;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.f5060e;
        long j4 = jArr2[1];
        long j5 = jArr2[2];
        if (j4 == j5 || j5 == 0) {
            return;
        }
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        long[] jArr3 = this.f5060e;
        long j6 = jArr3[jArr3.length - 1];
        long j7 = jArr3[0];
    }

    @RequiresApi(api = 16)
    public AccessibilityNodeInfo e(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            z1.b(f5053g, "findViewByText3 accessibilityNodeInfo is null");
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

    public void d(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        CountDownTimer countDownTimer = this.f5059d;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f5059d = null;
        }
        CountDownTimer a4 = l0.a().a(2000, 50, new d(accessibilityService));
        this.f5059d = a4;
        a4.start();
    }

    @RequiresApi(api = 24)
    public boolean b(AccessibilityService accessibilityService, int i4, int i5) {
        Path path = new Path();
        path.moveTo(i4, i5);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 1000L)).build(), new C0085b(), null);
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

    public String e() {
        return TextUtils.isEmpty(g1.a().d("plunin_id")) ? "" : g1.a().d("plunin_id");
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

    @RequiresApi(api = 16)
    public void f(AccessibilityService accessibilityService) {
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
                g(accessibilityNodeInfo);
                return;
            }
        }
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

    public void c() {
        List<AccessibilityServiceInfo> enabledAccessibilityServiceList = ((AccessibilityManager) HelpShopAppUtil.getContext().getSystemService("accessibility")).getEnabledAccessibilityServiceList(-1);
        ArrayList arrayList = new ArrayList();
        for (AccessibilityServiceInfo accessibilityServiceInfo : enabledAccessibilityServiceList) {
            arrayList.add(accessibilityServiceInfo.getResolveInfo().serviceInfo.packageName);
        }
        i2.a().b("accessiblity_list", new Gson().toJson(arrayList));
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

    @RequiresApi(api = 24)
    public boolean a(AccessibilityService accessibilityService, int i4, int i5) {
        Path path = new Path();
        path.moveTo(i4, i5);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 200L)).build(), new a(), null);
    }

    public boolean b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isScrollable()) {
            return false;
        }
        return accessibilityNodeInfo.performAction(4096);
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

    @RequiresApi(api = 24)
    public static boolean a(AccessibilityService accessibilityService, int i4, int i5, int i6, int i7, int i8) {
        Path path = new Path();
        path.moveTo(i4, i5);
        path.lineTo(i6, i7);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, i8)).build(), new c(), null);
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
        new f0().j(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).subscribe(new e(), new f());
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
            String str2 = f5053g;
            z1.b(str2, "findViewByText accessibilityNodeInfo is null text =" + str);
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

    public void a(AcseHelpManager.OnAccessiblityStateCallBack onAccessiblityStateCallBack) {
        if (AcseHelpManager.mIsDebug) {
            if (onAccessiblityStateCallBack != null) {
                onAccessiblityStateCallBack.onSuccess(d().f() ? "1" : "0");
                return;
            }
            return;
        }
        String a4 = g1.a().a("accessiblity_type", "3");
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
        treeMap.put("accessiblitystate", d().f() ? "1" : "0");
        new f0().b(q0.a().a(treeMap, "")).subscribeOn(Schedulers.newThread()).subscribe(new g(onAccessiblityStateCallBack), new h());
    }

    public void a(String str) {
        if (g1.a() != null) {
            g1.a().b("plunin_id", str);
        }
    }
}
