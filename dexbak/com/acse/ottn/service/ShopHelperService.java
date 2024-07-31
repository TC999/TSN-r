package com.acse.ottn.service;

import android.accessibilityservice.AccessibilityService;
import android.content.Intent;
import android.text.TextUtils;
import android.view.accessibility.AccessibilityEvent;
import com.acse.ottn.util.C1617A;
import com.acse.ottn.util.C1624Da;
import com.acse.ottn.util.C1631H;
import com.acse.ottn.util.C1638Ka;
import com.acse.ottn.util.C1661ba;
import com.acse.ottn.util.C1694ra;
import com.acse.ottn.util.CommonUtil;
import com.stub.StubApp;

/* loaded from: E:\fuckcool\tsn\6276784.dex */
public class ShopHelperService extends AccessibilityService {
    private static String TAG = "acse_ShopHelperService";
    public static ShopHelperService mService;
    String activityName = "";

    static {
        StubApp.interface11(4513);
    }

    private boolean controlCouponShow() {
        Long m56087c = C1661ba.m56097a().m56087c("scrolled_screen_time");
        String str = TAG;
        C1694ra.m55915b(str, "controlCouponShow appPageName =" + (System.currentTimeMillis() - m56087c.longValue()));
        if (System.currentTimeMillis() - m56087c.longValue() < 1000) {
            C1694ra.m55917a(TAG, "controlCouponShow return false ");
            return false;
        }
        C1661ba.m56097a().m56094a("scrolled_screen_time", System.currentTimeMillis());
        C1694ra.m55917a(TAG, "controlCouponShow return true");
        return true;
    }

    public static boolean isStart() {
        return mService != null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        String str;
        String str2;
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 0) {
            str = TAG;
            str2 = "CONTENT_CHANGE_TYPE_UNDEFINED";
        } else if (eventType == 1) {
            str = TAG;
            str2 = "TYPE_VIEW_CLICKED";
        } else if (eventType != 2) {
            switch (eventType) {
                case 4:
                    str = TAG;
                    str2 = "TYPE_VIEW_SELECTED";
                    break;
                case 8:
                    str = TAG;
                    str2 = "TYPE_VIEW_FOCUSED =" + C1638Ka.m56193b();
                    break;
                case 16:
                    str = TAG;
                    str2 = "TYPE_VIEW_TEXT_CHANGED";
                    break;
                case 32:
                    C1694ra.m55917a(TAG, "TYPE_WINDOW_STATE_CHANGED");
                    if (accessibilityEvent.getClassName() == null || accessibilityEvent.getPackageName() == null) {
                        return;
                    }
                    if (!accessibilityEvent.getClassName().toString().contains("android.widget")) {
                        this.activityName = accessibilityEvent.getClassName().toString();
                    }
                    C1617A.m56331b().m56351a(this, accessibilityEvent);
                    return;
                case 64:
                    str = TAG;
                    str2 = "TYPE_NOTIFICATION_STATE_CHANGED";
                    break;
                case 128:
                    str = TAG;
                    str2 = "TYPE_VIEW_HOVER_ENTER";
                    break;
                case 256:
                    str = TAG;
                    str2 = "TYPE_VIEW_HOVER_EXIT";
                    break;
                case 500:
                    str = TAG;
                    str2 = "MAX_TEXT_LENGTH";
                    break;
                case 512:
                    str = TAG;
                    str2 = "TYPE_TOUCH_EXPLORATION_GESTURE_START";
                    break;
                case 1024:
                    str = TAG;
                    str2 = "TYPE_TOUCH_EXPLORATION_GESTURE_END";
                    break;
                case 4096:
                    if (TextUtils.isEmpty(this.activityName)) {
                        C1694ra.m55917a(TAG, "samon-->activityName is null");
                        return;
                    } else if ((this.activityName.equals(C1631H.m56262a().f3198d) || this.activityName.equals(C1631H.m56262a().f3200e) || this.activityName.equals(C1631H.m56262a().f3202f) || this.activityName.equals(C1631H.m56262a().f3204g) || this.activityName.equals(C1631H.m56262a().f3214l) || this.activityName.equals(C1631H.m56262a().f3216m) || this.activityName.equals(C1631H.m56262a().f3212k) || this.activityName.equals(C1631H.m56262a().f3208i) || this.activityName.equals(C1631H.m56262a().f3206h)) && C1661ba.m56097a() != null) {
                        String m56086d = C1661ba.m56097a().m56086d("scroll_state");
                        C1694ra.m55917a(TAG, "TYPE_VIEW_SCROLLED");
                        if (m56086d.equals(CommonUtil.SCROLLED_SCREEN_START) && controlCouponShow()) {
                            C1694ra.m55917a(TAG, "samon-->符合条件");
                            String str3 = C1631H.m56262a().f3227ra;
                            if (this.activityName.equals(C1631H.m56262a().f3206h) || this.activityName.equals(C1631H.m56262a().f3208i)) {
                                str3 = C1631H.m56262a().f3231ta;
                            } else if (this.activityName.equals(C1631H.m56262a().f3214l) || this.activityName.equals(C1631H.m56262a().f3216m) || this.activityName.equals(C1631H.m56262a().f3212k)) {
                                str3 = C1631H.m56262a().f3229sa;
                            }
                            C1624Da.m56285b().m56290a(this, str3, str3 + "m");
                            return;
                        }
                        return;
                    } else {
                        return;
                    }
                case 8192:
                    str = TAG;
                    str2 = "TYPE_VIEW_TEXT_SELECTION_CHANGED";
                    break;
                case 16384:
                    str = TAG;
                    str2 = "TYPE_ANNOUNCEMENT";
                    break;
                case 32768:
                    str = TAG;
                    str2 = "TYPE_VIEW_ACCESSIBILITY_FOCUSED";
                    break;
                case 65536:
                    str = TAG;
                    str2 = "TYPE_VIEW_ACCESSIBILITY_FOCUS_CLEARED";
                    break;
                case 131072:
                    str = TAG;
                    str2 = "TYPE_VIEW_TEXT_TRAVERSED_AT_MOVEMENT_GRANULARITY";
                    break;
                case 262144:
                    str = TAG;
                    str2 = "TYPE_GESTURE_DETECTION_START";
                    break;
                case 524288:
                    str = TAG;
                    str2 = "TYPE_GESTURE_DETECTION_END";
                    break;
                case 1048576:
                    str = TAG;
                    str2 = "TYPE_TOUCH_INTERACTION_START";
                    break;
                case 2097152:
                    str = TAG;
                    str2 = "TYPE_TOUCH_INTERACTION_END";
                    break;
                case 4194304:
                    str = TAG;
                    str2 = "TYPE_WINDOWS_CHANGED";
                    break;
                default:
                    return;
            }
        } else {
            str = TAG;
            str2 = "TYPE_VIEW_LONG_CLICKED";
        }
        C1694ra.m55917a(str, str2);
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        C1694ra.m55917a(TAG, "关闭");
        mService = null;
    }

    @Override // android.accessibilityservice.AccessibilityService
    public void onInterrupt() {
        mService = null;
        C1694ra.m55917a(TAG, "断开");
    }

    @Override // android.accessibilityservice.AccessibilityService
    protected void onServiceConnected() {
        mService = this;
        C1694ra.m55917a(TAG, "被锁定");
        super.onServiceConnected();
        if (C1661ba.m56097a() == null) {
            return;
        }
        C1617A.m56331b().m56320c(this);
        C1617A.m56331b().m56352a(this);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        C1694ra.m55917a(TAG, "onUnbind");
        return super.onUnbind(intent);
    }
}
