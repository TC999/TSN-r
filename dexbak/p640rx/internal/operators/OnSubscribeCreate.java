package p640rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Emitter;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.MissingBackpressureException;
import p640rx.functions.Action1;
import p640rx.functions.Cancellable;
import p640rx.internal.subscriptions.CancellableSubscription;
import p640rx.internal.util.RxRingBuffer;
import p640rx.internal.util.atomic.SpscUnboundedAtomicArrayQueue;
import p640rx.internal.util.unsafe.SpscUnboundedArrayQueue;
import p640rx.internal.util.unsafe.UnsafeAccess;
import p640rx.plugins.RxJavaHooks;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.a0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeCreate<T> implements Observable.InterfaceC15567a<T> {

    /* renamed from: a */
    final Action1<Emitter<T>> f44876a;

    /* renamed from: b */
    final Emitter.BackpressureMode f44877b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: rx.internal.operators.a0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static /* synthetic */ class C15637a {

        /* renamed from: a */
        static final /* synthetic */ int[] f44878a;

        static {
            int[] iArr = new int[Emitter.BackpressureMode.values().length];
            f44878a = iArr;
            try {
                iArr[Emitter.BackpressureMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f44878a[Emitter.BackpressureMode.ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f44878a[Emitter.BackpressureMode.DROP.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f44878a[Emitter.BackpressureMode.LATEST.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: rx.internal.operators.a0$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static abstract class AbstractC15638b<T> extends AtomicLong implements Emitter<T>, Producer, Subscription {
        private static final long serialVersionUID = 7326289992464377023L;

        /* renamed from: a */
        final Subscriber<? super T> f44879a;

        /* renamed from: b */
        final SerialSubscription f44880b = new SerialSubscription();

        public AbstractC15638b(Subscriber<? super T> subscriber) {
            this.f44879a = subscriber;
        }

        /* renamed from: F */
        void mo1323F() {
        }

        @Override // p640rx.Emitter
        /* renamed from: a */
        public final void mo1326a(Subscription subscription) {
            this.f44880b.m347b(subscription);
        }

        @Override // p640rx.Emitter
        /* renamed from: b */
        public final void mo1325b(Cancellable cancellable) {
            mo1326a(new CancellableSubscription(cancellable));
        }

        /* renamed from: d */
        void mo1321d() {
        }

        @Override // p640rx.Subscription
        public final boolean isUnsubscribed() {
            return this.f44880b.isUnsubscribed();
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f44879a.isUnsubscribed()) {
                return;
            }
            try {
                this.f44879a.onCompleted();
            } finally {
                this.f44880b.unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f44879a.isUnsubscribed()) {
                return;
            }
            try {
                this.f44879a.onError(th);
            } finally {
                this.f44880b.unsubscribe();
            }
        }

        @Override // p640rx.Producer
        public final void request(long j) {
            if (BackpressureUtils.m1327j(j)) {
                BackpressureUtils.m1335b(this, j);
                mo1321d();
            }
        }

        @Override // p640rx.Emitter
        public final long requested() {
            return get();
        }

        @Override // p640rx.Subscription
        public final void unsubscribe() {
            this.f44880b.unsubscribe();
            mo1323F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: rx.internal.operators.a0$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15639c<T> extends AbstractC15638b<T> {
        private static final long serialVersionUID = 2427151001689639875L;

        /* renamed from: c */
        final Queue<Object> f44881c;

        /* renamed from: d */
        Throwable f44882d;

        /* renamed from: e */
        volatile boolean f44883e;

        /* renamed from: f */
        final AtomicInteger f44884f;

        public C15639c(Subscriber<? super T> subscriber, int i) {
            super(subscriber);
            this.f44881c = UnsafeAccess.m759f() ? new SpscUnboundedArrayQueue<>(i) : new SpscUnboundedAtomicArrayQueue<>(i);
            this.f44884f = new AtomicInteger();
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15638b
        /* renamed from: F */
        void mo1323F() {
            if (this.f44884f.getAndIncrement() == 0) {
                this.f44881c.clear();
            }
        }

        /* renamed from: G */
        void m1324G() {
            if (this.f44884f.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.f44879a;
            Queue<Object> queue = this.f44881c;
            int i = 1;
            do {
                long j = get();
                long j2 = 0;
                while (j2 != j) {
                    if (subscriber.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z = this.f44883e;
                    Object poll = queue.poll();
                    boolean z2 = poll == null;
                    if (z && z2) {
                        Throwable th = this.f44882d;
                        if (th != null) {
                            super.onError(th);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    } else if (z2) {
                        break;
                    } else {
                        subscriber.onNext((Object) NotificationLite.m1048e(poll));
                        j2++;
                    }
                }
                if (j2 == j) {
                    if (subscriber.isUnsubscribed()) {
                        queue.clear();
                        return;
                    }
                    boolean z3 = this.f44883e;
                    boolean isEmpty = queue.isEmpty();
                    if (z3 && isEmpty) {
                        Throwable th2 = this.f44882d;
                        if (th2 != null) {
                            super.onError(th2);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    BackpressureUtils.m1328i(this, j2);
                }
                i = this.f44884f.addAndGet(-i);
            } while (i != 0);
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15638b
        /* renamed from: d */
        void mo1321d() {
            m1324G();
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15638b, p640rx.Observer
        public void onCompleted() {
            this.f44883e = true;
            m1324G();
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15638b, p640rx.Observer
        public void onError(Throwable th) {
            this.f44882d = th;
            this.f44883e = true;
            m1324G();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f44881c.offer(NotificationLite.m1043j(t));
            m1324G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: rx.internal.operators.a0$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15640d<T> extends AbstractC15643g<T> {
        private static final long serialVersionUID = 8360058422307496563L;

        public C15640d(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15643g
        /* renamed from: G */
        void mo1320G() {
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: rx.internal.operators.a0$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15641e<T> extends AbstractC15643g<T> {
        private static final long serialVersionUID = 338953216916120960L;

        /* renamed from: c */
        private boolean f44885c;

        public C15641e(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15643g
        /* renamed from: G */
        void mo1320G() {
            onError(new MissingBackpressureException("create: could not emit value due to lack of requests"));
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15638b, p640rx.Observer
        public void onCompleted() {
            if (this.f44885c) {
                return;
            }
            this.f44885c = true;
            super.onCompleted();
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15638b, p640rx.Observer
        public void onError(Throwable th) {
            if (this.f44885c) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f44885c = true;
            super.onError(th);
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15643g, p640rx.Observer
        public void onNext(T t) {
            if (this.f44885c) {
                return;
            }
            super.onNext(t);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: rx.internal.operators.a0$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15642f<T> extends AbstractC15638b<T> {
        private static final long serialVersionUID = 4023437720691792495L;

        /* renamed from: c */
        final AtomicReference<Object> f44886c;

        /* renamed from: d */
        Throwable f44887d;

        /* renamed from: e */
        volatile boolean f44888e;

        /* renamed from: f */
        final AtomicInteger f44889f;

        public C15642f(Subscriber<? super T> subscriber) {
            super(subscriber);
            this.f44886c = new AtomicReference<>();
            this.f44889f = new AtomicInteger();
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15638b
        /* renamed from: F */
        void mo1323F() {
            if (this.f44889f.getAndIncrement() == 0) {
                this.f44886c.lazySet(null);
            }
        }

        /* renamed from: G */
        void m1322G() {
            if (this.f44889f.getAndIncrement() != 0) {
                return;
            }
            Subscriber<? super T> subscriber = this.f44879a;
            AtomicReference<Object> atomicReference = this.f44886c;
            int i = 1;
            do {
                long j = get();
                long j2 = 0;
                while (true) {
                    if (j2 == j) {
                        break;
                    } else if (subscriber.isUnsubscribed()) {
                        atomicReference.lazySet(null);
                        return;
                    } else {
                        boolean z = this.f44888e;
                        Object andSet = atomicReference.getAndSet(null);
                        boolean z2 = andSet == null;
                        if (z && z2) {
                            Throwable th = this.f44887d;
                            if (th != null) {
                                super.onError(th);
                                return;
                            } else {
                                super.onCompleted();
                                return;
                            }
                        } else if (z2) {
                            break;
                        } else {
                            subscriber.onNext((Object) NotificationLite.m1048e(andSet));
                            j2++;
                        }
                    }
                }
                if (j2 == j) {
                    if (subscriber.isUnsubscribed()) {
                        atomicReference.lazySet(null);
                        return;
                    }
                    boolean z3 = this.f44888e;
                    boolean z4 = atomicReference.get() == null;
                    if (z3 && z4) {
                        Throwable th2 = this.f44887d;
                        if (th2 != null) {
                            super.onError(th2);
                            return;
                        } else {
                            super.onCompleted();
                            return;
                        }
                    }
                }
                if (j2 != 0) {
                    BackpressureUtils.m1328i(this, j2);
                }
                i = this.f44889f.addAndGet(-i);
            } while (i != 0);
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15638b
        /* renamed from: d */
        void mo1321d() {
            m1322G();
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15638b, p640rx.Observer
        public void onCompleted() {
            this.f44888e = true;
            m1322G();
        }

        @Override // p640rx.internal.operators.OnSubscribeCreate.AbstractC15638b, p640rx.Observer
        public void onError(Throwable th) {
            this.f44887d = th;
            this.f44888e = true;
            m1322G();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            this.f44886c.set(NotificationLite.m1043j(t));
            m1322G();
        }
    }

    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: rx.internal.operators.a0$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static abstract class AbstractC15643g<T> extends AbstractC15638b<T> {
        private static final long serialVersionUID = 4127754106204442833L;

        public AbstractC15643g(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        /* renamed from: G */
        abstract void mo1320G();

        public void onNext(T t) {
            if (this.f44879a.isUnsubscribed()) {
                return;
            }
            if (get() != 0) {
                this.f44879a.onNext(t);
                BackpressureUtils.m1328i(this, 1L);
                return;
            }
            mo1320G();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeCreate.java */
    /* renamed from: rx.internal.operators.a0$h */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15644h<T> extends AbstractC15638b<T> {
        private static final long serialVersionUID = 3776720187248809713L;

        public C15644h(Subscriber<? super T> subscriber) {
            super(subscriber);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            long j;
            if (this.f44879a.isUnsubscribed()) {
                return;
            }
            this.f44879a.onNext(t);
            do {
                j = get();
                if (j == 0) {
                    return;
                }
            } while (!compareAndSet(j, j - 1));
        }
    }

    public OnSubscribeCreate(Action1<Emitter<T>> action1, Emitter.BackpressureMode backpressureMode) {
        this.f44876a = action1;
        this.f44877b = backpressureMode;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super T> subscriber) {
        AbstractC15638b c15644h;
        int i = C15637a.f44878a[this.f44877b.ordinal()];
        if (i == 1) {
            c15644h = new C15644h(subscriber);
        } else if (i == 2) {
            c15644h = new C15641e(subscriber);
        } else if (i == 3) {
            c15644h = new C15640d(subscriber);
        } else if (i != 4) {
            c15644h = new C15639c(subscriber, RxRingBuffer.f46509d);
        } else {
            c15644h = new C15642f(subscriber);
        }
        subscriber.add(c15644h);
        subscriber.setProducer(c15644h);
        this.f44876a.call(c15644h);
    }
}
