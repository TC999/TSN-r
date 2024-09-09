package cn.jiguang.t;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;

@SuppressLint({"MissingPermission"})
/* loaded from: E:\TSN-r\205dec\6329136.dex */
class c {

    /* renamed from: e  reason: collision with root package name */
    private static final Object f3788e = new Object();

    /* renamed from: i  reason: collision with root package name */
    private static c f3789i;

    /* renamed from: a  reason: collision with root package name */
    protected Handler f3790a;

    /* renamed from: b  reason: collision with root package name */
    private Context f3791b;

    /* renamed from: c  reason: collision with root package name */
    private LocationManager f3792c;

    /* renamed from: d  reason: collision with root package name */
    private cn.jiguang.u.b f3793d;

    /* renamed from: f  reason: collision with root package name */
    private boolean f3794f;

    /* renamed from: g  reason: collision with root package name */
    private String f3795g;

    /* renamed from: h  reason: collision with root package name */
    private long f3796h = 0;

    /* renamed from: j  reason: collision with root package name */
    private LocationListener f3797j = new LocationListener() { // from class: cn.jiguang.t.c.1
        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            try {
                cn.jiguang.w.a.b("JLocationGps", "onLocationChanged:" + location + ",provider:" + c.this.f3795g);
                c.this.a(location);
                c.this.h();
            } catch (Throwable th) {
                cn.jiguang.w.a.f("JLocationGps", "onLocationChanged failed:" + th.getMessage());
            }
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            cn.jiguang.w.a.b("JLocationGps", "onProviderDisabled:" + str);
            c.this.h();
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            cn.jiguang.w.a.b("JLocationGps", "onProviderEnabled:" + str);
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i4, Bundle bundle) {
            cn.jiguang.w.a.b("JLocationGps", "onStatusChanged status:" + i4);
            if (i4 == 0) {
                c.this.h();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: E:\TSN-r\205dec\6329136.dex */
    public class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            String str;
            int i4 = 1001;
            switch (message.what) {
                case 1001:
                    try {
                        if (c.this.f3795g == null || !c.this.f3795g.equals("network")) {
                            cn.jiguang.w.a.f("JLocationGps", "get " + c.this.f3795g + " time out ");
                            c.this.h();
                        } else {
                            cn.jiguang.w.a.f("JLocationGps", "get gps with network time out ");
                            c.this.f3795g = "gps";
                            c.this.g();
                            c.this.f3792c.requestLocationUpdates(c.this.f3795g, 2000L, 0.0f, c.this.f3797j);
                            cn.jiguang.w.a.b("JLocationGps", "request " + c.this.f3795g + " location");
                            c.this.f3790a.sendEmptyMessageDelayed(1001, 15000L);
                        }
                        return;
                    } catch (Throwable th) {
                        str = "when location time out " + th.getMessage();
                        break;
                    }
                    break;
                case 1002:
                default:
                    return;
                case 1003:
                    try {
                        c.this.f3792c.requestLocationUpdates(c.this.f3795g, 2000L, 0.0f, c.this.f3797j);
                        cn.jiguang.w.a.b("JLocationGps", "request " + c.this.f3795g + " location");
                        c.this.f3790a.sendEmptyMessageDelayed(i4, PolicyConfig.mServerBusyRetryBaseInternal);
                        return;
                    } catch (SecurityException unused) {
                        str = "No suitable permission when get last known location!";
                        break;
                    } catch (Throwable unused2) {
                        str = "The provider is illegal argument!";
                        break;
                    }
                case 1004:
                    cn.jiguang.w.a.b("JLocationGps", "LOAD_GPS_ACTION_REQUEST_ONLY_NETWORK");
                    i4 = 1005;
                    c.this.f3792c.requestLocationUpdates(c.this.f3795g, 2000L, 0.0f, c.this.f3797j);
                    cn.jiguang.w.a.b("JLocationGps", "request " + c.this.f3795g + " location");
                    c.this.f3790a.sendEmptyMessageDelayed(i4, PolicyConfig.mServerBusyRetryBaseInternal);
                    return;
                case 1005:
                    str = "get only network " + c.this.f3795g + " time out ";
                    cn.jiguang.w.a.f("JLocationGps", str);
                    c.this.h();
                    return;
            }
        }
    }

    private c(Context context) {
        this.f3791b = context;
        this.f3792c = (LocationManager) context.getSystemService("location");
    }

    public static c a(Context context) {
        if (f3789i == null) {
            synchronized (f3788e) {
                if (f3789i == null) {
                    f3789i = new c(context);
                }
            }
        }
        return f3789i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        if (location == null) {
            this.f3793d = null;
            return;
        }
        cn.jiguang.w.a.b("JLocationGps", "updateGpsInfo location time:" + location.getTime());
        if (this.f3793d == null) {
            this.f3793d = new cn.jiguang.u.b();
        }
        this.f3793d.f3810a = cn.jiguang.ah.d.a(this.f3791b, location.getTime());
        this.f3793d.f3811b = location.getProvider();
        this.f3793d.f3812c = location.getLatitude();
        this.f3793d.f3813d = location.getLongitude();
        this.f3793d.f3815f = location.getBearing();
        this.f3793d.f3816g = location.getAccuracy();
    }

