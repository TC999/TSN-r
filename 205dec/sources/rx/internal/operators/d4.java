package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorWithLatestFrom.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class d4<T, U, R> implements e.b<R, T> {

    /* renamed from: c  reason: collision with root package name */
    static final Object f62503c = new Object();

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.q<? super T, ? super U, ? extends R> f62504a;

    /* renamed from: b  reason: collision with root package name */
    final rx.e<? extends U> f62505b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWithLatestFrom.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicReference f62506a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.observers.g f62507b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        a(rx.l lVar, boolean z3, AtomicReference atomicReference, rx.observers.g gVar) {
            super(lVar, z3);
            this.f62506a = atomicReference;
            this.f62507b = gVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62507b.onCompleted();
            this.f62507b.unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62507b.onError(th);
            this.f62507b.unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t3) {
            Object obj = this.f62506a.get();
            if (obj != d4.f62503c) {
                try {
                    this.f62507b.onNext(d4.this.f62504a.call(t3, obj));
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWithLatestFrom.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.l<U> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicReference f62509a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.observers.g f62510b;

        b(AtomicReference atomicReference, rx.observers.g gVar) {
            this.f62509a = atomicReference;
            this.f62510b = gVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62509a.get() == d4.f62503c) {
                this.f62510b.onCompleted();
                this.f62510b.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62510b.onError(th);
            this.f62510b.unsubscribe();
        }

        @Override // rx.f
        public void onNext(U u3) {
            this.f62509a.set(u3);
        }
    }

    public d4(rx.e<? extends U> eVar, rx.functions.q<? super T, ? super U, ? extends R> qVar) {
        this.f62505b = eVar;
        this.f62504a = qVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super R> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar, false);
        lVar.add(gVar);
        AtomicReference atomicReference = new AtomicReference(f62503c);
        a aVar = new a(gVar, true, atomicReference, gVar);
        b bVar = new b(atomicReference, gVar);
        gVar.add(aVar);
        gVar.add(bVar);
        this.f62505b.I6(bVar);
        return aVar;
    }
}
