package rx.internal.producers;

import java.util.concurrent.atomic.AtomicInteger;
import rx.g;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class SingleDelayedProducer<T> extends AtomicInteger implements g {
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2873467947112093874L;
    final l<? super T> child;
    T value;

    public SingleDelayedProducer(l<? super T> lVar) {
        this.child = lVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static <T> void emit(l<? super T> lVar, T t3) {
        if (lVar.isUnsubscribed()) {
            return;
        }
        try {
            lVar.onNext(t3);
            if (lVar.isUnsubscribed()) {
                return;
            }
            lVar.onCompleted();
        } catch (Throwable th) {
            rx.exceptions.a.g(th, lVar, t3);
        }
    }

    @Override // rx.g
    public void request(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException("n >= 0 required");
        }
        if (j4 == 0) {
            return;
        }
        do {
            int i4 = get();
            if (i4 != 0) {
                if (i4 == 1 && compareAndSet(1, 3)) {
                    emit(this.child, this.value);
                    return;
                }
                return;
            }
        } while (!compareAndSet(0, 2));
    }

    public void setValue(T t3) {
        do {
            int i4 = get();
            if (i4 == 0) {
                this.value = t3;
            } else if (i4 == 2 && compareAndSet(2, 3)) {
                emit(this.child, t3);
                return;
            } else {
                return;
            }
        } while (!compareAndSet(0, 1));
    }
}
