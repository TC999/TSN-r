package rx.internal.operators;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableOnSubscribeConcatIterable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m implements b.j0 {

    /* renamed from: a  reason: collision with root package name */
    final Iterable<? extends rx.b> f62947a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableOnSubscribeConcatIterable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends AtomicInteger implements rx.d {
        private static final long serialVersionUID = -7965400327305809232L;

        /* renamed from: a  reason: collision with root package name */
        final rx.d f62948a;

        /* renamed from: b  reason: collision with root package name */
        final Iterator<? extends rx.b> f62949b;

        /* renamed from: c  reason: collision with root package name */
        final rx.subscriptions.e f62950c = new rx.subscriptions.e();

        public a(rx.d dVar, Iterator<? extends rx.b> it) {
            this.f62948a = dVar;
            this.f62949b = it;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f62950c.b(mVar);
        }

        void b() {
            if (!this.f62950c.isUnsubscribed() && getAndIncrement() == 0) {
                Iterator<? extends rx.b> it = this.f62949b;
                while (!this.f62950c.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            this.f62948a.onCompleted();
                            return;
                        }
                        try {
                            rx.b next = it.next();
                            if (next == null) {
                                this.f62948a.onError(new NullPointerException("The completable returned is null"));
                                return;
                            }
                            next.G0(this);
                            if (decrementAndGet() == 0) {
                                return;
                            }
                        } catch (Throwable th) {
                            this.f62948a.onError(th);
                            return;
                        }
                    } catch (Throwable th2) {
                        this.f62948a.onError(th2);
                        return;
                    }
                }
            }
        }

        @Override // rx.d
        public void onCompleted() {
            b();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f62948a.onError(th);
        }
    }

    public m(Iterable<? extends rx.b> iterable) {
        this.f62947a = iterable;
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        try {
            Iterator<? extends rx.b> it = this.f62947a.iterator();
            if (it == null) {
                dVar.a(rx.subscriptions.f.e());
                dVar.onError(new NullPointerException("The iterator returned is null"));
                return;
            }
            a aVar = new a(dVar, it);
            dVar.a(aVar.f62950c);
            aVar.b();
        } catch (Throwable th) {
            dVar.a(rx.subscriptions.f.e());
            dVar.onError(th);
        }
    }
}
