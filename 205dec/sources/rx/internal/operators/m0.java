package rx.internal.operators;

import java.util.concurrent.Callable;
import rx.e;
import rx.internal.producers.SingleDelayedProducer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeFromCallable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m0<T> implements e.a<T> {

    /* renamed from: a  reason: collision with root package name */
    private final Callable<? extends T> f62951a;

    public m0(Callable<? extends T> callable) {
        this.f62951a = callable;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(lVar);
        lVar.setProducer(singleDelayedProducer);
        try {
            singleDelayedProducer.setValue(this.f62951a.call());
        } catch (Throwable th) {
            rx.exceptions.a.f(th, lVar);
        }
    }
}
