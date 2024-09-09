package rx.internal.schedulers;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.exceptions.OnErrorNotImplementedException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class ScheduledAction extends AtomicReference<Thread> implements Runnable, rx.m {
    private static final long serialVersionUID = -3962399486978279857L;
    final rx.functions.a action;
    final rx.internal.util.m cancel;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    final class a implements rx.m {

        /* renamed from: a  reason: collision with root package name */
        private final Future<?> f63738a;

        a(Future<?> future) {
            this.f63738a = future;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f63738a.isCancelled();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (ScheduledAction.this.get() != Thread.currentThread()) {
                this.f63738a.cancel(true);
            } else {
                this.f63738a.cancel(false);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class b extends AtomicBoolean implements rx.m {
        private static final long serialVersionUID = 247232374289553518L;

        /* renamed from: a  reason: collision with root package name */
        final ScheduledAction f63740a;

        /* renamed from: b  reason: collision with root package name */
        final rx.internal.util.m f63741b;

        public b(ScheduledAction scheduledAction, rx.internal.util.m mVar) {
            this.f63740a = scheduledAction;
            this.f63741b = mVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f63740a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f63741b.F(this.f63740a);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class c extends AtomicBoolean implements rx.m {
        private static final long serialVersionUID = 247232374289553518L;

        /* renamed from: a  reason: collision with root package name */
        final ScheduledAction f63742a;

        /* renamed from: b  reason: collision with root package name */
        final rx.subscriptions.b f63743b;

        public c(ScheduledAction scheduledAction, rx.subscriptions.b bVar) {
            this.f63742a = scheduledAction;
            this.f63743b = bVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f63742a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f63743b.G(this.f63742a);
            }
        }
    }

    public ScheduledAction(rx.functions.a aVar) {
        this.action = aVar;
        this.cancel = new rx.internal.util.m();
    }

    public void add(rx.m mVar) {
        this.cancel.a(mVar);
    }

    public void addParent(rx.subscriptions.b bVar) {
        this.cancel.a(new c(this, bVar));
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.cancel.isUnsubscribed();
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            try {
                lazySet(Thread.currentThread());
                this.action.call();
            } catch (OnErrorNotImplementedException e4) {
                signalError(new IllegalStateException("Exception thrown on Scheduler.Worker thread. Add `onError` handling.", e4));
            } catch (Throwable th) {
                signalError(new IllegalStateException("Fatal Exception thrown on Scheduler.Worker thread.", th));
            }
        } finally {
            unsubscribe();
        }
    }

    void signalError(Throwable th) {
        rx.plugins.c.I(th);
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    @Override // rx.m
    public void unsubscribe() {
        if (this.cancel.isUnsubscribed()) {
            return;
        }
        this.cancel.unsubscribe();
    }

    public void add(Future<?> future) {
        this.cancel.a(new a(future));
    }

    public void addParent(rx.internal.util.m mVar) {
        this.cancel.a(new b(this, mVar));
    }

    public ScheduledAction(rx.functions.a aVar, rx.subscriptions.b bVar) {
        this.action = aVar;
        this.cancel = new rx.internal.util.m(new c(this, bVar));
    }

    public ScheduledAction(rx.functions.a aVar, rx.internal.util.m mVar) {
        this.action = aVar;
        this.cancel = new rx.internal.util.m(new b(this, mVar));
    }
}
