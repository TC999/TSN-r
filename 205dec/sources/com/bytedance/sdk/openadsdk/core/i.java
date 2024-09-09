package com.bytedance.sdk.openadsdk.core;

import android.annotation.SuppressLint;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.stub.StubApp;
import java.net.NetworkInterface;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6465380.dex */
public class i {
    private static volatile boolean ba = false;
    private static volatile String bk = null;

    /* renamed from: c  reason: collision with root package name */
    private static String f33726c = null;
    private static volatile boolean ck = false;
    private static volatile String eq = null;

    /* renamed from: f  reason: collision with root package name */
    private static volatile String f33727f = null;
    private static volatile String fp = null;
    private static volatile boolean gb = false;
    private static volatile String gd = null;

    /* renamed from: i  reason: collision with root package name */
    private static volatile boolean f33728i = false;
    private static volatile String ia = null;

    /* renamed from: j  reason: collision with root package name */
    private static volatile boolean f33729j = false;
    private static volatile boolean ls = false;
    private static volatile long me = 0;

    /* renamed from: n  reason: collision with root package name */
    private static volatile boolean f33731n = false;

    /* renamed from: q  reason: collision with root package name */
    private static volatile boolean f33733q = false;

    /* renamed from: r  reason: collision with root package name */
    private static volatile String f33734r = null;

    /* renamed from: s  reason: collision with root package name */
    private static volatile String f33735s = null;
    private static volatile String sr = null;

    /* renamed from: t  reason: collision with root package name */
    private static volatile String f33736t = null;

    /* renamed from: u  reason: collision with root package name */
    private static volatile boolean f33737u = false;
    private static volatile String ux = null;

    /* renamed from: w  reason: collision with root package name */
    private static volatile String f33738w = "";
    private static volatile boolean wv;
    private static volatile WifiInfo wx;
    private static volatile TelephonyManager xk;
    private static volatile String xv;

    /* renamed from: y  reason: collision with root package name */
    private static volatile boolean f33739y;
    private static volatile String ys;
    private static volatile WifiManager yu;

    /* renamed from: z  reason: collision with root package name */
    private static volatile boolean f33740z;
    private static AtomicBoolean ev = new AtomicBoolean(false);

    /* renamed from: p  reason: collision with root package name */
    private static volatile String f33732p = "";

    /* renamed from: k  reason: collision with root package name */
    private static volatile String f33730k = "";

    /* renamed from: a  reason: collision with root package name */
    private static volatile boolean f33725a = true;
    private static volatile String fz = null;

    public static void a() {
        TelephonyManager c4;
        if (f33733q) {
            return;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = k.sr().ux();
        if ((ux2 == null || ux2.xv()) && com.bytedance.sdk.openadsdk.core.j.w.c(ls.getContext(), "android.permission.READ_PHONE_STATE") == 0 && (c4 = c()) != null) {
            synchronized (i.class) {
                f33733q = true;
                if (TextUtils.isEmpty(ux)) {
                    try {
                        if (Build.VERSION.SDK_INT >= 26) {
                            ux = c4.getImei();
                        } else {
                            ux = c4.getDeviceId();
                        }
                    } catch (Throwable unused) {
                    }
                    com.bytedance.sdk.openadsdk.tools.w.w(6, ux);
                }
                if (TextUtils.isEmpty(gd)) {
                    try {
                        gd = c4.getSubscriberId();
                    } catch (Throwable unused2) {
                    }
                }
            }
        }
    }

    private static String ba() {
        String xv2 = com.bytedance.sdk.openadsdk.core.xv.ux.c().xv("mac_address", 864000000L);
        if (TextUtils.isEmpty(xv2)) {
            String w3 = w("wlan0");
            if (TextUtils.isEmpty(w3)) {
                w3 = w("eth0");
            }
            if (TextUtils.isEmpty(w3)) {
                w3 = "DU:MM:YA:DD:RE:SS";
            }
            com.bytedance.sdk.openadsdk.core.xv.ux.c().ux("mac_address", w3);
            return w3;
        }
        return xv2;
    }

    public static String bk() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = k.sr().ux();
        if (ux2 == null || ux2.xv()) {
            if (!TextUtils.isEmpty(f33732p)) {
                return f33732p;
            }
            if (f33731n) {
                return f33732p;
            }
            synchronized (i.class) {
                if (f33731n) {
                    return f33732p;
                }
                TelephonyManager c4 = c();
                if (c4 == null) {
                    return f33732p;
                }
                try {
                    f33732p = c4.getSimOperator();
                } catch (Throwable unused) {
                }
                f33731n = true;
                return f33732p;
            }
        }
        return "";
    }

