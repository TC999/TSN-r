package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ba;
import com.ss.android.socialbase.downloader.depend.me;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr {

    /* renamed from: c  reason: collision with root package name */
    private static volatile sr f49494c;

    /* renamed from: w  reason: collision with root package name */
    private volatile SparseArray<Boolean> f49495w = new SparseArray<>();
    private Handler xv = new Handler(Looper.getMainLooper());
    private volatile List<ba> sr = new ArrayList();

    public static sr c() {
        if (f49494c == null) {
            synchronized (sr.class) {
                f49494c = new sr();
            }
        }
        return f49494c;
    }

    public com.ss.android.socialbase.downloader.depend.n a(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return null;
        }
        return xv.ia(i4);
    }

    public me bk(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return null;
        }
        return xv.s(i4);
    }

    public long ev(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return 0L;
        }
        return xv.ux(i4);
    }

    public void f(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return;
        }
        xv.xv(i4);
    }

    public void fp(int i4) {
        bk c4 = com.ss.android.socialbase.downloader.impls.a.c(false);
        if (c4 != null) {
            c4.k(i4);
        }
        bk c5 = com.ss.android.socialbase.downloader.impls.a.c(true);
        if (c5 != null) {
            c5.k(i4);
        }
    }

    public int gd(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return 0;
        }
        return xv.f(i4);
    }

    public void ia(int i4) {
        if (i4 == 0) {
            return;
        }
        w(i4, true);
        bk c4 = com.ss.android.socialbase.downloader.impls.a.c(true);
        if (c4 == null) {
            return;
        }
        c4.startService();
    }

    public DownloadInfo k(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return null;
        }
        return xv.ev(i4);
    }

    public boolean p(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return false;
        }
        return xv.r(i4);
    }

    public void r(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return;
        }
        xv.sr(i4);
    }

    public IDownloadFileUriProvider s(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return null;
        }
        return xv.fz(i4);
    }

    public void sr(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return;
        }
        xv.c(i4);
    }

    public void t(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return;
        }
        xv.p(i4);
    }

    public boolean ux(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return false;
        }
        return xv.w(i4);
    }

    public void w(ba baVar) {
        if (baVar == null) {
            return;
        }
        synchronized (this.sr) {
            if (this.sr.contains(baVar)) {
                this.sr.remove(baVar);
            }
        }
    }

    public bk xv(int i4) {
        boolean z3 = true;
        return com.ss.android.socialbase.downloader.impls.a.c((c(i4) != 1 || com.ss.android.socialbase.downloader.gd.f.xv()) ? false : false);
    }

    public boolean ys(int i4) {
        bk xv = xv(i4);
        if (xv == null) {
            return false;
        }
        return xv.a(i4);
    }

    public void xv(int i4, boolean z3) {
        if (com.ss.android.socialbase.downloader.gd.f.c()) {
            if (com.ss.android.socialbase.downloader.gd.c.c(8388608)) {
                bk c4 = com.ss.android.socialbase.downloader.impls.a.c(true);
                if (c4 != null) {
                    c4.c(i4, z3);
                }
                bk c5 = com.ss.android.socialbase.downloader.impls.a.c(false);
                if (c5 != null) {
                    c5.c(i4, z3);
                    return;
                }
                return;
            }
            bk c6 = com.ss.android.socialbase.downloader.impls.a.c(false);
            if (c6 != null) {
                c6.c(i4, z3);
            }
            bk c7 = com.ss.android.socialbase.downloader.impls.a.c(true);
            if (c7 != null) {
                c7.c(i4, z3);
                return;
            }
            return;
        }
        bk xv = xv(i4);
        if (xv != null) {
            xv.c(i4, z3);
        }
        com.ss.android.socialbase.downloader.impls.a.c(true).c(2, i4);
    }

    public boolean f() {
        bk c4 = com.ss.android.socialbase.downloader.impls.a.c(false);
        if (c4 != null) {
            return c4.ux();
        }
        return false;
    }

    public void sr(int i4, boolean z3) {
        bk xv = xv(i4);
        if (xv == null) {
            return;
        }
        xv.w(i4, z3);
    }

    public List<DownloadInfo> ux(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        bk c4 = com.ss.android.socialbase.downloader.impls.a.c(false);
        List<DownloadInfo> ux = c4 != null ? c4.ux(str) : null;
        bk c5 = com.ss.android.socialbase.downloader.impls.a.c(true);
        return c(ux, c5 != null ? c5.ux(str) : null, sparseArray);
    }

    public boolean sr() {
        return xv.vc();
    }

    public void w() {
        synchronized (this.sr) {
            for (ba baVar : this.sr) {
                if (baVar != null) {
                    baVar.c();
                }
            }
        }
    }

    public void c(ba baVar) {
        if (baVar == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.gd.f.xv()) {
            baVar.c();
            return;
        }
        if (com.ss.android.socialbase.downloader.impls.a.c(true).r()) {
            baVar.c();
        }
        synchronized (this.sr) {
            if (!this.sr.contains(baVar)) {
                this.sr.add(baVar);
            }
        }
    }

    public List<DownloadInfo> sr(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        bk c4 = com.ss.android.socialbase.downloader.impls.a.c(false);
        List<DownloadInfo> sr = c4 != null ? c4.sr(str) : null;
        bk c5 = com.ss.android.socialbase.downloader.impls.a.c(true);
        return c(sr, c5 != null ? c5.sr(str) : null, sparseArray);
    }

    public List<DownloadInfo> ux() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        bk c4 = com.ss.android.socialbase.downloader.impls.a.c(false);
        List<DownloadInfo> sr = c4 != null ? c4.sr() : null;
        bk c5 = com.ss.android.socialbase.downloader.impls.a.c(true);
        return c(sr, c5 != null ? c5.sr() : null, sparseArray);
    }

    public synchronized void w(int i4, boolean z3) {
        this.f49495w.put(i4, z3 ? Boolean.TRUE : Boolean.FALSE);
    }

    public synchronized int w(int i4) {
        if (this.f49495w.get(i4) == null) {
            return -1;
        }
        return this.f49495w.get(i4).booleanValue() ? 1 : 0;
    }

    public void c(int i4, boolean z3) {
        w(i4, z3);
        if (xv.au() && !com.ss.android.socialbase.downloader.gd.f.xv() && com.ss.android.socialbase.downloader.impls.a.c(true).r()) {
            com.ss.android.socialbase.downloader.impls.a.c(true).xv(i4, z3);
        }
        if (xv.xv() || com.ss.android.socialbase.downloader.gd.f.xv() || com.ss.android.socialbase.downloader.gd.f.c()) {
            return;
        }
        try {
            Intent intent = new Intent(xv.gw(), DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i4);
            xv.gw().startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void xv() {
        bk c4 = com.ss.android.socialbase.downloader.impls.a.c(false);
        if (c4 != null) {
            c4.c();
        }
        bk c5 = com.ss.android.socialbase.downloader.impls.a.c(true);
        if (c5 != null) {
            c5.c();
        }
    }

    private bk w(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<com.ss.android.socialbase.downloader.model.w> gd;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        downloadInfo.isNeedIndependentProcess();
        boolean z3 = (com.ss.android.socialbase.downloader.gd.f.xv() || !com.ss.android.socialbase.downloader.gd.f.c()) ? true : true;
        int c4 = c(downloadInfo.getId());
        if (c4 >= 0 && c4 != z3) {
            try {
                if (c4 == 1) {
                    if (com.ss.android.socialbase.downloader.gd.f.c()) {
                        com.ss.android.socialbase.downloader.impls.a.c(true).c(downloadInfo.getId());
                        DownloadInfo ev = com.ss.android.socialbase.downloader.impls.a.c(true).ev(downloadInfo.getId());
                        if (ev != null) {
                            com.ss.android.socialbase.downloader.impls.a.c(false).w(ev);
                        }
                        if (ev.getChunkCount() > 1 && (gd = com.ss.android.socialbase.downloader.impls.a.c(true).gd(downloadInfo.getId())) != null) {
                            com.ss.android.socialbase.downloader.impls.a.c(false).c(downloadInfo.getId(), com.ss.android.socialbase.downloader.gd.f.c(gd));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.gd.f.c()) {
                    com.ss.android.socialbase.downloader.impls.a.c(false).c(downloadInfo.getId());
                    List<com.ss.android.socialbase.downloader.model.w> gd2 = com.ss.android.socialbase.downloader.impls.a.c(false).gd(downloadInfo.getId());
                    if (gd2 != null) {
                        com.ss.android.socialbase.downloader.impls.a.c(true).c(downloadInfo.getId(), com.ss.android.socialbase.downloader.gd.f.c(gd2));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.ss.android.socialbase.downloader.impls.a.c(true).c(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        c(downloadInfo.getId(), z3);
        return com.ss.android.socialbase.downloader.impls.a.c(z3);
    }

    public List<DownloadInfo> xv(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        bk c4 = com.ss.android.socialbase.downloader.impls.a.c(false);
        List<DownloadInfo> xv = c4 != null ? c4.xv(str) : null;
        bk c5 = com.ss.android.socialbase.downloader.impls.a.c(true);
        return c(xv, c5 != null ? c5.xv(str) : null, sparseArray);
    }

    public int c(int i4) {
        if (xv.au()) {
            if (!com.ss.android.socialbase.downloader.gd.f.xv() && com.ss.android.socialbase.downloader.impls.a.c(true).r()) {
                return com.ss.android.socialbase.downloader.impls.a.c(true).bk(i4);
            }
            return w(i4);
        }
        return -1;
    }

    public int c(String str, String str2) {
        return xv.c(str, str2);
    }

    public List<DownloadInfo> c(String str) {
        List<DownloadInfo> c4 = com.ss.android.socialbase.downloader.impls.a.c(false).c(str);
        List<DownloadInfo> c5 = com.ss.android.socialbase.downloader.impls.a.c(true).c(str);
        if (c4 == null && c5 == null) {
            return null;
        }
        if (c4 == null || c5 == null) {
            return c4 != null ? c4 : c5;
        }
        ArrayList arrayList = new ArrayList(c4);
        arrayList.addAll(c5);
        return arrayList;
    }

    public void c(int i4, com.ss.android.socialbase.downloader.depend.n nVar) {
        bk xv = xv(i4);
        if (xv == null) {
            return;
        }
        xv.c(i4, nVar);
    }

    private List<DownloadInfo> c(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (DownloadInfo downloadInfo : list) {
                if (downloadInfo != null && sparseArray.get(downloadInfo.getId()) == null) {
                    sparseArray.put(downloadInfo.getId(), downloadInfo);
                }
            }
        }
        if (list2 != null) {
            for (DownloadInfo downloadInfo2 : list2) {
                if (downloadInfo2 != null && sparseArray.get(downloadInfo2.getId()) == null) {
                    sparseArray.put(downloadInfo2.getId(), downloadInfo2);
                }
            }
        }
        for (int i4 = 0; i4 < sparseArray.size(); i4++) {
            arrayList.add(sparseArray.get(sparseArray.keyAt(i4)));
        }
        return arrayList;
    }

    public DownloadInfo w(String str, String str2) {
        int c4 = c(str, str2);
        bk xv = xv(c4);
        if (xv == null) {
            return null;
        }
        return xv.ev(c4);
    }

    public List<DownloadInfo> w(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        bk c4 = com.ss.android.socialbase.downloader.impls.a.c(false);
        List<DownloadInfo> w3 = c4 != null ? c4.w(str) : null;
        bk c5 = com.ss.android.socialbase.downloader.impls.a.c(true);
        return c(w3, c5 != null ? c5.w(str) : null, sparseArray);
    }

    public void c(List<String> list) {
        bk c4 = com.ss.android.socialbase.downloader.impls.a.c(false);
        if (c4 != null) {
            c4.c(list);
        }
        bk c5 = com.ss.android.socialbase.downloader.impls.a.c(true);
        if (c5 != null) {
            c5.c(list);
        }
    }

    public void w(List<String> list) {
        bk c4 = com.ss.android.socialbase.downloader.impls.a.c(false);
        if (c4 != null) {
            c4.w(list);
        }
        bk c5 = com.ss.android.socialbase.downloader.impls.a.c(true);
        if (c5 != null) {
            c5.w(list);
        }
    }

    public void c(int i4, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3) {
        bk xv = xv(i4);
        if (xv == null) {
            return;
        }
        xv.w(i4, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, fVar, z3);
    }

    public void w(int i4, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3) {
        bk xv = xv(i4);
        if (xv == null) {
            return;
        }
        xv.c(i4, iDownloadListener.hashCode(), iDownloadListener, fVar, z3);
    }

    public void c(int i4, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3, boolean z4) {
        bk xv = xv(i4);
        if (xv == null) {
            return;
        }
        xv.c(i4, iDownloadListener.hashCode(), iDownloadListener, fVar, z3, z4);
    }

    public void w(com.ss.android.socialbase.downloader.depend.k kVar) {
        xv.w(kVar);
    }

    public boolean c(DownloadInfo downloadInfo) {
        bk xv;
        if (downloadInfo == null || (xv = xv(downloadInfo.getId())) == null) {
            return false;
        }
        return xv.c(downloadInfo);
    }

    public void c(final DownloadTask downloadTask) {
        final bk w3 = w(downloadTask);
        if (w3 == null) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.sr.c.c(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.xv.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.sr.1
                @Override // java.lang.Runnable
                public void run() {
                    w3.c(downloadTask);
                }
            }, 500L);
        } else {
            w3.c(downloadTask);
        }
    }

    public void c(com.ss.android.socialbase.downloader.depend.k kVar) {
        xv.c(kVar);
    }

    public void c(int i4, long j4) {
        bk xv = xv(i4);
        if (xv == null) {
            return;
        }
        xv.c(i4, j4);
    }
}
