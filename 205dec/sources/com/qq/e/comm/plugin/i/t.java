package com.qq.e.comm.plugin.i;

import com.qq.e.comm.plugin.apkmanager.ApkDownloadTask;
import com.qq.e.comm.plugin.apkmanager.c;
import java.lang.ref.WeakReference;
import yaq.pro;

/* compiled from: A */
/* loaded from: E:\TSN-r\205dec\2450172.dex */
class t implements o {

    /* renamed from: a  reason: collision with root package name */
    private String f44188a;

    /* renamed from: b  reason: collision with root package name */
    private long f44189b;

    /* compiled from: A */
    /* loaded from: E:\TSN-r\205dec\2450172.dex */
    static class a implements c.a {

        /* renamed from: a  reason: collision with root package name */
        private final ApkDownloadTask f44190a;

        /* renamed from: b  reason: collision with root package name */
        private final h f44191b;

        /* renamed from: c  reason: collision with root package name */
        private final WeakReference<com.qq.e.comm.plugin.apkmanager.w.a> f44192c;

        /* renamed from: d  reason: collision with root package name */
        private final long f44193d;

        public a(h hVar, ApkDownloadTask apkDownloadTask, com.qq.e.comm.plugin.i.d0.b bVar, long j4) {
            this.f44191b = hVar;
            this.f44190a = apkDownloadTask;
            this.f44193d = j4;
            this.f44192c = new WeakReference<>(bVar.a());
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public void a(int i4, String str, boolean z3) {
            if (i4 != 0) {
                return;
            }
            this.f44190a.c(1);
            String r3 = this.f44190a.r();
            WeakReference<com.qq.e.comm.plugin.apkmanager.w.a> weakReference = this.f44192c;
            com.qq.e.comm.plugin.apkmanager.w.a aVar = weakReference == null ? null : weakReference.get();
            if (aVar != null) {
                aVar.a(r3, this.f44190a.o(), 100, this.f44191b.C.q().f());
            }
            com.qq.e.comm.plugin.apkmanager.k.e().d(this.f44190a);
            com.qq.e.comm.plugin.apkmanager.x.a.c(this.f44190a, this.f44191b.C);
            com.qq.e.comm.plugin.apkmanager.x.f a4 = com.qq.e.comm.plugin.n0.w.b.a(r3);
            a4.f41948d = 3;
            a4.f41952h = 1;
            com.qq.e.comm.plugin.apkmanager.x.d.a(1100902, (Integer) 100, this.f44190a);
            com.qq.e.comm.plugin.apkmanager.x.d.a(1100903, (Integer) 100, this.f44190a);
            com.qq.e.comm.plugin.apkmanager.x.d.c(1100905, this.f44190a);
            h hVar = this.f44191b;
            if (hVar.f44148u) {
                t.a(4001043, null, hVar, true, this.f44193d);
            } else {
                t.a(4001017, null, hVar, false, this.f44193d);
            }
            a4.f41953i = 2;
            u.a(this.f44190a);
        }

        @Override // com.qq.e.comm.plugin.apkmanager.c.a
        public boolean a() {
            return false;
        }
    }

    t() {
    }

    private static ApkDownloadTask a(String str, h hVar) {
        return (ApkDownloadTask) pro.getobjresult(401, 1, str, hVar);
    }

    static /* synthetic */ void a(int i4, Integer num, h hVar, boolean z3, long j4) {
        pro.getVresult(402, 1, Integer.valueOf(i4), num, hVar, Boolean.valueOf(z3), Long.valueOf(j4));
    }

    private void a(Integer num, h hVar) {
        pro.getVresult(403, 0, this, num, hVar);
    }

    private String b(h hVar) {
        return (String) pro.getobjresult(404, 0, this, hVar);
    }

    private static void b(int i4, Integer num, h hVar, boolean z3, long j4) {
        pro.getVresult(405, 1, Integer.valueOf(i4), num, hVar, Boolean.valueOf(z3), Long.valueOf(j4));
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar) {
        return pro.getZresult(406, 0, this, hVar);
    }

    @Override // com.qq.e.comm.plugin.i.o
    public boolean a(h hVar, com.qq.e.comm.plugin.i.d0.b bVar) {
        return pro.getZresult(407, 0, this, hVar, bVar);
    }
}
