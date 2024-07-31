package p640rx.internal.operators;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.internal.util.atomic.SpscLinkedArrayQueue;
import p640rx.subjects.Subject;
import p640rx.subjects.UnicastSubject;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.a4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorWindowWithSize<T> implements Observable.InterfaceC15568b<Observable<T>, T> {

    /* renamed from: a */
    final int f44908a;

    /* renamed from: b */
    final int f44909b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithSize.java */
    /* renamed from: rx.internal.operators.a4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15649a<T> extends Subscriber<T> implements Action0 {

        /* renamed from: a */
        final Subscriber<? super Observable<T>> f44910a;

        /* renamed from: b */
        final int f44911b;

        /* renamed from: c */
        final AtomicInteger f44912c = new AtomicInteger(1);

        /* renamed from: d */
        final Subscription f44913d;

        /* renamed from: e */
        int f44914e;

        /* renamed from: f */
        Subject<T, T> f44915f;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorWindowWithSize.java */
        /* renamed from: rx.internal.operators.a4$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15650a implements Producer {
            C15650a() {
            }

            @Override // p640rx.Producer
            public void request(long j) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                } else if (j != 0) {
                    C15649a.this.request(BackpressureUtils.m1334c(C15649a.this.f44911b, j));
                }
            }
        }

        public C15649a(Subscriber<? super Observable<T>> subscriber, int i) {
            this.f44910a = subscriber;
            this.f44911b = i;
            Subscription m346a = Subscriptions.m346a(this);
            this.f44913d = m346a;
            add(m346a);
            request(0L);
        }

        /* renamed from: G */
        Producer m1315G() {
            return new C15650a();
        }

        @Override // p640rx.functions.Action0
        public void call() {
            if (this.f44912c.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            Subject<T, T> subject = this.f44915f;
            if (subject != null) {
                this.f44915f = null;
                subject.onCompleted();
            }
            this.f44910a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            Subject<T, T> subject = this.f44915f;
            if (subject != null) {
                this.f44915f = null;
                subject.onError(th);
            }
            this.f44910a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            int i = this.f44914e;
            UnicastSubject unicastSubject = this.f44915f;
            if (i == 0) {
                this.f44912c.getAndIncrement();
                unicastSubject = UnicastSubject.m368z7(this.f44911b, this);
                this.f44915f = unicastSubject;
                this.f44910a.onNext(unicastSubject);
            }
            int i2 = i + 1;
            unicastSubject.onNext(t);
            if (i2 == this.f44911b) {
                this.f44914e = 0;
                this.f44915f = null;
                unicastSubject.onCompleted();
                return;
            }
            this.f44914e = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithSize.java */
    /* renamed from: rx.internal.operators.a4$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15651b<T> extends Subscriber<T> implements Action0 {

        /* renamed from: a */
        final Subscriber<? super Observable<T>> f44917a;

        /* renamed from: b */
        final int f44918b;

        /* renamed from: c */
        final int f44919c;

        /* renamed from: e */
        final Subscription f44921e;

        /* renamed from: i */
        final Queue<Subject<T, T>> f44925i;

        /* renamed from: j */
        Throwable f44926j;

        /* renamed from: k */
        volatile boolean f44927k;

        /* renamed from: l */
        int f44928l;

        /* renamed from: m */
        int f44929m;

        /* renamed from: d */
        final AtomicInteger f44920d = new AtomicInteger(1);

        /* renamed from: f */
        final ArrayDeque<Subject<T, T>> f44922f = new ArrayDeque<>();

        /* renamed from: h */
        final AtomicInteger f44924h = new AtomicInteger();

        /* renamed from: g */
        final AtomicLong f44923g = new AtomicLong();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorWindowWithSize.java */
        /* renamed from: rx.internal.operators.a4$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15652a extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = 4625807964358024108L;

            C15652a() {
            }

            @Override // p640rx.Producer
            public void request(long j) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                } else if (j != 0) {
                    C15651b c15651b = C15651b.this;
                    if (!get() && compareAndSet(false, true)) {
                        c15651b.request(BackpressureUtils.m1336a(BackpressureUtils.m1334c(c15651b.f44919c, j - 1), c15651b.f44918b));
                    } else {
                        C15651b.this.request(BackpressureUtils.m1334c(c15651b.f44919c, j));
                    }
                    BackpressureUtils.m1335b(c15651b.f44923g, j);
                    c15651b.m1310J();
                }
            }
        }

        public C15651b(Subscriber<? super Observable<T>> subscriber, int i, int i2) {
            this.f44917a = subscriber;
            this.f44918b = i;
            this.f44919c = i2;
            Subscription m346a = Subscriptions.m346a(this);
            this.f44921e = m346a;
            add(m346a);
            request(0L);
            this.f44925i = new SpscLinkedArrayQueue((i + (i2 - 1)) / i2);
        }

        /* renamed from: H */
        boolean m1312H(boolean z, boolean z2, Subscriber<? super Subject<T, T>> subscriber, Queue<Subject<T, T>> queue) {
            if (subscriber.isUnsubscribed()) {
                queue.clear();
                return true;
            } else if (z) {
                Throwable th = this.f44926j;
                if (th != null) {
                    queue.clear();
                    subscriber.onError(th);
                    return true;
                } else if (z2) {
                    subscriber.onCompleted();
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        /* renamed from: I */
        Producer m1311I() {
            return new C15652a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: J */
        void m1310J() {
            AtomicInteger atomicInteger = this.f44924h;
            if (atomicInteger.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super Observable<T>> subscriber = this.f44917a;
            Queue<Subject<T, T>> queue = this.f44925i;
            int i = 1;
            do {
                long j = this.f44923g.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.f44927k;
                    Subject<T, T> poll = queue.poll();
                    boolean z2 = poll == null;
                    if (m1312H(z, z2, subscriber, queue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                }
                if (j2 == j && m1312H(this.f44927k, queue.isEmpty(), subscriber, queue)) {
                    return;
                }
                if (j2 != 0 && j != Long.MAX_VALUE) {
                    this.f44923g.addAndGet(-j2);
                }
                i = atomicInteger.addAndGet(-i);
            } while (i != 0);
        }

        @Override // p640rx.functions.Action0
        public void call() {
            if (this.f44920d.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            Iterator<Subject<T, T>> it = this.f44922f.iterator();
            while (it.hasNext()) {
                it.next().onCompleted();
            }
            this.f44922f.clear();
            this.f44927k = true;
            m1310J();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            Iterator<Subject<T, T>> it = this.f44922f.iterator();
            while (it.hasNext()) {
                it.next().onError(th);
            }
            this.f44922f.clear();
            this.f44926j = th;
            this.f44927k = true;
            m1310J();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            int i = this.f44928l;
            ArrayDeque<Subject<T, T>> arrayDeque = this.f44922f;
            if (i == 0 && !this.f44917a.isUnsubscribed()) {
                this.f44920d.getAndIncrement();
                UnicastSubject m368z7 = UnicastSubject.m368z7(16, this);
                arrayDeque.offer(m368z7);
                this.f44925i.offer(m368z7);
                m1310J();
            }
            Iterator<Subject<T, T>> it = this.f44922f.iterator();
            while (it.hasNext()) {
                it.next().onNext(t);
            }
            int i2 = this.f44929m + 1;
            if (i2 == this.f44918b) {
                this.f44929m = i2 - this.f44919c;
                Subject<T, T> poll = arrayDeque.poll();
                if (poll != null) {
                    poll.onCompleted();
                }
            } else {
                this.f44929m = i2;
            }
            int i3 = i + 1;
            if (i3 == this.f44919c) {
                this.f44928l = 0;
            } else {
                this.f44928l = i3;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithSize.java */
    /* renamed from: rx.internal.operators.a4$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15653c<T> extends Subscriber<T> implements Action0 {

        /* renamed from: a */
        final Subscriber<? super Observable<T>> f44931a;

        /* renamed from: b */
        final int f44932b;

        /* renamed from: c */
        final int f44933c;

        /* renamed from: d */
        final AtomicInteger f44934d = new AtomicInteger(1);

        /* renamed from: e */
        final Subscription f44935e;

        /* renamed from: f */
        int f44936f;

        /* renamed from: g */
        Subject<T, T> f44937g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorWindowWithSize.java */
        /* renamed from: rx.internal.operators.a4$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15654a extends AtomicBoolean implements Producer {
            private static final long serialVersionUID = 4625807964358024108L;

            C15654a() {
            }

            @Override // p640rx.Producer
            public void request(long j) {
                if (j < 0) {
                    throw new IllegalArgumentException("n >= 0 required but it was " + j);
                } else if (j != 0) {
                    C15653c c15653c = C15653c.this;
                    if (!get() && compareAndSet(false, true)) {
                        c15653c.request(BackpressureUtils.m1336a(BackpressureUtils.m1334c(j, c15653c.f44932b), BackpressureUtils.m1334c(c15653c.f44933c - c15653c.f44932b, j - 1)));
                    } else {
                        c15653c.request(BackpressureUtils.m1334c(j, c15653c.f44933c));
                    }
                }
            }
        }

        public C15653c(Subscriber<? super Observable<T>> subscriber, int i, int i2) {
            this.f44931a = subscriber;
            this.f44932b = i;
            this.f44933c = i2;
            Subscription m346a = Subscriptions.m346a(this);
            this.f44935e = m346a;
            add(m346a);
            request(0L);
        }

        /* renamed from: H */
        Producer m1307H() {
            return new C15654a();
        }

        @Override // p640rx.functions.Action0
        public void call() {
            if (this.f44934d.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            Subject<T, T> subject = this.f44937g;
            if (subject != null) {
                this.f44937g = null;
                subject.onCompleted();
            }
            this.f44931a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            Subject<T, T> subject = this.f44937g;
            if (subject != null) {
                this.f44937g = null;
                subject.onError(th);
            }
            this.f44931a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            int i = this.f44936f;
            UnicastSubject unicastSubject = this.f44937g;
            if (i == 0) {
                this.f44934d.getAndIncrement();
                unicastSubject = UnicastSubject.m368z7(this.f44932b, this);
                this.f44937g = unicastSubject;
                this.f44931a.onNext(unicastSubject);
            }
            int i2 = i + 1;
            if (unicastSubject != null) {
                unicastSubject.onNext(t);
            }
            if (i2 == this.f44932b) {
                this.f44936f = i2;
                this.f44937g = null;
                unicastSubject.onCompleted();
            } else if (i2 == this.f44933c) {
                this.f44936f = 0;
            } else {
                this.f44936f = i2;
            }
        }
    }

    public OperatorWindowWithSize(int i, int i2) {
        this.f44908a = i;
        this.f44909b = i2;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        int i = this.f44909b;
        int i2 = this.f44908a;
        if (i == i2) {
            C15649a c15649a = new C15649a(subscriber, i2);
            subscriber.add(c15649a.f44913d);
            subscriber.setProducer(c15649a.m1315G());
            return c15649a;
        } else if (i > i2) {
            C15653c c15653c = new C15653c(subscriber, i2, i);
            subscriber.add(c15653c.f44935e);
            subscriber.setProducer(c15653c.m1307H());
            return c15653c;
        } else {
            C15651b c15651b = new C15651b(subscriber, i2, i);
            subscriber.add(c15651b.f44921e);
            subscriber.setProducer(c15651b.m1311I());
            return c15651b;
        }
    }
}