    public static TelephonyManager c() {
        if (xk != null) {
            return xk;
        }
        synchronized (i.class) {
            if (xk != null) {
                return xk;
            }
            xk = (TelephonyManager) ls.getContext().getSystemService("phone");
            return xk;
        }
    }

    private static synchronized void ck() {
        String valueOf;
        String valueOf2;
        synchronized (i.class) {
            if (wv) {
                return;
            }
            if (Build.VERSION.SDK_INT < 22) {
                return;
            }
            synchronized (i.class) {
                wv = true;
                SubscriptionManager subscriptionManager = (SubscriptionManager) ls.getContext().getSystemService("telephony_subscription_service");
                if (subscriptionManager.getActiveSubscriptionInfoCount() < 2) {
                    return;
                }
                List<SubscriptionInfo> activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList();
                if (activeSubscriptionInfoList.size() < 2) {
                    return;
                }
                for (int i4 = 0; i4 < 2; i4++) {
                    SubscriptionInfo subscriptionInfo = activeSubscriptionInfoList.get(i4);
                    if (Build.VERSION.SDK_INT >= 29) {
                        valueOf = subscriptionInfo.getMccString();
                        valueOf2 = subscriptionInfo.getMncString();
                    } else {
                        valueOf = String.valueOf(subscriptionInfo.getMcc());
                        valueOf2 = String.valueOf(subscriptionInfo.getMnc());
                    }
                    if (i4 == 0) {
                        if (!TextUtils.isEmpty(valueOf)) {
                            bk = valueOf;
                        }
                        if (!TextUtils.isEmpty(valueOf2)) {
                            ys = valueOf2;
                        }
                    } else {
                        if (!TextUtils.isEmpty(valueOf)) {
                            f33736t = valueOf;
                        }
                        if (!TextUtils.isEmpty(valueOf2)) {
                            fp = valueOf2;
                        }
                    }
                }
            }
        }
    }

