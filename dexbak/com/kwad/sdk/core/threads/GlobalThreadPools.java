package com.kwad.sdk.core.threads;

import androidx.annotation.NonNull;
import com.kwad.sdk.core.p397e.C10331c;
import com.kwad.sdk.core.threads.p410a.C10508a;
import com.kwad.sdk.core.threads.p410a.C10509b;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\fuckcool\tsn\6520572.dex */
public final class GlobalThreadPools {
    private static String TAG;
    private static Map<String, Integer> aAA;
    private static final int aAw;
    private static final int aAx;
    private static final int aAy;
    private static Map<String, WeakReference<ExecutorService>> aAz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$4 */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static /* synthetic */ class C104974 {
        static final /* synthetic */ int[] aAB;

        static {
            int[] iArr = new int[ParamType.values().length];
            aAB = iArr;
            try {
                iArr[ParamType.CORE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                aAB[ParamType.MAX.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                aAB[ParamType.KEEP_ALIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    enum ParamType {
        CORE,
        MAX,
        KEEP_ALIVE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$a */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public interface InterfaceC10498a {
        @NonNull
        /* renamed from: FP */
        ExecutorService mo25588FP();
    }

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$b */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10499b implements InterfaceC10498a {
        private C10499b() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.InterfaceC10498a
        @NonNull
        /* renamed from: FP */
        public final ExecutorService mo25588FP() {
            return new C10509b(GlobalThreadPools.m25593a("httpIO", ParamType.CORE, GlobalThreadPools.aAx), GlobalThreadPools.m25593a("httpIO", ParamType.MAX, GlobalThreadPools.aAy), GlobalThreadPools.m25593a("httpIO", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC10501d(5, "diskAndHttp"));
        }

        /* synthetic */ C10499b(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$c */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10500c implements InterfaceC10498a {
        private C10500c() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.InterfaceC10498a
        @NonNull
        /* renamed from: FP */
        public final ExecutorService mo25588FP() {
            return new C10509b(GlobalThreadPools.m25593a("imageLoaderDistributor", ParamType.CORE, 0), GlobalThreadPools.m25593a("imageLoaderDistributor", ParamType.MAX, 10), GlobalThreadPools.m25593a("imageLoaderDistributor", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactoryC10501d(5, "uil-pool-d-"), new ThreadPoolExecutor.DiscardPolicy());
        }

        /* synthetic */ C10500c(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$d */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    public static class ThreadFactoryC10501d implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public ThreadFactoryC10501d(int i, String str) {
            this.threadPriority = i;
            this.namePrefix = "ksad-" + str + poolNumber.getAndIncrement() + "-thread-";
        }

        @Override // java.util.concurrent.ThreadFactory
        public final Thread newThread(Runnable runnable) {
            ThreadGroup threadGroup = this.group;
            Thread thread = new Thread(threadGroup, runnable, this.namePrefix + this.threadNumber.getAndIncrement(), 0L);
            if (thread.isDaemon()) {
                thread.setDaemon(false);
            }
            thread.setPriority(this.threadPriority);
            return thread;
        }
    }

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$e */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10502e implements InterfaceC10498a {
        private C10502e() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.InterfaceC10498a
        @NonNull
        /* renamed from: FP */
        public final ExecutorService mo25588FP() {
            return new C10509b(GlobalThreadPools.m25593a("ksImageLoaderTask", ParamType.CORE, 3), GlobalThreadPools.m25593a("ksImageLoaderTask", ParamType.MAX, 3), GlobalThreadPools.m25593a("ksImageLoaderTask", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC10501d(5, "uil-pool-"));
        }

        /* synthetic */ C10502e(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$f */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10503f implements InterfaceC10498a {
        private C10503f() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.InterfaceC10498a
        @NonNull
        /* renamed from: FP */
        public final ExecutorService mo25588FP() {
            return new C10509b(GlobalThreadPools.m25593a("lruDiskCache", ParamType.CORE, 0), GlobalThreadPools.m25593a("lruDiskCache", ParamType.MAX, 1), GlobalThreadPools.m25593a("lruDiskCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC10501d(5, "lruDiskCache"));
        }

        /* synthetic */ C10503f(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$g */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10504g implements InterfaceC10498a {
        private C10504g() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.InterfaceC10498a
        @NonNull
        /* renamed from: FP */
        public final ExecutorService mo25588FP() {
            return new C10509b(GlobalThreadPools.m25593a("report", ParamType.CORE, 1), GlobalThreadPools.m25593a("report", ParamType.MAX, 1), GlobalThreadPools.m25593a("report", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC10501d(3, "report-"));
        }

        /* synthetic */ C10504g(byte b) {
            this();
        }
    }

    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$h */
    /* loaded from: E:\fuckcool\tsn\6520572.dex */
    static class C10505h implements InterfaceC10498a {
        private C10505h() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.InterfaceC10498a
        @NonNull
        /* renamed from: FP */
        public final ExecutorService mo25588FP() {
            return new C10509b(GlobalThreadPools.m25593a("videoCache", ParamType.CORE, 3), GlobalThreadPools.m25593a("videoCache", ParamType.MAX, 3), GlobalThreadPools.m25593a("videoCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC10501d(5, "videoCache"));
        }

        /* synthetic */ C10505h(byte b) {
            this();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aAw = availableProcessors;
        int i = availableProcessors > 0 ? availableProcessors + 4 : 9;
        aAx = i;
        aAy = i;
        TAG = "GlobalThreadPools";
        aAz = new ConcurrentHashMap();
        aAA = new ConcurrentHashMap();
    }

    /* renamed from: FA */
    public static void m25608FA() {
        for (String str : aAz.keySet()) {
            if (aAz.get(str).get() instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) aAz.get(str).get();
                int corePoolSize = threadPoolExecutor.getCorePoolSize();
                int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                int keepAliveTime = (int) threadPoolExecutor.getKeepAliveTime(timeUnit);
                int m25593a = m25593a(str, ParamType.CORE, corePoolSize);
                int m25593a2 = m25593a(str, ParamType.MAX, maximumPoolSize);
                threadPoolExecutor.setKeepAliveTime(m25593a(str, ParamType.KEEP_ALIVE, keepAliveTime), timeUnit);
                if (corePoolSize != m25593a || maximumPoolSize != m25593a2) {
                    if (corePoolSize <= m25593a2) {
                        threadPoolExecutor.setMaximumPoolSize(m25593a2);
                        threadPoolExecutor.setCorePoolSize(m25593a);
                    } else if (m25593a <= maximumPoolSize) {
                        threadPoolExecutor.setCorePoolSize(m25593a);
                        threadPoolExecutor.setMaximumPoolSize(m25593a2);
                    }
                }
            }
        }
    }

    /* renamed from: FB */
    public static ExecutorService m25607FB() {
        return m25592a("lruDiskCache", new C10503f((byte) 0));
    }

    /* renamed from: FC */
    public static synchronized ExecutorService m25606FC() {
        ExecutorService m25592a;
        synchronized (GlobalThreadPools.class) {
            C10331c.m26254d(TAG, "forKsImageLoaderTask");
            m25592a = m25592a("ksImageLoaderTask", new C10502e((byte) 0));
        }
        return m25592a;
    }

    /* renamed from: FD */
    public static synchronized ExecutorService m25605FD() {
        ExecutorService m25592a;
        synchronized (GlobalThreadPools.class) {
            C10331c.m26254d(TAG, "forKsImageLoaderCachedImages");
            m25592a = m25592a("ksImageLoaderTask", new C10502e((byte) 0));
        }
        return m25592a;
    }

    /* renamed from: FE */
    public static ExecutorService m25604FE() {
        C10331c.m26254d(TAG, "forKsImageLoaderTaskDistributor");
        return m25592a("imageLoaderDistributor", new C10500c((byte) 0));
    }

    /* renamed from: FF */
    public static synchronized ExecutorService m25603FF() {
        ExecutorService m25592a;
        synchronized (GlobalThreadPools.class) {
            C10331c.m26254d(TAG, "forBaseBatchReporter");
            m25592a = m25592a("report", new C10504g((byte) 0));
        }
        return m25592a;
    }

    /* renamed from: FG */
    public static synchronized ExecutorService m25602FG() {
        ExecutorService m25592a;
        synchronized (GlobalThreadPools.class) {
            C10331c.m26254d(TAG, "forAdReportManager");
            m25592a = m25592a("report", new C10504g((byte) 0));
        }
        return m25592a;
    }

    /* renamed from: FH */
    public static ExecutorService m25601FH() {
        C10331c.m26254d(TAG, "forBaseNetwork");
        return m25592a("httpIO", new C10499b((byte) 0));
    }

    /* renamed from: FI */
    public static ExecutorService m25600FI() {
        C10331c.m26254d(TAG, "forHttpCacheServer");
        return m25592a("videoCache", new C10505h((byte) 0));
    }

    /* renamed from: FJ */
    public static ExecutorService m25599FJ() {
        C10331c.m26254d(TAG, "forAppStatusHelper");
        return new C10509b(m25593a("lruDiskCache", ParamType.CORE, 1), m25593a("lruDiskCache", ParamType.MAX, 1), m25593a("lruDiskCache", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    /* renamed from: FK */
    public static ExecutorService m25598FK() {
        C10331c.m26254d(TAG, "forAsync");
        return m25592a("async", new InterfaceC10498a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.2
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.InterfaceC10498a
            @NonNull
            /* renamed from: FP */
            public final ExecutorService mo25588FP() {
                return new C10509b(GlobalThreadPools.m25593a("async", ParamType.CORE, 3), GlobalThreadPools.m25593a("async", ParamType.MAX, 3), GlobalThreadPools.m25593a("async", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactoryC10501d(5, "async"));
            }
        });
    }

    /* renamed from: FL */
    public static ScheduledExecutorService m25597FL() {
        C10331c.m26254d(TAG, "forAsyncSchedule");
        ExecutorService m25592a = m25592a("async-schedule", new InterfaceC10498a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.3
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.InterfaceC10498a
            @NonNull
            /* renamed from: FP */
            public final ExecutorService mo25588FP() {
                return new C10508a(1, new ThreadFactoryC10501d(5, "async-schedule"));
            }
        });
        if (m25592a instanceof ScheduledExecutorService) {
            return (ScheduledExecutorService) m25592a;
        }
        return new C10508a(1, new ThreadFactoryC10501d(5, "async-schedule"));
    }

    /* renamed from: FM */
    public static Set<String> m25596FM() {
        return aAz.keySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public static int m25593a(String str, ParamType paramType, int i) {
        String str2;
        int i2 = C104974.aAB[paramType.ordinal()];
        if (i2 == 1) {
            str2 = str + "_core";
        } else if (i2 == 2) {
            str2 = str + "_max";
        } else if (i2 != 3) {
            return i;
        } else {
            str2 = str + "_keep_alive";
        }
        return (!aAA.containsKey(str2) || aAA.get(str2) == null) ? i : aAA.get(str2).intValue();
    }

    /* renamed from: et */
    public static ExecutorService m25590et(String str) {
        if (!aAz.containsKey(str) || aAz.get(str) == null) {
            return null;
        }
        return aAz.get(str).get();
    }

    /* renamed from: r */
    public static void m25589r(String str, int i) {
        aAA.put(str, Integer.valueOf(i));
    }

    @NonNull
    /* renamed from: a */
    private static ExecutorService m25592a(String str, @NonNull InterfaceC10498a interfaceC10498a) {
        WeakReference<ExecutorService> weakReference = aAz.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        ExecutorService mo25588FP = interfaceC10498a.mo25588FP();
        aAz.put(str, new WeakReference<>(mo25588FP));
        return mo25588FP;
    }
}
