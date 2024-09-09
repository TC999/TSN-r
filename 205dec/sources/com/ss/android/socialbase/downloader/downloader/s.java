package com.ss.android.socialbase.downloader.downloader;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.er;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s {
    private static volatile s ok;

    /* renamed from: a  reason: collision with root package name */
    private volatile SparseArray<Boolean> f49491a = new SparseArray<>();
    private Handler bl = new Handler(Looper.getMainLooper());

    /* renamed from: s  reason: collision with root package name */
    private volatile List<er> f49492s = new ArrayList();

    public static s ok() {
        if (ok == null) {
            synchronized (s.class) {
                ok = new s();
            }
        }
        return ok;
    }

    public void a(er erVar) {
        if (erVar == null) {
            return;
        }
        synchronized (this.f49492s) {
            if (this.f49492s.contains(erVar)) {
                this.f49492s.remove(erVar);
            }
        }
    }

    public z bl(int i4) {
        boolean z3 = true;
        return com.ss.android.socialbase.downloader.impls.j.ok((ok(i4) != 1 || com.ss.android.socialbase.downloader.q.kf.bl()) ? false : false);
    }

    public void h(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return;
        }
        bl.s(i4);
    }

    public void i(int i4) {
        z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(false);
        if (ok2 != null) {
            ok2.r(i4);
        }
        z ok3 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        if (ok3 != null) {
            ok3.r(i4);
        }
    }

    public ep j(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return null;
        }
        return bl.x(i4);
    }

    public boolean k(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return false;
        }
        return bl.h(i4);
    }

    public void kf(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return;
        }
        bl.bl(i4);
    }

    public boolean n(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return false;
        }
        return bl.a(i4);
    }

    public long p(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return 0L;
        }
        return bl.n(i4);
    }

    public int q(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return 0;
        }
        return bl.kf(i4);
    }

    public DownloadInfo r(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return null;
        }
        return bl.p(i4);
    }

    public void rh(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return;
        }
        bl.k(i4);
    }

    public void s(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return;
        }
        bl.ok(i4);
    }

    public boolean t(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return false;
        }
        return bl.j(i4);
    }

    public IDownloadFileUriProvider td(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return null;
        }
        return bl.zz(i4);
    }

    public void x(int i4) {
        if (i4 == 0) {
            return;
        }
        a(i4, true);
        z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        if (ok2 == null) {
            return;
        }
        ok2.startService();
    }

    public v z(int i4) {
        z bl = bl(i4);
        if (bl == null) {
            return null;
        }
        return bl.td(i4);
    }

    public void bl(int i4, boolean z3) {
        if (com.ss.android.socialbase.downloader.q.kf.ok()) {
            if (com.ss.android.socialbase.downloader.q.ok.ok(8388608)) {
                z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(true);
                if (ok2 != null) {
                    ok2.ok(i4, z3);
                }
                z ok3 = com.ss.android.socialbase.downloader.impls.j.ok(false);
                if (ok3 != null) {
                    ok3.ok(i4, z3);
                    return;
                }
                return;
            }
            z ok4 = com.ss.android.socialbase.downloader.impls.j.ok(false);
            if (ok4 != null) {
                ok4.ok(i4, z3);
            }
            z ok5 = com.ss.android.socialbase.downloader.impls.j.ok(true);
            if (ok5 != null) {
                ok5.ok(i4, z3);
                return;
            }
            return;
        }
        z bl = bl(i4);
        if (bl != null) {
            bl.ok(i4, z3);
        }
        com.ss.android.socialbase.downloader.impls.j.ok(true).ok(2, i4);
    }

    public boolean kf() {
        z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(false);
        if (ok2 != null) {
            return ok2.n();
        }
        return false;
    }

    public List<DownloadInfo> n(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(false);
        List<DownloadInfo> n4 = ok2 != null ? ok2.n(str) : null;
        z ok3 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        return ok(n4, ok3 != null ? ok3.n(str) : null, sparseArray);
    }

    public void s(int i4, boolean z3) {
        z bl = bl(i4);
        if (bl == null) {
            return;
        }
        bl.a(i4, z3);
    }

    public void a() {
        synchronized (this.f49492s) {
            for (er erVar : this.f49492s) {
                if (erVar != null) {
                    erVar.ok();
                }
            }
        }
    }

    public boolean s() {
        return bl.wv();
    }

    public void ok(er erVar) {
        if (erVar == null) {
            return;
        }
        if (com.ss.android.socialbase.downloader.q.kf.bl()) {
            erVar.ok();
            return;
        }
        if (com.ss.android.socialbase.downloader.impls.j.ok(true).h()) {
            erVar.ok();
        }
        synchronized (this.f49492s) {
            if (!this.f49492s.contains(erVar)) {
                this.f49492s.add(erVar);
            }
        }
    }

    public List<DownloadInfo> s(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(false);
        List<DownloadInfo> s3 = ok2 != null ? ok2.s(str) : null;
        z ok3 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        return ok(s3, ok3 != null ? ok3.s(str) : null, sparseArray);
    }

    public List<DownloadInfo> n() {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(false);
        List<DownloadInfo> s3 = ok2 != null ? ok2.s() : null;
        z ok3 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        return ok(s3, ok3 != null ? ok3.s() : null, sparseArray);
    }

    public synchronized void a(int i4, boolean z3) {
        this.f49491a.put(i4, z3 ? Boolean.TRUE : Boolean.FALSE);
    }

    public synchronized int a(int i4) {
        if (this.f49491a.get(i4) == null) {
            return -1;
        }
        return this.f49491a.get(i4).booleanValue() ? 1 : 0;
    }

    public void ok(int i4, boolean z3) {
        a(i4, z3);
        if (bl.qx() && !com.ss.android.socialbase.downloader.q.kf.bl() && com.ss.android.socialbase.downloader.impls.j.ok(true).h()) {
            com.ss.android.socialbase.downloader.impls.j.ok(true).bl(i4, z3);
        }
        if (bl.bl() || com.ss.android.socialbase.downloader.q.kf.bl() || com.ss.android.socialbase.downloader.q.kf.ok()) {
            return;
        }
        try {
            Intent intent = new Intent(bl.l(), DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.PROCESS_NOTIFY");
            intent.putExtra("extra_download_id", i4);
            bl.l().startService(intent);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void bl() {
        z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(false);
        if (ok2 != null) {
            ok2.ok();
        }
        z ok3 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        if (ok3 != null) {
            ok3.ok();
        }
    }

    private z a(DownloadTask downloadTask) {
        DownloadInfo downloadInfo;
        List<com.ss.android.socialbase.downloader.model.a> q3;
        if (downloadTask == null || (downloadInfo = downloadTask.getDownloadInfo()) == null) {
            return null;
        }
        downloadInfo.isNeedIndependentProcess();
        boolean z3 = (com.ss.android.socialbase.downloader.q.kf.bl() || !com.ss.android.socialbase.downloader.q.kf.ok()) ? true : true;
        int ok2 = ok(downloadInfo.getId());
        if (ok2 >= 0 && ok2 != z3) {
            try {
                if (ok2 == 1) {
                    if (com.ss.android.socialbase.downloader.q.kf.ok()) {
                        com.ss.android.socialbase.downloader.impls.j.ok(true).ok(downloadInfo.getId());
                        DownloadInfo p3 = com.ss.android.socialbase.downloader.impls.j.ok(true).p(downloadInfo.getId());
                        if (p3 != null) {
                            com.ss.android.socialbase.downloader.impls.j.ok(false).a(p3);
                        }
                        if (p3.getChunkCount() > 1 && (q3 = com.ss.android.socialbase.downloader.impls.j.ok(true).q(downloadInfo.getId())) != null) {
                            com.ss.android.socialbase.downloader.impls.j.ok(false).ok(downloadInfo.getId(), com.ss.android.socialbase.downloader.q.kf.ok(q3));
                        }
                    }
                } else if (com.ss.android.socialbase.downloader.q.kf.ok()) {
                    com.ss.android.socialbase.downloader.impls.j.ok(false).ok(downloadInfo.getId());
                    List<com.ss.android.socialbase.downloader.model.a> q4 = com.ss.android.socialbase.downloader.impls.j.ok(false).q(downloadInfo.getId());
                    if (q4 != null) {
                        com.ss.android.socialbase.downloader.impls.j.ok(true).ok(downloadInfo.getId(), com.ss.android.socialbase.downloader.q.kf.ok(q4));
                    }
                } else {
                    downloadTask.setNeedDelayForCacheSync(true);
                    com.ss.android.socialbase.downloader.impls.j.ok(true).ok(1, downloadInfo.getId());
                }
            } catch (Throwable unused) {
            }
        }
        ok(downloadInfo.getId(), z3);
        return com.ss.android.socialbase.downloader.impls.j.ok(z3);
    }

    public List<DownloadInfo> bl(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(false);
        List<DownloadInfo> bl = ok2 != null ? ok2.bl(str) : null;
        z ok3 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        return ok(bl, ok3 != null ? ok3.bl(str) : null, sparseArray);
    }

    public int ok(int i4) {
        if (bl.qx()) {
            if (!com.ss.android.socialbase.downloader.q.kf.bl() && com.ss.android.socialbase.downloader.impls.j.ok(true).h()) {
                return com.ss.android.socialbase.downloader.impls.j.ok(true).z(i4);
            }
            return a(i4);
        }
        return -1;
    }

    public int ok(String str, String str2) {
        return bl.ok(str, str2);
    }

    public List<DownloadInfo> ok(String str) {
        List<DownloadInfo> ok2 = com.ss.android.socialbase.downloader.impls.j.ok(false).ok(str);
        List<DownloadInfo> ok3 = com.ss.android.socialbase.downloader.impls.j.ok(true).ok(str);
        if (ok2 == null && ok3 == null) {
            return null;
        }
        if (ok2 == null || ok3 == null) {
            return ok2 != null ? ok2 : ok3;
        }
        ArrayList arrayList = new ArrayList(ok2);
        arrayList.addAll(ok3);
        return arrayList;
    }

    public void ok(int i4, ep epVar) {
        z bl = bl(i4);
        if (bl == null) {
            return;
        }
        bl.ok(i4, epVar);
    }

    private List<DownloadInfo> ok(List<DownloadInfo> list, List<DownloadInfo> list2, SparseArray<DownloadInfo> sparseArray) {
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

    public DownloadInfo a(String str, String str2) {
        int ok2 = ok(str, str2);
        z bl = bl(ok2);
        if (bl == null) {
            return null;
        }
        return bl.p(ok2);
    }

    public List<DownloadInfo> a(String str) {
        SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(false);
        List<DownloadInfo> a4 = ok2 != null ? ok2.a(str) : null;
        z ok3 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        return ok(a4, ok3 != null ? ok3.a(str) : null, sparseArray);
    }

    public void ok(List<String> list) {
        z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(false);
        if (ok2 != null) {
            ok2.ok(list);
        }
        z ok3 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        if (ok3 != null) {
            ok3.ok(list);
        }
    }

    public void a(List<String> list) {
        z ok2 = com.ss.android.socialbase.downloader.impls.j.ok(false);
        if (ok2 != null) {
            ok2.a(list);
        }
        z ok3 = com.ss.android.socialbase.downloader.impls.j.ok(true);
        if (ok3 != null) {
            ok3.a(list);
        }
    }

    public void ok(int i4, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3) {
        z bl = bl(i4);
        if (bl == null) {
            return;
        }
        bl.a(i4, iDownloadListener == null ? 0 : iDownloadListener.hashCode(), iDownloadListener, kfVar, z3);
    }

    public void a(int i4, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3) {
        z bl = bl(i4);
        if (bl == null) {
            return;
        }
        bl.ok(i4, iDownloadListener.hashCode(), iDownloadListener, kfVar, z3);
    }

    public void ok(int i4, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3, boolean z4) {
        z bl = bl(i4);
        if (bl == null) {
            return;
        }
        bl.ok(i4, iDownloadListener.hashCode(), iDownloadListener, kfVar, z3, z4);
    }

    public void a(com.ss.android.socialbase.downloader.depend.r rVar) {
        bl.a(rVar);
    }

    public boolean ok(DownloadInfo downloadInfo) {
        z bl;
        if (downloadInfo == null || (bl = bl(downloadInfo.getId())) == null) {
            return false;
        }
        return bl.ok(downloadInfo);
    }

    public void ok(final DownloadTask downloadTask) {
        final z a4 = a(downloadTask);
        if (a4 == null) {
            if (downloadTask != null) {
                com.ss.android.socialbase.downloader.s.ok.ok(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "tryDownload but getDownloadHandler failed"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
            }
        } else if (downloadTask.isNeedDelayForCacheSync()) {
            this.bl.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.s.1
                @Override // java.lang.Runnable
                public void run() {
                    a4.ok(downloadTask);
                }
            }, 500L);
        } else {
            a4.ok(downloadTask);
        }
    }

    public void ok(com.ss.android.socialbase.downloader.depend.r rVar) {
        bl.ok(rVar);
    }

    public void ok(int i4, long j4) {
        z bl = bl(i4);
        if (bl == null) {
            return;
        }
        bl.ok(i4, j4);
    }
}
