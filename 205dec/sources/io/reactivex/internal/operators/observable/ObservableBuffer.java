package io.reactivex.internal.operators.observable;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.exceptions.Exceptions;
import io.reactivex.internal.disposables.DisposableHelper;
import io.reactivex.internal.disposables.EmptyDisposable;
import io.reactivex.internal.functions.ObjectHelper;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ObservableBuffer<T, U extends Collection<? super T>> extends AbstractObservableWithUpstream<T, U> {
    final Callable<U> bufferSupplier;
    final int count;
    final int skip;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class BufferExactObserver<T, U extends Collection<? super T>> implements Observer<T>, Disposable {
        final Observer<? super U> actual;
        U buffer;
        final Callable<U> bufferSupplier;
        final int count;

        /* renamed from: s  reason: collision with root package name */
        Disposable f55032s;
        int size;

        BufferExactObserver(Observer<? super U> observer, int i4, Callable<U> callable) {
            this.actual = observer;
            this.count = i4;
            this.bufferSupplier = callable;
        }

        boolean createBuffer() {
            try {
                this.buffer = (U) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                Exceptions.throwIfFatal(th);
                this.buffer = null;
                Disposable disposable = this.f55032s;
                if (disposable == null) {
                    EmptyDisposable.error(th, this.actual);
                    return false;
                }
                disposable.dispose();
                this.actual.onError(th);
                return false;
            }
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f55032s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f55032s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            U u3 = this.buffer;
            this.buffer = null;
            if (u3 != null && !u3.isEmpty()) {
                this.actual.onNext(u3);
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.buffer = null;
            this.actual.onError(th);
        }

        @Override // io.reactivex.Observer
        public void onNext(T t3) {
            U u3 = this.buffer;
            if (u3 != null) {
                u3.add(t3);
                int i4 = this.size + 1;
                this.size = i4;
                if (i4 >= this.count) {
                    this.actual.onNext(u3);
                    this.size = 0;
                    createBuffer();
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f55032s, disposable)) {
                this.f55032s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class BufferSkipObserver<T, U extends Collection<? super T>> extends AtomicBoolean implements Observer<T>, Disposable {
        private static final long serialVersionUID = -8223395059921494546L;
        final Observer<? super U> actual;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        long index;

        /* renamed from: s  reason: collision with root package name */
        Disposable f55033s;
        final int skip;

        BufferSkipObserver(Observer<? super U> observer, int i4, int i5, Callable<U> callable) {
            this.actual = observer;
            this.count = i4;
            this.skip = i5;
            this.bufferSupplier = callable;
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            this.f55033s.dispose();
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return this.f55033s.isDisposed();
        }

        @Override // io.reactivex.Observer
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.actual.onNext(this.buffers.poll());
            }
            this.actual.onComplete();
        }

        @Override // io.reactivex.Observer
        public void onError(Throwable th) {
            this.buffers.clear();
            this.actual.onError(th);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // io.reactivex.Observer
        public void onNext(T t3) {
            long j4 = this.index;
            this.index = 1 + j4;
            if (j4 % this.skip == 0) {
                try {
                    this.buffers.offer((Collection) ObjectHelper.requireNonNull(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources."));
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.f55033s.dispose();
                    this.actual.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t3);
                if (this.count <= next.size()) {
                    it.remove();
                    this.actual.onNext(next);
                }
            }
        }

        @Override // io.reactivex.Observer
        public void onSubscribe(Disposable disposable) {
            if (DisposableHelper.validate(this.f55033s, disposable)) {
                this.f55033s = disposable;
                this.actual.onSubscribe(this);
            }
        }
    }

    public ObservableBuffer(ObservableSource<T> observableSource, int i4, int i5, Callable<U> callable) {
        super(observableSource);
        this.count = i4;
        this.skip = i5;
        this.bufferSupplier = callable;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super U> observer) {
        int i4 = this.skip;
        int i5 = this.count;
        if (i4 == i5) {
            BufferExactObserver bufferExactObserver = new BufferExactObserver(observer, i5, this.bufferSupplier);
            if (bufferExactObserver.createBuffer()) {
                this.source.subscribe(bufferExactObserver);
                return;
            }
            return;
        }
        this.source.subscribe(new BufferSkipObserver(observer, this.count, this.skip, this.bufferSupplier));
    }
}
