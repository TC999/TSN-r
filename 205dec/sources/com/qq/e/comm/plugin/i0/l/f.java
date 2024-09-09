package com.qq.e.comm.plugin.i0.l;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class f {

    /* renamed from: l  reason: collision with root package name */
    private static final String f44274l = "f";

    /* renamed from: m  reason: collision with root package name */
    private static volatile f f44275m;

    /* renamed from: c  reason: collision with root package name */
    private Handler f44278c;

    /* renamed from: e  reason: collision with root package name */
    private volatile String f44280e;

    /* renamed from: g  reason: collision with root package name */
    private volatile long f44282g;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicBoolean f44276a = new AtomicBoolean(false);

    /* renamed from: b  reason: collision with root package name */
    private final AtomicBoolean f44277b = new AtomicBoolean(true);

    /* renamed from: d  reason: collision with root package name */
    private final List<String> f44279d = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    private volatile int f44281f = -1;

    /* renamed from: h  reason: collision with root package name */
    private volatile int f44283h = -1;

    /* renamed from: i  reason: collision with root package name */
    private volatile int f44284i = -1;

    /* renamed from: j  reason: collision with root package name */
    private volatile int f44285j = -1;

    /* renamed from: k  reason: collision with root package name */
    private final Runnable f44286k = new b();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a extends BroadcastReceiver {
        a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            f.this.o();
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f.this.r();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class c implements Runnable {
        c() {
        }

        @Override // java.lang.Runnable
        public void run() {
            f fVar = f.this;
            fVar.b(fVar.f44277b.compareAndSet(true, false));
            int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("prhi", 2000);
            if (a4 > 0) {
                int e4 = f.this.e();
                if (e4 > 2) {
                    a4 = e4 * 1000;
                }
                if (f.this.f44278c != null) {
                    f.this.f44278c.postDelayed(f.this.f44286k, a4);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class d implements Runnable {
        d(f fVar) {
        }

        @Override // java.lang.Runnable
        public void run() {
            com.qq.e.comm.plugin.i0.l.a.b().a(false);
        }
    }

    private f() {
    }

    private boolean i() {
        return pro.getZresult(218, 0, this);
    }

    private boolean j() {
        return pro.getZresult(219, 0, this);
    }

    private void k() {
        boolean i4;
        if (Build.VERSION.SDK_INT >= 24) {
            i4 = j();
        } else {
            i4 = i();
        }
        if (i4) {
            if (com.qq.e.comm.plugin.d0.a.d().f().a("sisdc", 1) > 0) {
                com.qq.e.comm.plugin.i0.l.a.b().a(true);
            } else {
                d0.f46406b.submit(new d(this));
            }
            s();
        }
    }

    private void l() {
        String b4 = com.qq.e.comm.plugin.d0.a.d().f().b("prh", "mi.gdt.qq.com,v2.gdt.qq.com,c2.gdt.qq.com,pgdt.ugdtimg.com,adsmind.ugdtimg.com,qzs.gdtimg.com");
        if (TextUtils.isEmpty(b4)) {
            return;
        }
        this.f44279d.clear();
        this.f44279d.addAll(Arrays.asList(b4.split(",")));
        this.f44280e = b4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        d1.a(f44274l, "network changed");
        try {
            this.f44278c.removeCallbacksAndMessages(null);
            if (m()) {
                this.f44277b.set(true);
                int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("hdrnit", 0);
                if (a4 > 0) {
                    this.f44278c.postDelayed(this.f44286k, a4);
                } else {
                    this.f44278c.post(this.f44286k);
                }
            }
        } catch (Exception e4) {
            String str = f44274l;
            d1.a(str, "get network state exception " + e4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r() {
        d0.f46407c.submit(new c());
    }

    private void s() {
        v.a(9130075, null, 1, null, null);
    }

    public int f() {
        if (e() == 1 && b() == 1) {
            return 1;
        }
        if (e() > 1) {
            if (b() == 1) {
                return 2;
            }
            if (b() == 2) {
                return 3;
            }
            if (b() == 3) {
                return 4;
            }
            return b() == 4 ? 5 : 0;
        }
        return 0;
    }

    public List<String> g() {
        return this.f44279d;
    }

    public String h() {
        return this.f44280e;
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x0039 -> B:17:0x003a). Please submit an issue!!! */
    public boolean m() {
        NetworkCapabilities networkCapabilities;
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) com.qq.e.comm.plugin.d0.a.d().a().getSystemService("connectivity");
            if (connectivityManager != null) {
                if (Build.VERSION.SDK_INT < 23) {
                    NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
                    if (activeNetworkInfo != null) {
                        return activeNetworkInfo.isConnected();
                    }
                } else {
                    Network activeNetwork = connectivityManager.getActiveNetwork();
                    if (activeNetwork != null && (networkCapabilities = connectivityManager.getNetworkCapabilities(activeNetwork)) != null && networkCapabilities.hasCapability(16)) {
                        return true;
                    }
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public boolean n() {
        if (this.f44281f < 0) {
            int a4 = com.qq.e.comm.plugin.d0.a.d().f().a("hdlur", 10);
            if (a4 <= 0) {
                this.f44281f = 1;
            } else {
                double nextDouble = new Random(System.currentTimeMillis()).nextDouble();
                double d4 = a4;
                Double.isNaN(d4);
                this.f44281f = nextDouble < d4 * 0.001d ? 1 : 0;
            }
        }
        return this.f44281f > 0;
    }

    public void p() {
        if (this.f44278c == null && e() > 1 && this.f44276a.compareAndSet(false, true)) {
            String str = f44274l;
            d1.a(str, "init prefetch DNS " + e());
            l();
            if (b() > 1 || t()) {
                if (b() == 4) {
                    a();
                }
                k();
                if (b() > 1 && this.f44277b.get()) {
                    a(false);
                }
            }
            this.f44278c = new Handler(Looper.getMainLooper());
            r();
            a(com.qq.e.comm.plugin.d0.a.d().a());
        }
    }

    public void q() {
        if (this.f44278c == null || SystemClock.elapsedRealtime() - this.f44282g <= 1000) {
            return;
        }
        this.f44278c.post(this.f44286k);
        this.f44282g = SystemClock.elapsedRealtime();
    }

    public boolean t() {
        if (this.f44285j < 0) {
            this.f44285j = com.qq.e.comm.plugin.d0.a.d().f().a("pdhlc", 1);
        }
        return this.f44285j > 0;
    }

    public static f c() {
        if (f44275m == null) {
            synchronized (f.class) {
                if (f44275m == null) {
                    f44275m = new f();
                }
            }
        }
        return f44275m;
    }

    public int b() {
        if (this.f44284i < 0) {
            this.f44284i = com.qq.e.comm.plugin.t.c.a("htph", "APP", "", 0);
        }
        return this.f44284i;
    }

    public int d() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("dphl", 10) * 60;
    }

    public int e() {
        if (this.f44283h < 0) {
            this.f44283h = com.qq.e.comm.plugin.t.c.a("prhs", "APP", "", 0);
        }
        return this.f44283h;
    }

    private void a(Context context) {
        try {
            context.getApplicationContext().registerReceiver(new a(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        } catch (Throwable unused) {
        }
    }

    private void a(long j4, int i4) {
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(9920001);
        hVar.b(j4);
        hVar.b((f() * 100) + i4);
        v.a(hVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z3) {
        String str = f44274l;
        d1.a(str, "is first prefetch " + z3);
        for (int i4 = 0; i4 < this.f44279d.size(); i4++) {
            try {
                String str2 = this.f44279d.get(i4);
                String str3 = f44274l;
                d1.a(str3, "start parse " + str2);
                long elapsedRealtime = SystemClock.elapsedRealtime();
                InetAddress[] allByName = InetAddress.getAllByName(str2);
                String str4 = f44274l;
                d1.a(str4, "parse " + str2 + " cost " + (SystemClock.elapsedRealtime() - elapsedRealtime));
                if (allByName != null && allByName.length > 0 && z3) {
                    a(SystemClock.elapsedRealtime() - elapsedRealtime, i4 + 1);
                }
            } catch (Exception e4) {
                d1.a(f44274l, e4.toString());
            }
        }
    }

    private void a() {
        this.f44279d.add("doh.pub");
        this.f44279d.add("dns.alidns.com");
    }

    public void a(boolean z3) {
        int b4 = b();
        if (b4 == 2) {
            j.a().a(h(), z3);
        } else if (b4 == 3) {
            i.a().a(g(), z3);
        } else if (b4 == 4) {
            e.a().a(g(), z3);
        }
    }

    private void a(String str) {
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("data", str);
        v.a(9130075, null, 2, 1, dVar);
    }

    private void a(Exception exc) {
        d1.a(f44274l, exc.toString());
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("data", Log.getStackTraceString(exc));
        v.a(9130075, null, 2, 2, dVar);
    }
}
