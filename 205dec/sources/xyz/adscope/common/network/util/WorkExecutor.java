package xyz.adscope.common.network.util;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: E:\TSN-r\205dec\1574464.dex */
public class WorkExecutor implements Executor {

    /* renamed from: b  reason: collision with root package name */
    public static final int f65042b = Runtime.getRuntime().availableProcessors();

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f65043c = new ThreadFactory() { // from class: xyz.adscope.common.network.util.WorkExecutor.1

        /* renamed from: a  reason: collision with root package name */
        public final AtomicInteger f65045a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "Request #" + this.f65045a.getAndIncrement());
        }
    };

    /* renamed from: a  reason: collision with root package name */
    public ThreadPoolExecutor f65044a;

    public WorkExecutor() {
        int i4 = f65042b;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(Math.max(2, Math.min(i4 - 1, 4)), (i4 * 2) + 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(200), f65043c, rejectHandler());
        this.f65044a = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f65044a.execute(runnable);
    }

    public RejectedExecutionHandler rejectHandler() {
        return new RejectedExecutionHandler() { // from class: xyz.adscope.common.network.util.WorkExecutor.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            }
        };
    }
}
