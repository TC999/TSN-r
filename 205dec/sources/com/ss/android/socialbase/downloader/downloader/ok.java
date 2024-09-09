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

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public abstract class ok implements t {

    /* renamed from: n  reason: collision with root package name */
    private static final String f49485n = "ok";
    protected volatile boolean bl;
    private WeakReference<Service> kf;
    protected final SparseArray<List<DownloadTask>> ok = new SparseArray<>();

    /* renamed from: a  reason: collision with root package name */
    protected volatile boolean f49486a = false;

    /* renamed from: s  reason: collision with root package name */
    protected volatile boolean f49489s = false;

    /* renamed from: h  reason: collision with root package name */
    private Handler f49487h = new Handler(Looper.getMainLooper());

    /* renamed from: p  reason: collision with root package name */
    private Runnable f49488p = new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.ok.1
        @Override // java.lang.Runnable
        public void run() {
            if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                com.ss.android.socialbase.downloader.bl.ok.a(ok.f49485n, "tryDownload: 2 try");
            }
            if (ok.this.f49486a) {
                return;
            }
            if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                com.ss.android.socialbase.downloader.bl.ok.a(ok.f49485n, "tryDownload: 2 error");
            }
            ok.this.startService(bl.l(), null);
        }
    };

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public boolean a() {
        String str = f49485n;
        com.ss.android.socialbase.downloader.bl.ok.bl(str, "isServiceForeground = " + this.bl);
        return this.bl;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void bl() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void bl(DownloadTask downloadTask) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void n() {
        SparseArray<List<DownloadTask>> clone;
        synchronized (this.ok) {
            String str = f49485n;
            com.ss.android.socialbase.downloader.bl.ok.a(str, "resumePendingTask pendingTasks.size:" + this.ok.size());
            clone = this.ok.clone();
            this.ok.clear();
        }
        com.ss.android.socialbase.downloader.impls.ok fb = bl.fb();
        if (fb != null) {
            for (int i4 = 0; i4 < clone.size(); i4++) {
                List<DownloadTask> list = clone.get(clone.keyAt(i4));
                if (list != null) {
                    for (DownloadTask downloadTask : list) {
                        String str2 = f49485n;
                        com.ss.android.socialbase.downloader.bl.ok.a(str2, "resumePendingTask key:" + downloadTask.getDownloadId());
                        fb.ok(downloadTask);
                    }
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(Intent intent, int i4, int i5) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(rh rhVar) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(WeakReference weakReference) {
        this.kf = weakReference;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void s() {
        this.f49486a = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void startService() {
        if (this.f49486a) {
            return;
        }
        if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
            com.ss.android.socialbase.downloader.bl.ok.a(f49485n, "startService");
        }
        startService(bl.l(), null);
    }

    protected void startService(Context context, ServiceConnection serviceConnection) {
    }

    protected void stopService(Context context, ServiceConnection serviceConnection) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public boolean ok() {
        return this.f49486a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void a(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        if (!this.f49486a) {
            if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                com.ss.android.socialbase.downloader.bl.ok.a(f49485n, "tryDownload but service is not alive");
            }
            if (com.ss.android.socialbase.downloader.q.ok.ok(262144)) {
                ok(downloadTask);
                if (!this.f49489s) {
                    if (com.ss.android.socialbase.downloader.bl.ok.ok()) {
                        com.ss.android.socialbase.downloader.bl.ok.a(f49485n, "tryDownload: 1");
                    }
                    startService(bl.l(), null);
                    this.f49489s = true;
                    return;
                }
                this.f49487h.removeCallbacks(this.f49488p);
                this.f49487h.postDelayed(this.f49488p, 10L);
                return;
            }
            ok(downloadTask);
            startService(bl.l(), null);
            return;
        }
        String str = f49485n;
        com.ss.android.socialbase.downloader.bl.ok.a(str, "tryDownload when isServiceAlive");
        n();
        com.ss.android.socialbase.downloader.impls.ok fb = bl.fb();
        if (fb != null) {
            com.ss.android.socialbase.downloader.bl.ok.a(str, "tryDownload current task: " + downloadTask.getDownloadId());
            fb.ok(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public IBinder ok(Intent intent) {
        com.ss.android.socialbase.downloader.bl.ok.a(f49485n, "onBind Abs");
        return new Binder();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(int i4, Notification notification) {
        WeakReference<Service> weakReference = this.kf;
        if (weakReference != null && weakReference.get() != null) {
            String str = f49485n;
            com.ss.android.socialbase.downloader.bl.ok.bl(str, "startForeground  id = " + i4 + ", service = " + this.kf.get() + ",  isServiceAlive = " + this.f49486a);
            try {
                this.kf.get().startForeground(i4, notification);
                this.bl = true;
                return;
            } catch (Exception e4) {
                e4.printStackTrace();
                return;
            }
        }
        com.ss.android.socialbase.downloader.bl.ok.s(f49485n, "startForeground: downloadService is null, do nothing!");
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(boolean z3) {
        WeakReference<Service> weakReference = this.kf;
        if (weakReference == null || weakReference.get() == null) {
            return;
        }
        String str = f49485n;
        com.ss.android.socialbase.downloader.bl.ok.bl(str, "stopForeground  service = " + this.kf.get() + ",  isServiceAlive = " + this.f49486a);
        try {
            this.bl = false;
            this.kf.get().stopForeground(z3);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void ok(DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        int downloadId = downloadTask.getDownloadId();
        synchronized (this.ok) {
            String str = f49485n;
            com.ss.android.socialbase.downloader.bl.ok.a(str, "pendDownloadTask pendingTasks.size:" + this.ok.size() + " downloadId:" + downloadId);
            List<DownloadTask> list = this.ok.get(downloadId);
            if (list == null) {
                list = new ArrayList<>();
                this.ok.put(downloadId, list);
            }
            com.ss.android.socialbase.downloader.bl.ok.a(str, "before pendDownloadTask taskArray.size:" + list.size());
            list.add(downloadTask);
            com.ss.android.socialbase.downloader.bl.ok.a(str, "after pendDownloadTask pendingTasks.size:" + this.ok.size());
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.t
    public void ok(int i4) {
        com.ss.android.socialbase.downloader.bl.ok.ok(i4);
    }
}
