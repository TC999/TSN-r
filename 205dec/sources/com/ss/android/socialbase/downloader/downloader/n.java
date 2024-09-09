package com.ss.android.socialbase.downloader.downloader;

import android.os.SystemClock;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n {

    /* renamed from: a  reason: collision with root package name */
    private static String f49465a = "ResponseHandler";
    private final DownloadInfo bl;
    private boolean ep;
    private long er;
    private long fb;

    /* renamed from: h  reason: collision with root package name */
    private k f49467h;

    /* renamed from: i  reason: collision with root package name */
    private long f49468i;

    /* renamed from: io  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.ok.ok f49469io;

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f49470j;

    /* renamed from: k  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.n f49471k;
    private final com.ss.android.socialbase.downloader.network.q kf;
    private long kz;

    /* renamed from: m  reason: collision with root package name */
    private final boolean f49472m;

    /* renamed from: n  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.model.a f49473n;

    /* renamed from: o  reason: collision with root package name */
    private final long f49474o;

    /* renamed from: p  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.impls.r f49475p;

    /* renamed from: q  reason: collision with root package name */
    private u f49476q;

    /* renamed from: r  reason: collision with root package name */
    private BaseException f49477r;
    private final com.ss.android.socialbase.downloader.p.kf rh;

    /* renamed from: s  reason: collision with root package name */
    private final String f49478s;

    /* renamed from: t  reason: collision with root package name */
    private long f49479t;
    private volatile long td;

    /* renamed from: u  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.h.ok f49480u;
    private final boolean ul;
    private long vz;

    /* renamed from: x  reason: collision with root package name */
    private volatile long f49482x;

    /* renamed from: y  reason: collision with root package name */
    private final long f49483y;

    /* renamed from: z  reason: collision with root package name */
    private volatile boolean f49484z;
    private final boolean zz;
    boolean ok = false;

    /* renamed from: g  reason: collision with root package name */
    private volatile long f49466g = 0;

    /* renamed from: v  reason: collision with root package name */
    private volatile long f49481v = 0;

    public n(DownloadInfo downloadInfo, String str, com.ss.android.socialbase.downloader.network.q qVar, com.ss.android.socialbase.downloader.model.a aVar, com.ss.android.socialbase.downloader.p.kf kfVar) {
        this.bl = downloadInfo;
        this.f49478s = str;
        k m4 = bl.m();
        this.f49467h = m4;
        if (m4 instanceof com.ss.android.socialbase.downloader.impls.s) {
            com.ss.android.socialbase.downloader.impls.s sVar = (com.ss.android.socialbase.downloader.impls.s) m4;
            this.f49475p = sVar.ok();
            this.f49476q = sVar.kf();
        }
        this.kf = qVar;
        this.f49473n = aVar;
        this.rh = kfVar;
        long rh = aVar.rh();
        this.f49479t = rh;
        this.f49468i = rh;
        if (aVar.s()) {
            this.td = aVar.x();
        } else {
            this.td = aVar.bl(false);
        }
        this.f49482x = aVar.i();
        this.f49469io = com.ss.android.socialbase.downloader.ok.ok.ok();
        com.ss.android.socialbase.downloader.h.ok ok = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
        this.f49480u = ok;
        boolean z3 = ok.ok("sync_strategy", 0) == 1;
        this.ul = z3;
        if (z3) {
            this.f49474o = Math.max(ok.ok("sync_interval_ms_fg", 5000), 500L);
            this.f49483y = Math.max(ok.ok("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.f49474o = 0L;
            this.f49483y = 0L;
        }
        this.f49472m = ok.a("monitor_rw") == 1;
        this.zz = com.ss.android.socialbase.downloader.q.ok.ok(65536);
    }

    private boolean a(long j4, long j5) {
        return j4 > 65536 && j5 > 500;
    }

    private void h() {
        ExecutorService j4;
        if (this.kf == null || (j4 = bl.j()) == null) {
            return;
        }
        j4.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.n.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    n.this.kf.s();
                } catch (Throwable unused) {
                }
            }
        });
    }

    private boolean kf() {
        return this.f49470j || this.f49484z;
    }

    private void p() {
        boolean z3;
        long nanoTime = this.f49472m ? System.nanoTime() : 0L;
        try {
            this.f49471k.ok();
            z3 = true;
        } catch (Exception unused) {
            z3 = false;
        }
        if (z3) {
            this.bl.updateRealDownloadTime(true);
            boolean z4 = this.bl.getChunkCount() > 1;
            z ok = com.ss.android.socialbase.downloader.impls.j.ok(com.ss.android.socialbase.downloader.q.kf.a());
            if (z4) {
                ok(this.f49476q);
                if (ok != null) {
                    ok.bl(this.bl);
                } else {
                    this.f49476q.ok(this.bl.getId(), this.bl.getCurBytes());
                }
            } else if (ok != null) {
                ok.bl(this.bl);
            } else {
                this.f49476q.ok(this.f49473n.r(), this.f49479t);
            }
            this.f49466g = this.f49479t;
        }
        if (this.f49472m) {
            this.er += System.nanoTime() - nanoTime;
        }
    }

    public void a() {
        if (this.f49470j) {
            return;
        }
        this.f49470j = true;
        h();
    }

    public void bl() {
        if (this.f49484z) {
            return;
        }
        synchronized (this.rh) {
            this.f49484z = true;
        }
        h();
    }

    public long n() {
        return this.f49466g;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02e1 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x0361 A[Catch: all -> 0x04db, TRY_ENTER, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03e8 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:236:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x047f A[Catch: all -> 0x04db, TRY_LEAVE, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04d5 A[Catch: all -> 0x04db, TryCatch #26 {all -> 0x04db, blocks: (B:176:0x02e1, B:177:0x02e8, B:206:0x0361, B:208:0x0367, B:209:0x036a, B:250:0x0456, B:251:0x0458, B:255:0x045f, B:257:0x047f, B:285:0x04cf, B:287:0x04d5, B:288:0x04d8, B:289:0x04da), top: B:333:0x002b, inners: #28 }] */
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
    public void s() throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1380
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.n.s():void");
    }

    public long ok() {
        return this.f49479t;
    }

    public void ok(long j4, long j5, long j6) {
        this.f49479t = j4;
        this.f49468i = j4;
        this.f49482x = j5;
        this.td = j6;
    }

    public void ok(long j4, long j5) {
        this.f49482x = j4;
        this.td = j5;
    }

    private com.ss.android.socialbase.downloader.n.a ok(InputStream inputStream) {
        int fd = bl.fd();
        if (this.f49480u.ok("rw_concurrent", 0) == 1 && this.bl.getChunkCount() == 1 && this.bl.getTotalBytes() > 20971520) {
            try {
                com.ss.android.socialbase.downloader.n.ok okVar = new com.ss.android.socialbase.downloader.n.ok(inputStream, fd, this.f49480u.ok("rw_concurrent_max_buffer_count", 4));
                this.ep = true;
                return okVar;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        com.ss.android.socialbase.downloader.n.bl blVar = new com.ss.android.socialbase.downloader.n.bl(inputStream, fd);
        this.ep = false;
        return blVar;
    }

    private void ok(boolean z3) {
        long uptimeMillis = SystemClock.uptimeMillis();
        long j4 = uptimeMillis - this.f49481v;
        if (this.ul) {
            if (j4 > (this.f49469io.a() ? this.f49474o : this.f49483y)) {
                p();
                this.f49481v = uptimeMillis;
                return;
            }
            return;
        }
        long j5 = this.f49479t - this.f49466g;
        if (z3 || a(j5, j4)) {
            p();
            this.f49481v = uptimeMillis;
        }
    }

    private void ok(k kVar) {
        com.ss.android.socialbase.downloader.model.a aVar;
        com.ss.android.socialbase.downloader.model.a aVar2;
        if (kVar == null) {
            return;
        }
        z zVar = null;
        boolean z3 = kVar instanceof com.ss.android.socialbase.downloader.a.n;
        if (z3 && (zVar = com.ss.android.socialbase.downloader.impls.j.ok(com.ss.android.socialbase.downloader.q.kf.a())) == null) {
            return;
        }
        z zVar2 = zVar;
        if (this.f49473n.s()) {
            aVar = this.f49473n.n();
        } else {
            aVar = this.f49473n;
        }
        com.ss.android.socialbase.downloader.model.a aVar3 = aVar;
        if (aVar3 != null) {
            aVar3.a(this.f49479t);
            if (z3 && zVar2 != null) {
                zVar2.ok(aVar3.r(), aVar3.zz(), aVar3.a(), this.f49479t);
                aVar2 = aVar3;
            } else {
                aVar2 = aVar3;
                kVar.ok(aVar3.r(), aVar3.zz(), aVar3.a(), this.f49479t);
            }
            if (aVar2.p()) {
                boolean z4 = false;
                if (aVar2.q()) {
                    long k4 = aVar2.k();
                    if (k4 > this.f49479t) {
                        if (z3 && zVar2 != null) {
                            zVar2.ok(aVar2.r(), aVar2.a(), k4);
                        } else {
                            kVar.ok(aVar2.r(), aVar2.a(), k4);
                        }
                        z4 = true;
                    }
                }
                if (z4) {
                    return;
                }
                if (z3 && zVar2 != null) {
                    zVar2.ok(aVar2.r(), aVar2.a(), this.f49479t);
                } else {
                    kVar.ok(aVar2.r(), aVar2.a(), this.f49479t);
                }
            }
        } else if (this.f49473n.s()) {
            if (z3 && zVar2 != null) {
                zVar2.ok(this.f49473n.r(), this.f49473n.zz(), this.f49479t);
            } else {
                kVar.ok(this.f49473n.r(), this.f49473n.zz(), this.f49479t);
            }
        }
    }
}
