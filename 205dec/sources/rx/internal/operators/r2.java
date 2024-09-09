package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorOnErrorResumeNextViaFunction.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class r2<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.p<? super Throwable, ? extends rx.e<? extends T>> f63217a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a implements rx.functions.p<Throwable, rx.e<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.p f63218a;

        a(rx.functions.p pVar) {
            this.f63218a = pVar;
        }

        @Override // rx.functions.p
        public rx.e<? extends T> call(Throwable th) {
            return rx.e.L2(this.f63218a.call(th));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class b implements rx.functions.p<Throwable, rx.e<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.e f63219a;

        b(rx.e eVar) {
            this.f63219a = eVar;
        }

        @Override // rx.functions.p
        public rx.e<? extends T> call(Throwable th) {
            return this.f63219a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class c implements rx.functions.p<Throwable, rx.e<? extends T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.e f63220a;

        c(rx.e eVar) {
            this.f63220a = eVar;
        }

        @Override // rx.functions.p
        public rx.e<? extends T> call(Throwable th) {
            if (th instanceof Exception) {
                return this.f63220a;
            }
            return rx.e.T1(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class d extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        private boolean f63221a;

        /* renamed from: b  reason: collision with root package name */
        long f63222b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.l f63223c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ rx.internal.producers.a f63224d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f63225e;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorOnErrorResumeNextViaFunction.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class a extends rx.l<T> {
            a() {
            }

            @Override // rx.f
            public void onCompleted() {
                d.this.f63223c.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                d.this.f63223c.onError(th);
            }

            @Override // rx.f
            public void onNext(T t3) {
                d.this.f63223c.onNext(t3);
            }

            @Override // rx.l, rx.observers.a
            public void setProducer(rx.g gVar) {
                d.this.f63224d.c(gVar);
            }
        }

        d(rx.l lVar, rx.internal.producers.a aVar, rx.subscriptions.e eVar) {
            this.f63223c = lVar;
            this.f63224d = aVar;
            this.f63225e = eVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63221a) {
                return;
            }
            this.f63221a = true;
            this.f63223c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f63221a) {
                rx.exceptions.a.e(th);
                rx.plugins.c.I(th);
                return;
            }
            this.f63221a = true;
            try {
                unsubscribe();
                a aVar = new a();
                this.f63225e.b(aVar);
                long j4 = this.f63222b;
                if (j4 != 0) {
                    this.f63224d.b(j4);
                }
                r2.this.f63217a.call(th).I6(aVar);
            } catch (Throwable th2) {
                rx.exceptions.a.f(th2, this.f63223c);
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f63221a) {
                return;
            }
            this.f63222b++;
            this.f63223c.onNext(t3);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            this.f63224d.c(gVar);
        }
    }

    public r2(rx.functions.p<? super Throwable, ? extends rx.e<? extends T>> pVar) {
        this.f63217a = pVar;
    }

    public static <T> r2<T> a(rx.e<? extends T> eVar) {
        return new r2<>(new c(eVar));
    }

    public static <T> r2<T> b(rx.e<? extends T> eVar) {
        return new r2<>(new b(eVar));
    }

    public static <T> r2<T> c(rx.functions.p<? super Throwable, ? extends T> pVar) {
        return new r2<>(new a(pVar));
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        d dVar = new d(lVar, aVar, eVar);
        eVar.b(dVar);
        lVar.add(eVar);
        lVar.setProducer(aVar);
        return dVar;
    }
}
