package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ObservableRangeLong extends Observable<Long> {
    private final long count;
    private final long start;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class RangeDisposable extends BasicIntQueueDisposable<Long> {
        private static final long serialVersionUID = 396518478098735504L;
        final Observer<? super Long> actual;
        final long end;
        boolean fused;
        long index;

        RangeDisposable(Observer<? super Long> observer, long j4, long j5) {
            this.actual = observer;
            this.index = j4;
            this.end = j5;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public void clear() {
            this.index = this.end;
            lazySet(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public void dispose() {
            set(1);
        }

        @Override // io.reactivex.disposables.Disposable
        public boolean isDisposed() {
            return get() != 0;
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        public boolean isEmpty() {
            return this.index == this.end;
        }

        @Override // io.reactivex.internal.fuseable.QueueFuseable
        public int requestFusion(int i4) {
            if ((i4 & 1) != 0) {
                this.fused = true;
                return 1;
            }
            return 0;
        }

        void run() {
            if (this.fused) {
                return;
            }
            Observer<? super Long> observer = this.actual;
            long j4 = this.end;
            for (long j5 = this.index; j5 != j4 && get() == 0; j5++) {
                observer.onNext(Long.valueOf(j5));
            }
            if (get() == 0) {
                lazySet(1);
                observer.onComplete();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public Long poll() throws Exception {
            long j4 = this.index;
            if (j4 != this.end) {
                this.index = 1 + j4;
                return Long.valueOf(j4);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRangeLong(long j4, long j5) {
        this.start = j4;
        this.count = j5;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Long> observer) {
        long j4 = this.start;
        RangeDisposable rangeDisposable = new RangeDisposable(observer, j4, j4 + this.count);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
