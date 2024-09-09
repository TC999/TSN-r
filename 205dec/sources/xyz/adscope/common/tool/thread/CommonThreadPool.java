package xyz.adscope.common.tool.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class CommonThreadPool {

    /* renamed from: a  reason: collision with root package name */
    public static final int f65053a;

    /* renamed from: b  reason: collision with root package name */
    public static final int f65054b;

    /* renamed from: c  reason: collision with root package name */
    public static final LinkedBlockingQueue<Runnable> f65055c;

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f65053a = availableProcessors;
        f65054b = Math.max((availableProcessors / 2) + 1, 4);
        f65055c = new LinkedBlockingQueue<>();
    }

    public static ThreadPoolExecutor getInitRequestPool() {
        return new ThreadPoolExecutor(2, f65054b, 5L, TimeUnit.SECONDS, f65055c, new CommonThreadFactory(5, "common-adsdk-adrequest-thread-"), rejectHandler());
    }

    public static ScheduledExecutorService getScheduledExecutorService() {
        return Executors.newScheduledThreadPool(3);
    }

    public static ScheduledExecutorService getSingleExecutorService() {
        return Executors.newSingleThreadScheduledExecutor();
    }

    public static RejectedExecutionHandler rejectHandler() {
        return new RejectedExecutionHandler() { // from class: xyz.adscope.common.tool.thread.CommonThreadPool.1
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
