package com.autonavi.aps.amapapi.restruct;

import android.content.ContentResolver;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.col.p0003l.k9;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: WifiManagerWrapper.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class k {

    /* renamed from: d  reason: collision with root package name */
    static long f11863d;

    /* renamed from: e  reason: collision with root package name */
    static long f11864e;

    /* renamed from: f  reason: collision with root package name */
    static long f11865f;

    /* renamed from: g  reason: collision with root package name */
    public static long f11866g;

    /* renamed from: h  reason: collision with root package name */
    static long f11867h;

    /* renamed from: v  reason: collision with root package name */
    public static HashMap<String, Long> f11868v = new HashMap<>(36);

    /* renamed from: w  reason: collision with root package name */
    public static long f11869w = 0;

    /* renamed from: x  reason: collision with root package name */
    static int f11870x = 0;

    /* renamed from: z  reason: collision with root package name */
    public static long f11871z = 0;
    private com.autonavi.aps.amapapi.c E;

    /* renamed from: a  reason: collision with root package name */
    WifiManager f11872a;

    /* renamed from: i  reason: collision with root package name */
    Context f11875i;

    /* renamed from: t  reason: collision with root package name */
    i f11886t;

    /* renamed from: b  reason: collision with root package name */
    ArrayList<k9> f11873b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    ArrayList<k9> f11874c = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    boolean f11876j = false;

    /* renamed from: k  reason: collision with root package name */
    StringBuilder f11877k = null;

    /* renamed from: l  reason: collision with root package name */
    boolean f11878l = true;

    /* renamed from: m  reason: collision with root package name */
    boolean f11879m = true;

    /* renamed from: n  reason: collision with root package name */
    boolean f11880n = true;
    private volatile j B = null;

    /* renamed from: o  reason: collision with root package name */
    String f11881o = null;

    /* renamed from: p  reason: collision with root package name */
    TreeMap<Integer, k9> f11882p = null;

    /* renamed from: q  reason: collision with root package name */
    public boolean f11883q = true;

    /* renamed from: r  reason: collision with root package name */
    public boolean f11884r = true;

    /* renamed from: s  reason: collision with root package name */
    public boolean f11885s = false;
    private String C = "";

    /* renamed from: u  reason: collision with root package name */
    long f11887u = 0;

    /* renamed from: y  reason: collision with root package name */
    ConnectivityManager f11888y = null;
    private long D = PolicyConfig.mServerBusyRetryBaseInternal;
    volatile boolean A = false;

    public k(Context context, WifiManager wifiManager, Handler handler) {
        this.f11872a = wifiManager;
        this.f11875i = context;
        i iVar = new i(context, "wifiAgee", handler);
        this.f11886t = iVar;
        iVar.a();
    }

    private void A() {
        try {
            if (com.autonavi.aps.amapapi.utils.j.c(this.f11875i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                this.f11884r = this.f11872a.isWifiEnabled();
            }
        } catch (Throwable unused) {
            com.autonavi.aps.amapapi.utils.d.b();
        }
    }

    private boolean B() {
        this.f11883q = v();
        A();
        if (this.f11883q && this.f11878l) {
            if (f11865f == 0) {
                return true;
            }
            if (com.autonavi.aps.amapapi.utils.j.b() - f11865f >= 4900 && com.autonavi.aps.amapapi.utils.j.b() - f11866g >= 1500) {
                com.autonavi.aps.amapapi.utils.j.b();
                return true;
            }
        }
        return false;
    }

    public static long b() {
        return ((com.autonavi.aps.amapapi.utils.j.b() - f11869w) / 1000) + 1;
    }

    public static String p() {
        return String.valueOf(com.autonavi.aps.amapapi.utils.j.b() - f11866g);
    }

    private List<k9> r() {
        List<ScanResult> list;
        if (this.f11872a != null) {
            try {
                if (com.autonavi.aps.amapapi.utils.j.c(this.f11875i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    list = this.f11872a.getScanResults();
                } else {
                    com.autonavi.aps.amapapi.utils.b.a(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");
                    list = null;
                }
                HashMap<String, Long> hashMap = new HashMap<>(36);
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                }
                if (f11868v.isEmpty() || !f11868v.equals(hashMap)) {
                    f11868v = hashMap;
                    f11869w = com.autonavi.aps.amapapi.utils.j.b();
                }
                this.f11881o = null;
                ArrayList arrayList = new ArrayList();
                this.C = "";
                this.B = m();
                if (a(this.B)) {
                    this.C = this.B.a();
                }
                if (list != null && list.size() > 0) {
                    int size = list.size();
                    for (int i4 = 0; i4 < size; i4++) {
                        ScanResult scanResult2 = list.get(i4);
                        k9 k9Var = new k9(!TextUtils.isEmpty(this.C) && this.C.equals(scanResult2.BSSID));
                        k9Var.f8254b = scanResult2.SSID;
                        k9Var.f8256d = scanResult2.frequency;
                        k9Var.f8257e = scanResult2.timestamp;
                        k9Var.f8253a = k9.a(scanResult2.BSSID);
                        k9Var.f8255c = (short) scanResult2.level;
                        short elapsedRealtime = (short) ((SystemClock.elapsedRealtime() - (scanResult2.timestamp / 1000)) / 1000);
                        k9Var.f8259g = elapsedRealtime;
                        if (elapsedRealtime < 0) {
                            k9Var.f8259g = (short) 0;
                        }
                        k9Var.f8258f = com.autonavi.aps.amapapi.utils.j.b();
                        arrayList.add(k9Var);
                    }
                }
                this.f11886t.a((List) arrayList);
                return arrayList;
            } catch (SecurityException e4) {
                this.f11881o = e4.getMessage();
            } catch (Throwable th) {
                this.f11881o = null;
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    private int s() {
        WifiManager wifiManager = this.f11872a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    private boolean t() {
        long b4 = com.autonavi.aps.amapapi.utils.j.b() - f11863d;
        if (b4 < 4900) {
            return false;
        }
        if (!u() || b4 >= 9900) {
            if (f11870x > 1) {
                long j4 = this.D;
                if (j4 == PolicyConfig.mServerBusyRetryBaseInternal) {
                    j4 = com.autonavi.aps.amapapi.utils.a.o() != -1 ? com.autonavi.aps.amapapi.utils.a.o() : 30000L;
                }
                if (Build.VERSION.SDK_INT >= 28 && b4 < j4) {
                    return false;
                }
            }
            if (this.f11872a != null) {
                f11863d = com.autonavi.aps.amapapi.utils.j.b();
                int i4 = f11870x;
                if (i4 < 2) {
                    f11870x = i4 + 1;
                }
                if (com.autonavi.aps.amapapi.utils.j.c(this.f11875i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF")) {
                    return this.f11872a.startScan();
                }
                com.autonavi.aps.amapapi.utils.b.a(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
            }
            return false;
        }
        return false;
    }

    private boolean u() {
        if (this.f11888y == null) {
            this.f11888y = (ConnectivityManager) com.autonavi.aps.amapapi.utils.j.a(this.f11875i, "connectivity");
        }
        return a(this.f11888y);
    }

    private boolean v() {
        if (this.f11872a == null) {
            return false;
        }
        return com.autonavi.aps.amapapi.utils.j.g(this.f11875i);
    }

    private void w() {
        if (B()) {
            long b4 = com.autonavi.aps.amapapi.utils.j.b();
            if (b4 - f11864e >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                this.f11873b.clear();
                f11867h = f11866g;
            }
            x();
            if (b4 - f11864e >= ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
                for (int i4 = 20; i4 > 0 && f11866g == f11867h; i4--) {
                    try {
                        Thread.sleep(150L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    private void x() {
        if (B()) {
            try {
                if (t()) {
                    f11865f = com.autonavi.aps.amapapi.utils.j.b();
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManager", "wifiScan");
            }
        }
    }

    private void y() {
        if (f11867h != f11866g) {
            List<k9> list = null;
            try {
                list = r();
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "WifiManager", "updateScanResult");
            }
            f11867h = f11866g;
            if (list != null) {
                this.f11873b.clear();
                this.f11873b.addAll(list);
                return;
            }
            this.f11873b.clear();
        }
    }

    private void z() {
        try {
            if (this.f11872a == null) {
                return;
            }
            int s3 = s();
            if (this.f11873b == null) {
                this.f11873b = new ArrayList<>();
            }
            if (s3 == 0 || s3 == 1 || s3 == 4) {
                g();
            }
        } catch (Throwable unused) {
        }
    }

    public final ArrayList<k9> a() {
        if (!this.f11885s) {
            return this.f11874c;
        }
        b(true);
        return this.f11874c;
    }

    public final WifiInfo c() {
        try {
            if (this.f11872a != null) {
                if (com.autonavi.aps.amapapi.utils.j.c(this.f11875i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    return this.f11872a.getConnectionInfo();
                }
                com.autonavi.aps.amapapi.utils.b.a(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
                return null;
            }
            return null;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    public final String d() {
        return this.f11881o;
    }

    public final ArrayList<k9> e() {
        if (this.f11873b == null) {
            return null;
        }
        ArrayList<k9> arrayList = new ArrayList<>();
        if (!this.f11873b.isEmpty()) {
            arrayList.addAll(this.f11873b);
        }
        return arrayList;
    }

    public final void f() {
        try {
            this.f11885s = true;
            List<k9> r3 = r();
            if (r3 != null) {
                this.f11873b.clear();
                this.f11873b.addAll(r3);
            }
            d(true);
        } catch (Throwable unused) {
        }
    }

    public final void g() {
        this.B = null;
        this.f11873b.clear();
    }

    public final void h() {
        f11871z = System.currentTimeMillis();
        com.autonavi.aps.amapapi.c cVar = this.E;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final void i() {
        if (this.f11872a != null && com.autonavi.aps.amapapi.utils.j.b() - f11866g > 4900) {
            f11866g = com.autonavi.aps.amapapi.utils.j.b();
        }
    }

    public final void j() {
        if (this.f11872a == null) {
            return;
        }
        this.A = true;
    }

    public final boolean k() {
        return this.f11883q;
    }

    public final boolean l() {
        return this.f11884r;
    }

    public final j m() {
        A();
        if (l()) {
            if (this.B == null) {
                Log.w("SystemApiWrapper", "getwifiAccess " + this.B);
                this.B = new j(c());
            }
            return this.B;
        }
        return null;
    }

    public final boolean n() {
        return this.f11876j;
    }

    public final String o() {
        boolean z3;
        String str;
        StringBuilder sb = this.f11877k;
        if (sb == null) {
            this.f11877k = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.f11876j = false;
        int size = this.f11873b.size();
        int i4 = 0;
        boolean z4 = false;
        boolean z5 = false;
        while (i4 < size) {
            String c4 = k9.c(this.f11873b.get(i4).f8253a);
            if (!this.f11879m && !"<unknown ssid>".equals(this.f11873b.get(i4).f8254b)) {
                z4 = true;
            }
            if (TextUtils.isEmpty(this.C) || !this.C.equals(c4)) {
                z3 = z5;
                str = "nb";
            } else {
                str = "access";
                z3 = true;
            }
            this.f11877k.append(String.format(Locale.US, "#%s,%s", c4, str));
            i4++;
            z5 = z3;
        }
        if (this.f11873b.size() == 0) {
            z4 = true;
        }
        if (!this.f11879m && !z4) {
            this.f11876j = true;
        }
        if (!z5 && !TextUtils.isEmpty(this.C)) {
            StringBuilder sb2 = this.f11877k;
            sb2.append("#");
            sb2.append(this.C);
            this.f11877k.append(",access");
        }
        return this.f11877k.toString();
    }

    public final long q() {
        return this.f11887u;
    }

    private void d(boolean z3) {
        ArrayList<k9> arrayList = this.f11873b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (com.autonavi.aps.amapapi.utils.j.b() - f11866g > 3600000) {
            g();
        }
        if (this.f11882p == null) {
            this.f11882p = new TreeMap<>(Collections.reverseOrder());
        }
        this.f11882p.clear();
        if (this.f11885s && z3) {
            try {
                this.f11874c.clear();
            } catch (Throwable unused) {
            }
        }
        int size = this.f11873b.size();
        this.f11887u = 0L;
        for (int i4 = 0; i4 < size; i4++) {
            k9 k9Var = this.f11873b.get(i4);
            if (k9Var.f8260h) {
                this.f11887u = k9Var.f8258f;
            }
            if (com.autonavi.aps.amapapi.utils.j.a(k9.c(k9Var.f8253a)) && (size <= 20 || a(k9Var.f8255c))) {
                if (this.f11885s && z3) {
                    this.f11874c.add(k9Var);
                }
                if (!TextUtils.isEmpty(k9Var.f8254b)) {
                    if (!"<unknown ssid>".equals(k9Var.f8254b)) {
                        k9Var.f8254b = String.valueOf(i4);
                    }
                } else {
                    k9Var.f8254b = "unkwn";
                }
                this.f11882p.put(Integer.valueOf((k9Var.f8255c * 25) + i4), k9Var);
            }
        }
        this.f11873b.clear();
        for (k9 k9Var2 : this.f11882p.values()) {
            this.f11873b.add(k9Var2);
        }
        this.f11882p.clear();
    }

    public final void b(boolean z3) {
        if (z3) {
            w();
        } else {
            x();
        }
        boolean z4 = false;
        if (this.A) {
            this.A = false;
            z();
        }
        y();
        if (com.autonavi.aps.amapapi.utils.j.b() - f11866g > 20000) {
            this.f11873b.clear();
        }
        f11864e = com.autonavi.aps.amapapi.utils.j.b();
        if (this.f11873b.isEmpty()) {
            f11866g = com.autonavi.aps.amapapi.utils.j.b();
            List<k9> r3 = r();
            if (r3 != null) {
                this.f11873b.addAll(r3);
                z4 = true;
            }
        }
        d(z4);
    }

    public final boolean a(ConnectivityManager connectivityManager) {
        try {
            if (com.autonavi.aps.amapapi.utils.j.a(connectivityManager.getActiveNetworkInfo()) == 1) {
                return a(m());
            }
            return false;
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    public final void c(boolean z3) {
        g();
        this.f11873b.clear();
        this.f11886t.a(z3);
    }

    public final void a(boolean z3) {
        Context context = this.f11875i;
        if (!com.autonavi.aps.amapapi.utils.a.n() || !this.f11880n || this.f11872a == null || context == null || !z3 || com.autonavi.aps.amapapi.utils.j.c() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) com.autonavi.aps.amapapi.utils.f.a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                com.autonavi.aps.amapapi.utils.f.a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    public final boolean a(j jVar) {
        if (jVar == null) {
            return false;
        }
        boolean d4 = jVar.d();
        if (!d4 && v()) {
            g();
        }
        return d4;
    }

    public final void a(boolean z3, boolean z4, boolean z5, long j4) {
        this.f11878l = z3;
        this.f11879m = z4;
        this.f11880n = z5;
        if (j4 < ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT) {
            this.D = ILivePlayer.RETRY_TIME_INTERVAL_DEFAULT;
        } else {
            this.D = j4;
        }
    }

    public final void a(com.autonavi.aps.amapapi.c cVar) {
        this.E = cVar;
    }

    private static boolean a(int i4) {
        int i5 = 20;
        try {
            i5 = WifiManager.calculateSignalLevel(i4, 20);
        } catch (ArithmeticException e4) {
            com.autonavi.aps.amapapi.utils.b.a(e4, "Aps", "wifiSigFine");
        }
        return i5 > 0;
    }
}
