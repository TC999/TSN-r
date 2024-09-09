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

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class n extends ok {

    /* renamed from: a  reason: collision with root package name */
    private static com.ss.android.socialbase.downloader.p.s f49759a;

    public n() {
        f49759a = new com.ss.android.socialbase.downloader.p.s();
    }

    public static void bl(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService x3 = com.ss.android.socialbase.downloader.downloader.bl.x();
        if (x3 != null) {
            x3.invokeAll(list);
        }
    }

    public static Runnable n(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService x3 = com.ss.android.socialbase.downloader.downloader.bl.x();
                if ((x3 instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) x3).getQueue()) != null && !queue.isEmpty()) {
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
                com.ss.android.socialbase.downloader.bl.ok.s("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    public static List<Future> s(List<Runnable> list) {
        ExecutorService x3 = com.ss.android.socialbase.downloader.downloader.bl.x();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable runnable : list) {
            arrayList.add(x3.submit(runnable));
        }
        return arrayList;
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public void a(int i4) {
        com.ss.android.socialbase.downloader.p.s sVar = f49759a;
        if (sVar == null) {
            return;
        }
        sVar.bl(i4);
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public boolean ok(int i4) {
        DownloadInfo s3;
        com.ss.android.socialbase.downloader.p.s sVar = f49759a;
        if (sVar == null || !sVar.ok(i4) || (s3 = s(i4)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(s3.getStatus())) {
            return true;
        }
        a(i4);
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    protected com.ss.android.socialbase.downloader.p.bl bl(int i4) {
        com.ss.android.socialbase.downloader.p.s sVar = f49759a;
        if (sVar == null) {
            return null;
        }
        return sVar.a(i4);
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public void ok(com.ss.android.socialbase.downloader.p.bl blVar) {
        com.ss.android.socialbase.downloader.p.s sVar = f49759a;
        if (sVar == null) {
            return;
        }
        sVar.a(blVar);
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public void ok(int i4, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.a(IDownloadTask.TAG, "start doDownload for task : " + i4);
        f49759a.ok(new com.ss.android.socialbase.downloader.p.bl(downloadTask, this.ok));
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public List<Integer> ok() {
        return f49759a.ok();
    }

    @Override // com.ss.android.socialbase.downloader.impls.ok
    public void ok(int i4, long j4) {
        com.ss.android.socialbase.downloader.p.s sVar = f49759a;
        if (sVar == null) {
            return;
        }
        sVar.ok(i4, j4);
    }
}
