package p640rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import p640rx.Observable;
import p640rx.Producer;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.functions.Func1;
import p640rx.internal.producers.SingleProducer;
import p640rx.internal.schedulers.EventLoopsScheduler;
import p640rx.observers.Subscribers;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.util.k */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class ScalarSynchronousObservable<T> extends Observable<T> {

    /* renamed from: c */
    static final boolean f46513c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: b */
    final T f46514b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: rx.internal.util.k$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16049a implements Func1<Action0, Subscription> {

        /* renamed from: a */
        final /* synthetic */ EventLoopsScheduler f46515a;

        C16049a(EventLoopsScheduler eventLoopsScheduler) {
            this.f46515a = eventLoopsScheduler;
        }

        @Override // p640rx.functions.Func1
        public Subscription call(Action0 action0) {
            return this.f46515a.m951F(action0);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: rx.internal.util.k$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16050b implements Func1<Action0, Subscription> {

        /* renamed from: a */
        final /* synthetic */ Scheduler f46517a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: ScalarSynchronousObservable.java */
        /* renamed from: rx.internal.util.k$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C16051a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ Action0 f46519a;

            /* renamed from: b */
            final /* synthetic */ Scheduler.AbstractC15607a f46520b;

            C16051a(Action0 action0, Scheduler.AbstractC15607a abstractC15607a) {
                this.f46519a = action0;
                this.f46520b = abstractC15607a;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                try {
                    this.f46519a.call();
                } finally {
                    this.f46520b.unsubscribe();
                }
            }
        }

        C16050b(Scheduler scheduler) {
            this.f46517a = scheduler;
        }

        @Override // p640rx.functions.Func1
        public Subscription call(Action0 action0) {
            Scheduler.AbstractC15607a mo450a = this.f46517a.mo450a();
            mo450a.mo456d(new C16051a(action0, mo450a));
            return mo450a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: rx.internal.util.k$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C16052c<R> implements Observable.InterfaceC15567a<R> {

        /* renamed from: a */
        final /* synthetic */ Func1 f46522a;

        C16052c(Func1 func1) {
            this.f46522a = func1;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super R> subscriber) {
            Observable observable = (Observable) this.f46522a.call(ScalarSynchronousObservable.this.f46514b);
            if (observable instanceof ScalarSynchronousObservable) {
                subscriber.setProducer(ScalarSynchronousObservable.m818w7(subscriber, ((ScalarSynchronousObservable) observable).f46514b));
            } else {
                observable.m1822I6(Subscribers.m631f(subscriber));
            }
        }
    }

    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: rx.internal.util.k$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16053d<T> implements Observable.InterfaceC15567a<T> {

        /* renamed from: a */
        final T f46524a;

        C16053d(T t) {
            this.f46524a = t;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            subscriber.setProducer(ScalarSynchronousObservable.m818w7(subscriber, this.f46524a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: rx.internal.util.k$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16054e<T> implements Observable.InterfaceC15567a<T> {

        /* renamed from: a */
        final T f46525a;

        /* renamed from: b */
        final Func1<Action0, Subscription> f46526b;

        C16054e(T t, Func1<Action0, Subscription> func1) {
            this.f46525a = t;
            this.f46526b = func1;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            subscriber.setProducer(new C16055f(subscriber, this.f46525a, this.f46526b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: rx.internal.util.k$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16055f<T> extends AtomicBoolean implements Producer, Action0 {
        private static final long serialVersionUID = -2466317989629281651L;

        /* renamed from: a */
        final Subscriber<? super T> f46527a;

        /* renamed from: b */
        final T f46528b;

        /* renamed from: c */
        final Func1<Action0, Subscription> f46529c;

        public C16055f(Subscriber<? super T> subscriber, T t, Func1<Action0, Subscription> func1) {
            this.f46527a = subscriber;
            this.f46528b = t;
            this.f46529c = func1;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            Subscriber<? super T> subscriber = this.f46527a;
            if (subscriber.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.f46528b;
            try {
                subscriber.onNext(obj);
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                subscriber.onCompleted();
            } catch (Throwable th) {
                C15575a.m1472g(th, subscriber, obj);
            }
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j >= 0) {
                if (j == 0 || !compareAndSet(false, true)) {
                    return;
                }
                this.f46527a.add(this.f46529c.call(this));
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.f46528b + ", " + get() + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: ScalarSynchronousObservable.java */
    /* renamed from: rx.internal.util.k$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16056g<T> implements Producer {

        /* renamed from: a */
        final Subscriber<? super T> f46530a;

        /* renamed from: b */
        final T f46531b;

        /* renamed from: c */
        boolean f46532c;

        public C16056g(Subscriber<? super T> subscriber, T t) {
            this.f46530a = subscriber;
            this.f46531b = t;
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (this.f46532c) {
                return;
            }
            if (j < 0) {
                throw new IllegalStateException("n >= required but it was " + j);
            } else if (j == 0) {
            } else {
                this.f46532c = true;
                Subscriber<? super T> subscriber = this.f46530a;
                if (subscriber.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.f46531b;
                try {
                    subscriber.onNext(obj);
                    if (subscriber.isUnsubscribed()) {
                        return;
                    }
                    subscriber.onCompleted();
                } catch (Throwable th) {
                    C15575a.m1472g(th, subscriber, obj);
                }
            }
        }
    }

    protected ScalarSynchronousObservable(T t) {
        super(RxJavaHooks.m578G(new C16053d(t)));
        this.f46514b = t;
    }

    /* renamed from: v7 */
    public static <T> ScalarSynchronousObservable<T> m819v7(T t) {
        return new ScalarSynchronousObservable<>(t);
    }

    /* renamed from: w7 */
    static <T> Producer m818w7(Subscriber<? super T> subscriber, T t) {
        if (f46513c) {
            return new SingleProducer(subscriber, t);
        }
        return new C16056g(subscriber, t);
    }

    /* renamed from: x7 */
    public T m817x7() {
        return this.f46514b;
    }

    /* renamed from: y7 */
    public <R> Observable<R> m816y7(Func1<? super T, ? extends Observable<? extends R>> func1) {
        return Observable.m1830H6(new C16052c(func1));
    }

    /* renamed from: z7 */
    public Observable<T> m815z7(Scheduler scheduler) {
        Func1 c16050b;
        if (scheduler instanceof EventLoopsScheduler) {
            c16050b = new C16049a((EventLoopsScheduler) scheduler);
        } else {
            c16050b = new C16050b(scheduler);
        }
        return Observable.m1830H6(new C16054e(this.f46514b, c16050b));
    }
}
