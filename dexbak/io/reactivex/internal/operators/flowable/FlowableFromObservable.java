package io.reactivex.internal.operators.flowable;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class FlowableFromObservable<T> extends Flowable<T> {
    private final Observable<T> upstream;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class SubscriberObserver<T> implements Observer<T>, Subscription {

        /* renamed from: d */
        private Disposable f40450d;

        /* renamed from: s */
        private final Subscriber<? super T> f40451s;

        SubscriberObserver(Subscriber<? super T> subscriber) {
            this.f40451s = subscriber;
        }

        @Override // org.reactivestreams.Subscription
        public void cancel() {
            this.f40450d.dispose();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f40451s.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f40451s.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
            this.f40451s.onNext(t);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f40450d = disposable;
            this.f40451s.onSubscribe(this);
        }

        @Override // org.reactivestreams.Subscription
        public void request(long j) {
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
