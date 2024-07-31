package p640rx.internal.schedulers;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Scheduler;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.internal.util.RxThreadFactory;
import p640rx.subscriptions.CompositeSubscription;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.schedulers.a */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CachedThreadScheduler extends Scheduler implements SchedulerLifecycle {

    /* renamed from: c */
    private static final long f46313c;

    /* renamed from: d */
    private static final TimeUnit f46314d = TimeUnit.SECONDS;

    /* renamed from: e */
    static final C16004c f46315e;

    /* renamed from: f */
    static final C15999a f46316f;

    /* renamed from: a */
    final ThreadFactory f46317a;

    /* renamed from: b */
    final AtomicReference<C15999a> f46318b = new AtomicReference<>(f46316f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedThreadScheduler.java */
    /* renamed from: rx.internal.schedulers.a$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15999a {

        /* renamed from: a */
        private final ThreadFactory f46319a;

        /* renamed from: b */
        private final long f46320b;

        /* renamed from: c */
        private final ConcurrentLinkedQueue<C16004c> f46321c;

        /* renamed from: d */
        private final CompositeSubscription f46322d;

        /* renamed from: e */
        private final ScheduledExecutorService f46323e;

        /* renamed from: f */
        private final Future<?> f46324f;

        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.internal.schedulers.a$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class ThreadFactoryC16000a implements ThreadFactory {

            /* renamed from: a */
            final /* synthetic */ ThreadFactory f46325a;

            ThreadFactoryC16000a(ThreadFactory threadFactory) {
                this.f46325a = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f46325a.newThread(runnable);
                newThread.setName(newThread.getName() + " (Evictor)");
                return newThread;
            }
        }

        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.internal.schedulers.a$a$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class RunnableC16001b implements Runnable {
            RunnableC16001b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C15999a.this.m958a();
            }
        }

        C15999a(ThreadFactory threadFactory, long j, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f46319a = threadFactory;
            long nanos = timeUnit != null ? timeUnit.toNanos(j) : 0L;
            this.f46320b = nanos;
            this.f46321c = new ConcurrentLinkedQueue<>();
            this.f46322d = new CompositeSubscription();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC16000a(threadFactory));
                NewThreadWorker.m937O(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new RunnableC16001b(), nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f46323e = scheduledExecutorService;
            this.f46324f = scheduledFuture;
        }

        /* renamed from: a */
        void m958a() {
            if (this.f46321c.isEmpty()) {
                return;
            }
            long m956c = m956c();
            Iterator<C16004c> it = this.f46321c.iterator();
            while (it.hasNext()) {
                C16004c next = it.next();
                if (next.m953P() > m956c) {
                    return;
                }
                if (this.f46321c.remove(next)) {
                    this.f46322d.m361G(next);
                }
            }
        }

        /* renamed from: b */
        C16004c m957b() {
            if (this.f46322d.isUnsubscribed()) {
                return CachedThreadScheduler.f46315e;
            }
            while (!this.f46321c.isEmpty()) {
                C16004c poll = this.f46321c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            C16004c c16004c = new C16004c(this.f46319a);
            this.f46322d.m359a(c16004c);
            return c16004c;
        }

        /* renamed from: c */
        long m956c() {
            return System.nanoTime();
        }

        /* renamed from: d */
        void m955d(C16004c c16004c) {
            c16004c.m952Q(m956c() + this.f46320b);
            this.f46321c.offer(c16004c);
        }

        /* renamed from: e */
        void m954e() {
            try {
                Future<?> future = this.f46324f;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.f46323e;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.f46322d.unsubscribe();
            }
        }
    }

    /* compiled from: CachedThreadScheduler.java */
    /* renamed from: rx.internal.schedulers.a$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16002b extends Scheduler.AbstractC15607a implements Action0 {

        /* renamed from: b */
        private final C15999a f46329b;

        /* renamed from: c */
        private final C16004c f46330c;

        /* renamed from: a */
        private final CompositeSubscription f46328a = new CompositeSubscription();

        /* renamed from: d */
        final AtomicBoolean f46331d = new AtomicBoolean();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.internal.schedulers.a$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C16003a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ Action0 f46332a;

            C16003a(Action0 action0) {
                this.f46332a = action0;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                if (C16002b.this.isUnsubscribed()) {
                    return;
                }
                this.f46332a.call();
            }
        }

        C16002b(C15999a c15999a) {
            this.f46329b = c15999a;
            this.f46330c = c15999a.m957b();
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: F */
        public Subscription mo460F(Action0 action0, long j, TimeUnit timeUnit) {
            if (this.f46328a.isUnsubscribed()) {
                return Subscriptions.m342e();
            }
            ScheduledAction m940L = this.f46330c.m940L(new C16003a(action0), j, timeUnit);
            this.f46328a.m359a(m940L);
            m940L.addParent(this.f46328a);
            return m940L;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            this.f46329b.m955d(this.f46330c);
        }

        @Override // p640rx.Scheduler.AbstractC15607a
        /* renamed from: d */
        public Subscription mo456d(Action0 action0) {
            return mo460F(action0, 0L, null);
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f46328a.isUnsubscribed();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (this.f46331d.compareAndSet(false, true)) {
                this.f46330c.mo456d(this);
            }
            this.f46328a.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedThreadScheduler.java */
    /* renamed from: rx.internal.schedulers.a$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16004c extends NewThreadWorker {

        /* renamed from: l */
        private long f46334l;

        C16004c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f46334l = 0L;
        }

        /* renamed from: P */
        public long m953P() {
            return this.f46334l;
        }

        /* renamed from: Q */
        public void m952Q(long j) {
            this.f46334l = j;
        }
    }

    static {
        C16004c c16004c = new C16004c(RxThreadFactory.NONE);
        f46315e = c16004c;
        c16004c.unsubscribe();
        C15999a c15999a = new C15999a(null, 0L, null);
        f46316f = c15999a;
        c15999a.m954e();
        f46313c = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public CachedThreadScheduler(ThreadFactory threadFactory) {
        this.f46317a = threadFactory;
        start();
    }

    @Override // p640rx.Scheduler
    /* renamed from: a */
    public Scheduler.AbstractC15607a mo450a() {
        return new C16002b(this.f46318b.get());
    }

    @Override // p640rx.internal.schedulers.SchedulerLifecycle
    public void shutdown() {
        C15999a c15999a;
        C15999a c15999a2;
        do {
            c15999a = this.f46318b.get();
            c15999a2 = f46316f;
            if (c15999a == c15999a2) {
                return;
            }
        } while (!this.f46318b.compareAndSet(c15999a, c15999a2));
        c15999a.m954e();
    }

    @Override // p640rx.internal.schedulers.SchedulerLifecycle
    public void start() {
        C15999a c15999a = new C15999a(this.f46317a, f46313c, f46314d);
        if (this.f46318b.compareAndSet(f46316f, c15999a)) {
            return;
        }
        c15999a.m954e();
    }
}
