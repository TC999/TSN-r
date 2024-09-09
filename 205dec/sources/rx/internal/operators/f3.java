package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSkipWhile.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class f3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.q<? super T, Integer, Boolean> f62585a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSkipWhile.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f62586a;

        /* renamed from: b  reason: collision with root package name */
        int f62587b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.l f62588c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f62588c = lVar2;
            this.f62586a = true;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62588c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62588c.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (!this.f62586a) {
                this.f62588c.onNext(t3);
                return;
            }
            try {
                rx.functions.q<? super T, Integer, Boolean> qVar = f3.this.f62585a;
                int i4 = this.f62587b;
                this.f62587b = i4 + 1;
                if (!qVar.call(t3, Integer.valueOf(i4)).booleanValue()) {
                    this.f62586a = false;
                    this.f62588c.onNext(t3);
                    return;
                }
                request(1L);
            } catch (Throwable th) {
                rx.exceptions.a.g(th, this.f62588c, t3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSkipWhile.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b implements rx.functions.q<T, Integer, Boolean> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.p f62590a;

        b(rx.functions.p pVar) {
            this.f62590a = pVar;
        }

        @Override // rx.functions.q
        public /* bridge */ /* synthetic */ Boolean call(Object obj, Integer num) {
            return call2((b) obj, num);
        }

        /* renamed from: call  reason: avoid collision after fix types in other method */
        public Boolean call2(T t3, Integer num) {
            return (Boolean) this.f62590a.call(t3);
        }
    }

    public f3(rx.functions.q<? super T, Integer, Boolean> qVar) {
        this.f62585a = qVar;
    }

    public static <T> rx.functions.q<T, Integer, Boolean> a(rx.functions.p<? super T, Boolean> pVar) {
        return new b(pVar);
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }
}
