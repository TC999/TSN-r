package xyz.adscope.ad.tool.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class AdScopeThreadPool {
    private static final int CORE_NUM;
    private static final int MAX_NUM;
    private static final int UPDATE_THREAD_COUNT = 3;
    private static ScheduledExecutorService executorService;
    private static final LinkedBlockingQueue<Runnable> initRequestQueue;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CORE_NUM = availableProcessors;
        MAX_NUM = Math.max((availableProcessors / 2) + 1, 4);
        initRequestQueue = new LinkedBlockingQueue<>();
    }

    public static ThreadPoolExecutor getInitRequestPool() {
        return new ThreadPoolExecutor(2, MAX_NUM, 5L, TimeUnit.SECONDS, initRequestQueue, new AdScopeThreadFactory(5, "adscope-adsdk-adrequest-thread-"), rejectHandler());
    }

    public static ScheduledExecutorService getScheduledExecutorService() {
        return Executors.newScheduledThreadPool(3);
    }

    public static ScheduledExecutorService getSingleExecutorService() {
        if (executorService == null) {
            executorService = Executors.newSingleThreadScheduledExecutor();
        }
        return executorService;
    }

    public static RejectedExecutionHandler rejectHandler() {
        return new RejectedExecutionHandler() { // from class: xyz.adscope.ad.tool.thread.AdScopeThreadPool.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
