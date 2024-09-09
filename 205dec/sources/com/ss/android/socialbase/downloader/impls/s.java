package com.ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.p.p;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class s implements com.ss.android.socialbase.downloader.downloader.k {

    /* renamed from: a  reason: collision with root package name */
    private u f49784a;
    private volatile boolean bl;
    private com.ss.android.socialbase.downloader.p.p kf;

    /* renamed from: n  reason: collision with root package name */
    private p.ok f49785n = new p.ok() { // from class: com.ss.android.socialbase.downloader.impls.s.1
        @Override // com.ss.android.socialbase.downloader.p.p.ok
        public void ok(Message message) {
            if (message.what == 1) {
                com.ss.android.socialbase.downloader.downloader.bl.j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.s.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            s.this.q();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                });
            }
        }
    };
    private final r ok = new r();

    /* renamed from: s  reason: collision with root package name */
    private volatile boolean f49786s;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private boolean f49788a;

        /* renamed from: c  reason: collision with root package name */
        final int f49789c;
        private int ev;

        /* renamed from: f  reason: collision with root package name */
        final boolean f49790f;
        private int gd;

        /* renamed from: k  reason: collision with root package name */
        private long f49791k;

        /* renamed from: p  reason: collision with root package name */
        private boolean f49792p;

        /* renamed from: r  reason: collision with root package name */
        final int[] f49793r;
        final int sr;
        final int ux;

        /* renamed from: w  reason: collision with root package name */
        final int f49794w;
        final int xv;

        c(int i4, int i5, int i6, int i7, int i8, boolean z3, int[] iArr) {
            i7 = i7 < 3000 ? 3000 : i7;
            i8 = i8 < 5000 ? 5000 : i8;
            this.f49789c = i4;
            this.f49794w = i5;
            this.xv = i6;
            this.sr = i7;
            this.ux = i8;
            this.f49790f = z3;
            this.f49793r = iArr;
            this.ev = i7;
        }

        int sr() {
            return this.ev;
        }

        void xv() {
            this.ev = this.sr;
        }

        boolean c(long j4, int i4, int i5, boolean z3) {
            if (!this.f49788a) {
                com.ss.android.socialbase.downloader.xv.c.xv("RetryScheduler", "canRetry: mIsWaitingRetry is false, return false!!!");
                return false;
            } else if (this.f49794w >= i4 && this.gd < this.xv) {
                if (!this.f49792p || i5 == 2) {
                    return z3 || j4 - this.f49791k >= ((long) this.sr);
                }
                return false;
            } else {
                return false;
            }
        }

        synchronized void w() {
            this.gd++;
        }

        synchronized void c() {
            this.ev += this.ux;
        }

        synchronized void c(long j4) {
            this.f49791k = j4;
        }
    }

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface w {
        void c(DownloadInfo downloadInfo, long j4, boolean z3, int i4);
    }

    public s() {
        this.kf = null;
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("fix_sigbus_downloader_db")) {
            if (!com.ss.android.socialbase.downloader.q.kf.ok() && com.ss.android.socialbase.downloader.downloader.bl.qx()) {
                this.f49784a = com.ss.android.socialbase.downloader.downloader.bl.tr().ok(new bl.ok.InterfaceC1005ok() { // from class: com.ss.android.socialbase.downloader.impls.s.2
                    @Override // com.ss.android.socialbase.downloader.downloader.bl.ok.InterfaceC1005ok
                    public void ok() {
                        s.this.f49784a = new com.ss.android.socialbase.downloader.a.n();
                        Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                    }
                });
            } else {
                this.f49784a = new com.ss.android.socialbase.downloader.a.n();
            }
        } else {
            this.f49784a = new com.ss.android.socialbase.downloader.a.n();
        }
        this.bl = false;
        this.kf = new com.ss.android.socialbase.downloader.p.p(Looper.getMainLooper(), this.f49785n);
        h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k() {
        synchronized (this) {
            this.bl = true;
            notifyAll();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> bl(String str) {
        return this.ok.bl(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo h(int i4) {
        DownloadInfo h4 = this.ok.h(i4);
        bl(h4);
        return h4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public Map<Long, com.ss.android.socialbase.downloader.kf.q> j(int i4) {
        Map<Long, com.ss.android.socialbase.downloader.kf.q> j4 = this.ok.j(i4);
        if (j4 == null || j4.isEmpty()) {
            Map<Long, com.ss.android.socialbase.downloader.kf.q> j5 = this.f49784a.j(i4);
            this.ok.ok(i4, j5);
            return j5;
        }
        return j4;
    }

    public u kf() {
        return this.f49784a;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean n() {
        if (this.bl) {
            return true;
        }
        synchronized (this) {
            if (!this.bl) {
                com.ss.android.socialbase.downloader.bl.ok.s("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e4) {
                    e4.printStackTrace();
                }
                com.ss.android.socialbase.downloader.bl.ok.s("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.bl;
    }

    public void p() {
        long j4;
        if (com.ss.android.socialbase.downloader.h.ok.bl().ok("task_resume_delay")) {
            j4 = 4000;
        } else {
            j4 = Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L;
        }
        this.kf.sendMessageDelayed(this.kf.obtainMessage(1), j4);
    }

    public void q() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.bl) {
            if (this.f49786s) {
                com.ss.android.socialbase.downloader.bl.ok.a("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.f49786s = true;
            if (com.ss.android.socialbase.downloader.q.kf.ok()) {
                com.ss.android.socialbase.downloader.downloader.j y3 = com.ss.android.socialbase.downloader.downloader.bl.y();
                if (y3 != null) {
                    list = y3.ok();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> ok = this.ok.ok();
                    for (int i4 = 0; i4 < ok.size(); i4++) {
                        int keyAt = ok.keyAt(i4);
                        if (keyAt != 0 && (downloadInfo2 = ok.get(keyAt)) != null) {
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
                            com.ss.android.socialbase.downloader.s.ok.ok(com.ss.android.socialbase.downloader.downloader.bl.h(), downloadInfo, (BaseException) null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (com.ss.android.socialbase.downloader.h.ok.ok(downloadInfo.getId()).a("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (y3 == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                y3.ok(arrayList, 1);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.kf.q> rh(int i4) {
        List<com.ss.android.socialbase.downloader.kf.q> rh = this.ok.rh(i4);
        return (rh == null || rh.size() == 0) ? this.f49784a.rh(i4) : rh;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean s() {
        return this.bl;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void z(int i4) {
        this.ok.z(i4);
        this.f49784a.z(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo a(int i4) {
        return this.ok.a(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.model.a> bl(int i4) {
        return this.ok.bl(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean kf(int i4) {
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z ok = j.ok(true);
            if (ok != null) {
                ok.i(i4);
            } else {
                this.f49784a.kf(i4);
            }
        } else {
            this.f49784a.kf(i4);
        }
        return this.ok.kf(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> s(String str) {
        return this.ok.s(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> a(String str) {
        return this.ok.a(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void bl() {
        try {
            this.ok.bl();
        } catch (SQLiteException e4) {
            e4.printStackTrace();
        }
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z ok = j.ok(true);
            if (ok != null) {
                ok.kf();
                return;
            } else {
                this.f49784a.bl();
                return;
            }
        }
        this.f49784a.bl();
    }

    public void h() {
        List<com.ss.android.socialbase.downloader.model.a> list;
        DownloadInfo downloadInfo;
        com.ss.android.socialbase.downloader.downloader.bl.ok(com.ss.android.socialbase.downloader.constants.s.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArray2 = new SparseArray<>();
        synchronized (this.ok) {
            SparseArray<DownloadInfo> ok = this.ok.ok();
            for (int i4 = 0; i4 < ok.size(); i4++) {
                int keyAt = ok.keyAt(i4);
                if (keyAt != 0 && (downloadInfo = ok.get(keyAt)) != null) {
                    sparseArray.put(keyAt, downloadInfo);
                }
            }
            SparseArray<List<com.ss.android.socialbase.downloader.model.a>> kf = this.ok.kf();
            for (int i5 = 0; i5 < kf.size(); i5++) {
                int keyAt2 = kf.keyAt(i5);
                if (keyAt2 != 0 && (list = kf.get(keyAt2)) != null) {
                    sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.f49784a.ok(sparseArray, sparseArray2, new com.ss.android.socialbase.downloader.a.s() { // from class: com.ss.android.socialbase.downloader.impls.s.3
            @Override // com.ss.android.socialbase.downloader.a.s
            public void ok() {
                synchronized (s.this.ok) {
                    SparseArray<DownloadInfo> ok2 = s.this.ok.ok();
                    if (sparseArray != null) {
                        for (int i6 = 0; i6 < sparseArray.size(); i6++) {
                            int keyAt3 = sparseArray.keyAt(i6);
                            if (keyAt3 != 0) {
                                ok2.put(keyAt3, (DownloadInfo) sparseArray.get(keyAt3));
                            }
                        }
                    }
                    SparseArray<List<com.ss.android.socialbase.downloader.model.a>> kf2 = s.this.ok.kf();
                    if (sparseArray2 != null) {
                        for (int i7 = 0; i7 < sparseArray2.size(); i7++) {
                            int keyAt4 = sparseArray2.keyAt(i7);
                            if (keyAt4 != 0) {
                                kf2.put(keyAt4, (List) sparseArray2.get(keyAt4));
                            }
                        }
                    }
                }
                s.this.k();
                s.this.p();
                com.ss.android.socialbase.downloader.downloader.bl.ok(com.ss.android.socialbase.downloader.constants.s.SYNC_SUCCESS);
            }
        });
    }

    public r ok() {
        return this.ok;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void s(int i4) {
        this.ok.s(i4);
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z ok = j.ok(true);
            if (ok != null) {
                ok.t(i4);
                return;
            } else {
                this.f49784a.s(i4);
                return;
            }
        }
        this.f49784a.s(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> a() {
        return this.ok.a();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> ok(String str) {
        return this.ok.ok(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.model.a aVar) {
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z ok = j.ok(true);
            if (ok != null) {
                ok.ok(aVar);
                return;
            } else {
                this.f49784a.ok(aVar);
                return;
            }
        }
        this.f49784a.ok(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo k(int i4) {
        DownloadInfo k4 = this.ok.k(i4);
        bl(k4);
        return k4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(com.ss.android.socialbase.downloader.model.a aVar) {
        synchronized (this.ok) {
            this.ok.ok(aVar);
        }
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z ok = j.ok(true);
            if (ok != null) {
                ok.ok(aVar);
                return;
            } else {
                this.f49784a.ok(aVar);
                return;
            }
        }
        this.f49784a.ok(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo p(int i4) {
        DownloadInfo p3 = this.ok.p(i4);
        bl(p3);
        return p3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo s(int i4, long j4) {
        DownloadInfo s3 = this.ok.s(i4, j4);
        a(i4, (List<com.ss.android.socialbase.downloader.model.a>) null);
        return s3;
    }

    private void bl(DownloadInfo downloadInfo) {
        ok(downloadInfo, true);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo a(int i4, long j4) {
        DownloadInfo a4 = this.ok.a(i4, j4);
        a(i4, (List<com.ss.android.socialbase.downloader.model.a>) null);
        return a4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo bl(int i4, long j4) {
        DownloadInfo bl = this.ok.bl(i4, j4);
        a(i4, (List<com.ss.android.socialbase.downloader.model.a>) null);
        return bl;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean n(int i4) {
        try {
            if (com.ss.android.socialbase.downloader.q.kf.a()) {
                com.ss.android.socialbase.downloader.downloader.z ok = j.ok(true);
                if (ok != null) {
                    ok.rh(i4);
                } else {
                    this.f49784a.n(i4);
                }
            } else {
                this.f49784a.n(i4);
            }
        } catch (SQLiteException e4) {
            e4.printStackTrace();
        }
        return this.ok.n(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.ok.ok(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
        try {
            ok(this.ok.a(i4));
            if (list == null) {
                list = this.ok.bl(i4);
            }
            if (com.ss.android.socialbase.downloader.q.kf.a()) {
                com.ss.android.socialbase.downloader.downloader.z ok = j.ok(true);
                if (ok != null) {
                    ok.a(i4, list);
                    return;
                } else {
                    this.f49784a.a(i4, list);
                    return;
                }
            }
            this.f49784a.a(i4, list);
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i4, int i5, long j4) {
        this.ok.ok(i4, i5, j4);
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z ok = j.ok(true);
            if (ok != null) {
                ok.ok(i4, i5, j4);
                return;
            } else {
                this.f49784a.ok(i4, i5, j4);
                return;
            }
        }
        this.f49784a.ok(i4, i5, j4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i4, int i5, int i6, long j4) {
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z ok = j.ok(true);
            if (ok != null) {
                ok.ok(i4, i5, i6, j4);
                return;
            } else {
                this.f49784a.ok(i4, i5, i6, j4);
                return;
            }
        }
        this.f49784a.ok(i4, i5, i6, j4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i4, int i5, int i6, int i7) {
        if (com.ss.android.socialbase.downloader.q.kf.a()) {
            com.ss.android.socialbase.downloader.downloader.z ok = j.ok(true);
            if (ok != null) {
                ok.ok(i4, i5, i6, i7);
                return;
            } else {
                this.f49784a.ok(i4, i5, i6, i7);
                return;
            }
        }
        this.f49784a.ok(i4, i5, i6, i7);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i4, int i5) {
        DownloadInfo ok = this.ok.ok(i4, i5);
        bl(ok);
        return ok;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean ok = this.ok.ok(downloadInfo);
        bl(downloadInfo);
        return ok;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i4, long j4, String str, String str2) {
        DownloadInfo ok = this.ok.ok(i4, j4, str, str2);
        bl(ok);
        return ok;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo q(int i4) {
        DownloadInfo q3 = this.ok.q(i4);
        bl(q3);
        return q3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i4, long j4) {
        DownloadInfo ok = this.ok.ok(i4, j4);
        ok(ok, false);
        return ok;
    }

    private void ok(DownloadInfo downloadInfo, boolean z3) {
        if (downloadInfo == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.q.kf.a()) {
            this.f49784a.ok(downloadInfo);
        } else if (z3) {
            com.ss.android.socialbase.downloader.downloader.z ok = j.ok(true);
            if (ok != null) {
                ok.bl(downloadInfo);
            } else {
                this.f49784a.ok(downloadInfo);
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.ok.ok(i4, list);
        if (com.ss.android.socialbase.downloader.q.kf.bl()) {
            this.f49784a.a(i4, list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean ok(int i4, Map<Long, com.ss.android.socialbase.downloader.kf.q> map) {
        this.ok.ok(i4, map);
        this.f49784a.ok(i4, map);
        return false;
    }
}
