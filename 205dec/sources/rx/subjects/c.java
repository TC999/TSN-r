package rx.subjects;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.MissingBackpressureException;
import rx.l;
import rx.m;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: PublishSubject.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class c<T> extends f<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final b<T> f64269b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: PublishSubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class a<T> extends AtomicLong implements rx.g, m, rx.f<T> {
        private static final long serialVersionUID = 6451806817170721536L;

        /* renamed from: a  reason: collision with root package name */
        final b<T> f64270a;

        /* renamed from: b  reason: collision with root package name */
        final l<? super T> f64271b;

        /* renamed from: c  reason: collision with root package name */
        long f64272c;

        public a(b<T> bVar, l<? super T> lVar) {
            this.f64270a = bVar;
            this.f64271b = lVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.f
        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.f64271b.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.f64271b.onError(th);
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            long j4 = get();
            if (j4 != Long.MIN_VALUE) {
                long j5 = this.f64272c;
                if (j4 != j5) {
                    this.f64272c = j5 + 1;
                    this.f64271b.onNext(t3);
                    return;
                }
                unsubscribe();
                this.f64271b.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
            }
        }

        @Override // rx.g
        public void request(long j4) {
            long j5;
            if (rx.internal.operators.a.j(j4)) {
                do {
                    j5 = get();
                    if (j5 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j5, rx.internal.operators.a.a(j5, j4)));
            }
        }

        @Override // rx.m
        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f64270a.F(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: PublishSubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class b<T> extends AtomicReference<a<T>[]> implements e.a<T>, rx.f<T> {

        /* renamed from: b  reason: collision with root package name */
        static final a[] f64273b = new a[0];

        /* renamed from: c  reason: collision with root package name */
        static final a[] f64274c = new a[0];
        private static final long serialVersionUID = -7568940796666027140L;

        /* renamed from: a  reason: collision with root package name */
        Throwable f64275a;

        public b() {
            lazySet(f64273b);
        }

        void F(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr == f64274c || aVarArr == f64273b) {
                    return;
                }
                int length = aVarArr.length;
                int i4 = -1;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    } else if (aVarArr[i5] == aVar) {
                        i4 = i5;
                        break;
                    } else {
                        i5++;
                    }
                }
                if (i4 < 0) {
                    return;
                }
                if (length == 1) {
                    aVarArr2 = f64273b;
                } else {
                    a[] aVarArr3 = new a[length - 1];
                    System.arraycopy(aVarArr, 0, aVarArr3, 0, i4);
                    System.arraycopy(aVarArr, i4 + 1, aVarArr3, i4, (length - i4) - 1);
                    aVarArr2 = aVarArr3;
                }
            } while (!compareAndSet(aVarArr, aVarArr2));
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((l) ((l) obj));
        }

        boolean d(a<T> aVar) {
            a<T>[] aVarArr;
            a[] aVarArr2;
            do {
                aVarArr = get();
                if (aVarArr == f64274c) {
                    return false;
                }
                int length = aVarArr.length;
                aVarArr2 = new a[length + 1];
                System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
                aVarArr2[length] = aVar;
            } while (!compareAndSet(aVarArr, aVarArr2));
            return true;
        }

        @Override // rx.f
        public void onCompleted() {
            for (a<T> aVar : getAndSet(f64274c)) {
                aVar.onCompleted();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f64275a = th;
            ArrayList arrayList = null;
            for (a<T> aVar : getAndSet(f64274c)) {
                try {
                    aVar.onError(th);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.d(arrayList);
        }

        @Override // rx.f
        public void onNext(T t3) {
            for (a<T> aVar : get()) {
                aVar.onNext(t3);
            }
        }

        public void call(l<? super T> lVar) {
            a<T> aVar = new a<>(this, lVar);
            lVar.add(aVar);
            lVar.setProducer(aVar);
            if (d(aVar)) {
                if (aVar.isUnsubscribed()) {
                    F(aVar);
                    return;
                }
                return;
            }
            Throwable th = this.f64275a;
            if (th != null) {
                lVar.onError(th);
            } else {
                lVar.onCompleted();
            }
        }
    }

    protected c(b<T> bVar) {
        super(bVar);
        this.f64269b = bVar;
    }

    public static <T> c<T> x7() {
        return new c<>(new b());
    }

    public boolean A7() {
        return this.f64269b.get() == b.f64274c && this.f64269b.f64275a != null;
    }

    @Override // rx.f
    public void onCompleted() {
        this.f64269b.onCompleted();
    }

    @Override // rx.f
    public void onError(Throwable th) {
        this.f64269b.onError(th);
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f64269b.onNext(t3);
    }

    @Override // rx.subjects.f
    public boolean v7() {
        return this.f64269b.get().length != 0;
    }

    public Throwable y7() {
        if (this.f64269b.get() == b.f64274c) {
            return this.f64269b.f64275a;
        }
        return null;
    }

    public boolean z7() {
        return this.f64269b.get() == b.f64274c && this.f64269b.f64275a == null;
    }
}
