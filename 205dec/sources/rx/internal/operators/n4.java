package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.i;
import rx.internal.subscriptions.CancellableSubscription;
import rx.internal.subscriptions.SequentialSubscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: SingleFromEmitter.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n4<T> implements i.t<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.b<rx.j<T>> f63017a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: SingleFromEmitter.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends AtomicBoolean implements rx.j<T>, rx.m {
        private static final long serialVersionUID = 8082834163465882809L;

        /* renamed from: a  reason: collision with root package name */
        final rx.k<? super T> f63018a;

        /* renamed from: b  reason: collision with root package name */
        final SequentialSubscription f63019b = new SequentialSubscription();

        a(rx.k<? super T> kVar) {
            this.f63018a = kVar;
        }

        @Override // rx.j
        public void a(rx.m mVar) {
            this.f63019b.update(mVar);
        }

        @Override // rx.j
        public void b(rx.functions.n nVar) {
            a(new CancellableSubscription(nVar));
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get();
        }

        @Override // rx.j
        public void onError(Throwable th) {
            if (th == null) {
                th = new NullPointerException();
            }
            if (compareAndSet(false, true)) {
                try {
                    this.f63018a.onError(th);
                    return;
                } finally {
                    this.f63019b.unsubscribe();
                }
            }
            rx.plugins.c.I(th);
        }

        @Override // rx.j
        public void onSuccess(T t3) {
            if (compareAndSet(false, true)) {
                try {
                    this.f63018a.c(t3);
                } finally {
                    this.f63019b.unsubscribe();
                }
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (compareAndSet(false, true)) {
                this.f63019b.unsubscribe();
            }
        }
    }

    public n4(rx.functions.b<rx.j<T>> bVar) {
        this.f63017a = bVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.k) ((rx.k) obj));
    }

    public void call(rx.k<? super T> kVar) {
        a aVar = new a(kVar);
        kVar.b(aVar);
        try {
            this.f63017a.call(aVar);
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            aVar.onError(th);
        }
    }
}
