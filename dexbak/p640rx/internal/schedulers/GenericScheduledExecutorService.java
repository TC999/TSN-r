package p640rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: rx.internal.schedulers.d */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class GenericScheduledExecutorService implements SchedulerLifecycle {

    /* renamed from: b */
    private static final ScheduledExecutorService[] f46364b = new ScheduledExecutorService[0];

    /* renamed from: c */
    private static final ScheduledExecutorService f46365c;

    /* renamed from: d */
    public static final GenericScheduledExecutorService f46366d;

    /* renamed from: e */
    private static int f46367e;

    /* renamed from: a */
    private final AtomicReference<ScheduledExecutorService[]> f46368a = new AtomicReference<>(f46364b);

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f46365c = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f46366d = new GenericScheduledExecutorService();
    }

    private GenericScheduledExecutorService() {
        start();
    }

    /* renamed from: a */
    public static ScheduledExecutorService m948a() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = f46366d.f46368a.get();
        if (scheduledExecutorServiceArr == f46364b) {
            return f46365c;
        }
        int i = f46367e + 1;
        if (i >= scheduledExecutorServiceArr.length) {
            i = 0;
        }
        f46367e = i;
        return scheduledExecutorServiceArr[i];
    }

    @Override // p640rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        do {
            scheduledExecutorServiceArr = this.f46368a.get();
            scheduledExecutorServiceArr2 = f46364b;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
        } while (!this.f46368a.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            NewThreadWorker.m944H(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    @Override // p640rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors > 8) {
            availableProcessors = 8;
        }
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[availableProcessors];
        int i = 0;
        for (int i2 = 0; i2 < availableProcessors; i2++) {
            scheduledExecutorServiceArr[i2] = GenericScheduledExecutorServiceFactory.m947a();
        }
        if (!this.f46368a.compareAndSet(f46364b, scheduledExecutorServiceArr)) {
            while (i < availableProcessors) {
                scheduledExecutorServiceArr[i].shutdownNow();
                i++;
            }
            return;
        }
        while (i < availableProcessors) {
            ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i];
            if (!NewThreadWorker.m937O(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                NewThreadWorker.m941K((ScheduledThreadPoolExecutor) scheduledExecutorService);
            }
            i++;
        }
    }
}
