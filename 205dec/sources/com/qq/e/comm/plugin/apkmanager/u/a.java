package com.qq.e.comm.plugin.apkmanager.u;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.v1;
import java.util.concurrent.Future;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class a implements com.qq.e.comm.plugin.apkmanager.u.d {

    /* renamed from: a  reason: collision with root package name */
    private final ApkDownloadTask f41900a;

    /* renamed from: b  reason: collision with root package name */
    private final com.qq.e.comm.plugin.apkmanager.u.c f41901b;

    /* renamed from: c  reason: collision with root package name */
    private final NotificationManager f41902c;

    /* renamed from: d  reason: collision with root package name */
    private Future<Bitmap> f41903d;

    /* renamed from: e  reason: collision with root package name */
    private com.qq.e.comm.plugin.apkmanager.u.e f41904e;

    /* renamed from: g  reason: collision with root package name */
    private long f41906g;

    /* renamed from: h  reason: collision with root package name */
    private String f41907h;

    /* renamed from: i  reason: collision with root package name */
    private int f41908i;

    /* renamed from: f  reason: collision with root package name */
    private int f41905f = -1;

    /* renamed from: j  reason: collision with root package name */
    private boolean f41909j = false;

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.apkmanager.u.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class RunnableC0788a implements Runnable {
        RunnableC0788a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f41901b != null) {
                a.this.d();
                a.this.f41905f = -1;
                a.this.f41906g = 0L;
                a.this.f41901b.a("\u73a9\u513f\u547d\u4e0b\u8f7d\u4e2d").a(100, 100, true);
                if (a.this.f41904e != null) {
                    a.this.f41901b.a(a.this.f41904e.e());
                }
                Notification a4 = a.this.f41901b.a();
                a.this.c();
                a.this.a(a4);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f41911c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ long f41912d;

        b(long j4, long j5) {
            this.f41911c = j4;
            this.f41912d = j5;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f41901b != null) {
                long j4 = this.f41911c;
                int i4 = j4 > 0 ? (int) ((this.f41912d * 100) / j4) : 0;
                long currentTimeMillis = System.currentTimeMillis();
                if (i4 - a.this.f41905f <= 1 || currentTimeMillis - a.this.f41906g <= 1000) {
                    return;
                }
                a.this.f41905f = i4;
                a.this.f41906g = currentTimeMillis;
                a.this.d();
                a.this.f41901b.a(100, a.this.f41905f, false);
                com.qq.e.comm.plugin.apkmanager.u.c cVar = a.this.f41901b;
                cVar.a("\u5df2\u5b8c\u6210\uff1a" + v1.a(this.f41912d) + ",\u603b\u5927\u5c0f\uff1a" + v1.a(this.f41911c));
                if (a.this.f41904e != null) {
                    a.this.f41901b.a(a.this.f41904e.e());
                }
                Notification a4 = a.this.f41901b.a();
                if (i4 % 10 == 0) {
                    a.this.c();
                }
                a.this.a(a4);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class c implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f41914c;

        c(String str) {
            this.f41914c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f41901b != null) {
                com.qq.e.comm.plugin.apkmanager.u.c a4 = a.this.f41901b.a(false);
                a4.b("\u6682\u505c\u4e0b\u8f7d\uff1a" + a.this.f41900a.p());
                a.this.e();
                a.this.f41901b.a(100, a.this.f41905f, false);
                a.this.f41901b.a(this.f41914c);
                if (a.this.f41904e != null) {
                    a.this.f41901b.a(a.this.f41904e.b());
                }
                Notification a5 = a.this.f41901b.a();
                a.this.c();
                a.this.a(a5);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class d implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f41916c;

        d(String str) {
            this.f41916c = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f41901b != null) {
                a.this.d();
                a.this.f41901b.a(100, 100, true);
                a.this.f41901b.a(this.f41916c);
                if (a.this.f41904e != null) {
                    a.this.f41901b.a(a.this.f41904e.c());
                }
                Notification a4 = a.this.f41901b.a();
                a.this.c();
                a.this.a(a4);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f41901b != null) {
                a.this.d();
                a.this.f41901b.a(100, 100, false);
                a.this.f41901b.a("\u4e0b\u8f7d\u5b8c\u6210\u70b9\u51fb\u5b89\u88c5");
                if (a.this.f41904e != null) {
                    a.this.f41901b.a(a.this.f41904e.d());
                }
                Notification a4 = a.this.f41901b.a();
                a.this.c();
                a.this.a(a4);
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class f implements Runnable {
        f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f41901b != null) {
                if (a.this.f41904e != null) {
                    a.this.f41901b.a(a.this.f41904e.a());
                }
                if (a.this.f41900a.j() != null) {
                    a.this.f41901b.a(a.this.f41900a.j());
                }
                a.this.f41901b.a("\u70b9\u51fb\u542f\u52a8").b(a.this.f41900a.p()).a(false);
                Notification a4 = a.this.f41901b.a();
                a.this.c();
                a.this.a(a4);
            }
        }
    }

    public a(Context context, ApkDownloadTask apkDownloadTask) {
        this.f41900a = apkDownloadTask;
        this.f41901b = com.qq.e.comm.plugin.apkmanager.u.c.a(context);
        this.f41902c = com.qq.e.comm.plugin.j.b.a(context);
        this.f41907h = apkDownloadTask.d("notifyTag");
        this.f41908i = apkDownloadTask.b("notifyId");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.d
    public void start() {
        p0.a((Runnable) new RunnableC0788a());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        com.qq.e.comm.plugin.apkmanager.u.c cVar = this.f41901b;
        if (cVar != null) {
            com.qq.e.comm.plugin.apkmanager.u.c a4 = cVar.a(false);
            a4.b("\u6b63\u5728\u4e0b\u8f7d\uff1a" + this.f41900a.p());
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        Future<Bitmap> future;
        if (this.f41901b == null || this.f41909j || (future = this.f41903d) == null || !future.isDone()) {
            return;
        }
        this.f41909j = true;
        try {
            Bitmap bitmap = this.f41903d.get();
            if (bitmap != null) {
                this.f41901b.a(bitmap);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.d
    public void b(String str) {
        p0.a((Runnable) new c(str));
    }

    public void b() {
        p0.a((Runnable) new f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(Notification notification) {
        NotificationManager notificationManager = this.f41902c;
        if (notificationManager == null || notification == null) {
            return;
        }
        try {
            notificationManager.notify(this.f41907h, this.f41908i, notification);
        } catch (RuntimeException unused) {
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.d
    public void a(long j4, long j5) {
        p0.a((Runnable) new b(j5, j4));
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.d
    public void a(String str) {
        p0.a((Runnable) new d(str));
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.d
    public void a() {
        p0.a((Runnable) new e());
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.d
    public void a(Future<Bitmap> future) {
        this.f41903d = future;
    }

    @Override // com.qq.e.comm.plugin.apkmanager.u.d
    public void a(com.qq.e.comm.plugin.apkmanager.u.e eVar) {
        this.f41904e = eVar;
    }
}
