package com.p521ss.android.socialbase.downloader.p548a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.p521ss.android.socialbase.downloader.downloader.C12490bl;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12519u;
import com.p521ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.p521ss.android.socialbase.downloader.model.C12598a;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.p548a.InterfaceC12381a;
import com.p521ss.android.socialbase.downloader.p548a.InterfaceC12384bl;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p551kf.C12584q;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* renamed from: com.ss.android.socialbase.downloader.a.kf */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class ServiceConnectionC12388kf implements ServiceConnection, InterfaceC12519u {

    /* renamed from: a */
    private static boolean f34902a;

    /* renamed from: bl */
    private static int f34903bl;

    /* renamed from: s */
    private static long f34904s;

    /* renamed from: h */
    private C12490bl.InterfaceC12494ok.InterfaceC12495ok f34905h;
    @Nullable

    /* renamed from: ok */
    private InterfaceC12384bl f34909ok;

    /* renamed from: q */
    private Future<?> f34911q;

    /* renamed from: n */
    private Handler f34908n = new Handler(Looper.getMainLooper());

    /* renamed from: kf */
    private InterfaceC12381a f34907kf = null;

    /* renamed from: p */
    private Runnable f34910p = new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.1
        @Override // java.lang.Runnable
        public void run() {
            if (ServiceConnectionC12388kf.f34902a || ServiceConnectionC12388kf.this.f34905h == null) {
                return;
            }
            ServiceConnectionC12388kf.this.f34905h.mo17474ok();
        }
    };

    /* renamed from: k */
    private CountDownLatch f34906k = new CountDownLatch(1);

    public ServiceConnectionC12388kf() {
        SqlDownloadCacheService.m17842ok(C12490bl.m17807l(), this);
    }

    /* renamed from: ok */
    static /* synthetic */ C12490bl.InterfaceC12494ok.InterfaceC12495ok m17982ok(ServiceConnectionC12388kf serviceConnectionC12388kf) {
        return serviceConnectionC12388kf.f34905h;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: j */
    public Map<Long, C12584q> mo17506j(int i) {
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: k */
    public DownloadInfo mo17504k(int i) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17958k(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public ArrayList<C12584q> mo17480rh(int i) {
        return null;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public boolean mo17491ok(int i, Map<Long, C12584q> map) {
        return false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        f34902a = true;
        this.f34908n.removeCallbacks(this.f34910p);
        try {
            this.f34909ok = InterfaceC12384bl.AbstractBinderC12385ok.m17997ok(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f34911q = C12490bl.m17812j().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    try {
                        if (ServiceConnectionC12388kf.this.f34907kf != null && ServiceConnectionC12388kf.this.f34909ok != null) {
                            ServiceConnectionC12388kf.this.f34909ok.mo17938ok(ServiceConnectionC12388kf.this.f34907kf);
                        }
                        ServiceConnectionC12388kf.this.f34906k.countDown();
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.a.kf.2.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                boolean unused = ServiceConnectionC12388kf.f34902a = false;
                                if (ServiceConnectionC12388kf.this.m17990h() || ServiceConnectionC12388kf.this.f34905h == null) {
                                    return;
                                }
                                ServiceConnectionC12388kf.this.f34908n.postDelayed(ServiceConnectionC12388kf.this.f34910p, 2000L);
                            }
                        }, 0);
                    } catch (Throwable unused) {
                    }
                }
            }
        });
    }

    @Override // android.content.ServiceConnection
    public void onServiceDisconnected(ComponentName componentName) {
        this.f34909ok = null;
        f34902a = false;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: q */
    public DownloadInfo mo17481q(int i) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17915q(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: z */
    public void mo17475z(int i) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: h */
    public boolean m17990h() {
        if (Build.VERSION.SDK_INT < 26 && !f34902a) {
            if (f34903bl > 5) {
                C12409ok.m17894s("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f34904s < 15000) {
                C12409ok.m17894s("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
                return false;
            }
            f34903bl++;
            f34904s = currentTimeMillis;
            this.f34908n.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.3
                @Override // java.lang.Runnable
                public void run() {
                    SqlDownloadCacheService.m17842ok(C12490bl.m17807l(), ServiceConnectionC12388kf.this);
                }
            }, 1000L);
            return true;
        }
        return false;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public DownloadInfo mo17520a(int i) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17975a(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public List<DownloadInfo> mo17509bl(String str) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17962bl(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: n */
    public boolean mo17500n(int i) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17955n(i);
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: p */
    public DownloadInfo mo17483p(int i) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17917p(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public List<DownloadInfo> mo17476s(String str) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17907s(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: kf */
    public boolean mo17502kf(int i) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17957kf(i);
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: ok */
    public void m17981ok(C12490bl.InterfaceC12494ok.InterfaceC12495ok interfaceC12495ok) {
        this.f34905h = interfaceC12495ok;
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12519u
    /* renamed from: ok */
    public void mo17626ok(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<C12598a>> sparseArray2, final InterfaceC12408s interfaceC12408s) {
        C12490bl.m17812j().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z;
                InterfaceC12408s interfaceC12408s2;
                Future future;
                ServiceConnectionC12388kf.this.m17983ok(new InterfaceC12381a.AbstractBinderC12382ok() { // from class: com.ss.android.socialbase.downloader.a.kf.4.1
                    @Override // com.p521ss.android.socialbase.downloader.p548a.InterfaceC12381a
                    /* renamed from: ok */
                    public void mo17977ok(Map map, Map map2) {
                        C12713kf.m16566ok(sparseArray, map);
                        C12713kf.m16566ok(sparseArray2, map2);
                        interfaceC12408s.mo17473ok();
                        ServiceConnectionC12388kf.this.m17983ok((InterfaceC12381a) null);
                    }
                });
                try {
                    z = !ServiceConnectionC12388kf.this.f34906k.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                    z = false;
                }
                if (z && (future = ServiceConnectionC12388kf.this.f34911q) != null) {
                    future.cancel(true);
                }
                ServiceConnectionC12388kf.this.m17985ok();
                if (!z || (interfaceC12408s2 = interfaceC12408s) == null) {
                    return;
                }
                interfaceC12408s2.mo17473ok();
            }
        });
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public List<DownloadInfo> mo17514a(String str) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17968a(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public List<C12598a> mo17512bl(int i) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17966bl(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: n */
    public boolean mo17501n() {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17956n();
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: ok */
    public void m17983ok(InterfaceC12381a interfaceC12381a) {
        synchronized (this) {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                try {
                    interfaceC12384bl.mo17938ok(interfaceC12381a);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            } else {
                this.f34907kf = interfaceC12381a;
            }
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public void mo17478s(int i) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                interfaceC12384bl.mo17911s(i);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public List<DownloadInfo> mo17521a() {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17976a();
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public void mo17513bl() {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                interfaceC12384bl.mo17967bl();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public DownloadInfo mo17477s(int i, long j) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17910s(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public void mo17515a(C12598a c12598a) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                interfaceC12384bl.mo17969a(c12598a);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: bl */
    public DownloadInfo mo17511bl(int i, long j) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17965bl(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: ok */
    public void m17985ok() {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                interfaceC12384bl.mo17953ok();
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: s */
    public boolean mo17479s() {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17912s();
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: h */
    public DownloadInfo mo17507h(int i) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17960h(i);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public DownloadInfo mo17519a(int i, long j) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17974a(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public List<DownloadInfo> mo17485ok(String str) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17921ok(str);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public void mo17516a(DownloadInfo downloadInfo) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                interfaceC12384bl.mo17971a(downloadInfo);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17486ok(C12598a c12598a) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                interfaceC12384bl.mo17923ok(c12598a);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: a */
    public void mo17518a(int i, List<C12598a> list) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                interfaceC12384bl.mo17973a(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17495ok(int i, int i2, long j) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                interfaceC12384bl.mo17946ok(i, i2, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17496ok(int i, int i2, int i3, long j) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                interfaceC12384bl.mo17948ok(i, i2, i3, j);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17497ok(int i, int i2, int i3, int i4) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                interfaceC12384bl.mo17950ok(i, i2, i3, i4);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public DownloadInfo mo17498ok(int i, int i2) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17951ok(i, i2);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public boolean mo17488ok(DownloadInfo downloadInfo) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17925ok(downloadInfo);
            }
            return false;
        } catch (RemoteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public DownloadInfo mo17493ok(int i, long j, String str, String str2) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17943ok(i, j, str, str2);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public DownloadInfo mo17494ok(int i, long j) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                return interfaceC12384bl.mo17944ok(i, j);
            }
            return null;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12501k
    /* renamed from: ok */
    public void mo17492ok(int i, List<C12598a> list) {
        try {
            InterfaceC12384bl interfaceC12384bl = this.f34909ok;
            if (interfaceC12384bl != null) {
                interfaceC12384bl.mo17940ok(i, list);
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
