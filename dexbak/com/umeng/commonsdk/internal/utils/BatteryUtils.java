package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.UMInternalConfig;
import com.umeng.commonsdk.internal.UMInternalData;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* renamed from: com.umeng.commonsdk.internal.utils.c */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class BatteryUtils {

    /* renamed from: a */
    private static final String f38847a = "BatteryUtils";

    /* renamed from: b */
    private static boolean f38848b;

    /* renamed from: c */
    private static Context f38849c;

    /* renamed from: d */
    private BroadcastReceiver f38850d;

    /* compiled from: BatteryUtils.java */
    /* renamed from: com.umeng.commonsdk.internal.utils.c$a */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    private static class C13231a {

        /* renamed from: a */
        private static final BatteryUtils f38852a = new BatteryUtils();

        private C13231a() {
        }
    }

    /* renamed from: a */
    public static BatteryUtils m13917a(Context context) {
        if (f38849c == null && context != null) {
            f38849c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return C13231a.f38852a;
    }

    /* renamed from: b */
    public synchronized void m13916b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f38849c.registerReceiver(this.f38850d, intentFilter);
            f38848b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f38849c, th);
        }
    }

    /* renamed from: c */
    public synchronized void m13915c() {
        try {
            f38849c.unregisterReceiver(this.f38850d);
            f38848b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f38849c, th);
        }
    }

    private BatteryUtils() {
        this.f38850d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.m14008i(UMRTLog.RTLOG_TAG, "ACTION_BATTERY_CHANGED：battery info cc.");
                        int i = 0;
                        int intExtra = intent.getIntExtra("level", 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra("status", 0);
                        int i2 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 == 2) {
                                i2 = 1;
                            } else if (intExtra4 == 4) {
                                i2 = 0;
                            } else if (intExtra4 == 5) {
                                i2 = 2;
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 == 1) {
                            i = 1;
                        } else if (intExtra5 == 2) {
                            i = 2;
                        }
                        BatteryInfo batteryInfo = new BatteryInfo();
                        batteryInfo.f38841a = intExtra;
                        batteryInfo.f38842b = intExtra2;
                        batteryInfo.f38844d = i2;
                        batteryInfo.f38843c = intExtra3;
                        batteryInfo.f38845e = i;
                        batteryInfo.f38846f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, UMInternalConfig.f38796h, UMInternalData.m13974a(BatteryUtils.f38849c).m13975a(), batteryInfo);
                        BatteryUtils.this.m13915c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(BatteryUtils.f38849c, th);
                }
            }
        };
    }

    /* renamed from: a */
    public synchronized boolean m13918a() {
        return f38848b;
    }
}
