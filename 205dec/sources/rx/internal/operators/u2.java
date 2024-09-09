package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorRetryWithPredicate.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u2<T> implements e.b<T, rx.e<T>> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.q<Integer, Throwable, Boolean> f63420a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorRetryWithPredicate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<rx.e<T>> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f63421a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.q<Integer, Throwable, Boolean> f63422b;

        /* renamed from: c  reason: collision with root package name */
        final h.a f63423c;

        /* renamed from: d  reason: collision with root package name */
        final rx.subscriptions.e f63424d;

        /* renamed from: e  reason: collision with root package name */
        final rx.internal.producers.a f63425e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f63426f = new AtomicInteger();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorRetryWithPredicate.java */
        /* renamed from: rx.internal.operators.u2$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1300a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.e f63427a;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: OperatorRetryWithPredicate.java */
            /* renamed from: rx.internal.operators.u2$a$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class C1301a extends rx.l<T> {

                /* renamed from: a  reason: collision with root package name */
                boolean f63429a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ rx.functions.a f63430b;

                C1301a(rx.functions.a aVar) {
                    this.f63430b = aVar;
                }

                @Override // rx.f
                public void onCompleted() {
                    if (this.f63429a) {
                        return;
                    }
                    this.f63429a = true;
                    a.this.f63421a.onCompleted();
                }

                @Override // rx.f
                public void onError(Throwable th) {
                    if (this.f63429a) {
                        return;
                    }
                    this.f63429a = true;
                    a aVar = a.this;
                    if (aVar.f63422b.call(Integer.valueOf(aVar.f63426f.get()), th).booleanValue() && !a.this.f63423c.isUnsubscribed()) {
                        a.this.f63423c.c(this.f63430b);
                    } else {
                        a.this.f63421a.onError(th);
                    }
                }

                @Override // rx.f
                public void onNext(T t3) {
                    if (this.f63429a) {
                        return;
                    }
                    a.this.f63421a.onNext(t3);
                    a.this.f63425e.b(1L);
                }

                @Override // rx.l, rx.observers.a
                public void setProducer(rx.g gVar) {
                    a.this.f63425e.c(gVar);
                }
            }

            C1300a(rx.e eVar) {
                this.f63427a = eVar;
            }

            @Override // rx.functions.a
            public void call() {
                a.this.f63426f.incrementAndGet();
                C1301a c1301a = new C1301a(this);
                a.this.f63424d.b(c1301a);
                this.f63427a.I6(c1301a);
            }
        }

        public a(rx.l<? super T> lVar, rx.functions.q<Integer, Throwable, Boolean> qVar, h.a aVar, rx.subscriptions.e eVar, rx.internal.producers.a aVar2) {
            this.f63421a = lVar;
            this.f63422b = qVar;
            this.f63423c = aVar;
            this.f63424d = eVar;
            this.f63425e = aVar2;
        }

        @Override // rx.f
        /* renamed from: g */
        public void onNext(rx.e<T> eVar) {
            this.f63423c.c(new C1300a(eVar));
        }

        @Override // rx.f
        public void onCompleted() {
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63421a.onError(th);
        }
    }

    public u2(rx.functions.q<Integer, Throwable, Boolean> qVar) {
        this.f63420a = qVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super rx.e<T>> call(rx.l<? super T> lVar) {
        h.a a4 = rx.schedulers.c.m().a();
        lVar.add(a4);
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        lVar.add(eVar);
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        lVar.setProducer(aVar);
        return new a(lVar, this.f63420a, a4, eVar, aVar);
    }
}
