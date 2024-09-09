package rx.internal.operators;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorDebounceWithTime.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class u1<T> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final long f63404a;

    /* renamed from: b  reason: collision with root package name */
    final TimeUnit f63405b;

    /* renamed from: c  reason: collision with root package name */
    final rx.h f63406c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDebounceWithTime.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final b<T> f63407a;

        /* renamed from: b  reason: collision with root package name */
        final rx.l<?> f63408b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f63409c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h.a f63410d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ rx.observers.g f63411e;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorDebounceWithTime.java */
        /* renamed from: rx.internal.operators.u1$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class C1299a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ int f63413a;

            C1299a(int i4) {
                this.f63413a = i4;
            }

            @Override // rx.functions.a
            public void call() {
                a aVar = a.this;
                aVar.f63407a.b(this.f63413a, aVar.f63411e, aVar.f63408b);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, rx.subscriptions.e eVar, h.a aVar, rx.observers.g gVar) {
            super(lVar);
            this.f63409c = eVar;
            this.f63410d = aVar;
            this.f63411e = gVar;
            this.f63407a = new b<>();
            this.f63408b = this;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63407a.c(this.f63411e, this);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63411e.onError(th);
            unsubscribe();
            this.f63407a.a();
        }

        @Override // rx.f
        public void onNext(T t3) {
            int d4 = this.f63407a.d(t3);
            rx.subscriptions.e eVar = this.f63409c;
            h.a aVar = this.f63410d;
            C1299a c1299a = new C1299a(d4);
            u1 u1Var = u1.this;
            eVar.b(aVar.e(c1299a, u1Var.f63404a, u1Var.f63405b));
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorDebounceWithTime.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        int f63415a;

        /* renamed from: b  reason: collision with root package name */
        T f63416b;

        /* renamed from: c  reason: collision with root package name */
        boolean f63417c;

        /* renamed from: d  reason: collision with root package name */
        boolean f63418d;

        /* renamed from: e  reason: collision with root package name */
        boolean f63419e;

        public synchronized void a() {
            this.f63415a++;
            this.f63416b = null;
            this.f63417c = false;
        }

        public void b(int i4, rx.l<T> lVar, rx.l<?> lVar2) {
            synchronized (this) {
                if (!this.f63419e && this.f63417c && i4 == this.f63415a) {
                    T t3 = this.f63416b;
                    this.f63416b = null;
                    this.f63417c = false;
                    this.f63419e = true;
                    try {
                        lVar.onNext(t3);
                        synchronized (this) {
                            if (!this.f63418d) {
                                this.f63419e = false;
                            } else {
                                lVar.onCompleted();
                            }
                        }
                    } catch (Throwable th) {
                        rx.exceptions.a.g(th, lVar2, t3);
                    }
                }
            }
        }

        public void c(rx.l<T> lVar, rx.l<?> lVar2) {
            synchronized (this) {
                if (this.f63419e) {
                    this.f63418d = true;
                    return;
                }
                T t3 = this.f63416b;
                boolean z3 = this.f63417c;
                this.f63416b = null;
                this.f63417c = false;
                this.f63419e = true;
                if (z3) {
                    try {
                        lVar.onNext(t3);
                    } catch (Throwable th) {
                        rx.exceptions.a.g(th, lVar2, t3);
                        return;
                    }
                }
                lVar.onCompleted();
            }
        }

        public synchronized int d(T t3) {
            int i4;
            this.f63416b = t3;
            this.f63417c = true;
            i4 = this.f63415a + 1;
            this.f63415a = i4;
            return i4;
        }
    }

    public u1(long j4, TimeUnit timeUnit, rx.h hVar) {
        this.f63404a = j4;
        this.f63405b = timeUnit;
        this.f63406c = hVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        h.a a4 = this.f63406c.a();
        rx.observers.g gVar = new rx.observers.g(lVar);
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        gVar.add(a4);
        gVar.add(eVar);
        return new a(lVar, eVar, a4, gVar);
    }
}
