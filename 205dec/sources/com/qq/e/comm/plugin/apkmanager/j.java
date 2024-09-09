package com.qq.e.comm.plugin.apkmanager;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import com.qq.e.comm.plugin.util.d1;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class j {

    /* renamed from: a  reason: collision with root package name */
    private final Context f41791a;

    /* renamed from: b  reason: collision with root package name */
    private final s f41792b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(Context context) {
        this.f41791a = context;
        this.f41792b = s.a(context);
    }

    public boolean a(ApkDownloadTask apkDownloadTask, int i4) {
        if (apkDownloadTask == null) {
            return false;
        }
        try {
            com.qq.e.comm.plugin.apkmanager.w.b.a().a(apkDownloadTask.r(), 32, i4);
            a(apkDownloadTask, 32, i4);
            com.qq.e.comm.plugin.apkmanager.x.d.a(1100908, apkDownloadTask);
            return true;
        } catch (Throwable th) {
            d1.a("pauseTask err", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int b(String str, int i4) {
        return this.f41792b.a(str, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ApkDownloadTask> c() {
        return this.f41792b.c();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ApkDownloadTask> d() {
        return this.f41792b.d();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(int i4) {
        return b(this.f41792b.b(i4));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int c(ApkDownloadTask apkDownloadTask) {
        return this.f41792b.c(apkDownloadTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(String str) {
        return b(this.f41792b.a(str));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean b(ApkDownloadTask apkDownloadTask) {
        if (apkDownloadTask != null && apkDownloadTask.o() != 8) {
            try {
                if (com.qq.e.comm.plugin.apkmanager.w.d.d(com.qq.e.comm.plugin.apkmanager.w.b.a().d(this.f41791a, apkDownloadTask.r()))) {
                    b(apkDownloadTask, 8);
                    return true;
                }
                com.qq.e.comm.plugin.apkmanager.w.b.a().a(apkDownloadTask.r(), 128);
                apkDownloadTask.c(128);
                Intent a4 = i.a(this.f41791a, apkDownloadTask);
                if (a4 != null) {
                    this.f41791a.startService(a4);
                }
                com.qq.e.comm.plugin.apkmanager.x.d.a(1100909, apkDownloadTask);
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i4, int i5) {
        return a(this.f41792b.a(i4), i5);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(String str, int i4) {
        return a(this.f41792b.a(str), i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i4, int i5, long j4) {
        try {
            ApkDownloadTask c4 = this.f41792b.c(i4);
            if (c4 != null) {
                a(c4, this.f41792b, i5, j4);
                return true;
            }
            return false;
        } catch (Throwable th) {
            d1.a("updateProgress err", th);
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(ApkDownloadTask apkDownloadTask, boolean z3) {
        if (apkDownloadTask != null) {
            try {
                com.qq.e.comm.plugin.apkmanager.w.b.a().a(apkDownloadTask.r(), 64);
                b(apkDownloadTask, 64);
                String d4 = apkDownloadTask.d("notifyTag");
                int b4 = apkDownloadTask.b("notifyId");
                NotificationManager a4 = com.qq.e.comm.plugin.j.b.a(this.f41791a);
                if (a4 != null) {
                    a4.cancel(d4, b4);
                }
                if (z3) {
                    com.qq.e.comm.plugin.apkmanager.x.b.a(apkDownloadTask);
                    return true;
                }
                return true;
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    private void b(ApkDownloadTask apkDownloadTask, int i4) {
        apkDownloadTask.c(i4);
        this.f41792b.c(apkDownloadTask);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public List<ApkDownloadTask> b() {
        List<ApkDownloadTask> b4 = this.f41792b.b();
        if (b4 != null && b4.size() > 0) {
            Iterator<ApkDownloadTask> it = b4.iterator();
            while (it.hasNext()) {
                if (!com.qq.e.comm.plugin.apkmanager.x.b.d(it.next())) {
                    it.remove();
                }
            }
        }
        return b4;
    }

    private void a(ApkDownloadTask apkDownloadTask, s sVar, int i4, long j4) {
        apkDownloadTask.a("totalSize", j4);
        apkDownloadTask.a("progress", i4);
        sVar.c(apkDownloadTask);
    }

    private void a(ApkDownloadTask apkDownloadTask, int i4, int i5) {
        apkDownloadTask.a("manualPause", i5);
        b(apkDownloadTask, i4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public int a(ApkDownloadTask apkDownloadTask) {
        return this.f41792b.a(apkDownloadTask);
    }

    public List<ApkDownloadTask> a() {
        return this.f41792b.a();
    }

    public ApkDownloadTask a(String str) {
        return this.f41792b.a(str);
    }

    public ApkDownloadTask a(int i4) {
        return this.f41792b.c(i4);
    }
}
