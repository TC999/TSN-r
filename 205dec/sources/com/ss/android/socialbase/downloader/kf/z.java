package com.ss.android.socialbase.downloader.kf;

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
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class z implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    x f49884a;
    final int bl;

    /* renamed from: e  reason: collision with root package name */
    private boolean f49885e;
    private boolean em;
    private volatile boolean ep;
    private int er;
    private int fb;
    private BaseException fd;
    private int fl;

    /* renamed from: g  reason: collision with root package name */
    private int f49886g;

    /* renamed from: h  reason: collision with root package name */
    volatile long f49887h;

    /* renamed from: i  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.model.s f49888i;

    /* renamed from: j  reason: collision with root package name */
    private final bl f49890j;

    /* renamed from: k  reason: collision with root package name */
    String f49891k;
    volatile long kf;
    private volatile boolean kz;

    /* renamed from: m  reason: collision with root package name */
    private volatile boolean f49892m;

    /* renamed from: n  reason: collision with root package name */
    volatile long f49893n;

    /* renamed from: o  reason: collision with root package name */
    private Future f49894o;
    volatile q ok;

    /* renamed from: p  reason: collision with root package name */
    String f49895p;

    /* renamed from: q  reason: collision with root package name */
    String f49896q;
    private com.ss.android.socialbase.downloader.q.n qu;

    /* renamed from: r  reason: collision with root package name */
    private final kf f49897r;
    private final com.ss.android.socialbase.downloader.h.ok rh;

    /* renamed from: s  reason: collision with root package name */
    volatile long f49898s;
    private boolean sg;

    /* renamed from: t  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.network.q f49899t;
    private long td;

    /* renamed from: u  reason: collision with root package name */
    private volatile long f49900u;
    private volatile long ul;

    /* renamed from: v  reason: collision with root package name */
    private long f49901v;
    private Thread vz;

    /* renamed from: y  reason: collision with root package name */
    private volatile boolean f49903y;

    /* renamed from: z  reason: collision with root package name */
    private final DownloadInfo f49904z;
    private volatile long zz;

    /* renamed from: x  reason: collision with root package name */
    private final List<q> f49902x = new ArrayList();

    /* renamed from: io  reason: collision with root package name */
    private volatile long f49889io = -1;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(DownloadInfo downloadInfo, r rVar, bl blVar, x xVar, int i4) {
        this.f49904z = downloadInfo;
        this.f49897r = rVar;
        this.f49890j = blVar;
        this.rh = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId());
        this.f49884a = xVar;
        this.bl = i4;
    }

    private void a(q qVar) throws BaseException, com.ss.android.socialbase.downloader.exception.q {
        bl(qVar);
        this.f49897r.ok(this, qVar, this.f49884a, this.f49888i);
        this.f49884a.bl();
    }

    private void bl(q qVar) throws BaseException {
        String str;
        String str2;
        com.ss.android.socialbase.downloader.network.q ok;
        try {
            try {
                long currentTimeMillis = System.currentTimeMillis();
                this.f49893n = 0L;
                this.f49898s = currentTimeMillis;
                this.td = qVar.n();
                this.f49900u = qVar.kf();
                if (this.f49900u > 0 && this.td > this.f49900u) {
                    throw new k(6, "createConn, " + qVar);
                }
                this.qu = new com.ss.android.socialbase.downloader.q.n();
                List<com.ss.android.socialbase.downloader.model.bl> ok2 = com.ss.android.socialbase.downloader.q.kf.ok(this.f49904z.getExtraHeaders(), this.f49904z.geteTag(), this.td, this.f49900u);
                ok2.add(new com.ss.android.socialbase.downloader.model.bl("Segment-Index", String.valueOf(qVar.h())));
                ok2.add(new com.ss.android.socialbase.downloader.model.bl("Thread-Index", String.valueOf(this.bl)));
                com.ss.android.socialbase.downloader.q.kf.ok(ok2, this.f49904z);
                com.ss.android.socialbase.downloader.q.kf.a(ok2, this.f49904z);
                str = this.f49884a.ok;
                if (this.f49885e && !TextUtils.isEmpty(str) && str.startsWith("https")) {
                    str = str.replaceFirst("https", "http");
                }
                str2 = this.f49884a.f49877a;
                com.ss.android.socialbase.downloader.bl.ok.bl("SegmentReader", "createConnectionBegin: url = " + str + ", ip = " + str2 + ", segment = " + qVar + ", threadIndex = " + this.bl);
                this.f49895p = str;
                this.f49896q = str2;
                ok = com.ss.android.socialbase.downloader.downloader.bl.ok(this.f49904z.isNeedDefaultHttpServiceBackUp(), this.f49904z.getMaxBytes(), str, str2, ok2, 0, currentTimeMillis - this.f49901v > 3000 && this.rh.a("monitor_download_connect") > 0, this.f49904z);
            } catch (BaseException e4) {
                throw e4;
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.q.kf.ok(th, "createConn");
            }
            if (ok != null) {
                this.f49899t = ok;
                this.f49888i = new com.ss.android.socialbase.downloader.model.s(str, ok);
                if (!this.f49903y) {
                    if (ok instanceof com.ss.android.socialbase.downloader.network.ok) {
                        this.f49891k = ((com.ss.android.socialbase.downloader.network.ok) ok).n();
                    }
                    Log.i("SegmentReader", "createConnectionSuccess: url = " + str + ", ip = " + str2 + ", hostRealIp = " + this.f49891k + ", threadIndex = " + this.bl);
                    return;
                }
                throw new i("createConn");
            }
            throw new BaseException(1022, new IOException("download can't continue, chunk connection is null"));
        } finally {
            this.f49893n = System.currentTimeMillis();
        }
    }

    private void j() {
        this.fb = this.f49884a.f49883s ? this.f49904z.getRetryCount() : this.f49904z.getBackUpUrlRetryCount();
        this.f49886g = 0;
    }

    private void k() {
        com.ss.android.socialbase.downloader.network.q qVar = this.f49899t;
        if (qVar != null) {
            try {
                com.ss.android.socialbase.downloader.bl.ok.bl("SegmentReader", "closeConnection: thread = " + this.bl);
                qVar.s();
                qVar.bl();
            } catch (Throwable unused) {
            }
        }
    }

    private boolean ok(q qVar) throws BaseException {
        r();
        while (true) {
            try {
                a(qVar);
                s(qVar);
                return true;
            } catch (k e4) {
                this.fd = e4;
                throw e4;
            } catch (Throwable th) {
                try {
                    com.ss.android.socialbase.downloader.bl.ok.n("SegmentReader", "download: e = " + th + ", threadIndex = " + this.bl + ", reconnect = " + this.f49892m + ", closed = " + this.f49903y);
                    if (this.f49903y) {
                        return false;
                    }
                    if (this.f49892m) {
                        this.f49892m = false;
                        Thread.interrupted();
                        if (this.ep) {
                            this.ep = false;
                            throw new k(5, "download");
                        }
                    } else {
                        th.printStackTrace();
                        BaseException e5 = null;
                        if (th instanceof BaseException) {
                            e5 = th;
                        } else {
                            try {
                                com.ss.android.socialbase.downloader.q.kf.ok((Throwable) th, "download");
                            } catch (BaseException e6) {
                                e5 = e6;
                            }
                        }
                        if (e5 == null || !ok(qVar, e5)) {
                            return false;
                        }
                    }
                } finally {
                    q();
                }
            }
        }
        return false;
    }

    private void q() {
        this.f49901v = this.f49898s;
        this.f49898s = -1L;
        this.f49893n = -1L;
        this.kf = -1L;
        this.f49887h = -1L;
        k();
    }

    private void r() {
        this.f49885e = false;
        j();
    }

    /* JADX WARN: Code restructure failed: missing block: B:65:0x012b, code lost:
        r7 = r11 + 1;
        r11 = r13 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x0135, code lost:
        if (r11 <= 0) goto L170;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x0137, code lost:
        com.ss.android.socialbase.downloader.bl.ok.n("SegmentReader", "loopAndRead: redundant = " + r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x014d, code lost:
        r31.f49889io = r7;
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
        throw new com.ss.android.socialbase.downloader.kf.i("loopAndRead");
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
    private void s(com.ss.android.socialbase.downloader.kf.q r32) throws com.ss.android.socialbase.downloader.exception.BaseException {
        /*
            Method dump skipped, instructions count: 999
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kf.z.s(com.ss.android.socialbase.downloader.kf.q):void");
    }

    private long z() {
        long j4 = this.zz;
        this.zz = 0L;
        if (j4 <= 0) {
            return Long.MAX_VALUE;
        }
        return j4;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean h() {
        return this.em;
    }

    public void kf() {
        ok(false);
    }

    public void n() {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentReader", "close: threadIndex = " + this.bl);
        synchronized (this) {
            this.f49903y = true;
            this.kz = true;
        }
        k();
        Future future = this.f49894o;
        if (future != null) {
            this.f49894o = null;
            try {
                future.cancel(true);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long p() {
        return this.td;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x007b, code lost:
        r6.ok = null;
        r2 = r6.f49897r;
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.kf.z.run():void");
    }

    public long a() {
        long bl;
        synchronized (this.f49897r) {
            bl = this.ul + bl();
        }
        return bl;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(boolean z3) {
        this.em = z3;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(long j4) {
        long j5 = this.f49889io;
        com.ss.android.socialbase.downloader.q.n nVar = this.qu;
        if (j5 < 0 || nVar == null) {
            return;
        }
        Log.i("SegmentReader", "markProgress: curSegmentReadOffset = " + j5 + ", threadIndex = " + this.bl);
        nVar.ok(j5, j4);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean ok(x xVar) {
        int i4 = this.fl;
        if (i4 >= 30) {
            return false;
        }
        this.fl = i4 + 1;
        x xVar2 = this.f49884a;
        if (xVar2 != null) {
            xVar2.a(this);
        }
        xVar.ok(this);
        this.f49884a = xVar;
        j();
        return true;
    }

    private boolean ok(q qVar, BaseException baseException) {
        com.ss.android.socialbase.downloader.bl.ok.n("SegmentReader", "handleDownloadFailed:  e = " + baseException + ", curRetryCount = " + this.f49886g + ", retryCount = " + this.fb);
        this.fd = baseException;
        this.f49884a.a();
        this.f49897r.ok(this, this.f49884a, qVar, baseException, this.f49886g, this.fb);
        int i4 = this.f49886g;
        if (i4 < this.fb) {
            this.f49886g = i4 + 1;
            return true;
        } else if (ok(baseException)) {
            return true;
        } else {
            this.f49897r.ok(this, this.f49884a, qVar, baseException);
            return false;
        }
    }

    public long bl() {
        synchronized (this.f49897r) {
            long j4 = this.f49889io;
            long j5 = this.td;
            if (j5 < 0 || j4 <= j5) {
                return 0L;
            }
            return j4 - j5;
        }
    }

    private boolean ok(BaseException baseException) {
        if (com.ss.android.socialbase.downloader.q.kf.bl(baseException)) {
            String str = this.f49884a.ok;
            if (TextUtils.isEmpty(str) || !str.startsWith("https") || !this.f49904z.isNeedHttpsToHttpRetry() || this.f49885e) {
                return false;
            }
            this.f49885e = true;
            j();
            return true;
        }
        return false;
    }

    public void bl(boolean z3) {
        this.sg = z3;
    }

    private ok ok(bl blVar, InputStream inputStream) throws InterruptedException, BaseException, IOException {
        int i4;
        ok a4 = blVar.a();
        try {
            i4 = inputStream.read(a4.ok);
            try {
                if (i4 != -1) {
                    a4.bl = i4;
                    if (i4 == -1) {
                        blVar.ok(a4);
                    }
                    return a4;
                }
                throw new BaseException(1073, "probe");
            } catch (Throwable th) {
                th = th;
                if (i4 == -1) {
                    blVar.ok(a4);
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            i4 = -1;
        }
    }

    public boolean ok(long j4) {
        long j5 = this.f49900u;
        if (j4 > 0 || j5 <= 0) {
            if (j4 <= j5 || j5 <= 0) {
                this.zz = j4;
                this.kz = true;
                return true;
            }
            return false;
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok() {
        x xVar = this.f49884a;
        try {
            synchronized (this.f49897r) {
                long bl = bl();
                if (bl > 0) {
                    this.ul += bl;
                    xVar.ok(bl);
                }
                this.f49889io = -1L;
            }
        } catch (Throwable unused) {
        }
    }

    public void ok(boolean z3) {
        com.ss.android.socialbase.downloader.bl.ok.bl("SegmentReader", "reconnect: threadIndex = " + this.bl);
        synchronized (this) {
            this.ep = z3;
            this.f49892m = true;
            this.kz = true;
        }
        k();
        Thread thread = this.vz;
        if (thread != null) {
            try {
                Log.i("SegmentReader", "reconnect: t.interrupt threadIndex = " + this.bl);
                thread.interrupt();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void ok(Future future) {
        this.f49894o = future;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public long ok(long j4, long j5) {
        com.ss.android.socialbase.downloader.q.n nVar = this.qu;
        if (nVar == null) {
            return -1L;
        }
        return nVar.a(j4, j5);
    }

    public long s() {
        return this.f49889io;
    }
}
