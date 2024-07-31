package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.internal.producers.SingleDelayedProducer;

/* renamed from: rx.internal.operators.v3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorToObservableList<T> implements Observable.InterfaceC15568b<List<T>, T> {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorToObservableList.java */
    /* renamed from: rx.internal.operators.v3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15927a extends Subscriber<T> {

        /* renamed from: a */
        boolean f46039a;

        /* renamed from: b */
        List<T> f46040b = new LinkedList();

        /* renamed from: c */
        final /* synthetic */ SingleDelayedProducer f46041c;

        /* renamed from: d */
        final /* synthetic */ Subscriber f46042d;

        C15927a(SingleDelayedProducer singleDelayedProducer, Subscriber subscriber) {
            this.f46041c = singleDelayedProducer;
            this.f46042d = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f46039a) {
                return;
            }
            this.f46039a = true;
            try {
                ArrayList arrayList = new ArrayList(this.f46040b);
                this.f46040b = null;
                this.f46041c.setValue(arrayList);
            } catch (Throwable th) {
                C15575a.m1473f(th, this);
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46042d.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f46039a) {
                return;
            }
            this.f46040b.add(t);
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorToObservableList.java */
    /* renamed from: rx.internal.operators.v3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15928b {

        /* renamed from: a */
        static final OperatorToObservableList<Object> f46044a = new OperatorToObservableList<>();

        C15928b() {
        }
    }

    OperatorToObservableList() {
    }

    /* renamed from: a */
    public static <T> OperatorToObservableList<T> m1040a() {
        return (OperatorToObservableList<T>) C15928b.f46044a;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        C15927a c15927a = new C15927a(singleDelayedProducer, subscriber);
        subscriber.add(c15927a);
        subscriber.setProducer(singleDelayedProducer);
        return c15927a;
    }
}
