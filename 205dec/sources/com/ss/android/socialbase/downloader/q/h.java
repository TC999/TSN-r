package com.ss.android.socialbase.downloader.q;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.ss.android.socialbase.downloader.depend.IDownloadListener;
import com.ss.android.socialbase.downloader.depend.e;
import com.ss.android.socialbase.downloader.depend.em;
import com.ss.android.socialbase.downloader.depend.ep;
import com.ss.android.socialbase.downloader.depend.g;
import com.ss.android.socialbase.downloader.depend.h;
import com.ss.android.socialbase.downloader.depend.i;
import com.ss.android.socialbase.downloader.depend.io;
import com.ss.android.socialbase.downloader.depend.j;
import com.ss.android.socialbase.downloader.depend.k;
import com.ss.android.socialbase.downloader.depend.kf;
import com.ss.android.socialbase.downloader.depend.m;
import com.ss.android.socialbase.downloader.depend.n;
import com.ss.android.socialbase.downloader.depend.o;
import com.ss.android.socialbase.downloader.depend.p;
import com.ss.android.socialbase.downloader.depend.q;
import com.ss.android.socialbase.downloader.depend.rh;
import com.ss.android.socialbase.downloader.depend.sg;
import com.ss.android.socialbase.downloader.depend.t;
import com.ss.android.socialbase.downloader.depend.td;
import com.ss.android.socialbase.downloader.depend.u;
import com.ss.android.socialbase.downloader.depend.ul;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.x;
import com.ss.android.socialbase.downloader.depend.y;
import com.ss.android.socialbase.downloader.depend.z;
import com.ss.android.socialbase.downloader.depend.zz;
import com.ss.android.socialbase.downloader.exception.BaseException;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.model.ok;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class h {
    private static Handler ok = new Handler(Looper.getMainLooper());

    public static com.ss.android.socialbase.downloader.model.ok ok(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new ok.AbstractBinderC1015ok() { // from class: com.ss.android.socialbase.downloader.q.h.1
            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.n a() throws RemoteException {
                return h.ok(DownloadTask.this.getChunkStrategy());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public m bl() throws RemoteException {
                return h.ok(DownloadTask.this.getNotificationEventListener());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public io h() throws RemoteException {
                return h.ok(DownloadTask.this.getForbiddenHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public int j() throws RemoteException {
                return DownloadTask.this.getDownloadCompleteHandlers().size();
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.k k() throws RemoteException {
                return h.ok(DownloadTask.this.getMonitorDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.kf kf() throws RemoteException {
                return h.ok(DownloadTask.this.getDepend());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.p n() throws RemoteException {
                return h.ok(DownloadTask.this.getInterceptor());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public DownloadInfo ok() throws RemoteException {
                return DownloadTask.this.getDownloadInfo();
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public e p() throws RemoteException {
                return h.ok(DownloadTask.this.getRetryDelayTimeCalculator());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public i q() throws RemoteException {
                return h.ok(DownloadTask.this.getDiskSpaceHandler());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.h r() throws RemoteException {
                return h.ok(DownloadTask.this.getFileUriProvider());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public g s() throws RemoteException {
                return h.ok(DownloadTask.this.getNotificationClickCallback());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.q a(int i4) throws RemoteException {
                return h.ok(DownloadTask.this.getSingleDownloadListener(kf.n(i4)), i4 != com.ss.android.socialbase.downloader.constants.kf.SUB.ordinal());
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public j bl(int i4) throws RemoteException {
                return h.ok(DownloadTask.this.getDownloadCompleteHandlerByIndex(i4));
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public int ok(int i4) throws RemoteException {
                return DownloadTask.this.getDownloadListenerSize(kf.n(i4));
            }

            @Override // com.ss.android.socialbase.downloader.model.ok
            public com.ss.android.socialbase.downloader.depend.q ok(int i4, int i5) throws RemoteException {
                return h.ok(DownloadTask.this.getDownloadListenerByIndex(kf.n(i4), i5), i4 != com.ss.android.socialbase.downloader.constants.kf.SUB.ordinal());
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.q ok(final IDownloadListener iDownloadListener, final boolean z3) {
        if (iDownloadListener == null) {
            return null;
        }
        return new q.ok() { // from class: com.ss.android.socialbase.downloader.q.h.12
            @Override // com.ss.android.socialbase.downloader.depend.q
            public void a(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void bl(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onProgress(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onProgress(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void h(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstStart(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void kf(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onCanceled(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void n(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onSuccessed(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public int ok() throws RemoteException {
                return IDownloadListener.this.hashCode();
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void p(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void q(final DownloadInfo downloadInfo) throws RemoteException {
                IDownloadListener iDownloadListener2 = IDownloadListener.this;
                if (iDownloadListener2 instanceof zz) {
                    if (z3) {
                        h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((zz) IDownloadListener.this).ok(downloadInfo);
                            }
                        });
                    } else {
                        ((zz) iDownloadListener2).ok(downloadInfo);
                    }
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void s(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPause(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPause(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void ok(final DownloadInfo downloadInfo) throws RemoteException {
                if (z3) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPrepare(downloadInfo);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void a(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z3) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void bl(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z3) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.q
            public void ok(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z3) {
                    h.ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.9
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

    public static m ok(final ep epVar) {
        if (epVar == null) {
            return null;
        }
        return new m.ok() { // from class: com.ss.android.socialbase.downloader.q.h.23
            @Override // com.ss.android.socialbase.downloader.depend.m
            public void ok(int i4, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                ep.this.ok(i4, downloadInfo, str, str2);
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public boolean ok(boolean z3) throws RemoteException {
                return ep.this.ok(z3);
            }

            @Override // com.ss.android.socialbase.downloader.depend.m
            public String ok() throws RemoteException {
                return ep.this.ok();
            }
        };
    }

    public static g ok(final v vVar) {
        if (vVar == null) {
            return null;
        }
        return new g.ok() { // from class: com.ss.android.socialbase.downloader.q.h.26
            @Override // com.ss.android.socialbase.downloader.depend.g
            public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                return v.this.a(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public boolean bl(DownloadInfo downloadInfo) throws RemoteException {
                return v.this.bl(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.g
            public boolean ok(DownloadInfo downloadInfo) throws RemoteException {
                return v.this.ok(downloadInfo);
            }
        };
    }

    public static e ok(final com.ss.android.socialbase.downloader.downloader.zz zzVar) {
        if (zzVar == null) {
            return null;
        }
        return new e.ok() { // from class: com.ss.android.socialbase.downloader.q.h.27
            @Override // com.ss.android.socialbase.downloader.depend.e
            public long ok(int i4, int i5) throws RemoteException {
                return com.ss.android.socialbase.downloader.downloader.zz.this.ok(i4, i5);
            }
        };
    }

    public static io ok(final o oVar) {
        if (oVar == null) {
            return null;
        }
        return new io.ok() { // from class: com.ss.android.socialbase.downloader.q.h.28
            @Override // com.ss.android.socialbase.downloader.depend.io
            public boolean ok(u uVar) throws RemoteException {
                return o.this.ok(h.ok(uVar));
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.h ok(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new h.ok() { // from class: com.ss.android.socialbase.downloader.q.h.29
            @Override // com.ss.android.socialbase.downloader.depend.h
            public Uri ok(String str, String str2) throws RemoteException {
                return IDownloadFileUriProvider.this.getUriForFile(str, str2);
            }
        };
    }

    public static ul ok(final u uVar) {
        if (uVar == null) {
            return null;
        }
        return new ul() { // from class: com.ss.android.socialbase.downloader.q.h.30
            @Override // com.ss.android.socialbase.downloader.depend.ul
            public void ok(List<String> list) {
                try {
                    u.this.ok(list);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ul
            public boolean ok() {
                try {
                    return u.this.ok();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static i ok(final td tdVar) {
        if (tdVar == null) {
            return null;
        }
        return new i.ok() { // from class: com.ss.android.socialbase.downloader.q.h.31
            @Override // com.ss.android.socialbase.downloader.depend.i
            public boolean ok(long j4, long j5, t tVar) throws RemoteException {
                return td.this.ok(j4, j5, h.ok(tVar));
            }
        };
    }

    public static x ok(final t tVar) {
        if (tVar == null) {
            return null;
        }
        return new x() { // from class: com.ss.android.socialbase.downloader.q.h.2
            @Override // com.ss.android.socialbase.downloader.depend.x
            public void ok() {
                try {
                    t.this.ok();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.kf ok(final rh rhVar) {
        if (rhVar == null) {
            return null;
        }
        return new kf.ok() { // from class: com.ss.android.socialbase.downloader.q.h.3
            @Override // com.ss.android.socialbase.downloader.depend.kf
            public void ok(DownloadInfo downloadInfo, BaseException baseException, int i4) throws RemoteException {
                rh.this.ok(downloadInfo, baseException, i4);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.k ok(final y yVar) {
        if (yVar == null) {
            return null;
        }
        return new k.ok() { // from class: com.ss.android.socialbase.downloader.q.h.4
            @Override // com.ss.android.socialbase.downloader.depend.k
            public int[] a() throws RemoteException {
                y yVar2 = y.this;
                if (yVar2 instanceof com.ss.android.socialbase.downloader.depend.bl) {
                    return ((com.ss.android.socialbase.downloader.depend.bl) yVar2).ok();
                }
                return null;
            }

            @Override // com.ss.android.socialbase.downloader.depend.k
            public void ok(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    y.this.ok(new JSONObject(str));
                } catch (JSONException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.k
            public String ok() throws RemoteException {
                return y.this.a();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.n ok(final com.ss.android.socialbase.downloader.downloader.p pVar) {
        if (pVar == null) {
            return null;
        }
        return new n.ok() { // from class: com.ss.android.socialbase.downloader.q.h.5
            @Override // com.ss.android.socialbase.downloader.depend.n
            public int ok(long j4) throws RemoteException {
                return com.ss.android.socialbase.downloader.downloader.p.this.ok(j4);
            }
        };
    }

    public static com.ss.android.socialbase.downloader.depend.p ok(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new p.ok() { // from class: com.ss.android.socialbase.downloader.q.h.6
            @Override // com.ss.android.socialbase.downloader.depend.p
            public boolean ok() throws RemoteException {
                return IDownloadInterceptor.this.intercepte();
            }
        };
    }

    public static DownloadTask ok(com.ss.android.socialbase.downloader.model.ok okVar) {
        if (okVar == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(okVar.ok());
            downloadTask.chunkStategy(ok(okVar.a())).notificationEventListener(ok(okVar.bl())).interceptor(ok(okVar.n())).depend(ok(okVar.kf())).monitorDepend(ok(okVar.k())).forbiddenHandler(ok(okVar.h())).diskSpaceHandler(ok(okVar.q())).fileUriProvider(ok(okVar.r())).notificationClickCallback(ok(okVar.s())).retryDelayTimeCalculator(ok(okVar.p()));
            com.ss.android.socialbase.downloader.constants.kf kfVar = com.ss.android.socialbase.downloader.constants.kf.MAIN;
            com.ss.android.socialbase.downloader.depend.q a4 = okVar.a(kfVar.ordinal());
            if (a4 != null) {
                downloadTask.mainThreadListenerWithHashCode(a4.hashCode(), ok(a4));
            }
            com.ss.android.socialbase.downloader.constants.kf kfVar2 = com.ss.android.socialbase.downloader.constants.kf.SUB;
            com.ss.android.socialbase.downloader.depend.q a5 = okVar.a(kfVar2.ordinal());
            if (a5 != null) {
                downloadTask.subThreadListenerWithHashCode(a5.hashCode(), ok(a5));
            }
            com.ss.android.socialbase.downloader.constants.kf kfVar3 = com.ss.android.socialbase.downloader.constants.kf.NOTIFICATION;
            com.ss.android.socialbase.downloader.depend.q a6 = okVar.a(kfVar3.ordinal());
            if (a6 != null) {
                downloadTask.notificationListenerWithHashCode(a6.hashCode(), ok(a6));
            }
            ok(downloadTask, okVar, kfVar);
            ok(downloadTask, okVar, kfVar2);
            ok(downloadTask, okVar, kfVar3);
            ok(downloadTask, okVar);
            return downloadTask;
        } catch (RemoteException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    private static void ok(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.ok okVar, com.ss.android.socialbase.downloader.constants.kf kfVar) throws RemoteException {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i4 = 0; i4 < okVar.ok(kfVar.ordinal()); i4++) {
            com.ss.android.socialbase.downloader.depend.q ok2 = okVar.ok(kfVar.ordinal(), i4);
            if (ok2 != null) {
                sparseArray.put(ok2.ok(), ok(ok2));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, kfVar);
    }

    private static void ok(DownloadTask downloadTask, com.ss.android.socialbase.downloader.model.ok okVar) throws RemoteException {
        for (int i4 = 0; i4 < okVar.j(); i4++) {
            j bl = okVar.bl(i4);
            if (bl != null) {
                downloadTask.addDownloadCompleteHandler(ok(bl));
            }
        }
    }

    public static ep ok(final m mVar) {
        if (mVar == null) {
            return null;
        }
        return new ep() { // from class: com.ss.android.socialbase.downloader.q.h.7
            @Override // com.ss.android.socialbase.downloader.depend.ep
            public void ok(int i4, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    m.this.ok(i4, downloadInfo, str, str2);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ep
            public boolean ok(boolean z3) {
                try {
                    return m.this.ok(z3);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.ep
            public String ok() {
                try {
                    return m.this.ok();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static z ok(final j jVar) {
        if (jVar == null) {
            return null;
        }
        return new z() { // from class: com.ss.android.socialbase.downloader.q.h.8
            @Override // com.ss.android.socialbase.downloader.depend.z
            public boolean a(DownloadInfo downloadInfo) {
                try {
                    return j.this.a(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.z
            public void ok(DownloadInfo downloadInfo) throws BaseException {
                try {
                    j.this.ok(downloadInfo);
                } catch (RemoteException e4) {
                    throw new BaseException(1008, e4);
                }
            }
        };
    }

    public static j ok(final z zVar) {
        if (zVar == null) {
            return null;
        }
        return new j.ok() { // from class: com.ss.android.socialbase.downloader.q.h.9
            @Override // com.ss.android.socialbase.downloader.depend.j
            public boolean a(DownloadInfo downloadInfo) throws RemoteException {
                return z.this.a(downloadInfo);
            }

            @Override // com.ss.android.socialbase.downloader.depend.j
            public void ok(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    z.this.ok(downloadInfo);
                } catch (BaseException e4) {
                    throw new IllegalArgumentException(e4);
                }
            }
        };
    }

    public static v ok(final g gVar) {
        if (gVar == null) {
            return null;
        }
        return new v() { // from class: com.ss.android.socialbase.downloader.q.h.10
            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean a(DownloadInfo downloadInfo) {
                try {
                    return g.this.a(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean bl(DownloadInfo downloadInfo) {
                try {
                    return g.this.bl(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.v
            public boolean ok(DownloadInfo downloadInfo) {
                try {
                    return g.this.ok(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.p ok(final com.ss.android.socialbase.downloader.depend.n nVar) {
        if (nVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.p() { // from class: com.ss.android.socialbase.downloader.q.h.11
            @Override // com.ss.android.socialbase.downloader.downloader.p
            public int ok(long j4) {
                try {
                    return com.ss.android.socialbase.downloader.depend.n.this.ok(j4);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return 0;
                }
            }
        };
    }

    public static rh ok(final com.ss.android.socialbase.downloader.depend.kf kfVar) {
        if (kfVar == null) {
            return null;
        }
        return new rh() { // from class: com.ss.android.socialbase.downloader.q.h.13
            @Override // com.ss.android.socialbase.downloader.depend.rh
            public void ok(DownloadInfo downloadInfo, BaseException baseException, int i4) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    com.ss.android.socialbase.downloader.depend.kf.this.ok(downloadInfo, baseException, i4);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        };
    }

    public static y ok(final com.ss.android.socialbase.downloader.depend.k kVar) {
        if (kVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.depend.bl() { // from class: com.ss.android.socialbase.downloader.q.h.14
            @Override // com.ss.android.socialbase.downloader.depend.y
            public String a() {
                try {
                    return com.ss.android.socialbase.downloader.depend.k.this.ok();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return "";
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.y
            public void ok(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    com.ss.android.socialbase.downloader.depend.k.this.ok(jSONObject.toString());
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.bl
            public int[] ok() {
                try {
                    return com.ss.android.socialbase.downloader.depend.k.this.a();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static o ok(final io ioVar) {
        if (ioVar == null) {
            return null;
        }
        return new o() { // from class: com.ss.android.socialbase.downloader.q.h.15
            @Override // com.ss.android.socialbase.downloader.depend.o
            public boolean ok(ul ulVar) {
                try {
                    return io.this.ok(h.ok(ulVar));
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static u ok(final ul ulVar) {
        if (ulVar == null) {
            return null;
        }
        return new u.ok() { // from class: com.ss.android.socialbase.downloader.q.h.16
            @Override // com.ss.android.socialbase.downloader.depend.u
            public void ok(List<String> list) {
                ul.this.ok(list);
            }

            @Override // com.ss.android.socialbase.downloader.depend.u
            public boolean ok() {
                return ul.this.ok();
            }
        };
    }

    public static em ok(final sg sgVar) {
        if (sgVar == null) {
            return null;
        }
        return new em.ok() { // from class: com.ss.android.socialbase.downloader.q.h.17
            @Override // com.ss.android.socialbase.downloader.depend.em
            public void ok(int i4, int i5) {
                sg.this.ok(i4, i5);
            }
        };
    }

    public static sg ok(final em emVar) {
        if (emVar == null) {
            return null;
        }
        return new sg() { // from class: com.ss.android.socialbase.downloader.q.h.18
            @Override // com.ss.android.socialbase.downloader.depend.sg
            public void ok(int i4, int i5) {
                try {
                    em.this.ok(i4, i5);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        };
    }

    public static td ok(final i iVar) {
        if (iVar == null) {
            return null;
        }
        return new td() { // from class: com.ss.android.socialbase.downloader.q.h.19
            @Override // com.ss.android.socialbase.downloader.depend.td
            public boolean ok(long j4, long j5, x xVar) {
                try {
                    return i.this.ok(j4, j5, h.ok(xVar));
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static t ok(final x xVar) {
        if (xVar == null) {
            return null;
        }
        return new t.ok() { // from class: com.ss.android.socialbase.downloader.q.h.20
            @Override // com.ss.android.socialbase.downloader.depend.t
            public void ok() throws RemoteException {
                x.this.ok();
            }
        };
    }

    public static com.ss.android.socialbase.downloader.downloader.zz ok(final e eVar) {
        if (eVar == null) {
            return null;
        }
        return new com.ss.android.socialbase.downloader.downloader.zz() { // from class: com.ss.android.socialbase.downloader.q.h.21
            @Override // com.ss.android.socialbase.downloader.downloader.zz
            public long ok(int i4, int i5) {
                try {
                    return e.this.ok(i4, i5);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return 0L;
                }
            }
        };
    }

    public static IDownloadInterceptor ok(final com.ss.android.socialbase.downloader.depend.p pVar) {
        if (pVar == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.ss.android.socialbase.downloader.q.h.22
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return com.ss.android.socialbase.downloader.depend.p.this.ok();
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return false;
                }
            }
        };
    }

    public static IDownloadFileUriProvider ok(final com.ss.android.socialbase.downloader.depend.h hVar) {
        if (hVar == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.ss.android.socialbase.downloader.q.h.24
            @Override // com.ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return com.ss.android.socialbase.downloader.depend.h.this.ok(str, str2);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                    return null;
                }
            }
        };
    }

    public static IDownloadListener ok(final com.ss.android.socialbase.downloader.depend.q qVar) {
        if (qVar == null) {
            return null;
        }
        return new zz() { // from class: com.ss.android.socialbase.downloader.q.h.25
            @Override // com.ss.android.socialbase.downloader.depend.zz
            public void ok(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.q(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.kf(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.ok(downloadInfo, baseException);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.h(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.p(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.s(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.ok(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.bl(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.a(downloadInfo, baseException);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.bl(downloadInfo, baseException);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.a(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }

            @Override // com.ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    com.ss.android.socialbase.downloader.depend.q.this.n(downloadInfo);
                } catch (RemoteException e4) {
                    e4.printStackTrace();
                }
            }
        };
    }
}
