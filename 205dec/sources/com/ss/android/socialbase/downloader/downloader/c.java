package com.ss.android.socialbase.downloader.downloader;

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
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public abstract class c implements ys {
    private static final String ux = "c";

    /* renamed from: f  reason: collision with root package name */
    private WeakReference<Service> f49436f;
    protected volatile boolean xv;

    /* renamed from: c  reason: collision with root package name */
    protected final SparseArray<List<DownloadTask>> f49435c = new SparseArray<>();

    /* renamed from: w  reason: collision with root package name */
    protected volatile boolean f49438w = false;
    protected volatile boolean sr = false;

    /* renamed from: r  reason: collision with root package name */
    private Handler f49437r = new Handler(Looper.getMainLooper());
    private Runnable ev = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.c.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.xv.c.c()) {
                com.ss.android.socialbase.downloader.xv.c.w(c.ux, "tryDownload: 2 try");
            }
            if (c.this.f49438w) {
                return;
            }
            if (com.ss.android.socialbase.downloader.xv.c.c()) {
                com.ss.android.socialbase.downloader.xv.c.w(c.ux, "tryDownload: 2 error");
            }
            c.this.startService(xv.gw(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public void c(Intent intent, int i4, int i5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public void c(t tVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public void c(WeakReference weakReference) {
        this.f49436f = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public void sr() {
        this.f49438w = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public void startService() {
        if (this.f49438w) {
            return;
        }
        if (com.ss.android.socialbase.downloader.xv.c.c()) {
            com.ss.android.socialbase.downloader.xv.c.w(ux, "startService");
        }
        startService(xv.gw(), null);
    }

    protected void startService(Context context, ServiceConnection serviceConnection) {
    }

    protected void stopService(Context context, ServiceConnection serviceConnection) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ux() {
        SparseArray<List<DownloadTask>> clone;
        synchronized (this.f49435c) {
            String str = ux;
            com.ss.android.socialbase.downloader.xv.c.w(str, "resumePendingTask pendingTasks.size:" + this.f49435c.size());
            clone = this.f49435c.clone();
            this.f49435c.clear();
        }
        com.ss.android.socialbase.downloader.impls.c y3 = xv.y();
        if (y3 != null) {
            for (int i4 = 0; i4 < clone.size(); i4++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i4));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        String str2 = ux;
                        com.ss.android.socialbase.downloader.xv.c.w(str2, "resumePendingTask key:" + downloadTask.getDownloadId());
                        y3.c(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public boolean w() {
        String str = ux;
        com.ss.android.socialbase.downloader.xv.c.xv(str, "isServiceForeground = " + this.xv);
        return this.xv;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public void xv() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public void xv(DownloadTask downloadTask) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public boolean c() {
        return this.f49438w;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public IBinder c(Intent intent) {
        com.ss.android.socialbase.downloader.xv.c.w(ux, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public void w(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.f49438w) {
            if (com.ss.android.socialbase.downloader.xv.c.c()) {
                com.ss.android.socialbase.downloader.xv.c.w(ux, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.gd.c.c(262144)) {
                c(downloadTask);
                if (!this.sr) {
                    if (com.ss.android.socialbase.downloader.xv.c.c()) {
                        com.ss.android.socialbase.downloader.xv.c.w(ux, "tryDownload: 1");
                    }
                    startService(xv.gw(), null);
                    this.sr = true;
                    return;
                }
                this.f49437r.removeCallbacks(this.ev);
                this.f49437r.postDelayed(this.ev, 10L);
                return;
            }
            c(downloadTask);
            startService(xv.gw(), null);
            return;
        }
        String str = ux;
        com.ss.android.socialbase.downloader.xv.c.w(str, "tryDownload when isServiceAlive");
        ux();
        com.ss.android.socialbase.downloader.impls.c y3 = xv.y();
        if (y3 != null) {
            com.ss.android.socialbase.downloader.xv.c.w(str, "tryDownload current task: " + downloadTask.getDownloadId());
            y3.c(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public void c(int i4, Notification notification) {
        WeakReference<Service> weakReference = this.f49436f;
        if (weakReference != null && weakReference.get() != null) {
            String str = ux;
            com.ss.android.socialbase.downloader.xv.c.xv(str, "startForeground  id = " + i4 + ", service = " + this.f49436f.get() + ",  isServiceAlive = " + this.f49438w);
            try {
                this.f49436f.get().startForeground(i4, notification);
                this.xv = true;
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        com.ss.android.socialbase.downloader.xv.c.sr(ux, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public void c(boolean z3) {
        WeakReference<Service> weakReference = this.f49436f;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        String str = ux;
        com.ss.android.socialbase.downloader.xv.c.xv(str, "stopForeground  service = " + this.f49436f.get() + ",  isServiceAlive = " + this.f49438w);
        try {
            this.xv = false;
            this.f49436f.get().stopForeground(z3);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void c(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.f49435c) {
            String str = ux;
            com.ss.android.socialbase.downloader.xv.c.w(str, "pendDownloadTask pendingTasks.size:" + this.f49435c.size() + " downloadId:" + downloadId);
            List<DownloadTask> list = this.f49435c.get(downloadId);
            if (list == null) {
                list = new ArrayList<>();
                this.f49435c.put(downloadId, list);
            }
            com.ss.android.socialbase.downloader.xv.c.w(str, "before pendDownloadTask taskArray.size:" + list.size());
            list.add(downloadTask);
            com.ss.android.socialbase.downloader.xv.c.w(str, "after pendDownloadTask pendingTasks.size:" + this.f49435c.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.ys
    public void c(int i4) {
        com.ss.android.socialbase.downloader.xv.c.c(i4);
    }
}
