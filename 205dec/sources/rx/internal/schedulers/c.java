package rx.internal.schedulers;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ExecutorScheduler.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class c extends rx.h {

    /* renamed from: a  reason: collision with root package name */
    final Executor f63783a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ExecutorScheduler.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a extends h.a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final Executor f63784a;

        /* renamed from: c  reason: collision with root package name */
        final ConcurrentLinkedQueue<ScheduledAction> f63786c = new ConcurrentLinkedQueue<>();

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f63787d = new AtomicInteger();

        /* renamed from: b  reason: collision with root package name */
        final rx.subscriptions.b f63785b = new rx.subscriptions.b();

        /* renamed from: e  reason: collision with root package name */
        final ScheduledExecutorService f63788e = d.a();

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: ExecutorScheduler.java */
        /* renamed from: rx.internal.schedulers.c$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        class C1314a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.c f63789a;

            C1314a(rx.subscriptions.c cVar) {
                this.f63789a = cVar;
            }

            @Override // rx.functions.a
            public void call() {
                a.this.f63785b.G(this.f63789a);
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: ExecutorScheduler.java */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        class b implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.c f63791a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ rx.functions.a f63792b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ rx.m f63793c;

            b(rx.subscriptions.c cVar, rx.functions.a aVar, rx.m mVar) {
                this.f63791a = cVar;
                this.f63792b = aVar;
                this.f63793c = mVar;
            }

            @Override // rx.functions.a
            public void call() {
                if (this.f63791a.isUnsubscribed()) {
                    return;
                }
                rx.m d4 = a.this.d(this.f63792b);
                this.f63791a.b(d4);
                if (d4.getClass() == ScheduledAction.class) {
                    ((ScheduledAction) d4).add(this.f63793c);
                }
            }
        }

        public a(Executor executor) {
            this.f63784a = executor;
        }

        public rx.m F(rx.functions.a aVar, long j4, TimeUnit timeUnit) {
            if (j4 <= 0) {
                return d(aVar);
            }
            if (isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            rx.functions.a P = rx.plugins.c.P(aVar);
            rx.subscriptions.c cVar = new rx.subscriptions.c();
            rx.subscriptions.c cVar2 = new rx.subscriptions.c();
            cVar2.b(cVar);
            this.f63785b.a(cVar2);
            rx.m a4 = rx.subscriptions.f.a(new C1314a(cVar2));
            ScheduledAction scheduledAction = new ScheduledAction(new b(cVar2, P, a4));
            cVar.b(scheduledAction);
            try {
                scheduledAction.add(this.f63788e.schedule(scheduledAction, j4, timeUnit));
                return a4;
            } catch (RejectedExecutionException e4) {
                rx.plugins.c.I(e4);
                throw e4;
            }
        }

        public rx.m d(rx.functions.a aVar) {
            if (isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            ScheduledAction scheduledAction = new ScheduledAction(rx.plugins.c.P(aVar), this.f63785b);
            this.f63785b.a(scheduledAction);
            this.f63786c.offer(scheduledAction);
            if (this.f63787d.getAndIncrement() == 0) {
                try {
                    this.f63784a.execute(this);
                } catch (RejectedExecutionException e4) {
                    this.f63785b.G(scheduledAction);
                    this.f63787d.decrementAndGet();
                    rx.plugins.c.I(e4);
                    throw e4;
                }
            }
            return scheduledAction;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f63785b.isUnsubscribed();
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f63785b.isUnsubscribed()) {
                ScheduledAction poll = this.f63786c.poll();
                if (poll == null) {
                    return;
                }
                if (!poll.isUnsubscribed()) {
                    if (!this.f63785b.isUnsubscribed()) {
                        poll.run();
                    } else {
                        this.f63786c.clear();
                        return;
                    }
                }
                if (this.f63787d.decrementAndGet() == 0) {
                    return;
                }
            }
            this.f63786c.clear();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f63785b.unsubscribe();
            this.f63786c.clear();
        }
    }

    public c(Executor executor) {
        this.f63783a = executor;
    }

    @Override // rx.h
    public h.a a() {
        return new a(this.f63783a);
    }
}
