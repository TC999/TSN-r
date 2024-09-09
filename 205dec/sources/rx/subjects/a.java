package rx.subjects;

import java.util.ArrayList;
import rx.e;
import rx.internal.operators.v;
import rx.internal.producers.SingleProducer;
import rx.subjects.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: AsyncSubject.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class a<T> extends f<T, T> {

    /* renamed from: b  reason: collision with root package name */
    final g<T> f64263b;

    /* renamed from: c  reason: collision with root package name */
    volatile Object f64264c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: AsyncSubject.java */
    /* renamed from: rx.subjects.a$a  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class C1326a implements rx.functions.b<g.c<T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f64265a;

        C1326a(g gVar) {
            this.f64265a = gVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((g.c) ((g.c) obj));
        }

        public void call(g.c<T> cVar) {
            Object c4 = this.f64265a.c();
            if (c4 != null && !v.f(c4)) {
                if (v.g(c4)) {
                    cVar.onError(v.d(c4));
                    return;
                } else {
                    cVar.f64326a.setProducer(new SingleProducer(cVar.f64326a, v.e(c4)));
                    return;
                }
            }
            cVar.onCompleted();
        }
    }

    protected a(e.a<T> aVar, g<T> gVar) {
        super(aVar);
        this.f64263b = gVar;
    }

    public static <T> a<T> x7() {
        g gVar = new g();
        gVar.f64318e = new C1326a(gVar);
        return new a<>(gVar, gVar);
    }

    public boolean A7() {
        Object c4 = this.f64263b.c();
        return (c4 == null || v.g(c4)) ? false : true;
    }

    public boolean B7() {
        return v.g(this.f64263b.c());
    }

    public boolean C7() {
        return !v.g(this.f64263b.c()) && v.h(this.f64264c);
    }

    @Override // rx.f
    public void onCompleted() {
        g.c<T>[] h4;
        if (this.f64263b.f64315b) {
            Object obj = this.f64264c;
            if (obj == null) {
                obj = v.b();
            }
            for (g.c<T> cVar : this.f64263b.h(obj)) {
                if (obj == v.b()) {
                    cVar.onCompleted();
                } else {
                    cVar.f64326a.setProducer(new SingleProducer(cVar.f64326a, v.e(obj)));
                }
            }
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        if (this.f64263b.f64315b) {
            ArrayList arrayList = null;
            for (g.c<T> cVar : this.f64263b.h(v.c(th))) {
                try {
                    cVar.onError(th);
                } catch (Throwable th2) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(th2);
                }
            }
            rx.exceptions.a.d(arrayList);
        }
    }

    @Override // rx.f
    public void onNext(T t3) {
        this.f64264c = v.j(t3);
    }

    @Override // rx.subjects.f
    public boolean v7() {
        return this.f64263b.e().length > 0;
    }

    public Throwable y7() {
        Object c4 = this.f64263b.c();
        if (v.g(c4)) {
            return v.d(c4);
        }
        return null;
    }

    public T z7() {
        Object obj = this.f64264c;
        if (v.g(this.f64263b.c()) || !v.h(obj)) {
            return null;
        }
        return (T) v.e(obj);
    }
}
