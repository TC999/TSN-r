package rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;
import rx.exceptions.MissingBackpressureException;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorPublish.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class s2<T> extends rx.observables.c<T> {

    /* renamed from: b  reason: collision with root package name */
    final rx.e<? extends T> f63267b;

    /* renamed from: c  reason: collision with root package name */
    final AtomicReference<d<T>> f63268c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorPublish.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicReference f63269a;

        a(AtomicReference atomicReference) {
            this.f63269a = atomicReference;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super T> lVar) {
            while (true) {
                d dVar = (d) this.f63269a.get();
                if (dVar == null || dVar.isUnsubscribed()) {
                    d dVar2 = new d(this.f63269a);
                    dVar2.I();
                    if (this.f63269a.compareAndSet(dVar, dVar2)) {
                        dVar = dVar2;
                    } else {
                        continue;
                    }
                }
                c<T> cVar = new c<>(dVar, lVar);
                if (dVar.g(cVar)) {
                    lVar.add(cVar);
                    lVar.setProducer(cVar);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorPublish.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b<R> implements e.a<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ boolean f63270a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.p f63271b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.e f63272c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorPublish.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a extends rx.l<R> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.l f63273a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ OnSubscribePublishMulticast f63274b;

            a(rx.l lVar, OnSubscribePublishMulticast onSubscribePublishMulticast) {
                this.f63273a = lVar;
                this.f63274b = onSubscribePublishMulticast;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f63274b.unsubscribe();
                this.f63273a.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f63274b.unsubscribe();
                this.f63273a.onError(th);
            }

            @Override // rx.f
            public void onNext(R r3) {
                this.f63273a.onNext(r3);
            }

            @Override // rx.l, rx.observers.a
            public void setProducer(rx.g gVar) {
                this.f63273a.setProducer(gVar);
            }
        }

        b(boolean z3, rx.functions.p pVar, rx.e eVar) {
            this.f63270a = z3;
            this.f63271b = pVar;
            this.f63272c = eVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super R> lVar) {
            OnSubscribePublishMulticast onSubscribePublishMulticast = new OnSubscribePublishMulticast(rx.internal.util.j.f63940d, this.f63270a);
            a aVar = new a(lVar, onSubscribePublishMulticast);
            lVar.add(onSubscribePublishMulticast);
            lVar.add(aVar);
            ((rx.e) this.f63271b.call(rx.e.H6(onSubscribePublishMulticast))).I6(aVar);
            this.f63272c.I6(onSubscribePublishMulticast.subscriber());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorPublish.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class c<T> extends AtomicLong implements rx.g, rx.m {

        /* renamed from: c  reason: collision with root package name */
        static final long f63276c = Long.MIN_VALUE;

        /* renamed from: d  reason: collision with root package name */
        static final long f63277d = -4611686018427387904L;
        private static final long serialVersionUID = -4453897557930727610L;

        /* renamed from: a  reason: collision with root package name */
        final d<T> f63278a;

        /* renamed from: b  reason: collision with root package name */
        final rx.l<? super T> f63279b;

        public c(d<T> dVar, rx.l<? super T> lVar) {
            this.f63278a = dVar;
            this.f63279b = lVar;
            lazySet(-4611686018427387904L);
        }

        public long a(long j4) {
            long j5;
            long j6;
            if (j4 > 0) {
                do {
                    j5 = get();
                    if (j5 == -4611686018427387904L) {
                        throw new IllegalStateException("Produced without request");
                    }
                    if (j5 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j6 = j5 - j4;
                    if (j6 < 0) {
                        throw new IllegalStateException("More produced (" + j4 + ") than requested (" + j5 + ")");
                    }
                } while (!compareAndSet(j5, j6));
                return j6;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // rx.g
        public void request(long j4) {
            long j5;
            long j6;
            if (j4 < 0) {
                return;
            }
            do {
                j5 = get();
                if (j5 == Long.MIN_VALUE) {
                    return;
                }
                if (j5 >= 0 && j4 == 0) {
                    return;
                }
                if (j5 == -4611686018427387904L) {
                    j6 = j4;
                } else {
                    j6 = j5 + j4;
                    if (j6 < 0) {
                        j6 = Long.MAX_VALUE;
                    }
                }
            } while (!compareAndSet(j5, j6));
            this.f63278a.x();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.f63278a.J(this);
            this.f63278a.x();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorPublish.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class d<T> extends rx.l<T> implements rx.m {

        /* renamed from: h  reason: collision with root package name */
        static final c[] f63280h = new c[0];

        /* renamed from: i  reason: collision with root package name */
        static final c[] f63281i = new c[0];

        /* renamed from: a  reason: collision with root package name */
        final Queue<Object> f63282a;

        /* renamed from: b  reason: collision with root package name */
        final AtomicReference<d<T>> f63283b;

        /* renamed from: c  reason: collision with root package name */
        volatile Object f63284c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicReference<c[]> f63285d;

        /* renamed from: e  reason: collision with root package name */
        final AtomicBoolean f63286e;

        /* renamed from: f  reason: collision with root package name */
        boolean f63287f;

        /* renamed from: g  reason: collision with root package name */
        boolean f63288g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorPublish.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.a {
            a() {
            }

            @Override // rx.functions.a
            public void call() {
                d.this.f63285d.getAndSet(d.f63281i);
                d<T> dVar = d.this;
                dVar.f63283b.compareAndSet(dVar, null);
            }
        }

        public d(AtomicReference<d<T>> atomicReference) {
            this.f63282a = rx.internal.util.unsafe.n0.f() ? new rx.internal.util.unsafe.z<>(rx.internal.util.j.f63940d) : new rx.internal.util.atomic.d<>(rx.internal.util.j.f63940d);
            this.f63285d = new AtomicReference<>(f63280h);
            this.f63283b = atomicReference;
            this.f63286e = new AtomicBoolean();
        }

        void I() {
            add(rx.subscriptions.f.a(new a()));
        }

        void J(c<T> cVar) {
            c[] cVarArr;
            c[] cVarArr2;
            do {
                cVarArr = this.f63285d.get();
                if (cVarArr == f63280h || cVarArr == f63281i) {
                    return;
                }
                int i4 = -1;
                int length = cVarArr.length;
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    } else if (cVarArr[i5].equals(cVar)) {
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
                    cVarArr2 = f63280h;
                } else {
                    c[] cVarArr3 = new c[length - 1];
                    System.arraycopy(cVarArr, 0, cVarArr3, 0, i4);
                    System.arraycopy(cVarArr, i4 + 1, cVarArr3, i4, (length - i4) - 1);
                    cVarArr2 = cVarArr3;
                }
            } while (!this.f63285d.compareAndSet(cVarArr, cVarArr2));
        }

        boolean g(c<T> cVar) {
            c[] cVarArr;
            c[] cVarArr2;
            cVar.getClass();
            do {
                cVarArr = this.f63285d.get();
                if (cVarArr == f63281i) {
                    return false;
                }
                int length = cVarArr.length;
                cVarArr2 = new c[length + 1];
                System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
                cVarArr2[length] = cVar;
            } while (!this.f63285d.compareAndSet(cVarArr, cVarArr2));
            return true;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63284c == null) {
                this.f63284c = v.b();
                x();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63284c == null) {
                this.f63284c = v.c(th);
                x();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (!this.f63282a.offer(v.j(t3))) {
                onError(new MissingBackpressureException());
            } else {
                x();
            }
        }

        @Override // rx.l
        public void onStart() {
            request(rx.internal.util.j.f63940d);
        }

        boolean v(Object obj, boolean z3) {
            int i4 = 0;
            if (obj != null) {
                if (!v.f(obj)) {
                    Throwable d4 = v.d(obj);
                    this.f63283b.compareAndSet(this, null);
                    try {
                        c[] andSet = this.f63285d.getAndSet(f63281i);
                        int length = andSet.length;
                        while (i4 < length) {
                            andSet[i4].f63279b.onError(d4);
                            i4++;
                        }
                        return true;
                    } finally {
                    }
                } else if (z3) {
                    this.f63283b.compareAndSet(this, null);
                    try {
                        c[] andSet2 = this.f63285d.getAndSet(f63281i);
                        int length2 = andSet2.length;
                        while (i4 < length2) {
                            andSet2[i4].f63279b.onCompleted();
                            i4++;
                        }
                        return true;
                    } finally {
                    }
                }
            }
            return false;
        }

        void x() {
            boolean z3;
            long j4;
            synchronized (this) {
                if (this.f63287f) {
                    this.f63288g = true;
                    return;
                }
                this.f63287f = true;
                this.f63288g = false;
                while (true) {
                    try {
                        Object obj = this.f63284c;
                        boolean isEmpty = this.f63282a.isEmpty();
                        if (v(obj, isEmpty)) {
                            return;
                        }
                        if (!isEmpty) {
                            c[] cVarArr = this.f63285d.get();
                            int length = cVarArr.length;
                            long j5 = Long.MAX_VALUE;
                            int i4 = 0;
                            for (c cVar : cVarArr) {
                                long j6 = cVar.get();
                                if (j6 >= 0) {
                                    j5 = Math.min(j5, j6);
                                } else if (j6 == Long.MIN_VALUE) {
                                    i4++;
                                }
                            }
                            if (length == i4) {
                                if (v(this.f63284c, this.f63282a.poll() == null)) {
                                    return;
                                }
                                request(1L);
                            } else {
                                int i5 = 0;
                                while (true) {
                                    j4 = i5;
                                    if (j4 >= j5) {
                                        break;
                                    }
                                    Object obj2 = this.f63284c;
                                    Object poll = this.f63282a.poll();
                                    boolean z4 = poll == null;
                                    if (v(obj2, z4)) {
                                        return;
                                    }
                                    if (z4) {
                                        isEmpty = z4;
                                        break;
                                    }
                                    Object e4 = v.e(poll);
                                    for (c cVar2 : cVarArr) {
                                        if (cVar2.get() > 0) {
                                            cVar2.f63279b.onNext(e4);
                                            cVar2.a(1L);
                                        }
                                    }
                                    i5++;
                                    isEmpty = z4;
                                }
                                if (i5 > 0) {
                                    request(j4);
                                }
                                if (j5 != 0 && !isEmpty) {
                                }
                            }
                        }
                        synchronized (this) {
                            try {
                                if (!this.f63288g) {
                                    this.f63287f = false;
                                    try {
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        z3 = true;
                                        while (true) {
                                            try {
                                                break;
                                            } catch (Throwable th2) {
                                                th = th2;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                                this.f63288g = false;
                            } catch (Throwable th3) {
                                th = th3;
                                z3 = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                            if (!z3) {
                                synchronized (this) {
                                    this.f63287f = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z3 = false;
                    }
                }
            }
        }
    }

    private s2(e.a<T> aVar, rx.e<? extends T> eVar, AtomicReference<d<T>> atomicReference) {
        super(aVar);
        this.f63267b = eVar;
        this.f63268c = atomicReference;
    }

    public static <T, R> rx.e<R> B7(rx.e<? extends T> eVar, rx.functions.p<? super rx.e<T>, ? extends rx.e<R>> pVar) {
        return C7(eVar, pVar, false);
    }

    public static <T, R> rx.e<R> C7(rx.e<? extends T> eVar, rx.functions.p<? super rx.e<T>, ? extends rx.e<R>> pVar, boolean z3) {
        return rx.e.H6(new b(z3, pVar, eVar));
    }

    public static <T> rx.observables.c<T> D7(rx.e<? extends T> eVar) {
        AtomicReference atomicReference = new AtomicReference();
        return new s2(new a(atomicReference), eVar, atomicReference);
    }

    @Override // rx.observables.c
    public void z7(rx.functions.b<? super rx.m> bVar) {
        d<T> dVar;
        while (true) {
            dVar = this.f63268c.get();
            if (dVar != null && !dVar.isUnsubscribed()) {
                break;
            }
            d<T> dVar2 = new d<>(this.f63268c);
            dVar2.I();
            if (this.f63268c.compareAndSet(dVar, dVar2)) {
                dVar = dVar2;
                break;
            }
        }
        boolean z3 = true;
        z3 = (dVar.f63286e.get() || !dVar.f63286e.compareAndSet(false, true)) ? false : false;
        bVar.call(dVar);
        if (z3) {
            this.f63267b.I6(dVar);
        }
    }
}
