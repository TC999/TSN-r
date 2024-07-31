package com.bxkj.student.run.app.step.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.alibaba.fastjson.JSON;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bxkj.student.C4215R;
import com.bxkj.student.run.app.RunBroadcastActionType;
import com.bxkj.student.run.app.RunningActivity;
import com.bxkj.student.run.app.lockscreen.LockScreenActivity;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.step.StepChangeListener;
import com.bxkj.student.run.app.step.StepServiceCallBack;
import com.bxkj.student.run.app.step.accelerometer.StepCount;
import com.bxkj.student.run.app.step.accelerometer.StepValuePassListener;
import com.bxkj.student.run.app.utils.FormatUtils;
import com.bxkj.student.run.app.utils.SoundManagerUtil;
import com.orhanobut.logger.C11792j;
import com.umeng.analytics.pro.UMCommonContent;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: E:\fuckcool\tsn\5141176.dex */
public class StepService extends Service implements SensorEventListener {

    /* renamed from: c */
    private SensorManager f19459c;

    /* renamed from: e */
    private Integer f19461e;

    /* renamed from: f */
    private StepCount f19462f;

    /* renamed from: i */
    private StepChangeListener f19465i;

    /* renamed from: j */
    private RunDb f19466j;

    /* renamed from: k */
    private String f19467k;

    /* renamed from: l */
    private BroadcastReceiver f19468l;

    /* renamed from: n */
    private StepServiceCallBack f19470n;

    /* renamed from: o */
    private long f19471o;

    /* renamed from: p */
    private long f19472p;

    /* renamed from: s */
    private Timer f19475s;

    /* renamed from: u */
    private NotificationManager f19477u;

    /* renamed from: v */
    private NotificationCompat.Builder f19478v;

    /* renamed from: x */
    private long f19480x;

    /* renamed from: y */
    private Notification f19481y;

    /* renamed from: a */
    private final String f19457a = "StepService";

    /* renamed from: b */
    private List<Integer> f19458b = new ArrayList();

    /* renamed from: d */
    private int f19460d = 0;

    /* renamed from: g */
    private BinderC5367e f19463g = new BinderC5367e();

    /* renamed from: h */
    private boolean f19464h = false;

    /* renamed from: m */
    private long f19469m = 0;

    /* renamed from: q */
    private final int f19473q = 170;

    /* renamed from: r */
    private long f19474r = 0;

    /* renamed from: t */
    private Handler f19476t = new HandlerC5365c();

    /* renamed from: w */
    private int f19479w = 100;

    /* renamed from: z */
    private boolean f19482z = false;

