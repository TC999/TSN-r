package cn.jiguang.cm;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: E:\TSN-r\205dec\6329136.dex */
public class a implements RejectedExecutionHandler {

    /* renamed from: a  reason: collision with root package name */
    private int f3457a;

    /* renamed from: b  reason: collision with root package name */
    private String f3458b;

    /* renamed from: c  reason: collision with root package name */
    private ThreadPoolExecutor f3459c;

    /* renamed from: d  reason: collision with root package name */
    private LinkedBlockingQueue<Runnable> f3460d;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(String str, int i4) {
        this.f3458b = str;
        if (i4 <= 0) {
            this.f3457a = 3;
        }
        this.f3457a = i4;
    }

    @Override // java.util.concurrent.RejectedExecutionHandler
    public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        cn.jiguang.bq.d.c("JRejectedExecutionHandler", "poolName: " + this.f3458b + ", Exceeded ThreadPoolExecutor pool size");
        if (this.f3459c == null) {
            synchronized (this) {
                if (this.f3459c == null) {
                    this.f3460d = new LinkedBlockingQueue<>();
                    int i4 = this.f3457a;
                    TimeUnit timeUnit = TimeUnit.SECONDS;
                    LinkedBlockingQueue<Runnable> linkedBlockingQueue = this.f3460d;
                    ThreadPoolExecutor threadPoolExecutor2 = new ThreadPoolExecutor(i4, i4, 3L, timeUnit, linkedBlockingQueue, new c(this.f3458b + "_rjt"));
                    this.f3459c = threadPoolExecutor2;
                    threadPoolExecutor2.allowCoreThreadTimeOut(true);
                }
            }
        }
        this.f3459c.execute(runnable);
    }
}
