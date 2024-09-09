package com.ss.android.socialbase.downloader.f;

import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class bk implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final xv f49583a;
    private int ba;
    private final DownloadInfo bk;
    private com.ss.android.socialbase.downloader.gd.ux bw;

    /* renamed from: c  reason: collision with root package name */
    volatile gd f49584c;
    private Thread ck;
    private int eq;
    String ev;

    /* renamed from: f  reason: collision with root package name */
    volatile long f49585f;
    private com.ss.android.socialbase.downloader.model.sr fp;
    private volatile long fz;
    private volatile boolean gb;
    String gd;

    /* renamed from: j  reason: collision with root package name */
    private Future f49587j;

    /* renamed from: k  reason: collision with root package name */
    private final f f49588k;
    private volatile boolean ls;
    private long me;

    /* renamed from: n  reason: collision with root package name */
    private volatile boolean f49589n;

    /* renamed from: p  reason: collision with root package name */
    String f49590p;
    private boolean pr;

    /* renamed from: q  reason: collision with root package name */
    private volatile long f49591q;

    /* renamed from: r  reason: collision with root package name */
    volatile long f49592r;

    /* renamed from: s  reason: collision with root package name */
    private long f49593s;
    volatile long sr;

    /* renamed from: t  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.r.c f49594t;

    /* renamed from: u  reason: collision with root package name */
    private volatile long f49595u;
    volatile long ux;

    /* renamed from: w  reason: collision with root package name */
    ia f49596w;
    private int wv;
    private boolean wx;
    private boolean xk;
    final int xv;

    /* renamed from: y  reason: collision with root package name */
    private int f49597y;
    private com.ss.android.socialbase.downloader.network.gd ys;
    private BaseException yu;

    /* renamed from: z  reason: collision with root package name */
    private volatile boolean f49598z;
    private final List<gd> ia = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    private volatile long f49586i = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public bk(DownloadInfo downloadInfo, k kVar, xv xvVar, ia iaVar, int i4) {
        this.bk = downloadInfo;
        this.f49588k = kVar;
        this.f49583a = xvVar;
        this.f49594t = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId());
        this.f49596w = iaVar;
        this.xv = i4;
    }

    private void a() {
        this.f49597y = this.f49596w.sr ? this.bk.getRetryCount() : this.bk.getBackUpUrlRetryCount();
        this.eq = 0;
    }

    private long bk() {
        long j4 = this.fz;
        this.fz = 0L;
        if (j4 <= 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    private boolean c(gd gdVar) throws BaseException {
        k();
        while (true) {
            try {
                w(gdVar);
                sr(gdVar);
                return true;
            } catch (p e4) {
                this.yu = e4;
                throw e4;
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.xv.c.ux("SegmentReader", "download: e = " + th + ", threadIndex = " + this.xv + ", reconnect = " + this.gb + ", closed = " + this.ls);
                    if (this.ls) {
                        return false;
                    }
                    if (this.gb) {
                        this.gb = false;
                        Thread.interrupted();
                        if (this.f49589n) {
                            this.f49589n = false;
                            throw new p(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e5 = null;
                        if (th instanceof BaseException) {
                            e5 = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.gd.f.c((Throwable) th, "download");
                            } catch (BaseException e6) {
                                e5 = e6;
                            }
                        }
                        if (e5 == null || !c(gdVar, e5)) {
                            return false;
                        }
                    }
                } finally {
                    gd();
                }
            }
        }
        return false;
    }

    private void gd() {
        this.me = this.sr;
        this.sr = -1L;
        this.ux = -1L;
        this.f49585f = -1L;
        this.f49592r = -1L;
        p();
    }

    private void k() {
        this.xk = false;
        a();
    }

    private void p() {
        com.ss.android.socialbase.downloader.network.gd gdVar = this.ys;
        if (gdVar != null) {
            try {
                com.ss.android.socialbase.downloader.xv.c.xv("SegmentReader", "closeConnection: thread = " + this.xv);
                gdVar.sr();
                gdVar.xv();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x012b, code lost:
        r7 = r11 + 1;
        r11 = r13 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0135, code lost:
        if (r11 <= 0) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0137, code lost:
        com.ss.android.socialbase.downloader.xv.c.ux("SegmentReader", "loopAndRead: redundant = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014d, code lost:
        r31.f49586i = r7;
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
        throw new com.ss.android.socialbase.downloader.f.fp("loopAndRead");
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void sr(com.ss.android.socialbase.downloader.f.gd r32) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 999
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.bk.sr(com.ss.android.socialbase.downloader.f.gd):void");
    }

    private void w(gd gdVar) throws BaseException, com.ss.android.socialbase.downloader.exception.gd {
        xv(gdVar);
        this.f49588k.c(this, gdVar, this.f49596w, this.fp);
        this.f49596w.xv();
    }

    private void xv(gd gdVar) throws BaseException {
        String str;
        String str2;
        com.ss.android.socialbase.downloader.network.gd c4;
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.ux = 0L;
                this.sr = currentTimeMillis;
                this.f49593s = gdVar.ux();
                this.f49595u = gdVar.f();
                if (this.f49595u > 0 && this.f49593s > this.f49595u) {
                    throw new p(6, "createConn, " + gdVar);
                }
                this.bw = new com.ss.android.socialbase.downloader.gd.ux();
                List<com.ss.android.socialbase.downloader.model.xv> c5 = com.ss.android.socialbase.downloader.gd.f.c((List<com.ss.android.socialbase.downloader.model.xv>) this.bk.getExtraHeaders(), this.bk.geteTag(), this.f49593s, this.f49595u);
                c5.add(new com.ss.android.socialbase.downloader.model.xv("Segment-Index", String.valueOf(gdVar.r())));
                c5.add(new com.ss.android.socialbase.downloader.model.xv("Thread-Index", String.valueOf(this.xv)));
                com.ss.android.socialbase.downloader.gd.f.c(c5, this.bk);
                com.ss.android.socialbase.downloader.gd.f.w(c5, this.bk);
                str = this.f49596w.f49607c;
                if (this.xk && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                    str = str.replaceFirst("https", "http");
                }
                str2 = this.f49596w.f49611w;
                com.ss.android.socialbase.downloader.xv.c.xv("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + gdVar + ", threadIndex = " + this.xv);
                this.ev = str;
                this.gd = str2;
                c4 = com.ss.android.socialbase.downloader.downloader.xv.c(this.bk.isNeedDefaultHttpServiceBackUp(), this.bk.getMaxBytes(), str, str2, c5, 0, currentTimeMillis - this.me > 3000 && this.f49594t.w("monitor_download_connect") > 0, this.bk);
            } catch (BaseException e4) {
                throw e4;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.gd.f.c(th, "createConn");
            }
            if (c4 != null) {
                this.ys = c4;
                this.fp = new com.ss.android.socialbase.downloader.model.sr(str, c4);
                if (!this.ls) {
                    if (c4 instanceof com.ss.android.socialbase.downloader.network.c) {
                        this.f49590p = ((com.ss.android.socialbase.downloader.network.c) c4).ux();
                    }
                    Log.i("SegmentReader", "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.f49590p + ", threadIndex = " + this.xv);
                    return;
                }
                throw new fp("createConn");
            }
            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
        } finally {
            this.ux = System.currentTimeMillis();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ev() {
        return this.f49593s;
    }

    public void f() {
        c(false);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean r() {
        return this.wx;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
        r6.f49584c = null;
        r2 = r6.f49588k;
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.f.bk.run():void");
    }

    public void ux() {
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentReader", "close: threadIndex = " + this.xv);
        synchronized (this) {
            this.ls = true;
            this.f49598z = true;
        }
        p();
        Future future = this.f49587j;
        if (future != null) {
            this.f49587j = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public long w() {
        long xv;
        synchronized (this.f49588k) {
            xv = this.f49591q + xv();
        }
        return xv;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(boolean z3) {
        this.wx = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void w(long j4) {
        long j5 = this.f49586i;
        com.ss.android.socialbase.downloader.gd.ux uxVar = this.bw;
        if (j5 < 0 || uxVar == null) {
            return;
        }
        Log.i("SegmentReader", "markProgress: curSegmentReadOffset = " + j5 + ", threadIndex = " + this.xv);
        uxVar.c(j5, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean c(ia iaVar) {
        int i4 = this.wv;
        if (i4 >= 30) {
            return false;
        }
        this.wv = i4 + 1;
        ia iaVar2 = this.f49596w;
        if (iaVar2 != null) {
            iaVar2.w(this);
        }
        iaVar.c(this);
        this.f49596w = iaVar;
        a();
        return true;
    }

    private boolean c(gd gdVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.xv.c.ux("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.eq + ", retryCount = " + this.f49597y);
        this.yu = baseException;
        this.f49596w.w();
        this.f49588k.c(this, this.f49596w, gdVar, baseException, this.eq, this.f49597y);
        int i4 = this.eq;
        if (i4 < this.f49597y) {
            this.eq = i4 + 1;
            return true;
        } else if (c(baseException)) {
            return true;
        } else {
            this.f49588k.c(this, this.f49596w, gdVar, baseException);
            return false;
        }
    }

    public long xv() {
        synchronized (this.f49588k) {
            long j4 = this.f49586i;
            long j5 = this.f49593s;
            if (j5 < 0 || j4 <= j5) {
                return 0L;
            }
            return j4 - j5;
        }
    }

    private boolean c(BaseException baseException) {
        if (com.ss.android.socialbase.downloader.gd.f.xv(baseException)) {
            String str = this.f49596w.f49607c;
            if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.bk.isNeedHttpsToHttpRetry() || this.xk) {
                return false;
            }
            this.xk = true;
            a();
            return true;
        }
        return false;
    }

    public void xv(boolean z3) {
        this.pr = z3;
    }

    private c c(xv xvVar, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i4;
        c w3 = xvVar.w();
        try {
            i4 = inputStream.read(w3.f49599c);
            try {
                if (i4 != -1) {
                    w3.xv = i4;
                    if (i4 == -1) {
                        xvVar.c(w3);
                    }
                    return w3;
                }
                throw new BaseException(1073, "probe");
            } catch (Throwable th) {
                th = th;
                if (i4 == -1) {
                    xvVar.c(w3);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i4 = -1;
        }
    }

    public boolean c(long j4) {
        long j5 = this.f49595u;
        if (j4 > 0 || j5 <= 0) {
            if (j4 <= j5 || j5 <= 0) {
                this.fz = j4;
                this.f49598z = true;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        ia iaVar = this.f49596w;
        try {
            synchronized (this.f49588k) {
                long xv = xv();
                if (xv > 0) {
                    this.f49591q += xv;
                    iaVar.c(xv);
                }
                this.f49586i = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public void c(boolean z3) {
        com.ss.android.socialbase.downloader.xv.c.xv("SegmentReader", "reconnect: threadIndex = " + this.xv);
        synchronized (this) {
            this.f49589n = z3;
            this.gb = true;
            this.f49598z = true;
        }
        p();
        Thread thread = this.ck;
        if (thread != null) {
            try {
                Log.i("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.xv);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(Future future) {
        this.f49587j = future;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long c(long j4, long j5) {
        com.ss.android.socialbase.downloader.gd.ux uxVar = this.bw;
        if (uxVar == null) {
            return -1L;
        }
        return uxVar.w(j4, j5);
    }

    public long sr() {
        return this.f49586i;
    }
}
