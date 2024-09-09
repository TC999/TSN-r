package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.downloader.xv;
import com.ss.android.socialbase.downloader.ev.ev;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class sr implements com.ss.android.socialbase.downloader.downloader.p {

    /* renamed from: f  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.ev.ev f49796f;
    private volatile boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private u f49797w;
    private volatile boolean xv;
    private ev.c ux = new ev.c() { // from class: com.ss.android.socialbase.downloader.impls.sr.1
        @Override // com.ss.android.socialbase.downloader.ev.ev.c
        public void c(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.xv.a().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.sr.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            sr.this.gd();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                });
            }
        }
    };

    /* renamed from: c  reason: collision with root package name */
    private final k f49795c = new k();

    public sr() {
        this.f49796f = null;
        if (com.ss.android.socialbase.downloader.r.c.xv().c("fix_sigbus_downloader_db")) {
            if (!com.ss.android.socialbase.downloader.gd.f.c() && com.ss.android.socialbase.downloader.downloader.xv.au()) {
                this.f49797w = com.ss.android.socialbase.downloader.downloader.xv.bj().c(new xv.c.InterfaceC1008c() { // from class: com.ss.android.socialbase.downloader.impls.sr.2
                    @Override // com.ss.android.socialbase.downloader.downloader.xv.c.InterfaceC1008c
                    public void c() {
                        sr.this.f49797w = new com.ss.android.socialbase.downloader.w.ux();
                        Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                    }
                });
            } else {
                this.f49797w = new com.ss.android.socialbase.downloader.w.ux();
            }
        } else {
            this.f49797w = new com.ss.android.socialbase.downloader.w.ux();
        }
        this.xv = false;
        this.f49796f = new com.ss.android.socialbase.downloader.ev.ev(Looper.getMainLooper(), this.ux);
        r();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p() {
        synchronized (this) {
            this.xv = true;
            notifyAll();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public Map<Long, com.ss.android.socialbase.downloader.f.gd> a(int i4) {
        Map<Long, com.ss.android.socialbase.downloader.f.gd> a4 = this.f49795c.a(i4);
        if (a4 == null || a4.isEmpty()) {
            Map<Long, com.ss.android.socialbase.downloader.f.gd> a5 = this.f49797w.a(i4);
            this.f49795c.c(i4, a5);
            return a5;
        }
        return a4;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public void bk(int i4) {
        this.f49795c.bk(i4);
        this.f49797w.bk(i4);
    }

    public void ev() {
        long j4;
        if (com.ss.android.socialbase.downloader.r.c.xv().c("task_resume_delay")) {
            j4 = 4000;
        } else {
            j4 = Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L;
        }
        this.f49796f.sendMessageDelayed(this.f49796f.obtainMessage(1), j4);
    }

    public u f() {
        return this.f49797w;
    }

    public void gd() {
        List list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.xv) {
            if (this.sr) {
                com.ss.android.socialbase.downloader.xv.c.w("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.sr = true;
            if (com.ss.android.socialbase.downloader.gd.f.c()) {
                com.ss.android.socialbase.downloader.downloader.a ls = com.ss.android.socialbase.downloader.downloader.xv.ls();
                if (ls != null) {
                    list = ls.c();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray c4 = this.f49795c.c();
                    for (int i4 = 0; i4 < c4.size(); i4++) {
                        int keyAt = c4.keyAt(i4);
                        if (keyAt != 0 && (downloadInfo2 = (DownloadInfo) c4.get(keyAt)) != null) {
                            sparseArray.put(keyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i5 = 0; i5 < sparseArray.size(); i5++) {
                    int keyAt2 = sparseArray.keyAt(i5);
                    if (keyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(keyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit >= 1 && statusAtDbInit <= 11) {
                            com.ss.android.socialbase.downloader.sr.c.c(com.ss.android.socialbase.downloader.downloader.xv.r(), downloadInfo, (BaseException) null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (com.ss.android.socialbase.downloader.r.c.c(downloadInfo.getId()).w("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (ls == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                ls.c(arrayList, 1);
            }
        }
    }

    public DownloadInfo r(int i4) {
        DownloadInfo r3 = this.f49795c.r(i4);
        xv(r3);
        return r3;
    }

    public boolean sr() {
        return this.xv;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public List<com.ss.android.socialbase.downloader.f.gd> t(int i4) {
        List<com.ss.android.socialbase.downloader.f.gd> t3 = this.f49795c.t(i4);
        return (t3 == null || t3.size() == 0) ? this.f49797w.t(i4) : t3;
    }

    public boolean ux() {
        if (this.xv) {
            return true;
        }
        synchronized (this) {
            if (!this.xv) {
                com.ss.android.socialbase.downloader.xv.c.sr("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
                com.ss.android.socialbase.downloader.xv.c.sr("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.xv;
    }

    public List<DownloadInfo> xv(String str) {
        return this.f49795c.xv(str);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public boolean f(int i4) {
        if (com.ss.android.socialbase.downloader.gd.f.w()) {
            com.ss.android.socialbase.downloader.downloader.bk c4 = a.c(true);
            if (c4 != null) {
                c4.fp(i4);
            } else {
                this.f49797w.f(i4);
            }
        } else {
            this.f49797w.f(i4);
        }
        return this.f49795c.f(i4);
    }

    public List<DownloadInfo> sr(String str) {
        return this.f49795c.sr(str);
    }

    public DownloadInfo w(int i4) {
        return this.f49795c.w(i4);
    }

    public List<com.ss.android.socialbase.downloader.model.w> xv(int i4) {
        return this.f49795c.xv(i4);
    }

    public k c() {
        return this.f49795c;
    }

    public void r() {
        List list;
        DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.downloader.xv.c(com.ss.android.socialbase.downloader.constants.sr.SYNC_START);
        final SparseArray sparseArray = new SparseArray();
        final SparseArray sparseArray2 = new SparseArray();
        synchronized (this.f49795c) {
            SparseArray c4 = this.f49795c.c();
            for (int i4 = 0; i4 < c4.size(); i4++) {
                int keyAt = c4.keyAt(i4);
                if (keyAt != 0 && (downloadInfo = (DownloadInfo) c4.get(keyAt)) != null) {
                    sparseArray.put(keyAt, downloadInfo);
                }
            }
            SparseArray f4 = this.f49795c.f();
            for (int i5 = 0; i5 < f4.size(); i5++) {
                int keyAt2 = f4.keyAt(i5);
                if (keyAt2 != 0 && (list = (List) f4.get(keyAt2)) != null) {
                    sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.f49797w.c(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.w.sr() { // from class: com.ss.android.socialbase.downloader.impls.sr.3
            @Override // com.ss.android.socialbase.downloader.w.sr
            public void c() {
                synchronized (sr.this.f49795c) {
                    SparseArray c5 = sr.this.f49795c.c();
                    if (sparseArray != null) {
                        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                            int keyAt3 = sparseArray.keyAt(i6);
                            if (keyAt3 != 0) {
                                c5.put(keyAt3, (DownloadInfo) sparseArray.get(keyAt3));
                            }
                        }
                    }
                    SparseArray f5 = sr.this.f49795c.f();
                    if (sparseArray2 != null) {
                        for (int i7 = 0; i7 < sparseArray2.size(); i7++) {
                            int keyAt4 = sparseArray2.keyAt(i7);
                            if (keyAt4 != 0) {
                                f5.put(keyAt4, (List) sparseArray2.get(keyAt4));
                            }
                        }
                    }
                }
                sr.this.p();
                sr.this.ev();
                com.ss.android.socialbase.downloader.downloader.xv.c(com.ss.android.socialbase.downloader.constants.sr.SYNC_SUCCESS);
            }
        });
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public void sr(int i4) {
        this.f49795c.sr(i4);
        if (com.ss.android.socialbase.downloader.gd.f.w()) {
            com.ss.android.socialbase.downloader.downloader.bk c4 = a.c(true);
            if (c4 != null) {
                c4.ys(i4);
                return;
            } else {
                this.f49797w.sr(i4);
                return;
            }
        }
        this.f49797w.sr(i4);
    }

    public List<DownloadInfo> w(String str) {
        return this.f49795c.w(str);
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public void xv() {
        try {
            this.f49795c.xv();
        } catch (SQLiteException e4) {
            e4.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.gd.f.w()) {
            com.ss.android.socialbase.downloader.downloader.bk c4 = a.c(true);
            if (c4 != null) {
                c4.f();
                return;
            } else {
                this.f49797w.xv();
                return;
            }
        }
        this.f49797w.xv();
    }

    public List<DownloadInfo> c(String str) {
        return this.f49795c.c(str);
    }

    public List<DownloadInfo> w() {
        return this.f49795c.w();
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public void c(com.ss.android.socialbase.downloader.model.w wVar) {
        synchronized (this.f49795c) {
            this.f49795c.c(wVar);
        }
        if (com.ss.android.socialbase.downloader.gd.f.w()) {
            com.ss.android.socialbase.downloader.downloader.bk c4 = a.c(true);
            if (c4 != null) {
                c4.c(wVar);
                return;
            } else {
                this.f49797w.c(wVar);
                return;
            }
        }
        this.f49797w.c(wVar);
    }

    public DownloadInfo ev(int i4) {
        DownloadInfo ev = this.f49795c.ev(i4);
        xv(ev);
        return ev;
    }

    public DownloadInfo p(int i4) {
        DownloadInfo p3 = this.f49795c.p(i4);
        xv(p3);
        return p3;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public void w(com.ss.android.socialbase.downloader.model.w wVar) {
        if (com.ss.android.socialbase.downloader.gd.f.w()) {
            com.ss.android.socialbase.downloader.downloader.bk c4 = a.c(true);
            if (c4 != null) {
                c4.c(wVar);
                return;
            } else {
                this.f49797w.c(wVar);
                return;
            }
        }
        this.f49797w.c(wVar);
    }

    public DownloadInfo sr(int i4, long j4) {
        DownloadInfo sr = this.f49795c.sr(i4, j4);
        w(i4, (List<com.ss.android.socialbase.downloader.model.w>) null);
        return sr;
    }

    private void xv(DownloadInfo downloadInfo) {
        c(downloadInfo, true);
    }

    public DownloadInfo w(int i4, long j4) {
        DownloadInfo w3 = this.f49795c.w(i4, j4);
        w(i4, (List<com.ss.android.socialbase.downloader.model.w>) null);
        return w3;
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public boolean ux(int i4) {
        try {
            if (com.ss.android.socialbase.downloader.gd.f.w()) {
                com.ss.android.socialbase.downloader.downloader.bk c4 = a.c(true);
                if (c4 != null) {
                    c4.t(i4);
                } else {
                    this.f49797w.ux(i4);
                }
            } else {
                this.f49797w.ux(i4);
            }
        } catch (SQLiteException e4) {
            e4.printStackTrace();
        }
        return this.f49795c.ux(i4);
    }

    public DownloadInfo xv(int i4, long j4) {
        DownloadInfo xv = this.f49795c.xv(i4, j4);
        w(i4, (List<com.ss.android.socialbase.downloader.model.w>) null);
        return xv;
    }

    public void w(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f49795c.c(downloadInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r0v6, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public void w(int i4, List<com.ss.android.socialbase.downloader.model.w> list) {
        try {
            c(this.f49795c.w(i4));
            if (list == null) {
                list = this.f49795c.xv(i4);
            }
            if (com.ss.android.socialbase.downloader.gd.f.w()) {
                com.ss.android.socialbase.downloader.downloader.bk c4 = a.c(true);
                if (c4 != null) {
                    c4.w(i4, list);
                    return;
                } else {
                    this.f49797w.w(i4, list);
                    return;
                }
            }
            this.f49797w.w(i4, list);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r0v5, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public void c(int i4, int i5, long j4) {
        this.f49795c.c(i4, i5, j4);
        if (com.ss.android.socialbase.downloader.gd.f.w()) {
            com.ss.android.socialbase.downloader.downloader.bk c4 = a.c(true);
            if (c4 != null) {
                c4.c(i4, i5, j4);
                return;
            } else {
                this.f49797w.c(i4, i5, j4);
                return;
            }
        }
        this.f49797w.c(i4, i5, j4);
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r3v0, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public void c(int i4, int i5, int i6, long j4) {
        if (com.ss.android.socialbase.downloader.gd.f.w()) {
            com.ss.android.socialbase.downloader.downloader.bk c4 = a.c(true);
            if (c4 != null) {
                c4.c(i4, i5, i6, j4);
                return;
            } else {
                this.f49797w.c(i4, i5, i6, j4);
                return;
            }
        }
        this.f49797w.c(i4, i5, i6, j4);
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r0v4, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public void c(int i4, int i5, int i6, int i7) {
        if (com.ss.android.socialbase.downloader.gd.f.w()) {
            com.ss.android.socialbase.downloader.downloader.bk c4 = a.c(true);
            if (c4 != null) {
                c4.c(i4, i5, i6, i7);
                return;
            } else {
                this.f49797w.c(i4, i5, i6, i7);
                return;
            }
        }
        this.f49797w.c(i4, i5, i6, i7);
    }

    public DownloadInfo c(int i4, int i5) {
        DownloadInfo c4 = this.f49795c.c(i4, i5);
        xv(c4);
        return c4;
    }

    public boolean c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean c4 = this.f49795c.c(downloadInfo);
        xv(downloadInfo);
        return c4;
    }

    public DownloadInfo c(int i4, long j4, String str, String str2) {
        DownloadInfo c4 = this.f49795c.c(i4, j4, str, str2);
        xv(c4);
        return c4;
    }

    public DownloadInfo gd(int i4) {
        DownloadInfo gd = this.f49795c.gd(i4);
        xv(gd);
        return gd;
    }

    public DownloadInfo c(int i4, long j4) {
        DownloadInfo c4 = this.f49795c.c(i4, j4);
        c(c4, false);
        return c4;
    }

    /* JADX WARN: Type inference failed for: r3v1, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    /* JADX WARN: Type inference failed for: r3v4, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    private void c(DownloadInfo downloadInfo, boolean z3) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.gd.f.w()) {
            this.f49797w.c(downloadInfo);
        } else if (z3) {
            com.ss.android.socialbase.downloader.downloader.bk c4 = a.c(true);
            if (c4 != null) {
                c4.xv(downloadInfo);
            } else {
                this.f49797w.c(downloadInfo);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v3, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public void c(int i4, List<com.ss.android.socialbase.downloader.model.w> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f49795c.c(i4, list);
        if (com.ss.android.socialbase.downloader.gd.f.xv()) {
            this.f49797w.w(i4, list);
        }
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [com.ss.android.socialbase.downloader.downloader.p, com.ss.android.socialbase.downloader.downloader.u] */
    public boolean c(int i4, Map<Long, com.ss.android.socialbase.downloader.f.gd> map) {
        this.f49795c.c(i4, map);
        this.f49797w.c(i4, map);
        return false;
    }
}
