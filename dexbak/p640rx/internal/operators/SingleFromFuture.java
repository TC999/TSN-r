package p640rx.internal.operators;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p640rx.Single;
import p640rx.SingleSubscriber;
import p640rx.exceptions.C15575a;
import p640rx.subscriptions.Subscriptions;

/* renamed from: rx.internal.operators.o4 */
/* loaded from: E:\fuckcool\tsn\5406560.dex */
public final class SingleFromFuture<T> implements Single.InterfaceC15633t<T> {

    /* renamed from: a */
    final Future<? extends T> f45649a;

    /* renamed from: b */
    final long f45650b;

    /* renamed from: c */
    final TimeUnit f45651c;

    public SingleFromFuture(Future<? extends T> future, long j, TimeUnit timeUnit) {
        this.f45649a = future;
        this.f45650b = j;
        this.f45651c = timeUnit;
    }

    @Override // p640rx.functions.Action1
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((SingleSubscriber) ((SingleSubscriber) obj));
    }

    public void call(SingleSubscriber<? super T> singleSubscriber) {
        Object obj;
        Future<? extends T> future = this.f45649a;
        singleSubscriber.m743b(Subscriptions.m344c(future));
        try {
            long j = this.f45650b;
            if (j == 0) {
                obj = (T) future.get();
            } else {
                obj = (T) future.get(j, this.f45651c);
            }
            singleSubscriber.mo446d(obj);
        } catch (Throwable th) {
            C15575a.m1474e(th);
            singleSubscriber.onError(th);
        }
    }
}
