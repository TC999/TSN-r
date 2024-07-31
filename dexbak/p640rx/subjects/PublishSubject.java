package p640rx.subjects;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.MissingBackpressureException;
import p640rx.internal.operators.BackpressureUtils;

/* renamed from: rx.subjects.c */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class PublishSubject<T> extends Subject<T, T> {

    /* renamed from: b */
    final C16170b<T> f47000b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublishSubject.java */
    /* renamed from: rx.subjects.c$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16169a<T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        private static final long serialVersionUID = 6451806817170721536L;

        /* renamed from: a */
        final C16170b<T> f47001a;

        /* renamed from: b */
        final Subscriber<? super T> f47002b;

        /* renamed from: c */
        long f47003c;

        public C16169a(C16170b<T> c16170b, Subscriber<? super T> subscriber) {
            this.f47001a = c16170b;
            this.f47002b = subscriber;
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (get() != Long.MIN_VALUE) {
                this.f47002b.onCompleted();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (get() != Long.MIN_VALUE) {
                this.f47002b.onError(th);
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            long j = get();
            if (j != Long.MIN_VALUE) {
                long j2 = this.f47003c;
                if (j != j2) {
                    this.f47003c = j2 + 1;
                    this.f47002b.onNext(t);
                    return;
                }
                unsubscribe();
                this.f47002b.onError(new MissingBackpressureException("PublishSubject: could not emit value due to lack of requests"));
            }
        }

        @Override // p640rx.Producer
        public void request(long j) {
            long j2;
            if (BackpressureUtils.m1327j(j)) {
                do {
                    j2 = get();
                    if (j2 == Long.MIN_VALUE) {
                        return;
                    }
                } while (!compareAndSet(j2, BackpressureUtils.m1336a(j2, j)));
            }
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.f47001a.m424F(this);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: PublishSubject.java */
    /* renamed from: rx.subjects.c$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16170b<T> extends AtomicReference<C16169a<T>[]> implements Observable.InterfaceC15567a<T>, Observer<T> {

        /* renamed from: b */
        static final C16169a[] f47004b = new C16169a[0];

        /* renamed from: c */
        static final C16169a[] f47005c = new C16169a[0];
        private static final long serialVersionUID = -7568940796666027140L;

        /* renamed from: a */
        Throwable f47006a;

        public C16170b() {
            lazySet(f47004b);
        }

        /* renamed from: F */
        void m424F(C16169a<T> c16169a) {
            C16169a<T>[] c16169aArr;
            C16169a[] c16169aArr2;
            do {
                c16169aArr = get();
                if (c16169aArr == f47005c || c16169aArr == f47004b) {
                    return;
                }
                int length = c16169aArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (c16169aArr[i2] == c16169a) {
                        i = i2;
                        break;
                    } else {
                        i2++;
                    }
                }
                if (i < 0) {
                    return;
                }
                if (length == 1) {
                    c16169aArr2 = f47004b;
                } else {
                    C16169a[] c16169aArr3 = new C16169a[length - 1];
                    System.arraycopy(c16169aArr, 0, c16169aArr3, 0, i);
                    System.arraycopy(c16169aArr, i + 1, c16169aArr3, i, (length - i) - 1);
                    c16169aArr2 = c16169aArr3;
                }
            } while (!compareAndSet(c16169aArr, c16169aArr2));
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        /* renamed from: d */
        boolean m423d(C16169a<T> c16169a) {
            C16169a<T>[] c16169aArr;
            C16169a[] c16169aArr2;
            do {
                c16169aArr = get();
                if (c16169aArr == f47005c) {
                    return false;
                }
                int length = c16169aArr.length;
                c16169aArr2 = new C16169a[length + 1];
                System.arraycopy(c16169aArr, 0, c16169aArr2, 0, length);
                c16169aArr2[length] = c16169a;
            } while (!compareAndSet(c16169aArr, c16169aArr2));
            return true;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            for (C16169a<T> c16169a : getAndSet(f47005c)) {
                c16169a.onCompleted();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f47006a = th;
            ArrayList arrayList = null;
            for (C16169a<T> c16169a : getAndSet(f47005c)) {
                try {
                    c16169a.onError(th);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(1);
                    }
                    arrayList.add(th2);
                }
            }
            C15575a.m1475d(arrayList);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            for (C16169a<T> c16169a : get()) {
                c16169a.onNext(t);
            }
        }

        public void call(Subscriber<? super T> subscriber) {
            C16169a<T> c16169a = new C16169a<>(this, subscriber);
            subscriber.add(c16169a);
            subscriber.setProducer(c16169a);
            if (m423d(c16169a)) {
                if (c16169a.isUnsubscribed()) {
                    m424F(c16169a);
                    return;
                }
                return;
            }
            Throwable th = this.f47006a;
            if (th != null) {
                subscriber.onError(th);
            } else {
                subscriber.onCompleted();
            }
        }
    }

    protected PublishSubject(C16170b<T> c16170b) {
        super(c16170b);
        this.f47000b = c16170b;
    }

    /* renamed from: x7 */
    public static <T> PublishSubject<T> m427x7() {
        return new PublishSubject<>(new C16170b());
    }

    /* renamed from: A7 */
    public boolean m428A7() {
        return this.f47000b.get() == C16170b.f47005c && this.f47000b.f47006a != null;
    }

    @Override // p640rx.Observer
    public void onCompleted() {
        this.f47000b.onCompleted();
    }

    @Override // p640rx.Observer
    public void onError(Throwable th) {
        this.f47000b.onError(th);
    }

    @Override // p640rx.Observer
    public void onNext(T t) {
        this.f47000b.onNext(t);
    }

    @Override // p640rx.subjects.Subject
    /* renamed from: v7 */
    public boolean mo371v7() {
        return this.f47000b.get().length != 0;
    }

    /* renamed from: y7 */
    public Throwable m426y7() {
        if (this.f47000b.get() == C16170b.f47005c) {
            return this.f47000b.f47006a;
        }
        return null;
    }

    /* renamed from: z7 */
    public boolean m425z7() {
        return this.f47000b.get() == C16170b.f47005c && this.f47000b.f47006a == null;
    }
}
