package p640rx.internal.operators;

import p640rx.Observable;
import p640rx.Producer;
import p640rx.Subscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.OnErrorThrowable;
import p640rx.plugins.RxJavaHooks;

/* renamed from: rx.internal.operators.s1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public class OperatorCast<T, R> implements Observable.InterfaceC15568b<R, T> {

    /* renamed from: a */
    final Class<R> f45832a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorCast.java */
    /* renamed from: rx.internal.operators.s1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15868a<T, R> extends Subscriber<T> {

        /* renamed from: a */
        final Subscriber<? super R> f45833a;

        /* renamed from: b */
        final Class<R> f45834b;

        /* renamed from: c */
        boolean f45835c;

        public C15868a(Subscriber<? super R> subscriber, Class<R> cls) {
            this.f45833a = subscriber;
            this.f45834b = cls;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            if (this.f45835c) {
                return;
            }
            this.f45833a.onCompleted();
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            if (this.f45835c) {
                RxJavaHooks.m576I(th);
                return;
            }
            this.f45835c = true;
            this.f45833a.onError(th);
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            try {
                this.f45833a.onNext(this.f45834b.cast(t));
            } catch (Throwable th) {
                C15575a.m1474e(th);
                unsubscribe();
                onError(OnErrorThrowable.addValueAsLastCause(th, t));
            }
        }

        @Override // p640rx.Subscriber, p640rx.observers.AssertableSubscriber
        public void setProducer(Producer producer) {
            this.f45833a.setProducer(producer);
        }
    }

    public OperatorCast(Class<R> cls) {
        this.f45832a = cls;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super R> subscriber) {
        C15868a c15868a = new C15868a(subscriber, this.f45832a);
        subscriber.add(c15868a);
        return c15868a;
    }
}
