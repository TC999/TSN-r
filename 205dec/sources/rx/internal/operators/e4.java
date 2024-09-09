package rx.internal.operators;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorWithLatestFromMany.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class e4<T, R> implements e.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f62550a;

    /* renamed from: b  reason: collision with root package name */
    final rx.e<?>[] f62551b;

    /* renamed from: c  reason: collision with root package name */
    final Iterable<rx.e<?>> f62552c;

    /* renamed from: d  reason: collision with root package name */
    final rx.functions.y<R> f62553d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWithLatestFromMany.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, R> extends rx.l<T> {

        /* renamed from: f  reason: collision with root package name */
        static final Object f62554f = new Object();

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super R> f62555a;

        /* renamed from: b  reason: collision with root package name */
        final rx.functions.y<R> f62556b;

        /* renamed from: c  reason: collision with root package name */
        final AtomicReferenceArray<Object> f62557c;

        /* renamed from: d  reason: collision with root package name */
        final AtomicInteger f62558d;

        /* renamed from: e  reason: collision with root package name */
        boolean f62559e;

        public a(rx.l<? super R> lVar, rx.functions.y<R> yVar, int i4) {
            this.f62555a = lVar;
            this.f62556b = yVar;
            AtomicReferenceArray<Object> atomicReferenceArray = new AtomicReferenceArray<>(i4 + 1);
            for (int i5 = 0; i5 <= i4; i5++) {
                atomicReferenceArray.lazySet(i5, f62554f);
            }
            this.f62557c = atomicReferenceArray;
            this.f62558d = new AtomicInteger(i4);
            request(0L);
        }

        void g(int i4) {
            if (this.f62557c.get(i4) == f62554f) {
                onCompleted();
            }
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f62559e) {
                return;
            }
            this.f62559e = true;
            unsubscribe();
            this.f62555a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            if (this.f62559e) {
                rx.plugins.c.I(th);
                return;
            }
            this.f62559e = true;
            unsubscribe();
            this.f62555a.onError(th);
        }

        @Override // rx.f
        public void onNext(T t3) {
            if (this.f62559e) {
                return;
            }
            if (this.f62558d.get() == 0) {
                AtomicReferenceArray<Object> atomicReferenceArray = this.f62557c;
                int length = atomicReferenceArray.length();
                atomicReferenceArray.lazySet(0, t3);
                Object[] objArr = new Object[atomicReferenceArray.length()];
                for (int i4 = 0; i4 < length; i4++) {
                    objArr[i4] = atomicReferenceArray.get(i4);
                }
                try {
                    this.f62555a.onNext(this.f62556b.call(objArr));
                    return;
                } catch (Throwable th) {
                    rx.exceptions.a.e(th);
                    onError(th);
                    return;
                }
            }
            request(1L);
        }

        @Override // rx.l, rx.observers.a
        public void setProducer(rx.g gVar) {
            super.setProducer(gVar);
            this.f62555a.setProducer(gVar);
        }

        void v(int i4, Throwable th) {
            onError(th);
        }

        void x(int i4, Object obj) {
            if (this.f62557c.getAndSet(i4, obj) == f62554f) {
                this.f62558d.decrementAndGet();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWithLatestFromMany.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b extends rx.l<Object> {

        /* renamed from: a  reason: collision with root package name */
        final a<?, ?> f62560a;

        /* renamed from: b  reason: collision with root package name */
        final int f62561b;

        public b(a<?, ?> aVar, int i4) {
            this.f62560a = aVar;
            this.f62561b = i4;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62560a.g(this.f62561b);
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62560a.v(this.f62561b, th);
        }

        @Override // rx.f
        public void onNext(Object obj) {
            this.f62560a.x(this.f62561b, obj);
        }
    }

    public e4(rx.e<T> eVar, rx.e<?>[] eVarArr, Iterable<rx.e<?>> iterable, rx.functions.y<R> yVar) {
        this.f62550a = eVar;
        this.f62551b = eVarArr;
        this.f62552c = iterable;
        this.f62553d = yVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super R> lVar) {
        int i4;
        rx.observers.g gVar = new rx.observers.g(lVar);
        rx.e<?>[] eVarArr = this.f62551b;
        int i5 = 0;
        if (eVarArr != null) {
            i4 = eVarArr.length;
        } else {
            eVarArr = new rx.e[8];
            int i6 = 0;
            for (rx.e<?> eVar : this.f62552c) {
                if (i6 == eVarArr.length) {
                    eVarArr = (rx.e[]) Arrays.copyOf(eVarArr, (i6 >> 2) + i6);
                }
                eVarArr[i6] = eVar;
                i6++;
            }
            i4 = i6;
        }
        a aVar = new a(lVar, this.f62553d, i4);
        gVar.add(aVar);
        while (i5 < i4) {
            if (gVar.isUnsubscribed()) {
                return;
            }
            int i7 = i5 + 1;
            b bVar = new b(aVar, i7);
            aVar.add(bVar);
            eVarArr[i5].I6(bVar);
            i5 = i7;
        }
        this.f62550a.I6(aVar);
    }
}
