package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Func1;
import p640rx.internal.producers.ProducerArbiter;
import p640rx.internal.util.RxRingBuffer;
import p640rx.internal.util.UtilityFunctions;
import p640rx.observables.GroupedObservable;
import p640rx.observers.Subscribers;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.g2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorGroupBy<T, K, V> implements Observable.InterfaceC15568b<GroupedObservable<K, V>, T> {

    /* renamed from: a */
    final Func1<? super T, ? extends K> f45197a;

    /* renamed from: b */
    final Func1<? super T, ? extends V> f45198b;

    /* renamed from: c */
    final int f45199c;

    /* renamed from: d */
    final boolean f45200d;

    /* renamed from: e */
    final Func1<Action1<K>, Map<K, Object>> f45201e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorGroupBy.java */
    /* renamed from: rx.internal.operators.g2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15722a implements Action0 {

        /* renamed from: a */
        final /* synthetic */ C15724c f45202a;

        C15722a(C15724c c15724c) {
            this.f45202a = c15724c;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            this.f45202a.m1253F();
        }
    }

    /* compiled from: OperatorGroupBy.java */
    /* renamed from: rx.internal.operators.g2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15723b implements Producer {

        /* renamed from: a */
        final C15724c<?, ?, ?> f45204a;

        public C15723b(C15724c<?, ?, ?> c15724c) {
            this.f45204a = c15724c;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            this.f45204a.m1247L(j);
        }
    }

    /* compiled from: OperatorGroupBy.java */
    /* renamed from: rx.internal.operators.g2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15724c<T, K, V> extends Subscriber<T> {

        /* renamed from: q */
        static final Object f45205q = new Object();

        /* renamed from: a */
        final Subscriber<? super GroupedObservable<K, V>> f45206a;

        /* renamed from: b */
        final Func1<? super T, ? extends K> f45207b;

        /* renamed from: c */
        final Func1<? super T, ? extends V> f45208c;

        /* renamed from: d */
        final int f45209d;

        /* renamed from: e */
        final boolean f45210e;

        /* renamed from: f */
        final Map<Object, C15726d<K, V>> f45211f;

        /* renamed from: g */
        final Queue<GroupedObservable<K, V>> f45212g = new ConcurrentLinkedQueue();

        /* renamed from: h */
        final C15723b f45213h;

        /* renamed from: i */
        final Queue<K> f45214i;

        /* renamed from: j */
        final ProducerArbiter f45215j;

        /* renamed from: k */
        final AtomicBoolean f45216k;

        /* renamed from: l */
        final AtomicLong f45217l;

        /* renamed from: m */
        final AtomicInteger f45218m;

        /* renamed from: n */
        Throwable f45219n;

        /* renamed from: o */
        volatile boolean f45220o;

        /* renamed from: p */
        final AtomicInteger f45221p;

        /* compiled from: OperatorGroupBy.java */
        /* renamed from: rx.internal.operators.g2$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        static class C15725a<K> implements Action1<K> {

            /* renamed from: a */
            final Queue<K> f45222a;

            C15725a(Queue<K> queue) {
                this.f45222a = queue;
            }

            @Override // p640rx.functions.Action1
            public void call(K k) {
                this.f45222a.offer(k);
            }
        }

        public C15724c(Subscriber<? super GroupedObservable<K, V>> subscriber, Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, int i, boolean z, Func1<Action1<K>, Map<K, Object>> func13) {
            this.f45206a = subscriber;
            this.f45207b = func1;
            this.f45208c = func12;
            this.f45209d = i;
            this.f45210e = z;
            ProducerArbiter producerArbiter = new ProducerArbiter();
            this.f45215j = producerArbiter;
            producerArbiter.request(i);
            this.f45213h = new C15723b(this);
            this.f45216k = new AtomicBoolean();
            this.f45217l = new AtomicLong();
            this.f45218m = new AtomicInteger(1);
            this.f45221p = new AtomicInteger();
            if (func13 == null) {
                this.f45211f = new ConcurrentHashMap();
                this.f45214i = null;
                return;
            }
            ConcurrentLinkedQueue concurrentLinkedQueue = new ConcurrentLinkedQueue();
            this.f45214i = concurrentLinkedQueue;
            this.f45211f = m1250I(func13, new C15725a(concurrentLinkedQueue));
        }

        /* renamed from: I */
        private Map<Object, C15726d<K, V>> m1250I(Func1<Action1<K>, Map<K, Object>> func1, Action1<K> action1) {
            return func1.call(action1);
        }

        /* renamed from: F */
        public void m1253F() {
            if (this.f45216k.compareAndSet(false, true) && this.f45218m.decrementAndGet() == 0) {
                unsubscribe();
            }
        }

        /* renamed from: G */
        public void m1252G(K k) {
            if (k == null) {
                k = (K) f45205q;
            }
            if (this.f45211f.remove(k) == null || this.f45218m.decrementAndGet() != 0) {
                return;
            }
            unsubscribe();
        }

        /* renamed from: H */
        boolean m1251H(boolean z, boolean z2, Subscriber<? super GroupedObservable<K, V>> subscriber, Queue<?> queue) {
            if (z) {
                Throwable th = this.f45219n;
                if (th != null) {
                    m1248K(subscriber, queue, th);
                    return true;
                } else if (z2) {
                    this.f45206a.onCompleted();
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }

        /* renamed from: J */
        void m1249J() {
            if (this.f45221p.getAndIncrement() != 0) {
                return;
            }
            Queue<GroupedObservable<K, V>> queue = this.f45212g;
            Subscriber<? super GroupedObservable<K, V>> subscriber = this.f45206a;
            int i = 1;
            while (!m1251H(this.f45220o, queue.isEmpty(), subscriber, queue)) {
                long j = this.f45217l.get();
                long j2 = 0;
                while (j2 != j) {
                    boolean z = this.f45220o;
                    GroupedObservable<K, V> poll = queue.poll();
                    boolean z2 = poll == null;
                    if (m1251H(z, z2, subscriber, queue)) {
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    subscriber.onNext(poll);
                    j2++;
                }
                if (j2 != 0) {
                    if (j != Long.MAX_VALUE) {
                        BackpressureUtils.m1328i(this.f45217l, j2);
                    }
                    this.f45215j.request(j2);
                }
                i = this.f45221p.addAndGet(-i);
                if (i == 0) {
                    return;
                }
            }
        }

        /* renamed from: K */
        void m1248K(Subscriber<? super GroupedObservable<K, V>> subscriber, Queue<?> queue, Throwable th) {
            queue.clear();
            ArrayList<C15726d> arrayList = new ArrayList(this.f45211f.values());
            this.f45211f.clear();
            Queue<K> queue2 = this.f45214i;
            if (queue2 != null) {
                queue2.clear();
            }
            for (C15726d c15726d : arrayList) {
                c15726d.onError(th);
            }
            subscriber.onError(th);
        }

        /* renamed from: L */
        public void m1247L(long j) {
            if (j >= 0) {
                BackpressureUtils.m1335b(this.f45217l, j);
                m1249J();
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45220o) {
                return;
            }
            for (C15726d<K, V> c15726d : this.f45211f.values()) {
                c15726d.m1245z7();
            }
            this.f45211f.clear();
            Queue<K> queue = this.f45214i;
            if (queue != null) {
                queue.clear();
            }
            this.f45220o = true;
            this.f45218m.decrementAndGet();
            m1249J();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45220o) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f45219n = th;
            this.f45220o = true;
            this.f45218m.decrementAndGet();
            m1249J();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45220o) {
                return;
            }
            Queue<?> queue = this.f45212g;
            Subscriber<? super GroupedObservable<K, V>> subscriber = this.f45206a;
            try {
                K call = this.f45207b.call(t);
                boolean z = false;
                Object obj = call != null ? call : f45205q;
                C15726d c15726d = this.f45211f.get(obj);
                if (c15726d == null) {
                    if (this.f45216k.get()) {
                        return;
                    }
                    c15726d = C15726d.m1246y7(call, this.f45209d, this, this.f45210e);
                    this.f45211f.put(obj, c15726d);
                    this.f45218m.getAndIncrement();
                    z = true;
                }
                try {
                    c15726d.onNext(this.f45208c.call(t));
                    if (this.f45214i != null) {
                        while (true) {
                            K poll = this.f45214i.poll();
                            if (poll == null) {
                                break;
                            }
                            C15726d<K, V> c15726d2 = this.f45211f.get(poll);
                            if (c15726d2 != null) {
                                c15726d2.m1245z7();
                            }
                        }
                    }
                    if (z) {
                        queue.offer(c15726d);
                        m1249J();
                    }
                } catch (Throwable th) {
                    unsubscribe();
                    m1248K(subscriber, queue, th);
                }
            } catch (Throwable th2) {
                unsubscribe();
                m1248K(subscriber, queue, th2);
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45215j.m960c(producer);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorGroupBy.java */
    /* renamed from: rx.internal.operators.g2$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15726d<K, T> extends GroupedObservable<K, T> {

        /* renamed from: c */
        final C15727e<T, K> f45223c;

        protected C15726d(K k, C15727e<T, K> c15727e) {
            super(k, c15727e);
            this.f45223c = c15727e;
        }

        /* renamed from: y7 */
        public static <T, K> C15726d<K, T> m1246y7(K k, int i, C15724c<?, K, T> c15724c, boolean z) {
            return new C15726d<>(k, new C15727e(i, c15724c, k, z));
        }

        public void onError(Throwable th) {
            this.f45223c.m1244F(th);
        }

        public void onNext(T t) {
            this.f45223c.m1243G(t);
        }

        /* renamed from: z7 */
        public void m1245z7() {
            this.f45223c.m1240d();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorGroupBy.java */
    /* renamed from: rx.internal.operators.g2$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15727e<T, K> extends AtomicInteger implements Producer, Subscription, Observable.InterfaceC15567a<T> {
        private static final long serialVersionUID = -3852313036005250360L;

        /* renamed from: a */
        final K f45224a;

        /* renamed from: c */
        final C15724c<?, K, T> f45226c;

        /* renamed from: d */
        final boolean f45227d;

        /* renamed from: f */
        volatile boolean f45229f;

        /* renamed from: g */
        Throwable f45230g;

        /* renamed from: b */
        final Queue<Object> f45225b = new ConcurrentLinkedQueue();

        /* renamed from: h */
        final AtomicBoolean f45231h = new AtomicBoolean();

        /* renamed from: i */
        final AtomicReference<Subscriber<? super T>> f45232i = new AtomicReference<>();

        /* renamed from: j */
        final AtomicBoolean f45233j = new AtomicBoolean();

        /* renamed from: e */
        final AtomicLong f45228e = new AtomicLong();

        public C15727e(int i, C15724c<?, K, T> c15724c, K k, boolean z) {
            this.f45226c = c15724c;
            this.f45224a = k;
            this.f45227d = z;
        }

        /* renamed from: F */
        public void m1244F(Throwable th) {
            this.f45230g = th;
            this.f45229f = true;
            m1241b();
        }

        /* renamed from: G */
        public void m1243G(T t) {
            if (t == null) {
                this.f45230g = new NullPointerException();
                this.f45229f = true;
            } else {
                this.f45225b.offer(NotificationLite.m1043j(t));
            }
            m1241b();
        }

        /* renamed from: a */
        boolean m1242a(boolean z, boolean z2, Subscriber<? super T> subscriber, boolean z3) {
            if (this.f45231h.get()) {
                this.f45225b.clear();
                this.f45226c.m1252G(this.f45224a);
                return true;
            } else if (z) {
                if (z3) {
                    if (z2) {
                        Throwable th = this.f45230g;
                        if (th != null) {
                            subscriber.onError(th);
                        } else {
                            subscriber.onCompleted();
                        }
                        return true;
                    }
                    return false;
                }
                Throwable th2 = this.f45230g;
                if (th2 != null) {
                    this.f45225b.clear();
                    subscriber.onError(th2);
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

        /* renamed from: b */
        void m1241b() {
            if (getAndIncrement() != 0) {
                return;
            }
            Queue<Object> queue = this.f45225b;
            boolean z = this.f45227d;
            Subscriber<? super T> subscriber = this.f45232i.get();
            int i = 1;
            while (true) {
                if (subscriber != null) {
                    if (m1242a(this.f45229f, queue.isEmpty(), subscriber, z)) {
                        return;
                    }
                    long j = this.f45228e.get();
                    long j2 = 0;
                    while (j2 != j) {
                        boolean z2 = this.f45229f;
                        Object poll = queue.poll();
                        boolean z3 = poll == null;
                        if (m1242a(z2, z3, subscriber, z)) {
                            return;
                        }
                        if (z3) {
                            break;
                        }
                        subscriber.onNext((Object) NotificationLite.m1048e(poll));
                        j2++;
                    }
                    if (j2 != 0) {
                        if (j != Long.MAX_VALUE) {
                            BackpressureUtils.m1328i(this.f45228e, j2);
                        }
                        this.f45226c.f45215j.request(j2);
                    }
                }
                i = addAndGet(-i);
                if (i == 0) {
                    return;
                }
                if (subscriber == null) {
                    subscriber = this.f45232i.get();
                }
            }
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        /* renamed from: d */
        public void m1240d() {
            this.f45229f = true;
            m1241b();
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f45231h.get();
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j < 0) {
                throw new IllegalArgumentException("n >= required but it was " + j);
            } else if (j != 0) {
                BackpressureUtils.m1335b(this.f45228e, j);
                m1241b();
            }
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (this.f45231h.compareAndSet(false, true) && getAndIncrement() == 0) {
                this.f45226c.m1252G(this.f45224a);
            }
        }

        public void call(Subscriber<? super T> subscriber) {
            if (this.f45233j.compareAndSet(false, true)) {
                subscriber.add(this);
                subscriber.setProducer(this);
                this.f45232i.lazySet(subscriber);
                m1241b();
                return;
            }
            subscriber.onError(new IllegalStateException("Only one Subscriber allowed!"));
        }
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1) {
        this(func1, UtilityFunctions.m803c(), RxRingBuffer.f46509d, false, null);
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12) {
        this(func1, func12, RxRingBuffer.f46509d, false, null);
    }

    public Subscriber<? super T> call(Subscriber<? super GroupedObservable<K, V>> subscriber) {
        try {
            C15724c c15724c = new C15724c(subscriber, this.f45197a, this.f45198b, this.f45199c, this.f45200d, this.f45201e);
            subscriber.add(Subscriptions.m346a(new C15722a(c15724c)));
            subscriber.setProducer(c15724c.f45213h);
            return c15724c;
        } catch (Throwable th) {
            C15575a.m1473f(th, subscriber);
            Subscriber<? super T> m633d = Subscribers.m633d();
            m633d.unsubscribe();
            return m633d;
        }
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, Func1<Action1<K>, Map<K, Object>> func13) {
        this(func1, func12, RxRingBuffer.f46509d, false, func13);
    }

    public OperatorGroupBy(Func1<? super T, ? extends K> func1, Func1<? super T, ? extends V> func12, int i, boolean z, Func1<Action1<K>, Map<K, Object>> func13) {
        this.f45197a = func1;
        this.f45198b = func12;
        this.f45199c = i;
        this.f45200d = z;
        this.f45201e = func13;
    }
}
