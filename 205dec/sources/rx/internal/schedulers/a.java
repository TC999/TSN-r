package rx.internal.schedulers;

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
import rx.h;
import rx.internal.util.RxThreadFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: CachedThreadScheduler.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class a extends rx.h implements j {

    /* renamed from: c  reason: collision with root package name */
    private static final long f63744c;

    /* renamed from: d  reason: collision with root package name */
    private static final TimeUnit f63745d = TimeUnit.SECONDS;

    /* renamed from: e  reason: collision with root package name */
    static final c f63746e;

    /* renamed from: f  reason: collision with root package name */
    static final C1308a f63747f;

    /* renamed from: a  reason: collision with root package name */
    final ThreadFactory f63748a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<C1308a> f63749b = new AtomicReference<>(f63747f);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: CachedThreadScheduler.java */
    /* renamed from: rx.internal.schedulers.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class C1308a {

        /* renamed from: a  reason: collision with root package name */
        private final ThreadFactory f63750a;

        /* renamed from: b  reason: collision with root package name */
        private final long f63751b;

        /* renamed from: c  reason: collision with root package name */
        private final ConcurrentLinkedQueue<c> f63752c;

        /* renamed from: d  reason: collision with root package name */
        private final rx.subscriptions.b f63753d;

        /* renamed from: e  reason: collision with root package name */
        private final ScheduledExecutorService f63754e;

        /* renamed from: f  reason: collision with root package name */
        private final Future<?> f63755f;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.internal.schedulers.a$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        class ThreadFactoryC1309a implements ThreadFactory {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ ThreadFactory f63756a;

            ThreadFactoryC1309a(ThreadFactory threadFactory) {
                this.f63756a = threadFactory;
            }

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                Thread newThread = this.f63756a.newThread(runnable);
                newThread.setName(newThread.getName() + " (Evictor)");
                return newThread;
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.internal.schedulers.a$a$b */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        class b implements Runnable {
            b() {
            }

            @Override // java.lang.Runnable
            public void run() {
                C1308a.this.a();
            }
        }

        C1308a(ThreadFactory threadFactory, long j4, TimeUnit timeUnit) {
            ScheduledFuture<?> scheduledFuture;
            this.f63750a = threadFactory;
            long nanos = timeUnit != null ? timeUnit.toNanos(j4) : 0L;
            this.f63751b = nanos;
            this.f63752c = new ConcurrentLinkedQueue<>();
            this.f63753d = new rx.subscriptions.b();
            ScheduledExecutorService scheduledExecutorService = null;
            if (timeUnit != null) {
                scheduledExecutorService = Executors.newScheduledThreadPool(1, new ThreadFactoryC1309a(threadFactory));
                h.O(scheduledExecutorService);
                scheduledFuture = scheduledExecutorService.scheduleWithFixedDelay(new b(), nanos, nanos, TimeUnit.NANOSECONDS);
            } else {
                scheduledFuture = null;
            }
            this.f63754e = scheduledExecutorService;
            this.f63755f = scheduledFuture;
        }

        void a() {
            if (this.f63752c.isEmpty()) {
                return;
            }
            long c4 = c();
            Iterator<c> it = this.f63752c.iterator();
            while (it.hasNext()) {
                c next = it.next();
                if (next.P() > c4) {
                    return;
                }
                if (this.f63752c.remove(next)) {
                    this.f63753d.G(next);
                }
            }
        }

        c b() {
            if (this.f63753d.isUnsubscribed()) {
                return a.f63746e;
            }
            while (!this.f63752c.isEmpty()) {
                c poll = this.f63752c.poll();
                if (poll != null) {
                    return poll;
                }
            }
            c cVar = new c(this.f63750a);
            this.f63753d.a(cVar);
            return cVar;
        }

        long c() {
            return System.nanoTime();
        }

        void d(c cVar) {
            cVar.Q(c() + this.f63751b);
            this.f63752c.offer(cVar);
        }

        void e() {
            try {
                Future<?> future = this.f63755f;
                if (future != null) {
                    future.cancel(true);
                }
                ScheduledExecutorService scheduledExecutorService = this.f63754e;
                if (scheduledExecutorService != null) {
                    scheduledExecutorService.shutdownNow();
                }
            } finally {
                this.f63753d.unsubscribe();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: CachedThreadScheduler.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class b extends h.a implements rx.functions.a {

        /* renamed from: b  reason: collision with root package name */
        private final C1308a f63760b;

        /* renamed from: c  reason: collision with root package name */
        private final c f63761c;

        /* renamed from: a  reason: collision with root package name */
        private final rx.subscriptions.b f63759a = new rx.subscriptions.b();

        /* renamed from: d  reason: collision with root package name */
        final AtomicBoolean f63762d = new AtomicBoolean();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: CachedThreadScheduler.java */
        /* renamed from: rx.internal.schedulers.a$b$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        public class C1310a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.functions.a f63763a;

            C1310a(rx.functions.a aVar) {
                this.f63763a = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                if (b.this.isUnsubscribed()) {
                    return;
                }
                this.f63763a.call();
            }
        }

        b(C1308a c1308a) {
            this.f63760b = c1308a;
            this.f63761c = c1308a.b();
        }

        public rx.m F(rx.functions.a aVar, long j4, TimeUnit timeUnit) {
            if (this.f63759a.isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            ScheduledAction L2 = this.f63761c.L(new C1310a(aVar), j4, timeUnit);
            this.f63759a.a(L2);
            L2.addParent(this.f63759a);
            return L2;
        }

        @Override // rx.functions.a
        public void call() {
            this.f63760b.d(this.f63761c);
        }

        public rx.m d(rx.functions.a aVar) {
            return F(aVar, 0L, null);
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f63759a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f63762d.compareAndSet(false, true)) {
                this.f63761c.d(this);
            }
            this.f63759a.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: CachedThreadScheduler.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class c extends h {

        /* renamed from: l  reason: collision with root package name */
        private long f63765l;

        c(ThreadFactory threadFactory) {
            super(threadFactory);
            this.f63765l = 0L;
        }

        public long P() {
            return this.f63765l;
        }

        public void Q(long j4) {
            this.f63765l = j4;
        }
    }

    static {
        c cVar = new c(RxThreadFactory.NONE);
        f63746e = cVar;
        cVar.unsubscribe();
        C1308a c1308a = new C1308a(null, 0L, null);
        f63747f = c1308a;
        c1308a.e();
        f63744c = Integer.getInteger("rx.io-scheduler.keepalive", 60).intValue();
    }

    public a(ThreadFactory threadFactory) {
        this.f63748a = threadFactory;
        start();
    }

    @Override // rx.h
    public h.a a() {
        return new b(this.f63749b.get());
    }

    @Override // rx.internal.schedulers.j
    public void shutdown() {
        C1308a c1308a;
        C1308a c1308a2;
        do {
            c1308a = this.f63749b.get();
            c1308a2 = f63747f;
            if (c1308a == c1308a2) {
                return;
            }
        } while (!this.f63749b.compareAndSet(c1308a, c1308a2));
        c1308a.e();
    }

    @Override // rx.internal.schedulers.j
    public void start() {
        C1308a c1308a = new C1308a(this.f63748a, f63744c, f63745d);
        if (this.f63749b.compareAndSet(f63747f, c1308a)) {
            return;
        }
        c1308a.e();
    }
}
