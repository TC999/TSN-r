package io.reactivex.internal.operators.maybe;

import io.reactivex.Maybe;
import io.reactivex.MaybeObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class MaybeFromFuture<T> extends Maybe<T> {
    final Future<? extends T> future;
    final long timeout;
    final TimeUnit unit;

    public MaybeFromFuture(Future<? extends T> future, long j4, TimeUnit timeUnit) {
        this.future = future;
        this.timeout = j4;
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
            long j4 = this.timeout;
            if (j4 <= 0) {
                obj = (T) this.future.get();
            } else {
                obj = (T) this.future.get(j4, this.unit);
            }
            if (empty.isDisposed()) {
                return;
            }
            if (obj == null) {
                maybeObserver.onComplete();
            } else {
                maybeObserver.onSuccess(obj);
            }
        } catch (InterruptedException e4) {
            if (empty.isDisposed()) {
                return;
            }
            maybeObserver.onError(e4);
        } catch (ExecutionException e5) {
            if (empty.isDisposed()) {
                return;
            }
            maybeObserver.onError(e5.getCause());
        } catch (TimeoutException e6) {
            if (empty.isDisposed()) {
                return;
            }
            maybeObserver.onError(e6);
        }
    }
}
