package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func0;
import p640rx.observers.SerializedSubscriber;
import p640rx.observers.Subscribers;

/* renamed from: rx.internal.operators.o1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorBufferWithSingleObservable<T, TClosing> implements Observable.InterfaceC15568b<List<T>, T> {

    /* renamed from: a */
    final Func0<? extends Observable<? extends TClosing>> f45622a;

    /* renamed from: b */
    final int f45623b;

    /* compiled from: OperatorBufferWithSingleObservable.java */
    /* renamed from: rx.internal.operators.o1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15814a implements Func0<Observable<? extends TClosing>> {

        /* renamed from: a */
        final /* synthetic */ Observable f45624a;

        C15814a(Observable observable) {
            this.f45624a = observable;
        }

        @Override // p640rx.functions.Func0, java.util.concurrent.Callable
        public Observable<? extends TClosing> call() {
            return this.f45624a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorBufferWithSingleObservable.java */
    /* renamed from: rx.internal.operators.o1$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15815b extends Subscriber<TClosing> {

        /* renamed from: a */
        final /* synthetic */ C15816c f45626a;

        C15815b(C15816c c15816c) {
            this.f45626a = c15816c;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45626a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45626a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(TClosing tclosing) {
            this.f45626a.m1137F();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorBufferWithSingleObservable.java */
    /* renamed from: rx.internal.operators.o1$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public final class C15816c extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super List<T>> f45628a;

        /* renamed from: b */
        List<T> f45629b;

        /* renamed from: c */
        boolean f45630c;

        public C15816c(Subscriber<? super List<T>> subscriber) {
            this.f45628a = subscriber;
            this.f45629b = new ArrayList(OperatorBufferWithSingleObservable.this.f45623b);
        }

        /* renamed from: F */
        void m1137F() {
            synchronized (this) {
                if (this.f45630c) {
                    return;
                }
                List<T> list = this.f45629b;
                this.f45629b = new ArrayList(OperatorBufferWithSingleObservable.this.f45623b);
                try {
                    this.f45628a.onNext(list);
                } catch (Throwable th) {
                    unsubscribe();
                    synchronized (this) {
                        if (this.f45630c) {
                            return;
                        }
                        this.f45630c = true;
                        C15575a.m1473f(th, this.f45628a);
                    }
                }
            }
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            try {
                synchronized (this) {
                    if (this.f45630c) {
                        return;
                    }
                    this.f45630c = true;
                    List<T> list = this.f45629b;
                    this.f45629b = null;
                    this.f45628a.onNext(list);
                    this.f45628a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                C15575a.m1473f(th, this.f45628a);
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            synchronized (this) {
                if (this.f45630c) {
                    return;
                }
                this.f45630c = true;
                this.f45629b = null;
                this.f45628a.onError(th);
                unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            synchronized (this) {
                if (this.f45630c) {
                    return;
                }
                this.f45629b.add(t);
            }
        }
    }

    public OperatorBufferWithSingleObservable(Func0<? extends Observable<? extends TClosing>> func0, int i) {
        this.f45622a = func0;
        this.f45623b = i;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        try {
            Observable<? extends TClosing> call = this.f45622a.call();
            C15816c c15816c = new C15816c(new SerializedSubscriber(subscriber));
            C15815b c15815b = new C15815b(c15816c);
            subscriber.add(c15815b);
            subscriber.add(c15816c);
            call.m1822I6(c15815b);
            return c15816c;
        } catch (Throwable th) {
            C15575a.m1473f(th, subscriber);
            return Subscribers.m633d();
        }
    }

    public OperatorBufferWithSingleObservable(Observable<? extends TClosing> observable, int i) {
        this.f45622a = new C15814a(observable);
        this.f45623b = i;
    }
}
