package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.functions.Func2;
import p640rx.observers.SerializedObserver;
import p640rx.observers.SerializedSubscriber;
import p640rx.subjects.PublishSubject;
import p640rx.subscriptions.CompositeSubscription;
import p640rx.subscriptions.RefCountSubscription;

/* renamed from: rx.internal.operators.o0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements Observable.InterfaceC15567a<R> {

    /* renamed from: a */
    final Observable<T1> f45595a;

    /* renamed from: b */
    final Observable<T2> f45596b;

    /* renamed from: c */
    final Func1<? super T1, ? extends Observable<D1>> f45597c;

    /* renamed from: d */
    final Func1<? super T2, ? extends Observable<D2>> f45598d;

    /* renamed from: e */
    final Func2<? super T1, ? super Observable<T2>, ? extends R> f45599e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeGroupJoin.java */
    /* renamed from: rx.internal.operators.o0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15807a extends HashMap<Integer, Observer<T2>> implements Subscription {
        private static final long serialVersionUID = -3035156013812425335L;

        /* renamed from: a */
        final RefCountSubscription f45600a;

        /* renamed from: b */
        final Subscriber<? super R> f45601b;

        /* renamed from: c */
        final CompositeSubscription f45602c;

        /* renamed from: d */
        int f45603d;

        /* renamed from: e */
        int f45604e;

        /* renamed from: f */
        final Map<Integer, T2> f45605f = new HashMap();

        /* renamed from: g */
        boolean f45606g;

        /* renamed from: h */
        boolean f45607h;

        /* compiled from: OnSubscribeGroupJoin.java */
        /* renamed from: rx.internal.operators.o0$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        final class C15808a extends Subscriber<D1> {

            /* renamed from: a */
            final int f45609a;

            /* renamed from: b */
            boolean f45610b = true;

            public C15808a(int i) {
                this.f45609a = i;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                Observer<T2> remove;
                if (this.f45610b) {
                    this.f45610b = false;
                    synchronized (C15807a.this) {
                        remove = C15807a.this.m1140H().remove(Integer.valueOf(this.f45609a));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    C15807a.this.f45602c.m361G(this);
                }
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15807a.this.m1142F(th);
            }

            @Override // p640rx.Observer
            public void onNext(D1 d1) {
                onCompleted();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeGroupJoin.java */
        /* renamed from: rx.internal.operators.o0$a$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15809b extends Subscriber<T1> {
            C15809b() {
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (C15807a.this) {
                    C15807a c15807a = C15807a.this;
                    c15807a.f45606g = true;
                    if (c15807a.f45607h) {
                        arrayList = new ArrayList(C15807a.this.m1140H().values());
                        C15807a.this.m1140H().clear();
                        C15807a.this.f45605f.clear();
                    } else {
                        arrayList = null;
                    }
                }
                C15807a.this.m1139a(arrayList);
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15807a.this.m1138d(th);
            }

            @Override // p640rx.Observer
            public void onNext(T1 t1) {
                int i;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject m427x7 = PublishSubject.m427x7();
                    SerializedObserver serializedObserver = new SerializedObserver(m427x7);
                    synchronized (C15807a.this) {
                        C15807a c15807a = C15807a.this;
                        i = c15807a.f45603d;
                        c15807a.f45603d = i + 1;
                        c15807a.m1140H().put(Integer.valueOf(i), serializedObserver);
                    }
                    Observable m1830H6 = Observable.m1830H6(new C15812b(m427x7, C15807a.this.f45600a));
                    C15808a c15808a = new C15808a(i);
                    C15807a.this.f45602c.m359a(c15808a);
                    OnSubscribeGroupJoin.this.f45597c.call(t1).m1822I6(c15808a);
                    R call = OnSubscribeGroupJoin.this.f45599e.call(t1, m1830H6);
                    synchronized (C15807a.this) {
                        arrayList = new ArrayList(C15807a.this.f45605f.values());
                    }
                    C15807a.this.f45601b.onNext(call);
                    for (Object obj : arrayList) {
                        serializedObserver.onNext(obj);
                    }
                } catch (Throwable th) {
                    C15575a.m1473f(th, this);
                }
            }
        }

        /* compiled from: OnSubscribeGroupJoin.java */
        /* renamed from: rx.internal.operators.o0$a$c */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        final class C15810c extends Subscriber<D2> {

            /* renamed from: a */
            final int f45613a;

            /* renamed from: b */
            boolean f45614b = true;

            public C15810c(int i) {
                this.f45613a = i;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                if (this.f45614b) {
                    this.f45614b = false;
                    synchronized (C15807a.this) {
                        C15807a.this.f45605f.remove(Integer.valueOf(this.f45613a));
                    }
                    C15807a.this.f45602c.m361G(this);
                }
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15807a.this.m1142F(th);
            }

            @Override // p640rx.Observer
            public void onNext(D2 d2) {
                onCompleted();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeGroupJoin.java */
        /* renamed from: rx.internal.operators.o0$a$d */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15811d extends Subscriber<T2> {
            C15811d() {
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (C15807a.this) {
                    C15807a c15807a = C15807a.this;
                    c15807a.f45607h = true;
                    if (c15807a.f45606g) {
                        arrayList = new ArrayList(C15807a.this.m1140H().values());
                        C15807a.this.m1140H().clear();
                        C15807a.this.f45605f.clear();
                    } else {
                        arrayList = null;
                    }
                }
                C15807a.this.m1139a(arrayList);
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15807a.this.m1138d(th);
            }

            @Override // p640rx.Observer
            public void onNext(T2 t2) {
                int i;
                ArrayList<Observer> arrayList;
                try {
                    synchronized (C15807a.this) {
                        C15807a c15807a = C15807a.this;
                        i = c15807a.f45604e;
                        c15807a.f45604e = i + 1;
                        c15807a.f45605f.put(Integer.valueOf(i), t2);
                    }
                    C15810c c15810c = new C15810c(i);
                    C15807a.this.f45602c.m359a(c15810c);
                    OnSubscribeGroupJoin.this.f45598d.call(t2).m1822I6(c15810c);
                    synchronized (C15807a.this) {
                        arrayList = new ArrayList(C15807a.this.m1140H().values());
                    }
                    for (Observer observer : arrayList) {
                        observer.onNext(t2);
                    }
                } catch (Throwable th) {
                    C15575a.m1473f(th, this);
                }
            }
        }

        public C15807a(Subscriber<? super R> subscriber) {
            this.f45601b = subscriber;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.f45602c = compositeSubscription;
            this.f45600a = new RefCountSubscription(compositeSubscription);
        }

        /* renamed from: F */
        void m1142F(Throwable th) {
            synchronized (this) {
                m1140H().clear();
                this.f45605f.clear();
            }
            this.f45601b.onError(th);
            this.f45600a.unsubscribe();
        }

        /* renamed from: G */
        public void m1141G() {
            C15809b c15809b = new C15809b();
            C15811d c15811d = new C15811d();
            this.f45602c.m359a(c15809b);
            this.f45602c.m359a(c15811d);
            OnSubscribeGroupJoin.this.f45595a.m1822I6(c15809b);
            OnSubscribeGroupJoin.this.f45596b.m1822I6(c15811d);
        }

        /* renamed from: H */
        Map<Integer, Observer<T2>> m1140H() {
            return this;
        }

        /* renamed from: a */
        void m1139a(List<Observer<T2>> list) {
            if (list != null) {
                for (Observer<T2> observer : list) {
                    observer.onCompleted();
                }
                this.f45601b.onCompleted();
                this.f45600a.unsubscribe();
            }
        }

        /* renamed from: d */
        void m1138d(Throwable th) {
            ArrayList<Observer> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(m1140H().values());
                m1140H().clear();
                this.f45605f.clear();
            }
            for (Observer observer : arrayList) {
                observer.onError(th);
            }
            this.f45601b.onError(th);
            this.f45600a.unsubscribe();
        }

        @Override // p640rx.Subscription
        public boolean isUnsubscribed() {
            return this.f45600a.isUnsubscribed();
        }

        @Override // p640rx.Subscription
        public void unsubscribe() {
            this.f45600a.unsubscribe();
        }
    }

    /* compiled from: OnSubscribeGroupJoin.java */
    /* renamed from: rx.internal.operators.o0$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15812b<T> implements Observable.InterfaceC15567a<T> {

        /* renamed from: a */
        final RefCountSubscription f45617a;

        /* renamed from: b */
        final Observable<T> f45618b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeGroupJoin.java */
        /* renamed from: rx.internal.operators.o0$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15813a extends Subscriber<T> {

            /* renamed from: a */
            final Subscriber<? super T> f45619a;

            /* renamed from: b */
            private final Subscription f45620b;

            public C15813a(Subscriber<? super T> subscriber, Subscription subscription) {
                super(subscriber);
                this.f45619a = subscriber;
                this.f45620b = subscription;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                this.f45619a.onCompleted();
                this.f45620b.unsubscribe();
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                this.f45619a.onError(th);
                this.f45620b.unsubscribe();
            }

            @Override // p640rx.Observer
            public void onNext(T t) {
                this.f45619a.onNext(t);
            }
        }

        public C15812b(Observable<T> observable, RefCountSubscription refCountSubscription) {
            this.f45617a = refCountSubscription;
            this.f45618b = observable;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super T> subscriber) {
            Subscription m354a = this.f45617a.m354a();
            C15813a c15813a = new C15813a(subscriber, m354a);
            c15813a.add(m354a);
            this.f45618b.m1822I6(c15813a);
        }
    }

    public OnSubscribeGroupJoin(Observable<T1> observable, Observable<T2> observable2, Func1<? super T1, ? extends Observable<D1>> func1, Func1<? super T2, ? extends Observable<D2>> func12, Func2<? super T1, ? super Observable<T2>, ? extends R> func2) {
        this.f45595a = observable;
        this.f45596b = observable2;
        this.f45597c = func1;
        this.f45598d = func12;
        this.f45599e = func2;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super R> subscriber) {
        C15807a c15807a = new C15807a(new SerializedSubscriber(subscriber));
        subscriber.add(c15807a);
        c15807a.m1141G();
    }
}
