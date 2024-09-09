package com.qq.e.comm.plugin.apkmanager;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    private final Context f41872a;

    /* renamed from: b  reason: collision with root package name */
    private volatile ScheduledFuture f41873b;

    /* renamed from: c  reason: collision with root package name */
    private long f41874c;

    /* renamed from: d  reason: collision with root package name */
    private final long f41875d;

    /* renamed from: e  reason: collision with root package name */
    private AtomicBoolean f41876e;

    /* renamed from: f  reason: collision with root package name */
    private final long f41877f;

    /* renamed from: g  reason: collision with root package name */
    private final int f41878g;

    /* renamed from: h  reason: collision with root package name */
    private int f41879h;

    /* renamed from: i  reason: collision with root package name */
    private final int f41880i;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ d f41881c;

        a(d dVar) {
            this.f41881c = dVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - r.this.f41874c >= r.this.f41877f) {
                if (r.this.a(this.f41881c, true)) {
                    r.this.a(2);
                    d1.b("JumpUnknownSourceManager", "\u8f6e\u8be2\u6388\u6743\u72b6\u6001\u5df2\u8d85\u65f6,\u8d85\u65f6\u65f6\u95f4\u4e3a" + (r.this.f41877f / 1000) + "\u79d2");
                }
            } else if (com.qq.e.comm.plugin.apkmanager.x.e.b() && r.this.a(this.f41881c, true)) {
                r.this.a(3);
                d1.b("JumpUnknownSourceManager", "\u8f6e\u8be2\u6388\u6743\u72b6\u6001,\u7528\u6237\u5df2\u6388\u6743");
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements p.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f41883a;

        /* compiled from: A */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class a implements Runnable {
            a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                b bVar = b.this;
                if (r.this.a(bVar.f41883a, true)) {
                    if (com.qq.e.comm.plugin.apkmanager.x.e.b()) {
                        r.this.a(3);
                    } else {
                        r.this.a(4);
                    }
                    d1.b("JumpUnknownSourceManager", "\u5e94\u7528\u56de\u5230\u524d\u53f0");
                }
            }
        }

        b(d dVar) {
            this.f41883a = dVar;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean b() {
            d0.f46410f.submit(new a());
            return true;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean c() {
            return false;
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public static class c {

        /* renamed from: a  reason: collision with root package name */
        private static final r f41886a = new r(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface d {
        void a(boolean z3);
    }

    /* synthetic */ r(a aVar) {
        this();
    }

    public void c(d dVar) {
        if (dVar == null) {
            return;
        }
        if (this.f41879h < this.f41878g && this.f41876e.get() && System.currentTimeMillis() - this.f41874c >= this.f41875d && com.qq.e.comm.plugin.util.p.b().c() && !com.qq.e.comm.plugin.apkmanager.x.e.c() && ((this.f41880i != 1 || com.qq.e.comm.plugin.apkmanager.x.d.d()) && (this.f41880i != 2 || com.qq.e.comm.plugin.apkmanager.x.d.e()))) {
            this.f41876e.set(false);
            try {
                a(0);
                b();
                this.f41879h++;
                b(dVar);
                a(dVar);
                return;
            } catch (Exception unused) {
                this.f41879h = this.f41878g;
                a(dVar, false);
                a(1);
                return;
            }
        }
        dVar.a(false);
    }

    private r() {
        this.f41876e = new AtomicBoolean(true);
        this.f41879h = 0;
        this.f41872a = com.qq.e.comm.plugin.d0.a.d().a();
        this.f41878g = com.qq.e.comm.plugin.apkmanager.x.c.b();
        com.qq.e.comm.plugin.d0.d.h f4 = com.qq.e.comm.plugin.d0.a.d().f();
        this.f41875d = f4.a("jusmi", 1200) * 1000;
        this.f41877f = f4.a("jusqt", 20) * 1000;
        this.f41880i = f4.a("jusres", 0);
    }

    private void b(d dVar) {
        this.f41874c = System.currentTimeMillis();
        this.f41873b = d0.f46410f.scheduleAtFixedRate(new a(dVar), 1000L, 1000L, TimeUnit.MILLISECONDS);
    }

    public static r a() {
        return c.f41886a;
    }

    private void b() {
        Intent intent = new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + this.f41872a.getPackageName()));
        intent.addFlags(1073741824);
        intent.addFlags(8388608);
        intent.addFlags(268435456);
        this.f41872a.startActivity(intent);
    }

    private void a(d dVar) {
        com.qq.e.comm.plugin.util.p.b().a(new b(dVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i4) {
        v.a(9120018, null, Integer.valueOf(i4));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(d dVar, boolean z3) {
        if (this.f41873b != null) {
            this.f41873b.cancel(true);
            this.f41873b = null;
        }
        if (!com.qq.e.comm.plugin.util.p.b().c()) {
            com.qq.e.comm.plugin.util.k.a();
        }
        if (this.f41876e.compareAndSet(false, true)) {
            dVar.a(z3);
            return true;
        }
        return false;
    }
}
