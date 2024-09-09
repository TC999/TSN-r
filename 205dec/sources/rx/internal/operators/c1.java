package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeSwitchIfEmpty.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class c1<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<? extends T> f62430a;

    /* renamed from: b  reason: collision with root package name */
    final rx.e<? extends T> f62431b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeSwitchIfEmpty.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.internal.producers.a f62432a;

        /* renamed from: b  reason: collision with root package name */
        private final rx.l<? super T> f62433b;

        a(rx.l<? super T> lVar, rx.internal.producers.a aVar) {
            this.f62433b = lVar;
            this.f62432a = aVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62433b.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62433b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62433b.onNext(t3);
            this.f62432a.b(1L);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f62432a.c(gVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeSwitchIfEmpty.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends rx.l<T> {

        /* renamed from: b  reason: collision with root package name */
        private final rx.l<? super T> f62435b;

        /* renamed from: c  reason: collision with root package name */
        private final rx.subscriptions.e f62436c;

        /* renamed from: d  reason: collision with root package name */
        private final rx.internal.producers.a f62437d;

        /* renamed from: e  reason: collision with root package name */
        private final rx.e<? extends T> f62438e;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f62440g;

        /* renamed from: a  reason: collision with root package name */
        private boolean f62434a = true;

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f62439f = new AtomicInteger();

        b(rx.l<? super T> lVar, rx.subscriptions.e eVar, rx.internal.producers.a aVar, rx.e<? extends T> eVar2) {
            this.f62435b = lVar;
            this.f62436c = eVar;
            this.f62437d = aVar;
            this.f62438e = eVar2;
        }

        void g(rx.e<? extends T> eVar) {
            if (this.f62439f.getAndIncrement() == 0) {
                while (!this.f62435b.isUnsubscribed()) {
                    if (!this.f62440g) {
                        if (eVar == null) {
                            a aVar = new a(this.f62435b, this.f62437d);
                            this.f62436c.b(aVar);
                            this.f62440g = true;
                            this.f62438e.I6(aVar);
                        } else {
                            this.f62440g = true;
                            eVar.I6(this);
                            eVar = null;
                        }
                    }
                    if (this.f62439f.decrementAndGet() == 0) {
                        return;
                    }
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (!this.f62434a) {
                this.f62435b.onCompleted();
            } else if (this.f62435b.isUnsubscribed()) {
            } else {
                this.f62440g = false;
                g(null);
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62435b.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62434a = false;
            this.f62435b.onNext(t3);
            this.f62437d.b(1L);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f62437d.c(gVar);
        }
    }

    public c1(rx.e<? extends T> eVar, rx.e<? extends T> eVar2) {
        this.f62430a = eVar;
        this.f62431b = eVar2;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        b bVar = new b(lVar, eVar, aVar, this.f62431b);
        eVar.b(bVar);
        lVar.add(eVar);
        lVar.setProducer(aVar);
        bVar.g(this.f62430a);
    }
}
