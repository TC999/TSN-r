package io.reactivex.subjects;

import io.reactivex.Observer;
import io.reactivex.annotations.CheckReturnValue;
import io.reactivex.disposables.Disposable;
import io.reactivex.internal.observers.DeferredScalarDisposable;
import io.reactivex.plugins.RxJavaPlugins;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class AsyncSubject<T> extends Subject<T> {
    static final AsyncDisposable[] EMPTY = new AsyncDisposable[0];
    static final AsyncDisposable[] TERMINATED = new AsyncDisposable[0];
    Throwable error;
    final AtomicReference<AsyncDisposable<T>[]> subscribers = new AtomicReference<>(EMPTY);
    T value;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class AsyncDisposable<T> extends DeferredScalarDisposable<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final AsyncSubject<T> parent;

        AsyncDisposable(Observer<? super T> observer, AsyncSubject<T> asyncSubject) {
            super(observer);
            this.parent = asyncSubject;
        }

        @Override // io.reactivex.internal.observers.DeferredScalarDisposable, io.reactivex.disposables.Disposable
        public void dispose() {
            if (super.tryDispose()) {
                this.parent.remove(this);
            }
        }

        void onComplete() {
            if (isDisposed()) {
                return;
            }
            this.actual.onComplete();
        }

        void onError(Throwable th) {
            if (isDisposed()) {
                RxJavaPlugins.onError(th);
            } else {
                this.actual.onError(th);
            }
        }
    }

    AsyncSubject() {
    }

    @CheckReturnValue
    public static <T> AsyncSubject<T> create() {
        return new AsyncSubject<>();
    }

    boolean add(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable<T>[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.subscribers.get();
            if (asyncDisposableArr == TERMINATED) {
                return false;
            }
            int length = asyncDisposableArr.length;
            asyncDisposableArr2 = new AsyncDisposable[length + 1];
            System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr2, 0, length);
            asyncDisposableArr2[length] = asyncDisposable;
        } while (!this.subscribers.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
        return true;
    }

    @Override // io.reactivex.subjects.Subject
    public Throwable getThrowable() {
        if (this.subscribers.get() == TERMINATED) {
            return this.error;
        }
        return null;
    }

    public T getValue() {
        if (this.subscribers.get() == TERMINATED) {
            return this.value;
        }
        return null;
    }

    public Object[] getValues() {
        T value = getValue();
        return value != null ? new Object[]{value} : new Object[0];
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasComplete() {
        return this.subscribers.get() == TERMINATED && this.error == null;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasObservers() {
        return this.subscribers.get().length != 0;
    }

    @Override // io.reactivex.subjects.Subject
    public boolean hasThrowable() {
        return this.subscribers.get() == TERMINATED && this.error != null;
    }

    public boolean hasValue() {
        return this.subscribers.get() == TERMINATED && this.value != null;
    }

    void nullOnNext() {
        this.value = null;
        NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.error = nullPointerException;
        for (AsyncDisposable<T> asyncDisposable : this.subscribers.getAndSet(TERMINATED)) {
            asyncDisposable.onError(nullPointerException);
        }
    }

    @Override // io.reactivex.Observer
    public void onComplete() {
        AsyncDisposable<T>[] asyncDisposableArr = this.subscribers.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = TERMINATED;
        if (asyncDisposableArr == asyncDisposableArr2) {
            return;
        }
        T t3 = this.value;
        AsyncDisposable<T>[] andSet = this.subscribers.getAndSet(asyncDisposableArr2);
        int i4 = 0;
        if (t3 == null) {
            int length = andSet.length;
            while (i4 < length) {
                andSet[i4].onComplete();
                i4++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i4 < length2) {
            andSet[i4].complete(t3);
            i4++;
        }
    }

    @Override // io.reactivex.Observer
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        AsyncDisposable<T>[] asyncDisposableArr = this.subscribers.get();
        AsyncDisposable<T>[] asyncDisposableArr2 = TERMINATED;
        if (asyncDisposableArr == asyncDisposableArr2) {
            RxJavaPlugins.onError(th);
            return;
        }
        this.value = null;
        this.error = th;
        for (AsyncDisposable<T> asyncDisposable : this.subscribers.getAndSet(asyncDisposableArr2)) {
            asyncDisposable.onError(th);
        }
    }

    @Override // io.reactivex.Observer
    public void onNext(T t3) {
        if (this.subscribers.get() == TERMINATED) {
            return;
        }
        if (t3 == null) {
            nullOnNext();
        } else {
            this.value = t3;
        }
    }

    @Override // io.reactivex.Observer
    public void onSubscribe(Disposable disposable) {
        if (this.subscribers.get() == TERMINATED) {
            disposable.dispose();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    void remove(AsyncDisposable<T> asyncDisposable) {
        AsyncDisposable<T>[] asyncDisposableArr;
        AsyncDisposable[] asyncDisposableArr2;
        do {
            asyncDisposableArr = this.subscribers.get();
            int length = asyncDisposableArr.length;
            if (length == 0) {
                return;
            }
            int i4 = -1;
            int i5 = 0;
            while (true) {
                if (i5 >= length) {
                    break;
                } else if (asyncDisposableArr[i5] == asyncDisposable) {
                    i4 = i5;
                    break;
                } else {
                    i5++;
                }
            }
            if (i4 < 0) {
                return;
            }
            if (length == 1) {
                asyncDisposableArr2 = EMPTY;
            } else {
                AsyncDisposable[] asyncDisposableArr3 = new AsyncDisposable[length - 1];
                System.arraycopy(asyncDisposableArr, 0, asyncDisposableArr3, 0, i4);
                System.arraycopy(asyncDisposableArr, i4 + 1, asyncDisposableArr3, i4, (length - i4) - 1);
                asyncDisposableArr2 = asyncDisposableArr3;
            }
        } while (!this.subscribers.compareAndSet(asyncDisposableArr, asyncDisposableArr2));
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super T> observer) {
        AsyncDisposable<T> asyncDisposable = new AsyncDisposable<>(observer, this);
        observer.onSubscribe(asyncDisposable);
        if (add(asyncDisposable)) {
            if (asyncDisposable.isDisposed()) {
                remove(asyncDisposable);
                return;
            }
            return;
        }
        Throwable th = this.error;
        if (th != null) {
            observer.onError(th);
            return;
        }
        T t3 = this.value;
        if (t3 != null) {
            asyncDisposable.complete(t3);
        } else {
            asyncDisposable.onComplete();
        }
    }

    public T[] getValues(T[] tArr) {
        T value = getValue();
        if (value == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = value;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }
}
