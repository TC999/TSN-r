package com.p521ss.android.socialbase.downloader.impls;

import android.app.Notification;
import android.os.IBinder;
import android.os.RemoteException;
import com.p521ss.android.socialbase.downloader.constants.EnumC12414kf;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12471sg;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.C12515s;
import com.p521ss.android.socialbase.downloader.downloader.Downloader;
import com.p521ss.android.socialbase.downloader.downloader.IndependentProcessDownloadService;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12510q;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12514rh;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12517t;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p556q.C12668h;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.util.List;

/* renamed from: com.ss.android.socialbase.downloader.impls.t */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12563t implements InterfaceC12514rh, InterfaceC12522z {

    /* renamed from: ok */
    private static final String f35271ok = "t";

    /* renamed from: a */
    private volatile InterfaceC12510q f35272a;

    /* renamed from: bl */
    private InterfaceC12517t<IndependentProcessDownloadService> f35273bl;

    /* renamed from: s */
    private InterfaceC12522z f35274s = new C12541i();

    public C12563t() {
        InterfaceC12517t<IndependentProcessDownloadService> m17751vz = C12490bl.m17751vz();
        this.f35273bl = m17751vz;
        m17751vz.mo17522ok(this);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17467a(DownloadInfo downloadInfo) {
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public boolean mo17471a(int i) {
        if (this.f35272a == null) {
            return false;
        }
        try {
            return this.f35272a.mo17373a(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: bl */
    public void mo17461bl(int i) {
        if (this.f35272a == null) {
            return;
        }
        try {
            this.f35272a.mo17364bl(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: h */
    public boolean mo17456h(int i) {
        if (this.f35272a == null) {
            return false;
        }
        try {
            return this.f35272a.mo17361h(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: i */
    public boolean mo17455i(int i) {
        if (this.f35272a == null) {
            return this.f35274s.mo17455i(i);
        }
        try {
            return this.f35272a.mo17360i(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: j */
    public boolean mo17454j(int i) {
        if (this.f35272a == null) {
            return false;
        }
        try {
            return this.f35272a.mo17329r(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: k */
    public void mo17453k(int i) {
        if (this.f35272a == null) {
            this.f35274s.mo17453k(i);
            return;
        }
        try {
            this.f35272a.mo17358k(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: kf */
    public int mo17451kf(int i) {
        if (this.f35272a == null) {
            return 0;
        }
        try {
            return this.f35272a.mo17356kf(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: n */
    public long mo17449n(int i) {
        if (this.f35272a == null) {
            return 0L;
        }
        try {
            return this.f35272a.mo17354n(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return 0L;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17446ok(int i) {
        if (this.f35272a == null) {
            return;
        }
        try {
            this.f35272a.mo17351ok(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: p */
    public DownloadInfo mo17424p(int i) {
        if (this.f35272a == null) {
            return this.f35274s.mo17424p(i);
        }
        try {
            return this.f35272a.mo17331p(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: q */
    public List<C12598a> mo17423q(int i) {
        if (this.f35272a == null) {
            return this.f35274s.mo17423q(i);
        }
        try {
            return this.f35272a.mo17330q(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: r */
    public void mo17422r(int i) {
        InterfaceC12517t<IndependentProcessDownloadService> interfaceC12517t = this.f35273bl;
        if (interfaceC12517t != null) {
            interfaceC12517t.mo17524ok(i);
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: rh */
    public boolean mo17421rh(int i) {
        if (this.f35272a == null) {
            return this.f35274s.mo17421rh(i);
        }
        try {
            return this.f35272a.mo17328rh(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: s */
    public void mo17419s(int i) {
        if (this.f35272a == null) {
            return;
        }
        try {
            this.f35272a.mo17326s(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    public void startService() {
        InterfaceC12517t<IndependentProcessDownloadService> interfaceC12517t = this.f35273bl;
        if (interfaceC12517t != null) {
            interfaceC12517t.startService();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: t */
    public void mo17417t(int i) {
        if (this.f35272a == null) {
            this.f35274s.mo17417t(i);
            return;
        }
        try {
            this.f35272a.mo17323t(i);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: td */
    public InterfaceC12480v mo17416td(int i) {
        if (this.f35272a != null) {
            try {
                return C12668h.m16724ok(this.f35272a.mo17322td(i));
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: x */
    public InterfaceC12427ep mo17415x(int i) {
        if (this.f35272a != null) {
            try {
                return C12668h.m16717ok(this.f35272a.mo17321x(i));
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: z */
    public int mo17414z(int i) {
        if (this.f35272a == null) {
            return C12515s.m17660ok().m17682a(i);
        }
        try {
            return this.f35272a.mo17320z(i);
        } catch (RemoteException e) {
            e.printStackTrace();
            return -1;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: zz */
    public IDownloadFileUriProvider mo17413zz(int i) {
        if (this.f35272a != null) {
            try {
                return C12668h.m16723ok(this.f35272a.mo17319zz(i));
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public DownloadInfo mo17464a(String str, String str2) {
        return mo17424p(mo17428ok(str, str2));
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: bl */
    public List<DownloadInfo> mo17458bl(String str) {
        if (this.f35272a == null) {
            return this.f35274s.mo17458bl(str);
        }
        try {
            return this.f35272a.mo17362bl(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: h */
    public boolean mo17457h() {
        return this.f35272a != null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: kf */
    public void mo17452kf() {
        if (this.f35272a == null) {
            this.f35274s.mo17452kf();
            return;
        }
        try {
            this.f35272a.mo17355n();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: n */
    public List<DownloadInfo> mo17448n(String str) {
        if (this.f35272a != null) {
            try {
                return this.f35272a.mo17324s(str);
            } catch (RemoteException e) {
                e.printStackTrace();
                return null;
            }
        }
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17435ok(int i, boolean z) {
        if (this.f35272a == null) {
            return;
        }
        try {
            this.f35272a.mo17340ok(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: s */
    public List<DownloadInfo> mo17420s() {
        if (this.f35272a == null) {
            return this.f35274s.mo17420s();
        }
        try {
            return this.f35272a.mo17374a();
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12514rh
    /* renamed from: p */
    public void mo17425p() {
        this.f35272a = null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public List<DownloadInfo> mo17465a(String str) {
        if (this.f35272a == null) {
            return this.f35274s.mo17465a(str);
        }
        try {
            return this.f35272a.mo17368a(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: n */
    public boolean mo17450n() {
        if (this.f35272a == null) {
            return this.f35274s.mo17450n();
        }
        try {
            return this.f35272a.mo17327s();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17447ok() {
        if (this.f35272a == null) {
            return;
        }
        try {
            this.f35272a.mo17352ok();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: bl */
    public boolean mo17462bl() {
        return C12490bl.m17750wv();
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: s */
    public List<DownloadInfo> mo17418s(String str) {
        if (this.f35272a == null) {
            return this.f35274s.mo17418s(str);
        }
        try {
            return this.f35272a.mo17353n(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: bl */
    public void mo17460bl(int i, boolean z) {
        if (this.f35272a == null) {
            return;
        }
        try {
            this.f35272a.mo17325s(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17463a(List<String> list) {
        if (this.f35272a == null) {
            this.f35274s.mo17463a(list);
            return;
        }
        try {
            this.f35272a.mo17366a(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public List<DownloadInfo> mo17429ok(String str) {
        if (this.f35272a == null) {
            return this.f35274s.mo17429ok(str);
        }
        try {
            return this.f35272a.mo17335ok(str);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: bl */
    public boolean mo17459bl(DownloadInfo downloadInfo) {
        if (this.f35272a == null) {
            return this.f35274s.mo17459bl(downloadInfo);
        }
        try {
            return this.f35272a.mo17369a(downloadInfo);
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17468a(int i, boolean z) {
        if (this.f35272a == null) {
            this.f35274s.mo17468a(i, z);
            return;
        }
        try {
            this.f35272a.mo17370a(i, z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public int mo17428ok(String str, String str2) {
        return C12490bl.m17776ok(str, str2);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17427ok(List<String> list) {
        if (this.f35272a == null) {
            this.f35274s.mo17427ok(list);
            return;
        }
        try {
            this.f35272a.mo17333ok(list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17470a(int i, int i2, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z) {
        if (this.f35272a == null) {
            return;
        }
        try {
            this.f35272a.mo17346ok(i, i2, C12668h.m16728ok(iDownloadListener, enumC12414kf != EnumC12414kf.SUB), enumC12414kf.ordinal(), z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17441ok(int i, int i2, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z) {
        if (this.f35272a == null) {
            return;
        }
        try {
            this.f35272a.mo17372a(i, i2, C12668h.m16728ok(iDownloadListener, enumC12414kf != EnumC12414kf.SUB), enumC12414kf.ordinal(), z);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public boolean mo17472a() {
        if (this.f35272a == null) {
            C12409ok.m17894s(f35271ok, "isServiceForeground, aidlService is null");
            return false;
        }
        C12409ok.m17901bl(f35271ok, "aidlService.isServiceForeground");
        try {
            return this.f35272a.mo17357kf();
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17440ok(int i, int i2, IDownloadListener iDownloadListener, EnumC12414kf enumC12414kf, boolean z, boolean z2) {
        if (this.f35272a == null) {
            return;
        }
        try {
            this.f35272a.mo17345ok(i, i2, C12668h.m16728ok(iDownloadListener, enumC12414kf != EnumC12414kf.SUB), enumC12414kf.ordinal(), z, z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public boolean mo17432ok(DownloadInfo downloadInfo) {
        if (this.f35272a == null) {
            return this.f35274s.mo17432ok(downloadInfo);
        }
        try {
            this.f35272a.mo17338ok(downloadInfo);
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17466a(DownloadTask downloadTask) {
        InterfaceC12517t<IndependentProcessDownloadService> interfaceC12517t;
        if (downloadTask == null || (interfaceC12517t = this.f35273bl) == null) {
            return;
        }
        interfaceC12517t.mo17526bl(downloadTask);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: a */
    public void mo17469a(int i, List<C12598a> list) {
        if (this.f35272a == null) {
            this.f35274s.mo17469a(i, list);
            return;
        }
        try {
            this.f35272a.mo17341ok(i, list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17438ok(int i, Notification notification) {
        if (this.f35272a == null) {
            C12409ok.m17894s(f35271ok, "startForeground, aidlService is null");
            return;
        }
        String str = f35271ok;
        C12409ok.m17901bl(str, "aidlService.startForeground, id = " + i);
        try {
            this.f35272a.mo17343ok(i, notification);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17426ok(boolean z, boolean z2) {
        if (this.f35272a == null) {
            C12409ok.m17894s(f35271ok, "stopForeground, aidlService is null");
            return;
        }
        C12409ok.m17901bl(f35271ok, "aidlService.stopForeground");
        try {
            this.f35272a.mo17332ok(z2);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17431ok(DownloadTask downloadTask) {
        InterfaceC12517t<IndependentProcessDownloadService> interfaceC12517t;
        if (downloadTask == null || (interfaceC12517t = this.f35273bl) == null) {
            return;
        }
        interfaceC12517t.mo17527a(downloadTask);
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17436ok(int i, List<C12598a> list) {
        if (this.f35272a == null) {
            return;
        }
        try {
            this.f35272a.mo17371a(i, list);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17430ok(C12598a c12598a) {
        if (this.f35272a == null) {
            this.f35274s.mo17430ok(c12598a);
            return;
        }
        try {
            this.f35272a.mo17337ok(c12598a);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17442ok(int i, int i2, long j) {
        if (this.f35272a == null) {
            this.f35274s.mo17442ok(i, i2, j);
            return;
        }
        try {
            this.f35272a.mo17347ok(i, i2, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17443ok(int i, int i2, int i3, long j) {
        if (this.f35272a == null) {
            this.f35274s.mo17443ok(i, i2, i3, j);
            return;
        }
        try {
            this.f35272a.mo17348ok(i, i2, i3, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17444ok(int i, int i2, int i3, int i4) {
        if (this.f35272a == null) {
            this.f35274s.mo17444ok(i, i2, i3, i4);
            return;
        }
        try {
            this.f35272a.mo17349ok(i, i2, i3, i4);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17433ok(InterfaceC12471sg interfaceC12471sg) {
        if (this.f35272a != null) {
            try {
                this.f35272a.mo17339ok(C12668h.m16711ok(interfaceC12471sg));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17445ok(int i, int i2) {
        if (this.f35272a != null) {
            try {
                this.f35272a.mo17350ok(i, i2);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17437ok(int i, InterfaceC12427ep interfaceC12427ep) {
        if (this.f35272a != null) {
            try {
                this.f35272a.mo17342ok(i, C12668h.m16725ok(interfaceC12427ep));
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12514rh
    /* renamed from: ok */
    public void mo17434ok(IBinder iBinder) {
        this.f35272a = InterfaceC12510q.AbstractBinderC12511ok.m17684ok(iBinder);
        if (C12713kf.m16575ok()) {
            mo17433ok(new InterfaceC12471sg() { // from class: com.ss.android.socialbase.downloader.impls.t.1
                @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12471sg
                /* renamed from: ok */
                public void mo16655ok(int i, int i2) {
                    if (i2 != 1) {
                        if (i2 == 2) {
                            Downloader.getInstance(C12490bl.m17807l()).cancel(i);
                            return;
                        }
                        return;
                    }
                    Downloader.getInstance(C12490bl.m17807l()).pause(i);
                    List<C12598a> mo17423q = C12542j.m17583ok(false).mo17423q(i);
                    if (mo17423q != null) {
                        C12542j.m17583ok(true).mo17436ok(i, C12713kf.m16539ok(mo17423q));
                    }
                }
            });
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12522z
    /* renamed from: ok */
    public void mo17439ok(int i, long j) {
        if (this.f35272a == null) {
            return;
        }
        try {
            this.f35272a.mo17344ok(i, j);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
