package rx.subjects;

import java.lang.reflect.Array;
import java.util.ArrayList;
import rx.e;
import rx.internal.operators.v;
import rx.subjects.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: BehaviorSubject.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class b<T> extends f<T, T> {

    /* renamed from: c  reason: collision with root package name */
    private static final Object[] f64266c = new Object[0];

    /* renamed from: b  reason: collision with root package name */
    private final g<T> f64267b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: BehaviorSubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static class a implements rx.functions.b<g.c<T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f64268a;

        a(g gVar) {
            this.f64268a = gVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((g.c) ((g.c) obj));
        }

        public void call(g.c<T> cVar) {
            cVar.F(this.f64268a.c());
        }
    }

    protected b(e.a<T> aVar, g<T> gVar) {
        super(aVar);
        this.f64267b = gVar;
    }

    public static <T> b<T> x7() {
        return z7(null, false);
    }

    public static <T> b<T> y7(T t3) {
        return z7(t3, true);
    }

    private static <T> b<T> z7(T t3, boolean z3) {
        g gVar = new g();
        if (z3) {
            gVar.g(v.j(t3));
        }
        a aVar = new a(gVar);
        gVar.f64317d = aVar;
        gVar.f64318e = aVar;
        return new b<>(gVar, gVar);
    }

    public Throwable A7() {
        Object c4 = this.f64267b.c();
        if (v.g(c4)) {
            return v.d(c4);
        }
        return null;
    }

    public T B7() {
        Object c4 = this.f64267b.c();
        if (v.h(c4)) {
            return (T) v.e(c4);
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] C7() {
        Object[] objArr = f64266c;
        Object[] D7 = D7(objArr);
        return D7 == objArr ? new Object[0] : D7;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] D7(T[] tArr) {
        Object c4 = this.f64267b.c();
        if (v.h(c4)) {
            if (tArr.length == 0) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            }
            tArr[0] = v.e(c4);
            if (tArr.length > 1) {
                tArr[1] = null;
            }
        } else if (tArr.length > 0) {
            tArr[0] = null;
        }
        return tArr;
    }

    public boolean E7() {
        return v.f(this.f64267b.c());
    }

    public boolean F7() {
        return v.g(this.f64267b.c());
    }

    public boolean G7() {
        return v.h(this.f64267b.c());
    }

    int H7() {
        return this.f64267b.e().length;
    }

    @Override // rx.f
    public void onCompleted() {
        if (this.f64267b.c() == null || this.f64267b.f64315b) {
            Object b4 = v.b();
            for (g.c<T> cVar : this.f64267b.h(b4)) {
                cVar.H(b4);
            }
        }
    }

    @Override // rx.f
    public void onError(Throwable th) {
        if (this.f64267b.c() == null || this.f64267b.f64315b) {
            Object c4 = v.c(th);
            ArrayList arrayList = null;
            for (g.c<T> cVar : this.f64267b.h(c4)) {
                try {
                    cVar.H(c4);
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
        if (this.f64267b.c() == null || this.f64267b.f64315b) {
            Object j4 = v.j(t3);
            for (g.c<T> cVar : this.f64267b.d(j4)) {
                cVar.H(j4);
            }
        }
    }

    @Override // rx.subjects.f
    public boolean v7() {
        return this.f64267b.e().length > 0;
    }
}
