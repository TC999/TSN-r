package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorDelay.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v1<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final long f63448a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f63449b;

    /* renamed from: c  reason: collision with root package name */
    final rx.h f63450c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDelay.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        boolean f63451a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h.a f63452b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.l f63453c;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorDelay.java */
        /* renamed from: rx.internal.operators.v1$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class C1302a implements rx.functions.a {
            C1302a() {
            }

            @Override // rx.functions.a
            public void call() {
                a aVar = a.this;
                if (aVar.f63451a) {
                    return;
                }
                aVar.f63451a = true;
                aVar.f63453c.onCompleted();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorDelay.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class b implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Throwable f63456a;

            b(Throwable th) {
                this.f63456a = th;
            }

            @Override // rx.functions.a
            public void call() {
                a aVar = a.this;
                if (aVar.f63451a) {
                    return;
                }
                aVar.f63451a = true;
                aVar.f63453c.onError(this.f63456a);
                a.this.f63452b.unsubscribe();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorDelay.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class c implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ Object f63458a;

            c(Object obj) {
                this.f63458a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.functions.a
            public void call() {
                a aVar = a.this;
                if (aVar.f63451a) {
                    return;
                }
                aVar.f63453c.onNext(this.f63458a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, h.a aVar, rx.l lVar2) {
            super(lVar);
            this.f63452b = aVar;
            this.f63453c = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            h.a aVar = this.f63452b;
            C1302a c1302a = new C1302a();
            v1 v1Var = v1.this;
            aVar.e(c1302a, v1Var.f63448a, v1Var.f63449b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63452b.c(new b(th));
        }

        @Override // rx.f
        public void onNext(T t3) {
            h.a aVar = this.f63452b;
            c cVar = new c(t3);
            v1 v1Var = v1.this;
            aVar.e(cVar, v1Var.f63448a, v1Var.f63449b);
        }
    }

    public v1(long j4, TimeUnit timeUnit, rx.h hVar) {
        this.f63448a = j4;
        this.f63449b = timeUnit;
        this.f63450c = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        h.a a4 = this.f63450c.a();
        lVar.add(a4);
        return new a(lVar, a4, lVar);
    }
}
