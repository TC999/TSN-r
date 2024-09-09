package com.qq.e.comm.plugin.apkmanager;

import com.qq.e.comm.plugin.util.d0;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public final class b {

    /* renamed from: c  reason: collision with root package name */
    private static final long f41758c = com.qq.e.comm.plugin.d0.a.d().f().a("cimt", 64) * 1000;

    /* renamed from: d  reason: collision with root package name */
    private static final boolean f41759d;

    /* renamed from: a  reason: collision with root package name */
    private final InterfaceC0781b f41760a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Long> f41761b = new ConcurrentHashMap();

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        private final String f41762c;

        /* renamed from: d  reason: collision with root package name */
        private final long f41763d;

        public a(String str, long j4) {
            this.f41762c = str;
            this.f41763d = j4;
        }

        private long a() {
            Long l4 = (Long) b.this.f41761b.get(this.f41762c);
            Long valueOf = Long.valueOf(l4 == null ? this.f41763d : l4.longValue());
            if (valueOf.longValue() > b.f41758c) {
                return -1L;
            }
            return valueOf.longValue() * 2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ApkDownloadTask apkDownloadTask = new ApkDownloadTask(this.f41762c);
            if (b.this.f41760a != null && b.this.f41760a.c(this.f41762c)) {
                if (com.qq.e.comm.plugin.m0.b.a("hieib") && !b.f41759d && !com.qq.e.comm.plugin.util.p.b().c()) {
                    com.qq.e.comm.plugin.apkmanager.x.d.b(1100918, apkDownloadTask, 4);
                    b.this.f41761b.remove(this.f41762c);
                    return;
                } else if (com.qq.e.comm.plugin.apkmanager.w.d.f(com.qq.e.comm.plugin.apkmanager.w.b.a().d(com.qq.e.comm.plugin.d0.a.d().a(), this.f41762c))) {
                    b.this.f41760a.a(this.f41762c);
                    com.qq.e.comm.plugin.apkmanager.x.d.b(1100918, apkDownloadTask, 2);
                    b.this.f41761b.remove(this.f41762c);
                    return;
                } else {
                    long a4 = a();
                    if (a4 > 0) {
                        b.this.a(this.f41762c, a4);
                        return;
                    }
                    com.qq.e.comm.plugin.apkmanager.x.d.b(1100918, apkDownloadTask, 3);
                    b.this.f41761b.remove(this.f41762c);
                    return;
                }
            }
            com.qq.e.comm.plugin.apkmanager.x.d.b(1100918, apkDownloadTask, 1);
            b.this.f41761b.remove(this.f41762c);
        }
    }

    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.apkmanager.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    interface InterfaceC0781b {
        void a(String str);

        boolean c(String str);
    }

    static {
        f41759d = com.qq.e.comm.plugin.d0.a.d().f().a("aicwibg", 1) == 1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(InterfaceC0781b interfaceC0781b) {
        this.f41760a = interfaceC0781b;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public synchronized void a(String str) {
        if (this.f41761b.get(str) == null) {
            a(str, 2000L);
        }
        this.f41761b.put(str, 2000L);
        com.qq.e.comm.plugin.apkmanager.x.d.b(1100919, new ApkDownloadTask(str), 0);
    }

    synchronized void a(String str, long j4) {
        d0.f46410f.schedule(new a(str, j4), j4, TimeUnit.MILLISECONDS);
    }
}
