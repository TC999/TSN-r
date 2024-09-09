package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.Emitter;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.internal.subscriptions.CancellableSubscription;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeCreate.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.b<Emitter<T>> f62307a;

    /* renamed from: b  reason: collision with root package name */
    final Emitter.BackpressureMode f62308b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f62309a;

        static {
            int[] iArr = new int[Emitter.BackpressureMode.values().length];
            f62309a = iArr;
            try {
                iArr[Emitter.BackpressureMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f62309a[Emitter.BackpressureMode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f62309a[Emitter.BackpressureMode.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f62309a[Emitter.BackpressureMode.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static abstract class b<T> extends AtomicLong implements Emitter<T>, rx.g, rx.m {
        private static final long serialVersionUID = 7326289992464377023L;

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f62310a;

        /* renamed from: b  reason: collision with root package name */
        final rx.subscriptions.e f62311b = new rx.subscriptions.e();

        public b(rx.l<? super T> lVar) {
            this.f62310a = lVar;
        }

        @Override // rx.Emitter
        public final void a(rx.m mVar) {
            this.f62311b.b(mVar);
        }

        @Override // rx.Emitter
        public final void b(rx.functions.n nVar) {
            a(new CancellableSubscription(nVar));
        }

        void c() {
        }

        void e() {
        }

        @Override // rx.m
        public final boolean isUnsubscribed() {
            return this.f62311b.isUnsubscribed();
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62310a.isUnsubscribed()) {
                return;
            }
            try {
                this.f62310a.onCompleted();
            } finally {
                this.f62311b.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62310a.isUnsubscribed()) {
                return;
            }
            try {
                this.f62310a.onError(th);
            } finally {
                this.f62311b.unsubscribe();
            }
        }

        @Override // rx.g
        public final void request(long j4) {
            if (rx.internal.operators.a.j(j4)) {
                rx.internal.operators.a.b(this, j4);
                c();
            }
        }

        @Override // rx.Emitter
        public final long requested() {
            return get();
        }

        @Override // rx.m
        public final void unsubscribe() {
            this.f62311b.unsubscribe();
            e();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends b<T> {
        private static final long serialVersionUID = 2427151001689639875L;

        /* renamed from: c  reason: collision with root package name */
        final Queue<Object> f62312c;

        /* renamed from: d  reason: collision with root package name */
        Throwable f62313d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f62314e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f62315f;

        public c(rx.l<? super T> lVar, int i4) {
            super(lVar);
            this.f62312c = rx.internal.util.unsafe.n0.f() ? new rx.internal.util.unsafe.h0<>(i4) : new rx.internal.util.atomic.g<>(i4);
            this.f62315f = new AtomicInteger();
        }

        @Override // rx.internal.operators.a0.b
        void c() {
            g();
        }

        @Override // rx.internal.operators.a0.b
        void e() {
            if (this.f62315f.getAndIncrement() == 0) {
                this.f62312c.clear();
            }
        }

        void g() {
            if (this.f62315f.getAndIncrement() != 0) {
                return;
            }
            rx.l<? super T> lVar = this.f62310a;
            Queue<Object> queue = this.f62312c;
            int i4 = 1;
            do {
                long j4 = get();
                long j5 = 0;
                while (j5 != j4) {
                    if (lVar.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z3 = this.f62314e;
                    Object poll = queue.poll();
                    boolean z4 = poll == null;
                    if (z3 && z4) {
                        Throwable th = this.f62313d;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    } else if (z4) {
                        break;
                    } else {
                        lVar.onNext((Object) v.e(poll));
                        j5++;
                    }
                }
                if (j5 == j4) {
                    if (lVar.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z5 = this.f62314e;
                    boolean isEmpty = queue.isEmpty();
                    if (z5 && isEmpty) {
                        Throwable th2 = this.f62313d;
                        if (th2 != null) {
                            super.onError(th2);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j5 != 0) {
                    rx.internal.operators.a.i(this, j5);
                }
                i4 = this.f62315f.addAndGet(-i4);
            } while (i4 != 0);
        }

        @Override // rx.internal.operators.a0.b, rx.f
        public void onCompleted() {
            this.f62314e = true;
            g();
        }

        @Override // rx.internal.operators.a0.b, rx.f
        public void onError(Throwable th) {
            this.f62313d = th;
            this.f62314e = true;
            g();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62312c.offer(v.j(t3));
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<T> extends g<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public d(rx.l<? super T> lVar) {
            super(lVar);
        }

        @Override // rx.internal.operators.a0.g
        void g() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class e<T> extends g<T> {
        private static final long serialVersionUID = 338953216916120960L;

        /* renamed from: c  reason: collision with root package name */
        private boolean f62316c;

        public e(rx.l<? super T> lVar) {
            super(lVar);
        }

        @Override // rx.internal.operators.a0.g
        void g() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }

        @Override // rx.internal.operators.a0.b, rx.f
        public void onCompleted() {
            if (this.f62316c) {
                return;
            }
            this.f62316c = true;
            super.onCompleted();
        }

        @Override // rx.internal.operators.a0.b, rx.f
        public void onError(Throwable th) {
            if (this.f62316c) {
                rx.plugins.c.I(th);
                return;
            }
            this.f62316c = true;
            super.onError(th);
        }

        @Override // rx.internal.operators.a0.g, rx.f
        public void onNext(T t3) {
            if (this.f62316c) {
                return;
            }
            super.onNext(t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f<T> extends b<T> {
        private static final long serialVersionUID = 4023437720691792495L;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReference<Object> f62317c;

        /* renamed from: d  reason: collision with root package name */
        Throwable f62318d;

        /* renamed from: e  reason: collision with root package name */
        volatile boolean f62319e;

        /* renamed from: f  reason: collision with root package name */
        final AtomicInteger f62320f;

        public f(rx.l<? super T> lVar) {
            super(lVar);
            this.f62317c = new AtomicReference<>();
            this.f62320f = new AtomicInteger();
        }

        @Override // rx.internal.operators.a0.b
        void c() {
            g();
        }

        @Override // rx.internal.operators.a0.b
        void e() {
            if (this.f62320f.getAndIncrement() == 0) {
                this.f62317c.lazySet(null);
            }
        }

        void g() {
            if (this.f62320f.getAndIncrement() != 0) {
                return;
            }
            rx.l<? super T> lVar = this.f62310a;
            AtomicReference<Object> atomicReference = this.f62317c;
            int i4 = 1;
            do {
                long j4 = get();
                long j5 = 0;
                while (true) {
                    if (j5 == j4) {
                        break;
                    } else if (lVar.isUnsubscribed()) {
                        atomicReference.lazySet(null);
                        return;
                    } else {
                        boolean z3 = this.f62319e;
                        Object andSet = atomicReference.getAndSet(null);
                        boolean z4 = andSet == null;
                        if (z3 && z4) {
                            Throwable th = this.f62318d;
                            if (th != null) {
                                super.onError(th);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (z4) {
                            break;
                        } else {
                            lVar.onNext((Object) v.e(andSet));
                            j5++;
                        }
                    }
                }
                if (j5 == j4) {
                    if (lVar.isUnsubscribed()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z5 = this.f62319e;
                    boolean z6 = atomicReference.get() == null;
                    if (z5 && z6) {
                        Throwable th2 = this.f62318d;
                        if (th2 != null) {
                            super.onError(th2);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j5 != 0) {
                    rx.internal.operators.a.i(this, j5);
                }
                i4 = this.f62320f.addAndGet(-i4);
            } while (i4 != 0);
        }

        @Override // rx.internal.operators.a0.b, rx.f
        public void onCompleted() {
            this.f62319e = true;
            g();
        }

        @Override // rx.internal.operators.a0.b, rx.f
        public void onError(Throwable th) {
            this.f62318d = th;
            this.f62319e = true;
            g();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62317c.set(v.j(t3));
            g();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static abstract class g<T> extends b<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public g(rx.l<? super T> lVar) {
            super(lVar);
        }

        abstract void g();

        public void onNext(T t3) {
            if (this.f62310a.isUnsubscribed()) {
                return;
            }
            if (get() != 0) {
                this.f62310a.onNext(t3);
                rx.internal.operators.a.i(this, 1L);
                return;
            }
            g();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeCreate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class h<T> extends b<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public h(rx.l<? super T> lVar) {
            super(lVar);
        }

        @Override // rx.f
        public void onNext(T t3) {
            long j4;
            if (this.f62310a.isUnsubscribed()) {
                return;
            }
            this.f62310a.onNext(t3);
            do {
                j4 = get();
                if (j4 == 0) {
                    return;
                }
            } while (!compareAndSet(j4, j4 - 1));
        }
    }

    public a0(rx.functions.b<Emitter<T>> bVar, Emitter.BackpressureMode backpressureMode) {
        this.f62307a = bVar;
        this.f62308b = backpressureMode;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        b hVar;
        int i4 = a.f62309a[this.f62308b.ordinal()];
        if (i4 == 1) {
            hVar = new h(lVar);
        } else if (i4 == 2) {
            hVar = new e(lVar);
        } else if (i4 == 3) {
            hVar = new d(lVar);
        } else if (i4 != 4) {
            hVar = new c(lVar, rx.internal.util.j.f63940d);
        } else {
            hVar = new f(lVar);
        }
        lVar.add(hVar);
        lVar.setProducer(hVar);
        this.f62307a.call(hVar);
    }
}
