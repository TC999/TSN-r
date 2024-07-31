package io.reactivex.internal.operators.completable;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CompletableFromObservable<T> extends Completable {
    final ObservableSource<T> observable;

    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class CompletableFromObservableObserver<T> implements Observer<T> {

        /* renamed from: co */
        final CompletableObserver f40389co;

        CompletableFromObservableObserver(CompletableObserver completableObserver) {
            this.f40389co = completableObserver;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            this.f40389co.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.f40389co.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t) {
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.f40389co.onSubscribe(disposable);
        }
    }

    public CompletableFromObservable(ObservableSource<T> observableSource) {
        this.observable = observableSource;
    }

    @Override // io.reactivex.Completable
    protected void subscribeActual(CompletableObserver completableObserver) {
        this.observable.subscribe(new CompletableFromObservableObserver(completableObserver));
    }
}
