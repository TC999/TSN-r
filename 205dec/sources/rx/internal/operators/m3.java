package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTakeUntil.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m3<T, E> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    private final rx.e<? extends E> f62973a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTakeUntil.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f62974a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, boolean z3, rx.l lVar2) {
            super(lVar, z3);
            this.f62974a = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                this.f62974a.onCompleted();
            } finally {
                this.f62974a.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                this.f62974a.onError(th);
            } finally {
                this.f62974a.unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f62974a.onNext(t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTakeUntil.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.l<E> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f62976a;

        b(rx.l lVar) {
            this.f62976a = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62976a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62976a.onError(th);
        }

        @Override // rx.f
        public void onNext(E e4) {
            onCompleted();
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public m3(rx.e<? extends E> eVar) {
        this.f62973a = eVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar, false);
        a aVar = new a(gVar, false, gVar);
        b bVar = new b(aVar);
        gVar.add(aVar);
        gVar.add(bVar);
        lVar.add(gVar);
        this.f62973a.I6(bVar);
        return aVar;
    }
}
