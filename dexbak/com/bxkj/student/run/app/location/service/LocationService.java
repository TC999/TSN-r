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
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.RunBroadcastActionType;
import com.bxkj.student.run.app.RunningActivity;
import com.bxkj.student.run.app.drift.DriftUtils;
import com.bxkj.student.run.app.location.LatLngTimeSpeed;
import com.bxkj.student.run.app.lockscreen.LockScreenActivity;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.bxkj.student.run.app.utils.PathSmoothToolOrigin;
import com.bxkj.student.run.app.utils.SoundManagerUtil;
import com.bxkj.student.run.app.utils.TraceUtils;
import com.github.mikephil.charting.utils.Utils;
import com.orhanobut.logger.C11792j;
import com.snail.antifake.deviceid.ShellAdbUtils;
import com.stub.StubApp;
import com.umeng.analytics.AnalyticsConfig;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class LocationService extends Service {

    /* renamed from: A */
    private NotificationManager f19162A;

    /* renamed from: B */
    private NotificationCompat.Builder f19163B;

    /* renamed from: E */
    private Timer f19166E;

    /* renamed from: e */
    private float f19175e;

    /* renamed from: f */
    private long f19176f;

    /* renamed from: h */
    private long f19178h;

    /* renamed from: l */
    private Notification f19182l;

    /* renamed from: n */
    private PathSmoothToolOrigin f19184n;

    /* renamed from: o */
    private long f19185o;

    /* renamed from: p */
    private TraceUtils f19186p;

    /* renamed from: q */
    private BroadcastReceiver f19187q;

    /* renamed from: r */
    private MediaPlayer f19188r;

    /* renamed from: u */
    private LatLng f19191u;

    /* renamed from: v */
    private LatLng f19192v;

    /* renamed from: w */
    private LatLngTimeSpeed f19193w;

    /* renamed from: a */
    private String f19171a = "LocationService";

    /* renamed from: b */
    private boolean f19172b = false;

    /* renamed from: c */
    private AMapLocationClient f19173c = null;

    /* renamed from: d */
    private AMapLocationClientOption f19174d = null;

    /* renamed from: g */
    private long f19177g = 0;

    /* renamed from: i */
    private boolean f19179i = false;

    /* renamed from: j */
    private ArrayList<LatLngTimeSpeed> f19180j = new ArrayList<>();

    /* renamed from: k */
    private List<LatLng> f19181k = new ArrayList();

    /* renamed from: m */
    private int f19183m = 3;

    /* renamed from: s */
    private BroadcastReceiver f19189s = new C5263b();

    /* renamed from: t */
    private boolean f19190t = false;

    /* renamed from: x */
    private long f19194x = 0;

    /* renamed from: y */
    private AMapLocationListener f19195y = new AMapLocationListener() { // from class: com.bxkj.student.run.app.location.service.a
        @Override // com.amap.api.location.AMapLocationListener
        public final void onLocationChanged(AMapLocation aMapLocation) {
            LocationService.this.m39960z(aMapLocation);
        }
    };

    /* renamed from: z */
    private boolean f19196z = false;

    /* renamed from: C */
    private int f19164C = 100;

    /* renamed from: D */
    private String f19165D = "";

    /* renamed from: F */
    private final int f19167F = 170;

    /* renamed from: G */
    private long f19168G = 0;

    /* renamed from: H */
    private Handler f19169H = new HandlerC5265d();

    /* renamed from: I */
    private int f19170I = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.location.service.LocationService$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5262a extends BroadcastReceiver {
        C5262a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RunBroadcastActionType.UPDATE_STEP)) {
                if (intent.hasExtra("stepCount")) {
                    LocationService.this.f19170I = intent.getIntExtra("stepCount", 0);
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.SET_RUNNING_PAUSE)) {
                if (intent.hasExtra("isPause")) {
                    LocationService locationService = LocationService.this;
                    locationService.f19172b = intent.getBooleanExtra("isPause", locationService.f19172b);
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.STOP_LOCATION)) {
                LocationService.this.m39990H();
            } else if (intent.getAction().equals(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION)) {
                if (intent.hasExtra("message")) {
                    LocationService.this.m39993E(intent.getStringExtra("message"));
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION)) {
                LocationService.this.m39987K();
            }
        }
    }

    /* renamed from: com.bxkj.student.run.app.location.service.LocationService$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5263b extends BroadcastReceiver {
        C5263b() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Intent intent2 = new Intent(context, LockScreenActivity.class);
                intent2.putExtra("distance", FormatUtils.m39633d(LocationService.this.f19175e));
                intent2.putExtra("speed", FormatUtils.m39636a(LocationService.this.f19175e, LocationService.this.f19177g));
                intent2.putExtra("peisu", FormatUtils.m39635b(LocationService.this.f19175e, LocationService.this.f19177g));
                intent2.putExtra(RtspHeaders.Values.TIME, FormatUtils.m39630g(LocationService.this.f19177g));
                intent2.putExtra("lastPauseMessage", LocationService.this.f19165D);
                intent2.putExtra("stepCount", LocationService.this.f19170I);
                intent2.addFlags(276824064);
                LocationService.this.startActivity(intent2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.location.service.LocationService$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5264c extends TimerTask {
        C5264c() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            LocationService.this.f19169H.sendEmptyMessage(170);
        }
    }

    /* renamed from: com.bxkj.student.run.app.location.service.LocationService$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class HandlerC5265d extends Handler {
        HandlerC5265d() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 170 && !LocationService.this.f19172b) {
                LocationService.m39972n(LocationService.this);
                LocationService.this.f19168G = System.currentTimeMillis();
                LocationService locationService = LocationService.this;
                locationService.m39986L(locationService.f19177g);
                LocationService.this.m39987K();
                LocationService.this.m39988J();
                LocationService locationService2 = LocationService.this;
                SoundManagerUtil.m39511h(locationService2, locationService2.f19177g, LocationService.this.f19175e, LocationService.this.f19170I);
                LocationService.this.m39995C();
            }
        }
    }

    /* renamed from: A */
    private void m39997A() {
        this.f19187q = new C5262a();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RunBroadcastActionType.UPDATE_DISTANCE);
        intentFilter.addAction(RunBroadcastActionType.UPDATE_STEP);
        intentFilter.addAction(RunBroadcastActionType.SET_RUNNING_PAUSE);
        intentFilter.addAction(RunBroadcastActionType.STOP_LOCATION);
        intentFilter.addAction(RunBroadcastActionType.RUN_PAUSE_NOTIFICATION);
        intentFilter.addAction(RunBroadcastActionType.RUN_CONTINUE_NOTIFICATION);
        registerReceiver(this.f19187q, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    /* renamed from: B */
    private void m39996B() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.f19189s, intentFilter);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: C */
    public void m39995C() {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.SAVE_LOCAL_DB);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* renamed from: D */
    private void m39994D(LatLng latLng) {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.CURRENT_LATLNG);
        intent.putExtra("latLng", latLng);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: E */
    public void m39993E(String message) {
        this.f19165D = message;
        this.f19185o = System.currentTimeMillis();
        Notification build = this.f19163B.setContentText(message).setWhen(this.f19185o).build();
        this.f19182l = build;
        this.f19162A.notify(this.f19164C, build);
    }

    /* renamed from: F */
    private void m39992F() {
        this.f19173c.stopLocation();
        this.f19173c.startLocation();
        this.f19196z = true;
    }

    /* renamed from: G */
    private void m39991G() {
        if (this.f19176f == 0) {
            this.f19176f = System.currentTimeMillis();
        }
        this.f19168G = System.currentTimeMillis();
        C5264c c5264c = new C5264c();
        Timer timer = new Timer();
        this.f19166E = timer;
        timer.schedule(c5264c, 0L, 1000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: H */
    public void m39990H() {
        try {
            try {
                Handler handler = this.f19169H;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                Timer timer = this.f19166E;
                if (timer != null) {
                    timer.cancel();
                }
                this.f19178h = System.currentTimeMillis();
                stopForeground(true);
                this.f19173c.disableBackgroundLocation(true);
                if (this.f19196z) {
                    this.f19173c.stopLocation();
                    this.f19196z = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            stopSelf();
        }
    }

    /* renamed from: I */
    private void m39989I(String gpsStatus, int gpsStatusImage) {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.UPDATE_GPS_STATUS);
        intent.putExtra("gpsStatus", gpsStatus);
        intent.putExtra("gpsStatusImage", gpsStatusImage);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: J */
    public void m39988J() {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.NOTIFY_RUN_DATA);
        intent.putExtra("distance", FormatUtils.m39633d(this.f19175e));
        intent.putExtra("speed", FormatUtils.m39636a(this.f19175e, this.f19177g));
        intent.putExtra("peisu", FormatUtils.m39635b(this.f19175e, this.f19177g));
        intent.putExtra(RtspHeaders.Values.TIME, FormatUtils.m39630g(this.f19177g));
        intent.putExtra("countTime", this.f19177g);
        intent.putExtra("stepCount", this.f19170I);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: K */
    public void m39987K() {
        this.f19165D = "";
        this.f19185o = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("你已经运动");
        sb.append(FormatUtils.m39633d(this.f19175e));
        sb.append(" KM,");
        sb.append(this.f19170I);
        sb.append("步,用时");
        sb.append(FormatUtils.m39630g(this.f19177g));
        Notification build = this.f19163B.setContentText(sb).setWhen(this.f19185o).build();
        this.f19182l = build;
        this.f19162A.notify(this.f19164C, build);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: L */
    public void m39986L(long countTime) {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.TIME_CHANGE);
        intent.putExtra("countTime", countTime);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* renamed from: n */
    static /* synthetic */ long m39972n(LocationService locationService) {
        long j = locationService.f19177g;
        locationService.f19177g = 1 + j;
        return j;
    }

    /* renamed from: r */
    private void m39968r(LatLng latLng) {
        C11792j.m20470c("第一个定位点获取成功");
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.GET_FIRST_LOCATION_SUCCESS);
        intent.putExtra("latLng", latLng);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
        this.f19190t = true;
    }

    /* renamed from: s */
    private void m39967s(LatLng pathSmoothCurrentLatLng, LatLng pathSmoothLastLatLng, float speed, float distance, String avgSpeed, String pace, boolean isPause, LatLngTimeSpeed latLngTimeSpeed) {
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.ADD_LINE);
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

    /* renamed from: t */
    private void m39966t(String avgSpeed, String pace, long countTime, float distance, long startTime, ArrayList<LatLngTimeSpeed> latLngTimeSpeedList) {
        C11792j.m20470c("发送广播addOldLine");
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.ADD_OLD_LINE);
        intent.putExtra("avgSpeed", avgSpeed);
        intent.putExtra("pace", pace);
        intent.putExtra("countTime", countTime);
        intent.putExtra("distance", distance);
        intent.putExtra(AnalyticsConfig.RTD_START_TIME, startTime);
        intent.putParcelableArrayListExtra("latLngTimeSpeedList", latLngTimeSpeedList);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* renamed from: u */
    private void m39965u(LatLng latLng, long startTime, LatLngTimeSpeed latLngTimeSpeed) {
        C11792j.m20470c("起始点定位成功");
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.ADD_START_POINT);
        intent.putExtra("latLng", latLng);
        intent.putExtra(AnalyticsConfig.RTD_START_TIME, startTime);
        intent.putExtra("latLngTimeSpeed", latLngTimeSpeed);
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* renamed from: v */
    private void m39964v() {
        try {
            AMapLocationClient aMapLocationClient = this.f19173c;
            if (aMapLocationClient != null) {
                aMapLocationClient.onDestroy();
                this.f19173c = null;
                this.f19174d = null;
            }
            Handler handler = this.f19169H;
            if (handler != null) {
                handler.removeCallbacksAndMessages(null);
            }
            Timer timer = this.f19166E;
            if (timer != null) {
                timer.cancel();
            }
            BroadcastReceiver broadcastReceiver = this.f19187q;
            if (broadcastReceiver != null) {
                unregisterReceiver(broadcastReceiver);
            }
            BroadcastReceiver broadcastReceiver2 = this.f19189s;
            if (broadcastReceiver2 != null) {
                unregisterReceiver(broadcastReceiver2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f19196z = false;
        this.f19179i = false;
    }

    /* renamed from: w */
    private AMapLocationClientOption m39963w() {
        AMapLocationClientOption aMapLocationClientOption = new AMapLocationClientOption();
        aMapLocationClientOption.setLocationPurpose(AMapLocationClientOption.AMapLocationPurpose.Sport);
        aMapLocationClientOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        aMapLocationClientOption.setGpsFirst(true);
        aMapLocationClientOption.setHttpTimeOut(30000L);
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

    /* renamed from: x */
    private void m39962x() {
        PathSmoothToolOrigin pathSmoothToolOrigin = new PathSmoothToolOrigin();
        this.f19184n = pathSmoothToolOrigin;
        pathSmoothToolOrigin.m39557p(3);
        try {
            this.f19173c = new AMapLocationClient(StubApp.getOrigApplicationContext(getApplicationContext()));
            AMapLocationClientOption m39963w = m39963w();
            this.f19174d = m39963w;
            this.f19173c.setLocationOption(m39963w);
            this.f19173c.setLocationListener(this.f19195y);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m39961y();
    }

    /* renamed from: y */
    private void m39961y() {
        this.f19163B = new NotificationCompat.Builder(this, "default");
        PendingIntent activity = PendingIntent.getActivity(this, 1, new Intent(this, RunningActivity.class), AMapEngineUtils.HALF_MAX_P20_WIDTH);
        this.f19185o = System.currentTimeMillis();
        this.f19163B.setContentTitle(getResources().getString(2131820604)).setContentText("正在记录本次跑步").setContentIntent(activity).setWhen(this.f19185o).setPriority(1).setAutoCancel(false).setOngoing(true).setOnlyAlertOnce(true).setSmallIcon(2131558617).setDefaults(64);
        this.f19182l = this.f19163B.build();
        this.f19162A = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f19162A.createNotificationChannel(new NotificationChannel("default", "体适能", 2));
        }
        try {
            startForeground(this.f19164C, this.f19182l);
            this.f19173c.enableBackgroundLocation(this.f19164C, this.f19182l);
            C11792j.m20470c("initNotification()");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: z */
    public /* synthetic */ void m39960z(AMapLocation aMapLocation) {
        LatLngTimeSpeed latLngTimeSpeed;
        BigDecimal multiply;
        if (aMapLocation != null) {
            StringBuilder sb = new StringBuilder();
            this.f19194x = System.currentTimeMillis();
            sb.append("回调时间: " + FormatUtils.m39629h(this.f19194x, "yyyy-MM-dd HH:mm:ss") + ShellAdbUtils.f33810d);
            if (aMapLocation.getErrorCode() == 0) {
                sb.append("定位成功\n");
                sb.append("定位类型: " + aMapLocation.getLocationType() + ShellAdbUtils.f33810d);
                sb.append("经    度    : " + aMapLocation.getLongitude() + ShellAdbUtils.f33810d);
                sb.append("纬    度    : " + aMapLocation.getLatitude() + ShellAdbUtils.f33810d);
                sb.append("精    度    : " + aMapLocation.getAccuracy() + "米\n");
                sb.append("提供者    : " + aMapLocation.getProvider() + ShellAdbUtils.f33810d);
                sb.append("速    度    : " + aMapLocation.getSpeed() + "米/秒\n");
                sb.append("角    度    : " + aMapLocation.getBearing() + ShellAdbUtils.f33810d);
                sb.append("星    数    : " + aMapLocation.getSatellites() + ShellAdbUtils.f33810d);
                sb.append("国    家    : " + aMapLocation.getCountry() + ShellAdbUtils.f33810d);
                sb.append("省            : " + aMapLocation.getProvince() + ShellAdbUtils.f33810d);
                sb.append("市            : " + aMapLocation.getCity() + ShellAdbUtils.f33810d);
                sb.append("城市编码 : " + aMapLocation.getCityCode() + ShellAdbUtils.f33810d);
                sb.append("区            : " + aMapLocation.getDistrict() + ShellAdbUtils.f33810d);
                sb.append("区域 码   : " + aMapLocation.getAdCode() + ShellAdbUtils.f33810d);
                sb.append("地    址    : " + aMapLocation.getAddress() + ShellAdbUtils.f33810d);
                sb.append("兴趣点    : " + aMapLocation.getPoiName() + ShellAdbUtils.f33810d);
                sb.append("定位时间: " + FormatUtils.m39629h(aMapLocation.getTime(), "yyyy-MM-dd HH:mm:ss") + ShellAdbUtils.f33810d);
                LatLng latLng = new LatLng(aMapLocation.getLatitude(), aMapLocation.getLongitude());
                this.f19191u = latLng;
                m39994D(latLng);
                if (!this.f19190t) {
                    m39968r(this.f19191u);
                }
                if (aMapLocation.getLocationType() != 6 && aMapLocation.getAccuracy() <= 100) {
                    float speed = aMapLocation.getSpeed();
                    if (!this.f19179i) {
                        if (FormatUtils.m39621p(aMapLocation) != null) {
                            this.f19179i = true;
                            m39991G();
                            SoundManagerUtil.m39512g(this, C4215R.raw.run_start);
                            C11792j.m20470c("起始点定位成功");
                            ArrayList<LatLngTimeSpeed> arrayList = this.f19180j;
                            if (arrayList != null && arrayList.size() > 0) {
                                try {
                                    C11792j.m20470c("oldLatLngTimeSpeedList" + this.f19180j.toString());
                                    ArrayList<LatLngTimeSpeed> arrayList2 = this.f19180j;
                                    LatLngTimeSpeed latLngTimeSpeed2 = arrayList2.get(arrayList2.size() - 1);
                                    C11792j.m20470c("latLngTimeSpeed1" + latLngTimeSpeed2.toString());
                                    latLngTimeSpeed2.setPuase(true);
                                    LatLng latLng2 = this.f19191u;
                                    LatLngTimeSpeed latLngTimeSpeed3 = new LatLngTimeSpeed(latLng2.latitude, latLng2.longitude, System.currentTimeMillis(), speed, true, aMapLocation.getLocationType());
                                    this.f19180j.add(latLngTimeSpeed3);
                                    m39966t(FormatUtils.m39636a(this.f19175e, this.f19177g), FormatUtils.m39635b(this.f19175e, this.f19177g), this.f19177g, this.f19175e, this.f19176f, this.f19180j);
                                    this.f19181k.add(this.f19191u);
                                    this.f19193w = latLngTimeSpeed3;
                                    this.f19192v = this.f19191u;
                                    String str = this.f19171a;
                                    Log.d(str, "恢复之前定位点第一个点->" + this.f19180j.get(0).toString() + "+最后一个点->" + this.f19192v.toString());
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            } else {
                                LatLng latLng3 = this.f19191u;
                                LatLngTimeSpeed latLngTimeSpeed4 = new LatLngTimeSpeed(latLng3.latitude, latLng3.longitude, System.currentTimeMillis(), speed, this.f19172b, aMapLocation.getLocationType());
                                Log.d(this.f19171a, "添加正常起始点");
                                m39965u(this.f19191u, this.f19176f, latLngTimeSpeed4);
                                this.f19181k.add(this.f19191u);
                                this.f19193w = latLngTimeSpeed4;
                                this.f19192v = this.f19191u;
                            }
                        }
                    } else {
                        LatLng latLng4 = this.f19191u;
                        LatLngTimeSpeed latLngTimeSpeed5 = new LatLngTimeSpeed(latLng4.latitude, latLng4.longitude, System.currentTimeMillis(), speed, this.f19172b, aMapLocation.getLocationType());
                        if (aMapLocation.getTrustedLevel() == 1 || aMapLocation.getTrustedLevel() == 2) {
                            if (!this.f19172b) {
                                new BigDecimal((double) Utils.DOUBLE_EPSILON);
                                if (DriftUtils.f19083a.m40073c(this.f19193w, latLngTimeSpeed5)) {
                                    multiply = BigDecimal.valueOf(AMapUtils.calculateLineDistance(this.f19192v, this.f19191u));
                                } else {
                                    multiply = new BigDecimal(this.f19175e).divide(new BigDecimal(this.f19177g), 10, 4).multiply(new BigDecimal(this.f19193w.getTime() - latLngTimeSpeed5.getTime()).abs().divide(new BigDecimal(1000), 10, 4));
                                    C11792j.m20470c("漂移点avg=${avg}appendDistance=${appendDistance}");
                                }
                                this.f19175e = new BigDecimal(this.f19175e).add(multiply).floatValue();
                            }
                            String m39636a = FormatUtils.m39636a(this.f19175e, this.f19177g);
                            String m39635b = FormatUtils.m39635b(this.f19175e, this.f19177g);
                            String str2 = this.f19171a;
                            Log.d(str2, "恢复之后开始划线第一个点->" + this.f19191u.toString() + "上一个点->" + this.f19192v.toString());
                            latLngTimeSpeed = latLngTimeSpeed5;
                            m39967s(this.f19191u, this.f19192v, speed, this.f19175e, m39636a, m39635b, this.f19172b, latLngTimeSpeed5);
                            this.f19181k.add(this.f19191u);
                        } else {
                            latLngTimeSpeed = latLngTimeSpeed5;
                        }
                        this.f19193w = latLngTimeSpeed;
                        this.f19192v = this.f19191u;
                    }
                }
            } else {
                sb.append("定位失败\n");
                sb.append("错误码:" + aMapLocation.getErrorCode() + ShellAdbUtils.f33810d);
                sb.append("错误信息:" + aMapLocation.getErrorInfo() + ShellAdbUtils.f33810d);
                sb.append("错误描述:" + aMapLocation.getLocationDetail() + ShellAdbUtils.f33810d);
            }
            sb.append("***定位质量报告***");
            sb.append(ShellAdbUtils.f33810d);
            sb.append("* WIFI开关：");
            sb.append(aMapLocation.getLocationQualityReport().isWifiAble() ? "开启" : "关闭");
            sb.append(ShellAdbUtils.f33810d);
            m39989I(FormatUtils.m39627j(aMapLocation.getLocationQualityReport().getGPSStatus(), aMapLocation.getGpsAccuracyStatus()), FormatUtils.m39626k(aMapLocation.getGpsAccuracyStatus()));
            sb.append("* GPS状态：");
            sb.append(FormatUtils.m39624m(aMapLocation.getLocationQualityReport().getGPSStatus()));
            sb.append(ShellAdbUtils.f33810d);
            sb.append("* GPS星数：");
            sb.append(aMapLocation.getLocationQualityReport().getGPSSatellites());
            sb.append(ShellAdbUtils.f33810d);
            sb.append("****************");
            sb.append(ShellAdbUtils.f33810d);
            C11792j.m20470c(sb.toString());
            return;
        }
        C11792j.m20470c("定位失败，loc is null");
    }

    @Override // android.app.Service
    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d(this.f19171a, "LocationService-----------------onCreate()");
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        this.f19162A = notificationManager;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        m39962x();
        m39996B();
        m39997A();
        MediaPlayer create = MediaPlayer.create(this, (int) C4215R.raw.slient);
        this.f19188r = create;
        create.setWakeMode(this, 1);
        this.f19188r.setLooping(true);
    }

    @Override // android.app.Service
    public void onDestroy() {
        m39964v();
        MediaPlayer mediaPlayer = this.f19188r;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.f19188r.release();
            this.f19188r = null;
        }
        Log.d(this.f19171a, "LocationService-----------------onDestroy()");
        super.onDestroy();
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        RunDb runDb;
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        this.f19162A = notificationManager;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        if (intent != null && intent.hasExtra("runType")) {
            this.f19183m = intent.getIntExtra("runType", 3);
            if (intent.hasExtra("runExceptionDataDB") && (runDb = (RunDb) intent.getParcelableExtra("runExceptionDataDB")) != null && Long.parseLong(runDb.getCountTime()) != 0) {
                this.f19177g = Long.parseLong(runDb.getCountTime());
                this.f19175e = Float.parseFloat(runDb.getDistance());
                this.f19176f = Long.parseLong(runDb.getStartTime());
                for (LatLngTimeSpeed latLngTimeSpeed : JSON.parseArray(runDb.getLatLngList(), LatLngTimeSpeed.class)) {
                    if (latLngTimeSpeed != null) {
                        this.f19180j.add(latLngTimeSpeed);
                    }
                }
            }
            Log.d(this.f19171a, "LocationService-----------------onStartCommand()");
            String str = this.f19171a;
            Log.d(str, "runType=" + this.f19183m);
            m39992F();
            this.f19186p = new TraceUtils();
        } else {
            stopSelf();
        }
        MediaPlayer mediaPlayer = this.f19188r;
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // android.app.Service
    public void onTaskRemoved(Intent rootIntent) {
        NotificationManager notificationManager = this.f19162A;
        if (notificationManager != null) {
            notificationManager.cancelAll();
        }
        super.onTaskRemoved(rootIntent);
    }
}
