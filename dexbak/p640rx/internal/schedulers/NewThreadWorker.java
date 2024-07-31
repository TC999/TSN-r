package p640rx.internal.schedulers;

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
import p640rx.Scheduler;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.internal.util.PlatformDependent;
import p640rx.internal.util.RxThreadFactory;
import p640rx.internal.util.SubscriptionList;
import p640rx.internal.util.SuppressAnimalSniffer;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.CompositeSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.schedulers.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class NewThreadWorker extends Scheduler.AbstractC15607a implements Subscription {

    /* renamed from: d */
    private static final String f46377d = "rx.scheduler.jdk6.purge-force";

    /* renamed from: e */
    private static final String f46378e = "RxSchedulerPurge-";

    /* renamed from: f */
    private static final boolean f46379f;

    /* renamed from: j */
    private static volatile Object f46383j;

    /* renamed from: a */
    private final ScheduledExecutorService f46385a;

    /* renamed from: b */
    volatile boolean f46386b;

    /* renamed from: k */
    private static final Object f46384k = new Object();

    /* renamed from: h */
    private static final ConcurrentHashMap<ScheduledThreadPoolExecutor, ScheduledThreadPoolExecutor> f46381h = new ConcurrentHashMap<>();

    /* renamed from: i */
    private static final AtomicReference<ScheduledExecutorService> f46382i = new AtomicReference<>();

    /* renamed from: c */
    private static final String f46376c = "rx.scheduler.jdk6.purge-frequency-millis";

    /* renamed from: g */
    public static final int f46380g = Integer.getInteger(f46376c, 1000).intValue();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: NewThreadWorker.java */
    /* renamed from: rx.internal.schedulers.h$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class RunnableC16014a implements Runnable {
        RunnableC16014a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            NewThreadWorker.m942J();
        }
    }

    static {
        boolean z = Boolean.getBoolean(f46377d);
        int m839a = PlatformDependent.m839a();
        f46379f = !z && (m839a == 0 || m839a >= 21);
    }

    public NewThreadWorker(ThreadFactory threadFactory) {
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, threadFactory);
        if (!m937O(newScheduledThreadPool) && (newScheduledThreadPool instanceof ScheduledThreadPoolExecutor)) {
            m941K((ScheduledThreadPoolExecutor) newScheduledThreadPool);
        }
        this.f46385a = newScheduledThreadPool;
    }

    /* renamed from: H */
    public static void m944H(ScheduledExecutorService scheduledExecutorService) {
        f46381h.remove(scheduledExecutorService);
    }

    /* renamed from: I */
    static Method m943I(ScheduledExecutorService scheduledExecutorService) {
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
    /* renamed from: J */
    static void m942J() {
        try {
            Iterator<ScheduledThreadPoolExecutor> it = f46381h.keySet().iterator();
            while (it.hasNext()) {
                ScheduledThreadPoolExecutor next = it.next();
                if (!next.isShutdown()) {
                    next.purge();
                } else {
                    it.remove();
                }
            }
        } catch (Throwable th) {
            C15575a.m1474e(th);
            RxJavaHooks.m576I(th);
        }
    }

    /* renamed from: K */
    public static void m941K(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        while (true) {
            AtomicReference<ScheduledExecutorService> atomicReference = f46382i;
            if (atomicReference.get() != null) {
                break;
            }
            ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(1, new RxThreadFactory(f46378e));
            if (atomicReference.compareAndSet(null, newScheduledThreadPool)) {
                RunnableC16014a runnableC16014a = new RunnableC16014a();
                int i = f46380g;
                newScheduledThreadPool.scheduleAtFixedRate(runnableC16014a, i, i, TimeUnit.MILLISECONDS);
                break;
            }
            newScheduledThreadPool.shutdownNow();
        }
        f46381h.putIfAbsent(scheduledThreadPoolExecutor, scheduledThreadPoolExecutor);
    }

    /* renamed from: O */
    public static boolean m937O(ScheduledExecutorService scheduledExecutorService) {
        Method m943I;
        if (f46379f) {
            if (scheduledExecutorService instanceof ScheduledThreadPoolExecutor) {
                Object obj = f46383j;
                Object obj2 = f46384k;
                if (obj == obj2) {
                    return false;
                }
                if (obj == null) {
                    m943I = m943I(scheduledExecutorService);
                    if (m943I != null) {
                        obj2 = m943I;
                    }
                    f46383j = obj2;
                } else {
                    m943I = (Method) obj;
                }
            } else {
                m943I = m943I(scheduledExecutorService);
            }
            if (m943I != null) {
                try {
                    m943I.invoke(scheduledExecutorService, Boolean.TRUE);
                    return true;
                } catch (IllegalAccessException e) {
                    RxJavaHooks.m576I(e);
                } catch (IllegalArgumentException e2) {
                    RxJavaHooks.m576I(e2);
                } catch (InvocationTargetException e3) {
                    RxJavaHooks.m576I(e3);
                }
            }
        }
        return false;
    }

    @Override // p640rx.Scheduler.AbstractC15607a
    /* renamed from: F */
    public Subscription mo460F(Action0 action0, long j, TimeUnit timeUnit) {
        if (this.f46386b) {
            return Subscriptions.m342e();
        }
        return m940L(action0, j, timeUnit);
    }

    /* renamed from: L */
    public ScheduledAction m940L(Action0 action0, long j, TimeUnit timeUnit) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.m569P(action0));
        if (j <= 0) {
            schedule = this.f46385a.submit(scheduledAction);
        } else {
            schedule = this.f46385a.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    /* renamed from: M */
    public ScheduledAction m939M(Action0 action0, long j, TimeUnit timeUnit, SubscriptionList subscriptionList) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.m569P(action0), subscriptionList);
        subscriptionList.m808a(scheduledAction);
        if (j <= 0) {
            schedule = this.f46385a.submit(scheduledAction);
        } else {
            schedule = this.f46385a.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    /* renamed from: N */
    public ScheduledAction m938N(Action0 action0, long j, TimeUnit timeUnit, CompositeSubscription compositeSubscription) {
        Future<?> schedule;
        ScheduledAction scheduledAction = new ScheduledAction(RxJavaHooks.m569P(action0), compositeSubscription);
        compositeSubscription.m359a(scheduledAction);
        if (j <= 0) {
            schedule = this.f46385a.submit(scheduledAction);
        } else {
            schedule = this.f46385a.schedule(scheduledAction, j, timeUnit);
        }
        scheduledAction.add(schedule);
        return scheduledAction;
    }

    @Override // p640rx.Scheduler.AbstractC15607a
    /* renamed from: d */
    public Subscription mo456d(Action0 action0) {
        return mo460F(action0, 0L, null);
    }

    @Override // p640rx.Subscription
    public boolean isUnsubscribed() {
        return this.f46386b;
    }

    @Override // p640rx.Subscription
    public void unsubscribe() {
        this.f46386b = true;
        this.f46385a.shutdownNow();
        m944H(this.f46385a);
    }
}
