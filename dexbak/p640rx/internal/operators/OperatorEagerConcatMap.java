package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.functions.Func1;
import p640rx.internal.util.atomic.SpscAtomicArrayQueue;
import p640rx.internal.util.unsafe.C16092z;
import p640rx.internal.util.unsafe.UnsafeAccess;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.e2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorEagerConcatMap<T, R> implements Observable.InterfaceC15568b<R, T> {

    /* renamed from: a */
    final Func1<? super T, ? extends Observable<? extends R>> f45094a;

    /* renamed from: b */
    final int f45095b;

    /* renamed from: c */
    private final int f45096c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorEagerConcatMap.java */
    /* renamed from: rx.internal.operators.e2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15695a<T> extends Subscriber<T> {

        /* renamed from: a */
        final C15697c<?, T> f45097a;

        /* renamed from: b */
        final Queue<Object> f45098b;

        /* renamed from: c */
        volatile boolean f45099c;

        /* renamed from: d */
        Throwable f45100d;

        public C15695a(C15697c<?, T> c15697c, int i) {
            Queue<Object> spscAtomicArrayQueue;
            this.f45097a = c15697c;
            if (UnsafeAccess.m759f()) {
                spscAtomicArrayQueue = new C16092z<>(i);
            } else {
                spscAtomicArrayQueue = new SpscAtomicArrayQueue<>(i);
            }
            this.f45098b = spscAtomicArrayQueue;
            request(i);
        }

        /* renamed from: F */
        void m1273F(long j) {
            request(j);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45099c = true;
            this.f45097a.m1271G();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45100d = th;
            this.f45099c = true;
            this.f45097a.m1271G();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f45098b.offer(NotificationLite.m1043j(t));
            this.f45097a.m1271G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorEagerConcatMap.java */
    /* renamed from: rx.internal.operators.e2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15696b extends AtomicLong implements Producer {
        private static final long serialVersionUID = -657299606803478389L;

        /* renamed from: a */
        final C15697c<?, ?> f45101a;

        public C15696b(C15697c<?, ?> c15697c) {
            this.f45101a = c15697c;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalStateException("n >= 0 required but it was " + j);
            } else if (j > 0) {
                BackpressureUtils.m1335b(this, j);
                this.f45101a.m1271G();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorEagerConcatMap.java */
    /* renamed from: rx.internal.operators.e2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15697c<T, R> extends Subscriber<T> {

        /* renamed from: a */
        final Func1<? super T, ? extends Observable<? extends R>> f45102a;

        /* renamed from: b */
        final int f45103b;

        /* renamed from: c */
        final Subscriber<? super R> f45104c;

        /* renamed from: e */
        volatile boolean f45106e;

        /* renamed from: f */
        Throwable f45107f;

        /* renamed from: g */
        volatile boolean f45108g;

        /* renamed from: i */
        private C15696b f45110i;

        /* renamed from: d */
        final Queue<C15695a<R>> f45105d = new LinkedList();

        /* renamed from: h */
        final AtomicInteger f45109h = new AtomicInteger();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorEagerConcatMap.java */
        /* renamed from: rx.internal.operators.e2$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15698a implements Action0 {
            C15698a() {
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15697c.this.f45108g = true;
                if (C15697c.this.f45109h.getAndIncrement() == 0) {
                    C15697c.this.m1272F();
                }
            }
        }

        public C15697c(Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2, Subscriber<? super R> subscriber) {
            this.f45102a = func1;
            this.f45103b = i;
            this.f45104c = subscriber;
            request(i2 == Integer.MAX_VALUE ? Long.MAX_VALUE : i2);
        }

        /* renamed from: F */
        void m1272F() {
            ArrayList<Subscription> arrayList;
            synchronized (this.f45105d) {
                arrayList = new ArrayList(this.f45105d);
                this.f45105d.clear();
            }
            for (Subscription subscription : arrayList) {
                subscription.unsubscribe();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:52:0x0087, code lost:
            if (r12 == 0) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:54:0x0090, code lost:
            if (r8 == Long.MAX_VALUE) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x0092, code lost:
            p640rx.internal.operators.BackpressureUtils.m1328i(r0, r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
            if (r6 != false) goto L50;
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x0097, code lost:
            r7.m1273F(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:58:0x009a, code lost:
            if (r6 == false) goto L51;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x009c, code lost:
            r4 = r17;
         */
        /* renamed from: G */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void m1271G() {
            /*
                Method dump skipped, instructions count: 198
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p640rx.internal.operators.OperatorEagerConcatMap.C15697c.m1271G():void");
        }

        /* renamed from: H */
        void m1270H() {
            this.f45110i = new C15696b(this);
            add(Subscriptions.m346a(new C15698a()));
            this.f45104c.add(this);
            this.f45104c.setProducer(this.f45110i);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45106e = true;
            m1271G();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45107f = th;
            this.f45106e = true;
            m1271G();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                Observable<? extends R> call = this.f45102a.call(t);
                if (this.f45108g) {
                    return;
                }
                C15695a<R> c15695a = new C15695a<>(this, this.f45103b);
                synchronized (this.f45105d) {
                    if (this.f45108g) {
                        return;
                    }
                    this.f45105d.add(c15695a);
                    if (this.f45108g) {
                        return;
                    }
                    call.m1822I6(c15695a);
                    m1271G();
                }
            } catch (Throwable th) {
                C15575a.m1472g(th, this.f45104c, t);
            }
        }
    }

    public OperatorEagerConcatMap(Func1<? super T, ? extends Observable<? extends R>> func1, int i, int i2) {
        this.f45094a = func1;
        this.f45095b = i;
        this.f45096c = i2;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        C15697c c15697c = new C15697c(this.f45094a, this.f45095b, this.f45096c, subscriber);
        c15697c.m1270H();
        return c15697c;
    }
}
