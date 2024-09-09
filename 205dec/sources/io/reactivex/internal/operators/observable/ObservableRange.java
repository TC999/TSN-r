package io.reactivex.internal.operators.observable;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.annotations.Nullable;
import io.reactivex.internal.observers.BasicIntQueueDisposable;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class ObservableRange extends Observable<Integer> {
    private final long end;
    private final int start;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class RangeDisposable extends BasicIntQueueDisposable<Integer> {
        private static final long serialVersionUID = 396518478098735504L;
        final Observer<? super Integer> actual;
        final long end;
        boolean fused;
        long index;

        RangeDisposable(Observer<? super Integer> observer, long j4, long j5) {
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
            Observer<? super Integer> observer = this.actual;
            long j4 = this.end;
            for (long j5 = this.index; j5 != j4 && get() == 0; j5++) {
                observer.onNext(Integer.valueOf((int) j5));
            }
            if (get() == 0) {
                lazySet(1);
                observer.onComplete();
            }
        }

        @Override // io.reactivex.internal.fuseable.SimpleQueue
        @Nullable
        public Integer poll() throws Exception {
            long j4 = this.index;
            if (j4 != this.end) {
                this.index = 1 + j4;
                return Integer.valueOf((int) j4);
            }
            lazySet(1);
            return null;
        }
    }

    public ObservableRange(int i4, int i5) {
        this.start = i4;
        this.end = i4 + i5;
    }

    @Override // io.reactivex.Observable
    protected void subscribeActual(Observer<? super Integer> observer) {
        RangeDisposable rangeDisposable = new RangeDisposable(observer, this.start, this.end);
        observer.onSubscribe(rangeDisposable);
        rangeDisposable.run();
    }
}
