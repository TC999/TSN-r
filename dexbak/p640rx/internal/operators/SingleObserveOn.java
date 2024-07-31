package p640rx.internal.operators;

import p640rx.Scheduler;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.functions.Action0;

/* renamed from: rx.internal.operators.r4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleObserveOn<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f45807a;

    /* renamed from: b */
    final Scheduler f45808b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleObserveOn.java */
    /* renamed from: rx.internal.operators.r4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15863a<T> extends SingleSubscriber<T> implements Action0 {

        /* renamed from: b */
        final SingleSubscriber<? super T> f45809b;

        /* renamed from: c */
        final Scheduler.AbstractC15607a f45810c;

        /* renamed from: d */
        T f45811d;

        /* renamed from: e */
        Throwable f45812e;

        public C15863a(SingleSubscriber<? super T> singleSubscriber, Scheduler.AbstractC15607a abstractC15607a) {
            this.f45809b = singleSubscriber;
            this.f45810c = abstractC15607a;
        }

        @Override // p640rx.functions.Action0
        public void call() {
            try {
                Throwable th = this.f45812e;
                if (th != null) {
                    this.f45812e = null;
                    this.f45809b.onError(th);
                } else {
                    T t = this.f45811d;
                    this.f45811d = null;
                    this.f45809b.mo446d(t);
                }
            } finally {
                this.f45810c.unsubscribe();
            }
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            this.f45811d = t;
            this.f45810c.mo456d(this);
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            this.f45812e = th;
            this.f45810c.mo456d(this);
        }
    }

    public SingleObserveOn(Single.InterfaceC15633t<T> interfaceC15633t, Scheduler scheduler) {
        this.f45807a = interfaceC15633t;
        this.f45808b = scheduler;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Scheduler.AbstractC15607a mo450a = this.f45808b.mo450a();
        C15863a c15863a = new C15863a(singleSubscriber, mo450a);
        singleSubscriber.m743b(mo450a);
        singleSubscriber.m743b(c15863a);
        this.f45807a.call(c15863a);
    }
}
