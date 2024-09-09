package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux {

    /* renamed from: w  reason: collision with root package name */
    private static String f49498w = "ResponseHandler";

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f49499a;
    private long ba;
    private volatile boolean bk;
    private long ck;
    private com.ss.android.socialbase.downloader.impls.k ev;

    /* renamed from: f  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.network.gd f49501f;
    private long fp;
    private final boolean fz;
    private final boolean gb;
    private u gd;

    /* renamed from: i  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.c.c f49502i;
    private volatile long ia;

    /* renamed from: j  reason: collision with root package name */
    private final long f49503j;

    /* renamed from: k  reason: collision with root package name */
    private BaseException f49504k;
    private final long ls;

    /* renamed from: n  reason: collision with root package name */
    private boolean f49505n;

    /* renamed from: p  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.ux f49506p;

    /* renamed from: q  reason: collision with root package name */
    private final boolean f49507q;

    /* renamed from: r  reason: collision with root package name */
    private p f49508r;

    /* renamed from: s  reason: collision with root package name */
    private volatile long f49509s;
    private final String sr;

    /* renamed from: t  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.ev.f f49510t;

    /* renamed from: u  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.r.c f49511u;
    private final com.ss.android.socialbase.downloader.model.w ux;
    private final DownloadInfo xv;

    /* renamed from: y  reason: collision with root package name */
    private long f49512y;
    private long ys;

    /* renamed from: z  reason: collision with root package name */
    private long f49513z;

    /* renamed from: c  reason: collision with root package name */
    boolean f49500c = false;
    private volatile long eq = 0;
    private volatile long me = 0;

    public ux(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.gd gdVar, com.ss.android.socialbase.downloader.model.w wVar, com.ss.android.socialbase.downloader.ev.f fVar) {
        this.xv = downloadInfo;
        this.sr = str;
        p gb = xv.gb();
        this.f49508r = gb;
        if (gb instanceof com.ss.android.socialbase.downloader.impls.sr) {
            com.ss.android.socialbase.downloader.impls.sr srVar = (com.ss.android.socialbase.downloader.impls.sr) gb;
            this.ev = srVar.c();
            this.gd = srVar.f();
        }
        this.f49501f = gdVar;
        this.ux = wVar;
        this.f49510t = fVar;
        long t3 = wVar.t();
        this.ys = t3;
        this.fp = t3;
        if (wVar.sr()) {
            this.f49509s = wVar.ia();
        } else {
            this.f49509s = wVar.xv(false);
        }
        this.ia = wVar.fp();
        this.f49502i = com.ss.android.socialbase.downloader.c.c.c();
        com.ss.android.socialbase.downloader.r.c c4 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId());
        this.f49511u = c4;
        boolean z3 = c4.c("sync_strategy", 0) == 1;
        this.f49507q = z3;
        if (z3) {
            this.f49503j = Math.max(c4.c("sync_interval_ms_fg", 5000), 500L);
            this.ls = Math.max(c4.c("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.f49503j = 0L;
            this.ls = 0L;
        }
        this.gb = c4.w("monitor_rw") == 1;
        this.fz = com.ss.android.socialbase.downloader.gd.c.c(65536);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r2v8, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    private void ev() {
        boolean z3;
        long nanoTime = this.gb ? System.nanoTime() : 0L;
        try {
            this.f49506p.c();
            z3 = true;
        } catch (Exception unused) {
            z3 = false;
        }
        if (z3) {
            this.xv.updateRealDownloadTime(true);
            boolean z4 = this.xv.getChunkCount() > 1;
            bk c4 = com.ss.android.socialbase.downloader.impls.a.c(com.ss.android.socialbase.downloader.gd.f.w());
            if (z4) {
                c((p) this.gd);
                if (c4 != null) {
                    c4.xv(this.xv);
                } else {
                    this.gd.c(this.xv.getId(), this.xv.getCurBytes());
                }
            } else if (c4 != null) {
                c4.xv(this.xv);
            } else {
                this.gd.c(this.ux.k(), this.ys);
            }
            this.eq = this.ys;
        }
        if (this.gb) {
            this.ba += System.nanoTime() - nanoTime;
        }
    }

    private boolean f() {
        return this.f49499a || this.bk;
    }

    private void r() {
        ExecutorService a4;
        if (this.f49501f == null || (a4 = xv.a()) == null) {
            return;
        }
        a4.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.ux.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    ux.this.f49501f.sr();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private boolean w(long j4, long j5) {
        return j4 > 65536 && j5 > 500;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02e1 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0361 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x047f A[Catch: all -> 0x04db, TRY_LEAVE, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04d5 A[Catch: all -> 0x04db, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
    /* JADX WARN: Type inference failed for: r0v20, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r0v24, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r0v29, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r0v33, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r0v40, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r0v44, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r0v70, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r0v75, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r0v83, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r0v87, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r2v5, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r34v0, types: [com.ss.android.socialbase.downloader.downloader.ux] */
    /* JADX WARN: Type inference failed for: r3v27, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r3v31, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r4v5, types: [com.ss.android.socialbase.downloader.impls.k, com.ss.android.socialbase.downloader.downloader.p] */
    /* JADX WARN: Type inference failed for: r6v0, types: [long] */
    /* JADX WARN: Type inference failed for: r6v1 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v12 */
    /* JADX WARN: Type inference failed for: r6v13 */
    /* JADX WARN: Type inference failed for: r6v14 */
    /* JADX WARN: Type inference failed for: r6v2 */
    /* JADX WARN: Type inference failed for: r6v22 */
    /* JADX WARN: Type inference failed for: r6v23 */
    /* JADX WARN: Type inference failed for: r6v3 */
    /* JADX WARN: Type inference failed for: r6v34 */
    /* JADX WARN: Type inference failed for: r6v35 */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5, types: [int] */
    /* JADX WARN: Type inference failed for: r6v6, types: [int] */
    /* JADX WARN: Type inference failed for: r6v7, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void sr() throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.ux.sr():void");
    }

    public long ux() {
        return this.eq;
    }

    public void w() {
        if (this.f49499a) {
            return;
        }
        this.f49499a = true;
        r();
    }

    public void xv() {
        if (this.bk) {
            return;
        }
        synchronized (this.f49510t) {
            this.bk = true;
        }
        r();
    }

    public long c() {
        return this.ys;
    }

    public void c(long j4, long j5, long j6) {
        this.ys = j4;
        this.fp = j4;
        this.ia = j5;
        this.f49509s = j6;
    }

    public void c(long j4, long j5) {
        this.ia = j4;
        this.f49509s = j5;
    }

    private com.ss.android.socialbase.downloader.ux.w c(InputStream inputStream) {
        int yu = xv.yu();
        if (this.f49511u.c("rw_concurrent", 0) == 1 && this.xv.getChunkCount() == 1 && this.xv.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.ux.c cVar = new com.ss.android.socialbase.downloader.ux.c(inputStream, yu, this.f49511u.c("rw_concurrent_max_buffer_count", 4));
                this.f49505n = true;
                return cVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.ux.xv xvVar = new com.ss.android.socialbase.downloader.ux.xv(inputStream, yu);
        this.f49505n = false;
        return xvVar;
    }

    private void c(boolean z3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j4 = uptimeMillis - this.me;
        if (this.f49507q) {
            if (j4 > (this.f49502i.w() ? this.f49503j : this.ls)) {
                ev();
                this.me = uptimeMillis;
                return;
            }
            return;
        }
        long j5 = this.ys - this.eq;
        if (z3 || w(j5, j4)) {
            ev();
            this.me = uptimeMillis;
        }
    }

    private void c(p pVar) {
        com.ss.android.socialbase.downloader.model.w wVar;
        com.ss.android.socialbase.downloader.model.w wVar2;
        if (pVar == null) {
            return;
        }
        bk bkVar = null;
        boolean z3 = pVar instanceof com.ss.android.socialbase.downloader.w.ux;
        if (z3 && (bkVar = com.ss.android.socialbase.downloader.impls.a.c(com.ss.android.socialbase.downloader.gd.f.w())) == null) {
            return;
        }
        bk bkVar2 = bkVar;
        if (this.ux.sr()) {
            wVar = this.ux.ux();
        } else {
            wVar = this.ux;
        }
        com.ss.android.socialbase.downloader.model.w wVar3 = wVar;
        if (wVar3 != null) {
            wVar3.w(this.ys);
            if (z3 && bkVar2 != null) {
                bkVar2.c(wVar3.k(), wVar3.fz(), wVar3.w(), this.ys);
                wVar2 = wVar3;
            } else {
                wVar2 = wVar3;
                pVar.c(wVar3.k(), wVar3.fz(), wVar3.w(), this.ys);
            }
            if (wVar2.ev()) {
                boolean z4 = false;
                if (wVar2.gd()) {
                    long p3 = wVar2.p();
                    if (p3 > this.ys) {
                        if (z3 && bkVar2 != null) {
                            bkVar2.c(wVar2.k(), wVar2.w(), p3);
                        } else {
                            pVar.c(wVar2.k(), wVar2.w(), p3);
                        }
                        z4 = true;
                    }
                }
                if (z4) {
                    return;
                }
                if (z3 && bkVar2 != null) {
                    bkVar2.c(wVar2.k(), wVar2.w(), this.ys);
                } else {
                    pVar.c(wVar2.k(), wVar2.w(), this.ys);
                }
            }
        } else if (this.ux.sr()) {
            if (z3 && bkVar2 != null) {
                bkVar2.c(this.ux.k(), this.ux.fz(), this.ys);
            } else {
                pVar.c(this.ux.k(), this.ux.fz(), this.ys);
            }
        }
    }
}
