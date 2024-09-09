package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.ss.android.socialbase.downloader.depend.ck;
import com.ss.android.socialbase.downloader.depend.me;
import com.ss.android.socialbase.downloader.depend.pr;
import com.ss.android.socialbase.downloader.downloader.i;
import com.ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.ss.android.socialbase.downloader.model.DownloadInfo;
import com.ss.android.socialbase.downloader.model.DownloadTask;
import com.ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.stub.StubApp;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6206960.dex */
public class xv {

    /* renamed from: a  reason: collision with root package name */
    private static volatile IDownloadHttpService f49515a;
    private static final List<com.ss.android.socialbase.downloader.depend.z> au;

    /* renamed from: b  reason: collision with root package name */
    private static boolean f49516b;
    private static volatile ck ba;
    private static int bj;
    private static volatile com.ss.android.socialbase.downloader.network.ev bk;
    private static boolean bm;
    private static int bw;

    /* renamed from: c  reason: collision with root package name */
    private static volatile Context f49517c;
    private static volatile ia ck;
    private static volatile ys ev;

    /* renamed from: f  reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.impls.c f49518f;
    private static volatile ExecutorService fp;
    private static volatile ExecutorService fz;
    private static volatile DownloadReceiver gb;
    private static volatile c gd;
    private static final int gw;

    /* renamed from: i  reason: collision with root package name */
    private static volatile ExecutorService f49519i;
    private static volatile ExecutorService ia;

    /* renamed from: j  reason: collision with root package name */
    private static volatile ScheduledExecutorService f49520j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.network.ev f49521k;
    private static volatile r ls;

    /* renamed from: m  reason: collision with root package name */
    private static final int f49522m;
    private static boolean mt;

    /* renamed from: n  reason: collision with root package name */
    private static volatile fz f49523n;
    private static final List<com.ss.android.socialbase.downloader.depend.k> oo;
    private static com.ss.android.socialbase.downloader.sr.xv ox;

    /* renamed from: p  reason: collision with root package name */
    private static volatile IDownloadHttpService f49524p;

    /* renamed from: q  reason: collision with root package name */
    private static volatile ExecutorService f49525q;

    /* renamed from: r  reason: collision with root package name */
    private static volatile ys f49526r;

    /* renamed from: s  reason: collision with root package name */
    private static volatile ExecutorService f49527s;
    private static volatile ev sr;

    /* renamed from: t  reason: collision with root package name */
    private static volatile a f49528t;

    /* renamed from: u  reason: collision with root package name */
    private static volatile ExecutorService f49529u;
    private static int up;
    private static volatile me ux;
    private static final int vc;

    /* renamed from: w  reason: collision with root package name */
    private static volatile p f49530w;
    private static s wo;
    private static volatile com.ss.android.socialbase.downloader.network.f wv;

    /* renamed from: x  reason: collision with root package name */
    private static final int f49531x;
    private static volatile com.ss.android.socialbase.downloader.network.f xk;
    private static volatile boolean xu;
    private static volatile k xv;
    private static volatile ExecutorService ys;
    private static volatile i yu;

    /* renamed from: z  reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.sr.w f49533z;

    /* renamed from: y  reason: collision with root package name */
    private static volatile List<pr> f49532y = new ArrayList();
    private static volatile boolean eq = false;
    private static volatile OkHttpClient me = null;
    private static final List<com.ss.android.socialbase.downloader.depend.bk> wx = new ArrayList();
    private static boolean pr = false;

    /* loaded from: E:\TSN-r\205dec\6206960.dex */
    public interface c {

        /* renamed from: com.ss.android.socialbase.downloader.downloader.xv$c$c  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6206960.dex */
        public interface InterfaceC1008c {
            void c();
        }

        u c(InterfaceC1008c interfaceC1008c);

        ys c();

        bk w();
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        f49531x = availableProcessors;
        f49522m = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        gw = availableProcessors;
        vc = availableProcessors;
        up = 8192;
        oo = new ArrayList();
        au = new ArrayList();
        bm = true;
        f49516b = false;
        xu = false;
    }

    private xv() {
    }

