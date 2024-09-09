package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.ObserverFullArbiter;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class FullArbiterObserver<T> implements Observer<T> {
    final ObserverFullArbiter<T> arbiter;

    /* renamed from: s  reason: collision with root package name */
    Disposable f54858s;

    public FullArbiterObserver(ObserverFullArbiter<T> observerFullArbiter) {
        this.arbiter = observerFullArbiter;
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        this.arbiter.onComplete(this.f54858s);
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.arbiter.onError(th, this.f54858s);
    }

    @Override // io.reactivex.Observer
    public void onNext(T t3) {
        this.arbiter.onNext(t3, this.f54858s);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f54858s, disposable)) {
            this.f54858s = disposable;
            this.arbiter.setDisposable(disposable);
        }
    }
}
