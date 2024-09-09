package com.ss.android.socialbase.downloader.f;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class r {
    private final boolean bk;
    private BaseException ev;

    /* renamed from: f  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.ev.f f49634f;
    private final boolean fp;
    private long ia;

    /* renamed from: r  reason: collision with root package name */
    private final xv f49637r;

    /* renamed from: t  reason: collision with root package name */
    private final long f49639t;
    private final com.ss.android.socialbase.downloader.r.c ux;
    private final DownloadInfo xv;
    private final long ys;

    /* renamed from: c  reason: collision with root package name */
    private final List<a> f49633c = new LinkedList();

    /* renamed from: w  reason: collision with root package name */
    private final List<a> f49640w = new ArrayList();
    private volatile boolean gd = false;

    /* renamed from: p  reason: collision with root package name */
    private volatile boolean f49636p = false;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f49635k = false;

    /* renamed from: s  reason: collision with root package name */
    private volatile long f49638s = 0;
    private volatile long fz = 0;
    private final com.ss.android.socialbase.downloader.downloader.p sr = com.ss.android.socialbase.downloader.downloader.xv.gb();

    /* renamed from: a  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.c.c f49632a = com.ss.android.socialbase.downloader.c.c.c();

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.ev.f fVar, xv xvVar) {
        this.xv = downloadInfo;
        this.f49634f = fVar;
        this.f49637r = xvVar;
        com.ss.android.socialbase.downloader.r.c c4 = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId());
        this.ux = c4;
        boolean z3 = c4.c("sync_strategy", 0) == 1;
        this.bk = z3;
        if (z3) {
            this.f49639t = Math.max(c4.c("sync_interval_ms_fg", 5000), 500L);
            this.ys = Math.max(c4.c("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.f49639t = 0L;
            this.ys = 0L;
        }
        this.fp = c4.w("monitor_rw") == 1;
    }

    private boolean c(long j4, long j5) {
        return j4 > 65536 && j5 > 500;
    }

    private void w(List<a> list) throws IOException {
        for (a aVar : list) {
            aVar.xv();
        }
    }

    private void xv() throws IOException {
        boolean z3 = this.fp;
        long nanoTime = z3 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.xv;
        com.ss.android.socialbase.downloader.downloader.p pVar = this.sr;
        List<a> list = this.f49633c;
        List<a> list2 = this.f49640w;
        Map<Long, gd> a4 = pVar.a(downloadInfo.getId());
        if (a4 == null) {
            a4 = new HashMap<>(4);
        }
        synchronized (this) {
            c(list);
            w(list);
            c(list, a4);
            if (list2.size() > 0) {
                xv(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (1 != 0) {
            downloadInfo.updateRealDownloadTime(true);
            pVar.c(downloadInfo.getId(), a4);
            pVar.c(downloadInfo);
            this.f49638s = downloadInfo.getCurBytes();
        }
        if (z3) {
            this.ia += System.nanoTime() - nanoTime;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(a aVar) {
        synchronized (this) {
            this.f49633c.add(aVar);
        }
    }

    public void w() {
        this.f49636p = true;
        this.gd = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x02a4, code lost:
        r3.w(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
        if (r13 <= 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
        r3.w(r13);
     */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01f4 A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:158:0x01f0, B:160:0x01f4, B:163:0x01fa, B:165:0x0200, B:166:0x0203, B:167:0x0219, B:204:0x029e, B:205:0x02a0, B:244:0x0328, B:246:0x0332, B:248:0x0336, B:285:0x03b9, B:287:0x03bf, B:288:0x03c2, B:289:0x03da), top: B:363:0x0027, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0200 A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:158:0x01f0, B:160:0x01f4, B:163:0x01fa, B:165:0x0200, B:166:0x0203, B:167:0x0219, B:204:0x029e, B:205:0x02a0, B:244:0x0328, B:246:0x0332, B:248:0x0336, B:285:0x03b9, B:287:0x03bf, B:288:0x03c2, B:289:0x03da), top: B:363:0x0027, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0332 A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:158:0x01f0, B:160:0x01f4, B:163:0x01fa, B:165:0x0200, B:166:0x0203, B:167:0x0219, B:204:0x029e, B:205:0x02a0, B:244:0x0328, B:246:0x0332, B:248:0x0336, B:285:0x03b9, B:287:0x03bf, B:288:0x03c2, B:289:0x03da), top: B:363:0x0027, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03bf A[Catch: all -> 0x03db, TryCatch #28 {all -> 0x03db, blocks: (B:158:0x01f0, B:160:0x01f4, B:163:0x01fa, B:165:0x0200, B:166:0x0203, B:167:0x0219, B:204:0x029e, B:205:0x02a0, B:244:0x0328, B:246:0x0332, B:248:0x0336, B:285:0x03b9, B:287:0x03bf, B:288:0x03c2, B:289:0x03da), top: B:363:0x0027, inners: #26 }] */
    /* JADX WARN: Removed duplicated region for block: B:300:0x03ef  */
    /* JADX WARN: Removed duplicated region for block: B:339:0x022a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:341:0x02ad A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:343:0x0365 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x00e3 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x0419 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:372:0x03f9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:376:0x0249 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:378:0x02cc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(com.ss.android.socialbase.downloader.f.sr r31) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1136
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.r.c(com.ss.android.socialbase.downloader.f.sr):void");
    }

    private void xv(List<a> list) {
        for (a aVar : list) {
            aVar.sr();
        }
    }

    private void c(long j4, boolean z3) throws IOException {
        long j5 = j4 - this.fz;
        if (this.bk) {
            if (j5 > (this.f49632a.w() ? this.f49639t : this.ys)) {
                xv();
                this.fz = j4;
                return;
            }
            return;
        }
        long curBytes = this.xv.getCurBytes() - this.f49638s;
        if (z3 || c(curBytes, j5)) {
            xv();
            this.fz = j4;
        }
    }

    private void c(ux uxVar) {
        synchronized (this) {
            this.f49640w.add((a) uxVar);
        }
    }

    private void c(List<a> list) throws IOException {
        for (a aVar : list) {
            aVar.w();
        }
    }

    private void c(List<a> list, Map<Long, gd> map) {
        for (a aVar : list) {
            gd ux = aVar.ux();
            gd gdVar = map.get(Long.valueOf(ux.xv()));
            if (gdVar == null) {
                map.put(Long.valueOf(ux.xv()), new gd(ux));
            } else {
                gdVar.c(ux.sr());
                gdVar.xv(ux.f());
            }
        }
    }

    public void c() {
        this.f49635k = true;
        this.gd = true;
    }
}
