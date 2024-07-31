package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.observers.SerializedSubscriber;
import p640rx.subscriptions.CompositeSubscription;

/* renamed from: rx.internal.operators.q1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorBufferWithStartEndObservable<T, TOpening, TClosing> implements Observable.InterfaceC15568b<List<T>, T> {

    /* renamed from: a */
    final Observable<? extends TOpening> f45727a;

    /* renamed from: b */
    final Func1<? super TOpening, ? extends Observable<? extends TClosing>> f45728b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorBufferWithStartEndObservable.java */
    /* renamed from: rx.internal.operators.q1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15839a extends Subscriber<TOpening> {

        /* renamed from: a */
        final /* synthetic */ C15840b f45729a;

        C15839a(C15840b c15840b) {
            this.f45729a = c15840b;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45729a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45729a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(TOpening topening) {
            this.f45729a.m1117G(topening);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorBufferWithStartEndObservable.java */
    /* renamed from: rx.internal.operators.q1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15840b extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super List<T>> f45731a;

        /* renamed from: b */
        final List<List<T>> f45732b = new LinkedList();

        /* renamed from: c */
        boolean f45733c;

        /* renamed from: d */
        final CompositeSubscription f45734d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorBufferWithStartEndObservable.java */
        /* renamed from: rx.internal.operators.q1$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15841a extends Subscriber<TClosing> {

            /* renamed from: a */
            final /* synthetic */ List f45736a;

            C15841a(List list) {
                this.f45736a = list;
            }

            @Override // p640rx.Observer
            public void onCompleted() {
                C15840b.this.f45734d.m361G(this);
                C15840b.this.m1118F(this.f45736a);
            }

            @Override // p640rx.Observer
            public void onError(Throwable th) {
                C15840b.this.onError(th);
            }

            @Override // p640rx.Observer
            public void onNext(TClosing tclosing) {
                C15840b.this.f45734d.m361G(this);
                C15840b.this.m1118F(this.f45736a);
            }
        }

        public C15840b(Subscriber<? super List<T>> subscriber) {
            this.f45731a = subscriber;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.f45734d = compositeSubscription;
            add(compositeSubscription);
        }

        /* renamed from: F */
        void m1118F(List<T> list) {
            boolean z;
            synchronized (this) {
                if (this.f45733c) {
                    return;
                }
                Iterator<List<T>> it = this.f45732b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next() == list) {
                        z = true;
                        it.remove();
                        break;
                    }
                }
                if (z) {
                    this.f45731a.onNext(list);
                }
            }
        }

        /* renamed from: G */
        void m1117G(TOpening topening) {
            ArrayList arrayList = new ArrayList();
            synchronized (this) {
                if (this.f45733c) {
                    return;
                }
                this.f45732b.add(arrayList);
                try {
                    Observable<? extends TClosing> call = OperatorBufferWithStartEndObservable.this.f45728b.call(topening);
                    C15841a c15841a = new C15841a(arrayList);
                    this.f45734d.m359a(c15841a);
                    call.m1822I6(c15841a);
                } catch (Throwable th) {
                    C15575a.m1473f(th, this);
                }
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.f45733c) {
                        return;
                    }
                    this.f45733c = true;
                    LinkedList<List> linkedList = new LinkedList(this.f45732b);
                    this.f45732b.clear();
                    for (List list : linkedList) {
                        this.f45731a.onNext(list);
                    }
                    this.f45731a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                C15575a.m1473f(th, this.f45731a);
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f45733c) {
                    return;
                }
                this.f45733c = true;
                this.f45732b.clear();
                this.f45731a.onError(th);
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            synchronized (this) {
                for (List<T> list : this.f45732b) {
                    list.add(t);
                }
            }
        }
    }

    public OperatorBufferWithStartEndObservable(Observable<? extends TOpening> observable, Func1<? super TOpening, ? extends Observable<? extends TClosing>> func1) {
        this.f45727a = observable;
        this.f45728b = func1;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        C15840b c15840b = new C15840b(new SerializedSubscriber(subscriber));
        C15839a c15839a = new C15839a(c15840b);
        subscriber.add(c15839a);
        subscriber.add(c15840b);
        this.f45727a.m1822I6(c15839a);
        return c15840b;
    }
}
