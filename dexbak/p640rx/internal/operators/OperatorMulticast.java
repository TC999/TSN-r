package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.functions.Action1;
import p640rx.functions.Func0;
import p640rx.observables.ConnectableObservable;
import p640rx.observers.Subscribers;
import p640rx.subjects.Subject;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.m2 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorMulticast<T, R> extends ConnectableObservable<R> {

    /* renamed from: b */
    final Observable<? extends T> f45528b;

    /* renamed from: c */
    final Object f45529c;

    /* renamed from: d */
    final Func0<? extends Subject<? super T, ? extends R>> f45530d;

    /* renamed from: e */
    final AtomicReference<Subject<? super T, ? extends R>> f45531e;

    /* renamed from: f */
    final List<Subscriber<? super R>> f45532f;

    /* renamed from: g */
    Subscriber<T> f45533g;

    /* renamed from: h */
    Subscription f45534h;

    /* compiled from: OperatorMulticast.java */
    /* renamed from: rx.internal.operators.m2$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15791a implements Observable.InterfaceC15567a<R> {

        /* renamed from: a */
        final /* synthetic */ Object f45535a;

        /* renamed from: b */
        final /* synthetic */ AtomicReference f45536b;

        /* renamed from: c */
        final /* synthetic */ List f45537c;

        C15791a(Object obj, AtomicReference atomicReference, List list) {
            this.f45535a = obj;
            this.f45536b = atomicReference;
            this.f45537c = list;
        }

        @Override // p640rx.functions.Action1
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((Subscriber) ((Subscriber) obj));
        }

        public void call(Subscriber<? super R> subscriber) {
            synchronized (this.f45535a) {
                if (this.f45536b.get() == null) {
                    this.f45537c.add(subscriber);
                } else {
                    ((Subject) this.f45536b.get()).m1822I6(subscriber);
                }
            }
        }
    }

    /* compiled from: OperatorMulticast.java */
    /* renamed from: rx.internal.operators.m2$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15792b implements Action0 {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f45538a;

        C15792b(AtomicReference atomicReference) {
            this.f45538a = atomicReference;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            synchronized (OperatorMulticast.this.f45529c) {
                if (OperatorMulticast.this.f45534h == this.f45538a.get()) {
                    OperatorMulticast operatorMulticast = OperatorMulticast.this;
                    Subscriber<T> subscriber = operatorMulticast.f45533g;
                    operatorMulticast.f45533g = null;
                    operatorMulticast.f45534h = null;
                    operatorMulticast.f45531e.set(null);
                    if (subscriber != null) {
                        subscriber.unsubscribe();
                    }
                }
            }
        }
    }

    /* compiled from: OperatorMulticast.java */
    /* renamed from: rx.internal.operators.m2$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15793c extends Subscriber<R> {

        /* renamed from: a */
        final /* synthetic */ Subscriber f45540a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15793c(Subscriber subscriber, Subscriber subscriber2) {
            super(subscriber);
            this.f45540a = subscriber2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45540a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45540a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(R r) {
            this.f45540a.onNext(r);
        }
    }

    public OperatorMulticast(Observable<? extends T> observable, Func0<? extends Subject<? super T, ? extends R>> func0) {
        this(new Object(), new AtomicReference(), new ArrayList(), observable, func0);
    }

    @Override // p640rx.observables.ConnectableObservable
    /* renamed from: z7 */
    public void mo692z7(Action1<? super Subscription> action1) {
        Subscriber<T> subscriber;
        synchronized (this.f45529c) {
            if (this.f45533g != null) {
                action1.call(this.f45534h);
                return;
            }
            Subject<? super T, ? extends R> call = this.f45530d.call();
            this.f45533g = Subscribers.m632e(call);
            AtomicReference atomicReference = new AtomicReference();
            atomicReference.set(Subscriptions.m346a(new C15792b(atomicReference)));
            this.f45534h = (Subscription) atomicReference.get();
            for (Subscriber<? super R> subscriber2 : this.f45532f) {
                call.m1822I6(new C15793c(subscriber2, subscriber2));
            }
            this.f45532f.clear();
            this.f45531e.set(call);
            action1.call(this.f45534h);
            synchronized (this.f45529c) {
                subscriber = this.f45533g;
            }
            if (subscriber != null) {
                this.f45528b.m1551q5(subscriber);
            }
        }
    }

    private OperatorMulticast(Object obj, AtomicReference<Subject<? super T, ? extends R>> atomicReference, List<Subscriber<? super R>> list, Observable<? extends T> observable, Func0<? extends Subject<? super T, ? extends R>> func0) {
        super(new C15791a(obj, atomicReference, list));
        this.f45529c = obj;
        this.f45531e = atomicReference;
        this.f45532f = list;
        this.f45528b = observable;
        this.f45530d = func0;
    }
}