    private boolean a(Location location, Location location2) {
        if (location == null) {
            return false;
        }
        if (location2 == null) {
            return true;
        }
        long time = location.getTime() - location2.getTime();
        boolean z3 = time > PolicyConfig.THREAD_BLOCK_TIMEOUT;
        boolean z4 = time < -120000;
        boolean z5 = time > 0;
        if (z3) {
            return true;
        }
        if (z4) {
            return false;
        }
        int accuracy = (int) (location.getAccuracy() - location2.getAccuracy());
        boolean z6 = accuracy > 0;
        boolean z7 = accuracy < 0;
        boolean z8 = accuracy > 200;
        boolean a4 = a(location.getProvider(), location2.getProvider());
        if (z7) {
            return true;
        }
        if (!z5 || z6) {
            return z5 && !z8 && a4;
        }
        return true;
    }

    private boolean a(String str, String str2) {
        return str == null ? str2 == null : str.equals(str2);
    }

    private void f() {
        try {
            if (this.f3790a == null) {
                HandlerThread handlerThread = new HandlerThread("jg_lcn_thread");
                handlerThread.start();
                this.f3790a = new a(handlerThread.getLooper());
            }
        } catch (Throwable th) {
            cn.jiguang.w.a.h("JLocationGps", "start load loc-info failed - error:" + th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        String str;
        try {
            LocationListener locationListener = this.f3797j;
            if (locationListener != null) {
                LocationManager locationManager = this.f3792c;
                if (locationManager != null) {
                    locationManager.removeUpdates(locationListener);
                }
                str = "locationManager is null , do nothing!";
            } else {
                str = "Location listener is null , do nothing!";
            }
            cn.jiguang.w.a.f("JLocationGps", str);
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JLocationGps", "remove location listener failed  e:" + th.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void h() {
        cn.jiguang.w.a.b("JLocationGps", "gps will done");
        this.f3794f = true;
        g();
        Handler handler = this.f3790a;
        if (handler != null) {
            if (handler.hasMessages(1004)) {
                this.f3790a.removeMessages(1004);
            }
            if (this.f3790a.hasMessages(1003)) {
                this.f3790a.removeMessages(1003);
            }
            if (this.f3790a.hasMessages(1001)) {
                this.f3790a.removeMessages(1001);
            }
            if (this.f3790a.hasMessages(1005)) {
                this.f3790a.removeMessages(1005);
            }
            this.f3790a.getLooper().quit();
            this.f3790a = null;
        } else {
            cn.jiguang.w.a.g("JLocationGps", "cellLocationManager is null,please check it");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public cn.jiguang.u.b a() {
        return this.f3793d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b() {
        return this.f3794f;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        String str;
        this.f3794f = false;
        this.f3793d = null;
        if (this.f3792c == null) {
            str = "get locationManager failed";
        } else {
            f();
            if (this.f3790a != null) {
                if (this.f3792c.isProviderEnabled("network")) {
                    this.f3795g = "network";
                } else if (!this.f3792c.isProviderEnabled("gps")) {
                    this.f3795g = "network";
                    this.f3790a.sendEmptyMessage(1004);
                    return;
                } else {
                    this.f3795g = "gps";
                }
                this.f3790a.sendEmptyMessage(1003);
                return;
            }
            str = " mAsyncHandler is empty";
        }
        cn.jiguang.w.a.f("JLocationGps", str);
        this.f3794f = true;
    }

    public cn.jiguang.u.b d() {
        try {
        } catch (Throwable th) {
            cn.jiguang.w.a.f("JLocationGps", "loadLastGpsInfo failed: " + th.getMessage());
        }
        if (this.f3796h > 0 && System.currentTimeMillis() - this.f3796h >= PolicyConfig.mServerBusyRetryBaseInternal) {
            cn.jiguang.w.a.b("JLocationGps", "g scan time compare last time than: " + (System.currentTimeMillis() - this.f3796h));
            return null;
        }
        this.f3796h = System.currentTimeMillis();
        Location lastKnownLocation = this.f3792c.getLastKnownLocation("gps");
        Location lastKnownLocation2 = this.f3792c.getLastKnownLocation("network");
        Location lastKnownLocation3 = this.f3792c.getLastKnownLocation("passive");
        if (a(lastKnownLocation, lastKnownLocation2)) {
            if (a(lastKnownLocation, lastKnownLocation3)) {
            }
            lastKnownLocation = lastKnownLocation3;
        } else {
            if (a(lastKnownLocation2, lastKnownLocation3)) {
                lastKnownLocation = lastKnownLocation2;
            }
            lastKnownLocation = lastKnownLocation3;
        }
        if (lastKnownLocation != null && System.currentTimeMillis() - lastKnownLocation.getTime() < PolicyConfig.mServerBusyRetryBaseInternal) {
            a(lastKnownLocation);
            cn.jiguang.w.a.b("JLocationGps", "bestLocation:" + this.f3793d + ",curTime:" + System.currentTimeMillis());
            return this.f3793d;
        }
        return null;
    }

    public boolean e() {
        String str;
        try {
            LocationManager locationManager = this.f3792c;
            if (locationManager != null) {
                if (!locationManager.isProviderEnabled("gps") && !this.f3792c.isProviderEnabled("network")) {
                    if (!this.f3792c.isProviderEnabled("passive")) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        } catch (IllegalArgumentException unused) {
            str = "The provider [gps] is illegal argument!";
            cn.jiguang.w.a.f("JLocationGps", str);
            return false;
        } catch (SecurityException unused2) {
            str = "No suitable permission is present when get GPS_PROVIDER!";
            cn.jiguang.w.a.f("JLocationGps", str);
            return false;
        } catch (Exception unused3) {
            str = "The ILocationManager is null!";
            cn.jiguang.w.a.f("JLocationGps", str);
            return false;
        }
    }
}
