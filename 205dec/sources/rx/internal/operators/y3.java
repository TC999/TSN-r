package rx.internal.operators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import rx.e;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OperatorWindowWithObservable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class y3<T, U> implements e.b<rx.e<T>, T> {

    /* renamed from: b  reason: collision with root package name */
    static final Object f63644b = new Object();

    /* renamed from: a  reason: collision with root package name */
    final rx.e<U> f63645a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OperatorWindowWithObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class a<T, U> extends rx.l<U> {

        /* renamed from: a  reason: collision with root package name */
        final b<T> f63646a;

        public a(b<T> bVar) {
            this.f63646a = bVar;
        }

        @Override // rx.f
        public void onCompleted() {
            this.f63646a.onCompleted();
        }

        @Override // rx.f
        public void onError(Throwable th) {
            this.f63646a.onError(th);
        }

        @Override // rx.f
        public void onNext(U u3) {
            this.f63646a.M();
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
    /* compiled from: OperatorWindowWithObservable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class b<T> extends rx.l<T> {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super rx.e<T>> f63647a;

        /* renamed from: b  reason: collision with root package name */
        final Object f63648b = new Object();

        /* renamed from: c  reason: collision with root package name */
        rx.f<T> f63649c;

        /* renamed from: d  reason: collision with root package name */
        rx.e<T> f63650d;

        /* renamed from: e  reason: collision with root package name */
        boolean f63651e;

        /* renamed from: f  reason: collision with root package name */
        List<Object> f63652f;

        public b(rx.l<? super rx.e<T>> lVar) {
            this.f63647a = new rx.observers.g(lVar);
        }

        void I(T t3) {
            rx.f<T> fVar = this.f63649c;
            if (fVar != null) {
                fVar.onNext(t3);
            }
        }

        void J(Throwable th) {
            rx.f<T> fVar = this.f63649c;
            this.f63649c = null;
            this.f63650d = null;
            if (fVar != null) {
                fVar.onError(th);
            }
            this.f63647a.onError(th);
            unsubscribe();
        }

        void L() {
            rx.f<T> fVar = this.f63649c;
            if (fVar != null) {
                fVar.onCompleted();
            }
            v();
            this.f63647a.onNext(this.f63650d);
        }

        void M() {
            synchronized (this.f63648b) {
                if (this.f63651e) {
                    if (this.f63652f == null) {
                        this.f63652f = new ArrayList();
                    }
                    this.f63652f.add(y3.f63644b);
                    return;
                }
                List<Object> list = this.f63652f;
                this.f63652f = null;
                boolean z3 = true;
                this.f63651e = true;
                boolean z4 = true;
                while (true) {
                    try {
                        x(list);
                        if (z4) {
                            L();
                            z4 = false;
                        }
                        try {
                            synchronized (this.f63648b) {
                                try {
                                    List<Object> list2 = this.f63652f;
                                    this.f63652f = null;
                                    if (list2 == null) {
                                        this.f63651e = false;
                                        return;
                                    } else if (this.f63647a.isUnsubscribed()) {
                                        synchronized (this.f63648b) {
                                            this.f63651e = false;
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
                                            synchronized (this.f63648b) {
                                                this.f63651e = false;
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
            rx.f<T> fVar = this.f63649c;
            this.f63649c = null;
            this.f63650d = null;
            if (fVar != null) {
                fVar.onCompleted();
            }
            this.f63647a.onCompleted();
            unsubscribe();
        }

        @Override // rx.f
        public void onCompleted() {
            synchronized (this.f63648b) {
                if (this.f63651e) {
                    if (this.f63652f == null) {
                        this.f63652f = new ArrayList();
                    }
                    this.f63652f.add(v.b());
                    return;
                }
                List<Object> list = this.f63652f;
                this.f63652f = null;
                this.f63651e = true;
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
            synchronized (this.f63648b) {
                if (this.f63651e) {
                    this.f63652f = Collections.singletonList(v.c(th));
                    return;
                }
                this.f63652f = null;
                this.f63651e = true;
                J(th);
            }
        }

        @Override // rx.f
        public void onNext(T t3) {
            synchronized (this.f63648b) {
                if (this.f63651e) {
                    if (this.f63652f == null) {
                        this.f63652f = new ArrayList();
                    }
                    this.f63652f.add(t3);
                    return;
                }
                List<Object> list = this.f63652f;
                this.f63652f = null;
                boolean z3 = true;
                this.f63651e = true;
                boolean z4 = true;
                while (true) {
                    try {
                        x(list);
                        if (z4) {
                            I(t3);
                            z4 = false;
                        }
                        try {
                            synchronized (this.f63648b) {
                                try {
                                    List<Object> list2 = this.f63652f;
                                    this.f63652f = null;
                                    if (list2 == null) {
                                        this.f63651e = false;
                                        return;
                                    } else if (this.f63647a.isUnsubscribed()) {
                                        synchronized (this.f63648b) {
                                            this.f63651e = false;
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
                                            synchronized (this.f63648b) {
                                                this.f63651e = false;
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
            this.f63649c = x7;
            this.f63650d = x7;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void x(List<Object> list) {
            if (list == null) {
                return;
            }
            for (Object obj : list) {
                if (obj == y3.f63644b) {
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

    public y3(rx.e<U> eVar) {
        this.f63645a = eVar;
    }

    @Override // rx.functions.p
    public /* bridge */ /* synthetic */ Object call(Object obj) {
        return call((rx.l) ((rx.l) obj));
    }

    public rx.l<? super T> call(rx.l<? super rx.e<T>> lVar) {
        b bVar = new b(lVar);
        a aVar = new a(bVar);
        lVar.add(bVar);
        lVar.add(aVar);
        bVar.M();
        this.f63645a.I6(aVar);
        return bVar;
    }
}
