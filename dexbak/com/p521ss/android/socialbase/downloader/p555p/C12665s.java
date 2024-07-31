package com.p521ss.android.socialbase.downloader.p555p;

import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p556q.C12717ok;
import com.p521ss.android.socialbase.downloader.p557s.C12723ok;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.ss.android.socialbase.downloader.p.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12665s {

    /* renamed from: ok */
    private static ExecutorService f35729ok = new ThreadPoolExecutor(2, 2, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC12662ok("Download_OP_Thread"));

    /* renamed from: bl */
    private int f35731bl = 0;

    /* renamed from: a */
    private volatile SparseArray<RunnableC12652bl> f35730a = new SparseArray<>();

    /* renamed from: a */
    private void m16743a() {
        try {
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < this.f35730a.size(); i++) {
                int keyAt = this.f35730a.keyAt(i);
                if (!this.f35730a.get(keyAt).m16782s()) {
                    arrayList.add(Integer.valueOf(keyAt));
                }
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                Integer num = (Integer) arrayList.get(i2);
                if (num != null) {
                    this.f35730a.remove(num.intValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: ok */
    public static void m16734ok(Runnable runnable) {
        f35729ok.execute(runnable);
    }

    /* renamed from: bl */
    public void m16740bl(int i) {
        synchronized (C12665s.class) {
            m16743a();
            RunnableC12652bl runnableC12652bl = this.f35730a.get(i);
            if (runnableC12652bl != null) {
                runnableC12652bl.m16804ok();
                m16739bl(runnableC12652bl);
                this.f35730a.remove(i);
            }
        }
    }

    /* renamed from: ok */
    public void m16735ok(RunnableC12652bl runnableC12652bl) {
        runnableC12652bl.m16809kf();
        synchronized (C12665s.class) {
            int i = this.f35731bl;
            if (i >= 500) {
                m16743a();
                this.f35731bl = 0;
            } else {
                this.f35731bl = i + 1;
            }
            this.f35730a.put(runnableC12652bl.m16806n(), runnableC12652bl);
        }
        DownloadTask m16824bl = runnableC12652bl.m16824bl();
        try {
            ExecutorService m17814i = C12490bl.m17814i();
            if (m16824bl != null && m16824bl.getDownloadInfo() != null) {
                if ("mime_type_plg".equals(m16824bl.getDownloadInfo().getMimeType()) && C12534ok.m17605bl().m17593ok("divide_plugin", 1) == 1) {
                    m16824bl.getDownloadInfo().safePutToDBJsonData("executor_group", 3);
                }
                int executorGroup = m16824bl.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    m17814i = C12490bl.m17762rh();
                } else if (executorGroup == 4) {
                    m17814i = C12490bl.m17758t();
                }
            }
            if (m17814i != null) {
                if (C12534ok.m17599ok(runnableC12652bl.m16806n()).m17606a("pause_with_interrupt", false)) {
                    runnableC12652bl.m16787ok(m17814i.submit(runnableC12652bl));
                    return;
                } else {
                    m17814i.execute(runnableC12652bl);
                    return;
                }
            }
            C12723ok.m16492ok(m16824bl.getMonitorDepend(), m16824bl.getDownloadInfo(), new BaseException(1003, "execute failed cpu thread executor service is null"), m16824bl.getDownloadInfo() != null ? m16824bl.getDownloadInfo().getStatus() : 0);
        } catch (Exception e) {
            if (m16824bl != null) {
                C12723ok.m16492ok(m16824bl.getMonitorDepend(), m16824bl.getDownloadInfo(), new BaseException(1003, C12713kf.m16608a(e, "DownloadThreadPoolExecute")), m16824bl.getDownloadInfo() != null ? m16824bl.getDownloadInfo().getStatus() : 0);
            }
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            if (m16824bl != null) {
                C12723ok.m16492ok(m16824bl.getMonitorDepend(), m16824bl.getDownloadInfo(), new BaseException(1003, "execute OOM"), m16824bl.getDownloadInfo() != null ? m16824bl.getDownloadInfo().getStatus() : 0);
            }
            e2.printStackTrace();
        }
    }

    /* renamed from: bl */
    private void m16739bl(RunnableC12652bl runnableC12652bl) {
        Future m16814h;
        if (runnableC12652bl == null) {
            return;
        }
        try {
            ExecutorService m17814i = C12490bl.m17814i();
            DownloadTask m16824bl = runnableC12652bl.m16824bl();
            if (m16824bl != null && m16824bl.getDownloadInfo() != null) {
                int executorGroup = m16824bl.getDownloadInfo().getExecutorGroup();
                if (executorGroup == 3) {
                    m17814i = C12490bl.m17762rh();
                } else if (executorGroup == 4) {
                    m17814i = C12490bl.m17758t();
                }
            }
            if (m17814i == null || !(m17814i instanceof ThreadPoolExecutor)) {
                return;
            }
            ((ThreadPoolExecutor) m17814i).remove(runnableC12652bl);
            if (!C12534ok.m17599ok(runnableC12652bl.m16806n()).m17606a("pause_with_interrupt", false) || (m16814h = runnableC12652bl.m16814h()) == null) {
                return;
            }
            m16814h.cancel(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m16741a(RunnableC12652bl runnableC12652bl) {
        if (runnableC12652bl == null) {
            return;
        }
        synchronized (C12665s.class) {
            try {
                if (C12717ok.m16510ok(524288)) {
                    int indexOfValue = this.f35730a.indexOfValue(runnableC12652bl);
                    if (indexOfValue >= 0) {
                        this.f35730a.removeAt(indexOfValue);
                    }
                } else {
                    this.f35730a.remove(runnableC12652bl.m16806n());
                }
            }
        }
    }

    /* renamed from: a */
    public RunnableC12652bl m16742a(int i) {
        synchronized (C12665s.class) {
            m16743a();
            RunnableC12652bl runnableC12652bl = this.f35730a.get(i);
            if (runnableC12652bl != null) {
                runnableC12652bl.m16826a();
                m16739bl(runnableC12652bl);
                this.f35730a.remove(i);
                return runnableC12652bl;
            }
            return null;
        }
    }

    /* renamed from: ok */
    public boolean m16737ok(int i) {
        synchronized (C12665s.class) {
            boolean z = false;
            if (this.f35730a != null && this.f35730a.size() > 0) {
                RunnableC12652bl runnableC12652bl = this.f35730a.get(i);
                if (runnableC12652bl != null && runnableC12652bl.m16782s()) {
                    z = true;
                }
                return z;
            }
            return false;
        }
    }

    /* renamed from: ok */
    public List<Integer> m16738ok() {
        ArrayList arrayList;
        synchronized (C12665s.class) {
            m16743a();
            arrayList = new ArrayList();
            for (int i = 0; i < this.f35730a.size(); i++) {
                RunnableC12652bl runnableC12652bl = this.f35730a.get(this.f35730a.keyAt(i));
                if (runnableC12652bl != null) {
                    arrayList.add(Integer.valueOf(runnableC12652bl.m16806n()));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: ok */
    public void m16736ok(int i, long j) {
        RunnableC12652bl runnableC12652bl = this.f35730a.get(i);
        if (runnableC12652bl != null) {
            runnableC12652bl.m16823bl(j);
        }
    }
}
