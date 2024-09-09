package com.bxkj.student.run.app.location.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import androidx.annotation.Nullable;
import androidx.core.app.NotificationCompat;
import com.alibaba.fastjson.JSON;
import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.bxkj.student.run.app.RunningActivity;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.lockscreen.LockScreenActivity;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.run.app.utils.p;
import com.bxkj.student.run.app.utils.y;
import com.bxkj.student.run.app.utils.z;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.orhanobut.logger.j;
import com.stub.StubApp;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class LocationService extends Service {
    private NotificationManager A;
    private NotificationCompat.Builder B;
    private Timer E;

    /* renamed from: e  reason: collision with root package name */
    private float f22412e;

    /* renamed from: f  reason: collision with root package name */
    private long f22413f;

    /* renamed from: h  reason: collision with root package name */
    private long f22415h;

    /* renamed from: l  reason: collision with root package name */
    private Notification f22419l;

    /* renamed from: n  reason: collision with root package name */
    private p f22421n;

    /* renamed from: o  reason: collision with root package name */
    private long f22422o;

    /* renamed from: p  reason: collision with root package name */
    private z f22423p;

    /* renamed from: q  reason: collision with root package name */
    private BroadcastReceiver f22424q;

    /* renamed from: r  reason: collision with root package name */
    private MediaPlayer f22425r;

    /* renamed from: u  reason: collision with root package name */
    private LatLng f22428u;

    /* renamed from: v  reason: collision with root package name */
    private LatLng f22429v;

    /* renamed from: w  reason: collision with root package name */
    private LatLngTimeSpeed f22430w;

    /* renamed from: a  reason: collision with root package name */
    private String f22408a = "LocationService";

    /* renamed from: b  reason: collision with root package name */
    private boolean f22409b = false;

    /* renamed from: c  reason: collision with root package name */
    private AMapLocationClient f22410c = null;

    /* renamed from: d  reason: collision with root package name */
    private AMapLocationClientOption f22411d = null;

    /* renamed from: g  reason: collision with root package name */
    private long f22414g = 0;

    /* renamed from: i  reason: collision with root package name */
    private boolean f22416i = false;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList<LatLngTimeSpeed> f22417j = new ArrayList<>();

    /* renamed from: k  reason: collision with root package name */
    private List<LatLng> f22418k = new ArrayList();

    /* renamed from: m  reason: collision with root package name */
    private int f22420m = 3;

    /* renamed from: s  reason: collision with root package name */
    private BroadcastReceiver f22426s = new b();

    /* renamed from: t  reason: collision with root package name */
    private boolean f22427t = false;

    /* renamed from: x  reason: collision with root package name */
    private long f22431x = 0;

    /* renamed from: y  reason: collision with root package name */
    private AMapLocationListener f22432y = new AMapLocationListener() { // from class: com.bxkj.student.run.app.location.service.a
        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            LocationService.this.z(aMapLocation);
        }
    };

    /* renamed from: z  reason: collision with root package name */
    private boolean f22433z = false;
    private int C = 100;
    private String D = "";
    private final int F = 170;
    private long G = 0;
    private Handler H = new d();
    private int I = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("UPDATE_STEP")) {
                if (intent.hasExtra("stepCount")) {
                    LocationService.this.I = intent.getIntExtra("stepCount", 0);
                }
            } else if (intent.getAction().equals("SET_RUNNING_PAUSE")) {
                if (intent.hasExtra("isPause")) {
                    LocationService locationService = LocationService.this;
                    locationService.f22409b = intent.getBooleanExtra("isPause", locationService.f22409b);
                }
            } else if (intent.getAction().equals("STOP_LOCATION")) {
                LocationService.this.H();
            } else if (intent.getAction().equals("RUN_PAUSE_NOTIFICATION")) {
                if (intent.hasExtra("message")) {
                    LocationService.this.E(intent.getStringExtra("message"));
                }
            } else if (intent.getAction().equals("RUN_CONTINUE_NOTIFICATION")) {
                LocationService.this.K();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends BroadcastReceiver {
        b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Intent intent2 = new Intent(context, LockScreenActivity.class);
                intent2.putExtra("distance", i.d(LocationService.this.f22412e));
                intent2.putExtra("speed", i.a(LocationService.this.f22412e, LocationService.this.f22414g));
                intent2.putExtra("peisu", i.b(LocationService.this.f22412e, LocationService.this.f22414g));
                intent2.putExtra("time", i.g(LocationService.this.f22414g));
                intent2.putExtra("lastPauseMessage", LocationService.this.D);
                intent2.putExtra("stepCount", LocationService.this.I);
                intent2.addFlags(276824064);
                LocationService.this.startActivity(intent2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class c extends TimerTask {
        c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LocationService.this.H.sendEmptyMessage(170);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d extends Handler {
        d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 170 && !LocationService.this.f22409b) {
                LocationService.n(LocationService.this);
                LocationService.this.G = System.currentTimeMillis();
                LocationService locationService = LocationService.this;
                locationService.L(locationService.f22414g);
                LocationService.this.K();
                LocationService.this.J();
                LocationService locationService2 = LocationService.this;
                y.h(locationService2, locationService2.f22414g, LocationService.this.f22412e, LocationService.this.I);
                LocationService.this.C();
            }
        }
    }

    private void A() {
        this.f22424q = new a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("UPDATE_DISTANCE");
        intentFilter.addAction("UPDATE_STEP");
        intentFilter.addAction("SET_RUNNING_PAUSE");
        intentFilter.addAction("STOP_LOCATION");
        intentFilter.addAction("RUN_PAUSE_NOTIFICATION");
        intentFilter.addAction("RUN_CONTINUE_NOTIFICATION");
        registerReceiver(this.f22424q, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    private void B() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.f22426s, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void C() {
        Intent intent = new Intent();
        intent.setAction("SAVE_LOCAL_DB");
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void D(LatLng latLng) {
        Intent intent = new Intent();
        intent.setAction("CURRENT_LATLNG");
        intent.putExtra("latLng", latLng);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void E(String message) {
        this.D = message;
        this.f22422o = System.currentTimeMillis();
        Notification build = this.B.setContentText(message).setWhen(this.f22422o).build();
        this.f22419l = build;
        this.A.notify(this.C, build);
    }

    private void F() {
        this.f22410c.stopLocation();
        this.f22410c.startLocation();
        this.f22433z = true;
    }

    private void G() {
        if (this.f22413f == 0) {
            this.f22413f = System.currentTimeMillis();
        }
        this.G = System.currentTimeMillis();
        c cVar = new c();
        Timer timer = new Timer();
        this.E = timer;
        timer.schedule(cVar, 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void H() {
        try {
            try {
                Handler handler = this.H;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                Timer timer = this.E;
                if (timer != null) {
                    timer.cancel();
                }
                this.f22415h = System.currentTimeMillis();
                stopForeground(true);
                this.f22410c.disableBackgroundLocation(true);
                if (this.f22433z) {
                    this.f22410c.stopLocation();
                    this.f22433z = false;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } finally {
            stopSelf();
        }
    }

    private void I(String gpsStatus, int gpsStatusImage) {
        Intent intent = new Intent();
        intent.setAction("UPDATE_GPS_STATUS");
        intent.putExtra("gpsStatus", gpsStatus);
        intent.putExtra("gpsStatusImage", gpsStatusImage);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void J() {
        Intent intent = new Intent();
        intent.setAction("NOTIFY_RUN_DATA");
        intent.putExtra("distance", i.d(this.f22412e));
        intent.putExtra("speed", i.a(this.f22412e, this.f22414g));
        intent.putExtra("peisu", i.b(this.f22412e, this.f22414g));
        intent.putExtra("time", i.g(this.f22414g));
        intent.putExtra("countTime", this.f22414g);
        intent.putExtra("stepCount", this.I);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void K() {
        this.D = "";
        this.f22422o = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("\u4f60\u5df2\u7ecf\u8fd0\u52a8");
        sb.append(i.d(this.f22412e));
        sb.append(" KM,");
        sb.append(this.I);
        sb.append("\u6b65,\u7528\u65f6");
        sb.append(i.g(this.f22414g));
        Notification build = this.B.setContentText(sb).setWhen(this.f22422o).build();
        this.f22419l = build;
        this.A.notify(this.C, build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L(long countTime) {
        Intent intent = new Intent();
        intent.setAction("TIME_CHANGE");
        intent.putExtra("countTime", countTime);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    static /* synthetic */ long n(LocationService locationService) {
        long j4 = locationService.f22414g;
        locationService.f22414g = 1 + j4;
        return j4;
    }

    private void r(LatLng latLng) {
        j.c("\u7b2c\u4e00\u4e2a\u5b9a\u4f4d\u70b9\u83b7\u53d6\u6210\u529f");
        Intent intent = new Intent();
        intent.setAction("GET_FIRST_LOCATION_SUCCESS");
        intent.putExtra("latLng", latLng);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
        this.f22427t = true;
    }

    private void s(LatLng pathSmoothCurrentLatLng, LatLng pathSmoothLastLatLng, float speed, float distance, String avgSpeed, String pace, boolean isPause, LatLngTimeSpeed latLngTimeSpeed) {
        Intent intent = new Intent();
        intent.setAction("ADD_LINE");
        intent.putExtra("lastLatLng", pathSmoothLastLatLng);
        intent.putExtra("currentLatLng", pathSmoothCurrentLatLng);
        intent.putExtra("speed", speed);
        intent.putExtra("distance", distance);
        intent.putExtra("avgSpeed", avgSpeed);
        intent.putExtra("pace", pace);
        intent.putExtra("isPause", isPause);
        intent.putExtra("latLngTimeSpeed", latLngTimeSpeed);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void t(String avgSpeed, String pace, long countTime, float distance, long startTime, ArrayList<LatLngTimeSpeed> latLngTimeSpeedList) {
        j.c("\u53d1\u9001\u5e7f\u64adaddOldLine");
        Intent intent = new Intent();
        intent.setAction("ADD_OLD_LINE");
        intent.putExtra("avgSpeed", avgSpeed);
        intent.putExtra("pace", pace);
        intent.putExtra("countTime", countTime);
        intent.putExtra("distance", distance);
        intent.putExtra("startTime", startTime);
        intent.putParcelableArrayListExtra("latLngTimeSpeedList", latLngTimeSpeedList);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void u(LatLng latLng, long startTime, LatLngTimeSpeed latLngTimeSpeed) {
        j.c("\u8d77\u59cb\u70b9\u5b9a\u4f4d\u6210\u529f");
        Intent intent = new Intent();
        intent.setAction("ADD_START_POINT");
        intent.putExtra("latLng", latLng);
        intent.putExtra("startTime", startTime);
        intent.putExtra("latLngTimeSpeed", latLngTimeSpeed);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void v() {
        try {
            AMapLocationClient aMapLocationClient = this.f22410c;
            if (aMapLocationClient != null) {
                aMapLocationClient.onDestroy();
                this.f22410c = null;
                this.f22411d = null;
            }
            Handler handler = this.H;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Timer timer = this.E;
            if (timer != null) {
                timer.cancel();
            }
            BroadcastReceiver broadcastReceiver = this.f22424q;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
            }
            BroadcastReceiver broadcastReceiver2 = this.f22426s;
            if (broadcastReceiver2 != null) {
                unregisterReceiver(broadcastReceiver2);
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        this.f22433z = false;
        this.f22416i = false;
    }

    private AMapLocationClientOption w() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Sport);
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setGpsFirst(true);
        aMapLocationClientOption.setHttpTimeOut(PolicyConfig.mServerBusyRetryBaseInternal);
        aMapLocationClientOption.setInterval(1000L);
        aMapLocationClientOption.setNeedAddress(true);
        aMapLocationClientOption.setOnceLocation(false);
        aMapLocationClientOption.setOnceLocationLatest(false);
        aMapLocationClientOption.setSensorEnable(true);
        aMapLocationClientOption.setWifiScan(true);
        aMapLocationClientOption.setLocationCacheEnable(true);
        aMapLocationClientOption.setMockEnable(false);
        return aMapLocationClientOption;
    }

    private void x() {
        p pVar = new p();
        this.f22421n = pVar;
        pVar.p(3);
        try {
            this.f22410c = new AMapLocationClient(StubApp.getOrigApplicationContext(getApplicationContext()));
            AMapLocationClientOption w3 = w();
            this.f22411d = w3;
            this.f22410c.setLocationOption(w3);
            this.f22410c.setLocationListener(this.f22432y);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        y();
    }

    private void y() {
        this.B = new NotificationCompat.Builder(this, "default");
        PendingIntent activity = PendingIntent.getActivity(this, 1, new Intent(this, RunningActivity.class), 134217728);
        this.f22422o = System.currentTimeMillis();
        this.B.setContentTitle(getResources().getString(2131820604)).setContentText("\u6b63\u5728\u8bb0\u5f55\u672c\u6b21\u8dd1\u6b65").setContentIntent(activity).setWhen(this.f22422o).setPriority(1).setAutoCancel(false).setOngoing(true).setOnlyAlertOnce(true).setSmallIcon(2131558617).setDefaults(64);
        this.f22419l = this.B.build();
        this.A = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.A.createNotificationChannel(new NotificationChannel("default", "\u4f53\u9002\u80fd", 2));
        }
        try {
            startForeground(this.C, this.f22419l);
            this.f22410c.enableBackgroundLocation(this.C, this.f22419l);
            j.c("initNotification()");
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void z(AMapLocation aMapLocation) {
        LatLngTimeSpeed latLngTimeSpeed;
        BigDecimal multiply;
        if (aMapLocation != null) {
            StringBuilder sb = new StringBuilder();
            this.f22431x = System.currentTimeMillis();
            sb.append("\u56de\u8c03\u65f6\u95f4: " + i.h(this.f22431x, "yyyy-MM-dd HH:mm:ss") + "\n");
            if (aMapLocation.getErrorCode() == 0) {
                sb.append("\u5b9a\u4f4d\u6210\u529f\n");
                sb.append("\u5b9a\u4f4d\u7c7b\u578b: " + aMapLocation.getLocationType() + "\n");
                sb.append("\u7ecf    \u5ea6    : " + aMapLocation.getLongitude() + "\n");
                sb.append("\u7eac    \u5ea6    : " + aMapLocation.getLatitude() + "\n");
                sb.append("\u7cbe    \u5ea6    : " + aMapLocation.getAccuracy() + "\u7c73\n");
                sb.append("\u63d0\u4f9b\u8005    : " + aMapLocation.getProvider() + "\n");
                sb.append("\u901f    \u5ea6    : " + aMapLocation.getSpeed() + "\u7c73/\u79d2\n");
                sb.append("\u89d2    \u5ea6    : " + aMapLocation.getBearing() + "\n");
                sb.append("\u661f    \u6570    : " + aMapLocation.getSatellites() + "\n");
                sb.append("\u56fd    \u5bb6    : " + aMapLocation.getCountry() + "\n");
                sb.append("\u7701            : " + aMapLocation.getProvince() + "\n");
                sb.append("\u5e02            : " + aMapLocation.getCity() + "\n");
                sb.append("\u57ce\u5e02\u7f16\u7801 : " + aMapLocation.getCityCode() + "\n");
                sb.append("\u533a            : " + aMapLocation.getDistrict() + "\n");
                sb.append("\u533a\u57df \u7801   : " + aMapLocation.getAdCode() + "\n");
                sb.append("\u5730    \u5740    : " + aMapLocation.getAddress() + "\n");
                sb.append("\u5174\u8da3\u70b9    : " + aMapLocation.getPoiName() + "\n");
                sb.append("\u5b9a\u4f4d\u65f6\u95f4: " + i.h(aMapLocation.getTime(), "yyyy-MM-dd HH:mm:ss") + "\n");
                LatLng latLng = new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                this.f22428u = latLng;
                D(latLng);
                if (!this.f22427t) {
                    r(this.f22428u);
                }
                if (aMapLocation.getLocationType() != 6 && aMapLocation.getAccuracy() <= 100) {
                    float speed = aMapLocation.getSpeed();
                    if (!this.f22416i) {
                        if (i.p(aMapLocation) != null) {
                            this.f22416i = true;
                            G();
                            y.g(this, 2131755099);
                            j.c("\u8d77\u59cb\u70b9\u5b9a\u4f4d\u6210\u529f");
                            ArrayList<LatLngTimeSpeed> arrayList = this.f22417j;
                            if (arrayList != null && arrayList.size() > 0) {
                                try {
                                    j.c("oldLatLngTimeSpeedList" + this.f22417j.toString());
                                    ArrayList<LatLngTimeSpeed> arrayList2 = this.f22417j;
                                    LatLngTimeSpeed latLngTimeSpeed2 = arrayList2.get(arrayList2.size() - 1);
                                    j.c("latLngTimeSpeed1" + latLngTimeSpeed2.toString());
                                    latLngTimeSpeed2.setPuase(true);
                                    LatLng latLng2 = this.f22428u;
                                    LatLngTimeSpeed latLngTimeSpeed3 = new LatLngTimeSpeed(latLng2.latitude, latLng2.longitude, System.currentTimeMillis(), speed, true, aMapLocation.getLocationType());
                                    this.f22417j.add(latLngTimeSpeed3);
                                    t(i.a(this.f22412e, this.f22414g), i.b(this.f22412e, this.f22414g), this.f22414g, this.f22412e, this.f22413f, this.f22417j);
                                    this.f22418k.add(this.f22428u);
                                    this.f22430w = latLngTimeSpeed3;
                                    this.f22429v = this.f22428u;
                                    String str = this.f22408a;
                                    Log.d(str, "\u6062\u590d\u4e4b\u524d\u5b9a\u4f4d\u70b9\u7b2c\u4e00\u4e2a\u70b9->" + this.f22417j.get(0).toString() + "+\u6700\u540e\u4e00\u4e2a\u70b9->" + this.f22429v.toString());
                                } catch (Exception e4) {
                                    e4.printStackTrace();
                                }
                            } else {
                                LatLng latLng3 = this.f22428u;
                                LatLngTimeSpeed latLngTimeSpeed4 = new LatLngTimeSpeed(latLng3.latitude, latLng3.longitude, System.currentTimeMillis(), speed, this.f22409b, aMapLocation.getLocationType());
                                Log.d(this.f22408a, "\u6dfb\u52a0\u6b63\u5e38\u8d77\u59cb\u70b9");
                                u(this.f22428u, this.f22413f, latLngTimeSpeed4);
                                this.f22418k.add(this.f22428u);
                                this.f22430w = latLngTimeSpeed4;
                                this.f22429v = this.f22428u;
                            }
                        }
                    } else {
                        LatLng latLng4 = this.f22428u;
                        LatLngTimeSpeed latLngTimeSpeed5 = new LatLngTimeSpeed(latLng4.latitude, latLng4.longitude, System.currentTimeMillis(), speed, this.f22409b, aMapLocation.getLocationType());
                        if (aMapLocation.getTrustedLevel() == 1 || aMapLocation.getTrustedLevel() == 2) {
                            if (!this.f22409b) {
                                new BigDecimal(0.0d);
                                if (com.bxkj.student.run.app.drift.a.f22329a.c(this.f22430w, latLngTimeSpeed5)) {
                                    multiply = BigDecimal.valueOf(AMapUtils.calculateLineDistance(this.f22429v, this.f22428u));
                                } else {
                                    multiply = new BigDecimal(this.f22412e).divide(new BigDecimal(this.f22414g), 10, 4).multiply(new BigDecimal(this.f22430w.getTime() - latLngTimeSpeed5.getTime()).abs().divide(new BigDecimal(1000), 10, 4));
                                    j.c("\u6f02\u79fb\u70b9avg=${avg}appendDistance=${appendDistance}");
                                }
                                this.f22412e = new BigDecimal(this.f22412e).add(multiply).floatValue();
                            }
                            String a4 = i.a(this.f22412e, this.f22414g);
                            String b4 = i.b(this.f22412e, this.f22414g);
                            String str2 = this.f22408a;
                            Log.d(str2, "\u6062\u590d\u4e4b\u540e\u5f00\u59cb\u5212\u7ebf\u7b2c\u4e00\u4e2a\u70b9->" + this.f22428u.toString() + "\u4e0a\u4e00\u4e2a\u70b9->" + this.f22429v.toString());
                            latLngTimeSpeed = latLngTimeSpeed5;
                            s(this.f22428u, this.f22429v, speed, this.f22412e, a4, b4, this.f22409b, latLngTimeSpeed5);
                            this.f22418k.add(this.f22428u);
                        } else {
                            latLngTimeSpeed = latLngTimeSpeed5;
                        }
                        this.f22430w = latLngTimeSpeed;
                        this.f22429v = this.f22428u;
                    }
                }
            } else {
                sb.append("\u5b9a\u4f4d\u5931\u8d25\n");
                sb.append("\u9519\u8bef\u7801:" + aMapLocation.getErrorCode() + "\n");
                sb.append("\u9519\u8bef\u4fe1\u606f:" + aMapLocation.getErrorInfo() + "\n");
                sb.append("\u9519\u8bef\u63cf\u8ff0:" + aMapLocation.getLocationDetail() + "\n");
            }
            sb.append("***\u5b9a\u4f4d\u8d28\u91cf\u62a5\u544a***");
            sb.append("\n");
            sb.append("* WIFI\u5f00\u5173\uff1a");
            sb.append(aMapLocation.getLocationQualityReport().isWifiAble() ? "\u5f00\u542f" : "\u5173\u95ed");
            sb.append("\n");
            I(i.j(aMapLocation.getLocationQualityReport().getGPSStatus(), aMapLocation.getGpsAccuracyStatus()), i.k(aMapLocation.getGpsAccuracyStatus()));
            sb.append("* GPS\u72b6\u6001\uff1a");
            sb.append(i.m(aMapLocation.getLocationQualityReport().getGPSStatus()));
            sb.append("\n");
            sb.append("* GPS\u661f\u6570\uff1a");
            sb.append(aMapLocation.getLocationQualityReport().getGPSSatellites());
            sb.append("\n");
            sb.append("****************");
            sb.append("\n");
            j.c(sb.toString());
            return;
        }
        j.c("\u5b9a\u4f4d\u5931\u8d25\uff0cloc is null");
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(this.f22408a, "LocationService-----------------onCreate()");
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        this.A = notificationManager;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        x();
        B();
        A();
        MediaPlayer create = MediaPlayer.create(this, 2131755101);
        this.f22425r = create;
        create.setWakeMode(this, 1);
        this.f22425r.setLooping(true);
    }

    @Override // android.app.Service
    public void onDestroy() {
        v();
        MediaPlayer mediaPlayer = this.f22425r;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f22425r.release();
            this.f22425r = null;
        }
        Log.d(this.f22408a, "LocationService-----------------onDestroy()");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        RunDb runDb;
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        this.A = notificationManager;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        if (intent != null && intent.hasExtra("runType")) {
            this.f22420m = intent.getIntExtra("runType", 3);
            if (intent.hasExtra("runExceptionDataDB") && (runDb = (RunDb) intent.getParcelableExtra("runExceptionDataDB")) != null && Long.parseLong(runDb.getCountTime()) != 0) {
                this.f22414g = Long.parseLong(runDb.getCountTime());
                this.f22412e = Float.parseFloat(runDb.getDistance());
                this.f22413f = Long.parseLong(runDb.getStartTime());
                for (LatLngTimeSpeed latLngTimeSpeed : JSON.parseArray(runDb.getLatLngList(), LatLngTimeSpeed.class)) {
                    if (latLngTimeSpeed != null) {
                        this.f22417j.add(latLngTimeSpeed);
                    }
                }
            }
            Log.d(this.f22408a, "LocationService-----------------onStartCommand()");
            String str = this.f22408a;
            Log.d(str, "runType=" + this.f22420m);
            F();
            this.f22423p = new z();
        } else {
            stopSelf();
        }
        MediaPlayer mediaPlayer = this.f22425r;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        NotificationManager notificationManager = this.A;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        super.onTaskRemoved(rootIntent);
    }
}
