package com.beizi.fusion.update;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.g.ab;
import com.beizi.fusion.g.ad;
import com.beizi.fusion.g.ae;
import com.beizi.fusion.g.au;
import com.beizi.fusion.g.ax;
import com.beizi.fusion.g.az;
import com.beizi.fusion.g.d;
import com.beizi.fusion.g.e;
import com.beizi.fusion.g.h;
import com.beizi.fusion.g.o;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.model.TaskConfig;
import com.beizi.fusion.widget.JSView;
import com.beizi.fusion.widget.LandingView;
import com.stub.StubApp;
import java.lang.ref.WeakReference;
import java.util.Date;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
/* compiled from: HeartScheduler.java */
/* loaded from: E:\TSN-r\205dec\7502512.dex */
public class b {

    /* renamed from: f  reason: collision with root package name */
    private static Context f15119f;

    /* renamed from: g  reason: collision with root package name */
    private static ResponseInfo f15120g;

    /* renamed from: i  reason: collision with root package name */
    private static TaskBean f15121i;

    /* renamed from: k  reason: collision with root package name */
    private static boolean f15122k;

    /* renamed from: l  reason: collision with root package name */
    private static boolean f15123l;

    /* renamed from: m  reason: collision with root package name */
    private static b f15124m;

    /* renamed from: a  reason: collision with root package name */
    private ScheduledExecutorService f15125a;

    /* renamed from: b  reason: collision with root package name */
    private long f15126b;

    /* renamed from: c  reason: collision with root package name */
    private long f15127c;

    /* renamed from: d  reason: collision with root package name */
    private long f15128d;

    /* renamed from: e  reason: collision with root package name */
    private final HandlerC0147b f15129e;

    /* renamed from: h  reason: collision with root package name */
    private ScheduledExecutorService f15130h;

    /* renamed from: j  reason: collision with root package name */
    private ScheduledExecutorService f15131j;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HeartScheduler.java */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public class a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private int f15133b;

        a(int i4) {
            this.f15133b = i4;
        }

