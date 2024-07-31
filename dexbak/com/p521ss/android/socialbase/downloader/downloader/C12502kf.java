package com.p521ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteFullException;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.constants.DownloadStatus;
import com.p521ss.android.socialbase.downloader.constants.EnumC12411a;
import com.p521ss.android.socialbase.downloader.constants.EnumC12413h;
import com.p521ss.android.socialbase.downloader.constants.EnumC12414kf;
import com.p521ss.android.socialbase.downloader.constants.EnumC12416ok;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12430fd;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12469rh;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12483y;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.exception.C12528kf;
import com.p521ss.android.socialbase.downloader.exception.C12529n;
import com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok;
import com.p521ss.android.socialbase.downloader.impls.C12565td;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12667bl;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p557s.C12723ok;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: com.ss.android.socialbase.downloader.downloader.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12502kf {

    /* renamed from: ok */
    private static final String f35112ok = "kf";

    /* renamed from: a */
    private final boolean f35113a;

    /* renamed from: bl */
    private DownloadInfo f35114bl;

    /* renamed from: h */
    private SparseArray<IDownloadListener> f35115h;

    /* renamed from: i */
    private InterfaceC12469rh f35116i;

    /* renamed from: kf */
    private DownloadTask f35119kf;

    /* renamed from: n */
    private final Handler f35120n;

    /* renamed from: p */
    private SparseArray<IDownloadListener> f35121p;

    /* renamed from: q */
    private SparseArray<IDownloadListener> f35122q;

    /* renamed from: rh */
    private int f35124rh;

    /* renamed from: s */
    private final InterfaceC12501k f35125s;

    /* renamed from: t */
    private long f35126t;

    /* renamed from: x */
    private InterfaceC12483y f35127x;

    /* renamed from: k */
    private boolean f35118k = false;

    /* renamed from: r */
    private volatile long f35123r = 0;

    /* renamed from: j */
    private final AtomicLong f35117j = new AtomicLong();

    /* renamed from: z */
    private boolean f35128z = false;

    public C12502kf(DownloadTask downloadTask, Handler handler) {
        this.f35119kf = downloadTask;
        m17725k();
        this.f35120n = handler;
        this.f35125s = C12490bl.m17806m();
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo != null) {
            this.f35113a = C12534ok.m17599ok(downloadInfo.getId()).m17595ok("fix_start_with_file_exist_update_error");
        } else {
            this.f35113a = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public void m17726j() {
        try {
            C12409ok.m17904a(f35112ok, "saveFileAsTargetName onSuccess");
            try {
                m17706z();
                this.f35114bl.setFirstSuccess(false);
                this.f35114bl.setSuccessByCache(false);
                m17721ok(-3, (BaseException) null);
                this.f35125s.mo17511bl(this.f35114bl.getId(), this.f35114bl.getTotalBytes());
                this.f35125s.mo17478s(this.f35114bl.getId());
                this.f35125s.mo17475z(this.f35114bl.getId());
            } catch (BaseException e) {
                m17714ok(e);
            }
        } catch (Throwable th) {
            m17714ok(new BaseException(1008, C12713kf.m16608a(th, "onCompleted")));
        }
    }

    /* renamed from: k */
    private void m17725k() {
        DownloadTask downloadTask = this.f35119kf;
        if (downloadTask != null) {
            this.f35114bl = downloadTask.getDownloadInfo();
            this.f35115h = this.f35119kf.getDownloadListeners(EnumC12414kf.MAIN);
            this.f35122q = this.f35119kf.getDownloadListeners(EnumC12414kf.NOTIFICATION);
            this.f35121p = this.f35119kf.getDownloadListeners(EnumC12414kf.SUB);
            this.f35116i = this.f35119kf.getDepend();
            this.f35127x = this.f35119kf.getMonitorDepend();
        }
    }

    /* renamed from: r */
    private void m17708r() {
        ExecutorService m17812j = C12490bl.m17812j();
        if (m17812j != null) {
            m17812j.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.kf.1
                @Override // java.lang.Runnable
                public void run() {
                    C12502kf.this.f35125s.mo17481q(C12502kf.this.f35114bl.getId());
                    C12502kf.this.m17721ok(1, (BaseException) null);
                }
            });
        }
    }

    /* renamed from: z */
    private void m17706z() throws BaseException {
        List<InterfaceC12484z> downloadCompleteHandlers = this.f35119kf.getDownloadCompleteHandlers();
        if (downloadCompleteHandlers.isEmpty()) {
            return;
        }
        DownloadInfo downloadInfo = this.f35114bl;
        m17721ok(11, (BaseException) null);
        this.f35125s.mo17488ok(downloadInfo);
        for (InterfaceC12484z interfaceC12484z : downloadCompleteHandlers) {
            try {
                if (interfaceC12484z.mo16628a(downloadInfo)) {
                    interfaceC12484z.mo16627ok(downloadInfo);
                    this.f35125s.mo17488ok(downloadInfo);
                }
            } catch (BaseException e) {
                throw e;
            } catch (Throwable th) {
                throw new BaseException(1071, th);
            }
        }
    }

    /* renamed from: h */
    public void m17727h() throws BaseException {
        if (this.f35113a) {
            m17706z();
            C12409ok.m17904a(f35112ok, "onCompleteForFileExist");
            this.f35114bl.setSuccessByCache(true);
            m17721ok(-3, (BaseException) null);
            this.f35125s.mo17511bl(this.f35114bl.getId(), this.f35114bl.getTotalBytes());
            this.f35125s.mo17478s(this.f35114bl.getId());
            this.f35125s.mo17488ok(this.f35114bl);
            this.f35125s.mo17475z(this.f35114bl.getId());
            return;
        }
        m17706z();
        C12409ok.m17904a(f35112ok, "onCompleteForFileExist");
        this.f35114bl.setSuccessByCache(true);
        m17721ok(-3, (BaseException) null);
        this.f35125s.mo17511bl(this.f35114bl.getId(), this.f35114bl.getTotalBytes());
        this.f35125s.mo17478s(this.f35114bl.getId());
        this.f35125s.mo17475z(this.f35114bl.getId());
    }

    /* renamed from: kf */
    public void m17724kf() {
        this.f35114bl.setFirstDownload(false);
        if (!this.f35114bl.isIgnoreDataVerify() && this.f35114bl.getCurBytes() != this.f35114bl.getTotalBytes()) {
            C12409ok.m17904a(f35112ok, this.f35114bl.getErrorBytesLog());
            m17714ok(new C12528kf(1027, "current bytes is not equals to total bytes, bytes changed with process : " + this.f35114bl.getByteInvalidRetryStatus()));
        } else if (this.f35114bl.getCurBytes() <= 0) {
            C12409ok.m17904a(f35112ok, this.f35114bl.getErrorBytesLog());
            m17714ok(new C12528kf(1026, "curBytes is 0, bytes changed with process : " + this.f35114bl.getByteInvalidRetryStatus()));
        } else if (!this.f35114bl.isIgnoreDataVerify() && this.f35114bl.getTotalBytes() <= 0) {
            C12409ok.m17904a(f35112ok, this.f35114bl.getErrorBytesLog());
            m17714ok(new C12528kf(1044, "TotalBytes is 0, bytes changed with process : " + this.f35114bl.getByteInvalidRetryStatus()));
        } else {
            String str = f35112ok;
            C12409ok.m17904a(str, "" + this.f35114bl.getName() + " onCompleted start save file as target name");
            InterfaceC12483y interfaceC12483y = this.f35127x;
            DownloadTask downloadTask = this.f35119kf;
            if (downloadTask != null) {
                interfaceC12483y = downloadTask.getMonitorDepend();
            }
            C12713kf.m16562ok(this.f35114bl, interfaceC12483y, new InterfaceC12430fd() { // from class: com.ss.android.socialbase.downloader.downloader.kf.2
                @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12430fd
                /* renamed from: ok */
                public void mo17705ok() {
                    C12502kf.this.m17726j();
                }

                @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12430fd
                /* renamed from: ok */
                public void mo17704ok(BaseException baseException) {
                    String str2 = C12502kf.f35112ok;
                    StringBuilder sb = new StringBuilder();
                    sb.append("saveFileAsTargetName onFailed : ");
                    sb.append(baseException != null ? baseException.getErrorMessage() : "");
                    C12409ok.m17904a(str2, sb.toString());
                    C12502kf.this.m17714ok(baseException);
                }
            });
        }
    }

    /* renamed from: n */
    public void m17723n() {
        this.f35114bl.setStatus(-7);
        try {
            this.f35125s.mo17504k(this.f35114bl.getId());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        m17721ok(-7, (BaseException) null);
    }

    /* renamed from: p */
    public void m17710p() {
        this.f35114bl.setStatus(8);
        this.f35114bl.setAsyncHandleStatus(EnumC12416ok.ASYNC_HANDLE_WAITING);
        AbstractC12547ok m17820fb = C12490bl.m17820fb();
        if (m17820fb != null) {
            m17820fb.m17556ok(this.f35114bl.getId(), this.f35119kf.getHashCodeForSameTask(), 8);
        }
    }

    /* renamed from: s */
    public void m17707s() {
        this.f35114bl.setStatus(-2);
        try {
            this.f35125s.mo17477s(this.f35114bl.getId(), this.f35114bl.getCurBytes());
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        m17721ok(-2, (BaseException) null);
    }

    /* renamed from: a */
    public void m17735a() {
        if (this.f35114bl.canSkipStatusHandler()) {
            this.f35114bl.changeSkipStatus();
            return;
        }
        this.f35125s.mo17507h(this.f35114bl.getId());
        if (this.f35114bl.isFirstDownload()) {
            m17721ok(6, (BaseException) null);
        }
        m17721ok(2, (BaseException) null);
    }

    /* renamed from: bl */
    public void m17730bl() {
        m17721ok(-4, (BaseException) null);
    }

    /* renamed from: bl */
    private BaseException m17728bl(BaseException baseException) {
        Context m17807l;
        if (C12534ok.m17599ok(this.f35114bl.getId()).m17593ok("download_failed_check_net", 1) != 1 || !C12713kf.m16525q(baseException) || (m17807l = C12490bl.m17807l()) == null || C12713kf.m16602bl(m17807l)) {
            return baseException;
        }
        return new BaseException(this.f35114bl.isOnlyWifi() ? 1013 : 1049, baseException.getErrorMessage());
    }

    /* renamed from: ok */
    public void m17722ok() {
        if (this.f35114bl.canSkipStatusHandler()) {
            return;
        }
        this.f35114bl.setStatus(1);
        m17708r();
    }

    /* renamed from: ok */
    public void m17718ok(long j, String str, String str2) {
        this.f35114bl.setTotalBytes(j);
        this.f35114bl.seteTag(str);
        if (!TextUtils.isEmpty(str2) && TextUtils.isEmpty(this.f35114bl.getName())) {
            this.f35114bl.setName(str2);
        }
        try {
            this.f35125s.mo17493ok(this.f35114bl.getId(), j, str, str2);
        } catch (Exception e) {
            e.printStackTrace();
        }
        m17721ok(3, (BaseException) null);
        this.f35126t = this.f35114bl.getMinByteIntervalForPostToMainThread(j);
        this.f35124rh = this.f35114bl.getMinProgressTimeMsInterval();
        this.f35118k = true;
        C12565td.m17403ok().m17405n();
    }

    /* renamed from: a */
    private void m17732a(BaseException baseException) {
        String str = f35112ok;
        Log.d(str, "handleError::" + baseException + " \r\n" + Log.getStackTraceString(new Throwable()));
        if (baseException != null && baseException.getCause() != null && (baseException.getCause() instanceof SQLiteFullException)) {
            try {
                this.f35125s.mo17502kf(this.f35114bl.getId());
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
        } else {
            try {
                try {
                    this.f35125s.mo17519a(this.f35114bl.getId(), this.f35114bl.getCurBytes());
                } catch (SQLiteException e2) {
                    e2.printStackTrace();
                }
            } catch (SQLiteException unused) {
                this.f35125s.mo17502kf(this.f35114bl.getId());
            }
        }
        BaseException m17728bl = m17728bl(baseException);
        this.f35114bl.setFailedException(m17728bl);
        m17721ok(m17728bl instanceof C12529n ? -2 : -1, m17728bl);
        if (C12534ok.m17599ok(this.f35114bl.getId()).m17593ok("retry_schedule", 0) > 0) {
            C12565td.m17403ok().m17393ok(this.f35114bl);
        }
    }

    /* renamed from: ok */
    public boolean m17719ok(long j) {
        this.f35117j.addAndGet(j);
        this.f35114bl.increaseCurBytes(j);
        long uptimeMillis = SystemClock.uptimeMillis();
        return m17717ok(uptimeMillis, m17734a(uptimeMillis));
    }

    /* renamed from: a */
    private boolean m17734a(long j) {
        boolean z = true;
        if (!this.f35128z) {
            this.f35128z = true;
            return true;
        }
        long j2 = j - this.f35123r;
        if (this.f35117j.get() < this.f35126t && j2 < this.f35124rh) {
            z = false;
        }
        if (z) {
            this.f35123r = j;
            this.f35117j.set(0L);
        }
        return z;
    }

    /* renamed from: ok */
    public void m17713ok(BaseException baseException, boolean z) {
        this.f35114bl.setFirstDownload(false);
        this.f35117j.set(0L);
        m17731a(baseException, z);
    }

    /* renamed from: ok */
    public void m17712ok(C12598a c12598a, BaseException baseException, boolean z) {
        this.f35114bl.setFirstDownload(false);
        this.f35117j.set(0L);
        this.f35125s.mo17483p(this.f35114bl.getId());
        m17720ok(z ? 10 : 9, baseException, true);
    }

    /* renamed from: a */
    private void m17731a(BaseException baseException, boolean z) {
        this.f35125s.mo17483p(this.f35114bl.getId());
        m17721ok(z ? 7 : 5, baseException);
    }

    /* renamed from: ok */
    public void m17714ok(BaseException baseException) {
        this.f35114bl.setFirstDownload(false);
        m17732a(baseException);
    }

    /* renamed from: ok */
    public void m17711ok(String str) throws BaseException {
        String str2 = f35112ok;
        C12409ok.m17904a(str2, "onCompleteForFileExist existTargetFileName is " + str + " but curName is " + this.f35114bl.getName());
        if (this.f35113a) {
            C12713kf.m16561ok(this.f35114bl, str);
            m17706z();
            this.f35114bl.setSuccessByCache(true);
            m17721ok(-3, (BaseException) null);
            this.f35125s.mo17488ok(this.f35114bl);
            return;
        }
        this.f35125s.mo17488ok(this.f35114bl);
        C12713kf.m16561ok(this.f35114bl, str);
        this.f35114bl.setSuccessByCache(true);
        m17706z();
        m17721ok(-3, (BaseException) null);
    }

    /* renamed from: ok */
    private boolean m17717ok(long j, boolean z) {
        boolean z2 = false;
        if (this.f35114bl.getCurBytes() == this.f35114bl.getTotalBytes()) {
            try {
                this.f35125s.mo17494ok(this.f35114bl.getId(), this.f35114bl.getCurBytes());
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
        if (this.f35118k) {
            this.f35118k = false;
            this.f35114bl.setStatus(4);
        }
        if (this.f35114bl.isNeedPostProgress() && z) {
            z2 = true;
        }
        m17720ok(4, (BaseException) null, z2);
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ok */
    public void m17721ok(int i, BaseException baseException) {
        m17720ok(i, baseException, true);
    }

    /* renamed from: ok */
    private void m17720ok(int i, BaseException baseException, boolean z) {
        SparseArray<IDownloadListener> sparseArray;
        SparseArray<IDownloadListener> sparseArray2;
        int status = this.f35114bl.getStatus();
        if (status == -3 && i == 4) {
            return;
        }
        m17725k();
        if (i != 4 && DownloadStatus.isRealTimeUploadStatus(i)) {
            this.f35114bl.updateRealDownloadTime(false);
            if (DownloadStatus.isTimeUploadStatus(i)) {
                this.f35114bl.updateDownloadTime();
            }
        }
        if (!this.f35114bl.isAddListenerToSameTask()) {
            C12723ok.m16488ok(this.f35119kf, baseException, i);
        }
        if (i == 6) {
            this.f35114bl.setStatus(2);
        } else if (i == -6) {
            this.f35114bl.setStatus(-3);
        } else {
            this.f35114bl.setStatus(i);
        }
        if (status == -3 || status == -1) {
            if (this.f35114bl.getRetryDelayStatus() == EnumC12413h.DELAY_RETRY_DOWNLOADING) {
                this.f35114bl.setRetryDelayStatus(EnumC12413h.DELAY_RETRY_DOWNLOADED);
            }
            if (this.f35114bl.getAsyncHandleStatus() == EnumC12416ok.ASYNC_HANDLE_DOWNLOADING) {
                this.f35114bl.setAsyncHandleStatus(EnumC12416ok.ASYNC_HANDLE_DOWNLOADED);
            }
            if (this.f35114bl.getByteInvalidRetryStatus() == EnumC12411a.BYTE_INVALID_RETRY_STATUS_DOWNLOADING) {
                this.f35114bl.setByteInvalidRetryStatus(EnumC12411a.BYTE_INVALID_RETRY_STATUS_DOWNLOADED);
            }
        }
        C12667bl.m16732ok(i, this.f35121p, true, this.f35114bl, baseException);
        if (i == -4) {
            return;
        }
        if (z && this.f35120n != null && (((sparseArray = this.f35115h) != null && sparseArray.size() > 0) || ((sparseArray2 = this.f35122q) != null && sparseArray2.size() > 0 && (this.f35114bl.canShowNotification() || this.f35114bl.isAutoInstallWithoutNotification())))) {
            this.f35120n.obtainMessage(i, this.f35114bl.getId(), this.f35119kf.getHashCodeForSameTask(), baseException).sendToTarget();
            return;
        }
        AbstractC12547ok m17820fb = C12490bl.m17820fb();
        if (m17820fb != null) {
            m17820fb.m17556ok(this.f35114bl.getId(), this.f35119kf.getHashCodeForSameTask(), i);
        }
    }
}
