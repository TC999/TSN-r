package rx.internal.operators;

import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorSampleWithObservable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class v2<T, U> implements e.b<T, T> {

    /* renamed from: b  reason: collision with root package name */
    static final Object f63460b = new Object();

    /* renamed from: a  reason: collision with root package name */
    final rx.e<U> f63461a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSampleWithObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<U> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicReference f63462a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.observers.g f63463b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicReference f63464c;

        a(AtomicReference atomicReference, rx.observers.g gVar, AtomicReference atomicReference2) {
            this.f63462a = atomicReference;
            this.f63463b = gVar;
            this.f63464c = atomicReference2;
        }

        @Override // rx.f
        public void onCompleted() {
            onNext(null);
            this.f63463b.onCompleted();
            ((rx.m) this.f63464c.get()).unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63463b.onError(th);
            ((rx.m) this.f63464c.get()).unsubscribe();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.f
        public void onNext(U u3) {
            AtomicReference atomicReference = this.f63462a;
            Object obj = v2.f63460b;
            Object andSet = atomicReference.getAndSet(obj);
            if (andSet != obj) {
                this.f63463b.onNext(andSet);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorSampleWithObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicReference f63466a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.observers.g f63467b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.l f63468c;

        b(AtomicReference atomicReference, rx.observers.g gVar, rx.l lVar) {
            this.f63466a = atomicReference;
            this.f63467b = gVar;
            this.f63468c = lVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63468c.onNext(null);
            this.f63467b.onCompleted();
            this.f63468c.unsubscribe();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63467b.onError(th);
            this.f63468c.unsubscribe();
        }

        @Override // rx.f
        public void onNext(T t3) {
            this.f63466a.set(t3);
        }
    }

    public v2(rx.e<U> eVar) {
        this.f63461a = eVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super T> lVar) {
        rx.observers.g gVar = new rx.observers.g(lVar);
        AtomicReference atomicReference = new AtomicReference(f63460b);
        AtomicReference atomicReference2 = new AtomicReference();
        a aVar = new a(atomicReference, gVar, atomicReference2);
        b bVar = new b(atomicReference, gVar, aVar);
        atomicReference2.lazySet(bVar);
        lVar.add(bVar);
        lVar.add(aVar);
        this.f63461a.I6(aVar);
        return bVar;
    }
}