    public static ExecutorService a() {
        if (ys == null) {
            synchronized (xv.class) {
                if (ys == null) {
                    int i4 = f49531x;
                    com.bytedance.sdk.component.gd.sr.sr srVar = new com.bytedance.sdk.component.gd.sr.sr(i4, i4, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.ev.c("DownloadThreadPool-cpu-fixed", true));
                    srVar.allowCoreThreadTimeOut(true);
                    ys = srVar;
                }
            }
        }
        return ys;
    }

    public static boolean au() {
        StringBuilder sb = new StringBuilder();
        sb.append("supportMultiProc::=");
        sb.append(gd != null);
        com.ss.android.socialbase.downloader.xv.c.c("wjd", sb.toString());
        return gd != null;
    }

    public static k ba() {
        if (xv == null) {
            synchronized (xv.class) {
                if (xv == null) {
                    xv = new com.ss.android.socialbase.downloader.impls.gd();
                }
            }
        }
        return xv;
    }

    public static c bj() {
        return gd;
    }

    public static ExecutorService bk() {
        return fp != null ? fp : a();
    }

    private static void bm() {
        if (gb == null) {
            gb = new DownloadReceiver();
        }
        if (pr) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            f49517c.registerReceiver(gb, intentFilter);
            pr = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static r bw() {
        if (ls == null) {
            synchronized (xv.class) {
                if (ls == null) {
                    ls = new com.ss.android.socialbase.downloader.impls.w();
                }
            }
        }
        return ls;
    }

    /* JADX WARN: Type inference failed for: r3v18, types: [com.ss.android.socialbase.downloader.downloader.fz, com.ss.android.socialbase.downloader.impls.p] */
    static synchronized void c(DownloaderBuilder downloaderBuilder) {
        synchronized (xv.class) {
            if (xu) {
                com.ss.android.socialbase.downloader.xv.c.ux("DownloadComponentManager", "component has init");
                return;
            }
            boolean z3 = eq;
            xv(downloaderBuilder);
            if (f49530w == null) {
                f49530w = new com.ss.android.socialbase.downloader.impls.sr();
            }
            if (f49526r == null) {
                f49526r = new com.ss.android.socialbase.downloader.impls.ev();
            }
            if (ev == null && gd != null) {
                ev = gd.c();
            }
            if (xv == null) {
                xv = new com.ss.android.socialbase.downloader.impls.gd();
            }
            if (f49518f == null) {
                f49518f = new com.ss.android.socialbase.downloader.impls.ux();
            }
            if (sr == null) {
                sr = new com.ss.android.socialbase.downloader.impls.xv();
            }
            if (ls == null) {
                ls = new com.ss.android.socialbase.downloader.impls.w();
            }
            if (f49523n == null) {
                f49523n = new com.ss.android.socialbase.downloader.impls.p();
            }
            int i4 = bw;
            if (i4 <= 0 || i4 > f49531x) {
                bw = f49531x;
            }
            bm();
            if (eq && !z3 && !com.ss.android.socialbase.downloader.gd.f.xv()) {
                com.ss.android.socialbase.downloader.impls.a.c(true).startService();
            } else if (com.ss.android.socialbase.downloader.gd.f.sr()) {
                ExecutorService bk2 = bk();
                if (bk2 != null) {
                    bk2.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.xv.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context gw2 = xv.gw();
                            if (gw2 != null) {
                                com.ss.android.socialbase.downloader.gd.f.sr(gw2);
                            }
                        }
                    });
                }
            } else {
                Context gw2 = gw();
                if (gw2 != null) {
                    com.ss.android.socialbase.downloader.gd.f.sr(gw2);
                }
            }
            wv();
            xu = true;
        }
    }

    public static void c(s sVar) {
    }

    public static ys ck() {
        if (ev == null) {
            synchronized (xv.class) {
                if (ev == null) {
                    ev = gd.c();
                }
            }
        }
        return ev;
    }

    public static int eq() {
        return bj;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.ss.android.socialbase.downloader.network.IDownloadHttpService, com.ss.android.socialbase.downloader.impls.r] */
    public static IDownloadHttpService ev() {
        if (f49515a == null) {
            synchronized (xv.class) {
                if (f49515a == null) {
                    f49515a = new com.ss.android.socialbase.downloader.impls.r();
                }
            }
        }
        return f49515a;
    }

    public static com.ss.android.socialbase.downloader.network.ev f() {
        return f49521k;
    }

    public static ExecutorService fp() {
        if (ia == null) {
            synchronized (xv.class) {
                if (ia == null) {
                    int i4 = gw;
                    com.bytedance.sdk.component.gd.sr.sr srVar = new com.bytedance.sdk.component.gd.sr.sr(i4, i4, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.ev.c("DownloadThreadPool-mix-fixed", true));
                    srVar.allowCoreThreadTimeOut(true);
                    ia = srVar;
                }
            }
        }
        return ia;
    }

    public static OkHttpClient fz() {
        if (me == null) {
            synchronized (xv.class) {
                if (me == null) {
                    me = i().build();
                }
            }
        }
        return me;
    }

    public static p gb() {
        if (f49530w == null) {
            synchronized (xv.class) {
                if (f49530w == null) {
                    f49530w = new com.ss.android.socialbase.downloader.impls.sr();
                }
            }
        }
        return f49530w;
    }

    public static com.ss.android.socialbase.downloader.network.ev gd() {
        if (bk == null) {
            synchronized (xv.class) {
                if (bk == null) {
                    bk = new com.ss.android.socialbase.downloader.impls.f();
                }
            }
        }
        return bk;
    }

    public static synchronized Context gw() {
        Context context;
        synchronized (xv.class) {
            context = f49517c;
        }
        return context;
    }

    public static OkHttpClient.Builder i() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(PolicyConfig.mServerBusyRetryBaseInternal, timeUnit).readTimeout(PolicyConfig.mServerBusyRetryBaseInternal, timeUnit).writeTimeout(PolicyConfig.mServerBusyRetryBaseInternal, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (f49525q != null) {
            builder.dispatcher(new Dispatcher(f49525q));
        }
        return builder;
    }

    public static ExecutorService ia() {
        if (f49519i == null) {
            synchronized (xv.class) {
                if (f49519i == null) {
                    int i4 = f49522m;
                    com.bytedance.sdk.component.gd.sr.sr srVar = new com.bytedance.sdk.component.gd.sr.sr(i4, i4, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.ev.c("DownloadThreadPool-chunk-fixed", true));
                    srVar.allowCoreThreadTimeOut(true);
                    f49519i = srVar;
                }
            }
        }
        return f49519i;
    }

    public static com.ss.android.socialbase.downloader.network.f j() {
        if (xk == null) {
            synchronized (xv.class) {
                if (xk == null) {
                    xk = new com.ss.android.socialbase.downloader.network.f() { // from class: com.ss.android.socialbase.downloader.downloader.xv.2
                        @Override // com.ss.android.socialbase.downloader.network.f
                        public List<InetAddress> c(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return xk;
    }

    public static synchronized ia k() {
        ia iaVar;
        synchronized (xv.class) {
            iaVar = ck;
        }
        return iaVar;
    }

    public static synchronized a ls() {
        a aVar;
        synchronized (xv.class) {
            aVar = f49528t;
        }
        return aVar;
    }

    public static i m() {
        if (yu == null) {
            synchronized (xv.class) {
                if (yu == null) {
                    yu = new i.c();
                }
            }
        }
        return yu;
    }

    @NonNull
    public static JSONObject me() {
        if (ba != null && ba.c() != null) {
            return ba.c();
        }
        return com.ss.android.socialbase.downloader.constants.ux.gd;
    }

    public static s mt() {
        return wo;
    }

    public static ys n() {
        if (f49526r == null) {
            synchronized (xv.class) {
                if (f49526r == null) {
                    f49526r = new com.ss.android.socialbase.downloader.impls.ev();
                }
            }
        }
        return f49526r;
    }

    public static boolean oo() {
        return xu;
    }

    public static boolean p() {
        return com.ss.android.socialbase.downloader.r.c.xv().c("switch_not_auto_boot_service", f49516b ? 1 : 0) > 0;
    }

    public static me pr() {
        return ux;
    }

    public static com.ss.android.socialbase.downloader.network.f q() {
        return wv;
    }

    public static com.ss.android.socialbase.downloader.sr.w r() {
        return f49533z;
    }

    public static ExecutorService s() {
        if (f49529u == null) {
            synchronized (xv.class) {
                if (f49529u == null) {
                    int i4 = vc;
                    com.bytedance.sdk.component.gd.sr.sr srVar = new com.bytedance.sdk.component.gd.sr.sr(i4, i4, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.ev.c("DownloadThreadPool-db-fixed", true));
                    srVar.allowCoreThreadTimeOut(true);
                    f49529u = srVar;
                }
            }
        }
        return f49529u;
    }

    public static IDownloadHttpService sr() {
        return f49524p;
    }

    public static ExecutorService t() {
        return f49527s != null ? f49527s : fp();
    }

    public static ScheduledExecutorService u() {
        if (f49520j == null) {
            synchronized (xv.class) {
                if (f49520j == null) {
                    f49520j = new com.bytedance.sdk.component.gd.sr.ux(1, new com.ss.android.socialbase.downloader.ev.c("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return f49520j;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.sr.xv up() {
        if (ox == null) {
            ox = new com.ss.android.socialbase.downloader.sr.xv() { // from class: com.ss.android.socialbase.downloader.downloader.xv.3
                @Override // com.ss.android.socialbase.downloader.sr.xv
                public void c(int i4, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.sr.xv
                public void w(int i4, String str, JSONObject jSONObject) {
                }
            };
        }
        return ox;
    }

    public static List<pr> ux() {
        List<pr> list;
        synchronized (f49532y) {
            list = f49532y;
        }
        return list;
    }

    public static synchronized boolean vc() {
        boolean z3;
        synchronized (xv.class) {
            z3 = mt;
        }
        return z3;
    }

    static synchronized void w(DownloaderBuilder downloaderBuilder) {
        synchronized (xv.class) {
            xv(downloaderBuilder);
        }
    }

    public static void wv() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.ux.xv)) {
            com.ss.android.socialbase.downloader.constants.ux.xv = "oppo";
            com.ss.android.socialbase.downloader.constants.ux.f49354w = com.ss.android.socialbase.downloader.constants.ux.xv.toUpperCase();
        }
    }

    public static ev wx() {
        if (sr == null) {
            synchronized (xv.class) {
                if (sr == null) {
                    sr = new com.ss.android.socialbase.downloader.impls.xv();
                }
            }
        }
        return sr;
    }

    /* JADX WARN: Type inference failed for: r1v2, types: [com.ss.android.socialbase.downloader.downloader.fz, com.ss.android.socialbase.downloader.impls.p] */
    public static fz x() {
        if (f49523n == null) {
            synchronized (xv.class) {
                if (f49523n == null) {
                    f49523n = new com.ss.android.socialbase.downloader.impls.p();
                }
            }
        }
        return f49523n;
    }

    public static boolean xk() {
        return bm;
    }

    private static void xv(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                c(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                c(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                c(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                c(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                c(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                w(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                c(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                c(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                c(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                xv(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                sr(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                ux(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                f(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                r(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                ev(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                c(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                w(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                c((List<com.ss.android.socialbase.downloader.depend.bk>) downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                ck = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                up = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                c(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                eq = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                bj = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                c(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                wv = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                yu = downloaderBuilder.getTTNetHandler();
                if (yu.c()) {
                    c(yu.w());
                    c(yu.xv());
                } else {
                    c(ev());
                    c(gd());
                }
            }
            w(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                c(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    public static com.ss.android.socialbase.downloader.impls.c y() {
        if (f49518f == null) {
            synchronized (xv.class) {
                if (f49518f == null) {
                    f49518f = new com.ss.android.socialbase.downloader.impls.ux();
                }
            }
        }
        return f49518f;
    }

    public static ExecutorService ys() {
        return fz != null ? fz : fp();
    }

    public static synchronized int yu() {
        int i4;
        synchronized (xv.class) {
            i4 = up;
        }
        return i4;
    }

    public static List<com.ss.android.socialbase.downloader.depend.bk> z() {
        return wx;
    }

    private static void f(ExecutorService executorService) {
        if (executorService != null) {
            f49527s = executorService;
        }
    }

    private static void r(ExecutorService executorService) {
        if (executorService != null) {
            fz = executorService;
        }
    }

    private static void sr(ExecutorService executorService) {
        if (executorService != null) {
            fp = executorService;
        }
    }

    public static synchronized void w() {
        synchronized (xv.class) {
            if (eq) {
                return;
            }
            eq = true;
            Intent intent = new Intent(gw(), DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            gw().startService(intent);
            if (!com.ss.android.socialbase.downloader.gd.f.xv()) {
                com.ss.android.socialbase.downloader.impls.a.c(true).startService();
            }
        }
    }

    private static void ux(ExecutorService executorService) {
        if (executorService != null) {
            ia = executorService;
        }
    }

    private static void ev(ExecutorService executorService) {
        if (executorService != null) {
            f49529u = executorService;
        }
    }

    public static void w(com.ss.android.socialbase.downloader.depend.k kVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = oo;
        synchronized (list) {
            if (kVar != null) {
                if (list.contains(kVar)) {
                    list.remove(kVar);
                }
            }
        }
    }

    public static void w(DownloadTask downloadTask, int i4) {
        List<com.ss.android.socialbase.downloader.depend.z> list = au;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.z zVar : list) {
                if (zVar != null) {
                    zVar.w(downloadTask, i4);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.network.r w(java.lang.String r11, java.util.List<com.ss.android.socialbase.downloader.model.xv> r12, int r13, boolean r14, com.ss.android.socialbase.downloader.model.DownloadInfo r15) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r0 = 1
            if (r13 != r0) goto L8
            com.ss.android.socialbase.downloader.network.ev r0 = f()
            goto Lc
        L8:
            com.ss.android.socialbase.downloader.network.ev r0 = gd()
        Lc:
            if (r0 == 0) goto L49
            r1 = 0
            r9 = 0
            r2 = 0
            if (r14 == 0) goto L18
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
        L18:
            com.ss.android.socialbase.downloader.network.r r12 = r0.c(r11, r12)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
            if (r14 == 0) goto L2e
            r4 = 0
            long r0 = java.lang.System.currentTimeMillis()
            long r5 = r0 - r2
            java.lang.String r7 = "head"
            r2 = r12
            r3 = r11
            r8 = r13
            r10 = r15
            com.ss.android.socialbase.downloader.sr.c.c(r2, r3, r4, r5, r7, r8, r9, r10)
        L2e:
            return r12
        L2f:
            r12 = move-exception
            r8 = r9
            goto L37
        L32:
            r12 = move-exception
            throw r12     // Catch: java.lang.Throwable -> L34
        L34:
            r0 = move-exception
            r8 = r12
            r12 = r0
        L37:
            if (r14 == 0) goto L48
            r14 = 0
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            java.lang.String r6 = "head"
            r2 = r11
            r3 = r14
            r7 = r13
            r9 = r15
            com.ss.android.socialbase.downloader.sr.c.c(r1, r2, r3, r4, r6, r7, r8, r9)
        L48:
            throw r12
        L49:
            com.ss.android.socialbase.downloader.exception.BaseException r11 = new com.ss.android.socialbase.downloader.exception.BaseException
            r12 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r14 = new java.io.IOException
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>()
            java.lang.String r0 = "httpService not exist, netLib = "
            r15.append(r0)
            r15.append(r13)
            java.lang.String r13 = r15.toString()
            r14.<init>(r13)
            r11.<init>(r12, r14)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.xv.w(java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.r");
    }

    public static void w(ExecutorService executorService) {
        if (executorService != null) {
            f49525q = executorService;
        }
    }

    public static void w(Runnable runnable) {
        w(runnable, false);
    }

    public static void w(Runnable runnable, boolean z3) {
        if (runnable == null) {
            return;
        }
        if (z3 && !com.ss.android.socialbase.downloader.gd.f.sr()) {
            runnable.run();
        } else {
            bk().execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void c() {
        synchronized (xv.class) {
            try {
                if (pr && gb != null && f49517c != null) {
                    f49517c.unregisterReceiver(gb);
                    pr = false;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private static void w(int i4) {
        if (i4 > 0) {
            bw = i4;
        }
    }

    private static void w(boolean z3) {
        bm = z3;
    }

    public static void c(pr prVar) {
        if (prVar == null) {
            return;
        }
        synchronized (f49532y) {
            f49532y.add(prVar);
        }
    }

    public static void c(com.ss.android.socialbase.downloader.depend.k kVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = oo;
        synchronized (list) {
            if (kVar != null) {
                if (!list.contains(kVar)) {
                    list.add(kVar);
                }
            }
        }
    }

    public static void c(com.ss.android.socialbase.downloader.constants.sr srVar) {
        List<com.ss.android.socialbase.downloader.depend.k> list = oo;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.k kVar : list) {
                if (kVar != null) {
                    if (srVar == com.ss.android.socialbase.downloader.constants.sr.SYNC_START) {
                        kVar.c();
                    } else if (srVar == com.ss.android.socialbase.downloader.constants.sr.SYNC_SUCCESS) {
                        kVar.w();
                    }
                }
            }
            if (srVar == com.ss.android.socialbase.downloader.constants.sr.SYNC_SUCCESS) {
                oo.clear();
            }
        }
    }

    public static void c(DownloadTask downloadTask, int i4) {
        List<com.ss.android.socialbase.downloader.depend.z> list = au;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.z zVar : list) {
                if (zVar != null) {
                    zVar.c(downloadTask, i4);
                }
            }
        }
    }

    public static synchronized boolean xv() {
        boolean z3;
        synchronized (xv.class) {
            z3 = eq;
        }
        return z3;
    }

    private static void xv(ExecutorService executorService) {
        if (executorService != null) {
            ys = executorService;
        }
    }

    public static void xv(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.gd.f.sr()) {
            runnable.run();
        } else {
            s().execute(runnable);
        }
    }

    public static com.ss.android.socialbase.downloader.network.gd c(boolean z3, int i4, String str, List<com.ss.android.socialbase.downloader.model.xv> list) throws Exception {
        return c(z3, i4, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.gd c(boolean z3, int i4, String str, String str2, List<com.ss.android.socialbase.downloader.model.xv> list, int i5, boolean z4, DownloadInfo downloadInfo) throws Exception {
        List<com.ss.android.socialbase.downloader.model.xv> list2;
        int i6;
        com.ss.android.socialbase.downloader.network.gd c4;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.model.xv> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.xv("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i6 = 1;
        } else if (z3) {
            list2 = list;
            i6 = i5;
        } else {
            i6 = 2;
            list2 = list;
        }
        int[] c5 = c(i6);
        Exception exc = null;
        for (int i7 : c5) {
            try {
                c4 = c(i4, str, str2, list2, i7, z4, downloadInfo);
            } catch (Exception e4) {
                if (downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.gd.f.r(e4) && com.ss.android.socialbase.downloader.gd.f.xv(list2)) {
                    com.ss.android.socialbase.downloader.xv.c.c("dcach::http exception 304, throw excepiton, not retry " + e4);
                    throw e4;
                }
                exc = e4;
            }
            if (c4 != null) {
                return c4;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.network.gd c(int r11, java.lang.String r12, java.lang.String r13, java.util.List<com.ss.android.socialbase.downloader.model.xv> r14, int r15, boolean r16, com.ss.android.socialbase.downloader.model.DownloadInfo r17) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r7 = r15
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = sr()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = ev()
        Ld:
            if (r0 == 0) goto L55
            r1 = 0
            r8 = 0
            r2 = 0
            if (r16 == 0) goto L20
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L1a java.io.IOException -> L1d
            goto L20
        L1a:
            r0 = move-exception
            r5 = r12
            goto L42
        L1d:
            r0 = move-exception
            r5 = r12
            goto L3e
        L20:
            r4 = r11
            r5 = r12
            r6 = r14
            com.ss.android.socialbase.downloader.network.gd r0 = r0.downloadWithConnection(r11, r12, r14)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
            if (r16 == 0) goto L3a
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r2
            java.lang.String r6 = "get"
            r1 = r0
            r2 = r12
            r3 = r13
            r4 = r9
            r7 = r15
            r9 = r17
            com.ss.android.socialbase.downloader.sr.c.c(r1, r2, r3, r4, r6, r7, r8, r9)
        L3a:
            return r0
        L3b:
            r0 = move-exception
            goto L42
        L3d:
            r0 = move-exception
        L3e:
            r4 = r0
            throw r4     // Catch: java.lang.Throwable -> L40
        L40:
            r0 = move-exception
            r8 = r4
        L42:
            if (r16 == 0) goto L54
            long r9 = java.lang.System.currentTimeMillis()
            long r9 = r9 - r2
            java.lang.String r6 = "get"
            r2 = r12
            r3 = r13
            r4 = r9
            r7 = r15
            r9 = r17
            com.ss.android.socialbase.downloader.sr.c.c(r1, r2, r3, r4, r6, r7, r8, r9)
        L54:
            throw r0
        L55:
            com.ss.android.socialbase.downloader.exception.BaseException r0 = new com.ss.android.socialbase.downloader.exception.BaseException
            r1 = 1022(0x3fe, float:1.432E-42)
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "httpService not exist, netLib = "
            r3.append(r4)
            r3.append(r15)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.xv.c(int, java.lang.String, java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.gd");
    }

    public static com.ss.android.socialbase.downloader.network.r c(String str, List<com.ss.android.socialbase.downloader.model.xv> list) throws Exception {
        return c(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.r c(String str, List<com.ss.android.socialbase.downloader.model.xv> list, int i4, boolean z3, DownloadInfo downloadInfo) throws Exception {
        com.ss.android.socialbase.downloader.network.r w3;
        Exception e4 = null;
        for (int i5 : c(i4)) {
            try {
                w3 = w(str, list, i5, z3, downloadInfo);
            } catch (Exception e5) {
                e4 = e5;
            }
            if (w3 != null) {
                return w3;
            }
        }
        if (e4 == null) {
            return null;
        }
        throw e4;
    }

    private static int[] c(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    public static synchronized void c(a aVar) {
        synchronized (xv.class) {
            if (aVar != null) {
                f49528t = aVar;
                if (f49530w instanceof com.ss.android.socialbase.downloader.impls.sr) {
                    ((com.ss.android.socialbase.downloader.impls.sr) f49530w).ev();
                }
            }
        }
    }

    public static void c(ExecutorService executorService) {
        if (executorService != null) {
            f49519i = executorService;
        }
    }

    private static void c(List<com.ss.android.socialbase.downloader.depend.bk> list) {
        List<com.ss.android.socialbase.downloader.depend.bk> list2 = wx;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void c(boolean z3) {
        f49516b = z3;
    }

    public static void c(Runnable runnable) {
        c(runnable, false);
    }

    public static void c(Runnable runnable, boolean z3) {
        if (runnable == null) {
            return;
        }
        if (z3 && !com.ss.android.socialbase.downloader.gd.f.sr()) {
            runnable.run();
        } else {
            a().execute(runnable);
        }
    }

    public static Future c(Runnable runnable, long j4, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return u().schedule(runnable, j4, timeUnit);
    }

    public static void c(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            f49524p = iDownloadHttpService;
        }
        mt = f49524p != null;
    }

    public static void c(com.ss.android.socialbase.downloader.network.ev evVar) {
        if (evVar != null) {
            f49521k = evVar;
        }
    }

    private static void c(p pVar) {
        if (pVar != null) {
            f49530w = pVar;
        }
    }

    private static void c(k kVar) {
        if (kVar != null) {
            xv = kVar;
        }
    }

    private static void c(com.ss.android.socialbase.downloader.sr.w wVar) {
        if (wVar != null) {
            f49533z = wVar;
        }
    }

    public static void c(ck ckVar) {
        ba = ckVar;
        com.ss.android.socialbase.downloader.r.c.c();
    }

    private static void c(ev evVar) {
        if (evVar != null) {
            sr = evVar;
        }
    }

    public static void c(me meVar) {
        if (meVar != null) {
            ux = meVar;
        }
    }

    private static void c(r rVar) {
        if (rVar != null) {
            ls = rVar;
        }
    }

    public static synchronized void c(Context context) {
        synchronized (xv.class) {
            if (context != null) {
                if (f49517c == null) {
                    f49517c = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    com.ss.android.socialbase.downloader.c.c.c().c(f49517c);
                }
            }
        }
    }

    public static int c(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return c(taskKey, downloadInfo.getSavePath());
    }

    public static int c(String str, String str2) {
        k ba2 = ba();
        if (ba2 == null) {
            return 0;
        }
        return ba2.c(str, str2);
    }

    public static void c(com.ss.android.socialbase.downloader.sr.xv xvVar) {
        ox = xvVar;
    }

    public static void c(c cVar) {
        com.ss.android.socialbase.downloader.xv.c.c("wjd", "setIndependentServiceCreator::creator=" + cVar);
        gd = cVar;
    }
}
