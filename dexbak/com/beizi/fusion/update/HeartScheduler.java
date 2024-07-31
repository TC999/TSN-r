package com.beizi.fusion.update;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.Configurator;
import com.beizi.fusion.model.Manager;
import com.beizi.fusion.model.Messenger;
import com.beizi.fusion.model.ResponseInfo;
import com.beizi.fusion.model.TaskBean;
import com.beizi.fusion.model.TaskConfig;
import com.beizi.fusion.p064b.EventBean;
import com.beizi.fusion.p064b.EventCar;
import com.beizi.fusion.p066d.AdManager;
import com.beizi.fusion.p072g.AesUtils;
import com.beizi.fusion.p072g.AppLinkRunnable;
import com.beizi.fusion.p072g.C3112ad;
import com.beizi.fusion.p072g.C3116af;
import com.beizi.fusion.p072g.C3137at;
import com.beizi.fusion.p072g.C3145h;
import com.beizi.fusion.p072g.ClipUtil;
import com.beizi.fusion.p072g.HttpUtil;
import com.beizi.fusion.p072g.LocalBroadcastManager;
import com.beizi.fusion.p072g.TaskRunnable;
import com.beizi.fusion.p072g.WebViewMultiInitHelper;
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

/* renamed from: com.beizi.fusion.update.b */
/* loaded from: E:\fuckcool\tsn\7241516.dex */
public class HeartScheduler {

    /* renamed from: f */
    private static Context f11534f;

    /* renamed from: g */
    private static ResponseInfo f11535g;

    /* renamed from: i */
    private static TaskBean f11536i;

    /* renamed from: k */
    private static boolean f11537k;

    /* renamed from: l */
    private static boolean f11538l;

    /* renamed from: m */
    private static HeartScheduler f11539m;

    /* renamed from: a */
    private ScheduledExecutorService f11540a;

    /* renamed from: b */
    private long f11541b = 60000;

    /* renamed from: c */
    private long f11542c = 60000;

    /* renamed from: d */
    private long f11543d = 0;

    /* renamed from: e */
    private final HandlerC3206b f11544e;

    /* renamed from: h */
    private ScheduledExecutorService f11545h;

