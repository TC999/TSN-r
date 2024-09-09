package com.ss.android.socialbase.downloader.ev;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;
import com.ss.android.socialbase.downloader.depend.ia;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.ls;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.downloader.fz;
import com.ss.android.socialbase.downloader.downloader.p;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.f.k;
import com.ss.android.socialbase.downloader.f.t;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.w;
import com.ss.android.socialbase.downloader.network.gd;
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

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv implements f, Runnable {

    /* renamed from: c  reason: collision with root package name */
    private static final String f49553c = xv.class.getSimpleName();

    /* renamed from: a  reason: collision with root package name */
    private boolean f49554a;
    private final AtomicBoolean bk;
    private s ck;
    private String eq;
    private boolean ev;
    private DownloadInfo fp;
    private com.ss.android.socialbase.downloader.downloader.r fz;
    private com.ss.android.socialbase.downloader.network.r gb;
    private boolean gd;

    /* renamed from: i  reason: collision with root package name */
    private fz f49556i;
    private com.ss.android.socialbase.downloader.downloader.ev ia;

    /* renamed from: j  reason: collision with root package name */
    private volatile BaseException f49557j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f49558k;
    private gd ls;

    /* renamed from: n  reason: collision with root package name */
    private j f49559n;

    /* renamed from: p  reason: collision with root package name */
    private boolean f49560p;

    /* renamed from: q  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.f f49561q;

    /* renamed from: r  reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.downloader.ux f49562r;

    /* renamed from: s  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.ev f49563s;

    /* renamed from: u  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.r f49565u;
    private AtomicInteger ux;

    /* renamed from: w  reason: collision with root package name */
    private Future f49566w;
    private long wv;
    private long xk;
    private final DownloadTask xv;
    private final p ys;
    private final com.ss.android.socialbase.downloader.r.c yu;
    private volatile boolean sr = false;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<w> f49555f = new ArrayList<>();

    /* renamed from: t  reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.constants.ev f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_NONE;

    /* renamed from: z  reason: collision with root package name */
    private volatile int f49568z = 5;
    private boolean ba = false;

    /* renamed from: y  reason: collision with root package name */
    private boolean f49567y = false;
    private boolean me = false;
    private int wx = 0;
    private volatile k pr = null;

    public xv(DownloadTask downloadTask, Handler handler) {
        this.xv = downloadTask;
        if (downloadTask != null) {
            this.fp = downloadTask.getDownloadInfo();
            this.ia = downloadTask.getChunkStrategy();
            this.fz = downloadTask.getChunkAdjustCalculator();
            this.f49559n = downloadTask.getForbiddenHandler();
            this.ck = downloadTask.getDiskSpaceHandler();
            this.f49556i = c(downloadTask);
            this.yu = com.ss.android.socialbase.downloader.r.c.c(this.fp.getId());
        } else {
            this.yu = com.ss.android.socialbase.downloader.r.c.xv();
        }
        ev();
        this.ys = com.ss.android.socialbase.downloader.downloader.xv.gb();
        this.f49563s = com.ss.android.socialbase.downloader.downloader.xv.wx();
        this.f49565u = com.ss.android.socialbase.downloader.downloader.xv.bw();
        this.f49561q = new com.ss.android.socialbase.downloader.downloader.f(downloadTask, handler);
        this.bk = new AtomicBoolean(true);
    }

    private void a() {
        boolean z3;
        List xv;
        try {
            this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_NONE;
            this.fp.updateStartDownloadTime();
            this.fp.resetRealStartDownloadTime();
            long currentTimeMillis = System.currentTimeMillis();
            this.fp.setFirstSpeedTime(-1L);
            try {
                p();
                z3 = false;
            } catch (com.ss.android.socialbase.downloader.exception.c e4) {
                String str = f49553c;
                com.ss.android.socialbase.downloader.xv.c.w(str, "file exist " + e4.c());
                this.eq = e4.c();
                z3 = true;
            }
            if (!this.ba) {
                this.f49561q.w();
            }
            this.ba = false;
            if (q()) {
                return;
            }
            if (!TextUtils.isEmpty(this.eq) && z3) {
                if (this.fp.isExpiredRedownload()) {
                    this.me = com.ss.android.socialbase.downloader.gd.f.sr(this.fp);
                }
                if (!this.me) {
                    bk();
                    return;
                }
            }
            while (!q()) {
                try {
                    try {
                        try {
                            me();
                            z();
                            eq();
                            xv = this.ys.xv(this.fp.getId());
                            wv();
                        } catch (com.ss.android.socialbase.downloader.exception.gd e5) {
                            String str2 = f49553c;
                            com.ss.android.socialbase.downloader.xv.c.sr(str2, "downloadInner: retry throwable for " + e5.c());
                            if (this.f49564t != com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_PAUSE) {
                                AtomicInteger atomicInteger = this.ux;
                                if (atomicInteger != null && atomicInteger.get() > 0) {
                                    this.fp.updateCurRetryTime(this.ux.decrementAndGet());
                                    this.fp.setStatus(5);
                                } else if (this.ux != null) {
                                    if (this.fp.trySwitchToNextBackupUrl()) {
                                        this.fp.setStatus(5);
                                        this.ux.set(this.fp.getRetryCount());
                                        this.fp.updateCurRetryTime(this.ux.get());
                                    } else {
                                        w(new BaseException(1018, String.format("retry for Throwable, but retry Time %s all used, last error is %s", String.valueOf(this.fp.getRetryCount()), e5.c())));
                                    }
                                } else {
                                    w(new BaseException(1043, "retry for Throwable, but retain retry time is NULL, last error is" + e5.c()));
                                }
                                fz();
                            }
                        }
                    } catch (BaseException e6) {
                        String str3 = f49553c;
                        com.ss.android.socialbase.downloader.xv.c.sr(str3, "downloadInner: baseException = " + e6);
                        if (this.f49564t != com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_PAUSE) {
                            if (e6.getErrorCode() != 1025 && e6.getErrorCode() != 1009) {
                                if (c(e6)) {
                                    if (com.ss.android.socialbase.downloader.gd.f.c(e6)) {
                                        xk();
                                    }
                                    if (c(e6, 0L) != com.ss.android.socialbase.downloader.exception.ev.RETURN) {
                                        fz();
                                    } else {
                                        fz();
                                        return;
                                    }
                                } else {
                                    w(e6);
                                }
                            }
                            this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_END_RIGHT_NOW;
                            fz();
                            return;
                        }
                    }
                } catch (com.ss.android.socialbase.downloader.exception.c unused) {
                    bk();
                }
                if (t()) {
                    com.ss.android.socialbase.downloader.xv.c.xv(f49553c, "downloadSegments return");
                    fz();
                    return;
                }
                String connectionUrl = this.fp.getConnectionUrl();
                if (q()) {
                    fz();
                    return;
                }
                long ux = this.gd ? com.ss.android.socialbase.downloader.gd.f.ux(this.fp) : 0L;
                com.ss.android.socialbase.downloader.model.w c4 = c(this.fp, ux);
                List<com.ss.android.socialbase.downloader.model.xv> c5 = c(c4);
                com.ss.android.socialbase.downloader.gd.f.c(c5, this.fp);
                com.ss.android.socialbase.downloader.gd.f.w(c5, this.fp);
                this.fp.setPreconnectLevel(0);
                long currentTimeMillis2 = System.currentTimeMillis();
                try {
                    c(connectionUrl, c5, ux);
                    this.fp.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                    if (q()) {
                        fz();
                        return;
                    }
                    long totalBytes = this.fp.getTotalBytes();
                    c(totalBytes);
                    int c6 = c(totalBytes, xv);
                    if (q()) {
                        fz();
                        return;
                    } else if (c6 > 0) {
                        boolean z4 = c6 == 1;
                        this.ev = z4;
                        if (z4) {
                            if (this.ls == null) {
                                try {
                                    currentTimeMillis2 = System.currentTimeMillis();
                                    c(connectionUrl, c5);
                                    this.fp.increaseAllConnectTime(System.currentTimeMillis() - currentTimeMillis2);
                                } finally {
                                }
                            }
                            if (q()) {
                                fz();
                                return;
                            }
                            this.fp.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            ys();
                            c(c4, connectionUrl, this.ls);
                        } else {
                            if (!this.fp.isNeedReuseFirstConnection()) {
                                s();
                            }
                            if (q()) {
                                fz();
                                return;
                            }
                            ys();
                            this.fp.setFirstSpeedTime(System.currentTimeMillis() - currentTimeMillis);
                            if (this.gd) {
                                c(c6, (List<com.ss.android.socialbase.downloader.model.w>) xv);
                            } else {
                                c(totalBytes, c6);
                            }
                        }
                        fz();
                        return;
                    } else {
                        throw new BaseException(1032, "chunkCount is 0");
                    }
                } finally {
                }
            }
        } finally {
            fp();
        }
    }

    private boolean ba() {
        DownloadInfo downloadInfo = this.fp;
        if (downloadInfo == null || downloadInfo.isExpiredRedownload()) {
            return false;
        }
        return (!this.gd || this.fp.getChunkCount() > 1) && !this.fp.isChunkDowngradeRetryUsed() && this.f49560p && !this.f49554a;
    }

    private void bk() {
        com.ss.android.socialbase.downloader.xv.c.w(f49553c, "finishWithFileExist");
        if (com.ss.android.socialbase.downloader.r.c.xv().w("fix_end_for_file_exist_error", true)) {
            if (this.eq.equals(this.fp.getName())) {
                this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_END_RIGHT_NOW;
            } else {
                this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_END_FOR_FILE_EXIST;
            }
        } else if (this.eq.equals(this.fp.getTargetFilePath())) {
            this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_END_RIGHT_NOW;
        } else {
            this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_END_FOR_FILE_EXIST;
        }
    }

    private long ck() {
        return this.f49556i.c(this.fp.getCurRetryTimeInTotal(), this.fp.getTotalRetryCount());
    }

    private void eq() throws com.ss.android.socialbase.downloader.exception.f {
        if (this.fp.isOnlyWifi() && !com.ss.android.socialbase.downloader.gd.f.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), "android.permission.ACCESS_NETWORK_STATE")) {
            throw new com.ss.android.socialbase.downloader.exception.f(1019, String.format("download task need permission:%s", "android.permission.ACCESS_NETWORK_STATE"));
        }
        if (this.fp.isDownloadWithWifiValid()) {
            if (!this.fp.isPauseReserveWithWifiValid()) {
                throw new com.ss.android.socialbase.downloader.exception.ux();
            }
            return;
        }
        throw new com.ss.android.socialbase.downloader.exception.xv();
    }

    private void ev() {
        DownloadInfo downloadInfo = this.fp;
        if (downloadInfo == null) {
            return;
        }
        int retryCount = downloadInfo.getRetryCount() - this.fp.getCurRetryTime();
        if (retryCount < 0) {
            retryCount = 0;
        }
        AtomicInteger atomicInteger = this.ux;
        if (atomicInteger == null) {
            this.ux = new AtomicInteger(retryCount);
        } else {
            atomicInteger.set(retryCount);
        }
    }

    private void fp() {
        boolean z3;
        boolean z4;
        String str = f49553c;
        com.ss.android.socialbase.downloader.xv.c.w(str, "endDownloadRunnable::runStatus=" + this.f49564t);
        boolean z5 = (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_PAUSE || this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_CANCELED) ? false : true;
        try {
            z3 = j();
            z4 = false;
        } catch (Exception e4) {
            if (e4 instanceof BaseException) {
                this.f49561q.c((BaseException) e4);
            } else {
                this.f49561q.c(new BaseException(1046, e4));
            }
            z3 = true;
            z4 = true;
        }
        if (!z3 && !z4) {
            this.ba = true;
            com.ss.android.socialbase.downloader.xv.c.w(f49553c, "jump to restart");
            return;
        }
        this.bk.set(false);
        if (z5) {
            try {
                com.ss.android.socialbase.downloader.impls.c y3 = com.ss.android.socialbase.downloader.downloader.xv.y();
                if (y3 != null) {
                    y3.c(this);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                ls monitorDepend = this.xv.getMonitorDepend();
                DownloadInfo downloadInfo = this.fp;
                BaseException baseException = new BaseException(1014, com.ss.android.socialbase.downloader.gd.f.w(th, "removeDownloadRunnable"));
                DownloadInfo downloadInfo2 = this.fp;
                com.ss.android.socialbase.downloader.sr.c.c(monitorDepend, downloadInfo, baseException, downloadInfo2 != null ? downloadInfo2.getStatus() : 0);
            }
        }
    }

    private void fz() {
        ia();
        s();
    }

    private boolean gb() {
        if (this.fp.isChunked()) {
            DownloadInfo downloadInfo = this.fp;
            downloadInfo.setTotalBytes(downloadInfo.getCurBytes());
        }
        String str = f49553c;
        com.ss.android.socialbase.downloader.xv.c.xv(str, "checkCompletedByteValid: downloadInfo.getCurBytes() = " + this.fp.getCurBytes() + ",  downloadInfo.getTotalBytes() = " + this.fp.getTotalBytes());
        if (this.fp.getCurBytes() > 0) {
            if (this.fp.isIgnoreDataVerify()) {
                return true;
            }
            if (this.fp.getTotalBytes() > 0 && this.fp.getCurBytes() == this.fp.getTotalBytes()) {
                return true;
            }
        }
        this.fp.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.w.BYTE_INVALID_RETRY_STATUS_RESTART);
        this.fp.reset();
        this.ys.c(this.fp);
        this.ys.sr(this.fp.getId());
        this.ys.bk(this.fp.getId());
        com.ss.android.socialbase.downloader.gd.f.c(this.fp);
        return false;
    }

    private boolean gd() {
        int status = this.fp.getStatus();
        if (status == 1 || this.fp.canSkipStatusHandler()) {
            return true;
        }
        if (status == -2 || status == -4) {
            return false;
        }
        w(new BaseException(1000, "The download Task can't start, because its status is not prepare:" + status));
        return false;
    }

    private boolean i() {
        return this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_CANCELED || this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_PAUSE;
    }

    private void ia() {
        com.ss.android.socialbase.downloader.network.r rVar = this.gb;
        if (rVar != null) {
            rVar.xv();
            this.gb = null;
        }
    }

    private boolean j() {
        if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_ERROR) {
            this.f49561q.c(this.f49557j);
        } else if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_CANCELED) {
            this.f49561q.xv();
        } else if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_PAUSE) {
            this.f49561q.sr();
        } else if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_END_RIGHT_NOW) {
            try {
                this.f49561q.r();
            } catch (BaseException e4) {
                this.f49561q.c(e4);
            }
        } else if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_END_FOR_FILE_EXIST) {
            try {
                this.f49561q.c(this.eq);
            } catch (BaseException e5) {
                this.f49561q.c(e5);
            }
        } else if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET) {
            this.f49561q.c(this.f49557j, false);
            return false;
        } else if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_WAITING_ASYNC_HANDLER) {
            return true;
        } else {
            com.ss.android.socialbase.downloader.constants.ev evVar = this.f49564t;
            com.ss.android.socialbase.downloader.constants.ev evVar2 = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_RETRY_DELAY;
            if (evVar == evVar2 && !ls()) {
                com.ss.android.socialbase.downloader.xv.c.w(f49553c, "doTaskStatusHandle retryDelay");
                n();
                return this.f49564t == evVar2;
            }
            try {
                if (!gb()) {
                    return false;
                }
                this.f49561q.f();
                com.ss.android.socialbase.downloader.impls.s.c().sr();
            } catch (Throwable th) {
                w(new BaseException(1008, com.ss.android.socialbase.downloader.gd.f.w(th, "doTaskStatusHandle onComplete")));
            }
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0058 A[LOOP:0: B:24:0x0058->B:57:0x0058, LOOP_START] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void k() {
        /*
            Method dump skipped, instructions count: 289
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ev.xv.k():void");
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean ls() {
        /*
            r7 = this;
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.fp
            int r0 = r0.getChunkCount()
            r1 = 0
            r2 = 1
            if (r0 > r2) goto L28
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.fp
            long r3 = r0.getCurBytes()
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L27
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.fp
            long r3 = r0.getCurBytes()
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r7.fp
            long r5 = r0.getTotalBytes()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 != 0) goto L27
            return r2
        L27:
            return r1
        L28:
            com.ss.android.socialbase.downloader.downloader.p r0 = r7.ys
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r7.fp
            int r3 = r3.getId()
            java.util.List r0 = r0.xv(r3)
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
            com.ss.android.socialbase.downloader.model.w r3 = (com.ss.android.socialbase.downloader.model.w) r3
            if (r3 == 0) goto L55
            boolean r3 = r3.gd()
            if (r3 != 0) goto L41
        L55:
            return r1
        L56:
            return r2
        L57:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ev.xv.ls():boolean");
    }

    private void me() throws BaseException {
        if (!TextUtils.isEmpty(this.fp.getSavePath())) {
            if (!TextUtils.isEmpty(this.fp.getName())) {
                File file = new File(this.fp.getSavePath());
                if (!file.exists()) {
                    boolean mkdirs = file.mkdirs();
                    if (mkdirs || file.exists()) {
                        return;
                    }
                    int i4 = 0;
                    if (com.ss.android.socialbase.downloader.r.c.c(this.fp.getId()).c("opt_mkdir_failed", 0) == 1) {
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
                        if (com.ss.android.socialbase.downloader.gd.f.sr(this.fp.getSavePath()) < 16384) {
                            throw new BaseException(1006, "download savePath directory can not created:" + this.fp.getSavePath());
                        }
                        throw new BaseException(1030, "download savePath directory can not created:" + this.fp.getSavePath());
                    }
                    throw new BaseException(1030, "download savePath directory can not created:" + this.fp.getSavePath());
                } else if (file.isDirectory()) {
                    return;
                } else {
                    if (com.ss.android.socialbase.downloader.gd.sr.w(this.fp)) {
                        file.delete();
                        if (file.mkdirs() || file.exists()) {
                            return;
                        }
                        throw new BaseException(1031, "download savePath is not directory:path=" + this.fp.getSavePath());
                    }
                    throw new BaseException(1031, "download savePath is not a directory:" + this.fp.getSavePath());
                }
            }
            throw new BaseException(1029, "download name can not be empty");
        }
        throw new BaseException(1028, "download savePath can not be empty");
    }

    private void n() {
        this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_NONE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:78:0x00f3, code lost:
        if (r9.yu.c("fix_file_exist_update_download_info") != false) goto L80;
     */
    /* JADX WARN: Removed duplicated region for block: B:100:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00ab A[Catch: all -> 0x00e8, TryCatch #6 {all -> 0x00e8, blocks: (B:56:0x00a7, B:58:0x00ab, B:60:0x00af, B:73:0x00e7), top: B:84:0x0004 }] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void p() throws com.ss.android.socialbase.downloader.exception.c {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ev.xv.p():void");
    }

    private boolean pr() {
        return false;
    }

    private boolean q() {
        if (i() || this.fp.getStatus() == -2) {
            if (i()) {
                return true;
            }
            if (this.fp.getStatus() == -2) {
                this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_PAUSE;
                return true;
            } else if (this.fp.getStatus() == -4) {
                this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_CANCELED;
                return true;
            } else {
                return true;
            }
        }
        return false;
    }

    private void s() {
        gd gdVar = this.ls;
        if (gdVar != null) {
            gdVar.sr();
            this.ls = null;
        }
    }

    private boolean t() throws BaseException, InterruptedException {
        if (!this.fp.isExpiredRedownload() && this.fp.getChunkCount() == 1 && this.fp.getThrottleNetSpeed() <= 0) {
            JSONObject sr = com.ss.android.socialbase.downloader.r.c.c(this.fp.getId()).sr("segment_config");
            List<com.ss.android.socialbase.downloader.f.gd> t3 = this.ys.t(this.fp.getId());
            if (this.fp.getCurBytes() > 0) {
                if (t3 == null || t3.isEmpty()) {
                    return false;
                }
                if (sr == null) {
                    sr = new JSONObject();
                }
            }
            if (sr == null) {
                return false;
            }
            this.pr = new k(this.fp, t.c(sr), this);
            if (q()) {
                com.ss.android.socialbase.downloader.xv.c.xv(f49553c, "downloadSegments: is stopped by user");
                if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_CANCELED) {
                    this.pr.c();
                } else {
                    this.pr.w();
                }
                return true;
            }
            return this.pr.c(t3);
        }
        return false;
    }

    private void u() throws BaseException {
        if (this.f49562r != null) {
            if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_CANCELED) {
                this.fp.setStatus(-4);
                this.f49562r.xv();
            } else if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_PAUSE) {
                this.fp.setStatus(-2);
                this.f49562r.w();
            } else {
                this.f49562r.sr();
            }
        }
    }

    private void wv() {
        long f4 = com.ss.android.socialbase.downloader.gd.f.f(this.fp);
        long curBytes = this.fp.getCurBytes();
        if (f4 != curBytes) {
            String str = f49553c;
            com.ss.android.socialbase.downloader.xv.c.sr(str, "checkTaskCanResume: offset = " + f4 + ", curBytes = " + curBytes);
        }
        this.fp.setCurBytes(f4);
        boolean z3 = f4 > 0;
        this.gd = z3;
        if (z3 || this.me) {
            return;
        }
        com.ss.android.socialbase.downloader.xv.c.xv(f49553c, "checkTaskCanResume: deleteAllDownloadFiles");
        this.ys.sr(this.fp.getId());
        this.ys.bk(this.fp.getId());
        com.ss.android.socialbase.downloader.gd.f.c(this.fp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wx() {
        com.ss.android.socialbase.downloader.impls.c y3;
        if (q() || (y3 = com.ss.android.socialbase.downloader.downloader.xv.y()) == null) {
            return;
        }
        y3.a(this.fp.getId());
    }

    private void xk() {
        String str = f49553c;
        com.ss.android.socialbase.downloader.xv.c.sr(str, "clearCurrentDownloadData::" + Log.getStackTraceString(new Throwable()));
        try {
            this.ys.sr(this.fp.getId());
            this.ys.bk(this.fp.getId());
            com.ss.android.socialbase.downloader.gd.f.c(this.fp);
            this.gd = false;
            this.fp.resetDataForEtagEndure("");
            this.ys.c(this.fp);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void y() throws BaseException {
        long j4;
        int c4;
        try {
            j4 = com.ss.android.socialbase.downloader.gd.f.sr(this.fp.getTempPath());
        } catch (BaseException unused) {
            j4 = 0;
        }
        String str = f49553c;
        com.ss.android.socialbase.downloader.xv.c.xv(str, "checkSpaceOverflowInProgress: available = " + com.ss.android.socialbase.downloader.gd.f.c(j4) + "MB");
        if (j4 > 0) {
            long totalBytes = this.fp.getTotalBytes() - this.fp.getCurBytes();
            if (j4 < totalBytes && (c4 = com.ss.android.socialbase.downloader.r.c.c(this.fp.getId()).c("space_fill_min_keep_mb", 100)) > 0) {
                long j5 = j4 - (c4 * 1048576);
                com.ss.android.socialbase.downloader.xv.c.xv(str, "checkSpaceOverflowInProgress: minKeep  = " + c4 + "MB, canDownload = " + com.ss.android.socialbase.downloader.gd.f.c(j5) + "MB");
                if (j5 > 0) {
                    this.wv = this.fp.getCurBytes() + j5 + 1048576;
                    return;
                } else {
                    this.wv = 0L;
                    throw new com.ss.android.socialbase.downloader.exception.sr(j4, totalBytes);
                }
            }
        }
        this.wv = 0L;
    }

    private void ys() {
        if (com.ss.android.socialbase.downloader.r.c.c(this.fp.getId()).c("reset_retain_retry_times", 0) != 1 || this.wx >= 3) {
            return;
        }
        this.ux.set(this.fp.isBackUpUrlUsed() ? this.fp.getBackUpUrlRetryCount() : this.fp.getRetryCount());
        this.wx++;
    }

    private void yu() {
        try {
            Iterator it = ((ArrayList) this.f49555f.clone()).iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                if (wVar != null) {
                    wVar.w();
                }
            }
        } catch (Throwable th) {
            String str = f49553c;
            com.ss.android.socialbase.downloader.xv.c.xv(str, "cancelAllChunkRunnable: " + th.toString());
        }
    }

    private void z() throws com.ss.android.socialbase.downloader.exception.gd, BaseException {
        com.ss.android.socialbase.downloader.impls.c y3;
        int id = this.fp.getId();
        int c4 = com.ss.android.socialbase.downloader.downloader.xv.c(this.fp);
        if (this.fp.isDownloaded() && !this.fp.isExpiredRedownload() && !this.me) {
            throw new BaseException(1009, "file has downloaded");
        }
        DownloadInfo w3 = this.ys.w(c4);
        if (w3 == null || (y3 = com.ss.android.socialbase.downloader.downloader.xv.y()) == null || w3.getId() == id || !w3.equalsTask(this.fp)) {
            return;
        }
        if (!y3.c(w3.getId())) {
            List<com.ss.android.socialbase.downloader.model.w> xv = this.ys.xv(c4);
            com.ss.android.socialbase.downloader.gd.f.c(this.fp);
            this.ys.f(c4);
            if (w3.isBreakpointAvailable()) {
                this.fp.copyFromCacheData(w3, false);
                this.ys.c(this.fp);
                if (xv != null) {
                    for (com.ss.android.socialbase.downloader.model.w wVar : xv) {
                        wVar.w(id);
                        this.ys.c(wVar);
                    }
                }
                throw new com.ss.android.socialbase.downloader.exception.gd("retry task because id generator changed");
            }
            return;
        }
        this.ys.f(id);
        throw new BaseException(1025, "another same task is downloading");
    }

    public void f() {
        this.xk = System.currentTimeMillis();
        this.f49561q.c();
    }

    public Future r() {
        return this.f49566w;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.ss.android.socialbase.downloader.downloader.xv.c(this.xv, 3);
        try {
            com.ss.android.socialbase.downloader.network.w.c().w();
            k();
            com.ss.android.socialbase.downloader.network.w.c().xv();
            com.ss.android.socialbase.downloader.downloader.xv.w(this.xv, 3);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.network.w.c().xv();
            throw th;
        }
    }

    public boolean sr() {
        return this.bk.get();
    }

    public int ux() {
        DownloadInfo downloadInfo = this.fp;
        if (downloadInfo != null) {
            return downloadInfo.getId();
        }
        return 0;
    }

    public void w() {
        com.ss.android.socialbase.downloader.constants.ev evVar = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_CANCELED;
        this.f49564t = evVar;
        if (this.pr != null) {
            this.pr.c();
        }
        if (this.f49562r != null) {
            this.f49562r.xv();
        }
        if (this.pr == null && this.f49562r == null) {
            fz();
            this.f49564t = evVar;
            fp();
        }
        yu();
    }

    public DownloadTask xv() {
        return this.xv;
    }

    private boolean sr(BaseException baseException) {
        AtomicInteger atomicInteger = this.ux;
        boolean z3 = true;
        if (atomicInteger != null) {
            if (atomicInteger.get() <= 0 || (baseException != null && baseException.getErrorCode() == 1070)) {
                if (this.fp.trySwitchToNextBackupUrl()) {
                    this.ux.set(this.fp.getBackUpUrlRetryCount());
                    this.fp.updateCurRetryTime(this.ux.get());
                } else if (baseException != null && ((baseException.getErrorCode() == 1011 || (baseException.getCause() != null && (baseException.getCause() instanceof SSLHandshakeException))) && this.fp.canReplaceHttpForRetry())) {
                    this.ux.set(this.fp.getRetryCount());
                    this.fp.updateCurRetryTime(this.ux.get());
                    this.fp.setHttpsToHttpRetryUsed(true);
                } else {
                    w(new BaseException(baseException.getErrorCode(), String.format("retry for exception, but current retry time : %s , retry Time %s all used, last error is %s", String.valueOf(this.ux), String.valueOf(this.fp.getRetryCount()), baseException.getErrorMessage())));
                    return true;
                }
                z3 = false;
            }
            if (this.f49564t != com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_RETRY_DELAY && z3) {
                this.fp.updateCurRetryTime(this.ux.decrementAndGet());
            }
            return false;
        }
        w(new BaseException(1043, "retry for exception, but retain retry time is null, last error is :" + baseException.getErrorMessage()));
        return true;
    }

    @Override // com.ss.android.socialbase.downloader.ev.f
    public void xv(BaseException baseException) {
        DownloadInfo downloadInfo = this.fp;
        if (downloadInfo != null) {
            downloadInfo.setChunkDowngradeRetryUsed(true);
        }
        c(baseException, false);
    }

    public void c() {
        com.ss.android.socialbase.downloader.constants.ev evVar = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_PAUSE;
        this.f49564t = evVar;
        if (this.pr != null) {
            this.pr.w();
        }
        if (this.f49562r != null) {
            this.f49562r.w();
        }
        if (this.pr == null && this.f49562r == null) {
            fz();
            this.f49564t = evVar;
            fp();
        }
        try {
            Iterator it = ((ArrayList) this.f49555f.clone()).iterator();
            while (it.hasNext()) {
                w wVar = (w) it.next();
                if (wVar != null) {
                    wVar.c();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void xv(long j4) {
        gd gdVar = this.ls;
        if (gdVar != null && (gdVar instanceof com.ss.android.socialbase.downloader.network.c)) {
            try {
                ((com.ss.android.socialbase.downloader.network.c) gdVar).c(j4);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private void w(String str, List<com.ss.android.socialbase.downloader.model.xv> list, long j4) throws BaseException, com.ss.android.socialbase.downloader.exception.gd {
        com.ss.android.socialbase.downloader.network.c.xv c4;
        boolean z3 = true;
        if (this.fp.getChunkCount() == 1 && (c4 = com.ss.android.socialbase.downloader.network.c.c.c().c(str, list)) != null) {
            this.gb = c4;
            this.fp.setPreconnectLevel(1);
        }
        if (this.gb == null && !this.f49567y && this.fp.isHeadConnectionAvailable()) {
            try {
                int w3 = this.yu.w("net_lib_strategy");
                if (this.yu.c("monitor_download_connect", 0) <= 0) {
                    z3 = false;
                }
                this.gb = com.ss.android.socialbase.downloader.downloader.xv.c(str, list, w3, z3, this.fp);
            } catch (Throwable th) {
                this.fp.setHeadConnectionException(com.ss.android.socialbase.downloader.gd.f.p(th));
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x005c, code lost:
        if (r9 <= 0) goto L22;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [java.lang.Enum, com.ss.android.socialbase.downloader.network.a] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int c(long r7, java.util.List<com.ss.android.socialbase.downloader.model.w> r9) {
        /*
            r6 = this;
            boolean r0 = r6.ba()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L5e
            boolean r0 = r6.gd
            if (r0 == 0) goto L1a
            if (r9 == 0) goto L13
            int r9 = r9.size()
            goto L5c
        L13:
            com.ss.android.socialbase.downloader.model.DownloadInfo r9 = r6.fp
            int r9 = r9.getChunkCount()
            goto L5c
        L1a:
            com.ss.android.socialbase.downloader.downloader.ev r9 = r6.ia
            if (r9 == 0) goto L23
            int r9 = r9.c(r7)
            goto L29
        L23:
            com.ss.android.socialbase.downloader.downloader.ev r9 = r6.f49563s
            int r9 = r9.c(r7)
        L29:
            com.ss.android.socialbase.downloader.network.k r0 = com.ss.android.socialbase.downloader.network.k.c()
            com.ss.android.socialbase.downloader.network.a r0 = r0.w()
            java.lang.String r3 = com.ss.android.socialbase.downloader.ev.xv.f49553c
            java.lang.Object[] r4 = new java.lang.Object[r2]
            java.lang.String r5 = r0.name()
            r4[r1] = r5
            java.lang.String r5 = "NetworkQuality is : %s"
            java.lang.String r4 = java.lang.String.format(r5, r4)
            com.ss.android.socialbase.downloader.xv.c.w(r3, r4)
            com.ss.android.socialbase.downloader.model.DownloadInfo r3 = r6.fp
            java.lang.String r4 = r0.name()
            r3.setNetworkQuality(r4)
            com.ss.android.socialbase.downloader.downloader.r r3 = r6.fz
            if (r3 == 0) goto L56
            int r9 = r3.c(r9, r0)
            goto L5c
        L56:
            com.ss.android.socialbase.downloader.downloader.r r3 = r6.f49565u
            int r9 = r3.c(r9, r0)
        L5c:
            if (r9 > 0) goto L5f
        L5e:
            r9 = 1
        L5f:
            boolean r0 = com.ss.android.socialbase.downloader.xv.c.c()
            if (r0 == 0) goto L88
            java.lang.String r0 = com.ss.android.socialbase.downloader.ev.xv.f49553c
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r4 = java.lang.String.valueOf(r9)
            r3[r1] = r4
            com.ss.android.socialbase.downloader.model.DownloadInfo r1 = r6.fp
            java.lang.String r1 = r1.getName()
            r3[r2] = r1
            r1 = 2
            java.lang.String r7 = java.lang.String.valueOf(r7)
            r3[r1] = r7
            java.lang.String r7 = "chunk count : %s for %s contentLen:%s"
            java.lang.String r7 = java.lang.String.format(r7, r3)
            com.ss.android.socialbase.downloader.xv.c.w(r0, r7)
        L88:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ev.xv.c(long, java.util.List):int");
    }

    @Override // com.ss.android.socialbase.downloader.ev.f
    public boolean w(long j4) throws BaseException {
        if (this.wv > 0 && this.fp.getCurBytes() > this.wv) {
            y();
        }
        return this.f49561q.c(j4);
    }

    @Override // com.ss.android.socialbase.downloader.ev.f
    public void w(BaseException baseException) {
        String str = f49553c;
        com.ss.android.socialbase.downloader.xv.c.w(str, "onError:" + baseException.getMessage());
        this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_ERROR;
        this.f49557j = baseException;
        yu();
    }

    private void c(String str, List<com.ss.android.socialbase.downloader.model.xv> list, long j4) throws BaseException, com.ss.android.socialbase.downloader.exception.gd {
        w(str, list, j4);
        com.ss.android.socialbase.downloader.network.r rVar = this.gb;
        if (rVar != null) {
            try {
                c(str, rVar, j4);
            } catch (Throwable unused) {
                this.f49567y = true;
            }
        }
        if (this.gb == null || this.f49567y) {
            c(str, list);
            c(str, this.ls, j4);
        }
    }

    private void c(String str, List<com.ss.android.socialbase.downloader.model.xv> list) throws BaseException, com.ss.android.socialbase.downloader.exception.gd {
        gd gdVar;
        if (this.ls != null) {
            return;
        }
        com.ss.android.socialbase.downloader.network.c.sr w3 = this.fp.getChunkCount() == 1 ? com.ss.android.socialbase.downloader.network.c.c.c().w(str, list) : null;
        try {
            if (w3 != null) {
                c(this.ls);
                this.fp.setPreconnectLevel(2);
                this.ls = w3;
            } else {
                try {
                    gdVar = com.ss.android.socialbase.downloader.downloader.xv.c(this.fp.isNeedDefaultHttpServiceBackUp(), this.fp.getMaxBytes(), str, null, list, this.yu.w("net_lib_strategy"), this.yu.c("monitor_download_connect", 0) > 0, this.fp);
                    this.ls = gdVar;
                } catch (BaseException e4) {
                    throw e4;
                } catch (Throwable th) {
                    if (this.fp.isExpiredRedownload() && com.ss.android.socialbase.downloader.gd.f.r(th) && com.ss.android.socialbase.downloader.gd.f.xv(list)) {
                        com.ss.android.socialbase.downloader.xv.c.w(f49553c, "dcache=execepiton responseCode=304 lastModified not changed, use local file.. old cacheControl=" + this.fp.getCacheControl());
                        long gd = com.ss.android.socialbase.downloader.gd.f.gd(this.fp.getCacheControl());
                        if (gd <= 0) {
                            gd = com.ss.android.socialbase.downloader.r.c.c(this.fp.getId()).c("default_304_max_age", 300);
                        }
                        this.fp.setCacheExpiredTime(System.currentTimeMillis() + (gd * 1000));
                        throw new com.ss.android.socialbase.downloader.exception.c(this.eq);
                    }
                    if (com.ss.android.socialbase.downloader.gd.f.f(th)) {
                        c("", "http code 416");
                    } else if (com.ss.android.socialbase.downloader.gd.f.ux(th)) {
                        c("", "http code 412");
                    } else {
                        com.ss.android.socialbase.downloader.gd.f.c(th, "CreateFirstConnection");
                    }
                    gdVar = this.ls;
                }
                c(gdVar);
            }
            if (this.ls == null) {
                throw new BaseException(1022, new IOException("download can't continue, firstConnection is null"));
            }
        } catch (Throwable th2) {
            c(this.ls);
            throw th2;
        }
    }

    public static com.ss.android.socialbase.downloader.model.w c(DownloadInfo downloadInfo, long j4) {
        return new w.c(downloadInfo.getId()).c(-1).c(0L).ux(j4).w(j4).xv(0L).sr(downloadInfo.getTotalBytes() - j4).c();
    }

    private List<com.ss.android.socialbase.downloader.model.xv> c(com.ss.android.socialbase.downloader.model.w wVar) {
        List<com.ss.android.socialbase.downloader.model.xv> c4 = com.ss.android.socialbase.downloader.gd.f.c((List<com.ss.android.socialbase.downloader.model.xv>) this.fp.getExtraHeaders(), this.fp.geteTag(), wVar);
        if (this.fp.isExpiredRedownload() && this.me && this.fp.getLastModified() != null) {
            c4.add(new com.ss.android.socialbase.downloader.model.xv("if-modified-since", this.fp.getLastModified()));
            c4.add(new com.ss.android.socialbase.downloader.model.xv("download-tc21-1-15", "download-tc21-1-15"));
            String str = f49553c;
            com.ss.android.socialbase.downloader.xv.c.w(str, "dcache::add head IF_MODIFIED_SINCE=" + this.fp.getLastModified());
        }
        return c4;
    }

    private void c(int i4, List<com.ss.android.socialbase.downloader.model.w> list) throws BaseException {
        if (list.size() == i4) {
            c(list, this.fp.getTotalBytes());
            return;
        }
        throw new BaseException(1033, new IllegalArgumentException());
    }

    private void c(long j4, int i4) throws BaseException {
        long j5 = j4 / i4;
        int id = this.fp.getId();
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        long j6 = 0;
        while (i5 < i4) {
            com.ss.android.socialbase.downloader.model.w c4 = new w.c(id).c(i5).c(j6).ux(j6).w(j6).xv(i5 == i4 + (-1) ? 0L : (j6 + j5) - 1).c();
            arrayList.add(c4);
            this.ys.c(c4);
            j6 += j5;
            i5++;
        }
        this.fp.setChunkCount(i4);
        this.ys.c(id, i4);
        c(arrayList, j4);
    }

    private void c(List<com.ss.android.socialbase.downloader.model.w> list, long j4) throws BaseException {
        long fp;
        for (com.ss.android.socialbase.downloader.model.w wVar : list) {
            if (wVar != null) {
                if (wVar.fp() == 0) {
                    fp = j4 - wVar.t();
                } else {
                    fp = (wVar.fp() - wVar.t()) + 1;
                }
                if (fp > 0) {
                    wVar.c(fp);
                    if (this.fp.isNeedReuseFirstConnection() && this.ls != null && (!this.fp.isHeadConnectionAvailable() || this.f49567y)) {
                        if (wVar.fz() == 0) {
                            this.f49555f.add(new w(wVar, this.xv, this.ls, this));
                        } else if (wVar.fz() > 0) {
                            this.f49555f.add(new w(wVar, this.xv, this));
                        }
                    } else {
                        this.f49555f.add(new w(wVar, this.xv, this));
                    }
                }
            }
        }
        if (com.ss.android.socialbase.downloader.gd.c.c(64)) {
            ArrayList arrayList = new ArrayList(this.f49555f.size());
            Iterator<w> it = this.f49555f.iterator();
            while (it.hasNext()) {
                w next = it.next();
                if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_CANCELED) {
                    next.w();
                } else if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_PAUSE) {
                    next.c();
                } else {
                    arrayList.add(next);
                }
            }
            try {
                List<Future> sr = com.ss.android.socialbase.downloader.impls.ux.sr(arrayList);
                for (Runnable runnable = (Runnable) arrayList.remove(0); runnable != null; runnable = com.ss.android.socialbase.downloader.impls.ux.ux(sr)) {
                    if (q()) {
                        return;
                    }
                    runnable.run();
                }
                if (sr == null || sr.isEmpty()) {
                    return;
                }
                for (Future future : sr) {
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
        ArrayList arrayList2 = new ArrayList(this.f49555f.size());
        Iterator<w> it2 = this.f49555f.iterator();
        while (it2.hasNext()) {
            w next2 = it2.next();
            if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_CANCELED) {
                next2.w();
            } else if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_PAUSE) {
                next2.c();
            } else {
                arrayList2.add(Executors.callable(next2));
            }
        }
        if (q()) {
            return;
        }
        try {
            com.ss.android.socialbase.downloader.impls.ux.xv(arrayList2);
        } catch (InterruptedException e4) {
            throw new BaseException(1020, e4);
        }
    }

    private void c(com.ss.android.socialbase.downloader.model.w wVar, String str, gd gdVar) throws BaseException {
        wVar.c(this.fp.getTotalBytes() - wVar.t());
        this.fp.setChunkCount(1);
        this.ys.c(this.fp.getId(), 1);
        this.f49562r = new com.ss.android.socialbase.downloader.downloader.ux(this.fp, str, gdVar, wVar, this);
        u();
    }

    @Override // com.ss.android.socialbase.downloader.ev.f
    public void c(long j4) throws BaseException {
        long j5;
        String tempPath = this.fp.getTempPath();
        String tempName = this.fp.getTempName();
        if (com.ss.android.socialbase.downloader.gd.f.w(j4)) {
            return;
        }
        com.ss.android.socialbase.downloader.model.ux c4 = com.ss.android.socialbase.downloader.gd.f.c(this.fp, tempPath, tempName, -1);
        try {
            long length = new File(tempPath, tempName).length();
            long j6 = j4 - length;
            long sr = com.ss.android.socialbase.downloader.gd.f.sr(tempPath);
            com.ss.android.socialbase.downloader.r.c c5 = com.ss.android.socialbase.downloader.r.c.c(this.fp.getId());
            if (c5.c("space_fill_part_download", 0) == 1) {
                this.wv = 0L;
                if (j6 <= 0) {
                    j6 = this.fp.getTotalBytes() - this.fp.getCurBytes();
                }
                if (sr < j6) {
                    String str = f49553c;
                    com.ss.android.socialbase.downloader.xv.c.sr(str, "checkSpaceOverflow: contentLength = " + com.ss.android.socialbase.downloader.gd.f.c(j4) + "MB, downloaded = " + com.ss.android.socialbase.downloader.gd.f.c(length) + "MB, required = " + com.ss.android.socialbase.downloader.gd.f.c(j6) + "MB, available = " + com.ss.android.socialbase.downloader.gd.f.c(sr) + "MB");
                    if (sr > 0) {
                        int c6 = c5.c("space_fill_min_keep_mb", 100);
                        if (c6 > 0) {
                            long j7 = sr - (c6 * 1048576);
                            com.ss.android.socialbase.downloader.xv.c.sr(str, "checkSpaceOverflow: minKeep = " + c6 + "MB, canDownload = " + com.ss.android.socialbase.downloader.gd.f.c(j7) + "MB");
                            if (j7 > 0) {
                                this.wv = this.fp.getCurBytes() + j7;
                                j5 = j7;
                            } else {
                                throw new com.ss.android.socialbase.downloader.exception.sr(sr, j6);
                            }
                        } else {
                            j5 = sr;
                        }
                        if (length < j4) {
                            if (j5 + length > j4) {
                            }
                            c4.w(j4);
                            com.ss.android.socialbase.downloader.gd.f.c(c4);
                        }
                    } else if (c5.c("download_when_space_negative", 0) != 1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("availableSpace ");
                        sb.append(sr == 0 ? "=" : "<");
                        sb.append(" 0");
                        throw new BaseException(1052, sb.toString());
                    } else {
                        c4.w(j4);
                        com.ss.android.socialbase.downloader.gd.f.c(c4);
                    }
                }
            } else if (sr <= 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("availableSpace ");
                sb2.append(sr == 0 ? "=" : "<");
                sb2.append(" 0");
                throw new BaseException(1052, sb2.toString());
            } else if (sr < j6) {
                throw new com.ss.android.socialbase.downloader.exception.sr(sr, j6);
            }
            c4.w(j4);
            com.ss.android.socialbase.downloader.gd.f.c(c4);
        } catch (Throwable th) {
            com.ss.android.socialbase.downloader.gd.f.c(c4);
            throw th;
        }
    }

    private boolean c(int i4, String str, String str2) {
        if (i4 == 412) {
            return true;
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || str.equals(str2) || !(this.f49558k || this.f49560p)) {
            return (i4 == 201 || i4 == 416) && this.fp.getCurBytes() > 0;
        }
        return true;
    }

    private void c(String str, String str2) throws com.ss.android.socialbase.downloader.exception.gd {
        this.ys.sr(this.fp.getId());
        this.ys.bk(this.fp.getId());
        com.ss.android.socialbase.downloader.gd.f.c(this.fp);
        this.gd = false;
        this.fp.resetDataForEtagEndure(str);
        this.ys.c(this.fp);
        throw new com.ss.android.socialbase.downloader.exception.gd(str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x0253, code lost:
        r8 = com.ss.android.socialbase.downloader.gd.f.w(r10, "Content-Range");
        com.ss.android.socialbase.downloader.xv.c.xv(r14, "firstConnection: contentRange = " + r8);
     */
    /* JADX WARN: Code restructure failed: missing block: B:103:0x0271, code lost:
        if (android.text.TextUtils.isEmpty(r8) != false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:105:0x027c, code lost:
        if (r19.yu.w("fix_get_total_bytes", true) == false) goto L129;
     */
    /* JADX WARN: Code restructure failed: missing block: B:106:0x027e, code lost:
        r3 = com.ss.android.socialbase.downloader.gd.f.w(r8);
        com.ss.android.socialbase.downloader.xv.c.xv(r14, "firstConnection: 1 totalLength = " + r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0297, code lost:
        r11 = r22 + r3;
        com.ss.android.socialbase.downloader.xv.c.ux(r14, "firstConnection: 2 totalLength = " + r11 + ", contentLength = " + r3);
        r3 = r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x013a, code lost:
        com.ss.android.socialbase.downloader.gd.f.c(r19.fp);
     */
    @Override // com.ss.android.socialbase.downloader.ev.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(java.lang.String r20, com.ss.android.socialbase.downloader.network.r r21, long r22) throws com.ss.android.socialbase.downloader.exception.BaseException, com.ss.android.socialbase.downloader.exception.gd {
        /*
            Method dump skipped, instructions count: 855
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ev.xv.c(java.lang.String, com.ss.android.socialbase.downloader.network.r, long):void");
    }

    @Override // com.ss.android.socialbase.downloader.ev.f
    public void c(w wVar) {
        if (this.ev) {
            return;
        }
        synchronized (this) {
            this.f49555f.remove(wVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.ev.f
    public boolean c(BaseException baseException) {
        if (this.pr == null || !com.ss.android.socialbase.downloader.gd.f.gd(baseException) || this.ux.get() >= this.fp.getRetryCount()) {
            if (com.ss.android.socialbase.downloader.gd.f.w(baseException)) {
                if (this.ev && !this.sr) {
                    com.ss.android.socialbase.downloader.gd.f.c(this.fp);
                    this.sr = true;
                }
                return true;
            }
            AtomicInteger atomicInteger = this.ux;
            if ((atomicInteger == null || atomicInteger.get() <= 0) && !this.fp.hasNextBackupUrl()) {
                if (baseException == null) {
                    return false;
                }
                if ((baseException.getErrorCode() != 1011 && (baseException.getCause() == null || !(baseException.getCause() instanceof SSLHandshakeException))) || !this.fp.canReplaceHttpForRetry()) {
                    return false;
                }
            }
            return !(baseException instanceof com.ss.android.socialbase.downloader.exception.f);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.ev.f
    public void c(BaseException baseException, boolean z3) {
        com.ss.android.socialbase.downloader.xv.c.w(f49553c, "onAllChunkRetryWithReset");
        this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_ALL_CHUNK_RETRY_WITH_RESET;
        this.f49557j = baseException;
        yu();
        if (z3 ? sr(baseException) : false) {
            return;
        }
        xk();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(List<String> list) {
        if (list == null || list.isEmpty()) {
            return;
        }
        this.fp.setForbiddenBackupUrls(list, this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_WAITING_ASYNC_HANDLER);
        com.ss.android.socialbase.downloader.impls.c y3 = com.ss.android.socialbase.downloader.downloader.xv.y();
        if (y3 != null) {
            y3.a(this.fp.getId());
        }
    }

    @Override // com.ss.android.socialbase.downloader.ev.f
    public com.ss.android.socialbase.downloader.exception.ev c(com.ss.android.socialbase.downloader.model.w wVar, BaseException baseException, long j4) {
        if (i()) {
            return com.ss.android.socialbase.downloader.exception.ev.RETURN;
        }
        if (baseException != null && (baseException.getErrorCode() == 1047 || com.ss.android.socialbase.downloader.gd.f.ev(baseException))) {
            return c(baseException, j4);
        }
        this.f49557j = baseException;
        this.fp.increaseCurBytes(-j4);
        this.ys.c(this.fp);
        if (sr(baseException)) {
            return com.ss.android.socialbase.downloader.exception.ev.RETURN;
        }
        com.ss.android.socialbase.downloader.downloader.f fVar = this.f49561q;
        com.ss.android.socialbase.downloader.constants.ev evVar = this.f49564t;
        com.ss.android.socialbase.downloader.constants.ev evVar2 = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_RETRY_DELAY;
        fVar.c(wVar, baseException, evVar == evVar2);
        if (this.f49564t != evVar2 && this.fp.isNeedRetryDelay()) {
            long ck = ck();
            if (ck > 0) {
                String str = f49553c;
                com.ss.android.socialbase.downloader.xv.c.xv(str, "onSingleChunkRetry with delay time " + ck);
                try {
                    Thread.sleep(ck);
                } catch (Throwable th) {
                    String str2 = f49553c;
                    com.ss.android.socialbase.downloader.xv.c.sr(str2, "onSingleChunkRetry:" + th.getMessage());
                }
            }
        }
        return com.ss.android.socialbase.downloader.exception.ev.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.ev.f
    public com.ss.android.socialbase.downloader.exception.ev c(BaseException baseException, long j4) {
        long totalBytes;
        long j5;
        boolean z3;
        this.f49557j = baseException;
        this.fp.increaseCurBytes(-j4);
        this.ys.c(this.fp);
        if (i()) {
            return com.ss.android.socialbase.downloader.exception.ev.RETURN;
        }
        if (baseException != null && baseException.getErrorCode() == 1047) {
            if (this.f49559n != null && !this.fp.isForbiddenRetryed()) {
                com.ss.android.socialbase.downloader.depend.w wVar = new com.ss.android.socialbase.downloader.depend.w() { // from class: com.ss.android.socialbase.downloader.ev.xv.1
                    @Override // com.ss.android.socialbase.downloader.depend.w
                    public void c(List<String> list) {
                        super.c(list);
                        xv.this.c(list);
                    }
                };
                boolean c4 = this.f49559n.c(wVar);
                this.fp.setForbiddenRetryed();
                if (c4) {
                    if (!wVar.c()) {
                        yu();
                        this.f49561q.ev();
                        this.f49564t = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        return com.ss.android.socialbase.downloader.exception.ev.RETURN;
                    }
                    z3 = true;
                }
            } else if (sr(baseException)) {
                return com.ss.android.socialbase.downloader.exception.ev.RETURN;
            }
            z3 = false;
        } else if (com.ss.android.socialbase.downloader.gd.f.ev(baseException)) {
            if (this.ck == null) {
                w(baseException);
                return com.ss.android.socialbase.downloader.exception.ev.RETURN;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            ia iaVar = new ia() { // from class: com.ss.android.socialbase.downloader.ev.xv.2
                @Override // com.ss.android.socialbase.downloader.depend.ia
                public void c() {
                    synchronized (xv.this) {
                        atomicBoolean.set(true);
                        xv.this.wx();
                    }
                }
            };
            if (baseException instanceof com.ss.android.socialbase.downloader.exception.sr) {
                com.ss.android.socialbase.downloader.exception.sr srVar = (com.ss.android.socialbase.downloader.exception.sr) baseException;
                j5 = srVar.c();
                totalBytes = srVar.w();
            } else {
                totalBytes = this.fp.getTotalBytes();
                j5 = -1;
            }
            synchronized (this) {
                if (this.ck.c(j5, totalBytes, iaVar)) {
                    if (!com.ss.android.socialbase.downloader.r.c.c(this.fp.getId()).w("not_delete_when_clean_space", false)) {
                        gb();
                    }
                    if (!atomicBoolean.get()) {
                        com.ss.android.socialbase.downloader.constants.ev evVar = this.f49564t;
                        com.ss.android.socialbase.downloader.constants.ev evVar2 = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_WAITING_ASYNC_HANDLER;
                        if (evVar != evVar2) {
                            this.f49564t = evVar2;
                            yu();
                            this.f49561q.ev();
                        }
                        return com.ss.android.socialbase.downloader.exception.ev.RETURN;
                    }
                    if (sr(baseException)) {
                        return com.ss.android.socialbase.downloader.exception.ev.RETURN;
                    }
                    z3 = true;
                } else if (this.f49564t == com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_WAITING_ASYNC_HANDLER) {
                    return com.ss.android.socialbase.downloader.exception.ev.RETURN;
                } else {
                    w(baseException);
                    return com.ss.android.socialbase.downloader.exception.ev.RETURN;
                }
            }
        } else {
            if (sr(baseException)) {
                return com.ss.android.socialbase.downloader.exception.ev.RETURN;
            }
            z3 = false;
        }
        if (!z3 && pr()) {
            yu();
        }
        com.ss.android.socialbase.downloader.downloader.f fVar = this.f49561q;
        com.ss.android.socialbase.downloader.constants.ev evVar3 = this.f49564t;
        com.ss.android.socialbase.downloader.constants.ev evVar4 = com.ss.android.socialbase.downloader.constants.ev.RUN_STATUS_RETRY_DELAY;
        fVar.c(baseException, evVar3 == evVar4);
        return this.f49564t == evVar4 ? com.ss.android.socialbase.downloader.exception.ev.RETURN : com.ss.android.socialbase.downloader.exception.ev.CONTINUE;
    }

    @Override // com.ss.android.socialbase.downloader.ev.f
    public synchronized com.ss.android.socialbase.downloader.model.w c(int i4) {
        com.ss.android.socialbase.downloader.model.w c4;
        if (this.fp.getChunkCount() < 2) {
            return null;
        }
        List xv = this.ys.xv(this.fp.getId());
        if (xv != null && !xv.isEmpty()) {
            for (int i5 = 0; i5 < xv.size(); i5++) {
                com.ss.android.socialbase.downloader.model.w wVar = (com.ss.android.socialbase.downloader.model.w) xv.get(i5);
                if (wVar != null && (c4 = c(wVar, i4)) != null) {
                    return c4;
                }
            }
            return null;
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    @Override // com.ss.android.socialbase.downloader.ev.f
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void c(com.ss.android.socialbase.downloader.network.r r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L1a
            int r2 = r2.w()     // Catch: java.lang.Throwable -> L16
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r1.fp     // Catch: java.lang.Throwable -> L16
            r0.setHttpStatusCode(r2)     // Catch: java.lang.Throwable -> L16
            com.ss.android.socialbase.downloader.model.DownloadInfo r0 = r1.fp     // Catch: java.lang.Throwable -> L16
            java.lang.String r2 = com.ss.android.socialbase.downloader.gd.w.c(r2)     // Catch: java.lang.Throwable -> L16
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
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r1.fp
            r0 = -1
            r2.setHttpStatusCode(r0)
            com.ss.android.socialbase.downloader.model.DownloadInfo r2 = r1.fp
            java.lang.String r0 = ""
            r2.setHttpStatusMessage(r0)
        L2a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ev.xv.c(com.ss.android.socialbase.downloader.network.r):void");
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x006c, code lost:
        if (r9.f() != false) goto L18;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private com.ss.android.socialbase.downloader.model.w c(com.ss.android.socialbase.downloader.model.w r9, int r10) {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.ev.xv.c(com.ss.android.socialbase.downloader.model.w, int):com.ss.android.socialbase.downloader.model.w");
    }

    private fz c(DownloadTask downloadTask) {
        fz retryDelayTimeCalculator = downloadTask.getRetryDelayTimeCalculator();
        if (retryDelayTimeCalculator != null) {
            return retryDelayTimeCalculator;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            String retryDelayTimeArray = downloadInfo.getRetryDelayTimeArray();
            if (!TextUtils.isEmpty(retryDelayTimeArray)) {
                return new com.ss.android.socialbase.downloader.impls.ia(retryDelayTimeArray);
            }
        }
        return com.ss.android.socialbase.downloader.downloader.xv.x();
    }

    public void c(Future future) {
        this.f49566w = future;
    }
}
