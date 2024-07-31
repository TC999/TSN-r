package com.amap.api.col.p0463l;

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
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.aps.amapapi.filters.LocFilter;
import com.autonavi.aps.amapapi.utils.AuthUtil;
import com.autonavi.aps.amapapi.utils.C2428b;
import com.autonavi.aps.amapapi.utils.C2429e;
import com.autonavi.aps.amapapi.utils.C2431i;
import com.autonavi.aps.amapapi.utils.C2432j;
import com.autonavi.aps.amapapi.utils.DateUtil;
import com.autonavi.aps.amapapi.utils.DebugUtils;
import com.autonavi.aps.amapapi.utils.Reflect;
import com.autonavi.aps.amapapi.utils.ReportUtil;
import com.github.mikephil.charting.utils.Utils;
import com.umeng.analytics.pro.UContent;
import com.umeng.socialize.common.SocializeConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* renamed from: com.amap.api.col.3l.s5 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class GpsLocation {

    /* renamed from: D */
    static AMapLocation f5248D;

    /* renamed from: E */
    static long f5249E;

    /* renamed from: F */
    static Object f5250F = new Object();

    /* renamed from: G */
    static long f5251G;

    /* renamed from: H */
    static boolean f5252H;

    /* renamed from: I */
    static boolean f5253I;

    /* renamed from: J */
    public static volatile AMapLocation f5254J;

    /* renamed from: a */
    Handler f5258a;

    /* renamed from: b */
    private Context f5259b;

    /* renamed from: c */
    LocationManager f5260c;

    /* renamed from: d */
    AMapLocationClientOption f5261d;

    /* renamed from: i */
    LocFilter f5266i;

    /* renamed from: t */
    private GnssStatus.Callback f5277t;

    /* renamed from: e */
    private long f5262e = 0;

    /* renamed from: f */
    long f5263f = 0;

    /* renamed from: g */
    boolean f5264g = false;

    /* renamed from: h */
    private int f5265h = 0;

    /* renamed from: j */
    int f5267j = GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;

    /* renamed from: k */
    int f5268k = 80;

    /* renamed from: l */
    AMapLocation f5269l = null;

    /* renamed from: m */
    long f5270m = 0;

    /* renamed from: n */
    float f5271n = 0.0f;

    /* renamed from: o */
    Object f5272o = new Object();

    /* renamed from: p */
    Object f5273p = new Object();

    /* renamed from: q */
    private int f5274q = 0;

    /* renamed from: r */
    private GpsStatus f5275r = null;

    /* renamed from: s */
    private GpsStatus.Listener f5276s = null;

    /* renamed from: u */
    AMapLocationClientOption.GeoLanguage f5278u = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: v */
    boolean f5279v = true;

    /* renamed from: w */
    long f5280w = 0;

    /* renamed from: x */
    int f5281x = 0;

    /* renamed from: y */
    LocationListener f5282y = null;

    /* renamed from: z */
    private String f5283z = null;

    /* renamed from: A */
    private boolean f5255A = false;

    /* renamed from: B */
    private int f5256B = 0;

    /* renamed from: C */
    private boolean f5257C = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GpsLocation.java */
    /* renamed from: com.amap.api.col.3l.s5$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1938a extends GnssStatus.Callback {
        C1938a() {
        }

        @Override // android.location.GnssStatus.Callback
        public final void onFirstFix(int i) {
            GpsLocation.m53960N();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onSatelliteStatusChanged(GnssStatus gnssStatus) {
            GpsLocation.this.m53950f(gnssStatus);
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStarted() {
            GpsLocation.m53962L();
        }

        @Override // android.location.GnssStatus.Callback
        public final void onStopped() {
            GpsLocation.this.m53961M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GpsLocation.java */
    /* renamed from: com.amap.api.col.3l.s5$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public final class C1939b implements GpsStatus.Listener {
        C1939b() {
        }

        @Override // android.location.GpsStatus.Listener
        public final void onGpsStatusChanged(int i) {
            try {
                GpsLocation gpsLocation = GpsLocation.this;
                LocationManager locationManager = gpsLocation.f5260c;
                if (locationManager == null) {
                    return;
                }
                gpsLocation.f5275r = locationManager.getGpsStatus(gpsLocation.f5275r);
                if (i == 1) {
                    GpsLocation.m53962L();
                } else if (i == 2) {
                    GpsLocation.this.m53961M();
                } else if (i == 3) {
                    GpsLocation.m53960N();
                } else if (i != 4) {
                } else {
                    GpsLocation.this.m53959O();
                }
            } catch (Throwable th) {
                new StringBuilder("GpsLocation | onGpsStatusChanged error: ").append(th.getMessage());
                DebugUtils.m51285a();
                C2428b.m51299a(th, "GpsLocation", "onGpsStatusChanged");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: GpsLocation.java */
    /* renamed from: com.amap.api.col.3l.s5$c */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1940c implements LocationListener {

        /* renamed from: a */
        private GpsLocation f5286a;

        C1940c(GpsLocation gpsLocation) {
            this.f5286a = gpsLocation;
        }

        /* renamed from: a */
        final void m53929a() {
            this.f5286a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                new StringBuilder("tid=").append(Thread.currentThread().getId());
                DebugUtils.m51285a();
                GpsLocation gpsLocation = this.f5286a;
                if (gpsLocation != null) {
                    gpsLocation.m53949g(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                GpsLocation gpsLocation = this.f5286a;
                if (gpsLocation != null) {
                    gpsLocation.m53939q(str);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
            try {
                GpsLocation gpsLocation = this.f5286a;
                if (gpsLocation != null) {
                    gpsLocation.m53952d(i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public GpsLocation(Context context, Handler handler) {
        this.f5266i = null;
        this.f5259b = context;
        this.f5258a = handler;
        try {
            this.f5260c = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
        } catch (Throwable th) {
            C2428b.m51299a(th, "GpsLocation", "<init>");
        }
        this.f5266i = new LocFilter();
    }

    /* renamed from: B */
    private void m53972B(AMapLocation aMapLocation) {
        if (this.f5258a != null) {
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 2;
            this.f5258a.sendMessage(obtain);
        }
    }

    /* renamed from: D */
    private void m53970D(AMapLocation aMapLocation) {
        try {
            if (C2428b.m51309a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) && this.f5261d.isOffset()) {
                DPoint m51278a = C2429e.m51278a(this.f5259b, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                aMapLocation.setLatitude(m51278a.getLatitude());
                aMapLocation.setLongitude(m51278a.getLongitude());
                aMapLocation.setOffset(this.f5261d.isOffset());
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                return;
            }
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        } catch (Throwable unused) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        }
    }

    /* renamed from: E */
    private void m53969E(AMapLocation aMapLocation) {
        try {
            int i = this.f5274q;
            if (i >= 4) {
                aMapLocation.setGpsAccuracyStatus(1);
            } else if (i == 0) {
                aMapLocation.setGpsAccuracyStatus(-1);
            } else {
                aMapLocation.setGpsAccuracyStatus(0);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: G */
    private AMapLocation m53967G(AMapLocation aMapLocation) {
        if (C2432j.m51197a(aMapLocation) && this.f5265h >= 3) {
            if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
                aMapLocation.setAccuracy(0.0f);
            }
            if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
                aMapLocation.setSpeed(0.0f);
            }
            return this.f5266i.m51639a(aMapLocation);
        }
        return aMapLocation;
    }

    /* renamed from: J */
    private static void m53964J(AMapLocation aMapLocation) {
        if (C2432j.m51197a(aMapLocation) && AuthUtil.m51314s()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long m51287a = DateUtil.m51287a(time, currentTimeMillis, AuthUtil.m51313t());
            if (m51287a != time) {
                aMapLocation.setTime(m51287a);
                ReportUtil.m51248a(time, currentTimeMillis);
            }
        }
    }

    /* renamed from: K */
    private void m53963K() {
        if (this.f5260c == null) {
            return;
        }
        try {
            m53958P();
            this.f5279v = true;
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.f5259b.getMainLooper();
            }
            Looper looper = myLooper;
            this.f5262e = C2432j.m51186b();
            if (m53938r(this.f5260c)) {
                try {
                    if (C2432j.m51211a() - f5251G >= 259200000) {
                        if (C2432j.m51174c(this.f5259b, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                            this.f5260c.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                            f5251G = C2432j.m51211a();
                            SharedPreferences.Editor m51222a = C2431i.m51222a(this.f5259b, "pref");
                            C2431i.m51214a(m51222a, "lagt", f5251G);
                            C2431i.m51217a(m51222a);
                            DebugUtils.m51285a();
                        } else {
                            C2428b.m51299a(new Exception("n_alec"), "OPENSDK_GL", "rlu_n_alec");
                        }
                    }
                } catch (Throwable th) {
                    new StringBuilder("GpsLocation | sendExtraCommand error: ").append(th.getMessage());
                    DebugUtils.m51285a();
                }
                if (this.f5282y == null) {
                    this.f5282y = new C1940c(this);
                }
                if (this.f5261d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f5261d.getDeviceModeDistanceFilter() > 0.0f) {
                    this.f5260c.requestLocationUpdates(GeocodeSearch.GPS, this.f5261d.getInterval(), this.f5261d.getDeviceModeDistanceFilter(), this.f5282y, looper);
                } else {
                    this.f5260c.requestLocationUpdates(GeocodeSearch.GPS, 900L, 0.0f, this.f5282y, looper);
                }
                if (Build.VERSION.SDK_INT >= 24) {
                    C1938a c1938a = new C1938a();
                    this.f5277t = c1938a;
                    this.f5260c.registerGnssStatusCallback(c1938a);
                } else {
                    C1939b c1939b = new C1939b();
                    this.f5276s = c1939b;
                    this.f5260c.addGpsStatusListener(c1939b);
                    DebugUtils.m51285a();
                }
                m53951e(8, 14, "no enough satellites#1401", this.f5261d.getHttpTimeOut());
                return;
            }
            DebugUtils.m51285a();
            m53951e(8, 14, "no gps provider#1402", 0L);
        } catch (SecurityException e) {
            DebugUtils.m51285a();
            this.f5279v = false;
            ReportUtil.m51233a((String) null, 2121);
            m53951e(2, 12, e.getMessage() + "#1201", 0L);
        } catch (Throwable th2) {
            new StringBuilder("GpsLocation | requestLocationUpdates error: ").append(th2.getMessage());
            DebugUtils.m51285a();
            C2428b.m51299a(th2, "GpsLocation", "requestLocationUpdates part2");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public static void m53962L() {
        DebugUtils.m51285a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: M */
    public void m53961M() {
        DebugUtils.m51285a();
        this.f5274q = 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: N */
    public static void m53960N() {
        DebugUtils.m51285a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: O */
    public void m53959O() {
        Iterable<GpsSatellite> satellites;
        int i = 0;
        try {
            GpsStatus gpsStatus = this.f5275r;
            if (gpsStatus != null && (satellites = gpsStatus.getSatellites()) != null) {
                Iterator<GpsSatellite> it = satellites.iterator();
                int maxSatellites = this.f5275r.getMaxSatellites();
                while (it.hasNext() && i < maxSatellites) {
                    if (it.next().usedInFix()) {
                        i++;
                    }
                }
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GpsLocation", "GPS_EVENT_SATELLITE_STATUS");
        }
        this.f5274q = i;
    }

    /* renamed from: P */
    private void m53958P() {
        if (C2432j.m51186b() - f5249E > 5000 || !C2432j.m51197a(f5248D)) {
            return;
        }
        if (this.f5261d.isMockEnable() || !f5248D.isMock()) {
            this.f5263f = C2432j.m51186b();
            m53930z(f5248D);
        }
    }

    /* renamed from: Q */
    private static boolean m53957Q() {
        try {
            return ((Boolean) Reflect.m51259a(C1925p4.m54183u("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), C1925p4.m54183u("UaXNOYXZpU3RhcnRlZA=="), (Object[]) null, (Class<?>[]) null)).booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: R */
    private AMapLocation m53956R() {
        float f;
        float f2;
        try {
            if (C2432j.m51197a(this.f5269l) && AuthUtil.m51322k() && m53957Q()) {
                JSONObject jSONObject = new JSONObject((String) Reflect.m51259a(C1925p4.m54183u("KY29tLmFtYXAuYXBpLm5hdmkuQU1hcE5hdmk="), C1925p4.m54183u("UZ2V0TmF2aUxvY2F0aW9u"), (Object[]) null, (Class<?>[]) null));
                long optLong = jSONObject.optLong(RtspHeaders.Values.TIME);
                if (!this.f5257C) {
                    this.f5257C = true;
                    ReportUtil.m51232a("useNaviLoc", "use NaviLoc");
                }
                if (C2432j.m51211a() - optLong <= 5500) {
                    double optDouble = jSONObject.optDouble(UContent.f38072C, Utils.DOUBLE_EPSILON);
                    double optDouble2 = jSONObject.optDouble(UContent.f38073D, Utils.DOUBLE_EPSILON);
                    float f3 = 0.0f;
                    try {
                        f = Float.parseFloat(jSONObject.optString("accuracy", "0"));
                    } catch (NumberFormatException unused) {
                        f = 0.0f;
                    }
                    double optDouble3 = jSONObject.optDouble("altitude", Utils.DOUBLE_EPSILON);
                    try {
                        f2 = Float.parseFloat(jSONObject.optString("bearing", "0"));
                    } catch (NumberFormatException unused2) {
                        f2 = 0.0f;
                    }
                    try {
                        f3 = (Float.parseFloat(jSONObject.optString("speed", "0")) * 10.0f) / 36.0f;
                    } catch (NumberFormatException unused3) {
                    }
                    AMapLocation aMapLocation = new AMapLocation("lbs");
                    aMapLocation.setLocationType(9);
                    aMapLocation.setLatitude(optDouble);
                    aMapLocation.setLongitude(optDouble2);
                    aMapLocation.setAccuracy(f);
                    aMapLocation.setAltitude(optDouble3);
                    aMapLocation.setBearing(f2);
                    aMapLocation.setSpeed(f3);
                    aMapLocation.setTime(optLong);
                    aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                    if (C2432j.m51196a(aMapLocation, this.f5269l) <= 300.0f) {
                        synchronized (this.f5273p) {
                            this.f5269l.setLongitude(optDouble2);
                            this.f5269l.setLatitude(optDouble);
                            this.f5269l.setAccuracy(f);
                            this.f5269l.setBearing(f2);
                            this.f5269l.setSpeed(f3);
                            this.f5269l.setTime(optLong);
                            this.f5269l.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
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
    /* renamed from: d */
    public void m53952d(int i) {
        if (i == 0) {
            try {
                this.f5263f = 0L;
                this.f5274q = 0;
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: e */
    private void m53951e(int i, int i2, String str, long j) {
        try {
            if (this.f5258a == null || this.f5261d.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors) {
                return;
            }
            Message obtain = Message.obtain();
            AMapLocation aMapLocation = new AMapLocation("");
            aMapLocation.setProvider(GeocodeSearch.GPS);
            aMapLocation.setErrorCode(i2);
            aMapLocation.setLocationDetail(str);
            aMapLocation.setLocationType(1);
            obtain.obj = aMapLocation;
            obtain.what = i;
            this.f5258a.sendMessageDelayed(obtain, j);
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public void m53950f(GnssStatus gnssStatus) {
        int i = 0;
        if (gnssStatus != null) {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    int satelliteCount = gnssStatus.getSatelliteCount();
                    int i2 = 0;
                    while (i < satelliteCount) {
                        try {
                            if (gnssStatus.usedInFix(i)) {
                                i2++;
                            }
                            i++;
                        } catch (Throwable th) {
                            th = th;
                            i = i2;
                            C2428b.m51299a(th, "GpsLocation_Gnss", "GPS_EVENT_SATELLITE_STATUS");
                            this.f5274q = i;
                        }
                    }
                    i = i2;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
        this.f5274q = i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: g */
    public void m53949g(Location location) {
        Handler handler = this.f5258a;
        if (handler != null) {
            handler.removeMessages(8);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (C2432j.m51197a(aMapLocation)) {
                aMapLocation.setProvider(GeocodeSearch.GPS);
                aMapLocation.setLocationType(1);
                if (!this.f5264g && C2432j.m51197a(aMapLocation)) {
                    ReportUtil.m51244a(this.f5259b, C2432j.m51186b() - this.f5262e, C2428b.m51309a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.f5264g = true;
                }
                if (C2432j.m51201a(aMapLocation, this.f5274q)) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.f5261d.isMockEnable()) {
                        int i = this.f5281x;
                        if (i > 3) {
                            ReportUtil.m51233a((String) null, 2152);
                            aMapLocation.setErrorCode(15);
                            aMapLocation.setLocationDetail("GpsLocation has been mocked!#1501");
                            aMapLocation.setLatitude(Utils.DOUBLE_EPSILON);
                            aMapLocation.setLongitude(Utils.DOUBLE_EPSILON);
                            aMapLocation.setAltitude(Utils.DOUBLE_EPSILON);
                            aMapLocation.setSpeed(0.0f);
                            aMapLocation.setAccuracy(0.0f);
                            aMapLocation.setBearing(0.0f);
                            aMapLocation.setExtras(null);
                            m53930z(aMapLocation);
                            return;
                        }
                        this.f5281x = i + 1;
                        return;
                    }
                } else {
                    this.f5281x = 0;
                }
                aMapLocation.setSatellites(this.f5274q);
                m53970D(aMapLocation);
                m53969E(aMapLocation);
                m53964J(aMapLocation);
                AMapLocation m53967G = m53967G(aMapLocation);
                m53942n(m53967G);
                m53936t(m53967G);
                synchronized (this.f5272o) {
                    m53941o(m53967G, f5254J);
                }
                if (C2432j.m51197a(m53967G)) {
                    if (this.f5269l != null) {
                        this.f5270m = location.getTime() - this.f5269l.getTime();
                        this.f5271n = C2432j.m51196a(this.f5269l, m53967G);
                    }
                    synchronized (this.f5273p) {
                        this.f5269l = m53967G.m60094clone();
                    }
                    this.f5283z = null;
                    this.f5255A = false;
                    this.f5256B = 0;
                }
                m53930z(m53967G);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "GpsLocation", "onLocationChanged");
        }
    }

    /* renamed from: n */
    private void m53942n(AMapLocation aMapLocation) {
        if (C2432j.m51197a(aMapLocation)) {
            this.f5263f = C2432j.m51186b();
            synchronized (f5250F) {
                f5249E = C2432j.m51186b();
                f5248D = aMapLocation.m60094clone();
            }
            this.f5265h++;
        }
    }

    /* renamed from: o */
    private void m53941o(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.f5261d.isNeedAddress() || C2432j.m51196a(aMapLocation, aMapLocation2) >= this.f5267j) {
            return;
        }
        C2428b.m51304a(aMapLocation, aMapLocation2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: q */
    public void m53939q(String str) {
        try {
            if (GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                this.f5263f = 0L;
                this.f5274q = 0;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: r */
    private static boolean m53938r(LocationManager locationManager) {
        try {
            if (f5252H) {
                return f5253I;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders != null && allProviders.size() > 0) {
                f5253I = allProviders.contains(GeocodeSearch.GPS);
            } else {
                f5253I = false;
            }
            f5252H = true;
            return f5253I;
        } catch (Throwable th) {
            new StringBuilder("GpsLocation | hasProvider error: ").append(th.getMessage());
            DebugUtils.m51285a();
            return f5253I;
        }
    }

    /* renamed from: t */
    private void m53936t(AMapLocation aMapLocation) {
        if (C2432j.m51197a(aMapLocation) && this.f5258a != null) {
            long m51186b = C2432j.m51186b();
            if (this.f5261d.getInterval() <= 8000 || m51186b - this.f5280w > this.f5261d.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble(UContent.f38072C, aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong(RtspHeaders.Values.TIME, aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 5;
                synchronized (this.f5272o) {
                    if (f5254J == null) {
                        this.f5258a.sendMessage(obtain);
                    } else if (C2432j.m51196a(aMapLocation, f5254J) > this.f5268k) {
                        this.f5258a.sendMessage(obtain);
                    }
                }
            }
        }
    }

    /* renamed from: w */
    private boolean m53933w(String str) {
        try {
            ArrayList<String> m51179b = C2432j.m51179b(str);
            ArrayList<String> m51179b2 = C2432j.m51179b(this.f5283z);
            if (m51179b.size() < 8 || m51179b2.size() < 8) {
                return false;
            }
            return C2432j.m51190a(this.f5283z, str);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: z */
    private void m53930z(AMapLocation aMapLocation) {
        if (aMapLocation.getErrorCode() != 15 || AMapLocationClientOption.AMapLocationMode.Device_Sensors.equals(this.f5261d.getLocationMode())) {
            if (this.f5261d.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f5261d.getDeviceModeDistanceFilter() > 0.0f) {
                m53972B(aMapLocation);
            } else if (C2432j.m51186b() - this.f5280w >= this.f5261d.getInterval() - 200) {
                this.f5280w = C2432j.m51186b();
                m53972B(aMapLocation);
            }
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: A */
    public final int m53973A() {
        LocationManager locationManager = this.f5260c;
        if (locationManager != null && m53938r(locationManager)) {
            if (Build.VERSION.SDK_INT < 19) {
                if (!this.f5260c.isProviderEnabled(GeocodeSearch.GPS)) {
                    return 2;
                }
            } else {
                int i = Settings.Secure.getInt(this.f5259b.getContentResolver(), "location_mode", 0);
                if (i == 0) {
                    return 2;
                }
                if (i == 2) {
                    return 3;
                }
            }
            return !this.f5279v ? 4 : 0;
        }
        return 1;
    }

    /* renamed from: C */
    public final int m53971C() {
        return this.f5274q;
    }

    /* renamed from: F */
    public final boolean m53968F() {
        AMapLocationClientOption aMapLocationClientOption = this.f5261d;
        return (aMapLocationClientOption == null || aMapLocationClientOption.isOnceLocation() || C2432j.m51186b() - this.f5263f <= 300000) ? false : true;
    }

    /* JADX WARN: Removed duplicated region for block: B:51:0x00a4 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00a5  */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.amap.api.location.AMapLocation m53954b(com.amap.api.location.AMapLocation r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 229
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0463l.GpsLocation.m53954b(com.amap.api.location.AMapLocation, java.lang.String):com.amap.api.location.AMapLocation");
    }

    /* renamed from: c */
    public final void m53953c() {
        LocationManager locationManager = this.f5260c;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f5282y;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((C1940c) this.f5282y).m53929a();
                this.f5282y = null;
            }
        } catch (Throwable unused) {
        }
        try {
            GpsStatus.Listener listener = this.f5276s;
            if (listener != null) {
                this.f5260c.removeGpsStatusListener(listener);
            }
        } catch (Throwable unused2) {
        }
        try {
            GnssStatus.Callback callback = this.f5277t;
            if (callback != null) {
                this.f5260c.unregisterGnssStatusCallback(callback);
            }
        } catch (Throwable unused3) {
        }
        try {
            Handler handler = this.f5258a;
            if (handler != null) {
                handler.removeMessages(8);
            }
        } catch (Throwable unused4) {
        }
        this.f5274q = 0;
        this.f5262e = 0L;
        this.f5280w = 0L;
        this.f5263f = 0L;
        this.f5265h = 0;
        this.f5281x = 0;
        this.f5266i.m51640a();
        this.f5269l = null;
        this.f5270m = 0L;
        this.f5271n = 0.0f;
        this.f5283z = null;
        this.f5257C = false;
    }

    /* renamed from: h */
    public final void m53948h(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f5267j = bundle.getInt("I_MAX_GEO_DIS");
                this.f5268k = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.f5272o) {
                    f5254J = aMapLocation;
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "GpsLocation", "setLastGeoLocation");
            }
        }
    }

    /* renamed from: p */
    public final void m53940p(AMapLocationClientOption aMapLocationClientOption) {
        this.f5261d = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f5261d = new AMapLocationClientOption();
        }
        try {
            f5251G = C2431i.m51220a(this.f5259b, "pref", "lagt", f5251G);
        } catch (Throwable unused) {
        }
        m53963K();
    }

    /* renamed from: u */
    public final void m53935u(AMapLocationClientOption aMapLocationClientOption) {
        Handler handler;
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f5261d = aMapLocationClientOption;
        if (aMapLocationClientOption.getLocationMode() != AMapLocationClientOption.AMapLocationMode.Device_Sensors && (handler = this.f5258a) != null) {
            handler.removeMessages(8);
        }
        if (this.f5278u != this.f5261d.getGeoLanguage()) {
            synchronized (this.f5272o) {
                f5254J = null;
            }
        }
        this.f5278u = this.f5261d.getGeoLanguage();
    }

    /* renamed from: v */
    public final boolean m53934v() {
        return C2432j.m51186b() - this.f5263f <= 2800;
    }

    /* renamed from: x */
    public final void m53932x() {
        this.f5281x = 0;
    }
}
