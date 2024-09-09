package rx.internal.operators;

import rx.e;
import rx.internal.producers.SingleDelayedProducer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorAny.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m1<T> implements e.b<Boolean, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.p<? super T, Boolean> f62952a;

    /* renamed from: b  reason: collision with root package name */
    final boolean f62953b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorAny.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f62954a;

        /* renamed from: b  reason: collision with root package name */
        boolean f62955b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ SingleDelayedProducer f62956c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ rx.l f62957d;

        a(SingleDelayedProducer singleDelayedProducer, rx.l lVar) {
            this.f62956c = singleDelayedProducer;
            this.f62957d = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62955b) {
                return;
            }
            this.f62955b = true;
            if (this.f62954a) {
                this.f62956c.setValue(Boolean.FALSE);
            } else {
                this.f62956c.setValue(Boolean.valueOf(m1.this.f62953b));
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (!this.f62955b) {
                this.f62955b = true;
                this.f62957d.onError(th);
                return;
            }
            rx.plugins.c.I(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62955b) {
                return;
            }
            this.f62954a = true;
            try {
                if (m1.this.f62952a.call(t3).booleanValue()) {
                    this.f62955b = true;
                    this.f62956c.setValue(Boolean.valueOf(true ^ m1.this.f62953b));
                    unsubscribe();
                }
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this, t3);
            }
        }
    }

    public m1(rx.functions.p<? super T, Boolean> pVar, boolean z3) {
        this.f62952a = pVar;
        this.f62953b = z3;
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
