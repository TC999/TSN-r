package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorTakeWhile.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.q<? super T, ? super Integer, Boolean> f63074a;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTakeWhile.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements rx.functions.q<T, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.p f63075a;

        a(rx.functions.p pVar) {
            this.f63075a = pVar;
        }

        @Override // rx.functions.q
        public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
            return call2((a) obj, num);
        }

        /* renamed from: call  reason: avoid collision after fix types in other method */
        public Boolean call2(T t3, Integer num) {
            return (Boolean) this.f63075a.call(t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorTakeWhile.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private int f63076a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f63077b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.l f63078c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.l lVar, boolean z3, rx.l lVar2) {
            super(lVar, z3);
            this.f63078c = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63077b) {
                return;
            }
            this.f63078c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63077b) {
                return;
            }
            this.f63078c.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            try {
                rx.functions.q<? super T, ? super Integer, Boolean> qVar = o3.this.f63074a;
                int i4 = this.f63076a;
                this.f63076a = i4 + 1;
                if (qVar.call(t3, Integer.valueOf(i4)).booleanValue()) {
                    this.f63078c.onNext(t3);
                    return;
                }
                this.f63077b = true;
                this.f63078c.onCompleted();
                unsubscribe();
            } catch (Throwable th) {
                this.f63077b = true;
                rx.exceptions.a.g(th, this.f63078c, t3);
                unsubscribe();
            }
        }
    }

    public o3(rx.functions.p<? super T, Boolean> pVar) {
        this(new a(pVar));
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public o3(rx.functions.q<? super T, ? super Integer, Boolean> qVar) {
        this.f63074a = qVar;
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        b bVar = new b(lVar, false, lVar);
        lVar.add(bVar);
        return bVar;
    }
}
