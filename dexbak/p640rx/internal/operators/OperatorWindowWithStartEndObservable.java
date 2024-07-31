package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p640rx.Observable;
import p640rx.Observer;
import p640rx.Subscriber;
import p640rx.functions.Func1;
import p640rx.observers.SerializedObserver;
import p640rx.observers.SerializedSubscriber;
import p640rx.subjects.UnicastSubject;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.b4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorWindowWithStartEndObservable<T, U, V> implements Observable.InterfaceC15568b<Observable<T>, T> {

    /* renamed from: a */
    final Observable<? extends U> f44964a;

    /* renamed from: b */
    final Func1<? super U, ? extends Observable<? extends V>> f44965b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithStartEndObservable.java */
    /* renamed from: rx.internal.operators.b4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15663a extends Subscriber<U> {

        /* renamed from: a */
        final /* synthetic */ C15665c f44966a;

        C15663a(C15665c c15665c) {
            this.f44966a = c15665c;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f44966a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f44966a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(U u) {
            this.f44966a.m1302F(u);
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithStartEndObservable.java */
    /* renamed from: rx.internal.operators.b4$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15664b<T> {

        /* renamed from: a */
        final Observer<T> f44968a;

        /* renamed from: b */
        final Observable<T> f44969b;

        public C15664b(Observer<T> observer, Observable<T> observable) {
            this.f44968a = new SerializedObserver(observer);
            this.f44969b = observable;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWindowWithStartEndObservable.java */
    /* renamed from: rx.internal.operators.b4$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15665c extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super Observable<T>> f44970a;

        /* renamed from: b */
        final CompositeSubscription f44971b;

        /* renamed from: c */
        final Object f44972c = new Object();

        /* renamed from: d */
        final List<C15664b<T>> f44973d = new LinkedList();

        /* renamed from: e */
        boolean f44974e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorWindowWithStartEndObservable.java */
        /* renamed from: rx.internal.operators.b4$c$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15666a extends Subscriber<V> {

            /* renamed from: a */
            boolean f44976a = true;

            /* renamed from: b */
            final /* synthetic */ C15664b f44977b;

            C15666a(C15664b c15664b) {
                this.f44977b = c15664b;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                if (this.f44976a) {
                    this.f44976a = false;
                    C15665c.this.m1300H(this.f44977b);
                    C15665c.this.f44971b.m361G(this);
                }
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15665c.this.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(V v) {
                onCompleted();
            }
        }

        public C15665c(Subscriber<? super Observable<T>> subscriber, CompositeSubscription compositeSubscription) {
            this.f44970a = new SerializedSubscriber(subscriber);
            this.f44971b = compositeSubscription;
        }

        /* renamed from: F */
        void m1302F(U u) {
            C15664b<T> m1301G = m1301G();
            synchronized (this.f44972c) {
                if (this.f44974e) {
                    return;
                }
                this.f44973d.add(m1301G);
                this.f44970a.onNext(m1301G.f44969b);
                try {
                    Observable<? extends V> call = OperatorWindowWithStartEndObservable.this.f44965b.call(u);
                    C15666a c15666a = new C15666a(m1301G);
                    this.f44971b.m359a(c15666a);
                    call.m1822I6(c15666a);
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        /* renamed from: G */
        C15664b<T> m1301G() {
            UnicastSubject m370x7 = UnicastSubject.m370x7();
            return new C15664b<>(m370x7, m370x7);
        }

        /* renamed from: H */
        void m1300H(C15664b<T> c15664b) {
            boolean z;
            synchronized (this.f44972c) {
                if (this.f44974e) {
                    return;
                }
                Iterator<C15664b<T>> it = this.f44973d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next() == c15664b) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    c15664b.f44968a.onCompleted();
                }
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            try {
                synchronized (this.f44972c) {
                    if (this.f44974e) {
                        return;
                    }
                    this.f44974e = true;
                    ArrayList<C15664b> arrayList = new ArrayList(this.f44973d);
                    this.f44973d.clear();
                    for (C15664b c15664b : arrayList) {
                        c15664b.f44968a.onCompleted();
                    }
                    this.f44970a.onCompleted();
                }
            } finally {
                this.f44971b.unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            try {
                synchronized (this.f44972c) {
                    if (this.f44974e) {
                        return;
                    }
                    this.f44974e = true;
                    ArrayList<C15664b> arrayList = new ArrayList(this.f44973d);
                    this.f44973d.clear();
                    for (C15664b c15664b : arrayList) {
                        c15664b.f44968a.onError(th);
                    }
                    this.f44970a.onError(th);
                }
            } finally {
                this.f44971b.unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            synchronized (this.f44972c) {
                if (this.f44974e) {
                    return;
                }
                for (C15664b c15664b : new ArrayList(this.f44973d)) {
                    c15664b.f44968a.onNext(t);
                }
            }
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorWindowWithStartEndObservable(Observable<? extends U> observable, Func1<? super U, ? extends Observable<? extends V>> func1) {
        this.f44964a = observable;
        this.f44965b = func1;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        subscriber.add(compositeSubscription);
        C15665c c15665c = new C15665c(subscriber, compositeSubscription);
        C15663a c15663a = new C15663a(c15665c);
        compositeSubscription.m359a(c15665c);
        compositeSubscription.m359a(c15663a);
        this.f44964a.m1822I6(c15663a);
        return c15665c;
    }
}
