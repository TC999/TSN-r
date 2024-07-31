package com.amap.api.col.p0463l;

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
import com.amap.api.services.geocoder.GeocodeSearch;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.autonavi.aps.amapapi.filters.LocFilter;
import com.autonavi.aps.amapapi.model.AMapLocationServer;
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
import com.stub.StubApp;
import com.umeng.analytics.pro.UContent;
import com.umeng.socialize.common.SocializeConstants;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.List;

/* renamed from: com.amap.api.col.3l.s4 */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public final class CoarseLocation {

    /* renamed from: r */
    private static String f5223r = "CoarseLocation";

    /* renamed from: s */
    private static long f5224s;

    /* renamed from: t */
    private static boolean f5225t;

    /* renamed from: u */
    private static boolean f5226u;

    /* renamed from: v */
    private static boolean f5227v;

    /* renamed from: w */
    private static boolean f5228w;

    /* renamed from: x */
    public static volatile AMapLocation f5229x;

    /* renamed from: d */
    private LocFilter f5233d;

    /* renamed from: h */
    private Handler f5237h;

    /* renamed from: i */
    private Context f5238i;

    /* renamed from: l */
    private LocationManager f5241l;

    /* renamed from: m */
    private AMapLocationClientOption f5242m;

    /* renamed from: a */
    private long f5230a = 0;

    /* renamed from: b */
    private boolean f5231b = false;

    /* renamed from: c */
    private int f5232c = 0;

    /* renamed from: e */
    private int f5234e = GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN;

    /* renamed from: f */
    private int f5235f = 80;

    /* renamed from: g */
    private int f5236g = 0;

    /* renamed from: j */
    private long f5239j = 0;

    /* renamed from: k */
    private int f5240k = 0;

    /* renamed from: n */
    private Object f5243n = new Object();

    /* renamed from: o */
    private boolean f5244o = true;

    /* renamed from: p */
    private AMapLocationClientOption.GeoLanguage f5245p = AMapLocationClientOption.GeoLanguage.DEFAULT;

    /* renamed from: q */
    private LocationListener f5246q = null;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CoarseLocation.java */
    /* renamed from: com.amap.api.col.3l.s4$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class C1937a implements LocationListener {

        /* renamed from: a */
        private CoarseLocation f5247a;

        C1937a(CoarseLocation coarseLocation) {
            this.f5247a = coarseLocation;
        }

        /* renamed from: a */
        final void m53974a() {
            this.f5247a = null;
        }

        @Override // android.location.LocationListener
        public final void onLocationChanged(Location location) {
            try {
                CoarseLocation coarseLocation = this.f5247a;
                if (coarseLocation != null) {
                    coarseLocation.m53996e(location);
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderDisabled(String str) {
            try {
                CoarseLocation coarseLocation = this.f5247a;
                if (coarseLocation != null) {
                    coarseLocation.m54002A();
                }
            } catch (Throwable unused) {
            }
        }

        @Override // android.location.LocationListener
        public final void onProviderEnabled(String str) {
            if (GeocodeSearch.GPS.equalsIgnoreCase(str)) {
                DebugUtils.m51285a();
            }
        }

        @Override // android.location.LocationListener
        public final void onStatusChanged(String str, int i, Bundle bundle) {
            try {
                CoarseLocation coarseLocation = this.f5247a;
                if (coarseLocation != null) {
                    coarseLocation.m53998c(i);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public CoarseLocation(Context context, Handler handler) {
        this.f5233d = null;
        this.f5238i = context;
        this.f5237h = handler;
        try {
            this.f5241l = (LocationManager) context.getSystemService(SocializeConstants.KEY_LOCATION);
        } catch (Throwable th) {
            C2428b.m51299a(th, f5223r, "<init>");
        }
        this.f5233d = new LocFilter();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: A */
    public void m54002A() {
        try {
            DebugUtils.m51285a();
            this.f5236g = 0;
        } catch (Throwable unused) {
        }
    }

    /* renamed from: B */
    private static void m54001B(AMapLocation aMapLocation) {
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

    /* renamed from: a */
    private static AMapLocationServer m54000a(int i, String str) {
        AMapLocationServer aMapLocationServer = new AMapLocationServer("");
        aMapLocationServer.setErrorCode(i);
        aMapLocationServer.setLocationDetail(str);
        return aMapLocationServer;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public void m53998c(int i) {
        if (i == 0) {
            try {
                DebugUtils.m51285a();
                this.f5236g = 0;
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: d */
    private void m53997d(int i, String str, long j) {
        try {
            if (this.f5237h != null) {
                Message obtain = Message.obtain();
                AMapLocation aMapLocation = new AMapLocation("");
                aMapLocation.setErrorCode(20);
                aMapLocation.setLocationDetail(str);
                aMapLocation.setLocationType(11);
                obtain.obj = aMapLocation;
                obtain.what = i;
                this.f5237h.sendMessageDelayed(obtain, j);
            }
        } catch (Throwable unused) {
            DebugUtils.m51283b();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m53996e(Location location) {
        Handler handler = this.f5237h;
        if (handler != null) {
            handler.removeMessages(100);
        }
        if (location == null) {
            return;
        }
        try {
            AMapLocation aMapLocation = new AMapLocation(location);
            if (C2432j.m51197a(aMapLocation)) {
                if (GeocodeSearch.GPS.equals(location.getProvider())) {
                    aMapLocation.setProvider("gps_coarse");
                } else {
                    aMapLocation.setProvider("network_coarse");
                }
                aMapLocation.setLocationType(11);
                if (!this.f5231b && C2432j.m51197a(aMapLocation)) {
                    ReportUtil.m51228b(this.f5238i, C2432j.m51186b() - this.f5230a, C2428b.m51309a(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                    this.f5231b = true;
                }
                Boolean bool = Boolean.FALSE;
                if (Build.VERSION.SDK_INT >= 18) {
                    try {
                        Boolean bool2 = (Boolean) Reflect.m51261a(location, "isFromMockProvider", new Object[0]);
                        try {
                            "CoarseLocation | isFromMock=".concat(String.valueOf(bool2));
                            DebugUtils.m51285a();
                        } catch (Throwable unused) {
                        }
                        bool = bool2;
                    } catch (Throwable unused2) {
                    }
                }
                if (bool.booleanValue()) {
                    aMapLocation.setMock(true);
                    aMapLocation.setTrustedLevel(4);
                    if (!this.f5242m.isMockEnable()) {
                        int i = this.f5240k;
                        if (i > 3) {
                            ReportUtil.m51233a((String) null, 2152);
                            aMapLocation.setErrorCode(15);
                            aMapLocation.setLocationDetail("CoarseLocation has been mocked!#2007");
                            aMapLocation.setLatitude(Utils.DOUBLE_EPSILON);
                            aMapLocation.setLongitude(Utils.DOUBLE_EPSILON);
                            aMapLocation.setAltitude(Utils.DOUBLE_EPSILON);
                            aMapLocation.setSpeed(0.0f);
                            aMapLocation.setAccuracy(0.0f);
                            aMapLocation.setBearing(0.0f);
                            aMapLocation.setExtras(null);
                            m53982s(aMapLocation);
                            return;
                        }
                        this.f5240k = i + 1;
                        return;
                    }
                } else {
                    this.f5240k = 0;
                }
                int m53986o = m53986o(location);
                this.f5236g = m53986o;
                aMapLocation.setSatellites(m53986o);
                m53977x(aMapLocation);
                m54001B(aMapLocation);
                AMapLocation m53976y = m53976y(aMapLocation);
                m53991j(m53976y);
                m53985p(m53976y);
                synchronized (this.f5243n) {
                    m53990k(m53976y, f5229x);
                }
                m53982s(m53976y);
            }
        } catch (Throwable th) {
            C2428b.m51299a(th, "CoarseLocation", "onLocationChanged");
        }
    }

    /* renamed from: j */
    private void m53991j(AMapLocation aMapLocation) {
        if (C2432j.m51197a(aMapLocation)) {
            this.f5232c++;
        }
    }

    /* renamed from: k */
    private void m53990k(AMapLocation aMapLocation, AMapLocation aMapLocation2) {
        if (aMapLocation2 == null || !this.f5242m.isNeedAddress() || C2432j.m51196a(aMapLocation, aMapLocation2) >= this.f5234e) {
            return;
        }
        C2428b.m51304a(aMapLocation, aMapLocation2);
    }

    /* renamed from: m */
    private static boolean m53988m(LocationManager locationManager) {
        try {
            if (f5225t) {
                return f5226u;
            }
            List<String> allProviders = locationManager.getAllProviders();
            if (allProviders != null && allProviders.size() > 0) {
                f5226u = allProviders.contains(GeocodeSearch.GPS);
            } else {
                f5226u = false;
            }
            f5225t = true;
            return f5226u;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            DebugUtils.m51285a();
            return f5226u;
        }
    }

    /* renamed from: o */
    private static int m53986o(Location location) {
        Bundle extras = location.getExtras();
        int i = extras != null ? extras.getInt("satellites") : 0;
        DebugUtils.m51283b();
        return i;
    }

    /* renamed from: p */
    private void m53985p(AMapLocation aMapLocation) {
        if (C2432j.m51197a(aMapLocation) && this.f5237h != null) {
            long m51186b = C2432j.m51186b();
            if (this.f5242m.getInterval() <= 8000 || m51186b - this.f5239j > this.f5242m.getInterval() - 8000) {
                Bundle bundle = new Bundle();
                bundle.putDouble(UContent.f38072C, aMapLocation.getLatitude());
                bundle.putDouble("lon", aMapLocation.getLongitude());
                bundle.putFloat("radius", aMapLocation.getAccuracy());
                bundle.putLong(RtspHeaders.Values.TIME, aMapLocation.getTime());
                Message obtain = Message.obtain();
                obtain.setData(bundle);
                obtain.what = 102;
                synchronized (this.f5243n) {
                    if (f5229x == null) {
                        this.f5237h.sendMessage(obtain);
                    } else if (C2432j.m51196a(aMapLocation, f5229x) > this.f5235f) {
                        this.f5237h.sendMessage(obtain);
                    }
                }
            }
        }
    }

    /* renamed from: r */
    private static boolean m53983r(LocationManager locationManager) {
        try {
            if (f5227v) {
                return f5228w;
            }
            boolean isProviderEnabled = locationManager.isProviderEnabled("network");
            f5228w = isProviderEnabled;
            f5227v = true;
            return isProviderEnabled;
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | hasProvider error: ").append(th.getMessage());
            DebugUtils.m51285a();
            return f5228w;
        }
    }

    /* renamed from: s */
    private void m53982s(AMapLocation aMapLocation) {
        if (this.f5242m.getLocationMode().equals(AMapLocationClientOption.AMapLocationMode.Device_Sensors) && this.f5242m.getDeviceModeDistanceFilter() > 0.0f) {
            m53979v(aMapLocation);
        } else if (C2432j.m51186b() - this.f5239j >= this.f5242m.getInterval() - 200) {
            this.f5239j = C2432j.m51186b();
            m53979v(aMapLocation);
        }
    }

    /* renamed from: t */
    private boolean m53981t() {
        boolean z = true;
        try {
            if (C2432j.m51177c() >= 28) {
                if (this.f5241l == null) {
                    this.f5241l = (LocationManager) StubApp.getOrigApplicationContext(this.f5238i.getApplicationContext()).getSystemService(SocializeConstants.KEY_LOCATION);
                }
                z = ((Boolean) Reflect.m51261a(this.f5241l, "isLocationEnabled", new Object[0])).booleanValue();
            }
            if (C2432j.m51177c() >= 24 && C2432j.m51177c() < 28) {
                if (Settings.Secure.getInt(this.f5238i.getContentResolver(), "location_mode", 0) == 0) {
                    return false;
                }
            }
        } catch (Throwable unused) {
            DebugUtils.m51285a();
        }
        return z;
    }

    /* renamed from: u */
    private void m53980u() {
        m53982s(m54000a(12, "定位服务没有开启，请在设置中打开定位服务开关#1206"));
    }

    /* renamed from: v */
    private void m53979v(AMapLocation aMapLocation) {
        if (this.f5237h != null) {
            DebugUtils.m51285a();
            Message obtain = Message.obtain();
            obtain.obj = aMapLocation;
            obtain.what = 101;
            this.f5237h.sendMessage(obtain);
        }
    }

    /* renamed from: w */
    private void m53978w() {
        m53982s(m54000a(20, "模糊权限下不支持连续定位#2006"));
    }

    /* renamed from: x */
    private void m53977x(AMapLocation aMapLocation) {
        try {
            if (C2428b.m51309a(aMapLocation.getLatitude(), aMapLocation.getLongitude()) && this.f5242m.isOffset()) {
                DPoint m51278a = C2429e.m51278a(this.f5238i, new DPoint(aMapLocation.getLatitude(), aMapLocation.getLongitude()));
                aMapLocation.setLatitude(m51278a.getLatitude());
                aMapLocation.setLongitude(m51278a.getLongitude());
                aMapLocation.setOffset(this.f5242m.isOffset());
                aMapLocation.setCoordType(AMapLocation.COORD_TYPE_GCJ02);
                return;
            }
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
        } catch (Throwable th) {
            aMapLocation.setOffset(false);
            aMapLocation.setCoordType(AMapLocation.COORD_TYPE_WGS84);
            new StringBuilder("CoarseLocation | offset error: ").append(th.getMessage());
            DebugUtils.m51285a();
        }
    }

    /* renamed from: y */
    private AMapLocation m53976y(AMapLocation aMapLocation) {
        if (C2432j.m51197a(aMapLocation) && this.f5232c >= 3) {
            if (aMapLocation.getAccuracy() < 0.0f || aMapLocation.getAccuracy() == Float.MAX_VALUE) {
                aMapLocation.setAccuracy(0.0f);
            }
            if (aMapLocation.getSpeed() < 0.0f || aMapLocation.getSpeed() == Float.MAX_VALUE) {
                aMapLocation.setSpeed(0.0f);
            }
            return this.f5233d.m51639a(aMapLocation);
        }
        return aMapLocation;
    }

    /* renamed from: z */
    private void m53975z() {
        if (this.f5241l == null) {
            return;
        }
        try {
            this.f5244o = true;
            Looper myLooper = Looper.myLooper();
            if (myLooper == null) {
                myLooper = this.f5238i.getMainLooper();
            }
            this.f5230a = C2432j.m51186b();
            if (m53983r(this.f5241l)) {
                if (this.f5246q == null) {
                    this.f5246q = new C1937a(this);
                }
                this.f5241l.requestLocationUpdates("network", this.f5242m.getInterval(), this.f5242m.getDeviceModeDistanceFilter(), this.f5246q, myLooper);
            }
            if (m53988m(this.f5241l)) {
                if (C2432j.m51211a() - f5224s >= 259200000) {
                    if (C2432j.m51174c(this.f5238i, "WYW5kcm9pZC5wZXJtaXNzaW9uLkFDQ0VTU19MT0NBVElPTl9FWFRSQV9DT01NQU5EUw==")) {
                        this.f5241l.sendExtraCommand(GeocodeSearch.GPS, "force_xtra_injection", null);
                        f5224s = C2432j.m51211a();
                        SharedPreferences.Editor m51222a = C2431i.m51222a(this.f5238i, "pref");
                        C2431i.m51214a(m51222a, "lagt", f5224s);
                        C2431i.m51217a(m51222a);
                        DebugUtils.m51285a();
                    } else {
                        C2428b.m51299a(new Exception("n_alec"), "OPENSDK_CL", "rlu_n_alec");
                    }
                }
                if (this.f5246q == null) {
                    this.f5246q = new C1937a(this);
                }
                this.f5241l.requestLocationUpdates(GeocodeSearch.GPS, this.f5242m.getInterval(), this.f5242m.getDeviceModeDistanceFilter(), this.f5246q, myLooper);
                DebugUtils.m51285a();
            }
            if (f5226u || f5228w) {
                m53997d(100, "系统返回定位结果超时#2002", this.f5242m.getHttpTimeOut());
            }
            if (f5226u || f5228w) {
                return;
            }
            DebugUtils.m51285a();
            m53997d(100, "系统定位当前不可用#2003", 0L);
        } catch (SecurityException e) {
            DebugUtils.m51285a();
            this.f5244o = false;
            ReportUtil.m51233a((String) null, 2121);
            m53997d(101, e.getMessage() + "#2004", 0L);
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | requestLocationUpdates error: ").append(th.getMessage());
            DebugUtils.m51285a();
            C2428b.m51299a(th, "CoarseLocation", "requestLocationUpdates part2");
        }
    }

    /* renamed from: b */
    public final void m53999b() {
        DebugUtils.m51285a();
        LocationManager locationManager = this.f5241l;
        if (locationManager == null) {
            return;
        }
        try {
            LocationListener locationListener = this.f5246q;
            if (locationListener != null) {
                locationManager.removeUpdates(locationListener);
                ((C1937a) this.f5246q).m53974a();
                this.f5246q = null;
                DebugUtils.m51285a();
            }
        } catch (Throwable th) {
            new StringBuilder("CoarseLocation | removeUpdates error ").append(th.getMessage());
            DebugUtils.m51285a();
        }
        try {
            Handler handler = this.f5237h;
            if (handler != null) {
                handler.removeMessages(100);
            }
        } catch (Throwable unused) {
        }
        this.f5236g = 0;
        this.f5230a = 0L;
        this.f5239j = 0L;
        this.f5232c = 0;
        this.f5240k = 0;
        this.f5233d.m51640a();
    }

    /* renamed from: f */
    public final void m53995f(Bundle bundle) {
        if (bundle != null) {
            try {
                bundle.setClassLoader(AMapLocation.class.getClassLoader());
                this.f5234e = bundle.getInt("I_MAX_GEO_DIS");
                this.f5235f = bundle.getInt("I_MIN_GEO_DIS");
                AMapLocation aMapLocation = (AMapLocation) bundle.getParcelable("loc");
                if (TextUtils.isEmpty(aMapLocation.getAdCode())) {
                    return;
                }
                synchronized (this.f5243n) {
                    f5229x = aMapLocation;
                }
            } catch (Throwable th) {
                C2428b.m51299a(th, "CoarseLocation", "setLastGeoLocation");
            }
        }
    }

    /* renamed from: l */
    public final void m53989l(AMapLocationClientOption aMapLocationClientOption) {
        this.f5242m = aMapLocationClientOption;
        if (aMapLocationClientOption == null) {
            this.f5242m = new AMapLocationClientOption();
        }
        new StringBuilder("option: ").append(this.f5242m.toString());
        DebugUtils.m51285a();
        if (!this.f5242m.isOnceLocation()) {
            m53978w();
        } else if (!m53981t()) {
            m53980u();
        } else {
            try {
                f5224s = C2431i.m51220a(this.f5238i, "pref", "lagt", f5224s);
            } catch (Throwable unused) {
            }
            m53975z();
        }
    }

    @SuppressLint({"NewApi"})
    /* renamed from: n */
    public final int m53987n() {
        LocationManager locationManager = this.f5241l;
        if (locationManager != null && m53988m(locationManager)) {
            if (Build.VERSION.SDK_INT < 19) {
                if (!this.f5241l.isProviderEnabled(GeocodeSearch.GPS)) {
                    return 2;
                }
            } else {
                int i = Settings.Secure.getInt(this.f5238i.getContentResolver(), "location_mode", 0);
                if (i == 0) {
                    return 2;
                }
                if (i == 2) {
                    return 3;
                }
            }
            return !this.f5244o ? 4 : 0;
        }
        return 1;
    }

    /* renamed from: q */
    public final void m53984q(AMapLocationClientOption aMapLocationClientOption) {
        if (aMapLocationClientOption == null) {
            aMapLocationClientOption = new AMapLocationClientOption();
        }
        this.f5242m = aMapLocationClientOption;
        new StringBuilder("option: ").append(this.f5242m.toString());
        DebugUtils.m51285a();
        this.f5237h.removeMessages(100);
        if (this.f5245p != this.f5242m.getGeoLanguage()) {
            synchronized (this.f5243n) {
                f5229x = null;
            }
        }
        this.f5245p = this.f5242m.getGeoLanguage();
    }
}
