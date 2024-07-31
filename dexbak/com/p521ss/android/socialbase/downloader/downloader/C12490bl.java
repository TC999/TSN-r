package com.p521ss.android.socialbase.downloader.downloader;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.p521ss.android.socialbase.downloader.constants.C12415n;
import com.p521ss.android.socialbase.downloader.constants.EnumC12418s;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12453kz;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12468r;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12471sg;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12480v;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12481vz;
import com.p521ss.android.socialbase.downloader.depend.InterfaceC12484z;
import com.p521ss.android.socialbase.downloader.downloader.InterfaceC12498io;
import com.p521ss.android.socialbase.downloader.impls.AbstractC12547ok;
import com.p521ss.android.socialbase.downloader.impls.C12536a;
import com.p521ss.android.socialbase.downloader.impls.C12537bl;
import com.p521ss.android.socialbase.downloader.impls.C12538h;
import com.p521ss.android.socialbase.downloader.impls.C12542j;
import com.p521ss.android.socialbase.downloader.impls.C12543k;
import com.p521ss.android.socialbase.downloader.impls.C12544kf;
import com.p521ss.android.socialbase.downloader.impls.C12546n;
import com.p521ss.android.socialbase.downloader.impls.C12554p;
import com.p521ss.android.socialbase.downloader.impls.C12555q;
import com.p521ss.android.socialbase.downloader.impls.C12558s;
import com.p521ss.android.socialbase.downloader.impls.DownloadHandleService;
import com.p521ss.android.socialbase.downloader.model.C12601bl;
import com.p521ss.android.socialbase.downloader.model.DownloadInfo;
import com.p521ss.android.socialbase.downloader.model.DownloadTask;
import com.p521ss.android.socialbase.downloader.network.IDownloadHttpService;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12620h;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12623kf;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12634p;
import com.p521ss.android.socialbase.downloader.network.InterfaceC12635q;
import com.p521ss.android.socialbase.downloader.p549bl.C12409ok;
import com.p521ss.android.socialbase.downloader.p550h.C12534ok;
import com.p521ss.android.socialbase.downloader.p554ok.C12646ok;
import com.p521ss.android.socialbase.downloader.p555p.ThreadFactoryC12662ok;
import com.p521ss.android.socialbase.downloader.p556q.C12713kf;
import com.p521ss.android.socialbase.downloader.p557s.InterfaceC12721a;
import com.p521ss.android.socialbase.downloader.p557s.InterfaceC12722bl;
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

/* renamed from: com.ss.android.socialbase.downloader.downloader.bl */
/* loaded from: E:\fuckcool\tsn\6400276.dex */
public class C12490bl {

    /* renamed from: a */
    private static volatile InterfaceC12501k f35060a;

    /* renamed from: ah */
    private static final int f35061ah;

    /* renamed from: bl */
    private static volatile InterfaceC12513r f35062bl;

    /* renamed from: cf */
    private static volatile boolean f35063cf;

    /* renamed from: cs */
    private static boolean f35064cs;

    /* renamed from: dx */
    private static InterfaceC12722bl f35065dx;

    /* renamed from: e */
    private static volatile InterfaceC12623kf f35066e;

    /* renamed from: ej */
    private static final List<InterfaceC12468r> f35067ej;

    /* renamed from: ep */
    private static volatile InterfaceC12523zz f35069ep;

    /* renamed from: er */
    private static volatile InterfaceC12481vz f35070er;

    /* renamed from: fd */
    private static volatile InterfaceC12498io f35072fd;

    /* renamed from: fl */
    private static volatile InterfaceC12623kf f35073fl;

    /* renamed from: h */
    private static volatile InterfaceC12517t f35075h;

    /* renamed from: i */
    private static volatile ExecutorService f35076i;

    /* renamed from: io */
    private static volatile ExecutorService f35077io;

    /* renamed from: j */
    private static volatile IDownloadHttpService f35078j;

    /* renamed from: k */
    private static volatile IDownloadHttpService f35079k;

    /* renamed from: kf */
    private static volatile AbstractC12547ok f35080kf;

    /* renamed from: kz */
    private static volatile InterfaceC12721a f35081kz;

    /* renamed from: l */
    private static final int f35082l;

    /* renamed from: m */
    private static volatile DownloadReceiver f35083m;

    /* renamed from: n */
    private static volatile InterfaceC12480v f35084n;

    /* renamed from: o */
    private static volatile ScheduledExecutorService f35085o;

    /* renamed from: ok */
    private static volatile Context f35086ok;

    /* renamed from: p */
    private static volatile InterfaceC12517t f35087p;

    /* renamed from: q */
    private static volatile InterfaceC12494ok f35088q;

    /* renamed from: qu */
    private static int f35089qu;

    /* renamed from: qx */
    private static final List<InterfaceC12453kz> f35090qx;

    /* renamed from: r */
    private static volatile InterfaceC12634p f35091r;

    /* renamed from: rh */
    private static volatile InterfaceC12500j f35092rh;

    /* renamed from: s */
    private static volatile InterfaceC12509p f35093s;

