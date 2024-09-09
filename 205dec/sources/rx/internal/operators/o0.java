package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeGroupJoin.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class o0<T1, T2, D1, D2, R> implements e.a<R> {

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T1> f63026a;

    /* renamed from: b  reason: collision with root package name */
    final rx.e<T2> f63027b;

    /* renamed from: c  reason: collision with root package name */
    final rx.functions.p<? super T1, ? extends rx.e<D1>> f63028c;

    /* renamed from: d  reason: collision with root package name */
    final rx.functions.p<? super T2, ? extends rx.e<D2>> f63029d;

    /* renamed from: e  reason: collision with root package name */
    final rx.functions.q<? super T1, ? super rx.e<T2>, ? extends R> f63030e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeGroupJoin.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public final class a extends HashMap<Integer, rx.f<T2>> implements rx.m {
        private static final long serialVersionUID = -3035156013812425335L;

        /* renamed from: a  reason: collision with root package name */
        final rx.subscriptions.d f63031a;

        /* renamed from: b  reason: collision with root package name */
        final rx.l<? super R> f63032b;

        /* renamed from: c  reason: collision with root package name */
        final rx.subscriptions.b f63033c;

        /* renamed from: d  reason: collision with root package name */
        int f63034d;

        /* renamed from: e  reason: collision with root package name */
        int f63035e;

        /* renamed from: f  reason: collision with root package name */
        final Map<Integer, T2> f63036f = new HashMap();

        /* renamed from: g  reason: collision with root package name */
        boolean f63037g;

        /* renamed from: h  reason: collision with root package name */
        boolean f63038h;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeGroupJoin.java */
        /* renamed from: rx.internal.operators.o0$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class C1288a extends rx.l<D1> {

            /* renamed from: a  reason: collision with root package name */
            final int f63040a;

            /* renamed from: b  reason: collision with root package name */
            boolean f63041b = true;

            public C1288a(int i4) {
                this.f63040a = i4;
            }

            @Override // rx.f
            public void onCompleted() {
                rx.f<T2> remove;
                if (this.f63041b) {
                    this.f63041b = false;
                    synchronized (a.this) {
                        remove = a.this.x().remove(Integer.valueOf(this.f63040a));
                    }
                    if (remove != null) {
                        remove.onCompleted();
                    }
                    a.this.f63033c.g(this);
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.c(th);
            }

            @Override // rx.f
            public void onNext(D1 d12) {
                onCompleted();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeGroupJoin.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class b extends rx.l<T1> {
            b() {
            }

            @Override // rx.f
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (a.this) {
                    a aVar = a.this;
                    aVar.f63037g = true;
                    if (aVar.f63038h) {
                        arrayList = new ArrayList(a.this.x().values());
                        a.this.x().clear();
                        a.this.f63036f.clear();
                    } else {
                        arrayList = null;
                    }
                }
                a.this.a(arrayList);
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.b(th);
            }

            @Override // rx.f
            public void onNext(T1 t12) {
                int i4;
                ArrayList<Object> arrayList;
                try {
                    rx.subjects.c x7 = rx.subjects.c.x7();
                    rx.observers.f fVar = new rx.observers.f(x7);
                    synchronized (a.this) {
                        a aVar = a.this;
                        i4 = aVar.f63034d;
                        aVar.f63034d = i4 + 1;
                        aVar.x().put(Integer.valueOf(i4), fVar);
                    }
                    rx.e H6 = rx.e.H6(new b(x7, a.this.f63031a));
                    C1288a c1288a = new C1288a(i4);
                    a.this.f63033c.a(c1288a);
                    o0.this.f63028c.call(t12).I6(c1288a);
                    R call = o0.this.f63030e.call(t12, H6);
                    synchronized (a.this) {
                        arrayList = new ArrayList(a.this.f63036f.values());
                    }
                    a.this.f63032b.onNext(call);
                    for (Object obj : arrayList) {
                        fVar.onNext(obj);
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeGroupJoin.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        final class c extends rx.l<D2> {

            /* renamed from: a  reason: collision with root package name */
            final int f63044a;

            /* renamed from: b  reason: collision with root package name */
            boolean f63045b = true;

            public c(int i4) {
                this.f63044a = i4;
            }

            @Override // rx.f
            public void onCompleted() {
                if (this.f63045b) {
                    this.f63045b = false;
                    synchronized (a.this) {
                        a.this.f63036f.remove(Integer.valueOf(this.f63044a));
                    }
                    a.this.f63033c.g(this);
                }
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.c(th);
            }

            @Override // rx.f
            public void onNext(D2 d22) {
                onCompleted();
            }
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeGroupJoin.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class d extends rx.l<T2> {
            d() {
            }

            @Override // rx.f
            public void onCompleted() {
                ArrayList arrayList;
                synchronized (a.this) {
                    a aVar = a.this;
                    aVar.f63038h = true;
                    if (aVar.f63037g) {
                        arrayList = new ArrayList(a.this.x().values());
                        a.this.x().clear();
                        a.this.f63036f.clear();
                    } else {
                        arrayList = null;
                    }
                }
                a.this.a(arrayList);
            }

            @Override // rx.f
            public void onError(Throwable th) {
                a.this.b(th);
            }

            @Override // rx.f
            public void onNext(T2 t22) {
                int i4;
                ArrayList<rx.f> arrayList;
                try {
                    synchronized (a.this) {
                        a aVar = a.this;
                        i4 = aVar.f63035e;
                        aVar.f63035e = i4 + 1;
                        aVar.f63036f.put(Integer.valueOf(i4), t22);
                    }
                    c cVar = new c(i4);
                    a.this.f63033c.a(cVar);
                    o0.this.f63029d.call(t22).I6(cVar);
                    synchronized (a.this) {
                        arrayList = new ArrayList(a.this.x().values());
                    }
                    for (rx.f fVar : arrayList) {
                        fVar.onNext(t22);
                    }
                } catch (Throwable th) {
                    rx.exceptions.a.f(th, this);
                }
            }
        }

        public a(rx.l<? super R> lVar) {
            this.f63032b = lVar;
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            this.f63033c = bVar;
            this.f63031a = new rx.subscriptions.d(bVar);
        }

        void a(List<rx.f<T2>> list) {
            if (list != null) {
                for (rx.f<T2> fVar : list) {
                    fVar.onCompleted();
                }
                this.f63032b.onCompleted();
                this.f63031a.unsubscribe();
            }
        }

        void b(Throwable th) {
            ArrayList<rx.f> arrayList;
            synchronized (this) {
                arrayList = new ArrayList(x().values());
                x().clear();
                this.f63036f.clear();
            }
            for (rx.f fVar : arrayList) {
                fVar.onError(th);
            }
            this.f63032b.onError(th);
            this.f63031a.unsubscribe();
        }

        void c(Throwable th) {
            synchronized (this) {
                x().clear();
                this.f63036f.clear();
            }
            this.f63032b.onError(th);
            this.f63031a.unsubscribe();
        }

        public void e() {
            b bVar = new b();
            d dVar = new d();
            this.f63033c.a(bVar);
            this.f63033c.a(dVar);
            o0.this.f63026a.I6(bVar);
            o0.this.f63027b.I6(dVar);
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f63031a.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f63031a.unsubscribe();
        }

        Map<Integer, rx.f<T2>> x() {
            return this;
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeGroupJoin.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static final class b<T> implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.subscriptions.d f63048a;

        /* renamed from: b  reason: collision with root package name */
        final rx.e<T> f63049b;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeGroupJoin.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public final class a extends rx.l<T> {

            /* renamed from: a  reason: collision with root package name */
            final rx.l<? super T> f63050a;

            /* renamed from: b  reason: collision with root package name */
            private final rx.m f63051b;

            public a(rx.l<? super T> lVar, rx.m mVar) {
                super(lVar);
                this.f63050a = lVar;
                this.f63051b = mVar;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f63050a.onCompleted();
                this.f63051b.unsubscribe();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f63050a.onError(th);
                this.f63051b.unsubscribe();
            }

            @Override // rx.f
            public void onNext(T t3) {
                this.f63050a.onNext(t3);
            }
        }

        public b(rx.e<T> eVar, rx.subscriptions.d dVar) {
            this.f63048a = dVar;
            this.f63049b = eVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super T> lVar) {
            rx.m a4 = this.f63048a.a();
            a aVar = new a(lVar, a4);
            aVar.add(a4);
            this.f63049b.I6(aVar);
        }
    }

    public o0(rx.e<T1> eVar, rx.e<T2> eVar2, rx.functions.p<? super T1, ? extends rx.e<D1>> pVar, rx.functions.p<? super T2, ? extends rx.e<D2>> pVar2, rx.functions.q<? super T1, ? super rx.e<T2>, ? extends R> qVar) {
        this.f63026a = eVar;
        this.f63027b = eVar2;
        this.f63028c = pVar;
        this.f63029d = pVar2;
        this.f63030e = qVar;
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super R> lVar) {
        a aVar = new a(new rx.observers.g(lVar));
        lVar.add(aVar);
        aVar.e();
    }
}