    /* renamed from: j */
    private ScheduledExecutorService f11546j;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HeartScheduler.java */
    /* renamed from: com.beizi.fusion.update.b$a */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public class RunnableC3204a implements Runnable {

        /* renamed from: b */
        private int f11548b;

        RunnableC3204a(int i) {
            this.f11548b = i;
        }

        /* renamed from: a */
        private void m48088a() {
            long j;
            if (HeartScheduler.f11536i != null) {
                long expired = HeartScheduler.f11536i.getExpired();
                long currentTimeMillis = System.currentTimeMillis();
                List<TaskBean.BackTaskArrayBean> backTaskArray = HeartScheduler.f11536i.getBackTaskArray();
                if (backTaskArray != null && backTaskArray.size() > 0) {
                    EventCar.m48869a(HeartScheduler.f11534f).m48862b(new EventBean(AdManager.f11053b, "", "500.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), "", String.valueOf(backTaskArray.size())));
                    int i = 0;
                    while (i < backTaskArray.size()) {
                        if (System.currentTimeMillis() - currentTimeMillis > expired) {
                            j = expired;
                            EventCar.m48869a(HeartScheduler.f11534f).m48862b(new EventBean(AdManager.f11053b, "", "530.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), "", String.valueOf(backTaskArray.size() - i)));
                        } else {
                            j = expired;
                            final TaskBean.BackTaskArrayBean backTaskArrayBean = backTaskArray.get(i);
                            final int type = backTaskArrayBean.getType();
                            HeartScheduler.this.f11544e.post(new Runnable() { // from class: com.beizi.fusion.update.b.a.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    int i2 = type;
                                    if (i2 == 1) {
                                        C3145h.m48264b().m48261e().execute(new TaskRunnable(HeartScheduler.f11534f, backTaskArrayBean));
                                    } else if (i2 == 2) {
                                        ClipUtil.m48235a(HeartScheduler.f11534f).m48233a(backTaskArrayBean);
                                    } else if (i2 == 3) {
                                        WebViewMultiInitHelper.m48279a(HeartScheduler.f11534f);
                                        new LandingView(HeartScheduler.f11534f, backTaskArrayBean).load();
                                    } else if (i2 == 4) {
                                        WebViewMultiInitHelper.m48279a(HeartScheduler.f11534f);
                                        new JSView(HeartScheduler.f11534f, backTaskArrayBean).load();
                                    } else if (i2 != 8) {
                                    } else {
                                        C3145h.m48264b().m48260f().execute(new AppLinkRunnable(HeartScheduler.f11534f, backTaskArrayBean));
                                    }
                                }
                            });
                            try {
                                Thread.sleep(backTaskArrayBean.getSleepTime());
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        i++;
                        expired = j;
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            TaskConfig taskConfig;
            int i = this.f11548b;
            if (i == 2) {
                if (!HeartScheduler.this.m48091d().booleanValue()) {
                    EventCar.m48869a(HeartScheduler.f11534f).m48868a(new EventBean(AdManager.f11053b, "", "310.210", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
                    return;
                }
                Log.d("BeiZis", "config is expire:" + Thread.currentThread().getName());
                Message message = new Message();
                message.what = 1;
                message.arg1 = 1;
                HeartScheduler.this.f11544e.sendMessage(message);
                EventCar.m48869a(HeartScheduler.f11534f).m48868a(new EventBean(AdManager.f11053b, "", "310.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            } else if (i == 3) {
                EventCar.m48869a(HeartScheduler.f11534f).m48870a();
            } else if (i != 4) {
                if (i != 5) {
                    return;
                }
                Log.d("BeiZis", "config is expire:" + Thread.currentThread().getName());
                Message message2 = new Message();
                message2.what = 1;
                message2.arg1 = 5;
                HeartScheduler.this.f11544e.sendMessage(message2);
                EventCar.m48869a(HeartScheduler.f11534f).m48868a(new EventBean(AdManager.f11053b, "", "310.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            } else {
                Log.d("BeiZis", "taskConfig:" + Thread.currentThread().getName());
                if (HeartScheduler.f11535g.getTaskConfig() == null || (taskConfig = HeartScheduler.f11535g.getTaskConfig()) == null || taskConfig.getUrl() == null) {
                    return;
                }
                String m48511a = HttpUtil.m48511a(HeartScheduler.f11534f, taskConfig.getUrl(), AdManager.m48786a().m48782b(), Boolean.TRUE);
                if (TextUtils.isEmpty(m48511a) || m48511a.length() <= 0) {
                    return;
                }
                try {
                    String optString = new JSONObject(m48511a).optString("data");
                    if (TextUtils.isEmpty(optString) || optString.equals("null")) {
                        return;
                    }
                    String m48269b = AesUtils.m48269b(C3112ad.m48504a(), optString);
                    if (TextUtils.isEmpty(m48269b)) {
                        return;
                    }
                    TaskBean unused = HeartScheduler.f11536i = TaskBean.objectFromData(m48269b);
                    if (HeartScheduler.f11536i != null) {
                        long checkInterval = HeartScheduler.f11536i.getCheckInterval();
                        if (checkInterval != HeartScheduler.this.f11543d && checkInterval != 0) {
                            HeartScheduler.this.f11543d = checkInterval;
                            HeartScheduler.this.m48090d(3);
                            HeartScheduler.this.m48097b(3);
                        }
                        m48088a();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: HeartScheduler.java */
    /* renamed from: com.beizi.fusion.update.b$b */
    /* loaded from: E:\fuckcool\tsn\7241516.dex */
    public static class HandlerC3206b extends Handler {

        /* renamed from: a */
        private final WeakReference<HeartScheduler> f11552a;

        HandlerC3206b(HeartScheduler heartScheduler) {
            super(Looper.getMainLooper());
            this.f11552a = new WeakReference<>(heartScheduler);
        }

        @Override // android.os.Handler
        @SuppressLint({"NewApi"})
        public void handleMessage(Message message) {
            HeartScheduler heartScheduler = this.f11552a.get();
            if (message.arg1 == 5) {
                boolean unused = HeartScheduler.f11537k = true;
            }
            if (message.arg1 == 1) {
                boolean unused2 = HeartScheduler.f11538l = true;
            }
            HeartSender heartSender = message.what == 1 ? new HeartSender(HeartScheduler.f11534f, heartScheduler) : null;
            if (heartSender != null) {
                try {
                    if (HeartScheduler.f11535g.getConfigurator() != null) {
                        heartSender.executeOnExecutor(C3145h.m48264b().m48262d(), HeartScheduler.f11535g.getConfigurator().getConfigUrl());
                    } else {
                        heartSender.executeOnExecutor(C3145h.m48264b().m48262d(), new String[0]);
                    }
                    return;
                } catch (RejectedExecutionException e) {
                    e.printStackTrace();
                    return;
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return;
                }
            }
            Log.d("BeiZis", "Empty logSender, sending aborted!");
        }
    }

    private HeartScheduler(Context context) {
        f11534f = StubApp.getOrigApplicationContext(context.getApplicationContext());
        this.f11544e = new HandlerC3206b(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m48090d(int i) {
        ScheduledExecutorService scheduledExecutorService;
        Log.d("BeiZis", "=============stop===================:" + i);
        if (i == 1) {
            ScheduledExecutorService scheduledExecutorService2 = this.f11540a;
            if (scheduledExecutorService2 == null) {
                return;
            }
            scheduledExecutorService2.shutdownNow();
            try {
                this.f11540a.awaitTermination(60000L, TimeUnit.MILLISECONDS);
            } catch (Exception unused) {
            } catch (Throwable th) {
                this.f11540a = null;
                throw th;
            }
            this.f11540a = null;
        } else if (i != 2) {
            if (i == 3 && (scheduledExecutorService = this.f11546j) != null) {
                scheduledExecutorService.shutdownNow();
                try {
                    this.f11546j.awaitTermination(60000L, TimeUnit.MILLISECONDS);
                } catch (Exception unused2) {
                } catch (Throwable th2) {
                    this.f11546j = null;
                    throw th2;
                }
                this.f11546j = null;
            }
        } else {
            ScheduledExecutorService scheduledExecutorService3 = this.f11545h;
            if (scheduledExecutorService3 == null) {
                return;
            }
            scheduledExecutorService3.shutdownNow();
            try {
                this.f11545h.awaitTermination(60000L, TimeUnit.MILLISECONDS);
            } catch (Exception unused3) {
            } catch (Throwable th3) {
                this.f11545h = null;
                throw th3;
            }
            this.f11545h = null;
        }
    }

    /* renamed from: e */
    private void m48089e() {
        if (f11535g == null) {
            ResponseInfo responseInfo = ResponseInfo.getInstance(f11534f);
            f11535g = responseInfo;
            if (!responseInfo.isInit()) {
                f11535g.init();
            }
            if (f11535g.getConfigurator() != null) {
                long checkInterval = f11535g.getConfigurator().getCheckInterval();
                if (checkInterval != 0) {
                    this.f11541b = checkInterval;
                }
            }
            if (f11535g.getMessenger() != null) {
                long checkInterval2 = f11535g.getMessenger().getCheckInterval();
                if (checkInterval2 != 0) {
                    this.f11542c = checkInterval2;
                }
            }
            if (f11535g.getTaskConfig() != null) {
                long checkInterval3 = f11535g.getTaskConfig().getCheckInterval();
                if (checkInterval3 != 0) {
                    this.f11543d = checkInterval3;
                }
            }
        }
        if (this.f11540a == null) {
            this.f11540a = Executors.newScheduledThreadPool(2);
        }
        if (this.f11545h == null) {
            this.f11545h = Executors.newScheduledThreadPool(2);
        }
        if (this.f11546j != null || this.f11543d == 0) {
            return;
        }
        this.f11546j = Executors.newScheduledThreadPool(2);
    }

    /* renamed from: c */
    private void m48093c(int i) {
        m48090d(1);
        LocalBroadcastManager m48499a = LocalBroadcastManager.m48499a(f11534f);
        Intent intent = new Intent("com.ad.action.UPDATE_CONFIG_SUCCESS");
        intent.putExtra("updateResult", i);
        m48499a.m48498a(intent);
    }

    /* renamed from: b */
    public void m48097b(int i) {
        m48089e();
        if (i == 0) {
            Log.d("BeiZis", this.f11541b + ":heartbeatTime=============start===================:logCheckTime:" + this.f11542c);
            ScheduledExecutorService scheduledExecutorService = this.f11540a;
            RunnableC3204a runnableC3204a = new RunnableC3204a(2);
            long j = this.f11541b;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            scheduledExecutorService.scheduleAtFixedRate(runnableC3204a, 0L, j, timeUnit);
            this.f11545h.scheduleAtFixedRate(new RunnableC3204a(3), 0L, this.f11542c, timeUnit);
            ScheduledExecutorService scheduledExecutorService2 = this.f11546j;
            if (scheduledExecutorService2 != null && this.f11543d != 0) {
                scheduledExecutorService2.scheduleAtFixedRate(new RunnableC3204a(4), 0L, this.f11543d, timeUnit);
                EventCar.m48869a(f11534f).m48868a(new EventBean(AdManager.f11053b, "", "500.000", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
            }
            EventCar.m48869a(f11534f).m48868a(new EventBean(AdManager.f11053b, "", "300.000", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        } else if (i == 1) {
            Log.d("BeiZis", "heartbeatTime:" + this.f11541b);
            this.f11540a.scheduleAtFixedRate(new RunnableC3204a(2), 0L, this.f11541b, TimeUnit.MILLISECONDS);
            EventCar.m48869a(f11534f).m48868a(new EventBean(AdManager.f11053b, "", "330.210", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        } else if (i == 2) {
            Log.d("BeiZis", "logCheckTime:" + this.f11542c);
            this.f11545h.scheduleAtFixedRate(new RunnableC3204a(3), 0L, this.f11542c, TimeUnit.MILLISECONDS);
            EventCar.m48869a(f11534f).m48868a(new EventBean(AdManager.f11053b, "", "410.300", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        } else if (i != 3) {
            if (i != 5) {
                return;
            }
            Log.d("BeiZis", "heartbeatTime:" + this.f11541b);
            this.f11540a.scheduleAtFixedRate(new RunnableC3204a(5), 0L, this.f11541b, TimeUnit.MILLISECONDS);
            EventCar.m48869a(f11534f).m48868a(new EventBean(AdManager.f11053b, "", "330.210", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        } else {
            C3116af.m48496a("BeiZis", "backTaskTime:" + this.f11543d);
            ScheduledExecutorService scheduledExecutorService3 = this.f11546j;
            if (scheduledExecutorService3 == null || this.f11543d == 0) {
                return;
            }
            scheduledExecutorService3.scheduleAtFixedRate(new RunnableC3204a(4), 0L, this.f11543d, TimeUnit.MILLISECONDS);
            EventCar.m48869a(f11534f).m48868a(new EventBean(AdManager.f11053b, "", "500.000", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }

    /* renamed from: a */
    public void m48100a(Object obj) {
        Log.d("BeiZis", "heartbeat logSuccess!");
        m48089e();
        if (((HeartResponse) obj) != null) {
            if (f11537k) {
                m48093c(1);
                f11537k = false;
            }
            if (f11538l) {
                ResponseInfo responseInfo = ResponseInfo.getInstance(f11534f);
                f11535g = responseInfo;
                responseInfo.init();
                f11538l = false;
            }
            if (f11535g.getConfigurator() != null) {
                long checkInterval = f11535g.getConfigurator().getCheckInterval();
                Log.d("BeiZis", checkInterval + "===============heartbeat=============" + this.f11541b);
                if (checkInterval != this.f11541b && checkInterval != 0) {
                    this.f11541b = checkInterval;
                    m48090d(1);
                    m48097b(1);
                }
            }
            Messenger messenger = f11535g.getMessenger();
            if (messenger != null) {
                long checkInterval2 = messenger.getCheckInterval();
                Log.d("BeiZis", checkInterval2 + "===============logBeat=============" + this.f11542c);
                if (checkInterval2 != this.f11542c && checkInterval2 != 0) {
                    this.f11542c = checkInterval2;
                    m48090d(2);
                    m48097b(2);
                }
            }
            TaskConfig taskConfig = f11535g.getTaskConfig();
            if (taskConfig != null) {
                long checkInterval3 = taskConfig.getCheckInterval();
                C3116af.m48496a("BeiZis", checkInterval3 + "===============backBeat=============" + this.f11543d);
                if (checkInterval3 != this.f11543d && checkInterval3 != 0) {
                    this.f11543d = checkInterval3;
                    m48090d(3);
                    m48097b(3);
                }
            }
            EventCar.m48869a(f11534f).m48868a(new EventBean(AdManager.f11053b, "", "320.200", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public Boolean m48091d() {
        m48089e();
        Manager manager = f11535g.getManager();
        if (manager != null) {
            List<AdSpacesBean> adSpaces = manager.getAdSpaces();
            if (adSpaces == null) {
                return Boolean.TRUE;
            }
            if (adSpaces.size() == 0) {
                return Boolean.TRUE;
            }
            String m48782b = AdManager.m48786a().m48782b();
            boolean z = false;
            AdSpacesBean adSpacesBean = adSpaces.get(0);
            if (!m48782b.equals(adSpacesBean.getAppId())) {
                return Boolean.TRUE;
            }
            if (adSpacesBean.getComponent() == null) {
                return Boolean.TRUE;
            }
            Configurator configurator = f11535g.getConfigurator();
            if (configurator != null) {
                long longValue = ((Long) C3137at.m48313b(f11534f, "lastUpdateTime", Long.valueOf(new Date(0L).getTime()))).longValue();
                long expireTime = f11535g.getExpireTime();
                this.f11541b = configurator.getCheckInterval();
                long maxValidTime = f11535g.getMaxValidTime();
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

    /* renamed from: a */
    public void m48106a(int i) {
        Log.d("BeiZis", "heartbeat fail:" + i);
        if (f11537k) {
            m48093c(0);
            f11537k = false;
        }
        EventCar.m48869a(f11534f).m48868a(new EventBean(AdManager.f11053b, "", "320.500", "", AdManager.m48786a().m48782b(), "", "", String.valueOf(System.currentTimeMillis()), ""));
    }

    /* renamed from: a */
    public static synchronized HeartScheduler m48105a(Context context) {
        HeartScheduler heartScheduler;
        synchronized (HeartScheduler.class) {
            if (f11539m == null) {
                f11539m = new HeartScheduler(context);
            }
            heartScheduler = f11539m;
        }
        return heartScheduler;
    }
}
