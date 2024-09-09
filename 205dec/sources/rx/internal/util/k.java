package rx.internal.util;

import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;
import rx.functions.p;
import rx.h;
import rx.internal.producers.SingleProducer;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: ScalarSynchronousObservable.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class k<T> extends rx.e<T> {

    /* renamed from: c  reason: collision with root package name */
    static final boolean f63944c = Boolean.valueOf(System.getProperty("rx.just.strong-mode", "false")).booleanValue();

    /* renamed from: b  reason: collision with root package name */
    final T f63945b;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class a implements p<rx.functions.a, rx.m> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.internal.schedulers.b f63946a;

        a(rx.internal.schedulers.b bVar) {
            this.f63946a = bVar;
        }

        @Override // rx.functions.p
        public rx.m call(rx.functions.a aVar) {
            return this.f63946a.F(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class b implements p<rx.functions.a, rx.m> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.h f63948a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: ScalarSynchronousObservable.java */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        public class a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.functions.a f63950a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h.a f63951b;

            a(rx.functions.a aVar, h.a aVar2) {
                this.f63950a = aVar;
                this.f63951b = aVar2;
            }

            @Override // rx.functions.a
            public void call() {
                try {
                    this.f63950a.call();
                } finally {
                    this.f63951b.unsubscribe();
                }
            }
        }

        b(rx.h hVar) {
            this.f63948a = hVar;
        }

        @Override // rx.functions.p
        public rx.m call(rx.functions.a aVar) {
            h.a a4 = this.f63948a.a();
            a4.d(new a(aVar, a4));
            return a4;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [R] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class c<R> implements e.a<R> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ p f63953a;

        c(p pVar) {
            this.f63953a = pVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super R> lVar) {
            rx.e eVar = (rx.e) this.f63953a.call(k.this.f63945b);
            if (eVar instanceof k) {
                lVar.setProducer(k.w7(lVar, ((k) eVar).f63945b));
            } else {
                eVar.I6(rx.observers.h.f(lVar));
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class d<T> implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f63955a;

        d(T t3) {
            this.f63955a = t3;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super T> lVar) {
            lVar.setProducer(k.w7(lVar, this.f63955a));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class e<T> implements e.a<T> {

        /* renamed from: a  reason: collision with root package name */
        final T f63956a;

        /* renamed from: b  reason: collision with root package name */
        final p<rx.functions.a, rx.m> f63957b;

        e(T t3, p<rx.functions.a, rx.m> pVar) {
            this.f63956a = t3;
            this.f63957b = pVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super T> lVar) {
            lVar.setProducer(new f(lVar, this.f63956a, this.f63957b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class f<T> extends AtomicBoolean implements rx.g, rx.functions.a {
        private static final long serialVersionUID = -2466317989629281651L;

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f63958a;

        /* renamed from: b  reason: collision with root package name */
        final T f63959b;

        /* renamed from: c  reason: collision with root package name */
        final p<rx.functions.a, rx.m> f63960c;

        public f(rx.l<? super T> lVar, T t3, p<rx.functions.a, rx.m> pVar) {
            this.f63958a = lVar;
            this.f63959b = t3;
            this.f63960c = pVar;
        }

        @Override // rx.functions.a
        public void call() {
            rx.l<? super T> lVar = this.f63958a;
            if (lVar.isUnsubscribed()) {
                return;
            }
            Object obj = (T) this.f63959b;
            try {
                lVar.onNext(obj);
                if (lVar.isUnsubscribed()) {
                    return;
                }
                lVar.onCompleted();
            } catch (Throwable th) {
                rx.exceptions.a.g(th, lVar, obj);
            }
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 >= 0) {
                if (j4 == 0 || !compareAndSet(false, true)) {
                    return;
                }
                this.f63958a.add(this.f63960c.call(this));
                return;
            }
            throw new IllegalArgumentException("n >= 0 required but it was " + j4);
        }

        @Override // java.util.concurrent.atomic.AtomicBoolean
        public String toString() {
            return "ScalarAsyncProducer[" + this.f63959b + ", " + get() + "]";
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: ScalarSynchronousObservable.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class g<T> implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final rx.l<? super T> f63961a;

        /* renamed from: b  reason: collision with root package name */
        final T f63962b;

        /* renamed from: c  reason: collision with root package name */
        boolean f63963c;

        public g(rx.l<? super T> lVar, T t3) {
            this.f63961a = lVar;
            this.f63962b = t3;
        }

        @Override // rx.g
        public void request(long j4) {
            if (this.f63963c) {
                return;
            }
            if (j4 < 0) {
                throw new IllegalStateException("n >= required but it was " + j4);
            } else if (j4 == 0) {
            } else {
                this.f63963c = true;
                rx.l<? super T> lVar = this.f63961a;
                if (lVar.isUnsubscribed()) {
                    return;
                }
                Object obj = (T) this.f63962b;
                try {
                    lVar.onNext(obj);
                    if (lVar.isUnsubscribed()) {
                        return;
                    }
                    lVar.onCompleted();
                } catch (Throwable th) {
                    rx.exceptions.a.g(th, lVar, obj);
                }
            }
        }
    }

    protected k(T t3) {
        super(rx.plugins.c.G(new d(t3)));
        this.f63945b = t3;
    }

    public static <T> k<T> v7(T t3) {
        return new k<>(t3);
    }

    static <T> rx.g w7(rx.l<? super T> lVar, T t3) {
        if (f63944c) {
            return new SingleProducer(lVar, t3);
        }
        return new g(lVar, t3);
    }

    public T x7() {
        return this.f63945b;
    }

    public <R> rx.e<R> y7(p<? super T, ? extends rx.e<? extends R>> pVar) {
        return rx.e.H6(new c(pVar));
    }

    public rx.e<T> z7(rx.h hVar) {
        p bVar;
        if (hVar instanceof rx.internal.schedulers.b) {
            bVar = new a((rx.internal.schedulers.b) hVar);
        } else {
            bVar = new b(hVar);
        }
        return rx.e.H6(new e(this.f63945b, bVar));
    }
}
