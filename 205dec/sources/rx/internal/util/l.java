package rx.internal.util;

import rx.functions.p;
import rx.h;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ScalarSynchronousSingle.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class l<T> extends rx.i<T> {

    /* renamed from: b  reason: collision with root package name */
    final T f63964b;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class a implements i.t<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f63965a;

        a(Object obj) {
            this.f63965a = obj;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.k) ((rx.k) obj));
        }

        public void call(rx.k<? super T> kVar) {
            kVar.d(this.f63965a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class b<R> implements i.t<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f63966a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: ScalarSynchronousSingle.java */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        public class a extends rx.k<R> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ rx.k f63968b;

            a(rx.k kVar) {
                this.f63968b = kVar;
            }

            public void d(R r3) {
                this.f63968b.d(r3);
            }

            @Override // rx.k
            public void onError(Throwable th) {
                this.f63968b.onError(th);
            }
        }

        b(p pVar) {
            this.f63966a = pVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.k) ((rx.k) obj));
        }

        public void call(rx.k<? super R> kVar) {
            rx.i iVar = (rx.i) this.f63966a.call(l.this.f63964b);
            if (iVar instanceof l) {
                kVar.d(((l) iVar).f63964b);
                return;
            }
            a aVar = new a(kVar);
            kVar.b(aVar);
            iVar.i0(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class c<T> implements i.t<T> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.internal.schedulers.b f63970a;

        /* renamed from: b  reason: collision with root package name */
        private final T f63971b;

        c(rx.internal.schedulers.b bVar, T t3) {
            this.f63970a = bVar;
            this.f63971b = t3;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.k) ((rx.k) obj));
        }

        public void call(rx.k<? super T> kVar) {
            kVar.b(this.f63970a.F(new e(kVar, this.f63971b)));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class d<T> implements i.t<T> {

        /* renamed from: a  reason: collision with root package name */
        private final rx.h f63972a;

        /* renamed from: b  reason: collision with root package name */
        private final T f63973b;

        d(rx.h hVar, T t3) {
            this.f63972a = hVar;
            this.f63973b = t3;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.k) ((rx.k) obj));
        }

        public void call(rx.k<? super T> kVar) {
            h.a a4 = this.f63972a.a();
            kVar.b(a4);
            a4.d(new e(kVar, this.f63973b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousSingle.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class e<T> implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        private final rx.k<? super T> f63974a;

        /* renamed from: b  reason: collision with root package name */
        private final T f63975b;

        e(rx.k<? super T> kVar, T t3) {
            this.f63974a = kVar;
            this.f63975b = t3;
        }

        @Override // rx.functions.a
        public void call() {
            try {
                this.f63974a.d(this.f63975b);
            } catch (Throwable th) {
                this.f63974a.onError(th);
            }
        }
    }

    protected l(T t3) {
        super(new a(t3));
        this.f63964b = t3;
    }

    public static <T> l<T> O0(T t3) {
        return new l<>(t3);
    }

    public T P0() {
        return this.f63964b;
    }

    public <R> rx.i<R> Q0(p<? super T, ? extends rx.i<? extends R>> pVar) {
        return rx.i.m(new b(pVar));
    }

    public rx.i<T> R0(rx.h hVar) {
        if (hVar instanceof rx.internal.schedulers.b) {
            return rx.i.m(new c((rx.internal.schedulers.b) hVar, this.f63964b));
        }
        return rx.i.m(new d(hVar, this.f63964b));
    }
}
