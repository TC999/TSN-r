package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Subscriber;
import p640rx.functions.Func0;
import p640rx.observers.SerializedSubscriber;
import p640rx.subjects.UnicastSubject;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.z3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorWindowWithObservableFactory<T, U> implements Observable.InterfaceC15568b<Observable<T>, T> {

    /* renamed from: b */
    static final Object f46272b = new Object();

    /* renamed from: a */
    final Func0<? extends Observable<? extends U>> f46273a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithObservableFactory.java */
    /* renamed from: rx.internal.operators.z3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15990a<T, U> extends Subscriber<U> {

        /* renamed from: a */
        final C15991b<T, U> f46274a;

        /* renamed from: b */
        boolean f46275b;

        public C15990a(C15991b<T, U> c15991b) {
            this.f46274a = c15991b;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f46275b) {
                return;
            }
            this.f46275b = true;
            this.f46274a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46274a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(U u) {
            if (this.f46275b) {
                return;
            }
            this.f46275b = true;
            this.f46274a.m963L();
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithObservableFactory.java */
    /* renamed from: rx.internal.operators.z3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15991b<T, U> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super Observable<T>> f46276a;

        /* renamed from: b */
        final Object f46277b = new Object();

        /* renamed from: c */
        Observer<T> f46278c;

        /* renamed from: d */
        Observable<T> f46279d;

        /* renamed from: e */
        boolean f46280e;

        /* renamed from: f */
        List<Object> f46281f;

        /* renamed from: g */
        final SerialSubscription f46282g;

        /* renamed from: h */
        final Func0<? extends Observable<? extends U>> f46283h;

        public C15991b(Subscriber<? super Observable<T>> subscriber, Func0<? extends Observable<? extends U>> func0) {
            this.f46276a = new SerializedSubscriber(subscriber);
            SerialSubscription serialSubscription = new SerialSubscription();
            this.f46282g = serialSubscription;
            this.f46283h = func0;
            add(serialSubscription);
        }

        /* renamed from: F */
        void m969F() {
            Observer<T> observer = this.f46278c;
            this.f46278c = null;
            this.f46279d = null;
            if (observer != null) {
                observer.onCompleted();
            }
            this.f46276a.onCompleted();
            unsubscribe();
        }

        /* renamed from: G */
        void m968G() {
            UnicastSubject m370x7 = UnicastSubject.m370x7();
            this.f46278c = m370x7;
            this.f46279d = m370x7;
            try {
                Observable<? extends U> call = this.f46283h.call();
                C15990a c15990a = new C15990a(this);
                this.f46282g.m347b(c15990a);
                call.m1822I6(c15990a);
            } catch (Throwable th) {
                this.f46276a.onError(th);
                unsubscribe();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: H */
        void m967H(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (obj == OperatorWindowWithObservableFactory.f46272b) {
                    m964K();
                } else if (NotificationLite.m1046g(obj)) {
                    m965J(NotificationLite.m1049d(obj));
                    return;
                } else if (NotificationLite.m1047f(obj)) {
                    m969F();
                    return;
                } else {
                    m966I(obj);
                }
            }
        }

        /* renamed from: I */
        void m966I(T t) {
            Observer<T> observer = this.f46278c;
            if (observer != null) {
                observer.onNext(t);
            }
        }

        /* renamed from: J */
        void m965J(Throwable th) {
            Observer<T> observer = this.f46278c;
            this.f46278c = null;
            this.f46279d = null;
            if (observer != null) {
                observer.onError(th);
            }
            this.f46276a.onError(th);
            unsubscribe();
        }

        /* renamed from: K */
        void m964K() {
            Observer<T> observer = this.f46278c;
            if (observer != null) {
                observer.onCompleted();
            }
            m968G();
            this.f46276a.onNext(this.f46279d);
        }

        /* renamed from: L */
        void m963L() {
            synchronized (this.f46277b) {
                if (this.f46280e) {
                    if (this.f46281f == null) {
                        this.f46281f = new ArrayList();
                    }
                    this.f46281f.add(OperatorWindowWithObservableFactory.f46272b);
                    return;
                }
                List<Object> list = this.f46281f;
                this.f46281f = null;
                boolean z = true;
                this.f46280e = true;
                boolean z2 = true;
                while (true) {
                    try {
                        m967H(list);
                        if (z2) {
                            m964K();
                            z2 = false;
                        }
                        try {
                            synchronized (this.f46277b) {
                                try {
                                    List<Object> list2 = this.f46281f;
                                    this.f46281f = null;
                                    if (list2 == null) {
                                        this.f46280e = false;
                                        return;
                                    } else if (this.f46276a.isUnsubscribed()) {
                                        synchronized (this.f46277b) {
                                            this.f46280e = false;
                                        }
                                        return;
                                    } else {
                                        list = list2;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (!z) {
                                            synchronized (this.f46277b) {
                                                this.f46280e = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                }
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            synchronized (this.f46277b) {
                if (this.f46280e) {
                    if (this.f46281f == null) {
                        this.f46281f = new ArrayList();
                    }
                    this.f46281f.add(NotificationLite.m1051b());
                    return;
                }
                List<Object> list = this.f46281f;
                this.f46281f = null;
                this.f46280e = true;
                try {
                    m967H(list);
                    m969F();
                } catch (Throwable th) {
                    m965J(th);
                }
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            synchronized (this.f46277b) {
                if (this.f46280e) {
                    this.f46281f = Collections.singletonList(NotificationLite.m1050c(th));
                    return;
                }
                this.f46281f = null;
                this.f46280e = true;
                m965J(th);
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            synchronized (this.f46277b) {
                if (this.f46280e) {
                    if (this.f46281f == null) {
                        this.f46281f = new ArrayList();
                    }
                    this.f46281f.add(t);
                    return;
                }
                List<Object> list = this.f46281f;
                this.f46281f = null;
                boolean z = true;
                this.f46280e = true;
                boolean z2 = true;
                while (true) {
                    try {
                        m967H(list);
                        if (z2) {
                            m966I(t);
                            z2 = false;
                        }
                        try {
                            synchronized (this.f46277b) {
                                try {
                                    List<Object> list2 = this.f46281f;
                                    this.f46281f = null;
                                    if (list2 == null) {
                                        this.f46280e = false;
                                        return;
                                    } else if (this.f46276a.isUnsubscribed()) {
                                        synchronized (this.f46277b) {
                                            this.f46280e = false;
                                        }
                                        return;
                                    } else {
                                        list = list2;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (!z) {
                                            synchronized (this.f46277b) {
                                                this.f46280e = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z = false;
                    }
                }
            }
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorWindowWithObservableFactory(Func0<? extends Observable<? extends U>> func0) {
        this.f46273a = func0;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        C15991b c15991b = new C15991b(subscriber, this.f46273a);
        subscriber.add(c15991b);
        c15991b.m963L();
        return c15991b;
    }
}
