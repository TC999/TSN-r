package rx.internal.operators;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorWindowWithStartEndObservable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class b4<T, U, V> implements e.b<rx.e<T>, T> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<? extends U> f62395a;

    /* renamed from: b  reason: collision with root package name */
    final rx.functions.p<? super U, ? extends rx.e<? extends V>> f62396b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithStartEndObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a extends rx.l<U> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f62397a;

        a(c cVar) {
            this.f62397a = cVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f62397a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f62397a.onError(th);
        }

        @Override // rx.f
        public void onNext(U u3) {
            this.f62397a.g(u3);
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithStartEndObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.f<T> f62399a;

        /* renamed from: b  reason: collision with root package name */
        final rx.e<T> f62400b;

        public b(rx.f<T> fVar, rx.e<T> eVar) {
            this.f62399a = new rx.observers.f(fVar);
            this.f62400b = eVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithStartEndObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class c extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super rx.e<T>> f62401a;

        /* renamed from: b  reason: collision with root package name */
        final rx.subscriptions.b f62402b;

        /* renamed from: c  reason: collision with root package name */
        final Object f62403c = new Object();

        /* renamed from: d  reason: collision with root package name */
        final List<b<T>> f62404d = new LinkedList();

        /* renamed from: e  reason: collision with root package name */
        boolean f62405e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OperatorWindowWithStartEndObservable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a extends rx.l<V> {

            /* renamed from: a  reason: collision with root package name */
            boolean f62407a = true;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ b f62408b;

            a(b bVar) {
                this.f62408b = bVar;
            }

            @Override // rx.f
            public void onCompleted() {
                if (this.f62407a) {
                    this.f62407a = false;
                    c.this.x(this.f62408b);
                    c.this.f62402b.g(this);
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                c.this.onError(th);
            }

            @Override // rx.f
            public void onNext(V v3) {
                onCompleted();
            }
        }

        public c(rx.l<? super rx.e<T>> lVar, rx.subscriptions.b bVar) {
            this.f62401a = new rx.observers.g(lVar);
            this.f62402b = bVar;
        }

        void g(U u3) {
            b<T> v3 = v();
            synchronized (this.f62403c) {
                if (this.f62405e) {
                    return;
                }
                this.f62404d.add(v3);
                this.f62401a.onNext(v3.f62400b);
                try {
                    rx.e<? extends V> call = b4.this.f62396b.call(u3);
                    a aVar = new a(v3);
                    this.f62402b.a(aVar);
                    call.I6(aVar);
                } catch (Throwable th) {
                    onError(th);
                }
            }
        }

        @Override // rx.f
        public void onCompleted() {
            try {
                synchronized (this.f62403c) {
                    if (this.f62405e) {
                        return;
                    }
                    this.f62405e = true;
                    ArrayList<b> arrayList = new ArrayList(this.f62404d);
                    this.f62404d.clear();
                    for (b bVar : arrayList) {
                        bVar.f62399a.onCompleted();
                    }
                    this.f62401a.onCompleted();
                }
            } finally {
                this.f62402b.unsubscribe();
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            try {
                synchronized (this.f62403c) {
                    if (this.f62405e) {
                        return;
                    }
                    this.f62405e = true;
                    ArrayList<b> arrayList = new ArrayList(this.f62404d);
                    this.f62404d.clear();
                    for (b bVar : arrayList) {
                        bVar.f62399a.onError(th);
                    }
                    this.f62401a.onError(th);
                }
            } finally {
                this.f62402b.unsubscribe();
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            synchronized (this.f62403c) {
                if (this.f62405e) {
                    return;
                }
                for (b bVar : new ArrayList(this.f62404d)) {
                    bVar.f62399a.onNext(t3);
                }
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        b<T> v() {
            rx.subjects.i x7 = rx.subjects.i.x7();
            return new b<>(x7, x7);
        }

        void x(b<T> bVar) {
            boolean z3;
            synchronized (this.f62403c) {
                if (this.f62405e) {
                    return;
                }
                Iterator<b<T>> it = this.f62404d.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z3 = false;
                        break;
                    } else if (it.next() == bVar) {
                        z3 = true;
                        it.remove();
                        break;
                    }
                }
                if (z3) {
                    bVar.f62399a.onCompleted();
                }
            }
        }
    }

    public b4(rx.e<? extends U> eVar, rx.functions.p<? super U, ? extends rx.e<? extends V>> pVar) {
        this.f62395a = eVar;
        this.f62396b = pVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super rx.e<T>> lVar) {
        rx.subscriptions.b bVar = new rx.subscriptions.b();
        lVar.add(bVar);
        c cVar = new c(lVar, bVar);
        a aVar = new a(cVar);
        bVar.a(cVar);
        bVar.a(aVar);
        this.f62395a.I6(aVar);
        return cVar;
    }
}