    public static String ev() {
        if (!TextUtils.isEmpty(f33734r)) {
            return f33734r;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = k.sr().ux();
        if (ux2 == null || (ux2.sr() && ux2.c())) {
            return gb();
        }
        return null;
    }

    @SuppressLint({"HardwareIds"})
    public static String f() {
        if (!TextUtils.isEmpty(ux)) {
            return ux;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = k.sr().ux();
        return c(ux2, ux2 != null && ux2.xv());
    }

    public static String fp() {
        n();
        return f33736t;
    }

    public static String fz() {
        if (!TextUtils.isEmpty(fz)) {
            return fz;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = k.sr().ux();
        if (ux2 != null && !ux2.sr()) {
            return ux2.p();
        }
        return y();
    }

    private static String gb() {
        if (ls) {
            return f33734r;
        }
        synchronized (i.class) {
            if (ls) {
                return f33734r;
            }
            f33734r = k();
            ls = true;
            return f33734r;
        }
    }

    public static String gd() {
        if (TextUtils.isEmpty(f33734r) && !ls) {
            if (ev.get()) {
                return null;
            }
            ev.set(true);
            com.bytedance.sdk.component.gd.ev.w(new com.bytedance.sdk.component.gd.p("") { // from class: com.bytedance.sdk.openadsdk.core.i.1
                @Override // java.lang.Runnable
                public void run() {
                    i.ev();
                    i.ev.set(false);
                }
            });
            return null;
        }
        return f33734r;
    }

    public static String ia() {
        n();
        return ys;
    }

    private static String j() {
        if (gb) {
            return gd;
        }
        synchronized (i.class) {
            if (gb) {
                return gd;
            } else if (f33733q) {
                return ux;
            } else {
                TelephonyManager c4 = c();
                if (c4 == null) {
                    return gd;
                }
                try {
                    gd = c4.getSubscriberId();
                } catch (Throwable unused) {
                }
                gb = true;
                return gd;
            }
        }
    }

    public static String k() {
        try {
            WifiInfo w3 = w();
            if (w3 == null) {
                return "02:00:00:00:00:00";
            }
            String bssid = w3.getBSSID();
            return TextUtils.isEmpty(bssid) ? "02:00:00:00:00:00" : bssid;
        } catch (Exception unused) {
            return "02:00:00:00:00:00";
        }
    }

    private static String ls() {
        WifiInfo w3;
        if (f33729j) {
            return f33727f;
        }
        synchronized (i.class) {
            if (f33729j) {
                return f33727f;
            }
            try {
                w3 = w();
            } catch (Throwable unused) {
            }
            if (w3 == null) {
                return f33727f;
            }
            f33727f = w3.getSSID();
            f33729j = true;
            return f33727f;
        }
    }

    private static void n() {
        String str;
        String str2;
        if (f33740z) {
            return;
        }
        synchronized (i.class) {
            if (f33740z) {
                return;
            }
            String str3 = null;
            try {
                str = c().getNetworkOperator();
            } catch (Throwable unused) {
                str = null;
            }
            if (TextUtils.isEmpty(str) || str.length() < 5) {
                str = bk();
            }
            if (TextUtils.isEmpty(str) || str.length() <= 4) {
                str2 = null;
            } else {
                str3 = str.substring(0, 3);
                str2 = str.substring(3);
            }
            if (!TextUtils.isEmpty(str3)) {
                bk = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                ys = str2;
            }
            ck();
            f33740z = true;
        }
    }

    public static String p() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = k.sr().ux();
        if (ux2 == null || ux2.xv()) {
            if (!TextUtils.isEmpty(f33735s)) {
                return f33735s;
            }
            if (ba) {
                return f33735s;
            }
            synchronized (i.class) {
                if (ba) {
                    return f33735s;
                }
                if (Build.VERSION.SDK_INT >= 28) {
                    try {
                        f33735s = Build.getSerial();
                    } catch (Throwable unused) {
                    }
                } else {
                    f33735s = Build.SERIAL;
                }
                ba = true;
                return f33735s;
            }
        }
        return null;
    }

    private static WifiManager q() {
        if (yu != null) {
            return yu;
        }
        synchronized (i.class) {
            if (yu != null) {
                return yu;
            }
            yu = (WifiManager) StubApp.getOrigApplicationContext(ls.getContext().getApplicationContext()).getSystemService("wifi");
            return yu;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String r() {
        if (!TextUtils.isEmpty(gd)) {
            return gd;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = k.sr().ux();
        if (ux2 == null || ux2.xv()) {
            return j();
        }
        return null;
    }

    public static String s() {
        n();
        return fp;
    }

    public static String sr() {
        if (!TextUtils.isEmpty(ia)) {
            return ia;
        }
        ia = String.valueOf(Build.TIME);
        return ia;
    }

    public static boolean t() {
        if (ck) {
            return f33725a;
        }
        synchronized (i.class) {
            if (ck) {
                return f33725a;
            }
            try {
                int simState = c().getSimState();
                if (1 == simState) {
                    f33725a = false;
                }
                if (simState == 0) {
                    f33725a = false;
                }
                ck = true;
            } catch (Throwable unused) {
            }
            return f33725a;
        }
    }

    public static String u() {
        if (!TextUtils.isEmpty(f33738w)) {
            return f33738w;
        }
        f33738w = com.bytedance.sdk.component.utils.j.c();
        return f33738w;
    }

    public static String ux() {
        if (!TextUtils.isEmpty(sr)) {
            return sr;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = k.sr().ux();
        if (ux2 != null && eq.f33190w >= 4600 && !ux2.f()) {
            if (eq.f33190w >= 4900) {
                return ux2.a();
            }
            return null;
        } else if (f33737u) {
            return sr;
        } else {
            synchronized (i.class) {
                if (f33737u) {
                    return sr;
                }
                sr = z();
                com.bytedance.sdk.openadsdk.tools.w.w(9, sr);
                return sr;
            }
        }
    }

    public static WifiInfo w() {
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = k.sr().ux();
        if (ux2 != null && (!ux2.sr() || !ux2.c())) {
            return wx;
        }
        if (wx != null) {
            return wx;
        }
        synchronized (i.class) {
            if (wx != null) {
                return wx;
            }
            WifiManager q3 = q();
            if (q3 == null) {
                return wx;
            }
            wx = q3.getConnectionInfo();
            return wx;
        }
    }

    public static String xv() {
        if (!TextUtils.isEmpty(xv)) {
            return xv;
        }
        xv = xv.c().w("did", f33726c);
        return xv;
    }

    private static String y() {
        if (f33739y) {
            return fz;
        }
        synchronized (i.class) {
            if (f33739y) {
                return fz;
            }
            fz = ba();
            f33739y = true;
            return fz;
        }
    }

    public static String ys() {
        try {
            n();
            if (!TextUtils.isEmpty(bk)) {
                return bk;
            }
            if (!c(me, 60000L)) {
                return eq;
            }
            if (t()) {
                int i4 = ls.getContext().getResources().getConfiguration().mcc;
                String valueOf = i4 != 0 ? String.valueOf(i4) : bk;
                eq = valueOf;
                me = System.currentTimeMillis();
                return valueOf;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x0025, code lost:
        if (r2.length() < 13) goto L19;
     */
    @android.annotation.SuppressLint({"TrulyRandom", "HardwareIds"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static synchronized java.lang.String z() {
        /*
            java.lang.Class<com.bytedance.sdk.openadsdk.core.i> r0 = com.bytedance.sdk.openadsdk.core.i.class
            monitor-enter(r0)
            android.content.Context r1 = com.bytedance.sdk.openadsdk.core.ls.getContext()     // Catch: java.lang.Throwable -> L2b
            r2 = 0
            if (r1 != 0) goto Lc
            monitor-exit(r0)
            return r2
        Lc:
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L2b
            java.lang.String r3 = "android_id"
            java.lang.String r2 = android.provider.Settings.Secure.getString(r1, r3)     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L2b
            r1 = 1
            com.bytedance.sdk.openadsdk.core.i.f33737u = r1     // Catch: java.lang.Exception -> L19 java.lang.Throwable -> L2b
        L19:
            boolean r1 = android.text.TextUtils.isEmpty(r2)     // Catch: java.lang.Throwable -> L2b
            if (r1 != 0) goto L27
            int r1 = r2.length()     // Catch: java.lang.Throwable -> L2b
            r3 = 13
            if (r1 >= r3) goto L29
        L27:
            java.lang.String r2 = ""
        L29:
            monitor-exit(r0)
            return r2
        L2b:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.core.i.z():java.lang.String");
    }

    public static String sr(com.bytedance.sdk.openadsdk.core.j.c cVar) {
        if (TextUtils.isEmpty(f33734r) && !ls) {
            if (cVar.w() && cVar.xv()) {
                return gb();
            }
            return null;
        }
        return f33734r;
    }

    public static String xv(com.bytedance.sdk.openadsdk.core.j.c cVar) {
        if (TextUtils.isEmpty(f33727f) && !f33729j) {
            if (cVar.w() && cVar.xv()) {
                return ls();
            }
            return null;
        }
        return f33727f;
    }

    public static String xv(boolean z3) {
        if (!TextUtils.isEmpty(fz)) {
            return fz;
        }
        com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = k.sr().ux();
        if (ux2 != null && !z3) {
            return ux2.p();
        }
        return y();
    }

    public static void c(String str) {
        if (com.bytedance.sdk.openadsdk.c.c.c.c() != null) {
            com.bytedance.sdk.openadsdk.c.c.c.c().c(str);
        }
        if (TextUtils.isEmpty(str) || str.equals(xv)) {
            return;
        }
        xv.c().c("did", str);
        xv = str;
    }

    public static String c(boolean z3) {
        if (!TextUtils.isEmpty(ux)) {
            return ux;
        }
        return c(k.sr().ux(), z3);
    }

    @SuppressLint({"HardwareIds"})
    public static String w(boolean z3) {
        if (TextUtils.isEmpty(gd)) {
            if (z3) {
                return j();
            }
            return null;
        }
        return gd;
    }

    public static String ux(com.bytedance.sdk.openadsdk.core.j.c cVar) {
        if (TextUtils.isEmpty(fz) && !f33739y) {
            com.bytedance.sdk.openadsdk.ys.w.xv.sr ux2 = k.sr().ux();
            if (ux2 != null && !cVar.w()) {
                return ux2.p();
            }
            return y();
        }
        return fz;
    }

    public static String w(com.bytedance.sdk.openadsdk.core.j.c cVar) {
        if (TextUtils.isEmpty(gd) && !gb && !f33733q) {
            if (cVar.c()) {
                return j();
            }
            return null;
        }
        return gd;
    }

    public static String c(com.bytedance.sdk.openadsdk.core.j.c cVar) {
        if (TextUtils.isEmpty(ux) && !f33728i) {
            return c(k.sr().ux(), cVar.c());
        }
        return ux;
    }

    public static String w(boolean z3, boolean z4) {
        if (TextUtils.isEmpty(f33734r)) {
            if (z3 && z4) {
                return gb();
            }
            return null;
        }
        return f33734r;
    }

    private static String c(com.bytedance.sdk.openadsdk.ys.w.xv.sr srVar, boolean z3) {
        if (srVar != null && !z3) {
            String gd2 = srVar.gd();
            ux = gd2;
            com.bytedance.sdk.openadsdk.tools.w.w(6, gd2);
            return gd2;
        } else if (f33728i) {
            return ux;
        } else {
            synchronized (i.class) {
                if (f33728i) {
                    return ux;
                } else if (f33733q) {
                    return ux;
                } else {
                    if (com.bytedance.sdk.openadsdk.core.j.w.c(ls.getContext(), "android.permission.READ_PHONE_STATE") == 0) {
                        f33733q = true;
                    }
                    TelephonyManager c4 = c();
                    if (c4 == null) {
                        return ux;
                    }
                    try {
                        if (Build.VERSION.SDK_INT >= 26) {
                            ux = c4.getImei();
                        } else {
                            ux = c4.getDeviceId();
                        }
                    } catch (Throwable unused) {
                    }
                    f33728i = true;
                    com.bytedance.sdk.openadsdk.tools.w.w(6, ux);
                    return ux;
                }
            }
        }
    }

    @SuppressLint({"NewApi"})
    private static String w(String str) {
        try {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (str == null || networkInterface.getName().equalsIgnoreCase(str)) {
                    byte[] hardwareAddress = networkInterface.getHardwareAddress();
                    if (hardwareAddress == null) {
                        return "";
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i4 = 0; i4 < length; i4++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i4])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    return sb.toString();
                }
            }
        } catch (Throwable unused) {
        }
        return "";
    }

    public static String c(boolean z3, boolean z4) {
        if (TextUtils.isEmpty(f33727f)) {
            if (z3 && z4) {
                return ls();
            }
            return null;
        }
        return f33727f;
    }

    private static boolean c(long j4, long j5) {
        return System.currentTimeMillis() - j4 > j5;
    }
}
