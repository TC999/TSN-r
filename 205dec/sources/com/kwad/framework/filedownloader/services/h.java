package com.kwad.framework.filedownloader.services;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class h {
    private ThreadPoolExecutor aic;
    private int aie;
    private SparseArray<DownloadLaunchRunnable> aib = new SparseArray<>();
    private final String aid = "Network";
    private int aif = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(int i4) {
        this.aic = com.kwad.framework.filedownloader.f.b.o(i4, "Network");
        this.aie = i4;
    }

    private synchronized void wF() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.aib.size();
        for (int i4 = 0; i4 < size; i4++) {
            int keyAt = this.aib.keyAt(i4);
            DownloadLaunchRunnable downloadLaunchRunnable = this.aib.get(keyAt);
            if (downloadLaunchRunnable.isAlive()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.aib = sparseArray;
    }

    public final void a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.vy();
        synchronized (this) {
            this.aib.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.aic.execute(downloadLaunchRunnable);
        int i4 = this.aif;
        if (i4 >= 600) {
            wF();
            this.aif = 0;
            return;
        }
        this.aif = i4 + 1;
    }

    public final boolean bK(int i4) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.aib.get(i4);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
    }

    public final synchronized boolean bx(int i4) {
        if (wG() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int bL = com.kwad.framework.filedownloader.f.e.bL(i4);
        if (com.kwad.framework.filedownloader.f.d.ail) {
            com.kwad.framework.filedownloader.f.d.c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.aie), Integer.valueOf(bL));
        }
        List<Runnable> shutdownNow = this.aic.shutdownNow();
        this.aic = com.kwad.framework.filedownloader.f.b.o(bL, "Network");
        if (shutdownNow.size() > 0) {
            com.kwad.framework.filedownloader.f.d.d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.aie = bL;
        return true;
    }

    public final void cancel(int i4) {
        wF();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.aib.get(i4);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.pause();
                boolean remove = this.aic.remove(downloadLaunchRunnable);
                if (com.kwad.framework.filedownloader.f.d.ail) {
                    com.kwad.framework.filedownloader.f.d.c(this, "successful cancel %d %B", Integer.valueOf(i4), Boolean.valueOf(remove));
                }
            }
            this.aib.remove(i4);
        }
    }

    public final int p(String str, int i4) {
        if (str == null) {
            return 0;
        }
        int size = this.aib.size();
        for (int i5 = 0; i5 < size; i5++) {
            DownloadLaunchRunnable valueAt = this.aib.valueAt(i5);
            if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i4 && str.equals(valueAt.vD())) {
                return valueAt.getId();
            }
        }
        return 0;
    }

    public final synchronized int wG() {
        wF();
        return this.aib.size();
    }

    public final synchronized List<Integer> wH() {
        ArrayList arrayList;
        wF();
        arrayList = new ArrayList();
        for (int i4 = 0; i4 < this.aib.size(); i4++) {
            SparseArray<DownloadLaunchRunnable> sparseArray = this.aib;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i4)).getId()));
        }
        return arrayList;
    }
}
