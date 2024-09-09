package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class OnSubscribeAutoConnect<T> extends AtomicInteger implements e.a<T> {
    final rx.functions.b<? super rx.m> connection;
    final int numberOfSubscribers;
    final rx.observables.c<? extends T> source;

    public OnSubscribeAutoConnect(rx.observables.c<? extends T> cVar, int i4, rx.functions.b<? super rx.m> bVar) {
        if (i4 > 0) {
            this.source = cVar;
            this.numberOfSubscribers = i4;
            this.connection = bVar;
            return;
        }
        throw new IllegalArgumentException("numberOfSubscribers > 0 required");
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        this.source.I6(rx.observers.h.f(lVar));
        if (incrementAndGet() == this.numberOfSubscribers) {
            this.source.z7(this.connection);
        }
    }
}
