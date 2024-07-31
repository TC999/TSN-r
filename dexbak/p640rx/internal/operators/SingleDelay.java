package p640rx.internal.operators;

import java.util.concurrent.TimeUnit;
import p640rx.Scheduler;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.functions.Action0;

/* renamed from: rx.internal.operators.h4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleDelay<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f45302a;

    /* renamed from: b */
    final long f45303b;

    /* renamed from: c */
    final TimeUnit f45304c;

    /* renamed from: d */
    final Scheduler f45305d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleDelay.java */
    /* renamed from: rx.internal.operators.h4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15746a<T> extends SingleSubscriber<T> implements Action0 {

        /* renamed from: b */
        final SingleSubscriber<? super T> f45306b;

        /* renamed from: c */
        final Scheduler.AbstractC15607a f45307c;

        /* renamed from: d */
        final long f45308d;

        /* renamed from: e */
        final TimeUnit f45309e;

        /* renamed from: f */
        T f45310f;

        /* renamed from: g */
        Throwable f45311g;

        public C15746a(SingleSubscriber<? super T> singleSubscriber, Scheduler.AbstractC15607a abstractC15607a, long j, TimeUnit timeUnit) {
            this.f45306b = singleSubscriber;
            this.f45307c = abstractC15607a;
            this.f45308d = j;
            this.f45309e = timeUnit;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            try {
                Throwable th = this.f45311g;
                if (th != null) {
                    this.f45311g = null;
                    this.f45306b.onError(th);
                } else {
                    T t = this.f45310f;
                    this.f45310f = null;
                    this.f45306b.mo446d(t);
                }
            } finally {
                this.f45307c.unsubscribe();
            }
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            this.f45310f = t;
            this.f45307c.mo460F(this, this.f45308d, this.f45309e);
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            this.f45311g = th;
            this.f45307c.mo460F(this, this.f45308d, this.f45309e);
        }
    }

    public SingleDelay(Single.InterfaceC15633t<T> interfaceC15633t, long j, TimeUnit timeUnit, Scheduler scheduler) {
        this.f45302a = interfaceC15633t;
        this.f45305d = scheduler;
        this.f45303b = j;
        this.f45304c = timeUnit;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Scheduler.AbstractC15607a mo450a = this.f45305d.mo450a();
        C15746a c15746a = new C15746a(singleSubscriber, mo450a, this.f45303b, this.f45304c);
        singleSubscriber.m743b(mo450a);
        singleSubscriber.m743b(c15746a);
        this.f45302a.call(c15746a);
    }
}
