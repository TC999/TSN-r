package rx.internal.operators;

import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorUnsubscribeOn.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class x3<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.h f63596a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorUnsubscribeOn.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f63597a;

        a(rx.l lVar) {
            this.f63597a = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63597a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63597a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f63597a.onNext(t3);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorUnsubscribeOn.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f63599a;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorUnsubscribeOn.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h.a f63601a;

            a(h.a aVar) {
                this.f63601a = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                b.this.f63599a.unsubscribe();
                this.f63601a.unsubscribe();
            }
        }

        b(rx.l lVar) {
            this.f63599a = lVar;
        }

        @Override // rx.functions.a
        public void call() {
            h.a a4 = x3.this.f63596a.a();
            a4.c(new a(a4));
        }
    }

    public x3(rx.h hVar) {
        this.f63596a = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        a aVar = new a(lVar);
        lVar.add(rx.subscriptions.f.a(new b(aVar)));
        return aVar;
    }
}
