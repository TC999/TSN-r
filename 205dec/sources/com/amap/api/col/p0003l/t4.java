package com.amap.api.col.p0003l;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
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
import com.autonavi.aps.amapapi.utils.b;
import com.autonavi.aps.amapapi.utils.c;
import com.autonavi.aps.amapapi.utils.d;
import com.autonavi.aps.amapapi.utils.e;
import com.autonavi.aps.amapapi.utils.f;
import com.autonavi.aps.amapapi.utils.h;
import com.autonavi.aps.amapapi.utils.i;
import com.autonavi.aps.amapapi.utils.j;
import com.stub.StubApp;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: CoarseLocation.java */
/* renamed from: com.amap.api.col.3l.t4  reason: invalid package */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public final class t4 {

    /* renamed from: r  reason: collision with root package name */
    private static String f9013r = "CoarseLocation";

    /* renamed from: s  reason: collision with root package name */
    private static long f9014s;

    /* renamed from: t  reason: collision with root package name */
    private static boolean f9015t;

    /* renamed from: u  reason: collision with root package name */
    private static boolean f9016u;

    /* renamed from: v  reason: collision with root package name */
    private static boolean f9017v;

    /* renamed from: w  reason: collision with root package name */
    private static boolean f9018w;

    /* renamed from: x  reason: collision with root package name */
    public static volatile AMapLocation f9019x;

    /* renamed from: d  reason: collision with root package name */
    private com.autonavi.aps.amapapi.filters.a f9023d;

    /* renamed from: h  reason: collision with root package name */
    private Handler f9027h;

    /* renamed from: i  reason: collision with root package name */
    private Context f9028i;

    /* renamed from: l  reason: collision with root package name */
    private LocationManager f9031l;

    /* renamed from: m  reason: collision with root package name */
    private AMapLocationClientOption f9032m;

    /* renamed from: a  reason: collision with root package name */
    private long f9020a = 0;

    /* renamed from: b  reason: collision with root package name */
    private boolean f9021b = false;

    /* renamed from: c  reason: collision with root package name */
    private int f9022c = 0;

    /* renamed from: e  reason: collision with root package name */
    private int f9024e = 240;

    /* renamed from: f  reason: collision with root package name */
    private int f9025f = 80;

    /* renamed from: g  reason: collision with root package name */
    private int f9026g = 0;

    /* renamed from: j  reason: collision with root package name */
    private long f9029j = 0;

    /* renamed from: k  reason: collision with root package name */
    private int f9030k = 0;

    /* renamed from: n  reason: collision with root package name */
    private Object f9033n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private boolean f9034o = true;

    /* renamed from: p  reason: collision with root package name */
    private AMapLocationClientOption.GeoLanguage f9035p = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: q  reason: collision with root package name */
    private LocationListener f9036q = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CoarseLocation.java */
    /* renamed from: com.amap.api.col.3l.t4$a */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class a implements LocationListener {

        /* renamed from: a  reason: collision with root package name */
        private t4 f9037a;

        a(t4 t4Var) {
            this.f9037a = t4Var;
        }

        final void a() {
            this.f9037a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                t4 t4Var = this.f9037a;
                if (t4Var != null) {
                    t4Var.e(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                t4 t4Var = this.f9037a;
                if (t4Var != null) {
                    t4Var.A();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            if ("gps".equalsIgnoreCase(str)) {
                d.a();
            }
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i4, Bundle bundle) {
            try {
                t4 t4Var = this.f9037a;
                if (t4Var != null) {
                    t4Var.c(i4);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public t4(Context context, Handler handler) {
        this.f9023d = null;
        this.f9028i = context;
        this.f9027h = handler;
        try {
            this.f9031l = (LocationManager) context.getSystemService("location");
        } catch (Throwable th) {
            b.a(th, f9013r, "<init>");
        }
        this.f9023d = new com.autonavi.aps.amapapi.filters.a();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A() {
        try {
            d.a();
            this.f9026g = 0;
        } catch (Throwable unused) {
        }
    }

    private static void B(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && com.autonavi.aps.amapapi.utils.a.s()) {
            long time = aMapLocation.getTime();
            long currentTimeMillis = System.currentTimeMillis();
            long a4 = c.a(time, currentTimeMillis, com.autonavi.aps.amapapi.utils.a.t());
            if (a4 != time) {
                aMapLocation.setTime(a4);
                h.a(time, currentTimeMillis);
            }
        }
    }

    private static com.autonavi.aps.amapapi.model.a a(int i4, String str) {
        com.autonavi.aps.amapapi.model.a aVar = new com.autonavi.aps.amapapi.model.a("");
        aVar.setErrorCode(i4);
        aVar.setLocationDetail(str);
        return aVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4) {
        if (i4 == 0) {
            try {
                d.a();
                this.f9026g = 0;
            } catch (Throwable unused) {
            }
        }
    }

    private void d(int i4, String str, long j4) {
        try {
            if (this.f9027h != null) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(20);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(11);
                obtain.obj = aMapLocation;
                obtain.what = i4;
                this.f9027h.sendMessageDelayed(obtain, j4);
            }
        } catch (Throwable unused) {
            d.b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(Location location) {
        Handler handler = this.f9027h;
        if (handler != null) {
            handler.removeMessages(100);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (j.a(aMapLocation)) {
                if ("gps".equals(location.getProvider())) {
                    aMapLocation.setProvider("gps_coarse");
                } else {
                    aMapLocation.setProvider("network_coarse");
                }
                aMapLocation.setLocationType(11);
                if (!this.f9021b && j.a(aMapLocation)) {
                    h.b(this.f9028i, j.b() - this.f9020a, b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.f9021b = true;
                }
                Boolean bool = Boolean.FALSE;
                if (Build.VERSION.SDK_INT >= 18) {
                    try {
                        Boolean bool2 = (Boolean) f.a(location, "isFromMockProvider", new Object[0]);
                        try {
                            "CoarseLocation | isFromMock=".concat(String.valueOf(bool2));
                            d.a();
                        } catch (Throwable unused) {
                        }
                        bool = bool2;
                    } catch (Throwable unused2) {
                    }
                }
                if (bool.booleanValue()) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.f9032m.isMockEnable()) {
                        int i4 = this.f9030k;
                        if (i4 > 3) {
                            h.a((String) null, 2152);
                            aMapLocation.setErrorCode(15);
                            aMapLocation.setLocationDetail("CoarseLocation has been mocked!#2007");
                            aMapLocation.setLatitude(0.0d);
                            aMapLocation.setLongitude(0.0d);
                            aMapLocation.setAltitude(0.0d);
                            aMapLocation.setSpeed(0.0f);
                            aMapLocation.setAccuracy(0.0f);
                            aMapLocation.setBearing(0.0f);
                            aMapLocation.setExtras(null);
                            s(aMapLocation);
                            return;
                        }
                        this.f9030k = i4 + 1;
                        return;
                    }
                } else {
                    this.f9030k = 0;
                }
                int o4 = o(location);
                this.f9026g = o4;
                aMapLocation.setSatellites(o4);
                x(aMapLocation);
                B(aMapLocation);
                AMapLocation y3 = y(aMapLocation);
                j(y3);
                p(y3);
                synchronized (this.f9033n) {
                    k(y3, f9019x);
                }
                s(y3);
            }
        } catch (Throwable th) {
            b.a(th, "CoarseLocation", "onLocationChanged");
        }
    }

    private void j(AMapLocation aMapLocation) {
        if (j.a(aMapLocation)) {
            this.f9022c++;
        }
    }

    private void k(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.f9032m.isNeedAddress() || j.a(aMapLocation, aMapLocation2) >= this.f9024e) {
            return;
        }
        b.a(aMapLocation, aMapLocation2);
    }

    private static boolean m(LocationManager locationManager) {
        try {
            if (f9015t) {
                return f9016u;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders != null && allProviders.size() > 0) {
                f9016u = allProviders.contains("gps");
            } else {
                f9016u = false;
            }
            f9015t = true;
            return f9016u;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            d.a();
            return f9016u;
        }
    }

    private static int o(Location location) {
        Bundle extras = location.getExtras();
        int i4 = extras != null ? extras.getInt("satellites") : 0;
        d.b();
        return i4;
    }

    private void p(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && this.f9027h != null) {
            long b4 = j.b();
            if (this.f9032m.getInterval() <= 8000 || b4 - this.f9029j > this.f9032m.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble("lat", aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong("time", aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 102;
                synchronized (this.f9033n) {
                    if (f9019x == null) {
                        this.f9027h.sendMessage(obtain);
                    } else if (j.a(aMapLocation, f9019x) > this.f9025f) {
                        this.f9027h.sendMessage(obtain);
                    }
                }
            }
        }
    }

    private static boolean r(LocationManager locationManager) {
        try {
            if (f9017v) {
                return f9018w;
            }
            boolean isProviderEnabled = locationManager.isProviderEnabled("network");
            f9018w = isProviderEnabled;
            f9017v = true;
            return isProviderEnabled;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            d.a();
            return f9018w;
        }
    }

    private void s(AMapLocation aMapLocation) {
        if (this.f9032m.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f9032m.getDeviceModeDistanceFilter() > 0.0f) {
            v(aMapLocation);
        } else if (j.b() - this.f9029j >= this.f9032m.getInterval() - 200) {
            this.f9029j = j.b();
            v(aMapLocation);
        }
    }

    private boolean t() {
        boolean z3 = true;
        try {
            if (j.c() >= 28) {
                if (this.f9031l == null) {
                    this.f9031l = (LocationManager) StubApp.getOrigApplicationContext(this.f9028i.getApplicationContext()).getSystemService("location");
                }
                z3 = ((Boolean) f.a(this.f9031l, "isLocationEnabled", new Object[0])).booleanValue();
            }
            if (j.c() >= 24 && j.c() < 28) {
                if (Settings.Secure.getInt(this.f9028i.getContentResolver(), "location_mode", 0) == 0) {
                    return false;
                }
            }
        } catch (Throwable unused) {
            d.a();
        }
        return z3;
    }

    private void u() {
        s(a(12, "\u5b9a\u4f4d\u670d\u52a1\u6ca1\u6709\u5f00\u542f\uff0c\u8bf7\u5728\u8bbe\u7f6e\u4e2d\u6253\u5f00\u5b9a\u4f4d\u670d\u52a1\u5f00\u5173#1206"));
    }

    private void v(AMapLocation aMapLocation) {
        if (this.f9027h != null) {
            d.a();
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 101;
            this.f9027h.sendMessage(obtain);
        }
    }

    private void w() {
        s(a(20, "\u6a21\u7cca\u6743\u9650\u4e0b\u4e0d\u652f\u6301\u8fde\u7eed\u5b9a\u4f4d#2006"));
    }

    private void x(AMapLocation aMapLocation) {
        try {
            if (b.a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) && this.f9032m.isOffset()) {
                DPoint a4 = e.a(this.f9028i, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                aMapLocation.setLatitude(a4.getLatitude());
                aMapLocation.setLongitude(a4.getLongitude());
                aMapLocation.setOffset(this.f9032m.isOffset());
                aMapLocation.setCoordType("GCJ02");
                return;
            }
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType("WGS84");
        } catch (Throwable th) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType("WGS84");
            new StringBuilder("CoarseLocation | offset error: ").append(th.getMessage());
            d.a();
        }
    }

    private AMapLocation y(AMapLocation aMapLocation) {
        if (j.a(aMapLocation) && this.f9022c >= 3) {
            if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
                aMapLocation.setAccuracy(0.0f);
            }
            if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
                aMapLocation.setSpeed(0.0f);
            }
            return this.f9023d.a(aMapLocation);
        }
        return aMapLocation;
    }

    private void z() {
        if (this.f9031l == null) {
            return;
        }
        try {
            this.f9034o = true;
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.f9028i.getMainLooper();
            }
            this.f9020a = j.b();
            if (r(this.f9031l)) {
                if (this.f9036q == null) {
                    this.f9036q = new a(this);
                }
                this.f9031l.requestLocationUpdates("network", this.f9032m.getInterval(), this.f9032m.getDeviceModeDistanceFilter(), this.f9036q, myLooper);
            }
            if (m(this.f9031l)) {
                try {
                    if (j.a() - f9014s >= 259200000) {
                        if (j.c(this.f9028i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                            this.f9031l.sendExtraCommand("gps", "force_xtra_injection", null);
                            f9014s = j.a();
                            SharedPreferences.Editor a4 = i.a(this.f9028i, "pref");
                            i.a(a4, "lagt", f9014s);
                            i.a(a4);
                            d.a();
                        } else {
                            b.a(new Exception("n_alec"), "OPENSDK_CL", "rlu_n_alec");
                        }
                    }
                } catch (Throwable th) {
                    new StringBuilder("CoarseLocation | sendExtraCommand error: ").append(th.getMessage());
                    d.a();
                }
                if (this.f9036q == null) {
                    this.f9036q = new a(this);
                }
                this.f9031l.requestLocationUpdates("gps", this.f9032m.getInterval(), this.f9032m.getDeviceModeDistanceFilter(), this.f9036q, myLooper);
                d.a();
            }
            if (f9016u || f9018w) {
                d(100, "\u7cfb\u7edf\u8fd4\u56de\u5b9a\u4f4d\u7ed3\u679c\u8d85\u65f6#2002", this.f9032m.getHttpTimeOut());
            }
            if (f9016u || f9018w) {
                return;
            }
            d.a();
            d(100, "\u7cfb\u7edf\u5b9a\u4f4d\u5f53\u524d\u4e0d\u53ef\u7528#2003", 0L);
        } catch (SecurityException e4) {
            d.a();
            this.f9034o = false;
            h.a((String) null, 2121);
            d(101, e4.getMessage() + "#2004", 0L);
        } catch (Throwable th2) {
            new StringBuilder("CoarseLocation | requestLocationUpdates error: ").append(th2.getMessage());
            d.a();
            b.a(th2, "CoarseLocation", "requestLocationUpdates part2");
        }
    }

    public final void b() {
        d.a();
        LocationManager locationManager = this.f9031l;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f9036q;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((a) this.f9036q).a();
                this.f9036q = null;
                d.a();
            }
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | removeUpdates error ").append(th.getMessage());
            d.a();
        }
        try {
            Handler handler = this.f9027h;
            if (handler != null) {
                handler.removeMessages(100);
            }
        } catch (Throwable unused) {
        }
        this.f9026g = 0;
        this.f9020a = 0L;
        this.f9029j = 0L;
        this.f9022c = 0;
        this.f9030k = 0;
        this.f9023d.a();
    }

    public final void f(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f9024e = bundle.getInt("I_MAX_GEO_DIS");
                this.f9025f = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.f9033n) {
                    f9019x = aMapLocation;
                }
            } catch (Throwable th) {
                b.a(th, "CoarseLocation", "setLastGeoLocation");
            }
        }
    }

    public final void l(AMapLocationClientOption aMapLocationClientOption) {
        this.f9032m = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f9032m = new AMapLocationClientOption();
        }
        new StringBuilder("option: ").append(this.f9032m.toString());
        d.a();
        if (!this.f9032m.isOnceLocation()) {
            w();
        } else if (!t()) {
            u();
        } else {
            try {
                f9014s = i.a(this.f9028i, "pref", "lagt", f9014s);
            } catch (Throwable unused) {
            }
            z();
        }
    }

    @SuppressLint({"NewApi"})
    public final int n() {
        LocationManager locationManager = this.f9031l;
        if (locationManager != null && m(locationManager)) {
            if (Build.VERSION.SDK_INT < 19) {
                if (!this.f9031l.isProviderEnabled("gps")) {
                    return 2;
                }
            } else {
                int i4 = Settings.Secure.getInt(this.f9028i.getContentResolver(), "location_mode", 0);
                if (i4 == 0) {
                    return 2;
                }
                if (i4 == 2) {
                    return 3;
                }
            }
            return !this.f9034o ? 4 : 0;
        }
        return 1;
    }

    public final void q(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f9032m = aMapLocationClientOption;
        new StringBuilder("option: ").append(this.f9032m.toString());
        d.a();
        this.f9027h.removeMessages(100);
        if (this.f9035p != this.f9032m.getGeoLanguage()) {
            synchronized (this.f9033n) {
                f9019x = null;
            }
        }
        this.f9035p = this.f9032m.getGeoLanguage();
    }
}
