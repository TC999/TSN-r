package com.p521ss.android.socialbase.downloader.p551kf;

import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;
import com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ss.android.socialbase.downloader.kf.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12576h {

    /* renamed from: bl */
    private final DownloadInfo f35319bl;

    /* renamed from: h */
    private final InterfaceC12575bl f35320h;

    /* renamed from: i */
    private final boolean f35321i;

    /* renamed from: kf */
    private final InterfaceC12658kf f35324kf;

    /* renamed from: n */
    private final C12534ok f35325n;

    /* renamed from: p */
    private BaseException f35327p;

    /* renamed from: rh */
    private final long f35330rh;

    /* renamed from: t */
    private final long f35332t;

    /* renamed from: x */
    private long f35334x;

    /* renamed from: z */
    private final boolean f35335z;

    /* renamed from: ok */
    private final List<C12578j> f35326ok = new LinkedList();

    /* renamed from: a */
    private final List<C12578j> f35318a = new ArrayList();

    /* renamed from: q */
    private volatile boolean f35328q = false;

    /* renamed from: k */
    private volatile boolean f35323k = false;

    /* renamed from: r */
    private volatile boolean f35329r = false;

    /* renamed from: td */
    private volatile long f35333td = 0;

    /* renamed from: zz */
    private volatile long f35336zz = 0;

    /* renamed from: s */
    private final InterfaceC12501k f35331s = C12490bl.m17806m();

    /* renamed from: j */
    private final C12646ok f35322j = C12646ok.m16846ok();

    /* JADX INFO: Access modifiers changed from: package-private */
    public C12576h(DownloadInfo downloadInfo, InterfaceC12658kf interfaceC12658kf, InterfaceC12575bl interfaceC12575bl) {
        this.f35319bl = downloadInfo;
        this.f35324kf = interfaceC12658kf;
        this.f35320h = interfaceC12575bl;
        C12534ok m17599ok = C12534ok.m17599ok(downloadInfo.getId());
        this.f35325n = m17599ok;
        boolean z = m17599ok.m17593ok("sync_strategy", 0) == 1;
        this.f35335z = z;
        if (z) {
            this.f35330rh = Math.max(m17599ok.m17593ok("sync_interval_ms_fg", 5000), 500L);
            this.f35332t = Math.max(m17599ok.m17593ok("sync_interval_ms_bg", 1000), 500L);
        } else {
            this.f35330rh = 0L;
            this.f35332t = 0L;
        }
        this.f35321i = m17599ok.m17607a("monitor_rw") == 1;
    }

    /* renamed from: a */
    private void m17314a(List<C12578j> list) throws IOException {
        for (C12578j c12578j : list) {
            c12578j.m17302bl();
        }
    }

    /* renamed from: bl */
    private void m17313bl() throws IOException {
        boolean z = this.f35321i;
        long nanoTime = z ? System.nanoTime() : 0L;
        DownloadInfo downloadInfo = this.f35319bl;
        InterfaceC12501k interfaceC12501k = this.f35331s;
        List<C12578j> list = this.f35326ok;
        List<C12578j> list2 = this.f35318a;
        Map<Long, C12584q> mo17506j = interfaceC12501k.mo17506j(downloadInfo.getId());
        if (mo17506j == null) {
            mo17506j = new HashMap<>(4);
        }
        synchronized (this) {
            m17305ok(list);
            m17314a(list);
            m17304ok(list, mo17506j);
            if (list2.size() > 0) {
                m17312bl(list2);
                list.removeAll(list2);
                list2.clear();
            }
        }
        if (1 != 0) {
            downloadInfo.updateRealDownloadTime(true);
            interfaceC12501k.mo17491ok(downloadInfo.getId(), mo17506j);
            interfaceC12501k.mo17488ok(downloadInfo);
            this.f35333td = downloadInfo.getCurBytes();
        }
        if (z) {
            this.f35334x += System.nanoTime() - nanoTime;
        }
    }

    /* renamed from: ok */
    private boolean m17310ok(long j, long j2) {
        return j > 65536 && j2 > 500;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m17308ok(C12578j c12578j) {
        synchronized (this) {
            this.f35326ok.add(c12578j);
        }
    }

    /* renamed from: a */
    public void m17315a() {
        this.f35323k = true;
        this.f35328q = true;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x02a4, code lost:
        r3.mo16761a(r15);
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b8, code lost:
        if (r13 <= 0) goto L267;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00bb, code lost:
        r3.mo16761a(r13);
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
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m17306ok(com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12590s r31) throws com.p521ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 1136
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p551kf.C12576h.m17306ok(com.ss.android.socialbase.downloader.kf.s):void");
    }

    /* renamed from: bl */
    private void m17312bl(List<C12578j> list) {
        for (C12578j c12578j : list) {
            c12578j.m17298s();
        }
    }

    /* renamed from: ok */
    private void m17309ok(long j, boolean z) throws IOException {
        long j2 = j - this.f35336zz;
        if (this.f35335z) {
            if (j2 > (this.f35322j.m16854a() ? this.f35330rh : this.f35332t)) {
                m17313bl();
                this.f35336zz = j;
                return;
            }
            return;
        }
        long curBytes = this.f35319bl.getCurBytes() - this.f35333td;
        if (z || m17310ok(curBytes, j2)) {
            m17313bl();
            this.f35336zz = j;
        }
    }

    /* renamed from: ok */
    private void m17307ok(InterfaceC12581n interfaceC12581n) {
        synchronized (this) {
            this.f35318a.add((C12578j) interfaceC12581n);
        }
    }

    /* renamed from: ok */
    private void m17305ok(List<C12578j> list) throws IOException {
        for (C12578j c12578j : list) {
            c12578j.m17303a();
        }
    }

    /* renamed from: ok */
    private void m17304ok(List<C12578j> list, Map<Long, C12584q> map) {
        for (C12578j c12578j : list) {
            C12584q m17301n = c12578j.m17301n();
            C12584q c12584q = map.get(Long.valueOf(m17301n.m17293bl()));
            if (c12584q == null) {
                map.put(Long.valueOf(m17301n.m17293bl()), new C12584q(m17301n));
            } else {
                c12584q.m17285ok(m17301n.m17280s());
                c12584q.m17292bl(m17301n.m17289kf());
            }
        }
    }

    /* renamed from: ok */
    public void m17311ok() {
        this.f35329r = true;
        this.f35328q = true;
    }
}
