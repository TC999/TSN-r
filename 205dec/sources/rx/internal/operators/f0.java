package rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeDetach.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f62566a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeDetach.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> implements rx.g, rx.m {

        /* renamed from: a  reason: collision with root package name */
        final b<T> f62567a;

        public a(b<T> bVar) {
            this.f62567a = bVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f62567a.isUnsubscribed();
        }

        @Override // rx.g
        public void request(long j4) {
            this.f62567a.g(j4);
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f62567a.v();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeDetach.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final AtomicReference<rx.l<? super T>> f62568a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<rx.g> f62569b = new AtomicReference<>();

        /* renamed from: c  reason: collision with root package name */
        final AtomicLong f62570c = new AtomicLong();

        public b(rx.l<? super T> lVar) {
            this.f62568a = new AtomicReference<>(lVar);
        }

        void g(long j4) {
            if (j4 >= 0) {
                rx.g gVar = this.f62569b.get();
                if (gVar != null) {
                    gVar.request(j4);
                    return;
                }
                rx.internal.operators.a.b(this.f62570c, j4);
                rx.g gVar2 = this.f62569b.get();
                if (gVar2 == null || gVar2 == c.INSTANCE) {
                    return;
                }
                gVar2.request(this.f62570c.getAndSet(0L));
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j4);
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62569b.lazySet(c.INSTANCE);
            rx.l<? super T> andSet = this.f62568a.getAndSet(null);
            if (andSet != null) {
                andSet.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62569b.lazySet(c.INSTANCE);
            rx.l<? super T> andSet = this.f62568a.getAndSet(null);
            if (andSet != null) {
                andSet.onError(th);
            } else {
                rx.plugins.c.I(th);
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            rx.l<? super T> lVar = this.f62568a.get();
            if (lVar != null) {
                lVar.onNext(t3);
            }
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            if (this.f62569b.compareAndSet(null, gVar)) {
                gVar.request(this.f62570c.getAndSet(0L));
            } else if (this.f62569b.get() != c.INSTANCE) {
                throw new IllegalStateException("Producer already set!");
            }
        }

        void v() {
            this.f62569b.lazySet(c.INSTANCE);
            this.f62568a.lazySet(null);
            unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeDetach.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public enum c implements rx.g {
        INSTANCE;

        @Override // rx.g
        public void request(long j4) {
        }
    }

    public f0(rx.e<T> eVar) {
        this.f62566a = eVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        b bVar = new b(lVar);
        a aVar = new a(bVar);
        lVar.add(aVar);
        lVar.setProducer(aVar);
        this.f62566a.I6(bVar);
    }
}
