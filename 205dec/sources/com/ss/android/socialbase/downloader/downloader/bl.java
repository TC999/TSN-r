package com.ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.bytedance.pangle.sdk.component.log.impl.event.policy.PolicyConfig;
import com.ss.android.socialbase.downloader.depend.kz;
import com.ss.android.socialbase.downloader.depend.sg;
import com.ss.android.socialbase.downloader.depend.v;
import com.ss.android.socialbase.downloader.depend.vz;
import com.ss.android.socialbase.downloader.downloader.io;
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
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Dispatcher;
import okhttp3.Dns;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import org.json.JSONObject;

/* loaded from: E:\TSN-r\205dec\6400276.dex */
public class bl {

    /* renamed from: a  reason: collision with root package name */
    private static volatile k f49412a;
    private static final int ah;
    private static volatile r bl;
    private static volatile boolean cf;
    private static boolean cs;
    private static com.ss.android.socialbase.downloader.s.bl dx;

    /* renamed from: e  reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.network.kf f49413e;
    private static final List<com.ss.android.socialbase.downloader.depend.r> ej;
    private static volatile zz ep;
    private static volatile vz er;
    private static volatile io fd;
    private static volatile com.ss.android.socialbase.downloader.network.kf fl;

    /* renamed from: h  reason: collision with root package name */
    private static volatile t f49415h;

    /* renamed from: i  reason: collision with root package name */
    private static volatile ExecutorService f49416i;

    /* renamed from: io  reason: collision with root package name */
    private static volatile ExecutorService f49417io;

    /* renamed from: j  reason: collision with root package name */
    private static volatile IDownloadHttpService f49418j;

    /* renamed from: k  reason: collision with root package name */
    private static volatile IDownloadHttpService f49419k;
    private static volatile com.ss.android.socialbase.downloader.impls.ok kf;
    private static volatile com.ss.android.socialbase.downloader.s.a kz;

    /* renamed from: l  reason: collision with root package name */
    private static final int f49420l;

    /* renamed from: m  reason: collision with root package name */
    private static volatile DownloadReceiver f49421m;

    /* renamed from: n  reason: collision with root package name */
    private static volatile v f49422n;

    /* renamed from: o  reason: collision with root package name */
    private static volatile ScheduledExecutorService f49423o;
    private static volatile Context ok;

    /* renamed from: p  reason: collision with root package name */
    private static volatile t f49424p;

    /* renamed from: q  reason: collision with root package name */
    private static volatile ok f49425q;
    private static int qu;
    private static final List<kz> qx;

    /* renamed from: r  reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.network.p f49426r;
    private static volatile j rh;

    /* renamed from: s  reason: collision with root package name */
    private static volatile p f49427s;

    /* renamed from: t  reason: collision with root package name */
    private static volatile ExecutorService f49428t;
    private static volatile ExecutorService td;
    private static td tg;
    private static int tr;

    /* renamed from: u  reason: collision with root package name */
    private static volatile ExecutorService f49429u;
    private static volatile ExecutorService ul;
    private static int vk;
    private static volatile x vz;

    /* renamed from: w  reason: collision with root package name */
    private static boolean f49431w;
    private static final int wv;

    /* renamed from: x  reason: collision with root package name */
    private static volatile ExecutorService f49432x;
    private static final int xy;

    /* renamed from: y  reason: collision with root package name */
    private static volatile h f49433y;
    private static boolean yt;

    /* renamed from: z  reason: collision with root package name */
    private static volatile com.ss.android.socialbase.downloader.network.p f49434z;
    private static volatile ExecutorService zz;
    private static volatile List<sg> fb = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    private static volatile boolean f49414g = false;

    /* renamed from: v  reason: collision with root package name */
    private static volatile OkHttpClient f49430v = null;
    private static final List<com.ss.android.socialbase.downloader.depend.z> em = new ArrayList();
    private static boolean sg = false;

    /* loaded from: E:\TSN-r\205dec\6400276.dex */
    public interface ok {

