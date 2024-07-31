package p640rx.observables;

import java.util.concurrent.atomic.AtomicLong;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Action2;
import p640rx.functions.Func0;
import p640rx.functions.Func2;
import p640rx.internal.operators.BackpressureUtils;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.observables.e */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public abstract class SyncOnSubscribe<S, T> implements Observable.InterfaceC15567a<T> {

    /* compiled from: SyncOnSubscribe.java */
    /* renamed from: rx.observables.e$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16117a implements Func2<S, Observer<? super T>, S> {

        /* renamed from: a */
        final /* synthetic */ Action2 f46880a;

        C16117a(Action2 action2) {
            this.f46880a = action2;
        }

        @Override // p640rx.functions.Func2
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
            return call((C16117a) obj, (Observer) ((Observer) obj2));
        }

        public S call(S s, Observer<? super T> observer) {
            this.f46880a.call(s, observer);
            return s;
        }
    }

    /* compiled from: SyncOnSubscribe.java */
    /* renamed from: rx.observables.e$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16118b implements Func2<S, Observer<? super T>, S> {

        /* renamed from: a */
        final /* synthetic */ Action2 f46881a;

        C16118b(Action2 action2) {
            this.f46881a = action2;
        }

        @Override // p640rx.functions.Func2
        public /* bridge */ /* synthetic */ Object call(Object obj, Object obj2) {
            return call((C16118b) obj, (Observer) ((Observer) obj2));
        }

        public S call(S s, Observer<? super T> observer) {
            this.f46881a.call(s, observer);
            return s;
        }
    }

    /* compiled from: SyncOnSubscribe.java */
    /* renamed from: rx.observables.e$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16119c implements Func2<Void, Observer<? super T>, Void> {

        /* renamed from: a */
        final /* synthetic */ Action1 f46882a;

        C16119c(Action1 action1) {
            this.f46882a = action1;
        }

        @Override // p640rx.functions.Func2
        public /* bridge */ /* synthetic */ Void call(Void r1, Object obj) {
            return call(r1, (Observer) ((Observer) obj));
        }

        public Void call(Void r2, Observer<? super T> observer) {
            this.f46882a.call(observer);
            return r2;
        }
    }

    /* compiled from: SyncOnSubscribe.java */
    /* renamed from: rx.observables.e$d */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16120d implements Func2<Void, Observer<? super T>, Void> {

        /* renamed from: a */
        final /* synthetic */ Action1 f46883a;

        C16120d(Action1 action1) {
            this.f46883a = action1;
        }

        @Override // p640rx.functions.Func2
        public /* bridge */ /* synthetic */ Void call(Void r1, Object obj) {
            return call(r1, (Observer) ((Observer) obj));
        }

        public Void call(Void r1, Observer<? super T> observer) {
            this.f46883a.call(observer);
            return null;
        }
    }

    /* compiled from: SyncOnSubscribe.java */
    /* renamed from: rx.observables.e$e */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static class C16121e implements Action1<Void> {

        /* renamed from: a */
        final /* synthetic */ Action0 f46884a;

        C16121e(Action0 action0) {
            this.f46884a = action0;
        }

        @Override // p640rx.functions.Action1
        public void call(Void r1) {
            this.f46884a.call();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SyncOnSubscribe.java */
    /* renamed from: rx.observables.e$f */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C16122f<S, T> extends AtomicLong implements Producer, Subscription, Observer<T> {
        private static final long serialVersionUID = -3736864024352728072L;

        /* renamed from: a */
        private final Subscriber<? super T> f46885a;

        /* renamed from: b */
        private final SyncOnSubscribe<S, T> f46886b;

        /* renamed from: c */
        private boolean f46887c;

        /* renamed from: d */
        private boolean f46888d;

        /* renamed from: e */
        private S f46889e;

        C16122f(Subscriber<? super T> subscriber, SyncOnSubscribe<S, T> syncOnSubscribe, S s) {
            this.f46885a = subscriber;
            this.f46886b = syncOnSubscribe;
            this.f46889e = s;
        }

        /* renamed from: F */
        private void m682F() {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.f46886b;
            Subscriber<? super T> subscriber = this.f46885a;
            do {
                try {
                    this.f46887c = false;
                    m680H(syncOnSubscribe);
                } catch (Throwable th) {
                    m681G(subscriber, th);
                    return;
                }
            } while (!m678J());
        }

        /* renamed from: G */
        private void m681G(Subscriber<? super T> subscriber, Throwable th) {
            if (this.f46888d) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f46888d = true;
            subscriber.onError(th);
            unsubscribe();
        }

        /* renamed from: H */
        private void m680H(SyncOnSubscribe<S, T> syncOnSubscribe) {
            this.f46889e = syncOnSubscribe.mo675h(this.f46889e, this);
        }

        /* renamed from: I */
        private void m679I(long j) {
            SyncOnSubscribe<S, T> syncOnSubscribe = this.f46886b;
            Subscriber<? super T> subscriber = this.f46885a;
            do {
                long j2 = j;
                do {
                    try {
                        this.f46887c = false;
                        m680H(syncOnSubscribe);
                        if (m678J()) {
                            return;
                        }
                        if (this.f46887c) {
                            j2--;
                        }
                    } catch (Throwable th) {
                        m681G(subscriber, th);
                        return;
                    }
                } while (j2 != 0);
                j = addAndGet(-j);
            } while (j > 0);
            m678J();
        }

        /* renamed from: J */
        private boolean m678J() {
            if (this.f46888d || get() < -1) {
                set(-1L);
                m677d();
                return true;
            }
            return false;
        }

        /* renamed from: d */
        private void m677d() {
            try {
                this.f46886b.mo674i(this.f46889e);
            } catch (Throwable th) {
                C15575a.m1474e(th);
                RxJavaHooks.m576I(th);
            }
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return get() < 0;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (!this.f46888d) {
                this.f46888d = true;
                if (this.f46885a.isUnsubscribed()) {
                    return;
                }
                this.f46885a.onCompleted();
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (!this.f46888d) {
                this.f46888d = true;
                if (this.f46885a.isUnsubscribed()) {
                    return;
                }
                this.f46885a.onError(th);
                return;
            }
            throw new IllegalStateException("Terminal event already emitted.");
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (!this.f46887c) {
                this.f46887c = true;
                this.f46885a.onNext(t);
                return;
            }
            throw new IllegalStateException("onNext called multiple times!");
        }

        @Override // p640rx.Producer
        public void request(long j) {
            if (j <= 0 || BackpressureUtils.m1335b(this, j) != 0) {
                return;
            }
            if (j == Long.MAX_VALUE) {
                m682F();
            } else {
                m679I(j);
            }
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            long j;
            do {
                j = get();
                if (compareAndSet(0L, -1L)) {
                    m677d();
                    return;
                }
            } while (!compareAndSet(j, -2L));
        }
    }

    /* renamed from: a */
    public static <S, T> SyncOnSubscribe<S, T> m688a(Func0<? extends S> func0, Action2<? super S, ? super Observer<? super T>> action2) {
        return new C16123g(func0, new C16117a(action2));
    }

    /* renamed from: b */
    public static <S, T> SyncOnSubscribe<S, T> m687b(Func0<? extends S> func0, Action2<? super S, ? super Observer<? super T>> action2, Action1<? super S> action1) {
        return new C16123g(func0, new C16118b(action2), action1);
    }

    /* renamed from: c */
    public static <S, T> SyncOnSubscribe<S, T> m686c(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2) {
        return new C16123g(func0, func2);
    }

    /* renamed from: d */
    public static <S, T> SyncOnSubscribe<S, T> m685d(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2, Action1<? super S> action1) {
        return new C16123g(func0, func2, action1);
    }

    /* renamed from: e */
    public static <T> SyncOnSubscribe<Void, T> m684e(Action1<? super Observer<? super T>> action1) {
        return new C16123g(new C16119c(action1));
    }

    /* renamed from: f */
    public static <T> SyncOnSubscribe<Void, T> m683f(Action1<? super Observer<? super T>> action1, Action0 action0) {
        return new C16123g(new C16120d(action1), new C16121e(action0));
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    /* renamed from: g */
    protected abstract S mo676g();

    /* renamed from: h */
    protected abstract S mo675h(S s, Observer<? super T> observer);

    /* renamed from: i */
    protected void mo674i(S s) {
    }

    public final void call(Subscriber<? super T> subscriber) {
        try {
            C16122f c16122f = new C16122f(subscriber, this, mo676g());
            subscriber.add(c16122f);
            subscriber.setProducer(c16122f);
        } catch (Throwable th) {
            C15575a.m1474e(th);
            subscriber.onError(th);
        }
    }

    /* compiled from: SyncOnSubscribe.java */
    /* renamed from: rx.observables.e$g */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C16123g<S, T> extends SyncOnSubscribe<S, T> {

        /* renamed from: a */
        private final Func0<? extends S> f46890a;

        /* renamed from: b */
        private final Func2<? super S, ? super Observer<? super T>, ? extends S> f46891b;

        /* renamed from: c */
        private final Action1<? super S> f46892c;

        C16123g(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2, Action1<? super S> action1) {
            this.f46890a = func0;
            this.f46891b = func2;
            this.f46892c = action1;
        }

        @Override // p640rx.observables.SyncOnSubscribe, p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            super.call((Subscriber) ((Subscriber) obj));
        }

        @Override // p640rx.observables.SyncOnSubscribe
        /* renamed from: g */
        protected S mo676g() {
            Func0<? extends S> func0 = this.f46890a;
            if (func0 == null) {
                return null;
            }
            return func0.call();
        }

        @Override // p640rx.observables.SyncOnSubscribe
        /* renamed from: h */
        protected S mo675h(S s, Observer<? super T> observer) {
            return this.f46891b.call(s, observer);
        }

        @Override // p640rx.observables.SyncOnSubscribe
        /* renamed from: i */
        protected void mo674i(S s) {
            Action1<? super S> action1 = this.f46892c;
            if (action1 != null) {
                action1.call(s);
            }
        }

        public C16123g(Func0<? extends S> func0, Func2<? super S, ? super Observer<? super T>, ? extends S> func2) {
            this(func0, func2, null);
        }

        public C16123g(Func2<S, Observer<? super T>, S> func2, Action1<? super S> action1) {
            this(null, func2, action1);
        }

        public C16123g(Func2<S, Observer<? super T>, S> func2) {
            this(null, func2, null);
        }
    }
}
