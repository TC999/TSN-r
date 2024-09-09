package rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: BlockingOperatorToFuture.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BlockingOperatorToFuture.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f62512a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference f62513b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicReference f62514c;

        a(CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f62512a = countDownLatch;
            this.f62513b = atomicReference;
            this.f62514c = atomicReference2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62512a.countDown();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62513b.compareAndSet(null, th);
            this.f62512a.countDown();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62514c.set(t3);
        }
    }

    private e() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Future<T> a(rx.e<? extends T> eVar) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        return new b(countDownLatch, eVar.P4().q5(new a(countDownLatch, atomicReference2, atomicReference)), atomicReference2, atomicReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: BlockingOperatorToFuture.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b<T> implements Future<T> {

        /* renamed from: a  reason: collision with root package name */
        private volatile boolean f62515a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f62516b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.m f62517c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AtomicReference f62518d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ AtomicReference f62519e;

        b(CountDownLatch countDownLatch, rx.m mVar, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f62516b = countDownLatch;
            this.f62517c = mVar;
            this.f62518d = atomicReference;
            this.f62519e = atomicReference2;
        }

        private T a() throws ExecutionException {
            Throwable th = (Throwable) this.f62518d.get();
            if (th == null) {
                if (!this.f62515a) {
                    return (T) this.f62519e.get();
                }
                throw new CancellationException("Subscription unsubscribed");
            }
            throw new ExecutionException("Observable onError", th);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z3) {
            if (this.f62516b.getCount() > 0) {
                this.f62515a = true;
                this.f62517c.unsubscribe();
                this.f62516b.countDown();
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            this.f62516b.await();
            return a();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f62515a;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f62516b.getCount() == 0;
        }

        @Override // java.util.concurrent.Future
        public T get(long j4, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            if (this.f62516b.await(j4, timeUnit)) {
                return a();
            }
            throw new TimeoutException("Timed out after " + timeUnit.toMillis(j4) + "ms waiting for underlying Observable.");
        }
    }
}
