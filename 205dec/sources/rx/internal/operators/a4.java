package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorWindowWithSize.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class a4<T> implements e.b<rx.e<T>, T> {

    /* renamed from: a  reason: collision with root package name */
    final int f62339a;

    /* renamed from: b  reason: collision with root package name */
    final int f62340b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithSize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super rx.e<T>> f62341a;

        /* renamed from: b  reason: collision with root package name */
        final int f62342b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicInteger f62343c = new AtomicInteger(1);

        /* renamed from: d  reason: collision with root package name */
        final rx.m f62344d;

        /* renamed from: e  reason: collision with root package name */
        int f62345e;

        /* renamed from: f  reason: collision with root package name */
        rx.subjects.f<T, T> f62346f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorWindowWithSize.java */
        /* renamed from: rx.internal.operators.a4$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1273a implements rx.g {
            C1273a() {
            }

            @Override // rx.g
            public void request(long j4) {
                if (j4 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j4);
                } else if (j4 != 0) {
                    a.this.request(rx.internal.operators.a.c(a.this.f62342b, j4));
                }
            }
        }

        public a(rx.l<? super rx.e<T>> lVar, int i4) {
            this.f62341a = lVar;
            this.f62342b = i4;
            rx.m a4 = rx.subscriptions.f.a(this);
            this.f62344d = a4;
            add(a4);
            request(0L);
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f62343c.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            rx.subjects.f<T, T> fVar = this.f62346f;
            if (fVar != null) {
                this.f62346f = null;
                fVar.onCompleted();
            }
            this.f62341a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            rx.subjects.f<T, T> fVar = this.f62346f;
            if (fVar != null) {
                this.f62346f = null;
                fVar.onError(th);
            }
            this.f62341a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            int i4 = this.f62345e;
            rx.subjects.i iVar = this.f62346f;
            if (i4 == 0) {
                this.f62343c.getAndIncrement();
                iVar = rx.subjects.i.z7(this.f62342b, this);
                this.f62346f = iVar;
                this.f62341a.onNext(iVar);
            }
            int i5 = i4 + 1;
            iVar.onNext(t3);
            if (i5 == this.f62342b) {
                this.f62345e = 0;
                this.f62346f = null;
                iVar.onCompleted();
                return;
            }
            this.f62345e = i5;
        }

        rx.g v() {
            return new C1273a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithSize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super rx.e<T>> f62348a;

        /* renamed from: b  reason: collision with root package name */
        final int f62349b;

        /* renamed from: c  reason: collision with root package name */
        final int f62350c;

        /* renamed from: e  reason: collision with root package name */
        final rx.m f62352e;

        /* renamed from: i  reason: collision with root package name */
        final Queue<rx.subjects.f<T, T>> f62356i;

        /* renamed from: j  reason: collision with root package name */
        Throwable f62357j;

        /* renamed from: k  reason: collision with root package name */
        volatile boolean f62358k;

        /* renamed from: l  reason: collision with root package name */
        int f62359l;

        /* renamed from: m  reason: collision with root package name */
        int f62360m;

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f62351d = new AtomicInteger(1);

        /* renamed from: f  reason: collision with root package name */
        final ArrayDeque<rx.subjects.f<T, T>> f62353f = new ArrayDeque<>();

        /* renamed from: h  reason: collision with root package name */
        final AtomicInteger f62355h = new AtomicInteger();

        /* renamed from: g  reason: collision with root package name */
        final AtomicLong f62354g = new AtomicLong();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorWindowWithSize.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class a extends AtomicBoolean implements rx.g {
            private static final long serialVersionUID = 4625807964358024108L;

            a() {
            }

            @Override // rx.g
            public void request(long j4) {
                if (j4 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j4);
                } else if (j4 != 0) {
                    b bVar = b.this;
                    if (!get() && compareAndSet(false, true)) {
                        bVar.request(rx.internal.operators.a.a(rx.internal.operators.a.c(bVar.f62350c, j4 - 1), bVar.f62349b));
                    } else {
                        b.this.request(rx.internal.operators.a.c(bVar.f62350c, j4));
                    }
                    rx.internal.operators.a.b(bVar.f62354g, j4);
                    bVar.J();
                }
            }
        }

        public b(rx.l<? super rx.e<T>> lVar, int i4, int i5) {
            this.f62348a = lVar;
            this.f62349b = i4;
            this.f62350c = i5;
            rx.m a4 = rx.subscriptions.f.a(this);
            this.f62352e = a4;
            add(a4);
            request(0L);
            this.f62356i = new rx.internal.util.atomic.e((i4 + (i5 - 1)) / i5);
        }

        rx.g I() {
            return new a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        void J() {
            AtomicInteger atomicInteger = this.f62355h;
            if (atomicInteger.getAndIncrement() != 0) {
                return;
            }
            rx.l<? super rx.e<T>> lVar = this.f62348a;
            Queue<rx.subjects.f<T, T>> queue = this.f62356i;
            int i4 = 1;
            do {
                long j4 = this.f62354g.get();
                long j5 = 0;
                while (j5 != j4) {
                    boolean z3 = this.f62358k;
                    rx.subjects.f<T, T> poll = queue.poll();
                    boolean z4 = poll == null;
                    if (x(z3, z4, lVar, queue)) {
                        return;
                    }
                    if (z4) {
                        break;
                    }
                    lVar.onNext(poll);
                    j5++;
                }
                if (j5 == j4 && x(this.f62358k, queue.isEmpty(), lVar, queue)) {
                    return;
                }
                if (j5 != 0 && j4 != Long.MAX_VALUE) {
                    this.f62354g.addAndGet(-j5);
                }
                i4 = atomicInteger.addAndGet(-i4);
            } while (i4 != 0);
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f62351d.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            Iterator<rx.subjects.f<T, T>> it = this.f62353f.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            this.f62353f.clear();
            this.f62358k = true;
            J();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            Iterator<rx.subjects.f<T, T>> it = this.f62353f.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.f62353f.clear();
            this.f62357j = th;
            this.f62358k = true;
            J();
        }

        @Override // rx.f
        public void onNext(T t3) {
            int i4 = this.f62359l;
            ArrayDeque<rx.subjects.f<T, T>> arrayDeque = this.f62353f;
            if (i4 == 0 && !this.f62348a.isUnsubscribed()) {
                this.f62351d.getAndIncrement();
                rx.subjects.i z7 = rx.subjects.i.z7(16, this);
                arrayDeque.offer(z7);
                this.f62356i.offer(z7);
                J();
            }
            Iterator<rx.subjects.f<T, T>> it = this.f62353f.iterator();
            while (it.hasNext()) {
                it.next().onNext(t3);
            }
            int i5 = this.f62360m + 1;
            if (i5 == this.f62349b) {
                this.f62360m = i5 - this.f62350c;
                rx.subjects.f<T, T> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.onCompleted();
                }
            } else {
                this.f62360m = i5;
            }
            int i6 = i4 + 1;
            if (i6 == this.f62350c) {
                this.f62359l = 0;
            } else {
                this.f62359l = i6;
            }
        }

        boolean x(boolean z3, boolean z4, rx.l<? super rx.subjects.f<T, T>> lVar, Queue<rx.subjects.f<T, T>> queue) {
            if (lVar.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (z3) {
                Throwable th = this.f62357j;
                if (th != null) {
                    queue.clear();
                    lVar.onError(th);
                    return true;
                } else if (z4) {
                    lVar.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithSize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends rx.l<T> implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super rx.e<T>> f62362a;

        /* renamed from: b  reason: collision with root package name */
        final int f62363b;

        /* renamed from: c  reason: collision with root package name */
        final int f62364c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f62365d = new AtomicInteger(1);

        /* renamed from: e  reason: collision with root package name */
        final rx.m f62366e;

        /* renamed from: f  reason: collision with root package name */
        int f62367f;

        /* renamed from: g  reason: collision with root package name */
        rx.subjects.f<T, T> f62368g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorWindowWithSize.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class a extends AtomicBoolean implements rx.g {
            private static final long serialVersionUID = 4625807964358024108L;

            a() {
            }

            @Override // rx.g
            public void request(long j4) {
                if (j4 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j4);
                } else if (j4 != 0) {
                    c cVar = c.this;
                    if (!get() && compareAndSet(false, true)) {
                        cVar.request(rx.internal.operators.a.a(rx.internal.operators.a.c(j4, cVar.f62363b), rx.internal.operators.a.c(cVar.f62364c - cVar.f62363b, j4 - 1)));
                    } else {
                        cVar.request(rx.internal.operators.a.c(j4, cVar.f62364c));
                    }
                }
            }
        }

        public c(rx.l<? super rx.e<T>> lVar, int i4, int i5) {
            this.f62362a = lVar;
            this.f62363b = i4;
            this.f62364c = i5;
            rx.m a4 = rx.subscriptions.f.a(this);
            this.f62366e = a4;
            add(a4);
            request(0L);
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f62365d.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            rx.subjects.f<T, T> fVar = this.f62368g;
            if (fVar != null) {
                this.f62368g = null;
                fVar.onCompleted();
            }
            this.f62362a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            rx.subjects.f<T, T> fVar = this.f62368g;
            if (fVar != null) {
                this.f62368g = null;
                fVar.onError(th);
            }
            this.f62362a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            int i4 = this.f62367f;
            rx.subjects.i iVar = this.f62368g;
            if (i4 == 0) {
                this.f62365d.getAndIncrement();
                iVar = rx.subjects.i.z7(this.f62363b, this);
                this.f62368g = iVar;
                this.f62362a.onNext(iVar);
            }
            int i5 = i4 + 1;
            if (iVar != null) {
                iVar.onNext(t3);
            }
            if (i5 == this.f62363b) {
                this.f62367f = i5;
                this.f62368g = null;
                iVar.onCompleted();
            } else if (i5 == this.f62364c) {
                this.f62367f = 0;
            } else {
                this.f62367f = i5;
            }
        }

        rx.g x() {
            return new a();
        }
    }

    public a4(int i4, int i5) {
        this.f62339a = i4;
        this.f62340b = i5;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super rx.e<T>> lVar) {
        int i4 = this.f62340b;
        int i5 = this.f62339a;
        if (i4 == i5) {
            a aVar = new a(lVar, i5);
            lVar.add(aVar.f62344d);
            lVar.setProducer(aVar.v());
            return aVar;
        } else if (i4 > i5) {
            c cVar = new c(lVar, i5, i4);
            lVar.add(cVar.f62366e);
            lVar.setProducer(cVar.x());
            return cVar;
        } else {
            b bVar = new b(lVar, i5, i4);
            lVar.add(bVar.f62352e);
            lVar.setProducer(bVar.I());
            return bVar;
        }
    }
}
