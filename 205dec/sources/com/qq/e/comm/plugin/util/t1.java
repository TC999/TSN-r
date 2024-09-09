package com.qq.e.comm.plugin.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.PowerManager;
import android.os.SystemClock;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class t1 {

    /* renamed from: a  reason: collision with root package name */
    private static final String f46607a = "t1";

    /* renamed from: b  reason: collision with root package name */
    private static final int f46608b = com.qq.e.comm.plugin.t.c.a("gssst", "APP", "", 0);

    /* renamed from: c  reason: collision with root package name */
    private static volatile boolean f46609c = true;

    /* renamed from: d  reason: collision with root package name */
    private static volatile long f46610d = 0;

    /* renamed from: e  reason: collision with root package name */
    private static volatile long f46611e = 0;

    /* renamed from: f  reason: collision with root package name */
    private static volatile boolean f46612f = true;

    /* renamed from: g  reason: collision with root package name */
    private static Handler f46613g;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.intent.action.SCREEN_OFF".equals(action)) {
                boolean unused = t1.f46609c = false;
            } else if ("android.intent.action.SCREEN_ON".equals(action)) {
                boolean unused2 = t1.f46609c = true;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            t1.b();
        }
    }

    static {
        int i4 = f46608b;
        if (i4 != 1) {
            if (i4 != 2) {
                return;
            }
            e();
            return;
        }
        HandlerThread handlerThread = new HandlerThread("gdt_screen_handler");
        handlerThread.start();
        f46613g = new Handler(handlerThread.getLooper());
    }

    t1() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void b() {
        f46611e = SystemClock.elapsedRealtime();
        try {
            PowerManager powerManager = (PowerManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("power");
            f46612f = Build.VERSION.SDK_INT > 19 ? powerManager.isInteractive() : powerManager.isScreenOn();
        } catch (Exception e4) {
            String str = f46607a;
            d1.a(str, "Check isScreenOn failed:" + e4.getMessage(), e4);
        }
        if (f46611e - f46610d >= 1000) {
            d1.a(f46607a, "stopCheckScreenOn");
        } else {
            f46613g.postDelayed(new b(), 200L);
        }
    }

    public static boolean c() {
        int i4 = f46608b;
        if (i4 != 1) {
            if (i4 != 2) {
                return true;
            }
            return f46609c;
        }
        return d();
    }

    public static boolean d() {
        f46610d = SystemClock.elapsedRealtime();
        if (SystemClock.elapsedRealtime() - f46611e >= 1000) {
            d1.a(f46607a, "startCheckScreenOn");
            b();
        }
        return f46612f;
    }

    private static void e() {
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            com.qq.e.comm.plugin.d0.a.d().a().registerReceiver(new a(), intentFilter);
        } catch (Throwable unused) {
        }
    }
}