    /* renamed from: t */
    private static volatile ExecutorService f35095t;

    /* renamed from: td */
    private static volatile ExecutorService f35096td;

    /* renamed from: tg */
    private static InterfaceC12518td f35097tg;

    /* renamed from: tr */
    private static int f35098tr;

    /* renamed from: u */
    private static volatile ExecutorService f35099u;

    /* renamed from: ul */
    private static volatile ExecutorService f35100ul;

    /* renamed from: vk */
    private static int f35102vk;

    /* renamed from: vz */
    private static volatile InterfaceC12521x f35103vz;

    /* renamed from: w */
    private static boolean f35104w;

    /* renamed from: wv */
    private static final int f35105wv;

    /* renamed from: x */
    private static volatile ExecutorService f35106x;

    /* renamed from: xy */
    private static final int f35107xy;

    /* renamed from: y */
    private static volatile InterfaceC12496h f35108y;

    /* renamed from: yt */
    private static boolean f35109yt;

    /* renamed from: z */
    private static volatile InterfaceC12634p f35110z;

    /* renamed from: zz */
    private static volatile ExecutorService f35111zz;

    /* renamed from: fb */
    private static volatile List<InterfaceC12471sg> f35071fb = new ArrayList();

    /* renamed from: g */
    private static volatile boolean f35074g = false;

    /* renamed from: v */
    private static volatile OkHttpClient f35101v = null;

    /* renamed from: em */
    private static final List<InterfaceC12484z> f35068em = new ArrayList();

    /* renamed from: sg */
    private static boolean f35094sg = false;

    /* renamed from: com.ss.android.socialbase.downloader.downloader.bl$ok */
    /* loaded from: E:\fuckcool\tsn\6400276.dex */
    public interface InterfaceC12494ok {

        /* renamed from: com.ss.android.socialbase.downloader.downloader.bl$ok$ok */
        /* loaded from: E:\fuckcool\tsn\6400276.dex */
        public interface InterfaceC12495ok {
            /* renamed from: ok */
            void mo17474ok();
        }

        /* renamed from: a */
        InterfaceC12522z mo17625a();

        /* renamed from: ok */
        InterfaceC12517t mo17624ok();

        /* renamed from: ok */
        InterfaceC12519u mo17623ok(InterfaceC12495ok interfaceC12495ok);
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors() + 1;
        f35107xy = availableProcessors;
        f35061ah = (Runtime.getRuntime().availableProcessors() * 2) + 1;
        f35082l = availableProcessors;
        f35105wv = availableProcessors;
        f35102vk = 8192;
        f35067ej = new ArrayList();
        f35090qx = new ArrayList();
        f35064cs = true;
        f35104w = false;
        f35063cf = false;
    }

    private C12490bl() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: a */
    public static synchronized void m17838a(DownloaderBuilder downloaderBuilder) {
        synchronized (C12490bl.class) {
            m17829bl(downloaderBuilder);
        }
    }

    /* renamed from: ah */
    public static InterfaceC12498io m17831ah() {
        if (f35072fd == null) {
            synchronized (C12490bl.class) {
                if (f35072fd == null) {
                    f35072fd = new InterfaceC12498io.C12499ok();
                }
            }
        }
        return f35072fd;
    }

