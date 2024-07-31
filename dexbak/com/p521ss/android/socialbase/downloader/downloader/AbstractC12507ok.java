package com.p521ss.android.socialbase.downloader.downloader;

import android.app.Notification;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.downloader.ok */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public abstract class AbstractC12507ok implements InterfaceC12517t {

    /* renamed from: n */
    private static final String f35164n = "ok";

    /* renamed from: bl */
    protected volatile boolean f35166bl;

    /* renamed from: kf */
    private WeakReference<Service> f35168kf;

    /* renamed from: ok */
    protected final SparseArray<List<DownloadTask>> f35169ok = new SparseArray<>();

    /* renamed from: a */
    protected volatile boolean f35165a = false;

    /* renamed from: s */
    protected volatile boolean f35171s = false;

    /* renamed from: h */
    private Handler f35167h = new Handler(Looper.getMainLooper());

    /* renamed from: p */
    private Runnable f35170p = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.ok.1
        @Override // java.lang.Runnable
        public void run() {
            if (C12409ok.m17899ok()) {
                C12409ok.m17904a(AbstractC12507ok.f35164n, "tryDownload: 2 try");
            }
            if (AbstractC12507ok.this.f35165a) {
                return;
            }
            if (C12409ok.m17899ok()) {
                C12409ok.m17904a(AbstractC12507ok.f35164n, "tryDownload: 2 error");
            }
            AbstractC12507ok.this.startService(C12490bl.m17807l(), null);
        }
    };

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: a */
    public boolean mo17633a() {
        String str = f35164n;
        C12409ok.m17901bl(str, "isServiceForeground = " + this.f35166bl);
        return this.f35166bl;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: bl */
    public void mo17532bl() {
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: bl */
    public void mo17526bl(DownloadTask downloadTask) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* renamed from: n */
    public void m17687n() {
        SparseArray<List<DownloadTask>> clone;
        synchronized (this.f35169ok) {
            String str = f35164n;
            C12409ok.m17904a(str, "resumePendingTask pendingTasks.size:" + this.f35169ok.size());
            clone = this.f35169ok.clone();
            this.f35169ok.clear();
        }
        AbstractC12547ok m17820fb = C12490bl.m17820fb();
        if (m17820fb != null) {
            for (int i = 0; i < clone.size(); i++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        String str2 = f35164n;
                        C12409ok.m17904a(str2, "resumePendingTask key:" + downloadTask.getDownloadId());
                        m17820fb.m17545ok(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public void mo17531ok(Intent intent, int i, int i2) {
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public void mo17522ok(InterfaceC12514rh interfaceC12514rh) {
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public void mo17630ok(WeakReference weakReference) {
        this.f35168kf = weakReference;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: s */
    public void mo17628s() {
        this.f35165a = false;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    public void startService() {
        if (this.f35165a) {
            return;
        }
        if (C12409ok.m17899ok()) {
            C12409ok.m17904a(f35164n, "startService");
        }
        startService(C12490bl.m17807l(), null);
    }

    protected void startService(Context context, ServiceConnection serviceConnection) {
    }

    protected void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public boolean mo17632ok() {
        return this.f35165a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: a */
    public void mo17527a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.f35165a) {
            if (C12409ok.m17899ok()) {
                C12409ok.m17904a(f35164n, "tryDownload but service is not alive");
            }
            if (C12717ok.m16510ok(262144)) {
                m17686ok(downloadTask);
                if (!this.f35171s) {
                    if (C12409ok.m17899ok()) {
                        C12409ok.m17904a(f35164n, "tryDownload: 1");
                    }
                    startService(C12490bl.m17807l(), null);
                    this.f35171s = true;
                    return;
                }
                this.f35167h.removeCallbacks(this.f35170p);
                this.f35167h.postDelayed(this.f35170p, 10L);
                return;
            }
            m17686ok(downloadTask);
            startService(C12490bl.m17807l(), null);
            return;
        }
        String str = f35164n;
        C12409ok.m17904a(str, "tryDownload when isServiceAlive");
        m17687n();
        AbstractC12547ok m17820fb = C12490bl.m17820fb();
        if (m17820fb != null) {
            C12409ok.m17904a(str, "tryDownload current task: " + downloadTask.getDownloadId());
            m17820fb.m17545ok(downloadTask);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public IBinder mo17523ok(Intent intent) {
        C12409ok.m17904a(f35164n, "onBind Abs");
        return new Binder();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public void mo17631ok(int i, Notification notification) {
        WeakReference<Service> weakReference = this.f35168kf;
        if (weakReference != null && weakReference.get() != null) {
            String str = f35164n;
            C12409ok.m17901bl(str, "startForeground  id = " + i + ", service = " + this.f35168kf.get() + ",  isServiceAlive = " + this.f35165a);
            try {
                this.f35168kf.get().startForeground(i, notification);
                this.f35166bl = true;
                return;
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        C12409ok.m17894s(f35164n, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public void mo17629ok(boolean z) {
        WeakReference<Service> weakReference = this.f35168kf;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        String str = f35164n;
        C12409ok.m17901bl(str, "stopForeground  service = " + this.f35168kf.get() + ",  isServiceAlive = " + this.f35165a);
        try {
            this.f35166bl = false;
            this.f35168kf.get().stopForeground(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: ok */
    public void m17686ok(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.f35169ok) {
            String str = f35164n;
            C12409ok.m17904a(str, "pendDownloadTask pendingTasks.size:" + this.f35169ok.size() + " downloadId:" + downloadId);
            List<DownloadTask> list = this.f35169ok.get(downloadId);
            if (list == null) {
                list = new ArrayList<>();
                this.f35169ok.put(downloadId, list);
            }
            C12409ok.m17904a(str, "before pendDownloadTask taskArray.size:" + list.size());
            list.add(downloadTask);
            C12409ok.m17904a(str, "after pendDownloadTask pendingTasks.size:" + this.f35169ok.size());
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t
    /* renamed from: ok */
    public void mo17524ok(int i) {
        C12409ok.m17898ok(i);
    }
}
