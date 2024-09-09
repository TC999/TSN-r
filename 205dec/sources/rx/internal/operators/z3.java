package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorWindowWithObservableFactory.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class z3<T, U> implements e.b<rx.e<T>, T> {

    /* renamed from: b  reason: collision with root package name */
    static final Object f63703b = new Object();

    /* renamed from: a  reason: collision with root package name */
    final rx.functions.o<? extends rx.e<? extends U>> f63704a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithObservableFactory.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, U> extends rx.l<U> {

        /* renamed from: a  reason: collision with root package name */
        final b<T, U> f63705a;

        /* renamed from: b  reason: collision with root package name */
        boolean f63706b;

        public a(b<T, U> bVar) {
            this.f63705a = bVar;
        }

        @Override // rx.f
        public void onCompleted() {
            if (this.f63706b) {
                return;
            }
            this.f63706b = true;
            this.f63705a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63705a.onError(th);
        }

        @Override // rx.f
        public void onNext(U u3) {
            if (this.f63706b) {
                return;
            }
            this.f63706b = true;
            this.f63705a.M();
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
    /* compiled from: OperatorWindowWithObservableFactory.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T, U> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super rx.e<T>> f63707a;

        /* renamed from: b  reason: collision with root package name */
        final Object f63708b = new Object();

        /* renamed from: c  reason: collision with root package name */
        rx.f<T> f63709c;

        /* renamed from: d  reason: collision with root package name */
        rx.e<T> f63710d;

        /* renamed from: e  reason: collision with root package name */
        boolean f63711e;

        /* renamed from: f  reason: collision with root package name */
        List<Object> f63712f;

        /* renamed from: g  reason: collision with root package name */
        final rx.subscriptions.e f63713g;

        /* renamed from: h  reason: collision with root package name */
        final rx.functions.o<? extends rx.e<? extends U>> f63714h;

        public b(rx.l<? super rx.e<T>> lVar, rx.functions.o<? extends rx.e<? extends U>> oVar) {
            this.f63707a = new rx.observers.g(lVar);
            rx.subscriptions.e eVar = new rx.subscriptions.e();
            this.f63713g = eVar;
            this.f63714h = oVar;
            add(eVar);
        }

        void I(T t3) {
            rx.f<T> fVar = this.f63709c;
            if (fVar != null) {
                fVar.onNext(t3);
            }
        }

        void J(Throwable th) {
            rx.f<T> fVar = this.f63709c;
            this.f63709c = null;
            this.f63710d = null;
            if (fVar != null) {
                fVar.onError(th);
            }
            this.f63707a.onError(th);
            unsubscribe();
        }

        void L() {
            rx.f<T> fVar = this.f63709c;
            if (fVar != null) {
                fVar.onCompleted();
            }
            v();
            this.f63707a.onNext(this.f63710d);
        }

        void M() {
            synchronized (this.f63708b) {
                if (this.f63711e) {
                    if (this.f63712f == null) {
                        this.f63712f = new ArrayList();
                    }
                    this.f63712f.add(z3.f63703b);
                    return;
                }
                List<Object> list = this.f63712f;
                this.f63712f = null;
                boolean z3 = true;
                this.f63711e = true;
                boolean z4 = true;
                while (true) {
                    try {
                        x(list);
                        if (z4) {
                            L();
                            z4 = false;
                        }
                        try {
                            synchronized (this.f63708b) {
                                try {
                                    List<Object> list2 = this.f63712f;
                                    this.f63712f = null;
                                    if (list2 == null) {
                                        this.f63711e = false;
                                        return;
                                    } else if (this.f63707a.isUnsubscribed()) {
                                        synchronized (this.f63708b) {
                                            this.f63711e = false;
                                        }
                                        return;
                                    } else {
                                        list = list2;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z3 = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (!z3) {
                                            synchronized (this.f63708b) {
                                                this.f63711e = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z3 = false;
                    }
                }
            }
        }

        void g() {
            rx.f<T> fVar = this.f63709c;
            this.f63709c = null;
            this.f63710d = null;
            if (fVar != null) {
                fVar.onCompleted();
            }
            this.f63707a.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onCompleted() {
            synchronized (this.f63708b) {
                if (this.f63711e) {
                    if (this.f63712f == null) {
                        this.f63712f = new ArrayList();
                    }
                    this.f63712f.add(v.b());
                    return;
                }
                List<Object> list = this.f63712f;
                this.f63712f = null;
                this.f63711e = true;
                try {
                    x(list);
                    g();
                } catch (Throwable th) {
                    J(th);
                }
            }
        }

        @Override // rx.f
        public void onError(Throwable th) {
            synchronized (this.f63708b) {
                if (this.f63711e) {
                    this.f63712f = Collections.singletonList(v.c(th));
                    return;
                }
                this.f63712f = null;
                this.f63711e = true;
                J(th);
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            synchronized (this.f63708b) {
                if (this.f63711e) {
                    if (this.f63712f == null) {
                        this.f63712f = new ArrayList();
                    }
                    this.f63712f.add(t3);
                    return;
                }
                List<Object> list = this.f63712f;
                this.f63712f = null;
                boolean z3 = true;
                this.f63711e = true;
                boolean z4 = true;
                while (true) {
                    try {
                        x(list);
                        if (z4) {
                            I(t3);
                            z4 = false;
                        }
                        try {
                            synchronized (this.f63708b) {
                                try {
                                    List<Object> list2 = this.f63712f;
                                    this.f63712f = null;
                                    if (list2 == null) {
                                        this.f63711e = false;
                                        return;
                                    } else if (this.f63707a.isUnsubscribed()) {
                                        synchronized (this.f63708b) {
                                            this.f63711e = false;
                                        }
                                        return;
                                    } else {
                                        list = list2;
                                    }
                                } catch (Throwable th) {
                                    th = th;
                                    z3 = false;
                                    try {
                                        throw th;
                                    } catch (Throwable th2) {
                                        th = th2;
                                        if (!z3) {
                                            synchronized (this.f63708b) {
                                                this.f63711e = false;
                                            }
                                        }
                                        throw th;
                                    }
                                }
                            }
                        } catch (Throwable th3) {
                            th = th3;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z3 = false;
                    }
                }
            }
        }

        @Override // rx.l
        public void onStart() {
            request(Long.MAX_VALUE);
        }

        void v() {
            rx.subjects.i x7 = rx.subjects.i.x7();
            this.f63709c = x7;
            this.f63710d = x7;
            try {
                rx.e<? extends U> call = this.f63714h.call();
                a aVar = new a(this);
                this.f63713g.b(aVar);
                call.I6(aVar);
            } catch (Throwable th) {
                this.f63707a.onError(th);
                unsubscribe();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        void x(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (obj == z3.f63703b) {
                    L();
                } else if (v.g(obj)) {
                    J(v.d(obj));
                    return;
                } else if (v.f(obj)) {
                    g();
                    return;
                } else {
                    I(obj);
                }
            }
        }
    }

    public z3(rx.functions.o<? extends rx.e<? extends U>> oVar) {
        this.f63704a = oVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super rx.e<T>> lVar) {
        b bVar = new b(lVar, this.f63704a);
        lVar.add(bVar);
        bVar.M();
        return bVar;
    }
}
