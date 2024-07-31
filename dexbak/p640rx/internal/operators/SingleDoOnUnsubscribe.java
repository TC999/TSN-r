package p640rx.internal.operators;

import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.functions.Action0;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.l4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleDoOnUnsubscribe<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f45514a;

    /* renamed from: b */
    final Action0 f45515b;

    public SingleDoOnUnsubscribe(Single.InterfaceC15633t<T> interfaceC15633t, Action0 action0) {
        this.f45514a = interfaceC15633t;
        this.f45515b = action0;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        singleSubscriber.m743b(Subscriptions.m346a(this.f45515b));
        this.f45514a.call(singleSubscriber);
    }
}
