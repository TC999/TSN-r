package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.location.GnssStatus;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.DPoint;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.f;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.i;
import com.autonavi.aps.amapapi.utils.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: GpsLocation.java */
/* renamed from: com.amap.api.col.3l.t5  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t5 {
    static AMapLocation D;
    static long E;
    static Object F = new Object();
    static long G;
    static boolean H;
    static boolean I;
    public static volatile AMapLocation J;

    /* renamed from: a  reason: collision with root package name */
    Handler f9038a;

    /* renamed from: b  reason: collision with root package name */
    private Context f9039b;

    /* renamed from: c  reason: collision with root package name */
    LocationManager f9040c;

    /* renamed from: d  reason: collision with root package name */
    AMapLocationClientOption f9041d;

    /* renamed from: i  reason: collision with root package name */
    com.autonavi.aps.amapapi.filters.a f9046i;

    /* renamed from: t  reason: collision with root package name */
    private GnssStatus.Callback f9057t;

    /* renamed from: e  reason: collision with root package name */
    private long f9042e = 0;

    /* renamed from: f  reason: collision with root package name */
    long f9043f = 0;

    /* renamed from: g  reason: collision with root package name */
    boolean f9044g = false;

    /* renamed from: h  reason: collision with root package name */
    private int f9045h = 0;

    /* renamed from: j  reason: collision with root package name */
    int f9047j = 240;

    /* renamed from: k  reason: collision with root package name */
    int f9048k = 80;

    /* renamed from: l  reason: collision with root package name */
    AMapLocation f9049l = null;

    /* renamed from: m  reason: collision with root package name */
    long f9050m = 0;

    /* renamed from: n  reason: collision with root package name */
    float f9051n = 0.0f;

    /* renamed from: o  reason: collision with root package name */
    Object f9052o = new Object();

    /* renamed from: p  reason: collision with root package name */
    Object f9053p = new Object();

    /* renamed from: q  reason: collision with root package name */
    private int f9054q = 0;

    /* renamed from: r  reason: collision with root package name */
    private GpsStatus f9055r = null;

    /* renamed from: s  reason: collision with root package name */
    private GpsStatus.Listener f9056s = null;

    /* renamed from: u  reason: collision with root package name */
    AMapLocationClientOption.GeoLanguage f9058u = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: v  reason: collision with root package name */
    boolean f9059v = true;

    /* renamed from: w  reason: collision with root package name */
    long f9060w = 0;

    /* renamed from: x  reason: collision with root package name */
    int f9061x = 0;

    /* renamed from: y  reason: collision with root package name */
    LocationListener f9062y = null;

    /* renamed from: z  reason: collision with root package name */
    private String f9063z = null;
    private boolean A = false;
    private int B = 0;
    private boolean C = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GpsLocation.java */
    /* renamed from: com.amap.api.col.3l.t5$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class a extends GnssStatus.Callback {
        a() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i4) {
            t5.N();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            t5.this.f(gnssStatus);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            t5.L();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
            t5.this.M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: GpsLocation.java */
    /* renamed from: com.amap.api.col.3l.t5$b */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public final class b implements GpsStatus.Listener {

        /* compiled from: SDKLogHandler.java */
        /* renamed from: com.amap.api.col.3l.t5$b$a */
        /* loaded from: E:\TSN-r\205dec\7241516.dex */
        final class a extends Thread {
            a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                try {
                    super.run();
                } catch (Throwable unused) {
                }
            }
        }

        b() {
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i4) {
            try {
                t5 t5Var = t5.this;
                LocationManager locationManager = t5Var.f9040c;
                if (locationManager == null) {
                    return;
                }
                t5Var.f9055r = locationManager.getGpsStatus(t5Var.f9055r);
                if (i4 == 1) {
                    t5.L();
                } else if (i4 == 2) {
                    t5.this.M();
                } else if (i4 == 3) {
                    t5.N();
                } else if (i4 != 4) {
                } else {
                    t5.this.O();
                }
            } catch (Throwable th) {
                new StringBuilder("GpsLocation | onGpsStatusChanged error: ").append(th.getMessage());
                d.a();
                com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "onGpsStatusChanged");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GpsLocation.java */
    /* renamed from: com.amap.api.col.3l.t5$c */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class c implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        private t5 f9067a;

        c(t5 t5Var) {
            this.f9067a = t5Var;
        }

        final void a() {
            this.f9067a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                new StringBuilder("tid=").append(Thread.currentThread().getId());
                d.a();
                t5 t5Var = this.f9067a;
                if (t5Var != null) {
                    t5Var.g(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                t5 t5Var = this.f9067a;
                if (t5Var != null) {
                    t5Var.q(str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i4, Bundle bundle) {
            try {
                t5 t5Var = this.f9067a;
                if (t5Var != null) {
                    t5Var.d(i4);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public t5(Context context, Handler handler) {
        this.f9046i = null;
        this.f9039b = context;
        this.f9038a = handler;
        try {
            this.f9040c = (LocationManager) context.getSystemService("location");
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "<init>");
        }
        this.f9046i = new com.autonavi.aps.amapapi.filters.a();
    }

    private void B(AMapLocation aMapLocation) {
        if (this.f9038a != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.f9038a.sendMessage(obtain);
        }
    }

    private void D(AMapLocation aMapLocation) {
        try {
            if (com.autonavi.aps.amapapi.utils.b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) && this.f9041d.isOffset()) {
                DPoint a4 = e.a(this.f9039b, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                aMapLocation.setLatitude(a4.getLatitude());
                aMapLocation.setLongitude(a4.getLongitude());
                aMapLocation.setOffset(this.f9041d.isOffset());
                aMapLocation.setCoordType("GCJ02");
                return;
            }
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType("WGS84");
        } catch (Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType("WGS84");
        }
    }

    private void E(AMapLocation aMapLocation) {
        try {
            int i4 = this.f9054q;
            if (i4 >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (i4 == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable unused) {
        }
    }

    private AMapLocation G(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && this.f9045h >= 3) {
            if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
                aMapLocation.setAccuracy(0.0f);
            }
            if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
                aMapLocation.setSpeed(0.0f);
            }
            return this.f9046i.a(aMapLocation);
        }
        return aMapLocation;
    }

    private static void J(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && com.autonavi.aps.amapapi.utils.a.s()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long a4 = com.autonavi.aps.amapapi.utils.c.a(time, currentTimeMillis, com.autonavi.aps.amapapi.utils.a.t());
            if (a4 != time) {
                aMapLocation.setTime(a4);
                h.a(time, currentTimeMillis);
            }
        }
    }

    private void K() {
        if (this.f9040c == null) {
            return;
        }
        try {
            P();
            this.f9059v = true;
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.f9039b.getMainLooper();
            }
            Looper looper = myLooper;
            this.f9042e = j.b();
            if (r(this.f9040c)) {
                try {
                    if (j.a() - G >= 259200000) {
                        if (j.c(this.f9039b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                            this.f9040c.sendExtraCommand("gps", "force_xtra_injection", null);
                            G = j.a();
                            SharedPreferences.Editor a4 = i.a(this.f9039b, "pref");
                            i.a(a4, "lagt", G);
                            i.a(a4);
                            d.a();
                        } else {
                            com.autonavi.aps.amapapi.utils.b.a(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                        }
                    }
                } catch (Throwable th) {
                    new StringBuilder("GpsLocation | sendExtraCommand error: ").append(th.getMessage());
                    d.a();
                }
                if (this.f9062y == null) {
                    this.f9062y = new c(this);
                }
                if (this.f9041d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f9041d.getDeviceModeDistanceFilter() > 0.0f) {
                    this.f9040c.requestLocationUpdates("gps", this.f9041d.getInterval(), this.f9041d.getDeviceModeDistanceFilter(), this.f9062y, looper);
                } else {
                    this.f9040c.requestLocationUpdates("gps", 900L, 0.0f, this.f9062y, looper);
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    a aVar = new a();
                    this.f9057t = aVar;
                    this.f9040c.registerGnssStatusCallback(aVar);
                } else {
                    b bVar = new b();
                    this.f9056s = bVar;
                    this.f9040c.addGpsStatusListener(bVar);
                    d.a();
                }
                e(8, 14, "no enough satellites#1401", this.f9041d.getHttpTimeOut());
                return;
            }
            d.a();
            e(8, 14, "no gps provider#1402", 0L);
        } catch (SecurityException e4) {
            d.a();
            this.f9059v = false;
            h.a((String) null, 2121);
            e(2, 12, e4.getMessage() + "#1201", 0L);
        } catch (Throwable th2) {
            new StringBuilder("GpsLocation | requestLocationUpdates error: ").append(th2.getMessage());
            d.a();
            com.autonavi.aps.amapapi.utils.b.a(th2, "GpsLocation", "requestLocationUpdates part2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void L() {
        d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void M() {
        d.a();
        this.f9054q = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N() {
        d.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void O() {
        Iterable<GpsSatellite> satellites;
        int i4 = 0;
        try {
            GpsStatus gpsStatus = this.f9055r;
            if (gpsStatus != null && (satellites = gpsStatus.getSatellites()) != null) {
                Iterator<GpsSatellite> it = satellites.iterator();
                int maxSatellites = this.f9055r.getMaxSatellites();
                while (it.hasNext() && i4 < maxSatellites) {
                    if (it.next().usedInFix()) {
                        i4++;
                    }
                }
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        }
        this.f9054q = i4;
    }

    private void P() {
        if (j.b() - E > 5000 || !j.a(D)) {
            return;
        }
        if (this.f9041d.isMockEnable() || !D.isMock()) {
            this.f9043f = j.b();
            z(D);
        }
    }

    private static boolean Q() {
        try {
            return ((Boolean) f.a(q4.u("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), q4.u("UaXNOYXZpU3RhcnRlZA=="), (Object[]) null, (Class<?>[]) null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    private AMapLocation R() {
        float f4;
        float f5;
        try {
            if (j.a(this.f9049l) && com.autonavi.aps.amapapi.utils.a.k() && Q()) {
                JSONObject jSONObject = new JSONObject((String) f.a(q4.u("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), q4.u("UZ2V0TmF2aUxvY2F0aW9u"), (Object[]) null, (Class<?>[]) null));
                long optLong = jSONObject.optLong("time");
                if (!this.C) {
                    this.C = true;
                    h.a("useNaviLoc", "use NaviLoc");
                }
                if (j.a() - optLong <= 5500) {
                    double optDouble = jSONObject.optDouble("lat", 0.0d);
                    double optDouble2 = jSONObject.optDouble("lng", 0.0d);
                    float f6 = 0.0f;
                    try {
                        f4 = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (NumberFormatException unused) {
                        f4 = 0.0f;
                    }
                    double optDouble3 = jSONObject.optDouble("altitude", 0.0d);
                    try {
                        f5 = Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (NumberFormatException unused2) {
                        f5 = 0.0f;
                    }
                    try {
                        f6 = (Float.parseFloat(jSONObject.optString("speed", "0")) * 10.0f) / 36.0f;
                    } catch (NumberFormatException unused3) {
                    }
                    AMapLocation aMapLocation = new AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(optDouble);
                    aMapLocation.setLongitude(optDouble2);
                    aMapLocation.setAccuracy(f4);
                    aMapLocation.setAltitude(optDouble3);
                    aMapLocation.setBearing(f5);
                    aMapLocation.setSpeed(f6);
                    aMapLocation.setTime(optLong);
                    aMapLocation.setCoordType("GCJ02");
                    if (j.a(aMapLocation, this.f9049l) <= 300.0f) {
                        synchronized (this.f9053p) {
                            this.f9049l.setLongitude(optDouble2);
                            this.f9049l.setLatitude(optDouble);
                            this.f9049l.setAccuracy(f4);
                            this.f9049l.setBearing(f5);
                            this.f9049l.setSpeed(f6);
                            this.f9049l.setTime(optLong);
                            this.f9049l.setCoordType("GCJ02");
                        }
                        return aMapLocation;
                    }
                }
            }
        } catch (Throwable unused4) {
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(int i4) {
        if (i4 == 0) {
            try {
                this.f9043f = 0L;
                this.f9054q = 0;
            } catch (Throwable unused) {
            }
        }
    }

    private void e(int i4, int i5, String str, long j4) {
        try {
            if (this.f9038a == null || this.f9041d.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                return;
            }
            Message obtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider("gps");
            aMapLocation.setErrorCode(i5);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(1);
            obtain.obj = aMapLocation;
            obtain.what = i4;
            this.f9038a.sendMessageDelayed(obtain, j4);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(GnssStatus gnssStatus) {
        int i4 = 0;
        if (gnssStatus != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    int satelliteCount = gnssStatus.getSatelliteCount();
                    int i5 = 0;
                    while (i4 < satelliteCount) {
                        try {
                            if (gnssStatus.usedInFix(i4)) {
                                i5++;
                            }
                            i4++;
                        } catch (Throwable th) {
                            th = th;
                            i4 = i5;
                            com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
                            this.f9054q = i4;
                        }
                    }
                    i4 = i5;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        this.f9054q = i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Location location) {
        Handler handler = this.f9038a;
        if (handler != null) {
            handler.removeMessages(8);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (j.a(aMapLocation)) {
                aMapLocation.setProvider("gps");
                aMapLocation.setLocationType(1);
                if (!this.f9044g && j.a(aMapLocation)) {
                    h.a(this.f9039b, j.b() - this.f9042e, com.autonavi.aps.amapapi.utils.b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.f9044g = true;
                }
                if (j.a(aMapLocation, this.f9054q)) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.f9041d.isMockEnable()) {
                        int i4 = this.f9061x;
                        if (i4 > 3) {
                            h.a((String) null, 2152);
                            aMapLocation.setErrorCode(15);
                            aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                            aMapLocation.setLatitude(0.0d);
                            aMapLocation.setLongitude(0.0d);
                            aMapLocation.setAltitude(0.0d);
                            aMapLocation.setSpeed(0.0f);
                            aMapLocation.setAccuracy(0.0f);
                            aMapLocation.setBearing(0.0f);
                            aMapLocation.setExtras(null);
                            z(aMapLocation);
                            return;
                        }
                        this.f9061x = i4 + 1;
                        return;
                    }
                } else {
                    this.f9061x = 0;
                }
                aMapLocation.setSatellites(this.f9054q);
                D(aMapLocation);
                E(aMapLocation);
                J(aMapLocation);
                AMapLocation G2 = G(aMapLocation);
                n(G2);
                t(G2);
                synchronized (this.f9052o) {
                    o(G2, J);
                }
                if (j.a(G2)) {
                    if (this.f9049l != null) {
                        this.f9050m = location.getTime() - this.f9049l.getTime();
                        this.f9051n = j.a(this.f9049l, G2);
                    }
                    synchronized (this.f9053p) {
                        this.f9049l = G2.m15clone();
                    }
                    this.f9063z = null;
                    this.A = false;
                    this.B = 0;
                }
                z(G2);
            }
        } catch (Throwable th) {
            com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "onLocationChanged");
        }
    }

    private void n(AMapLocation aMapLocation) {
        if (j.a(aMapLocation)) {
            this.f9043f = j.b();
            synchronized (F) {
                E = j.b();
                D = aMapLocation.m15clone();
            }
            this.f9045h++;
        }
    }

    private void o(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.f9041d.isNeedAddress() || j.a(aMapLocation, aMapLocation2) >= this.f9047j) {
            return;
        }
        com.autonavi.aps.amapapi.utils.b.a(aMapLocation, aMapLocation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(String str) {
        try {
            if ("gps".equalsIgnoreCase(str)) {
                this.f9043f = 0L;
                this.f9054q = 0;
            }
        } catch (Throwable unused) {
        }
    }

    private static boolean r(LocationManager locationManager) {
        try {
            if (H) {
                return I;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders != null && allProviders.size() > 0) {
                I = allProviders.contains("gps");
            } else {
                I = false;
            }
            H = true;
            return I;
        } catch (Throwable th) {
            new StringBuilder("GpsLocation | hasProvider error: ").append(th.getMessage());
            d.a();
            return I;
        }
    }

    private void t(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && this.f9038a != null) {
            long b4 = j.b();
            if (this.f9041d.getInterval() <= 8000 || b4 - this.f9060w > this.f9041d.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.f9052o) {
                    if (J == null) {
                        this.f9038a.sendMessage(obtain);
                    } else if (j.a(aMapLocation, J) > this.f9048k) {
                        this.f9038a.sendMessage(obtain);
                    }
                }
            }
        }
    }

    private boolean w(String str) {
        try {
            ArrayList<String> b4 = j.b(str);
            ArrayList<String> b5 = j.b(this.f9063z);
            if (b4.size() < 8 || b5.size() < 8) {
                return false;
            }
            return j.a(this.f9063z, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    private void z(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.f9041d.getLocationMode())) {
            if (this.f9041d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f9041d.getDeviceModeDistanceFilter() > 0.0f) {
                B(aMapLocation);
            } else if (j.b() - this.f9060w >= this.f9041d.getInterval() - 200) {
                this.f9060w = j.b();
                B(aMapLocation);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public final int A() {
        LocationManager locationManager = this.f9040c;
        if (locationManager != null && r(locationManager)) {
            if (Build.VERSION.SDK_INT < 19) {
                if (!this.f9040c.isProviderEnabled("gps")) {
                    return 2;
                }
            } else {
                int i4 = Settings.Secure.getInt(this.f9039b.getContentResolver(), "location_mode", 0);
                if (i4 == 0) {
                    return 2;
                }
                if (i4 == 2) {
                    return 3;
                }
            }
            return !this.f9059v ? 4 : 0;
        }
        return 1;
    }

    public final int C() {
        return this.f9054q;
    }

    public final boolean F() {
        AMapLocationClientOption aMapLocationClientOption = this.f9041d;
        return (aMapLocationClientOption == null || aMapLocationClientOption.isOnceLocation() || j.b() - this.f9043f <= 300000) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.amap.api.location.AMapLocation b(com.amap.api.location.AMapLocation r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003l.t5.b(com.amap.api.location.AMapLocation, java.lang.String):com.amap.api.location.AMapLocation");
    }

    public final void c() {
        LocationManager locationManager = this.f9040c;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f9062y;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((c) this.f9062y).a();
                this.f9062y = null;
            }
        } catch (Throwable unused) {
        }
        try {
            GpsStatus.Listener listener = this.f9056s;
            if (listener != null) {
                this.f9040c.removeGpsStatusListener(listener);
            }
        } catch (Throwable unused2) {
        }
        try {
            GnssStatus.Callback callback = this.f9057t;
            if (callback != null) {
                this.f9040c.unregisterGnssStatusCallback(callback);
            }
        } catch (Throwable unused3) {
        }
        try {
            Handler handler = this.f9038a;
            if (handler != null) {
                handler.removeMessages(8);
            }
        } catch (Throwable unused4) {
        }
        this.f9054q = 0;
        this.f9042e = 0L;
        this.f9060w = 0L;
        this.f9043f = 0L;
        this.f9045h = 0;
        this.f9061x = 0;
        this.f9046i.a();
        this.f9049l = null;
        this.f9050m = 0L;
        this.f9051n = 0.0f;
        this.f9063z = null;
        this.C = false;
    }

    public final void h(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f9047j = bundle.getInt("I_MAX_GEO_DIS");
                this.f9048k = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.f9052o) {
                    J = aMapLocation;
                }
            } catch (Throwable th) {
                com.autonavi.aps.amapapi.utils.b.a(th, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    public final void p(AMapLocationClientOption aMapLocationClientOption) {
        this.f9041d = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f9041d = new AMapLocationClientOption();
        }
        try {
            G = i.a(this.f9039b, "pref", "lagt", G);
        } catch (Throwable unused) {
        }
        K();
    }

    public final void u(AMapLocationClientOption aMapLocationClientOption) {
        Handler handler;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f9041d = aMapLocationClientOption;
        if (aMapLocationClientOption.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors && (handler = this.f9038a) != null) {
            handler.removeMessages(8);
        }
        if (this.f9058u != this.f9041d.getGeoLanguage()) {
            synchronized (this.f9052o) {
                J = null;
            }
        }
        this.f9058u = this.f9041d.getGeoLanguage();
    }

    public final boolean v() {
        return j.b() - this.f9043f <= 2800;
    }

    public final void x() {
        this.f9061x = 0;
    }
}
