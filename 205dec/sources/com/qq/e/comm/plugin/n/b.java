package com.qq.e.comm.plugin.n;

import android.content.Context;
import com.qq.e.ads.dfa.GDTApk;
import com.qq.e.ads.dfa.IGDTApkListener;
import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.k;
import com.qq.e.comm.plugin.n0.v;
import com.qq.e.comm.plugin.util.d1;
import com.qq.e.comm.plugin.util.p0;
import com.qq.e.comm.plugin.util.u1;
import com.qq.e.comm.util.AdError;
import com.qq.e.comm.util.GDTLogger;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    private d1.a f44705a = null;

    /* renamed from: b  reason: collision with root package name */
    private Context f44706b = com.qq.e.comm.plugin.d0.a.d().a();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class a implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ IGDTApkListener f44707c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ com.qq.e.comm.plugin.n.a f44708d;

        a(b bVar, IGDTApkListener iGDTApkListener, com.qq.e.comm.plugin.n.a aVar) {
            this.f44707c = iGDTApkListener;
            this.f44708d = aVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            IGDTApkListener iGDTApkListener = this.f44707c;
            if (iGDTApkListener != null) {
                iGDTApkListener.onApkLoad(this.f44708d);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: A */
    /* renamed from: com.qq.e.comm.plugin.n.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    public class RunnableC0857b implements Runnable {

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ IGDTApkListener f44709c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ int f44710d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ String f44711e;

        RunnableC0857b(b bVar, IGDTApkListener iGDTApkListener, int i4, String str) {
            this.f44709c = iGDTApkListener;
            this.f44710d = i4;
            this.f44711e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f44709c.onError(new AdError(this.f44710d, this.f44711e));
        }
    }

    public void a(Context context, GDTApk gDTApk, IGDTApkListener iGDTApkListener) {
        if (context != null && gDTApk != null && iGDTApkListener != null) {
            ApkDownloadTask a4 = gDTApk instanceof com.qq.e.comm.plugin.n.a ? ((com.qq.e.comm.plugin.n.a) gDTApk).a() : null;
            if (a4 == null) {
                GDTLogger.e("\u4f20\u5165\u7684 GDTApk \u4e3a null");
                return;
            }
            v.a(100422, new com.qq.e.comm.plugin.n0.c().a(a4.a()), 1);
            if (!com.qq.e.comm.plugin.apkmanager.x.b.d(a4)) {
                a(iGDTApkListener, 5043, "\u8c03\u7528\u5b89\u88c5\u5668\u65f6\uff0cApk \u6587\u4ef6\u4e0d\u5b58\u5728");
                return;
            } else if (d.a(u1.a("downloaded_not_installed_apk", System.currentTimeMillis()), System.currentTimeMillis(), a4)) {
                a(iGDTApkListener, 5042, "\u63a5\u53e3\u8c03\u7528\u65f6\u95f4\u95f4\u9694\u8fc7\u957f!");
                return;
            } else {
                com.qq.e.comm.plugin.n0.w.b.a(a4.r()).f41948d = 5;
                d.b(a4);
                return;
            }
        }
        GDTLogger.e("\u4f20\u5165\u53c2\u6570\u4e3a null");
    }

    public void a(IGDTApkListener iGDTApkListener) {
        if (com.qq.e.comm.plugin.d0.a.d().f().a("apk_downloaded_task", 0) == 0) {
            a(iGDTApkListener, 5045, "\u63a5\u53e3\u529f\u80fd\u672a\u5f00\u542f");
        } else if (d.d()) {
            a(iGDTApkListener, 5041, "\u8c03\u7528\u63a5\u53e3\u77ed\u65f6\u95f4\u5185\u8fc7\u4e8e\u9891\u7e41\uff0c\u8bf7\u7a0d\u540e\u518d\u8bd5!");
        } else {
            List<ApkDownloadTask> c4 = k.e().c();
            if (d.a(c4)) {
                a(iGDTApkListener, 5044, "\u4e0d\u5b58\u5728\u6709\u6548\u7684 Apk \u6587\u4ef6");
            } else if (c4.size() == 1) {
                ApkDownloadTask apkDownloadTask = c4.get(0);
                if (!d.c(apkDownloadTask) && !com.qq.e.comm.plugin.apkmanager.x.b.b(com.qq.e.comm.plugin.d0.a.d().a(), apkDownloadTask.r())) {
                    apkDownloadTask.a(true);
                    k.e().d(apkDownloadTask);
                    d1.a(apkDownloadTask.toString() + " , , time=" + (((float) (System.currentTimeMillis() - apkDownloadTask.e())) * 1.0f) + "ms", this.f44705a);
                    u1.b("downloaded_not_installed_apk", System.currentTimeMillis());
                    v.a(100412, new com.qq.e.comm.plugin.n0.c().a(apkDownloadTask.a()), 1);
                    if (com.qq.e.comm.plugin.apkmanager.x.b.d(apkDownloadTask) && com.qq.e.comm.plugin.apkmanager.x.b.a(d.a(apkDownloadTask), apkDownloadTask.r(), this.f44706b)) {
                        a(iGDTApkListener, d.d(apkDownloadTask));
                        return;
                    }
                }
                a(iGDTApkListener, 5044, "\u4e0d\u5b58\u5728\u6709\u6548\u7684 Apk \u6587\u4ef6");
            } else {
                Iterator<ApkDownloadTask> it = c4.iterator();
                while (it.hasNext()) {
                    ApkDownloadTask next = it.next();
                    if (d.c(next) || com.qq.e.comm.plugin.apkmanager.x.b.b(com.qq.e.comm.plugin.d0.a.d().a(), next.r()) || !com.qq.e.comm.plugin.apkmanager.x.b.d(next) || !com.qq.e.comm.plugin.apkmanager.x.b.a(d.a(next), next.r(), this.f44706b)) {
                        it.remove();
                    }
                }
                if (d.a(c4)) {
                    a(iGDTApkListener, 5044, "\u4e0d\u5b58\u5728\u6709\u6548\u7684 Apk \u6587\u4ef6");
                    return;
                }
                d.b(c4);
                ApkDownloadTask apkDownloadTask2 = c4.get(0);
                for (int i4 = 1; i4 < c4.size(); i4++) {
                    ApkDownloadTask apkDownloadTask3 = c4.get(i4);
                    if ((!apkDownloadTask3.y() && apkDownloadTask2.e() > apkDownloadTask3.e()) || apkDownloadTask2.y()) {
                        apkDownloadTask2 = apkDownloadTask3;
                    }
                }
                apkDownloadTask2.a(true);
                k.e().d(apkDownloadTask2);
                u1.b("downloaded_not_installed_apk", System.currentTimeMillis());
                v.a(100412, new com.qq.e.comm.plugin.n0.c().a(apkDownloadTask2.a()), 1);
                a(iGDTApkListener, d.d(apkDownloadTask2));
            }
        }
    }

    private void a(IGDTApkListener iGDTApkListener, com.qq.e.comm.plugin.n.a aVar) {
        p0.a((Runnable) new a(this, iGDTApkListener, aVar));
    }

    private void a(IGDTApkListener iGDTApkListener, int i4, String str) {
        if (iGDTApkListener != null) {
            p0.a((Runnable) new RunnableC0857b(this, iGDTApkListener, i4, str));
        }
    }
}
