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
import com.ss.android.socialbase.downloader.depend.fd;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf {
    private static final String ok = "kf";

    /* renamed from: a  reason: collision with root package name */
    private final boolean f49452a;
    private DownloadInfo bl;

    /* renamed from: h  reason: collision with root package name */
    private SparseArray<IDownloadListener> f49453h;

    /* renamed from: i  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.depend.rh f49454i;
    private DownloadTask kf;

    /* renamed from: n  reason: collision with root package name */
    private final Handler f49457n;

    /* renamed from: p  reason: collision with root package name */
    private SparseArray<IDownloadListener> f49458p;

    /* renamed from: q  reason: collision with root package name */
    private SparseArray<IDownloadListener> f49459q;
    private int rh;

    /* renamed from: s  reason: collision with root package name */
    private final k f49461s;

    /* renamed from: t  reason: collision with root package name */
    private long f49462t;

    /* renamed from: x  reason: collision with root package name */
    private y f49463x;

    /* renamed from: k  reason: collision with root package name */
    private boolean f49456k = false;

    /* renamed from: r  reason: collision with root package name */
    private volatile long f49460r = 0;

    /* renamed from: j  reason: collision with root package name */
    private final AtomicLong f49455j = new AtomicLong();

    /* renamed from: z  reason: collision with root package name */
    private boolean f49464z = false;

    public kf(DownloadTask downloadTask, Handler handler) {
        this.kf = downloadTask;
        k();
        this.f49457n = handler;
        this.f49461s = bl.m();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.f49452a = com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("fix_start_with_file_exist_update_error");
        } else {
            this.f49452a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "saveFileAsTargetName onSuccess");
            try {
                z();
                this.bl.setFirstSuccess(false);
                this.bl.setSuccessByCache(false);
                ok(-3, (BaseException) null);
                this.f49461s.bl(this.bl.getId(), this.bl.getTotalBytes());
                this.f49461s.s(this.bl.getId());
                this.f49461s.z(this.bl.getId());
            } catch (BaseException e4) {
                ok(e4);
            }
        } catch (Throwable th) {
            ok(new BaseException(1008, com.ss.android.socialbase.downloader.q.kf.a(th, "onCompleted")));
        }
    }

    private void k() {
        DownloadTask downloadTask = this.kf;
        if (downloadTask != null) {
            this.bl = downloadTask.getDownloadInfo();
            this.f49453h = this.kf.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.MAIN);
            this.f49459q = this.kf.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION);
            this.f49458p = this.kf.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.SUB);
            this.f49454i = this.kf.getDepend();
            this.f49463x = this.kf.getMonitorDepend();
        }
    }

    private void r() {
        ExecutorService j4 = bl.j();
        if (j4 != null) {
            j4.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.kf.1
                @Override // java.lang.Runnable
                public void run() {
                    kf.this.f49461s.q(kf.this.bl.getId());
                    kf.this.ok(1, (BaseException) null);
                }
            });
        }
    }

    private void z() throws BaseException {
        List<com.ss.android.socialbase.downloader.depend.z> downloadCompleteHandlers = this.kf.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.bl;
        ok(11, (BaseException) null);
        this.f49461s.ok(downloadInfo);
        for (com.ss.android.socialbase.downloader.depend.z zVar : downloadCompleteHandlers) {
            try {
                if (zVar.a(downloadInfo)) {
                    zVar.ok(downloadInfo);
                    this.f49461s.ok(downloadInfo);
                }
            } catch (BaseException e4) {
                throw e4;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    public void h() throws BaseException {
        if (this.f49452a) {
            z();
            com.ss.android.socialbase.downloader.bl.ok.a(ok, "onCompleteForFileExist");
            this.bl.setSuccessByCache(true);
            ok(-3, (BaseException) null);
            this.f49461s.bl(this.bl.getId(), this.bl.getTotalBytes());
            this.f49461s.s(this.bl.getId());
            this.f49461s.ok(this.bl);
            this.f49461s.z(this.bl.getId());
            return;
        }
        z();
        com.ss.android.socialbase.downloader.bl.ok.a(ok, "onCompleteForFileExist");
        this.bl.setSuccessByCache(true);
        ok(-3, (BaseException) null);
        this.f49461s.bl(this.bl.getId(), this.bl.getTotalBytes());
        this.f49461s.s(this.bl.getId());
        this.f49461s.z(this.bl.getId());
    }

    public void kf() {
        this.bl.setFirstDownload(false);
        if (!this.bl.isIgnoreDataVerify() && this.bl.getCurBytes() != this.bl.getTotalBytes()) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, this.bl.getErrorBytesLog());
            ok(new com.ss.android.socialbase.downloader.exception.kf(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.bl.getByteInvalidRetryStatus()));
        } else if (this.bl.getCurBytes() <= 0) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, this.bl.getErrorBytesLog());
            ok(new com.ss.android.socialbase.downloader.exception.kf(1026, "curBytes is 0, bytes changed with process : " + this.bl.getByteInvalidRetryStatus()));
        } else if (!this.bl.isIgnoreDataVerify() && this.bl.getTotalBytes() <= 0) {
            com.ss.android.socialbase.downloader.bl.ok.a(ok, this.bl.getErrorBytesLog());
            ok(new com.ss.android.socialbase.downloader.exception.kf(1044, "TotalBytes is 0, bytes changed with process : " + this.bl.getByteInvalidRetryStatus()));
        } else {
            String str = ok;
            com.ss.android.socialbase.downloader.bl.ok.a(str, "" + this.bl.getName() + " onCompleted start save file as target name");
            y yVar = this.f49463x;
            DownloadTask downloadTask = this.kf;
            if (downloadTask != null) {
                yVar = downloadTask.getMonitorDepend();
            }
            com.ss.android.socialbase.downloader.q.kf.ok(this.bl, yVar, new fd() { // from class: com.ss.android.socialbase.downloader.downloader.kf.2
                @Override // com.ss.android.socialbase.downloader.depend.fd
                public void ok() {
                    kf.this.j();
                }

                @Override // com.ss.android.socialbase.downloader.depend.fd
                public void ok(BaseException baseException) {
                    String str2 = kf.ok;
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveFileAsTargetName onFailed : ");
                    sb.append(baseException != null ? baseException.getErrorMessage() : "");
                    com.ss.android.socialbase.downloader.bl.ok.a(str2, sb.toString());
                    kf.this.ok(baseException);
                }
            });
        }
    }

    public void n() {
        this.bl.setStatus(-7);
        try {
            this.f49461s.k(this.bl.getId());
        } catch (SQLiteException e4) {
            e4.printStackTrace();
        }
        ok(-7, (BaseException) null);
    }

    public void p() {
        this.bl.setStatus(8);
        this.bl.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_WAITING);
        com.ss.android.socialbase.downloader.impls.ok fb = bl.fb();
        if (fb != null) {
            fb.ok(this.bl.getId(), this.kf.getHashCodeForSameTask(), 8);
        }
    }

    public void s() {
        this.bl.setStatus(-2);
        try {
            this.f49461s.s(this.bl.getId(), this.bl.getCurBytes());
        } catch (SQLiteException e4) {
            e4.printStackTrace();
        }
        ok(-2, (BaseException) null);
    }

    public void a() {
        if (this.bl.canSkipStatusHandler()) {
            this.bl.changeSkipStatus();
            return;
        }
        this.f49461s.h(this.bl.getId());
        if (this.bl.isFirstDownload()) {
            ok(6, (BaseException) null);
        }
        ok(2, (BaseException) null);
    }

    public void bl() {
        ok(-4, (BaseException) null);
    }

    private BaseException bl(BaseException baseException) {
        Context l4;
        if (com.ss.android.socialbase.downloader.h.ok.ok(this.bl.getId()).ok("download_failed_check_net", 1) != 1 || !com.ss.android.socialbase.downloader.q.kf.q(baseException) || (l4 = bl.l()) == null || com.ss.android.socialbase.downloader.q.kf.bl(l4)) {
            return baseException;
        }
        return new BaseException(this.bl.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    public void ok() {
        if (this.bl.canSkipStatusHandler()) {
            return;
        }
        this.bl.setStatus(1);
        r();
    }

    public void ok(long j4, String str, String str2) {
        this.bl.setTotalBytes(j4);
        this.bl.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.bl.getName())) {
            this.bl.setName(str2);
        }
        try {
            this.f49461s.ok(this.bl.getId(), j4, str, str2);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        ok(3, (BaseException) null);
        this.f49462t = this.bl.getMinByteIntervalForPostToMainThread(j4);
        this.rh = this.bl.getMinProgressTimeMsInterval();
        this.f49456k = true;
        com.ss.android.socialbase.downloader.impls.td.ok().n();
    }

    private void a(BaseException baseException) {
        String str = ok;
        Log.d(str, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.f49461s.kf(this.bl.getId());
            } catch (SQLiteException e4) {
                e4.printStackTrace();
            }
        } else {
            try {
                try {
                    this.f49461s.a(this.bl.getId(), this.bl.getCurBytes());
                } catch (SQLiteException e5) {
                    e5.printStackTrace();
                }
            } catch (SQLiteException unused) {
                this.f49461s.kf(this.bl.getId());
            }
        }
        BaseException bl = bl(baseException);
        this.bl.setFailedException(bl);
        ok(bl instanceof com.ss.android.socialbase.downloader.exception.n ? -2 : -1, bl);
        if (com.ss.android.socialbase.downloader.h.ok.ok(this.bl.getId()).ok("retry_schedule", 0) > 0) {
            com.ss.android.socialbase.downloader.impls.td.ok().ok(this.bl);
        }
    }

    public boolean ok(long j4) {
        this.f49455j.addAndGet(j4);
        this.bl.increaseCurBytes(j4);
        long uptimeMillis = SystemClock.uptimeMillis();
        return ok(uptimeMillis, a(uptimeMillis));
    }

    private boolean a(long j4) {
        boolean z3 = true;
        if (!this.f49464z) {
            this.f49464z = true;
            return true;
        }
        long j5 = j4 - this.f49460r;
        if (this.f49455j.get() < this.f49462t && j5 < this.rh) {
            z3 = false;
        }
        if (z3) {
            this.f49460r = j4;
            this.f49455j.set(0L);
        }
        return z3;
    }

    public void ok(BaseException baseException, boolean z3) {
        this.bl.setFirstDownload(false);
        this.f49455j.set(0L);
        a(baseException, z3);
    }

    public void ok(com.ss.android.socialbase.downloader.model.a aVar, BaseException baseException, boolean z3) {
        this.bl.setFirstDownload(false);
        this.f49455j.set(0L);
        this.f49461s.p(this.bl.getId());
        ok(z3 ? 10 : 9, baseException, true);
    }

    private void a(BaseException baseException, boolean z3) {
        this.f49461s.p(this.bl.getId());
        ok(z3 ? 7 : 5, baseException);
    }

    public void ok(BaseException baseException) {
        this.bl.setFirstDownload(false);
        a(baseException);
    }

    public void ok(String str) throws BaseException {
        String str2 = ok;
        com.ss.android.socialbase.downloader.bl.ok.a(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.bl.getName());
        if (this.f49452a) {
            com.ss.android.socialbase.downloader.q.kf.ok(this.bl, str);
            z();
            this.bl.setSuccessByCache(true);
            ok(-3, (BaseException) null);
            this.f49461s.ok(this.bl);
            return;
        }
        this.f49461s.ok(this.bl);
        com.ss.android.socialbase.downloader.q.kf.ok(this.bl, str);
        this.bl.setSuccessByCache(true);
        z();
        ok(-3, (BaseException) null);
    }

    private boolean ok(long j4, boolean z3) {
        boolean z4 = false;
        if (this.bl.getCurBytes() == this.bl.getTotalBytes()) {
            try {
                this.f49461s.ok(this.bl.getId(), this.bl.getCurBytes());
            } catch (Exception e4) {
                e4.printStackTrace();
            }
            return false;
        }
        if (this.f49456k) {
            this.f49456k = false;
            this.bl.setStatus(4);
        }
        if (this.bl.isNeedPostProgress() && z3) {
            z4 = true;
        }
        ok(4, (BaseException) null, z4);
        return z3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ok(int i4, BaseException baseException) {
        ok(i4, baseException, true);
    }

    private void ok(int i4, BaseException baseException, boolean z3) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.bl.getStatus();
        if (status == -3 && i4 == 4) {
            return;
        }
        k();
        if (i4 != 4 && DownloadStatus.isRealTimeUploadStatus(i4)) {
            this.bl.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i4)) {
                this.bl.updateDownloadTime();
            }
        }
        if (!this.bl.isAddListenerToSameTask()) {
            com.ss.android.socialbase.downloader.s.ok.ok(this.kf, baseException, i4);
        }
        if (i4 == 6) {
            this.bl.setStatus(2);
        } else if (i4 == -6) {
            this.bl.setStatus(-3);
        } else {
            this.bl.setStatus(i4);
        }
        if (status == -3 || status == -1) {
            if (this.bl.getRetryDelayStatus() == com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_DOWNLOADING) {
                this.bl.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_DOWNLOADED);
            }
            if (this.bl.getAsyncHandleStatus() == com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_DOWNLOADING) {
                this.bl.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.bl.getByteInvalidRetryStatus() == com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.bl.setByteInvalidRetryStatus(com.ss.android.socialbase.downloader.constants.a.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        com.ss.android.socialbase.downloader.q.bl.ok(i4, this.f49458p, true, this.bl, baseException);
        if (i4 == -4) {
            return;
        }
        if (z3 && this.f49457n != null && (((sparseArray = this.f49453h) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f49459q) != null && sparseArray2.size() > 0 && (this.bl.canShowNotification() || this.bl.isAutoInstallWithoutNotification())))) {
            this.f49457n.obtainMessage(i4, this.bl.getId(), this.kf.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        com.ss.android.socialbase.downloader.impls.ok fb = bl.fb();
        if (fb != null) {
            fb.ok(this.bl.getId(), this.kf.getHashCodeForSameTask(), i4);
        }
    }
}
