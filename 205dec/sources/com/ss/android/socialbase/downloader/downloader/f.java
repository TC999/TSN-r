package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ls;
import com.ss.android.socialbase.downloader.depend.yu;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f {

    /* renamed from: c  reason: collision with root package name */
    private static final String f49440c = "f";
    private SparseArray<IDownloadListener> ev;

    /* renamed from: f  reason: collision with root package name */
    private DownloadTask f49442f;
    private com.ss.android.socialbase.downloader.depend.t fp;
    private SparseArray<IDownloadListener> gd;
    private ls ia;

    /* renamed from: r  reason: collision with root package name */
    private SparseArray<IDownloadListener> f49445r;
    private final p sr;

    /* renamed from: t  reason: collision with root package name */
    private int f49446t;
    private final Handler ux;

    /* renamed from: w  reason: collision with root package name */
    private final boolean f49447w;
    private DownloadInfo xv;
    private long ys;

    /* renamed from: p  reason: collision with root package name */
    private boolean f49444p = false;

    /* renamed from: k  reason: collision with root package name */
    private volatile long f49443k = 0;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f49441a = new AtomicLong();
    private boolean bk = false;

    public f(DownloadTask downloadTask, Handler handler) {
        this.f49442f = downloadTask;
        p();
        this.ux = handler;
        this.sr = xv.gb();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.f49447w = com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("fix_start_with_file_exist_update_error");
        } else {
            this.f49447w = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a() {
        try {
            com.ss.android.socialbase.downloader.xv.c.w(f49440c, "saveFileAsTargetName onSuccess");
            try {
                bk();
                this.xv.setFirstSuccess(false);
                this.xv.setSuccessByCache(false);
                c(-3, (BaseException) null);
                this.sr.xv(this.xv.getId(), this.xv.getTotalBytes());
                this.sr.sr(this.xv.getId());
                this.sr.bk(this.xv.getId());
            } catch (BaseException e4) {
                c(e4);
            }
        } catch (Throwable th) {
            c(new BaseException(1008, com.ss.android.socialbase.downloader.gd.f.w(th, "onCompleted")));
        }
    }

    private void bk() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.z> downloadCompleteHandlers = this.f49442f.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.xv;
        c(11, (BaseException) null);
        this.sr.c(downloadInfo);
        Iterator<com.ss.android.socialbase.downloader.depend.z> it = downloadCompleteHandlers.iterator();
        while (it.hasNext()) {
            com.ss.android.socialbase.downloader.depend.bk bkVar = (com.ss.android.socialbase.downloader.depend.bk) it.next();
            try {
                if (bkVar.w(downloadInfo)) {
                    bkVar.c(downloadInfo);
                    this.sr.c(downloadInfo);
                }
            } catch (BaseException e4) {
                throw e4;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    private void k() {
        ExecutorService a4 = xv.a();
        if (a4 != null) {
            a4.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.f.1
                @Override // java.lang.Runnable
                public void run() {
                    f.this.sr.gd(f.this.xv.getId());
                    f.this.c(1, (BaseException) null);
                }
            });
        }
    }

    private void p() {
        DownloadTask downloadTask = this.f49442f;
        if (downloadTask != null) {
            this.xv = downloadTask.getDownloadInfo();
            this.f49445r = this.f49442f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            this.gd = this.f49442f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.ev = this.f49442f.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
            this.fp = this.f49442f.getDepend();
            this.ia = this.f49442f.getMonitorDepend();
        }
    }

    public void ev() {
        this.xv.setStatus(8);
        this.xv.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.c.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.c y3 = xv.y();
        if (y3 != null) {
            y3.c(this.xv.getId(), this.f49442f.getHashCodeForSameTask(), 8);
        }
    }

    public void f() {
        this.xv.setFirstDownload(false);
        if (!this.xv.isIgnoreDataVerify() && this.xv.getCurBytes() != this.xv.getTotalBytes()) {
            com.ss.android.socialbase.downloader.xv.c.w(f49440c, this.xv.getErrorBytesLog());
            c(new com.ss.android.socialbase.downloader.exception.f(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.xv.getByteInvalidRetryStatus()));
        } else if (this.xv.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.xv.c.w(f49440c, this.xv.getErrorBytesLog());
            c(new com.ss.android.socialbase.downloader.exception.f(1026, "curBytes is 0, bytes changed with process : " + this.xv.getByteInvalidRetryStatus()));
        } else if (!this.xv.isIgnoreDataVerify() && this.xv.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.xv.c.w(f49440c, this.xv.getErrorBytesLog());
            c(new com.ss.android.socialbase.downloader.exception.f(1044, "TotalBytes is 0, bytes changed with process : " + this.xv.getByteInvalidRetryStatus()));
        } else {
            String str = f49440c;
            com.ss.android.socialbase.downloader.xv.c.w(str, "" + this.xv.getName() + " onCompleted start save file as target name");
            ls lsVar = this.ia;
            DownloadTask downloadTask = this.f49442f;
            if (downloadTask != null) {
                lsVar = downloadTask.getMonitorDepend();
            }
            com.ss.android.socialbase.downloader.gd.f.c(this.xv, lsVar, new yu() { // from class: com.ss.android.socialbase.downloader.downloader.f.2
                @Override // com.ss.android.socialbase.downloader.depend.yu
                public void c() {
                    f.this.a();
                }

                @Override // com.ss.android.socialbase.downloader.depend.yu
                public void c(BaseException baseException) {
                    String str2 = f.f49440c;
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveFileAsTargetName onFailed : ");
                    sb.append(baseException != null ? baseException.getErrorMessage() : "");
                    com.ss.android.socialbase.downloader.xv.c.w(str2, sb.toString());
                    f.this.c(baseException);
                }
            });
        }
    }

    public void r() throws BaseException {
        if (this.f49447w) {
            bk();
            com.ss.android.socialbase.downloader.xv.c.w(f49440c, "onCompleteForFileExist");
            this.xv.setSuccessByCache(true);
            c(-3, (BaseException) null);
            this.sr.xv(this.xv.getId(), this.xv.getTotalBytes());
            this.sr.sr(this.xv.getId());
            this.sr.c(this.xv);
            this.sr.bk(this.xv.getId());
            return;
        }
        bk();
        com.ss.android.socialbase.downloader.xv.c.w(f49440c, "onCompleteForFileExist");
        this.xv.setSuccessByCache(true);
        c(-3, (BaseException) null);
        this.sr.xv(this.xv.getId(), this.xv.getTotalBytes());
        this.sr.sr(this.xv.getId());
        this.sr.bk(this.xv.getId());
    }

    public void sr() {
        this.xv.setStatus(-2);
        try {
            this.sr.sr(this.xv.getId(), this.xv.getCurBytes());
        } catch (SQLiteException e4) {
            e4.printStackTrace();
        }
        c(-2, (BaseException) null);
    }

    public void ux() {
        this.xv.setStatus(-7);
        try {
            this.sr.p(this.xv.getId());
        } catch (SQLiteException e4) {
            e4.printStackTrace();
        }
        c(-7, (BaseException) null);
    }

    public void w() {
        if (this.xv.canSkipStatusHandler()) {
            this.xv.changeSkipStatus();
            return;
        }
        this.sr.r(this.xv.getId());
        if (this.xv.isFirstDownload()) {
            c(6, (BaseException) null);
        }
        c(2, (BaseException) null);
    }

    public void xv() {
        c(-4, (BaseException) null);
    }

    private BaseException xv(BaseException baseException) {
        Context gw;
        if (com.ss.android.socialbase.downloader.r.c.c(this.xv.getId()).c("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.gd.f.gd(baseException) || (gw = xv.gw()) == null || com.ss.android.socialbase.downloader.gd.f.xv(gw)) {
            return baseException;
        }
        return new BaseException(this.xv.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void c() {
        if (this.xv.canSkipStatusHandler()) {
            return;
        }
        this.xv.setStatus(1);
        k();
    }

    public void c(long j4, String str, String str2) {
        this.xv.setTotalBytes(j4);
        this.xv.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.xv.getName())) {
            this.xv.setName(str2);
        }
        try {
            this.sr.c(this.xv.getId(), j4, str, str2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        c(3, (BaseException) null);
        this.ys = this.xv.getMinByteIntervalForPostToMainThread(j4);
        this.f49446t = this.xv.getMinProgressTimeMsInterval();
        this.f49444p = true;
        com.ss.android.socialbase.downloader.impls.s.c().ux();
    }

    private void w(BaseException baseException) {
        String str = f49440c;
        Log.d(str, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.sr.f(this.xv.getId());
            } catch (SQLiteException e4) {
                e4.printStackTrace();
            }
        } else {
            try {
                try {
                    this.sr.w(this.xv.getId(), this.xv.getCurBytes());
                } catch (SQLiteException e5) {
                    e5.printStackTrace();
                }
            } catch (SQLiteException unused) {
                this.sr.f(this.xv.getId());
            }
        }
        BaseException xv = xv(baseException);
        this.xv.setFailedException(xv);
        c(xv instanceof com.ss.android.socialbase.downloader.exception.ux ? -2 : -1, xv);
        if (com.ss.android.socialbase.downloader.r.c.c(this.xv.getId()).c("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.s.c().c(this.xv);
        }
    }

    public boolean c(long j4) {
        this.f49441a.addAndGet(j4);
        this.xv.increaseCurBytes(j4);
        long uptimeMillis = SystemClock.uptimeMillis();
        return c(uptimeMillis, w(uptimeMillis));
    }

    private boolean w(long j4) {
        boolean z3 = true;
        if (!this.bk) {
            this.bk = true;
            return true;
        }
        long j5 = j4 - this.f49443k;
        if (this.f49441a.get() < this.ys && j5 < this.f49446t) {
            z3 = false;
        }
        if (z3) {
            this.f49443k = j4;
            this.f49441a.set(0L);
        }
        return z3;
    }

    public void c(BaseException baseException, boolean z3) {
        this.xv.setFirstDownload(false);
        this.f49441a.set(0L);
        w(baseException, z3);
    }

    public void c(com.ss.android.socialbase.downloader.model.w wVar, BaseException baseException, boolean z3) {
        this.xv.setFirstDownload(false);
        this.f49441a.set(0L);
        this.sr.ev(this.xv.getId());
        c(z3 ? 10 : 9, baseException, true);
    }

    private void w(BaseException baseException, boolean z3) {
        this.sr.ev(this.xv.getId());
        c(z3 ? 7 : 5, baseException);
    }

    public void c(BaseException baseException) {
        this.xv.setFirstDownload(false);
        w(baseException);
    }

    public void c(String str) throws BaseException {
        String str2 = f49440c;
        com.ss.android.socialbase.downloader.xv.c.w(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.xv.getName());
        if (this.f49447w) {
            com.ss.android.socialbase.downloader.gd.f.c(this.xv, str);
            bk();
            this.xv.setSuccessByCache(true);
            c(-3, (BaseException) null);
            this.sr.c(this.xv);
            return;
        }
        this.sr.c(this.xv);
        com.ss.android.socialbase.downloader.gd.f.c(this.xv, str);
        this.xv.setSuccessByCache(true);
        bk();
        c(-3, (BaseException) null);
    }

    private boolean c(long j4, boolean z3) {
        boolean z4 = false;
        if (this.xv.getCurBytes() == this.xv.getTotalBytes()) {
            try {
                this.sr.c(this.xv.getId(), this.xv.getCurBytes());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return false;
        }
        if (this.f49444p) {
            this.f49444p = false;
            this.xv.setStatus(4);
        }
        if (this.xv.isNeedPostProgress() && z3) {
            z4 = true;
        }
        c(4, (BaseException) null, z4);
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i4, BaseException baseException) {
        c(i4, baseException, true);
    }

    private void c(int i4, BaseException baseException, boolean z3) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.xv.getStatus();
        if (status == -3 && i4 == 4) {
            return;
        }
        p();
        if (i4 != 4 && DownloadStatus.isRealTimeUploadStatus(i4)) {
            this.xv.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i4)) {
                this.xv.updateDownloadTime();
            }
        }
        if (!this.xv.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.sr.c.c(this.f49442f, baseException, i4);
        }
        if (i4 == 6) {
            this.xv.setStatus(2);
        } else if (i4 == -6) {
            this.xv.setStatus(-3);
        } else {
            this.xv.setStatus(i4);
        }
        if (status == -3 || status == -1) {
            if (this.xv.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.r.DELAY_RETRY_DOWNLOADING) {
                this.xv.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.r.DELAY_RETRY_DOWNLOADED);
            }
            if (this.xv.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.c.ASYNC_HANDLE_DOWNLOADING) {
                this.xv.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.c.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.xv.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.w.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.xv.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.w.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.gd.xv.c(i4, this.ev, true, this.xv, baseException);
        if (i4 == -4) {
            return;
        }
        if (z3 && this.ux != null && (((sparseArray = this.f49445r) != null && sparseArray.size() > 0) || ((sparseArray2 = this.gd) != null && sparseArray2.size() > 0 && (this.xv.canShowNotification() || this.xv.isAutoInstallWithoutNotification())))) {
            this.ux.obtainMessage(i4, this.xv.getId(), this.f49442f.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.c y3 = xv.y();
        if (y3 != null) {
            y3.c(this.xv.getId(), this.f49442f.getHashCodeForSameTask(), i4);
        }
    }
}
