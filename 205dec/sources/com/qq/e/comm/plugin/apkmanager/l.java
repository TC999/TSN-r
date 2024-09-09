package com.qq.e.comm.plugin.apkmanager;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.qq.e.comm.pi.SVSD;
import com.qq.e.comm.plugin.apkmanager.p;
import com.qq.e.comm.plugin.apkmanager.q;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.o.a;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.q1;
import com.qq.e.comm.plugin.util.v1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class l implements SVSD, p.a {

    /* renamed from: i  reason: collision with root package name */
    private static final ArrayList<String> f41803i = new ArrayList<>();

    /* renamed from: j  reason: collision with root package name */
    private static final HashMap<String, ReentrantLock> f41804j = new HashMap<>();

    /* renamed from: k  reason: collision with root package name */
    private static long f41805k = ((com.qq.e.comm.plugin.d0.a.d().f().a("rdet", 24) * 60) * 60) * 1000;

    /* renamed from: a  reason: collision with root package name */
    private final Service f41806a;

    /* renamed from: b  reason: collision with root package name */
    private p f41807b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f41808c;

    /* renamed from: e  reason: collision with root package name */
    private boolean f41810e;

    /* renamed from: f  reason: collision with root package name */
    private final j f41811f;

    /* renamed from: h  reason: collision with root package name */
    private boolean f41813h;

    /* renamed from: d  reason: collision with root package name */
    private final ConcurrentHashMap<String, Intent> f41809d = new ConcurrentHashMap<>();

    /* renamed from: g  reason: collision with root package name */
    private long f41812g = System.currentTimeMillis();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.f();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements a.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f41816a;

        c(ApkDownloadTask apkDownloadTask) {
            this.f41816a = apkDownloadTask;
        }

        @Override // com.qq.e.comm.plugin.o.a.b
        public void a() {
            l.this.f41811f.a(this.f41816a, false);
            v.a(1130034, (com.qq.e.comm.plugin.n0.c) null);
        }

        @Override // com.qq.e.comm.plugin.o.a.b
        public void b() {
            l.this.a(this.f41816a);
            v.a(1130033, (com.qq.e.comm.plugin.n0.c) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d extends o {

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f41818d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ Intent f41819e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(com.qq.e.comm.plugin.apkmanager.a aVar, com.qq.e.comm.plugin.apkmanager.c cVar, ApkDownloadTask apkDownloadTask, ApkDownloadTask apkDownloadTask2, Intent intent) {
            super(aVar, cVar, apkDownloadTask);
            this.f41818d = apkDownloadTask2;
            this.f41819e = intent;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.o
        public void a(int i4, String str) {
            if (i4 == 11) {
                l.this.f41809d.put(this.f41818d.s(), this.f41819e);
            }
            l.f41804j.remove(this.f41818d.r());
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class e implements Runnable {
        e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            l.this.e();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private class f extends q.a {
        private f() {
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public int a(String str) throws RemoteException {
            return com.qq.e.comm.plugin.apkmanager.w.b.a().c(l.this.f41808c, str);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public List<ApkDownloadTask> b() throws RemoteException {
            return l.this.f41811f.a();
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public List<ApkDownloadTask> c() throws RemoteException {
            return l.this.f41811f.b();
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public int d(String str) throws RemoteException {
            return com.qq.e.comm.plugin.apkmanager.w.b.a().d(l.this.f41808c, str);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public boolean f(int i4) throws RemoteException {
            return l.this.f41811f.a(i4, 1);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public ApkDownloadTask g(int i4) throws RemoteException {
            return l.this.f41811f.a(i4);
        }

        /* synthetic */ f(l lVar, a aVar) {
            this();
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public int a(ApkDownloadTask apkDownloadTask) throws RemoteException {
            return l.this.f41811f.c(apkDownloadTask);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public int b(String str, int i4) throws RemoteException {
            return l.this.f41811f.b(str, i4);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public ApkDownloadTask c(String str) throws RemoteException {
            return l.this.f41811f.a(str);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public List<ApkDownloadTask> d() throws RemoteException {
            return l.this.f41811f.c();
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public boolean a(String str, int i4) throws RemoteException {
            return l.this.f41811f.a(str, i4);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public boolean b(String str) throws RemoteException {
            return l.this.f41811f.b(str);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public boolean c(ApkDownloadTask apkDownloadTask) throws RemoteException {
            return l.this.f41811f.a(apkDownloadTask, 1);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public int d(ApkDownloadTask apkDownloadTask) throws RemoteException {
            return l.this.f41811f.a(apkDownloadTask);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public boolean a(ApkDownloadTask apkDownloadTask, boolean z3) throws RemoteException {
            return l.this.f41811f.a(apkDownloadTask, z3);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public boolean b(ApkDownloadTask apkDownloadTask) throws RemoteException {
            return l.this.f41811f.b(apkDownloadTask);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public boolean d(int i4) throws RemoteException {
            return l.this.f41811f.b(i4);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.q
        public boolean a(int i4, int i5, long j4) throws RemoteException {
            return l.this.f41811f.a(i4, i5, j4);
        }
    }

    public l(Service service) {
        this.f41806a = service;
        Context applicationContext = service.getApplicationContext();
        this.f41808c = applicationContext;
        this.f41811f = new j(applicationContext);
    }

    private void g() {
        if (this.f41809d.isEmpty()) {
            return;
        }
        try {
            for (Intent intent : this.f41809d.values()) {
                i.a(intent, false);
                this.f41806a.startService(intent);
            }
            this.f41809d.clear();
        } catch (Throwable th) {
            String th2 = th.toString();
            d1.a(th2);
            com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
            dVar.a("msg", th2);
            v.b(100252, null, Integer.valueOf(this.f41809d.size()), dVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.f41807b == null) {
            this.f41807b = new p(this);
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                this.f41808c.registerReceiver(this.f41807b, intentFilter);
            } catch (Exception unused) {
                this.f41807b = null;
            }
            d1.a("\u6ce8\u518c\u7f51\u7edc\u72b6\u6001\u5e7f\u64ad\u63a5\u6536\u5668", new Object[0]);
        }
    }

    private void i() {
        if (this.f41810e) {
            return;
        }
        for (ApkDownloadTask apkDownloadTask : this.f41811f.d()) {
            if (!f41803i.contains(apkDownloadTask.r())) {
                this.f41811f.a(apkDownloadTask.t(), 0);
            }
        }
        this.f41810e = true;
    }

    private void j() {
        if (this.f41813h) {
            return;
        }
        this.f41813h = true;
        if (com.qq.e.comm.plugin.apkmanager.x.c.h()) {
            d0.f46410f.schedule(new a(), com.qq.e.comm.plugin.d0.a.d().f().a("rddt", 60), TimeUnit.SECONDS);
        }
    }

    private void k() {
        p pVar = this.f41807b;
        if (pVar != null) {
            this.f41808c.unregisterReceiver(pVar);
            this.f41807b = null;
            d1.a("\u53d6\u6d88\u7f51\u7edc\u72b6\u6001\u5e7f\u64ad\u63a5\u6536\u5668", new Object[0]);
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.p.a
    public void b() {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public IBinder onBind(Intent intent) {
        d1.a("OnBind ", new Object[0]);
        return new f(this, null);
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onCreate() {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onDestroy() {
        f41804j.clear();
        k();
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onLowMemory() {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onRebind(Intent intent) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public int onStartCommand(Intent intent, int i4, int i5) {
        if (intent == null) {
            return 2;
        }
        if (i.e(intent)) {
            j();
            return 2;
        } else if ("com.qq.e.comm.ACTION_DOWNLOAD_LIST".equals(intent.getAction())) {
            d();
            return 2;
        } else if (i.f(intent)) {
            i();
            return 2;
        } else {
            boolean c4 = i.c(intent);
            ApkDownloadTask a4 = ApkDownloadTask.a(i.b(intent));
            if (c4) {
                com.qq.e.comm.plugin.apkmanager.x.d.a(1100913, a4);
            }
            if (a4 == null) {
                if (c4) {
                    com.qq.e.comm.plugin.apkmanager.x.d.a(1100914, (Integer) 3, a4);
                }
                return 2;
            }
            String e4 = com.qq.e.comm.plugin.d0.a.d().b().e();
            String a5 = i.a(intent);
            if (!TextUtils.isEmpty(e4) && !TextUtils.isEmpty(a5) && !e4.equals(a5)) {
                com.qq.e.comm.plugin.apkmanager.x.d.a(2, e4 + "#" + a5);
            }
            if (com.qq.e.comm.plugin.apkmanager.w.d.e(com.qq.e.comm.plugin.apkmanager.w.b.a().d(this.f41808c, a4.r()))) {
                com.qq.e.comm.plugin.apkmanager.x.d.a(1100914, (Integer) 4, a4);
                return 2;
            }
            h();
            if (i.d(intent) && !this.f41809d.isEmpty()) {
                this.f41809d.remove(a4.s());
            }
            a(a4, intent);
            return 2;
        }
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onTaskRemoved(Intent intent) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public void onTrimMemory(int i4) {
    }

    @Override // com.qq.e.comm.pi.SVSD
    public boolean onUnbind(Intent intent) {
        return true;
    }

    private void b(ApkDownloadTask apkDownloadTask) {
        long c4 = apkDownloadTask.c("totalSize");
        com.qq.e.comm.plugin.o.a.a(String.format("\u60a8\u5df2\u4e0b\u8f7d\u7684\u201c%s\u201d\u672a\u4e0b\u8f7d\u5b8c\u6210%s\uff0c\u8981\u7ee7\u7eed\u4e0b\u8f7d\u5417", apkDownloadTask.p(), c4 > 0 ? String.format("\uff08\u6587\u4ef6\u5927\u5c0f%s\uff09", v1.c(c4)) : ""), "\u786e\u8ba4", "\u53d6\u6d88", new c(apkDownloadTask));
        v.a(1130032, (com.qq.e.comm.plugin.n0.c) null);
    }

    private void d() {
        Intent intent = new Intent();
        intent.setClassName(this.f41808c, q1.a());
        intent.putExtra("gdt_activity_delegate_name", com.qq.e.comm.plugin.a.DOWNLOAD_MANAGE);
        intent.putExtra("appid", com.qq.e.comm.plugin.d0.a.d().b().a());
        intent.addFlags(268435456);
        this.f41808c.startActivity(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f() {
        List<ApkDownloadTask> c4 = this.f41811f.c();
        if (c4 == null || c4.isEmpty()) {
            return;
        }
        if (com.qq.e.comm.plugin.d0.a.d().c().n() != com.qq.e.comm.plugin.d0.e.d.WIFI) {
            p0.a((Runnable) new b());
            return;
        }
        ApkDownloadTask apkDownloadTask = null;
        long currentTimeMillis = System.currentTimeMillis() - f41805k;
        for (ApkDownloadTask apkDownloadTask2 : c4) {
            if (apkDownloadTask2 != null && apkDownloadTask2.e() < this.f41812g && apkDownloadTask2.e() > currentTimeMillis && !f41803i.contains(apkDownloadTask2.r()) && (apkDownloadTask == null || apkDownloadTask.e() < apkDownloadTask2.e())) {
                apkDownloadTask = apkDownloadTask2;
            }
        }
        if (apkDownloadTask == null) {
            return;
        }
        apkDownloadTask.a(1);
        if (com.qq.e.comm.plugin.apkmanager.x.c.i()) {
            b(apkDownloadTask);
        } else {
            a(apkDownloadTask);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(ApkDownloadTask apkDownloadTask) {
        if (apkDownloadTask.o() != 0) {
            com.qq.e.comm.plugin.n0.w.b.b(4001005, apkDownloadTask, 3, 202);
        }
        a(apkDownloadTask, i.a(this.f41808c, apkDownloadTask));
    }

    private void a(ApkDownloadTask apkDownloadTask, Intent intent) {
        ReentrantLock a4 = a(apkDownloadTask.r());
        if (a4 != null && a4.isLocked()) {
            com.qq.e.comm.plugin.apkmanager.x.d.a(1100914, (Integer) 5, apkDownloadTask);
            d1.a("there is already a download worker running", new Object[0]);
            return;
        }
        f41803i.add(apkDownloadTask.r());
        new d(new m(this.f41808c, apkDownloadTask, intent, a4), new n(this.f41808c, apkDownloadTask), apkDownloadTask, apkDownloadTask, intent).b();
    }

    private ReentrantLock a(String str) {
        if (f41804j.containsKey(str)) {
            return f41804j.get(str);
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        f41804j.put(str, reentrantLock);
        return reentrantLock;
    }

    @Override // com.qq.e.comm.plugin.apkmanager.p.a
    public void a() {
        d0.f46406b.submit(new e());
        j();
    }
}
