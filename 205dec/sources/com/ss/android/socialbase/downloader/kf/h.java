package com.ss.android.socialbase.downloader.kf;

import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {
    private final DownloadInfo bl;

    /* renamed from: h  reason: collision with root package name */
    private final bl f49836h;

    /* renamed from: i  reason: collision with root package name */
    private final boolean f49837i;
    private final com.ss.android.socialbase.downloader.p.kf kf;

    /* renamed from: n  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.h.ok f49840n;

    /* renamed from: p  reason: collision with root package name */
    private BaseException f49841p;
    private final long rh;

    /* renamed from: t  reason: collision with root package name */
    private final long f49845t;

    /* renamed from: x  reason: collision with root package name */
    private long f49846x;

    /* renamed from: z  reason: collision with root package name */
    private final boolean f49847z;
    private final List<j> ok = new LinkedList();

    /* renamed from: a  reason: collision with root package name */
    private final List<j> f49835a = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private volatile boolean f49842q = false;

    /* renamed from: k  reason: collision with root package name */
    private volatile boolean f49839k = false;

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f49843r = false;
    private volatile long td = 0;
    private volatile long zz = 0;

    /* renamed from: s  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.k f49844s = com.ss.android.socialbase.downloader.downloader.bl.m();

    /* renamed from: j  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.ok.ok f49838j = com.ss.android.socialbase.downloader.ok.ok.ok();

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(DownloadInfo downloadInfo, com.ss.android.socialbase.downloader.p.kf kfVar, bl blVar) {
        this.bl = downloadInfo;
        this.kf = kfVar;
        this.f49836h = blVar;
        com.ss.android.socialbase.downloader.h.ok ok = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
        this.f49840n = ok;
        boolean z3 = ok.ok("sync_strategy", 0) == 1;
        this.f49847z = z3;
        if (z3) {
            this.rh = Math.max(ok.ok("sync_interval_ms_fg", 5000), 500L);
            this.f49845t = Math.max(ok.ok("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.rh = 0L;
            this.f49845t = 0L;
        }
        this.f49837i = ok.a("monitor_rw") == 1;
    }

    private void a(List<j> list) throws IOException {
        for (j jVar : list) {
            jVar.bl();
        }
    }

    private void bl() throws IOException {
        boolean z3 = this.f49837i;
        long nanoTime = z3 ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.bl;
        com.ss.android.socialbase.downloader.downloader.k kVar = this.f49844s;
        List<j> list = this.ok;
        List<j> list2 = this.f49835a;
        Map<Long, q> j4 = kVar.j(downloadInfo.getId());
        if (j4 == null) {
            j4 = new HashMap<>(4);
        }
        synchronized (this) {
            ok(list);
            a(list);
            ok(list, j4);
            if (list2.size() > 0) {
                bl(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (1 != 0) {
            downloadInfo.updateRealDownloadTime(true);
            kVar.ok(downloadInfo.getId(), j4);
            kVar.ok(downloadInfo);
            this.td = downloadInfo.getCurBytes();
        }
        if (z3) {
            this.f49846x += System.nanoTime() - nanoTime;
        }
    }

    private boolean ok(long j4, long j5) {
        return j4 > 65536 && j5 > 500;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(j jVar) {
        synchronized (this) {
            this.ok.add(jVar);
        }
    }

    public void a() {
        this.f49839k = true;
        this.f49842q = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x02a4, code lost:
        r3.a(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
        if (r13 <= 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
        r3.a(r13);
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
    public void ok(com.ss.android.socialbase.downloader.kf.s r31) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1136
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kf.h.ok(com.ss.android.socialbase.downloader.kf.s):void");
    }

    private void bl(List<j> list) {
        for (j jVar : list) {
            jVar.s();
        }
    }

    private void ok(long j4, boolean z3) throws IOException {
        long j5 = j4 - this.zz;
        if (this.f49847z) {
            if (j5 > (this.f49838j.a() ? this.rh : this.f49845t)) {
                bl();
                this.zz = j4;
                return;
            }
            return;
        }
        long curBytes = this.bl.getCurBytes() - this.td;
        if (z3 || ok(curBytes, j5)) {
            bl();
            this.zz = j4;
        }
    }

    private void ok(n nVar) {
        synchronized (this) {
            this.f49835a.add((j) nVar);
        }
    }

    private void ok(List<j> list) throws IOException {
        for (j jVar : list) {
            jVar.a();
        }
    }

    private void ok(List<j> list, Map<Long, q> map) {
        for (j jVar : list) {
            q n4 = jVar.n();
            q qVar = map.get(Long.valueOf(n4.bl()));
            if (qVar == null) {
                map.put(Long.valueOf(n4.bl()), new q(n4));
            } else {
                qVar.ok(n4.s());
                qVar.bl(n4.kf());
            }
        }
    }

    public void ok() {
        this.f49843r = true;
        this.f49842q = true;
    }
}
