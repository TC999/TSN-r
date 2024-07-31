package com.kwad.framework.filedownloader.services;

import android.util.SparseArray;
import com.kwad.framework.filedownloader.download.DownloadLaunchRunnable;
import com.kwad.framework.filedownloader.p353f.C9490b;
import com.kwad.framework.filedownloader.p353f.C9498d;
import com.kwad.framework.filedownloader.p353f.C9499e;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: Access modifiers changed from: package-private */
/* renamed from: com.kwad.framework.filedownloader.services.h */
/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class C9574h {
    private ThreadPoolExecutor aic;
    private int aie;
    private SparseArray<DownloadLaunchRunnable> aib = new SparseArray<>();
    private final String aid = "Network";
    private int aif = 0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C9574h(int i) {
        this.aic = C9490b.m28551o(i, "Network");
        this.aie = i;
    }

    /* renamed from: wF */
    private synchronized void m28359wF() {
        SparseArray<DownloadLaunchRunnable> sparseArray = new SparseArray<>();
        int size = this.aib.size();
        for (int i = 0; i < size; i++) {
            int keyAt = this.aib.keyAt(i);
            DownloadLaunchRunnable downloadLaunchRunnable = this.aib.get(keyAt);
            if (downloadLaunchRunnable.isAlive()) {
                sparseArray.put(keyAt, downloadLaunchRunnable);
            }
        }
        this.aib = sparseArray;
    }

    /* renamed from: a */
    public final void m28363a(DownloadLaunchRunnable downloadLaunchRunnable) {
        downloadLaunchRunnable.m28648vy();
        synchronized (this) {
            this.aib.put(downloadLaunchRunnable.getId(), downloadLaunchRunnable);
        }
        this.aic.execute(downloadLaunchRunnable);
        int i = this.aif;
        if (i >= 600) {
            m28359wF();
            this.aif = 0;
            return;
        }
        this.aif = i + 1;
    }

    /* renamed from: bK */
    public final boolean m28362bK(int i) {
        DownloadLaunchRunnable downloadLaunchRunnable = this.aib.get(i);
        return downloadLaunchRunnable != null && downloadLaunchRunnable.isAlive();
    }

    /* renamed from: bx */
    public final synchronized boolean m28361bx(int i) {
        if (m28358wG() > 0) {
            C9498d.m28534d(this, "Can't change the max network thread count, because the  network thread pool isn't in IDLE, please try again after all running tasks are completed or invoking FileDownloader#pauseAll directly.", new Object[0]);
            return false;
        }
        int m28531bL = C9499e.m28531bL(i);
        if (C9498d.ail) {
            C9498d.m28535c(this, "change the max network thread count, from %d to %d", Integer.valueOf(this.aie), Integer.valueOf(m28531bL));
        }
        List<Runnable> shutdownNow = this.aic.shutdownNow();
        this.aic = C9490b.m28551o(m28531bL, "Network");
        if (shutdownNow.size() > 0) {
            C9498d.m28534d(this, "recreate the network thread pool and discard %d tasks", Integer.valueOf(shutdownNow.size()));
        }
        this.aie = m28531bL;
        return true;
    }

    public final void cancel(int i) {
        m28359wF();
        synchronized (this) {
            DownloadLaunchRunnable downloadLaunchRunnable = this.aib.get(i);
            if (downloadLaunchRunnable != null) {
                downloadLaunchRunnable.pause();
                boolean remove = this.aic.remove(downloadLaunchRunnable);
                if (C9498d.ail) {
                    C9498d.m28535c(this, "successful cancel %d %B", Integer.valueOf(i), Boolean.valueOf(remove));
                }
            }
            this.aib.remove(i);
        }
    }

    /* renamed from: p */
    public final int m28360p(String str, int i) {
        if (str == null) {
            return 0;
        }
        int size = this.aib.size();
        for (int i2 = 0; i2 < size; i2++) {
            DownloadLaunchRunnable valueAt = this.aib.valueAt(i2);
            if (valueAt != null && valueAt.isAlive() && valueAt.getId() != i && str.equals(valueAt.m28649vD())) {
                return valueAt.getId();
            }
        }
        return 0;
    }

    /* renamed from: wG */
    public final synchronized int m28358wG() {
        m28359wF();
        return this.aib.size();
    }

    /* renamed from: wH */
    public final synchronized List<Integer> m28357wH() {
        ArrayList arrayList;
        m28359wF();
        arrayList = new ArrayList();
        for (int i = 0; i < this.aib.size(); i++) {
            SparseArray<DownloadLaunchRunnable> sparseArray = this.aib;
            arrayList.add(Integer.valueOf(sparseArray.get(sparseArray.keyAt(i)).getId()));
        }
        return arrayList;
    }
}
