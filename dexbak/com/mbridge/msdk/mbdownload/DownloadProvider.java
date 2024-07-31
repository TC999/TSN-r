package com.mbridge.msdk.mbdownload;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Debug;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.Toast;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.FileProvider;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.click.CommonClickUtil;
import com.mbridge.msdk.foundation.same.report.C11385e;
import com.mbridge.msdk.foundation.tools.SameDiTool;
import com.mbridge.msdk.foundation.tools.SameLogTool;
import com.mbridge.msdk.mbdownload.DownloadAgent;
import com.mbridge.msdk.mbdownload.DownloadTool;
import com.stub.StubApp;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.mbridge.msdk.mbdownload.c */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public class DownloadProvider {

    /* renamed from: a */
    public static final String f31298a = "c";

    /* renamed from: b */
    public static boolean f31299b;

    /* renamed from: c */
    protected static Map<DownloadAgent.C11460a, Messenger> f31300c = new HashMap();

    /* renamed from: d */
    protected static SparseArray<DownloadTool.C11469b> f31301d = new SparseArray<>();

    /* renamed from: g */
    private NotificationManagerCompat f31304g;

    /* renamed from: h */
    private DownloadTool f31305h;

    /* renamed from: i */
    private NotificationRuntimeCache f31306i;

    /* renamed from: j */
    private Handler f31307j;

    /* renamed from: l */
    private Service f31309l;

    /* renamed from: e */
    final Messenger f31302e = new Messenger(new HandlerC11463b());

    /* renamed from: k */
    private boolean f31308k = true;

    /* renamed from: f */
    SparseArray<Long> f31303f = new SparseArray<>();

    /* compiled from: DownloadProvider.java */
    /* renamed from: com.mbridge.msdk.mbdownload.c$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class HandlerC11462a extends Handler {
        HandlerC11462a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Uri uriForFile;
            int i = message.what;
            if (i != 5) {
                if (i != 6) {
                    return;
                }
                DownloadAgent.C11460a c11460a = (DownloadAgent.C11460a) message.obj;
                int i2 = message.arg2;
                String string = message.getData().getString("filename");
                DownloadProvider.this.f31304g.cancel(i2);
                Notification m21630a = DownloadTool.m21630a(DownloadProvider.this.f31309l, MSGMapper.m21600k(DownloadProvider.this.f31309l.getBaseContext()), PendingIntent.getActivity(DownloadProvider.this.f31309l, 0, new Intent(), AMapEngineUtils.HALF_MAX_P20_WIDTH));
                if (m21630a != null) {
                    try {
                        DownloadProvider.this.f31304g.notify(i2 + 1, m21630a);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                String replace = string.replace(".patch", ".apk");
                String m21682a = DeltaUpdate.m21682a(DownloadProvider.this.f31309l);
                DownloadTool downloadTool = DownloadProvider.this.f31305h;
                downloadTool.getClass();
                new DownloadTool.AsyncTaskC11470c(DownloadProvider.this.f31309l, i2, c11460a, replace).execute(m21682a, replace, string);
                return;
            }
            DownloadAgent.C11460a c11460a2 = (DownloadAgent.C11460a) message.obj;
            int i3 = message.arg2;
            try {
                try {
                    String string2 = message.getData().getString("filename");
                    SameLogTool.m21738a(DownloadProvider.f31298a, "Cancel old notification....");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    try {
                        Context applicationContext = DownloadProvider.this.f31309l.getApplicationContext();
                        if (SameDiTool.m21767w(applicationContext) >= 24 && Build.VERSION.SDK_INT >= 24) {
                            Uri uri = null;
                            try {
                                if (!TextUtils.isEmpty(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH)) {
                                    Method method = Class.forName(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH).getMethod("getUriForFile", Context.class, String.class, File.class);
                                    uriForFile = (Uri) method.invoke(null, applicationContext, applicationContext.getApplicationContext().getPackageName() + ".mbFileProvider", new File(string2));
                                } else {
                                    uriForFile = FileProvider.getUriForFile(applicationContext, applicationContext.getApplicationContext().getPackageName() + ".mbFileProvider", new File(string2));
                                }
                                uri = uriForFile;
                            } catch (Exception e2) {
                                e2.printStackTrace();
                            }
                            if (uri != null) {
                                intent.setDataAndType(uri, "application/vnd.android.package-archive");
                                intent.addFlags(1);
                            }
                        } else {
                            intent.setDataAndType(Uri.fromFile(new File(string2)), "application/vnd.android.package-archive");
                        }
                    } catch (Exception unused) {
                        intent.setDataAndType(Uri.fromFile(new File(string2)), "application/vnd.android.package-archive");
                    }
                    PendingIntent activity = PendingIntent.getActivity(DownloadProvider.this.f31309l, 0, intent, AMapEngineUtils.HALF_MAX_P20_WIDTH);
                    Notification m21630a2 = c11460a2.f31295r ? DownloadTool.m21630a(DownloadProvider.this.f31309l, MSGMapper.m21601j(DownloadProvider.this.f31309l.getBaseContext()), activity) : DownloadTool.m21630a(DownloadProvider.this.f31309l, MSGMapper.m21602i(DownloadProvider.this.f31309l.getBaseContext()), activity);
                    if (m21630a2 != null) {
                        m21630a2.flags = 16;
                        try {
                            DownloadProvider.this.f31304g.notify(i3 + 1, m21630a2);
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                        SameLogTool.m21738a(DownloadProvider.f31298a, "Show new  notification....");
                    }
                    boolean m21634a = DownloadProvider.this.f31305h.m21634a(DownloadProvider.this.f31309l);
                    String str = DownloadProvider.f31298a;
                    SameLogTool.m21738a(str, String.format("isAppOnForeground = %1$B", Boolean.valueOf(m21634a)));
                    if (m21634a && !c11460a2.f31295r) {
                        DownloadProvider.this.f31304g.cancel(i3 + 1);
                        CommonClickUtil.m23066c(DownloadProvider.this.f31309l, c11460a2.f31284g);
                    }
                    SameLogTool.m21736b(str, String.format("%1$10s downloaded. Saved to: %2$s", c11460a2.f31280c, string2));
                } catch (Exception e4) {
                    String str2 = DownloadProvider.f31298a;
                    SameLogTool.m21733d(str2, "can not install. " + e4.getMessage());
                    DownloadProvider.this.f31304g.cancel(i3 + 1);
                }
            } catch (Throwable unused2) {
            }
        }
    }

    /* compiled from: DownloadProvider.java */
    /* renamed from: com.mbridge.msdk.mbdownload.c$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    class HandlerC11463b extends Handler {
        HandlerC11463b() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str;
            try {
                str = DownloadProvider.f31298a;
                SameLogTool.m21738a(str, "IncomingHandler(msg.what:" + message.what + " msg.arg1:" + message.arg1 + " msg.arg2:" + message.arg2 + " msg.replyTo:" + message.replyTo);
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (message.what != 4) {
                super.handleMessage(message);
                return;
            }
            Bundle data = message.getData();
            SameLogTool.m21738a(str, "IncomingHandler(msg.getData():" + data);
            DownloadAgent.C11460a c11460a = new DownloadAgent.C11460a(data.getString("mComponentName"), data.getString("mTitle"), data.getString("mUrl"), data.getString("uniqueKey"), data.getBoolean("mOnGoingStatus"));
            c11460a.f31282e = data.getString("mMd5");
            c11460a.f31283f = data.getString("mTargetMd5");
            c11460a.f31278a = data.getString("mReqClz");
            c11460a.f31288k = data.getStringArray("succUrls");
            c11460a.f31290m = data.getStringArray("faiUrls");
            c11460a.f31291n = data.getStringArray("startUrls");
            c11460a.f31292o = data.getStringArray("pauseUrls");
            c11460a.f31293p = data.getStringArray("cancelUrls");
            c11460a.f31289l = data.getStringArray("carryonUrls");
            c11460a.f31294q = data.getBoolean("rich_notification");
            c11460a.f31295r = data.getBoolean("mSilent");
            c11460a.f31296s = data.getBoolean("mWifiOnly");
            c11460a.f31286i = data.getBoolean("mCanPause");
            c11460a.f31287j = data.getString("mTargetAppIconUrl");
            if (!DownloadProvider.this.f31305h.m21628a(c11460a, DownloadProvider.f31299b, message.replyTo)) {
                if (!DownloadTool.m21621b(DownloadProvider.this.f31309l)) {
                    Toast.makeText(DownloadProvider.this.f31309l, MSGMapper.m21606e(DownloadProvider.this.f31309l.getBaseContext()), 0).show();
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.arg1 = 4;
                    obtain.arg2 = 0;
                    try {
                        message.replyTo.send(obtain);
                        return;
                    } catch (RemoteException e2) {
                        e2.printStackTrace();
                        return;
                    }
                }
                DownloadProvider.f31300c.put(c11460a, message.replyTo);
                Message obtain2 = Message.obtain();
                obtain2.what = 1;
                obtain2.arg1 = 1;
                obtain2.arg2 = 0;
                try {
                    message.replyTo.send(obtain2);
                } catch (RemoteException e3) {
                    e3.printStackTrace();
                }
                DownloadProvider.m21647a(DownloadProvider.this, c11460a);
                return;
            }
            SameLogTool.m21736b(str, c11460a.f31280c + " is already in downloading list. ");
            int m21629a = DownloadProvider.this.f31305h.m21629a(c11460a);
            if (m21629a == -1 || DownloadProvider.f31301d.get(m21629a).f31326a != null) {
                if (DownloadProvider.this.f31309l != null && DownloadProvider.this.f31309l.getBaseContext() != null) {
                    Toast.makeText(DownloadProvider.this.f31309l, MSGMapper.m21603h(DownloadProvider.this.f31309l.getBaseContext()), 0).show();
                }
                Message obtain3 = Message.obtain();
                obtain3.what = 2;
                obtain3.arg1 = 2;
                obtain3.arg2 = 0;
                try {
                    message.replyTo.send(obtain3);
                    return;
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return;
                }
            }
            String m21589a = NotificationUtils.m21589a(m21629a, "continue");
            Intent intent = new Intent(DownloadProvider.this.f31309l, DownloadProvider.class);
            intent.putExtra("com.mbridge.msdk.broadcast.download.msg", m21589a);
            DownloadProvider.this.f31305h.m21627a(DownloadProvider.this, intent);
            return;
            e.printStackTrace();
        }
    }

    /* renamed from: d */
    private void m21640d() {
        for (Integer num : this.f31306i.m21594a()) {
            this.f31304g.cancel(num.intValue());
        }
    }

    /* renamed from: a */
    public final IBinder m21650a(Intent intent) {
        SameLogTool.m21738a(f31298a, "onBind ");
        return this.f31302e.getBinder();
    }

    /* renamed from: b */
    public final void m21645b() {
        try {
            DownloadTaskList.m21637a(StubApp.getOrigApplicationContext(this.f31309l.getApplicationContext())).m21638a(259200);
            DownloadTaskList.m21637a(StubApp.getOrigApplicationContext(this.f31309l.getApplicationContext())).finalize();
        } catch (Exception e) {
            SameLogTool.m21733d(f31298a, e.getMessage());
        }
    }

    /* renamed from: c */
    public final Service m21642c() {
        return this.f31309l;
    }

    /* renamed from: a */
    public final int m21649a(Intent intent, int i, int i2) {
        if (intent != null && intent.getExtras() != null) {
            this.f31305h.m21627a(this, intent);
        }
        if (Build.VERSION.SDK_INT >= 19 && (this.f31306i.m21592b() || this.f31308k)) {
            try {
                Intent intent2 = new Intent(StubApp.getOrigApplicationContext(this.f31309l.getApplicationContext()), getClass());
                intent2.setPackage(this.f31309l.getPackageName());
                ((AlarmManager) StubApp.getOrigApplicationContext(this.f31309l.getApplicationContext()).getSystemService(NotificationCompat.CATEGORY_ALARM)).set(3, SystemClock.elapsedRealtime() + 5000, PendingIntent.getService(StubApp.getOrigApplicationContext(this.f31309l.getApplicationContext()), 1, intent2, 1073741824));
            } catch (Exception unused) {
            }
        }
        if (this.f31308k) {
            m21640d();
            this.f31308k = false;
        }
        return 1;
    }

    /* renamed from: b */
    public final void m21644b(int i, int i2) {
        if (i2 == 1) {
            DownloadTool.C11469b c11469b = f31301d.get(i);
            DownloadTool.C11467a c11467a = c11469b.f31327b;
            c11467a.m21618a(100, 100, false).m21616a(c11469b.f31330e.f31287j).m21614b(MSGMapper.m21610a(this.f31309l.getBaseContext())).m21617a((CharSequence) MSGMapper.m21608c(this.f31309l.getBaseContext())).m21615b().m21597a(c11469b.f31330e.f31285h);
            try {
                this.f31304g.notify(i, c11467a.m21611d());
            } catch (Exception unused) {
                m21646a(c11469b, i);
                DownloadTool.C11467a c11467a2 = c11469b.f31327b;
                c11467a2.m21618a(100, 100, false).m21616a(c11469b.f31330e.f31287j).m21614b(MSGMapper.m21610a(this.f31309l.getBaseContext())).m21617a((CharSequence) MSGMapper.m21608c(this.f31309l.getBaseContext())).m21615b().m21597a(c11469b.f31330e.f31285h);
                try {
                    this.f31304g.notify(i, c11467a2.m21611d());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        } else if (i2 == 9) {
            DownloadTool.C11469b c11469b2 = f31301d.get(i);
            DownloadTool.C11467a c11467a3 = c11469b2.f31327b;
            c11467a3.m21618a(100, 100, false).m21616a(c11469b2.f31330e.f31287j).m21614b(MSGMapper.m21609b(this.f31309l.getBaseContext())).m21617a((CharSequence) MSGMapper.m21607d(this.f31309l.getBaseContext())).m21615b().m21597a(false);
            try {
                this.f31304g.notify(i, c11467a3.m21611d());
            } catch (Exception unused2) {
                m21646a(c11469b2, i);
                DownloadTool.C11467a c11467a4 = c11469b2.f31327b;
                c11467a4.m21618a(100, 100, false).m21616a(c11469b2.f31330e.f31287j).m21614b(MSGMapper.m21609b(this.f31309l.getBaseContext())).m21617a((CharSequence) MSGMapper.m21607d(this.f31309l.getBaseContext())).m21615b().m21597a(false);
                try {
                    this.f31304g.notify(i, c11467a4.m21611d());
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public final void m21656a() {
        if (f31299b) {
            Debug.waitForDebugger();
        }
        this.f31304g = NotificationManagerCompat.from(StubApp.getOrigApplicationContext(this.f31309l.getApplicationContext()));
        NotificationUtils.m21590a();
        this.f31306i = new NotificationRuntimeCache(this.f31309l);
        this.f31305h = new DownloadTool(f31301d, f31300c, this.f31306i);
        this.f31307j = new HandlerC11462a();
    }

    /* renamed from: a */
    public final void m21655a(int i) {
        NotificationChannel notificationChannel;
        if (f31301d.indexOfKey(i) >= 0) {
            DownloadTool.C11469b c11469b = f31301d.get(i);
            long[] jArr = c11469b.f31331f;
            int i2 = 0;
            if (jArr != null && jArr[1] > 0 && (i2 = (int) ((((float) jArr[0]) / ((float) jArr[1])) * 100.0f)) > 100) {
                i2 = 99;
            }
            if (c11469b.f31330e.f31295r) {
                return;
            }
            this.f31303f.put(i, -1L);
            DownloadTool.C11467a m21632a = this.f31305h.m21632a(this.f31309l, c11469b.f31330e, i, i2);
            c11469b.f31327b = m21632a;
            try {
                this.f31304g.notify(i, m21632a.m21611d());
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                String str = this.f31304g.areNotificationsEnabled() ? "true" : "false";
                String str2 = "";
                NotificationManager notificationManager = (NotificationManager) this.f31309l.getSystemService("notification");
                if (Build.VERSION.SDK_INT >= 26 && (notificationChannel = notificationManager.getNotificationChannel("download")) != null) {
                    str2 = String.valueOf(notificationChannel.getImportance());
                }
                C11385e.m22073a(this.f31309l, str, String.valueOf(this.f31304g.getImportance()), str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public final void m21654a(int i, int i2) {
        if (f31301d.indexOfKey(i) >= 0) {
            DownloadTool.C11469b c11469b = f31301d.get(i);
            DownloadAgent.C11460a c11460a = c11469b.f31330e;
            long currentTimeMillis = System.currentTimeMillis();
            if (c11460a.f31295r || currentTimeMillis - this.f31303f.get(i).longValue() <= 500) {
                return;
            }
            this.f31303f.put(i, Long.valueOf(currentTimeMillis));
            DownloadTool.C11467a c11467a = c11469b.f31327b;
            DownloadTool.C11467a m21618a = c11467a.m21618a(100, i2, false);
            m21618a.m21617a((CharSequence) (String.valueOf(i2) + "%"));
            if (c11469b.f31330e.f31286i) {
                c11467a.m21619a();
            }
            try {
                this.f31304g.notify(i, c11467a.m21611d());
            } catch (Exception unused) {
                m21646a(c11469b, i);
                DownloadTool.C11467a c11467a2 = c11469b.f31327b;
                DownloadTool.C11467a m21618a2 = c11467a2.m21618a(100, i2, false);
                m21618a2.m21617a((CharSequence) (String.valueOf(i2) + "%"));
                if (c11469b.f31330e.f31286i) {
                    c11467a2.m21619a();
                }
                try {
                    this.f31304g.notify(i, c11467a2.m21611d());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* renamed from: a */
    public final void m21652a(int i, String str) {
        DownloadTool.C11469b c11469b;
        if (f31301d.indexOfKey(i) < 0 || (c11469b = f31301d.get(i)) == null) {
            return;
        }
        DownloadAgent.C11460a c11460a = c11469b.f31330e;
        DownloadTool.C11467a c11467a = c11469b.f31327b;
        c11467a.m21618a(100, 100, false).m21616a(c11460a.f31287j).m21614b(MSGMapper.m21610a(this.f31309l.getBaseContext())).m21617a((CharSequence) MSGMapper.m21608c(this.f31309l.getBaseContext())).m21615b().m21597a(c11460a.f31285h).m21599a(17301634);
        try {
            this.f31304g.notify(i, c11467a.m21611d());
        } catch (Exception e) {
            e.printStackTrace();
        }
        DownloadTaskList.m21637a(this.f31309l).m21636a(c11460a.f31279b, c11460a.f31281d, 100);
        Bundle bundle = new Bundle();
        bundle.putString("filename", str);
        if (c11460a.f31279b.equalsIgnoreCase("delta_update")) {
            Message obtain = Message.obtain();
            obtain.what = 6;
            obtain.arg1 = 1;
            obtain.obj = c11460a;
            obtain.arg2 = i;
            obtain.setData(bundle);
            this.f31307j.sendMessage(obtain);
            return;
        }
        Message obtain2 = Message.obtain();
        obtain2.what = 5;
        obtain2.arg1 = 1;
        obtain2.obj = c11460a;
        obtain2.arg2 = i;
        obtain2.setData(bundle);
        this.f31307j.sendMessage(obtain2);
        Message obtain3 = Message.obtain();
        obtain3.what = 5;
        obtain3.arg1 = 1;
        obtain3.arg2 = i;
        obtain3.setData(bundle);
        try {
            if (f31300c.get(c11460a) != null) {
                f31300c.get(c11460a).send(obtain3);
            }
        } catch (RemoteException unused) {
            this.f31305h.m21633a(this.f31309l, i);
        }
    }

    /* renamed from: a */
    public final void m21653a(int i, Exception exc) {
        if (f31301d.indexOfKey(i) >= 0) {
            this.f31305h.m21633a(this.f31309l, i);
        }
    }

    /* renamed from: a */
    private void m21646a(DownloadTool.C11469b c11469b, int i) {
        c11469b.f31327b = this.f31305h.m21632a(this.f31309l, c11469b.f31330e, i, 0);
    }

    /* renamed from: a */
    public final void m21651a(Service service) {
        this.f31309l = service;
    }

    /* renamed from: a */
    static /* synthetic */ void m21647a(DownloadProvider downloadProvider, DownloadAgent.C11460a c11460a) {
        String str = f31298a;
        SameLogTool.m21738a(str, "startDownload([mComponentName:" + c11460a.f31279b + " mTitle:" + c11460a.f31280c + " mUrl:" + c11460a.f31281d + "])");
        DownloadTool downloadTool = downloadProvider.f31305h;
        int abs = Math.abs((int) (((long) ((c11460a.f31280c.hashCode() >> 2) + (c11460a.f31281d.hashCode() >> 3))) + System.currentTimeMillis()));
        WorkThread workThread = new WorkThread(downloadProvider, c11460a, abs, 0);
        DownloadTool.C11469b c11469b = new DownloadTool.C11469b(c11460a, abs);
        downloadProvider.f31306i.m21593a(abs);
        f31301d.put(c11469b.f31328c, c11469b);
        c11469b.f31326a = workThread;
        workThread.start();
        if (f31299b) {
            int size = f31300c.size();
            int size2 = f31301d.size();
            SameLogTool.m21736b(str, "Client size =" + size + "   cacheSize = " + size2);
            if (size != size2) {
                throw new RuntimeException("Client size =" + size + "   cacheSize = " + size2);
            }
        }
        if (f31299b) {
            for (int i = 0; i < f31301d.size(); i++) {
                String str2 = f31298a;
                SameLogTool.m21738a(str2, "Running task " + f31301d.valueAt(i).f31330e.f31280c);
            }
        }
    }
}
