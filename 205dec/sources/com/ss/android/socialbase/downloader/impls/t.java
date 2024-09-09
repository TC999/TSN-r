package com.ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.sg;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.downloader.Downloader;
import com.ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.ss.android.socialbase.downloader.downloader.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import java.util.List;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6206960.dex
 */
/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class t implements com.ss.android.socialbase.downloader.downloader.rh, com.ss.android.socialbase.downloader.downloader.z {
    private static final String ok = "t";

    /* renamed from: a  reason: collision with root package name */
    private volatile com.ss.android.socialbase.downloader.downloader.q f49803a;
    private com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> bl;

    /* renamed from: s  reason: collision with root package name */
    private com.ss.android.socialbase.downloader.downloader.z f49804s = new i();

    public t() {
        com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> vz = com.ss.android.socialbase.downloader.downloader.bl.vz();
        this.bl = vz;
        vz.ok(this);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(DownloadInfo downloadInfo) {
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean a(int i4) {
        if (this.f49803a == null) {
            return false;
        }
        try {
            return this.f49803a.a(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void bl(int i4) {
        if (this.f49803a == null) {
            return;
        }
        try {
            this.f49803a.bl(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean h(int i4) {
        if (this.f49803a == null) {
            return false;
        }
        try {
            return this.f49803a.h(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean i(int i4) {
        if (this.f49803a == null) {
            return this.f49804s.i(i4);
        }
        try {
            return this.f49803a.i(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean j(int i4) {
        if (this.f49803a == null) {
            return false;
        }
        try {
            return this.f49803a.r(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void k(int i4) {
        if (this.f49803a == null) {
            this.f49804s.k(i4);
            return;
        }
        try {
            this.f49803a.k(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int kf(int i4) {
        if (this.f49803a == null) {
            return 0;
        }
        try {
            return this.f49803a.kf(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return 0;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public long n(int i4) {
        if (this.f49803a == null) {
            return 0L;
        }
        try {
            return this.f49803a.n(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return 0L;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4) {
        if (this.f49803a == null) {
            return;
        }
        try {
            this.f49803a.ok(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public DownloadInfo p(int i4) {
        if (this.f49803a == null) {
            return this.f49804s.p(i4);
        }
        try {
            return this.f49803a.p(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<com.ss.android.socialbase.downloader.model.a> q(int i4) {
        if (this.f49803a == null) {
            return this.f49804s.q(i4);
        }
        try {
            return this.f49803a.q(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void r(int i4) {
        com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> tVar = this.bl;
        if (tVar != null) {
            tVar.ok(i4);
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean rh(int i4) {
        if (this.f49803a == null) {
            return this.f49804s.rh(i4);
        }
        try {
            return this.f49803a.rh(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void s(int i4) {
        if (this.f49803a == null) {
            return;
        }
        try {
            this.f49803a.s(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void startService() {
        com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> tVar = this.bl;
        if (tVar != null) {
            tVar.startService();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void t(int i4) {
        if (this.f49803a == null) {
            this.f49804s.t(i4);
            return;
        }
        try {
            this.f49803a.t(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public v td(int i4) {
        if (this.f49803a != null) {
            try {
                return com.ss.android.socialbase.downloader.q.h.ok(this.f49803a.td(i4));
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public ep x(int i4) {
        if (this.f49803a != null) {
            try {
                return com.ss.android.socialbase.downloader.q.h.ok(this.f49803a.x(i4));
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int z(int i4) {
        if (this.f49803a == null) {
            return com.ss.android.socialbase.downloader.downloader.s.ok().a(i4);
        }
        try {
            return this.f49803a.z(i4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return -1;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public IDownloadFileUriProvider zz(int i4) {
        if (this.f49803a != null) {
            try {
                return com.ss.android.socialbase.downloader.q.h.ok(this.f49803a.zz(i4));
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public DownloadInfo a(String str, String str2) {
        return p(ok(str, str2));
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> bl(String str) {
        if (this.f49803a == null) {
            return this.f49804s.bl(str);
        }
        try {
            return this.f49803a.bl(str);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean h() {
        return this.f49803a != null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void kf() {
        if (this.f49803a == null) {
            this.f49804s.kf();
            return;
        }
        try {
            this.f49803a.n();
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> n(String str) {
        if (this.f49803a != null) {
            try {
                return this.f49803a.s(str);
            } catch (RemoteException e4) {
                e4.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, boolean z3) {
        if (this.f49803a == null) {
            return;
        }
        try {
            this.f49803a.ok(i4, z3);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> s() {
        if (this.f49803a == null) {
            return this.f49804s.s();
        }
        try {
            return this.f49803a.a();
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.rh
    public void p() {
        this.f49803a = null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> a(String str) {
        if (this.f49803a == null) {
            return this.f49804s.a(str);
        }
        try {
            return this.f49803a.a(str);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean n() {
        if (this.f49803a == null) {
            return this.f49804s.n();
        }
        try {
            return this.f49803a.s();
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok() {
        if (this.f49803a == null) {
            return;
        }
        try {
            this.f49803a.ok();
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean bl() {
        return com.ss.android.socialbase.downloader.downloader.bl.wv();
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> s(String str) {
        if (this.f49803a == null) {
            return this.f49804s.s(str);
        }
        try {
            return this.f49803a.n(str);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void bl(int i4, boolean z3) {
        if (this.f49803a == null) {
            return;
        }
        try {
            this.f49803a.s(i4, z3);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(List<String> list) {
        if (this.f49803a == null) {
            this.f49804s.a(list);
            return;
        }
        try {
            this.f49803a.a(list);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public List<DownloadInfo> ok(String str) {
        if (this.f49803a == null) {
            return this.f49804s.ok(str);
        }
        try {
            return this.f49803a.ok(str);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean bl(DownloadInfo downloadInfo) {
        if (this.f49803a == null) {
            return this.f49804s.bl(downloadInfo);
        }
        try {
            return this.f49803a.a(downloadInfo);
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i4, boolean z3) {
        if (this.f49803a == null) {
            this.f49804s.a(i4, z3);
            return;
        }
        try {
            this.f49803a.a(i4, z3);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public int ok(String str, String str2) {
        return com.ss.android.socialbase.downloader.downloader.bl.ok(str, str2);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(List<String> list) {
        if (this.f49803a == null) {
            this.f49804s.ok(list);
            return;
        }
        try {
            this.f49803a.ok(list);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3) {
        if (this.f49803a == null) {
            return;
        }
        try {
            this.f49803a.ok(i4, i5, com.ss.android.socialbase.downloader.q.h.ok(iDownloadListener, kfVar != com.ss.android.socialbase.downloader.constants.kf.SUB), kfVar.ordinal(), z3);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3) {
        if (this.f49803a == null) {
            return;
        }
        try {
            this.f49803a.a(i4, i5, com.ss.android.socialbase.downloader.q.h.ok(iDownloadListener, kfVar != com.ss.android.socialbase.downloader.constants.kf.SUB), kfVar.ordinal(), z3);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean a() {
        if (this.f49803a == null) {
            com.ss.android.socialbase.downloader.bl.ok.s(ok, "isServiceForeground, aidlService is null");
            return false;
        }
        com.ss.android.socialbase.downloader.bl.ok.bl(ok, "aidlService.isServiceForeground");
        try {
            return this.f49803a.kf();
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5, IDownloadListener iDownloadListener, com.ss.android.socialbase.downloader.constants.kf kfVar, boolean z3, boolean z4) {
        if (this.f49803a == null) {
            return;
        }
        try {
            this.f49803a.ok(i4, i5, com.ss.android.socialbase.downloader.q.h.ok(iDownloadListener, kfVar != com.ss.android.socialbase.downloader.constants.kf.SUB), kfVar.ordinal(), z3, z4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public boolean ok(DownloadInfo downloadInfo) {
        if (this.f49803a == null) {
            return this.f49804s.ok(downloadInfo);
        }
        try {
            this.f49803a.ok(downloadInfo);
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> tVar;
        if (downloadTask == null || (tVar = this.bl) == null) {
            return;
        }
        tVar.bl(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void a(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
        if (this.f49803a == null) {
            this.f49804s.a(i4, list);
            return;
        }
        try {
            this.f49803a.ok(i4, list);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, Notification notification) {
        if (this.f49803a == null) {
            com.ss.android.socialbase.downloader.bl.ok.s(ok, "startForeground, aidlService is null");
            return;
        }
        String str = ok;
        com.ss.android.socialbase.downloader.bl.ok.bl(str, "aidlService.startForeground, id = " + i4);
        try {
            this.f49803a.ok(i4, notification);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(boolean z3, boolean z4) {
        if (this.f49803a == null) {
            com.ss.android.socialbase.downloader.bl.ok.s(ok, "stopForeground, aidlService is null");
            return;
        }
        com.ss.android.socialbase.downloader.bl.ok.bl(ok, "aidlService.stopForeground");
        try {
            this.f49803a.ok(z4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(DownloadTask downloadTask) {
        com.ss.android.socialbase.downloader.downloader.t<IndependentProcessDownloadService> tVar;
        if (downloadTask == null || (tVar = this.bl) == null) {
            return;
        }
        tVar.a(downloadTask);
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
        if (this.f49803a == null) {
            return;
        }
        try {
            this.f49803a.a(i4, list);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(com.ss.android.socialbase.downloader.model.a aVar) {
        if (this.f49803a == null) {
            this.f49804s.ok(aVar);
            return;
        }
        try {
            this.f49803a.ok(aVar);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5, long j4) {
        if (this.f49803a == null) {
            this.f49804s.ok(i4, i5, j4);
            return;
        }
        try {
            this.f49803a.ok(i4, i5, j4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5, int i6, long j4) {
        if (this.f49803a == null) {
            this.f49804s.ok(i4, i5, i6, j4);
            return;
        }
        try {
            this.f49803a.ok(i4, i5, i6, j4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5, int i6, int i7) {
        if (this.f49803a == null) {
            this.f49804s.ok(i4, i5, i6, i7);
            return;
        }
        try {
            this.f49803a.ok(i4, i5, i6, i7);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(sg sgVar) {
        if (this.f49803a != null) {
            try {
                this.f49803a.ok(com.ss.android.socialbase.downloader.q.h.ok(sgVar));
            } catch (RemoteException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, int i5) {
        if (this.f49803a != null) {
            try {
                this.f49803a.ok(i4, i5);
            } catch (RemoteException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, ep epVar) {
        if (this.f49803a != null) {
            try {
                this.f49803a.ok(i4, com.ss.android.socialbase.downloader.q.h.ok(epVar));
            } catch (RemoteException e4) {
                e4.printStackTrace();
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.rh
    public void ok(IBinder iBinder) {
        this.f49803a = q.ok.ok(iBinder);
        if (com.ss.android.socialbase.downloader.q.kf.ok()) {
            ok(new sg() { // from class: com.ss.android.socialbase.downloader.impls.t.1
                @Override // com.ss.android.socialbase.downloader.depend.sg
                public void ok(int i4, int i5) {
                    if (i5 != 1) {
                        if (i5 == 2) {
                            Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).cancel(i4);
                            return;
                        }
                        return;
                    }
                    Downloader.getInstance(com.ss.android.socialbase.downloader.downloader.bl.l()).pause(i4);
                    List<com.ss.android.socialbase.downloader.model.a> q3 = j.ok(false).q(i4);
                    if (q3 != null) {
                        j.ok(true).ok(i4, com.ss.android.socialbase.downloader.q.kf.ok(q3));
                    }
                }
            });
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.z
    public void ok(int i4, long j4) {
        if (this.f49803a == null) {
            return;
        }
        try {
            this.f49803a.ok(i4, j4);
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }
}
