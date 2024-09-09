package com.ss.android.socialbase.downloader.p;

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

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {
    private static ExecutorService ok = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ok("Download_OP_Thread"));
    private int bl = 0;

    /* renamed from: a  reason: collision with root package name */
    private volatile SparseArray<bl> f50141a = new SparseArray<>();

    private void a() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i4 = 0; i4 < this.f50141a.size(); i4++) {
                int keyAt = this.f50141a.keyAt(i4);
                if (!this.f50141a.get(keyAt).s()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i5 = 0; i5 < arrayList.size(); i5++) {
                Integer num = (Integer) arrayList.get(i5);
                if (num != null) {
                    this.f50141a.remove(num.intValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void ok(Runnable runnable) {
        ok.execute(runnable);
    }

    public void bl(int i4) {
        synchronized (s.class) {
            a();
            bl blVar = this.f50141a.get(i4);
            if (blVar != null) {
                blVar.ok();
                bl(blVar);
                this.f50141a.remove(i4);
            }
        }
    }

    public void ok(bl blVar) {
        blVar.kf();
        synchronized (s.class) {
            int i4 = this.bl;
            if (i4 >= 500) {
                a();
                this.bl = 0;
            } else {
                this.bl = i4 + 1;
            }
            this.f50141a.put(blVar.n(), blVar);
        }
        DownloadTask bl = blVar.bl();
        try {
            ExecutorService i5 = com.ss.android.socialbase.downloader.downloader.bl.i();
            if (bl != null && bl.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(bl.getDownloadInfo().getMimeType()) && com.ss.android.socialbase.downloader.h.ok.bl().ok("divide_plugin", 1) == 1) {
                    bl.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = bl.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    i5 = com.ss.android.socialbase.downloader.downloader.bl.rh();
                } else if (executorGroup == 4) {
                    i5 = com.ss.android.socialbase.downloader.downloader.bl.t();
                }
            }
            if (i5 != null) {
                if (com.ss.android.socialbase.downloader.h.ok.ok(blVar.n()).a("pause_with_interrupt", false)) {
                    blVar.ok(i5.submit(blVar));
                    return;
                } else {
                    i5.execute(blVar);
                    return;
                }
            }
            com.ss.android.socialbase.downloader.s.ok.ok(bl.getMonitorDepend(), bl.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), bl.getDownloadInfo() != null ? bl.getDownloadInfo().getStatus() : 0);
        } catch (Exception e4) {
            if (bl != null) {
                com.ss.android.socialbase.downloader.s.ok.ok(bl.getMonitorDepend(), bl.getDownloadInfo(), new BaseException(1003, com.ss.android.socialbase.downloader.q.kf.a(e4, "DownloadThreadPoolExecute")), bl.getDownloadInfo() != null ? bl.getDownloadInfo().getStatus() : 0);
            }
            e4.printStackTrace();
        } catch (OutOfMemoryError e5) {
            if (bl != null) {
                com.ss.android.socialbase.downloader.s.ok.ok(bl.getMonitorDepend(), bl.getDownloadInfo(), new BaseException(1003, "execute OOM"), bl.getDownloadInfo() != null ? bl.getDownloadInfo().getStatus() : 0);
            }
            e5.printStackTrace();
        }
    }

    private void bl(bl blVar) {
        Future h4;
        if (blVar == null) {
            return;
        }
        try {
            ExecutorService i4 = com.ss.android.socialbase.downloader.downloader.bl.i();
            DownloadTask bl = blVar.bl();
            if (bl != null && bl.getDownloadInfo() != null) {
                int executorGroup = bl.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    i4 = com.ss.android.socialbase.downloader.downloader.bl.rh();
                } else if (executorGroup == 4) {
                    i4 = com.ss.android.socialbase.downloader.downloader.bl.t();
                }
            }
            if (i4 == null || !(i4 instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) i4).remove(blVar);
            if (!com.ss.android.socialbase.downloader.h.ok.ok(blVar.n()).a("pause_with_interrupt", false) || (h4 = blVar.h()) == null) {
                return;
            }
            h4.cancel(true);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    public void a(bl blVar) {
        if (blVar == null) {
            return;
        }
        synchronized (s.class) {
            try {
                if (com.ss.android.socialbase.downloader.q.ok.ok(524288)) {
                    int indexOfValue = this.f50141a.indexOfValue(blVar);
                    if (indexOfValue >= 0) {
                        this.f50141a.removeAt(indexOfValue);
                    }
                } else {
                    this.f50141a.remove(blVar.n());
                }
            }
        }
    }

    public bl a(int i4) {
        synchronized (s.class) {
            a();
            bl blVar = this.f50141a.get(i4);
            if (blVar != null) {
                blVar.a();
                bl(blVar);
                this.f50141a.remove(i4);
                return blVar;
            }
            return null;
        }
    }

    public boolean ok(int i4) {
        synchronized (s.class) {
            boolean z3 = false;
            if (this.f50141a != null && this.f50141a.size() > 0) {
                bl blVar = this.f50141a.get(i4);
                if (blVar != null && blVar.s()) {
                    z3 = true;
                }
                return z3;
            }
            return false;
        }
    }

    public List<Integer> ok() {
        ArrayList arrayList;
        synchronized (s.class) {
            a();
            arrayList = new ArrayList();
            for (int i4 = 0; i4 < this.f50141a.size(); i4++) {
                bl blVar = this.f50141a.get(this.f50141a.keyAt(i4));
                if (blVar != null) {
                    arrayList.add(Integer.valueOf(blVar.n()));
                }
            }
        }
        return arrayList;
    }

    public void ok(int i4, long j4) {
        bl blVar = this.f50141a.get(i4);
        if (blVar != null) {
            blVar.bl(j4);
        }
    }
}