        private void a() {
            long j4;
            if (b.f15121i != null) {
                long expired = b.f15121i.getExpired();
                long currentTimeMillis = System.currentTimeMillis();
                List<TaskBean.BackTaskArrayBean> backTaskArray = b.f15121i.getBackTaskArray();
                if (backTaskArray != null && backTaskArray.size() > 0) {
                    com.beizi.fusion.b.c.a(b.f15119f).b(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "500.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), "", String.valueOf(backTaskArray.size())));
                    int i4 = 0;
                    while (i4 < backTaskArray.size()) {
                        if (System.currentTimeMillis() - currentTimeMillis > expired) {
                            j4 = expired;
                            com.beizi.fusion.b.c.a(b.f15119f).b(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "530.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), "", String.valueOf(backTaskArray.size() - i4)));
                        } else {
                            j4 = expired;
                            final TaskBean.BackTaskArrayBean backTaskArrayBean = backTaskArray.get(i4);
                            final int type = backTaskArrayBean.getType();
                            b.this.f15129e.post(new Runnable() { // from class: com.beizi.fusion.update.b.a.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int i5 = type;
                                    if (i5 == 1) {
                                        h.b().e().execute(new ax(b.f15119f, backTaskArrayBean));
                                    } else if (i5 == 2) {
                                        o.a(b.f15119f).a(backTaskArrayBean);
                                    } else if (i5 == 3) {
                                        az.a(b.f15119f);
                                        new LandingView(b.f15119f, backTaskArrayBean).load();
                                    } else if (i5 == 4) {
                                        az.a(b.f15119f);
                                        new JSView(b.f15119f, backTaskArrayBean).load();
                                    } else if (i5 != 8) {
                                    } else {
                                        h.b().f().execute(new e(b.f15119f, backTaskArrayBean));
                                    }
                                }
                            });
                            try {
                                Thread.sleep(backTaskArrayBean.getSleepTime());
                            } catch (InterruptedException e4) {
                                e4.printStackTrace();
                            }
                        }
                        i4++;
                        expired = j4;
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            TaskConfig taskConfig;
            int i4 = this.f15133b;
            if (i4 == 2) {
                if (!b.this.e().booleanValue()) {
                    com.beizi.fusion.b.c.a(b.f15119f).a(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "310.210", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    return;
                }
                Log.d("BeiZis", "config is expire:" + Thread.currentThread().getName());
                Message message = new Message();
                message.what = 1;
                message.arg1 = 1;
                b.this.f15129e.sendMessage(message);
                com.beizi.fusion.b.c.a(b.f15119f).a(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "310.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            } else if (i4 == 3) {
                com.beizi.fusion.b.c.a(b.f15119f).a();
            } else if (i4 != 4) {
                if (i4 != 5) {
                    return;
                }
                Log.d("BeiZis", "config is expire:" + Thread.currentThread().getName());
                Message message2 = new Message();
                message2.what = 1;
                message2.arg1 = 5;
                b.this.f15129e.sendMessage(message2);
                com.beizi.fusion.b.c.a(b.f15119f).a(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "310.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            } else {
                Log.d("BeiZis", "taskConfig:" + Thread.currentThread().getName());
                if (b.f15120g.getTaskConfig() == null || (taskConfig = b.f15120g.getTaskConfig()) == null || taskConfig.getUrl() == null) {
                    return;
                }
                String a4 = ab.a(b.f15119f, taskConfig.getUrl(), com.beizi.fusion.d.b.a().b(), Boolean.TRUE);
                if (TextUtils.isEmpty(a4) || a4.length() <= 0) {
                    return;
                }
                try {
                    String optString = new JSONObject(a4).optString("data");
                    if (TextUtils.isEmpty(optString) || optString.equals("null")) {
                        return;
                    }
                    String b4 = d.b(ad.a(), optString);
                    if (TextUtils.isEmpty(b4)) {
                        return;
                    }
                    TaskBean unused = b.f15121i = TaskBean.objectFromData(b4);
                    if (b.f15121i != null) {
                        a();
                    }
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\7241516.dex
 */
    /* compiled from: HeartScheduler.java */
    /* renamed from: com.beizi.fusion.update.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7502512.dex */
    public static class HandlerC0147b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<b> f15137a;

        HandlerC0147b(b bVar) {
            super(Looper.getMainLooper());
            this.f15137a = new WeakReference<>(bVar);
        }

        @Override // android.os.Handler
        @SuppressLint({"NewApi"})
        public void handleMessage(Message message) {
            if (b.f15123l) {
                return;
            }
            boolean unused = b.f15123l = true;
            try {
                b bVar = this.f15137a.get();
                if (bVar == null) {
                    boolean unused2 = b.f15123l = false;
                    return;
                }
                c cVar = new c(b.f15119f, bVar);
                if (b.f15120g.getConfigurator() != null) {
                    cVar.executeOnExecutor(h.b().d(), b.f15120g.getConfigurator().getConfigUrl());
                } else {
                    cVar.executeOnExecutor(h.b().d(), new String[0]);
                }
            } catch (RejectedExecutionException e4) {
                e4.printStackTrace();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    private b(Context context) {
        this.f15126b = 60000L;
        this.f15127c = 60000L;
        this.f15128d = 0L;
        f15119f = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f15129e = new HandlerC0147b(this);
        if (f15120g == null) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(f15119f);
            f15120g = responseInfo;
            if (!responseInfo.isInit()) {
                f15120g.init();
            }
            if (f15120g.getConfigurator() != null) {
                long checkInterval = f15120g.getConfigurator().getCheckInterval();
                if (checkInterval != 0) {
                    this.f15126b = checkInterval;
                }
            }
            if (f15120g.getMessenger() != null) {
                long checkInterval2 = f15120g.getMessenger().getCheckInterval();
                if (checkInterval2 != 0) {
                    this.f15127c = checkInterval2;
                }
            }
            if (f15120g.getTaskConfig() != null) {
                long checkInterval3 = f15120g.getTaskConfig().getCheckInterval();
                if (checkInterval3 != 0) {
                    this.f15128d = checkInterval3;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Boolean e() {
        Manager manager = f15120g.getManager();
        if (manager != null) {
            List<AdSpacesBean> adSpaces = manager.getAdSpaces();
            if (adSpaces == null) {
                return Boolean.TRUE;
            }
            if (adSpaces.size() == 0) {
                return Boolean.TRUE;
            }
            String b4 = com.beizi.fusion.d.b.a().b();
            boolean z3 = false;
            AdSpacesBean adSpacesBean = adSpaces.get(0);
            if (!b4.equals(adSpacesBean.getAppId())) {
                return Boolean.TRUE;
            }
            if (adSpacesBean.getComponent() == null) {
                return Boolean.TRUE;
            }
            if (f15120g.getConfigurator() != null) {
                long longValue = ((Long) au.b(f15119f, "lastUpdateTime", Long.valueOf(new Date(0L).getTime()))).longValue();
                long expireTime = f15120g.getExpireTime();
                long maxValidTime = f15120g.getMaxValidTime();
                if (maxValidTime == 0) {
                    maxValidTime = 2592000000L;
                }
                long currentTimeMillis = System.currentTimeMillis() - longValue;
                return Boolean.valueOf((currentTimeMillis > expireTime || currentTimeMillis > maxValidTime) ? true : true);
            }
            Log.d("BeiZis", "first launch and heartConfig is null return true!");
            return Boolean.TRUE;
        }
        return Boolean.TRUE;
    }

    private void f() {
        if (this.f15125a == null) {
            this.f15125a = Executors.newScheduledThreadPool(2);
        }
        if (this.f15130h == null) {
            this.f15130h = Executors.newScheduledThreadPool(2);
        }
        if (this.f15131j != null || this.f15128d == 0) {
            return;
        }
        this.f15131j = Executors.newScheduledThreadPool(2);
    }

    private void c(int i4) {
        ae a4 = ae.a(f15119f);
        Intent intent = new Intent("com.ad.action.UPDATE_CONFIG_SUCCESS");
        intent.putExtra("updateResult", i4);
        a4.a(intent);
    }

    public void b(int i4) {
        f();
        if (i4 != 0) {
            if (i4 != 5) {
                return;
            }
            Log.d("BeiZis", "heartbeatTime:" + this.f15126b);
            f15122k = true;
            if (!f15123l) {
                Message message = new Message();
                message.what = 1;
                message.arg1 = 5;
                this.f15129e.sendMessage(message);
            }
            com.beizi.fusion.b.c.a(f15119f).a(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "310.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            return;
        }
        Log.d("BeiZis", this.f15126b + ":heartbeatTime=============start===================:logCheckTime:" + this.f15127c);
        ScheduledExecutorService scheduledExecutorService = this.f15125a;
        a aVar = new a(2);
        long j4 = this.f15126b;
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        scheduledExecutorService.scheduleWithFixedDelay(aVar, 0L, j4, timeUnit);
        this.f15130h.scheduleWithFixedDelay(new a(3), 0L, this.f15127c, timeUnit);
        ScheduledExecutorService scheduledExecutorService2 = this.f15131j;
        if (scheduledExecutorService2 != null && this.f15128d != 0) {
            scheduledExecutorService2.scheduleWithFixedDelay(new a(4), 0L, this.f15128d, timeUnit);
            com.beizi.fusion.b.c.a(f15119f).a(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "500.000", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
        com.beizi.fusion.b.c.a(f15119f).a(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "300.000", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    public void a(Object obj) {
        Log.d("BeiZis", "heartbeat logSuccess!");
        if (((com.beizi.fusion.update.a) obj) != null) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(f15119f);
            f15120g = responseInfo;
            responseInfo.init();
            if (f15122k) {
                c(1);
                f15122k = false;
            }
            com.beizi.fusion.b.c.a(f15119f).a(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "320.200", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
        f15123l = false;
    }

    public void a(int i4) {
        Log.d("BeiZis", "heartbeat fail:" + i4);
        if (f15122k) {
            c(0);
            f15122k = false;
        }
        com.beizi.fusion.b.c.a(f15119f).a(new com.beizi.fusion.b.b(com.beizi.fusion.d.b.f14592b, "", "320.500", "", com.beizi.fusion.d.b.a().b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        f15123l = false;
    }

    public static synchronized b a(Context context) {
        b bVar;
        synchronized (b.class) {
            if (f15124m == null) {
                f15124m = new b(context);
            }
            bVar = f15124m;
        }
        return bVar;
    }
}
