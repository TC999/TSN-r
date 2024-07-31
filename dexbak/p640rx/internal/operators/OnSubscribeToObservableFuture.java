package p640rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.internal.producers.SingleProducer;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.j1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeToObservableFuture {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeToObservableFuture.java */
    /* renamed from: rx.internal.operators.j1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15761a<T> implements Observable.InterfaceC15567a<T> {

        /* renamed from: a */
        final Future<? extends T> f45386a;

        /* renamed from: b */
        private final long f45387b;

        /* renamed from: c */
        private final TimeUnit f45388c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeToObservableFuture.java */
        /* renamed from: rx.internal.operators.j1$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15762a implements Action0 {
            C15762a() {
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15761a.this.f45386a.cancel(true);
            }
        }

        public C15761a(Future<? extends T> future) {
            this.f45386a = future;
            this.f45387b = 0L;
            this.f45388c = null;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            subscriber.add(Subscriptions.m346a(new C15762a()));
            try {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                TimeUnit timeUnit = this.f45388c;
                subscriber.setProducer(new SingleProducer(subscriber, timeUnit == null ? this.f45386a.get() : this.f45386a.get(this.f45387b, timeUnit)));
            } catch (Throwable th) {
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                C15575a.m1473f(th, subscriber);
            }
        }

        public C15761a(Future<? extends T> future, long j, TimeUnit timeUnit) {
            this.f45386a = future;
            this.f45387b = j;
            this.f45388c = timeUnit;
        }
    }

    private OnSubscribeToObservableFuture() {
        throw new IllegalStateException("No instances!");
    }

    /* renamed from: a */
    public static <T> Observable.InterfaceC15567a<T> m1200a(Future<? extends T> future) {
        return new C15761a(future);
    }

    /* renamed from: b */
    public static <T> Observable.InterfaceC15567a<T> m1199b(Future<? extends T> future, long j, TimeUnit timeUnit) {
        return new C15761a(future, j, timeUnit);
    }
}
