package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.internal.producers.SingleDelayedProducer;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.l1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorAll<T> implements Observable.InterfaceC15568b<Boolean, T> {

    /* renamed from: a */
    final Func1<? super T, Boolean> f45476a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorAll.java */
    /* renamed from: rx.internal.operators.l1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15782a extends Subscriber<T> {

        /* renamed from: a */
        boolean f45477a;

        /* renamed from: b */
        final /* synthetic */ SingleDelayedProducer f45478b;

        /* renamed from: c */
        final /* synthetic */ Subscriber f45479c;

        C15782a(SingleDelayedProducer singleDelayedProducer, Subscriber subscriber) {
            this.f45478b = singleDelayedProducer;
            this.f45479c = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45477a) {
                return;
            }
            this.f45477a = true;
            this.f45478b.setValue(Boolean.TRUE);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (!this.f45477a) {
                this.f45477a = true;
                this.f45479c.onError(th);
                return;
            }
            RxJavaHooks.m576I(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45477a) {
                return;
            }
            try {
                if (OperatorAll.this.f45476a.call(t).booleanValue()) {
                    return;
                }
                this.f45477a = true;
                this.f45478b.setValue(Boolean.FALSE);
                unsubscribe();
            } catch (Throwable th) {
                C15575a.m1472g(th, this, t);
            }
        }
    }

    public OperatorAll(Func1<? super T, Boolean> func1) {
        this.f45476a = func1;
    }

    @Override // p640rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Boolean> subscriber) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        C15782a c15782a = new C15782a(singleDelayedProducer, subscriber);
        subscriber.add(c15782a);
        subscriber.setProducer(singleDelayedProducer);
        return c15782a;
    }
}
