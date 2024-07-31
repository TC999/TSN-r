package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.MissingBackpressureException;
import p640rx.functions.C15576a0;
import p640rx.functions.Func2;
import p640rx.functions.Func3;
import p640rx.functions.Func4;
import p640rx.functions.Func5;
import p640rx.functions.Func6;
import p640rx.functions.Func7;
import p640rx.functions.Func8;
import p640rx.functions.Func9;
import p640rx.functions.FuncN;
import p640rx.internal.util.RxRingBuffer;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.f4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorZip<R> implements Observable.InterfaceC15568b<R, Observable<?>[]> {

    /* renamed from: a */
    final FuncN<? extends R> f45160a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorZip.java */
    /* renamed from: rx.internal.operators.f4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15712a<R> extends AtomicLong {

        /* renamed from: g */
        static final int f45161g;
        private static final long serialVersionUID = 5995274816189928317L;

        /* renamed from: a */
        final Observer<? super R> f45162a;

        /* renamed from: b */
        private final FuncN<? extends R> f45163b;

        /* renamed from: c */
        private final CompositeSubscription f45164c;

        /* renamed from: d */
        int f45165d;

        /* renamed from: e */
        private volatile Object[] f45166e;

        /* renamed from: f */
        private AtomicLong f45167f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorZip.java */
        /* renamed from: rx.internal.operators.f4$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15713a extends Subscriber {

            /* renamed from: a */
            final RxRingBuffer f45168a = RxRingBuffer.m834H();

            C15713a() {
            }

            /* renamed from: F */
            public void m1258F(long j) {
                request(j);
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                this.f45168a.m828N();
                C15712a.this.m1259b();
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15712a.this.f45162a.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(Object obj) {
                try {
                    this.f45168a.m826P(obj);
                } catch (MissingBackpressureException e) {
                    onError(e);
                }
                C15712a.this.m1259b();
            }

            @Override // p640rx.Subscriber
            public void onStart() {
                request(RxRingBuffer.f46509d);
            }
        }

        static {
            double d = RxRingBuffer.f46509d;
            Double.isNaN(d);
            f45161g = (int) (d * 0.7d);
        }

        public C15712a(Subscriber<? super R> subscriber, FuncN<? extends R> funcN) {
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.f45164c = compositeSubscription;
            this.f45162a = subscriber;
            this.f45163b = funcN;
            subscriber.add(compositeSubscription);
        }

        /* renamed from: a */
        public void m1260a(Observable[] observableArr, AtomicLong atomicLong) {
            Object[] objArr = new Object[observableArr.length];
            for (int i = 0; i < observableArr.length; i++) {
                C15713a c15713a = new C15713a();
                objArr[i] = c15713a;
                this.f45164c.m359a(c15713a);
            }
            this.f45167f = atomicLong;
            this.f45166e = objArr;
            for (int i2 = 0; i2 < observableArr.length; i2++) {
                observableArr[i2].m1822I6((C15713a) objArr[i2]);
            }
        }

        /* renamed from: b */
        void m1259b() {
            Object[] objArr = this.f45166e;
            if (objArr == null || getAndIncrement() != 0) {
                return;
            }
            int length = objArr.length;
            Observer<? super R> observer = this.f45162a;
            AtomicLong atomicLong = this.f45167f;
            while (true) {
                Object[] objArr2 = new Object[length];
                boolean z = true;
                for (int i = 0; i < length; i++) {
                    RxRingBuffer rxRingBuffer = ((C15713a) objArr[i]).f45168a;
                    Object m825Q = rxRingBuffer.m825Q();
                    if (m825Q == null) {
                        z = false;
                    } else if (rxRingBuffer.m831K(m825Q)) {
                        observer.onCompleted();
                        this.f45164c.unsubscribe();
                        return;
                    } else {
                        objArr2[i] = rxRingBuffer.m832J(m825Q);
                    }
                }
                if (z && atomicLong.get() > 0) {
                    try {
                        observer.onNext((R) this.f45163b.call(objArr2));
                        atomicLong.decrementAndGet();
                        this.f45165d++;
                        for (Object obj : objArr) {
                            RxRingBuffer rxRingBuffer2 = ((C15713a) obj).f45168a;
                            rxRingBuffer2.m824R();
                            if (rxRingBuffer2.m831K(rxRingBuffer2.m825Q())) {
                                observer.onCompleted();
                                this.f45164c.unsubscribe();
                                return;
                            }
                        }
                        if (this.f45165d > f45161g) {
                            for (Object obj2 : objArr) {
                                ((C15713a) obj2).m1258F(this.f45165d);
                            }
                            this.f45165d = 0;
                        }
                    } catch (Throwable th) {
                        C15575a.m1472g(th, observer, objArr2);
                        return;
                    }
                } else if (decrementAndGet() <= 0) {
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorZip.java */
    /* renamed from: rx.internal.operators.f4$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15714b<R> extends AtomicLong implements Producer {
        private static final long serialVersionUID = -1216676403723546796L;

        /* renamed from: a */
        final C15712a<R> f45170a;

        public C15714b(C15712a<R> c15712a) {
            this.f45170a = c15712a;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            BackpressureUtils.m1335b(this, j);
            this.f45170a.m1259b();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorZip.java */
    /* renamed from: rx.internal.operators.f4$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15715c extends Subscriber<Observable[]> {

        /* renamed from: a */
        final Subscriber<? super R> f45171a;

        /* renamed from: b */
        final C15712a<R> f45172b;

        /* renamed from: c */
        final C15714b<R> f45173c;

        /* renamed from: d */
        boolean f45174d;

        public C15715c(Subscriber<? super R> subscriber, C15712a<R> c15712a, C15714b<R> c15714b) {
            this.f45171a = subscriber;
            this.f45172b = c15712a;
            this.f45173c = c15714b;
        }

        @Override // p640rx.Observer
        /* renamed from: F */
        public void onNext(Observable[] observableArr) {
            if (observableArr != null && observableArr.length != 0) {
                this.f45174d = true;
                this.f45172b.m1260a(observableArr, this.f45173c);
                return;
            }
            this.f45171a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45174d) {
                return;
            }
            this.f45171a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45171a.onError(th);
        }
    }

    public OperatorZip(FuncN<? extends R> funcN) {
        this.f45160a = funcN;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super Observable[]> call(Subscriber<? super R> subscriber) {
        C15712a c15712a = new C15712a(subscriber, this.f45160a);
        C15714b c15714b = new C15714b(c15712a);
        C15715c c15715c = new C15715c(subscriber, c15712a, c15714b);
        subscriber.add(c15715c);
        subscriber.setProducer(c15714b);
        return c15715c;
    }

    public OperatorZip(Func2 func2) {
        this.f45160a = C15576a0.m1463g(func2);
    }

    public OperatorZip(Func3 func3) {
        this.f45160a = C15576a0.m1462h(func3);
    }

    public OperatorZip(Func4 func4) {
        this.f45160a = C15576a0.m1461i(func4);
    }

    public OperatorZip(Func5 func5) {
        this.f45160a = C15576a0.m1460j(func5);
    }

    public OperatorZip(Func6 func6) {
        this.f45160a = C15576a0.m1459k(func6);
    }

    public OperatorZip(Func7 func7) {
        this.f45160a = C15576a0.m1458l(func7);
    }

    public OperatorZip(Func8 func8) {
        this.f45160a = C15576a0.m1457m(func8);
    }

    public OperatorZip(Func9 func9) {
        this.f45160a = C15576a0.m1456n(func9);
    }
}
