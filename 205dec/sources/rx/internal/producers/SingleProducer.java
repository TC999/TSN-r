package rx.internal.producers;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.g;
import rx.l;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class SingleProducer<T> extends AtomicBoolean implements g {
    private static final long serialVersionUID = -3353584923995471404L;
    final l<? super T> child;
    final T value;

    public SingleProducer(l<? super T> lVar, T t3) {
        this.child = lVar;
        this.value = t3;
    }

    @Override // rx.g
    public void request(long j4) {
        if (j4 >= 0) {
            if (j4 != 0 && compareAndSet(false, true)) {
                l<? super T> lVar = this.child;
                if (lVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.value;
                try {
                    lVar.onNext(obj);
                    if (lVar.isUnsubscribed()) {
                        return;
                    }
                    lVar.onCompleted();
                    return;
                } catch (Throwable th) {
                    rx.exceptions.a.g(th, lVar, obj);
                    return;
                }
            }
            return;
        }
        throw new IllegalArgumentException("n >= 0 required");
    }
}
