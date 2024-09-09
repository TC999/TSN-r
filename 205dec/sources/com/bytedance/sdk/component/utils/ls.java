package com.bytedance.sdk.component.utils;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.SystemClock;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class ls {

    /* renamed from: c  reason: collision with root package name */
    private static final Object f30197c = new Object();

    /* renamed from: w  reason: collision with root package name */
    private static final Map<c, Object> f30200w = new ConcurrentHashMap();
    private static AtomicBoolean xv = new AtomicBoolean(false);
    private static volatile int sr = -1;
    private static volatile long ux = 0;

    /* renamed from: f  reason: collision with root package name */
    private static volatile int f30198f = 60000;

    /* renamed from: r  reason: collision with root package name */
    private static fp f30199r = null;
    private static final AtomicBoolean ev = new AtomicBoolean(false);

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    public interface c {
        void c(Context context, Intent intent, boolean z3, int i4);
    }

    /* loaded from: E:\TSN-r\205dec\6465380.dex */
    private static class w extends BroadcastReceiver {
        private w() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            boolean z3 = false;
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            if (ls.f30200w != null && ls.f30200w.size() > 0) {
                z3 = true;
            }
            ls.w(context, intent, z3, booleanExtra);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(final Context context, final Intent intent, final boolean z3, final boolean z4) {
        if (!z3 && z4) {
            sr = 0;
        } else if (ev.compareAndSet(false, true)) {
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("getNetworkType") { // from class: com.bytedance.sdk.component.utils.ls.1
                @Override // java.lang.Runnable
                public void run() {
                    int unused = ls.sr = z4 ? 0 : ls.w(context);
                    ls.ev.set(false);
                    if (z3) {
                        ls.w(context, intent, ls.sr, z4);
                    }
                }
            });
        }
    }

    private static int xv(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isAvailable()) {
                int type = activeNetworkInfo.getType();
                if (type != 0) {
                    return type != 1 ? 1 : 4;
                }
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                switch (activeNetworkInfo.getSubtype()) {
                    case 1:
                    case 2:
                    case 4:
                    case 7:
                    case 11:
                    case 16:
                        return 2;
                    case 3:
                    case 5:
                    case 6:
                    case 8:
                    case 9:
                    case 10:
                    case 12:
                    case 14:
                    case 15:
                    case 17:
                        return 3;
                    case 13:
                    case 18:
                    case 19:
                        fp fpVar = f30199r;
                        return (fpVar == null || !fpVar.c(context, telephonyManager)) ? 5 : 6;
                    case 20:
                        return 6;
                    default:
                        String subtypeName = activeNetworkInfo.getSubtypeName();
                        return (TextUtils.isEmpty(subtypeName) || !(subtypeName.equalsIgnoreCase("TD-SCDMA") || subtypeName.equalsIgnoreCase("WCDMA") || subtypeName.equalsIgnoreCase("CDMA2000"))) ? 1 : 3;
                }
            }
            return 0;
        } catch (Throwable unused) {
            return 1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void w(Context context, Intent intent, int i4, boolean z3) {
        Map<c, Object> map = f30200w;
        if (map == null || map.size() <= 0) {
            return;
        }
        for (c cVar : map.keySet()) {
            if (cVar != null) {
                cVar.c(context, intent, !z3, i4);
            }
        }
    }

    public static void c(fp fpVar) {
        f30199r = fpVar;
    }

    public static int c(Context context, long j4) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (ux + j4 <= elapsedRealtime) {
            return w(context);
        }
        if (sr == -1) {
            return w(context);
        }
        if (elapsedRealtime - ux >= f30198f) {
            w(context, (Intent) null, false, false);
        }
        return sr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int w(Context context) {
        sr = xv(context);
        ux = SystemClock.elapsedRealtime();
        return sr;
    }

    public static void c(c cVar, Context context) {
        if (cVar == null) {
            return;
        }
        if (!xv.get()) {
            try {
                context.registerReceiver(new w(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                xv.set(true);
            } catch (Throwable unused) {
            }
        }
        f30200w.put(cVar, f30197c);
    }

    public static void c(c cVar) {
        if (cVar == null) {
            return;
        }
        f30200w.remove(cVar);
    }
}