        /* renamed from: com.ss.android.socialbase.downloader.downloader.bl$ok$ok  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\6400276.dex */
        public interface InterfaceC1005ok {
            void ok();
        }

        z a();

        t ok();

        u ok(InterfaceC1005ok interfaceC1005ok);
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        xy = availableProcessors;
        ah = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        f49420l = availableProcessors;
        wv = availableProcessors;
        vk = 8192;
        ej = new ArrayList();
        qx = new ArrayList();
        cs = true;
        f49431w = false;
        cf = false;
    }

    private bl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void a(DownloaderBuilder downloaderBuilder) {
        synchronized (bl.class) {
            bl(downloaderBuilder);
        }
    }

    public static io ah() {
        if (fd == null) {
            synchronized (bl.class) {
                if (fd == null) {
                    fd = new io.ok();
                }
            }
        }
        return fd;
    }

    private static void bl(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                ok(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                ok(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                ok(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                ok(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                ok(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                a(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                ok(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                ok(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                ok(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                bl(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                s(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                n(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                kf(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                h(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                p(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                ok(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                a(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                ok(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                vz = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                vk = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                ok(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                f49414g = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                tr = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                ok(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                fl = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                fd = downloaderBuilder.getTTNetHandler();
                if (fd.ok()) {
                    ok(fd.a());
                    ok(fd.bl());
                } else {
                    ok(p());
                    ok(q());
                }
            }
            a(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                ok(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    private static void cs() {
        if (f49421m == null) {
            f49421m = new DownloadReceiver();
        }
        if (sg) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            ok.registerReceiver(f49421m, intentFilter);
            sg = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static boolean e() {
        return cs;
    }

    public static boolean ej() {
        return cf;
    }

    public static p em() {
        if (f49427s == null) {
            synchronized (bl.class) {
                if (f49427s == null) {
                    f49427s = new com.ss.android.socialbase.downloader.impls.bl();
                }
            }
        }
        return f49427s;
    }

    public static t ep() {
        if (f49415h == null) {
            synchronized (bl.class) {
                if (f49415h == null) {
                    f49415h = new com.ss.android.socialbase.downloader.impls.p();
                }
            }
        }
        return f49415h;
    }

    public static r er() {
        if (bl == null) {
            synchronized (bl.class) {
                if (bl == null) {
                    bl = new com.ss.android.socialbase.downloader.impls.q();
                }
            }
        }
        return bl;
    }

    public static com.ss.android.socialbase.downloader.impls.ok fb() {
        if (kf == null) {
            synchronized (bl.class) {
                if (kf == null) {
                    kf = new com.ss.android.socialbase.downloader.impls.n();
                }
            }
        }
        return kf;
    }

    public static synchronized int fd() {
        int i4;
        synchronized (bl.class) {
            i4 = vk;
        }
        return i4;
    }

    public static void fl() {
        if (TextUtils.isEmpty(com.ss.android.socialbase.downloader.constants.n.bl)) {
            com.ss.android.socialbase.downloader.constants.n.bl = "oppo";
            com.ss.android.socialbase.downloader.constants.n.f49329a = com.ss.android.socialbase.downloader.constants.n.bl.toUpperCase();
        }
    }

    public static int g() {
        return tr;
    }

    public static com.ss.android.socialbase.downloader.s.a h() {
        return kz;
    }

    public static ExecutorService i() {
        if (f49432x == null) {
            synchronized (bl.class) {
                if (f49432x == null) {
                    int i4 = f49420l;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i4, i4, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.p.ok("DownloadThreadPool-mix-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    f49432x = threadPoolExecutor;
                }
            }
        }
        return f49432x;
    }

    public static OkHttpClient.Builder io() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(PolicyConfig.mServerBusyRetryBaseInternal, timeUnit).readTimeout(PolicyConfig.mServerBusyRetryBaseInternal, timeUnit).writeTimeout(PolicyConfig.mServerBusyRetryBaseInternal, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (ul != null) {
            builder.dispatcher(new Dispatcher(ul));
        }
        return builder;
    }

    public static ExecutorService j() {
        if (f49428t == null) {
            synchronized (bl.class) {
                if (f49428t == null) {
                    int i4 = xy;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i4, i4, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.p.ok("DownloadThreadPool-cpu-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    f49428t = threadPoolExecutor;
                }
            }
        }
        return f49428t;
    }

    public static boolean k() {
        return com.ss.android.socialbase.downloader.h.ok.bl().ok("switch_not_auto_boot_service", f49431w ? 1 : 0) > 0;
    }

    public static com.ss.android.socialbase.downloader.network.p kf() {
        return f49426r;
    }

    public static List<com.ss.android.socialbase.downloader.depend.z> kz() {
        return em;
    }

    public static synchronized Context l() {
        Context context;
        synchronized (bl.class) {
            context = ok;
        }
        return context;
    }

    public static k m() {
        if (f49412a == null) {
            synchronized (bl.class) {
                if (f49412a == null) {
                    f49412a = new com.ss.android.socialbase.downloader.impls.s();
                }
            }
        }
        return f49412a;
    }

    public static List<sg> n() {
        List<sg> list;
        synchronized (fb) {
            list = fb;
        }
        return list;
    }

    public static com.ss.android.socialbase.downloader.network.kf o() {
        if (f49413e == null) {
            synchronized (bl.class) {
                if (f49413e == null) {
                    f49413e = new com.ss.android.socialbase.downloader.network.kf() { // from class: com.ss.android.socialbase.downloader.downloader.bl.2
                        @Override // com.ss.android.socialbase.downloader.network.kf
                        public List<InetAddress> ok(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return f49413e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void ok(DownloaderBuilder downloaderBuilder) {
        synchronized (bl.class) {
            if (cf) {
                com.ss.android.socialbase.downloader.bl.ok.n("DownloadComponentManager", "component has init");
                return;
            }
            boolean z3 = f49414g;
            bl(downloaderBuilder);
            if (f49412a == null) {
                f49412a = new com.ss.android.socialbase.downloader.impls.s();
            }
            if (f49415h == null) {
                f49415h = new com.ss.android.socialbase.downloader.impls.p();
            }
            if (f49424p == null && f49425q != null) {
                f49424p = f49425q.ok();
            }
            if (bl == null) {
                bl = new com.ss.android.socialbase.downloader.impls.q();
            }
            if (kf == null) {
                kf = new com.ss.android.socialbase.downloader.impls.n();
            }
            if (f49427s == null) {
                f49427s = new com.ss.android.socialbase.downloader.impls.bl();
            }
            if (f49433y == null) {
                f49433y = new com.ss.android.socialbase.downloader.impls.a();
            }
            if (ep == null) {
                ep = new com.ss.android.socialbase.downloader.impls.k();
            }
            int i4 = qu;
            if (i4 <= 0 || i4 > xy) {
                qu = xy;
            }
            cs();
            if (f49414g && !z3 && !com.ss.android.socialbase.downloader.q.kf.bl()) {
                com.ss.android.socialbase.downloader.impls.j.ok(true).startService();
            } else if (com.ss.android.socialbase.downloader.q.kf.s()) {
                ExecutorService z4 = z();
                if (z4 != null) {
                    z4.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.bl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context l4 = bl.l();
                            if (l4 != null) {
                                com.ss.android.socialbase.downloader.q.kf.s(l4);
                            }
                        }
                    });
                }
            } else {
                Context l4 = l();
                if (l4 != null) {
                    com.ss.android.socialbase.downloader.q.kf.s(l4);
                }
            }
            fl();
            cf = true;
        }
    }

    public static void ok(td tdVar) {
    }

    public static IDownloadHttpService p() {
        if (f49418j == null) {
            synchronized (bl.class) {
                if (f49418j == null) {
                    f49418j = new com.ss.android.socialbase.downloader.impls.h();
                }
            }
        }
        return f49418j;
    }

    public static com.ss.android.socialbase.downloader.network.p q() {
        if (f49434z == null) {
            synchronized (bl.class) {
                if (f49434z == null) {
                    f49434z = new com.ss.android.socialbase.downloader.impls.kf();
                }
            }
        }
        return f49434z;
    }

    public static h qu() {
        if (f49433y == null) {
            synchronized (bl.class) {
                if (f49433y == null) {
                    f49433y = new com.ss.android.socialbase.downloader.impls.a();
                }
            }
        }
        return f49433y;
    }

    public static boolean qx() {
        StringBuilder sb = new StringBuilder();
        sb.append("supportMultiProc::=");
        sb.append(f49425q != null);
        com.ss.android.socialbase.downloader.bl.ok.ok("wjd", sb.toString());
        return f49425q != null;
    }

    public static synchronized x r() {
        x xVar;
        synchronized (bl.class) {
            xVar = vz;
        }
        return xVar;
    }

    public static ExecutorService rh() {
        return td != null ? td : i();
    }

    public static IDownloadHttpService s() {
        return f49419k;
    }

    public static v sg() {
        return f49422n;
    }

    public static ExecutorService t() {
        return zz != null ? zz : i();
    }

    public static ExecutorService td() {
        if (f49429u == null) {
            synchronized (bl.class) {
                if (f49429u == null) {
                    int i4 = wv;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i4, i4, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.p.ok("DownloadThreadPool-db-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    f49429u = threadPoolExecutor;
                }
            }
        }
        return f49429u;
    }

    public static ok tr() {
        return f49425q;
    }

    public static ScheduledExecutorService u() {
        if (f49423o == null) {
            synchronized (bl.class) {
                if (f49423o == null) {
                    f49423o = new ScheduledThreadPoolExecutor(1, new com.ss.android.socialbase.downloader.p.ok("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return f49423o;
    }

    public static com.ss.android.socialbase.downloader.network.kf ul() {
        return fl;
    }

    @NonNull
    public static JSONObject v() {
        if (er != null && er.ok() != null) {
            return er.ok();
        }
        return com.ss.android.socialbase.downloader.constants.n.f49333q;
    }

    @NonNull
    public static com.ss.android.socialbase.downloader.s.bl vk() {
        if (dx == null) {
            dx = new com.ss.android.socialbase.downloader.s.bl() { // from class: com.ss.android.socialbase.downloader.downloader.bl.3
                @Override // com.ss.android.socialbase.downloader.s.bl
                public void a(int i4, String str, JSONObject jSONObject) {
                }

                @Override // com.ss.android.socialbase.downloader.s.bl
                public void ok(int i4, String str, JSONObject jSONObject) {
                }
            };
        }
        return dx;
    }

    public static t vz() {
        if (f49424p == null) {
            synchronized (bl.class) {
                if (f49424p == null) {
                    f49424p = f49425q.ok();
                }
            }
        }
        return f49424p;
    }

    public static synchronized boolean wv() {
        boolean z3;
        synchronized (bl.class) {
            z3 = yt;
        }
        return z3;
    }

    public static ExecutorService x() {
        if (f49417io == null) {
            synchronized (bl.class) {
                if (f49417io == null) {
                    int i4 = ah;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i4, i4, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new com.ss.android.socialbase.downloader.p.ok("DownloadThreadPool-chunk-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    f49417io = threadPoolExecutor;
                }
            }
        }
        return f49417io;
    }

    public static zz xy() {
        if (ep == null) {
            synchronized (bl.class) {
                if (ep == null) {
                    ep = new com.ss.android.socialbase.downloader.impls.k();
                }
            }
        }
        return ep;
    }

    public static synchronized j y() {
        j jVar;
        synchronized (bl.class) {
            jVar = rh;
        }
        return jVar;
    }

    public static td yt() {
        return tg;
    }

    public static ExecutorService z() {
        return f49416i != null ? f49416i : j();
    }

    public static OkHttpClient zz() {
        if (f49430v == null) {
            synchronized (bl.class) {
                if (f49430v == null) {
                    f49430v = io().build();
                }
            }
        }
        return f49430v;
    }

    private static void h(ExecutorService executorService) {
        if (executorService != null) {
            zz = executorService;
        }
    }

    private static void kf(ExecutorService executorService) {
        if (executorService != null) {
            td = executorService;
        }
    }

    private static void s(ExecutorService executorService) {
        if (executorService != null) {
            f49416i = executorService;
        }
    }

    public static synchronized void a() {
        synchronized (bl.class) {
            if (f49414g) {
                return;
            }
            f49414g = true;
            Intent intent = new Intent(l(), DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            l().startService(intent);
            if (!com.ss.android.socialbase.downloader.q.kf.bl()) {
                com.ss.android.socialbase.downloader.impls.j.ok(true).startService();
            }
        }
    }

    private static void n(ExecutorService executorService) {
        if (executorService != null) {
            f49432x = executorService;
        }
    }

    private static void p(ExecutorService executorService) {
        if (executorService != null) {
            f49429u = executorService;
        }
    }

    public static void a(com.ss.android.socialbase.downloader.depend.r rVar) {
        List<com.ss.android.socialbase.downloader.depend.r> list = ej;
        synchronized (list) {
            if (rVar != null) {
                if (list.contains(rVar)) {
                    list.remove(rVar);
                }
            }
        }
    }

    public static void a(DownloadTask downloadTask, int i4) {
        List<kz> list = qx;
        synchronized (list) {
            for (kz kzVar : list) {
                if (kzVar != null) {
                    kzVar.a(downloadTask, i4);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.ss.android.socialbase.downloader.network.h a(java.lang.String r11, java.util.List<com.ss.android.socialbase.downloader.model.bl> r12, int r13, boolean r14, com.ss.android.socialbase.downloader.model.DownloadInfo r15) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r0 = 1
            if (r13 != r0) goto L8
            com.ss.android.socialbase.downloader.network.p r0 = kf()
            goto Lc
        L8:
            com.ss.android.socialbase.downloader.network.p r0 = q()
        Lc:
            if (r0 == 0) goto L49
            r1 = 0
            r9 = 0
            r2 = 0
            if (r14 == 0) goto L18
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
        L18:
            com.ss.android.socialbase.downloader.network.h r12 = r0.ok(r11, r12)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
            if (r14 == 0) goto L2e
            r4 = 0
            long r0 = java.lang.System.currentTimeMillis()
            long r5 = r0 - r2
            java.lang.String r7 = "head"
            r2 = r12
            r3 = r11
            r8 = r13
            r10 = r15
            com.ss.android.socialbase.downloader.s.ok.ok(r2, r3, r4, r5, r7, r8, r9, r10)
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
            com.ss.android.socialbase.downloader.s.ok.ok(r1, r2, r3, r4, r6, r7, r8, r9)
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.bl.a(java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.h");
    }

    public static void a(ExecutorService executorService) {
        if (executorService != null) {
            ul = executorService;
        }
    }

    public static void a(Runnable runnable) {
        a(runnable, false);
    }

    public static void a(Runnable runnable, boolean z3) {
        if (runnable == null) {
            return;
        }
        if (z3 && !com.ss.android.socialbase.downloader.q.kf.s()) {
            runnable.run();
        } else {
            z().execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void ok() {
        synchronized (bl.class) {
            try {
                if (sg && f49421m != null && ok != null) {
                    ok.unregisterReceiver(f49421m);
                    sg = false;
                }
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    private static void a(int i4) {
        if (i4 > 0) {
            qu = i4;
        }
    }

    private static void a(boolean z3) {
        cs = z3;
    }

    public static void ok(sg sgVar) {
        if (sgVar == null) {
            return;
        }
        synchronized (fb) {
            fb.add(sgVar);
        }
    }

    public static void ok(com.ss.android.socialbase.downloader.depend.r rVar) {
        List<com.ss.android.socialbase.downloader.depend.r> list = ej;
        synchronized (list) {
            if (rVar != null) {
                if (!list.contains(rVar)) {
                    list.add(rVar);
                }
            }
        }
    }

    public static void ok(com.ss.android.socialbase.downloader.constants.s sVar) {
        List<com.ss.android.socialbase.downloader.depend.r> list = ej;
        synchronized (list) {
            for (com.ss.android.socialbase.downloader.depend.r rVar : list) {
                if (rVar != null) {
                    if (sVar == com.ss.android.socialbase.downloader.constants.s.SYNC_START) {
                        rVar.ok();
                    } else if (sVar == com.ss.android.socialbase.downloader.constants.s.SYNC_SUCCESS) {
                        rVar.a();
                    }
                }
            }
            if (sVar == com.ss.android.socialbase.downloader.constants.s.SYNC_SUCCESS) {
                ej.clear();
            }
        }
    }

    public static synchronized boolean bl() {
        boolean z3;
        synchronized (bl.class) {
            z3 = f49414g;
        }
        return z3;
    }

    public static void ok(DownloadTask downloadTask, int i4) {
        List<kz> list = qx;
        synchronized (list) {
            for (kz kzVar : list) {
                if (kzVar != null) {
                    kzVar.ok(downloadTask, i4);
                }
            }
        }
    }

    private static void bl(ExecutorService executorService) {
        if (executorService != null) {
            f49428t = executorService;
        }
    }

    public static void bl(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!com.ss.android.socialbase.downloader.q.kf.s()) {
            runnable.run();
        } else {
            td().execute(runnable);
        }
    }

    public static com.ss.android.socialbase.downloader.network.q ok(boolean z3, int i4, String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws Exception {
        return ok(z3, i4, str, null, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.q ok(boolean z3, int i4, String str, String str2, List<com.ss.android.socialbase.downloader.model.bl> list, int i5, boolean z4, DownloadInfo downloadInfo) throws Exception {
        List<com.ss.android.socialbase.downloader.model.bl> list2;
        int i6;
        com.ss.android.socialbase.downloader.network.q ok2;
        if (!TextUtils.isEmpty(str2)) {
            List<com.ss.android.socialbase.downloader.model.bl> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new com.ss.android.socialbase.downloader.model.bl("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i6 = 1;
        } else if (z3) {
            list2 = list;
            i6 = i5;
        } else {
            i6 = 2;
            list2 = list;
        }
        int[] ok3 = ok(i6);
        Exception exc = null;
        for (int i7 : ok3) {
            try {
                ok2 = ok(i4, str, str2, list2, i7, z4, downloadInfo);
            } catch (Exception e4) {
                if (downloadInfo.isExpiredRedownload() && com.ss.android.socialbase.downloader.q.kf.h(e4) && com.ss.android.socialbase.downloader.q.kf.bl(list2)) {
                    com.ss.android.socialbase.downloader.bl.ok.ok("dcach::http exception 304, throw excepiton, not retry " + e4);
                    throw e4;
                }
                exc = e4;
            }
            if (ok2 != null) {
                return ok2;
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
    private static com.ss.android.socialbase.downloader.network.q ok(int r11, java.lang.String r12, java.lang.String r13, java.util.List<com.ss.android.socialbase.downloader.model.bl> r14, int r15, boolean r16, com.ss.android.socialbase.downloader.model.DownloadInfo r17) throws com.ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r7 = r15
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = s()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = p()
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
            com.ss.android.socialbase.downloader.network.q r0 = r0.downloadWithConnection(r11, r12, r14)     // Catch: java.lang.Throwable -> L3b java.io.IOException -> L3d
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
            com.ss.android.socialbase.downloader.s.ok.ok(r1, r2, r3, r4, r6, r7, r8, r9)
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
            com.ss.android.socialbase.downloader.s.ok.ok(r1, r2, r3, r4, r6, r7, r8, r9)
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
        throw new UnsupportedOperationException("Method not decompiled: com.ss.android.socialbase.downloader.downloader.bl.ok(int, java.lang.String, java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.q");
    }

    public static com.ss.android.socialbase.downloader.network.h ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list) throws Exception {
        return ok(str, list, 0, false, null);
    }

    public static com.ss.android.socialbase.downloader.network.h ok(String str, List<com.ss.android.socialbase.downloader.model.bl> list, int i4, boolean z3, DownloadInfo downloadInfo) throws Exception {
        com.ss.android.socialbase.downloader.network.h a4;
        Exception e4 = null;
        for (int i5 : ok(i4)) {
            try {
                a4 = a(str, list, i5, z3, downloadInfo);
            } catch (Exception e5) {
                e4 = e5;
            }
            if (a4 != null) {
                return a4;
            }
        }
        if (e4 == null) {
            return null;
        }
        throw e4;
    }

    private static int[] ok(int i4) {
        return i4 != 1 ? i4 != 2 ? i4 != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    public static synchronized void ok(j jVar) {
        synchronized (bl.class) {
            if (jVar != null) {
                rh = jVar;
                if (f49412a instanceof com.ss.android.socialbase.downloader.impls.s) {
                    ((com.ss.android.socialbase.downloader.impls.s) f49412a).p();
                }
            }
        }
    }

    public static void ok(ExecutorService executorService) {
        if (executorService != null) {
            f49417io = executorService;
        }
    }

    private static void ok(List<com.ss.android.socialbase.downloader.depend.z> list) {
        List<com.ss.android.socialbase.downloader.depend.z> list2 = em;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    public static void ok(boolean z3) {
        f49431w = z3;
    }

    public static void ok(Runnable runnable) {
        ok(runnable, false);
    }

    public static void ok(Runnable runnable, boolean z3) {
        if (runnable == null) {
            return;
        }
        if (z3 && !com.ss.android.socialbase.downloader.q.kf.s()) {
            runnable.run();
        } else {
            j().execute(runnable);
        }
    }

    public static Future ok(Runnable runnable, long j4, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return u().schedule(runnable, j4, timeUnit);
    }

    public static void ok(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            f49419k = iDownloadHttpService;
        }
        yt = f49419k != null;
    }

    public static void ok(com.ss.android.socialbase.downloader.network.p pVar) {
        if (pVar != null) {
            f49426r = pVar;
        }
    }

    private static void ok(k kVar) {
        if (kVar != null) {
            f49412a = kVar;
        }
    }

    private static void ok(r rVar) {
        if (rVar != null) {
            bl = rVar;
        }
    }

    private static void ok(com.ss.android.socialbase.downloader.s.a aVar) {
        if (aVar != null) {
            kz = aVar;
        }
    }

    public static void ok(vz vzVar) {
        er = vzVar;
        com.ss.android.socialbase.downloader.h.ok.ok();
    }

    private static void ok(p pVar) {
        if (pVar != null) {
            f49427s = pVar;
        }
    }

    public static void ok(v vVar) {
        if (vVar != null) {
            f49422n = vVar;
        }
    }

    private static void ok(h hVar) {
        if (hVar != null) {
            f49433y = hVar;
        }
    }

    public static synchronized void ok(Context context) {
        synchronized (bl.class) {
            if (context != null) {
                if (ok == null) {
                    ok = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    com.ss.android.socialbase.downloader.ok.ok.ok().ok(ok);
                }
            }
        }
    }

    public static int ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return ok(taskKey, downloadInfo.getSavePath());
    }

    public static int ok(String str, String str2) {
        r er2 = er();
        if (er2 == null) {
            return 0;
        }
        return er2.ok(str, str2);
    }

    public static void ok(com.ss.android.socialbase.downloader.s.bl blVar) {
        dx = blVar;
    }

    public static void ok(ok okVar) {
        com.ss.android.socialbase.downloader.bl.ok.ok("wjd", "setIndependentServiceCreator::creator=" + okVar);
        f49425q = okVar;
    }
}
