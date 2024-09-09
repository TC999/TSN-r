package rx.internal.operators;

import rx.e;
import rx.internal.producers.SingleDelayedProducer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorAll.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class l1<T> implements e.b<Boolean, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.p<? super T, Boolean> f62907a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorAll.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f62908a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ SingleDelayedProducer f62909b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.l f62910c;

        a(SingleDelayedProducer singleDelayedProducer, rx.l lVar) {
            this.f62909b = singleDelayedProducer;
            this.f62910c = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62908a) {
                return;
            }
            this.f62908a = true;
            this.f62909b.setValue(Boolean.TRUE);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!this.f62908a) {
                this.f62908a = true;
                this.f62910c.onError(th);
                return;
            }
            rx.plugins.c.I(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62908a) {
                return;
            }
            try {
                if (l1.this.f62907a.call(t3).booleanValue()) {
                    return;
                }
                this.f62908a = true;
                this.f62909b.setValue(Boolean.FALSE);
                unsubscribe();
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this, t3);
            }
        }
    }

    public l1(rx.functions.p<? super T, Boolean> pVar) {
        this.f62907a = pVar;
    }

    @Override // rx.functions.p
    public rx.l<? super T> call(rx.l<? super Boolean> lVar) {
        SingleDelayedProducer singleDelayedProducer = new SingleDelayedProducer(lVar);
        a aVar = new a(singleDelayedProducer, lVar);
        lVar.add(aVar);
        lVar.setProducer(singleDelayedProducer);
        return aVar;
    }
}
