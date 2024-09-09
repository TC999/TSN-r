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
import com.bxkj.student.run.app.RunningActivity;
import com.bxkj.student.run.app.lockscreen.LockScreenActivity;
import com.bxkj.student.run.app.offline.table.RunDb;
import com.bxkj.student.run.app.utils.i;
import com.bxkj.student.run.app.utils.y;
import com.orhanobut.logger.j;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
/* loaded from: E:\TSN-r\205dec\5141176.dex */
public class StepService extends Service implements SensorEventListener {

    /* renamed from: c  reason: collision with root package name */
    private SensorManager f22689c;

    /* renamed from: e  reason: collision with root package name */
    private Integer f22691e;

    /* renamed from: f  reason: collision with root package name */
    private com.bxkj.student.run.app.step.accelerometer.a f22692f;

    /* renamed from: i  reason: collision with root package name */
    private com.bxkj.student.run.app.step.a f22695i;

    /* renamed from: j  reason: collision with root package name */
    private RunDb f22696j;

    /* renamed from: k  reason: collision with root package name */
    private String f22697k;

    /* renamed from: l  reason: collision with root package name */
    private BroadcastReceiver f22698l;

    /* renamed from: n  reason: collision with root package name */
    private com.bxkj.student.run.app.step.d f22700n;

    /* renamed from: o  reason: collision with root package name */
    private long f22701o;

    /* renamed from: p  reason: collision with root package name */
    private long f22702p;

    /* renamed from: s  reason: collision with root package name */
    private Timer f22705s;

    /* renamed from: u  reason: collision with root package name */
    private NotificationManager f22707u;

    /* renamed from: v  reason: collision with root package name */
    private NotificationCompat.Builder f22708v;

    /* renamed from: x  reason: collision with root package name */
    private long f22710x;

    /* renamed from: y  reason: collision with root package name */
    private Notification f22711y;

    /* renamed from: a  reason: collision with root package name */
    private final String f22687a = "StepService";

    /* renamed from: b  reason: collision with root package name */
    private List<Integer> f22688b = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private int f22690d = 0;

    /* renamed from: g  reason: collision with root package name */
    private e f22693g = new e();

    /* renamed from: h  reason: collision with root package name */
    private boolean f22694h = false;

    /* renamed from: m  reason: collision with root package name */
    private long f22699m = 0;

    /* renamed from: q  reason: collision with root package name */
    private final int f22703q = 170;

    /* renamed from: r  reason: collision with root package name */
    private long f22704r = 0;

    /* renamed from: t  reason: collision with root package name */
    private Handler f22706t = new c();

    /* renamed from: w  reason: collision with root package name */
    private int f22709w = 100;

