package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSkipUntil.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e3<T, U> implements e.b<T, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<U> f62543a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSkipUntil.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<U> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f62544a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.observers.g f62545b;

        a(AtomicBoolean atomicBoolean, rx.observers.g gVar) {
            this.f62544a = atomicBoolean;
            this.f62545b = gVar;
        }

        @Override // rx.f
        public void onCompleted() {
            unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62545b.onError(th);
            this.f62545b.unsubscribe();
        }

        @Override // rx.f
        public void onNext(U u3) {
            this.f62544a.set(true);
            unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSkipUntil.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f62547a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.observers.g f62548b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(rx.l lVar, AtomicBoolean atomicBoolean, rx.observers.g gVar) {
            super(lVar);
            this.f62547a = atomicBoolean;
            this.f62548b = gVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62548b.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62548b.onError(th);
            unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62547a.get()) {
                this.f62548b.onNext(t3);
            } else {
                request(1L);
            }
        }
    }

    public e3(rx.e<U> eVar) {
        this.f62543a = eVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar);
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        a aVar = new a(atomicBoolean, gVar);
        lVar.add(aVar);
        this.f62543a.I6(aVar);
        return new b(lVar, atomicBoolean, gVar);
    }
}
