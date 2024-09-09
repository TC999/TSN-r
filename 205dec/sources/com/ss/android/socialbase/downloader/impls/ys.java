package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.me;
import com.ss.android.socialbase.downloader.depend.pr;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.gd;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class ys implements com.ss.android.socialbase.downloader.downloader.bk, com.ss.android.socialbase.downloader.downloader.t {

    /* renamed from: c  reason: collision with root package name */
    private static final String f49823c = "ys";
    private com.ss.android.socialbase.downloader.downloader.bk sr = new fp();

    /* renamed from: w  reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.downloader.gd f49824w;
    private com.ss.android.socialbase.downloader.downloader.ys<IndependentProcessDownloadService> xv;

    public ys() {
        com.ss.android.socialbase.downloader.downloader.ys<IndependentProcessDownloadService> ck = com.ss.android.socialbase.downloader.downloader.xv.ck();
        this.xv = ck;
        ck.c(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean a(int i4) {
        if (this.f49824w == null) {
            return false;
        }
        try {
            return this.f49824w.k(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public int bk(int i4) {
        if (this.f49824w == null) {
            return com.ss.android.socialbase.downloader.downloader.sr.c().w(i4);
        }
        try {
            return this.f49824w.bk(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4) {
        if (this.f49824w == null) {
            return;
        }
        try {
            this.f49824w.c(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public DownloadInfo ev(int i4) {
        if (this.f49824w == null) {
            return this.sr.ev(i4);
        }
        try {
            return this.f49824w.ev(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public int f(int i4) {
        if (this.f49824w == null) {
            return 0;
        }
        try {
            return this.f49824w.f(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean fp(int i4) {
        if (this.f49824w == null) {
            return this.sr.fp(i4);
        }
        try {
            return this.f49824w.fp(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public IDownloadFileUriProvider fz(int i4) {
        if (this.f49824w != null) {
            try {
                return com.ss.android.socialbase.downloader.gd.r.c(this.f49824w.fz(i4));
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<com.ss.android.socialbase.downloader.model.w> gd(int i4) {
        if (this.f49824w == null) {
            return this.sr.gd(i4);
        }
        try {
            return this.f49824w.gd(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public com.ss.android.socialbase.downloader.depend.n ia(int i4) {
        if (this.f49824w != null) {
            try {
                return com.ss.android.socialbase.downloader.gd.r.c(this.f49824w.ia(i4));
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void k(int i4) {
        com.ss.android.socialbase.downloader.downloader.ys<IndependentProcessDownloadService> ysVar = this.xv;
        if (ysVar != null) {
            ysVar.c(i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void p(int i4) {
        if (this.f49824w == null) {
            this.sr.p(i4);
            return;
        }
        try {
            this.f49824w.p(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean r(int i4) {
        if (this.f49824w == null) {
            return false;
        }
        try {
            return this.f49824w.r(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public me s(int i4) {
        if (this.f49824w != null) {
            try {
                return com.ss.android.socialbase.downloader.gd.r.c(this.f49824w.s(i4));
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void sr(int i4) {
        if (this.f49824w == null) {
            return;
        }
        try {
            this.f49824w.sr(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.ys<IndependentProcessDownloadService> ysVar = this.xv;
        if (ysVar != null) {
            ysVar.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean t(int i4) {
        if (this.f49824w == null) {
            return this.sr.t(i4);
        }
        try {
            return this.f49824w.t(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public long ux(int i4) {
        if (this.f49824w == null) {
            return 0L;
        }
        try {
            return this.f49824w.ux(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean w(int i4) {
        if (this.f49824w == null) {
            return false;
        }
        try {
            return this.f49824w.w(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void xv(int i4) {
        if (this.f49824w == null) {
            return;
        }
        try {
            this.f49824w.xv(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void ys(int i4) {
        if (this.f49824w == null) {
            this.sr.ys(i4);
            return;
        }
        try {
            this.f49824w.ys(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, boolean z3) {
        if (this.f49824w == null) {
            return;
        }
        try {
            this.f49824w.c(i4, z3);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void f() {
        if (this.f49824w == null) {
            this.sr.f();
            return;
        }
        try {
            this.f49824w.ux();
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean r() {
        return this.f49824w != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> sr() {
        if (this.f49824w == null) {
            return this.sr.sr();
        }
        try {
            return this.f49824w.w();
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> ux(String str) {
        if (this.f49824w != null) {
            try {
                return this.f49824w.sr(str);
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public DownloadInfo w(String str, String str2) {
        return ev(c(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> xv(String str) {
        if (this.f49824w == null) {
            return this.sr.xv(str);
        }
        try {
            return this.f49824w.xv(str);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void ev() {
        this.f49824w = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> w(String str) {
        if (this.f49824w == null) {
            return this.sr.w(str);
        }
        try {
            return this.f49824w.w(str);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c() {
        if (this.f49824w == null) {
            return;
        }
        try {
            this.f49824w.c();
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean ux() {
        if (this.f49824w == null) {
            return this.sr.ux();
        }
        try {
            return this.f49824w.sr();
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> sr(String str) {
        if (this.f49824w == null) {
            return this.sr.sr(str);
        }
        try {
            return this.f49824w.ux(str);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean xv() {
        return com.ss.android.socialbase.downloader.downloader.xv.vc();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void xv(int i4, boolean z3) {
        if (this.f49824w == null) {
            return;
        }
        try {
            this.f49824w.sr(i4, z3);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public List<DownloadInfo> c(String str) {
        if (this.f49824w == null) {
            return this.sr.c(str);
        }
        try {
            return this.f49824w.c(str);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(List<String> list) {
        if (this.f49824w == null) {
            this.sr.w(list);
            return;
        }
        try {
            this.f49824w.w(list);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean xv(DownloadInfo downloadInfo) {
        if (this.f49824w == null) {
            return this.sr.xv(downloadInfo);
        }
        try {
            return this.f49824w.w(downloadInfo);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public int c(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.xv.c(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(int i4, boolean z3) {
        if (this.f49824w == null) {
            this.sr.w(i4, z3);
            return;
        }
        try {
            this.f49824w.w(i4, z3);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(List<String> list) {
        if (this.f49824w == null) {
            this.sr.c(list);
            return;
        }
        try {
            this.f49824w.c(list);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3) {
        if (this.f49824w == null) {
            return;
        }
        try {
            this.f49824w.c(i4, i5, com.ss.android.socialbase.downloader.gd.r.c(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z3);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3) {
        if (this.f49824w == null) {
            return;
        }
        try {
            this.f49824w.w(i4, i5, com.ss.android.socialbase.downloader.gd.r.c(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z3);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean w() {
        if (this.f49824w == null) {
            com.ss.android.socialbase.downloader.xv.c.sr(f49823c, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.xv.c.xv(f49823c, "aidlService.isServiceForeground");
        try {
            return this.f49824w.f();
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.f fVar, boolean z3, boolean z4) {
        if (this.f49824w == null) {
            return;
        }
        try {
            this.f49824w.c(i4, i5, com.ss.android.socialbase.downloader.gd.r.c(iDownloadListener, fVar != com.ss.android.socialbase.downloader.constants.f.SUB), fVar.ordinal(), z3, z4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public boolean c(DownloadInfo downloadInfo) {
        if (this.f49824w == null) {
            return this.sr.c(downloadInfo);
        }
        try {
            this.f49824w.c(downloadInfo);
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.ys<IndependentProcessDownloadService> ysVar;
        if (downloadTask == null || (ysVar = this.xv) == null) {
            return;
        }
        ysVar.xv(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void w(int i4, List<com.ss.android.socialbase.downloader.model.w> list) {
        if (this.f49824w == null) {
            this.sr.w(i4, list);
            return;
        }
        try {
            this.f49824w.c(i4, list);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, Notification notification) {
        if (this.f49824w == null) {
            com.ss.android.socialbase.downloader.xv.c.sr(f49823c, "startForeground, aidlService is null");
            return;
        }
        String str = f49823c;
        com.ss.android.socialbase.downloader.xv.c.xv(str, "aidlService.startForeground, id = " + i4);
        try {
            this.f49824w.c(i4, notification);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(boolean z3, boolean z4) {
        if (this.f49824w == null) {
            com.ss.android.socialbase.downloader.xv.c.sr(f49823c, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.xv.c.xv(f49823c, "aidlService.stopForeground");
        try {
            this.f49824w.c(z4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.ys<IndependentProcessDownloadService> ysVar;
        if (downloadTask == null || (ysVar = this.xv) == null) {
            return;
        }
        ysVar.w(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, List<com.ss.android.socialbase.downloader.model.w> list) {
        if (this.f49824w == null) {
            return;
        }
        try {
            this.f49824w.w(i4, list);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(com.ss.android.socialbase.downloader.model.w wVar) {
        if (this.f49824w == null) {
            this.sr.c(wVar);
            return;
        }
        try {
            this.f49824w.c(wVar);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5, long j4) {
        if (this.f49824w == null) {
            this.sr.c(i4, i5, j4);
            return;
        }
        try {
            this.f49824w.c(i4, i5, j4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5, int i6, long j4) {
        if (this.f49824w == null) {
            this.sr.c(i4, i5, i6, j4);
            return;
        }
        try {
            this.f49824w.c(i4, i5, i6, j4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5, int i6, int i7) {
        if (this.f49824w == null) {
            this.sr.c(i4, i5, i6, i7);
            return;
        }
        try {
            this.f49824w.c(i4, i5, i6, i7);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(pr prVar) {
        if (this.f49824w != null) {
            try {
                this.f49824w.c(com.ss.android.socialbase.downloader.gd.r.c(prVar));
            } catch (RemoteException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, int i5) {
        if (this.f49824w != null) {
            try {
                this.f49824w.c(i4, i5);
            } catch (RemoteException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, com.ss.android.socialbase.downloader.depend.n nVar) {
        if (this.f49824w != null) {
            try {
                this.f49824w.c(i4, com.ss.android.socialbase.downloader.gd.r.c(nVar));
            } catch (RemoteException e4) {
                e4.printStackTrace();
            }
        }
    }

    public void c(IBinder iBinder) {
        this.f49824w = gd.c.c(iBinder);
        if (com.ss.android.socialbase.downloader.gd.f.c()) {
            c(new pr() { // from class: com.ss.android.socialbase.downloader.impls.ys.1
                @Override // com.ss.android.socialbase.downloader.depend.pr
                public void c(int i4, int i5) {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).cancel(i4);
                            return;
                        }
                        return;
                    }
                    Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.xv.gw()).pause(i4);
                    List<com.ss.android.socialbase.downloader.model.w> gd = a.c(false).gd(i4);
                    if (gd != null) {
                        a.c(true).c(i4, com.ss.android.socialbase.downloader.gd.f.c(gd));
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.bk
    public void c(int i4, long j4) {
        if (this.f49824w == null) {
            return;
        }
        try {
            this.f49824w.c(i4, j4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }
}
