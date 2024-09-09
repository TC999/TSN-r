package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.NoSuchElementException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ObservableElementAt<T> extends AbstractObservableWithUpstream<T, T> {
    final T defaultValue;
    final boolean errorOnFewer;
    final long index;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class ElementAtObserver<T> implements Observer<T>, Disposable {
        final Observer<? super T> actual;
        long count;
        final T defaultValue;
        boolean done;
        final boolean errorOnFewer;
        final long index;

        /* renamed from: s  reason: collision with root package name */
        Disposable f55061s;

        ElementAtObserver(Observer<? super T> observer, long j4, T t3, boolean z3) {
            this.actual = observer;
            this.index = j4;
            this.defaultValue = t3;
            this.errorOnFewer = z3;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f55061s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f55061s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            T t3 = this.defaultValue;
            if (t3 == null && this.errorOnFewer) {
                this.actual.onError(new NoSuchElementException());
                return;
            }
            if (t3 != null) {
                this.actual.onNext(t3);
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            if (this.done) {
                RxJavaPlugins.onError(th);
                return;
            }
            this.done = true;
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t3) {
            if (this.done) {
                return;
            }
            long j4 = this.count;
            if (j4 == this.index) {
                this.done = true;
                this.f55061s.dispose();
                this.actual.onNext(t3);
                this.actual.onComplete();
                return;
            }
            this.count = j4 + 1;
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f55061s, disposable)) {
                this.f55061s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableElementAt(ObservableSource<T> observableSource, long j4, T t3, boolean z3) {
        super(observableSource);
        this.index = j4;
        this.defaultValue = t3;
        this.errorOnFewer = z3;
    }

    @Override // io.reactivex.Observable
    public void subscribeActual(Observer<? super T> observer) {
        this.source.subscribe(new ElementAtObserver(observer, this.index, this.defaultValue, this.errorOnFewer));
    }
}