    /* renamed from: z  reason: collision with root package name */
    private boolean f22712z = false;
    private BroadcastReceiver A = new d();

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
            if (intent.getAction().equals("SET_RUNNING_PAUSE")) {
                if (intent.hasExtra("isPause")) {
                    StepService stepService = StepService.this;
                    stepService.f22694h = intent.getBooleanExtra("isPause", stepService.f22694h);
                    Log.d("StepService", "StepService->isPause=" + StepService.this.f22694h);
                    if (StepService.this.f22692f != null) {
                        StepService.this.f22692f.e(StepService.this.f22694h);
                    }
                }
            } else if (intent.getAction().equals("STOP_LOCATION")) {
                StepService.this.k();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class b extends TimerTask {
        b() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            StepService.this.f22706t.sendEmptyMessage(170);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class c extends Handler {
        c() {
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            if (msg.what == 170 && !StepService.this.f22694h) {
                StepService.g(StepService.this);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    class d extends BroadcastReceiver {
        d() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (intent.getAction().equals("android.intent.action.SCREEN_OFF")) {
                Intent intent2 = new Intent(context, LockScreenActivity.class);
                intent2.putExtra("time", StepService.this.f22697k);
                intent2.putExtra("stepCount", StepService.this.n());
                intent2.addFlags(276824064);
                StepService.this.startActivity(intent2);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\4499832.dex
 */
    /* loaded from: E:\TSN-r\205dec\5141176.dex */
    public class e extends Binder {
        public e() {
        }

        public StepService a() {
            return StepService.this;
        }
    }

    static /* synthetic */ long g(StepService stepService) {
        long j4 = stepService.f22699m;
        stepService.f22699m = 1 + j4;
        return j4;
    }

    private void i() {
        com.bxkj.student.run.app.step.accelerometer.a aVar = new com.bxkj.student.run.app.step.accelerometer.a();
        this.f22692f = aVar;
        aVar.e(this.f22694h);
        this.f22692f.f(this.f22690d);
        boolean registerListener = this.f22689c.registerListener(this.f22692f.b(), this.f22689c.getDefaultSensor(1), 2);
        this.f22692f.c(new com.bxkj.student.run.app.step.accelerometer.d() { // from class: com.bxkj.student.run.app.step.service.a
            @Override // com.bxkj.student.run.app.step.accelerometer.d
            public final void a(int i4) {
                StepService.this.p(i4);
            }
        });
        if (registerListener) {
            Log.v("StepService", "\u52a0\u901f\u5ea6\u4f20\u611f\u5668\u53ef\u4ee5\u4f7f\u7528");
        } else {
            Log.v("StepService", "\u52a0\u901f\u5ea6\u4f20\u611f\u5668\u65e0\u6cd5\u4f7f\u7528");
        }
    }

    private void j() {
        Sensor defaultSensor = this.f22689c.getDefaultSensor(19);
        Sensor defaultSensor2 = this.f22689c.getDefaultSensor(18);
        if (defaultSensor != null) {
            Log.v("StepService", "Sensor.TYPE_STEP_COUNTER");
            this.f22689c.registerListener(this, defaultSensor, 0);
        } else if (defaultSensor2 != null) {
            Log.v("StepService", "Sensor.TYPE_STEP_DETECTOR");
            this.f22689c.registerListener(this, defaultSensor2, 0);
        } else {
            Log.v("StepService", "Count sensor not available!");
            i();
        }
    }

    private void o() {
        this.f22708v = new NotificationCompat.Builder(this, "default");
        PendingIntent activity = PendingIntent.getActivity(this, 1, new Intent(this, RunningActivity.class), 134217728);
        this.f22710x = System.currentTimeMillis();
        this.f22708v.setContentTitle(getResources().getString(2131820604)).setContentText("\u6b63\u5728\u8bb0\u5f55\u672c\u6b21\u8dd1\u6b65").setContentIntent(activity).setWhen(this.f22710x).setPriority(1).setAutoCancel(false).setOngoing(true).setOnlyAlertOnce(true).setSmallIcon(2131558617);
        this.f22711y = this.f22708v.build();
        this.f22707u = (NotificationManager) getSystemService("notification");
        if (Build.VERSION.SDK_INT >= 26) {
            this.f22707u.createNotificationChannel(new NotificationChannel("default", "\u4f53\u9002\u80fd", 2));
        }
        startForeground(this.f22709w, this.f22711y);
        j.c("initNotification()");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void p(int i4) {
        this.f22690d = i4;
        com.bxkj.student.run.app.step.a aVar = this.f22695i;
        if (aVar != null) {
            aVar.a(n());
        }
        Intent intent = new Intent();
        intent.setAction("UPDATE_STEP");
        intent.putExtra("stepCount", n());
        sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
    }

    private void r() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("NOTIFY_RUN_DATA");
        intentFilter.addAction("SET_RUNNING_PAUSE");
        intentFilter.addAction("STOP_LOCATION");
        a aVar = new a();
        this.f22698l = aVar;
        registerReceiver(aVar, intentFilter, "com.bxkj.student.sports.permissions.MY_BROADCAST", null);
    }

    private void s() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        registerReceiver(this.A, intentFilter);
        this.f22712z = true;
    }

    private void v() {
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
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: w */
    public void q() {
        if (this.f22689c != null) {
            this.f22689c = null;
        }
        this.f22689c = (SensorManager) getSystemService("sensor");
        if (Build.VERSION.SDK_INT >= 19) {
            j();
        } else {
            i();
        }
    }

    public void k() {
        try {
            try {
                this.f22702p = System.currentTimeMillis();
                Handler handler = this.f22706t;
                if (handler != null) {
                    handler.removeCallbacksAndMessages(null);
                }
                Timer timer = this.f22705s;
                if (timer != null) {
                    timer.cancel();
                }
                stopForeground(true);
                y.g(this, 2131755103);
                BroadcastReceiver broadcastReceiver = this.f22698l;
                if (broadcastReceiver != null) {
                    unregisterReceiver(broadcastReceiver);
                    this.f22698l = null;
                }
                BroadcastReceiver broadcastReceiver2 = this.A;
                if (broadcastReceiver2 != null && this.f22712z) {
                    unregisterReceiver(broadcastReceiver2);
                    this.A = null;
                }
                this.f22689c.unregisterListener(this);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        } finally {
            stopSelf();
        }
    }

    public long l() {
        return this.f22702p;
    }

    public long m() {
        return this.f22701o;
    }

    public int n() {
        return this.f22690d;
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.f22693g;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        Log.d("StepService", "onCreate()");
        r();
    }

    @Override // android.app.Service
    public void onDestroy() {
        com.bxkj.student.run.app.step.accelerometer.a aVar;
        super.onDestroy();
        Handler handler = this.f22706t;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Timer timer = this.f22705s;
        if (timer != null) {
            timer.cancel();
        }
        SensorManager sensorManager = this.f22689c;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        SensorManager sensorManager2 = this.f22689c;
        if (sensorManager2 != null && (aVar = this.f22692f) != null) {
            sensorManager2.unregisterListener(aVar.b());
        }
        stopForeground(true);
        BroadcastReceiver broadcastReceiver = this.f22698l;
        if (broadcastReceiver != null) {
            unregisterReceiver(broadcastReceiver);
            this.f22698l = null;
        }
        BroadcastReceiver broadcastReceiver2 = this.A;
        if (broadcastReceiver2 != null && this.f22712z) {
            unregisterReceiver(broadcastReceiver2);
            this.A = null;
        }
        j.c("stepService\u5173\u95ed");
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent event) {
        int i4 = 0;
        if (event.sensor.getType() == 19) {
            int i5 = (int) event.values[0];
            Integer num = this.f22691e;
            if (num != null) {
                int intValue = i5 - num.intValue();
                if (intValue < 0) {
                    this.f22691e = Integer.valueOf(i5);
                } else {
                    i4 = intValue;
                }
                if (!this.f22694h) {
                    this.f22690d += i4;
                }
            }
            String str = "tempStep=" + i5 + "\npreviousStepCount=" + this.f22691e + "\nCURRENT_STEP=" + this.f22690d;
            this.f22691e = Integer.valueOf(i5);
            com.bxkj.student.run.app.step.a aVar = this.f22695i;
            if (aVar != null) {
                aVar.a(n());
            }
            Intent intent = new Intent();
            intent.setAction("UPDATE_STEP");
            intent.putExtra("stepCount", n());
            sendBroadcast(intent, "com.bxkj.student.sports.permissions.MY_BROADCAST");
            Log.d("StepService", str);
        } else if (event.sensor.getType() == 18) {
            if (event.values[0] == 1.0d && !this.f22694h) {
                this.f22690d++;
            }
            com.bxkj.student.run.app.step.a aVar2 = this.f22695i;
            if (aVar2 != null) {
                aVar2.a(n());
            }
            Intent intent2 = new Intent();
            intent2.setAction("UPDATE_STEP");
            intent2.putExtra("stepCount", n());
            sendBroadcast(intent2, "com.bxkj.student.sports.permissions.MY_BROADCAST");
        }
    }

    @Override // android.app.Service
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        j.c("onStartCommand");
        if (intent != null && intent.hasExtra("runType")) {
            if (intent.hasExtra("isPause")) {
                this.f22694h = intent.getBooleanExtra("isPause", this.f22694h);
                Log.d("StepService", "StepService->isPause=" + this.f22694h);
                com.bxkj.student.run.app.step.accelerometer.a aVar = this.f22692f;
                if (aVar != null) {
                    aVar.e(this.f22694h);
                }
            }
            if (intent.hasExtra("runExceptionDataDB")) {
                RunDb runDb = (RunDb) intent.getParcelableExtra("runExceptionDataDB");
                this.f22696j = runDb;
                if (runDb != null) {
                    this.f22699m = Long.parseLong(runDb.getCountTime());
                    this.f22701o = Long.parseLong(this.f22696j.getStartTime());
                    if (this.f22699m != 0) {
                        this.f22688b = JSON.parseArray(this.f22696j.getStepList(), Integer.class);
                    }
                    int i4 = 0;
                    for (Integer num : this.f22688b) {
                        i4 += num.intValue();
                    }
                    this.f22690d = i4;
                }
            }
            new Thread(new Runnable() { // from class: com.bxkj.student.run.app.step.service.b
                @Override // java.lang.Runnable
                public final void run() {
                    StepService.this.q();
                }
            }).start();
            v();
        } else {
            stopSelf();
        }
        return super.onStartCommand(intent, flags, startId);
    }

    @Override // android.app.Service
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    public void t(com.bxkj.student.run.app.step.a stepChangeListener) {
        this.f22695i = stepChangeListener;
    }

    public void u(com.bxkj.student.run.app.step.d stepServiceCallBack) {
        this.f22700n = stepServiceCallBack;
    }

    public void x(long startTime) {
        y.g(this, 2131755099);
        s();
        o();
        if (this.f22701o == 0) {
            this.f22701o = startTime;
            j.c("\u8dd1\u6b65\u5f00\u59cb\u65f6\u95f4=" + i.h(startTime, null));
        }
        this.f22704r = System.currentTimeMillis();
        b bVar = new b();
        Timer timer = new Timer();
        this.f22705s = timer;
        timer.schedule(bVar, 0L, 1000L);
    }
}
