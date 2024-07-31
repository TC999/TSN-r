package com.p521ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.constants.DownloadStatus;
import com.p521ss.android.socialbase.downloader.constants.EnqueueType;
import com.p521ss.android.socialbase.downloader.constants.EnumC12413h;
import com.p521ss.android.socialbase.downloader.constants.EnumC12414kf;
import com.p521ss.android.socialbase.downloader.constants.EnumC12416ok;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12483y;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12502kf;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12518td;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.notification.C12644a;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p555p.HandlerC12663p;
import com.p521ss.android.socialbase.downloader.p555p.RunnableC12652bl;
import com.p521ss.android.socialbase.downloader.p556q.C12667bl;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;
import com.p521ss.android.socialbase.downloader.p556q.C12718p;
import com.p521ss.android.socialbase.downloader.p557s.C12723ok;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

/* renamed from: com.ss.android.socialbase.downloader.impls.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractC12547ok implements HandlerC12663p.InterfaceC12664ok {

    /* renamed from: a */
    private final SparseArray<DownloadTask> f35223a = new SparseArray<>();

    /* renamed from: bl */
    private final SparseArray<DownloadTask> f35224bl = new SparseArray<>();

    /* renamed from: s */
    private final SparseArray<DownloadTask> f35233s = new SparseArray<>();

    /* renamed from: n */
    private final SparseArray<DownloadTask> f35228n = new SparseArray<>();

    /* renamed from: kf */
    private final SparseArray<DownloadTask> f35227kf = new SparseArray<>();

    /* renamed from: h */
    private final SparseArray<SparseArray<DownloadTask>> f35225h = new SparseArray<>();

    /* renamed from: p */
    private final C12718p<Integer, DownloadTask> f35230p = new C12718p<>();

    /* renamed from: q */
    private final SparseArray<Long> f35231q = new SparseArray<>();

    /* renamed from: k */
    private final LinkedBlockingDeque<DownloadTask> f35226k = new LinkedBlockingDeque<>();

    /* renamed from: ok */
    protected final HandlerC12663p f35229ok = new HandlerC12663p(Looper.getMainLooper(), this);

    /* renamed from: r */
    private final InterfaceC12501k f35232r = C12490bl.m17806m();

    /* renamed from: bl */
    private void m17567bl(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        try {
            if (this.f35226k.isEmpty()) {
                m17544ok(downloadTask, true);
                this.f35226k.put(downloadTask);
            } else if (downloadInfo.getEnqueueType() == EnqueueType.ENQUEUE_TAIL) {
                if (this.f35226k.getFirst().getDownloadId() == downloadTask.getDownloadId() && mo17558ok(downloadTask.getDownloadId())) {
                    return;
                }
                Iterator<DownloadTask> it = this.f35226k.iterator();
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
                this.f35226k.put(downloadTask);
                new C12502kf(downloadTask, this.f35229ok).m17722ok();
            } else {
                DownloadTask first = this.f35226k.getFirst();
                if (first.getDownloadId() == downloadTask.getDownloadId() && mo17558ok(downloadTask.getDownloadId())) {
                    return;
                }
                m17561n(first.getDownloadId());
                m17544ok(downloadTask, true);
                if (first.getDownloadId() != downloadTask.getDownloadId()) {
                    this.f35226k.putFirst(downloadTask);
                }
            }
        } catch (InterruptedException unused) {
        }
    }

    /* renamed from: i */
    private void m17565i(int i) {
        DownloadTask first;
        if (this.f35226k.isEmpty()) {
            return;
        }
        DownloadTask first2 = this.f35226k.getFirst();
        if (first2 != null && first2.getDownloadId() == i) {
            this.f35226k.poll();
        }
        if (this.f35226k.isEmpty() || (first = this.f35226k.getFirst()) == null) {
            return;
        }
        m17544ok(first, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: t */
    public DownloadTask m17534t(int i) {
        DownloadTask downloadTask = this.f35223a.get(i);
        if (downloadTask == null) {
            DownloadTask downloadTask2 = this.f35233s.get(i);
            if (downloadTask2 == null) {
                DownloadTask downloadTask3 = this.f35224bl.get(i);
                if (downloadTask3 == null) {
                    DownloadTask downloadTask4 = this.f35228n.get(i);
                    return downloadTask4 == null ? this.f35227kf.get(i) : downloadTask4;
                }
                return downloadTask3;
            }
            return downloadTask2;
        }
        return downloadTask;
    }

    /* renamed from: a */
    protected abstract void mo17578a(int i);

    /* renamed from: bl */
    protected abstract RunnableC12652bl mo17569bl(int i);

    /* renamed from: h */
    public synchronized boolean m17566h(int i) {
        DownloadTask downloadTask = this.f35233s.get(i);
        if (downloadTask == null) {
            downloadTask = this.f35228n.get(i);
        }
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            m17545ok(downloadTask);
            return true;
        }
        return false;
    }

    /* renamed from: j */
    public synchronized boolean m17564j(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f35227kf.get(i);
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return false;
        }
        if (downloadInfo.canReStartAsyncTask()) {
            m17545ok(downloadTask);
        }
        return true;
    }

    /* renamed from: k */
    public synchronized IDownloadFileUriProvider m17563k(int i) {
        DownloadTask downloadTask = this.f35223a.get(i);
        if (downloadTask != null) {
            return downloadTask.getFileUriProvider();
        }
        DownloadTask downloadTask2 = this.f35224bl.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getFileUriProvider();
        }
        DownloadTask downloadTask3 = this.f35233s.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getFileUriProvider();
        }
        DownloadTask downloadTask4 = this.f35228n.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getFileUriProvider();
        }
        DownloadTask downloadTask5 = this.f35227kf.get(i);
        if (downloadTask5 != null) {
            return downloadTask5.getFileUriProvider();
        }
        return null;
    }

    /* renamed from: kf */
    public synchronized boolean m17562kf(int i) {
        DownloadTask downloadTask = this.f35223a.get(i);
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            if (downloadInfo != null) {
                downloadInfo.setDownloadFromReserveWifi(false);
            }
            m17545ok(downloadTask);
        } else {
            m17566h(i);
        }
        return true;
    }

    /* renamed from: n */
    public synchronized boolean m17561n(int i) {
        C12409ok.m17904a("AbsDownloadEngine", "pause id=" + i);
        DownloadInfo mo17520a = this.f35232r.mo17520a(i);
        if (mo17520a == null || mo17520a.getStatus() != 11) {
            synchronized (this.f35223a) {
                mo17578a(i);
            }
            if (mo17520a == null) {
                DownloadTask downloadTask = this.f35223a.get(i);
                if (downloadTask != null) {
                    new C12502kf(downloadTask, this.f35229ok).m17707s();
                    return true;
                }
            } else {
                m17546ok(mo17520a);
                if (mo17520a.getStatus() == 1) {
                    DownloadTask downloadTask2 = this.f35223a.get(i);
                    if (downloadTask2 != null) {
                        new C12502kf(downloadTask2, this.f35229ok).m17707s();
                        return true;
                    }
                } else if (DownloadStatus.isDownloading(mo17520a.getStatus())) {
                    mo17520a.setStatus(-2);
                    return true;
                }
            }
            return false;
        }
        return false;
    }

    /* renamed from: ok */
    protected abstract List<Integer> mo17559ok();

    /* renamed from: ok */
    public abstract void mo17553ok(int i, long j);

    /* renamed from: ok */
    protected abstract void mo17550ok(int i, DownloadTask downloadTask);

    /* renamed from: ok */
    public abstract void mo17543ok(RunnableC12652bl runnableC12652bl);

    /* renamed from: ok */
    public abstract boolean mo17558ok(int i);

    /* renamed from: p */
    public synchronized InterfaceC12480v m17540p(int i) {
        DownloadTask downloadTask = this.f35223a.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationClickCallback();
        }
        DownloadTask downloadTask2 = this.f35224bl.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationClickCallback();
        }
        DownloadTask downloadTask3 = this.f35233s.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationClickCallback();
        }
        DownloadTask downloadTask4 = this.f35228n.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationClickCallback();
        }
        DownloadTask downloadTask5 = this.f35227kf.get(i);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationClickCallback();
        }
        return null;
    }

    /* renamed from: q */
    public synchronized InterfaceC12427ep m17539q(int i) {
        DownloadTask downloadTask = this.f35223a.get(i);
        if (downloadTask != null) {
            return downloadTask.getNotificationEventListener();
        }
        DownloadTask downloadTask2 = this.f35224bl.get(i);
        if (downloadTask2 != null) {
            return downloadTask2.getNotificationEventListener();
        }
        DownloadTask downloadTask3 = this.f35233s.get(i);
        if (downloadTask3 != null) {
            return downloadTask3.getNotificationEventListener();
        }
        DownloadTask downloadTask4 = this.f35228n.get(i);
        if (downloadTask4 != null) {
            return downloadTask4.getNotificationEventListener();
        }
        DownloadTask downloadTask5 = this.f35227kf.get(i);
        if (downloadTask5 != null) {
            return downloadTask5.getNotificationEventListener();
        }
        return null;
    }

    /* renamed from: r */
    public synchronized boolean m17538r(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f35228n.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            if (downloadInfo.canStartRetryDelayTask()) {
                m17544ok(downloadTask, false);
            }
            return true;
        }
        DownloadInfo mo17520a = this.f35232r.mo17520a(i);
        if (mo17520a != null && mo17520a.canStartRetryDelayTask()) {
            m17544ok(new DownloadTask(mo17520a), false);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0011, code lost:
        if (r1.f35233s.get(r2) != null) goto L13;
     */
    /* renamed from: rh */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized boolean m17537rh(int r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L18
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f35223a     // Catch: java.lang.Throwable -> L15
            java.lang.Object r0 = r0.get(r2)     // Catch: java.lang.Throwable -> L15
            if (r0 != 0) goto L13
            android.util.SparseArray<com.ss.android.socialbase.downloader.model.DownloadTask> r0 = r1.f35233s     // Catch: java.lang.Throwable -> L15
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
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok.m17537rh(int):boolean");
    }

    /* renamed from: s */
    public synchronized DownloadInfo m17536s(int i) {
        DownloadInfo mo17520a;
        DownloadTask downloadTask;
        mo17520a = this.f35232r.mo17520a(i);
        if (mo17520a == null && (downloadTask = this.f35223a.get(i)) != null) {
            mo17520a = downloadTask.getDownloadInfo();
        }
        return mo17520a;
    }

    /* renamed from: z */
    public synchronized void m17533z(int i) {
        DownloadInfo downloadInfo;
        DownloadTask downloadTask = this.f35223a.get(i);
        if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null) {
            downloadInfo.setForceIgnoreRecommendSize(true);
            m17545ok(downloadTask);
        }
    }

    /* renamed from: a */
    private void m17572a(DownloadTask downloadTask) {
        int hashCodeForSameTask = downloadTask.getHashCodeForSameTask();
        if (hashCodeForSameTask == 0 && downloadTask.isAutoSetHashCodeForSameTask()) {
            hashCodeForSameTask = downloadTask.autoCalAndGetHashCodeForSameTask();
        }
        if (hashCodeForSameTask == 0) {
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f35225h.get(downloadTask.getDownloadId());
        if (sparseArray == null) {
            sparseArray = new SparseArray<>();
            this.f35225h.put(downloadTask.getDownloadId(), sparseArray);
        }
        C12409ok.m17904a("AbsDownloadEngine", "tryCacheSameTaskWithListenerHashCode id:" + downloadTask.getDownloadId() + " listener hasCode:" + hashCodeForSameTask);
        sparseArray.put(hashCodeForSameTask, downloadTask);
    }

    /* renamed from: ok */
    private void m17544ok(DownloadTask downloadTask, boolean z) {
        DownloadInfo downloadInfo;
        int i;
        DownloadInfo downloadInfo2;
        DownloadTask remove;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return;
        }
        if (downloadInfo.isEntityInvalid()) {
            InterfaceC12483y monitorDepend = downloadTask.getMonitorDepend();
            C12723ok.m16492ok(monitorDepend, downloadInfo, new BaseException(1003, "downloadInfo is Invalid, url is " + downloadInfo.getUrl() + " name is " + downloadInfo.getName() + " savePath is " + downloadInfo.getSavePath()), downloadInfo.getStatus());
            return;
        }
        boolean z2 = false;
        if (C12534ok.m17599ok(downloadInfo.getId()).m17593ok("no_net_opt", 0) == 1 && !C12713kf.m16602bl(C12490bl.m17807l()) && !downloadInfo.isFirstDownload()) {
            new C12502kf(downloadTask, this.f35229ok).m17714ok(new BaseException(1049, "network_not_available"));
            return;
        }
        int id = downloadInfo.getId();
        if (z) {
            m17546ok(downloadInfo);
        }
        if (this.f35233s.get(id) != null) {
            this.f35233s.remove(id);
        }
        if (this.f35224bl.get(id) != null) {
            this.f35224bl.remove(id);
        }
        if (this.f35228n.get(id) != null) {
            this.f35228n.remove(id);
        }
        if (this.f35227kf.get(id) != null) {
            this.f35227kf.remove(id);
        }
        if (mo17558ok(id) && !downloadInfo.canReStartAsyncTask()) {
            C12409ok.m17904a("AbsDownloadEngine", "another task with same id is downloading when tryDownload");
            downloadTask.addListenerToDownloadingSameTask();
            C12723ok.m16492ok(downloadTask.getMonitorDepend(), downloadInfo, new BaseException(1003, "downloadInfo is isDownloading and addListenerToSameTask is false"), downloadInfo.getStatus());
            return;
        }
        C12409ok.m17904a("AbsDownloadEngine", "no downloading task :" + id);
        if (downloadInfo.canReStartAsyncTask()) {
            downloadInfo.setAsyncHandleStatus(EnumC12416ok.ASYNC_HANDLE_RESTART);
        }
        if (C12717ok.m16510ok(32768) && (remove = this.f35230p.remove(Integer.valueOf(id))) != null) {
            downloadTask.copyListenerFromPendingTask(remove);
        }
        long uptimeMillis = SystemClock.uptimeMillis();
        DownloadTask downloadTask2 = this.f35223a.get(id);
        if (downloadTask2 == null || (downloadInfo2 = downloadTask2.getDownloadInfo()) == null) {
            i = 0;
        } else {
            i = downloadInfo2.getStatus();
            if (DownloadStatus.isDownloading(i)) {
                z2 = true;
            }
        }
        C12409ok.m17904a("AbsDownloadEngine", "can add listener " + z2 + " , oldTaskStatus is :" + i);
        if (z2) {
            downloadTask.addListenerToDownloadingSameTask();
            return;
        }
        m17572a(downloadTask);
        this.f35223a.put(id, downloadTask);
        this.f35231q.put(id, Long.valueOf(uptimeMillis));
        mo17550ok(id, downloadTask);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: s */
    public synchronized void m17535s(int i, boolean z) {
        C12409ok.m17904a("AbsDownloadEngine", "clearDownloadDataInSubThread::id=" + i + " deleteTargetFile=" + z);
        DownloadInfo mo17520a = this.f35232r.mo17520a(i);
        if (mo17520a != null) {
            if (z) {
                C12713kf.m16563ok(mo17520a);
            } else {
                C12713kf.m16597bl(mo17520a.getTempPath(), mo17520a.getTempName());
            }
            mo17520a.erase();
        }
        try {
            this.f35232r.mo17502kf(i);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        m17556ok(i, 0, -4);
        if (this.f35233s.get(i) != null) {
            this.f35233s.remove(i);
        }
        if (this.f35224bl.get(i) != null) {
            this.f35224bl.remove(i);
        }
        this.f35230p.remove(Integer.valueOf(i));
        C12534ok.m17609a(i);
    }

    /* renamed from: a */
    public synchronized void m17570a(List<String> list) {
        DownloadInfo downloadInfo;
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (C12713kf.m16620a(C12490bl.m17807l())) {
            for (int i = 0; i < this.f35223a.size(); i++) {
                DownloadTask downloadTask = this.f35223a.get(this.f35223a.keyAt(i));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && m17573a(downloadInfo)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    m17545ok(downloadTask);
                    downloadInfo.setDownloadFromReserveWifi(true);
                    InterfaceC12518td reserveWifiStatusListener = Downloader.getInstance(C12490bl.m17807l()).getReserveWifiStatusListener();
                    if (reserveWifiStatusListener != null) {
                        reserveWifiStatusListener.mo17627ok(downloadInfo, 5, 2);
                    }
                }
            }
        }
    }

    /* renamed from: bl */
    public void m17568bl(final int i, final boolean z) {
        DownloadInfo mo17520a = this.f35232r.mo17520a(i);
        if (mo17520a != null) {
            m17546ok(mo17520a);
        }
        this.f35229ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.4
            @Override // java.lang.Runnable
            public void run() {
                C12644a.m16876ok().m16878kf(i);
            }
        });
        C12490bl.m17777ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.5
            @Override // java.lang.Runnable
            public void run() {
                AbstractC12547ok.this.mo17569bl(i);
                AbstractC12547ok.this.m17560n(i, z);
            }
        }, false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: n */
    public void m17560n(int i, boolean z) {
        try {
            DownloadInfo mo17520a = this.f35232r.mo17520a(i);
            if (mo17520a != null) {
                C12713kf.m16559ok(mo17520a, z);
                mo17520a.erase();
            }
            try {
                this.f35232r.mo17478s(i);
                this.f35232r.mo17488ok(mo17520a);
            } catch (SQLiteException e) {
                e.printStackTrace();
            }
            if (this.f35233s.get(i) != null) {
                this.f35233s.remove(i);
            }
            if (this.f35224bl.get(i) != null) {
                this.f35224bl.remove(i);
            }
            this.f35230p.remove(Integer.valueOf(i));
            C12534ok.m17609a(i);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: a */
    private boolean m17573a(DownloadInfo downloadInfo) {
        if (downloadInfo != null && downloadInfo.statusInPause()) {
            return downloadInfo.isPauseReserveOnWifi();
        }
        return false;
    }

    /* renamed from: a */
    public void m17579a() {
        List<Integer> mo17559ok = mo17559ok();
        if (mo17559ok == null) {
            return;
        }
        for (Integer num : mo17559ok) {
            m17561n(num.intValue());
        }
    }

    /* renamed from: a */
    public void m17575a(final int i, final boolean z) {
        DownloadInfo mo17520a = this.f35232r.mo17520a(i);
        if (mo17520a != null) {
            m17546ok(mo17520a);
        }
        this.f35229ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.2
            @Override // java.lang.Runnable
            public void run() {
                C12644a.m16876ok().m16878kf(i);
            }
        });
        C12490bl.m17777ok(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.3
            @Override // java.lang.Runnable
            public void run() {
                DownloadTask m17534t;
                if (AbstractC12547ok.this.mo17569bl(i) == null && (m17534t = AbstractC12547ok.this.m17534t(i)) != null) {
                    DownloadInfo downloadInfo = m17534t.getDownloadInfo();
                    SparseArray<IDownloadListener> downloadListeners = m17534t.getDownloadListeners(EnumC12414kf.SUB);
                    if (downloadListeners != null) {
                        synchronized (downloadListeners) {
                            for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                IDownloadListener iDownloadListener = downloadListeners.get(downloadListeners.keyAt(i2));
                                if (iDownloadListener != null) {
                                    iDownloadListener.onCanceled(downloadInfo);
                                }
                            }
                        }
                    }
                }
                AbstractC12547ok.this.m17535s(i, z);
            }
        }, false);
    }

    /* renamed from: a */
    public synchronized void m17577a(int i, int i2, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z) {
        m17554ok(i, i2, iDownloadListener, enumC12414kf, z, true);
    }

    /* renamed from: a */
    public List<DownloadInfo> m17571a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Integer num : mo17559ok()) {
            DownloadInfo m17536s = m17536s(num.intValue());
            if (m17536s != null && str.equals(m17536s.getMimeType())) {
                arrayList.add(m17536s);
            }
        }
        return arrayList;
    }

    /* renamed from: ok */
    public synchronized void m17545ok(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
        if (downloadInfo == null) {
            return;
        }
        downloadInfo.setDownloadFromReserveWifi(false);
        if (downloadInfo.getEnqueueType() != EnqueueType.ENQUEUE_NONE) {
            m17567bl(downloadTask);
        } else {
            m17544ok(downloadTask, true);
        }
    }

    /* renamed from: a */
    public void m17576a(int i, long j) {
        DownloadInfo mo17520a = this.f35232r.mo17520a(i);
        if (mo17520a != null) {
            mo17520a.setThrottleNetSpeed(j);
        }
        mo17553ok(i, j);
    }

    /* renamed from: ok */
    public synchronized List<DownloadInfo> m17542ok(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        List<DownloadInfo> mo17485ok = this.f35232r.mo17485ok(str);
        if (mo17485ok == null || mo17485ok.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            int size = this.f35223a.size();
            for (int i = 0; i < size; i++) {
                DownloadTask valueAt = this.f35223a.valueAt(i);
                if (valueAt != null && valueAt.getDownloadInfo() != null && str.equals(valueAt.getDownloadInfo().getUrl())) {
                    arrayList.add(valueAt.getDownloadInfo());
                }
            }
            return arrayList;
        }
        return mo17485ok;
    }

    /* renamed from: ok */
    public synchronized boolean m17549ok(int i, boolean z) {
        DownloadTask downloadTask = this.f35223a.get(i);
        if (downloadTask == null && C12717ok.m16510ok(65536)) {
            downloadTask = m17534t(i);
        }
        if (downloadTask != null) {
            if (!C12534ok.m17599ok(i).m17606a("fix_on_cancel_call_twice", true)) {
                new C12502kf(downloadTask, this.f35229ok).m17730bl();
            }
            final DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            final SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(EnumC12414kf.MAIN);
            final SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(EnumC12414kf.NOTIFICATION);
            this.f35229ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.1
                @Override // java.lang.Runnable
                public void run() {
                    SparseArray sparseArray;
                    SparseArray sparseArray2 = downloadListeners;
                    if (sparseArray2 != null) {
                        synchronized (sparseArray2) {
                            for (int i2 = 0; i2 < downloadListeners.size(); i2++) {
                                IDownloadListener iDownloadListener = (IDownloadListener) downloadListeners.get(downloadListeners.keyAt(i2));
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
                        for (int i3 = 0; i3 < downloadListeners2.size(); i3++) {
                            IDownloadListener iDownloadListener2 = (IDownloadListener) downloadListeners2.get(downloadListeners2.keyAt(i3));
                            if (iDownloadListener2 != null) {
                                iDownloadListener2.onCanceled(downloadInfo);
                            }
                        }
                    }
                }
            });
        }
        DownloadInfo mo17520a = this.f35232r.mo17520a(i);
        if (C12717ok.m16510ok(65536)) {
            if (mo17520a != null) {
                mo17520a.setStatus(-4);
            }
        } else if (mo17520a != null && DownloadStatus.isDownloading(mo17520a.getStatus())) {
            mo17520a.setStatus(-4);
        }
        m17575a(i, z);
        return true;
    }

    /* renamed from: ok */
    private void m17546ok(DownloadInfo downloadInfo) {
        if (downloadInfo != null) {
            try {
                if (downloadInfo.getStatus() == 7 || downloadInfo.getRetryDelayStatus() != EnumC12413h.DELAY_RETRY_NONE) {
                    downloadInfo.setStatus(5);
                    downloadInfo.setRetryDelayStatus(EnumC12413h.DELAY_RETRY_NONE);
                    C12409ok.m17904a("AbsDownloadEngine", "cancelAlarm");
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* renamed from: ok */
    public synchronized void m17552ok(int i, InterfaceC12427ep interfaceC12427ep) {
        DownloadTask downloadTask = this.f35223a.get(i);
        if (downloadTask != null) {
            downloadTask.setNotificationEventListener(interfaceC12427ep);
        }
    }

    /* renamed from: ok */
    public synchronized void m17541ok(List<String> list) {
        DownloadInfo downloadInfo;
        try {
            boolean m16620a = C12717ok.m16510ok(1048576) ? C12713kf.m16620a(C12490bl.m17807l()) : true;
            for (int i = 0; i < this.f35233s.size(); i++) {
                DownloadTask downloadTask = this.f35233s.get(this.f35233s.keyAt(i));
                if (downloadTask != null && (downloadInfo = downloadTask.getDownloadInfo()) != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (!downloadInfo.isOnlyWifi() || m16620a)) {
                    downloadInfo.setAutoResumed(true);
                    downloadInfo.setShowNotificationForNetworkResumed(true);
                    m17545ok(downloadTask);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ok */
    public synchronized void m17555ok(int i, int i2, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z) {
        DownloadTask m17534t = m17534t(i);
        if (m17534t == null) {
            m17534t = this.f35230p.get(Integer.valueOf(i));
        }
        if (m17534t != null) {
            m17534t.removeDownloadListener(i2, iDownloadListener, enumC12414kf, z);
        }
    }

    /* renamed from: ok */
    public synchronized void m17554ok(int i, int i2, final IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z, boolean z2) {
        DownloadInfo mo17520a;
        DownloadTask m17534t = m17534t(i);
        if (m17534t != null) {
            m17534t.addDownloadListener(i2, iDownloadListener, enumC12414kf, z);
            final DownloadInfo downloadInfo = m17534t.getDownloadInfo();
            if (z2 && downloadInfo != null && !mo17558ok(i) && (enumC12414kf == EnumC12414kf.MAIN || enumC12414kf == EnumC12414kf.NOTIFICATION)) {
                boolean z3 = true;
                if (enumC12414kf == EnumC12414kf.NOTIFICATION && !downloadInfo.canShowNotification()) {
                    z3 = false;
                }
                if (z3) {
                    this.f35229ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.ok.6
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
        } else if (C12717ok.m16510ok(32768) && (mo17520a = this.f35232r.mo17520a(i)) != null && mo17520a.getStatus() != -3) {
            DownloadTask downloadTask = this.f35230p.get(Integer.valueOf(i));
            if (downloadTask == null) {
                downloadTask = new DownloadTask(mo17520a);
                this.f35230p.put(Integer.valueOf(i), downloadTask);
            }
            downloadTask.addDownloadListener(i2, iDownloadListener, enumC12414kf, z);
        }
    }

    /* renamed from: ok */
    private void m17551ok(int i, BaseException baseException, DownloadTask downloadTask) {
        if (downloadTask != null) {
            DownloadInfo downloadInfo = downloadTask.getDownloadInfo();
            SparseArray<IDownloadListener> downloadListeners = downloadTask.getDownloadListeners(EnumC12414kf.MAIN);
            SparseArray<IDownloadListener> downloadListeners2 = downloadTask.getDownloadListeners(EnumC12414kf.NOTIFICATION);
            boolean z = downloadTask.canShowNotification() || downloadInfo.isAutoInstallWithoutNotification();
            C12667bl.m16732ok(i, downloadListeners, true, downloadInfo, baseException);
            C12667bl.m16732ok(i, downloadListeners2, z, downloadInfo, baseException);
        }
    }

    /* renamed from: ok */
    private void m17557ok(int i, int i2) {
        C12409ok.m17904a("AbsDownloadEngine", "removeTask id: " + i + " listener hasCode: " + i2);
        if (i2 == 0) {
            this.f35223a.remove(i);
            this.f35225h.remove(i);
            return;
        }
        SparseArray<DownloadTask> sparseArray = this.f35225h.get(i);
        if (sparseArray != null) {
            sparseArray.remove(i2);
            C12409ok.m17904a("AbsDownloadEngine", "after downloadTaskWithListenerMap removeTask taskArray.size: " + sparseArray.size());
            if (sparseArray.size() == 0) {
                this.f35223a.remove(i);
                this.f35225h.remove(i);
                return;
            }
            return;
        }
        this.f35223a.remove(i);
    }

    /* renamed from: ok */
    public synchronized void m17556ok(int i, int i2, int i3) {
        if (i3 != -7) {
            if (i3 == -6) {
                this.f35224bl.put(i, this.f35223a.get(i));
                m17557ok(i, i2);
            } else if (i3 == -4) {
                m17557ok(i, i2);
                m17565i(i);
            } else if (i3 == -3) {
                this.f35224bl.put(i, this.f35223a.get(i));
                m17557ok(i, i2);
                m17565i(i);
            } else if (i3 != -1) {
                if (i3 == 7) {
                    DownloadTask downloadTask = this.f35223a.get(i);
                    if (downloadTask != null) {
                        if (this.f35228n.get(i) == null) {
                            this.f35228n.put(i, downloadTask);
                        }
                        m17557ok(i, i2);
                    }
                    m17565i(i);
                } else if (i3 == 8) {
                    DownloadTask downloadTask2 = this.f35223a.get(i);
                    if (downloadTask2 != null && this.f35227kf.get(i) == null) {
                        this.f35227kf.put(i, downloadTask2);
                    }
                    m17565i(i);
                }
            }
        }
        DownloadTask downloadTask3 = this.f35223a.get(i);
        if (downloadTask3 != null) {
            if (this.f35233s.get(i) == null) {
                this.f35233s.put(i, downloadTask3);
            }
            m17557ok(i, i2);
        }
        m17565i(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.p555p.HandlerC12663p.InterfaceC12664ok
    /* renamed from: ok */
    public void mo16744ok(Message message) {
        int i = message.arg1;
        int i2 = message.arg2;
        C12409ok.m17904a("AbsDownloadEngine", "handleMsg id: " + i + " listener hasCode: " + i2);
        Object obj = message.obj;
        DownloadTask downloadTask = null;
        BaseException baseException = obj instanceof Exception ? (BaseException) obj : null;
        synchronized (this) {
            if (i2 == 0) {
                downloadTask = this.f35223a.get(i);
            } else {
                SparseArray<DownloadTask> sparseArray = this.f35225h.get(i);
                if (sparseArray != null) {
                    downloadTask = sparseArray.get(i2);
                }
            }
            if (downloadTask == null) {
                return;
            }
            m17551ok(message.what, baseException, downloadTask);
            m17556ok(i, i2, message.what);
        }
    }
}
