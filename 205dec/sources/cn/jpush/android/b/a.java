package cn.jpush.android.b;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import cn.jpush.android.ad.m;
import cn.jpush.android.helper.Logger;
import cn.jpush.android.n.e;
import com.bytedance.pangle.sdk.component.log.impl.cache.db.TTPathConst;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a extends c {

    /* renamed from: b  reason: collision with root package name */
    private long f4062b;

    /* renamed from: c  reason: collision with root package name */
    private LocationManager f4063c;

    /* renamed from: d  reason: collision with root package name */
    private Handler f4064d;

    /* renamed from: e  reason: collision with root package name */
    private long f4065e;

    /* renamed from: f  reason: collision with root package name */
    private long f4066f;

    /* renamed from: g  reason: collision with root package name */
    private String f4067g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f4068h;
    @SuppressLint({"MissingPermission"})

    /* renamed from: i  reason: collision with root package name */
    private LocationListener f4069i;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicBoolean f4070j;

    public a(Context context) {
        super(context);
        this.f4065e = 900000L;
        this.f4066f = PolicyConfig.mServerBusyRetryBaseInternal;
        this.f4068h = false;
        this.f4069i = new LocationListener() { // from class: cn.jpush.android.b.a.1
            @Override // android.location.LocationListener
            public void onLocationChanged(Location location) {
                a.this.f4063c.removeUpdates(this);
                a.this.f4070j.set(false);
                a.this.a(location);
            }

            @Override // android.location.LocationListener
            public void onProviderDisabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onProviderEnabled(String str) {
            }

            @Override // android.location.LocationListener
            public void onStatusChanged(String str, int i4, Bundle bundle) {
            }
        };
        this.f4070j = new AtomicBoolean();
        this.f4063c = (LocationManager) context.getSystemService("location");
        this.f4065e = cn.jpush.android.cache.a.c(context, 900000L);
        this.f4062b = cn.jpush.android.cache.a.c(context, -1L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Location location) {
        LinkedHashMap<String, b> linkedHashMap;
        Logger.dd("CustomGeofenAction", "current location:" + location);
        Handler handler = this.f4064d;
        if (handler != null && handler.hasMessages(1001)) {
            this.f4064d.removeMessages(1001);
        }
        if (location != null && e.a().c() > 0) {
            double longitude = location.getLongitude();
            double latitude = location.getLatitude();
            LinkedHashMap<String, b> b4 = e.a().b();
            Iterator<Map.Entry<String, b>> it = b4.entrySet().iterator();
            boolean z3 = false;
            while (it.hasNext()) {
                b value = it.next().getValue();
                if (value.f4078e * 1000 <= System.currentTimeMillis()) {
                    Logger.dd("CustomGeofenAction", "Out of date geofence " + value.f4074a);
                    it.remove();
                    e.a().a(value);
                } else {
                    LinkedHashMap<String, b> linkedHashMap2 = b4;
                    double a4 = m.a(longitude, latitude, value.f4079f, value.f4080g);
                    Logger.dd("CustomGeofenAction", value.f4074a + " distance to center:" + a4);
                    long j4 = value.f4075b;
                    String str = a4 <= ((double) j4) ? "in" : "out";
                    double d4 = j4;
                    Double.isNaN(d4);
                    if (Math.abs(a4 - d4) < 1000.0d) {
                        z3 = true;
                    }
                    Logger.d("CustomGeofenAction", "lastStatus:" + value.f4081h + ",currentStatus:" + str);
                    Logger.d("CustomGeofenAction", "geofence status :" + value.f4081h + ",currentStatus:" + str + ",geoStatus:" + str);
                    if ((value.f4076c.equals("inside") || !str.equals(value.f4081h)) && !(value.f4076c.equals("inside") && str == "out")) {
                        if ((value.f4076c.equals("inside") || (value.f4081h != null && str.equals(value.f4076c))) && d(value)) {
                            c(value);
                            a(value, location);
                            cn.jpush.android.n.a.a(this.f4094a, value.a().toString(), latitude, longitude);
                            if (!value.f4077d) {
                                Logger.dd("CustomGeofenAction", "No repeat geofence " + value.f4074a);
                                linkedHashMap = linkedHashMap2;
                                linkedHashMap.remove(value.f4074a);
                                e.a().a(value);
                                value.f4081h = str;
                                e.a().a(value.f4074a, value.a(), false);
                            }
                        }
                        linkedHashMap = linkedHashMap2;
                        value.f4081h = str;
                        e.a().a(value.f4074a, value.a(), false);
                    } else {
                        linkedHashMap = linkedHashMap2;
                    }
                    b4 = linkedHashMap;
                }
            }
            if (this.f4062b == -1) {
                long j5 = z3 ? 180000 : 900000;
                if (this.f4065e != j5) {
                    this.f4065e = j5;
                    Logger.dd("CustomGeofenAction", "need update scan peroid to:" + this.f4065e);
                    b(j5);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j4) {
        Logger.dd("CustomGeofenAction", "Scan geofence after " + j4 + "ms");
        Handler handler = this.f4064d;
        if (handler == null) {
            return;
        }
        if (handler.hasMessages(1000)) {
            this.f4064d.removeMessages(1000);
        }
        this.f4064d.sendEmptyMessageDelayed(1000, j4);
    }

    private void c() {
        try {
            HandlerThread handlerThread = new HandlerThread("jg_cgf_thread") { // from class: cn.jpush.android.b.a.2
                @Override // android.os.HandlerThread, java.lang.Thread, java.lang.Runnable
                public void run() {
                    try {
                        super.run();
                    } catch (RuntimeException e4) {
                        Logger.e("CustomGeofenAction", "handler thread run e:" + e4 + "  t=" + Thread.currentThread().getName() + "_" + Thread.currentThread().getId());
                    }
                }
            };
            handlerThread.start();
            this.f4064d = new Handler(handlerThread.getLooper()) { // from class: cn.jpush.android.b.a.3
                /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
                @Override // android.os.Handler
                @SuppressLint({"MissingPermission"})
                public void handleMessage(Message message) {
                    String str;
                    switch (message.what) {
                        case 1000:
                            Logger.d("CustomGeofenAction", "period task tid " + Thread.currentThread().getId());
                            a aVar = a.this;
                            aVar.b(aVar.f4065e);
                            break;
                        case 1001:
                            a.this.d();
                            try {
                                if (a.this.f4067g == null || !a.this.f4067g.equals("gps")) {
                                    str = "Network provider time out!";
                                } else {
                                    Logger.dd("CustomGeofenAction", "GPS provider time out!");
                                    a.this.f4067g = "network";
                                    if (a.this.f4063c.isProviderEnabled(a.this.f4067g)) {
                                        a.this.f4063c.requestLocationUpdates(a.this.f4067g, 2000L, 0.0f, a.this.f4069i);
                                        a.this.f4064d.sendEmptyMessageDelayed(1001, a.this.f4066f / 2);
                                        return;
                                    }
                                    str = "Network provider is disabled";
                                }
                                Logger.dd("CustomGeofenAction", str);
                            } catch (Throwable th) {
                                Logger.dd("CustomGeofenAction", "request location error#" + th);
                            }
                            a.this.f4070j.set(false);
                            return;
                        case 1002:
                            break;
                        default:
                            return;
                    }
                    a.this.e();
                }
            };
        } catch (Throwable th) {
            Logger.ww("CustomGeofenAction", "init geofence handler failed:" + th);
        }
    }

    private void c(b bVar) {
        long currentTimeMillis = System.currentTimeMillis();
        bVar.f4088o = currentTimeMillis;
        Date date = new Date(currentTimeMillis);
        String format = m.a("yyyy-DDD").format(date);
        if (format.equals(bVar.f4091r)) {
            bVar.f4092s++;
        } else {
            bVar.f4091r = format;
            bVar.f4092s = 1;
        }
        String format2 = m.a("yyyy-ww").format(date);
        if (format2.equals(bVar.f4089p)) {
            bVar.f4090q++;
            return;
        }
        bVar.f4089p = format2;
        bVar.f4090q = 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @SuppressLint({"MissingPermission"})
    public void d() {
        String str;
        try {
            LocationListener locationListener = this.f4069i;
            if (locationListener != null) {
                LocationManager locationManager = this.f4063c;
                if (locationManager != null) {
                    locationManager.removeUpdates(locationListener);
                }
                str = "locationManager is null , do nothing!";
            } else {
                str = "Location listener is null , do nothing!";
            }
            Logger.w("CustomGeofenAction", str);
        } catch (Throwable th) {
            Logger.w("CustomGeofenAction", "remove location listener failed  e:" + th.getMessage());
        }
    }

    private boolean d(b bVar) {
        StringBuilder sb;
        int i4;
        String sb2;
        if (bVar.f4088o <= 0) {
            return true;
        }
        if (bVar.f4077d) {
            if (bVar.f4087n <= 0 && bVar.f4076c.equals("inside")) {
                bVar.f4087n = 3600;
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i5 = bVar.f4087n;
            if (i5 > 0) {
                long j4 = bVar.f4088o;
                if (j4 > 0 && currentTimeMillis < j4 + (i5 * 1000)) {
                    sb = new StringBuilder();
                    sb.append("in ");
                    sb.append(bVar.f4087n);
                    sb.append("s, can't repeat geofence");
                    sb2 = sb.toString();
                }
            }
            if (bVar.f4086m > 0 && !TextUtils.isEmpty(bVar.f4091r)) {
                if (bVar.f4091r.equals(m.a("yyyy-DDD").format(new Date(currentTimeMillis))) && bVar.f4092s >= bVar.f4086m) {
                    sb = new StringBuilder();
                    sb.append("today already repeat enough:");
                    sb.append(bVar.f4092s);
                    sb.append(TTPathConst.sSeparator);
                    i4 = bVar.f4086m;
                    sb.append(i4);
                    sb2 = sb.toString();
                }
            }
            if (bVar.f4085l > 0 && !TextUtils.isEmpty(bVar.f4089p)) {
                if (bVar.f4089p.equals(m.a("yyyy-ww").format(new Date(currentTimeMillis))) && bVar.f4090q >= bVar.f4085l) {
                    sb = new StringBuilder();
                    sb.append("this week already repeat enough:");
                    sb.append(bVar.f4090q);
                    sb.append(TTPathConst.sSeparator);
                    i4 = bVar.f4085l;
                    sb.append(i4);
                    sb2 = sb.toString();
                }
            }
            return true;
        }
        sb2 = "can't repeat geofence";
        Logger.dd("CustomGeofenAction", sb2);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Logger.d("CustomGeofenAction", "try locate...");
        if (!cn.jpush.android.n.c.a(this.f4094a, this.f4063c)) {
            Logger.dd("CustomGeofenAction", "No enabled provider");
            return;
        }
        Logger.d("CustomGeofenAction", "sdk int:" + Build.VERSION.SDK_INT + ",targetSdkVersion:" + this.f4094a.getApplicationInfo().targetSdkVersion);
        if (e.a().c() <= 0) {
            a();
        } else if (this.f4070j.get()) {
            Logger.d("CustomGeofenAction", "isLocating...");
        } else {
            f();
        }
    }

    @SuppressLint({"MissingPermission"})
    private void f() {
        String str;
        try {
            LocationManager locationManager = this.f4063c;
            if (locationManager == null) {
                Logger.ww("CustomGeofenAction", "locationManager is null");
                return;
            }
            Location a4 = cn.jpush.android.n.c.a(this.f4094a, locationManager, true);
            if (System.currentTimeMillis() - (a4 != null ? a4.getTime() : 0L) < PolicyConfig.mServerBusyRetryBaseInternal) {
                StringBuilder sb = new StringBuilder();
                sb.append("need not restart gpslocation,the time with last:");
                sb.append(System.currentTimeMillis() - (a4 != null ? a4.getTime() : 0L));
                Logger.dd("CustomGeofenAction", sb.toString());
                a(a4);
                return;
            }
            this.f4067g = null;
            if (this.f4063c.isProviderEnabled("gps")) {
                this.f4067g = "gps";
            } else if (this.f4063c.isProviderEnabled("network")) {
                this.f4067g = "network";
            }
            Logger.d("CustomGeofenAction", "provider " + this.f4067g);
            if (TextUtils.isEmpty(this.f4067g)) {
                Logger.dd("CustomGeofenAction", "not gps nor network provider,stop scan geofence");
                return;
            }
            this.f4070j.set(true);
            this.f4063c.requestLocationUpdates(this.f4067g, 2000L, 0.0f, this.f4069i);
            this.f4064d.sendEmptyMessageDelayed(1001, this.f4066f);
        } catch (SecurityException unused) {
            str = "No suitable permission when get last known location!";
            Logger.ww("CustomGeofenAction", str);
        } catch (Throwable th) {
            str = "The provider is illegal argument!" + th;
            Logger.ww("CustomGeofenAction", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // cn.jpush.android.b.c
    public synchronized void a() {
        Logger.dd("CustomGeofenAction", "geofence size:" + e.a().c());
        Logger.dd("CustomGeofenAction", "stop listen geofence");
        if (this.f4068h) {
            Handler handler = this.f4064d;
            if (handler != null) {
                handler.removeMessages(1000);
            }
            this.f4068h = false;
        }
    }

    @Override // cn.jpush.android.b.c
    public void a(long j4) {
        Logger.dd("CustomGeofenAction", "Set geofence interval " + j4);
        this.f4065e = j4;
        this.f4062b = j4;
        cn.jpush.android.cache.a.b(this.f4094a, j4);
    }

    @Override // cn.jpush.android.b.c
    protected void a(b bVar) {
        Handler handler;
        Logger.dd("CustomGeofenAction", "Geofence create success, id=" + bVar.f4074a);
        if (!this.f4068h || (handler = this.f4064d) == null) {
            return;
        }
        handler.sendEmptyMessage(1002);
    }

    @Override // cn.jpush.android.b.c
    protected void a(b bVar, b bVar2) {
        Handler handler;
        if (bVar != null) {
            Logger.dd("CustomGeofenAction", "Geofence update success, id=" + bVar.f4074a);
        }
        if (!this.f4068h || (handler = this.f4064d) == null) {
            return;
        }
        handler.sendEmptyMessage(1002);
    }

    @Override // cn.jpush.android.b.c
    public synchronized void b() {
        Logger.dd("CustomGeofenAction", "start listen geofence");
        if (!cn.jpush.android.cache.a.n(this.f4094a)) {
            Logger.ww("CustomGeofenAction", "lbs is disable!");
        } else if (this.f4068h) {
            Logger.ii("CustomGeofenAction", "geofence is running!");
        } else if (e.a().c() == 0) {
            Logger.dd("CustomGeofenAction", "No geofence,not need listen");
        } else {
            if (this.f4064d == null) {
                c();
            }
            b(0L);
            this.f4068h = true;
        }
    }

    @Override // cn.jpush.android.b.c
    protected void b(b bVar) {
        Logger.dd("CustomGeofenAction", "Geofence delete success, id=" + bVar.f4074a);
    }
}
