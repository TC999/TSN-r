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
import androidx.core.app.NotificationManagerCompat;
import androidx.core.content.FileProvider;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.t;
import com.mbridge.msdk.foundation.tools.x;
import com.mbridge.msdk.mbdownload.b;
import com.mbridge.msdk.mbdownload.e;
import com.stub.StubApp;
import java.io.File;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* compiled from: DownloadProvider.java */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public static final String f40070a = "c";

    /* renamed from: b  reason: collision with root package name */
    public static boolean f40071b;

    /* renamed from: c  reason: collision with root package name */
    protected static Map<b.a, Messenger> f40072c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    protected static SparseArray<e.b> f40073d = new SparseArray<>();

    /* renamed from: g  reason: collision with root package name */
    private NotificationManagerCompat f40076g;

    /* renamed from: h  reason: collision with root package name */
    private e f40077h;

    /* renamed from: i  reason: collision with root package name */
    private i f40078i;

    /* renamed from: j  reason: collision with root package name */
    private Handler f40079j;

    /* renamed from: l  reason: collision with root package name */
    private Service f40081l;

    /* renamed from: e  reason: collision with root package name */
    final Messenger f40074e = new Messenger(new b());

    /* renamed from: k  reason: collision with root package name */
    private boolean f40080k = true;

    /* renamed from: f  reason: collision with root package name */
    SparseArray<Long> f40075f = new SparseArray<>();

    /* compiled from: DownloadProvider.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class a extends Handler {
        a() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            Uri uriForFile;
            int i4 = message.what;
            if (i4 != 5) {
                if (i4 != 6) {
                    return;
                }
                b.a aVar = (b.a) message.obj;
                int i5 = message.arg2;
                String string = message.getData().getString("filename");
                c.this.f40076g.cancel(i5);
                Notification a4 = e.a(c.this.f40081l, g.k(c.this.f40081l.getBaseContext()), PendingIntent.getActivity(c.this.f40081l, 0, new Intent(), 134217728));
                if (a4 != null) {
                    try {
                        c.this.f40076g.notify(i5 + 1, a4);
                    } catch (Exception e4) {
                        e4.printStackTrace();
                    }
                }
                String replace = string.replace(".patch", ".apk");
                String a5 = com.mbridge.msdk.mbdownload.a.a(c.this.f40081l);
                e eVar = c.this.f40077h;
                eVar.getClass();
                new e.c(c.this.f40081l, i5, aVar, replace).execute(a5, replace, string);
                return;
            }
            b.a aVar2 = (b.a) message.obj;
            int i6 = message.arg2;
            try {
                try {
                    String string2 = message.getData().getString("filename");
                    x.a(c.f40070a, "Cancel old notification....");
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addFlags(268435456);
                    try {
                        Context applicationContext = c.this.f40081l.getApplicationContext();
                        if (t.w(applicationContext) >= 24 && Build.VERSION.SDK_INT >= 24) {
                            Uri uri = null;
                            try {
                                if (!TextUtils.isEmpty(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH)) {
                                    Method method = Class.forName(MBridgeConstans.FILE_PROVIDE_CUSTOM_PATH).getMethod("getUriForFile", Context.class, String.class, File.class);
                                    uriForFile = (Uri) method.invoke(null, applicationContext, applicationContext.getApplicationContext().getPackageName() + ".mbFileProvider", new File(string2));
                                } else {
                                    uriForFile = FileProvider.getUriForFile(applicationContext, applicationContext.getApplicationContext().getPackageName() + ".mbFileProvider", new File(string2));
                                }
                                uri = uriForFile;
                            } catch (Exception e5) {
                                e5.printStackTrace();
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
                    PendingIntent activity = PendingIntent.getActivity(c.this.f40081l, 0, intent, 134217728);
                    Notification a6 = aVar2.f40067r ? e.a(c.this.f40081l, g.j(c.this.f40081l.getBaseContext()), activity) : e.a(c.this.f40081l, g.i(c.this.f40081l.getBaseContext()), activity);
                    if (a6 != null) {
                        a6.flags = 16;
                        try {
                            c.this.f40076g.notify(i6 + 1, a6);
                        } catch (Exception e6) {
                            e6.printStackTrace();
                        }
                        x.a(c.f40070a, "Show new  notification....");
                    }
                    boolean a7 = c.this.f40077h.a(c.this.f40081l);
                    String str = c.f40070a;
                    x.a(str, String.format("isAppOnForeground = %1$B", Boolean.valueOf(a7)));
                    if (a7 && !aVar2.f40067r) {
                        c.this.f40076g.cancel(i6 + 1);
                        com.mbridge.msdk.click.c.c(c.this.f40081l, aVar2.f40056g);
                    }
                    x.b(str, String.format("%1$10s downloaded. Saved to: %2$s", aVar2.f40052c, string2));
                } catch (Exception e7) {
                    String str2 = c.f40070a;
                    x.d(str2, "can not install. " + e7.getMessage());
                    c.this.f40076g.cancel(i6 + 1);
                }
            } catch (Throwable unused2) {
            }
        }
    }

    /* compiled from: DownloadProvider.java */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    class b extends Handler {
        b() {
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            String str;
            try {
                str = c.f40070a;
                x.a(str, "IncomingHandler(msg.what:" + message.what + " msg.arg1:" + message.arg1 + " msg.arg2:" + message.arg2 + " msg.replyTo:" + message.replyTo);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            if (message.what != 4) {
                super.handleMessage(message);
                return;
            }
            Bundle data = message.getData();
            x.a(str, "IncomingHandler(msg.getData():" + data);
            b.a aVar = new b.a(data.getString("mComponentName"), data.getString("mTitle"), data.getString("mUrl"), data.getString("uniqueKey"), data.getBoolean("mOnGoingStatus"));
            aVar.f40054e = data.getString("mMd5");
            aVar.f40055f = data.getString("mTargetMd5");
            aVar.f40050a = data.getString("mReqClz");
            aVar.f40060k = data.getStringArray("succUrls");
            aVar.f40062m = data.getStringArray("faiUrls");
            aVar.f40063n = data.getStringArray("startUrls");
            aVar.f40064o = data.getStringArray("pauseUrls");
            aVar.f40065p = data.getStringArray("cancelUrls");
            aVar.f40061l = data.getStringArray("carryonUrls");
            aVar.f40066q = data.getBoolean("rich_notification");
            aVar.f40067r = data.getBoolean("mSilent");
            aVar.f40068s = data.getBoolean("mWifiOnly");
            aVar.f40058i = data.getBoolean("mCanPause");
            aVar.f40059j = data.getString("mTargetAppIconUrl");
            if (!c.this.f40077h.a(aVar, c.f40071b, message.replyTo)) {
                if (!e.b(c.this.f40081l)) {
                    Toast.makeText(c.this.f40081l, g.e(c.this.f40081l.getBaseContext()), 0).show();
                    Message obtain = Message.obtain();
                    obtain.what = 2;
                    obtain.arg1 = 4;
                    obtain.arg2 = 0;
                    try {
                        message.replyTo.send(obtain);
                        return;
                    } catch (RemoteException e5) {
                        e5.printStackTrace();
                        return;
                    }
                }
                c.f40072c.put(aVar, message.replyTo);
                Message obtain2 = Message.obtain();
                obtain2.what = 1;
                obtain2.arg1 = 1;
                obtain2.arg2 = 0;
                try {
                    message.replyTo.send(obtain2);
                } catch (RemoteException e6) {
                    e6.printStackTrace();
                }
                c.a(c.this, aVar);
                return;
            }
            x.b(str, aVar.f40052c + " is already in downloading list. ");
            int a4 = c.this.f40077h.a(aVar);
            if (a4 == -1 || c.f40073d.get(a4).f40098a != null) {
                if (c.this.f40081l != null && c.this.f40081l.getBaseContext() != null) {
                    Toast.makeText(c.this.f40081l, g.h(c.this.f40081l.getBaseContext()), 0).show();
                }
                Message obtain3 = Message.obtain();
                obtain3.what = 2;
                obtain3.arg1 = 2;
                obtain3.arg2 = 0;
                try {
                    message.replyTo.send(obtain3);
                    return;
                } catch (RemoteException e7) {
                    e7.printStackTrace();
                    return;
                }
            }
            String a5 = j.a(a4, "continue");
            Intent intent = new Intent(c.this.f40081l, c.class);
            intent.putExtra("com.mbridge.msdk.broadcast.download.msg", a5);
            c.this.f40077h.a(c.this, intent);
            return;
            e4.printStackTrace();
        }
    }

    private void d() {
        for (Integer num : this.f40078i.a()) {
            this.f40076g.cancel(num.intValue());
        }
    }

    public final IBinder a(Intent intent) {
        x.a(f40070a, "onBind ");
        return this.f40074e.getBinder();
    }

    public final void b() {
        try {
            d.a(StubApp.getOrigApplicationContext(this.f40081l.getApplicationContext())).a(259200);
            d.a(StubApp.getOrigApplicationContext(this.f40081l.getApplicationContext())).finalize();
        } catch (Exception e4) {
            x.d(f40070a, e4.getMessage());
        }
    }

    public final Service c() {
        return this.f40081l;
    }

    public final int a(Intent intent, int i4, int i5) {
        if (intent != null && intent.getExtras() != null) {
            this.f40077h.a(this, intent);
        }
        if (Build.VERSION.SDK_INT >= 19 && (this.f40078i.b() || this.f40080k)) {
            try {
                Intent intent2 = new Intent(StubApp.getOrigApplicationContext(this.f40081l.getApplicationContext()), getClass());
                intent2.setPackage(this.f40081l.getPackageName());
                ((AlarmManager) StubApp.getOrigApplicationContext(this.f40081l.getApplicationContext()).getSystemService("alarm")).set(3, SystemClock.elapsedRealtime() + 5000, PendingIntent.getService(StubApp.getOrigApplicationContext(this.f40081l.getApplicationContext()), 1, intent2, 1073741824));
            } catch (Exception unused) {
            }
        }
        if (this.f40080k) {
            d();
            this.f40080k = false;
        }
        return 1;
    }

    public final void b(int i4, int i5) {
        if (i5 == 1) {
            e.b bVar = f40073d.get(i4);
            e.a aVar = bVar.f40099b;
            aVar.a(100, 100, false).a(bVar.f40102e.f40059j).b(g.a(this.f40081l.getBaseContext())).a((CharSequence) g.c(this.f40081l.getBaseContext())).b().a(bVar.f40102e.f40057h);
            try {
                this.f40076g.notify(i4, aVar.d());
            } catch (Exception unused) {
                a(bVar, i4);
                e.a aVar2 = bVar.f40099b;
                aVar2.a(100, 100, false).a(bVar.f40102e.f40059j).b(g.a(this.f40081l.getBaseContext())).a((CharSequence) g.c(this.f40081l.getBaseContext())).b().a(bVar.f40102e.f40057h);
                try {
                    this.f40076g.notify(i4, aVar2.d());
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        } else if (i5 == 9) {
            e.b bVar2 = f40073d.get(i4);
            e.a aVar3 = bVar2.f40099b;
            aVar3.a(100, 100, false).a(bVar2.f40102e.f40059j).b(g.b(this.f40081l.getBaseContext())).a((CharSequence) g.d(this.f40081l.getBaseContext())).b().a(false);
            try {
                this.f40076g.notify(i4, aVar3.d());
            } catch (Exception unused2) {
                a(bVar2, i4);
                e.a aVar4 = bVar2.f40099b;
                aVar4.a(100, 100, false).a(bVar2.f40102e.f40059j).b(g.b(this.f40081l.getBaseContext())).a((CharSequence) g.d(this.f40081l.getBaseContext())).b().a(false);
                try {
                    this.f40076g.notify(i4, aVar4.d());
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }
    }

    public final void a() {
        if (f40071b) {
            Debug.waitForDebugger();
        }
        this.f40076g = NotificationManagerCompat.from(StubApp.getOrigApplicationContext(this.f40081l.getApplicationContext()));
        j.a();
        this.f40078i = new i(this.f40081l);
        this.f40077h = new e(f40073d, f40072c, this.f40078i);
        this.f40079j = new a();
    }

    public final void a(int i4) {
        NotificationChannel notificationChannel;
        if (f40073d.indexOfKey(i4) >= 0) {
            e.b bVar = f40073d.get(i4);
            long[] jArr = bVar.f40103f;
            int i5 = 0;
            if (jArr != null && jArr[1] > 0 && (i5 = (int) ((((float) jArr[0]) / ((float) jArr[1])) * 100.0f)) > 100) {
                i5 = 99;
            }
            if (bVar.f40102e.f40067r) {
                return;
            }
            this.f40075f.put(i4, -1L);
            e.a a4 = this.f40077h.a(this.f40081l, bVar.f40102e, i4, i5);
            bVar.f40099b = a4;
            try {
                this.f40076g.notify(i4, a4.d());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            try {
                String str = this.f40076g.areNotificationsEnabled() ? "true" : "false";
                String str2 = "";
                NotificationManager notificationManager = (NotificationManager) this.f40081l.getSystemService("notification");
                if (Build.VERSION.SDK_INT >= 26 && (notificationChannel = notificationManager.getNotificationChannel("download")) != null) {
                    str2 = String.valueOf(notificationChannel.getImportance());
                }
                com.mbridge.msdk.foundation.same.report.e.a(this.f40081l, str, String.valueOf(this.f40076g.getImportance()), str2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(int i4, int i5) {
        if (f40073d.indexOfKey(i4) >= 0) {
            e.b bVar = f40073d.get(i4);
            b.a aVar = bVar.f40102e;
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar.f40067r || currentTimeMillis - this.f40075f.get(i4).longValue() <= 500) {
                return;
            }
            this.f40075f.put(i4, Long.valueOf(currentTimeMillis));
            e.a aVar2 = bVar.f40099b;
            e.a a4 = aVar2.a(100, i5, false);
            a4.a((CharSequence) (String.valueOf(i5) + "%"));
            if (bVar.f40102e.f40058i) {
                aVar2.a();
            }
            try {
                this.f40076g.notify(i4, aVar2.d());
            } catch (Exception unused) {
                a(bVar, i4);
                e.a aVar3 = bVar.f40099b;
                e.a a5 = aVar3.a(100, i5, false);
                a5.a((CharSequence) (String.valueOf(i5) + "%"));
                if (bVar.f40102e.f40058i) {
                    aVar3.a();
                }
                try {
                    this.f40076g.notify(i4, aVar3.d());
                } catch (Exception e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public final void a(int i4, String str) {
        e.b bVar;
        if (f40073d.indexOfKey(i4) < 0 || (bVar = f40073d.get(i4)) == null) {
            return;
        }
        b.a aVar = bVar.f40102e;
        e.a aVar2 = bVar.f40099b;
        aVar2.a(100, 100, false).a(aVar.f40059j).b(g.a(this.f40081l.getBaseContext())).a((CharSequence) g.c(this.f40081l.getBaseContext())).b().a(aVar.f40057h).a(17301634);
        try {
            this.f40076g.notify(i4, aVar2.d());
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        d.a(this.f40081l).a(aVar.f40051b, aVar.f40053d, 100);
        Bundle bundle = new Bundle();
        bundle.putString("filename", str);
        if (aVar.f40051b.equalsIgnoreCase("delta_update")) {
            Message obtain = Message.obtain();
            obtain.what = 6;
            obtain.arg1 = 1;
            obtain.obj = aVar;
            obtain.arg2 = i4;
            obtain.setData(bundle);
            this.f40079j.sendMessage(obtain);
            return;
        }
        Message obtain2 = Message.obtain();
        obtain2.what = 5;
        obtain2.arg1 = 1;
        obtain2.obj = aVar;
        obtain2.arg2 = i4;
        obtain2.setData(bundle);
        this.f40079j.sendMessage(obtain2);
        Message obtain3 = Message.obtain();
        obtain3.what = 5;
        obtain3.arg1 = 1;
        obtain3.arg2 = i4;
        obtain3.setData(bundle);
        try {
            if (f40072c.get(aVar) != null) {
                f40072c.get(aVar).send(obtain3);
            }
        } catch (RemoteException unused) {
            this.f40077h.a(this.f40081l, i4);
        }
    }

    public final void a(int i4, Exception exc) {
        if (f40073d.indexOfKey(i4) >= 0) {
            this.f40077h.a(this.f40081l, i4);
        }
    }

    private void a(e.b bVar, int i4) {
        bVar.f40099b = this.f40077h.a(this.f40081l, bVar.f40102e, i4, 0);
    }

    public final void a(Service service) {
        this.f40081l = service;
    }

    static /* synthetic */ void a(c cVar, b.a aVar) {
        String str = f40070a;
        x.a(str, "startDownload([mComponentName:" + aVar.f40051b + " mTitle:" + aVar.f40052c + " mUrl:" + aVar.f40053d + "])");
        e eVar = cVar.f40077h;
        int abs = Math.abs((int) (((long) ((aVar.f40052c.hashCode() >> 2) + (aVar.f40053d.hashCode() >> 3))) + System.currentTimeMillis()));
        k kVar = new k(cVar, aVar, abs, 0);
        e.b bVar = new e.b(aVar, abs);
        cVar.f40078i.a(abs);
        f40073d.put(bVar.f40100c, bVar);
        bVar.f40098a = kVar;
        kVar.start();
        if (f40071b) {
            int size = f40072c.size();
            int size2 = f40073d.size();
            x.b(str, "Client size =" + size + "   cacheSize = " + size2);
            if (size != size2) {
                throw new RuntimeException("Client size =" + size + "   cacheSize = " + size2);
            }
        }
        if (f40071b) {
            for (int i4 = 0; i4 < f40073d.size(); i4++) {
                String str2 = f40070a;
                x.a(str2, "Running task " + f40073d.valueAt(i4).f40102e.f40052c);
            }
        }
    }
}
