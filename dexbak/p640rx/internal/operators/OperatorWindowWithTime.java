package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.functions.Action0;
import p640rx.observers.SerializedObserver;
import p640rx.observers.SerializedSubscriber;
import p640rx.subjects.UnicastSubject;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.c4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorWindowWithTime<T> implements Observable.InterfaceC15568b<Observable<T>, T> {

    /* renamed from: f */
    static final Object f45015f = new Object();

    /* renamed from: a */
    final long f45016a;

    /* renamed from: b */
    final long f45017b;

    /* renamed from: c */
    final TimeUnit f45018c;

    /* renamed from: d */
    final Scheduler f45019d;

    /* renamed from: e */
    final int f45020e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithTime.java */
    /* renamed from: rx.internal.operators.c4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15676a<T> {

        /* renamed from: a */
        final Observer<T> f45021a;

        /* renamed from: b */
        final Observable<T> f45022b;

        /* renamed from: c */
        int f45023c;

        public C15676a(Observer<T> observer, Observable<T> observable) {
            this.f45021a = new SerializedObserver(observer);
            this.f45022b = observable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithTime.java */
    /* renamed from: rx.internal.operators.c4$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15677b extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super Observable<T>> f45024a;

        /* renamed from: b */
        final Scheduler.AbstractC15607a f45025b;

        /* renamed from: d */
        List<Object> f45027d;

        /* renamed from: e */
        boolean f45028e;

        /* renamed from: c */
        final Object f45026c = new Object();

        /* renamed from: f */
        volatile C15683d<T> f45029f = C15683d.m1283c();

        /* compiled from: OperatorWindowWithTime.java */
        /* renamed from: rx.internal.operators.c4$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15678a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ OperatorWindowWithTime f45031a;

            C15678a(OperatorWindowWithTime operatorWindowWithTime) {
                this.f45031a = operatorWindowWithTime;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                if (C15677b.this.f45029f.f45044a == null) {
                    C15677b.this.unsubscribe();
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorWindowWithTime.java */
        /* renamed from: rx.internal.operators.c4$b$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15679b implements Action0 {
            C15679b() {
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15677b.this.m1292J();
            }
        }

        public C15677b(Subscriber<? super Observable<T>> subscriber, Scheduler.AbstractC15607a abstractC15607a) {
            this.f45024a = new SerializedSubscriber(subscriber);
            this.f45025b = abstractC15607a;
            subscriber.add(Subscriptions.m346a(new C15678a(OperatorWindowWithTime.this)));
        }

        /* renamed from: F */
        void m1296F() {
            Observer<T> observer = this.f45029f.f45044a;
            this.f45029f = this.f45029f.m1285a();
            if (observer != null) {
                observer.onCompleted();
            }
            this.f45024a.onCompleted();
            unsubscribe();
        }

        /* JADX WARN: Code restructure failed: missing block: B:22:0x003d, code lost:
            return true;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: G */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean m1295G(java.util.List<java.lang.Object> r5) {
            /*
                r4 = this;
                r0 = 1
                if (r5 != 0) goto L4
                return r0
            L4:
                java.util.Iterator r5 = r5.iterator()
            L8:
                boolean r1 = r5.hasNext()
                if (r1 == 0) goto L3d
                java.lang.Object r1 = r5.next()
                java.lang.Object r2 = p640rx.internal.operators.OperatorWindowWithTime.f45015f
                r3 = 0
                if (r1 != r2) goto L1e
                boolean r1 = r4.m1291K()
                if (r1 != 0) goto L8
                return r3
            L1e:
                boolean r2 = p640rx.internal.operators.NotificationLite.m1046g(r1)
                if (r2 == 0) goto L2c
                java.lang.Throwable r5 = p640rx.internal.operators.NotificationLite.m1049d(r1)
                r4.m1293I(r5)
                goto L3d
            L2c:
                boolean r2 = p640rx.internal.operators.NotificationLite.m1047f(r1)
                if (r2 == 0) goto L36
                r4.m1296F()
                goto L3d
            L36:
                boolean r1 = r4.m1294H(r1)
                if (r1 != 0) goto L8
                return r3
            L3d:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: p640rx.internal.operators.OperatorWindowWithTime.C15677b.m1295G(java.util.List):boolean");
        }

        /* renamed from: H */
        boolean m1294H(T t) {
            C15683d<T> m1282d;
            C15683d<T> c15683d = this.f45029f;
            if (c15683d.f45044a == null) {
                if (!m1291K()) {
                    return false;
                }
                c15683d = this.f45029f;
            }
            c15683d.f45044a.onNext(t);
            if (c15683d.f45046c == OperatorWindowWithTime.this.f45020e - 1) {
                c15683d.f45044a.onCompleted();
                m1282d = c15683d.m1285a();
            } else {
                m1282d = c15683d.m1282d();
            }
            this.f45029f = m1282d;
            return true;
        }

        /* renamed from: I */
        void m1293I(Throwable th) {
            Observer<T> observer = this.f45029f.f45044a;
            this.f45029f = this.f45029f.m1285a();
            if (observer != null) {
                observer.onError(th);
            }
            this.f45024a.onError(th);
            unsubscribe();
        }

        /* renamed from: J */
        void m1292J() {
            boolean z;
            List<Object> list;
            synchronized (this.f45026c) {
                if (this.f45028e) {
                    if (this.f45027d == null) {
                        this.f45027d = new ArrayList();
                    }
                    this.f45027d.add(OperatorWindowWithTime.f45015f);
                    return;
                }
                boolean z2 = true;
                this.f45028e = true;
                try {
                    if (!m1291K()) {
                        synchronized (this.f45026c) {
                            this.f45028e = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.f45026c) {
                                try {
                                    list = this.f45027d;
                                    if (list == null) {
                                        this.f45028e = false;
                                        return;
                                    }
                                    this.f45027d = null;
                                } catch (Throwable th) {
                                    th = th;
                                    z2 = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        z = z2;
                                        th = th2;
                                        if (!z) {
                                            synchronized (this.f45026c) {
                                                this.f45028e = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } while (m1295G(list));
                    synchronized (this.f45026c) {
                        this.f45028e = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                }
            }
        }

        /* renamed from: K */
        boolean m1291K() {
            Observer<T> observer = this.f45029f.f45044a;
            if (observer != null) {
                observer.onCompleted();
            }
            if (this.f45024a.isUnsubscribed()) {
                this.f45029f = this.f45029f.m1285a();
                unsubscribe();
                return false;
            }
            UnicastSubject m370x7 = UnicastSubject.m370x7();
            this.f45029f = this.f45029f.m1284b(m370x7, m370x7);
            this.f45024a.onNext(m370x7);
            return true;
        }

        /* renamed from: L */
        void m1290L() {
            Scheduler.AbstractC15607a abstractC15607a = this.f45025b;
            C15679b c15679b = new C15679b();
            OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
            abstractC15607a.mo459G(c15679b, 0L, operatorWindowWithTime.f45016a, operatorWindowWithTime.f45018c);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            synchronized (this.f45026c) {
                if (this.f45028e) {
                    if (this.f45027d == null) {
                        this.f45027d = new ArrayList();
                    }
                    this.f45027d.add(NotificationLite.m1051b());
                    return;
                }
                List<Object> list = this.f45027d;
                this.f45027d = null;
                this.f45028e = true;
                try {
                    m1295G(list);
                    m1296F();
                } catch (Throwable th) {
                    m1293I(th);
                }
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            synchronized (this.f45026c) {
                if (this.f45028e) {
                    this.f45027d = Collections.singletonList(NotificationLite.m1050c(th));
                    return;
                }
                this.f45027d = null;
                this.f45028e = true;
                m1293I(th);
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            List<Object> list;
            synchronized (this.f45026c) {
                if (this.f45028e) {
                    if (this.f45027d == null) {
                        this.f45027d = new ArrayList();
                    }
                    this.f45027d.add(t);
                    return;
                }
                boolean z = true;
                this.f45028e = true;
                try {
                    if (!m1294H(t)) {
                        synchronized (this.f45026c) {
                            this.f45028e = false;
                        }
                        return;
                    }
                    do {
                        try {
                            synchronized (this.f45026c) {
                                try {
                                    list = this.f45027d;
                                    if (list == null) {
                                        this.f45028e = false;
                                        return;
                                    }
                                    this.f45027d = null;
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (!z) {
                                            synchronized (this.f45026c) {
                                                this.f45028e = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } while (m1295G(list));
                    synchronized (this.f45026c) {
                        this.f45028e = false;
                    }
                } catch (Throwable th4) {
                    th = th4;
                    z = false;
                }
            }
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithTime.java */
    /* renamed from: rx.internal.operators.c4$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15680c extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super Observable<T>> f45034a;

        /* renamed from: b */
        final Scheduler.AbstractC15607a f45035b;

        /* renamed from: c */
        final Object f45036c;

        /* renamed from: d */
        final List<C15676a<T>> f45037d;

        /* renamed from: e */
        boolean f45038e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorWindowWithTime.java */
        /* renamed from: rx.internal.operators.c4$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15681a implements Action0 {
            C15681a() {
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15680c.this.m1287H();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorWindowWithTime.java */
        /* renamed from: rx.internal.operators.c4$c$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15682b implements Action0 {

            /* renamed from: a */
            final /* synthetic */ C15676a f45041a;

            C15682b(C15676a c15676a) {
                this.f45041a = c15676a;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15680c.this.m1286I(this.f45041a);
            }
        }

        public C15680c(Subscriber<? super Observable<T>> subscriber, Scheduler.AbstractC15607a abstractC15607a) {
            super(subscriber);
            this.f45034a = subscriber;
            this.f45035b = abstractC15607a;
            this.f45036c = new Object();
            this.f45037d = new LinkedList();
        }

        /* renamed from: F */
        C15676a<T> m1289F() {
            UnicastSubject m370x7 = UnicastSubject.m370x7();
            return new C15676a<>(m370x7, m370x7);
        }

        /* renamed from: G */
        void m1288G() {
            Scheduler.AbstractC15607a abstractC15607a = this.f45035b;
            C15681a c15681a = new C15681a();
            OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
            long j = operatorWindowWithTime.f45017b;
            abstractC15607a.mo459G(c15681a, j, j, operatorWindowWithTime.f45018c);
        }

        /* renamed from: H */
        void m1287H() {
            C15676a<T> m1289F = m1289F();
            synchronized (this.f45036c) {
                if (this.f45038e) {
                    return;
                }
                this.f45037d.add(m1289F);
                try {
                    this.f45034a.onNext(m1289F.f45022b);
                    Scheduler.AbstractC15607a abstractC15607a = this.f45035b;
                    C15682b c15682b = new C15682b(m1289F);
                    OperatorWindowWithTime operatorWindowWithTime = OperatorWindowWithTime.this;
                    abstractC15607a.mo460F(c15682b, operatorWindowWithTime.f45016a, operatorWindowWithTime.f45018c);
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        /* renamed from: I */
        void m1286I(C15676a<T> c15676a) {
            boolean z;
            synchronized (this.f45036c) {
                if (this.f45038e) {
                    return;
                }
                Iterator<C15676a<T>> it = this.f45037d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next() == c15676a) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    c15676a.f45021a.onCompleted();
                }
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            synchronized (this.f45036c) {
                if (this.f45038e) {
                    return;
                }
                this.f45038e = true;
                ArrayList<C15676a> arrayList = new ArrayList(this.f45037d);
                this.f45037d.clear();
                for (C15676a c15676a : arrayList) {
                    c15676a.f45021a.onCompleted();
                }
                this.f45034a.onCompleted();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            synchronized (this.f45036c) {
                if (this.f45038e) {
                    return;
                }
                this.f45038e = true;
                ArrayList<C15676a> arrayList = new ArrayList(this.f45037d);
                this.f45037d.clear();
                for (C15676a c15676a : arrayList) {
                    c15676a.f45021a.onError(th);
                }
                this.f45034a.onError(th);
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            synchronized (this.f45036c) {
                if (this.f45038e) {
                    return;
                }
                ArrayList<C15676a> arrayList = new ArrayList(this.f45037d);
                Iterator<C15676a<T>> it = this.f45037d.iterator();
                while (it.hasNext()) {
                    C15676a<T> next = it.next();
                    int i = next.f45023c + 1;
                    next.f45023c = i;
                    if (i == OperatorWindowWithTime.this.f45020e) {
                        it.remove();
                    }
                }
                for (C15676a c15676a : arrayList) {
                    c15676a.f45021a.onNext(t);
                    if (c15676a.f45023c == OperatorWindowWithTime.this.f45020e) {
                        c15676a.f45021a.onCompleted();
                    }
                }
            }
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithTime.java */
    /* renamed from: rx.internal.operators.c4$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15683d<T> {

        /* renamed from: d */
        static final C15683d<Object> f45043d = new C15683d<>(null, null, 0);

        /* renamed from: a */
        final Observer<T> f45044a;

        /* renamed from: b */
        final Observable<T> f45045b;

        /* renamed from: c */
        final int f45046c;

        public C15683d(Observer<T> observer, Observable<T> observable, int i) {
            this.f45044a = observer;
            this.f45045b = observable;
            this.f45046c = i;
        }

        /* renamed from: c */
        public static <T> C15683d<T> m1283c() {
            return (C15683d<T>) f45043d;
        }

        /* renamed from: a */
        public C15683d<T> m1285a() {
            return m1283c();
        }

        /* renamed from: b */
        public C15683d<T> m1284b(Observer<T> observer, Observable<T> observable) {
            return new C15683d<>(observer, observable, 0);
        }

        /* renamed from: d */
        public C15683d<T> m1282d() {
            return new C15683d<>(this.f45044a, this.f45045b, this.f45046c + 1);
        }
    }

    public OperatorWindowWithTime(long j, long j2, TimeUnit timeUnit, int i, Scheduler scheduler) {
        this.f45016a = j;
        this.f45017b = j2;
        this.f45018c = timeUnit;
        this.f45020e = i;
        this.f45019d = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        Scheduler.AbstractC15607a mo450a = this.f45019d.mo450a();
        if (this.f45016a == this.f45017b) {
            C15677b c15677b = new C15677b(subscriber, mo450a);
            c15677b.add(mo450a);
            c15677b.m1290L();
            return c15677b;
        }
        C15680c c15680c = new C15680c(subscriber, mo450a);
        c15680c.add(mo450a);
        c15680c.m1287H();
        c15680c.m1288G();
        return c15680c;
    }
}
