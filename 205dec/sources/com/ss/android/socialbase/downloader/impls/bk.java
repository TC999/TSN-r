package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.eq;
import com.ss.android.socialbase.downloader.depend.gb;
import com.ss.android.socialbase.downloader.depend.wx;
import com.ss.android.socialbase.downloader.downloader.gd;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class bk extends gd.c {

    /* renamed from: c  reason: collision with root package name */
    private static final String f49726c = bk.class.getSimpleName();

    /* renamed from: w  reason: collision with root package name */
    private final com.ss.android.socialbase.downloader.downloader.bk f49727w = new fp(true);

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void a(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.k(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public int bk(int i4) throws RemoteException {
        return com.ss.android.socialbase.downloader.downloader.sr.c().w(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(com.ss.android.socialbase.downloader.model.c cVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.w(com.ss.android.socialbase.downloader.gd.r.c(cVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public DownloadInfo ev(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return bkVar.ev(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public int f(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return 0;
        }
        return bkVar.f(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public boolean fp(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return false;
        }
        return bkVar.fp(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public com.ss.android.socialbase.downloader.depend.r fz(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.gd.r.c(bkVar.fz(i4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public List<com.ss.android.socialbase.downloader.model.w> gd(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return bkVar.gd(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public gb ia(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.gd.r.c(bkVar.ia(i4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public boolean k(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return false;
        }
        return bkVar.a(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void p(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.p(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public boolean r(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return false;
        }
        return bkVar.r(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public eq s(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return com.ss.android.socialbase.downloader.gd.r.c(bkVar.s(i4));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void sr(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.sr(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public boolean t(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return false;
        }
        return bkVar.t(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public long ux(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return 0L;
        }
        return bkVar.ux(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public boolean w(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return false;
        }
        return bkVar.w(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void xv(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.xv(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void ys(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.ys(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public boolean f() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return false;
        }
        return bkVar.w();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public List<DownloadInfo> sr(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return bkVar.ux(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public List<DownloadInfo> ux(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return bkVar.sr(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public DownloadInfo w(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return bkVar.w(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public List<DownloadInfo> xv(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return bkVar.xv(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4, boolean z3) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4, z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public boolean sr() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return false;
        }
        return bkVar.ux();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void ux() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.f();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public List<DownloadInfo> w(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return bkVar.w(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void xv(int i4, boolean z3) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.w(i4, z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void sr(int i4, boolean z3) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.sr.c().w(i4, z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public List<DownloadInfo> w() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return bkVar.sr();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public boolean xv() throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return false;
        }
        return bkVar.xv();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public List<DownloadInfo> c(String str) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return null;
        }
        return bkVar.c(str);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void w(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar != null) {
            bkVar.w(list);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public int c(String str, String str2) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return 0;
        }
        return bkVar.c(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void w(int i4, boolean z3) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.w(i4, z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(List<String> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void w(int i4, int i5, com.ss.android.socialbase.downloader.depend.gd gdVar, int i6, boolean z3) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4, i5, com.ss.android.socialbase.downloader.gd.r.c(gdVar), com.ss.android.socialbase.downloader.gd.f.ux(i6), z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4, int i5, com.ss.android.socialbase.downloader.depend.gd gdVar, int i6, boolean z3) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.w(i4, i5, com.ss.android.socialbase.downloader.gd.r.c(gdVar), com.ss.android.socialbase.downloader.gd.f.ux(i6), z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public boolean w(DownloadInfo downloadInfo) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return false;
        }
        return bkVar.xv(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4, int i5, com.ss.android.socialbase.downloader.depend.gd gdVar, int i6, boolean z3, boolean z4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4, i5, com.ss.android.socialbase.downloader.gd.r.c(gdVar), com.ss.android.socialbase.downloader.gd.f.ux(i6), z3, z4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void w(int i4, List<com.ss.android.socialbase.downloader.model.w> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public boolean c(DownloadInfo downloadInfo) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return false;
        }
        return bkVar.c(downloadInfo);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4, Notification notification) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4, notification);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(boolean z3) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(true, z3);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4, long j4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4, j4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(com.ss.android.socialbase.downloader.model.w wVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(wVar);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4, int i5, long j4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4, i5, j4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4, int i5, int i6, long j4) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4, i5, i6, j4);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4, int i5, int i6, int i7) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4, i5, i6, i7);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4, List<com.ss.android.socialbase.downloader.model.w> list) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.w(i4, list);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(wx wxVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(com.ss.android.socialbase.downloader.gd.r.c(wxVar));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4, int i5) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4, i5);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.gd
    public void c(int i4, gb gbVar) throws RemoteException {
        com.ss.android.socialbase.downloader.downloader.bk bkVar = this.f49727w;
        if (bkVar == null) {
            return;
        }
        bkVar.c(i4, com.ss.android.socialbase.downloader.gd.r.c(gbVar));
    }
}
