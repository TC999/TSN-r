package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTakeUntilPredicate.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class n3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.p<? super T, Boolean> f63011a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTakeUntilPredicate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f63012a;

        a(b bVar) {
            this.f63012a = bVar;
        }

        @Override // rx.g
        public void request(long j4) {
            this.f63012a.g(j4);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTakeUntilPredicate.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class b extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.l<? super T> f63014a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f63015b;

        b(rx.l<? super T> lVar) {
            this.f63014a = lVar;
        }

        void g(long j4) {
            request(j4);
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63015b) {
                return;
            }
            this.f63014a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63015b) {
                return;
            }
            this.f63014a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f63014a.onNext(t3);
            try {
                if (n3.this.f63011a.call(t3).booleanValue()) {
                    this.f63015b = true;
                    this.f63014a.onCompleted();
                    unsubscribe();
                }
            } catch (Throwable th) {
                this.f63015b = true;
                rx.exceptions.a.g(th, this.f63014a, t3);
                unsubscribe();
            }
        }
    }

    public n3(rx.functions.p<? super T, Boolean> pVar) {
        this.f63011a = pVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar);
        lVar.add(bVar);
        lVar.setProducer(new a(bVar));
        return bVar;
    }
}
