package com.qq.e.comm.plugin.apkmanager;

import android.content.Context;
import android.content.Intent;
import android.database.SQLException;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Pair;
import com.qq.e.comm.plugin.apkmanager.a;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.p.c;
import com.qq.e.comm.plugin.util.b1;
import com.qq.e.comm.plugin.util.d0;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.i2;
import com.qq.e.comm.plugin.util.p1;
import com.qq.e.comm.plugin.util.y;
import java.io.File;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class m implements com.qq.e.comm.plugin.apkmanager.a {

    /* renamed from: c  reason: collision with root package name */
    private final Context f41823c;

    /* renamed from: d  reason: collision with root package name */
    private final h f41824d;

    /* renamed from: e  reason: collision with root package name */
    private final com.qq.e.comm.plugin.apkmanager.v.b f41825e;

    /* renamed from: f  reason: collision with root package name */
    private a.InterfaceC0780a f41826f;

    /* renamed from: g  reason: collision with root package name */
    private final ApkDownloadTask f41827g;

    /* renamed from: h  reason: collision with root package name */
    private final Intent f41828h;

    /* renamed from: i  reason: collision with root package name */
    private final Lock f41829i;

    /* renamed from: j  reason: collision with root package name */
    private Future<Bitmap> f41830j;

    /* renamed from: k  reason: collision with root package name */
    private com.qq.e.comm.plugin.apkmanager.u.d f41831k;

    /* renamed from: l  reason: collision with root package name */
    private com.qq.e.comm.plugin.apkmanager.w.a f41832l;

    /* renamed from: m  reason: collision with root package name */
    private long f41833m = 0;

    /* renamed from: n  reason: collision with root package name */
    private com.qq.e.comm.plugin.d0.e.d f41834n;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements com.qq.e.comm.plugin.apkmanager.w.a {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f41835c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.p.f f41836d;

        a(m mVar, String str, com.qq.e.comm.plugin.p.f fVar) {
            this.f41835c = str;
            this.f41836d = fVar;
        }

        @Override // com.qq.e.comm.plugin.apkmanager.w.a
        public void a(String str, int i4, int i5, long j4) {
            if (TextUtils.isEmpty(this.f41835c) || !this.f41835c.equals(str)) {
                return;
            }
            if (i4 == 32) {
                this.f41836d.pause();
            } else if (i4 == 64) {
                this.f41836d.cancel();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class b implements com.qq.e.comm.plugin.p.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ String f41837a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ApkDownloadTask f41838b;

        b(String str, ApkDownloadTask apkDownloadTask) {
            this.f41837a = str;
            this.f41838b = apkDownloadTask;
        }

        @Override // com.qq.e.comm.plugin.p.g
        public void a(long j4, long j5) {
            m.this.a(j4, j5);
            int i4 = j5 <= 0 ? 0 : (int) ((100 * j4) / j5);
            if (com.qq.e.comm.plugin.apkmanager.w.b.a().a(m.this.f41823c, this.f41837a, false) == 128) {
                com.qq.e.comm.plugin.apkmanager.w.b.a().a(this.f41838b.r(), 4);
            }
            com.qq.e.comm.plugin.apkmanager.w.b.a().a(this.f41838b.r(), i4, j5);
            this.f41838b.a("progress", i4);
            if (m.this.f41833m == 0) {
                m.this.f41833m = j5;
                this.f41838b.a("totalSize", j5);
                m.this.c(this.f41838b);
            }
            m.this.b(j4, j5);
        }
    }

    public m(Context context, ApkDownloadTask apkDownloadTask, Intent intent, Lock lock) {
        this.f41823c = context;
        com.qq.e.comm.plugin.d0.e.d n4 = com.qq.e.comm.plugin.d0.a.d().c().n();
        this.f41834n = n4;
        this.f41824d = new h(n4);
        this.f41825e = new com.qq.e.comm.plugin.apkmanager.v.a();
        this.f41827g = apkDownloadTask;
        this.f41828h = intent;
        a();
        this.f41829i = lock;
    }

    private int b(int i4) {
        if (i4 != 4) {
            if (i4 != 5) {
                return i4 != 6 ? 0 : 2048;
            }
            return 1024;
        }
        return 4096;
    }

    private int c() {
        return com.qq.e.comm.plugin.d0.a.d().f().a("airmsv", 0);
    }

    private int d(ApkDownloadTask apkDownloadTask) {
        if (apkDownloadTask.x()) {
            if (!this.f41825e.a(apkDownloadTask)) {
                return !this.f41825e.b(apkDownloadTask) ? 3 : 0;
            }
            e(apkDownloadTask);
            return 2;
        }
        return 0;
    }

    private int e() {
        File a4 = b1.a();
        if (a4 == null) {
            return 5;
        }
        return (a4.exists() || a4.mkdirs()) ? 0 : 6;
    }

    private void f() {
        Future<Bitmap> future = this.f41830j;
        if (future == null || !future.isDone()) {
            return;
        }
        try {
            this.f41827g.a(this.f41830j.get());
        } catch (Exception unused) {
        }
    }

    @Override // java.lang.Runnable
    public void run() {
        b(this.f41827g);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ApkDownloadTask apkDownloadTask) {
        try {
            s a4 = s.a(this.f41823c);
            ApkDownloadTask a5 = a4.a(apkDownloadTask.r());
            if (a5 != null) {
                apkDownloadTask.d(a5.t());
                a4.c(apkDownloadTask);
            } else {
                a4.a(apkDownloadTask);
            }
        } catch (SQLException unused) {
        }
    }

    private void b(ApkDownloadTask apkDownloadTask) {
        try {
            this.f41829i.lockInterruptibly();
            d1.a("download start", new Object[0]);
            com.qq.e.comm.plugin.apkmanager.x.d.a(1100902, this.f41827g);
            a(apkDownloadTask);
            d1.a("download stop", new Object[0]);
            this.f41829i.unlock();
        } catch (Throwable th) {
            try {
                a(1, th.getMessage());
                d1.a("download stop", new Object[0]);
                this.f41829i.unlock();
            } catch (Throwable th2) {
                d1.a("download stop", new Object[0]);
                this.f41829i.unlock();
                throw th2;
            }
        }
    }

    private void f(ApkDownloadTask apkDownloadTask) {
        apkDownloadTask.a("progress", 0);
        com.qq.e.comm.plugin.apkmanager.w.b.a().a(apkDownloadTask.r(), 0, 0L);
        com.qq.e.comm.plugin.apkmanager.w.b.a().a(apkDownloadTask.r(), 0);
        d1.a("reset progress", new Object[0]);
    }

    private void a() {
        com.qq.e.comm.plugin.apkmanager.u.a aVar = new com.qq.e.comm.plugin.apkmanager.u.a(this.f41823c, this.f41827g);
        this.f41831k = aVar;
        aVar.a(new com.qq.e.comm.plugin.apkmanager.u.b(this.f41828h, this.f41827g, this.f41823c));
    }

    private void e(ApkDownloadTask apkDownloadTask) {
        try {
            s.a(this.f41823c).b(apkDownloadTask);
        } catch (SQLException unused) {
        }
    }

    private void d(int i4) {
        a.InterfaceC0780a interfaceC0780a = this.f41826f;
        if (interfaceC0780a != null) {
            interfaceC0780a.onStatusChanged(i4);
        }
    }

    @Override // com.qq.e.comm.plugin.apkmanager.a
    public void a(a.InterfaceC0780a interfaceC0780a) {
        this.f41826f = interfaceC0780a;
    }

    private void a(ApkDownloadTask apkDownloadTask) {
        com.qq.e.comm.plugin.p.f b4;
        File file;
        int i4;
        String str;
        int i5;
        int i6;
        ApkDownloadTask apkDownloadTask2;
        int i7;
        ApkDownloadTask apkDownloadTask3 = apkDownloadTask;
        d(1);
        int d4 = d(apkDownloadTask);
        if (d4 != 0) {
            a(d4, "");
            return;
        }
        int e4 = e();
        if (e4 != 0) {
            c(b(e4));
            a(e4, "");
            return;
        }
        File b5 = com.qq.e.comm.plugin.apkmanager.x.b.b(apkDownloadTask);
        if (b5 == null) {
            c(b(4));
            a(e4, "");
            return;
        }
        d(2);
        int a4 = a(b5, apkDownloadTask3);
        int i8 = 0;
        d1.a("check apk file result:" + a4, new Object[0]);
        if (a4 != 0) {
            a(a4, "", b5);
            return;
        }
        boolean z3 = false;
        int i9 = 0;
        while (true) {
            d(4);
            d();
            f.a(b5);
            b4 = b(apkDownloadTask3, b5);
            if (!z3) {
                com.qq.e.comm.plugin.apkmanager.x.d.a(apkDownloadTask3, 1100936, b4.h(), this.f41834n.a(), new com.qq.e.comm.plugin.n0.d().a("data2", Integer.valueOf(this.f41824d.f41790b)));
            }
            b4.g();
            int b6 = b4.b();
            a(b4, apkDownloadTask3);
            d1.a("download code:" + b6 + ",download message:" + b4.a(), new Object[i8]);
            String a5 = b4.a();
            long d5 = b4.d() * 2;
            if (b6 == 0) {
                d(6);
                boolean a6 = f.a(apkDownloadTask3, b4, b5);
                Pair<Integer, String> b7 = com.qq.e.comm.plugin.apkmanager.x.b.b(b5, apkDownloadTask.r(), this.f41823c);
                if (((Integer) b7.first).intValue() == 0) {
                    f();
                    z3 = false;
                    i7 = 0;
                } else {
                    if (b5.exists()) {
                        b5.delete();
                    }
                    z3 = !z3 && (c() & ((Integer) b7.first).intValue()) > 0;
                    b6 = 8;
                    a5 = "code=" + b7.first + ";" + ((String) b7.second) + ";" + b4.getContentType();
                    if (a6) {
                        com.qq.e.comm.plugin.apkmanager.x.d.a(apkDownloadTask3, ((Integer) b7.first).intValue(), a5);
                    }
                    i7 = 12;
                }
                i4 = b6;
                str = a5;
                i5 = i7;
                file = b5;
            } else if (com.qq.e.comm.plugin.p.e.d(b6)) {
                i4 = b6;
                str = a5;
                file = b5;
                z3 = false;
                i5 = 11;
            } else if (com.qq.e.comm.plugin.p.e.e(b6)) {
                i4 = b6;
                str = a5;
                file = b5;
                z3 = false;
                i5 = 13;
            } else {
                file = b5;
                if (com.qq.e.comm.plugin.p.e.b(b6)) {
                    long a7 = y.a();
                    if (d5 > a7) {
                        p1 p1Var = new p1();
                        long c4 = p1Var.c();
                        if (z3 || c4 + a7 <= d5 || (c() & 16) <= 0) {
                            z3 = false;
                        } else {
                            p1Var.a(d5);
                            z3 = true;
                        }
                        i4 = b6;
                        str = a5 + "[\u5927\u5c0f\u4fe1\u606f:" + b4.d() + " " + a7 + " " + c4 + "]";
                        i5 = 14;
                    }
                }
                z3 = !z3 && com.qq.e.comm.plugin.p.e.f(b6) && (c() & 32) > 0;
                i4 = b6;
                str = a5;
                i5 = 10;
            }
            i6 = z3 ? i5 : i9;
            if (!z3) {
                break;
            }
            apkDownloadTask3 = apkDownloadTask;
            i9 = i6;
            b5 = file;
            i8 = 0;
        }
        d(7);
        if (i6 != 0) {
            com.qq.e.comm.plugin.apkmanager.x.d.b(apkDownloadTask, i5, i6, str, b4.i());
        }
        if (i5 != 0) {
            apkDownloadTask2 = apkDownloadTask;
            apkDownloadTask2.f(String.format("[%d]%s", Integer.valueOf(i4), str));
            com.qq.e.comm.plugin.apkmanager.x.d.a(apkDownloadTask, i4, i5, str, b4.i());
        } else {
            apkDownloadTask2 = apkDownloadTask;
        }
        c(i4);
        a(apkDownloadTask2, i4);
        a(i5, str, file);
    }

    private void c(int i4) {
        if (i4 == 0) {
            b().a();
        } else if (com.qq.e.comm.plugin.p.e.a(i4)) {
        } else {
            if (!com.qq.e.comm.plugin.p.e.e(i4) && !com.qq.e.comm.plugin.p.e.c(i4)) {
                b().a(a(i4));
            } else {
                b().b(a(i4));
            }
        }
    }

    private void d() {
        b().start();
    }

    private com.qq.e.comm.plugin.p.f b(ApkDownloadTask apkDownloadTask, File file) {
        String r3 = apkDownloadTask.r();
        com.qq.e.comm.plugin.p.f a4 = a(apkDownloadTask, file);
        if (this.f41832l != null) {
            com.qq.e.comm.plugin.apkmanager.w.b.a().b(r3, this.f41832l);
        }
        this.f41832l = new a(this, r3, a4);
        com.qq.e.comm.plugin.apkmanager.w.b.a().a(r3, this.f41832l);
        a4.a(new b(r3, apkDownloadTask));
        return a4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(long j4, long j5) {
        a.InterfaceC0780a interfaceC0780a = this.f41826f;
        if (interfaceC0780a != null) {
            interfaceC0780a.a(j4, j5);
        }
    }

    private com.qq.e.comm.plugin.apkmanager.u.d b() {
        if (this.f41830j == null && !TextUtils.isEmpty(this.f41827g.k())) {
            Future<Bitmap> submit = d0.f46406b.submit(new g(this.f41827g.k()));
            this.f41830j = submit;
            this.f41831k.a(submit);
        }
        return this.f41831k;
    }

    private void a(com.qq.e.comm.plugin.p.f fVar, ApkDownloadTask apkDownloadTask) {
        if (fVar.b() != 0 || fVar.i() == 0 || fVar.f() == 0) {
            return;
        }
        com.qq.e.comm.plugin.n0.e eVar = new com.qq.e.comm.plugin.n0.e(10000001);
        int i4 = (int) ((fVar.i() * 1000) / (fVar.f() * 1024));
        eVar.c(i4);
        eVar.a(com.qq.e.comm.plugin.n0.c.a(apkDownloadTask.v()));
        eVar.d(fVar.h());
        com.qq.e.comm.plugin.edgeanalytics.b.c().a(eVar, false);
        com.qq.e.comm.plugin.edgeanalytics.b.c().e(com.qq.e.comm.plugin.edgeanalytics.d.a());
        com.qq.e.comm.plugin.n0.d dVar = new com.qq.e.comm.plugin.n0.d();
        dVar.a("data2", Integer.valueOf(this.f41824d.f41790b));
        dVar.a("data", Integer.valueOf(i4));
        if (fVar.c() != null) {
            dVar.a("msg", fVar.c().toString());
        }
        com.qq.e.comm.plugin.apkmanager.x.d.a(apkDownloadTask, 1100935, fVar.h(), this.f41834n.a(), dVar);
        com.qq.e.comm.plugin.n0.h hVar = new com.qq.e.comm.plugin.n0.h(this.f41834n.equals(com.qq.e.comm.plugin.d0.e.d.WIFI) ? 2130103 : 2130104);
        hVar.b(i4).b(fVar.h());
        v.a(hVar);
    }

    private com.qq.e.comm.plugin.p.f a(ApkDownloadTask apkDownloadTask, File file) {
        com.qq.e.comm.plugin.p.j.f fVar = new com.qq.e.comm.plugin.p.j.f(apkDownloadTask.s(), file, this.f41824d.a(), new c.b().a(d0.f46406b).a(), false, com.qq.e.comm.plugin.apkmanager.x.c.e());
        fVar.c(true);
        return new com.qq.e.comm.plugin.p.i.a(fVar, new com.qq.e.comm.plugin.p.i.b(apkDownloadTask.d()));
    }

    private int a(File file, ApkDownloadTask apkDownloadTask) {
        int d4 = com.qq.e.comm.plugin.apkmanager.w.b.a().d(this.f41823c, apkDownloadTask.r());
        d1.a("check apk status:" + d4, new Object[0]);
        if (file.exists()) {
            if (com.qq.e.comm.plugin.apkmanager.x.b.a(file, apkDownloadTask.r(), this.f41823c)) {
                ApkDownloadTask a4 = s.a(this.f41823c).a(apkDownloadTask.r());
                long c4 = a4 == null ? 0L : a4.c("totalSize");
                long length = file.length();
                if (c4 > 0 && c4 != length) {
                    com.qq.e.comm.plugin.apkmanager.x.d.a(a4, c4, length);
                }
                d1.a("apk exist and valid", new Object[0]);
                com.qq.e.comm.plugin.apkmanager.w.b.a().a(apkDownloadTask.r(), 8);
            } else {
                file.delete();
                f(apkDownloadTask);
            }
        } else if (com.qq.e.comm.plugin.apkmanager.w.d.d(d4)) {
            f(apkDownloadTask);
        }
        int d5 = com.qq.e.comm.plugin.apkmanager.w.b.a().d(this.f41823c, apkDownloadTask.r());
        d1.a("after check status is:" + d5 + " " + apkDownloadTask.o(), new Object[0]);
        if (com.qq.e.comm.plugin.apkmanager.w.d.f(d5)) {
            return 7;
        }
        if (com.qq.e.comm.plugin.apkmanager.w.d.e(d5)) {
            return 8;
        }
        if (com.qq.e.comm.plugin.apkmanager.w.d.d(d5)) {
            return 9;
        }
        s a5 = s.a(this.f41823c);
        ApkDownloadTask a6 = a5.a(apkDownloadTask.r());
        a(a6, apkDownloadTask, file);
        if (d5 == 0) {
            d(3);
            d1.a("reset download task progress and total", new Object[0]);
            apkDownloadTask.a("progress", 0);
            com.qq.e.comm.plugin.apkmanager.w.b.a().b(apkDownloadTask.r());
            if (a6 != null && com.qq.e.comm.plugin.apkmanager.x.b.c(apkDownloadTask)) {
                com.qq.e.comm.plugin.n0.w.b.b(4001005, apkDownloadTask, 1, 103);
            } else {
                com.qq.e.comm.plugin.n0.w.b.a(4001001, apkDownloadTask);
            }
        }
        d1.a("set download task to downloading", new Object[0]);
        com.qq.e.comm.plugin.apkmanager.w.b.a().a(apkDownloadTask.r(), 4);
        apkDownloadTask.c(4);
        if (a6 != null) {
            apkDownloadTask.d(a6.t());
            a5.c(apkDownloadTask);
        } else {
            a5.a(apkDownloadTask);
        }
        return 0;
    }

    private void a(ApkDownloadTask apkDownloadTask, ApkDownloadTask apkDownloadTask2, File file) {
        if (apkDownloadTask == null || TextUtils.equals(i2.b(apkDownloadTask.s()), i2.b(apkDownloadTask2.s()))) {
            return;
        }
        com.qq.e.comm.plugin.apkmanager.x.b.a(apkDownloadTask2);
    }

    private void a(int i4, String str, File file) {
        com.qq.e.comm.plugin.apkmanager.x.d.a(i4, str, this.f41827g, file);
        com.qq.e.comm.plugin.n0.w.b.b(i4, this.f41827g);
        a.InterfaceC0780a interfaceC0780a = this.f41826f;
        if (interfaceC0780a != null) {
            interfaceC0780a.a(i4, str, file);
        }
    }

    private void a(int i4, String str) {
        a(i4, str, (File) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j4, long j5) {
        b().a(j4, j5);
    }

    private String a(int i4) {
        return com.qq.e.comm.plugin.p.e.c(i4) ? "\u8fde\u63a5\u5230\u8fd0\u8425\u5546\u7f51\u7edc\uff0c\u6682\u505c\u4e0b\u8f7d\uff0c\u70b9\u51fb\u8fd9\u91cc\u7ee7\u7eed\uff01" : com.qq.e.comm.plugin.p.e.e(i4) ? "\u5df2\u6682\u505c" : com.qq.e.comm.plugin.p.e.d(i4) ? "\u770b\u8d77\u6765\u7f51\u7edc\u51fa\u95ee\u9898\u4e86\uff0c\u5feb\u53bb\u68c0\u67e5\u7f51\u7edc\u6b63\u5e38\u540e\u70b9\u8fd9\u91cc\u91cd\u8bd5\u5427\uff01" : com.qq.e.comm.plugin.p.e.b(i4) ? "\u5b58\u50a8\u5361\u4e0d\u53ef\u7528\u6216\u8005\u5b58\u50a8\u7a7a\u95f4\u4e0d\u8db3\uff0c\u5feb\u53bb\u68c0\u67e5\u5b58\u50a8\u5361\u72b6\u6001\u540e\u70b9\u8fd9\u91cc\u91cd\u8bd5\u5427\uff01" : "\u771f\u9057\u61be\uff0c\u4e0b\u8f7d\u5931\u8d25\u4e86\uff0c\u7a0d\u540e\u70b9\u8fd9\u91cc\u91cd\u8bd5\u5427";
    }

    private void a(ApkDownloadTask apkDownloadTask, int i4) {
        int i5;
        if (i4 == 0) {
            i5 = 8;
        } else if (com.qq.e.comm.plugin.p.e.c(i4) || com.qq.e.comm.plugin.p.e.e(i4)) {
            i5 = 32;
        } else {
            i5 = com.qq.e.comm.plugin.p.e.a(i4) ? 64 : 16;
        }
        com.qq.e.comm.plugin.apkmanager.w.b.a().a(apkDownloadTask.r(), i5);
        apkDownloadTask.c(i5);
        if (i4 == 8) {
            s.a(this.f41823c).b(apkDownloadTask);
        } else {
            s.a(this.f41823c).c(apkDownloadTask);
        }
    }
}
