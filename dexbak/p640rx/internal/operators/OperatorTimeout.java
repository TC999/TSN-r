package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import p640rx.Observable;
import p640rx.Scheduler;
import p640rx.Subscriber;
import p640rx.Subscription;
import p640rx.functions.Action0;
import p640rx.internal.operators.OperatorTimeoutBase;

/* renamed from: rx.internal.operators.r3 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class OperatorTimeout<T> extends OperatorTimeoutBase<T> {

    /* compiled from: OperatorTimeout.java */
    /* renamed from: rx.internal.operators.r3$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15859a implements OperatorTimeoutBase.InterfaceC15875a<T> {

        /* renamed from: a */
        final /* synthetic */ long f45797a;

        /* renamed from: b */
        final /* synthetic */ TimeUnit f45798b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorTimeout.java */
        /* renamed from: rx.internal.operators.r3$a$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15860a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ OperatorTimeoutBase.C15877c f45799a;

            /* renamed from: b */
            final /* synthetic */ Long f45800b;

            C15860a(OperatorTimeoutBase.C15877c c15877c, Long l) {
                this.f45799a = c15877c;
                this.f45800b = l;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                this.f45799a.m1093F(this.f45800b.longValue());
            }
        }

        C15859a(long j, TimeUnit timeUnit) {
            this.f45797a = j;
            this.f45798b = timeUnit;
        }

        @Override // p640rx.functions.Func3
        public /* bridge */ /* synthetic */ Subscription call(Object obj, Long l, Scheduler.AbstractC15607a abstractC15607a) {
            return call((OperatorTimeoutBase.C15877c) ((OperatorTimeoutBase.C15877c) obj), l, abstractC15607a);
        }

        public Subscription call(OperatorTimeoutBase.C15877c<T> c15877c, Long l, Scheduler.AbstractC15607a abstractC15607a) {
            return abstractC15607a.mo460F(new C15860a(c15877c, l), this.f45797a, this.f45798b);
        }
    }

    /* compiled from: OperatorTimeout.java */
    /* renamed from: rx.internal.operators.r3$b */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    class C15861b implements OperatorTimeoutBase.InterfaceC15876b<T> {

        /* renamed from: a */
        final /* synthetic */ long f45802a;

        /* renamed from: b */
        final /* synthetic */ TimeUnit f45803b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: OperatorTimeout.java */
        /* renamed from: rx.internal.operators.r3$b$a */
        /* loaded from: E:\fuckcool\tsn\5406560.dex */
        public class C15862a implements Action0 {

            /* renamed from: a */
            final /* synthetic */ OperatorTimeoutBase.C15877c f45804a;

            /* renamed from: b */
            final /* synthetic */ Long f45805b;

            C15862a(OperatorTimeoutBase.C15877c c15877c, Long l) {
                this.f45804a = c15877c;
                this.f45805b = l;
            }

            @Override // p640rx.functions.Action0
            public void call() {
                this.f45804a.m1093F(this.f45805b.longValue());
            }
        }

        C15861b(long j, TimeUnit timeUnit) {
            this.f45802a = j;
            this.f45803b = timeUnit;
        }

        @Override // p640rx.functions.Func4
        public /* bridge */ /* synthetic */ Subscription call(Object obj, Long l, Object obj2, Scheduler.AbstractC15607a abstractC15607a) {
            return call((OperatorTimeoutBase.C15877c<Long>) obj, l, (Long) obj2, abstractC15607a);
        }

        public Subscription call(OperatorTimeoutBase.C15877c<T> c15877c, Long l, T t, Scheduler.AbstractC15607a abstractC15607a) {
            return abstractC15607a.mo460F(new C15862a(c15877c, l), this.f45802a, this.f45803b);
        }
    }

    public OperatorTimeout(long j, TimeUnit timeUnit, Observable<? extends T> observable, Scheduler scheduler) {
        super(new C15859a(j, timeUnit), new C15861b(j, timeUnit), observable, scheduler);
    }

    @Override // p640rx.internal.operators.OperatorTimeoutBase
    public /* bridge */ /* synthetic */ Subscriber call(Subscriber subscriber) {
        return super.call(subscriber);
    }
}
