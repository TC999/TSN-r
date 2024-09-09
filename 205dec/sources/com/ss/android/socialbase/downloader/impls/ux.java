package com.ss.android.socialbase.downloader.impls;

import com.mbridge.msdk.foundation.download.core.IDownloadTask;
import com.ss.android.socialbase.downloader.constants.DownloadStatus;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ux extends c {

    /* renamed from: w  reason: collision with root package name */
    private static com.ss.android.socialbase.downloader.ev.sr f49822w;

    public ux() {
        f49822w = new com.ss.android.socialbase.downloader.ev.sr();
    }

    public static List<Future> sr(List<Runnable> list) {
        ExecutorService ia = com.ss.android.socialbase.downloader.downloader.xv.ia();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable runnable : list) {
            arrayList.add(ia.submit(runnable));
        }
        return arrayList;
    }

    public static Runnable ux(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService ia = com.ss.android.socialbase.downloader.downloader.xv.ia();
                if ((ia instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) ia).getQueue()) != null && !queue.isEmpty()) {
                    Iterator<Future> it = list.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            runnable = null;
                            break;
                        }
                        Future next = it.next();
                        if ((next instanceof Runnable) && queue.remove(next)) {
                            runnable = (Runnable) next;
                            break;
                        }
                    }
                    if (runnable != null) {
                        list.remove(runnable);
                        return runnable;
                    }
                }
            } catch (Throwable th) {
                com.ss.android.socialbase.downloader.xv.c.sr("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    public static void xv(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService ia = com.ss.android.socialbase.downloader.downloader.xv.ia();
        if (ia != null) {
            ia.invokeAll(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.impls.c
    public boolean c(int i4) {
        DownloadInfo sr;
        com.ss.android.socialbase.downloader.ev.sr srVar = f49822w;
        if (srVar == null || !srVar.c(i4) || (sr = sr(i4)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(sr.getStatus())) {
            return true;
        }
        w(i4);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.c
    public void w(int i4) {
        com.ss.android.socialbase.downloader.ev.sr srVar = f49822w;
        if (srVar == null) {
            return;
        }
        srVar.xv(i4);
    }

    @Override // com.ss.android.socialbase.downloader.impls.c
    protected com.ss.android.socialbase.downloader.ev.xv xv(int i4) {
        com.ss.android.socialbase.downloader.ev.sr srVar = f49822w;
        if (srVar == null) {
            return null;
        }
        return srVar.w(i4);
    }

    @Override // com.ss.android.socialbase.downloader.impls.c
    public void c(com.ss.android.socialbase.downloader.ev.xv xvVar) {
        com.ss.android.socialbase.downloader.ev.sr srVar = f49822w;
        if (srVar == null) {
            return;
        }
        srVar.w(xvVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.c
    public void c(int i4, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.xv.c.w(IDownloadTask.TAG, "start doDownload for task : " + i4);
        f49822w.c(new com.ss.android.socialbase.downloader.ev.xv(downloadTask, this.f49728c));
    }

    @Override // com.ss.android.socialbase.downloader.impls.c
    public List<Integer> c() {
        return f49822w.c();
    }

    @Override // com.ss.android.socialbase.downloader.impls.c
    public void c(int i4, long j4) {
        com.ss.android.socialbase.downloader.ev.sr srVar = f49822w;
        if (srVar == null) {
            return;
        }
        srVar.c(i4, j4);
    }
}
