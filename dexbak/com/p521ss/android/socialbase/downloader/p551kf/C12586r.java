package com.p521ss.android.socialbase.downloader.p551kf;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.exception.C12525a;
import com.p521ss.android.socialbase.downloader.exception.C12532q;
import com.p521ss.android.socialbase.downloader.model.C12607s;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.network.C12614bl;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p555p.C12659n;
import com.p521ss.android.socialbase.downloader.p555p.InterfaceC12658kf;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12714n;
import com.p521ss.android.socialbase.downloader.p557s.C12723ok;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.ss.android.socialbase.downloader.kf.r */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12586r implements InterfaceC12580kf, C12614bl.InterfaceC12619ok {

    /* renamed from: a */
    private final C12589rh f35355a;

    /* renamed from: bl */
    private final C12574a f35356bl;

    /* renamed from: ep */
    private float f35357ep;

    /* renamed from: i */
    private int f35361i;

    /* renamed from: io */
    private final C12659n f35362io;

    /* renamed from: k */
    private C12607s f35364k;

    /* renamed from: kz */
    private final boolean f35366kz;

    /* renamed from: m */
    private long f35367m;

    /* renamed from: n */
    private final C12576h f35368n;

    /* renamed from: o */
    private long f35369o;

    /* renamed from: ok */
    private final DownloadInfo f35370ok;

    /* renamed from: r */
    private C12607s f35373r;

    /* renamed from: s */
    private final InterfaceC12658kf f35375s;

    /* renamed from: td */
    private volatile boolean f35377td;

    /* renamed from: u */
    private final C12714n f35378u;

    /* renamed from: vz */
    private int f35380vz;

    /* renamed from: x */
    private BaseException f35381x;

    /* renamed from: y */
    private long f35382y;

    /* renamed from: z */
    private long f35383z;

    /* renamed from: kf */
    private volatile boolean f35365kf = false;

    /* renamed from: h */
    private volatile boolean f35360h = false;

    /* renamed from: p */
    private final List<RunnableC12593z> f35371p = new ArrayList();

    /* renamed from: q */
    private final List<C12592x> f35372q = new ArrayList();

    /* renamed from: j */
    private volatile boolean f35363j = true;

    /* renamed from: rh */
    private final LinkedList<C12584q> f35374rh = new LinkedList<>();

    /* renamed from: t */
    private final List<C12584q> f35376t = new ArrayList();

    /* renamed from: zz */
    private final Object f35384zz = new Object();

    /* renamed from: ul */
    private volatile boolean f35379ul = false;

    /* renamed from: er */
    private final C12659n.InterfaceC12660a f35358er = new C12659n.InterfaceC12660a() { // from class: com.ss.android.socialbase.downloader.kf.r.1

        /* renamed from: a */
        private int f35385a;

        @Override // com.p521ss.android.socialbase.downloader.p555p.C12659n.InterfaceC12660a
        /* renamed from: ok */
        public long mo16746ok() {
            if (C12586r.this.f35365kf || C12586r.this.f35360h) {
                return -1L;
            }
            synchronized (C12586r.this) {
                if (C12586r.this.f35364k == null && C12586r.this.f35373r == null) {
                    long j = C12586r.this.f35369o;
                    if (j <= 0) {
                        return -1L;
                    }
                    this.f35385a++;
                    RunnableC12593z m17229ok = C12586r.this.m17229ok(false, System.currentTimeMillis(), j);
                    if (m17229ok != null) {
                        Log.i("SegmentDispatcher", "connectWatcher: switchUrl and reconnect");
                        C12586r.this.m17266bl(m17229ok);
                        m17229ok.m17173kf();
                        return ((this.f35385a / C12586r.this.f35372q.size()) + 1) * j;
                    }
                    return j;
                }
                return -1L;
            }
        }
    };

    /* renamed from: fb */
    private final C12659n.InterfaceC12660a f35359fb = new C12659n.InterfaceC12660a() { // from class: com.ss.android.socialbase.downloader.kf.r.2
        @Override // com.p521ss.android.socialbase.downloader.p555p.C12659n.InterfaceC12660a
        /* renamed from: ok */
        public long mo16746ok() {
            return C12586r.this.m17217td();
        }
    };

    public C12586r(@NonNull DownloadInfo downloadInfo, @NonNull C12589rh c12589rh, InterfaceC12658kf interfaceC12658kf) {
        this.f35370ok = downloadInfo;
        this.f35355a = c12589rh;
        C12574a c12574a = new C12574a(c12589rh.m17198s(), c12589rh.m17206n());
        this.f35356bl = c12574a;
        this.f35375s = interfaceC12658kf;
        this.f35368n = new C12576h(downloadInfo, interfaceC12658kf, c12574a);
        this.f35362io = new C12659n();
        this.f35378u = new C12714n();
        this.f35366kz = C12534ok.m17599ok(downloadInfo.getId()).m17607a("debug") == 1;
    }

    /* renamed from: i */
    private C12584q m17259i() {
        int i = 0;
        while (true) {
            C12584q m17216x = m17216x();
            if (m17216x == null) {
                return null;
            }
            RunnableC12593z runnableC12593z = m17216x.f35352ok;
            if (runnableC12593z == null) {
                return m17216x;
            }
            if (m17216x.m17290k() >= 2) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            m17276a(currentTimeMillis);
            if (currentTimeMillis - runnableC12593z.f35415kf > 2000 && m17239ok(runnableC12593z, currentTimeMillis - 2000, currentTimeMillis, 500L, 1.0d)) {
                if (this.f35366kz) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: isDownloadSpeedPoor segment = " + m17216x + ", owner.threadIndex = " + runnableC12593z.f35401bl);
                }
                return m17216x;
            }
            int i2 = i + 1;
            if (i > 2) {
                if (this.f35366kz) {
                    Log.i("SegmentDispatcher", "obtainSegmentWhenNoNewSegment: waitCount > 2, return segment = " + m17216x);
                }
                return m17216x;
            }
            try {
                synchronized (this) {
                    wait(500L);
                }
                i = i2;
            } catch (InterruptedException unused) {
                return null;
            }
        }
    }

    /* renamed from: j */
    private boolean m17258j() {
        for (RunnableC12593z runnableC12593z : this.f35371p) {
            if (!runnableC12593z.m17176h()) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: k */
    private C12592x m17257k() {
        C12592x c12592x;
        synchronized (this) {
            int size = this.f35361i % this.f35372q.size();
            if (this.f35355a.m17214a()) {
                this.f35361i++;
            }
            c12592x = this.f35372q.get(size);
        }
        return c12592x;
    }

    /* renamed from: p */
    private void m17228p() {
        if (this.f35382y > 0) {
            this.f35367m = System.currentTimeMillis();
            this.f35362io.m16747ok(this.f35359fb, 0L);
        }
    }

    /* renamed from: q */
    private void m17227q() {
        List<String> backUpUrls;
        int m17209j = this.f35355a.m17209j();
        if (m17209j <= 0) {
            this.f35363j = false;
            m17254n();
            return;
        }
        C12614bl m16952ok = C12614bl.m16952ok();
        m16952ok.m16950ok(this.f35370ok.getUrl(), this, 2000L);
        if (m17209j <= 2 || (backUpUrls = this.f35370ok.getBackUpUrls()) == null) {
            return;
        }
        for (String str : backUpUrls) {
            if (!TextUtils.isEmpty(str)) {
                m16952ok.m16950ok(str, this, 2000L);
            }
        }
    }

    /* renamed from: r */
    private void m17226r() {
        C12409ok.m17901bl("SegmentDispatcher", "onComplete");
        this.f35356bl.m17318bl();
        synchronized (this.f35384zz) {
            this.f35384zz.notify();
        }
    }

    /* renamed from: rh */
    private boolean m17225rh() {
        long j = this.f35383z;
        if (j <= 0) {
            this.f35377td = false;
            return false;
        }
        synchronized (this) {
            long m17193ok = C12591t.m17193ok(this.f35376t);
            C12409ok.m17901bl("SegmentDispatcher", "isAllContentDownloaded: firstOffset = " + m17193ok);
            if (m17193ok >= j) {
                this.f35377td = true;
                return true;
            }
            this.f35377td = false;
            return false;
        }
    }

    /* renamed from: t */
    private long m17218t() {
        long j = 0;
        for (RunnableC12593z runnableC12593z : this.f35371p) {
            j += runnableC12593z.m17183a();
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: td */
    public long m17217td() {
        if (this.f35365kf || this.f35360h) {
            return -1L;
        }
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (this) {
            m17276a(currentTimeMillis);
            long m17200r = this.f35355a.m17200r();
            if (m17200r > 0) {
                long j = this.f35367m;
                if (j > 0 && currentTimeMillis - j > m17200r && m17248ok(currentTimeMillis, m17200r)) {
                    this.f35367m = currentTimeMillis;
                    this.f35380vz++;
                }
            }
        }
        return 2000L;
    }

    /* renamed from: x */
    private C12584q m17216x() {
        int m17290k;
        C12584q c12584q = null;
        int i = Integer.MAX_VALUE;
        for (C12584q c12584q2 : this.f35376t) {
            if (m17245ok(c12584q2) > 0 && (m17290k = c12584q2.m17290k()) < i) {
                c12584q = c12584q2;
                i = m17290k;
            }
        }
        return c12584q;
    }

    /* renamed from: z */
    private void m17215z() {
        int size;
        if (this.f35383z > 0 && (size = this.f35376t.size()) > 1) {
            ArrayList<C12584q> arrayList = null;
            int i = 0;
            for (int i2 = 1; i2 < size; i2++) {
                C12584q c12584q = this.f35376t.get(i);
                C12584q c12584q2 = this.f35376t.get(i2);
                if (c12584q.m17288n() > c12584q2.m17293bl() && c12584q2.m17287ok() <= 0 && c12584q2.f35352ok == null) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(c12584q2);
                    if (this.f35366kz) {
                        Log.w("SegmentDispatcher", "clearCovered, covered = " + c12584q2 + ", prev = " + c12584q);
                    }
                } else if (c12584q2.m17288n() > c12584q.m17288n()) {
                    i++;
                }
            }
            if (arrayList != null) {
                for (C12584q c12584q3 : arrayList) {
                    this.f35376t.remove(c12584q3);
                    for (RunnableC12593z runnableC12593z : this.f35371p) {
                        if (runnableC12593z.f35420ok == c12584q3) {
                            if (this.f35366kz) {
                                Log.w("SegmentDispatcher", "clearCoveredSegmentLocked: reconnect, segment = " + c12584q3 + ", threadIndex = " + runnableC12593z.f35401bl);
                            }
                            runnableC12593z.m17162ok(true);
                        }
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m17269a(List<C12584q> list) {
        long totalBytes = this.f35370ok.getTotalBytes();
        this.f35383z = totalBytes;
        if (totalBytes <= 0) {
            this.f35383z = this.f35370ok.getExpectFileLength();
            C12409ok.m17901bl("SegmentDispatcher", "initSegments: getExpectFileLength = " + this.f35383z);
        }
        synchronized (this) {
            this.f35374rh.clear();
            if (list != null && !list.isEmpty()) {
                for (C12584q c12584q : list) {
                    m17230ok((List<C12584q>) this.f35374rh, new C12584q(c12584q), false);
                }
                m17219s(this.f35374rh);
                m17262bl(this.f35374rh);
                C12409ok.m17901bl("SegmentDispatcher", "initSegments: totalLength = " + this.f35383z);
            }
            m17230ok((List<C12584q>) this.f35374rh, new C12584q(0L, -1L), false);
            C12409ok.m17901bl("SegmentDispatcher", "initSegments: totalLength = " + this.f35383z);
        }
    }

    /* renamed from: bl */
    private void m17268bl() throws BaseException, InterruptedException {
        BaseException baseException;
        synchronized (this.f35384zz) {
            if (this.f35364k == null && this.f35373r == null) {
                this.f35384zz.wait();
            }
        }
        if (this.f35364k == null && this.f35373r == null && (baseException = this.f35381x) != null) {
            throw baseException;
        }
    }

    /* renamed from: h */
    private void m17261h() {
        C12589rh c12589rh = this.f35355a;
        this.f35369o = c12589rh.m17208k();
        this.f35382y = c12589rh.m17200r();
        this.f35357ep = c12589rh.m17197t();
        int i = this.f35380vz;
        if (i > 0) {
            this.f35362io.m16747ok(this.f35358er, i);
        }
    }

    /* renamed from: kf */
    private void m17256kf() {
        this.f35372q.add(new C12592x(this.f35370ok.getUrl(), true));
        List<String> backUpUrls = this.f35370ok.getBackUpUrls();
        if (backUpUrls != null) {
            for (String str : backUpUrls) {
                if (!TextUtils.isEmpty(str)) {
                    this.f35372q.add(new C12592x(str, false));
                }
            }
        }
        this.f35355a.m17204ok(this.f35372q.size());
    }

    /* renamed from: n */
    private void m17254n() {
        int i;
        if (this.f35383z <= 0 || this.f35363j) {
            i = 1;
        } else {
            i = this.f35355a.m17205ok();
            int m17202p = (int) (this.f35383z / this.f35355a.m17202p());
            if (i > m17202p) {
                i = m17202p;
            }
        }
        C12409ok.m17901bl("SegmentDispatcher", "dispatchReadThread: totalLength = " + this.f35383z + ", threadCount = " + i);
        int i2 = i > 0 ? i : 1;
        synchronized (this) {
            do {
                if (this.f35371p.size() >= i2) {
                    break;
                }
                if (!this.f35360h && !this.f35365kf) {
                    m17241ok(m17257k());
                }
                return;
            } while (!this.f35355a.m17207kf());
        }
    }

    /* renamed from: s */
    private void m17224s() throws BaseException {
        try {
            this.f35368n.m17306ok((InterfaceC12590s) this.f35356bl);
        } catch (C12577i unused) {
        } catch (BaseException e) {
            C12409ok.m17900n("SegmentDispatcher", "dispatchSegments: loopAndWrite e = " + e);
            m17246ok(e);
            throw e;
        }
        if (this.f35360h || this.f35365kf) {
            return;
        }
        try {
            synchronized (this) {
                while (!this.f35374rh.isEmpty()) {
                    C12584q poll = this.f35374rh.poll();
                    if (poll != null) {
                        m17230ok(this.f35376t, poll, true);
                    }
                }
                m17262bl(this.f35376t);
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        if (this.f35379ul && this.f35381x != null) {
            C12409ok.m17900n("SegmentDispatcher", "dispatchSegments: loopAndWrite  failedException = " + this.f35381x);
            throw this.f35381x;
        }
        if (this.f35370ok.getCurBytes() != this.f35370ok.getTotalBytes()) {
            C12723ok.m16489ok(this.f35370ok, this.f35376t);
        }
        C12409ok.m17901bl("SegmentDispatcher", "dispatchSegments::download finished");
    }

    /* renamed from: ok */
    public boolean m17231ok(List<C12584q> list) throws BaseException, InterruptedException {
        try {
            m17256kf();
            m17269a(list);
            m17254n();
            m17261h();
            m17227q();
            long currentTimeMillis = System.currentTimeMillis();
            m17268bl();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            this.f35370ok.increaseAllConnectTime(currentTimeMillis2);
            this.f35370ok.setFirstSpeedTime(currentTimeMillis2);
            if (!this.f35360h && !this.f35365kf) {
                this.f35375s.mo16757ok(this.f35383z);
                m17228p();
                m17224s();
                return true;
            }
            if (!this.f35360h && !this.f35365kf) {
                C12409ok.m17901bl("SegmentDispatcher", "finally pause");
                m17277a();
            }
            this.f35362io.m16749a();
            return true;
        } finally {
            if (!this.f35360h && !this.f35365kf) {
                C12409ok.m17901bl("SegmentDispatcher", "finally pause");
                m17277a();
            }
            this.f35362io.m16749a();
        }
    }

    /* renamed from: bl */
    private void m17262bl(List<C12584q> list) {
        long m17194a = C12591t.m17194a(list);
        C12409ok.m17901bl("SegmentDispatcher", "checkDownloadBytes: getCurBytes = " + this.f35370ok.getCurBytes() + ", totalBytes = " + this.f35370ok.getTotalBytes() + ", downloadedBytes = " + m17194a);
        if (m17194a > this.f35370ok.getTotalBytes() && this.f35370ok.getTotalBytes() > 0) {
            m17194a = this.f35370ok.getTotalBytes();
        }
        if (this.f35370ok.getCurBytes() == this.f35370ok.getTotalBytes() || this.f35370ok.getCurBytes() == m17194a) {
            return;
        }
        this.f35370ok.setCurBytes(m17194a);
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x00a1, code lost:
        if ((r10.m17288n() - r24.m17288n()) < (r14 / 2)) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x01f2, code lost:
        r3 = r3 + 1;
        r6 = r22.f35376t.size();
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x01fa, code lost:
        if (r3 >= r6) goto L81;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x01fc, code lost:
        r7 = r22.f35376t.get(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x020c, code lost:
        if (r7.m17287ok() > 0) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x0210, code lost:
        if (r7.f35352ok == null) goto L62;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0213, code lost:
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0216, code lost:
        r11 = r24.m17289kf();
        r15 = r7.m17293bl();
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0220, code lost:
        if (r11 <= 0) goto L79;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0224, code lost:
        if (r11 < r15) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0226, code lost:
        r9 = r15 - 1;
        r24.m17292bl(r9);
        com.p521ss.android.socialbase.downloader.p549bl.C12409ok.m17901bl("SegmentDispatcher", "applySegment: segment set end:" + r9 + ", later = " + r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:81:0x0247, code lost:
        android.util.Log.d("SegmentDispatcher", "applySegmentLocked: break 2");
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x024c, code lost:
        r6 = r24.m17289kf();
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0254, code lost:
        if (r6 <= 0) goto L77;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x0258, code lost:
        if (r20 > r6) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0260, code lost:
        if (r24.m17288n() > r6) goto L75;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x0278, code lost:
        throw new com.p521ss.android.socialbase.downloader.p551kf.C12579k(6, "applySegment: " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x0279, code lost:
        r24.f35352ok = r23;
        com.p521ss.android.socialbase.downloader.p549bl.C12409ok.m17901bl("SegmentDispatcher", "applySegment: OK " + r24);
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x028f, code lost:
        return;
     */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0107  */
    /* renamed from: n */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m17252n(com.p521ss.android.socialbase.downloader.p551kf.RunnableC12593z r23, com.p521ss.android.socialbase.downloader.p551kf.C12584q r24) throws com.p521ss.android.socialbase.downloader.p551kf.C12579k {
        /*
            Method dump skipped, instructions count: 738
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p551kf.C12586r.m17252n(com.ss.android.socialbase.downloader.kf.z, com.ss.android.socialbase.downloader.kf.q):void");
    }

    /* renamed from: a */
    private void m17270a(String str, List<C12592x> list) {
        int m17232ok;
        if (this.f35366kz) {
            Iterator<C12592x> it = list.iterator();
            while (it.hasNext()) {
                Log.i("SegmentDispatcher", "addIpListLocked: urlRecord = " + it.next());
            }
        }
        int m17209j = this.f35355a.m17209j();
        if ((m17209j == 1 || m17209j == 3) && (m17232ok = m17232ok(str)) >= 0 && m17232ok < this.f35372q.size()) {
            this.f35372q.addAll(m17232ok + 1, list);
        } else {
            this.f35372q.addAll(list);
        }
    }

    /* renamed from: bl */
    private List<C12592x> m17263bl(String str, List<InetAddress> list) {
        boolean z;
        if (list != null && !list.isEmpty()) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            for (InetAddress inetAddress : list) {
                if (inetAddress != null) {
                    String hostAddress = inetAddress.getHostAddress();
                    if (!TextUtils.isEmpty(hostAddress)) {
                        if (this.f35366kz) {
                            Log.i("SegmentDispatcher", "onDnsResolved: ip = " + hostAddress);
                        }
                        C12592x c12592x = new C12592x(str, hostAddress);
                        LinkedList linkedList = (LinkedList) linkedHashMap.get(c12592x.f35391bl);
                        if (linkedList == null) {
                            linkedList = new LinkedList();
                            linkedHashMap.put(c12592x.f35391bl, linkedList);
                        }
                        linkedList.add(c12592x);
                        i++;
                    }
                }
            }
            if (i > 0) {
                ArrayList arrayList = new ArrayList();
                do {
                    z = false;
                    for (Map.Entry entry : linkedHashMap.entrySet()) {
                        LinkedList linkedList2 = (LinkedList) entry.getValue();
                        if (linkedList2 != null && !linkedList2.isEmpty()) {
                            arrayList.add((C12592x) linkedList2.pollFirst());
                            i--;
                            z = true;
                        }
                    }
                    if (i <= 0) {
                        break;
                    }
                } while (z);
                return arrayList;
            }
        }
        return null;
    }

    /* renamed from: s */
    private void m17219s(List<C12584q> list) {
        C12584q c12584q = list.get(0);
        long m17293bl = c12584q.m17293bl();
        if (m17293bl > 0) {
            C12584q c12584q2 = new C12584q(0L, m17293bl - 1);
            Log.w("SegmentDispatcher", "fixSegmentsLocked: first = " + c12584q + ", add new first = " + c12584q2);
            m17230ok(list, c12584q2, true);
        }
        Iterator<C12584q> it = list.iterator();
        if (it.hasNext()) {
            C12584q next = it.next();
            while (it.hasNext()) {
                C12584q next2 = it.next();
                if (next.m17289kf() < next2.m17293bl() - 1) {
                    C12409ok.m17894s("SegmentDispatcher", "fixSegment: segment = " + next + ", new end = " + (next2.m17293bl() - 1));
                    next.m17292bl(next2.m17293bl() - 1);
                }
                next = next2;
            }
        }
        C12584q c12584q3 = list.get(list.size() - 1);
        long totalBytes = this.f35370ok.getTotalBytes();
        if (totalBytes <= 0 || (c12584q3.m17289kf() != -1 && c12584q3.m17289kf() < totalBytes - 1)) {
            C12409ok.m17894s("SegmentDispatcher", "fixSegment: last segment = " + c12584q3 + ", new end=-1");
            c12584q3.m17292bl(-1L);
        }
    }

    /* renamed from: a */
    private C12584q m17271a(RunnableC12593z runnableC12593z, C12592x c12592x) {
        while (!this.f35374rh.isEmpty()) {
            C12584q poll = this.f35374rh.poll();
            if (poll != null) {
                m17230ok(this.f35376t, poll, true);
                if (m17245ok(poll) > 0 || this.f35383z <= 0) {
                    return poll;
                }
            }
        }
        m17215z();
        C12584q m17264bl = m17264bl(runnableC12593z, c12592x);
        if (m17264bl != null && m17245ok(m17264bl) > 0) {
            m17230ok(this.f35376t, m17264bl, true);
            return m17264bl;
        }
        C12584q m17259i = m17259i();
        if (m17259i != null) {
            return m17259i;
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12580kf
    /* renamed from: a */
    public void mo17273a(RunnableC12593z runnableC12593z, C12584q c12584q) throws BaseException {
        synchronized (this) {
            m17252n(runnableC12593z, c12584q);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.network.C12614bl.InterfaceC12619ok
    /* renamed from: ok */
    public void mo16947ok(String str, List<InetAddress> list) {
        if (this.f35360h || this.f35365kf) {
            return;
        }
        List<C12592x> list2 = null;
        try {
            list2 = m17263bl(str, list);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        synchronized (this) {
            if (list2 != null) {
                m17270a(str, list2);
            }
            this.f35363j = false;
            this.f35355a.m17204ok(this.f35372q.size());
            Log.i("SegmentDispatcher", "onDnsResolved: dispatchReadThread");
            m17254n();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12580kf
    /* renamed from: a */
    public void mo17274a(RunnableC12593z runnableC12593z) {
        C12409ok.m17901bl("SegmentDispatcher", "onReaderExit: threadIndex = " + runnableC12593z.f35401bl);
        synchronized (this) {
            runnableC12593z.m17177bl(true);
            this.f35371p.remove(runnableC12593z);
            m17215z();
            if (this.f35371p.isEmpty()) {
                m17226r();
            } else if (m17225rh()) {
                Log.i("SegmentDispatcher", "onReaderExit: allContentDownloaded");
                for (RunnableC12593z runnableC12593z2 : this.f35371p) {
                    runnableC12593z2.m17172n();
                }
                m17226r();
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12580kf
    /* renamed from: bl */
    public void mo17265bl(RunnableC12593z runnableC12593z, C12584q c12584q) {
        synchronized (this) {
            if (c12584q.f35352ok == runnableC12593z) {
                C12409ok.m17901bl("SegmentDispatcher", "unApplySegment " + c12584q);
                c12584q.m17279s(runnableC12593z.m17158s());
                c12584q.f35352ok = null;
                runnableC12593z.m17171ok();
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12580kf
    /* renamed from: s */
    public InterfaceC12581n mo17221s(RunnableC12593z runnableC12593z, C12584q c12584q) throws BaseException {
        InterfaceC12581n m17300ok;
        synchronized (this) {
            C12578j c12578j = new C12578j(this.f35370ok, this.f35356bl, c12584q);
            this.f35368n.m17308ok(c12578j);
            m17300ok = c12578j.m17300ok();
        }
        return m17300ok;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: bl */
    public boolean m17266bl(RunnableC12593z runnableC12593z) {
        synchronized (this) {
            C12592x m17222s = m17222s(runnableC12593z);
            if (m17222s == null) {
                return false;
            }
            return runnableC12593z.m17164ok(m17222s);
        }
    }

    /* renamed from: ok */
    private int m17232ok(String str) {
        int size = this.f35372q.size();
        for (int i = 0; i < size; i++) {
            if (TextUtils.equals(this.f35372q.get(i).f35396ok, str)) {
                return i;
            }
        }
        return -1;
    }

    /* renamed from: s */
    private C12592x m17222s(RunnableC12593z runnableC12593z) {
        C12592x c12592x;
        Iterator<C12592x> it = this.f35372q.iterator();
        C12592x c12592x2 = null;
        while (true) {
            if (!it.hasNext()) {
                c12592x = null;
                break;
            }
            c12592x = it.next();
            if (c12592x != runnableC12593z.f35400a && !c12592x.m17184s()) {
                if (c12592x2 == null) {
                    c12592x2 = c12592x;
                }
                if (c12592x.m17188ok() <= 0) {
                    break;
                }
            }
        }
        if (this.f35355a.m17214a()) {
            if (c12592x != null) {
                return c12592x;
            }
            if (this.f35355a.m17212bl()) {
                return null;
            }
        }
        return c12592x2;
    }

    /* renamed from: ok */
    private void m17230ok(List<C12584q> list, C12584q c12584q, boolean z) {
        long m17293bl = c12584q.m17293bl();
        int size = list.size();
        int i = 0;
        while (i < size && m17293bl >= list.get(i).m17293bl()) {
            i++;
        }
        list.add(i, c12584q);
        if (z) {
            c12584q.m17286ok(size);
        }
    }

    /* renamed from: a */
    private void m17272a(RunnableC12593z runnableC12593z, C12584q c12584q, C12592x c12592x, C12607s c12607s) throws BaseException, C12532q {
        RunnableC12593z runnableC12593z2 = c12584q.f35352ok;
        if (runnableC12593z2 != null && runnableC12593z2 != runnableC12593z) {
            throw new C12579k(1, "segment already has an owner");
        }
        if (runnableC12593z.m17161p() == c12584q.m17288n()) {
            if (!c12607s.m16988a()) {
                if (c12584q.m17288n() <= 0) {
                    C12409ok.m17900n("SegmentDispatcher", "parseHttpResponse: segment.getCurrentOffsetRead = " + c12584q.m17288n());
                    if (!c12607s.m16982ok()) {
                        int i = c12607s.f35524bl;
                        throw new C12525a(1004, i, "2: response code error : " + c12607s.f35524bl + " segment=" + c12584q);
                    }
                } else {
                    int i2 = c12607s.f35524bl;
                    throw new C12525a(1004, i2, "1: response code error : " + c12607s.f35524bl + " segment=" + c12584q);
                }
            }
            if (c12592x.f35399s) {
                if (this.f35364k == null) {
                    this.f35364k = c12607s;
                    synchronized (this.f35384zz) {
                        this.f35384zz.notify();
                    }
                    InterfaceC12658kf interfaceC12658kf = this.f35375s;
                    if (interfaceC12658kf != null) {
                        interfaceC12658kf.mo16750ok(c12592x.f35396ok, c12607s.f35523a, c12584q.m17288n());
                    }
                    long m16985k = c12607s.m16985k();
                    if (m16985k > 0) {
                        for (C12584q c12584q2 : this.f35376t) {
                            if (c12584q2.m17289kf() <= 0 || c12584q2.m17289kf() > m16985k - 1) {
                                c12584q2.m17292bl(m16985k - 1);
                            }
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            m17233ok(c12607s);
            if (this.f35373r == null) {
                this.f35373r = c12607s;
                if (this.f35370ok.getTotalBytes() <= 0) {
                    long m16985k2 = c12607s.m16985k();
                    C12409ok.m17901bl("SegmentDispatcher", "checkSegmentHttpResponse:len=" + m16985k2 + ",url=" + c12592x.f35396ok);
                    this.f35370ok.setTotalBytes(m16985k2);
                }
                synchronized (this.f35384zz) {
                    this.f35384zz.notify();
                }
                return;
            }
            return;
        }
        throw new C12579k(5, "applySegment");
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b7  */
    /* renamed from: bl */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.p521ss.android.socialbase.downloader.p551kf.C12584q m17264bl(com.p521ss.android.socialbase.downloader.p551kf.RunnableC12593z r28, com.p521ss.android.socialbase.downloader.p551kf.C12592x r29) {
        /*
            Method dump skipped, instructions count: 495
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p551kf.C12586r.m17264bl(com.ss.android.socialbase.downloader.kf.z, com.ss.android.socialbase.downloader.kf.x):com.ss.android.socialbase.downloader.kf.q");
    }

    /* renamed from: s */
    private float m17220s(RunnableC12593z runnableC12593z, C12592x c12592x) {
        long m17183a = runnableC12593z.m17183a();
        int size = this.f35371p.size();
        if (size <= 1) {
            size = this.f35355a.m17205ok();
        }
        float f = 1.0f;
        if (m17183a <= 0) {
            float m17196z = this.f35355a.m17196z();
            if (m17196z <= 0.0f || m17196z >= 1.0f) {
                m17196z = 1.0f / size;
            }
            if (runnableC12593z.f35401bl == 0) {
                return m17196z;
            }
            if (size > 1) {
                f = 1.0f - m17196z;
                size--;
            }
        } else {
            long m17218t = m17218t();
            if (m17218t > m17183a) {
                return ((float) m17183a) / ((float) m17218t);
            }
        }
        return f / size;
    }

    /* renamed from: ok */
    private void m17241ok(C12592x c12592x) {
        RunnableC12593z runnableC12593z = new RunnableC12593z(this.f35370ok, this, this.f35356bl, c12592x, this.f35371p.size());
        this.f35371p.add(runnableC12593z);
        runnableC12593z.m17163ok(C12490bl.m17749x().submit(runnableC12593z));
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12580kf
    /* renamed from: ok */
    public void mo17240ok(RunnableC12593z runnableC12593z) {
        if (this.f35366kz) {
            C12409ok.m17901bl("SegmentDispatcher", "onReaderRun, threadIndex = " + runnableC12593z.f35401bl);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12580kf
    /* renamed from: ok */
    public C12584q mo17236ok(RunnableC12593z runnableC12593z, C12592x c12592x) {
        if (this.f35365kf || this.f35360h) {
            return null;
        }
        synchronized (this) {
            C12584q m17271a = m17271a(runnableC12593z, c12592x);
            if (m17271a != null) {
                m17271a.m17283p();
                if (m17271a.m17290k() > 1) {
                    return new C12584q(m17271a);
                }
            }
            return m17271a;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12580kf
    /* renamed from: ok */
    public void mo17238ok(RunnableC12593z runnableC12593z, C12584q c12584q) {
        synchronized (this) {
            c12584q.m17282q();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12580kf
    /* renamed from: ok */
    public void mo17237ok(RunnableC12593z runnableC12593z, C12584q c12584q, C12592x c12592x, C12607s c12607s) throws BaseException, C12532q {
        synchronized (this) {
            if (!this.f35365kf && !this.f35360h) {
                m17272a(runnableC12593z, c12584q, c12592x, c12607s);
                runnableC12593z.m17180a(false);
                if (this.f35383z <= 0) {
                    long totalBytes = this.f35370ok.getTotalBytes();
                    this.f35383z = totalBytes;
                    if (totalBytes <= 0) {
                        this.f35383z = c12607s.m16985k();
                    }
                    m17254n();
                } else if (this.f35355a.m17207kf()) {
                    m17254n();
                }
            } else {
                throw new C12577i("connected");
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12580kf
    /* renamed from: ok */
    public void mo17234ok(RunnableC12593z runnableC12593z, C12592x c12592x, C12584q c12584q, BaseException baseException, int i, int i2) {
        C12713kf.m16619a(baseException);
        int errorCode = baseException.getErrorCode();
        if (((errorCode == 1047 || errorCode == 1074 || errorCode == 1055) ? true : true) || i >= i2) {
            m17266bl(runnableC12593z);
        }
    }

    /* renamed from: a */
    public void m17277a() {
        C12409ok.m17901bl("SegmentDispatcher", "pause1");
        this.f35360h = true;
        synchronized (this) {
            for (RunnableC12593z runnableC12593z : this.f35371p) {
                runnableC12593z.m17172n();
            }
        }
        this.f35368n.m17315a();
        this.f35356bl.m17318bl();
    }

    @Override // com.p521ss.android.socialbase.downloader.p551kf.InterfaceC12580kf
    /* renamed from: ok */
    public void mo17235ok(RunnableC12593z runnableC12593z, C12592x c12592x, C12584q c12584q, BaseException baseException) {
        synchronized (this) {
            C12409ok.m17900n("SegmentDispatcher", "onSegmentFailed: segment = " + c12584q + ", e = " + baseException);
            runnableC12593z.m17180a(true);
            if (runnableC12593z.f35401bl == 0) {
                this.f35381x = baseException;
            }
            if (m17258j()) {
                if (this.f35381x == null) {
                    this.f35381x = baseException;
                }
                this.f35379ul = true;
                m17246ok(this.f35381x);
            }
        }
    }

    /* renamed from: a */
    private void m17276a(long j) {
        this.f35378u.m16511ok(this.f35370ok.getCurBytes(), j);
        for (RunnableC12593z runnableC12593z : this.f35371p) {
            runnableC12593z.m17182a(j);
        }
    }

    /* renamed from: ok */
    private void m17246ok(BaseException baseException) {
        C12409ok.m17900n("SegmentDispatcher", "onError, e = " + baseException);
        this.f35381x = baseException;
        this.f35356bl.m17318bl();
        synchronized (this) {
            for (RunnableC12593z runnableC12593z : this.f35371p) {
                runnableC12593z.m17172n();
            }
        }
    }

    /* renamed from: ok */
    private void m17233ok(C12607s c12607s) throws BaseException {
        C12607s c12607s2 = this.f35364k;
        if (c12607s2 == null && (c12607s2 = this.f35373r) == null) {
            return;
        }
        long m16985k = c12607s.m16985k();
        long m16985k2 = c12607s2.m16985k();
        if (m16985k != m16985k2) {
            String str = "total len not equals,len=" + m16985k + ",sLen=" + m16985k2 + ",code=" + c12607s.f35524bl + ",sCode=" + c12607s2.f35524bl + ",range=" + c12607s.m16983n() + ",sRange = " + c12607s2.m16983n() + ",url = " + c12607s.f35526ok + ",sUrl=" + c12607s2.f35526ok;
            C12409ok.m17900n("SegmentDispatcher", str);
            if (m16985k > 0 && m16985k2 > 0) {
                throw new BaseException(1074, str);
            }
        }
        String m16987bl = c12607s.m16987bl();
        String m16987bl2 = c12607s2.m16987bl();
        if (TextUtils.equals(m16987bl, m16987bl2)) {
            return;
        }
        String str2 = "etag not equals with main url, etag = " + m16987bl + ", mainEtag = " + m16987bl2;
        C12409ok.m17900n("SegmentDispatcher", str2);
        if (!TextUtils.isEmpty(m16987bl) && !TextUtils.isEmpty(m16987bl2) && !m16987bl.equalsIgnoreCase(m16987bl2)) {
            throw new BaseException(1074, str2);
        }
    }

    /* renamed from: ok */
    public void m17251ok() {
        C12409ok.m17901bl("SegmentDispatcher", CommonNetImpl.CANCEL);
        this.f35365kf = true;
        synchronized (this) {
            for (RunnableC12593z runnableC12593z : this.f35371p) {
                runnableC12593z.m17172n();
            }
        }
        this.f35368n.m17311ok();
        this.f35356bl.m17318bl();
    }

    /* renamed from: ok */
    private int m17249ok(long j) {
        int size = this.f35376t.size();
        for (int i = 0; i < size; i++) {
            C12584q c12584q = this.f35376t.get(i);
            if (c12584q.m17293bl() == j) {
                return i;
            }
            if (c12584q.m17293bl() > j) {
                return -1;
            }
        }
        return -1;
    }

    /* renamed from: ok */
    private long m17250ok(int i, int i2) {
        C12584q c12584q = this.f35376t.get(i);
        long m17245ok = m17245ok(c12584q);
        int i3 = i + 1;
        C12584q c12584q2 = i3 < i2 ? this.f35376t.get(i3) : null;
        if (c12584q2 == null) {
            return m17245ok;
        }
        long m17293bl = c12584q2.m17293bl() - c12584q.m17288n();
        return m17245ok == -1 ? m17293bl : Math.min(m17245ok, m17293bl);
    }

    /* renamed from: ok */
    private long m17245ok(C12584q c12584q) {
        long m17296a = c12584q.m17296a();
        if (m17296a == -1) {
            long j = this.f35383z;
            return j > 0 ? j - c12584q.m17288n() : m17296a;
        }
        return m17296a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public RunnableC12593z m17229ok(boolean z, long j, long j2) {
        RunnableC12593z runnableC12593z = null;
        for (RunnableC12593z runnableC12593z2 : this.f35371p) {
            if (runnableC12593z2.f35401bl != 0 || z) {
                if (runnableC12593z2.f35426s > 0 && runnableC12593z2.f35418n <= 0 && j - runnableC12593z2.f35426s > j2 && (runnableC12593z == null || runnableC12593z2.f35426s < runnableC12593z.f35426s)) {
                    runnableC12593z = runnableC12593z2;
                }
            }
        }
        return runnableC12593z;
    }

    /* renamed from: ok */
    private boolean m17239ok(RunnableC12593z runnableC12593z, long j, long j2, long j3, double d) {
        if (runnableC12593z.f35415kf > 0) {
            long m16514a = this.f35378u.m16514a(j, j2);
            int size = this.f35371p.size();
            long j4 = size > 0 ? m16514a / size : m16514a;
            long m17169ok = runnableC12593z.m17169ok(j, j2);
            if (m17169ok >= j3) {
                double d2 = j4;
                Double.isNaN(d2);
                if (m17169ok >= d2 * d) {
                    return false;
                }
            }
            Log.i("SegmentDispatcher", "isDownloadSpeedPoor: totalSpeed = " + m16514a + ", threadAvgSpeed = " + j4 + ", poorSpeed = " + j3 + ", speed = " + m17169ok + ",threadIndex = " + runnableC12593z.f35401bl);
            return true;
        }
        return false;
    }

    /* renamed from: ok */
    private boolean m17248ok(long j, long j2) {
        long j3 = j - j2;
        long m16514a = this.f35378u.m16514a(j3, j);
        int size = this.f35371p.size();
        if (size > 0) {
            m16514a /= size;
        }
        RunnableC12593z m17247ok = m17247ok(j3, j, Math.max(10.0f, ((float) m16514a) * this.f35357ep), size / 2);
        if (m17247ok != null) {
            m17266bl(m17247ok);
            C12409ok.m17894s("SegmentDispatcher", "handlePoorReadThread: reconnect for poor speed, threadIndex = " + m17247ok.f35401bl);
            m17247ok.m17173kf();
            return true;
        }
        RunnableC12593z m17229ok = m17229ok(true, j, j2);
        if (m17229ok != null) {
            m17266bl(m17229ok);
            C12409ok.m17894s("SegmentDispatcher", "handlePoorReadThread: reconnect for connect timeout, threadIndex = " + m17229ok.f35401bl);
            m17229ok.m17173kf();
            return true;
        }
        return false;
    }

    /* renamed from: ok */
    private RunnableC12593z m17247ok(long j, long j2, long j3, int i) {
        long j4;
        long j5 = Long.MAX_VALUE;
        int i2 = 0;
        RunnableC12593z runnableC12593z = null;
        for (RunnableC12593z runnableC12593z2 : this.f35371p) {
            if (runnableC12593z2.f35415kf > 0) {
                i2++;
                long j6 = j5;
                if (runnableC12593z2.f35415kf < j) {
                    long m17169ok = runnableC12593z2.m17169ok(j, j2);
                    if (this.f35366kz) {
                        Log.i("SegmentDispatcher", "findPoorReadThread: speed = " + m17169ok + ", threadIndex = " + runnableC12593z2.f35401bl);
                        j4 = 0;
                    } else {
                        j4 = 0;
                    }
                    if (m17169ok >= j4 && m17169ok < j6) {
                        j5 = m17169ok;
                        runnableC12593z = runnableC12593z2;
                    }
                }
                j5 = j6;
            }
        }
        long j7 = j5;
        if (runnableC12593z == null || i2 < i || j7 >= j3) {
            return null;
        }
        C12409ok.m17901bl("SegmentDispatcher", "findPoorReadThread: ----------- minSpeed = " + j7 + ", threadIndex = " + runnableC12593z.f35401bl);
        return runnableC12593z;
    }
}
