package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> upstream;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class SubscriberObserver<T> implements Observer<T>, Subscription {

        /* renamed from: d  reason: collision with root package name */
        private Disposable f54925d;

        /* renamed from: s  reason: collision with root package name */
        private final Subscriber<? super T> f54926s;

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.f54926s = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f54925d.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f54926s.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f54926s.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t3) {
            this.f54926s.onNext(t3);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f54925d = disposable;
            this.f54926s.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j4) {
        }
    }

    public FlowableFromObservable(Observable<T> observable) {
        this.upstream = observable;
    }

    @Override // io.reactivex.Flowable
    protected void subscribeActual(Subscriber<? super T> subscriber) {
        this.upstream.subscribe(new SubscriberObserver(subscriber));
    }
}
