package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.functions.Func2;
import p640rx.observers.SerializedSubscriber;
import p640rx.subscriptions.CompositeSubscription;
import p640rx.subscriptions.SerialSubscription;

/* renamed from: rx.internal.operators.p0 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements Observable.InterfaceC15567a<R> {

    /* renamed from: a */
    final Observable<TLeft> f45658a;

    /* renamed from: b */
    final Observable<TRight> f45659b;

    /* renamed from: c */
    final Func1<TLeft, Observable<TLeftDuration>> f45660c;

    /* renamed from: d */
    final Func1<TRight, Observable<TRightDuration>> f45661d;

    /* renamed from: e */
    final Func2<TLeft, TRight, R> f45662e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OnSubscribeJoin.java */
    /* renamed from: rx.internal.operators.p0$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15822a extends HashMap<Integer, TLeft> {
        private static final long serialVersionUID = 3491669543549085380L;

        /* renamed from: b */
        final Subscriber<? super R> f45664b;

        /* renamed from: c */
        boolean f45665c;

        /* renamed from: d */
        int f45666d;

        /* renamed from: e */
        boolean f45667e;

        /* renamed from: f */
        int f45668f;

        /* renamed from: a */
        final CompositeSubscription f45663a = new CompositeSubscription();

        /* renamed from: g */
        final Map<Integer, TRight> f45669g = new HashMap();

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeJoin.java */
        /* renamed from: rx.internal.operators.p0$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15823a extends Subscriber<TLeft> {

            /* compiled from: OnSubscribeJoin.java */
            /* renamed from: rx.internal.operators.p0$a$a$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            final class C15824a extends Subscriber<TLeftDuration> {

                /* renamed from: a */
                final int f45672a;

                /* renamed from: b */
                boolean f45673b = true;

                public C15824a(int i) {
                    this.f45672a = i;
                }

                @Override // p640rx.Observer
                public void onCompleted() {
                    if (this.f45673b) {
                        this.f45673b = false;
                        C15823a.this.m1130F(this.f45672a, this);
                    }
                }

                @Override // p640rx.Observer
                public void onError(Throwable th) {
                    C15823a.this.onError(th);
                }

                @Override // p640rx.Observer
                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            C15823a() {
            }

            /* renamed from: F */
            protected void m1130F(int i, Subscription subscription) {
                boolean z;
                synchronized (C15822a.this) {
                    z = C15822a.this.m1132a().remove(Integer.valueOf(i)) != null && C15822a.this.m1132a().isEmpty() && C15822a.this.f45665c;
                }
                if (z) {
                    C15822a.this.f45664b.onCompleted();
                    C15822a.this.f45664b.unsubscribe();
                    return;
                }
                C15822a.this.f45663a.m361G(subscription);
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                boolean z;
                synchronized (C15822a.this) {
                    C15822a c15822a = C15822a.this;
                    z = true;
                    c15822a.f45665c = true;
                    if (!c15822a.f45667e && !c15822a.m1132a().isEmpty()) {
                        z = false;
                    }
                }
                if (z) {
                    C15822a.this.f45664b.onCompleted();
                    C15822a.this.f45664b.unsubscribe();
                    return;
                }
                C15822a.this.f45663a.m361G(this);
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15822a.this.f45664b.onError(th);
                C15822a.this.f45664b.unsubscribe();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p640rx.Observer
            public void onNext(TLeft tleft) {
                int i;
                C15822a c15822a;
                int i2;
                synchronized (C15822a.this) {
                    C15822a c15822a2 = C15822a.this;
                    i = c15822a2.f45666d;
                    c15822a2.f45666d = i + 1;
                    c15822a2.m1132a().put(Integer.valueOf(i), tleft);
                    c15822a = C15822a.this;
                    i2 = c15822a.f45668f;
                }
                try {
                    C15824a c15824a = new C15824a(i);
                    C15822a.this.f45663a.m359a(c15824a);
                    OnSubscribeJoin.this.f45660c.call(tleft).m1822I6(c15824a);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (C15822a.this) {
                        for (Map.Entry<Integer, TRight> entry : C15822a.this.f45669g.entrySet()) {
                            if (entry.getKey().intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        C15822a.this.f45664b.onNext(OnSubscribeJoin.this.f45662e.call(tleft, obj));
                    }
                } catch (Throwable th) {
                    C15575a.m1473f(th, this);
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OnSubscribeJoin.java */
        /* renamed from: rx.internal.operators.p0$a$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public final class C15825b extends Subscriber<TRight> {

            /* compiled from: OnSubscribeJoin.java */
            /* renamed from: rx.internal.operators.p0$a$b$a */
            /* loaded from: E:\fuckcool\tsn\5406560.dex */
            final class C15826a extends Subscriber<TRightDuration> {

                /* renamed from: a */
                final int f45676a;

                /* renamed from: b */
                boolean f45677b = true;

                public C15826a(int i) {
                    this.f45676a = i;
                }

                @Override // p640rx.Observer
                public void onCompleted() {
                    if (this.f45677b) {
                        this.f45677b = false;
                        C15825b.this.m1129F(this.f45676a, this);
                    }
                }

                @Override // p640rx.Observer
                public void onError(Throwable th) {
                    C15825b.this.onError(th);
                }

                @Override // p640rx.Observer
                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            C15825b() {
            }

            /* renamed from: F */
            void m1129F(int i, Subscription subscription) {
                boolean z;
                synchronized (C15822a.this) {
                    z = C15822a.this.f45669g.remove(Integer.valueOf(i)) != null && C15822a.this.f45669g.isEmpty() && C15822a.this.f45667e;
                }
                if (z) {
                    C15822a.this.f45664b.onCompleted();
                    C15822a.this.f45664b.unsubscribe();
                    return;
                }
                C15822a.this.f45663a.m361G(subscription);
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                boolean z;
                synchronized (C15822a.this) {
                    C15822a c15822a = C15822a.this;
                    z = true;
                    c15822a.f45667e = true;
                    if (!c15822a.f45665c && !c15822a.f45669g.isEmpty()) {
                        z = false;
                    }
                }
                if (z) {
                    C15822a.this.f45664b.onCompleted();
                    C15822a.this.f45664b.unsubscribe();
                    return;
                }
                C15822a.this.f45663a.m361G(this);
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15822a.this.f45664b.onError(th);
                C15822a.this.f45664b.unsubscribe();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p640rx.Observer
            public void onNext(TRight tright) {
                int i;
                int i2;
                synchronized (C15822a.this) {
                    C15822a c15822a = C15822a.this;
                    i = c15822a.f45668f;
                    c15822a.f45668f = i + 1;
                    c15822a.f45669g.put(Integer.valueOf(i), tright);
                    i2 = C15822a.this.f45666d;
                }
                C15822a.this.f45663a.m359a(new SerialSubscription());
                try {
                    C15826a c15826a = new C15826a(i);
                    C15822a.this.f45663a.m359a(c15826a);
                    OnSubscribeJoin.this.f45661d.call(tright).m1822I6(c15826a);
                    ArrayList<Object> arrayList = new ArrayList();
                    synchronized (C15822a.this) {
                        for (Map.Entry<Integer, TLeft> entry : C15822a.this.m1132a().entrySet()) {
                            if (entry.getKey().intValue() < i2) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object obj : arrayList) {
                        C15822a.this.f45664b.onNext(OnSubscribeJoin.this.f45662e.call(obj, tright));
                    }
                } catch (Throwable th) {
                    C15575a.m1473f(th, this);
                }
            }
        }

        public C15822a(Subscriber<? super R> subscriber) {
            this.f45664b = subscriber;
        }

        /* renamed from: a */
        HashMap<Integer, TLeft> m1132a() {
            return this;
        }

        /* renamed from: c */
        public void m1131c() {
            this.f45664b.add(this.f45663a);
            C15823a c15823a = new C15823a();
            C15825b c15825b = new C15825b();
            this.f45663a.m359a(c15823a);
            this.f45663a.m359a(c15825b);
            OnSubscribeJoin.this.f45658a.m1822I6(c15823a);
            OnSubscribeJoin.this.f45659b.m1822I6(c15825b);
        }
    }

    public OnSubscribeJoin(Observable<TLeft> observable, Observable<TRight> observable2, Func1<TLeft, Observable<TLeftDuration>> func1, Func1<TRight, Observable<TRightDuration>> func12, Func2<TLeft, TRight, R> func2) {
        this.f45658a = observable;
        this.f45659b = observable2;
        this.f45660c = func1;
        this.f45661d = func12;
        this.f45662e = func2;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((Subscriber) ((Subscriber) obj));
    }

    public void call(Subscriber<? super R> subscriber) {
        new C15822a(new SerializedSubscriber(subscriber)).m1131c();
    }
}
