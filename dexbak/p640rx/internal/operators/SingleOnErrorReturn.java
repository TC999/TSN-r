package p640rx.internal.operators;

import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Func1;

/* renamed from: rx.internal.operators.s4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleOnErrorReturn<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f45872a;

    /* renamed from: b */
    final Func1<Throwable, ? extends T> f45873b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleOnErrorReturn.java */
    /* renamed from: rx.internal.operators.s4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15879a<T> extends SingleSubscriber<T> {

        /* renamed from: b */
        final SingleSubscriber<? super T> f45874b;

        /* renamed from: c */
        final Func1<Throwable, ? extends T> f45875c;

        public C15879a(SingleSubscriber<? super T> singleSubscriber, Func1<Throwable, ? extends T> func1) {
            this.f45874b = singleSubscriber;
            this.f45875c = func1;
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            this.f45874b.mo446d(t);
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            try {
                this.f45874b.mo446d(this.f45875c.call(th));
            } catch (Throwable th2) {
                C15575a.m1474e(th2);
                this.f45874b.onError(th2);
            }
        }
    }

    public SingleOnErrorReturn(Single.InterfaceC15633t<T> interfaceC15633t, Func1<Throwable, ? extends T> func1) {
        this.f45872a = interfaceC15633t;
        this.f45873b = func1;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15879a c15879a = new C15879a(singleSubscriber, this.f45873b);
        singleSubscriber.m743b(c15879a);
        this.f45872a.call(c15879a);
    }
}
