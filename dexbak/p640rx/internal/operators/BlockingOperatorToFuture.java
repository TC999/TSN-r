package p640rx.internal.operators;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.Subscription;

/* renamed from: rx.internal.operators.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class BlockingOperatorToFuture {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: BlockingOperatorToFuture.java */
    /* renamed from: rx.internal.operators.e$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15692a<T> extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ CountDownLatch f45081a;

        /* renamed from: b */
        final /* synthetic */ AtomicReference f45082b;

        /* renamed from: c */
        final /* synthetic */ AtomicReference f45083c;

        C15692a(CountDownLatch countDownLatch, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f45081a = countDownLatch;
            this.f45082b = atomicReference;
            this.f45083c = atomicReference2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45081a.countDown();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45082b.compareAndSet(null, th);
            this.f45081a.countDown();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45083c.set(t);
        }
    }

    private BlockingOperatorToFuture() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> Future<T> m1275a(Observable<? extends T> observable) {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        AtomicReference atomicReference = new AtomicReference();
        AtomicReference atomicReference2 = new AtomicReference();
        return new FutureC15693b(countDownLatch, observable.m1768P4().m1551q5(new C15692a(countDownLatch, atomicReference2, atomicReference)), atomicReference2, atomicReference);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* compiled from: BlockingOperatorToFuture.java */
    /* renamed from: rx.internal.operators.e$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class FutureC15693b<T> implements Future<T> {

        /* renamed from: a */
        private volatile boolean f45084a;

        /* renamed from: b */
        final /* synthetic */ CountDownLatch f45085b;

        /* renamed from: c */
        final /* synthetic */ Subscription f45086c;

        /* renamed from: d */
        final /* synthetic */ AtomicReference f45087d;

        /* renamed from: e */
        final /* synthetic */ AtomicReference f45088e;

        FutureC15693b(CountDownLatch countDownLatch, Subscription subscription, AtomicReference atomicReference, AtomicReference atomicReference2) {
            this.f45085b = countDownLatch;
            this.f45086c = subscription;
            this.f45087d = atomicReference;
            this.f45088e = atomicReference2;
        }

        /* renamed from: a */
        private T m1274a() throws ExecutionException {
            Throwable th = (Throwable) this.f45087d.get();
            if (th == null) {
                if (!this.f45084a) {
                    return (T) this.f45088e.get();
                }
                throw new CancellationException("Subscription unsubscribed");
            }
            throw new ExecutionException("Observable onError", th);
        }

        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            if (this.f45085b.getCount() > 0) {
                this.f45084a = true;
                this.f45086c.unsubscribe();
                this.f45085b.countDown();
                return true;
            }
            return false;
        }

        @Override // java.util.concurrent.Future
        public T get() throws InterruptedException, ExecutionException {
            this.f45085b.await();
            return m1274a();
        }

        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return this.f45084a;
        }

        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return this.f45085b.getCount() == 0;
        }

        @Override // java.util.concurrent.Future
        public T get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
            if (this.f45085b.await(j, timeUnit)) {
                return m1274a();
            }
            throw new TimeoutException("Timed out after " + timeUnit.toMillis(j) + "ms waiting for underlying Observable.");
        }
    }
}
