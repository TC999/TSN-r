package io.reactivex.observers;

import io.reactivex.Observer;
import io.reactivex.annotations.NonNull;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.util.EndConsumerHelper;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class DefaultObserver<T> implements Observer<T> {

    /* renamed from: s  reason: collision with root package name */
    private Disposable f55192s;

    protected final void cancel() {
        Disposable disposable = this.f55192s;
        this.f55192s = DisposableHelper.DISPOSED;
        disposable.dispose();
    }

    protected void onStart() {
    }

    @Override // io.reactivex.Observer
    public final void onSubscribe(@NonNull Disposable disposable) {
        if (EndConsumerHelper.validate(this.f55192s, disposable, getClass())) {
            this.f55192s = disposable;
            onStart();
        }
    }
}
