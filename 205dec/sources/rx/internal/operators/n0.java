package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeFromIterable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<? extends T> f62992a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeFromIterable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends AtomicLong implements rx.g {
        private static final long serialVersionUID = -8730475647105475802L;

        /* renamed from: a  reason: collision with root package name */
        private final rx.l<? super T> f62993a;

        /* renamed from: b  reason: collision with root package name */
        private final Iterator<? extends T> f62994b;

        /* JADX INFO: Access modifiers changed from: package-private */
        public a(rx.l<? super T> lVar, Iterator<? extends T> it) {
            this.f62993a = lVar;
            this.f62994b = it;
        }

        void a() {
            rx.l<? super T> lVar = this.f62993a;
            Iterator<? extends T> it = this.f62994b;
            while (!lVar.isUnsubscribed()) {
                try {
                    lVar.onNext((T) it.next());
                    if (lVar.isUnsubscribed()) {
                        return;
                    }
                    try {
                        if (!it.hasNext()) {
                            if (lVar.isUnsubscribed()) {
                                return;
                            }
                            lVar.onCompleted();
                            return;
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.f(th, lVar);
                        return;
                    }
                } catch (Throwable th2) {
                    rx.exceptions.a.f(th2, lVar);
                    return;
                }
            }
        }

        void b(long j4) {
            rx.l<? super T> lVar = this.f62993a;
            Iterator<? extends T> it = this.f62994b;
            do {
                long j5 = 0;
                while (true) {
                    if (j5 != j4) {
                        if (lVar.isUnsubscribed()) {
                            return;
                        }
                        try {
                            lVar.onNext((T) it.next());
                            if (lVar.isUnsubscribed()) {
                                return;
                            }
                            try {
                                if (!it.hasNext()) {
                                    if (lVar.isUnsubscribed()) {
                                        return;
                                    }
                                    lVar.onCompleted();
                                    return;
                                }
                                j5++;
                            } catch (Throwable th) {
                                rx.exceptions.a.f(th, lVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            rx.exceptions.a.f(th2, lVar);
                            return;
                        }
                    } else {
                        j4 = get();
                        if (j5 == j4) {
                            j4 = rx.internal.operators.a.i(this, j5);
                        }
                    }
                }
            } while (j4 != 0);
        }

        @Override // rx.g
        public void request(long j4) {
            if (get() == Long.MAX_VALUE) {
                return;
            }
            if (j4 == Long.MAX_VALUE && compareAndSet(0L, Long.MAX_VALUE)) {
                a();
            } else if (j4 <= 0 || rx.internal.operators.a.b(this, j4) != 0) {
            } else {
                b(j4);
            }
        }
    }

    public n0(Iterable<? extends T> iterable) {
        if (iterable != null) {
            this.f62992a = iterable;
            return;
        }
        throw new NullPointerException("iterable must not be null");
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        try {
            Iterator<? extends T> it = this.f62992a.iterator();
            boolean hasNext = it.hasNext();
            if (lVar.isUnsubscribed()) {
                return;
            }
            if (!hasNext) {
                lVar.onCompleted();
            } else {
                lVar.setProducer(new a(lVar, it));
            }
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
        }
    }
}
