package com.ss.android.socialbase.downloader.gd;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.a;
import com.ss.android.socialbase.downloader.depend.bk;
import com.ss.android.socialbase.downloader.depend.eq;
import com.ss.android.socialbase.downloader.depend.ev;
import com.ss.android.socialbase.downloader.depend.f;
import com.ss.android.socialbase.downloader.depend.fp;
import com.ss.android.socialbase.downloader.depend.fz;
import com.ss.android.socialbase.downloader.depend.gb;
import com.ss.android.socialbase.downloader.depend.gd;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.ia;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.ls;
import com.ss.android.socialbase.downloader.depend.me;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.pr;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.r;
import com.ss.android.socialbase.downloader.depend.s;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.ux;
import com.ss.android.socialbase.downloader.depend.wx;
import com.ss.android.socialbase.downloader.depend.xk;
import com.ss.android.socialbase.downloader.depend.ys;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.c;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class r {

    /* renamed from: c  reason: collision with root package name */
    private static Handler f49656c = new Handler(Looper.getMainLooper());

    public static com.ss.android.socialbase.downloader.model.c c(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new c.AbstractBinderC1013c() { // from class: com.ss.android.socialbase.downloader.gd.r.1
            @Override // com.ss.android.socialbase.downloader.model.c
            public int a() throws RemoteException {
                return DownloadTask.this.getDownloadCompleteHandlers().size();
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public DownloadInfo c() throws RemoteException {
                return DownloadTask.this.getDownloadInfo();
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public xk ev() throws RemoteException {
                return r.c(DownloadTask.this.getRetryDelayTimeCalculator());
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public com.ss.android.socialbase.downloader.depend.f f() throws RemoteException {
                return r.c(DownloadTask.this.getDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public fp gd() throws RemoteException {
                return r.c(DownloadTask.this.getDiskSpaceHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public com.ss.android.socialbase.downloader.depend.r k() throws RemoteException {
                return r.c(DownloadTask.this.getFileUriProvider());
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public com.ss.android.socialbase.downloader.depend.p p() throws RemoteException {
                return r.c(DownloadTask.this.getMonitorDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public i r() throws RemoteException {
                return r.c(DownloadTask.this.getForbiddenHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public eq sr() throws RemoteException {
                return r.c(DownloadTask.this.getNotificationClickCallback());
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public com.ss.android.socialbase.downloader.depend.ev ux() throws RemoteException {
                return r.c(DownloadTask.this.getInterceptor());
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public com.ss.android.socialbase.downloader.depend.ux w() throws RemoteException {
                return r.c(DownloadTask.this.getChunkStrategy());
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public gb xv() throws RemoteException {
                return r.c(DownloadTask.this.getNotificationEventListener());
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public int c(int i4) throws RemoteException {
                return DownloadTask.this.getDownloadListenerSize(f.ux(i4));
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public com.ss.android.socialbase.downloader.depend.gd w(int i4) throws RemoteException {
                return r.c(DownloadTask.this.getSingleDownloadListener(f.ux(i4)), i4 != com.ss.android.socialbase.downloader.constants.f.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public a xv(int i4) throws RemoteException {
                return r.c(DownloadTask.this.getDownloadCompleteHandlerByIndex(i4));
            }

            @Override // com.ss.android.socialbase.downloader.model.c
            public com.ss.android.socialbase.downloader.depend.gd c(int i4, int i5) throws RemoteException {
                return r.c(DownloadTask.this.getDownloadListenerByIndex(f.ux(i4), i5), i4 != com.ss.android.socialbase.downloader.constants.f.SUB.ordinal());
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.gd c(final IDownloadListener iDownloadListener, final boolean z3) {
        if (iDownloadListener == null) {
            return null;
        }
        return new gd.c() { // from class: com.ss.android.socialbase.downloader.gd.r.12
            @Override // com.ss.android.socialbase.downloader.depend.gd
            public int c() throws RemoteException {
                return IDownloadListener.this.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void ev(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void f(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onCanceled(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void gd(final DownloadInfo downloadInfo) throws RemoteException {
                IDownloadListener iDownloadListener2 = IDownloadListener.this;
                if (iDownloadListener2 instanceof fz) {
                    if (z3) {
                        r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((fz) IDownloadListener.this).c(downloadInfo);
                            }
                        });
                    } else {
                        ((fz) iDownloadListener2).c(downloadInfo);
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void r(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void sr(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPause(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPause(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void ux(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onSuccessed(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void w(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void xv(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onProgress(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onProgress(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void c(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPrepare(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void w(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z3) {
                    r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void xv(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z3) {
                    r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.gd
            public void c(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z3) {
                    r.f49656c.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.gd.r.12.9
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFailed(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onFailed(downloadInfo, baseException);
                }
            }
        };
    }

    public static gb c(final n nVar) {
        if (nVar == null) {
            return null;
        }
        return new gb.c() { // from class: com.ss.android.socialbase.downloader.gd.r.23
            @Override // com.ss.android.socialbase.downloader.depend.gb
            public void c(int i4, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                n.this.c(i4, downloadInfo, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.depend.gb
            public boolean c(boolean z3) throws RemoteException {
                return n.this.c(z3);
            }

            @Override // com.ss.android.socialbase.downloader.depend.gb
            public String c() throws RemoteException {
                return n.this.c();
            }
        };
    }

    public static eq c(final me meVar) {
        if (meVar == null) {
            return null;
        }
        return new eq.c() { // from class: com.ss.android.socialbase.downloader.gd.r.26
            @Override // com.ss.android.socialbase.downloader.depend.eq
            public boolean c(DownloadInfo downloadInfo) throws RemoteException {
                return me.this.c(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.eq
            public boolean w(DownloadInfo downloadInfo) throws RemoteException {
                return me.this.w(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.eq
            public boolean xv(DownloadInfo downloadInfo) throws RemoteException {
                return me.this.xv(downloadInfo);
            }
        };
    }

    public static xk c(final com.ss.android.socialbase.downloader.downloader.fz fzVar) {
        if (fzVar == null) {
            return null;
        }
        return new xk.c() { // from class: com.ss.android.socialbase.downloader.gd.r.27
            @Override // com.ss.android.socialbase.downloader.depend.xk
            public long c(int i4, int i5) throws RemoteException {
                return com.ss.android.socialbase.downloader.downloader.fz.this.c(i4, i5);
            }
        };
    }

    public static i c(final j jVar) {
        if (jVar == null) {
            return null;
        }
        return new i.c() { // from class: com.ss.android.socialbase.downloader.gd.r.28
            public boolean c(u uVar) throws RemoteException {
                return j.this.c(r.c(uVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.r c(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new r.c() { // from class: com.ss.android.socialbase.downloader.gd.r.29
            public Uri c(String str, String str2) throws RemoteException {
                return IDownloadFileUriProvider.this.getUriForFile(str, str2);
            }
        };
    }

    public static q c(final u uVar) {
        if (uVar == null) {
            return null;
        }
        return new q() { // from class: com.ss.android.socialbase.downloader.gd.r.30
            public void c(List<String> list) {
                try {
                    u.this.c(list);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            public boolean c() {
                try {
                    return u.this.c();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static fp c(final s sVar) {
        if (sVar == null) {
            return null;
        }
        return new fp.c() { // from class: com.ss.android.socialbase.downloader.gd.r.31
            @Override // com.ss.android.socialbase.downloader.depend.fp
            public boolean c(long j4, long j5, ys ysVar) throws RemoteException {
                return s.this.c(j4, j5, r.c(ysVar));
            }
        };
    }

    public static ia c(final ys ysVar) {
        if (ysVar == null) {
            return null;
        }
        return new ia() { // from class: com.ss.android.socialbase.downloader.gd.r.2
            @Override // com.ss.android.socialbase.downloader.depend.ia
            public void c() {
                try {
                    ys.this.c();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.f c(final t tVar) {
        if (tVar == null) {
            return null;
        }
        return new f.c() { // from class: com.ss.android.socialbase.downloader.gd.r.3
            @Override // com.ss.android.socialbase.downloader.depend.f
            public void c(DownloadInfo downloadInfo, BaseException baseException, int i4) throws RemoteException {
                t.this.c(downloadInfo, baseException, i4);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.p c(final ls lsVar) {
        if (lsVar == null) {
            return null;
        }
        return new p.c() { // from class: com.ss.android.socialbase.downloader.gd.r.4
            public void c(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    ls.this.c(new JSONObject(str));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }

            public int[] w() throws RemoteException {
                ls lsVar2 = ls.this;
                if (lsVar2 instanceof com.ss.android.socialbase.downloader.depend.xv) {
                    return ((com.ss.android.socialbase.downloader.depend.xv) lsVar2).c();
                }
                return null;
            }

            public String c() throws RemoteException {
                return ls.this.w();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.ux c(final com.ss.android.socialbase.downloader.downloader.ev evVar) {
        if (evVar == null) {
            return null;
        }
        return new ux.c() { // from class: com.ss.android.socialbase.downloader.gd.r.5
            @Override // com.ss.android.socialbase.downloader.depend.ux
            public int c(long j4) throws RemoteException {
                return com.ss.android.socialbase.downloader.downloader.ev.this.c(j4);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.ev c(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new ev.c() { // from class: com.ss.android.socialbase.downloader.gd.r.6
            @Override // com.ss.android.socialbase.downloader.depend.ev
            public boolean c() throws RemoteException {
                return IDownloadInterceptor.this.intercepte();
            }
        };
    }

    public static DownloadTask c(com.ss.android.socialbase.downloader.model.c cVar) {
        if (cVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(cVar.c());
            downloadTask.chunkStategy(c(cVar.w())).notificationEventListener(c(cVar.xv())).interceptor(c(cVar.ux())).depend(c(cVar.f())).monitorDepend(c(cVar.p())).forbiddenHandler(c(cVar.r())).diskSpaceHandler(c(cVar.gd())).fileUriProvider(c(cVar.k())).notificationClickCallback(c(cVar.sr())).retryDelayTimeCalculator(c(cVar.ev()));
            com.ss.android.socialbase.downloader.constants.f fVar = com.ss.android.socialbase.downloader.constants.f.MAIN;
            com.ss.android.socialbase.downloader.depend.gd w3 = cVar.w(fVar.ordinal());
            if (w3 != null) {
                downloadTask.mainThreadListenerWithHashCode(w3.hashCode(), c(w3));
            }
            com.ss.android.socialbase.downloader.constants.f fVar2 = com.ss.android.socialbase.downloader.constants.f.SUB;
            com.ss.android.socialbase.downloader.depend.gd w4 = cVar.w(fVar2.ordinal());
            if (w4 != null) {
                downloadTask.subThreadListenerWithHashCode(w4.hashCode(), c(w4));
            }
            com.ss.android.socialbase.downloader.constants.f fVar3 = com.ss.android.socialbase.downloader.constants.f.NOTIFICATION;
            com.ss.android.socialbase.downloader.depend.gd w5 = cVar.w(fVar3.ordinal());
            if (w5 != null) {
                downloadTask.notificationListenerWithHashCode(w5.hashCode(), c(w5));
            }
            c(downloadTask, cVar, fVar);
            c(downloadTask, cVar, fVar2);
            c(downloadTask, cVar, fVar3);
            c(downloadTask, cVar);
            return downloadTask;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static void c(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.c cVar, com.ss.android.socialbase.downloader.constants.f fVar) throws RemoteException {
        SparseArray sparseArray = new SparseArray();
        for (int i4 = 0; i4 < cVar.c(fVar.ordinal()); i4++) {
            com.ss.android.socialbase.downloader.depend.gd c4 = cVar.c(fVar.ordinal(), i4);
            if (c4 != null) {
                sparseArray.put(c4.c(), c(c4));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, fVar);
    }

    private static void c(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.c cVar) throws RemoteException {
        for (int i4 = 0; i4 < cVar.a(); i4++) {
            a xv = cVar.xv(i4);
            if (xv != null) {
                downloadTask.addDownloadCompleteHandler(c(xv));
            }
        }
    }

    public static n c(final gb gbVar) {
        if (gbVar == null) {
            return null;
        }
        return new n() { // from class: com.ss.android.socialbase.downloader.gd.r.7
            public void c(int i4, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    gb.this.c(i4, downloadInfo, str, str2);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            public boolean c(boolean z3) {
                try {
                    return gb.this.c(z3);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }

            public String c() {
                try {
                    return gb.this.c();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static bk c(final a aVar) {
        if (aVar == null) {
            return null;
        }
        return new bk() { // from class: com.ss.android.socialbase.downloader.gd.r.8
            @Override // com.ss.android.socialbase.downloader.depend.bk
            public void c(DownloadInfo downloadInfo) throws BaseException {
                try {
                    a.this.c(downloadInfo);
                } catch (RemoteException e4) {
                    throw new BaseException(1008, e4);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.bk
            public boolean w(DownloadInfo downloadInfo) {
                try {
                    return a.this.w(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static a c(final bk bkVar) {
        if (bkVar == null) {
            return null;
        }
        return new a.c() { // from class: com.ss.android.socialbase.downloader.gd.r.9
            public void c(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    bk.this.c(downloadInfo);
                } catch (BaseException e4) {
                    throw new IllegalArgumentException(e4);
                }
            }

            public boolean w(DownloadInfo downloadInfo) throws RemoteException {
                return bk.this.w(downloadInfo);
            }
        };
    }

    public static me c(final eq eqVar) {
        if (eqVar == null) {
            return null;
        }
        return new me() { // from class: com.ss.android.socialbase.downloader.gd.r.10
            @Override // com.ss.android.socialbase.downloader.depend.me
            public boolean c(DownloadInfo downloadInfo) {
                try {
                    return eq.this.c(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.me
            public boolean w(DownloadInfo downloadInfo) {
                try {
                    return eq.this.w(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.me
            public boolean xv(DownloadInfo downloadInfo) {
                try {
                    return eq.this.xv(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.ev c(final com.ss.android.socialbase.downloader.depend.ux uxVar) {
        if (uxVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.ev() { // from class: com.ss.android.socialbase.downloader.gd.r.11
            @Override // com.ss.android.socialbase.downloader.downloader.ev
            public int c(long j4) {
                try {
                    return com.ss.android.socialbase.downloader.depend.ux.this.c(j4);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return 0;
                }
            }
        };
    }

    public static t c(final com.ss.android.socialbase.downloader.depend.f fVar) {
        if (fVar == null) {
            return null;
        }
        return new t() { // from class: com.ss.android.socialbase.downloader.gd.r.13
            public void c(DownloadInfo downloadInfo, BaseException baseException, int i4) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    com.ss.android.socialbase.downloader.depend.f.this.c(downloadInfo, baseException, i4);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        };
    }

    public static ls c(final com.ss.android.socialbase.downloader.depend.p pVar) {
        if (pVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.xv() { // from class: com.ss.android.socialbase.downloader.gd.r.14
            @Override // com.ss.android.socialbase.downloader.depend.ls
            public void c(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    com.ss.android.socialbase.downloader.depend.p.this.c(jSONObject.toString());
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ls
            public String w() {
                try {
                    return com.ss.android.socialbase.downloader.depend.p.this.c();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.xv
            public int[] c() {
                try {
                    return com.ss.android.socialbase.downloader.depend.p.this.w();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static j c(final i iVar) {
        if (iVar == null) {
            return null;
        }
        return new j() { // from class: com.ss.android.socialbase.downloader.gd.r.15
            public boolean c(q qVar) {
                try {
                    return i.this.c(r.c(qVar));
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static u c(final q qVar) {
        if (qVar == null) {
            return null;
        }
        return new u.c() { // from class: com.ss.android.socialbase.downloader.gd.r.16
            public void c(List<String> list) {
                q.this.c(list);
            }

            public boolean c() {
                return q.this.c();
            }
        };
    }

    public static wx c(final pr prVar) {
        if (prVar == null) {
            return null;
        }
        return new wx.c() { // from class: com.ss.android.socialbase.downloader.gd.r.17
            @Override // com.ss.android.socialbase.downloader.depend.wx
            public void c(int i4, int i5) {
                pr.this.c(i4, i5);
            }
        };
    }

    public static pr c(final wx wxVar) {
        if (wxVar == null) {
            return null;
        }
        return new pr() { // from class: com.ss.android.socialbase.downloader.gd.r.18
            @Override // com.ss.android.socialbase.downloader.depend.pr
            public void c(int i4, int i5) {
                try {
                    wx.this.c(i4, i5);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        };
    }

    public static s c(final fp fpVar) {
        if (fpVar == null) {
            return null;
        }
        return new s() { // from class: com.ss.android.socialbase.downloader.gd.r.19
            public boolean c(long j4, long j5, ia iaVar) {
                try {
                    return fp.this.c(j4, j5, r.c(iaVar));
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static ys c(final ia iaVar) {
        if (iaVar == null) {
            return null;
        }
        return new ys.c() { // from class: com.ss.android.socialbase.downloader.gd.r.20
            @Override // com.ss.android.socialbase.downloader.depend.ys
            public void c() throws RemoteException {
                ia.this.c();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.fz c(final xk xkVar) {
        if (xkVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.fz() { // from class: com.ss.android.socialbase.downloader.gd.r.21
            @Override // com.ss.android.socialbase.downloader.downloader.fz
            public long c(int i4, int i5) {
                try {
                    return xk.this.c(i4, i5);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return 0L;
                }
            }
        };
    }

    public static IDownloadInterceptor c(final com.ss.android.socialbase.downloader.depend.ev evVar) {
        if (evVar == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.ss.android.socialbase.downloader.gd.r.22
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return com.ss.android.socialbase.downloader.depend.ev.this.c();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static IDownloadFileUriProvider c(final com.ss.android.socialbase.downloader.depend.r rVar) {
        if (rVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.ss.android.socialbase.downloader.gd.r.24
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return com.ss.android.socialbase.downloader.depend.r.this.c(str, str2);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static IDownloadListener c(final com.ss.android.socialbase.downloader.depend.gd gdVar) {
        if (gdVar == null) {
            return null;
        }
        return new fz() { // from class: com.ss.android.socialbase.downloader.gd.r.25
            @Override // com.ss.android.socialbase.downloader.depend.fz
            public void c(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.gd(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.f(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.c(downloadInfo, baseException);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.r(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.ev(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.sr(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.c(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.xv(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.w(downloadInfo, baseException);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.xv(downloadInfo, baseException);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.w(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.gd.this.ux(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        };
    }
}
