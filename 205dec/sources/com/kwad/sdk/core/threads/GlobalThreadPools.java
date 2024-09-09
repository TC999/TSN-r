package com.kwad.sdk.core.threads;

import androidx.annotation.NonNull;
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

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
/* loaded from: E:\TSN-r\205dec\6520572.dex */
public final class GlobalThreadPools {
    private static String TAG;
    private static Map<String, Integer> aAA;
    private static final int aAw;
    private static final int aAx;
    private static final int aAy;
    private static Map<String, WeakReference<ExecutorService>> aAz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* renamed from: com.kwad.sdk.core.threads.GlobalThreadPools$4  reason: invalid class name */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static /* synthetic */ class AnonymousClass4 {
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    enum ParamType {
        CORE,
        MAX,
        KEEP_ALIVE
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public interface a {
        @NonNull
        ExecutorService FP();
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class b implements a {
        private b() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("httpIO", ParamType.CORE, GlobalThreadPools.aAx), GlobalThreadPools.a("httpIO", ParamType.MAX, GlobalThreadPools.aAy), GlobalThreadPools.a("httpIO", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "diskAndHttp"));
        }

        /* synthetic */ b(byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class c implements a {
        private c() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("imageLoaderDistributor", ParamType.CORE, 0), GlobalThreadPools.a("imageLoaderDistributor", ParamType.MAX, 10), GlobalThreadPools.a("imageLoaderDistributor", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new SynchronousQueue(), new d(5, "uil-pool-d-"), new ThreadPoolExecutor.DiscardPolicy());
        }

        /* synthetic */ c(byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    public static class d implements ThreadFactory {
        private static final AtomicInteger poolNumber = new AtomicInteger(1);
        private final String namePrefix;
        private final int threadPriority;
        private final AtomicInteger threadNumber = new AtomicInteger(1);
        private final ThreadGroup group = Thread.currentThread().getThreadGroup();

        public d(int i4, String str) {
            this.threadPriority = i4;
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

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class e implements a {
        private e() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("ksImageLoaderTask", ParamType.CORE, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.MAX, 3), GlobalThreadPools.a("ksImageLoaderTask", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "uil-pool-"));
        }

        /* synthetic */ e(byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class f implements a {
        private f() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("lruDiskCache", ParamType.CORE, 0), GlobalThreadPools.a("lruDiskCache", ParamType.MAX, 1), GlobalThreadPools.a("lruDiskCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "lruDiskCache"));
        }

        /* synthetic */ f(byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class g implements a {
        private g() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("report", ParamType.CORE, 1), GlobalThreadPools.a("report", ParamType.MAX, 1), GlobalThreadPools.a("report", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(3, "report-"));
        }

        /* synthetic */ g(byte b4) {
            this();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\6241084.dex
 */
    /* loaded from: E:\TSN-r\205dec\6520572.dex */
    static class h implements a {
        private h() {
        }

        @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
        @NonNull
        public final ExecutorService FP() {
            return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("videoCache", ParamType.CORE, 3), GlobalThreadPools.a("videoCache", ParamType.MAX, 3), GlobalThreadPools.a("videoCache", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "videoCache"));
        }

        /* synthetic */ h(byte b4) {
            this();
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        aAw = availableProcessors;
        int i4 = availableProcessors > 0 ? availableProcessors + 4 : 9;
        aAx = i4;
        aAy = i4;
        TAG = "GlobalThreadPools";
        aAz = new ConcurrentHashMap();
        aAA = new ConcurrentHashMap();
    }

    public static void FA() {
        for (String str : aAz.keySet()) {
            if (aAz.get(str).get() instanceof ThreadPoolExecutor) {
                ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) aAz.get(str).get();
                int corePoolSize = threadPoolExecutor.getCorePoolSize();
                int maximumPoolSize = threadPoolExecutor.getMaximumPoolSize();
                TimeUnit timeUnit = TimeUnit.SECONDS;
                int keepAliveTime = (int) threadPoolExecutor.getKeepAliveTime(timeUnit);
                int a4 = a(str, ParamType.CORE, corePoolSize);
                int a5 = a(str, ParamType.MAX, maximumPoolSize);
                threadPoolExecutor.setKeepAliveTime(a(str, ParamType.KEEP_ALIVE, keepAliveTime), timeUnit);
                if (corePoolSize != a4 || maximumPoolSize != a5) {
                    if (corePoolSize <= a5) {
                        threadPoolExecutor.setMaximumPoolSize(a5);
                        threadPoolExecutor.setCorePoolSize(a4);
                    } else if (a4 <= maximumPoolSize) {
                        threadPoolExecutor.setCorePoolSize(a4);
                        threadPoolExecutor.setMaximumPoolSize(a5);
                    }
                }
            }
        }
    }

    public static ExecutorService FB() {
        return a("lruDiskCache", new f((byte) 0));
    }

    public static synchronized ExecutorService FC() {
        ExecutorService a4;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.e.c.d(TAG, "forKsImageLoaderTask");
            a4 = a("ksImageLoaderTask", new e((byte) 0));
        }
        return a4;
    }

    public static synchronized ExecutorService FD() {
        ExecutorService a4;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.e.c.d(TAG, "forKsImageLoaderCachedImages");
            a4 = a("ksImageLoaderTask", new e((byte) 0));
        }
        return a4;
    }

    public static ExecutorService FE() {
        com.kwad.sdk.core.e.c.d(TAG, "forKsImageLoaderTaskDistributor");
        return a("imageLoaderDistributor", new c((byte) 0));
    }

    public static synchronized ExecutorService FF() {
        ExecutorService a4;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.e.c.d(TAG, "forBaseBatchReporter");
            a4 = a("report", new g((byte) 0));
        }
        return a4;
    }

    public static synchronized ExecutorService FG() {
        ExecutorService a4;
        synchronized (GlobalThreadPools.class) {
            com.kwad.sdk.core.e.c.d(TAG, "forAdReportManager");
            a4 = a("report", new g((byte) 0));
        }
        return a4;
    }

    public static ExecutorService FH() {
        com.kwad.sdk.core.e.c.d(TAG, "forBaseNetwork");
        return a("httpIO", new b((byte) 0));
    }

    public static ExecutorService FI() {
        com.kwad.sdk.core.e.c.d(TAG, "forHttpCacheServer");
        return a("videoCache", new h((byte) 0));
    }

    public static ExecutorService FJ() {
        com.kwad.sdk.core.e.c.d(TAG, "forAppStatusHelper");
        return new com.kwad.sdk.core.threads.a.b(a("lruDiskCache", ParamType.CORE, 1), a("lruDiskCache", ParamType.MAX, 1), a("lruDiskCache", ParamType.KEEP_ALIVE, 0), TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "ksad-ashelper");
                thread.setPriority(3);
                return thread;
            }
        });
    }

    public static ExecutorService FK() {
        com.kwad.sdk.core.e.c.d(TAG, "forAsync");
        return a("async", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.2
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            @NonNull
            public final ExecutorService FP() {
                return new com.kwad.sdk.core.threads.a.b(GlobalThreadPools.a("async", ParamType.CORE, 3), GlobalThreadPools.a("async", ParamType.MAX, 3), GlobalThreadPools.a("async", ParamType.KEEP_ALIVE, 60), TimeUnit.SECONDS, new LinkedBlockingQueue(), new d(5, "async"));
            }
        });
    }

    public static ScheduledExecutorService FL() {
        com.kwad.sdk.core.e.c.d(TAG, "forAsyncSchedule");
        ExecutorService a4 = a("async-schedule", new a() { // from class: com.kwad.sdk.core.threads.GlobalThreadPools.3
            @Override // com.kwad.sdk.core.threads.GlobalThreadPools.a
            @NonNull
            public final ExecutorService FP() {
                return new com.kwad.sdk.core.threads.a.a(1, new d(5, "async-schedule"));
            }
        });
        if (a4 instanceof ScheduledExecutorService) {
            return (ScheduledExecutorService) a4;
        }
        return new com.kwad.sdk.core.threads.a.a(1, new d(5, "async-schedule"));
    }

    public static Set<String> FM() {
        return aAz.keySet();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int a(String str, ParamType paramType, int i4) {
        String str2;
        int i5 = AnonymousClass4.aAB[paramType.ordinal()];
        if (i5 == 1) {
            str2 = str + "_core";
        } else if (i5 == 2) {
            str2 = str + "_max";
        } else if (i5 != 3) {
            return i4;
        } else {
            str2 = str + "_keep_alive";
        }
        return (!aAA.containsKey(str2) || aAA.get(str2) == null) ? i4 : aAA.get(str2).intValue();
    }

    public static ExecutorService et(String str) {
        if (!aAz.containsKey(str) || aAz.get(str) == null) {
            return null;
        }
        return aAz.get(str).get();
    }

    public static void r(String str, int i4) {
        aAA.put(str, Integer.valueOf(i4));
    }

    @NonNull
    private static ExecutorService a(String str, @NonNull a aVar) {
        WeakReference<ExecutorService> weakReference = aAz.get(str);
        if (weakReference != null && weakReference.get() != null) {
            return weakReference.get();
        }
        ExecutorService FP = aVar.FP();
        aAz.put(str, new WeakReference<>(FP));
        return FP;
    }
}
