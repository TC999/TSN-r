package com.ss.android.socialbase.downloader.p;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.td;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.downloader.k;
import com.ss.android.socialbase.downloader.downloader.zz;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.kf.r;
import com.ss.android.socialbase.downloader.kf.rh;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.a;
import com.ss.android.socialbase.downloader.network.q;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl implements kf, Runnable {
    private static final String ok = bl.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private Future f50115a;
    private final DownloadTask bl;

    /* renamed from: e  reason: collision with root package name */
    private long f50116e;
    private o ep;
    private final com.ss.android.socialbase.downloader.h.ok fd;
    private long fl;

    /* renamed from: g  reason: collision with root package name */
    private String f50117g;

    /* renamed from: h  reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.downloader.n f50118h;

    /* renamed from: i  reason: collision with root package name */
    private DownloadInfo f50119i;

    /* renamed from: io  reason: collision with root package name */
    private zz f50120io;

    /* renamed from: j  reason: collision with root package name */
    private boolean f50121j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f50122k;

    /* renamed from: m  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.network.h f50123m;

    /* renamed from: n  reason: collision with root package name */
    private AtomicInteger f50124n;

    /* renamed from: o  reason: collision with root package name */
    private volatile BaseException f50125o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f50126p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f50127q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f50128r;

    /* renamed from: t  reason: collision with root package name */
    private final k f50130t;
    private final com.ss.android.socialbase.downloader.downloader.p td;

    /* renamed from: u  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.h f50131u;
    private final com.ss.android.socialbase.downloader.downloader.kf ul;
    private td vz;

    /* renamed from: x  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.p f50133x;

    /* renamed from: y  reason: collision with root package name */
    private q f50134y;

    /* renamed from: z  reason: collision with root package name */
    private final AtomicBoolean f50135z;
    private com.ss.android.socialbase.downloader.downloader.h zz;

    /* renamed from: s  reason: collision with root package name */
    private volatile boolean f50129s = false;
    private final ArrayList<a> kf = new ArrayList<>();
    private volatile com.ss.android.socialbase.downloader.constants.p rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_NONE;
    private volatile int kz = 5;
    private boolean er = false;
    private boolean fb = false;

    /* renamed from: v  reason: collision with root package name */
    private boolean f50132v = false;
    private int em = 0;
    private volatile r sg = null;

    public bl(DownloadTask downloadTask, Handler handler) {
        this.bl = downloadTask;
        if (downloadTask != null) {
            this.f50119i = downloadTask.getDownloadInfo();
            this.f50133x = downloadTask.getChunkStrategy();
            this.zz = downloadTask.getChunkAdjustCalculator();
            this.ep = downloadTask.getForbiddenHandler();
            this.vz = downloadTask.getDiskSpaceHandler();
            this.f50120io = ok(downloadTask);
            this.fd = com.ss.android.socialbase.downloader.h.ok.ok(this.f50119i.getId());
        } else {
            this.fd = com.ss.android.socialbase.downloader.h.ok.bl();
        }
        p();
        this.f50130t = com.ss.android.socialbase.downloader.downloader.bl.m();
        this.td = com.ss.android.socialbase.downloader.downloader.bl.em();
        this.f50131u = com.ss.android.socialbase.downloader.downloader.bl.qu();
        this.ul = new com.ss.android.socialbase.downloader.downloader.kf(downloadTask, handler);
        this.f50135z = new AtomicBoolean(true);
    }

    private void e() {
        String str = ok;
        com.ss.android.socialbase.downloader.bl.ok.s(str, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.f50130t.s(this.f50119i.getId());
            this.f50130t.z(this.f50119i.getId());
            com.ss.android.socialbase.downloader.q.kf.ok(this.f50119i);
            this.f50127q = false;
            this.f50119i.resetDataForEtagEndure("");
            this.f50130t.ok(this.f50119i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void em() {
        com.ss.android.socialbase.downloader.impls.ok fb;
        if (ul() || (fb = com.ss.android.socialbase.downloader.downloader.bl.fb()) == null) {
            return;
        }
        fb.j(this.f50119i.getId());
    }

    private void ep() {
        this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_NONE;
    }

    private boolean er() {
        DownloadInfo downloadInfo = this.f50119i;
        if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
            return false;
        }
        return (!this.f50127q || this.f50119i.getChunkCount() > 1) && !this.f50119i.isChunkDowngradeRetryUsed() && this.f50122k && !this.f50121j;
    }

    private void fb() throws BaseException {
        long j4;
        int ok2;
        try {
            j4 = com.ss.android.socialbase.downloader.q.kf.s(this.f50119i.getTempPath());
        } catch (BaseException unused) {
            j4 = 0;
        }
        String str = ok;
        com.ss.android.socialbase.downloader.bl.ok.bl(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.q.kf.ok(j4) + "MB");
        if (j4 > 0) {
            long totalBytes = this.f50119i.getTotalBytes() - this.f50119i.getCurBytes();
            if (j4 < totalBytes && (ok2 = com.ss.android.socialbase.downloader.h.ok.ok(this.f50119i.getId()).ok("space_fill_min_keep_mb", 100)) > 0) {
                long j5 = j4 - (ok2 * 1048576);
                com.ss.android.socialbase.downloader.bl.ok.bl(str, "checkSpaceOverflowInProgress: minKeep  = " + ok2 + "MB, canDownload = " + com.ss.android.socialbase.downloader.q.kf.ok(j5) + "MB");
                if (j5 > 0) {
                    this.fl = this.f50119i.getCurBytes() + j5 + 1048576;
                    return;
                } else {
                    this.fl = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.s(j4, totalBytes);
                }
            }
        }
        this.fl = 0L;
    }

    private void fd() {
        try {
            Iterator it = ((ArrayList) this.kf.clone()).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.a();
                }
            }
        } catch (Throwable th) {
            String str = ok;
            com.ss.android.socialbase.downloader.bl.ok.bl(str, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    private void fl() {
        long kf = com.ss.android.socialbase.downloader.q.kf.kf(this.f50119i);
        long curBytes = this.f50119i.getCurBytes();
        if (kf != curBytes) {
            String str = ok;
            com.ss.android.socialbase.downloader.bl.ok.s(str, "checkTaskCanResume: offset = " + kf + ", curBytes = " + curBytes);
        }
        this.f50119i.setCurBytes(kf);
        boolean z3 = kf > 0;
        this.f50127q = z3;
        if (z3 || this.f50132v) {
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.bl(ok, "checkTaskCanResume: deleteAllDownloadFiles");
        this.f50130t.s(this.f50119i.getId());
        this.f50130t.z(this.f50119i.getId());
        com.ss.android.socialbase.downloader.q.kf.ok(this.f50119i);
    }

    private void g() throws com.ss.android.socialbase.downloader.exception.kf {
        if (this.f50119i.isOnlyWifi() && !com.ss.android.socialbase.downloader.q.kf.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.exception.kf(1019, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.f50119i.isDownloadWithWifiValid()) {
            if (!this.f50119i.isPauseReserveWithWifiValid()) {
                throw new com.ss.android.socialbase.downloader.exception.n();
            }
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.bl();
    }

    private void i() {
        boolean z3;
        boolean z4;
        String str = ok;
        com.ss.android.socialbase.downloader.bl.ok.a(str, "endDownloadRunnable::runStatus=" + this.rh);
        boolean z5 = (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE || this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) ? false : true;
        try {
            z3 = o();
            z4 = false;
        } catch (Exception e4) {
            if (e4 instanceof BaseException) {
                this.ul.ok((BaseException) e4);
            } else {
                this.ul.ok(new BaseException(1046, e4));
            }
            z3 = true;
            z4 = true;
        }
        if (!z3 && !z4) {
            this.er = true;
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "jump to restart");
            return;
        }
        this.f50135z.set(false);
        if (z5) {
            try {
                com.ss.android.socialbase.downloader.impls.ok fb = com.ss.android.socialbase.downloader.downloader.bl.fb();
                if (fb != null) {
                    fb.ok(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                y monitorDepend = this.bl.getMonitorDepend();
                DownloadInfo downloadInfo = this.f50119i;
                BaseException baseException = new BaseException(1014, com.ss.android.socialbase.downloader.q.kf.a(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.f50119i;
                com.ss.android.socialbase.downloader.s.ok.ok(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            }
        }
    }

    private boolean io() {
        return this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED || this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE;
    }

    private void j() {
        boolean z3;
        List<com.ss.android.socialbase.downloader.model.a> bl;
        try {
            this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_NONE;
            this.f50119i.updateStartDownloadTime();
            this.f50119i.resetRealStartDownloadTime();
            long currentTimeMillis = System.currentTimeMillis();
            this.f50119i.setFirstSpeedTime(-1L);
            try {
                k();
                z3 = false;
            } catch (com.ss.android.socialbase.downloader.exception.ok e4) {
                String str = ok;
                com.ss.android.socialbase.downloader.bl.ok.a(str, "file exist " + e4.ok());
                this.f50117g = e4.ok();
                z3 = true;
            }
            if (!this.er) {
                this.ul.a();
            }
            this.er = false;
            if (ul()) {
                return;
            }
            if (!TextUtils.isEmpty(this.f50117g) && z3) {
                if (this.f50119i.isExpiredRedownload()) {
                    this.f50132v = com.ss.android.socialbase.downloader.q.kf.s(this.f50119i);
                }
                if (!this.f50132v) {
                    z();
                    return;
                }
            }
            while (!ul()) {
                try {
                    try {
                        try {
                            v();
                            kz();
                            g();
                            bl = this.f50130t.bl(this.f50119i.getId());
                            fl();
                        } catch (com.ss.android.socialbase.downloader.exception.q e5) {
                            String str2 = ok;
                            com.ss.android.socialbase.downloader.bl.ok.s(str2, "downloadInner: retry throwable for " + e5.ok());
                            if (this.rh != com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
                                AtomicInteger atomicInteger = this.f50124n;
                                if (atomicInteger != null && atomicInteger.get() > 0) {
                                    this.f50119i.updateCurRetryTime(this.f50124n.decrementAndGet());
                                    this.f50119i.setStatus(5);
                                } else if (this.f50124n != null) {
                                    if (this.f50119i.trySwitchToNextBackupUrl()) {
                                        this.f50119i.setStatus(5);
                                        this.f50124n.set(this.f50119i.getRetryCount());
                                        this.f50119i.updateCurRetryTime(this.f50124n.get());
                                    } else {
                                        a(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.f50119i.getRetryCount()), e5.ok())));
                                    }
                                } else {
                                    a(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e5.ok()));
                                }
                                zz();
                            }
                        }
                    } catch (BaseException e6) {
                        String str3 = ok;
                        com.ss.android.socialbase.downloader.bl.ok.s(str3, "downloadInner: baseException = " + e6);
                        if (this.rh != com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
                            if (e6.getErrorCode() != 1025 && e6.getErrorCode() != 1009) {
                                if (ok(e6)) {
                                    if (com.ss.android.socialbase.downloader.q.kf.ok(e6)) {
                                        e();
                                    }
                                    if (ok(e6, 0L) != com.ss.android.socialbase.downloader.exception.p.RETURN) {
                                        zz();
                                    } else {
                                        zz();
                                        return;
                                    }
                                } else {
                                    a(e6);
                                }
                            }
                            this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_RIGHT_NOW;
                            zz();
                            return;
                        }
                    }
                } catch (com.ss.android.socialbase.downloader.exception.ok unused) {
                    z();
                }
                if (rh()) {
                    com.ss.android.socialbase.downloader.bl.ok.bl(ok, "downloadSegments return");
                    zz();
                    return;
                }
                String connectionUrl = this.f50119i.getConnectionUrl();
                if (ul()) {
                    zz();
                    return;
                }
                long n4 = this.f50127q ? com.ss.android.socialbase.downloader.q.kf.n(this.f50119i) : 0L;
                com.ss.android.socialbase.downloader.model.a ok2 = ok(this.f50119i, n4);
                List<com.ss.android.socialbase.downloader.model.bl> ok3 = ok(ok2);
                com.ss.android.socialbase.downloader.q.kf.ok(ok3, this.f50119i);
                com.ss.android.socialbase.downloader.q.kf.a(ok3, this.f50119i);
                this.f50119i.setPreconnectLevel(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    ok(connectionUrl, ok3, n4);
                    this.f50119i.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                    if (ul()) {
                        zz();
                        return;
                    }
                    long totalBytes = this.f50119i.getTotalBytes();
                    ok(totalBytes);
                    int ok4 = ok(totalBytes, bl);
                    if (ul()) {
                        zz();
                        return;
                    } else if (ok4 > 0) {
                        boolean z4 = ok4 == 1;
                        this.f50126p = z4;
                        if (z4) {
                            if (this.f50134y == null) {
                                try {
                                    currentTimeMillis2 = System.currentTimeMillis();
                                    ok(connectionUrl, ok3);
                                    this.f50119i.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                                } finally {
                                }
                            }
                            if (ul()) {
                                zz();
                                return;
                            }
                            this.f50119i.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            t();
                            ok(ok2, connectionUrl, this.f50134y);
                        } else {
                            if (!this.f50119i.isNeedReuseFirstConnection()) {
                                td();
                            }
                            if (ul()) {
                                zz();
                                return;
                            }
                            t();
                            this.f50119i.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            if (this.f50127q) {
                                ok(ok4, bl);
                            } else {
                                ok(totalBytes, ok4);
                            }
                        }
                        zz();
                        return;
                    } else {
                        throw new BaseException(1032, "chunkCount is 0");
                    }
                } finally {
                }
            }
        } finally {
            i();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f3, code lost:
        if (r9.fd.ok("fix_file_exist_update_download_info") != false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab A[Catch: all -> 0x00e8, TryCatch #5 {all -> 0x00e8, blocks: (B:56:0x00a7, B:58:0x00ab, B:60:0x00af, B:73:0x00e7), top: B:84:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() throws com.ss.android.socialbase.downloader.exception.ok {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.bl.k():void");
    }

    private void kz() throws com.ss.android.socialbase.downloader.exception.q, BaseException {
        com.ss.android.socialbase.downloader.impls.ok fb;
        int id = this.f50119i.getId();
        int ok2 = com.ss.android.socialbase.downloader.downloader.bl.ok(this.f50119i);
        if (this.f50119i.isDownloaded() && !this.f50119i.isExpiredRedownload() && !this.f50132v) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo a4 = this.f50130t.a(ok2);
        if (a4 == null || (fb = com.ss.android.socialbase.downloader.downloader.bl.fb()) == null || a4.getId() == id || !a4.equalsTask(this.f50119i)) {
            return;
        }
        if (!fb.ok(a4.getId())) {
            List<com.ss.android.socialbase.downloader.model.a> bl = this.f50130t.bl(ok2);
            com.ss.android.socialbase.downloader.q.kf.ok(this.f50119i);
            this.f50130t.kf(ok2);
            if (a4.isBreakpointAvailable()) {
                this.f50119i.copyFromCacheData(a4, false);
                this.f50130t.ok(this.f50119i);
                if (bl != null) {
                    for (com.ss.android.socialbase.downloader.model.a aVar : bl) {
                        aVar.a(id);
                        this.f50130t.ok(aVar);
                    }
                }
                throw new com.ss.android.socialbase.downloader.exception.q("retry task because id generator changed");
            }
            return;
        }
        this.f50130t.kf(id);
        throw new BaseException(1025, "another same task is downloading");
    }

    private boolean m() {
        if (this.f50119i.isChunked()) {
            DownloadInfo downloadInfo = this.f50119i;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        String str = ok;
        com.ss.android.socialbase.downloader.bl.ok.bl(str, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.f50119i.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.f50119i.getTotalBytes());
        if (this.f50119i.getCurBytes() > 0) {
            if (this.f50119i.isIgnoreDataVerify()) {
                return true;
            }
            if (this.f50119i.getTotalBytes() > 0 && this.f50119i.getCurBytes() == this.f50119i.getTotalBytes()) {
                return true;
            }
        }
        this.f50119i.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.f50119i.reset();
        this.f50130t.ok(this.f50119i);
        this.f50130t.s(this.f50119i.getId());
        this.f50130t.z(this.f50119i.getId());
        com.ss.android.socialbase.downloader.q.kf.ok(this.f50119i);
        return false;
    }

    private boolean o() {
        if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_ERROR) {
            this.ul.ok(this.f50125o);
        } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) {
            this.ul.bl();
        } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
            this.ul.s();
        } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.ul.h();
            } catch (BaseException e4) {
                this.ul.ok(e4);
            }
        } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.ul.ok(this.f50117g);
            } catch (BaseException e5) {
                this.ul.ok(e5);
            }
        } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.ul.ok(this.f50125o, false);
            return false;
        } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            return true;
        } else {
            com.ss.android.socialbase.downloader.constants.p pVar = this.rh;
            com.ss.android.socialbase.downloader.constants.p pVar2 = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_RETRY_DELAY;
            if (pVar == pVar2 && !y()) {
                com.ss.android.socialbase.downloader.bl.ok.a(ok, "doTaskStatusHandle retryDelay");
                ep();
                return this.rh == pVar2;
            }
            try {
                if (!m()) {
                    return false;
                }
                this.ul.kf();
                com.ss.android.socialbase.downloader.impls.td.ok().s();
            } catch (Throwable th) {
                a(new BaseException(1008, com.ss.android.socialbase.downloader.q.kf.a(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    private void p() {
        DownloadInfo downloadInfo = this.f50119i;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.f50119i.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.f50124n;
        if (atomicInteger == null) {
            this.f50124n = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    private boolean q() {
        int status = this.f50119i.getStatus();
        if (status == 1 || this.f50119i.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        a(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058 A[LOOP:0: B:24:0x0058->B:57:0x0058, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void r() {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.bl.r():void");
    }

    private boolean rh() throws BaseException, InterruptedException {
        if (!this.f50119i.isExpiredRedownload() && this.f50119i.getChunkCount() == 1 && this.f50119i.getThrottleNetSpeed() <= 0) {
            JSONObject s3 = com.ss.android.socialbase.downloader.h.ok.ok(this.f50119i.getId()).s("segment_config");
            List<com.ss.android.socialbase.downloader.kf.q> rh = this.f50130t.rh(this.f50119i.getId());
            if (this.f50119i.getCurBytes() > 0) {
                if (rh == null || rh.isEmpty()) {
                    return false;
                }
                if (s3 == null) {
                    s3 = new JSONObject();
                }
            }
            if (s3 == null) {
                return false;
            }
            this.sg = new r(this.f50119i, rh.ok(s3), this);
            if (ul()) {
                com.ss.android.socialbase.downloader.bl.ok.bl(ok, "downloadSegments: is stopped by user");
                if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) {
                    this.sg.ok();
                } else {
                    this.sg.a();
                }
                return true;
            }
            return this.sg.ok(rh);
        }
        return false;
    }

    private boolean sg() {
        return false;
    }

    private void t() {
        if (com.ss.android.socialbase.downloader.h.ok.ok(this.f50119i.getId()).ok("reset_retain_retry_times", 0) != 1 || this.em >= 3) {
            return;
        }
        this.f50124n.set(this.f50119i.isBackUpUrlUsed() ? this.f50119i.getBackUpUrlRetryCount() : this.f50119i.getRetryCount());
        this.em++;
    }

    private void td() {
        q qVar = this.f50134y;
        if (qVar != null) {
            qVar.s();
            this.f50134y = null;
        }
    }

    private void u() throws BaseException {
        if (this.f50118h != null) {
            if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) {
                this.f50119i.setStatus(-4);
                this.f50118h.bl();
            } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
                this.f50119i.setStatus(-2);
                this.f50118h.a();
            } else {
                this.f50118h.s();
            }
        }
    }

    private boolean ul() {
        if (io() || this.f50119i.getStatus() == -2) {
            if (io()) {
                return true;
            }
            if (this.f50119i.getStatus() == -2) {
                this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE;
                return true;
            } else if (this.f50119i.getStatus() == -4) {
                this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED;
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    private void v() throws BaseException {
        if (!TextUtils.isEmpty(this.f50119i.getSavePath())) {
            if (!TextUtils.isEmpty(this.f50119i.getName())) {
                File file = new File(this.f50119i.getSavePath());
                if (!file.exists()) {
                    boolean mkdirs = file.mkdirs();
                    if (mkdirs || file.exists()) {
                        return;
                    }
                    int i4 = 0;
                    if (com.ss.android.socialbase.downloader.h.ok.ok(this.f50119i.getId()).ok("opt_mkdir_failed", 0) == 1) {
                        while (!mkdirs) {
                            int i5 = i4 + 1;
                            if (i4 >= 3) {
                                break;
                            }
                            try {
                                Thread.sleep(10L);
                                mkdirs = file.mkdirs();
                                i4 = i5;
                            } catch (InterruptedException unused) {
                            }
                        }
                        if (mkdirs || file.exists()) {
                            return;
                        }
                        if (com.ss.android.socialbase.downloader.q.kf.s(this.f50119i.getSavePath()) < 16384) {
                            throw new BaseException(1006, "download savePath directory can not created:" + this.f50119i.getSavePath());
                        }
                        throw new BaseException(1030, "download savePath directory can not created:" + this.f50119i.getSavePath());
                    }
                    throw new BaseException(1030, "download savePath directory can not created:" + this.f50119i.getSavePath());
                } else if (file.isDirectory()) {
                    return;
                } else {
                    if (com.ss.android.socialbase.downloader.q.s.a(this.f50119i)) {
                        file.delete();
                        if (file.mkdirs() || file.exists()) {
                            return;
                        }
                        throw new BaseException(1031, "download savePath is not directory:path=" + this.f50119i.getSavePath());
                    }
                    throw new BaseException(1031, "download savePath is not a directory:" + this.f50119i.getSavePath());
                }
            }
            throw new BaseException(1029, "download name can not be empty");
        }
        throw new BaseException(1028, "download savePath can not be empty");
    }

    private long vz() {
        return this.f50120io.ok(this.f50119i.getCurRetryTimeInTotal(), this.f50119i.getTotalRetryCount());
    }

    private void x() {
        com.ss.android.socialbase.downloader.network.h hVar = this.f50123m;
        if (hVar != null) {
            hVar.bl();
            this.f50123m = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean y() {
        /*
            r7 = this;
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.f50119i
            int r0 = r0.getChunkCount()
            r1 = 0
            r2 = 1
            if (r0 > r2) goto L28
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.f50119i
            long r3 = r0.getCurBytes()
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L27
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.f50119i
            long r3 = r0.getCurBytes()
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.f50119i
            long r5 = r0.getTotalBytes()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L27
            return r2
        L27:
            return r1
        L28:
            com.ss.android.socialbase.downloader.downloader.k r0 = r7.f50130t
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r7.f50119i
            int r3 = r3.getId()
            java.util.List r0 = r0.bl(r3)
            if (r0 == 0) goto L57
            int r3 = r0.size()
            if (r3 > r2) goto L3d
            goto L57
        L3d:
            java.util.Iterator r0 = r0.iterator()
        L41:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L56
            java.lang.Object r3 = r0.next()
            com.ss.android.socialbase.downloader.model.a r3 = (com.ss.android.socialbase.downloader.model.a) r3
            if (r3 == 0) goto L55
            boolean r3 = r3.q()
            if (r3 != 0) goto L41
        L55:
            return r1
        L56:
            return r2
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.bl.y():boolean");
    }

    private void z() {
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.h.ok.bl().a("fix_end_for_file_exist_error", true)) {
            if (this.f50117g.equals(this.f50119i.getName())) {
                this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_RIGHT_NOW;
            } else {
                this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_FOR_FILE_EXIST;
            }
        } else if (this.f50117g.equals(this.f50119i.getTargetFilePath())) {
            this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private void zz() {
        x();
        td();
    }

    public void a() {
        com.ss.android.socialbase.downloader.constants.p pVar = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED;
        this.rh = pVar;
        if (this.sg != null) {
            this.sg.ok();
        }
        if (this.f50118h != null) {
            this.f50118h.bl();
        }
        if (this.sg == null && this.f50118h == null) {
            zz();
            this.rh = pVar;
            i();
        }
        fd();
    }

    public DownloadTask bl() {
        return this.bl;
    }

    public Future h() {
        return this.f50115a;
    }

    public void kf() {
        this.f50116e = System.currentTimeMillis();
        this.ul.ok();
    }

    public int n() {
        DownloadInfo downloadInfo = this.f50119i;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.bl.ok(this.bl, 3);
        try {
            com.ss.android.socialbase.downloader.network.a.ok().a();
            r();
            com.ss.android.socialbase.downloader.network.a.ok().bl();
            com.ss.android.socialbase.downloader.downloader.bl.a(this.bl, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.network.a.ok().bl();
            throw th;
        }
    }

    public boolean s() {
        return this.f50135z.get();
    }

    private boolean s(BaseException baseException) {
        AtomicInteger atomicInteger = this.f50124n;
        boolean z3 = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                if (this.f50119i.trySwitchToNextBackupUrl()) {
                    this.f50124n.set(this.f50119i.getBackUpUrlRetryCount());
                    this.f50119i.updateCurRetryTime(this.f50124n.get());
                } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.f50119i.canReplaceHttpForRetry())) {
                    this.f50124n.set(this.f50119i.getRetryCount());
                    this.f50119i.updateCurRetryTime(this.f50124n.get());
                    this.f50119i.setHttpsToHttpRetryUsed(true);
                } else {
                    a(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.f50124n), String.valueOf(this.f50119i.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                z3 = false;
            }
            if (this.rh != com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_RETRY_DELAY && z3) {
                this.f50119i.updateCurRetryTime(this.f50124n.decrementAndGet());
            }
            return false;
        }
        a(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public void bl(BaseException baseException) {
        DownloadInfo downloadInfo = this.f50119i;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        ok(baseException, false);
    }

    public void ok() {
        com.ss.android.socialbase.downloader.constants.p pVar = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE;
        this.rh = pVar;
        if (this.sg != null) {
            this.sg.a();
        }
        if (this.f50118h != null) {
            this.f50118h.a();
        }
        if (this.sg == null && this.f50118h == null) {
            zz();
            this.rh = pVar;
            i();
        }
        try {
            Iterator it = ((ArrayList) this.kf.clone()).iterator();
            while (it.hasNext()) {
                a aVar = (a) it.next();
                if (aVar != null) {
                    aVar.ok();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bl(long j4) {
        q qVar = this.f50134y;
        if (qVar != null && (qVar instanceof com.ss.android.socialbase.downloader.network.ok)) {
            try {
                ((com.ss.android.socialbase.downloader.network.ok) qVar).ok(j4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void a(String str, List<com.ss.android.socialbase.downloader.model.bl> list, long j4) throws BaseException, com.ss.android.socialbase.downloader.exception.q {
        com.ss.android.socialbase.downloader.network.ok.bl ok2;
        boolean z3 = true;
        if (this.f50119i.getChunkCount() == 1 && (ok2 = com.ss.android.socialbase.downloader.network.ok.ok.ok().ok(str, list)) != null) {
            this.f50123m = ok2;
            this.f50119i.setPreconnectLevel(1);
        }
        if (this.f50123m == null && !this.fb && this.f50119i.isHeadConnectionAvailable()) {
            try {
                int a4 = this.fd.a("net_lib_strategy");
                if (this.fd.ok("monitor_download_connect", 0) <= 0) {
                    z3 = false;
                }
                this.f50123m = com.ss.android.socialbase.downloader.downloader.bl.ok(str, list, a4, z3, this.f50119i);
            } catch (Throwable th) {
                this.f50119i.setHeadConnectionException(com.ss.android.socialbase.downloader.q.kf.k(th));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r9 <= 0) goto L22;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int ok(long r7, java.util.List<com.ss.android.socialbase.downloader.model.a> r9) {
        /*
            r6 = this;
            boolean r0 = r6.er()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5e
            boolean r0 = r6.f50127q
            if (r0 == 0) goto L1a
            if (r9 == 0) goto L13
            int r9 = r9.size()
            goto L5c
        L13:
            com.ss.android.socialbase.downloader.model.DownloadInfo r9 = r6.f50119i
            int r9 = r9.getChunkCount()
            goto L5c
        L1a:
            com.ss.android.socialbase.downloader.downloader.p r9 = r6.f50133x
            if (r9 == 0) goto L23
            int r9 = r9.ok(r7)
            goto L29
        L23:
            com.ss.android.socialbase.downloader.downloader.p r9 = r6.td
            int r9 = r9.ok(r7)
        L29:
            com.ss.android.socialbase.downloader.network.r r0 = com.ss.android.socialbase.downloader.network.r.ok()
            com.ss.android.socialbase.downloader.network.j r0 = r0.a()
            java.lang.String r3 = com.ss.android.socialbase.downloader.p.bl.ok
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r0.name()
            r4[r1] = r5
            java.lang.String r5 = "NetworkQuality is : %s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            com.ss.android.socialbase.downloader.bl.ok.a(r3, r4)
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r6.f50119i
            java.lang.String r4 = r0.name()
            r3.setNetworkQuality(r4)
            com.ss.android.socialbase.downloader.downloader.h r3 = r6.zz
            if (r3 == 0) goto L56
            int r9 = r3.ok(r9, r0)
            goto L5c
        L56:
            com.ss.android.socialbase.downloader.downloader.h r3 = r6.f50131u
            int r9 = r3.ok(r9, r0)
        L5c:
            if (r9 > 0) goto L5f
        L5e:
            r9 = 1
        L5f:
            boolean r0 = com.ss.android.socialbase.downloader.bl.ok.ok()
            if (r0 == 0) goto L88
            java.lang.String r0 = com.ss.android.socialbase.downloader.p.bl.ok
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = java.lang.String.valueOf(r9)
            r3[r1] = r4
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r6.f50119i
            java.lang.String r1 = r1.getName()
            r3[r2] = r1
            r1 = 2
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r3[r1] = r7
            java.lang.String r7 = "chunk count : %s for %s contentLen:%s"
            java.lang.String r7 = java.lang.String.format(r7, r3)
            com.ss.android.socialbase.downloader.bl.ok.a(r0, r7)
        L88:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.bl.ok(long, java.util.List):int");
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public boolean a(long j4) throws BaseException {
        if (this.fl > 0 && this.f50119i.getCurBytes() > this.fl) {
            fb();
        }
        return this.ul.ok(j4);
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public void a(BaseException baseException) {
        String str = ok;
        com.ss.android.socialbase.downloader.bl.ok.a(str, "onError:" + baseException.getMessage());
        this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_ERROR;
        this.f50125o = baseException;
        fd();
    }

    private void ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list, long j4) throws BaseException, com.ss.android.socialbase.downloader.exception.q {
        a(str, list, j4);
        com.ss.android.socialbase.downloader.network.h hVar = this.f50123m;
        if (hVar != null) {
            try {
                ok(str, hVar, j4);
            } catch (Throwable unused) {
                this.fb = true;
            }
        }
        if (this.f50123m == null || this.fb) {
            ok(str, list);
            ok(str, this.f50134y, j4);
        }
    }

    private void ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws BaseException, com.ss.android.socialbase.downloader.exception.q {
        q qVar;
        if (this.f50134y != null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.ok.s a4 = this.f50119i.getChunkCount() == 1 ? com.ss.android.socialbase.downloader.network.ok.ok.ok().a(str, list) : null;
        try {
            if (a4 != null) {
                ok(this.f50134y);
                this.f50119i.setPreconnectLevel(2);
                this.f50134y = a4;
            } else {
                try {
                    qVar = com.ss.android.socialbase.downloader.downloader.bl.ok(this.f50119i.isNeedDefaultHttpServiceBackUp(), this.f50119i.getMaxBytes(), str, null, list, this.fd.a("net_lib_strategy"), this.fd.ok("monitor_download_connect", 0) > 0, this.f50119i);
                    this.f50134y = qVar;
                } catch (BaseException e4) {
                    throw e4;
                } catch (Throwable th) {
                    if (this.f50119i.isExpiredRedownload() && com.ss.android.socialbase.downloader.q.kf.h(th) && com.ss.android.socialbase.downloader.q.kf.bl(list)) {
                        com.ss.android.socialbase.downloader.bl.ok.a(ok, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.f50119i.getCacheControl());
                        long q3 = com.ss.android.socialbase.downloader.q.kf.q(this.f50119i.getCacheControl());
                        if (q3 <= 0) {
                            q3 = com.ss.android.socialbase.downloader.h.ok.ok(this.f50119i.getId()).ok("default_304_max_age", 300);
                        }
                        this.f50119i.setCacheExpiredTime(System.currentTimeMillis() + (q3 * 1000));
                        throw new com.ss.android.socialbase.downloader.exception.ok(this.f50117g);
                    }
                    if (com.ss.android.socialbase.downloader.q.kf.kf(th)) {
                        ok("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.q.kf.n(th)) {
                        ok("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.q.kf.ok(th, "CreateFirstConnection");
                    }
                    qVar = this.f50134y;
                }
                ok(qVar);
            }
            if (this.f50134y == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            ok(this.f50134y);
            throw th2;
        }
    }

    public static com.ss.android.socialbase.downloader.model.a ok(DownloadInfo downloadInfo, long j4) {
        return new a.ok(downloadInfo.getId()).ok(-1).ok(0L).n(j4).a(j4).bl(0L).s(downloadInfo.getTotalBytes() - j4).ok();
    }

    private List<com.ss.android.socialbase.downloader.model.bl> ok(com.ss.android.socialbase.downloader.model.a aVar) {
        List<com.ss.android.socialbase.downloader.model.bl> ok2 = com.ss.android.socialbase.downloader.q.kf.ok(this.f50119i.getExtraHeaders(), this.f50119i.geteTag(), aVar);
        if (this.f50119i.isExpiredRedownload() && this.f50132v && this.f50119i.getLastModified() != null) {
            ok2.add(new com.ss.android.socialbase.downloader.model.bl("if-modified-since", this.f50119i.getLastModified()));
            ok2.add(new com.ss.android.socialbase.downloader.model.bl("download-tc21-1-15", "download-tc21-1-15"));
            String str = ok;
            com.ss.android.socialbase.downloader.bl.ok.a(str, "dcache::add head IF_MODIFIED_SINCE=" + this.f50119i.getLastModified());
        }
        return ok2;
    }

    private void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list) throws BaseException {
        if (list.size() == i4) {
            ok(list, this.f50119i.getTotalBytes());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    private void ok(long j4, int i4) throws BaseException {
        long j5 = j4 / i4;
        int id = this.f50119i.getId();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        long j6 = 0;
        while (i5 < i4) {
            com.ss.android.socialbase.downloader.model.a ok2 = new a.ok(id).ok(i5).ok(j6).n(j6).a(j6).bl(i5 == i4 + (-1) ? 0L : (j6 + j5) - 1).ok();
            arrayList.add(ok2);
            this.f50130t.ok(ok2);
            j6 += j5;
            i5++;
        }
        this.f50119i.setChunkCount(i4);
        this.f50130t.ok(id, i4);
        ok(arrayList, j4);
    }

    private void ok(List<com.ss.android.socialbase.downloader.model.a> list, long j4) throws BaseException {
        long i4;
        for (com.ss.android.socialbase.downloader.model.a aVar : list) {
            if (aVar != null) {
                if (aVar.i() == 0) {
                    i4 = j4 - aVar.rh();
                } else {
                    i4 = (aVar.i() - aVar.rh()) + 1;
                }
                if (i4 > 0) {
                    aVar.ok(i4);
                    if (this.f50119i.isNeedReuseFirstConnection() && this.f50134y != null && (!this.f50119i.isHeadConnectionAvailable() || this.fb)) {
                        if (aVar.zz() == 0) {
                            this.kf.add(new a(aVar, this.bl, this.f50134y, this));
                        } else if (aVar.zz() > 0) {
                            this.kf.add(new a(aVar, this.bl, this));
                        }
                    } else {
                        this.kf.add(new a(aVar, this.bl, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.q.ok.ok(64)) {
            ArrayList arrayList = new ArrayList(this.kf.size());
            Iterator<a> it = this.kf.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) {
                    next.a();
                } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
                    next.ok();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> s3 = com.ss.android.socialbase.downloader.impls.n.s(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.n.n(s3)) {
                    if (ul()) {
                        return;
                    }
                    runnable.run();
                }
                if (s3 == null || s3.isEmpty()) {
                    return;
                }
                for (Future future : s3) {
                    if (future != null && !future.isDone()) {
                        try {
                            future.get();
                        } catch (Throwable unused) {
                        }
                    }
                }
                return;
            } catch (Throwable unused2) {
                return;
            }
        }
        ArrayList arrayList2 = new ArrayList(this.kf.size());
        Iterator<a> it2 = this.kf.iterator();
        while (it2.hasNext()) {
            a next2 = it2.next();
            if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_CANCELED) {
                next2.a();
            } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_PAUSE) {
                next2.ok();
            } else {
                arrayList2.add(Executors.callable(next2));
            }
        }
        if (ul()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.n.bl(arrayList2);
        } catch (InterruptedException e4) {
            throw new BaseException(1020, e4);
        }
    }

    private void ok(com.ss.android.socialbase.downloader.model.a aVar, String str, q qVar) throws BaseException {
        aVar.ok(this.f50119i.getTotalBytes() - aVar.rh());
        this.f50119i.setChunkCount(1);
        this.f50130t.ok(this.f50119i.getId(), 1);
        this.f50118h = new com.ss.android.socialbase.downloader.downloader.n(this.f50119i, str, qVar, aVar, this);
        u();
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public void ok(long j4) throws BaseException {
        long j5;
        String tempPath = this.f50119i.getTempPath();
        String tempName = this.f50119i.getTempName();
        if (com.ss.android.socialbase.downloader.q.kf.a(j4)) {
            return;
        }
        com.ss.android.socialbase.downloader.model.n ok2 = com.ss.android.socialbase.downloader.q.kf.ok(this.f50119i, tempPath, tempName, -1);
        try {
            long length = new File(tempPath, tempName).length();
            long j6 = j4 - length;
            long s3 = com.ss.android.socialbase.downloader.q.kf.s(tempPath);
            com.ss.android.socialbase.downloader.h.ok ok3 = com.ss.android.socialbase.downloader.h.ok.ok(this.f50119i.getId());
            if (ok3.ok("space_fill_part_download", 0) == 1) {
                this.fl = 0L;
                if (j6 <= 0) {
                    j6 = this.f50119i.getTotalBytes() - this.f50119i.getCurBytes();
                }
                if (s3 < j6) {
                    String str = ok;
                    com.ss.android.socialbase.downloader.bl.ok.s(str, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.q.kf.ok(j4) + "MB, downloaded = " + com.ss.android.socialbase.downloader.q.kf.ok(length) + "MB, required = " + com.ss.android.socialbase.downloader.q.kf.ok(j6) + "MB, available = " + com.ss.android.socialbase.downloader.q.kf.ok(s3) + "MB");
                    if (s3 > 0) {
                        int ok4 = ok3.ok("space_fill_min_keep_mb", 100);
                        if (ok4 > 0) {
                            long j7 = s3 - (ok4 * 1048576);
                            com.ss.android.socialbase.downloader.bl.ok.s(str, "checkSpaceOverflow: minKeep = " + ok4 + "MB, canDownload = " + com.ss.android.socialbase.downloader.q.kf.ok(j7) + "MB");
                            if (j7 > 0) {
                                this.fl = this.f50119i.getCurBytes() + j7;
                                j5 = j7;
                            } else {
                                throw new com.ss.android.socialbase.downloader.exception.s(s3, j6);
                            }
                        } else {
                            j5 = s3;
                        }
                        if (length < j4) {
                            if (j5 + length > j4) {
                            }
                            ok2.a(j4);
                            com.ss.android.socialbase.downloader.q.kf.ok(ok2);
                        }
                    } else if (ok3.ok("download_when_space_negative", 0) != 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("availableSpace ");
                        sb.append(s3 == 0 ? "=" : "<");
                        sb.append(" 0");
                        throw new BaseException(1052, sb.toString());
                    } else {
                        ok2.a(j4);
                        com.ss.android.socialbase.downloader.q.kf.ok(ok2);
                    }
                }
            } else if (s3 <= 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("availableSpace ");
                sb2.append(s3 == 0 ? "=" : "<");
                sb2.append(" 0");
                throw new BaseException(1052, sb2.toString());
            } else if (s3 < j6) {
                throw new com.ss.android.socialbase.downloader.exception.s(s3, j6);
            }
            ok2.a(j4);
            com.ss.android.socialbase.downloader.q.kf.ok(ok2);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.q.kf.ok(ok2);
            throw th;
        }
    }

    private boolean ok(int i4, String str, String str2) {
        if (i4 == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.f50128r || this.f50122k)) {
            return (i4 == 201 || i4 == 416) && this.f50119i.getCurBytes() > 0;
        }
        return true;
    }

    private void ok(String str, String str2) throws com.ss.android.socialbase.downloader.exception.q {
        this.f50130t.s(this.f50119i.getId());
        this.f50130t.z(this.f50119i.getId());
        com.ss.android.socialbase.downloader.q.kf.ok(this.f50119i);
        this.f50127q = false;
        this.f50119i.resetDataForEtagEndure(str);
        this.f50130t.ok(this.f50119i);
        throw new com.ss.android.socialbase.downloader.exception.q(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0253, code lost:
        r8 = com.ss.android.socialbase.downloader.q.kf.a(r10, "Content-Range");
        com.ss.android.socialbase.downloader.bl.ok.bl(r14, "firstConnection: contentRange = " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0271, code lost:
        if (android.text.TextUtils.isEmpty(r8) != false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x027c, code lost:
        if (r19.fd.a("fix_get_total_bytes", true) == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x027e, code lost:
        r3 = com.ss.android.socialbase.downloader.q.kf.a(r8);
        com.ss.android.socialbase.downloader.bl.ok.bl(r14, "firstConnection: 1 totalLength = " + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0297, code lost:
        r11 = r22 + r3;
        com.ss.android.socialbase.downloader.bl.ok.n(r14, "firstConnection: 2 totalLength = " + r11 + ", contentLength = " + r3);
        r3 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x013a, code lost:
        com.ss.android.socialbase.downloader.q.kf.ok(r19.f50119i);
     */
    @Override // com.ss.android.socialbase.downloader.p.kf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ok(java.lang.String r20, com.ss.android.socialbase.downloader.network.h r21, long r22) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.q {
        /*
            Method dump skipped, instructions count: 855
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.bl.ok(java.lang.String, com.ss.android.socialbase.downloader.network.h, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public void ok(a aVar) {
        if (this.f50126p) {
            return;
        }
        synchronized (this) {
            this.kf.remove(aVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public boolean ok(BaseException baseException) {
        if (this.sg == null || !com.ss.android.socialbase.downloader.q.kf.q(baseException) || this.f50124n.get() >= this.f50119i.getRetryCount()) {
            if (com.ss.android.socialbase.downloader.q.kf.a(baseException)) {
                if (this.f50126p && !this.f50129s) {
                    com.ss.android.socialbase.downloader.q.kf.ok(this.f50119i);
                    this.f50129s = true;
                }
                return true;
            }
            AtomicInteger atomicInteger = this.f50124n;
            if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.f50119i.hasNextBackupUrl()) {
                if (baseException == null) {
                    return false;
                }
                if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.f50119i.canReplaceHttpForRetry()) {
                    return false;
                }
            }
            return !(baseException instanceof com.ss.android.socialbase.downloader.exception.kf);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public void ok(BaseException baseException, boolean z3) {
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "onAllChunkRetryWithReset");
        this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.f50125o = baseException;
        fd();
        if (z3 ? s(baseException) : false) {
            return;
        }
        e();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.f50119i.setForbiddenBackupUrls(list, this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.ok fb = com.ss.android.socialbase.downloader.downloader.bl.fb();
        if (fb != null) {
            fb.j(this.f50119i.getId());
        }
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public com.ss.android.socialbase.downloader.exception.p ok(com.ss.android.socialbase.downloader.model.a aVar, BaseException baseException, long j4) {
        if (io()) {
            return com.ss.android.socialbase.downloader.exception.p.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.q.kf.p(baseException))) {
            return ok(baseException, j4);
        }
        this.f50125o = baseException;
        this.f50119i.increaseCurBytes(-j4);
        this.f50130t.ok(this.f50119i);
        if (s(baseException)) {
            return com.ss.android.socialbase.downloader.exception.p.RETURN;
        }
        com.ss.android.socialbase.downloader.downloader.kf kfVar = this.ul;
        com.ss.android.socialbase.downloader.constants.p pVar = this.rh;
        com.ss.android.socialbase.downloader.constants.p pVar2 = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_RETRY_DELAY;
        kfVar.ok(aVar, baseException, pVar == pVar2);
        if (this.rh != pVar2 && this.f50119i.isNeedRetryDelay()) {
            long vz = vz();
            if (vz > 0) {
                String str = ok;
                com.ss.android.socialbase.downloader.bl.ok.bl(str, "onSingleChunkRetry with delay time " + vz);
                try {
                    Thread.sleep(vz);
                } catch (Throwable th) {
                    String str2 = ok;
                    com.ss.android.socialbase.downloader.bl.ok.s(str2, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.p.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public com.ss.android.socialbase.downloader.exception.p ok(BaseException baseException, long j4) {
        long totalBytes;
        long j5;
        boolean z3;
        this.f50125o = baseException;
        this.f50119i.increaseCurBytes(-j4);
        this.f50130t.ok(this.f50119i);
        if (io()) {
            return com.ss.android.socialbase.downloader.exception.p.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.ep != null && !this.f50119i.isForbiddenRetryed()) {
                com.ss.android.socialbase.downloader.depend.a aVar = new com.ss.android.socialbase.downloader.depend.a() { // from class: com.ss.android.socialbase.downloader.p.bl.1
                    @Override // com.ss.android.socialbase.downloader.depend.a, com.ss.android.socialbase.downloader.depend.ul
                    public void ok(List<String> list) {
                        super.ok(list);
                        bl.this.ok(list);
                    }
                };
                boolean ok2 = this.ep.ok(aVar);
                this.f50119i.setForbiddenRetryed();
                if (ok2) {
                    if (!aVar.ok()) {
                        fd();
                        this.ul.p();
                        this.rh = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.exception.p.RETURN;
                    }
                    z3 = true;
                }
            } else if (s(baseException)) {
                return com.ss.android.socialbase.downloader.exception.p.RETURN;
            }
            z3 = false;
        } else if (com.ss.android.socialbase.downloader.q.kf.p(baseException)) {
            if (this.vz == null) {
                a(baseException);
                return com.ss.android.socialbase.downloader.exception.p.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            x xVar = new x() { // from class: com.ss.android.socialbase.downloader.p.bl.2
                @Override // com.ss.android.socialbase.downloader.depend.x
                public void ok() {
                    synchronized (bl.this) {
                        atomicBoolean.set(true);
                        bl.this.em();
                    }
                }
            };
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.s) {
                com.ss.android.socialbase.downloader.exception.s sVar = (com.ss.android.socialbase.downloader.exception.s) baseException;
                j5 = sVar.ok();
                totalBytes = sVar.a();
            } else {
                totalBytes = this.f50119i.getTotalBytes();
                j5 = -1;
            }
            synchronized (this) {
                if (this.vz.ok(j5, totalBytes, xVar)) {
                    if (!com.ss.android.socialbase.downloader.h.ok.ok(this.f50119i.getId()).a("not_delete_when_clean_space", false)) {
                        m();
                    }
                    if (!atomicBoolean.get()) {
                        com.ss.android.socialbase.downloader.constants.p pVar = this.rh;
                        com.ss.android.socialbase.downloader.constants.p pVar2 = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        if (pVar != pVar2) {
                            this.rh = pVar2;
                            fd();
                            this.ul.p();
                        }
                        return com.ss.android.socialbase.downloader.exception.p.RETURN;
                    }
                    if (s(baseException)) {
                        return com.ss.android.socialbase.downloader.exception.p.RETURN;
                    }
                    z3 = true;
                } else if (this.rh == com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                    return com.ss.android.socialbase.downloader.exception.p.RETURN;
                } else {
                    a(baseException);
                    return com.ss.android.socialbase.downloader.exception.p.RETURN;
                }
            }
        } else {
            if (s(baseException)) {
                return com.ss.android.socialbase.downloader.exception.p.RETURN;
            }
            z3 = false;
        }
        if (!z3 && sg()) {
            fd();
        }
        com.ss.android.socialbase.downloader.downloader.kf kfVar = this.ul;
        com.ss.android.socialbase.downloader.constants.p pVar3 = this.rh;
        com.ss.android.socialbase.downloader.constants.p pVar4 = com.ss.android.socialbase.downloader.constants.p.RUN_STATUS_RETRY_DELAY;
        kfVar.ok(baseException, pVar3 == pVar4);
        return this.rh == pVar4 ? com.ss.android.socialbase.downloader.exception.p.RETURN : com.ss.android.socialbase.downloader.exception.p.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.p.kf
    public synchronized com.ss.android.socialbase.downloader.model.a ok(int i4) {
        com.ss.android.socialbase.downloader.model.a ok2;
        if (this.f50119i.getChunkCount() < 2) {
            return null;
        }
        List<com.ss.android.socialbase.downloader.model.a> bl = this.f50130t.bl(this.f50119i.getId());
        if (bl != null && !bl.isEmpty()) {
            for (int i5 = 0; i5 < bl.size(); i5++) {
                com.ss.android.socialbase.downloader.model.a aVar = bl.get(i5);
                if (aVar != null && (ok2 = ok(aVar, i4)) != null) {
                    return ok2;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    @Override // com.ss.android.socialbase.downloader.p.kf
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void ok(com.ss.android.socialbase.downloader.network.h r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1a
            int r2 = r2.a()     // Catch: java.lang.Throwable -> L16
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r1.f50119i     // Catch: java.lang.Throwable -> L16
            r0.setHttpStatusCode(r2)     // Catch: java.lang.Throwable -> L16
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r1.f50119i     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = com.ss.android.socialbase.downloader.q.a.ok(r2)     // Catch: java.lang.Throwable -> L16
            r0.setHttpStatusMessage(r2)     // Catch: java.lang.Throwable -> L16
            r2 = 1
            goto L1b
        L16:
            r2 = move-exception
            r2.printStackTrace()
        L1a:
            r2 = 0
        L1b:
            if (r2 != 0) goto L2a
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r1.f50119i
            r0 = -1
            r2.setHttpStatusCode(r0)
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r1.f50119i
            java.lang.String r0 = ""
            r2.setHttpStatusMessage(r0)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.bl.ok(com.ss.android.socialbase.downloader.network.h):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r9.kf() != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.model.a ok(com.ss.android.socialbase.downloader.model.a r9, int r10) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.p.bl.ok(com.ss.android.socialbase.downloader.model.a, int):com.ss.android.socialbase.downloader.model.a");
    }

    private zz ok(DownloadTask downloadTask) {
        zz retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.ss.android.socialbase.downloader.impls.x(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.bl.xy();
    }

    public void ok(Future future) {
        this.f50115a = future;
    }
}
