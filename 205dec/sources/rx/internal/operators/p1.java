package rx.internal.operators;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.e;
import rx.exceptions.MissingBackpressureException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorBufferWithSize.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class p1<T> implements e.b<List<T>, T> {

    /* renamed from: a  reason: collision with root package name */
    final int f63110a;

    /* renamed from: b  reason: collision with root package name */
    final int f63111b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorBufferWithSize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super List<T>> f63112a;

        /* renamed from: b  reason: collision with root package name */
        final int f63113b;

        /* renamed from: c  reason: collision with root package name */
        List<T> f63114c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorBufferWithSize.java */
        /* renamed from: rx.internal.operators.p1$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1292a implements rx.g {
            C1292a() {
            }

            @Override // rx.g
            public void request(long j4) {
                if (j4 < 0) {
                    throw new IllegalArgumentException("n >= required but it was " + j4);
                } else if (j4 != 0) {
                    a.this.request(rx.internal.operators.a.c(j4, a.this.f63113b));
                }
            }
        }

        public a(rx.l<? super List<T>> lVar, int i4) {
            this.f63112a = lVar;
            this.f63113b = i4;
            request(0L);
        }

        @Override // rx.f
        public void onCompleted() {
            List<T> list = this.f63114c;
            if (list != null) {
                this.f63112a.onNext(list);
            }
            this.f63112a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63114c = null;
            this.f63112a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            List list = this.f63114c;
            if (list == null) {
                list = new ArrayList(this.f63113b);
                this.f63114c = list;
            }
            list.add(t3);
            if (list.size() == this.f63113b) {
                this.f63114c = null;
                this.f63112a.onNext(list);
            }
        }

        rx.g v() {
            return new C1292a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorBufferWithSize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super List<T>> f63116a;

        /* renamed from: b  reason: collision with root package name */
        final int f63117b;

        /* renamed from: c  reason: collision with root package name */
        final int f63118c;

        /* renamed from: d  reason: collision with root package name */
        long f63119d;

        /* renamed from: e  reason: collision with root package name */
        final ArrayDeque<List<T>> f63120e = new ArrayDeque<>();

        /* renamed from: f  reason: collision with root package name */
        final AtomicLong f63121f = new AtomicLong();

        /* renamed from: g  reason: collision with root package name */
        long f63122g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorBufferWithSize.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class a extends AtomicBoolean implements rx.g {
            private static final long serialVersionUID = -4015894850868853147L;

            a() {
            }

            @Override // rx.g
            public void request(long j4) {
                b bVar = b.this;
                if (!rx.internal.operators.a.g(bVar.f63121f, j4, bVar.f63120e, bVar.f63116a) || j4 == 0) {
                    return;
                }
                if (!get() && compareAndSet(false, true)) {
                    bVar.request(rx.internal.operators.a.a(rx.internal.operators.a.c(bVar.f63118c, j4 - 1), bVar.f63117b));
                } else {
                    bVar.request(rx.internal.operators.a.c(bVar.f63118c, j4));
                }
            }
        }

        public b(rx.l<? super List<T>> lVar, int i4, int i5) {
            this.f63116a = lVar;
            this.f63117b = i4;
            this.f63118c = i5;
            request(0L);
        }

        @Override // rx.f
        public void onCompleted() {
            long j4 = this.f63122g;
            if (j4 != 0) {
                if (j4 > this.f63121f.get()) {
                    rx.l<? super List<T>> lVar = this.f63116a;
                    lVar.onError(new MissingBackpressureException("More produced than requested? " + j4));
                    return;
                }
                this.f63121f.addAndGet(-j4);
            }
            rx.internal.operators.a.d(this.f63121f, this.f63120e, this.f63116a);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63120e.clear();
            this.f63116a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            long j4 = this.f63119d;
            if (j4 == 0) {
                this.f63120e.offer(new ArrayList(this.f63117b));
            }
            long j5 = j4 + 1;
            if (j5 == this.f63118c) {
                this.f63119d = 0L;
            } else {
                this.f63119d = j5;
            }
            Iterator<List<T>> it = this.f63120e.iterator();
            while (it.hasNext()) {
                it.next().add(t3);
            }
            List<T> peek = this.f63120e.peek();
            if (peek == null || peek.size() != this.f63117b) {
                return;
            }
            this.f63120e.poll();
            this.f63122g++;
            this.f63116a.onNext(peek);
        }

        rx.g x() {
            return new a();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorBufferWithSize.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super List<T>> f63124a;

        /* renamed from: b  reason: collision with root package name */
        final int f63125b;

        /* renamed from: c  reason: collision with root package name */
        final int f63126c;

        /* renamed from: d  reason: collision with root package name */
        long f63127d;

        /* renamed from: e  reason: collision with root package name */
        List<T> f63128e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorBufferWithSize.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class a extends AtomicBoolean implements rx.g {
            private static final long serialVersionUID = 3428177408082367154L;

            a() {
            }

            @Override // rx.g
            public void request(long j4) {
                if (j4 < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j4);
                } else if (j4 != 0) {
                    c cVar = c.this;
                    if (!get() && compareAndSet(false, true)) {
                        cVar.request(rx.internal.operators.a.a(rx.internal.operators.a.c(j4, cVar.f63125b), rx.internal.operators.a.c(cVar.f63126c - cVar.f63125b, j4 - 1)));
                    } else {
                        cVar.request(rx.internal.operators.a.c(j4, cVar.f63126c));
                    }
                }
            }
        }

        public c(rx.l<? super List<T>> lVar, int i4, int i5) {
            this.f63124a = lVar;
            this.f63125b = i4;
            this.f63126c = i5;
            request(0L);
        }

        @Override // rx.f
        public void onCompleted() {
            List<T> list = this.f63128e;
            if (list != null) {
                this.f63128e = null;
                this.f63124a.onNext(list);
            }
            this.f63124a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63128e = null;
            this.f63124a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            long j4 = this.f63127d;
            List list = this.f63128e;
            if (j4 == 0) {
                list = new ArrayList(this.f63125b);
                this.f63128e = list;
            }
            long j5 = j4 + 1;
            if (j5 == this.f63126c) {
                this.f63127d = 0L;
            } else {
                this.f63127d = j5;
            }
            if (list != null) {
                list.add(t3);
                if (list.size() == this.f63125b) {
                    this.f63128e = null;
                    this.f63124a.onNext(list);
                }
            }
        }

        rx.g x() {
            return new a();
        }
    }

    public p1(int i4, int i5) {
        if (i4 <= 0) {
            throw new IllegalArgumentException("count must be greater than 0");
        }
        if (i5 > 0) {
            this.f63110a = i4;
            this.f63111b = i5;
            return;
        }
        throw new IllegalArgumentException("skip must be greater than 0");
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super List<T>> lVar) {
        int i4 = this.f63111b;
        int i5 = this.f63110a;
        if (i4 == i5) {
            a aVar = new a(lVar, i5);
            lVar.add(aVar);
            lVar.setProducer(aVar.v());
            return aVar;
        } else if (i4 > i5) {
            c cVar = new c(lVar, i5, i4);
            lVar.add(cVar);
            lVar.setProducer(cVar.x());
            return cVar;
        } else {
            b bVar = new b(lVar, i5, i4);
            lVar.add(bVar);
            lVar.setProducer(bVar.x());
            return bVar;
        }
    }
}
