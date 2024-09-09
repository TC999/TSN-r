package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.ev.ux;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.xv;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class k implements f, xv.c {
    private long bk;

    /* renamed from: c  reason: collision with root package name */
    private final DownloadInfo f49613c;
    private int ck;
    private int fp;
    private long gb;

    /* renamed from: i  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.ev.ux f49615i;
    private BaseException ia;

    /* renamed from: j  reason: collision with root package name */
    private long f49616j;

    /* renamed from: k  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.sr f49617k;
    private long ls;

    /* renamed from: n  reason: collision with root package name */
    private float f49618n;

    /* renamed from: p  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.sr f49619p;

    /* renamed from: s  reason: collision with root package name */
    private volatile boolean f49622s;
    private final com.ss.android.socialbase.downloader.ev.f sr;

    /* renamed from: u  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.gd.ux f49624u;
    private final r ux;

    /* renamed from: w  reason: collision with root package name */
    private final t f49625w;
    private final w xv;

    /* renamed from: z  reason: collision with root package name */
    private final boolean f49627z;

    /* renamed from: f  reason: collision with root package name */
    private volatile boolean f49614f = false;

    /* renamed from: r  reason: collision with root package name */
    private volatile boolean f49621r = false;
    private final List<bk> ev = new ArrayList();
    private final List<ia> gd = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    private volatile boolean f49612a = true;

    /* renamed from: t  reason: collision with root package name */
    private final LinkedList<gd> f49623t = new LinkedList<>();
    private final List<gd> ys = new ArrayList();
    private final Object fz = new Object();

    /* renamed from: q  reason: collision with root package name */
    private volatile boolean f49620q = false;
    private final ux.w ba = new ux.w() { // from class: com.ss.android.socialbase.downloader.f.k.1

        /* renamed from: w  reason: collision with root package name */
        private int f49629w;

        @Override // com.ss.android.socialbase.downloader.ev.ux.w
        public long c() {
            if (k.this.f49614f || k.this.f49621r) {
                return -1L;
            }
            synchronized (k.this) {
                if (k.this.f49619p == null && k.this.f49617k == null) {
                    long j4 = k.this.f49616j;
                    if (j4 <= 0) {
                        return -1L;
                    }
                    this.f49629w++;
                    bk c4 = k.this.c(false, System.currentTimeMillis(), j4);
                    if (c4 != null) {
                        Log.i("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                        k.this.xv(c4);
                        c4.f();
                        return ((this.f49629w / k.this.gd.size()) + 1) * j4;
                    }
                    return j4;
                }
                return -1L;
            }
        }
    };

    /* renamed from: y  reason: collision with root package name */
    private final ux.w f49626y = new ux.w() { // from class: com.ss.android.socialbase.downloader.f.k.2
        @Override // com.ss.android.socialbase.downloader.ev.ux.w
        public long c() {
            return k.this.s();
        }
    };

    public k(@NonNull DownloadInfo downloadInfo, @NonNull t tVar, com.ss.android.socialbase.downloader.ev.f fVar) {
        this.f49613c = downloadInfo;
        this.f49625w = tVar;
        w wVar = new w(tVar.sr(), tVar.ux());
        this.xv = wVar;
        this.sr = fVar;
        this.ux = new r(downloadInfo, fVar, wVar);
        this.f49615i = new com.ss.android.socialbase.downloader.ev.ux();
        this.f49624u = new com.ss.android.socialbase.downloader.gd.ux();
        this.f49627z = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).w("debug") == 1;
    }

    private boolean a() {
        for (bk bkVar : this.ev) {
            if (!bkVar.r()) {
                return false;
            }
        }
        return true;
    }

    private void bk() {
        int size;
        if (this.bk > 0 && (size = this.ys.size()) > 1) {
            ArrayList<gd> arrayList = null;
            int i4 = 0;
            for (int i5 = 1; i5 < size; i5++) {
                gd gdVar = this.ys.get(i4);
                gd gdVar2 = this.ys.get(i5);
                if (gdVar.ux() > gdVar2.xv() && gdVar2.c() <= 0 && gdVar2.f49603c == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(gdVar2);
                    if (this.f49627z) {
                        Log.w("SegmentDispatcher", "clearCovered, covered = " + gdVar2 + ", prev = " + gdVar);
                    }
                } else if (gdVar2.ux() > gdVar.ux()) {
                    i4++;
                }
            }
            if (arrayList != null) {
                for (gd gdVar3 : arrayList) {
                    this.ys.remove(gdVar3);
                    for (bk bkVar : this.ev) {
                        if (bkVar.f49584c == gdVar3) {
                            if (this.f49627z) {
                                Log.w("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + gdVar3 + ", threadIndex = " + bkVar.xv);
                            }
                            bkVar.c(true);
                        }
                    }
                }
            }
        }
    }

    private void ev() {
        if (this.ls > 0) {
            this.gb = System.currentTimeMillis();
            this.f49615i.c(this.f49626y, 0L);
        }
    }

    private gd fp() {
        int i4 = 0;
        while (true) {
            gd ia = ia();
            if (ia == null) {
                return null;
            }
            bk bkVar = ia.f49603c;
            if (bkVar == null) {
                return ia;
            }
            if (ia.p() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            w(currentTimeMillis);
            if (currentTimeMillis - bkVar.f49585f > 2000 && c(bkVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.f49627z) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + ia + ", owner.threadIndex = " + bkVar.xv);
                }
                return ia;
            }
            int i5 = i4 + 1;
            if (i4 > 2) {
                if (this.f49627z) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + ia);
                }
                return ia;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i4 = i5;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    private void gd() {
        List<String> backUpUrls;
        int a4 = this.f49625w.a();
        if (a4 <= 0) {
            this.f49612a = false;
            ux();
            return;
        }
        com.ss.android.socialbase.downloader.network.xv c4 = com.ss.android.socialbase.downloader.network.xv.c();
        c4.c(this.f49613c.getUrl(), this, 2000L);
        if (a4 <= 2 || (backUpUrls = this.f49613c.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                c4.c(str, this, 2000L);
            }
        }
    }

    private gd ia() {
        int p3;
        gd gdVar = null;
        int i4 = Integer.MAX_VALUE;
        for (gd gdVar2 : this.ys) {
            if (c(gdVar2) > 0 && (p3 = gdVar2.p()) < i4) {
                gdVar = gdVar2;
                i4 = p3;
            }
        }
        return gdVar;
    }

    private void k() {
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "onComplete");
        this.xv.xv();
        synchronized (this.fz) {
            this.fz.notify();
        }
    }

    private ia p() {
        ia iaVar;
        synchronized (this) {
            int size = this.fp % this.gd.size();
            if (this.f49625w.w()) {
                this.fp++;
            }
            iaVar = this.gd.get(size);
        }
        return iaVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long s() {
        if (this.f49614f || this.f49621r) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            w(currentTimeMillis);
            long k4 = this.f49625w.k();
            if (k4 > 0) {
                long j4 = this.gb;
                if (j4 > 0 && currentTimeMillis - j4 > k4 && c(currentTimeMillis, k4)) {
                    this.gb = currentTimeMillis;
                    this.ck++;
                }
            }
        }
        return 2000L;
    }

    private boolean t() {
        long j4 = this.bk;
        if (j4 <= 0) {
            this.f49622s = false;
            return false;
        }
        synchronized (this) {
            long c4 = ys.c(this.ys);
            com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + c4);
            if (c4 >= j4) {
                this.f49622s = true;
                return true;
            }
            this.f49622s = false;
            return false;
        }
    }

    private long ys() {
        long j4 = 0;
        for (bk bkVar : this.ev) {
            j4 += bkVar.w();
        }
        return j4;
    }

    private void f() {
        this.gd.add(new ia(this.f49613c.getUrl(), true));
        List<String> backUpUrls = this.f49613c.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.gd.add(new ia(str, false));
                }
            }
        }
        this.f49625w.c(this.gd.size());
    }

    private void r() {
        t tVar = this.f49625w;
        this.f49616j = tVar.p();
        this.ls = tVar.k();
        this.f49618n = tVar.ys();
        int i4 = this.ck;
        if (i4 > 0) {
            this.f49615i.c(this.ba, i4);
        }
    }

    private void sr() throws BaseException {
        try {
            this.ux.c((sr) this.xv);
        } catch (fp unused) {
        } catch (BaseException e4) {
            com.ss.android.socialbase.downloader.xv.c.ux("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e4);
            c(e4);
            throw e4;
        }
        if (this.f49621r || this.f49614f) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.f49623t.isEmpty()) {
                    gd poll = this.f49623t.poll();
                    if (poll != null) {
                        c(this.ys, poll, true);
                    }
                }
                xv(this.ys);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.f49620q && this.ia != null) {
            com.ss.android.socialbase.downloader.xv.c.ux("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.ia);
            throw this.ia;
        }
        if (this.f49613c.getCurBytes() != this.f49613c.getTotalBytes()) {
            com.ss.android.socialbase.downloader.sr.c.c(this.f49613c, this.ys);
        }
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "dispatchSegments::download finished");
    }

    private void ux() {
        int i4;
        if (this.bk <= 0 || this.f49612a) {
            i4 = 1;
        } else {
            i4 = this.f49625w.c();
            int ev = (int) (this.bk / this.f49625w.ev());
            if (i4 > ev) {
                i4 = ev;
            }
        }
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.bk + ", threadCount = " + i4);
        int i5 = i4 > 0 ? i4 : 1;
        synchronized (this) {
            do {
                if (this.ev.size() >= i5) {
                    break;
                }
                if (!this.f49621r && !this.f49614f) {
                    c(p());
                }
                return;
            } while (!this.f49625w.f());
        }
    }

    private void w(List<gd> list) {
        long totalBytes = this.f49613c.getTotalBytes();
        this.bk = totalBytes;
        if (totalBytes <= 0) {
            this.bk = this.f49613c.getExpectFileLength();
            com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.bk);
        }
        synchronized (this) {
            this.f49623t.clear();
            if (list != null && !list.isEmpty()) {
                for (gd gdVar : list) {
                    c((List<gd>) this.f49623t, new gd(gdVar), false);
                }
                sr(this.f49623t);
                xv(this.f49623t);
                com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "initSegments: totalLength = " + this.bk);
            }
            c((List<gd>) this.f49623t, new gd(0L, -1L), false);
            com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "initSegments: totalLength = " + this.bk);
        }
    }

    private void xv() throws BaseException, InterruptedException {
        BaseException baseException;
        synchronized (this.fz) {
            if (this.f49619p == null && this.f49617k == null) {
                this.fz.wait();
            }
        }
        if (this.f49619p == null && this.f49617k == null && (baseException = this.ia) != null) {
            throw baseException;
        }
    }

    public boolean c(List<gd> list) throws BaseException, InterruptedException {
        try {
            f();
            w(list);
            ux();
            r();
            gd();
            long currentTimeMillis = System.currentTimeMillis();
            xv();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            this.f49613c.increaseAllConnectTime(currentTimeMillis2);
            this.f49613c.setFirstSpeedTime(currentTimeMillis2);
            if (!this.f49621r && !this.f49614f) {
                this.sr.c(this.bk);
                ev();
                sr();
                return true;
            }
            if (!this.f49621r && !this.f49614f) {
                com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "finally pause");
                w();
            }
            this.f49615i.w();
            return true;
        } finally {
            if (!this.f49621r && !this.f49614f) {
                com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "finally pause");
                w();
            }
            this.f49615i.w();
        }
    }

    private void xv(List<gd> list) {
        long w3 = ys.w(list);
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.f49613c.getCurBytes() + ", totalBytes = " + this.f49613c.getTotalBytes() + ", downloadedBytes = " + w3);
        if (w3 > this.f49613c.getTotalBytes() && this.f49613c.getTotalBytes() > 0) {
            w3 = this.f49613c.getTotalBytes();
        }
        if (this.f49613c.getCurBytes() == this.f49613c.getTotalBytes() || this.f49613c.getCurBytes() == w3) {
            return;
        }
        this.f49613c.setCurBytes(w3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
        if ((r10.ux() - r24.ux()) < (r14 / 2)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01f2, code lost:
        r3 = r3 + 1;
        r6 = r22.ys.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01fa, code lost:
        if (r3 >= r6) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01fc, code lost:
        r7 = r22.ys.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x020c, code lost:
        if (r7.c() > 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0210, code lost:
        if (r7.f49603c == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0213, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0216, code lost:
        r11 = r24.f();
        r15 = r7.xv();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0220, code lost:
        if (r11 <= 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0224, code lost:
        if (r11 < r15) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0226, code lost:
        r9 = r15 - 1;
        r24.xv(r9);
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "applySegment: segment set end:" + r9 + ", later = " + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0247, code lost:
        android.util.Log.d("SegmentDispatcher", "applySegmentLocked: break 2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x024c, code lost:
        r6 = r24.f();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0254, code lost:
        if (r6 <= 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0258, code lost:
        if (r20 > r6) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0260, code lost:
        if (r24.ux() > r6) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0278, code lost:
        throw new com.ss.android.socialbase.downloader.f.p(6, "applySegment: " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0279, code lost:
        r24.f49603c = r23;
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "applySegment: OK " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x028f, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void ux(com.ss.android.socialbase.downloader.f.bk r23, com.ss.android.socialbase.downloader.f.gd r24) throws com.ss.android.socialbase.downloader.f.p {
        /*
            Method dump skipped, instructions count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.k.ux(com.ss.android.socialbase.downloader.f.bk, com.ss.android.socialbase.downloader.f.gd):void");
    }

    private void w(String str, List<ia> list) {
        int c4;
        if (this.f49627z) {
            Iterator<ia> it = list.iterator();
            while (it.hasNext()) {
                Log.i("SegmentDispatcher", "addIpListLocked: urlRecord = " + it.next());
            }
        }
        int a4 = this.f49625w.a();
        if ((a4 == 1 || a4 == 3) && (c4 = c(str)) >= 0 && c4 < this.gd.size()) {
            this.gd.addAll(c4 + 1, list);
        } else {
            this.gd.addAll(list);
        }
    }

    private List<ia> xv(String str, List<InetAddress> list) {
        boolean z3;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i4 = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.f49627z) {
                            Log.i("SegmentDispatcher", "onDnsResolved: ip = " + hostAddress);
                        }
                        ia iaVar = new ia(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(iaVar.xv);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(iaVar.xv, linkedList);
                        }
                        linkedList.add(iaVar);
                        i4++;
                    }
                }
            }
            if (i4 > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    z3 = false;
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        LinkedList linkedList2 = (LinkedList) entry.getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((ia) linkedList2.pollFirst());
                            i4--;
                            z3 = true;
                        }
                    }
                    if (i4 <= 0) {
                        break;
                    }
                } while (z3);
                return arrayList;
            }
        }
        return null;
    }

    private void sr(List<gd> list) {
        gd gdVar = list.get(0);
        long xv = gdVar.xv();
        if (xv > 0) {
            gd gdVar2 = new gd(0L, xv - 1);
            Log.w("SegmentDispatcher", "fixSegmentsLocked: first = " + gdVar + ", add new first = " + gdVar2);
            c(list, gdVar2, true);
        }
        Iterator<gd> it = list.iterator();
        if (it.hasNext()) {
            gd next = it.next();
            while (it.hasNext()) {
                gd next2 = it.next();
                if (next.f() < next2.xv() - 1) {
                    com.ss.android.socialbase.downloader.xv.c.sr("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.xv() - 1));
                    next.xv(next2.xv() - 1);
                }
                next = next2;
            }
        }
        gd gdVar3 = list.get(list.size() - 1);
        long totalBytes = this.f49613c.getTotalBytes();
        if (totalBytes <= 0 || (gdVar3.f() != -1 && gdVar3.f() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.xv.c.sr("SegmentDispatcher", "fixSegment: last segment = " + gdVar3 + ", new end=-1");
            gdVar3.xv(-1L);
        }
    }

    private gd w(bk bkVar, ia iaVar) {
        while (!this.f49623t.isEmpty()) {
            gd poll = this.f49623t.poll();
            if (poll != null) {
                c(this.ys, poll, true);
                if (c(poll) > 0 || this.bk <= 0) {
                    return poll;
                }
            }
        }
        bk();
        gd xv = xv(bkVar, iaVar);
        if (xv != null && c(xv) > 0) {
            c(this.ys, xv, true);
            return xv;
        }
        gd fp = fp();
        if (fp != null) {
            return fp;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void w(bk bkVar, gd gdVar) throws BaseException {
        synchronized (this) {
            ux(bkVar, gdVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.xv.c
    public void c(String str, List<InetAddress> list) {
        if (this.f49621r || this.f49614f) {
            return;
        }
        List<ia> list2 = null;
        try {
            list2 = xv(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this) {
            if (list2 != null) {
                w(str, list2);
            }
            this.f49612a = false;
            this.f49625w.c(this.gd.size());
            Log.i("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
            ux();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void w(bk bkVar) {
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "onReaderExit: threadIndex = " + bkVar.xv);
        synchronized (this) {
            bkVar.xv(true);
            this.ev.remove(bkVar);
            bk();
            if (this.ev.isEmpty()) {
                k();
            } else if (t()) {
                Log.i("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                for (bk bkVar2 : this.ev) {
                    bkVar2.ux();
                }
                k();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void xv(bk bkVar, gd gdVar) {
        synchronized (this) {
            if (gdVar.f49603c == bkVar) {
                com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "unApplySegment " + gdVar);
                gdVar.sr(bkVar.sr());
                gdVar.f49603c = null;
                bkVar.c();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public ux sr(bk bkVar, gd gdVar) throws BaseException {
        ux c4;
        synchronized (this) {
            a aVar = new a(this.f49613c, this.xv, gdVar);
            this.ux.c(aVar);
            c4 = aVar.c();
        }
        return c4;
    }

    private int c(String str) {
        int size = this.gd.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (TextUtils.equals(this.gd.get(i4).f49607c, str)) {
                return i4;
            }
        }
        return -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xv(bk bkVar) {
        synchronized (this) {
            ia sr = sr(bkVar);
            if (sr == null) {
                return false;
            }
            return bkVar.c(sr);
        }
    }

    private ia sr(bk bkVar) {
        ia iaVar;
        Iterator<ia> it = this.gd.iterator();
        ia iaVar2 = null;
        while (true) {
            if (!it.hasNext()) {
                iaVar = null;
                break;
            }
            iaVar = it.next();
            if (iaVar != bkVar.f49596w && !iaVar.sr()) {
                if (iaVar2 == null) {
                    iaVar2 = iaVar;
                }
                if (iaVar.c() <= 0) {
                    break;
                }
            }
        }
        if (this.f49625w.w()) {
            if (iaVar != null) {
                return iaVar;
            }
            if (this.f49625w.xv()) {
                return null;
            }
        }
        return iaVar2;
    }

    private void c(List<gd> list, gd gdVar, boolean z3) {
        long xv = gdVar.xv();
        int size = list.size();
        int i4 = 0;
        while (i4 < size && xv >= list.get(i4).xv()) {
            i4++;
        }
        list.add(i4, gdVar);
        if (z3) {
            gdVar.c(size);
        }
    }

    private void w(bk bkVar, gd gdVar, ia iaVar, com.ss.android.socialbase.downloader.model.sr srVar) throws BaseException, com.ss.android.socialbase.downloader.exception.gd {
        bk bkVar2 = gdVar.f49603c;
        if (bkVar2 != null && bkVar2 != bkVar) {
            throw new p(1, "segment already has an owner");
        }
        if (bkVar.ev() == gdVar.ux()) {
            if (!srVar.w()) {
                if (gdVar.ux() <= 0) {
                    com.ss.android.socialbase.downloader.xv.c.ux("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + gdVar.ux());
                    if (!srVar.c()) {
                        int i4 = srVar.xv;
                        throw new com.ss.android.socialbase.downloader.exception.w(1004, i4, "2: response code error : " + srVar.xv + " segment=" + gdVar);
                    }
                } else {
                    int i5 = srVar.xv;
                    throw new com.ss.android.socialbase.downloader.exception.w(1004, i5, "1: response code error : " + srVar.xv + " segment=" + gdVar);
                }
            }
            if (iaVar.sr) {
                if (this.f49619p == null) {
                    this.f49619p = srVar;
                    synchronized (this.fz) {
                        this.fz.notify();
                    }
                    com.ss.android.socialbase.downloader.ev.f fVar = this.sr;
                    if (fVar != null) {
                        fVar.c(iaVar.f49607c, srVar.f49973w, gdVar.ux());
                    }
                    long p3 = srVar.p();
                    if (p3 > 0) {
                        for (gd gdVar2 : this.ys) {
                            if (gdVar2.f() <= 0 || gdVar2.f() > p3 - 1) {
                                gdVar2.xv(p3 - 1);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            c(srVar);
            if (this.f49617k == null) {
                this.f49617k = srVar;
                if (this.f49613c.getTotalBytes() <= 0) {
                    long p4 = srVar.p();
                    com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "checkSegmentHttpResponse:len=" + p4 + ",url=" + iaVar.f49607c);
                    this.f49613c.setTotalBytes(p4);
                }
                synchronized (this.fz) {
                    this.fz.notify();
                }
                return;
            }
            return;
        }
        throw new p(5, "applySegment");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.f.gd xv(com.ss.android.socialbase.downloader.f.bk r28, com.ss.android.socialbase.downloader.f.ia r29) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.k.xv(com.ss.android.socialbase.downloader.f.bk, com.ss.android.socialbase.downloader.f.ia):com.ss.android.socialbase.downloader.f.gd");
    }

    private float sr(bk bkVar, ia iaVar) {
        long w3 = bkVar.w();
        int size = this.ev.size();
        if (size <= 1) {
            size = this.f49625w.c();
        }
        float f4 = 1.0f;
        if (w3 <= 0) {
            float bk = this.f49625w.bk();
            if (bk <= 0.0f || bk >= 1.0f) {
                bk = 1.0f / size;
            }
            if (bkVar.xv == 0) {
                return bk;
            }
            if (size > 1) {
                f4 = 1.0f - bk;
                size--;
            }
        } else {
            long ys = ys();
            if (ys > w3) {
                return ((float) w3) / ((float) ys);
            }
        }
        return f4 / size;
    }

    private void c(ia iaVar) {
        bk bkVar = new bk(this.f49613c, this, this.xv, iaVar, this.ev.size());
        this.ev.add(bkVar);
        bkVar.c(com.ss.android.socialbase.downloader.downloader.xv.ia().submit(bkVar));
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void c(bk bkVar) {
        if (this.f49627z) {
            com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "onReaderRun, threadIndex = " + bkVar.xv);
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public gd c(bk bkVar, ia iaVar) {
        if (this.f49614f || this.f49621r) {
            return null;
        }
        synchronized (this) {
            gd w3 = w(bkVar, iaVar);
            if (w3 != null) {
                w3.ev();
                if (w3.p() > 1) {
                    return new gd(w3);
                }
            }
            return w3;
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void c(bk bkVar, gd gdVar) {
        synchronized (this) {
            gdVar.gd();
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void c(bk bkVar, gd gdVar, ia iaVar, com.ss.android.socialbase.downloader.model.sr srVar) throws BaseException, com.ss.android.socialbase.downloader.exception.gd {
        synchronized (this) {
            if (!this.f49614f && !this.f49621r) {
                w(bkVar, gdVar, iaVar, srVar);
                bkVar.w(false);
                if (this.bk <= 0) {
                    long totalBytes = this.f49613c.getTotalBytes();
                    this.bk = totalBytes;
                    if (totalBytes <= 0) {
                        this.bk = srVar.p();
                    }
                    ux();
                } else if (this.f49625w.f()) {
                    ux();
                }
            } else {
                throw new fp("connected");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void c(bk bkVar, ia iaVar, gd gdVar, BaseException baseException, int i4, int i5) {
        com.ss.android.socialbase.downloader.gd.f.w(baseException);
        int errorCode = baseException.getErrorCode();
        if (((errorCode == 1047 || errorCode == 1074 || errorCode == 1055) ? true : true) || i4 >= i5) {
            xv(bkVar);
        }
    }

    public void w() {
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "pause1");
        this.f49621r = true;
        synchronized (this) {
            for (bk bkVar : this.ev) {
                bkVar.ux();
            }
        }
        this.ux.w();
        this.xv.xv();
    }

    @Override // com.ss.android.socialbase.downloader.f.f
    public void c(bk bkVar, ia iaVar, gd gdVar, BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.xv.c.ux("SegmentDispatcher", "onSegmentFailed: segment = " + gdVar + ", e = " + baseException);
            bkVar.w(true);
            if (bkVar.xv == 0) {
                this.ia = baseException;
            }
            if (a()) {
                if (this.ia == null) {
                    this.ia = baseException;
                }
                this.f49620q = true;
                c(this.ia);
            }
        }
    }

    private void w(long j4) {
        this.f49624u.c(this.f49613c.getCurBytes(), j4);
        for (bk bkVar : this.ev) {
            bkVar.w(j4);
        }
    }

    private void c(BaseException baseException) {
        com.ss.android.socialbase.downloader.xv.c.ux("SegmentDispatcher", "onError, e = " + baseException);
        this.ia = baseException;
        this.xv.xv();
        synchronized (this) {
            for (bk bkVar : this.ev) {
                bkVar.ux();
            }
        }
    }

    private void c(com.ss.android.socialbase.downloader.model.sr srVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.sr srVar2 = this.f49619p;
        if (srVar2 == null && (srVar2 = this.f49617k) == null) {
            return;
        }
        long p3 = srVar.p();
        long p4 = srVar2.p();
        if (p3 != p4) {
            String str = "total len not equals,len=" + p3 + ",sLen=" + p4 + ",code=" + srVar.xv + ",sCode=" + srVar2.xv + ",range=" + srVar.ux() + ",sRange = " + srVar2.ux() + ",url = " + srVar.f49972c + ",sUrl=" + srVar2.f49972c;
            com.ss.android.socialbase.downloader.xv.c.ux("SegmentDispatcher", str);
            if (p3 > 0 && p4 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String xv = srVar.xv();
        String xv2 = srVar2.xv();
        if (TextUtils.equals(xv, xv2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + xv + ", mainEtag = " + xv2;
        com.ss.android.socialbase.downloader.xv.c.ux("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(xv) && !TextUtils.isEmpty(xv2) && !xv.equalsIgnoreCase(xv2)) {
            throw new BaseException(1074, str2);
        }
    }

    public void c() {
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "cancel");
        this.f49614f = true;
        synchronized (this) {
            for (bk bkVar : this.ev) {
                bkVar.ux();
            }
        }
        this.ux.c();
        this.xv.xv();
    }

    private int c(long j4) {
        int size = this.ys.size();
        for (int i4 = 0; i4 < size; i4++) {
            gd gdVar = this.ys.get(i4);
            if (gdVar.xv() == j4) {
                return i4;
            }
            if (gdVar.xv() > j4) {
                return -1;
            }
        }
        return -1;
    }

    private long c(int i4, int i5) {
        gd gdVar = this.ys.get(i4);
        long c4 = c(gdVar);
        int i6 = i4 + 1;
        gd gdVar2 = i6 < i5 ? this.ys.get(i6) : null;
        if (gdVar2 == null) {
            return c4;
        }
        long xv = gdVar2.xv() - gdVar.ux();
        return c4 == -1 ? xv : Math.min(c4, xv);
    }

    private long c(gd gdVar) {
        long w3 = gdVar.w();
        if (w3 == -1) {
            long j4 = this.bk;
            return j4 > 0 ? j4 - gdVar.ux() : w3;
        }
        return w3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public bk c(boolean z3, long j4, long j5) {
        bk bkVar = null;
        for (bk bkVar2 : this.ev) {
            if (bkVar2.xv != 0 || z3) {
                if (bkVar2.sr > 0 && bkVar2.ux <= 0 && j4 - bkVar2.sr > j5 && (bkVar == null || bkVar2.sr < bkVar.sr)) {
                    bkVar = bkVar2;
                }
            }
        }
        return bkVar;
    }

    private boolean c(bk bkVar, long j4, long j5, long j6, double d4) {
        if (bkVar.f49585f > 0) {
            long w3 = this.f49624u.w(j4, j5);
            int size = this.ev.size();
            long j7 = size > 0 ? w3 / size : w3;
            long c4 = bkVar.c(j4, j5);
            if (c4 >= j6) {
                double d5 = j7;
                Double.isNaN(d5);
                if (c4 >= d5 * d4) {
                    return false;
                }
            }
            Log.i("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + w3 + ", threadAvgSpeed = " + j7 + ", poorSpeed = " + j6 + ", speed = " + c4 + ",threadIndex = " + bkVar.xv);
            return true;
        }
        return false;
    }

    private boolean c(long j4, long j5) {
        long j6 = j4 - j5;
        long w3 = this.f49624u.w(j6, j4);
        int size = this.ev.size();
        if (size > 0) {
            w3 /= size;
        }
        bk c4 = c(j6, j4, Math.max(10.0f, ((float) w3) * this.f49618n), size / 2);
        if (c4 != null) {
            xv(c4);
            com.ss.android.socialbase.downloader.xv.c.sr("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + c4.xv);
            c4.f();
            return true;
        }
        bk c5 = c(true, j4, j5);
        if (c5 != null) {
            xv(c5);
            com.ss.android.socialbase.downloader.xv.c.sr("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + c5.xv);
            c5.f();
            return true;
        }
        return false;
    }

    private bk c(long j4, long j5, long j6, int i4) {
        long j7;
        long j8 = Long.MAX_VALUE;
        int i5 = 0;
        bk bkVar = null;
        for (bk bkVar2 : this.ev) {
            if (bkVar2.f49585f > 0) {
                i5++;
                long j9 = j8;
                if (bkVar2.f49585f < j4) {
                    long c4 = bkVar2.c(j4, j5);
                    if (this.f49627z) {
                        Log.i("SegmentDispatcher", "findPoorReadThread: speed = " + c4 + ", threadIndex = " + bkVar2.xv);
                        j7 = 0;
                    } else {
                        j7 = 0;
                    }
                    if (c4 >= j7 && c4 < j9) {
                        j8 = c4;
                        bkVar = bkVar2;
                    }
                }
                j8 = j9;
            }
        }
        long j10 = j8;
        if (bkVar == null || i5 < i4 || j10 >= j6) {
            return null;
        }
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j10 + ", threadIndex = " + bkVar.xv);
        return bkVar;
    }
}
