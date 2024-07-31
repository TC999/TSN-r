package p640rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func2;
import p640rx.internal.producers.SingleDelayedProducer;

/* renamed from: rx.internal.operators.w3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorToObservableSortedList<T> implements Observable.InterfaceC15568b<List<T>, T> {

    /* renamed from: c */
    private static final Comparator f46111c = new C15952c();

    /* renamed from: a */
    final Comparator<? super T> f46112a;

    /* renamed from: b */
    final int f46113b;

    /* compiled from: OperatorToObservableSortedList.java */
    /* renamed from: rx.internal.operators.w3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15950a implements Comparator<T> {

        /* renamed from: a */
        final /* synthetic */ Func2 f46114a;

        C15950a(Func2 func2) {
            this.f46114a = func2;
        }

        @Override // java.util.Comparator
        public int compare(T t, T t2) {
            return ((Integer) this.f46114a.call(t, t2)).intValue();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorToObservableSortedList.java */
    /* renamed from: rx.internal.operators.w3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15951b extends Subscriber<T> {

        /* renamed from: a */
        List<T> f46116a;

        /* renamed from: b */
        boolean f46117b;

        /* renamed from: c */
        final /* synthetic */ SingleDelayedProducer f46118c;

        /* renamed from: d */
        final /* synthetic */ Subscriber f46119d;

        C15951b(SingleDelayedProducer singleDelayedProducer, Subscriber subscriber) {
            this.f46118c = singleDelayedProducer;
            this.f46119d = subscriber;
            this.f46116a = new ArrayList(OperatorToObservableSortedList.this.f46113b);
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f46117b) {
                return;
            }
            this.f46117b = true;
            List<T> list = this.f46116a;
            this.f46116a = null;
            try {
                Collections.sort(list, OperatorToObservableSortedList.this.f46112a);
                this.f46118c.setValue(list);
            } catch (Throwable th) {
                C15575a.m1473f(th, this);
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46119d.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f46117b) {
                return;
            }
            this.f46116a.add(t);
        }

        @Override // p640rx.Subscriber
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* compiled from: OperatorToObservableSortedList.java */
    /* renamed from: rx.internal.operators.w3$c */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    static final class C15952c implements Comparator<Object> {
        C15952c() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo((Comparable) obj2);
        }
    }

    public OperatorToObservableSortedList(int i) {
        this.f46112a = f46111c;
        this.f46113b = i;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super List<T>> subscriber) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        C15951b c15951b = new C15951b(singleDelayedProducer, subscriber);
        subscriber.add(c15951b);
        subscriber.setProducer(singleDelayedProducer);
        return c15951b;
    }

    public OperatorToObservableSortedList(Func2<? super T, ? super T, Integer> func2, int i) {
        this.f46113b = i;
        this.f46112a = new C15950a(func2);
    }
}
