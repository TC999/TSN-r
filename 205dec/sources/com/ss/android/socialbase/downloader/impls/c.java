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
import com.ss.android.socialbase.downloader.depend.ls;
import com.ss.android.socialbase.downloader.depend.me;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.ev.ev;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class c implements ev.c {

    /* renamed from: w  reason: collision with root package name */
    private final SparseArray<DownloadTask> f49733w = new SparseArray<>();
    private final SparseArray<DownloadTask> xv = new SparseArray<>();
    private final SparseArray<DownloadTask> sr = new SparseArray<>();
    private final SparseArray<DownloadTask> ux = new SparseArray<>();

    /* renamed from: f  reason: collision with root package name */
    private final SparseArray<DownloadTask> f49729f = new SparseArray<>();

    /* renamed from: r  reason: collision with root package name */
    private final SparseArray<SparseArray<DownloadTask>> f49732r = new SparseArray<>();
    private final com.ss.android.socialbase.downloader.gd.ev<Integer, DownloadTask> ev = new com.ss.android.socialbase.downloader.gd.ev<>();
    private final SparseArray<Long> gd = new SparseArray<>();

    /* renamed from: p  reason: collision with root package name */
    private final LinkedBlockingDeque<DownloadTask> f49731p = new LinkedBlockingDeque<>();

    /* renamed from: c  reason: collision with root package name */
    protected final com.ss.android.socialbase.downloader.ev.ev f49728c = new com.ss.android.socialbase.downloader.ev.ev(Looper.getMainLooper(), this);

    /* renamed from: k  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.p f49730k = com.ss.android.socialbase.downloader.downloader.xv.gb();

    private void fp(int i4) {
        DownloadTask first;
        if (this.f49731p.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.f49731p.getFirst();
        if (first2 != null && first2.getDownloadId() == i4) {
            this.f49731p.poll();
        }
        if (this.f49731p.isEmpty() || (first = this.f49731p.getFirst()) == null) {
            return;
        }
        c(first, true);
    }

    private void xv(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.f49731p.isEmpty()) {
                c(downloadTask, true);
                this.f49731p.put(downloadTask);
            } else if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.f49731p.getFirst().getDownloadId() == downloadTask.getDownloadId() && c(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.f49731p.iterator();
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
                this.f49731p.put(downloadTask);
                new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f49728c).c();
            } else {
                DownloadTask first = this.f49731p.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && c(downloadTask.getDownloadId())) {
                    return;
                }
                ux(first.getDownloadId());
                c(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.f49731p.putFirst(downloadTask);
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public DownloadTask ys(int i4) {
        DownloadTask downloadTask = this.f49733w.get(i4);
        if (downloadTask == null) {
            DownloadTask downloadTask2 = this.sr.get(i4);
            if (downloadTask2 == null) {
                DownloadTask downloadTask3 = this.xv.get(i4);
                if (downloadTask3 == null) {
                    DownloadTask downloadTask4 = this.ux.get(i4);
                    return downloadTask4 == null ? this.f49729f.get(i4) : downloadTask4;
                }
                return downloadTask3;
            }
            return downloadTask2;
        }
        return downloadTask;
    }

    public synchronized boolean a(int i4) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f49729f.get(i4);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            c(downloadTask);
        }
        return true;
    }

    public synchronized void bk(int i4) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f49733w.get(i4);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            c(downloadTask);
        }
    }

    protected abstract List<Integer> c();

    public abstract void c(int i4, long j4);

    protected abstract void c(int i4, DownloadTask downloadTask);

    public abstract void c(com.ss.android.socialbase.downloader.ev.xv xvVar);

    public abstract boolean c(int i4);

    public synchronized me ev(int i4) {
        DownloadTask downloadTask = this.f49733w.get(i4);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.xv.get(i4);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.sr.get(i4);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.ux.get(i4);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.f49729f.get(i4);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationClickCallback();
        }
        return null;
    }

    public synchronized boolean f(int i4) {
        DownloadTask downloadTask = this.f49733w.get(i4);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            c(downloadTask);
        } else {
            r(i4);
        }
        return true;
    }

    public synchronized com.ss.android.socialbase.downloader.depend.n gd(int i4) {
        DownloadTask downloadTask = this.f49733w.get(i4);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.xv.get(i4);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.sr.get(i4);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.ux.get(i4);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.f49729f.get(i4);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationEventListener();
        }
        return null;
    }

    public synchronized boolean k(int i4) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.ux.get(i4);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                c(downloadTask, false);
            }
            return true;
        }
        DownloadInfo w3 = this.f49730k.w(i4);
        if (w3 != null && w3.canStartRetryDelayTask()) {
            c(new DownloadTask(w3), false);
        }
        return false;
    }

    public synchronized IDownloadFileUriProvider p(int i4) {
        DownloadTask downloadTask = this.f49733w.get(i4);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.xv.get(i4);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.sr.get(i4);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.ux.get(i4);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.f49729f.get(i4);
        if (downloadTask5 != null) {
            return downloadTask5.getFileUriProvider();
        }
        return null;
    }

    public synchronized boolean r(int i4) {
        DownloadTask downloadTask = this.sr.get(i4);
        if (downloadTask == null) {
            downloadTask = this.ux.get(i4);
        }
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            c(downloadTask);
            return true;
        }
        return false;
    }

    public synchronized DownloadInfo sr(int i4) {
        DownloadInfo w3;
        DownloadTask downloadTask;
        w3 = this.f49730k.w(i4);
        if (w3 == null && (downloadTask = this.f49733w.get(i4)) != null) {
            w3 = downloadTask.getDownloadInfo();
        }
        return w3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r1.sr.get(r2) != null) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean t(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L18
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f49733w     // Catch: java.lang.Throwable -> L15
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r0 != 0) goto L13
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.sr     // Catch: java.lang.Throwable -> L15
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.impls.c.t(int):boolean");
    }

    public synchronized boolean ux(int i4) {
        com.ss.android.socialbase.downloader.xv.c.w("AbsDownloadEngine", "pause id=" + i4);
        DownloadInfo w3 = this.f49730k.w(i4);
        if (w3 == null || w3.getStatus() != 11) {
            synchronized (this.f49733w) {
                w(i4);
            }
            if (w3 == null) {
                DownloadTask downloadTask = this.f49733w.get(i4);
                if (downloadTask != null) {
                    new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f49728c).sr();
                    return true;
                }
            } else {
                c(w3);
                if (w3.getStatus() == 1) {
                    DownloadTask downloadTask2 = this.f49733w.get(i4);
                    if (downloadTask2 != null) {
                        new com.ss.android.socialbase.downloader.downloader.f(downloadTask2, this.f49728c).sr();
                        return true;
                    }
                } else if (DownloadStatus.isDownloading(w3.getStatus())) {
                    w3.setStatus(-2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    protected abstract void w(int i4);

    protected abstract com.ss.android.socialbase.downloader.ev.xv xv(int i4);

    private void w(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f49732r.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f49732r.put(downloadTask.getDownloadId(), sparseArray);
        }
        com.ss.android.socialbase.downloader.xv.c.w("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    private void c(DownloadTask downloadTask, boolean z3) {
        DownloadInfo downloadInfo;
        int i4;
        DownloadInfo downloadInfo2;
        DownloadTask remove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            ls monitorDepend = downloadTask.getMonitorDepend();
            com.ss.android.socialbase.downloader.sr.c.c(monitorDepend, downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z4 = false;
        if (com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).c("no_net_opt", 0) == 1 && !com.ss.android.socialbase.downloader.gd.f.xv(com.ss.android.socialbase.downloader.downloader.xv.gw()) && !downloadInfo.isFirstDownload()) {
            new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f49728c).c(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z3) {
            c(downloadInfo);
        }
        if (this.sr.get(id) != null) {
            this.sr.remove(id);
        }
        if (this.xv.get(id) != null) {
            this.xv.remove(id);
        }
        if (this.ux.get(id) != null) {
            this.ux.remove(id);
        }
        if (this.f49729f.get(id) != null) {
            this.f49729f.remove(id);
        }
        if (c(id) && !downloadInfo.canReStartAsyncTask()) {
            com.ss.android.socialbase.downloader.xv.c.w("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            com.ss.android.socialbase.downloader.sr.c.c(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        com.ss.android.socialbase.downloader.xv.c.w("AbsDownloadEngine", "no downloading task :" + id);
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(com.ss.android.socialbase.downloader.constants.c.ASYNC_HANDLE_RESTART);
        }
        if (com.ss.android.socialbase.downloader.gd.c.c(32768) && (remove = this.ev.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.f49733w.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            i4 = 0;
        } else {
            i4 = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(i4)) {
                z4 = true;
            }
        }
        com.ss.android.socialbase.downloader.xv.c.w("AbsDownloadEngine", "can add listener " + z4 + " , oldTaskStatus is :" + i4);
        if (z4) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        w(downloadTask);
        this.f49733w.put(id, downloadTask);
        this.gd.put(id, Long.valueOf(uptimeMillis));
        c(id, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void sr(int i4, boolean z3) {
        com.ss.android.socialbase.downloader.xv.c.w("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i4 + " deleteTargetFile=" + z3);
        DownloadInfo w3 = this.f49730k.w(i4);
        if (w3 != null) {
            if (z3) {
                com.ss.android.socialbase.downloader.gd.f.c(w3);
            } else {
                com.ss.android.socialbase.downloader.gd.f.xv(w3.getTempPath(), w3.getTempName());
            }
            w3.erase();
        }
        try {
            this.f49730k.f(i4);
        } catch (SQLiteException e4) {
            e4.printStackTrace();
        }
        c(i4, 0, -4);
        if (this.sr.get(i4) != null) {
            this.sr.remove(i4);
        }
        if (this.xv.get(i4) != null) {
            this.xv.remove(i4);
        }
        this.ev.remove(Integer.valueOf(i4));
        com.ss.android.socialbase.downloader.r.c.w(i4);
    }

    public synchronized void w(List<String> list) {
        DownloadInfo downloadInfo;
        try {
        } catch (Exception e4) {
            e4.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.gd.f.w(com.ss.android.socialbase.downloader.downloader.xv.gw())) {
            for (int i4 = 0; i4 < this.f49733w.size(); i4++) {
                DownloadTask downloadTask = this.f49733w.get(this.f49733w.keyAt(i4));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && w(downloadInfo)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    c(downloadTask);
                    downloadInfo.setDownloadFromReserveWifi(true);
                    com.ss.android.socialbase.downloader.downloader.s reserveWifiStatusListener = Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).getReserveWifiStatusListener();
                    if (reserveWifiStatusListener != null) {
                        reserveWifiStatusListener.c(downloadInfo, 5, 2);
                    }
                }
            }
        }
    }

    public void xv(final int i4, final boolean z3) {
        DownloadInfo w3 = this.f49730k.w(i4);
        if (w3 != null) {
            c(w3);
        }
        this.f49728c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.c.4
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.w.c().f(i4);
            }
        });
        com.ss.android.socialbase.downloader.downloader.xv.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.c.5
            @Override // java.lang.Runnable
            public void run() {
                c.this.xv(i4);
                c.this.ux(i4, z3);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ux(int i4, boolean z3) {
        try {
            DownloadInfo w3 = this.f49730k.w(i4);
            if (w3 != null) {
                com.ss.android.socialbase.downloader.gd.f.c(w3, z3);
                w3.erase();
            }
            try {
                this.f49730k.sr(i4);
                this.f49730k.c(w3);
            } catch (SQLiteException e4) {
                e4.printStackTrace();
            }
            if (this.sr.get(i4) != null) {
                this.sr.remove(i4);
            }
            if (this.xv.get(i4) != null) {
                this.xv.remove(i4);
            }
            this.ev.remove(Integer.valueOf(i4));
            com.ss.android.socialbase.downloader.r.c.w(i4);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private boolean w(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    public void w() {
        List<Integer> c4 = c();
        if (c4 == null) {
            return;
        }
        for (Integer num : c4) {
            ux(num.intValue());
        }
    }

    public void w(final int i4, final boolean z3) {
        DownloadInfo w3 = this.f49730k.w(i4);
        if (w3 != null) {
            c(w3);
        }
        this.f49728c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.ss.android.socialbase.downloader.notification.w.c().f(i4);
            }
        });
        com.ss.android.socialbase.downloader.downloader.xv.c(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.c.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask ys;
                if (c.this.xv(i4) == null && (ys = c.this.ys(i4)) != null) {
                    DownloadInfo downloadInfo = ys.getDownloadInfo();
                    SparseArray downloadListeners = ys.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i5 = 0; i5 < downloadListeners.size(); i5++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i5));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
                c.this.sr(i4, z3);
            }
        }, false);
    }

    public synchronized void w(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3) {
        c(i4, i5, iDownloadListener, fVar, z3, true);
    }

    public List<DownloadInfo> w(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : c()) {
            DownloadInfo sr = sr(num.intValue());
            if (sr != null && str.equals(sr.getMimeType())) {
                arrayList.add(sr);
            }
        }
        return arrayList;
    }

    public synchronized void c(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            xv(downloadTask);
        } else {
            c(downloadTask, true);
        }
    }

    public void w(int i4, long j4) {
        DownloadInfo w3 = this.f49730k.w(i4);
        if (w3 != null) {
            w3.setThrottleNetSpeed(j4);
        }
        c(i4, j4);
    }

    public synchronized List<DownloadInfo> c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> c4 = this.f49730k.c(str);
        if (c4 == null || c4.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = this.f49733w.size();
            for (int i4 = 0; i4 < size; i4++) {
                DownloadTask valueAt = this.f49733w.valueAt(i4);
                if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                    arrayList.add(valueAt.getDownloadInfo());
                }
            }
            return arrayList;
        }
        return c4;
    }

    public synchronized boolean c(int i4, boolean z3) {
        DownloadTask downloadTask = this.f49733w.get(i4);
        if (downloadTask == null && com.ss.android.socialbase.downloader.gd.c.c(65536)) {
            downloadTask = ys(i4);
        }
        if (downloadTask != null) {
            if (!com.ss.android.socialbase.downloader.r.c.c(i4).w("fix_on_cancel_call_twice", true)) {
                new com.ss.android.socialbase.downloader.downloader.f(downloadTask, this.f49728c).xv();
            }
            final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            final SparseArray downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            final SparseArray downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            this.f49728c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.c.1
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
        DownloadInfo w3 = this.f49730k.w(i4);
        if (com.ss.android.socialbase.downloader.gd.c.c(65536)) {
            if (w3 != null) {
                w3.setStatus(-4);
            }
        } else if (w3 != null && DownloadStatus.isDownloading(w3.getStatus())) {
            w3.setStatus(-4);
        }
        w(i4, z3);
        return true;
    }

    private void c(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != com.ss.android.socialbase.downloader.constants.r.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(com.ss.android.socialbase.downloader.constants.r.DELAY_RETRY_NONE);
                    com.ss.android.socialbase.downloader.xv.c.w("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public synchronized void c(int i4, com.ss.android.socialbase.downloader.depend.n nVar) {
        DownloadTask downloadTask = this.f49733w.get(i4);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(nVar);
        }
    }

    public synchronized void c(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean w3 = com.ss.android.socialbase.downloader.gd.c.c(1048576) ? com.ss.android.socialbase.downloader.gd.f.w(com.ss.android.socialbase.downloader.downloader.xv.gw()) : true;
            for (int i4 = 0; i4 < this.sr.size(); i4++) {
                DownloadTask downloadTask = this.sr.get(this.sr.keyAt(i4));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || w3)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    c(downloadTask);
                }
            }
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public synchronized void c(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3) {
        DownloadTask ys = ys(i4);
        if (ys == null) {
            ys = this.ev.get(Integer.valueOf(i4));
        }
        if (ys != null) {
            ys.removeDownloadListener(i5, iDownloadListener, fVar, z3);
        }
    }

    public synchronized void c(int i4, int i5, final IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3, boolean z4) {
        DownloadInfo w3;
        DownloadTask ys = ys(i4);
        if (ys != null) {
            ys.addDownloadListener(i5, iDownloadListener, fVar, z3);
            final DownloadInfo downloadInfo = ys.getDownloadInfo();
            if (z4 && downloadInfo != null && !c(i4) && (fVar == com.ss.android.socialbase.downloader.constants.f.MAIN || fVar == com.ss.android.socialbase.downloader.constants.f.NOTIFICATION)) {
                boolean z5 = true;
                if (fVar == com.ss.android.socialbase.downloader.constants.f.NOTIFICATION && !downloadInfo.canShowNotification()) {
                    z5 = false;
                }
                if (z5) {
                    this.f49728c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.c.6
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
        } else if (com.ss.android.socialbase.downloader.gd.c.c(32768) && (w3 = this.f49730k.w(i4)) != null && w3.getStatus() != -3) {
            DownloadTask downloadTask = this.ev.get(Integer.valueOf(i4));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(w3);
                this.ev.put(Integer.valueOf(i4), downloadTask);
            }
            downloadTask.addDownloadListener(i5, iDownloadListener, fVar, z3);
        }
    }

    private void c(int i4, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray downloadListeners = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.MAIN);
            SparseArray downloadListeners2 = downloadTask.getDownloadListeners(com.ss.android.socialbase.downloader.constants.f.NOTIFICATION);
            boolean z3 = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            com.ss.android.socialbase.downloader.gd.xv.c(i4, downloadListeners, true, downloadInfo, baseException);
            com.ss.android.socialbase.downloader.gd.xv.c(i4, downloadListeners2, z3, downloadInfo, baseException);
        }
    }

    private void c(int i4, int i5) {
        com.ss.android.socialbase.downloader.xv.c.w("AbsDownloadEngine", "removeTask id: " + i4 + " listener hasCode: " + i5);
        if (i5 == 0) {
            this.f49733w.remove(i4);
            this.f49732r.remove(i4);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f49732r.get(i4);
        if (sparseArray != null) {
            sparseArray.remove(i5);
            com.ss.android.socialbase.downloader.xv.c.w("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.f49733w.remove(i4);
                this.f49732r.remove(i4);
                return;
            }
            return;
        }
        this.f49733w.remove(i4);
    }

    public synchronized void c(int i4, int i5, int i6) {
        if (i6 != -7) {
            if (i6 == -6) {
                this.xv.put(i4, this.f49733w.get(i4));
                c(i4, i5);
            } else if (i6 == -4) {
                c(i4, i5);
                fp(i4);
            } else if (i6 == -3) {
                this.xv.put(i4, this.f49733w.get(i4));
                c(i4, i5);
                fp(i4);
            } else if (i6 != -1) {
                if (i6 == 7) {
                    DownloadTask downloadTask = this.f49733w.get(i4);
                    if (downloadTask != null) {
                        if (this.ux.get(i4) == null) {
                            this.ux.put(i4, downloadTask);
                        }
                        c(i4, i5);
                    }
                    fp(i4);
                } else if (i6 == 8) {
                    DownloadTask downloadTask2 = this.f49733w.get(i4);
                    if (downloadTask2 != null && this.f49729f.get(i4) == null) {
                        this.f49729f.put(i4, downloadTask2);
                    }
                    fp(i4);
                }
            }
        }
        DownloadTask downloadTask3 = this.f49733w.get(i4);
        if (downloadTask3 != null) {
            if (this.sr.get(i4) == null) {
                this.sr.put(i4, downloadTask3);
            }
            c(i4, i5);
        }
        fp(i4);
    }

    @Override // com.ss.android.socialbase.downloader.ev.ev.c
    public void c(Message message) {
        int i4 = message.arg1;
        int i5 = message.arg2;
        com.ss.android.socialbase.downloader.xv.c.w("AbsDownloadEngine", "handleMsg id: " + i4 + " listener hasCode: " + i5);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            if (i5 == 0) {
                downloadTask = this.f49733w.get(i4);
            } else {
                SparseArray<DownloadTask> sparseArray = this.f49732r.get(i4);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i5);
                }
            }
            if (downloadTask == null) {
                return;
            }
            c(message.what, baseException, downloadTask);
            c(i4, i5, message.what);
        }
    }
}
