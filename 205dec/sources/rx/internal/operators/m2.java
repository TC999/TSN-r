package rx.internal.operators;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorMulticast.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class m2<T, R> extends rx.observables.c<R> {

    /* renamed from: b  reason: collision with root package name */
    final rx.e<? extends T> f62959b;

    /* renamed from: c  reason: collision with root package name */
    final Object f62960c;

    /* renamed from: d  reason: collision with root package name */
    final rx.functions.o<? extends rx.subjects.f<? super T, ? extends R>> f62961d;

    /* renamed from: e  reason: collision with root package name */
    final AtomicReference<rx.subjects.f<? super T, ? extends R>> f62962e;

    /* renamed from: f  reason: collision with root package name */
    final List<rx.l<? super R>> f62963f;

    /* renamed from: g  reason: collision with root package name */
    rx.l<T> f62964g;

    /* renamed from: h  reason: collision with root package name */
    rx.m f62965h;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMulticast.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class a implements e.a<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f62966a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ AtomicReference f62967b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ List f62968c;

        a(Object obj, AtomicReference atomicReference, List list) {
            this.f62966a = obj;
            this.f62967b = atomicReference;
            this.f62968c = list;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super R> lVar) {
            synchronized (this.f62966a) {
                if (this.f62967b.get() == null) {
                    this.f62968c.add(lVar);
                } else {
                    ((rx.subjects.f) this.f62967b.get()).I6(lVar);
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMulticast.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class b implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicReference f62969a;

        b(AtomicReference atomicReference) {
            this.f62969a = atomicReference;
        }

        @Override // rx.functions.a
        public void call() {
            synchronized (m2.this.f62960c) {
                if (m2.this.f62965h == this.f62969a.get()) {
                    m2 m2Var = m2.this;
                    rx.l<T> lVar = m2Var.f62964g;
                    m2Var.f62964g = null;
                    m2Var.f62965h = null;
                    m2Var.f62962e.set(null);
                    if (lVar != null) {
                        lVar.unsubscribe();
                    }
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorMulticast.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class c extends rx.l<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f62971a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        c(rx.l lVar, rx.l lVar2) {
            super(lVar);
            this.f62971a = lVar2;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62971a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62971a.onError(th);
        }

        @Override // rx.f
        public void onNext(R r3) {
            this.f62971a.onNext(r3);
        }
    }

    public m2(rx.e<? extends T> eVar, rx.functions.o<? extends rx.subjects.f<? super T, ? extends R>> oVar) {
        this(new Object(), new AtomicReference(), new ArrayList(), eVar, oVar);
    }

    @Override // rx.observables.c
    public void z7(rx.functions.b<? super rx.m> bVar) {
        rx.l<T> lVar;
        synchronized (this.f62960c) {
            if (this.f62964g != null) {
                bVar.call(this.f62965h);
                return;
            }
            rx.subjects.f<? super T, ? extends R> call = this.f62961d.call();
            this.f62964g = rx.observers.h.e(call);
            AtomicReference atomicReference = new AtomicReference();
            atomicReference.set(rx.subscriptions.f.a(new b(atomicReference)));
            this.f62965h = (rx.m) atomicReference.get();
            for (rx.l<? super R> lVar2 : this.f62963f) {
                call.I6(new c(lVar2, lVar2));
            }
            this.f62963f.clear();
            this.f62962e.set(call);
            bVar.call(this.f62965h);
            synchronized (this.f62960c) {
                lVar = this.f62964g;
            }
            if (lVar != null) {
                this.f62959b.q5(lVar);
            }
        }
    }

    private m2(Object obj, AtomicReference<rx.subjects.f<? super T, ? extends R>> atomicReference, List<rx.l<? super R>> list, rx.e<? extends T> eVar, rx.functions.o<? extends rx.subjects.f<? super T, ? extends R>> oVar) {
        super(new a(obj, atomicReference, list));
        this.f62960c = obj;
        this.f62962e = atomicReference;
        this.f62963f = list;
        this.f62959b = eVar;
        this.f62961d = oVar;
    }
}
