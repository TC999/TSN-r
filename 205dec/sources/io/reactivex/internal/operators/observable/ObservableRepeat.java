package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.SequentialDisposable;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ObservableRepeat<T> extends AbstractObservableWithUpstream<T, T> {
    final long count;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class RepeatObserver<T> extends AtomicInteger implements Observer<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final Observer<? super T> actual;
        long remaining;
        final SequentialDisposable sd;
        final ObservableSource<? extends T> source;

        RepeatObserver(Observer<? super T> observer, long j4, SequentialDisposable sequentialDisposable, ObservableSource<? extends T> observableSource) {
            this.actual = observer;
            this.sd = sequentialDisposable;
            this.source = observableSource;
            this.remaining = j4;
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            long j4 = this.remaining;
            if (j4 != Long.MAX_VALUE) {
                this.remaining = j4 - 1;
            }
            if (j4 != 0) {
                subscribeNext();
            } else {
                this.actual.onComplete();
            }
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t3) {
            this.actual.onNext(t3);
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            this.sd.replace(disposable);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int i4 = 1;
                while (!this.sd.isDisposed()) {
                    this.source.subscribe(this);
                    i4 = addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                }
            }
        }
    }

    public ObservableRepeat(Observable<T> observable, long j4) {
        super(observable);
        this.count = j4;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        SequentialDisposable sequentialDisposable = new SequentialDisposable();
        observer.onSubscribe(sequentialDisposable);
        long j4 = this.count;
        new RepeatObserver(observer, j4 != Long.MAX_VALUE ? j4 - 1 : Long.MAX_VALUE, sequentialDisposable, this.source).subscribeNext();
    }
}
