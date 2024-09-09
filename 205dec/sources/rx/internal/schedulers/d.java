package rx.internal.schedulers;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: GenericScheduledExecutorService.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class d implements j {

    /* renamed from: b  reason: collision with root package name */
    private static final ScheduledExecutorService[] f63795b = new ScheduledExecutorService[0];

    /* renamed from: c  reason: collision with root package name */
    private static final ScheduledExecutorService f63796c;

    /* renamed from: d  reason: collision with root package name */
    public static final d f63797d;

    /* renamed from: e  reason: collision with root package name */
    private static int f63798e;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicReference<ScheduledExecutorService[]> f63799a = new AtomicReference<>(f63795b);

    static {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(0);
        f63796c = newScheduledThreadPool;
        newScheduledThreadPool.shutdown();
        f63797d = new d();
    }

    private d() {
        start();
    }

    public static ScheduledExecutorService a() {
        ScheduledExecutorService[] scheduledExecutorServiceArr = f63797d.f63799a.get();
        if (scheduledExecutorServiceArr == f63795b) {
            return f63796c;
        }
        int i4 = f63798e + 1;
        if (i4 >= scheduledExecutorServiceArr.length) {
            i4 = 0;
        }
        f63798e = i4;
        return scheduledExecutorServiceArr[i4];
    }

    @Override // rx.internal.schedulers.j
    public void shutdown() {
        ScheduledExecutorService[] scheduledExecutorServiceArr;
        ScheduledExecutorService[] scheduledExecutorServiceArr2;
        do {
            scheduledExecutorServiceArr = this.f63799a.get();
            scheduledExecutorServiceArr2 = f63795b;
            if (scheduledExecutorServiceArr == scheduledExecutorServiceArr2) {
                return;
            }
        } while (!this.f63799a.compareAndSet(scheduledExecutorServiceArr, scheduledExecutorServiceArr2));
        for (ScheduledExecutorService scheduledExecutorService : scheduledExecutorServiceArr) {
            h.H(scheduledExecutorService);
            scheduledExecutorService.shutdownNow();
        }
    }

    @Override // rx.internal.schedulers.j
    public void start() {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (availableProcessors > 4) {
            availableProcessors /= 2;
        }
        if (availableProcessors > 8) {
            availableProcessors = 8;
        }
        ScheduledExecutorService[] scheduledExecutorServiceArr = new ScheduledExecutorService[availableProcessors];
        int i4 = 0;
        for (int i5 = 0; i5 < availableProcessors; i5++) {
            scheduledExecutorServiceArr[i5] = e.a();
        }
        if (!this.f63799a.compareAndSet(f63795b, scheduledExecutorServiceArr)) {
            while (i4 < availableProcessors) {
                scheduledExecutorServiceArr[i4].shutdownNow();
                i4++;
            }
            return;
        }
        while (i4 < availableProcessors) {
            ScheduledExecutorService scheduledExecutorService = scheduledExecutorServiceArr[i4];
            if (!h.O(scheduledExecutorService) && (scheduledExecutorService instanceof ScheduledThreadPoolExecutor)) {
                h.K((ScheduledThreadPoolExecutor) scheduledExecutorService);
            }
            i4++;
        }
    }
}
