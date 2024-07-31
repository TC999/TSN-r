package com.p521ss.android.socialbase.downloader.p551kf;

import android.text.TextUtils;
import android.util.Log;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.exception.C12532q;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.model.C12607s;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.network.AbstractC12625ok;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12635q;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12714n;
import com.umeng.analytics.pro.PathCenter;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import master.flame.danmaku.danmaku.parser.IDataSource;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.ss.android.socialbase.downloader.kf.z */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class RunnableC12593z implements Runnable {

    /* renamed from: a */
    C12592x f35400a;

    /* renamed from: bl */
    final int f35401bl;

    /* renamed from: e */
    private boolean f35402e;

    /* renamed from: em */
    private boolean f35403em;

    /* renamed from: ep */
    private volatile boolean f35404ep;

    /* renamed from: er */
    private int f35405er;

    /* renamed from: fb */
    private int f35406fb;

    /* renamed from: fd */
    private BaseException f35407fd;

    /* renamed from: fl */
    private int f35408fl;

    /* renamed from: g */
    private int f35409g;

    /* renamed from: h */
    volatile long f35410h;

    /* renamed from: i */
    private C12607s f35411i;

    /* renamed from: j */
    private final InterfaceC12575bl f35413j;

    /* renamed from: k */
    String f35414k;

    /* renamed from: kf */
    volatile long f35415kf;

    /* renamed from: kz */
    private volatile boolean f35416kz;

    /* renamed from: m */
    private volatile boolean f35417m;

    /* renamed from: n */
    volatile long f35418n;

    /* renamed from: o */
    private Future f35419o;

    /* renamed from: ok */
    volatile C12584q f35420ok;

    /* renamed from: p */
    String f35421p;

    /* renamed from: q */
    String f35422q;

    /* renamed from: qu */
    private C12714n f35423qu;

    /* renamed from: r */
    private final InterfaceC12580kf f35424r;

    /* renamed from: rh */
    private final C12534ok f35425rh;

    /* renamed from: s */
    volatile long f35426s;

    /* renamed from: sg */
    private boolean f35427sg;

    /* renamed from: t */
    private InterfaceC12635q f35428t;

    /* renamed from: td */
    private long f35429td;

    /* renamed from: u */
    private volatile long f35430u;

    /* renamed from: ul */
    private volatile long f35431ul;

    /* renamed from: v */
    private long f35432v;

    /* renamed from: vz */
    private Thread f35433vz;

    /* renamed from: y */
    private volatile boolean f35435y;

    /* renamed from: z */
    private final DownloadInfo f35436z;

    /* renamed from: zz */
    private volatile long f35437zz;

    /* renamed from: x */
    private final List<C12584q> f35434x = new ArrayList();

    /* renamed from: io */
    private volatile long f35412io = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public RunnableC12593z(DownloadInfo downloadInfo, C12586r c12586r, InterfaceC12575bl interfaceC12575bl, C12592x c12592x, int i) {
        this.f35436z = downloadInfo;
        this.f35424r = c12586r;
        this.f35413j = interfaceC12575bl;
        this.f35425rh = C12534ok.m17599ok(downloadInfo.getId());
        this.f35400a = c12592x;
        this.f35401bl = i;
    }

    /* renamed from: a */
    private void m17181a(C12584q c12584q) throws BaseException, C12532q {
        m17178bl(c12584q);
        this.f35424r.mo17237ok(this, c12584q, this.f35400a, this.f35411i);
        this.f35400a.m17190bl();
    }

    /* renamed from: bl */
    private void m17178bl(C12584q c12584q) throws BaseException {
        String str;
        String str2;
        InterfaceC12635q m17770ok;
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.f35418n = 0L;
                this.f35426s = currentTimeMillis;
                this.f35429td = c12584q.m17288n();
                this.f35430u = c12584q.m17289kf();
                if (this.f35430u > 0 && this.f35429td > this.f35430u) {
                    throw new C12579k(6, "createConn, " + c12584q);
                }
                this.f35423qu = new C12714n();
                List<C12601bl> m16537ok = C12713kf.m16537ok(this.f35436z.getExtraHeaders(), this.f35436z.geteTag(), this.f35429td, this.f35430u);
                m16537ok.add(new C12601bl("Segment-Index", String.valueOf(c12584q.m17291h())));
                m16537ok.add(new C12601bl("Thread-Index", String.valueOf(this.f35401bl)));
                C12713kf.m16538ok(m16537ok, this.f35436z);
                C12713kf.m16606a(m16537ok, this.f35436z);
                str = this.f35400a.f35396ok;
                if (this.f35402e && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                    str = str.replaceFirst("https", IDataSource.f43971a);
                }
                str2 = this.f35400a.f35390a;
                C12409ok.m17901bl("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + c12584q + ", threadIndex = " + this.f35401bl);
                this.f35421p = str;
                this.f35422q = str2;
                m17770ok = C12490bl.m17770ok(this.f35436z.isNeedDefaultHttpServiceBackUp(), this.f35436z.getMaxBytes(), str, str2, m16537ok, 0, currentTimeMillis - this.f35432v > 3000 && this.f35425rh.m17607a("monitor_download_connect") > 0, this.f35436z);
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                C12713kf.m16540ok(th, "createConn");
            }
            if (m17770ok != null) {
                this.f35428t = m17770ok;
                this.f35411i = new C12607s(str, m17770ok);
                if (!this.f35435y) {
                    if (m17770ok instanceof AbstractC12625ok) {
                        this.f35414k = ((AbstractC12625ok) m17770ok).mo16943n();
                    }
                    Log.i("SegmentReader", "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.f35414k + ", threadIndex = " + this.f35401bl);
                    return;
                }
                throw new C12577i("createConn");
            }
            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
        } finally {
            this.f35418n = System.currentTimeMillis();
        }
    }

    /* renamed from: j */
    private void m17175j() {
        this.f35406fb = this.f35400a.f35399s ? this.f35436z.getRetryCount() : this.f35436z.getBackUpUrlRetryCount();
        this.f35409g = 0;
    }

    /* renamed from: k */
    private void m17174k() {
        InterfaceC12635q interfaceC12635q = this.f35428t;
        if (interfaceC12635q != null) {
            try {
                C12409ok.m17901bl("SegmentReader", "closeConnection: thread = " + this.f35401bl);
                interfaceC12635q.mo16908s();
                interfaceC12635q.mo16917bl();
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: ok */
    private boolean m17166ok(C12584q c12584q) throws BaseException {
        m17159r();
        while (true) {
            try {
                m17181a(c12584q);
                m17157s(c12584q);
                return true;
            } catch (C12579k e) {
                this.f35407fd = e;
                throw e;
            } catch (Throwable th) {
                try {
                    C12409ok.m17900n("SegmentReader", "download: e = " + th + ", threadIndex = " + this.f35401bl + ", reconnect = " + this.f35417m + ", closed = " + this.f35435y);
                    if (this.f35435y) {
                        return false;
                    }
                    if (this.f35417m) {
                        this.f35417m = false;
                        Thread.interrupted();
                        if (this.f35404ep) {
                            this.f35404ep = false;
                            throw new C12579k(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e2 = null;
                        if (th instanceof BaseException) {
                            e2 = th;
                        } else {
                            try {
                                C12713kf.m16540ok((Throwable) th, "download");
                            } catch (BaseException e3) {
                                e2 = e3;
                            }
                        }
                        if (e2 == null || !m17165ok(c12584q, e2)) {
                            return false;
                        }
                    }
                } finally {
                    m17160q();
                }
            }
        }
        return false;
    }

    /* renamed from: q */
    private void m17160q() {
        this.f35432v = this.f35426s;
        this.f35426s = -1L;
        this.f35418n = -1L;
        this.f35415kf = -1L;
        this.f35410h = -1L;
        m17174k();
    }

    /* renamed from: r */
    private void m17159r() {
        this.f35402e = false;
        m17175j();
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x012b, code lost:
        r7 = r11 + 1;
        r11 = r13 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0135, code lost:
        if (r11 <= 0) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0137, code lost:
        com.p521ss.android.socialbase.downloader.p549bl.C12409ok.m17900n("SegmentReader", "loopAndRead: redundant = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014d, code lost:
        r31.f35412io = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x0150, code lost:
        r13 = r7;
        r11 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x0154, code lost:
        r0 = th;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x015d, code lost:
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0165, code lost:
        throw new com.p521ss.android.socialbase.downloader.p551kf.C12577i("loopAndRead");
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x01c1, code lost:
        r6 = 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0331  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x039a  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x03a7  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:76:0x015b -> B:77:0x015c). Please submit an issue!!! */
    /* renamed from: s */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m17157s(com.p521ss.android.socialbase.downloader.p551kf.C12584q r32) throws com.p521ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 999
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p551kf.RunnableC12593z.m17157s(com.ss.android.socialbase.downloader.kf.q):void");
    }

    /* renamed from: z */
    private long m17156z() {
        long j = this.f35437zz;
        this.f35437zz = 0L;
        if (j <= 0) {
            return Long.MAX_VALUE;
        }
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: h */
    public boolean m17176h() {
        return this.f35403em;
    }

    /* renamed from: kf */
    public void m17173kf() {
        m17162ok(false);
    }

    /* renamed from: n */
    public void m17172n() {
        C12409ok.m17901bl("SegmentReader", "close: threadIndex = " + this.f35401bl);
        synchronized (this) {
            this.f35435y = true;
            this.f35416kz = true;
        }
        m17174k();
        Future future = this.f35419o;
        if (future != null) {
            this.f35419o = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: p */
    public long m17161p() {
        return this.f35429td;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
        r6.f35420ok = null;
        r2 = r6.f35424r;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void run() {
        /*
            Method dump skipped, instructions count: 256
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.p551kf.RunnableC12593z.run():void");
    }

    /* renamed from: a */
    public long m17183a() {
        long m17179bl;
        synchronized (this.f35424r) {
            m17179bl = this.f35431ul + m17179bl();
        }
        return m17179bl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m17180a(boolean z) {
        this.f35403em = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public void m17182a(long j) {
        long j2 = this.f35412io;
        C12714n c12714n = this.f35423qu;
        if (j2 < 0 || c12714n == null) {
            return;
        }
        Log.i("SegmentReader", "markProgress: curSegmentReadOffset = " + j2 + ", threadIndex = " + this.f35401bl);
        c12714n.m16511ok(j2, j);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public boolean m17164ok(C12592x c12592x) {
        int i = this.f35408fl;
        if (i >= 30) {
            return false;
        }
        this.f35408fl = i + 1;
        C12592x c12592x2 = this.f35400a;
        if (c12592x2 != null) {
            c12592x2.m17191a(this);
        }
        c12592x.m17186ok(this);
        this.f35400a = c12592x;
        m17175j();
        return true;
    }

    /* renamed from: ok */
    private boolean m17165ok(C12584q c12584q, BaseException baseException) {
        C12409ok.m17900n("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.f35409g + ", retryCount = " + this.f35406fb);
        this.f35407fd = baseException;
        this.f35400a.m17192a();
        this.f35424r.mo17234ok(this, this.f35400a, c12584q, baseException, this.f35409g, this.f35406fb);
        int i = this.f35409g;
        if (i < this.f35406fb) {
            this.f35409g = i + 1;
            return true;
        } else if (m17168ok(baseException)) {
            return true;
        } else {
            this.f35424r.mo17235ok(this, this.f35400a, c12584q, baseException);
            return false;
        }
    }

    /* renamed from: bl */
    public long m17179bl() {
        synchronized (this.f35424r) {
            long j = this.f35412io;
            long j2 = this.f35429td;
            if (j2 < 0 || j <= j2) {
                return 0L;
            }
            return j - j2;
        }
    }

    /* renamed from: ok */
    private boolean m17168ok(BaseException baseException) {
        if (C12713kf.m16601bl(baseException)) {
            String str = this.f35400a.f35396ok;
            if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.f35436z.isNeedHttpsToHttpRetry() || this.f35402e) {
                return false;
            }
            this.f35402e = true;
            m17175j();
            return true;
        }
        return false;
    }

    /* renamed from: bl */
    public void m17177bl(boolean z) {
        this.f35427sg = z;
    }

    /* renamed from: ok */
    private C12582ok m17167ok(InterfaceC12575bl interfaceC12575bl, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i;
        C12582ok mo17317a = interfaceC12575bl.mo17317a();
        try {
            i = inputStream.read(mo17317a.f35343ok);
            try {
                if (i != -1) {
                    mo17317a.f35342bl = i;
                    if (i == -1) {
                        interfaceC12575bl.mo17316ok(mo17317a);
                    }
                    return mo17317a;
                }
                throw new BaseException(1073, PathCenter.f37700s);
            } catch (Throwable th) {
                th = th;
                if (i == -1) {
                    interfaceC12575bl.mo17316ok(mo17317a);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i = -1;
        }
    }

    /* renamed from: ok */
    public boolean m17170ok(long j) {
        long j2 = this.f35430u;
        if (j > 0 || j2 <= 0) {
            if (j <= j2 || j2 <= 0) {
                this.f35437zz = j;
                this.f35416kz = true;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m17171ok() {
        C12592x c12592x = this.f35400a;
        try {
            synchronized (this.f35424r) {
                long m17179bl = m17179bl();
                if (m17179bl > 0) {
                    this.f35431ul += m17179bl;
                    c12592x.m17187ok(m17179bl);
                }
                this.f35412io = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: ok */
    public void m17162ok(boolean z) {
        C12409ok.m17901bl("SegmentReader", "reconnect: threadIndex = " + this.f35401bl);
        synchronized (this) {
            this.f35404ep = z;
            this.f35417m = true;
            this.f35416kz = true;
        }
        m17174k();
        Thread thread = this.f35433vz;
        if (thread != null) {
            try {
                Log.i("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.f35401bl);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public void m17163ok(Future future) {
        this.f35419o = future;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public long m17169ok(long j, long j2) {
        C12714n c12714n = this.f35423qu;
        if (c12714n == null) {
            return -1L;
        }
        return c12714n.m16514a(j, j2);
    }

    /* renamed from: s */
    public long m17158s() {
        return this.f35412io;
    }
}
