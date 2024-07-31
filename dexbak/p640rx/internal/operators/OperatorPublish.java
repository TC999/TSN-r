package p640rx.internal.operators;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.MissingBackpressureException;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Func1;
import p640rx.internal.util.RxRingBuffer;
import p640rx.internal.util.atomic.SpscAtomicArrayQueue;
import p640rx.internal.util.unsafe.C16092z;
import p640rx.internal.util.unsafe.UnsafeAccess;
import p640rx.observables.ConnectableObservable;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.s2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorPublish<T> extends ConnectableObservable<T> {

    /* renamed from: b */
    final Observable<? extends T> f45836b;

    /* renamed from: c */
    final AtomicReference<C15873d<T>> f45837c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorPublish.java */
    /* renamed from: rx.internal.operators.s2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15869a implements Observable.InterfaceC15567a<T> {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f45838a;

        C15869a(AtomicReference atomicReference) {
            this.f45838a = atomicReference;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            while (true) {
                C15873d c15873d = (C15873d) this.f45838a.get();
                if (c15873d == null || c15873d.isUnsubscribed()) {
                    C15873d c15873d2 = new C15873d(this.f45838a);
                    c15873d2.m1095I();
                    if (this.f45838a.compareAndSet(c15873d, c15873d2)) {
                        c15873d = c15873d2;
                    } else {
                        continue;
                    }
                }
                C15872c<T> c15872c = new C15872c<>(c15873d, subscriber);
                if (c15873d.m1098F(c15872c)) {
                    subscriber.add(c15872c);
                    subscriber.setProducer(c15872c);
                    return;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: OperatorPublish.java */
    /* renamed from: rx.internal.operators.s2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static class C15870b<R> implements Observable.InterfaceC15567a<R> {

        /* renamed from: a */
        final /* synthetic */ boolean f45839a;

        /* renamed from: b */
        final /* synthetic */ Func1 f45840b;

        /* renamed from: c */
        final /* synthetic */ Observable f45841c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorPublish.java */
        /* renamed from: rx.internal.operators.s2$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15871a extends Subscriber<R> {

            /* renamed from: a */
            final /* synthetic */ Subscriber f45842a;

            /* renamed from: b */
            final /* synthetic */ OnSubscribePublishMulticast f45843b;

            C15871a(Subscriber subscriber, OnSubscribePublishMulticast onSubscribePublishMulticast) {
                this.f45842a = subscriber;
                this.f45843b = onSubscribePublishMulticast;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                this.f45843b.unsubscribe();
                this.f45842a.onCompleted();
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                this.f45843b.unsubscribe();
                this.f45842a.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(R r) {
                this.f45842a.onNext(r);
            }

            @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
            public void setProducer(Producer producer) {
                this.f45842a.setProducer(producer);
            }
        }

        C15870b(boolean z, Func1 func1, Observable observable) {
            this.f45839a = z;
            this.f45840b = func1;
            this.f45841c = observable;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super R> subscriber) {
            OnSubscribePublishMulticast onSubscribePublishMulticast = new OnSubscribePublishMulticast(RxRingBuffer.f46509d, this.f45839a);
            C15871a c15871a = new C15871a(subscriber, onSubscribePublishMulticast);
            subscriber.add(onSubscribePublishMulticast);
            subscriber.add(c15871a);
            ((Observable) this.f45840b.call(Observable.m1830H6(onSubscribePublishMulticast))).m1822I6(c15871a);
            this.f45841c.m1822I6(onSubscribePublishMulticast.subscriber());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorPublish.java */
    /* renamed from: rx.internal.operators.s2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15872c<T> extends AtomicLong implements Producer, Subscription {

        /* renamed from: c */
        static final long f45845c = Long.MIN_VALUE;

        /* renamed from: d */
        static final long f45846d = -4611686018427387904L;
        private static final long serialVersionUID = -4453897557930727610L;

        /* renamed from: a */
        final C15873d<T> f45847a;

        /* renamed from: b */
        final Subscriber<? super T> f45848b;

        public C15872c(C15873d<T> c15873d, Subscriber<? super T> subscriber) {
            this.f45847a = c15873d;
            this.f45848b = subscriber;
            lazySet(f45846d);
        }

        /* renamed from: a */
        public long m1099a(long j) {
            long j2;
            long j3;
            if (j > 0) {
                do {
                    j2 = get();
                    if (j2 == f45846d) {
                        throw new IllegalStateException("Produced without request");
                    }
                    if (j2 == Long.MIN_VALUE) {
                        return Long.MIN_VALUE;
                    }
                    j3 = j2 - j;
                    if (j3 < 0) {
                        throw new IllegalStateException("More produced (" + j + ") than requested (" + j2 + ")");
                    }
                } while (!compareAndSet(j2, j3));
                return j3;
            }
            throw new IllegalArgumentException("Cant produce zero or less");
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return get() == Long.MIN_VALUE;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            long j2;
            long j3;
            if (j < 0) {
                return;
            }
            do {
                j2 = get();
                if (j2 == Long.MIN_VALUE) {
                    return;
                }
                if (j2 >= 0 && j == 0) {
                    return;
                }
                if (j2 == f45846d) {
                    j3 = j;
                } else {
                    j3 = j2 + j;
                    if (j3 < 0) {
                        j3 = Long.MAX_VALUE;
                    }
                }
            } while (!compareAndSet(j2, j3));
            this.f45847a.m1096H();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE) {
                return;
            }
            this.f45847a.m1094J(this);
            this.f45847a.m1096H();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorPublish.java */
    /* renamed from: rx.internal.operators.s2$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15873d<T> extends Subscriber<T> implements Subscription {

        /* renamed from: h */
        static final C15872c[] f45849h = new C15872c[0];

        /* renamed from: i */
        static final C15872c[] f45850i = new C15872c[0];

        /* renamed from: a */
        final Queue<Object> f45851a;

        /* renamed from: b */
        final AtomicReference<C15873d<T>> f45852b;

        /* renamed from: c */
        volatile Object f45853c;

        /* renamed from: d */
        final AtomicReference<C15872c[]> f45854d;

        /* renamed from: e */
        final AtomicBoolean f45855e;

        /* renamed from: f */
        boolean f45856f;

        /* renamed from: g */
        boolean f45857g;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorPublish.java */
        /* renamed from: rx.internal.operators.s2$d$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15874a implements Action0 {
            C15874a() {
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15873d.this.f45854d.getAndSet(C15873d.f45850i);
                C15873d<T> c15873d = C15873d.this;
                c15873d.f45852b.compareAndSet(c15873d, null);
            }
        }

        public C15873d(AtomicReference<C15873d<T>> atomicReference) {
            this.f45851a = UnsafeAccess.m759f() ? new C16092z<>(RxRingBuffer.f46509d) : new SpscAtomicArrayQueue<>(RxRingBuffer.f46509d);
            this.f45854d = new AtomicReference<>(f45849h);
            this.f45852b = atomicReference;
            this.f45855e = new AtomicBoolean();
        }

        /* renamed from: F */
        boolean m1098F(C15872c<T> c15872c) {
            C15872c[] c15872cArr;
            C15872c[] c15872cArr2;
            c15872c.getClass();
            do {
                c15872cArr = this.f45854d.get();
                if (c15872cArr == f45850i) {
                    return false;
                }
                int length = c15872cArr.length;
                c15872cArr2 = new C15872c[length + 1];
                System.arraycopy(c15872cArr, 0, c15872cArr2, 0, length);
                c15872cArr2[length] = c15872c;
            } while (!this.f45854d.compareAndSet(c15872cArr, c15872cArr2));
            return true;
        }

        /* renamed from: G */
        boolean m1097G(Object obj, boolean z) {
            int i = 0;
            if (obj != null) {
                if (!NotificationLite.m1047f(obj)) {
                    Throwable m1049d = NotificationLite.m1049d(obj);
                    this.f45852b.compareAndSet(this, null);
                    try {
                        C15872c[] andSet = this.f45854d.getAndSet(f45850i);
                        int length = andSet.length;
                        while (i < length) {
                            andSet[i].f45848b.onError(m1049d);
                            i++;
                        }
                        return true;
                    } finally {
                    }
                } else if (z) {
                    this.f45852b.compareAndSet(this, null);
                    try {
                        C15872c[] andSet2 = this.f45854d.getAndSet(f45850i);
                        int length2 = andSet2.length;
                        while (i < length2) {
                            andSet2[i].f45848b.onCompleted();
                            i++;
                        }
                        return true;
                    } finally {
                    }
                }
            }
            return false;
        }

        /* renamed from: H */
        void m1096H() {
            boolean z;
            long j;
            synchronized (this) {
                if (this.f45856f) {
                    this.f45857g = true;
                    return;
                }
                this.f45856f = true;
                this.f45857g = false;
                while (true) {
                    try {
                        Object obj = this.f45853c;
                        boolean isEmpty = this.f45851a.isEmpty();
                        if (m1097G(obj, isEmpty)) {
                            return;
                        }
                        if (!isEmpty) {
                            C15872c[] c15872cArr = this.f45854d.get();
                            int length = c15872cArr.length;
                            long j2 = Long.MAX_VALUE;
                            int i = 0;
                            for (C15872c c15872c : c15872cArr) {
                                long j3 = c15872c.get();
                                if (j3 >= 0) {
                                    j2 = Math.min(j2, j3);
                                } else if (j3 == Long.MIN_VALUE) {
                                    i++;
                                }
                            }
                            if (length == i) {
                                if (m1097G(this.f45853c, this.f45851a.poll() == null)) {
                                    return;
                                }
                                request(1L);
                            } else {
                                int i2 = 0;
                                while (true) {
                                    j = i2;
                                    if (j >= j2) {
                                        break;
                                    }
                                    Object obj2 = this.f45853c;
                                    Object poll = this.f45851a.poll();
                                    boolean z2 = poll == null;
                                    if (m1097G(obj2, z2)) {
                                        return;
                                    }
                                    if (z2) {
                                        isEmpty = z2;
                                        break;
                                    }
                                    Object m1048e = NotificationLite.m1048e(poll);
                                    for (C15872c c15872c2 : c15872cArr) {
                                        if (c15872c2.get() > 0) {
                                            c15872c2.f45848b.onNext(m1048e);
                                            c15872c2.m1099a(1L);
                                        }
                                    }
                                    i2++;
                                    isEmpty = z2;
                                }
                                if (i2 > 0) {
                                    request(j);
                                }
                                if (j2 != 0 && !isEmpty) {
                                }
                            }
                        }
                        synchronized (this) {
                            try {
                                if (!this.f45857g) {
                                    this.f45856f = false;
                                    try {
                                        return;
                                    } catch (Throwable th) {
                                        th = th;
                                        z = true;
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
                                this.f45857g = false;
                            } catch (Throwable th3) {
                                th = th3;
                                z = false;
                            }
                        }
                        try {
                            break;
                            throw th;
                        } catch (Throwable th4) {
                            th = th4;
                            if (!z) {
                                synchronized (this) {
                                    this.f45856f = false;
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th5) {
                        th = th5;
                        z = false;
                    }
                }
            }
        }

        /* renamed from: I */
        void m1095I() {
            add(Subscriptions.m346a(new C15874a()));
        }

        /* renamed from: J */
        void m1094J(C15872c<T> c15872c) {
            C15872c[] c15872cArr;
            C15872c[] c15872cArr2;
            do {
                c15872cArr = this.f45854d.get();
                if (c15872cArr == f45849h || c15872cArr == f45850i) {
                    return;
                }
                int i = -1;
                int length = c15872cArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (c15872cArr[i2].equals(c15872c)) {
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
                    c15872cArr2 = f45849h;
                } else {
                    C15872c[] c15872cArr3 = new C15872c[length - 1];
                    System.arraycopy(c15872cArr, 0, c15872cArr3, 0, i);
                    System.arraycopy(c15872cArr, i + 1, c15872cArr3, i, (length - i) - 1);
                    c15872cArr2 = c15872cArr3;
                }
            } while (!this.f45854d.compareAndSet(c15872cArr, c15872cArr2));
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45853c == null) {
                this.f45853c = NotificationLite.m1051b();
                m1096H();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45853c == null) {
                this.f45853c = NotificationLite.m1050c(th);
                m1096H();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (!this.f45851a.offer(NotificationLite.m1043j(t))) {
                onError(new MissingBackpressureException());
            } else {
                m1096H();
            }
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(RxRingBuffer.f46509d);
        }
    }

    private OperatorPublish(Observable.InterfaceC15567a<T> interfaceC15567a, Observable<? extends T> observable, AtomicReference<C15873d<T>> atomicReference) {
        super(interfaceC15567a);
        this.f45836b = observable;
        this.f45837c = atomicReference;
    }

    /* renamed from: B7 */
    public static <T, R> Observable<R> m1102B7(Observable<? extends T> observable, Func1<? super Observable<T>, ? extends Observable<R>> func1) {
        return m1101C7(observable, func1, false);
    }

    /* renamed from: C7 */
    public static <T, R> Observable<R> m1101C7(Observable<? extends T> observable, Func1<? super Observable<T>, ? extends Observable<R>> func1, boolean z) {
        return Observable.m1830H6(new C15870b(z, func1, observable));
    }

    /* renamed from: D7 */
    public static <T> ConnectableObservable<T> m1100D7(Observable<? extends T> observable) {
        AtomicReference atomicReference = new AtomicReference();
        return new OperatorPublish(new C15869a(atomicReference), observable, atomicReference);
    }

    @Override // p640rx.observables.ConnectableObservable
    /* renamed from: z7 */
    public void mo692z7(Action1<? super Subscription> action1) {
        C15873d<T> c15873d;
        while (true) {
            c15873d = this.f45837c.get();
            if (c15873d != null && !c15873d.isUnsubscribed()) {
                break;
            }
            C15873d<T> c15873d2 = new C15873d<>(this.f45837c);
            c15873d2.m1095I();
            if (this.f45837c.compareAndSet(c15873d, c15873d2)) {
                c15873d = c15873d2;
                break;
            }
        }
        boolean z = true;
        z = (c15873d.f45855e.get() || !c15873d.f45855e.compareAndSet(false, true)) ? false : false;
        action1.call(c15873d);
        if (z) {
            this.f45836b.m1822I6(c15873d);
        }
    }
}
