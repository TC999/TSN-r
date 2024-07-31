package p640rx.internal.operators;

import java.util.Iterator;
import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func2;
import p640rx.observers.Subscribers;

/* renamed from: rx.internal.operators.g4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorZipIterable<T1, T2, R> implements Observable.InterfaceC15568b<R, T1> {

    /* renamed from: a */
    final Iterable<? extends T2> f45246a;

    /* renamed from: b */
    final Func2<? super T1, ? super T2, ? extends R> f45247b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorZipIterable.java */
    /* renamed from: rx.internal.operators.g4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15731a extends Subscriber<T1> {

        /* renamed from: a */
        boolean f45248a;

        /* renamed from: b */
        final /* synthetic */ Subscriber f45249b;

        /* renamed from: c */
        final /* synthetic */ Iterator f45250c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15731a(Subscriber subscriber, Subscriber subscriber2, Iterator it) {
            super(subscriber);
            this.f45249b = subscriber2;
            this.f45250c = it;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45248a) {
                return;
            }
            this.f45248a = true;
            this.f45249b.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45248a) {
                C15575a.m1474e(th);
                return;
            }
            this.f45248a = true;
            this.f45249b.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T1 t1) {
            if (this.f45248a) {
                return;
            }
            try {
                this.f45249b.onNext(OperatorZipIterable.this.f45247b.call(t1, (Object) this.f45250c.next()));
                if (this.f45250c.hasNext()) {
                    return;
                }
                onCompleted();
            } catch (Throwable th) {
                C15575a.m1473f(th, this);
            }
        }
    }

    public OperatorZipIterable(Iterable<? extends T2> iterable, Func2<? super T1, ? super T2, ? extends R> func2) {
        this.f45246a = iterable;
        this.f45247b = func2;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T1> call(Subscriber<? super R> subscriber) {
        Iterator<? extends T2> it = this.f45246a.iterator();
        try {
            if (!it.hasNext()) {
                subscriber.onCompleted();
                return Subscribers.m633d();
            }
            return new C15731a(subscriber, subscriber, it);
        } catch (Throwable th) {
            C15575a.m1473f(th, subscriber);
            return Subscribers.m633d();
        }
    }
}
