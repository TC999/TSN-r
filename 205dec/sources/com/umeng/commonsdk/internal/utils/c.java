package com.umeng.commonsdk.internal.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.stub.StubApp;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* compiled from: BatteryUtils.java */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f53483a = "BatteryUtils";

    /* renamed from: b  reason: collision with root package name */
    private static boolean f53484b;

    /* renamed from: c  reason: collision with root package name */
    private static Context f53485c;

    /* renamed from: d  reason: collision with root package name */
    private BroadcastReceiver f53486d;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
    /* compiled from: BatteryUtils.java */
    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    private static class a {

        /* renamed from: a  reason: collision with root package name */
        private static final c f53488a = new c();

        private a() {
        }
    }

    public static c a(Context context) {
        if (f53485c == null && context != null) {
            f53485c = StubApp.getOrigApplicationContext(context.getApplicationContext());
        }
        return a.f53488a;
    }

    public synchronized void b() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            f53485c.registerReceiver(this.f53486d, intentFilter);
            f53484b = true;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f53485c, th);
        }
    }

    public synchronized void c() {
        try {
            f53485c.unregisterReceiver(this.f53486d);
            f53484b = false;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f53485c, th);
        }
    }

    private c() {
        this.f53486d = new BroadcastReceiver() { // from class: com.umeng.commonsdk.internal.utils.c.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                try {
                    if (intent.getAction().equals("android.intent.action.BATTERY_CHANGED")) {
                        UMRTLog.i("MobclickRT", "ACTION_BATTERY_CHANGED\uff1abattery info cc.");
                        int i4 = 0;
                        int intExtra = intent.getIntExtra("level", 0);
                        int intExtra2 = intent.getIntExtra("voltage", 0);
                        int intExtra3 = intent.getIntExtra("temperature", 0);
                        int intExtra4 = intent.getIntExtra("status", 0);
                        int i5 = -1;
                        if (intExtra4 != 1) {
                            if (intExtra4 == 2) {
                                i5 = 1;
                            } else if (intExtra4 == 4) {
                                i5 = 0;
                            } else if (intExtra4 == 5) {
                                i5 = 2;
                            }
                        }
                        int intExtra5 = intent.getIntExtra("plugged", 0);
                        if (intExtra5 == 1) {
                            i4 = 1;
                        } else if (intExtra5 == 2) {
                            i4 = 2;
                        }
                        b bVar = new b();
                        bVar.f53477a = intExtra;
                        bVar.f53478b = intExtra2;
                        bVar.f53480d = i5;
                        bVar.f53479c = intExtra3;
                        bVar.f53481e = i4;
                        bVar.f53482f = System.currentTimeMillis();
                        UMWorkDispatch.sendEvent(context, 32771, com.umeng.commonsdk.internal.b.a(c.f53485c).a(), bVar);
                        c.this.c();
                    }
                } catch (Throwable th) {
                    UMCrashManager.reportCrash(c.f53485c, th);
                }
            }
        };
    }

    public synchronized boolean a() {
        return f53484b;
    }
}
