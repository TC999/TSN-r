package com.ss.android.socialbase.downloader.w;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import com.ss.android.socialbase.downloader.downloader.SqlDownloadCacheService;
import com.ss.android.socialbase.downloader.downloader.u;
import com.ss.android.socialbase.downloader.downloader.xv;
import com.ss.android.socialbase.downloader.f.gd;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.w.w;
import com.ss.android.socialbase.downloader.w.xv;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class f implements ServiceConnection, u {
    private static long sr;

    /* renamed from: w  reason: collision with root package name */
    private static boolean f50186w;
    private static int xv;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private xv f50187c;
    private Future<?> gd;

    /* renamed from: r  reason: collision with root package name */
    private xv.c.InterfaceC1008c f50190r;
    private Handler ux = new Handler(Looper.getMainLooper());

    /* renamed from: f  reason: collision with root package name */
    private w f50188f = null;
    private Runnable ev = new Runnable() { // from class: com.ss.android.socialbase.downloader.w.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.f50186w || f.this.f50190r == null) {
                return;
            }
            f.this.f50190r.c();
        }
    };

    /* renamed from: p  reason: collision with root package name */
    private CountDownLatch f50189p = new CountDownLatch(1);

    public f() {
        SqlDownloadCacheService.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), this);
    }

    static /* synthetic */ xv.c.InterfaceC1008c c(f fVar) {
        return fVar.f50190r;
    }

    public Map<Long, gd> a(int i4) {
        return null;
    }

    public void bk(int i4) {
    }

    /* renamed from: c */
    public ArrayList<gd> t(int i4) {
        return null;
    }

    public boolean c(int i4, Map<Long, gd> map) {
        return false;
    }

    public DownloadInfo gd(int i4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.gd(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    @Override // android.content.ServiceConnection
    public void onServiceConnected(ComponentName componentName, final IBinder iBinder) {
        f50186w = true;
        this.ux.removeCallbacks(this.ev);
        try {
            this.f50187c = xv.c.c(iBinder);
        } catch (Throwable th) {
            th.printStackTrace();
        }
        this.gd = com.ss.android.socialbase.downloader.downloader.xv.a().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.f.2
            @Override // java.lang.Runnable
            public void run() {
                synchronized (this) {
                    try {
                        if (f.this.f50188f != null && f.this.f50187c != null) {
                            f.this.f50187c.c(f.this.f50188f);
                        }
                        f.this.f50189p.countDown();
                        iBinder.linkToDeath(new IBinder.DeathRecipient() { // from class: com.ss.android.socialbase.downloader.w.f.2.1
                            @Override // android.os.IBinder.DeathRecipient
                            public void binderDied() {
                                boolean unused = f.f50186w = false;
                                if (f.this.r() || f.this.f50190r == null) {
                                    return;
                                }
                                f.this.ux.postDelayed(f.this.ev, 2000L);
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
        this.f50187c = null;
        f50186w = false;
    }

    @Override // com.ss.android.socialbase.downloader.downloader.k
    public DownloadInfo p(int i4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.p(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean r() {
        if (Build.VERSION.SDK_INT < 26 && !f50186w) {
            if (xv > 5) {
                com.ss.android.socialbase.downloader.xv.c.sr("SqlDownloadCacheAidlWra", "bindMainProcess: bind too many times!!! ");
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - sr < 15000) {
                com.ss.android.socialbase.downloader.xv.c.sr("SqlDownloadCacheAidlWra", "bindMainProcess: time too short since last bind!!! ");
                return false;
            }
            xv++;
            sr = currentTimeMillis;
            this.ux.postDelayed(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.f.3
                @Override // java.lang.Runnable
                public void run() {
                    SqlDownloadCacheService.c(com.ss.android.socialbase.downloader.downloader.xv.gw(), f.this);
                }
            }, 1000L);
            return true;
        }
        return false;
    }

    public DownloadInfo ev(int i4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.ev(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public List<DownloadInfo> sr(String str) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.sr(str);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public boolean ux(int i4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.ux(i4);
            }
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public DownloadInfo w(int i4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.w(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public List<DownloadInfo> xv(String str) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.xv(str);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void c(xv.c.InterfaceC1008c interfaceC1008c) {
        this.f50190r = interfaceC1008c;
    }

    public boolean f(int i4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.f(i4);
            }
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public void c(final SparseArray<DownloadInfo> sparseArray, final SparseArray<List<com.ss.android.socialbase.downloader.model.w>> sparseArray2, final sr srVar) {
        com.ss.android.socialbase.downloader.downloader.xv.a().submit(new Runnable() { // from class: com.ss.android.socialbase.downloader.w.f.4
            @Override // java.lang.Runnable
            public void run() {
                boolean z3;
                sr srVar2;
                Future future;
                f.this.c(new w.c() { // from class: com.ss.android.socialbase.downloader.w.f.4.1
                    @Override // com.ss.android.socialbase.downloader.w.w
                    public void c(Map map, Map map2) {
                        com.ss.android.socialbase.downloader.gd.f.c(sparseArray, map);
                        com.ss.android.socialbase.downloader.gd.f.c(sparseArray2, map2);
                        srVar.c();
                        f.this.c((w) null);
                    }
                });
                try {
                    z3 = !f.this.f50189p.await(5000L, TimeUnit.MILLISECONDS);
                } catch (Throwable th) {
                    th.printStackTrace();
                    z3 = false;
                }
                if (z3 && (future = f.this.gd) != null) {
                    future.cancel(true);
                }
                f.this.c();
                if (!z3 || (srVar2 = srVar) == null) {
                    return;
                }
                srVar2.c();
            }
        });
    }

    public void c(w wVar) {
        synchronized (this) {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                try {
                    xvVar.c(wVar);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            } else {
                this.f50188f = wVar;
            }
        }
    }

    public void sr(int i4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                xvVar.sr(i4);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public boolean ux() {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.ux();
            }
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public List<DownloadInfo> w(String str) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.w(str);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public List<com.ss.android.socialbase.downloader.model.w> xv(int i4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.xv(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public DownloadInfo sr(int i4, long j4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.sr(i4, j4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public List<DownloadInfo> w() {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.w();
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void xv() {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                xvVar.xv();
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public void c() {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                xvVar.c();
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public boolean sr() {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.sr();
            }
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public void w(com.ss.android.socialbase.downloader.model.w wVar) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                xvVar.w(wVar);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public DownloadInfo xv(int i4, long j4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.xv(i4, j4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public DownloadInfo r(int i4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.r(i4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public List<DownloadInfo> c(String str) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.c(str);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public DownloadInfo w(int i4, long j4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.w(i4, j4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void c(com.ss.android.socialbase.downloader.model.w wVar) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                xvVar.c(wVar);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public void w(DownloadInfo downloadInfo) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                xvVar.w(downloadInfo);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public void c(int i4, int i5, long j4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                xvVar.c(i4, i5, j4);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public void w(int i4, List<com.ss.android.socialbase.downloader.model.w> list) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                xvVar.w(i4, list);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public void c(int i4, int i5, int i6, long j4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                xvVar.c(i4, i5, i6, j4);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public void c(int i4, int i5, int i6, int i7) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                xvVar.c(i4, i5, i6, i7);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }

    public DownloadInfo c(int i4, int i5) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.c(i4, i5);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public boolean c(DownloadInfo downloadInfo) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.c(downloadInfo);
            }
            return false;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return false;
        }
    }

    public DownloadInfo c(int i4, long j4, String str, String str2) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.c(i4, j4, str, str2);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public DownloadInfo c(int i4, long j4) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                return xvVar.c(i4, j4);
            }
            return null;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public void c(int i4, List<com.ss.android.socialbase.downloader.model.w> list) {
        try {
            xv xvVar = this.f50187c;
            if (xvVar != null) {
                xvVar.c(i4, list);
            }
        } catch (RemoteException e4) {
            e4.printStackTrace();
        }
    }
}
