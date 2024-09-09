package com.ss.android.socialbase.downloader.ev;

import android.util.SparseArray;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static ExecutorService f49542c = new com.bytedance.sdk.component.gd.sr.sr(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new c("Download_OP_Thread"));
    private int xv = 0;

    /* renamed from: w  reason: collision with root package name */
    private volatile SparseArray<xv> f49543w = new SparseArray<>();

    public static void c(Runnable runnable) {
        f49542c.execute(runnable);
    }

    private void w() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < this.f49543w.size(); i4++) {
                int keyAt = this.f49543w.keyAt(i4);
                if (!this.f49543w.get(keyAt).sr()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                Integer num = (Integer) arrayList.get(i5);
                if (num != null) {
                    this.f49543w.remove(num.intValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void xv(int i4) {
        synchronized (sr.class) {
            w();
            xv xvVar = this.f49543w.get(i4);
            if (xvVar != null) {
                xvVar.c();
                xv(xvVar);
                this.f49543w.remove(i4);
            }
        }
    }

    public void c(xv xvVar) {
        xvVar.f();
        synchronized (sr.class) {
            int i4 = this.xv;
            if (i4 >= 500) {
                w();
                this.xv = 0;
            } else {
                this.xv = i4 + 1;
            }
            this.f49543w.put(xvVar.ux(), xvVar);
        }
        DownloadTask xv = xvVar.xv();
        try {
            ExecutorService fp = com.ss.android.socialbase.downloader.downloader.xv.fp();
            if (xv != null && xv.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(xv.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.r.c.xv().c("divide_plugin", 1) == 1) {
                    xv.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = xv.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    fp = com.ss.android.socialbase.downloader.downloader.xv.t();
                } else if (executorGroup == 4) {
                    fp = com.ss.android.socialbase.downloader.downloader.xv.ys();
                }
            }
            if (fp != null) {
                if (com.ss.android.socialbase.downloader.r.c.c(xvVar.ux()).w("pause_with_interrupt", false)) {
                    xvVar.c(fp.submit(xvVar));
                    return;
                } else {
                    fp.execute(xvVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.sr.c.c(xv.getMonitorDepend(), xv.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), xv.getDownloadInfo() != null ? xv.getDownloadInfo().getStatus() : 0);
        } catch (Exception e4) {
            if (xv != null) {
                com.ss.android.socialbase.downloader.sr.c.c(xv.getMonitorDepend(), xv.getDownloadInfo(), new BaseException(1003, com.ss.android.socialbase.downloader.gd.f.w(e4, "DownloadThreadPoolExecute")), xv.getDownloadInfo() != null ? xv.getDownloadInfo().getStatus() : 0);
            }
            e4.printStackTrace();
        } catch (OutOfMemoryError e5) {
            if (xv != null) {
                com.ss.android.socialbase.downloader.sr.c.c(xv.getMonitorDepend(), xv.getDownloadInfo(), new BaseException(1003, "execute OOM"), xv.getDownloadInfo() != null ? xv.getDownloadInfo().getStatus() : 0);
            }
            e5.printStackTrace();
        }
    }

    private void xv(xv xvVar) {
        Future r3;
        if (xvVar == null) {
            return;
        }
        try {
            ExecutorService fp = com.ss.android.socialbase.downloader.downloader.xv.fp();
            DownloadTask xv = xvVar.xv();
            if (xv != null && xv.getDownloadInfo() != null) {
                int executorGroup = xv.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    fp = com.ss.android.socialbase.downloader.downloader.xv.t();
                } else if (executorGroup == 4) {
                    fp = com.ss.android.socialbase.downloader.downloader.xv.ys();
                }
            }
            if (fp == null || !(fp instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) fp).remove(xvVar);
            if (!com.ss.android.socialbase.downloader.r.c.c(xvVar.ux()).w("pause_with_interrupt", false) || (r3 = xvVar.r()) == null) {
                return;
            }
            r3.cancel(true);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void w(xv xvVar) {
        if (xvVar == null) {
            return;
        }
        synchronized (sr.class) {
            try {
                if (com.ss.android.socialbase.downloader.gd.c.c(524288)) {
                    int indexOfValue = this.f49543w.indexOfValue(xvVar);
                    if (indexOfValue >= 0) {
                        this.f49543w.removeAt(indexOfValue);
                    }
                } else {
                    this.f49543w.remove(xvVar.ux());
                }
            }
        }
    }

    public xv w(int i4) {
        synchronized (sr.class) {
            w();
            xv xvVar = this.f49543w.get(i4);
            if (xvVar != null) {
                xvVar.w();
                xv(xvVar);
                this.f49543w.remove(i4);
                return xvVar;
            }
            return null;
        }
    }

    public boolean c(int i4) {
        synchronized (sr.class) {
            boolean z3 = false;
            if (this.f49543w != null && this.f49543w.size() > 0) {
                xv xvVar = this.f49543w.get(i4);
                if (xvVar != null && xvVar.sr()) {
                    z3 = true;
                }
                return z3;
            }
            return false;
        }
    }

    public List<Integer> c() {
        ArrayList arrayList;
        synchronized (sr.class) {
            w();
            arrayList = new ArrayList();
            for (int i4 = 0; i4 < this.f49543w.size(); i4++) {
                xv xvVar = this.f49543w.get(this.f49543w.keyAt(i4));
                if (xvVar != null) {
                    arrayList.add(Integer.valueOf(xvVar.ux()));
                }
            }
        }
        return arrayList;
    }

    public void c(int i4, long j4) {
        xv xvVar = this.f49543w.get(i4);
        if (xvVar != null) {
            xvVar.xv(j4);
        }
    }
}
