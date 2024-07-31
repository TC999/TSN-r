package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Subscriber;
import p640rx.observers.SerializedSubscriber;
import p640rx.subjects.UnicastSubject;

/* renamed from: rx.internal.operators.y3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorWindowWithObservable<T, U> implements Observable.InterfaceC15568b<Observable<T>, T> {

    /* renamed from: b */
    static final Object f46213b = new Object();

    /* renamed from: a */
    final Observable<U> f46214a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithObservable.java */
    /* renamed from: rx.internal.operators.y3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15976a<T, U> extends Subscriber<U> {

        /* renamed from: a */
        final C15977b<T> f46215a;

        public C15976a(C15977b<T> c15977b) {
            this.f46215a = c15977b;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f46215a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46215a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(U u) {
            this.f46215a.m984L();
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithObservable.java */
    /* renamed from: rx.internal.operators.y3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15977b<T> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super Observable<T>> f46216a;

        /* renamed from: b */
        final Object f46217b = new Object();

        /* renamed from: c */
        Observer<T> f46218c;

        /* renamed from: d */
        Observable<T> f46219d;

        /* renamed from: e */
        boolean f46220e;

        /* renamed from: f */
        List<Object> f46221f;

        public C15977b(Subscriber<? super Observable<T>> subscriber) {
            this.f46216a = new SerializedSubscriber(subscriber);
        }

        /* renamed from: F */
        void m990F() {
            Observer<T> observer = this.f46218c;
            this.f46218c = null;
            this.f46219d = null;
            if (observer != null) {
                observer.onCompleted();
            }
            this.f46216a.onCompleted();
            unsubscribe();
        }

        /* renamed from: G */
        void m989G() {
            UnicastSubject m370x7 = UnicastSubject.m370x7();
            this.f46218c = m370x7;
            this.f46219d = m370x7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: H */
        void m988H(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (obj == OperatorWindowWithObservable.f46213b) {
                    m985K();
                } else if (NotificationLite.m1046g(obj)) {
                    m986J(NotificationLite.m1049d(obj));
                    return;
                } else if (NotificationLite.m1047f(obj)) {
                    m990F();
                    return;
                } else {
                    m987I(obj);
                }
            }
        }

        /* renamed from: I */
        void m987I(T t) {
            Observer<T> observer = this.f46218c;
            if (observer != null) {
                observer.onNext(t);
            }
        }

        /* renamed from: J */
        void m986J(Throwable th) {
            Observer<T> observer = this.f46218c;
            this.f46218c = null;
            this.f46219d = null;
            if (observer != null) {
                observer.onError(th);
            }
            this.f46216a.onError(th);
            unsubscribe();
        }

        /* renamed from: K */
        void m985K() {
            Observer<T> observer = this.f46218c;
            if (observer != null) {
                observer.onCompleted();
            }
            m989G();
            this.f46216a.onNext(this.f46219d);
        }

        /* renamed from: L */
        void m984L() {
            synchronized (this.f46217b) {
                if (this.f46220e) {
                    if (this.f46221f == null) {
                        this.f46221f = new ArrayList();
                    }
                    this.f46221f.add(OperatorWindowWithObservable.f46213b);
                    return;
                }
                List<Object> list = this.f46221f;
                this.f46221f = null;
                boolean z = true;
                this.f46220e = true;
                boolean z2 = true;
                while (true) {
                    try {
                        m988H(list);
                        if (z2) {
                            m985K();
                            z2 = false;
                        }
                        try {
                            synchronized (this.f46217b) {
                                try {
                                    List<Object> list2 = this.f46221f;
                                    this.f46221f = null;
                                    if (list2 == null) {
                                        this.f46220e = false;
                                        return;
                                    } else if (this.f46216a.isUnsubscribed()) {
                                        synchronized (this.f46217b) {
                                            this.f46220e = false;
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
                                            synchronized (this.f46217b) {
                                                this.f46220e = false;
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
            synchronized (this.f46217b) {
                if (this.f46220e) {
                    if (this.f46221f == null) {
                        this.f46221f = new ArrayList();
                    }
                    this.f46221f.add(NotificationLite.m1051b());
                    return;
                }
                List<Object> list = this.f46221f;
                this.f46221f = null;
                this.f46220e = true;
                try {
                    m988H(list);
                    m990F();
                } catch (Throwable th) {
                    m986J(th);
                }
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            synchronized (this.f46217b) {
                if (this.f46220e) {
                    this.f46221f = Collections.singletonList(NotificationLite.m1050c(th));
                    return;
                }
                this.f46221f = null;
                this.f46220e = true;
                m986J(th);
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            synchronized (this.f46217b) {
                if (this.f46220e) {
                    if (this.f46221f == null) {
                        this.f46221f = new ArrayList();
                    }
                    this.f46221f.add(t);
                    return;
                }
                List<Object> list = this.f46221f;
                this.f46221f = null;
                boolean z = true;
                this.f46220e = true;
                boolean z2 = true;
                while (true) {
                    try {
                        m988H(list);
                        if (z2) {
                            m987I(t);
                            z2 = false;
                        }
                        try {
                            synchronized (this.f46217b) {
                                try {
                                    List<Object> list2 = this.f46221f;
                                    this.f46221f = null;
                                    if (list2 == null) {
                                        this.f46220e = false;
                                        return;
                                    } else if (this.f46216a.isUnsubscribed()) {
                                        synchronized (this.f46217b) {
                                            this.f46220e = false;
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
                                            synchronized (this.f46217b) {
                                                this.f46220e = false;
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

    public OperatorWindowWithObservable(Observable<U> observable) {
        this.f46214a = observable;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        C15977b c15977b = new C15977b(subscriber);
        C15976a c15976a = new C15976a(c15977b);
        subscriber.add(c15977b);
        subscriber.add(c15976a);
        c15977b.m984L();
        this.f46214a.m1822I6(c15976a);
        return c15977b;
    }
}
