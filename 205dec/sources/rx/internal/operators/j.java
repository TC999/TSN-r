package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.b;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableFromEmitter.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class j implements b.j0 {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.b<rx.c> f62796a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableFromEmitter.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends AtomicBoolean implements rx.c, rx.m {
        private static final long serialVersionUID = 5539301318568668881L;

        /* renamed from: a  reason: collision with root package name */
        final rx.d f62797a;

        /* renamed from: b  reason: collision with root package name */
        final SequentialSubscription f62798b = new SequentialSubscription();

        public a(rx.d dVar) {
            this.f62797a = dVar;
        }

        @Override // rx.c
        public void a(rx.m mVar) {
            this.f62798b.update(mVar);
        }

        @Override // rx.c
        public void b(rx.functions.n nVar) {
            a(new CancellableSubscription(nVar));
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // rx.c
        public void onCompleted() {
            if (compareAndSet(false, true)) {
                try {
                    this.f62797a.onCompleted();
                } finally {
                    this.f62798b.unsubscribe();
                }
            }
        }

        @Override // rx.c
        public void onError(Throwable th) {
            if (compareAndSet(false, true)) {
                try {
                    this.f62797a.onError(th);
                    return;
                } finally {
                    this.f62798b.unsubscribe();
                }
            }
            rx.plugins.c.I(th);
        }

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f62798b.unsubscribe();
            }
        }
    }

    public j(rx.functions.b<rx.c> bVar) {
        this.f62796a = bVar;
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        a aVar = new a(dVar);
        dVar.a(aVar);
        try {
            this.f62796a.call(aVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            aVar.onError(th);
        }
    }
}
