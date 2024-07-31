package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class MaybeFromFuture<T> extends Maybe<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public MaybeFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.future = future;
        this.timeout = j;
        this.unit = timeUnit;
    }

    @Override // io.reactivex.Maybe
    protected void subscribeActual(MaybeObserver<? super T> maybeObserver) {
        Object obj;
        Disposable empty = Disposables.empty();
        maybeObserver.onSubscribe(empty);
        if (empty.isDisposed()) {
            return;
        }
        try {
            long j = this.timeout;
            if (j <= 0) {
                obj = (T) this.future.get();
            } else {
                obj = (T) this.future.get(j, this.unit);
            }
            if (empty.isDisposed()) {
                return;
            }
            if (obj == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(obj);
            }
        } catch (InterruptedException e) {
            if (empty.isDisposed()) {
                return;
            }
            maybeObserver.onError(e);
        } catch (ExecutionException e2) {
            if (empty.isDisposed()) {
                return;
            }
            maybeObserver.onError(e2.getCause());
        } catch (TimeoutException e3) {
            if (empty.isDisposed()) {
                return;
            }
            maybeObserver.onError(e3);
        }
    }
}