    /* renamed from: A */
    private BroadcastReceiver f19456A = new C5366d();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.bxkj.student.run.app.step.service.StepService$a */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class C5363a extends BroadcastReceiver {
        C5363a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals(RunBroadcastActionType.SET_RUNNING_PAUSE)) {
                if (intent.hasExtra("isPause")) {
                    StepService stepService = StepService.this;
                    stepService.f19464h = intent.getBooleanExtra("isPause", stepService.f19464h);
                    Log.d("StepService", "StepService->isPause=" + StepService.this.f19464h);
                    if (StepService.this.f19462f != null) {
                        StepService.this.f19462f.m39747e(StepService.this.f19464h);
                    }
                }
            } else if (intent.getAction().equals(RunBroadcastActionType.STOP_LOCATION)) {
                StepService.this.m39721k();
            }
        }
    }

    /* renamed from: com.bxkj.student.run.app.step.service.StepService$b */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5364b extends TimerTask {
        C5364b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            StepService.this.f19476t.sendEmptyMessage(170);
        }
    }

    /* renamed from: com.bxkj.student.run.app.step.service.StepService$c */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class HandlerC5365c extends Handler {
        HandlerC5365c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 170 && !StepService.this.f19464h) {
                StepService.m39725g(StepService.this);
            }
        }
    }

    /* renamed from: com.bxkj.student.run.app.step.service.StepService$d */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    class C5366d extends BroadcastReceiver {
        C5366d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Intent intent2 = new Intent(context, LockScreenActivity.class);
                intent2.putExtra(RtspHeaders.Values.TIME, StepService.this.f19467k);
                intent2.putExtra("stepCount", StepService.this.m39718n());
                intent2.addFlags(276824064);
                StepService.this.startActivity(intent2);
            }
        }
    }

    /* renamed from: com.bxkj.student.run.app.step.service.StepService$e */
    /* loaded from: E:\fuckcool\tsn\5141176.dex */
    public class BinderC5367e extends Binder {
        public BinderC5367e() {
        }

        /* renamed from: a */
        public StepService m39707a() {
            return StepService.this;
        }
    }

    /* renamed from: g */
    static /* synthetic */ long m39725g(StepService stepService) {
        long j = stepService.f19469m;
        stepService.f19469m = 1 + j;
        return j;
    }

    /* renamed from: i */
    private void m39723i() {
        StepCount stepCount = new StepCount();
        this.f19462f = stepCount;
        stepCount.m39747e(this.f19464h);
        this.f19462f.m39746f(this.f19460d);
        boolean registerListener = this.f19459c.registerListener(this.f19462f.m39750b(), this.f19459c.getDefaultSensor(1), 2);
        this.f19462f.m39749c(new StepValuePassListener() { // from class: com.bxkj.student.run.app.step.service.a
            @Override // com.bxkj.student.run.app.step.accelerometer.StepValuePassListener
            /* renamed from: a */
            public final void mo38207a(int i) {
                StepService.this.m39716p(i);
            }
        });
        if (registerListener) {
            Log.v("StepService", "加速度传感器可以使用");
        } else {
            Log.v("StepService", "加速度传感器无法使用");
        }
    }

    /* renamed from: j */
    private void m39722j() {
        Sensor defaultSensor = this.f19459c.getDefaultSensor(19);
        Sensor defaultSensor2 = this.f19459c.getDefaultSensor(18);
        if (defaultSensor != null) {
            Log.v("StepService", "Sensor.TYPE_STEP_COUNTER");
            this.f19459c.registerListener(this, defaultSensor, 0);
        } else if (defaultSensor2 != null) {
            Log.v("StepService", "Sensor.TYPE_STEP_DETECTOR");
            this.f19459c.registerListener(this, defaultSensor2, 0);
        } else {
            Log.v("StepService", "Count sensor not available!");
            m39723i();
        }
    }

    /* renamed from: o */
    private void m39717o() {
        this.f19478v = new NotificationCompat.Builder(this, "default");
        PendingIntent activity = PendingIntent.getActivity(this, 1, new Intent(this, RunningActivity.class), AMapEngineUtils.HALF_MAX_P20_WIDTH);
        this.f19480x = System.currentTimeMillis();
        this.f19478v.setContentTitle(getResources().getString(2131820604)).setContentText("正在记录本次跑步").setContentIntent(activity).setWhen(this.f19480x).setPriority(1).setAutoCancel(false).setOngoing(true).setOnlyAlertOnce(true).setSmallIcon(2131558617);
        this.f19481y = this.f19478v.build();
        this.f19477u = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f19477u.createNotificationChannel(new NotificationChannel("default", "体适能", 2));
        }
        startForeground(this.f19479w, this.f19481y);
        C11792j.m20470c("initNotification()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: p */
    public /* synthetic */ void m39716p(int i) {
        this.f19460d = i;
        StepChangeListener stepChangeListener = this.f19465i;
        if (stepChangeListener != null) {
            stepChangeListener.m39751a(m39718n());
        }
        Intent intent = new Intent();
        intent.setAction(RunBroadcastActionType.UPDATE_STEP);
        intent.putExtra("stepCount", m39718n());
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    /* renamed from: r */
    private void m39714r() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(RunBroadcastActionType.NOTIFY_RUN_DATA);
        intentFilter.addAction(RunBroadcastActionType.SET_RUNNING_PAUSE);
        intentFilter.addAction(RunBroadcastActionType.STOP_LOCATION);
        C5363a c5363a = new C5363a();
        this.f19468l = c5363a;
        registerReceiver(c5363a, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    /* renamed from: s */
    private void m39713s() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.f19456A, intentFilter);
        this.f19482z = true;
    }

    /* renamed from: v */
    private void m39710v() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannel = new NotificationChannel("default", "default", 4);
            notificationChannel.setGroup("default");
            notificationChannel.setLockscreenVisibility(2);
            notificationChannel.setDescription("");
            notificationChannel.setLightColor(-16711936);
            notificationChannel.setName("");
            notificationChannel.setSound(null, null);
            notificationChannel.enableVibration(false);
            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, notificationChannel.getId());
            builder.setContentTitle(getString(2131820604));
            builder.setContentText("");
            builder.setDefaults(-1);
            builder.setAutoCancel(true);
            builder.setShowWhen(true);
            builder.setSmallIcon(2131558617);
            NotificationManagerCompat.from(this).notify(100, builder.build());
            try {
                startForeground(100, builder.build());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void m39715q() {
        if (this.f19459c != null) {
            this.f19459c = null;
        }
        this.f19459c = (SensorManager) getSystemService(UMCommonContent.f37799ac);
        if (Build.VERSION.SDK_INT >= 19) {
            m39722j();
        } else {
            m39723i();
        }
    }

    /* renamed from: k */
    public void m39721k() {
        try {
            try {
                this.f19472p = System.currentTimeMillis();
                Handler handler = this.f19476t;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                Timer timer = this.f19475s;
                if (timer != null) {
                    timer.cancel();
                }
                stopForeground(true);
                SoundManagerUtil.m39512g(this, C4215R.raw.stop_run);
                BroadcastReceiver broadcastReceiver = this.f19468l;
                if (broadcastReceiver != null) {
                    unregisterReceiver(broadcastReceiver);
                    this.f19468l = null;
                }
                BroadcastReceiver broadcastReceiver2 = this.f19456A;
                if (broadcastReceiver2 != null && this.f19482z) {
                    unregisterReceiver(broadcastReceiver2);
                    this.f19456A = null;
                }
                this.f19459c.unregisterListener(this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            stopSelf();
        }
    }

    /* renamed from: l */
    public long m39720l() {
        return this.f19472p;
    }

    /* renamed from: m */
    public long m39719m() {
        return this.f19471o;
    }

    /* renamed from: n */
    public int m39718n() {
        return this.f19460d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f19463g;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("StepService", "onCreate()");
        m39714r();
    }

    @Override // android.app.Service
    public void onDestroy() {
        StepCount stepCount;
        super.onDestroy();
        Handler handler = this.f19476t;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Timer timer = this.f19475s;
        if (timer != null) {
            timer.cancel();
        }
        SensorManager sensorManager = this.f19459c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        SensorManager sensorManager2 = this.f19459c;
        if (sensorManager2 != null && (stepCount = this.f19462f) != null) {
            sensorManager2.unregisterListener(stepCount.m39750b());
        }
        stopForeground(true);
        BroadcastReceiver broadcastReceiver = this.f19468l;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f19468l = null;
        }
        BroadcastReceiver broadcastReceiver2 = this.f19456A;
        if (broadcastReceiver2 != null && this.f19482z) {
            unregisterReceiver(broadcastReceiver2);
            this.f19456A = null;
        }
        C11792j.m20470c("stepService关闭");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        int i = 0;
        if (event.sensor.getType() == 19) {
            int i2 = (int) event.values[0];
            Integer num = this.f19461e;
            if (num != null) {
                int intValue = i2 - num.intValue();
                if (intValue < 0) {
                    this.f19461e = Integer.valueOf(i2);
                } else {
                    i = intValue;
                }
                if (!this.f19464h) {
                    this.f19460d += i;
                }
            }
            String str = "tempStep=" + i2 + "\npreviousStepCount=" + this.f19461e + "\nCURRENT_STEP=" + this.f19460d;
            this.f19461e = Integer.valueOf(i2);
            StepChangeListener stepChangeListener = this.f19465i;
            if (stepChangeListener != null) {
                stepChangeListener.m39751a(m39718n());
            }
            Intent intent = new Intent();
            intent.setAction(RunBroadcastActionType.UPDATE_STEP);
            intent.putExtra("stepCount", m39718n());
            sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            Log.d("StepService", str);
        } else if (event.sensor.getType() == 18) {
            if (event.values[0] == 1.0d && !this.f19464h) {
                this.f19460d++;
            }
            StepChangeListener stepChangeListener2 = this.f19465i;
            if (stepChangeListener2 != null) {
                stepChangeListener2.m39751a(m39718n());
            }
            Intent intent2 = new Intent();
            intent2.setAction(RunBroadcastActionType.UPDATE_STEP);
            intent2.putExtra("stepCount", m39718n());
            sendBroadcast(intent2, "com.bxkj.student.sports.permissions.MY_BROADCAST");
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        C11792j.m20470c("onStartCommand");
        if (intent != null && intent.hasExtra("runType")) {
            if (intent.hasExtra("isPause")) {
                this.f19464h = intent.getBooleanExtra("isPause", this.f19464h);
                Log.d("StepService", "StepService->isPause=" + this.f19464h);
                StepCount stepCount = this.f19462f;
                if (stepCount != null) {
                    stepCount.m39747e(this.f19464h);
                }
            }
            if (intent.hasExtra("runExceptionDataDB")) {
                RunDb runDb = (RunDb) intent.getParcelableExtra("runExceptionDataDB");
                this.f19466j = runDb;
                if (runDb != null) {
                    this.f19469m = Long.parseLong(runDb.getCountTime());
                    this.f19471o = Long.parseLong(this.f19466j.getStartTime());
                    if (this.f19469m != 0) {
                        this.f19458b = JSON.parseArray(this.f19466j.getStepList(), Integer.class);
                    }
                    int i = 0;
                    for (Integer num : this.f19458b) {
                        i += num.intValue();
                    }
                    this.f19460d = i;
                }
            }
            new Thread(new Runnable() { // from class: com.bxkj.student.run.app.step.service.b
                @Override // java.lang.Runnable
                public final void run() {
                    StepService.this.m39715q();
                }
            }).start();
            m39710v();
        } else {
            stopSelf();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    /* renamed from: t */
    public void m39712t(StepChangeListener stepChangeListener) {
        this.f19465i = stepChangeListener;
    }

    /* renamed from: u */
    public void m39711u(StepServiceCallBack stepServiceCallBack) {
        this.f19470n = stepServiceCallBack;
    }

    /* renamed from: x */
    public void m39708x(long startTime) {
        SoundManagerUtil.m39512g(this, C4215R.raw.run_start);
        m39713s();
        m39717o();
        if (this.f19471o == 0) {
            this.f19471o = startTime;
            C11792j.m20470c("跑步开始时间=" + FormatUtils.m39629h(startTime, null));
        }
        this.f19474r = System.currentTimeMillis();
        C5364b c5364b = new C5364b();
        Timer timer = new Timer();
        this.f19475s = timer;
        timer.schedule(c5364b, 0L, 1000L);
    }
}
