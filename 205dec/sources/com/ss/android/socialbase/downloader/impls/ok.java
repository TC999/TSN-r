package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.constants.EnqueueType;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.p.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class ok implements p.ok {

    /* renamed from: a  reason: collision with root package name */
    private final SparseArray<DownloadTask> f49760a = new SparseArray<>();
    private final SparseArray<DownloadTask> bl = new SparseArray<>();

    /* renamed from: s  reason: collision with root package name */
    private final SparseArray<DownloadTask> f49767s = new SparseArray<>();

    /* renamed from: n  reason: collision with root package name */
    private final SparseArray<DownloadTask> f49763n = new SparseArray<>();
    private final SparseArray<DownloadTask> kf = new SparseArray<>();

    /* renamed from: h  reason: collision with root package name */
    private final SparseArray<SparseArray<DownloadTask>> f49761h = new SparseArray<>();

    /* renamed from: p  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.q.p<Integer, DownloadTask> f49764p = new com.ss.android.socialbase.downloader.q.p<>();

    /* renamed from: q  reason: collision with root package name */
    private final SparseArray<Long> f49765q = new SparseArray<>();

    /* renamed from: k  reason: collision with root package name */
    private final LinkedBlockingDeque<DownloadTask> f49762k = new LinkedBlockingDeque<>();
    protected final com.ss.android.socialbase.downloader.p.p ok = new com.ss.android.socialbase.downloader.p.p(Looper.getMainLooper(), this);

    /* renamed from: r  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.k f49766r = com.ss.android.socialbase.downloader.downloader.bl.m();

    private void bl(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.f49762k.isEmpty()) {
                ok(downloadTask, true);
                this.f49762k.put(downloadTask);
            } else if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.f49762k.getFirst().getDownloadId() == downloadTask.getDownloadId() && ok(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.f49762k.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    DownloadTask next = it.next();
                    if (next != null && next.getDownloadId() == downloadTask.getDownloadId()) {
                        it.remove();
                        break;
                    }
                }
                this.f49762k.put(downloadTask);
                new com.ss.android.socialbase.downloader.downloader.kf(downloadTask, this.ok).ok();
            } else {
                DownloadTask first = this.f49762k.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && ok(downloadTask.getDownloadId())) {
                    return;
                }
                n(first.getDownloadId());
                ok(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.f49762k.putFirst(downloadTask);
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    private void i(int i4) {
        DownloadTask first;
        if (this.f49762k.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.f49762k.getFirst();
        if (first2 != null && first2.getDownloadId() == i4) {
            this.f49762k.poll();
        }
        if (this.f49762k.isEmpty() || (first = this.f49762k.getFirst()) == null) {
            return;
        }
        ok(first, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask t(int i4) {
        DownloadTask downloadTask = this.f49760a.get(i4);
        if (downloadTask == null) {
            DownloadTask downloadTask2 = this.f49767s.get(i4);
            if (downloadTask2 == null) {
                DownloadTask downloadTask3 = this.bl.get(i4);
                if (downloadTask3 == null) {
                    DownloadTask downloadTask4 = this.f49763n.get(i4);
                    return downloadTask4 == null ? this.kf.get(i4) : downloadTask4;
                }
                return downloadTask3;
            }
            return downloadTask2;
        }
        return downloadTask;
    }

    protected abstract void a(int i4);

    protected abstract com.ss.android.socialbase.downloader.p.bl bl(int i4);

    public synchronized boolean h(int i4) {
        DownloadTask downloadTask = this.f49767s.get(i4);
        if (downloadTask == null) {
            downloadTask = this.f49763n.get(i4);
        }
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            ok(downloadTask);
            return true;
        }
        return false;
    }

    public synchronized boolean j(int i4) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.kf.get(i4);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            ok(downloadTask);
        }
        return true;
    }

    public synchronized IDownloadFileUriProvider k(int i4) {
        DownloadTask downloadTask = this.f49760a.get(i4);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.bl.get(i4);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.f49767s.get(i4);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.f49763n.get(i4);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.kf.get(i4);
        if (downloadTask5 != null) {
            return downloadTask5.getFileUriProvider();
        }
        return null;
    }

    public synchronized boolean kf(int i4) {
        DownloadTask downloadTask = this.f49760a.get(i4);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            ok(downloadTask);
        } else {
            h(i4);
        }
        return true;
    }

    public synchronized boolean n(int i4) {
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "pause id=" + i4);
        DownloadInfo a4 = this.f49766r.a(i4);
        if (a4 == null || a4.getStatus() != 11) {
            synchronized (this.f49760a) {
                a(i4);
            }
            if (a4 == null) {
                DownloadTask downloadTask = this.f49760a.get(i4);
                if (downloadTask != null) {
                    new com.ss.android.socialbase.downloader.downloader.kf(downloadTask, this.ok).s();
                    return true;
                }
            } else {
                ok(a4);
                if (a4.getStatus() == 1) {
                    DownloadTask downloadTask2 = this.f49760a.get(i4);
                    if (downloadTask2 != null) {
                        new com.ss.android.socialbase.downloader.downloader.kf(downloadTask2, this.ok).s();
                        return true;
                    }
                } else if (DownloadStatus.isDownloading(a4.getStatus())) {
                    a4.setStatus(-2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    protected abstract List<Integer> ok();

    public abstract void ok(int i4, long j4);

    protected abstract void ok(int i4, DownloadTask downloadTask);

    public abstract void ok(com.ss.android.socialbase.downloader.p.bl blVar);

    public abstract boolean ok(int i4);

    public synchronized v p(int i4) {
        DownloadTask downloadTask = this.f49760a.get(i4);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.bl.get(i4);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.f49767s.get(i4);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.f49763n.get(i4);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.kf.get(i4);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationClickCallback();
        }
        return null;
    }

    public synchronized ep q(int i4) {
        DownloadTask downloadTask = this.f49760a.get(i4);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.bl.get(i4);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.f49767s.get(i4);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.f49763n.get(i4);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.kf.get(i4);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationEventListener();
        }
        return null;
    }

    public synchronized boolean r(int i4) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f49763n.get(i4);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                ok(downloadTask, false);
            }
            return true;
        }
        DownloadInfo a4 = this.f49766r.a(i4);
        if (a4 != null && a4.canStartRetryDelayTask()) {
            ok(new DownloadTask(a4), false);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r1.f49767s.get(r2) != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean rh(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L18
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f49760a     // Catch: java.lang.Throwable -> L15
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r0 != 0) goto L13
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f49767s     // Catch: java.lang.Throwable -> L15
            java.lang.Object r2 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r2 == 0) goto L18
        L13:
            r2 = 1
            goto L19
        L15:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L18:
            r2 = 0
        L19:
            monitor-exit(r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.ok.rh(int):boolean");
    }

    public synchronized DownloadInfo s(int i4) {
        DownloadInfo a4;
        DownloadTask downloadTask;
        a4 = this.f49766r.a(i4);
        if (a4 == null && (downloadTask = this.f49760a.get(i4)) != null) {
            a4 = downloadTask.getDownloadInfo();
        }
        return a4;
    }

    public synchronized void z(int i4) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f49760a.get(i4);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            ok(downloadTask);
        }
    }

    private void a(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f49761h.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f49761h.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void ok(DownloadTask downloadTask, boolean z3) {
        DownloadInfo downloadInfo;
        int i4;
        DownloadInfo downloadInfo2;
        DownloadTask remove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            y monitorDepend = downloadTask.getMonitorDepend();
            com.ss.android.socialbase.downloader.s.ok.ok(monitorDepend, downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z4 = false;
        if (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).ok("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.q.kf.bl(com.ss.android.socialbase.downloader.downloader.bl.l()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.kf(downloadTask, this.ok).ok(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z3) {
            ok(downloadInfo);
        }
        if (this.f49767s.get(id) != null) {
            this.f49767s.remove(id);
        }
        if (this.bl.get(id) != null) {
            this.bl.remove(id);
        }
        if (this.f49763n.get(id) != null) {
            this.f49763n.remove(id);
        }
        if (this.kf.get(id) != null) {
            this.kf.remove(id);
        }
        if (ok(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.s.ok.ok(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "no downloading task :" + id);
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.ok.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.q.ok.ok(32768) && (remove = this.f49764p.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.f49760a.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            i4 = 0;
        } else {
            i4 = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(i4)) {
                z4 = true;
            }
        }
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "can add listener " + z4 + " , oldTaskStatus is :" + i4);
        if (z4) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        a(downloadTask);
        this.f49760a.put(id, downloadTask);
        this.f49765q.put(id, Long.valueOf(uptimeMillis));
        ok(id, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void s(int i4, boolean z3) {
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i4 + " deleteTargetFile=" + z3);
        DownloadInfo a4 = this.f49766r.a(i4);
        if (a4 != null) {
            if (z3) {
                com.ss.android.socialbase.downloader.q.kf.ok(a4);
            } else {
                com.ss.android.socialbase.downloader.q.kf.bl(a4.getTempPath(), a4.getTempName());
            }
            a4.erase();
        }
        try {
            this.f49766r.kf(i4);
        } catch (SQLiteException e4) {
            e4.printStackTrace();
        }
        ok(i4, 0, -4);
        if (this.f49767s.get(i4) != null) {
            this.f49767s.remove(i4);
        }
        if (this.bl.get(i4) != null) {
            this.bl.remove(i4);
        }
        this.f49764p.remove(Integer.valueOf(i4));
        com.ss.android.socialbase.downloader.h.ok.a(i4);
    }

    public synchronized void a(List<String> list) {
        DownloadInfo downloadInfo;
        try {
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.q.kf.a(com.ss.android.socialbase.downloader.downloader.bl.l())) {
            for (int i4 = 0; i4 < this.f49760a.size(); i4++) {
                DownloadTask downloadTask = this.f49760a.get(this.f49760a.keyAt(i4));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && a(downloadInfo)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    ok(downloadTask);
                    downloadInfo.setDownloadFromReserveWifi(true);
                    com.ss.android.socialbase.downloader.downloader.td reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).getReserveWifiStatusListener();
                    if (reserveWifiStatusListener != null) {
                        reserveWifiStatusListener.ok(downloadInfo, 5, 2);
                    }
                }
            }
        }
    }

    public void bl(final int i4, final boolean z3) {
        DownloadInfo a4 = this.f49766r.a(i4);
        if (a4 != null) {
            ok(a4);
        }
        this.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.a.ok().kf(i4);
            }
        });
        com.ss.android.socialbase.downloader.downloader.bl.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.5
            @Override // java.lang.Runnable
            public void run() {
                ok.this.bl(i4);
                ok.this.n(i4, z3);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(int i4, boolean z3) {
        try {
            DownloadInfo a4 = this.f49766r.a(i4);
            if (a4 != null) {
                com.ss.android.socialbase.downloader.q.kf.ok(a4, z3);
                a4.erase();
            }
            try {
                this.f49766r.s(i4);
                this.f49766r.ok(a4);
            } catch (SQLiteException e4) {
                e4.printStackTrace();
            }
            if (this.f49767s.get(i4) != null) {
                this.f49767s.remove(i4);
            }
            if (this.bl.get(i4) != null) {
                this.bl.remove(i4);
            }
            this.f49764p.remove(Integer.valueOf(i4));
            com.ss.android.socialbase.downloader.h.ok.a(i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean a(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void a() {
        List<Integer> ok = ok();
        if (ok == null) {
            return;
        }
        for (Integer num : ok) {
            n(num.intValue());
        }
    }

    public void a(final int i4, final boolean z3) {
        DownloadInfo a4 = this.f49766r.a(i4);
        if (a4 != null) {
            ok(a4);
        }
        this.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.a.ok().kf(i4);
            }
        });
        com.ss.android.socialbase.downloader.downloader.bl.ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask t3;
                if (ok.this.bl(i4) == null && (t3 = ok.this.t(i4)) != null) {
                    DownloadInfo downloadInfo = t3.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = t3.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i5 = 0; i5 < downloadListeners.size(); i5++) {
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i5));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
                ok.this.s(i4, z3);
            }
        }, false);
    }

    public synchronized void a(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3) {
        ok(i4, i5, iDownloadListener, kfVar, z3, true);
    }

    public List<DownloadInfo> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : ok()) {
            DownloadInfo s3 = s(num.intValue());
            if (s3 != null && str.equals(s3.getMimeType())) {
                arrayList.add(s3);
            }
        }
        return arrayList;
    }

    public synchronized void ok(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            bl(downloadTask);
        } else {
            ok(downloadTask, true);
        }
    }

    public void a(int i4, long j4) {
        DownloadInfo a4 = this.f49766r.a(i4);
        if (a4 != null) {
            a4.setThrottleNetSpeed(j4);
        }
        ok(i4, j4);
    }

    public synchronized List<DownloadInfo> ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> ok = this.f49766r.ok(str);
        if (ok == null || ok.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = this.f49760a.size();
            for (int i4 = 0; i4 < size; i4++) {
                DownloadTask valueAt = this.f49760a.valueAt(i4);
                if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                    arrayList.add(valueAt.getDownloadInfo());
                }
            }
            return arrayList;
        }
        return ok;
    }

    public synchronized boolean ok(int i4, boolean z3) {
        DownloadTask downloadTask = this.f49760a.get(i4);
        if (downloadTask == null && com.ss.android.socialbase.downloader.q.ok.ok(65536)) {
            downloadTask = t(i4);
        }
        if (downloadTask != null) {
            if (!com.ss.android.socialbase.downloader.h.ok.ok(i4).a("fix_on_cancel_call_twice", true)) {
                new com.ss.android.socialbase.downloader.downloader.kf(downloadTask, this.ok).bl();
            }
            final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION);
            this.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.1
                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = downloadListeners;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i5 = 0; i5 < downloadListeners.size(); i5++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i5));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                    DownloadInfo downloadInfo2 = downloadInfo;
                    if (downloadInfo2 == null || !downloadInfo2.canShowNotification() || (sparseArray = downloadListeners2) == null) {
                        return;
                    }
                    synchronized (sparseArray) {
                        for (int i6 = 0; i6 < downloadListeners2.size(); i6++) {
                            IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i6));
                            if (iDownloadListener2 != null) {
                                iDownloadListener2.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo a4 = this.f49766r.a(i4);
        if (com.ss.android.socialbase.downloader.q.ok.ok(65536)) {
            if (a4 != null) {
                a4.setStatus(-4);
            }
        } else if (a4 != null && DownloadStatus.isDownloading(a4.getStatus())) {
            a4.setStatus(-4);
        }
        a(i4, z3);
        return true;
    }

    private void ok(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.h.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void ok(int i4, ep epVar) {
        DownloadTask downloadTask = this.f49760a.get(i4);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(epVar);
        }
    }

    public synchronized void ok(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean a4 = com.ss.android.socialbase.downloader.q.ok.ok(1048576) ? com.ss.android.socialbase.downloader.q.kf.a(com.ss.android.socialbase.downloader.downloader.bl.l()) : true;
            for (int i4 = 0; i4 < this.f49767s.size(); i4++) {
                DownloadTask downloadTask = this.f49767s.get(this.f49767s.keyAt(i4));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || a4)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    ok(downloadTask);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public synchronized void ok(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3) {
        DownloadTask t3 = t(i4);
        if (t3 == null) {
            t3 = this.f49764p.get(Integer.valueOf(i4));
        }
        if (t3 != null) {
            t3.removeDownloadListener(i5, iDownloadListener, kfVar, z3);
        }
    }

    public synchronized void ok(int i4, int i5, final IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3, boolean z4) {
        DownloadInfo a4;
        DownloadTask t3 = t(i4);
        if (t3 != null) {
            t3.addDownloadListener(i5, iDownloadListener, kfVar, z3);
            final DownloadInfo downloadInfo = t3.getDownloadInfo();
            if (z4 && downloadInfo != null && !ok(i4) && (kfVar == com.ss.android.socialbase.downloader.constants.kf.MAIN || kfVar == com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION)) {
                boolean z5 = true;
                if (kfVar == com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION && !downloadInfo.canShowNotification()) {
                    z5 = false;
                }
                if (z5) {
                    this.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (iDownloadListener != null) {
                                if (downloadInfo.getStatus() == -3) {
                                    iDownloadListener.onSuccessed(downloadInfo);
                                } else if (downloadInfo.getStatus() == -1) {
                                    iDownloadListener.onFailed(downloadInfo, new BaseException(1000, "try add listener for failed task"));
                                }
                            }
                        }
                    });
                }
            }
        } else if (com.ss.android.socialbase.downloader.q.ok.ok(32768) && (a4 = this.f49766r.a(i4)) != null && a4.getStatus() != -3) {
            DownloadTask downloadTask = this.f49764p.get(Integer.valueOf(i4));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(a4);
                this.f49764p.put(Integer.valueOf(i4), downloadTask);
            }
            downloadTask.addDownloadListener(i5, iDownloadListener, kfVar, z3);
        }
    }

    private void ok(int i4, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION);
            boolean z3 = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.q.bl.ok(i4, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.q.bl.ok(i4, downloadListeners2, z3, downloadInfo, baseException);
        }
    }

    private void ok(int i4, int i5) {
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "removeTask id: " + i4 + " listener hasCode: " + i5);
        if (i5 == 0) {
            this.f49760a.remove(i4);
            this.f49761h.remove(i4);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f49761h.get(i4);
        if (sparseArray != null) {
            sparseArray.remove(i5);
            com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.f49760a.remove(i4);
                this.f49761h.remove(i4);
                return;
            }
            return;
        }
        this.f49760a.remove(i4);
    }

    public synchronized void ok(int i4, int i5, int i6) {
        if (i6 != -7) {
            if (i6 == -6) {
                this.bl.put(i4, this.f49760a.get(i4));
                ok(i4, i5);
            } else if (i6 == -4) {
                ok(i4, i5);
                i(i4);
            } else if (i6 == -3) {
                this.bl.put(i4, this.f49760a.get(i4));
                ok(i4, i5);
                i(i4);
            } else if (i6 != -1) {
                if (i6 == 7) {
                    DownloadTask downloadTask = this.f49760a.get(i4);
                    if (downloadTask != null) {
                        if (this.f49763n.get(i4) == null) {
                            this.f49763n.put(i4, downloadTask);
                        }
                        ok(i4, i5);
                    }
                    i(i4);
                } else if (i6 == 8) {
                    DownloadTask downloadTask2 = this.f49760a.get(i4);
                    if (downloadTask2 != null && this.kf.get(i4) == null) {
                        this.kf.put(i4, downloadTask2);
                    }
                    i(i4);
                }
            }
        }
        DownloadTask downloadTask3 = this.f49760a.get(i4);
        if (downloadTask3 != null) {
            if (this.f49767s.get(i4) == null) {
                this.f49767s.put(i4, downloadTask3);
            }
            ok(i4, i5);
        }
        i(i4);
    }

    @Override // com.ss.android.socialbase.downloader.p.p.ok
    public void ok(Message message) {
        int i4 = message.arg1;
        int i5 = message.arg2;
        com.ss.android.socialbase.downloader.bl.ok.a("AbsDownloadEngine", "handleMsg id: " + i4 + " listener hasCode: " + i5);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            if (i5 == 0) {
                downloadTask = this.f49760a.get(i4);
            } else {
                SparseArray<DownloadTask> sparseArray = this.f49761h.get(i4);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i5);
                }
            }
            if (downloadTask == null) {
                return;
            }
            ok(message.what, baseException, downloadTask);
            ok(i4, i5, message.what);
        }
    }
}
