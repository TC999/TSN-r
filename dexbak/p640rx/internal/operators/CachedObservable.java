package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.internal.util.LinkedArrayList;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.h */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class CachedObservable<T> extends Observable<T> {

    /* renamed from: b */
    private final C15732a<T> f45252b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedObservable.java */
    /* renamed from: rx.internal.operators.h$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15732a<T> extends LinkedArrayList implements Observer<T> {

        /* renamed from: k */
        static final C15735c<?>[] f45253k = new C15735c[0];

        /* renamed from: f */
        final Observable<? extends T> f45254f;

        /* renamed from: g */
        final SerialSubscription f45255g;

        /* renamed from: h */
        volatile C15735c<?>[] f45256h;

        /* renamed from: i */
        volatile boolean f45257i;

        /* renamed from: j */
        boolean f45258j;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: CachedObservable.java */
        /* renamed from: rx.internal.operators.h$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15733a extends Subscriber<T> {
            C15733a() {
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                C15732a.this.onCompleted();
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15732a.this.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(T t) {
                C15732a.this.onNext(t);
            }
        }

        public C15732a(Observable<? extends T> observable, int i) {
            super(i);
            this.f45254f = observable;
            this.f45256h = f45253k;
            this.f45255g = new SerialSubscription();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: L */
        public void m1235L(C15735c<T> c15735c) {
            synchronized (this.f45255g) {
                C15735c<?>[] c15735cArr = this.f45256h;
                int length = c15735cArr.length;
                C15735c<?>[] c15735cArr2 = new C15735c[length + 1];
                System.arraycopy(c15735cArr, 0, c15735cArr2, 0, length);
                c15735cArr2[length] = c15735c;
                this.f45256h = c15735cArr2;
            }
        }

        /* renamed from: M */
        public void m1234M() {
            C15733a c15733a = new C15733a();
            this.f45255g.m347b(c15733a);
            this.f45254f.m1822I6(c15733a);
            this.f45257i = true;
        }

        /* renamed from: N */
        void m1233N() {
            for (C15735c<?> c15735c : this.f45256h) {
                c15735c.m1230b();
            }
        }

        /* renamed from: O */
        public void m1232O(C15735c<T> c15735c) {
            synchronized (this.f45255g) {
                C15735c<?>[] c15735cArr = this.f45256h;
                int length = c15735cArr.length;
                int i = -1;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (c15735cArr[i2].equals(c15735c)) {
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
                    this.f45256h = f45253k;
                    return;
                }
                C15735c<?>[] c15735cArr2 = new C15735c[length - 1];
                System.arraycopy(c15735cArr, 0, c15735cArr2, 0, i);
                System.arraycopy(c15735cArr, i + 1, c15735cArr2, i, (length - i) - 1);
                this.f45256h = c15735cArr2;
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45258j) {
                return;
            }
            this.f45258j = true;
            m849d(NotificationLite.m1051b());
            this.f45255g.unsubscribe();
            m1233N();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45258j) {
                return;
            }
            this.f45258j = true;
            m849d(NotificationLite.m1050c(th));
            this.f45255g.unsubscribe();
            m1233N();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45258j) {
                return;
            }
            m849d(NotificationLite.m1043j(t));
            m1233N();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedObservable.java */
    /* renamed from: rx.internal.operators.h$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15734b<T> extends AtomicBoolean implements Observable.InterfaceC15567a<T> {
        private static final long serialVersionUID = -2817751667698696782L;

        /* renamed from: a */
        final C15732a<T> f45260a;

        public C15734b(C15732a<T> c15732a) {
            this.f45260a = c15732a;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            C15735c<T> c15735c = new C15735c<>(subscriber, this.f45260a);
            this.f45260a.m1235L(c15735c);
            subscriber.add(c15735c);
            subscriber.setProducer(c15735c);
            if (get() || !compareAndSet(false, true)) {
                return;
            }
            this.f45260a.m1234M();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: CachedObservable.java */
    /* renamed from: rx.internal.operators.h$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15735c<T> extends AtomicLong implements Producer, Subscription {
        private static final long serialVersionUID = -2557562030197141021L;

        /* renamed from: a */
        final Subscriber<? super T> f45261a;

        /* renamed from: b */
        final C15732a<T> f45262b;

        /* renamed from: c */
        Object[] f45263c;

        /* renamed from: d */
        int f45264d;

        /* renamed from: e */
        int f45265e;

        /* renamed from: f */
        boolean f45266f;

        /* renamed from: g */
        boolean f45267g;

        public C15735c(Subscriber<? super T> subscriber, C15732a<T> c15732a) {
            this.f45261a = subscriber;
            this.f45262b = c15732a;
        }

        /* renamed from: a */
        public long m1231a(long j) {
            return addAndGet(-j);
        }

        /* JADX WARN: Removed duplicated region for block: B:88:0x00df  */
        /* renamed from: b */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void m1230b() {
            /*
                Method dump skipped, instructions count: 237
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p640rx.internal.operators.CachedObservable.C15735c.m1230b():void");
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            long j2;
            long j3;
            do {
                j2 = get();
                if (j2 < 0) {
                    return;
                }
                j3 = j2 + j;
                if (j3 < 0) {
                    j3 = Long.MAX_VALUE;
                }
            } while (!compareAndSet(j2, j3));
            m1230b();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (get() < 0 || getAndSet(-1L) < 0) {
                return;
            }
            this.f45262b.m1232O(this);
        }
    }

    private CachedObservable(Observable.InterfaceC15567a<T> interfaceC15567a, C15732a<T> c15732a) {
        super(interfaceC15567a);
        this.f45252b = c15732a;
    }

    /* renamed from: v7 */
    public static <T> CachedObservable<T> m1239v7(Observable<? extends T> observable) {
        return m1238w7(observable, 16);
    }

    /* renamed from: w7 */
    public static <T> CachedObservable<T> m1238w7(Observable<? extends T> observable, int i) {
        if (i >= 1) {
            C15732a c15732a = new C15732a(observable, i);
            return new CachedObservable<>(new C15734b(c15732a), c15732a);
        }
        throw new IllegalArgumentException("capacityHint > 0 required");
    }

    /* renamed from: x7 */
    boolean m1237x7() {
        return this.f45252b.f45256h.length != 0;
    }

    /* renamed from: y7 */
    boolean m1236y7() {
        return this.f45252b.f45257i;
    }
}
