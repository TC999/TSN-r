package com.qq.e.comm.plugin.apkmanager;

import android.content.Context;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f41765a;

    /* renamed from: b  reason: collision with root package name */
    private long f41766b;

    /* renamed from: c  reason: collision with root package name */
    private final long f41767c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements p.h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ File f41768a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f41769b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ InterfaceC0783d f41770c;

        /* compiled from: A */
        /* renamed from: com.qq.e.comm.plugin.apkmanager.d$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\2450172.dex */
        class RunnableC0782a implements Runnable {
            RunnableC0782a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                if (System.currentTimeMillis() - d.this.f41766b < 2000) {
                    d1.a("ApkReinstallManager", "\u524d\u53f0\u91cd\u8bd5\uff0c\u8ddd\u79bb\u4e0a\u6b21\u91cd\u8bd5\u5b89\u88c5\u65f6\u95f4\u5c0f\u4e8e2s\uff0c\u4e0d\u91cd\u8bd5");
                } else if (!a.this.f41768a.exists() || com.qq.e.comm.plugin.apkmanager.x.b.b(d.this.f41765a, a.this.f41769b)) {
                } else {
                    d.this.f41766b = System.currentTimeMillis();
                    com.qq.e.comm.plugin.n0.w.b.a(a.this.f41769b).f41948d = 7;
                    d1.a("ApkReinstallManager", "\u5f00\u59cb\u524d\u53f0\u91cd\u8bd5\u5b89\u88c5");
                    a.this.f41770c.a();
                }
            }
        }

        a(File file, String str, InterfaceC0783d interfaceC0783d) {
            this.f41768a = file;
            this.f41769b = str;
            this.f41770c = interfaceC0783d;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean b() {
            d0.f46410f.submit(new RunnableC0782a());
            return true;
        }

        @Override // com.qq.e.comm.plugin.util.p.h
        public boolean c() {
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ File f41773c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f41774d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ InterfaceC0783d f41775e;

        b(File file, String str, InterfaceC0783d interfaceC0783d) {
            this.f41773c = file;
            this.f41774d = str;
            this.f41775e = interfaceC0783d;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (System.currentTimeMillis() - d.this.f41766b < d.this.f41767c / 5) {
                d1.a("ApkReinstallManager", "\u5ef6\u8fdf\u91cd\u8bd5\uff0c\u8ddd\u79bb\u4e0a\u6b21\u91cd\u8bd5\u5b89\u88c5\u65f6\u95f4\u5c0f\u4e8e" + (d.this.f41767c / 5000) + "\u79d2\uff0c\u4e0d\u91cd\u8bd5");
            } else if (this.f41773c.exists() && com.qq.e.comm.plugin.util.p.b().c() && !com.qq.e.comm.plugin.apkmanager.x.b.b(d.this.f41765a, this.f41774d)) {
                d.this.f41766b = System.currentTimeMillis();
                com.qq.e.comm.plugin.n0.w.b.a(this.f41774d).f41948d = 6;
                d1.a("ApkReinstallManager", "\u5f00\u59cb\u5ef6\u8fdf\u91cd\u8bd5");
                this.f41775e.a();
            } else {
                d1.a("ApkReinstallManager", "\u5ef6\u8fdf\u91cd\u8bd5\uff0c\u5e94\u7528\u4e0d\u5728\u524d\u53f0\u6216\u5df2\u5b89\u88c5\uff0c\u4e0d\u91cd\u8bd5");
            }
        }
    }

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private static final d f41777a = new d(null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.apkmanager.d$d  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public interface InterfaceC0783d {
        void a();
    }

    /* synthetic */ d(a aVar) {
        this();
    }

    private d() {
        this.f41765a = com.qq.e.comm.plugin.d0.a.d().a();
        this.f41767c = com.qq.e.comm.plugin.d0.a.d().f().a("rtiad", 60) * 1000;
    }

    private void b(File file, String str, InterfaceC0783d interfaceC0783d) {
        if (!com.qq.e.comm.plugin.apkmanager.x.c.g()) {
            d1.a("ApkReinstallManager", "\u524d\u53f0\u91cd\u8bd5\u5f00\u5173\u672a\u6253\u5f00");
        } else {
            com.qq.e.comm.plugin.util.p.b().a(new a(file, str, interfaceC0783d));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static d a() {
        return c.f41777a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(File file, String str, boolean z3, InterfaceC0783d interfaceC0783d) {
        if (interfaceC0783d == null) {
            return;
        }
        if (z3) {
            a(file, str, interfaceC0783d);
        }
        if (com.qq.e.comm.plugin.util.p.b().c()) {
            return;
        }
        b(file, str, interfaceC0783d);
    }

    private void a(File file, String str, InterfaceC0783d interfaceC0783d) {
        if (!com.qq.e.comm.plugin.apkmanager.x.c.f()) {
            d1.a("ApkReinstallManager", "\u5ef6\u8fdf\u91cd\u8bd5\u5f00\u5173\u672a\u6253\u5f00");
        } else {
            d0.f46410f.schedule(new b(file, str, interfaceC0783d), this.f41767c, TimeUnit.MILLISECONDS);
        }
    }
}
