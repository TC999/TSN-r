package com.p521ss.android.socialbase.downloader.impls;

import android.database.sqlite.SQLiteException;
import android.os.Build;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.constants.EnumC12418s;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12500j;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12519u;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p548a.BinderC12395n;
import com.p521ss.android.socialbase.downloader.p548a.InterfaceC12408s;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p551kf.C12584q;
import com.p521ss.android.socialbase.downloader.p555p.HandlerC12663p;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p557s.C12723ok;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import master.flame.danmaku.danmaku.model.android.DanmakuFactory;

/* renamed from: com.ss.android.socialbase.downloader.impls.s */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12558s implements InterfaceC12501k {

    /* renamed from: a */
    private InterfaceC12519u f35259a;

    /* renamed from: bl */
    private volatile boolean f35260bl;

    /* renamed from: kf */
    private HandlerC12663p f35261kf;

    /* renamed from: n */
    private HandlerC12663p.InterfaceC12664ok f35262n = new HandlerC12663p.InterfaceC12664ok() { // from class: com.ss.android.socialbase.downloader.impls.s.1
        @Override // com.p521ss.android.socialbase.downloader.p555p.HandlerC12663p.InterfaceC12664ok
        /* renamed from: ok */
        public void mo16744ok(Message message) {
            if (message.what == 1) {
                C12490bl.m17812j().execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.impls.s.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            C12558s.this.m17482q();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        }
    };

    /* renamed from: ok */
    private final C12556r f35263ok = new C12556r();

    /* renamed from: s */
    private volatile boolean f35264s;

    public C12558s() {
        this.f35261kf = null;
        if (C12534ok.m17605bl().m17595ok("fix_sigbus_downloader_db")) {
            if (!C12713kf.m16575ok() && C12490bl.m17764qx()) {
                this.f35259a = C12490bl.m17756tr().mo17623ok(new C12490bl.InterfaceC12494ok.InterfaceC12495ok() { // from class: com.ss.android.socialbase.downloader.impls.s.2
                    @Override // com.p521ss.android.socialbase.downloader.downloader.C12490bl.InterfaceC12494ok.InterfaceC12495ok
                    /* renamed from: ok */
                    public void mo17474ok() {
                        C12558s.this.f35259a = new BinderC12395n();
                        Log.e("DefaultDownloadCache", "rebind error,use backup sqlDownloadCache");
                    }
                });
            } else {
                this.f35259a = new BinderC12395n();
            }
        } else {
            this.f35259a = new BinderC12395n();
        }
        this.f35260bl = false;
        this.f35261kf = new HandlerC12663p(Looper.getMainLooper(), this.f35262n);
        m17508h();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public void m17505k() {
        synchronized (this) {
            this.f35260bl = true;
            notifyAll();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public List<DownloadInfo> mo17509bl(String str) {
        return this.f35263ok.mo17509bl(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: h */
    public DownloadInfo mo17507h(int i) {
        DownloadInfo mo17507h = this.f35263ok.mo17507h(i);
        m17510bl(mo17507h);
        return mo17507h;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: j */
    public Map<Long, C12584q> mo17506j(int i) {
        Map<Long, C12584q> mo17506j = this.f35263ok.mo17506j(i);
        if (mo17506j == null || mo17506j.isEmpty()) {
            Map<Long, C12584q> mo17506j2 = this.f35259a.mo17506j(i);
            this.f35263ok.mo17491ok(i, mo17506j2);
            return mo17506j2;
        }
        return mo17506j;
    }

    /* renamed from: kf */
    public InterfaceC12519u m17503kf() {
        return this.f35259a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: n */
    public boolean mo17501n() {
        if (this.f35260bl) {
            return true;
        }
        synchronized (this) {
            if (!this.f35260bl) {
                C12409ok.m17894s("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting start!!!!");
                try {
                    wait(5000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                C12409ok.m17894s("DefaultDownloadCache", "ensureDownloadCacheSyncSuccess: waiting end!!!!");
            }
        }
        return this.f35260bl;
    }

    /* renamed from: p */
    public void m17484p() {
        long j;
        if (C12534ok.m17605bl().m17595ok("task_resume_delay")) {
            j = DanmakuFactory.f43786r;
        } else {
            j = Build.VERSION.SDK_INT >= 23 ? 1000L : 5000L;
        }
        this.f35261kf.sendMessageDelayed(this.f35261kf.obtainMessage(1), j);
    }

    /* renamed from: q */
    public void m17482q() {
        List<String> list;
        ArrayList arrayList;
        DownloadInfo downloadInfo;
        DownloadInfo downloadInfo2;
        if (this.f35260bl) {
            if (this.f35264s) {
                C12409ok.m17904a("DefaultDownloadCache", "resumeUnCompleteTask: has resumed, return!!!");
                return;
            }
            this.f35264s = true;
            if (C12713kf.m16575ok()) {
                InterfaceC12500j m17747y = C12490bl.m17747y();
                if (m17747y != null) {
                    list = m17747y.mo17737ok();
                    arrayList = (list == null || list.isEmpty()) ? null : new ArrayList();
                } else {
                    list = null;
                    arrayList = null;
                }
                SparseArray sparseArray = new SparseArray();
                synchronized (this) {
                    SparseArray<DownloadInfo> m17528ok = this.f35263ok.m17528ok();
                    for (int i = 0; i < m17528ok.size(); i++) {
                        int keyAt = m17528ok.keyAt(i);
                        if (keyAt != 0 && (downloadInfo2 = m17528ok.get(keyAt)) != null) {
                            sparseArray.put(keyAt, downloadInfo2);
                        }
                    }
                }
                if (sparseArray.size() == 0) {
                    return;
                }
                for (int i2 = 0; i2 < sparseArray.size(); i2++) {
                    int keyAt2 = sparseArray.keyAt(i2);
                    if (keyAt2 != 0 && (downloadInfo = (DownloadInfo) sparseArray.get(keyAt2)) != null) {
                        int realStatus = downloadInfo.getRealStatus();
                        int statusAtDbInit = downloadInfo.getStatusAtDbInit();
                        if (statusAtDbInit >= 1 && statusAtDbInit <= 11) {
                            C12723ok.m16486ok(C12490bl.m17816h(), downloadInfo, (BaseException) null, -5);
                        }
                        if (list != null && arrayList != null && downloadInfo.getMimeType() != null && list.contains(downloadInfo.getMimeType()) && (C12534ok.m17599ok(downloadInfo.getId()).m17607a("enable_notification_ui") >= 2 || realStatus != -2 || downloadInfo.isPauseReserveOnWifi())) {
                            downloadInfo.setDownloadFromReserveWifi(false);
                            arrayList.add(downloadInfo);
                        }
                    }
                }
                if (m17747y == null || arrayList == null || arrayList.isEmpty()) {
                    return;
                }
                m17747y.mo17736ok(arrayList, 1);
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: rh */
    public List<C12584q> mo17480rh(int i) {
        List<C12584q> mo17480rh = this.f35263ok.mo17480rh(i);
        return (mo17480rh == null || mo17480rh.size() == 0) ? this.f35259a.mo17480rh(i) : mo17480rh;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public boolean mo17479s() {
        return this.f35260bl;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: z */
    public void mo17475z(int i) {
        this.f35263ok.mo17475z(i);
        this.f35259a.mo17475z(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public DownloadInfo mo17520a(int i) {
        return this.f35263ok.mo17520a(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public List<C12598a> mo17512bl(int i) {
        return this.f35263ok.mo17512bl(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: kf */
    public boolean mo17502kf(int i) {
        if (C12713kf.m16623a()) {
            InterfaceC12522z m17583ok = C12542j.m17583ok(true);
            if (m17583ok != null) {
                m17583ok.mo17455i(i);
            } else {
                this.f35259a.mo17502kf(i);
            }
        } else {
            this.f35259a.mo17502kf(i);
        }
        return this.f35263ok.mo17502kf(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public List<DownloadInfo> mo17476s(String str) {
        return this.f35263ok.mo17476s(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public List<DownloadInfo> mo17514a(String str) {
        return this.f35263ok.mo17514a(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public void mo17513bl() {
        try {
            this.f35263ok.mo17513bl();
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (C12713kf.m16623a()) {
            InterfaceC12522z m17583ok = C12542j.m17583ok(true);
            if (m17583ok != null) {
                m17583ok.mo17452kf();
                return;
            } else {
                this.f35259a.mo17513bl();
                return;
            }
        }
        this.f35259a.mo17513bl();
    }

    /* renamed from: h */
    public void m17508h() {
        List<C12598a> list;
        DownloadInfo downloadInfo;
        C12490bl.m17798ok(EnumC12418s.SYNC_START);
        final SparseArray<DownloadInfo> sparseArray = new SparseArray<>();
        final SparseArray<List<C12598a>> sparseArray2 = new SparseArray<>();
        synchronized (this.f35263ok) {
            SparseArray<DownloadInfo> m17528ok = this.f35263ok.m17528ok();
            for (int i = 0; i < m17528ok.size(); i++) {
                int keyAt = m17528ok.keyAt(i);
                if (keyAt != 0 && (downloadInfo = m17528ok.get(keyAt)) != null) {
                    sparseArray.put(keyAt, downloadInfo);
                }
            }
            SparseArray<List<C12598a>> m17529kf = this.f35263ok.m17529kf();
            for (int i2 = 0; i2 < m17529kf.size(); i2++) {
                int keyAt2 = m17529kf.keyAt(i2);
                if (keyAt2 != 0 && (list = m17529kf.get(keyAt2)) != null) {
                    sparseArray2.put(keyAt2, new CopyOnWriteArrayList(list));
                }
            }
        }
        this.f35259a.mo17626ok(sparseArray, sparseArray2, new InterfaceC12408s() { // from class: com.ss.android.socialbase.downloader.impls.s.3
            @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12408s
            /* renamed from: ok */
            public void mo17473ok() {
                synchronized (C12558s.this.f35263ok) {
                    SparseArray<DownloadInfo> m17528ok2 = C12558s.this.f35263ok.m17528ok();
                    if (sparseArray != null) {
                        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
                            int keyAt3 = sparseArray.keyAt(i3);
                            if (keyAt3 != 0) {
                                m17528ok2.put(keyAt3, (DownloadInfo) sparseArray.get(keyAt3));
                            }
                        }
                    }
                    SparseArray<List<C12598a>> m17529kf2 = C12558s.this.f35263ok.m17529kf();
                    if (sparseArray2 != null) {
                        for (int i4 = 0; i4 < sparseArray2.size(); i4++) {
                            int keyAt4 = sparseArray2.keyAt(i4);
                            if (keyAt4 != 0) {
                                m17529kf2.put(keyAt4, (List) sparseArray2.get(keyAt4));
                            }
                        }
                    }
                }
                C12558s.this.m17505k();
                C12558s.this.m17484p();
                C12490bl.m17798ok(EnumC12418s.SYNC_SUCCESS);
            }
        });
    }

    /* renamed from: ok */
    public C12556r m17499ok() {
        return this.f35263ok;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public void mo17478s(int i) {
        this.f35263ok.mo17478s(i);
        if (C12713kf.m16623a()) {
            InterfaceC12522z m17583ok = C12542j.m17583ok(true);
            if (m17583ok != null) {
                m17583ok.mo17417t(i);
                return;
            } else {
                this.f35259a.mo17478s(i);
                return;
            }
        }
        this.f35259a.mo17478s(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public List<DownloadInfo> mo17521a() {
        return this.f35263ok.mo17521a();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public List<DownloadInfo> mo17485ok(String str) {
        return this.f35263ok.mo17485ok(str);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public void mo17515a(C12598a c12598a) {
        if (C12713kf.m16623a()) {
            InterfaceC12522z m17583ok = C12542j.m17583ok(true);
            if (m17583ok != null) {
                m17583ok.mo17430ok(c12598a);
                return;
            } else {
                this.f35259a.mo17486ok(c12598a);
                return;
            }
        }
        this.f35259a.mo17486ok(c12598a);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: k */
    public DownloadInfo mo17504k(int i) {
        DownloadInfo mo17504k = this.f35263ok.mo17504k(i);
        m17510bl(mo17504k);
        return mo17504k;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17486ok(C12598a c12598a) {
        synchronized (this.f35263ok) {
            this.f35263ok.mo17486ok(c12598a);
        }
        if (C12713kf.m16623a()) {
            InterfaceC12522z m17583ok = C12542j.m17583ok(true);
            if (m17583ok != null) {
                m17583ok.mo17430ok(c12598a);
                return;
            } else {
                this.f35259a.mo17486ok(c12598a);
                return;
            }
        }
        this.f35259a.mo17486ok(c12598a);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: p */
    public DownloadInfo mo17483p(int i) {
        DownloadInfo mo17483p = this.f35263ok.mo17483p(i);
        m17510bl(mo17483p);
        return mo17483p;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public DownloadInfo mo17477s(int i, long j) {
        DownloadInfo mo17477s = this.f35263ok.mo17477s(i, j);
        mo17518a(i, (List<C12598a>) null);
        return mo17477s;
    }

    /* renamed from: bl */
    private void m17510bl(DownloadInfo downloadInfo) {
        m17487ok(downloadInfo, true);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public DownloadInfo mo17519a(int i, long j) {
        DownloadInfo mo17519a = this.f35263ok.mo17519a(i, j);
        mo17518a(i, (List<C12598a>) null);
        return mo17519a;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public DownloadInfo mo17511bl(int i, long j) {
        DownloadInfo mo17511bl = this.f35263ok.mo17511bl(i, j);
        mo17518a(i, (List<C12598a>) null);
        return mo17511bl;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: n */
    public boolean mo17500n(int i) {
        try {
            if (C12713kf.m16623a()) {
                InterfaceC12522z m17583ok = C12542j.m17583ok(true);
                if (m17583ok != null) {
                    m17583ok.mo17421rh(i);
                } else {
                    this.f35259a.mo17500n(i);
                }
            } else {
                this.f35259a.mo17500n(i);
            }
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        return this.f35263ok.mo17500n(i);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public void mo17516a(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return;
        }
        this.f35263ok.mo17488ok(downloadInfo);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public void mo17518a(int i, List<C12598a> list) {
        try {
            mo17488ok(this.f35263ok.mo17520a(i));
            if (list == null) {
                list = this.f35263ok.mo17512bl(i);
            }
            if (C12713kf.m16623a()) {
                InterfaceC12522z m17583ok = C12542j.m17583ok(true);
                if (m17583ok != null) {
                    m17583ok.mo17469a(i, list);
                    return;
                } else {
                    this.f35259a.mo17518a(i, list);
                    return;
                }
            }
            this.f35259a.mo17518a(i, list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17495ok(int i, int i2, long j) {
        this.f35263ok.mo17495ok(i, i2, j);
        if (C12713kf.m16623a()) {
            InterfaceC12522z m17583ok = C12542j.m17583ok(true);
            if (m17583ok != null) {
                m17583ok.mo17442ok(i, i2, j);
                return;
            } else {
                this.f35259a.mo17495ok(i, i2, j);
                return;
            }
        }
        this.f35259a.mo17495ok(i, i2, j);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17496ok(int i, int i2, int i3, long j) {
        if (C12713kf.m16623a()) {
            InterfaceC12522z m17583ok = C12542j.m17583ok(true);
            if (m17583ok != null) {
                m17583ok.mo17443ok(i, i2, i3, j);
                return;
            } else {
                this.f35259a.mo17496ok(i, i2, i3, j);
                return;
            }
        }
        this.f35259a.mo17496ok(i, i2, i3, j);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17497ok(int i, int i2, int i3, int i4) {
        if (C12713kf.m16623a()) {
            InterfaceC12522z m17583ok = C12542j.m17583ok(true);
            if (m17583ok != null) {
                m17583ok.mo17444ok(i, i2, i3, i4);
                return;
            } else {
                this.f35259a.mo17497ok(i, i2, i3, i4);
                return;
            }
        }
        this.f35259a.mo17497ok(i, i2, i3, i4);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public DownloadInfo mo17498ok(int i, int i2) {
        DownloadInfo mo17498ok = this.f35263ok.mo17498ok(i, i2);
        m17510bl(mo17498ok);
        return mo17498ok;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public boolean mo17488ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean mo17488ok = this.f35263ok.mo17488ok(downloadInfo);
        m17510bl(downloadInfo);
        return mo17488ok;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public DownloadInfo mo17493ok(int i, long j, String str, String str2) {
        DownloadInfo mo17493ok = this.f35263ok.mo17493ok(i, j, str, str2);
        m17510bl(mo17493ok);
        return mo17493ok;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: q */
    public DownloadInfo mo17481q(int i) {
        DownloadInfo mo17481q = this.f35263ok.mo17481q(i);
        m17510bl(mo17481q);
        return mo17481q;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public DownloadInfo mo17494ok(int i, long j) {
        DownloadInfo mo17494ok = this.f35263ok.mo17494ok(i, j);
        m17487ok(mo17494ok, false);
        return mo17494ok;
    }

    /* renamed from: ok */
    private void m17487ok(DownloadInfo downloadInfo, boolean z) {
        if (downloadInfo == null) {
            return;
        }
        if (!C12713kf.m16623a()) {
            this.f35259a.mo17488ok(downloadInfo);
        } else if (z) {
            InterfaceC12522z m17583ok = C12542j.m17583ok(true);
            if (m17583ok != null) {
                m17583ok.mo17459bl(downloadInfo);
            } else {
                this.f35259a.mo17488ok(downloadInfo);
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17492ok(int i, List<C12598a> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        this.f35263ok.mo17492ok(i, list);
        if (C12713kf.m16605bl()) {
            this.f35259a.mo17518a(i, list);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public boolean mo17491ok(int i, Map<Long, C12584q> map) {
        this.f35263ok.mo17491ok(i, map);
        this.f35259a.mo17491ok(i, map);
        return false;
    }
}
