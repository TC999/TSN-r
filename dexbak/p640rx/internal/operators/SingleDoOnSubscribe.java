package p640rx.internal.operators;

import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.C15575a;
import p640rx.functions.Action0;

/* renamed from: rx.internal.operators.k4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleDoOnSubscribe<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Single.InterfaceC15633t<T> f45465a;

    /* renamed from: b */
    final Action0 f45466b;

    public SingleDoOnSubscribe(Single.InterfaceC15633t<T> interfaceC15633t, Action0 action0) {
        this.f45465a = interfaceC15633t;
        this.f45466b = action0;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        try {
            this.f45466b.call();
            this.f45465a.call(singleSubscriber);
        } catch (Throwable th) {
            C15575a.m1474e(th);
            singleSubscriber.onError(th);
        }
    }
}
