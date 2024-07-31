package p640rx.internal.operators;

import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.C15575a;
import p640rx.exceptions.CompositeException;
import p640rx.functions.Action1;

/* renamed from: rx.internal.operators.j4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleDoOnEvent<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single<T> f45406a;

    /* renamed from: b */
    final Action1<? super T> f45407b;

    /* renamed from: c */
    final Action1<Throwable> f45408c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: SingleDoOnEvent.java */
    /* renamed from: rx.internal.operators.j4$a */
    /* loaded from: E:\fuckcool\tsn\5406560.dex */
    public static final class C15768a<T> extends SingleSubscriber<T> {

        /* renamed from: b */
        final SingleSubscriber<? super T> f45409b;

        /* renamed from: c */
        final Action1<? super T> f45410c;

        /* renamed from: d */
        final Action1<Throwable> f45411d;

        C15768a(SingleSubscriber<? super T> singleSubscriber, Action1<? super T> action1, Action1<Throwable> action12) {
            this.f45409b = singleSubscriber;
            this.f45410c = action1;
            this.f45411d = action12;
        }

        @Override // p640rx.SingleSubscriber
        /* renamed from: d */
        public void mo446d(T t) {
            try {
                this.f45410c.call(t);
                this.f45409b.mo446d(t);
            } catch (Throwable th) {
                C15575a.m1470i(th, this, t);
            }
        }

        @Override // p640rx.SingleSubscriber
        public void onError(Throwable th) {
            try {
                this.f45411d.call(th);
                this.f45409b.onError(th);
            } catch (Throwable th2) {
                C15575a.m1474e(th2);
                this.f45409b.onError(new CompositeException(th, th2));
            }
        }
    }

    public SingleDoOnEvent(Single<T> single, Action1<? super T> action1, Action1<Throwable> action12) {
        this.f45406a = single;
        this.f45407b = action1;
        this.f45408c = action12;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        C15768a c15768a = new C15768a(singleSubscriber, this.f45407b, this.f45408c);
        singleSubscriber.m743b(c15768a);
        this.f45406a.m1372i0(c15768a);
    }
}
