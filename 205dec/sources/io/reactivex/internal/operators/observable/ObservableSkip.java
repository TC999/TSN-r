package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ObservableSkip<T> extends AbstractObservableWithUpstream<T, T> {

    /* renamed from: n  reason: collision with root package name */
    final long f55098n;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class SkipObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;

        /* renamed from: d  reason: collision with root package name */
        Disposable f55099d;
        long remaining;

        SkipObserver(Observer<? super T> observer, long j4) {
            this.actual = observer;
            this.remaining = j4;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f55099d.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f55099d.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t3) {
            long j4 = this.remaining;
            if (j4 != 0) {
                this.remaining = j4 - 1;
            } else {
                this.actual.onNext(t3);
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f55099d = disposable;
            this.actual.onSubscribe(this);
        }
    }

    public ObservableSkip(ObservableSource<T> observableSource, long j4) {
        super(observableSource);
        this.f55098n = j4;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new SkipObserver(observer, this.f55098n));
    }
}