    /* renamed from: bl */
    private static void m17829bl(DownloaderBuilder downloaderBuilder) {
        if (downloaderBuilder != null) {
            if (downloaderBuilder.getContext() != null) {
                m17799ok(downloaderBuilder.getContext());
            }
            if (downloaderBuilder.getDownloadCache() != null) {
                m17789ok(downloaderBuilder.getDownloadCache());
            }
            if (downloaderBuilder.getIdGenerator() != null) {
                m17787ok(downloaderBuilder.getIdGenerator());
            }
            if (downloaderBuilder.getChunkCntCalculator() != null) {
                m17788ok(downloaderBuilder.getChunkCntCalculator());
            }
            if (downloaderBuilder.getNotificationClickCallback() != null) {
                m17795ok(downloaderBuilder.getNotificationClickCallback());
            }
            if (downloaderBuilder.getMaxDownloadPoolSize() != 0) {
                m17840a(downloaderBuilder.getMaxDownloadPoolSize());
            }
            if (downloaderBuilder.getHttpService() != null) {
                m17783ok(downloaderBuilder.getHttpService());
            }
            if (downloaderBuilder.getHeadHttpService() != null) {
                m17782ok(downloaderBuilder.getHeadHttpService());
            }
            if (downloaderBuilder.getDownloadLaunchHandler() != null) {
                m17790ok(downloaderBuilder.getDownloadLaunchHandler());
            }
            if (downloaderBuilder.getCPUThreadExecutor() != null) {
                m17827bl(downloaderBuilder.getCPUThreadExecutor());
            }
            if (downloaderBuilder.getIOThreadExecutor() != null) {
                m17760s(downloaderBuilder.getIOThreadExecutor());
            }
            if (downloaderBuilder.getMixDefaultDownloadExecutor() != null) {
                m17804n(downloaderBuilder.getMixDefaultDownloadExecutor());
            }
            if (downloaderBuilder.getMixFrequentDownloadExecutor() != null) {
                m17809kf(downloaderBuilder.getMixFrequentDownloadExecutor());
            }
            if (downloaderBuilder.getMixApkDownloadExecutor() != null) {
                m17815h(downloaderBuilder.getMixApkDownloadExecutor());
            }
            if (downloaderBuilder.getDBThreadExecutor() != null) {
                m17767p(downloaderBuilder.getDBThreadExecutor());
            }
            if (downloaderBuilder.getChunkThreadExecutor() != null) {
                m17772ok(downloaderBuilder.getChunkThreadExecutor());
            }
            if (downloaderBuilder.getOkHttpDispatcherExecutor() != null) {
                m17833a(downloaderBuilder.getOkHttpDispatcherExecutor());
            }
            if (!downloaderBuilder.getDownloadCompleteHandlers().isEmpty()) {
                m17773ok(downloaderBuilder.getDownloadCompleteHandlers());
            }
            if (downloaderBuilder.getMonitorConfig() != null) {
                f35103vz = downloaderBuilder.getMonitorConfig();
            }
            if (downloaderBuilder.getWriteBufferSize() > 1024) {
                f35102vk = downloaderBuilder.getWriteBufferSize();
            }
            if (downloaderBuilder.getChunkAdjustCalculator() != null) {
                m17791ok(downloaderBuilder.getChunkAdjustCalculator());
            }
            if (downloaderBuilder.isDownloadInMultiProcess()) {
                f35074g = true;
            }
            if (downloaderBuilder.getDownloadExpSwitch() != 0) {
                f35098tr = downloaderBuilder.getDownloadExpSwitch();
            }
            if (downloaderBuilder.getDownloadSetting() != null) {
                m17794ok(downloaderBuilder.getDownloadSetting());
            }
            if (downloaderBuilder.getDownloadDns() != null) {
                f35073fl = downloaderBuilder.getDownloadDns();
            }
            if (downloaderBuilder.getTTNetHandler() != null) {
                f35072fd = downloaderBuilder.getTTNetHandler();
                if (f35072fd.mo17740ok()) {
                    m17783ok(f35072fd.mo17742a());
                    m17782ok(f35072fd.mo17741bl());
                } else {
                    m17783ok(m17768p());
                    m17782ok(m17766q());
                }
            }
            m17832a(downloaderBuilder.needAutoRefreshUnSuccessTask());
            if (downloaderBuilder.getDownloadMonitorListener() != null) {
                m17781ok(downloaderBuilder.getDownloadMonitorListener());
            }
        }
    }

