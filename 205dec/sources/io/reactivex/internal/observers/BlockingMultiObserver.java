package io.reactivex.internal.observers;

import io.reactivex.CompletableObserver;
import io.reactivex.MaybeObserver;
import io.reactivex.SingleObserver;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.util.BlockingHelper;
import io.reactivex.internal.util.ExceptionHelper;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class BlockingMultiObserver<T> extends CountDownLatch implements SingleObserver<T>, CompletableObserver, MaybeObserver<T> {
    volatile boolean cancelled;

    /* renamed from: d  reason: collision with root package name */
    Disposable f54855d;
    Throwable error;
    T value;

    public BlockingMultiObserver() {
        super(1);
    }

    public boolean blockingAwait(long j4, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j4, timeUnit)) {
                    dispose();
                    return false;
                }
            } catch (InterruptedException e4) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e4);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            return true;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public T blockingGet() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e4) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e4);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            return this.value;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }

    public Throwable blockingGetError() {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e4) {
                dispose();
                return e4;
            }
        }
        return this.error;
    }

    void dispose() {
        this.cancelled = true;
        Disposable disposable = this.f54855d;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.CompletableObserver, io.reactivex.MaybeObserver
    public void onComplete() {
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onError(Throwable th) {
        this.error = th;
        countDown();
    }

    @Override // io.reactivex.SingleObserver
    public void onSubscribe(Disposable disposable) {
        this.f54855d = disposable;
        if (this.cancelled) {
            disposable.dispose();
        }
    }

    @Override // io.reactivex.SingleObserver
    public void onSuccess(T t3) {
        this.value = t3;
        countDown();
    }

    public Throwable blockingGetError(long j4, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                if (!await(j4, timeUnit)) {
                    dispose();
                    throw ExceptionHelper.wrapOrThrow(new TimeoutException());
                }
            } catch (InterruptedException e4) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e4);
            }
        }
        return this.error;
    }

    public T blockingGet(T t3) {
        if (getCount() != 0) {
            try {
                BlockingHelper.verifyNonBlocking();
                await();
            } catch (InterruptedException e4) {
                dispose();
                throw ExceptionHelper.wrapOrThrow(e4);
            }
        }
        Throwable th = this.error;
        if (th == null) {
            T t4 = this.value;
            return t4 != null ? t4 : t3;
        }
        throw ExceptionHelper.wrapOrThrow(th);
    }
}
