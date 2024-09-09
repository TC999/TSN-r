package com.ss.android.socialbase.downloader.a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.a.a;
import com.ss.android.socialbase.downloader.a.bl;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.bl;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.kf.q;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class kf implements ServiceConnection, u {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f49271a;
    private static int bl;

    /* renamed from: s  reason: collision with root package name */
    private static long f49272s;

    /* renamed from: h  reason: collision with root package name */
    private bl.ok.InterfaceC1005ok f49273h;
    @Nullable
    private bl ok;

    /* renamed from: q  reason: collision with root package name */
    private Future<?> f49277q;

    /* renamed from: n  reason: collision with root package name */
    private Handler f49275n = new Handler(Looper.getMainLooper());
    private a kf = null;

    /* renamed from: p  reason: collision with root package name */
    private Runnable f49276p = new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.1
        @Override // java.lang.Runnable
        public void run() {
            if (kf.f49271a || kf.this.f49273h == null) {
                return;
            }
            kf.this.f49273h.ok();
        }
    };

    /* renamed from: k  reason: collision with root package name */
    private CountDownLatch f49274k = new CountDownLatch(1);

    public kf() {
        SqlDownloadCacheService.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), this);
    }

    static /* synthetic */ bl.ok.InterfaceC1005ok ok(kf kfVar) {
        return kfVar.f49273h;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public Map<Long, q> j(int i4) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo k(int i4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.k(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    /* renamed from: ok */
    public ArrayList<q> rh(int i4) {
        return null;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean ok(int i4, Map<Long, q> map) {
        return false;
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        f49271a = true;
        this.f49275n.removeCallbacks(this.f49276p);
        try {
            this.ok = bl.ok.ok(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.f49277q = com.ss.android.socialbase.downloader.downloader.bl.j().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    try {
                        if (kf.this.kf != null && kf.this.ok != null) {
                            kf.this.ok.ok(kf.this.kf);
                        }
                        kf.this.f49274k.countDown();
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.a.kf.2.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                boolean unused = kf.f49271a = false;
                                if (kf.this.h() || kf.this.f49273h == null) {
                                    return;
                                }
                                kf.this.f49275n.postDelayed(kf.this.f49276p, 2000L);
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
        this.ok = null;
        f49271a = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo q(int i4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.q(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void z(int i4) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean h() {
        if (Build.VERSION.SDK_INT < 26 && !f49271a) {
            if (bl > 5) {
                com.ss.android.socialbase.downloader.bl.ok.s("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - f49272s < 15000) {
                com.ss.android.socialbase.downloader.bl.ok.s("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
                return false;
            }
            bl++;
            f49272s = currentTimeMillis;
            this.f49275n.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.3
                @Override // java.lang.Runnable
                public void run() {
                    SqlDownloadCacheService.ok(com.ss.android.socialbase.downloader.downloader.bl.l(), kf.this);
                }
            }, 1000L);
            return true;
        }
        return false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo a(int i4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.a(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> bl(String str) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.bl(str);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean n(int i4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.n(i4);
            }
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo p(int i4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.p(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> s(String str) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.s(str);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean kf(int i4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.kf(i4);
            }
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public void ok(bl.ok.InterfaceC1005ok interfaceC1005ok) {
        this.f49273h = interfaceC1005ok;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.u
    public void ok(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.a>> sparseArray2, final s sVar) {
        com.ss.android.socialbase.downloader.downloader.bl.j().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.a.kf.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z3;
                s sVar2;
                Future future;
                kf.this.ok(new a.ok() { // from class: com.ss.android.socialbase.downloader.a.kf.4.1
                    @Override // com.ss.android.socialbase.downloader.a.a
                    public void ok(Map map, Map map2) {
                        com.ss.android.socialbase.downloader.q.kf.ok(sparseArray, map);
                        com.ss.android.socialbase.downloader.q.kf.ok(sparseArray2, map2);
                        sVar.ok();
                        kf.this.ok((a) null);
                    }
                });
                try {
                    z3 = !kf.this.f49274k.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                    z3 = false;
                }
                if (z3 && (future = kf.this.f49277q) != null) {
                    future.cancel(true);
                }
                kf.this.ok();
                if (!z3 || (sVar2 = sVar) == null) {
                    return;
                }
                sVar2.ok();
            }
        });
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> a(String str) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.a(str);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<com.ss.android.socialbase.downloader.model.a> bl(int i4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.bl(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean n() {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.n();
            }
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public void ok(a aVar) {
        synchronized (this) {
            bl blVar = this.ok;
            if (blVar != null) {
                try {
                    blVar.ok(aVar);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            } else {
                this.kf = aVar;
            }
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void s(int i4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.s(i4);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> a() {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.a();
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void bl() {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.bl();
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo s(int i4, long j4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.s(i4, j4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(com.ss.android.socialbase.downloader.model.a aVar) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.a(aVar);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo bl(int i4, long j4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.bl(i4, j4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void ok() {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok();
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean s() {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.s();
            }
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo h(int i4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.h(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo a(int i4, long j4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.a(i4, j4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public List<DownloadInfo> ok(String str) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.ok(str);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(DownloadInfo downloadInfo) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.a(downloadInfo);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(com.ss.android.socialbase.downloader.model.a aVar) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok(aVar);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void a(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.a(i4, list);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i4, int i5, long j4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok(i4, i5, j4);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i4, int i5, int i6, long j4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok(i4, i5, i6, j4);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i4, int i5, int i6, int i7) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok(i4, i5, i6, i7);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i4, int i5) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.ok(i4, i5);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public boolean ok(DownloadInfo downloadInfo) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.ok(downloadInfo);
            }
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i4, long j4, String str, String str2) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.ok(i4, j4, str, str2);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo ok(int i4, long j4) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                return blVar.ok(i4, j4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public void ok(int i4, List<com.ss.android.socialbase.downloader.model.a> list) {
        try {
            bl blVar = this.ok;
            if (blVar != null) {
                blVar.ok(i4, list);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }
}