    /* renamed from: cs */
    private static void m17826cs() {
        if (f35083m == null) {
            f35083m = new DownloadReceiver();
        }
        if (f35094sg) {
            return;
        }
        try {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            f35086ok.registerReceiver(f35083m, intentFilter);
            f35094sg = true;
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    /* renamed from: e */
    public static boolean m17825e() {
        return f35064cs;
    }

    /* renamed from: ej */
    public static boolean m17824ej() {
        return f35063cf;
    }

    /* renamed from: em */
    public static InterfaceC12509p m17823em() {
        if (f35093s == null) {
            synchronized (C12490bl.class) {
                if (f35093s == null) {
                    f35093s = new C12537bl();
                }
            }
        }
        return f35093s;
    }

    /* renamed from: ep */
    public static InterfaceC12517t m17822ep() {
        if (f35075h == null) {
            synchronized (C12490bl.class) {
                if (f35075h == null) {
                    f35075h = new C12554p();
                }
            }
        }
        return f35075h;
    }

    /* renamed from: er */
    public static InterfaceC12513r m17821er() {
        if (f35062bl == null) {
            synchronized (C12490bl.class) {
                if (f35062bl == null) {
                    f35062bl = new C12555q();
                }
            }
        }
        return f35062bl;
    }

    /* renamed from: fb */
    public static AbstractC12547ok m17820fb() {
        if (f35080kf == null) {
            synchronized (C12490bl.class) {
                if (f35080kf == null) {
                    f35080kf = new C12546n();
                }
            }
        }
        return f35080kf;
    }

    /* renamed from: fd */
    public static synchronized int m17819fd() {
        int i;
        synchronized (C12490bl.class) {
            i = f35102vk;
        }
        return i;
    }

    /* renamed from: fl */
    public static void m17818fl() {
        if (TextUtils.isEmpty(C12415n.f34986bl)) {
            C12415n.f34986bl = "oppo";
            C12415n.f34985a = C12415n.f34986bl.toUpperCase();
        }
    }

    /* renamed from: g */
    public static int m17817g() {
        return f35098tr;
    }

    /* renamed from: h */
    public static InterfaceC12721a m17816h() {
        return f35081kz;
    }

    /* renamed from: i */
    public static ExecutorService m17814i() {
        if (f35106x == null) {
            synchronized (C12490bl.class) {
                if (f35106x == null) {
                    int i = f35082l;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC12662ok("DownloadThreadPool-mix-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    f35106x = threadPoolExecutor;
                }
            }
        }
        return f35106x;
    }

    /* renamed from: io */
    public static OkHttpClient.Builder m17813io() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        builder.connectTimeout(30000L, timeUnit).readTimeout(30000L, timeUnit).writeTimeout(30000L, timeUnit).retryOnConnectionFailure(true).followRedirects(true).protocols(Collections.singletonList(Protocol.HTTP_1_1));
        if (f35100ul != null) {
            builder.dispatcher(new Dispatcher(f35100ul));
        }
        return builder;
    }

    /* renamed from: j */
    public static ExecutorService m17812j() {
        if (f35095t == null) {
            synchronized (C12490bl.class) {
                if (f35095t == null) {
                    int i = f35107xy;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC12662ok("DownloadThreadPool-cpu-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    f35095t = threadPoolExecutor;
                }
            }
        }
        return f35095t;
    }

    /* renamed from: k */
    public static boolean m17811k() {
        return C12534ok.m17605bl().m17593ok("switch_not_auto_boot_service", f35104w ? 1 : 0) > 0;
    }

    /* renamed from: kf */
    public static InterfaceC12634p m17810kf() {
        return f35091r;
    }

    /* renamed from: kz */
    public static List<InterfaceC12484z> m17808kz() {
        return f35068em;
    }

    /* renamed from: l */
    public static synchronized Context m17807l() {
        Context context;
        synchronized (C12490bl.class) {
            context = f35086ok;
        }
        return context;
    }

    /* renamed from: m */
    public static InterfaceC12501k m17806m() {
        if (f35060a == null) {
            synchronized (C12490bl.class) {
                if (f35060a == null) {
                    f35060a = new C12558s();
                }
            }
        }
        return f35060a;
    }

    /* renamed from: n */
    public static List<InterfaceC12471sg> m17805n() {
        List<InterfaceC12471sg> list;
        synchronized (f35071fb) {
            list = f35071fb;
        }
        return list;
    }

    /* renamed from: o */
    public static InterfaceC12623kf m17803o() {
        if (f35066e == null) {
            synchronized (C12490bl.class) {
                if (f35066e == null) {
                    f35066e = new InterfaceC12623kf() { // from class: com.ss.android.socialbase.downloader.downloader.bl.2
                        @Override // com.p521ss.android.socialbase.downloader.network.InterfaceC12623kf
                        /* renamed from: ok */
                        public List<InetAddress> mo16945ok(String str) throws UnknownHostException {
                            return Dns.SYSTEM.lookup(str);
                        }
                    };
                }
            }
        }
        return f35066e;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public static synchronized void m17793ok(DownloaderBuilder downloaderBuilder) {
        synchronized (C12490bl.class) {
            if (f35063cf) {
                C12409ok.m17900n("DownloadComponentManager", "component has init");
                return;
            }
            boolean z = f35074g;
            m17829bl(downloaderBuilder);
            if (f35060a == null) {
                f35060a = new C12558s();
            }
            if (f35075h == null) {
                f35075h = new C12554p();
            }
            if (f35087p == null && f35088q != null) {
                f35087p = f35088q.mo17624ok();
            }
            if (f35062bl == null) {
                f35062bl = new C12555q();
            }
            if (f35080kf == null) {
                f35080kf = new C12546n();
            }
            if (f35093s == null) {
                f35093s = new C12537bl();
            }
            if (f35108y == null) {
                f35108y = new C12536a();
            }
            if (f35069ep == null) {
                f35069ep = new C12543k();
            }
            int i = f35089qu;
            if (i <= 0 || i > f35107xy) {
                f35089qu = f35107xy;
            }
            m17826cs();
            if (f35074g && !z && !C12713kf.m16605bl()) {
                C12542j.m17583ok(true).startService();
            } else if (C12713kf.m16522s()) {
                ExecutorService m17745z = m17745z();
                if (m17745z != null) {
                    m17745z.execute(new Runnable() { // from class: com.ss.android.socialbase.downloader.downloader.bl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            Context m17807l = C12490bl.m17807l();
                            if (m17807l != null) {
                                C12713kf.m16520s(m17807l);
                            }
                        }
                    });
                }
            } else {
                Context m17807l = m17807l();
                if (m17807l != null) {
                    C12713kf.m16520s(m17807l);
                }
            }
            m17818fl();
            f35063cf = true;
        }
    }

    /* renamed from: ok */
    public static void m17786ok(InterfaceC12518td interfaceC12518td) {
    }

    /* renamed from: p */
    public static IDownloadHttpService m17768p() {
        if (f35078j == null) {
            synchronized (C12490bl.class) {
                if (f35078j == null) {
                    f35078j = new C12538h();
                }
            }
        }
        return f35078j;
    }

    /* renamed from: q */
    public static InterfaceC12634p m17766q() {
        if (f35110z == null) {
            synchronized (C12490bl.class) {
                if (f35110z == null) {
                    f35110z = new C12544kf();
                }
            }
        }
        return f35110z;
    }

    /* renamed from: qu */
    public static InterfaceC12496h m17765qu() {
        if (f35108y == null) {
            synchronized (C12490bl.class) {
                if (f35108y == null) {
                    f35108y = new C12536a();
                }
            }
        }
        return f35108y;
    }

    /* renamed from: qx */
    public static boolean m17764qx() {
        StringBuilder sb = new StringBuilder();
        sb.append("supportMultiProc::=");
        sb.append(f35088q != null);
        C12409ok.m17896ok("wjd", sb.toString());
        return f35088q != null;
    }

    /* renamed from: r */
    public static synchronized InterfaceC12521x m17763r() {
        InterfaceC12521x interfaceC12521x;
        synchronized (C12490bl.class) {
            interfaceC12521x = f35103vz;
        }
        return interfaceC12521x;
    }

    /* renamed from: rh */
    public static ExecutorService m17762rh() {
        return f35096td != null ? f35096td : m17814i();
    }

    /* renamed from: s */
    public static IDownloadHttpService m17761s() {
        return f35079k;
    }

    /* renamed from: sg */
    public static InterfaceC12480v m17759sg() {
        return f35084n;
    }

    /* renamed from: t */
    public static ExecutorService m17758t() {
        return f35111zz != null ? f35111zz : m17814i();
    }

    /* renamed from: td */
    public static ExecutorService m17757td() {
        if (f35099u == null) {
            synchronized (C12490bl.class) {
                if (f35099u == null) {
                    int i = f35105wv;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC12662ok("DownloadThreadPool-db-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    f35099u = threadPoolExecutor;
                }
            }
        }
        return f35099u;
    }

    /* renamed from: tr */
    public static InterfaceC12494ok m17756tr() {
        return f35088q;
    }

    /* renamed from: u */
    public static ScheduledExecutorService m17755u() {
        if (f35085o == null) {
            synchronized (C12490bl.class) {
                if (f35085o == null) {
                    f35085o = new ScheduledThreadPoolExecutor(1, new ThreadFactoryC12662ok("DownloadThreadPool-Schedule", true));
                }
            }
        }
        return f35085o;
    }

    /* renamed from: ul */
    public static InterfaceC12623kf m17754ul() {
        return f35073fl;
    }

    @NonNull
    /* renamed from: v */
    public static JSONObject m17753v() {
        if (f35070er != null && f35070er.mo17845ok() != null) {
            return f35070er.mo17845ok();
        }
        return C12415n.f34992q;
    }

    @NonNull
    /* renamed from: vk */
    public static InterfaceC12722bl m17752vk() {
        if (f35065dx == null) {
            f35065dx = new InterfaceC12722bl() { // from class: com.ss.android.socialbase.downloader.downloader.bl.3
                @Override // com.p521ss.android.socialbase.downloader.p557s.InterfaceC12722bl
                /* renamed from: a */
                public void mo16495a(int i, String str, JSONObject jSONObject) {
                }

                @Override // com.p521ss.android.socialbase.downloader.p557s.InterfaceC12722bl
                /* renamed from: ok */
                public void mo16494ok(int i, String str, JSONObject jSONObject) {
                }
            };
        }
        return f35065dx;
    }

    /* renamed from: vz */
    public static InterfaceC12517t m17751vz() {
        if (f35087p == null) {
            synchronized (C12490bl.class) {
                if (f35087p == null) {
                    f35087p = f35088q.mo17624ok();
                }
            }
        }
        return f35087p;
    }

    /* renamed from: wv */
    public static synchronized boolean m17750wv() {
        boolean z;
        synchronized (C12490bl.class) {
            z = f35109yt;
        }
        return z;
    }

    /* renamed from: x */
    public static ExecutorService m17749x() {
        if (f35077io == null) {
            synchronized (C12490bl.class) {
                if (f35077io == null) {
                    int i = f35061ah;
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 15L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC12662ok("DownloadThreadPool-chunk-fixed", true));
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    f35077io = threadPoolExecutor;
                }
            }
        }
        return f35077io;
    }

    /* renamed from: xy */
    public static InterfaceC12523zz m17748xy() {
        if (f35069ep == null) {
            synchronized (C12490bl.class) {
                if (f35069ep == null) {
                    f35069ep = new C12543k();
                }
            }
        }
        return f35069ep;
    }

    /* renamed from: y */
    public static synchronized InterfaceC12500j m17747y() {
        InterfaceC12500j interfaceC12500j;
        synchronized (C12490bl.class) {
            interfaceC12500j = f35092rh;
        }
        return interfaceC12500j;
    }

    /* renamed from: yt */
    public static InterfaceC12518td m17746yt() {
        return f35097tg;
    }

    /* renamed from: z */
    public static ExecutorService m17745z() {
        return f35076i != null ? f35076i : m17812j();
    }

    /* renamed from: zz */
    public static OkHttpClient m17744zz() {
        if (f35101v == null) {
            synchronized (C12490bl.class) {
                if (f35101v == null) {
                    f35101v = m17813io().build();
                }
            }
        }
        return f35101v;
    }

    /* renamed from: h */
    private static void m17815h(ExecutorService executorService) {
        if (executorService != null) {
            f35111zz = executorService;
        }
    }

    /* renamed from: kf */
    private static void m17809kf(ExecutorService executorService) {
        if (executorService != null) {
            f35096td = executorService;
        }
    }

    /* renamed from: s */
    private static void m17760s(ExecutorService executorService) {
        if (executorService != null) {
            f35076i = executorService;
        }
    }

    /* renamed from: a */
    public static synchronized void m17841a() {
        synchronized (C12490bl.class) {
            if (f35074g) {
                return;
            }
            f35074g = true;
            Intent intent = new Intent(m17807l(), DownloadHandleService.class);
            intent.setAction("com.ss.android.downloader.action.MULTI_PROCESS_NOTIFY");
            m17807l().startService(intent);
            if (!C12713kf.m16605bl()) {
                C12542j.m17583ok(true).startService();
            }
        }
    }

    /* renamed from: n */
    private static void m17804n(ExecutorService executorService) {
        if (executorService != null) {
            f35106x = executorService;
        }
    }

    /* renamed from: p */
    private static void m17767p(ExecutorService executorService) {
        if (executorService != null) {
            f35099u = executorService;
        }
    }

    /* renamed from: a */
    public static void m17839a(InterfaceC12468r interfaceC12468r) {
        List<InterfaceC12468r> list = f35067ej;
        synchronized (list) {
            if (interfaceC12468r != null) {
                if (list.contains(interfaceC12468r)) {
                    list.remove(interfaceC12468r);
                }
            }
        }
    }

    /* renamed from: a */
    public static void m17837a(DownloadTask downloadTask, int i) {
        List<InterfaceC12453kz> list = f35090qx;
        synchronized (list) {
            for (InterfaceC12453kz interfaceC12453kz : list) {
                if (interfaceC12453kz != null) {
                    interfaceC12453kz.m17865a(downloadTask, i);
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0039  */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.p521ss.android.socialbase.downloader.network.InterfaceC12620h m17834a(java.lang.String r11, java.util.List<com.p521ss.android.socialbase.downloader.model.C12601bl> r12, int r13, boolean r14, com.p521ss.android.socialbase.downloader.model.DownloadInfo r15) throws com.p521ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r0 = 1
            if (r13 != r0) goto L8
            com.ss.android.socialbase.downloader.network.p r0 = m17810kf()
            goto Lc
        L8:
            com.ss.android.socialbase.downloader.network.p r0 = m17766q()
        Lc:
            if (r0 == 0) goto L49
            r1 = 0
            r9 = 0
            r2 = 0
            if (r14 == 0) goto L18
            long r2 = java.lang.System.currentTimeMillis()     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
        L18:
            com.ss.android.socialbase.downloader.network.h r12 = r0.mo16910ok(r11, r12)     // Catch: java.lang.Throwable -> L2f java.io.IOException -> L32
            if (r14 == 0) goto L2e
            r4 = 0
            long r0 = java.lang.System.currentTimeMillis()
            long r5 = r0 - r2
            java.lang.String r7 = "head"
            r2 = r12
            r3 = r11
            r8 = r13
            r10 = r15
            com.p521ss.android.socialbase.downloader.p557s.C12723ok.m16487ok(r2, r3, r4, r5, r7, r8, r9, r10)
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
            com.p521ss.android.socialbase.downloader.p557s.C12723ok.m16487ok(r1, r2, r3, r4, r6, r7, r8, r9)
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
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.downloader.C12490bl.m17834a(java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.h");
    }

    /* renamed from: a */
    public static void m17833a(ExecutorService executorService) {
        if (executorService != null) {
            f35100ul = executorService;
        }
    }

    /* renamed from: a */
    public static void m17836a(Runnable runnable) {
        m17835a(runnable, false);
    }

    /* renamed from: a */
    public static void m17835a(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !C12713kf.m16522s()) {
            runnable.run();
        } else {
            m17745z().execute(runnable);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: ok */
    public static synchronized void m17802ok() {
        synchronized (C12490bl.class) {
            try {
                if (f35094sg && f35083m != null && f35086ok != null) {
                    f35086ok.unregisterReceiver(f35083m);
                    f35094sg = false;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m17840a(int i) {
        if (i > 0) {
            f35089qu = i;
        }
    }

    /* renamed from: a */
    private static void m17832a(boolean z) {
        f35064cs = z;
    }

    /* renamed from: ok */
    public static void m17796ok(InterfaceC12471sg interfaceC12471sg) {
        if (interfaceC12471sg == null) {
            return;
        }
        synchronized (f35071fb) {
            f35071fb.add(interfaceC12471sg);
        }
    }

    /* renamed from: ok */
    public static void m17797ok(InterfaceC12468r interfaceC12468r) {
        List<InterfaceC12468r> list = f35067ej;
        synchronized (list) {
            if (interfaceC12468r != null) {
                if (!list.contains(interfaceC12468r)) {
                    list.add(interfaceC12468r);
                }
            }
        }
    }

    /* renamed from: ok */
    public static void m17798ok(EnumC12418s enumC12418s) {
        List<InterfaceC12468r> list = f35067ej;
        synchronized (list) {
            for (InterfaceC12468r interfaceC12468r : list) {
                if (interfaceC12468r != null) {
                    if (enumC12418s == EnumC12418s.SYNC_START) {
                        interfaceC12468r.mo17854ok();
                    } else if (enumC12418s == EnumC12418s.SYNC_SUCCESS) {
                        interfaceC12468r.mo17855a();
                    }
                }
            }
            if (enumC12418s == EnumC12418s.SYNC_SUCCESS) {
                f35067ej.clear();
            }
        }
    }

    /* renamed from: bl */
    public static synchronized boolean m17830bl() {
        boolean z;
        synchronized (C12490bl.class) {
            z = f35074g;
        }
        return z;
    }

    /* renamed from: ok */
    public static void m17784ok(DownloadTask downloadTask, int i) {
        List<InterfaceC12453kz> list = f35090qx;
        synchronized (list) {
            for (InterfaceC12453kz interfaceC12453kz : list) {
                if (interfaceC12453kz != null) {
                    interfaceC12453kz.m17864ok(downloadTask, i);
                }
            }
        }
    }

    /* renamed from: bl */
    private static void m17827bl(ExecutorService executorService) {
        if (executorService != null) {
            f35095t = executorService;
        }
    }

    /* renamed from: bl */
    public static void m17828bl(Runnable runnable) {
        if (runnable == null) {
            return;
        }
        if (!C12713kf.m16522s()) {
            runnable.run();
        } else {
            m17757td().execute(runnable);
        }
    }

    /* renamed from: ok */
    public static InterfaceC12635q m17769ok(boolean z, int i, String str, List<C12601bl> list) throws Exception {
        return m17770ok(z, i, str, null, list, 0, false, null);
    }

    /* renamed from: ok */
    public static InterfaceC12635q m17770ok(boolean z, int i, String str, String str2, List<C12601bl> list, int i2, boolean z2, DownloadInfo downloadInfo) throws Exception {
        List<C12601bl> list2;
        int i3;
        InterfaceC12635q m17800ok;
        if (!TextUtils.isEmpty(str2)) {
            List<C12601bl> arrayList = list == null ? new ArrayList<>() : list;
            arrayList.add(new C12601bl("ss_d_request_host_ip_114", str2));
            list2 = arrayList;
            i3 = 1;
        } else if (z) {
            list2 = list;
            i3 = i2;
        } else {
            i3 = 2;
            list2 = list;
        }
        int[] m17801ok = m17801ok(i3);
        Exception exc = null;
        for (int i4 : m17801ok) {
            try {
                m17800ok = m17800ok(i, str, str2, list2, i4, z2, downloadInfo);
            } catch (Exception e) {
                if (downloadInfo.isExpiredRedownload() && C12713kf.m16590h(e) && C12713kf.m16593bl(list2)) {
                    C12409ok.m17897ok("dcach::http exception 304, throw excepiton, not retry " + e);
                    throw e;
                }
                exc = e;
            }
            if (m17800ok != null) {
                return m17800ok;
            }
        }
        if (exc == null) {
            return null;
        }
        throw exc;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0044  */
    /* renamed from: ok */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static com.p521ss.android.socialbase.downloader.network.InterfaceC12635q m17800ok(int r11, java.lang.String r12, java.lang.String r13, java.util.List<com.p521ss.android.socialbase.downloader.model.C12601bl> r14, int r15, boolean r16, com.p521ss.android.socialbase.downloader.model.DownloadInfo r17) throws com.p521ss.android.socialbase.downloader.exception.BaseException, java.io.IOException {
        /*
            r7 = r15
            r0 = 1
            if (r7 != r0) goto L9
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = m17761s()
            goto Ld
        L9:
            com.ss.android.socialbase.downloader.network.IDownloadHttpService r0 = m17768p()
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
            com.p521ss.android.socialbase.downloader.p557s.C12723ok.m16487ok(r1, r2, r3, r4, r6, r7, r8, r9)
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
            com.p521ss.android.socialbase.downloader.p557s.C12723ok.m16487ok(r1, r2, r3, r4, r6, r7, r8, r9)
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
        throw new UnsupportedOperationException("Method not decompiled: com.p521ss.android.socialbase.downloader.downloader.C12490bl.m17800ok(int, java.lang.String, java.lang.String, java.util.List, int, boolean, com.ss.android.socialbase.downloader.model.DownloadInfo):com.ss.android.socialbase.downloader.network.q");
    }

    /* renamed from: ok */
    public static InterfaceC12620h m17775ok(String str, List<C12601bl> list) throws Exception {
        return m17774ok(str, list, 0, false, null);
    }

    /* renamed from: ok */
    public static InterfaceC12620h m17774ok(String str, List<C12601bl> list, int i, boolean z, DownloadInfo downloadInfo) throws Exception {
        InterfaceC12620h m17834a;
        Exception e = null;
        for (int i2 : m17801ok(i)) {
            try {
                m17834a = m17834a(str, list, i2, z, downloadInfo);
            } catch (Exception e2) {
                e = e2;
            }
            if (m17834a != null) {
                return m17834a;
            }
        }
        if (e == null) {
            return null;
        }
        throw e;
    }

    /* renamed from: ok */
    private static int[] m17801ok(int i) {
        return i != 1 ? i != 2 ? i != 3 ? new int[]{1, 0} : new int[]{0, 1} : new int[]{1} : new int[]{0};
    }

    /* renamed from: ok */
    public static synchronized void m17790ok(InterfaceC12500j interfaceC12500j) {
        synchronized (C12490bl.class) {
            if (interfaceC12500j != null) {
                f35092rh = interfaceC12500j;
                if (f35060a instanceof C12558s) {
                    ((C12558s) f35060a).m17484p();
                }
            }
        }
    }

    /* renamed from: ok */
    public static void m17772ok(ExecutorService executorService) {
        if (executorService != null) {
            f35077io = executorService;
        }
    }

    /* renamed from: ok */
    private static void m17773ok(List<InterfaceC12484z> list) {
        List<InterfaceC12484z> list2 = f35068em;
        if (list2.isEmpty()) {
            synchronized (list2) {
                list2.addAll(list);
            }
        }
    }

    /* renamed from: ok */
    public static void m17771ok(boolean z) {
        f35104w = z;
    }

    /* renamed from: ok */
    public static void m17779ok(Runnable runnable) {
        m17777ok(runnable, false);
    }

    /* renamed from: ok */
    public static void m17777ok(Runnable runnable, boolean z) {
        if (runnable == null) {
            return;
        }
        if (z && !C12713kf.m16522s()) {
            runnable.run();
        } else {
            m17812j().execute(runnable);
        }
    }

    /* renamed from: ok */
    public static Future m17778ok(Runnable runnable, long j, TimeUnit timeUnit) {
        if (runnable == null) {
            return null;
        }
        return m17755u().schedule(runnable, j, timeUnit);
    }

    /* renamed from: ok */
    public static void m17783ok(IDownloadHttpService iDownloadHttpService) {
        if (iDownloadHttpService != null) {
            f35079k = iDownloadHttpService;
        }
        f35109yt = f35079k != null;
    }

    /* renamed from: ok */
    public static void m17782ok(InterfaceC12634p interfaceC12634p) {
        if (interfaceC12634p != null) {
            f35091r = interfaceC12634p;
        }
    }

    /* renamed from: ok */
    private static void m17789ok(InterfaceC12501k interfaceC12501k) {
        if (interfaceC12501k != null) {
            f35060a = interfaceC12501k;
        }
    }

    /* renamed from: ok */
    private static void m17787ok(InterfaceC12513r interfaceC12513r) {
        if (interfaceC12513r != null) {
            f35062bl = interfaceC12513r;
        }
    }

    /* renamed from: ok */
    private static void m17781ok(InterfaceC12721a interfaceC12721a) {
        if (interfaceC12721a != null) {
            f35081kz = interfaceC12721a;
        }
    }

    /* renamed from: ok */
    public static void m17794ok(InterfaceC12481vz interfaceC12481vz) {
        f35070er = interfaceC12481vz;
        C12534ok.m17600ok();
    }

    /* renamed from: ok */
    private static void m17788ok(InterfaceC12509p interfaceC12509p) {
        if (interfaceC12509p != null) {
            f35093s = interfaceC12509p;
        }
    }

    /* renamed from: ok */
    public static void m17795ok(InterfaceC12480v interfaceC12480v) {
        if (interfaceC12480v != null) {
            f35084n = interfaceC12480v;
        }
    }

    /* renamed from: ok */
    private static void m17791ok(InterfaceC12496h interfaceC12496h) {
        if (interfaceC12496h != null) {
            f35108y = interfaceC12496h;
        }
    }

    /* renamed from: ok */
    public static synchronized void m17799ok(Context context) {
        synchronized (C12490bl.class) {
            if (context != null) {
                if (f35086ok == null) {
                    f35086ok = StubApp.getOrigApplicationContext(context.getApplicationContext());
                    C12646ok.m16846ok().m16845ok(f35086ok);
                }
            }
        }
    }

    /* renamed from: ok */
    public static int m17785ok(DownloadInfo downloadInfo) {
        if (downloadInfo == null) {
            return 0;
        }
        String taskKey = downloadInfo.getTaskKey();
        if (TextUtils.isEmpty(taskKey)) {
            taskKey = downloadInfo.getUrl();
        }
        return m17776ok(taskKey, downloadInfo.getSavePath());
    }

    /* renamed from: ok */
    public static int m17776ok(String str, String str2) {
        InterfaceC12513r m17821er = m17821er();
        if (m17821er == null) {
            return 0;
        }
        return m17821er.mo17530ok(str, str2);
    }

    /* renamed from: ok */
    public static void m17780ok(InterfaceC12722bl interfaceC12722bl) {
        f35065dx = interfaceC12722bl;
    }

    /* renamed from: ok */
    public static void m17792ok(InterfaceC12494ok interfaceC12494ok) {
        C12409ok.m17896ok("wjd", "setIndependentServiceCreator::creator=" + interfaceC12494ok);
        f35088q = interfaceC12494ok;
    }
}
