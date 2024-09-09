package io.reactivex.internal.observers;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class DeferredScalarObserver<T, R> extends DeferredScalarDisposable<R> implements Observer<T> {
    private static final long serialVersionUID = -266195175408988651L;

    /* renamed from: s  reason: collision with root package name */
    protected Disposable f54856s;

    public DeferredScalarObserver(Observer<? super R> observer) {
        super(observer);
    }

    @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
    public void dispose() {
        super.dispose();
        this.f54856s.dispose();
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        T t3 = this.value;
        if (t3 != null) {
            this.value = null;
            complete(t3);
            return;
        }
        complete();
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        this.value = null;
        error(th);
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (DisposableHelper.validate(this.f54856s, disposable)) {
            this.f54856s = disposable;
            this.actual.onSubscribe(this);
        }
    }
}
