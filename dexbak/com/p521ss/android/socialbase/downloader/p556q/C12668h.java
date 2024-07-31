package com.p521ss.android.socialbase.downloader.p556q;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.SparseArray;
import com.p521ss.android.socialbase.downloader.constants.EnumC12414kf;
import com.p521ss.android.socialbase.downloader.depend.AbstractC12420bl;
import com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider;
import com.p521ss.android.socialbase.downloader.depend.IDownloadInterceptor;
import com.p521ss.android.socialbase.downloader.depend.IDownloadListener;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12421e;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12424em;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12432g;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12435h;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12438i;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12441io;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12444j;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12447k;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12450kf;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12454m;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12457n;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12460o;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12462p;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12469rh;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12471sg;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12472t;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12475td;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12476u;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12479ul;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12482x;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12483y;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12485zz;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12509p;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12523zz;
import com.p521ss.android.socialbase.downloader.exception.BaseException;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.ss.android.socialbase.downloader.q.h */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12668h {

    /* renamed from: ok */
    private static Handler f35732ok = new Handler(Looper.getMainLooper());

    /* renamed from: ok */
    public static InterfaceC12604ok m16700ok(final DownloadTask downloadTask) {
        if (downloadTask == null) {
            return null;
        }
        return new InterfaceC12604ok.AbstractBinderC12605ok() { // from class: com.ss.android.socialbase.downloader.q.h.1
            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: a */
            public InterfaceC12457n mo16696a() throws RemoteException {
                return C12668h.m16702ok(DownloadTask.this.getChunkStrategy());
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: bl */
            public InterfaceC12454m mo16694bl() throws RemoteException {
                return C12668h.m16725ok(DownloadTask.this.getNotificationEventListener());
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: h */
            public InterfaceC12441io mo16692h() throws RemoteException {
                return C12668h.m16715ok(DownloadTask.this.getForbiddenHandler());
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: j */
            public int mo16691j() throws RemoteException {
                return DownloadTask.this.getDownloadCompleteHandlers().size();
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: k */
            public InterfaceC12447k mo16690k() throws RemoteException {
                return C12668h.m16704ok(DownloadTask.this.getMonitorDepend());
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: kf */
            public InterfaceC12450kf mo16689kf() throws RemoteException {
                return C12668h.m16712ok(DownloadTask.this.getDepend());
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: n */
            public InterfaceC12462p mo16688n() throws RemoteException {
                return C12668h.m16729ok(DownloadTask.this.getInterceptor());
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: ok */
            public DownloadInfo mo16687ok() throws RemoteException {
                return DownloadTask.this.getDownloadInfo();
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: p */
            public InterfaceC12421e mo16684p() throws RemoteException {
                return C12668h.m16701ok(DownloadTask.this.getRetryDelayTimeCalculator());
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: q */
            public InterfaceC12438i mo16683q() throws RemoteException {
                return C12668h.m16709ok(DownloadTask.this.getDiskSpaceHandler());
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: r */
            public InterfaceC12435h mo16682r() throws RemoteException {
                return C12668h.m16730ok(DownloadTask.this.getFileUriProvider());
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: s */
            public InterfaceC12432g mo16681s() throws RemoteException {
                return C12668h.m16706ok(DownloadTask.this.getNotificationClickCallback());
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: a */
            public InterfaceC12465q mo16695a(int i) throws RemoteException {
                return C12668h.m16728ok(DownloadTask.this.getSingleDownloadListener(C12713kf.m16581n(i)), i != EnumC12414kf.SUB.ordinal());
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: bl */
            public InterfaceC12444j mo16693bl(int i) throws RemoteException {
                return C12668h.m16703ok(DownloadTask.this.getDownloadCompleteHandlerByIndex(i));
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: ok */
            public int mo16686ok(int i) throws RemoteException {
                return DownloadTask.this.getDownloadListenerSize(C12713kf.m16581n(i));
            }

            @Override // com.p521ss.android.socialbase.downloader.model.InterfaceC12604ok
            /* renamed from: ok */
            public InterfaceC12465q mo16685ok(int i, int i2) throws RemoteException {
                return C12668h.m16728ok(DownloadTask.this.getDownloadListenerByIndex(C12713kf.m16581n(i), i2), i != EnumC12414kf.SUB.ordinal());
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12465q m16728ok(final IDownloadListener iDownloadListener, final boolean z) {
        if (iDownloadListener == null) {
            return null;
        }
        return new InterfaceC12465q.AbstractBinderC12466ok() { // from class: com.ss.android.socialbase.downloader.q.h.12
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: a */
            public void mo16676a(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.5
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onStart(downloadInfo);
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: bl */
            public void mo16674bl(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.6
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onProgress(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onProgress(downloadInfo);
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: h */
            public void mo16672h(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.11
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstStart(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstStart(downloadInfo);
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: kf */
            public void mo16671kf(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.10
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onCanceled(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onCanceled(downloadInfo);
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: n */
            public void mo16670n(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.8
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onSuccessed(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onSuccessed(downloadInfo);
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: ok */
            public int mo16669ok() throws RemoteException {
                return IDownloadListener.this.hashCode();
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: p */
            public void mo16666p(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.12
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onFirstSuccess(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onFirstSuccess(downloadInfo);
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: q */
            public void mo16665q(final DownloadInfo downloadInfo) throws RemoteException {
                IDownloadListener iDownloadListener2 = IDownloadListener.this;
                if (iDownloadListener2 instanceof InterfaceC12485zz) {
                    if (z) {
                        C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.4
                            @Override // java.lang.Runnable
                            public void run() {
                                ((InterfaceC12485zz) IDownloadListener.this).mo16647ok(downloadInfo);
                            }
                        });
                    } else {
                        ((InterfaceC12485zz) iDownloadListener2).mo16647ok(downloadInfo);
                    }
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: s */
            public void mo16664s(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.7
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPause(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPause(downloadInfo);
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: ok */
            public void mo16668ok(final DownloadInfo downloadInfo) throws RemoteException {
                if (z) {
                    C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.1
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onPrepare(downloadInfo);
                        }
                    });
                } else {
                    IDownloadListener.this.onPrepare(downloadInfo);
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: a */
            public void mo16675a(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.2
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetry(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetry(downloadInfo, baseException);
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: bl */
            public void mo16673bl(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.3
                        @Override // java.lang.Runnable
                        public void run() {
                            IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                        }
                    });
                } else {
                    IDownloadListener.this.onRetryDelay(downloadInfo, baseException);
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12465q
            /* renamed from: ok */
            public void mo16667ok(final DownloadInfo downloadInfo, final BaseException baseException) throws RemoteException {
                if (z) {
                    C12668h.f35732ok.post(new Runnable() { // from class: com.ss.android.socialbase.downloader.q.h.12.9
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

    /* renamed from: ok */
    public static InterfaceC12454m m16725ok(final InterfaceC12427ep interfaceC12427ep) {
        if (interfaceC12427ep == null) {
            return null;
        }
        return new InterfaceC12454m.AbstractBinderC12455ok() { // from class: com.ss.android.socialbase.downloader.q.h.23
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12454m
            /* renamed from: ok */
            public void mo16649ok(int i, DownloadInfo downloadInfo, String str, String str2) throws RemoteException {
                InterfaceC12427ep.this.mo16630ok(i, downloadInfo, str, str2);
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12454m
            /* renamed from: ok */
            public boolean mo16648ok(boolean z) throws RemoteException {
                return InterfaceC12427ep.this.mo16629ok(z);
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12454m
            /* renamed from: ok */
            public String mo16650ok() throws RemoteException {
                return InterfaceC12427ep.this.mo16631ok();
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12432g m16706ok(final InterfaceC12480v interfaceC12480v) {
        if (interfaceC12480v == null) {
            return null;
        }
        return new InterfaceC12432g.AbstractBinderC12433ok() { // from class: com.ss.android.socialbase.downloader.q.h.26
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12432g
            /* renamed from: a */
            public boolean mo16646a(DownloadInfo downloadInfo) throws RemoteException {
                return InterfaceC12480v.this.mo16680a(downloadInfo);
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12432g
            /* renamed from: bl */
            public boolean mo16645bl(DownloadInfo downloadInfo) throws RemoteException {
                return InterfaceC12480v.this.mo16679bl(downloadInfo);
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12432g
            /* renamed from: ok */
            public boolean mo16644ok(DownloadInfo downloadInfo) throws RemoteException {
                return InterfaceC12480v.this.mo16678ok(downloadInfo);
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12421e m16701ok(final InterfaceC12523zz interfaceC12523zz) {
        if (interfaceC12523zz == null) {
            return null;
        }
        return new InterfaceC12421e.AbstractBinderC12422ok() { // from class: com.ss.android.socialbase.downloader.q.h.27
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12421e
            /* renamed from: ok */
            public long mo16643ok(int i, int i2) throws RemoteException {
                return InterfaceC12523zz.this.mo16651ok(i, i2);
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12441io m16715ok(final InterfaceC12460o interfaceC12460o) {
        if (interfaceC12460o == null) {
            return null;
        }
        return new InterfaceC12441io.AbstractBinderC12442ok() { // from class: com.ss.android.socialbase.downloader.q.h.28
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12441io
            /* renamed from: ok */
            public boolean mo16642ok(InterfaceC12476u interfaceC12476u) throws RemoteException {
                return InterfaceC12460o.this.mo16659ok(C12668h.m16708ok(interfaceC12476u));
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12435h m16730ok(final IDownloadFileUriProvider iDownloadFileUriProvider) {
        if (iDownloadFileUriProvider == null) {
            return null;
        }
        return new InterfaceC12435h.AbstractBinderC12436ok() { // from class: com.ss.android.socialbase.downloader.q.h.29
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12435h
            /* renamed from: ok */
            public Uri mo16641ok(String str, String str2) throws RemoteException {
                return IDownloadFileUriProvider.this.getUriForFile(str, str2);
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12479ul m16708ok(final InterfaceC12476u interfaceC12476u) {
        if (interfaceC12476u == null) {
            return null;
        }
        return new InterfaceC12479ul() { // from class: com.ss.android.socialbase.downloader.q.h.30
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12479ul
            /* renamed from: ok */
            public void mo16638ok(List<String> list) {
                try {
                    InterfaceC12476u.this.mo16657ok(list);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12479ul
            /* renamed from: ok */
            public boolean mo16639ok() {
                try {
                    return InterfaceC12476u.this.mo16658ok();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12438i m16709ok(final InterfaceC12475td interfaceC12475td) {
        if (interfaceC12475td == null) {
            return null;
        }
        return new InterfaceC12438i.AbstractBinderC12439ok() { // from class: com.ss.android.socialbase.downloader.q.h.31
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12438i
            /* renamed from: ok */
            public boolean mo16637ok(long j, long j2, InterfaceC12472t interfaceC12472t) throws RemoteException {
                return InterfaceC12475td.this.mo16654ok(j, j2, C12668h.m16710ok(interfaceC12472t));
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12482x m16710ok(final InterfaceC12472t interfaceC12472t) {
        if (interfaceC12472t == null) {
            return null;
        }
        return new InterfaceC12482x() { // from class: com.ss.android.socialbase.downloader.q.h.2
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12482x
            /* renamed from: ok */
            public void mo16653ok() {
                try {
                    InterfaceC12472t.this.mo16652ok();
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12450kf m16712ok(final InterfaceC12469rh interfaceC12469rh) {
        if (interfaceC12469rh == null) {
            return null;
        }
        return new InterfaceC12450kf.AbstractBinderC12451ok() { // from class: com.ss.android.socialbase.downloader.q.h.3
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12450kf
            /* renamed from: ok */
            public void mo16640ok(DownloadInfo downloadInfo, BaseException baseException, int i) throws RemoteException {
                InterfaceC12469rh.this.mo16663ok(downloadInfo, baseException, i);
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12447k m16704ok(final InterfaceC12483y interfaceC12483y) {
        if (interfaceC12483y == null) {
            return null;
        }
        return new InterfaceC12447k.AbstractBinderC12448ok() { // from class: com.ss.android.socialbase.downloader.q.h.4
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12447k
            /* renamed from: a */
            public int[] mo16636a() throws RemoteException {
                InterfaceC12483y interfaceC12483y2 = InterfaceC12483y.this;
                if (interfaceC12483y2 instanceof AbstractC12420bl) {
                    return ((AbstractC12420bl) interfaceC12483y2).mo16661ok();
                }
                return null;
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12447k
            /* renamed from: ok */
            public void mo16634ok(String str) throws RemoteException {
                if (TextUtils.isEmpty(str)) {
                    return;
                }
                try {
                    InterfaceC12483y.this.mo16660ok(new JSONObject(str));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12447k
            /* renamed from: ok */
            public String mo16635ok() throws RemoteException {
                return InterfaceC12483y.this.mo16662a();
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12457n m16702ok(final InterfaceC12509p interfaceC12509p) {
        if (interfaceC12509p == null) {
            return null;
        }
        return new InterfaceC12457n.AbstractBinderC12458ok() { // from class: com.ss.android.socialbase.downloader.q.h.5
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12457n
            /* renamed from: ok */
            public int mo16633ok(long j) throws RemoteException {
                return InterfaceC12509p.this.mo16677ok(j);
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12462p m16729ok(final IDownloadInterceptor iDownloadInterceptor) {
        if (iDownloadInterceptor == null) {
            return null;
        }
        return new InterfaceC12462p.AbstractBinderC12463ok() { // from class: com.ss.android.socialbase.downloader.q.h.6
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12462p
            /* renamed from: ok */
            public boolean mo16632ok() throws RemoteException {
                return IDownloadInterceptor.this.intercepte();
            }
        };
    }

    /* renamed from: ok */
    public static DownloadTask m16697ok(InterfaceC12604ok interfaceC12604ok) {
        if (interfaceC12604ok == null) {
            return null;
        }
        try {
            DownloadTask downloadTask = new DownloadTask(interfaceC12604ok.mo16687ok());
            downloadTask.chunkStategy(m16716ok(interfaceC12604ok.mo16696a())).notificationEventListener(m16717ok(interfaceC12604ok.mo16694bl())).interceptor(m16714ok(interfaceC12604ok.mo16688n())).depend(m16718ok(interfaceC12604ok.mo16689kf())).monitorDepend(m16719ok(interfaceC12604ok.mo16690k())).forbiddenHandler(m16721ok(interfaceC12604ok.mo16692h())).diskSpaceHandler(m16722ok(interfaceC12604ok.mo16683q())).fileUriProvider(m16723ok(interfaceC12604ok.mo16682r())).notificationClickCallback(m16724ok(interfaceC12604ok.mo16681s())).retryDelayTimeCalculator(m16727ok(interfaceC12604ok.mo16684p()));
            EnumC12414kf enumC12414kf = EnumC12414kf.MAIN;
            InterfaceC12465q mo16695a = interfaceC12604ok.mo16695a(enumC12414kf.ordinal());
            if (mo16695a != null) {
                downloadTask.mainThreadListenerWithHashCode(mo16695a.hashCode(), m16713ok(mo16695a));
            }
            EnumC12414kf enumC12414kf2 = EnumC12414kf.SUB;
            InterfaceC12465q mo16695a2 = interfaceC12604ok.mo16695a(enumC12414kf2.ordinal());
            if (mo16695a2 != null) {
                downloadTask.subThreadListenerWithHashCode(mo16695a2.hashCode(), m16713ok(mo16695a2));
            }
            EnumC12414kf enumC12414kf3 = EnumC12414kf.NOTIFICATION;
            InterfaceC12465q mo16695a3 = interfaceC12604ok.mo16695a(enumC12414kf3.ordinal());
            if (mo16695a3 != null) {
                downloadTask.notificationListenerWithHashCode(mo16695a3.hashCode(), m16713ok(mo16695a3));
            }
            m16698ok(downloadTask, interfaceC12604ok, enumC12414kf);
            m16698ok(downloadTask, interfaceC12604ok, enumC12414kf2);
            m16698ok(downloadTask, interfaceC12604ok, enumC12414kf3);
            m16699ok(downloadTask, interfaceC12604ok);
            return downloadTask;
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: ok */
    private static void m16698ok(DownloadTask downloadTask, InterfaceC12604ok interfaceC12604ok, EnumC12414kf enumC12414kf) throws RemoteException {
        SparseArray<IDownloadListener> sparseArray = new SparseArray<>();
        for (int i = 0; i < interfaceC12604ok.mo16686ok(enumC12414kf.ordinal()); i++) {
            InterfaceC12465q mo16685ok = interfaceC12604ok.mo16685ok(enumC12414kf.ordinal(), i);
            if (mo16685ok != null) {
                sparseArray.put(mo16685ok.mo16669ok(), m16713ok(mo16685ok));
            }
        }
        downloadTask.setDownloadListeners(sparseArray, enumC12414kf);
    }

    /* renamed from: ok */
    private static void m16699ok(DownloadTask downloadTask, InterfaceC12604ok interfaceC12604ok) throws RemoteException {
        for (int i = 0; i < interfaceC12604ok.mo16691j(); i++) {
            InterfaceC12444j mo16693bl = interfaceC12604ok.mo16693bl(i);
            if (mo16693bl != null) {
                downloadTask.addDownloadCompleteHandler(m16720ok(mo16693bl));
            }
        }
    }

    /* renamed from: ok */
    public static InterfaceC12427ep m16717ok(final InterfaceC12454m interfaceC12454m) {
        if (interfaceC12454m == null) {
            return null;
        }
        return new InterfaceC12427ep() { // from class: com.ss.android.socialbase.downloader.q.h.7
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep
            /* renamed from: ok */
            public void mo16630ok(int i, DownloadInfo downloadInfo, String str, String str2) {
                try {
                    InterfaceC12454m.this.mo16649ok(i, downloadInfo, str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep
            /* renamed from: ok */
            public boolean mo16629ok(boolean z) {
                try {
                    return InterfaceC12454m.this.mo16648ok(z);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12427ep
            /* renamed from: ok */
            public String mo16631ok() {
                try {
                    return InterfaceC12454m.this.mo16650ok();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12484z m16720ok(final InterfaceC12444j interfaceC12444j) {
        if (interfaceC12444j == null) {
            return null;
        }
        return new InterfaceC12484z() { // from class: com.ss.android.socialbase.downloader.q.h.8
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z
            /* renamed from: a */
            public boolean mo16628a(DownloadInfo downloadInfo) {
                try {
                    return InterfaceC12444j.this.mo16626a(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z
            /* renamed from: ok */
            public void mo16627ok(DownloadInfo downloadInfo) throws BaseException {
                try {
                    InterfaceC12444j.this.mo16625ok(downloadInfo);
                } catch (RemoteException e) {
                    throw new BaseException(1008, e);
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12444j m16703ok(final InterfaceC12484z interfaceC12484z) {
        if (interfaceC12484z == null) {
            return null;
        }
        return new InterfaceC12444j.AbstractBinderC12445ok() { // from class: com.ss.android.socialbase.downloader.q.h.9
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12444j
            /* renamed from: a */
            public boolean mo16626a(DownloadInfo downloadInfo) throws RemoteException {
                return InterfaceC12484z.this.mo16628a(downloadInfo);
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12444j
            /* renamed from: ok */
            public void mo16625ok(DownloadInfo downloadInfo) throws RemoteException {
                try {
                    InterfaceC12484z.this.mo16627ok(downloadInfo);
                } catch (BaseException e) {
                    throw new IllegalArgumentException(e);
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12480v m16724ok(final InterfaceC12432g interfaceC12432g) {
        if (interfaceC12432g == null) {
            return null;
        }
        return new InterfaceC12480v() { // from class: com.ss.android.socialbase.downloader.q.h.10
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v
            /* renamed from: a */
            public boolean mo16680a(DownloadInfo downloadInfo) {
                try {
                    return InterfaceC12432g.this.mo16646a(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v
            /* renamed from: bl */
            public boolean mo16679bl(DownloadInfo downloadInfo) {
                try {
                    return InterfaceC12432g.this.mo16645bl(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v
            /* renamed from: ok */
            public boolean mo16678ok(DownloadInfo downloadInfo) {
                try {
                    return InterfaceC12432g.this.mo16644ok(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12509p m16716ok(final InterfaceC12457n interfaceC12457n) {
        if (interfaceC12457n == null) {
            return null;
        }
        return new InterfaceC12509p() { // from class: com.ss.android.socialbase.downloader.q.h.11
            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12509p
            /* renamed from: ok */
            public int mo16677ok(long j) {
                try {
                    return InterfaceC12457n.this.mo16633ok(j);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12469rh m16718ok(final InterfaceC12450kf interfaceC12450kf) {
        if (interfaceC12450kf == null) {
            return null;
        }
        return new InterfaceC12469rh() { // from class: com.ss.android.socialbase.downloader.q.h.13
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12469rh
            /* renamed from: ok */
            public void mo16663ok(DownloadInfo downloadInfo, BaseException baseException, int i) {
                if (downloadInfo == null) {
                    return;
                }
                try {
                    InterfaceC12450kf.this.mo16640ok(downloadInfo, baseException, i);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12483y m16719ok(final InterfaceC12447k interfaceC12447k) {
        if (interfaceC12447k == null) {
            return null;
        }
        return new AbstractC12420bl() { // from class: com.ss.android.socialbase.downloader.q.h.14
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12483y
            /* renamed from: a */
            public String mo16662a() {
                try {
                    return InterfaceC12447k.this.mo16635ok();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return "";
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12483y
            /* renamed from: ok */
            public void mo16660ok(JSONObject jSONObject) {
                if (jSONObject == null) {
                    return;
                }
                try {
                    InterfaceC12447k.this.mo16634ok(jSONObject.toString());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.AbstractC12420bl
            /* renamed from: ok */
            public int[] mo16661ok() {
                try {
                    return InterfaceC12447k.this.mo16636a();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12460o m16721ok(final InterfaceC12441io interfaceC12441io) {
        if (interfaceC12441io == null) {
            return null;
        }
        return new InterfaceC12460o() { // from class: com.ss.android.socialbase.downloader.q.h.15
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12460o
            /* renamed from: ok */
            public boolean mo16659ok(InterfaceC12479ul interfaceC12479ul) {
                try {
                    return InterfaceC12441io.this.mo16642ok(C12668h.m16707ok(interfaceC12479ul));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12476u m16707ok(final InterfaceC12479ul interfaceC12479ul) {
        if (interfaceC12479ul == null) {
            return null;
        }
        return new InterfaceC12476u.AbstractBinderC12477ok() { // from class: com.ss.android.socialbase.downloader.q.h.16
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12476u
            /* renamed from: ok */
            public void mo16657ok(List<String> list) {
                InterfaceC12479ul.this.mo16638ok(list);
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12476u
            /* renamed from: ok */
            public boolean mo16658ok() {
                return InterfaceC12479ul.this.mo16639ok();
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12424em m16711ok(final InterfaceC12471sg interfaceC12471sg) {
        if (interfaceC12471sg == null) {
            return null;
        }
        return new InterfaceC12424em.AbstractBinderC12425ok() { // from class: com.ss.android.socialbase.downloader.q.h.17
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12424em
            /* renamed from: ok */
            public void mo16656ok(int i, int i2) {
                InterfaceC12471sg.this.mo16655ok(i, i2);
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12471sg m16726ok(final InterfaceC12424em interfaceC12424em) {
        if (interfaceC12424em == null) {
            return null;
        }
        return new InterfaceC12471sg() { // from class: com.ss.android.socialbase.downloader.q.h.18
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12471sg
            /* renamed from: ok */
            public void mo16655ok(int i, int i2) {
                try {
                    InterfaceC12424em.this.mo16656ok(i, i2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12475td m16722ok(final InterfaceC12438i interfaceC12438i) {
        if (interfaceC12438i == null) {
            return null;
        }
        return new InterfaceC12475td() { // from class: com.ss.android.socialbase.downloader.q.h.19
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12475td
            /* renamed from: ok */
            public boolean mo16654ok(long j, long j2, InterfaceC12482x interfaceC12482x) {
                try {
                    return InterfaceC12438i.this.mo16637ok(j, j2, C12668h.m16705ok(interfaceC12482x));
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12472t m16705ok(final InterfaceC12482x interfaceC12482x) {
        if (interfaceC12482x == null) {
            return null;
        }
        return new InterfaceC12472t.AbstractBinderC12473ok() { // from class: com.ss.android.socialbase.downloader.q.h.20
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12472t
            /* renamed from: ok */
            public void mo16652ok() throws RemoteException {
                InterfaceC12482x.this.mo16653ok();
            }
        };
    }

    /* renamed from: ok */
    public static InterfaceC12523zz m16727ok(final InterfaceC12421e interfaceC12421e) {
        if (interfaceC12421e == null) {
            return null;
        }
        return new InterfaceC12523zz() { // from class: com.ss.android.socialbase.downloader.q.h.21
            @Override // com.p521ss.android.socialbase.downloader.downloader.InterfaceC12523zz
            /* renamed from: ok */
            public long mo16651ok(int i, int i2) {
                try {
                    return InterfaceC12421e.this.mo16643ok(i, i2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return 0L;
                }
            }
        };
    }

    /* renamed from: ok */
    public static IDownloadInterceptor m16714ok(final InterfaceC12462p interfaceC12462p) {
        if (interfaceC12462p == null) {
            return null;
        }
        return new IDownloadInterceptor() { // from class: com.ss.android.socialbase.downloader.q.h.22
            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadInterceptor
            public boolean intercepte() {
                try {
                    return InterfaceC12462p.this.mo16632ok();
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        };
    }

    /* renamed from: ok */
    public static IDownloadFileUriProvider m16723ok(final InterfaceC12435h interfaceC12435h) {
        if (interfaceC12435h == null) {
            return null;
        }
        return new IDownloadFileUriProvider() { // from class: com.ss.android.socialbase.downloader.q.h.24
            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadFileUriProvider
            public Uri getUriForFile(String str, String str2) {
                try {
                    return InterfaceC12435h.this.mo16641ok(str, str2);
                } catch (RemoteException e) {
                    e.printStackTrace();
                    return null;
                }
            }
        };
    }

    /* renamed from: ok */
    public static IDownloadListener m16713ok(final InterfaceC12465q interfaceC12465q) {
        if (interfaceC12465q == null) {
            return null;
        }
        return new InterfaceC12485zz() { // from class: com.ss.android.socialbase.downloader.q.h.25
            @Override // com.p521ss.android.socialbase.downloader.depend.InterfaceC12485zz
            /* renamed from: ok */
            public void mo16647ok(DownloadInfo downloadInfo) {
                try {
                    InterfaceC12465q.this.mo16665q(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
            public void onCanceled(DownloadInfo downloadInfo) {
                try {
                    InterfaceC12465q.this.mo16671kf(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFailed(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    InterfaceC12465q.this.mo16667ok(downloadInfo, baseException);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstStart(DownloadInfo downloadInfo) {
                try {
                    InterfaceC12465q.this.mo16672h(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
            public void onFirstSuccess(DownloadInfo downloadInfo) {
                try {
                    InterfaceC12465q.this.mo16666p(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPause(DownloadInfo downloadInfo) {
                try {
                    InterfaceC12465q.this.mo16664s(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
            public void onPrepare(DownloadInfo downloadInfo) {
                try {
                    InterfaceC12465q.this.mo16668ok(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
            public void onProgress(DownloadInfo downloadInfo) {
                try {
                    InterfaceC12465q.this.mo16674bl(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetry(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    InterfaceC12465q.this.mo16675a(downloadInfo, baseException);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
            public void onRetryDelay(DownloadInfo downloadInfo, BaseException baseException) {
                try {
                    InterfaceC12465q.this.mo16673bl(downloadInfo, baseException);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
            public void onStart(DownloadInfo downloadInfo) {
                try {
                    InterfaceC12465q.this.mo16676a(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }

            @Override // com.p521ss.android.socialbase.downloader.depend.IDownloadListener
            public void onSuccessed(DownloadInfo downloadInfo) {
                try {
                    InterfaceC12465q.this.mo16670n(downloadInfo);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
        };
    }
}
