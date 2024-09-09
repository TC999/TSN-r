package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.me;
import com.ss.android.socialbase.downloader.depend.pr;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class fp implements com.ss.android.socialbase.downloader.downloader.bk {

    /* renamed from: c  reason: collision with root package name */
    private final c f49748c;
    private final boolean sr;

    /* renamed from: w  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.p f49749w;
    private final com.ss.android.socialbase.downloader.downloader.ys xv;

    public fp() {
        this(false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean a(int i4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            return cVar.k(i4);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public int bk(int i4) {
        return com.ss.android.socialbase.downloader.downloader.sr.c().c(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.ux(i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public DownloadInfo ev(int i4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            return cVar.sr(i4);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public int f(int i4) {
        DownloadInfo sr;
        c cVar = this.f49748c;
        if (cVar == null || (sr = cVar.sr(i4)) == null) {
            return 0;
        }
        return sr.getStatus();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean fp(int i4) {
        return this.f49749w.f(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public IDownloadFileUriProvider fz(int i4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            return cVar.p(i4);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<com.ss.android.socialbase.downloader.model.w> gd(int i4) {
        return this.f49749w.xv(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public com.ss.android.socialbase.downloader.depend.n ia(int i4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            return cVar.gd(i4);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void k(int i4) {
        com.ss.android.socialbase.downloader.xv.c.c(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void p(int i4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.bk(i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean r(int i4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            return cVar.c(i4);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public me s(int i4) {
        c cVar = this.f49748c;
        me ev = cVar != null ? cVar.ev(i4) : null;
        return ev == null ? com.ss.android.socialbase.downloader.downloader.xv.pr() : ev;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void sr(int i4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.r(i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void startService() {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean t(int i4) {
        return this.f49749w.ux(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public long ux(int i4) {
        DownloadInfo w3;
        com.ss.android.socialbase.downloader.downloader.p pVar = this.f49749w;
        if (pVar == null || (w3 = pVar.w(i4)) == null) {
            return 0L;
        }
        int chunkCount = w3.getChunkCount();
        if (chunkCount <= 1) {
            return w3.getCurBytes();
        }
        List xv = this.f49749w.xv(i4);
        if (xv == null || xv.size() != chunkCount) {
            return 0L;
        }
        return com.ss.android.socialbase.downloader.gd.f.w(xv);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean w(int i4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            return cVar.t(i4);
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void xv(int i4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.f(i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void ys(int i4) {
        this.f49749w.sr(i4);
    }

    public fp(boolean z3) {
        this.f49748c = com.ss.android.socialbase.downloader.downloader.xv.y();
        this.f49749w = com.ss.android.socialbase.downloader.downloader.xv.gb();
        if (!z3) {
            this.xv = com.ss.android.socialbase.downloader.downloader.xv.n();
        } else {
            this.xv = com.ss.android.socialbase.downloader.downloader.xv.ck();
        }
        this.sr = com.ss.android.socialbase.downloader.r.c.xv().w("service_alive", false);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, boolean z3) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.c(i4, z3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean r() {
        com.ss.android.socialbase.downloader.downloader.ys ysVar;
        return this.sr && (ysVar = this.xv) != null && ysVar.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> sr() {
        com.ss.android.socialbase.downloader.downloader.p pVar = this.f49749w;
        if (pVar != null) {
            return pVar.w();
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> w(String str) {
        com.ss.android.socialbase.downloader.downloader.p pVar = this.f49749w;
        if (pVar != null) {
            return pVar.w(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> xv(String str) {
        com.ss.android.socialbase.downloader.downloader.p pVar = this.f49749w;
        if (pVar != null) {
            return pVar.xv(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void f() {
        this.f49749w.xv();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c() {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.w();
        }
    }

    public void sr(int i4, boolean z3) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.xv(i4, z3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(List<String> list) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.w(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean xv() {
        return com.ss.android.socialbase.downloader.downloader.xv.vc();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void xv(int i4, boolean z3) {
        com.ss.android.socialbase.downloader.downloader.sr.c().c(i4, z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(List<String> list) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.c(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> sr(String str) {
        com.ss.android.socialbase.downloader.downloader.p pVar = this.f49749w;
        if (pVar != null) {
            return pVar.sr(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public DownloadInfo w(String str, String str2) {
        return ev(com.ss.android.socialbase.downloader.downloader.xv.c(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean xv(DownloadInfo downloadInfo) {
        return this.f49749w.c(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> ux(String str) {
        c cVar = this.f49748c;
        if (cVar != null) {
            return cVar.w(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> c(String str) {
        c cVar = this.f49748c;
        if (cVar != null) {
            return cVar.c(str);
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(int i4, boolean z3) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.w(i4, z3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean ux() {
        return this.f49749w.sr();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public int c(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.xv.c(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.c(i4, i5, iDownloadListener, fVar, z3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.w(i4, i5, iDownloadListener, fVar, z3);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean w() {
        com.ss.android.socialbase.downloader.downloader.ys ysVar = this.xv;
        if (ysVar != null) {
            return ysVar.w();
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3, boolean z4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.c(i4, i5, iDownloadListener, fVar, z3, z4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.ys ysVar = this.xv;
        if (ysVar != null) {
            ysVar.xv(downloadTask);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return false;
        }
        boolean c4 = com.ss.android.socialbase.downloader.gd.f.c(downloadInfo.getStatus(), downloadInfo.getSavePath(), downloadInfo.getName());
        if (c4) {
            if (com.ss.android.socialbase.downloader.gd.c.c(33554432)) {
                w(downloadInfo.getId(), true);
            } else {
                sr(downloadInfo.getId(), true);
            }
        }
        return c4;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(DownloadInfo downloadInfo) {
        this.f49749w.w(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(int i4, List<com.ss.android.socialbase.downloader.model.w> list) {
        this.f49749w.w(i4, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, Notification notification) {
        com.ss.android.socialbase.downloader.downloader.ys ysVar = this.xv;
        if (ysVar != null) {
            ysVar.c(i4, notification);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(boolean z3, boolean z4) {
        com.ss.android.socialbase.downloader.downloader.ys ysVar = this.xv;
        if (ysVar != null) {
            ysVar.c(z4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.ys ysVar = this.xv;
        if (ysVar != null) {
            ysVar.w(downloadTask);
        } else if (downloadTask != null) {
            com.ss.android.socialbase.downloader.sr.c.c(downloadTask.getMonitorDepend(), downloadTask.getDownloadInfo(), new BaseException(1003, "downloadServiceHandler is null"), downloadTask.getDownloadInfo() != null ? downloadTask.getDownloadInfo().getStatus() : 0);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, List<com.ss.android.socialbase.downloader.model.w> list) {
        this.f49749w.c(i4, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(com.ss.android.socialbase.downloader.model.w wVar) {
        this.f49749w.c(wVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5, long j4) {
        this.f49749w.c(i4, i5, j4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5, int i6, long j4) {
        this.f49749w.c(i4, i5, i6, j4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5, int i6, int i7) {
        this.f49749w.c(i4, i5, i6, i7);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(pr prVar) {
        com.ss.android.socialbase.downloader.downloader.xv.c(prVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5) {
        if (com.ss.android.socialbase.downloader.downloader.xv.ux() != null) {
            for (pr prVar : com.ss.android.socialbase.downloader.downloader.xv.ux()) {
                if (prVar != null) {
                    prVar.c(i5, i4);
                }
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, com.ss.android.socialbase.downloader.depend.n nVar) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.c(i4, nVar);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, long j4) {
        c cVar = this.f49748c;
        if (cVar != null) {
            cVar.w(i4, j4);
        }
    }
}
