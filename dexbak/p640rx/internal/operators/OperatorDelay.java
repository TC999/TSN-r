package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.functions.Action0;

/* renamed from: rx.internal.operators.v1 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorDelay<T> implements Observable.InterfaceC15568b<T, T> {

    /* renamed from: a */
    final long f46017a;

    /* renamed from: b */
    final TimeUnit f46018b;

    /* renamed from: c */
    final Scheduler f46019c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: OperatorDelay.java */
    /* renamed from: rx.internal.operators.v1$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public class C15921a extends Subscriber<T> {

        /* renamed from: a */
        boolean f46020a;

        /* renamed from: b */
        final /* synthetic */ Scheduler.AbstractC15607a f46021b;

        /* renamed from: c */
        final /* synthetic */ Subscriber f46022c;

        /* compiled from: OperatorDelay.java */
        /* renamed from: rx.internal.operators.v1$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15922a implements Action0 {
            C15922a() {
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15921a c15921a = C15921a.this;
                if (c15921a.f46020a) {
                    return;
                }
                c15921a.f46020a = true;
                c15921a.f46022c.onCompleted();
            }
        }

        /* compiled from: OperatorDelay.java */
        /* renamed from: rx.internal.operators.v1$a$b */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15923b implements Action0 {

            /* renamed from: a */
            final /* synthetic */ Throwable f46025a;

            C15923b(Throwable th) {
                this.f46025a = th;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                C15921a c15921a = C15921a.this;
                if (c15921a.f46020a) {
                    return;
                }
                c15921a.f46020a = true;
                c15921a.f46022c.onError(this.f46025a);
                C15921a.this.f46021b.unsubscribe();
            }
        }

        /* compiled from: OperatorDelay.java */
        /* renamed from: rx.internal.operators.v1$a$c */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        class C15924c implements Action0 {

            /* renamed from: a */
            final /* synthetic */ Object f46027a;

            C15924c(Object obj) {
                this.f46027a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // p640rx.functions.Action0
            public void call() {
                C15921a c15921a = C15921a.this;
                if (c15921a.f46020a) {
                    return;
                }
                c15921a.f46022c.onNext(this.f46027a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C15921a(Subscriber subscriber, Scheduler.AbstractC15607a abstractC15607a, Subscriber subscriber2) {
            super(subscriber);
            this.f46021b = abstractC15607a;
            this.f46022c = subscriber2;
        }

        @Override // p640rx.Observer
        public void onCompleted() {
            Scheduler.AbstractC15607a abstractC15607a = this.f46021b;
            C15922a c15922a = new C15922a();
            OperatorDelay operatorDelay = OperatorDelay.this;
            abstractC15607a.mo460F(c15922a, operatorDelay.f46017a, operatorDelay.f46018b);
        }

        @Override // p640rx.Observer
        public void onError(Throwable th) {
            this.f46021b.mo456d(new C15923b(th));
        }

        @Override // p640rx.Observer
        public void onNext(T t) {
            Scheduler.AbstractC15607a abstractC15607a = this.f46021b;
            C15924c c15924c = new C15924c(t);
            OperatorDelay operatorDelay = OperatorDelay.this;
            abstractC15607a.mo460F(c15924c, operatorDelay.f46017a, operatorDelay.f46018b);
        }
    }

    public OperatorDelay(long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f46017a = j;
        this.f46018b = timeUnit;
        this.f46019c = scheduler;
    }

    @Override // p640rx.functions.Func1
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((Subscriber) ((Subscriber) obj));
    }

    public Subscriber<? super T> call(Subscriber<? super T> subscriber) {
        Scheduler.AbstractC15607a mo450a = this.f46019c.mo450a();
        subscriber.add(mo450a);
        return new C15921a(subscriber, mo450a, subscriber);
    }
}
