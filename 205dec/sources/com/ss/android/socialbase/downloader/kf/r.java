package com.ss.android.socialbase.downloader.kf;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.network.bl;
import com.ss.android.socialbase.downloader.p.n;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class r implements kf, bl.ok {

    /* renamed from: a  reason: collision with root package name */
    private final rh f49857a;
    private final a bl;
    private float ep;

    /* renamed from: i  reason: collision with root package name */
    private int f49859i;

    /* renamed from: io  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.p.n f49860io;

    /* renamed from: k  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.s f49862k;
    private final boolean kz;

    /* renamed from: m  reason: collision with root package name */
    private long f49863m;

    /* renamed from: n  reason: collision with root package name */
    private final h f49864n;

    /* renamed from: o  reason: collision with root package name */
    private long f49865o;
    private final DownloadInfo ok;

    /* renamed from: r  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.s f49868r;

    /* renamed from: s  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.p.kf f49869s;
    private volatile boolean td;

    /* renamed from: u  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.q.n f49871u;
    private int vz;

    /* renamed from: x  reason: collision with root package name */
    private BaseException f49872x;

    /* renamed from: y  reason: collision with root package name */
    private long f49873y;

    /* renamed from: z  reason: collision with root package name */
    private long f49874z;
    private volatile boolean kf = false;

    /* renamed from: h  reason: collision with root package name */
    private volatile boolean f49858h = false;

    /* renamed from: p  reason: collision with root package name */
    private final List<z> f49866p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    private final List<x> f49867q = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private volatile boolean f49861j = true;
    private final LinkedList<q> rh = new LinkedList<>();

    /* renamed from: t  reason: collision with root package name */
    private final List<q> f49870t = new ArrayList();
    private final Object zz = new Object();
    private volatile boolean ul = false;
    private final n.a er = new n.a() { // from class: com.ss.android.socialbase.downloader.kf.r.1

        /* renamed from: a  reason: collision with root package name */
        private int f49875a;

        @Override // com.ss.android.socialbase.downloader.p.n.a
        public long ok() {
            if (r.this.kf || r.this.f49858h) {
                return -1L;
            }
            synchronized (r.this) {
                if (r.this.f49862k == null && r.this.f49868r == null) {
                    long j4 = r.this.f49865o;
                    if (j4 <= 0) {
                        return -1L;
                    }
                    this.f49875a++;
                    z ok = r.this.ok(false, System.currentTimeMillis(), j4);
                    if (ok != null) {
                        Log.i("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                        r.this.bl(ok);
                        ok.kf();
                        return ((this.f49875a / r.this.f49867q.size()) + 1) * j4;
                    }
                    return j4;
                }
                return -1L;
            }
        }
    };
    private final n.a fb = new n.a() { // from class: com.ss.android.socialbase.downloader.kf.r.2
        @Override // com.ss.android.socialbase.downloader.p.n.a
        public long ok() {
            return r.this.td();
        }
    };

    public r(@NonNull DownloadInfo downloadInfo, @NonNull rh rhVar, com.ss.android.socialbase.downloader.p.kf kfVar) {
        this.ok = downloadInfo;
        this.f49857a = rhVar;
        a aVar = new a(rhVar.s(), rhVar.n());
        this.bl = aVar;
        this.f49869s = kfVar;
        this.f49864n = new h(downloadInfo, kfVar, aVar);
        this.f49860io = new com.ss.android.socialbase.downloader.p.n();
        this.f49871u = new com.ss.android.socialbase.downloader.q.n();
        this.kz = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).a("debug") == 1;
    }

    private q i() {
        int i4 = 0;
        while (true) {
            q x3 = x();
            if (x3 == null) {
                return null;
            }
            z zVar = x3.ok;
            if (zVar == null) {
                return x3;
            }
            if (x3.k() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            a(currentTimeMillis);
            if (currentTimeMillis - zVar.kf > 2000 && ok(zVar, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.kz) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + x3 + ", owner.threadIndex = " + zVar.bl);
                }
                return x3;
            }
            int i5 = i4 + 1;
            if (i4 > 2) {
                if (this.kz) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + x3);
                }
                return x3;
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

    private boolean j() {
        for (z zVar : this.f49866p) {
            if (!zVar.h()) {
                return false;
            }
        }
        return true;
    }

    private x k() {
        x xVar;
        synchronized (this) {
            int size = this.f49859i % this.f49867q.size();
            if (this.f49857a.a()) {
                this.f49859i++;
            }
            xVar = this.f49867q.get(size);
        }
        return xVar;
    }

    private void p() {
        if (this.f49873y > 0) {
            this.f49863m = System.currentTimeMillis();
            this.f49860io.ok(this.fb, 0L);
        }
    }

    private void q() {
        List<String> backUpUrls;
        int j4 = this.f49857a.j();
        if (j4 <= 0) {
            this.f49861j = false;
            n();
            return;
        }
        com.ss.android.socialbase.downloader.network.bl ok = com.ss.android.socialbase.downloader.network.bl.ok();
        ok.ok(this.ok.getUrl(), this, 2000L);
        if (j4 <= 2 || (backUpUrls = this.ok.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                ok.ok(str, this, 2000L);
            }
        }
    }

    private void r() {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "onComplete");
        this.bl.bl();
        synchronized (this.zz) {
            this.zz.notify();
        }
    }

    private boolean rh() {
        long j4 = this.f49874z;
        if (j4 <= 0) {
            this.td = false;
            return false;
        }
        synchronized (this) {
            long ok = t.ok(this.f49870t);
            com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + ok);
            if (ok >= j4) {
                this.td = true;
                return true;
            }
            this.td = false;
            return false;
        }
    }

    private long t() {
        long j4 = 0;
        for (z zVar : this.f49866p) {
            j4 += zVar.a();
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public long td() {
        if (this.kf || this.f49858h) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            a(currentTimeMillis);
            long r3 = this.f49857a.r();
            if (r3 > 0) {
                long j4 = this.f49863m;
                if (j4 > 0 && currentTimeMillis - j4 > r3 && ok(currentTimeMillis, r3)) {
                    this.f49863m = currentTimeMillis;
                    this.vz++;
                }
            }
        }
        return 2000L;
    }

    private q x() {
        int k4;
        q qVar = null;
        int i4 = Integer.MAX_VALUE;
        for (q qVar2 : this.f49870t) {
            if (ok(qVar2) > 0 && (k4 = qVar2.k()) < i4) {
                qVar = qVar2;
                i4 = k4;
            }
        }
        return qVar;
    }

    private void z() {
        int size;
        if (this.f49874z > 0 && (size = this.f49870t.size()) > 1) {
            ArrayList<q> arrayList = null;
            int i4 = 0;
            for (int i5 = 1; i5 < size; i5++) {
                q qVar = this.f49870t.get(i4);
                q qVar2 = this.f49870t.get(i5);
                if (qVar.n() > qVar2.bl() && qVar2.ok() <= 0 && qVar2.ok == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(qVar2);
                    if (this.kz) {
                        Log.w("SegmentDispatcher", "clearCovered, covered = " + qVar2 + ", prev = " + qVar);
                    }
                } else if (qVar2.n() > qVar.n()) {
                    i4++;
                }
            }
            if (arrayList != null) {
                for (q qVar3 : arrayList) {
                    this.f49870t.remove(qVar3);
                    for (z zVar : this.f49866p) {
                        if (zVar.ok == qVar3) {
                            if (this.kz) {
                                Log.w("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + qVar3 + ", threadIndex = " + zVar.bl);
                            }
                            zVar.ok(true);
                        }
                    }
                }
            }
        }
    }

    private void a(List<q> list) {
        long totalBytes = this.ok.getTotalBytes();
        this.f49874z = totalBytes;
        if (totalBytes <= 0) {
            this.f49874z = this.ok.getExpectFileLength();
            com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.f49874z);
        }
        synchronized (this) {
            this.rh.clear();
            if (list != null && !list.isEmpty()) {
                for (q qVar : list) {
                    ok((List<q>) this.rh, new q(qVar), false);
                }
                s(this.rh);
                bl(this.rh);
                com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "initSegments: totalLength = " + this.f49874z);
            }
            ok((List<q>) this.rh, new q(0L, -1L), false);
            com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "initSegments: totalLength = " + this.f49874z);
        }
    }

    private void bl() throws BaseException, InterruptedException {
        BaseException baseException;
        synchronized (this.zz) {
            if (this.f49862k == null && this.f49868r == null) {
                this.zz.wait();
            }
        }
        if (this.f49862k == null && this.f49868r == null && (baseException = this.f49872x) != null) {
            throw baseException;
        }
    }

    private void h() {
        rh rhVar = this.f49857a;
        this.f49865o = rhVar.k();
        this.f49873y = rhVar.r();
        this.ep = rhVar.t();
        int i4 = this.vz;
        if (i4 > 0) {
            this.f49860io.ok(this.er, i4);
        }
    }

    private void kf() {
        this.f49867q.add(new x(this.ok.getUrl(), true));
        List<String> backUpUrls = this.ok.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.f49867q.add(new x(str, false));
                }
            }
        }
        this.f49857a.ok(this.f49867q.size());
    }

    private void n() {
        int i4;
        if (this.f49874z <= 0 || this.f49861j) {
            i4 = 1;
        } else {
            i4 = this.f49857a.ok();
            int p3 = (int) (this.f49874z / this.f49857a.p());
            if (i4 > p3) {
                i4 = p3;
            }
        }
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.f49874z + ", threadCount = " + i4);
        int i5 = i4 > 0 ? i4 : 1;
        synchronized (this) {
            do {
                if (this.f49866p.size() >= i5) {
                    break;
                }
                if (!this.f49858h && !this.kf) {
                    ok(k());
                }
                return;
            } while (!this.f49857a.kf());
        }
    }

    private void s() throws BaseException {
        try {
            this.f49864n.ok((s) this.bl);
        } catch (i unused) {
        } catch (BaseException e4) {
            com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e4);
            ok(e4);
            throw e4;
        }
        if (this.f49858h || this.kf) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.rh.isEmpty()) {
                    q poll = this.rh.poll();
                    if (poll != null) {
                        ok(this.f49870t, poll, true);
                    }
                }
                bl(this.f49870t);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.ul && this.f49872x != null) {
            com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.f49872x);
            throw this.f49872x;
        }
        if (this.ok.getCurBytes() != this.ok.getTotalBytes()) {
            com.ss.android.socialbase.downloader.s.ok.ok(this.ok, this.f49870t);
        }
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "dispatchSegments::download finished");
    }

    public boolean ok(List<q> list) throws BaseException, InterruptedException {
        try {
            kf();
            a(list);
            n();
            h();
            q();
            long currentTimeMillis = System.currentTimeMillis();
            bl();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            this.ok.increaseAllConnectTime(currentTimeMillis2);
            this.ok.setFirstSpeedTime(currentTimeMillis2);
            if (!this.f49858h && !this.kf) {
                this.f49869s.ok(this.f49874z);
                p();
                s();
                return true;
            }
            if (!this.f49858h && !this.kf) {
                com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "finally pause");
                a();
            }
            this.f49860io.a();
            return true;
        } finally {
            if (!this.f49858h && !this.kf) {
                com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "finally pause");
                a();
            }
            this.f49860io.a();
        }
    }

    private void bl(List<q> list) {
        long a4 = t.a(list);
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.ok.getCurBytes() + ", totalBytes = " + this.ok.getTotalBytes() + ", downloadedBytes = " + a4);
        if (a4 > this.ok.getTotalBytes() && this.ok.getTotalBytes() > 0) {
            a4 = this.ok.getTotalBytes();
        }
        if (this.ok.getCurBytes() == this.ok.getTotalBytes() || this.ok.getCurBytes() == a4) {
            return;
        }
        this.ok.setCurBytes(a4);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
        if ((r10.n() - r24.n()) < (r14 / 2)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01f2, code lost:
        r3 = r3 + 1;
        r6 = r22.f49870t.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01fa, code lost:
        if (r3 >= r6) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01fc, code lost:
        r7 = r22.f49870t.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x020c, code lost:
        if (r7.ok() > 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0210, code lost:
        if (r7.ok == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0213, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0216, code lost:
        r11 = r24.kf();
        r15 = r7.bl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0220, code lost:
        if (r11 <= 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0224, code lost:
        if (r11 < r15) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0226, code lost:
        r9 = r15 - 1;
        r24.bl(r9);
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "applySegment: segment set end:" + r9 + ", later = " + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0247, code lost:
        android.util.Log.d("SegmentDispatcher", "applySegmentLocked: break 2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x024c, code lost:
        r6 = r24.kf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0254, code lost:
        if (r6 <= 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0258, code lost:
        if (r20 > r6) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0260, code lost:
        if (r24.n() > r6) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0278, code lost:
        throw new com.ss.android.socialbase.downloader.kf.k(6, "applySegment: " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0279, code lost:
        r24.ok = r23;
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "applySegment: OK " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x028f, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void n(com.ss.android.socialbase.downloader.kf.z r23, com.ss.android.socialbase.downloader.kf.q r24) throws com.ss.android.socialbase.downloader.kf.k {
        /*
            Method dump skipped, instructions count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kf.r.n(com.ss.android.socialbase.downloader.kf.z, com.ss.android.socialbase.downloader.kf.q):void");
    }

    private void a(String str, List<x> list) {
        int ok;
        if (this.kz) {
            Iterator<x> it = list.iterator();
            while (it.hasNext()) {
                Log.i("SegmentDispatcher", "addIpListLocked: urlRecord = " + it.next());
            }
        }
        int j4 = this.f49857a.j();
        if ((j4 == 1 || j4 == 3) && (ok = ok(str)) >= 0 && ok < this.f49867q.size()) {
            this.f49867q.addAll(ok + 1, list);
        } else {
            this.f49867q.addAll(list);
        }
    }

    private List<x> bl(String str, List<InetAddress> list) {
        boolean z3;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i4 = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.kz) {
                            Log.i("SegmentDispatcher", "onDnsResolved: ip = " + hostAddress);
                        }
                        x xVar = new x(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(xVar.bl);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(xVar.bl, linkedList);
                        }
                        linkedList.add(xVar);
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
                            arrayList.add((x) linkedList2.pollFirst());
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

    private void s(List<q> list) {
        q qVar = list.get(0);
        long bl = qVar.bl();
        if (bl > 0) {
            q qVar2 = new q(0L, bl - 1);
            Log.w("SegmentDispatcher", "fixSegmentsLocked: first = " + qVar + ", add new first = " + qVar2);
            ok(list, qVar2, true);
        }
        Iterator<q> it = list.iterator();
        if (it.hasNext()) {
            q next = it.next();
            while (it.hasNext()) {
                q next2 = it.next();
                if (next.kf() < next2.bl() - 1) {
                    com.ss.android.socialbase.downloader.bl.ok.s("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.bl() - 1));
                    next.bl(next2.bl() - 1);
                }
                next = next2;
            }
        }
        q qVar3 = list.get(list.size() - 1);
        long totalBytes = this.ok.getTotalBytes();
        if (totalBytes <= 0 || (qVar3.kf() != -1 && qVar3.kf() < totalBytes - 1)) {
            com.ss.android.socialbase.downloader.bl.ok.s("SegmentDispatcher", "fixSegment: last segment = " + qVar3 + ", new end=-1");
            qVar3.bl(-1L);
        }
    }

    private q a(z zVar, x xVar) {
        while (!this.rh.isEmpty()) {
            q poll = this.rh.poll();
            if (poll != null) {
                ok(this.f49870t, poll, true);
                if (ok(poll) > 0 || this.f49874z <= 0) {
                    return poll;
                }
            }
        }
        z();
        q bl = bl(zVar, xVar);
        if (bl != null && ok(bl) > 0) {
            ok(this.f49870t, bl, true);
            return bl;
        }
        q i4 = i();
        if (i4 != null) {
            return i4;
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void a(z zVar, q qVar) throws BaseException {
        synchronized (this) {
            n(zVar, qVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.network.bl.ok
    public void ok(String str, List<InetAddress> list) {
        if (this.f49858h || this.kf) {
            return;
        }
        List<x> list2 = null;
        try {
            list2 = bl(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this) {
            if (list2 != null) {
                a(str, list2);
            }
            this.f49861j = false;
            this.f49857a.ok(this.f49867q.size());
            Log.i("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
            n();
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void a(z zVar) {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "onReaderExit: threadIndex = " + zVar.bl);
        synchronized (this) {
            zVar.bl(true);
            this.f49866p.remove(zVar);
            z();
            if (this.f49866p.isEmpty()) {
                r();
            } else if (rh()) {
                Log.i("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                for (z zVar2 : this.f49866p) {
                    zVar2.n();
                }
                r();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void bl(z zVar, q qVar) {
        synchronized (this) {
            if (qVar.ok == zVar) {
                com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "unApplySegment " + qVar);
                qVar.s(zVar.s());
                qVar.ok = null;
                zVar.ok();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public n s(z zVar, q qVar) throws BaseException {
        n ok;
        synchronized (this) {
            j jVar = new j(this.ok, this.bl, qVar);
            this.f49864n.ok(jVar);
            ok = jVar.ok();
        }
        return ok;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bl(z zVar) {
        synchronized (this) {
            x s3 = s(zVar);
            if (s3 == null) {
                return false;
            }
            return zVar.ok(s3);
        }
    }

    private int ok(String str) {
        int size = this.f49867q.size();
        for (int i4 = 0; i4 < size; i4++) {
            if (TextUtils.equals(this.f49867q.get(i4).ok, str)) {
                return i4;
            }
        }
        return -1;
    }

    private x s(z zVar) {
        x xVar;
        Iterator<x> it = this.f49867q.iterator();
        x xVar2 = null;
        while (true) {
            if (!it.hasNext()) {
                xVar = null;
                break;
            }
            xVar = it.next();
            if (xVar != zVar.f49884a && !xVar.s()) {
                if (xVar2 == null) {
                    xVar2 = xVar;
                }
                if (xVar.ok() <= 0) {
                    break;
                }
            }
        }
        if (this.f49857a.a()) {
            if (xVar != null) {
                return xVar;
            }
            if (this.f49857a.bl()) {
                return null;
            }
        }
        return xVar2;
    }

    private void ok(List<q> list, q qVar, boolean z3) {
        long bl = qVar.bl();
        int size = list.size();
        int i4 = 0;
        while (i4 < size && bl >= list.get(i4).bl()) {
            i4++;
        }
        list.add(i4, qVar);
        if (z3) {
            qVar.ok(size);
        }
    }

    private void a(z zVar, q qVar, x xVar, com.ss.android.socialbase.downloader.model.s sVar) throws BaseException, com.ss.android.socialbase.downloader.exception.q {
        z zVar2 = qVar.ok;
        if (zVar2 != null && zVar2 != zVar) {
            throw new k(1, "segment already has an owner");
        }
        if (zVar.p() == qVar.n()) {
            if (!sVar.a()) {
                if (qVar.n() <= 0) {
                    com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + qVar.n());
                    if (!sVar.ok()) {
                        int i4 = sVar.bl;
                        throw new com.ss.android.socialbase.downloader.exception.a(1004, i4, "2: response code error : " + sVar.bl + " segment=" + qVar);
                    }
                } else {
                    int i5 = sVar.bl;
                    throw new com.ss.android.socialbase.downloader.exception.a(1004, i5, "1: response code error : " + sVar.bl + " segment=" + qVar);
                }
            }
            if (xVar.f49883s) {
                if (this.f49862k == null) {
                    this.f49862k = sVar;
                    synchronized (this.zz) {
                        this.zz.notify();
                    }
                    com.ss.android.socialbase.downloader.p.kf kfVar = this.f49869s;
                    if (kfVar != null) {
                        kfVar.ok(xVar.ok, sVar.f49969a, qVar.n());
                    }
                    long k4 = sVar.k();
                    if (k4 > 0) {
                        for (q qVar2 : this.f49870t) {
                            if (qVar2.kf() <= 0 || qVar2.kf() > k4 - 1) {
                                qVar2.bl(k4 - 1);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            ok(sVar);
            if (this.f49868r == null) {
                this.f49868r = sVar;
                if (this.ok.getTotalBytes() <= 0) {
                    long k5 = sVar.k();
                    com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "checkSegmentHttpResponse:len=" + k5 + ",url=" + xVar.ok);
                    this.ok.setTotalBytes(k5);
                }
                synchronized (this.zz) {
                    this.zz.notify();
                }
                return;
            }
            return;
        }
        throw new k(5, "applySegment");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.kf.q bl(com.ss.android.socialbase.downloader.kf.z r28, com.ss.android.socialbase.downloader.kf.x r29) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kf.r.bl(com.ss.android.socialbase.downloader.kf.z, com.ss.android.socialbase.downloader.kf.x):com.ss.android.socialbase.downloader.kf.q");
    }

    private float s(z zVar, x xVar) {
        long a4 = zVar.a();
        int size = this.f49866p.size();
        if (size <= 1) {
            size = this.f49857a.ok();
        }
        float f4 = 1.0f;
        if (a4 <= 0) {
            float z3 = this.f49857a.z();
            if (z3 <= 0.0f || z3 >= 1.0f) {
                z3 = 1.0f / size;
            }
            if (zVar.bl == 0) {
                return z3;
            }
            if (size > 1) {
                f4 = 1.0f - z3;
                size--;
            }
        } else {
            long t3 = t();
            if (t3 > a4) {
                return ((float) a4) / ((float) t3);
            }
        }
        return f4 / size;
    }

    private void ok(x xVar) {
        z zVar = new z(this.ok, this, this.bl, xVar, this.f49866p.size());
        this.f49866p.add(zVar);
        zVar.ok(com.ss.android.socialbase.downloader.downloader.bl.x().submit(zVar));
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void ok(z zVar) {
        if (this.kz) {
            com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "onReaderRun, threadIndex = " + zVar.bl);
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public q ok(z zVar, x xVar) {
        if (this.kf || this.f49858h) {
            return null;
        }
        synchronized (this) {
            q a4 = a(zVar, xVar);
            if (a4 != null) {
                a4.p();
                if (a4.k() > 1) {
                    return new q(a4);
                }
            }
            return a4;
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void ok(z zVar, q qVar) {
        synchronized (this) {
            qVar.q();
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void ok(z zVar, q qVar, x xVar, com.ss.android.socialbase.downloader.model.s sVar) throws BaseException, com.ss.android.socialbase.downloader.exception.q {
        synchronized (this) {
            if (!this.kf && !this.f49858h) {
                a(zVar, qVar, xVar, sVar);
                zVar.a(false);
                if (this.f49874z <= 0) {
                    long totalBytes = this.ok.getTotalBytes();
                    this.f49874z = totalBytes;
                    if (totalBytes <= 0) {
                        this.f49874z = sVar.k();
                    }
                    n();
                } else if (this.f49857a.kf()) {
                    n();
                }
            } else {
                throw new i("connected");
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void ok(z zVar, x xVar, q qVar, BaseException baseException, int i4, int i5) {
        com.ss.android.socialbase.downloader.q.kf.a(baseException);
        int errorCode = baseException.getErrorCode();
        if (((errorCode == 1047 || errorCode == 1074 || errorCode == 1055) ? true : true) || i4 >= i5) {
            bl(zVar);
        }
    }

    public void a() {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "pause1");
        this.f49858h = true;
        synchronized (this) {
            for (z zVar : this.f49866p) {
                zVar.n();
            }
        }
        this.f49864n.a();
        this.bl.bl();
    }

    @Override // com.ss.android.socialbase.downloader.kf.kf
    public void ok(z zVar, x xVar, q qVar, BaseException baseException) {
        synchronized (this) {
            com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", "onSegmentFailed: segment = " + qVar + ", e = " + baseException);
            zVar.a(true);
            if (zVar.bl == 0) {
                this.f49872x = baseException;
            }
            if (j()) {
                if (this.f49872x == null) {
                    this.f49872x = baseException;
                }
                this.ul = true;
                ok(this.f49872x);
            }
        }
    }

    private void a(long j4) {
        this.f49871u.ok(this.ok.getCurBytes(), j4);
        for (z zVar : this.f49866p) {
            zVar.a(j4);
        }
    }

    private void ok(BaseException baseException) {
        com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", "onError, e = " + baseException);
        this.f49872x = baseException;
        this.bl.bl();
        synchronized (this) {
            for (z zVar : this.f49866p) {
                zVar.n();
            }
        }
    }

    private void ok(com.ss.android.socialbase.downloader.model.s sVar) throws BaseException {
        com.ss.android.socialbase.downloader.model.s sVar2 = this.f49862k;
        if (sVar2 == null && (sVar2 = this.f49868r) == null) {
            return;
        }
        long k4 = sVar.k();
        long k5 = sVar2.k();
        if (k4 != k5) {
            String str = "total len not equals,len=" + k4 + ",sLen=" + k5 + ",code=" + sVar.bl + ",sCode=" + sVar2.bl + ",range=" + sVar.n() + ",sRange = " + sVar2.n() + ",url = " + sVar.ok + ",sUrl=" + sVar2.ok;
            com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", str);
            if (k4 > 0 && k5 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String bl = sVar.bl();
        String bl2 = sVar2.bl();
        if (TextUtils.equals(bl, bl2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + bl + ", mainEtag = " + bl2;
        com.ss.android.socialbase.downloader.bl.ok.n("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(bl) && !TextUtils.isEmpty(bl2) && !bl.equalsIgnoreCase(bl2)) {
            throw new BaseException(1074, str2);
        }
    }

    public void ok() {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "cancel");
        this.kf = true;
        synchronized (this) {
            for (z zVar : this.f49866p) {
                zVar.n();
            }
        }
        this.f49864n.ok();
        this.bl.bl();
    }

    private int ok(long j4) {
        int size = this.f49870t.size();
        for (int i4 = 0; i4 < size; i4++) {
            q qVar = this.f49870t.get(i4);
            if (qVar.bl() == j4) {
                return i4;
            }
            if (qVar.bl() > j4) {
                return -1;
            }
        }
        return -1;
    }

    private long ok(int i4, int i5) {
        q qVar = this.f49870t.get(i4);
        long ok = ok(qVar);
        int i6 = i4 + 1;
        q qVar2 = i6 < i5 ? this.f49870t.get(i6) : null;
        if (qVar2 == null) {
            return ok;
        }
        long bl = qVar2.bl() - qVar.n();
        return ok == -1 ? bl : Math.min(ok, bl);
    }

    private long ok(q qVar) {
        long a4 = qVar.a();
        if (a4 == -1) {
            long j4 = this.f49874z;
            return j4 > 0 ? j4 - qVar.n() : a4;
        }
        return a4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public z ok(boolean z3, long j4, long j5) {
        z zVar = null;
        for (z zVar2 : this.f49866p) {
            if (zVar2.bl != 0 || z3) {
                if (zVar2.f49898s > 0 && zVar2.f49893n <= 0 && j4 - zVar2.f49898s > j5 && (zVar == null || zVar2.f49898s < zVar.f49898s)) {
                    zVar = zVar2;
                }
            }
        }
        return zVar;
    }

    private boolean ok(z zVar, long j4, long j5, long j6, double d4) {
        if (zVar.kf > 0) {
            long a4 = this.f49871u.a(j4, j5);
            int size = this.f49866p.size();
            long j7 = size > 0 ? a4 / size : a4;
            long ok = zVar.ok(j4, j5);
            if (ok >= j6) {
                double d5 = j7;
                Double.isNaN(d5);
                if (ok >= d5 * d4) {
                    return false;
                }
            }
            Log.i("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + a4 + ", threadAvgSpeed = " + j7 + ", poorSpeed = " + j6 + ", speed = " + ok + ",threadIndex = " + zVar.bl);
            return true;
        }
        return false;
    }

    private boolean ok(long j4, long j5) {
        long j6 = j4 - j5;
        long a4 = this.f49871u.a(j6, j4);
        int size = this.f49866p.size();
        if (size > 0) {
            a4 /= size;
        }
        z ok = ok(j6, j4, Math.max(10.0f, ((float) a4) * this.ep), size / 2);
        if (ok != null) {
            bl(ok);
            com.ss.android.socialbase.downloader.bl.ok.s("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + ok.bl);
            ok.kf();
            return true;
        }
        z ok2 = ok(true, j4, j5);
        if (ok2 != null) {
            bl(ok2);
            com.ss.android.socialbase.downloader.bl.ok.s("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + ok2.bl);
            ok2.kf();
            return true;
        }
        return false;
    }

    private z ok(long j4, long j5, long j6, int i4) {
        long j7;
        long j8 = Long.MAX_VALUE;
        int i5 = 0;
        z zVar = null;
        for (z zVar2 : this.f49866p) {
            if (zVar2.kf > 0) {
                i5++;
                long j9 = j8;
                if (zVar2.kf < j4) {
                    long ok = zVar2.ok(j4, j5);
                    if (this.kz) {
                        Log.i("SegmentDispatcher", "findPoorReadThread: speed = " + ok + ", threadIndex = " + zVar2.bl);
                        j7 = 0;
                    } else {
                        j7 = 0;
                    }
                    if (ok >= j7 && ok < j9) {
                        j8 = ok;
                        zVar = zVar2;
                    }
                }
                j8 = j9;
            }
        }
        long j10 = j8;
        if (zVar == null || i5 < i4 || j10 >= j6) {
            return null;
        }
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j10 + ", threadIndex = " + zVar.bl);
        return zVar;
    }
}
