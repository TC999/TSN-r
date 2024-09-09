package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import rx.b;
import rx.exceptions.MissingBackpressureException;
import rx.internal.subscriptions.SequentialSubscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: CompletableOnSubscribeConcat.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class k implements b.j0 {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<rx.b> f62843a;

    /* renamed from: b  reason: collision with root package name */
    final int f62844b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: CompletableOnSubscribeConcat.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a extends rx.l<rx.b> {

        /* renamed from: a  reason: collision with root package name */
        final rx.d f62845a;

        /* renamed from: b  reason: collision with root package name */
        final SequentialSubscription f62846b;

        /* renamed from: c  reason: collision with root package name */
        final rx.internal.util.unsafe.z<rx.b> f62847c;

        /* renamed from: d  reason: collision with root package name */
        final C1286a f62848d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicBoolean f62849e;

        /* renamed from: f  reason: collision with root package name */
        volatile boolean f62850f;

        /* renamed from: g  reason: collision with root package name */
        volatile boolean f62851g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: CompletableOnSubscribeConcat.java */
        /* renamed from: rx.internal.operators.k$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class C1286a extends AtomicInteger implements rx.d {
            private static final long serialVersionUID = 7233503139645205620L;

            C1286a() {
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                a.this.f62846b.set(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                a.this.v();
            }

            @Override // rx.d
            public void onError(Throwable th) {
                a.this.x(th);
            }
        }

        public a(rx.d dVar, int i4) {
            this.f62845a = dVar;
            this.f62847c = new rx.internal.util.unsafe.z<>(i4);
            SequentialSubscription sequentialSubscription = new SequentialSubscription();
            this.f62846b = sequentialSubscription;
            this.f62848d = new C1286a();
            this.f62849e = new AtomicBoolean();
            add(sequentialSubscription);
            request(i4);
        }

        @Override // rx.f
        /* renamed from: I */
        public void onNext(rx.b bVar) {
            if (!this.f62847c.offer(bVar)) {
                onError(new MissingBackpressureException());
            } else {
                g();
            }
        }

        void g() {
            C1286a c1286a = this.f62848d;
            if (c1286a.getAndIncrement() != 0) {
                return;
            }
            while (!isUnsubscribed()) {
                if (!this.f62851g) {
                    boolean z3 = this.f62850f;
                    rx.b poll = this.f62847c.poll();
                    boolean z4 = poll == null;
                    if (z3 && z4) {
                        this.f62845a.onCompleted();
                        return;
                    } else if (!z4) {
                        this.f62851g = true;
                        poll.q0(c1286a);
                        request(1L);
                    }
                }
                if (c1286a.decrementAndGet() == 0) {
                    return;
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62850f) {
                return;
            }
            this.f62850f = true;
            g();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62849e.compareAndSet(false, true)) {
                this.f62845a.onError(th);
            } else {
                rx.plugins.c.I(th);
            }
        }

        void v() {
            this.f62851g = false;
            g();
        }

        void x(Throwable th) {
            unsubscribe();
            onError(th);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public k(rx.e<? extends rx.b> eVar, int i4) {
        this.f62843a = eVar;
        this.f62844b = i4;
    }

    @Override // rx.functions.b
    public void call(rx.d dVar) {
        a aVar = new a(dVar, this.f62844b);
        dVar.a(aVar);
        this.f62843a.I6(aVar);
    }
}
