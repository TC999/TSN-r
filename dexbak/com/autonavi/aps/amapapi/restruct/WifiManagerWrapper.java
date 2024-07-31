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
import com.amap.api.col.p0463l.AmapWifi;
import com.autonavi.aps.amapapi.CollectionManager;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.kuaishou.weapon.p205p0.C7193bi;
import com.umeng.analytics.pro.UMCommonContent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.TreeMap;

/* renamed from: com.autonavi.aps.amapapi.restruct.k */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class WifiManagerWrapper {

    /* renamed from: d */
    static long f8186d;

    /* renamed from: e */
    static long f8187e;

    /* renamed from: f */
    static long f8188f;

    /* renamed from: g */
    public static long f8189g;

    /* renamed from: h */
    static long f8190h;

    /* renamed from: v */
    public static HashMap<String, Long> f8191v = new HashMap<>(36);

    /* renamed from: w */
    public static long f8192w = 0;

    /* renamed from: x */
    static int f8193x = 0;

    /* renamed from: z */
    public static long f8194z = 0;

    /* renamed from: E */
    private CollectionManager f8199E;

    /* renamed from: a */
    WifiManager f8200a;

    /* renamed from: i */
    Context f8203i;

    /* renamed from: t */
    WifiAgeEstimator f8214t;

    /* renamed from: b */
    ArrayList<AmapWifi> f8201b = new ArrayList<>();

    /* renamed from: c */
    ArrayList<AmapWifi> f8202c = new ArrayList<>();

    /* renamed from: j */
    boolean f8204j = false;

    /* renamed from: k */
    StringBuilder f8205k = null;

    /* renamed from: l */
    boolean f8206l = true;

    /* renamed from: m */
    boolean f8207m = true;

    /* renamed from: n */
    boolean f8208n = true;

    /* renamed from: B */
    private volatile WifiInfoWrapper f8196B = null;

    /* renamed from: o */
    String f8209o = null;

    /* renamed from: p */
    TreeMap<Integer, AmapWifi> f8210p = null;

    /* renamed from: q */
    public boolean f8211q = true;

    /* renamed from: r */
    public boolean f8212r = true;

    /* renamed from: s */
    public boolean f8213s = false;

    /* renamed from: C */
    private String f8197C = "";

    /* renamed from: u */
    long f8215u = 0;

    /* renamed from: y */
    ConnectivityManager f8216y = null;

    /* renamed from: D */
    private long f8198D = 30000;

    /* renamed from: A */
    volatile boolean f8195A = false;

    public WifiManagerWrapper(Context context, WifiManager wifiManager, Handler handler) {
        this.f8200a = wifiManager;
        this.f8203i = context;
        WifiAgeEstimator wifiAgeEstimator = new WifiAgeEstimator(context, "wifiAgee", handler);
        this.f8214t = wifiAgeEstimator;
        wifiAgeEstimator.m51609a();
    }

    /* renamed from: A */
    private void m51494A() {
        try {
            if (C2432j.m51174c(this.f8203i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                this.f8212r = this.f8200a.isWifiEnabled();
            }
        } catch (Throwable unused) {
            DebugUtils.m51283b();
        }
    }

    /* renamed from: B */
    private boolean m51493B() {
        this.f8211q = m51462v();
        m51494A();
        if (this.f8211q && this.f8206l) {
            if (f8188f == 0) {
                return true;
            }
            if (C2432j.m51186b() - f8188f >= 4900 && C2432j.m51186b() - f8189g >= 1500) {
                C2432j.m51186b();
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public static long m51485b() {
        return ((C2432j.m51186b() - f8192w) / 1000) + 1;
    }

    /* renamed from: p */
    public static String m51468p() {
        return String.valueOf(C2432j.m51186b() - f8189g);
    }

    /* renamed from: r */
    private List<AmapWifi> m51466r() {
        List<ScanResult> list;
        if (this.f8200a != null) {
            try {
                if (C2432j.m51174c(this.f8203i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    list = this.f8200a.getScanResults();
                } else {
                    C2428b.m51299a(new Exception("gst_n_aws"), "OPENSDK_WMW", "gsr_n_aws");
                    list = null;
                }
                HashMap<String, Long> hashMap = new HashMap<>(36);
                if (list != null) {
                    for (ScanResult scanResult : list) {
                        hashMap.put(scanResult.BSSID, Long.valueOf(scanResult.timestamp));
                    }
                }
                if (f8191v.isEmpty() || !f8191v.equals(hashMap)) {
                    f8191v = hashMap;
                    f8192w = C2432j.m51186b();
                }
                this.f8209o = null;
                ArrayList arrayList = new ArrayList();
                this.f8197C = "";
                this.f8196B = m51471m();
                if (m51488a(this.f8196B)) {
                    this.f8197C = this.f8196B.m51498a();
                }
                if (list != null && list.size() > 0) {
                    int size = list.size();
                    for (int i = 0; i < size; i++) {
                        ScanResult scanResult2 = list.get(i);
                        AmapWifi amapWifi = new AmapWifi(!TextUtils.isEmpty(this.f8197C) && this.f8197C.equals(scanResult2.BSSID));
                        amapWifi.f4585b = scanResult2.SSID;
                        amapWifi.f4587d = scanResult2.frequency;
                        amapWifi.f4588e = scanResult2.timestamp;
                        amapWifi.f4584a = AmapWifi.m54648a(scanResult2.BSSID);
                        amapWifi.f4586c = (short) scanResult2.level;
                        short elapsedRealtime = (short) ((SystemClock.elapsedRealtime() - (scanResult2.timestamp / 1000)) / 1000);
                        amapWifi.f4590g = elapsedRealtime;
                        if (elapsedRealtime < 0) {
                            amapWifi.f4590g = (short) 0;
                        }
                        amapWifi.f4589f = C2432j.m51186b();
                        arrayList.add(amapWifi);
                    }
                }
                this.f8214t.m51605a((List) arrayList);
                return arrayList;
            } catch (SecurityException e) {
                this.f8209o = e.getMessage();
            } catch (Throwable th) {
                this.f8209o = null;
                C2428b.m51299a(th, "WifiManagerWrapper", "getScanResults");
            }
        }
        return null;
    }

    /* renamed from: s */
    private int m51465s() {
        WifiManager wifiManager = this.f8200a;
        if (wifiManager != null) {
            return wifiManager.getWifiState();
        }
        return 4;
    }

    /* renamed from: t */
    private boolean m51464t() {
        long m51186b = C2432j.m51186b() - f8186d;
        if (m51186b < 4900) {
            return false;
        }
        if (!m51463u() || m51186b >= 9900) {
            if (f8193x > 1) {
                long j = this.f8198D;
                if (j == 30000) {
                    j = AuthUtil.m51318o() != -1 ? AuthUtil.m51318o() : 30000L;
                }
                if (Build.VERSION.SDK_INT >= 28 && m51186b < j) {
                    return false;
                }
            }
            if (this.f8200a != null) {
                f8186d = C2432j.m51186b();
                int i = f8193x;
                if (i < 2) {
                    f8193x = i + 1;
                }
                if (C2432j.m51174c(this.f8203i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkNIQU5HRV9XSUZJX1NUQVRF")) {
                    return this.f8200a.startScan();
                }
                C2428b.m51299a(new Exception("n_cws"), "OPENSDK_WMW", "wfs_n_cws");
            }
            return false;
        }
        return false;
    }

    /* renamed from: u */
    private boolean m51463u() {
        if (this.f8216y == null) {
            this.f8216y = (ConnectivityManager) C2432j.m51203a(this.f8203i, "connectivity");
        }
        return m51490a(this.f8216y);
    }

    /* renamed from: v */
    private boolean m51462v() {
        if (this.f8200a == null) {
            return false;
        }
        return C2432j.m51162g(this.f8203i);
    }

    /* renamed from: w */
    private void m51461w() {
        if (m51493B()) {
            long m51186b = C2432j.m51186b();
            if (m51186b - f8187e >= 10000) {
                this.f8201b.clear();
                f8190h = f8189g;
            }
            m51460x();
            if (m51186b - f8187e >= 10000) {
                for (int i = 20; i > 0 && f8189g == f8190h; i--) {
                    try {
                        Thread.sleep(150L);
                    } catch (Throwable unused) {
                    }
                }
            }
        }
    }

    /* renamed from: x */
    private void m51460x() {
        if (m51493B()) {
            try {
                if (m51464t()) {
                    f8188f = C2432j.m51186b();
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "WifiManager", "wifiScan");
            }
        }
    }

    /* renamed from: y */
    private void m51459y() {
        if (f8190h != f8189g) {
            List<AmapWifi> list = null;
            try {
                list = m51466r();
            } catch (Throwable th) {
                C2428b.m51299a(th, "WifiManager", "updateScanResult");
            }
            f8190h = f8189g;
            if (list != null) {
                this.f8201b.clear();
                this.f8201b.addAll(list);
                return;
            }
            this.f8201b.clear();
        }
    }

    /* renamed from: z */
    private void m51458z() {
        try {
            if (this.f8200a == null) {
                return;
            }
            int m51465s = m51465s();
            if (this.f8201b == null) {
                this.f8201b = new ArrayList<>();
            }
            if (m51465s == 0 || m51465s == 1 || m51465s == 4) {
                m51477g();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    public final ArrayList<AmapWifi> m51492a() {
        if (!this.f8213s) {
            return this.f8202c;
        }
        m51484b(true);
        return this.f8202c;
    }

    /* renamed from: c */
    public final WifiInfo m51483c() {
        try {
            if (this.f8200a != null) {
                if (C2432j.m51174c(this.f8203i, "EYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19XSUZJX1NUQVRF")) {
                    return this.f8200a.getConnectionInfo();
                }
                C2428b.m51299a(new Exception("gci_n_aws"), "OPENSDK_WMW", "gci_n_aws");
                return null;
            }
            return null;
        } catch (Throwable th) {
            C2428b.m51299a(th, "WifiManagerWrapper", "getConnectionInfo");
            return null;
        }
    }

    /* renamed from: d */
    public final String m51481d() {
        return this.f8209o;
    }

    /* renamed from: e */
    public final ArrayList<AmapWifi> m51479e() {
        if (this.f8201b == null) {
            return null;
        }
        ArrayList<AmapWifi> arrayList = new ArrayList<>();
        if (!this.f8201b.isEmpty()) {
            arrayList.addAll(this.f8201b);
        }
        return arrayList;
    }

    /* renamed from: f */
    public final void m51478f() {
        try {
            this.f8213s = true;
            List<AmapWifi> m51466r = m51466r();
            if (m51466r != null) {
                this.f8201b.clear();
                this.f8201b.addAll(m51466r);
            }
            m51480d(true);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: g */
    public final void m51477g() {
        this.f8196B = null;
        this.f8201b.clear();
    }

    /* renamed from: h */
    public final void m51476h() {
        f8194z = System.currentTimeMillis();
        CollectionManager collectionManager = this.f8199E;
        if (collectionManager != null) {
            collectionManager.m51666b();
        }
    }

    /* renamed from: i */
    public final void m51475i() {
        if (this.f8200a != null && C2432j.m51186b() - f8189g > 4900) {
            f8189g = C2432j.m51186b();
        }
    }

    /* renamed from: j */
    public final void m51474j() {
        if (this.f8200a == null) {
            return;
        }
        this.f8195A = true;
    }

    /* renamed from: k */
    public final boolean m51473k() {
        return this.f8211q;
    }

    /* renamed from: l */
    public final boolean m51472l() {
        return this.f8212r;
    }

    /* renamed from: m */
    public final WifiInfoWrapper m51471m() {
        m51494A();
        if (m51472l()) {
            if (this.f8196B == null) {
                Log.w("SystemApiWrapper", "getwifiAccess " + this.f8196B);
                this.f8196B = new WifiInfoWrapper(m51483c());
            }
            return this.f8196B;
        }
        return null;
    }

    /* renamed from: n */
    public final boolean m51470n() {
        return this.f8204j;
    }

    /* renamed from: o */
    public final String m51469o() {
        boolean z;
        String str;
        StringBuilder sb = this.f8205k;
        if (sb == null) {
            this.f8205k = new StringBuilder(700);
        } else {
            sb.delete(0, sb.length());
        }
        this.f8204j = false;
        int size = this.f8201b.size();
        int i = 0;
        boolean z2 = false;
        boolean z3 = false;
        while (i < size) {
            String m54646c = AmapWifi.m54646c(this.f8201b.get(i).f4584a);
            if (!this.f8207m && !"<unknown ssid>".equals(this.f8201b.get(i).f4585b)) {
                z2 = true;
            }
            if (TextUtils.isEmpty(this.f8197C) || !this.f8197C.equals(m54646c)) {
                z = z3;
                str = "nb";
            } else {
                str = UMCommonContent.f37760Q;
                z = true;
            }
            this.f8205k.append(String.format(Locale.US, "#%s,%s", m54646c, str));
            i++;
            z3 = z;
        }
        if (this.f8201b.size() == 0) {
            z2 = true;
        }
        if (!this.f8207m && !z2) {
            this.f8204j = true;
        }
        if (!z3 && !TextUtils.isEmpty(this.f8197C)) {
            StringBuilder sb2 = this.f8205k;
            sb2.append("#");
            sb2.append(this.f8197C);
            this.f8205k.append(",access");
        }
        return this.f8205k.toString();
    }

    /* renamed from: q */
    public final long m51467q() {
        return this.f8215u;
    }

    /* renamed from: d */
    private void m51480d(boolean z) {
        ArrayList<AmapWifi> arrayList = this.f8201b;
        if (arrayList == null || arrayList.isEmpty()) {
            return;
        }
        if (C2432j.m51186b() - f8189g > C7193bi.f24584s) {
            m51477g();
        }
        if (this.f8210p == null) {
            this.f8210p = new TreeMap<>(Collections.reverseOrder());
        }
        this.f8210p.clear();
        if (this.f8213s && z) {
            try {
                this.f8202c.clear();
            } catch (Throwable unused) {
            }
        }
        int size = this.f8201b.size();
        this.f8215u = 0L;
        for (int i = 0; i < size; i++) {
            AmapWifi amapWifi = this.f8201b.get(i);
            if (amapWifi.f4591h) {
                this.f8215u = amapWifi.f4589f;
            }
            if (C2432j.m51191a(AmapWifi.m54646c(amapWifi.f4584a)) && (size <= 20 || m51491a(amapWifi.f4586c))) {
                if (this.f8213s && z) {
                    this.f8202c.add(amapWifi);
                }
                if (!TextUtils.isEmpty(amapWifi.f4585b)) {
                    if (!"<unknown ssid>".equals(amapWifi.f4585b)) {
                        amapWifi.f4585b = String.valueOf(i);
                    }
                } else {
                    amapWifi.f4585b = "unkwn";
                }
                this.f8210p.put(Integer.valueOf((amapWifi.f4586c * 25) + i), amapWifi);
            }
        }
        this.f8201b.clear();
        for (AmapWifi amapWifi2 : this.f8210p.values()) {
            this.f8201b.add(amapWifi2);
        }
        this.f8210p.clear();
    }

    /* renamed from: b */
    public final void m51484b(boolean z) {
        if (z) {
            m51461w();
        } else {
            m51460x();
        }
        boolean z2 = false;
        if (this.f8195A) {
            this.f8195A = false;
            m51458z();
        }
        m51459y();
        if (C2432j.m51186b() - f8189g > 20000) {
            this.f8201b.clear();
        }
        f8187e = C2432j.m51186b();
        if (this.f8201b.isEmpty()) {
            f8189g = C2432j.m51186b();
            List<AmapWifi> m51466r = m51466r();
            if (m51466r != null) {
                this.f8201b.addAll(m51466r);
                z2 = true;
            }
        }
        m51480d(z2);
    }

    /* renamed from: a */
    public final boolean m51490a(ConnectivityManager connectivityManager) {
        try {
            if (C2432j.m51199a(connectivityManager.getActiveNetworkInfo()) == 1) {
                return m51488a(m51471m());
            }
            return false;
        } catch (Throwable th) {
            C2428b.m51299a(th, "WifiManagerWrapper", "wifiAccess");
            return false;
        }
    }

    /* renamed from: c */
    public final void m51482c(boolean z) {
        m51477g();
        this.f8201b.clear();
        this.f8214t.m51604a(z);
    }

    /* renamed from: a */
    public final void m51487a(boolean z) {
        Context context = this.f8203i;
        if (!AuthUtil.m51319n() || !this.f8208n || this.f8200a == null || context == null || !z || C2432j.m51177c() <= 17) {
            return;
        }
        ContentResolver contentResolver = context.getContentResolver();
        try {
            if (((Integer) Reflect.m51259a("android.provider.Settings$Global", "getInt", new Object[]{contentResolver, "wifi_scan_always_enabled"}, new Class[]{ContentResolver.class, String.class})).intValue() == 0) {
                Reflect.m51259a("android.provider.Settings$Global", "putInt", new Object[]{contentResolver, "wifi_scan_always_enabled", 1}, new Class[]{ContentResolver.class, String.class, Integer.TYPE});
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "WifiManagerWrapper", "enableWifiAlwaysScan");
        }
    }

    /* renamed from: a */
    public final boolean m51488a(WifiInfoWrapper wifiInfoWrapper) {
        if (wifiInfoWrapper == null) {
            return false;
        }
        boolean m51495d = wifiInfoWrapper.m51495d();
        if (!m51495d && m51462v()) {
            m51477g();
        }
        return m51495d;
    }

    /* renamed from: a */
    public final void m51486a(boolean z, boolean z2, boolean z3, long j) {
        this.f8206l = z;
        this.f8207m = z2;
        this.f8208n = z3;
        if (j < 10000) {
            this.f8198D = 10000L;
        } else {
            this.f8198D = j;
        }
    }

    /* renamed from: a */
    public final void m51489a(CollectionManager collectionManager) {
        this.f8199E = collectionManager;
    }

    /* renamed from: a */
    private static boolean m51491a(int i) {
        int i2 = 20;
        try {
            i2 = WifiManager.calculateSignalLevel(i, 20);
        } catch (ArithmeticException e) {
            C2428b.m51299a(e, "Aps", "wifiSigFine");
        }
        return i2 > 0;
    }
}
