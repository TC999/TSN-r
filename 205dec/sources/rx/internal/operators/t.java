package rx.internal.operators;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: DeferredScalarSubscriber.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public abstract class t<T, R> extends rx.l<T> {

    /* renamed from: e  reason: collision with root package name */
    static final int f63307e = 0;

    /* renamed from: f  reason: collision with root package name */
    static final int f63308f = 1;

    /* renamed from: g  reason: collision with root package name */
    static final int f63309g = 2;

    /* renamed from: h  reason: collision with root package name */
    static final int f63310h = 3;

    /* renamed from: a  reason: collision with root package name */
    protected final rx.l<? super R> f63311a;

    /* renamed from: b  reason: collision with root package name */
    protected boolean f63312b;

    /* renamed from: c  reason: collision with root package name */
    protected R f63313c;

    /* renamed from: d  reason: collision with root package name */
    final AtomicInteger f63314d = new AtomicInteger();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: DeferredScalarSubscriber.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final t<?, ?> f63315a;

        public a(t<?, ?> tVar) {
            this.f63315a = tVar;
        }

        @Override // rx.g
        public void request(long j4) {
            this.f63315a.x(j4);
        }
    }

    public t(rx.l<? super R> lVar) {
        this.f63311a = lVar;
    }

    final void I() {
        rx.l<? super R> lVar = this.f63311a;
        lVar.add(this);
        lVar.setProducer(new a(this));
    }

    public final void J(rx.e<? extends T> eVar) {
        I();
        eVar.I6(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void g() {
        this.f63311a.onCompleted();
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f63312b) {
            v(this.f63313c);
        } else {
            g();
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f63313c = null;
        this.f63311a.onError(th);
    }

    @Override // rx.l, rx.observers.a
    public final void setProducer(rx.g gVar) {
        gVar.request(Long.MAX_VALUE);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public final void v(R r3) {
        rx.l<? super R> lVar = this.f63311a;
        do {
            int i4 = this.f63314d.get();
            if (i4 == 2 || i4 == 3 || lVar.isUnsubscribed()) {
                return;
            }
            if (i4 == 1) {
                lVar.onNext(r3);
                if (!lVar.isUnsubscribed()) {
                    lVar.onCompleted();
                }
                this.f63314d.lazySet(3);
                return;
            }
            this.f63313c = r3;
        } while (!this.f63314d.compareAndSet(0, 2));
    }

    final void x(long j4) {
        if (j4 < 0) {
            throw new IllegalArgumentException("n >= 0 required but it was " + j4);
        } else if (j4 != 0) {
            rx.l<? super R> lVar = this.f63311a;
            do {
                int i4 = this.f63314d.get();
                if (i4 == 1 || i4 == 3 || lVar.isUnsubscribed()) {
                    return;
                }
                if (i4 == 2) {
                    if (this.f63314d.compareAndSet(2, 3)) {
                        lVar.onNext((R) this.f63313c);
                        if (lVar.isUnsubscribed()) {
                            return;
                        }
                        lVar.onCompleted();
                        return;
                    }
                    return;
                }
            } while (!this.f63314d.compareAndSet(0, 1));
        }
    }
}
