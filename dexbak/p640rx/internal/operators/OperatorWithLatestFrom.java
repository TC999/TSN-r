package p640rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func2;
import p640rx.observers.SerializedSubscriber;

/* renamed from: rx.internal.operators.d4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorWithLatestFrom<T, U, R> implements Observable.InterfaceC15568b<R, T> {

    /* renamed from: c */
    static final Object f45072c = new Object();

    /* renamed from: a */
    final Func2<? super T, ? super U, ? extends R> f45073a;

    /* renamed from: b */
    final Observable<? extends U> f45074b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWithLatestFrom.java */
    /* renamed from: rx.internal.operators.d4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15690a extends Subscriber<T> {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f45075a;

        /* renamed from: b */
        final /* synthetic */ SerializedSubscriber f45076b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15690a(Subscriber subscriber, boolean z, AtomicReference atomicReference, SerializedSubscriber serializedSubscriber) {
            super(subscriber, z);
            this.f45075a = atomicReference;
            this.f45076b = serializedSubscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            this.f45076b.onCompleted();
            this.f45076b.unsubscribe();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45076b.onError(th);
            this.f45076b.unsubscribe();
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            Object obj = this.f45075a.get();
            if (obj != OperatorWithLatestFrom.f45072c) {
                try {
                    this.f45076b.onNext(OperatorWithLatestFrom.this.f45073a.call(t, obj));
                } catch (Throwable th) {
                    C15575a.m1473f(th, this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorWithLatestFrom.java */
    /* renamed from: rx.internal.operators.d4$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15691b extends Subscriber<U> {

        /* renamed from: a */
        final /* synthetic */ AtomicReference f45078a;

        /* renamed from: b */
        final /* synthetic */ SerializedSubscriber f45079b;

        C15691b(AtomicReference atomicReference, SerializedSubscriber serializedSubscriber) {
            this.f45078a = atomicReference;
            this.f45079b = serializedSubscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45078a.get() == OperatorWithLatestFrom.f45072c) {
                this.f45079b.onCompleted();
                this.f45079b.unsubscribe();
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f45079b.onError(th);
            this.f45079b.unsubscribe();
        }

        @Override // p640rx.Observer
        public void onNext(U u) {
            this.f45078a.set(u);
        }
    }

    public OperatorWithLatestFrom(Observable<? extends U> observable, Func2<? super T, ? super U, ? extends R> func2) {
        this.f45074b = observable;
        this.f45073a = func2;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        SerializedSubscriber serializedSubscriber = new SerializedSubscriber(subscriber, false);
        subscriber.add(serializedSubscriber);
        AtomicReference atomicReference = new AtomicReference(f45072c);
        C15690a c15690a = new C15690a(serializedSubscriber, true, atomicReference, serializedSubscriber);
        C15691b c15691b = new C15691b(atomicReference, serializedSubscriber);
        serializedSubscriber.add(c15690a);
        serializedSubscriber.add(c15691b);
        this.f45074b.m1822I6(c15691b);
        return c15690a;
    }
}
