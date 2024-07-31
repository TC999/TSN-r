package p640rx.internal.operators;

import java.util.concurrent.Callable;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.C15575a;

/* renamed from: rx.internal.operators.m4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleFromCallable<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Callable<? extends T> f45547a;

    public SingleFromCallable(Callable<? extends T> callable) {
        this.f45547a = callable;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        try {
            singleSubscriber.mo446d((T) this.f45547a.call());
        } catch (Throwable th) {
            C15575a.m1474e(th);
            singleSubscriber.onError(th);
        }
    }
}
