package com.p521ss.android.socialbase.downloader.impls;

import com.mbridge.msdk.foundation.download.core.IDownloadTask;
import com.p521ss.android.socialbase.downloader.constants.DownloadStatus;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p555p.C12665s;
import com.p521ss.android.socialbase.downloader.p555p.RunnableC12652bl;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/* renamed from: com.ss.android.socialbase.downloader.impls.n */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12546n extends AbstractC12547ok {

    /* renamed from: a */
    private static C12665s f35222a;

    public C12546n() {
        f35222a = new C12665s();
    }

    /* renamed from: bl */
    public static void m17582bl(List<Callable<Object>> list) throws InterruptedException {
        ExecutorService m17749x = C12490bl.m17749x();
        if (m17749x != null) {
            m17749x.invokeAll(list);
        }
    }

    /* renamed from: n */
    public static Runnable m17581n(List<Future> list) {
        BlockingQueue<Runnable> queue;
        Runnable runnable;
        if (list != null && !list.isEmpty()) {
            try {
                ExecutorService m17749x = C12490bl.m17749x();
                if ((m17749x instanceof ThreadPoolExecutor) && (queue = ((ThreadPoolExecutor) m17749x).getQueue()) != null && !queue.isEmpty()) {
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
                C12409ok.m17894s("DefaultDownloadEngine", "getUnstartedTask() error: " + th.toString());
            }
        }
        return null;
    }

    /* renamed from: s */
    public static List<Future> m17580s(List<Runnable> list) {
        ExecutorService m17749x = C12490bl.m17749x();
        ArrayList arrayList = new ArrayList(list.size());
        for (Runnable runnable : list) {
            arrayList.add(m17749x.submit(runnable));
        }
        return arrayList;
    }

    @Override // com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok
    /* renamed from: a */
    public void mo17578a(int i) {
        C12665s c12665s = f35222a;
        if (c12665s == null) {
            return;
        }
        c12665s.m16740bl(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok
    /* renamed from: ok */
    public boolean mo17558ok(int i) {
        DownloadInfo m17536s;
        C12665s c12665s = f35222a;
        if (c12665s == null || !c12665s.m16737ok(i) || (m17536s = m17536s(i)) == null) {
            return false;
        }
        if (DownloadStatus.isDownloading(m17536s.getStatus())) {
            return true;
        }
        mo17578a(i);
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok
    /* renamed from: bl */
    protected RunnableC12652bl mo17569bl(int i) {
        C12665s c12665s = f35222a;
        if (c12665s == null) {
            return null;
        }
        return c12665s.m16742a(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok
    /* renamed from: ok */
    public void mo17543ok(RunnableC12652bl runnableC12652bl) {
        C12665s c12665s = f35222a;
        if (c12665s == null) {
            return;
        }
        c12665s.m16741a(runnableC12652bl);
    }

    @Override // com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok
    /* renamed from: ok */
    public void mo17550ok(int i, DownloadTask downloadTask) {
        if (downloadTask == null) {
            return;
        }
        C12409ok.m17904a(IDownloadTask.TAG, "start doDownload for task : " + i);
        f35222a.m16735ok(new RunnableC12652bl(downloadTask, this.f35229ok));
    }

    @Override // com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok
    /* renamed from: ok */
    public List<Integer> mo17559ok() {
        return f35222a.m16738ok();
    }

    @Override // com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok
    /* renamed from: ok */
    public void mo17553ok(int i, long j) {
        C12665s c12665s = f35222a;
        if (c12665s == null) {
            return;
        }
        c12665s.m16736ok(i, j);
    }
}
