package rx.internal.schedulers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;
import rx.internal.util.RxThreadFactory;
import rx.internal.util.SuppressAnimalSniffer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: NewThreadWorker.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class h extends h.a implements rx.m {

    /* renamed from: c  reason: collision with root package name */
    private static final String f63807c = "rx.scheduler.jdk6.purge-frequency-millis";

    /* renamed from: d  reason: collision with root package name */
    private static final String f63808d = "rx.scheduler.jdk6.purge-force";

    /* renamed from: e  reason: collision with root package name */
    private static final String f63809e = "RxSchedulerPurge-";

    /* renamed from: f  reason: collision with root package name */
    private static final boolean f63810f;

    /* renamed from: j  reason: collision with root package name */
    private static volatile Object f63814j;

    /* renamed from: a  reason: collision with root package name */
    private final ScheduledExecutorService f63816a;

    /* renamed from: b  reason: collision with root package name */
    volatile boolean f63817b;

    /* renamed from: k  reason: collision with root package name */
    private static final Object f63815k = new Object();

    /* renamed from: h  reason: collision with root package name */
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f63812h = new ConcurrentHashMap<>();

    /* renamed from: i  reason: collision with root package name */
    private static final AtomicReference<ScheduledExecutorService> f63813i = new AtomicReference<>();

    /* renamed from: g  reason: collision with root package name */
    public static final int f63811g = Integer.getInteger("rx.scheduler.jdk6.purge-frequency-millis", 1000).intValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: NewThreadWorker.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            h.J();
        }
    }

    static {
        boolean z3 = Boolean.getBoolean("rx.scheduler.jdk6.purge-force");
        int a4 = rx.internal.util.i.a();
        f63810f = !z3 && (a4 == 0 || a4 >= 21);
    }

    public h(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!O(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            K((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f63816a = newScheduledThreadPool;
    }

    public static void H(ScheduledExecutorService scheduledExecutorService) {
        f63812h.remove(scheduledExecutorService);
    }

    static Method I(ScheduledExecutorService scheduledExecutorService) {
        Method[] methods;
        for (Method method : scheduledExecutorService.getClass().getMethods()) {
            if (method.getName().equals("setRemoveOnCancelPolicy")) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1 && parameterTypes[0] == Boolean.TYPE) {
                    return method;
                }
            }
        }
        return null;
    }

    @SuppressAnimalSniffer
    static void J() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = f63812h.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            rx.plugins.c.I(th);
        }
    }

    public static void K(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f63813i;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory("RxSchedulerPurge-"));
            if (atomicReference.compareAndSet(null, newScheduledThreadPool)) {
                a aVar = new a();
                int i4 = f63811g;
                newScheduledThreadPool.scheduleAtFixedRate(aVar, i4, i4, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        f63812h.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    public static boolean O(ScheduledExecutorService scheduledExecutorService) {
        Method I;
        if (f63810f) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = f63814j;
                Object obj2 = f63815k;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    I = I(scheduledExecutorService);
                    if (I != null) {
                        obj2 = I;
                    }
                    f63814j = obj2;
                } else {
                    I = (Method) obj;
                }
            } else {
                I = I(scheduledExecutorService);
            }
            if (I != null) {
                try {
                    I.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e4) {
                    rx.plugins.c.I(e4);
                } catch (IllegalArgumentException e5) {
                    rx.plugins.c.I(e5);
                } catch (InvocationTargetException e6) {
                    rx.plugins.c.I(e6);
                }
            }
        }
        return false;
    }

    public rx.m F(rx.functions.a aVar, long j4, TimeUnit timeUnit) {
        if (this.f63817b) {
            return rx.subscriptions.f.e();
        }
        return L(aVar, j4, timeUnit);
    }

    public ScheduledAction L(rx.functions.a aVar, long j4, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(rx.plugins.c.P(aVar));
        if (j4 <= 0) {
            schedule = this.f63816a.submit(scheduledAction);
        } else {
            schedule = this.f63816a.schedule(scheduledAction, j4, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    public ScheduledAction M(rx.functions.a aVar, long j4, TimeUnit timeUnit, rx.internal.util.m mVar) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(rx.plugins.c.P(aVar), mVar);
        mVar.a(scheduledAction);
        if (j4 <= 0) {
            schedule = this.f63816a.submit(scheduledAction);
        } else {
            schedule = this.f63816a.schedule(scheduledAction, j4, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    public ScheduledAction N(rx.functions.a aVar, long j4, TimeUnit timeUnit, rx.subscriptions.b bVar) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(rx.plugins.c.P(aVar), bVar);
        bVar.a(scheduledAction);
        if (j4 <= 0) {
            schedule = this.f63816a.submit(scheduledAction);
        } else {
            schedule = this.f63816a.schedule(scheduledAction, j4, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    public rx.m d(rx.functions.a aVar) {
        return F(aVar, 0L, null);
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f63817b;
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f63817b = true;
        this.f63816a.shutdownNow();
        H(this.f63816a);
    }
}
