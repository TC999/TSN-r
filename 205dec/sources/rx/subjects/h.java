package rx.subjects;

import java.util.concurrent.TimeUnit;
import rx.e;
import rx.h;
import rx.internal.operators.v;
import rx.subjects.g;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: TestSubject.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class h<T> extends f<T, T> {

    /* renamed from: b  reason: collision with root package name */
    private final g<T> f64333b;

    /* renamed from: c  reason: collision with root package name */
    private final h.a f64334c;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: TestSubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class a implements rx.functions.b<g.c<T>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f64335a;

        a(g gVar) {
            this.f64335a = gVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((g.c) ((g.c) obj));
        }

        public void call(g.c<T> cVar) {
            cVar.F(this.f64335a.c());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: TestSubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class b implements rx.functions.a {
        b() {
        }

        @Override // rx.functions.a
        public void call() {
            h.this.y7();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: TestSubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class c implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Throwable f64337a;

        c(Throwable th) {
            this.f64337a = th;
        }

        @Override // rx.functions.a
        public void call() {
            h.this.z7(this.f64337a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: TestSubject.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class d implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f64339a;

        d(Object obj) {
            this.f64339a = obj;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // rx.functions.a
        public void call() {
            h.this.A7(this.f64339a);
        }
    }

    protected h(e.a<T> aVar, g<T> gVar, rx.schedulers.d dVar) {
        super(aVar);
        this.f64333b = gVar;
        this.f64334c = dVar.a();
    }

    public static <T> h<T> x7(rx.schedulers.d dVar) {
        g gVar = new g();
        a aVar = new a(gVar);
        gVar.f64317d = aVar;
        gVar.f64318e = aVar;
        return new h<>(gVar, gVar, dVar);
    }

    void A7(T t3) {
        for (g.c<T> cVar : this.f64333b.e()) {
            cVar.onNext(t3);
        }
    }

    public void B7(long j4) {
        this.f64334c.F(new b(), j4, TimeUnit.MILLISECONDS);
    }

    public void C7(Throwable th, long j4) {
        this.f64334c.F(new c(th), j4, TimeUnit.MILLISECONDS);
    }

    public void D7(T t3, long j4) {
        this.f64334c.F(new d(t3), j4, TimeUnit.MILLISECONDS);
    }

    @Override // rx.f
    public void onCompleted() {
        B7(0L);
    }

    @Override // rx.f
    public void onError(Throwable th) {
        C7(th, 0L);
    }

    @Override // rx.f
    public void onNext(T t3) {
        D7(t3, 0L);
    }

    @Override // rx.subjects.f
    public boolean v7() {
        return this.f64333b.e().length > 0;
    }

    void y7() {
        g<T> gVar = this.f64333b;
        if (gVar.f64315b) {
            for (g.c<T> cVar : gVar.h(v.b())) {
                cVar.onCompleted();
            }
        }
    }

    void z7(Throwable th) {
        g<T> gVar = this.f64333b;
        if (gVar.f64315b) {
            for (g.c<T> cVar : gVar.h(v.c(th))) {
                cVar.onError(th);
            }
        }
    }
}
