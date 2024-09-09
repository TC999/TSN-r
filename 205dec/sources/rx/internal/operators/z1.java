package rx.internal.operators;

import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorDistinctUntilChanged.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z1<T, U> implements e.b<T, T>, rx.functions.q<U, U, Boolean> {

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.p<? super T, ? extends U> f63693a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.q<? super U, ? super U, Boolean> f63694b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDistinctUntilChanged.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        U f63695a;

        /* renamed from: b  reason: collision with root package name */
        boolean f63696b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.l f63697c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f63697c = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63697c.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63697c.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            Object obj;
            try {
                U call = z1.this.f63693a.call(t3);
                U u3 = this.f63695a;
                this.f63695a = call;
                if (this.f63696b) {
                    try {
                        if (!z1.this.f63694b.call(u3, call).booleanValue()) {
                            this.f63697c.onNext(t3);
                            return;
                        } else {
                            request(1L);
                            return;
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.g(th, this.f63697c, obj);
                        return;
                    }
                }
                this.f63696b = true;
                this.f63697c.onNext(t3);
            } catch (Throwable th2) {
                rx.exceptions.a.g(th2, this.f63697c, t3);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDistinctUntilChanged.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        static final z1<?, ?> f63699a = new z1<>(rx.internal.util.n.c());

        b() {
        }
    }

    public z1(rx.functions.p<? super T, ? extends U> pVar) {
        this.f63693a = pVar;
        this.f63694b = this;
    }

    public static <T> z1<T, T> a() {
        return (z1<T, T>) b.f63699a;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // rx.functions.q
    public Boolean call(U u3, U u4) {
        return Boolean.valueOf(u3 == u4 || (u3 != null && u3.equals(u4)));
    }

    public z1(rx.functions.q<? super U, ? super U, Boolean> qVar) {
        this.f63693a = rx.internal.util.n.c();
        this.f63694b = qVar;
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        return new a(lVar, lVar);
    }
}
