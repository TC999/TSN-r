package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.sg;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class i implements com.ss.android.socialbase.downloader.downloader.z {

    /* renamed from: a  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.k f49754a;
    private final com.ss.android.socialbase.downloader.downloader.t bl;
    private final ok ok;

    /* renamed from: s  reason: collision with root package name */
    private final boolean f49755s;

    public i() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean a(int i4) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.rh(i4);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void bl(int i4) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.kf(i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean h(int i4) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.ok(i4);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean i(int i4) {
        return this.f49754a.kf(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean j(int i4) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.r(i4);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void k(int i4) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.z(i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int kf(int i4) {
        DownloadInfo s3;
        ok okVar = this.ok;
        if (okVar == null || (s3 = okVar.s(i4)) == null) {
            return 0;
        }
        return s3.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public long n(int i4) {
        DownloadInfo a4;
        com.ss.android.socialbase.downloader.downloader.k kVar = this.f49754a;
        if (kVar == null || (a4 = kVar.a(i4)) == null) {
            return 0L;
        }
        int chunkCount = a4.getChunkCount();
        if (chunkCount <= 1) {
            return a4.getCurBytes();
        }
        List<com.ss.android.socialbase.downloader.model.a> bl = this.f49754a.bl(i4);
        if (bl == null || bl.size() != chunkCount) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.q.kf.a(bl);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.n(i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public DownloadInfo p(int i4) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.s(i4);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<com.ss.android.socialbase.downloader.model.a> q(int i4) {
        return this.f49754a.bl(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void r(int i4) {
        com.ss.android.socialbase.downloader.bl.ok.ok(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean rh(int i4) {
        return this.f49754a.n(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void s(int i4) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.h(i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void startService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void t(int i4) {
        this.f49754a.s(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public v td(int i4) {
        ok okVar = this.ok;
        v p3 = okVar != null ? okVar.p(i4) : null;
        return p3 == null ? com.ss.android.socialbase.downloader.downloader.bl.sg() : p3;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public ep x(int i4) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.q(i4);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int z(int i4) {
        return com.ss.android.socialbase.downloader.downloader.s.ok().ok(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public IDownloadFileUriProvider zz(int i4) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.k(i4);
        }
        return null;
    }

    public i(boolean z3) {
        this.ok = com.ss.android.socialbase.downloader.downloader.bl.fb();
        this.f49754a = com.ss.android.socialbase.downloader.downloader.bl.m();
        if (!z3) {
            this.bl = com.ss.android.socialbase.downloader.downloader.bl.ep();
        } else {
            this.bl = com.ss.android.socialbase.downloader.downloader.bl.vz();
        }
        this.f49755s = com.ss.android.socialbase.downloader.h.ok.bl().a("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> a(String str) {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.f49754a;
        if (kVar != null) {
            return kVar.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> bl(String str) {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.f49754a;
        if (kVar != null) {
            return kVar.bl(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean h() {
        com.ss.android.socialbase.downloader.downloader.t tVar;
        return this.f49755s && (tVar = this.bl) != null && tVar.ok();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, boolean z3) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.ok(i4, z3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> s() {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.f49754a;
        if (kVar != null) {
            return kVar.a();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void kf() {
        this.f49754a.bl();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(List<String> list) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.a(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean bl() {
        return com.ss.android.socialbase.downloader.downloader.bl.wv();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok() {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.a();
        }
    }

    public void s(int i4, boolean z3) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.bl(i4, z3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void bl(int i4, boolean z3) {
        com.ss.android.socialbase.downloader.downloader.s.ok().ok(i4, z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public DownloadInfo a(String str, String str2) {
        return p(com.ss.android.socialbase.downloader.downloader.bl.ok(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean bl(DownloadInfo downloadInfo) {
        return this.f49754a.ok(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(List<String> list) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.ok(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> s(String str) {
        com.ss.android.socialbase.downloader.downloader.k kVar = this.f49754a;
        if (kVar != null) {
            return kVar.s(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> n(String str) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.a(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i4, boolean z3) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.a(i4, z3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> ok(String str) {
        ok okVar = this.ok;
        if (okVar != null) {
            return okVar.ok(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean n() {
        return this.f49754a.s();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.ok(i4, i5, iDownloadListener, kfVar, z3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int ok(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.bl.ok(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.a(i4, i5, iDownloadListener, kfVar, z3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean a() {
        com.ss.android.socialbase.downloader.downloader.t tVar = this.bl;
        if (tVar != null) {
            return tVar.a();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3, boolean z4) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.ok(i4, i5, iDownloadListener, kfVar, z3, z4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.t tVar = this.bl;
        if (tVar != null) {
            tVar.bl(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean ok = com.ss.android.socialbase.downloader.q.kf.ok(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (ok) {
            if (com.ss.android.socialbase.downloader.q.ok.ok(33554432)) {
                a(downloadInfo.getId(), true);
            } else {
                s(downloadInfo.getId(), true);
            }
        }
        return ok;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(DownloadInfo downloadInfo) {
        this.f49754a.a(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
        this.f49754a.a(i4, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.t tVar = this.bl;
        if (tVar != null) {
            tVar.ok(i4, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(boolean z3, boolean z4) {
        com.ss.android.socialbase.downloader.downloader.t tVar = this.bl;
        if (tVar != null) {
            tVar.ok(z4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.t tVar = this.bl;
        if (tVar != null) {
            tVar.a(downloadTask);
        } else if (downloadTask != null) {
            com.ss.android.socialbase.downloader.s.ok.ok(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
        this.f49754a.ok(i4, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(com.ss.android.socialbase.downloader.model.a aVar) {
        this.f49754a.ok(aVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5, long j4) {
        this.f49754a.ok(i4, i5, j4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5, int i6, long j4) {
        this.f49754a.ok(i4, i5, i6, j4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5, int i6, int i7) {
        this.f49754a.ok(i4, i5, i6, i7);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(sg sgVar) {
        com.ss.android.socialbase.downloader.downloader.bl.ok(sgVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5) {
        if (com.ss.android.socialbase.downloader.downloader.bl.n() != null) {
            for (sg sgVar : com.ss.android.socialbase.downloader.downloader.bl.n()) {
                if (sgVar != null) {
                    sgVar.ok(i5, i4);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, ep epVar) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.ok(i4, epVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, long j4) {
        ok okVar = this.ok;
        if (okVar != null) {
            okVar.a(i4, j4);
        }
    }
}
