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
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.acse.ottn.activity.AcseHelpManager;
import com.acse.ottn.p030a.C1249a;
import com.acse.ottn.p042d.C1530i;
import com.baidu.idl.face.platform.common.ConstantHelper;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import io.reactivex.schedulers.Schedulers;
import java.io.ObjectStreamException;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/* renamed from: com.acse.ottn.util.n */
/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class C1684n {

    /* renamed from: a */
    private static C1684n f3341a = null;

    /* renamed from: b */
    private static String f3342b = "acse_AccessibilityUtil";

    /* renamed from: c */
    static final int f3343c = 3;

    /* renamed from: d */
    static final long f3344d = 60000;

    /* renamed from: h */
    public CountDownTimer f3348h;

    /* renamed from: e */
    private boolean f3345e = false;

    /* renamed from: f */
    public boolean f3346f = false;

    /* renamed from: g */
    public boolean f3347g = false;

    /* renamed from: i */
    long[] f3349i = new long[3];

    private C1684n() {
    }

    @RequiresApi(api = 24)
    /* renamed from: a */
    public static boolean m56001a(AccessibilityService accessibilityService, int i, int i2, int i3, int i4, int i5) {
        Path path = new Path();
        path.moveTo(i, i2);
        path.lineTo(i3, i4);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, i5)).build(), new C1672h(), null);
    }

    /* renamed from: c */
    public static C1684n m55975c() {
        if (f3341a == null) {
            synchronized (C1684n.class) {
                if (f3341a == null) {
                    f3341a = new C1684n();
                }
            }
        }
        return f3341a;
    }

    /* renamed from: g */
    private Object m55957g() throws ObjectStreamException {
        return f3341a;
    }

    /* renamed from: g */
    private void m55956g(AccessibilityService accessibilityService) {
        if (C1661ba.m56097a().m56096a("show_red_package")) {
            return;
        }
        long[] jArr = this.f3349i;
        System.arraycopy(jArr, 1, jArr, 0, jArr.length - 1);
        long[] jArr2 = this.f3349i;
        if (jArr2[1] == jArr2[2] || jArr2[2] == 0) {
            return;
        }
        jArr2[jArr2.length - 1] = SystemClock.uptimeMillis();
        long[] jArr3 = this.f3349i;
        long j = jArr3[jArr3.length - 1];
        long j2 = jArr3[0];
    }

    /* renamed from: g */
    private boolean m55954g(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isLongClickable()) {
            return accessibilityNodeInfo.performAction(32);
        }
        m55954g(accessibilityNodeInfo.getParent());
        return false;
    }

    @RequiresApi(api = 16)
    /* renamed from: a */
    public AccessibilityNodeInfo m55996a(AccessibilityService accessibilityService, String str, boolean z) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            String str2 = f3342b;
            C1694ra.m55915b(str2, "findViewByText accessibilityNodeInfo is null text =" + str);
            return null;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && accessibilityNodeInfo.getText() != null && str.equals(accessibilityNodeInfo.getText().toString().trim()) && accessibilityNodeInfo.isClickable() == z) {
                    return accessibilityNodeInfo;
                }
            }
        }
        return null;
    }

    @TargetApi(18)
    /* renamed from: a */
    public AccessibilityNodeInfo m55991a(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
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
    public AccessibilityNodeInfo m55990a(AccessibilityNodeInfo accessibilityNodeInfo, String str, String str2) {
        for (int childCount = accessibilityNodeInfo.getChildCount() - 1; childCount >= 0; childCount--) {
            if (accessibilityNodeInfo.getChild(childCount) != null && !str2.equals(accessibilityNodeInfo.getChild(childCount).getText())) {
                return accessibilityNodeInfo.getChild(childCount);
            }
        }
        return null;
    }

    /* renamed from: a */
    public AccessibilityNodeInfo m55989a(AccessibilityNodeInfo accessibilityNodeInfo, String str, boolean z) {
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
    public void m56005a(long j) {
        try {
            Thread.sleep(j);
        } catch (Exception unused) {
            System.exit(0);
        }
    }

    @RequiresApi(api = 24)
    /* renamed from: a */
    protected void m56003a(AccessibilityService accessibilityService, float f, float f2, int i, AccessibilityService.GestureResultCallback gestureResultCallback) {
        Path path = new Path();
        path.moveTo(f, f2);
        m56000a(accessibilityService, path, 0L, i, gestureResultCallback);
    }

    @RequiresApi(api = 24)
    /* renamed from: a */
    public void m56000a(AccessibilityService accessibilityService, Path path, long j, long j2, AccessibilityService.GestureResultCallback gestureResultCallback) {
        GestureDescription.Builder builder = new GestureDescription.Builder();
        builder.addStroke(new GestureDescription.StrokeDescription(path, j, j2));
        accessibilityService.dispatchGesture(builder.build(), gestureResultCallback, null);
    }

    /* renamed from: a */
    public void m55995a(Context context) {
        Intent intent = new Intent("android.intent.action.MAIN");
        intent.setFlags(268435456);
        intent.addCategory("android.intent.category.HOME");
        context.startActivity(intent);
    }

    /* renamed from: a */
    public void m55993a(AccessibilityEvent accessibilityEvent) {
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
    public void m55988a(AppCompatActivity appCompatActivity, int i) {
        C1530i.m56512b().m56516a(appCompatActivity, i);
    }

    /* renamed from: a */
    public void m55987a(AcseHelpManager.OnAccessiblityStateCallBack onAccessiblityStateCallBack) {
        if (AcseHelpManager.mIsDebug) {
            if (onAccessiblityStateCallBack != null) {
                onAccessiblityStateCallBack.onSuccess(m55975c().m55965e() ? "1" : "0");
                return;
            }
            return;
        }
        String m56093a = C1661ba.m56097a().m56093a("accessiblity_type", "3");
        if (!"3".equals(m56093a)) {
            if (onAccessiblityStateCallBack != null) {
                onAccessiblityStateCallBack.onSuccess(m56093a);
                return;
            }
            return;
        }
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put(ConstantHelper.LOG_VS, "1");
        treeMap.put("accessiblitystate", m55975c().m55965e() ? "1" : "0");
        new C1249a().m57375b(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).subscribe(new C1680l(this, onAccessiblityStateCallBack), new C1682m(this));
    }

    /* renamed from: a */
    public void m55986a(String str) {
        if (C1661ba.m56097a() != null) {
            C1661ba.m56097a().m56088b("plunin_id", str);
        }
    }

    /* renamed from: a */
    public void m55985a(boolean z) {
        this.f3345e = z;
    }

    @SuppressLint({"ObsoleteSdkInt"})
    /* renamed from: a */
    public boolean m56004a(AccessibilityService accessibilityService) {
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
    public boolean m56002a(AccessibilityService accessibilityService, int i, int i2) {
        Path path = new Path();
        path.moveTo(i, i2);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 200L)).build(), new C1668f(this), null);
    }

    @SuppressLint({"ObsoleteSdkInt"})
    /* renamed from: a */
    public boolean m55999a(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
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
    public boolean m55998a(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return m55971c(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    /* renamed from: a */
    public boolean m55997a(AccessibilityService accessibilityService, String str, int i) {
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
        return m55971c((AccessibilityNodeInfo) (arrayList.size() > i ? arrayList.get(i) : arrayList.get(0)));
    }

    /* renamed from: a */
    public boolean m55994a(Context context, Class cls) {
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
    public boolean m55992a(AccessibilityNodeInfo accessibilityNodeInfo) {
        return accessibilityNodeInfo.performAction(8192);
    }

    @RequiresApi(api = 16)
    /* renamed from: b */
    public AccessibilityNodeInfo m55977b(AccessibilityNodeInfo accessibilityNodeInfo, String str) {
        return m55989a(accessibilityNodeInfo, str, false);
    }

    /* renamed from: b */
    public void m55981b(AccessibilityService accessibilityService, AccessibilityNodeInfo accessibilityNodeInfo, String str) {
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
    public void m55976b(String str) {
        TreeMap treeMap = new TreeMap();
        treeMap.put(SocializeProtocolConstants.PROTOCOL_KEY_AK, HelpShopAppUtil.getHmKey());
        HelpShopAppUtil.getInstance();
        treeMap.put("sessionid", HelpShopAppUtil.sessionNewID());
        treeMap.put("is_snt", "0");
        if (TextUtils.isEmpty(str)) {
            str = "n";
        }
        treeMap.put("state", str);
        new C1249a().m57367j(C1652V.m56140a().m56134a(treeMap, "")).subscribeOn(Schedulers.newThread()).subscribe(new C1676j(this), new C1678k(this));
    }

    /* renamed from: b */
    public boolean m55984b() {
        return C1530i.m56512b().m56518a(HelpShopAppUtil.getContext());
    }

    @SuppressLint({"ObsoleteSdkInt"})
    /* renamed from: b */
    public boolean m55983b(AccessibilityService accessibilityService) {
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
    public boolean m55982b(AccessibilityService accessibilityService, int i, int i2) {
        Path path = new Path();
        path.moveTo(i, i2);
        return accessibilityService.dispatchGesture(new GestureDescription.Builder().addStroke(new GestureDescription.StrokeDescription(path, 0L, 1000L)).build(), new C1670g(this), null);
    }

    @RequiresApi(api = 16)
    /* renamed from: b */
    public boolean m55980b(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    return m55971c(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 16)
    /* renamed from: b */
    public boolean m55979b(AccessibilityService accessibilityService, String str, int i) {
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
        return m55971c((AccessibilityNodeInfo) (arrayList.size() > i ? arrayList.get(i) : arrayList.get(0)));
    }

    /* renamed from: b */
    public boolean m55978b(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null || !accessibilityNodeInfo.isScrollable()) {
            return false;
        }
        return accessibilityNodeInfo.performAction(4096);
    }

    /* renamed from: c */
    public void m55974c(AccessibilityService accessibilityService) {
        if (accessibilityService == null) {
            return;
        }
        CountDownTimer countDownTimer = this.f3348h;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.f3348h = null;
        }
        CountDownTimer m56164a = C1648S.m56165a().m56164a(2000, 50, new C1674i(this, accessibilityService));
        this.f3348h = m56164a;
        m56164a.start();
    }

    @TargetApi(18)
    /* renamed from: c */
    public void m55973c(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) == null || findAccessibilityNodeInfosByViewId.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
            if (accessibilityNodeInfo != null) {
                m55958f(accessibilityNodeInfo);
                return;
            }
        }
    }

    @RequiresApi(api = 18)
    /* renamed from: c */
    public boolean m55972c(AccessibilityService accessibilityService, String str, int i) {
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
        return m55954g((AccessibilityNodeInfo) (arrayList.size() > i ? arrayList.get(i) : arrayList.get(0)));
    }

    /* renamed from: c */
    public boolean m55971c(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (accessibilityNodeInfo == null) {
            return false;
        }
        if (accessibilityNodeInfo.isClickable()) {
            return accessibilityNodeInfo.performAction(16);
        }
        m55971c(accessibilityNodeInfo.getParent());
        return false;
    }

    /* renamed from: d */
    public String m55970d() {
        return TextUtils.isEmpty(C1661ba.m56097a().m56086d("plunin_id")) ? "" : C1661ba.m56097a().m56086d("plunin_id");
    }

    @RequiresApi(api = 16)
    /* renamed from: d */
    public void m55969d(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(150L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accessibilityService.performGlobalAction(1);
    }

    @RequiresApi(api = 16)
    /* renamed from: d */
    public void m55968d(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null || (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) == null || findAccessibilityNodeInfosByText.isEmpty()) {
            return;
        }
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
            if (accessibilityNodeInfo != null) {
                m55958f(accessibilityNodeInfo);
                return;
            }
        }
    }

    /* renamed from: d */
    public void m55966d(AccessibilityNodeInfo accessibilityNodeInfo) {
        for (int i = 0; i < accessibilityNodeInfo.getChildCount(); i++) {
            AccessibilityNodeInfo m55991a = m55991a(accessibilityNodeInfo.getChild(i), "com.tencent.mm:id/e7t");
            if (m55991a != null && m55991a.getText() != null && m55991a.getText().toString().contains("[微信红包]")) {
                m55958f(m55991a);
                return;
            }
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: d */
    public boolean m55967d(AccessibilityService accessibilityService, String str, int i) {
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
        return m55954g((AccessibilityNodeInfo) (arrayList.size() > i ? arrayList.get(i) : arrayList.get(0)));
    }

    @RequiresApi(api = 16)
    /* renamed from: e */
    public AccessibilityNodeInfo m55963e(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            C1694ra.m55915b(f3342b, "findViewByText3 accessibilityNodeInfo is null");
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
    /* renamed from: e */
    public void m55964e(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accessibilityService.performGlobalAction(8192);
    }

    @RequiresApi(api = 18)
    /* renamed from: e */
    public void m55962e(AccessibilityNodeInfo accessibilityNodeInfo) {
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
                    if (this.f3347g) {
                        return;
                    }
                    m55962e(child);
                }
            }
        }
    }

    /* renamed from: e */
    public boolean m55965e() {
        int i;
        String string;
        String str = C1666e.m56042c().m56044b(HelpShopAppUtil.getContext()) + "/com.acse.ottn.service.ShopHelperService";
        try {
            i = Settings.Secure.getInt(HelpShopAppUtil.getContext().getContentResolver(), "accessibility_enabled");
        } catch (Exception e) {
            C1694ra.m55915b("AccessibilityIntroduce", "Error finding setting, default accessibility to not found: " + e.getMessage());
            i = 0;
        }
        TextUtils.SimpleStringSplitter simpleStringSplitter = new TextUtils.SimpleStringSplitter(':');
        if (i == 1 && (string = Settings.Secure.getString(HelpShopAppUtil.getContext().getContentResolver(), "enabled_accessibility_services")) != null) {
            simpleStringSplitter.setString(string);
            while (simpleStringSplitter.hasNext()) {
                if (simpleStringSplitter.next().equalsIgnoreCase(str)) {
                    return true;
                }
            }
        }
        if (C1661ba.m56097a() != null) {
            C1661ba.m56097a().m56088b("flow_window_state", "1");
            C1661ba.m56097a().m56092a("open_battery_white", false);
            C1661ba.m56097a().m56092a("background_battery_hignt", false);
            C1661ba.m56097a().m56092a("open_battery_white_size", false);
        }
        return false;
    }

    @TargetApi(18)
    /* renamed from: f */
    public AccessibilityNodeInfo m55959f(AccessibilityService accessibilityService, String str) {
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
    /* renamed from: f */
    public void m55960f(AccessibilityService accessibilityService) {
        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        accessibilityService.performGlobalAction(4096);
    }

    /* renamed from: f */
    public void m55958f(AccessibilityNodeInfo accessibilityNodeInfo) {
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

    /* renamed from: f */
    public boolean m55961f() {
        return this.f3345e;
    }

    @RequiresApi(api = 16)
    /* renamed from: g */
    public AccessibilityNodeInfo m55955g(AccessibilityService accessibilityService, String str) {
        return m55996a(accessibilityService, str, false);
    }

    @RequiresApi(api = 16)
    /* renamed from: h */
    public AccessibilityNodeInfo m55953h(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            C1694ra.m55915b(f3342b, "findViewByText1 accessibilityNodeInfo is null");
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
    /* renamed from: i */
    public void m55952i(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            C1694ra.m55917a(f3342b, "findViewByText2 accessibilityNodeInfo is null");
            return;
        }
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str);
        if (findAccessibilityNodeInfosByText == null || findAccessibilityNodeInfosByText.isEmpty()) {
            return;
        }
        String str2 = f3342b;
        C1694ra.m55917a(str2, "nodeInfoList size =" + findAccessibilityNodeInfosByText.size());
        for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
            if (accessibilityNodeInfo != null) {
                m55975c().m55958f(accessibilityNodeInfo);
            }
        }
    }

    @RequiresApi(api = 16)
    /* renamed from: j */
    public AccessibilityNodeInfo m55951j(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            C1694ra.m55915b(f3342b, "findViewByText3 accessibilityNodeInfo is null");
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
    /* renamed from: k */
    public List<AccessibilityNodeInfo> m55950k(AccessibilityService accessibilityService, String str) {
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow == null) {
            return null;
        }
        return rootInActiveWindow.findAccessibilityNodeInfosByViewId(str);
    }

    @RequiresApi(api = 16)
    /* renamed from: l */
    public boolean m55949l(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByText = rootInActiveWindow.findAccessibilityNodeInfosByText(str)) != null && !findAccessibilityNodeInfosByText.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByText) {
                if (accessibilityNodeInfo != null && (accessibilityNodeInfo.getText().equals(str) || accessibilityNodeInfo.getContentDescription().equals(str))) {
                    return m55954g(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }

    @RequiresApi(api = 18)
    /* renamed from: m */
    public boolean m55948m(AccessibilityService accessibilityService, String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId;
        AccessibilityNodeInfo rootInActiveWindow = accessibilityService.getRootInActiveWindow();
        if (rootInActiveWindow != null && (findAccessibilityNodeInfosByViewId = rootInActiveWindow.findAccessibilityNodeInfosByViewId(str)) != null && !findAccessibilityNodeInfosByViewId.isEmpty()) {
            for (AccessibilityNodeInfo accessibilityNodeInfo : findAccessibilityNodeInfosByViewId) {
                if (accessibilityNodeInfo != null) {
                    return m55954g(accessibilityNodeInfo);
                }
            }
        }
        return false;
    }
}
