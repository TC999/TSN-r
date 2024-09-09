package com.acse.ottn.service;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import com.acse.ottn.c4;
import com.acse.ottn.g1;
import com.acse.ottn.j0;
import com.acse.ottn.s3;
import com.acse.ottn.z1;
import com.stub.StubApp;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6276784.dex
 */
/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class ShopHelperService extends AccessibilityService {
    private static String TAG = "acse_ShopHelperService";
    public static ShopHelperService mService;
    String activityName = "";

    static {
        StubApp.interface11(5041);
    }

    private boolean controlCouponShow() {
        Long c4 = g1.a().c("scrolled_screen_time");
        String str = TAG;
        z1.b(str, "controlCouponShow appPageName =" + (System.currentTimeMillis() - c4.longValue()));
        if (System.currentTimeMillis() - c4.longValue() < 1000) {
            z1.a(TAG, "controlCouponShow return false ");
            return false;
        }
        g1.a().a("scrolled_screen_time", System.currentTimeMillis());
        z1.a(TAG, "controlCouponShow return true");
        return true;
    }

    public static boolean isStart() {
        return mService != null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 0) {
            z1.a(TAG, "CONTENT_CHANGE_TYPE_UNDEFINED");
        } else if (eventType == 1) {
            z1.a(TAG, "TYPE_VIEW_CLICKED");
            com.acse.ottn.d.b().g(this);
        } else if (eventType != 2) {
            switch (eventType) {
                case 4:
                    z1.a(TAG, "TYPE_VIEW_SELECTED");
                    return;
                case 8:
                    String str = TAG;
                    z1.a(str, "TYPE_VIEW_FOCUSED =" + c4.b());
                    return;
                case 16:
                    z1.a(TAG, "TYPE_VIEW_TEXT_CHANGED");
                    return;
                case 32:
                    z1.a(TAG, "TYPE_WINDOW_STATE_CHANGED");
                    if (accessibilityEvent.getClassName() == null || accessibilityEvent.getPackageName() == null) {
                        return;
                    }
                    if (!accessibilityEvent.getClassName().toString().contains("android.widget")) {
                        this.activityName = accessibilityEvent.getClassName().toString();
                    }
                    com.acse.ottn.d.b().a(this, accessibilityEvent);
                    return;
                case 64:
                    z1.a(TAG, "TYPE_NOTIFICATION_STATE_CHANGED");
                    return;
                case 128:
                    z1.a(TAG, "TYPE_VIEW_HOVER_ENTER");
                    return;
                case 256:
                    z1.a(TAG, "TYPE_VIEW_HOVER_EXIT");
                    return;
                case 500:
                    z1.a(TAG, "MAX_TEXT_LENGTH");
                    return;
                case 512:
                    z1.a(TAG, "TYPE_TOUCH_EXPLORATION_GESTURE_START");
                    return;
                case 1024:
                    z1.a(TAG, "TYPE_TOUCH_EXPLORATION_GESTURE_END");
                    return;
                case 4096:
                    if (TextUtils.isEmpty(this.activityName)) {
                        z1.a(TAG, "samon-->activityName is null");
                        return;
                    } else if ((this.activityName.equals(com.acse.ottn.n.a().f5989b) || this.activityName.equals(com.acse.ottn.n.a().f5991c) || this.activityName.equals(com.acse.ottn.n.a().f5993d) || this.activityName.equals(com.acse.ottn.n.a().f5995e) || this.activityName.equals(com.acse.ottn.n.a().f5997f) || this.activityName.equals(com.acse.ottn.n.a().f6007k) || this.activityName.equals(com.acse.ottn.n.a().f6009l) || this.activityName.equals(com.acse.ottn.n.a().f6005j) || this.activityName.equals(com.acse.ottn.n.a().f6001h) || this.activityName.equals(com.acse.ottn.n.a().f5999g)) && g1.a() != null) {
                        String d4 = g1.a().d("scroll_state");
                        z1.a(TAG, "TYPE_VIEW_SCROLLED");
                        if (d4.equals(j0.f5775q) && controlCouponShow()) {
                            z1.a(TAG, "samon-->\u7b26\u5408\u6761\u4ef6");
                            String str2 = com.acse.ottn.n.a().f6020q0;
                            if (!this.activityName.equals(com.acse.ottn.n.a().f5999g) && !this.activityName.equals(com.acse.ottn.n.a().f6001h)) {
                                if (this.activityName.equals(com.acse.ottn.n.a().f6007k) || this.activityName.equals(com.acse.ottn.n.a().f6009l) || this.activityName.equals(com.acse.ottn.n.a().f6005j)) {
                                    str2 = com.acse.ottn.n.a().f6022r0;
                                }
                            } else {
                                str2 = com.acse.ottn.n.a().f6024s0;
                            }
                            s3 b4 = s3.b();
                            b4.a(this, str2, str2 + "m");
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 8192:
                    z1.a(TAG, "TYPE_VIEW_TEXT_SELECTION_CHANGED");
                    return;
                case 16384:
                    z1.a(TAG, "TYPE_ANNOUNCEMENT");
                    return;
                case 32768:
                    z1.a(TAG, "TYPE_VIEW_ACCESSIBILITY_FOCUSED");
                    return;
                case 65536:
                    z1.a(TAG, "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED");
                    return;
                case 131072:
                    z1.a(TAG, "TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY");
                    return;
                case 262144:
                    z1.a(TAG, "TYPE_GESTURE_DETECTION_START");
                    return;
                case 524288:
                    z1.a(TAG, "TYPE_GESTURE_DETECTION_END");
                    return;
                case 1048576:
                    z1.a(TAG, "TYPE_TOUCH_INTERACTION_START");
                    return;
                case 2097152:
                    z1.a(TAG, "TYPE_TOUCH_INTERACTION_END");
                    return;
                case 4194304:
                    z1.a(TAG, "TYPE_WINDOWS_CHANGED");
                    com.acse.ottn.d.b().g(this);
                    return;
                default:
                    return;
            }
        } else {
            z1.a(TAG, "TYPE_VIEW_LONG_CLICKED");
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        z1.a(TAG, "\u5173\u95ed");
        mService = null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        mService = null;
        z1.a(TAG, "\u65ad\u5f00");
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onServiceConnected() {
        mService = this;
        z1.a(TAG, "\u88ab\u9501\u5b9a");
        super.onServiceConnected();
        if (g1.a() == null) {
            return;
        }
        com.acse.ottn.d.b().d(this);
        com.acse.ottn.d.b().a(this);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        z1.a(TAG, "onUnbind");
        return super.onUnbind(intent);
    }
}
