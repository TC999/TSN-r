package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;
import p640rx.internal.producers.SingleDelayedProducer;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.m1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorAny<T> implements Observable.InterfaceC15568b<Boolean, T> {

    /* renamed from: a */
    final Func1<? super T, Boolean> f45521a;

    /* renamed from: b */
    final boolean f45522b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorAny.java */
    /* renamed from: rx.internal.operators.m1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15790a extends Subscriber<T> {

        /* renamed from: a */
        boolean f45523a;

        /* renamed from: b */
        boolean f45524b;

        /* renamed from: c */
        final /* synthetic */ SingleDelayedProducer f45525c;

        /* renamed from: d */
        final /* synthetic */ Subscriber f45526d;

        C15790a(SingleDelayedProducer singleDelayedProducer, Subscriber subscriber) {
            this.f45525c = singleDelayedProducer;
            this.f45526d = subscriber;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45524b) {
                return;
            }
            this.f45524b = true;
            if (this.f45523a) {
                this.f45525c.setValue(Boolean.FALSE);
            } else {
                this.f45525c.setValue(Boolean.valueOf(OperatorAny.this.f45522b));
            }
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (!this.f45524b) {
                this.f45524b = true;
                this.f45526d.onError(th);
                return;
            }
            RxJavaHooks.m576I(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            if (this.f45524b) {
                return;
            }
            this.f45523a = true;
            try {
                if (OperatorAny.this.f45521a.call(t).booleanValue()) {
                    this.f45524b = true;
                    this.f45525c.setValue(Boolean.valueOf(true ^ OperatorAny.this.f45522b));
                    unsubscribe();
                }
            } catch (Throwable th) {
                C15575a.m1472g(th, this, t);
            }
        }
    }

    public OperatorAny(Func1<? super T, Boolean> func1, boolean z) {
        this.f45521a = func1;
        this.f45522b = z;
    }

    @Override // p640rx.functions.Func1
    public Subscriber<? super T> call(Subscriber<? super Boolean> subscriber) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(subscriber);
        C15790a c15790a = new C15790a(singleDelayedProducer, subscriber);
        subscriber.add(c15790a);
        subscriber.setProducer(singleDelayedProducer);
        return c15790a;
    }
}
