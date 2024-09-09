package rx;

import java.util.Arrays;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import rx.e;
import rx.exceptions.CompositeException;
import rx.h;
import rx.i;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: Completable.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    static final b f62081b = new b(new k(), false);

    /* renamed from: c  reason: collision with root package name */
    static final b f62082c = new b(new v(), false);

    /* renamed from: a  reason: collision with root package name */
    private final j0 f62083a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class a implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.e f62084a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1259a extends rx.l<Object> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.d f62085a;

            C1259a(rx.d dVar) {
                this.f62085a = dVar;
            }

            @Override // rx.f
            public void onCompleted() {
                this.f62085a.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f62085a.onError(th);
            }

            @Override // rx.f
            public void onNext(Object obj) {
            }
        }

        a(rx.e eVar) {
            this.f62084a = eVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            C1259a c1259a = new C1259a(dVar);
            dVar.a(c1259a);
            this.f62084a.I6(c1259a);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class a0<T> implements i.t<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.o f62087a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.k f62089a;

            a(rx.k kVar) {
                this.f62089a = kVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f62089a.b(mVar);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.d
            public void onCompleted() {
                try {
                    Object call = a0.this.f62087a.call();
                    if (call == null) {
                        this.f62089a.onError(new NullPointerException("The value supplied is null"));
                    } else {
                        this.f62089a.c(call);
                    }
                } catch (Throwable th) {
                    this.f62089a.onError(th);
                }
            }

            @Override // rx.d
            public void onError(Throwable th) {
                this.f62089a.onError(th);
            }
        }

        a0(rx.functions.o oVar) {
            this.f62087a = oVar;
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.k) ((rx.k) obj));
        }

        public void call(rx.k<? super T> kVar) {
            b.this.G0(new a(kVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* renamed from: rx.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class C1260b implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.i f62091a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* renamed from: rx.b$b$a */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a extends rx.k<Object> {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ rx.d f62092b;

            a(rx.d dVar) {
                this.f62092b = dVar;
            }

            @Override // rx.k
            public void c(Object obj) {
                this.f62092b.onCompleted();
            }

            @Override // rx.k
            public void onError(Throwable th) {
                this.f62092b.onError(th);
            }
        }

        C1260b(rx.i iVar) {
            this.f62091a = iVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            a aVar = new a(dVar);
            dVar.a(aVar);
            this.f62091a.i0(aVar);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class b0<T> implements rx.functions.o<T> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Object f62094a;

        b0(Object obj) {
            this.f62094a = obj;
        }

        @Override // rx.functions.o, java.util.concurrent.Callable
        public T call() {
            return (T) this.f62094a;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class c implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.h f62096a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f62097b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TimeUnit f62098c;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.d f62099a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h.a f62100b;

            a(rx.d dVar, h.a aVar) {
                this.f62099a = dVar;
                this.f62100b = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                try {
                    this.f62099a.onCompleted();
                } finally {
                    this.f62100b.unsubscribe();
                }
            }
        }

        c(rx.h hVar, long j4, TimeUnit timeUnit) {
            this.f62096a = hVar;
            this.f62097b = j4;
            this.f62098c = timeUnit;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.c cVar = new rx.subscriptions.c();
            dVar.a(cVar);
            if (cVar.isUnsubscribed()) {
                return;
            }
            h.a a4 = this.f62096a.a();
            cVar.b(a4);
            a4.e(new a(dVar, a4), this.f62097b, this.f62098c);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class c0 implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.h f62102a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.d f62104a;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Completable.java */
            /* renamed from: rx.b$c0$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class C1261a implements rx.functions.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ rx.m f62106a;

                /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
                /* compiled from: Completable.java */
                /* renamed from: rx.b$c0$a$a$a  reason: collision with other inner class name */
                /* loaded from: E:\TSN-r\205dec\7343912.dex */
                class C1262a implements rx.functions.a {

                    /* renamed from: a  reason: collision with root package name */
                    final /* synthetic */ h.a f62108a;

                    C1262a(h.a aVar) {
                        this.f62108a = aVar;
                    }

                    @Override // rx.functions.a
                    public void call() {
                        try {
                            C1261a.this.f62106a.unsubscribe();
                        } finally {
                            this.f62108a.unsubscribe();
                        }
                    }
                }

                C1261a(rx.m mVar) {
                    this.f62106a = mVar;
                }

                @Override // rx.functions.a
                public void call() {
                    h.a a4 = c0.this.f62102a.a();
                    a4.c(new C1262a(a4));
                }
            }

            a(rx.d dVar) {
                this.f62104a = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f62104a.a(rx.subscriptions.f.a(new C1261a(mVar)));
            }

            @Override // rx.d
            public void onCompleted() {
                this.f62104a.onCompleted();
            }

            @Override // rx.d
            public void onError(Throwable th) {
                this.f62104a.onError(th);
            }
        }

        c0(rx.h hVar) {
            this.f62102a = hVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            b.this.G0(new a(dVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class d implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.o f62110a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.p f62111b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62112c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f62113d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.d {

            /* renamed from: a  reason: collision with root package name */
            rx.m f62114a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f62115b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ Object f62116c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ rx.d f62117d;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Completable.java */
            /* renamed from: rx.b$d$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class C1263a implements rx.functions.a {
                C1263a() {
                }

                @Override // rx.functions.a
                public void call() {
                    a.this.b();
                }
            }

            a(AtomicBoolean atomicBoolean, Object obj, rx.d dVar) {
                this.f62115b = atomicBoolean;
                this.f62116c = obj;
                this.f62117d = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f62114a = mVar;
                this.f62117d.a(rx.subscriptions.f.a(new C1263a()));
            }

            void b() {
                this.f62114a.unsubscribe();
                if (this.f62115b.compareAndSet(false, true)) {
                    try {
                        d.this.f62112c.call(this.f62116c);
                    } catch (Throwable th) {
                        rx.plugins.c.I(th);
                    }
                }
            }

            @Override // rx.d
            public void onCompleted() {
                if (d.this.f62113d && this.f62115b.compareAndSet(false, true)) {
                    try {
                        d.this.f62112c.call(this.f62116c);
                    } catch (Throwable th) {
                        this.f62117d.onError(th);
                        return;
                    }
                }
                this.f62117d.onCompleted();
                if (d.this.f62113d) {
                    return;
                }
                b();
            }

            @Override // rx.d
            public void onError(Throwable th) {
                if (d.this.f62113d && this.f62115b.compareAndSet(false, true)) {
                    try {
                        d.this.f62112c.call(this.f62116c);
                    } catch (Throwable th2) {
                        th = new CompositeException(Arrays.asList(th, th2));
                    }
                }
                this.f62117d.onError(th);
                if (d.this.f62113d) {
                    return;
                }
                b();
            }
        }

        d(rx.functions.o oVar, rx.functions.p pVar, rx.functions.b bVar, boolean z3) {
            this.f62110a = oVar;
            this.f62111b = pVar;
            this.f62112c = bVar;
            this.f62113d = z3;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            try {
                Object call = this.f62110a.call();
                try {
                    b bVar = (b) this.f62111b.call(call);
                    if (bVar == null) {
                        try {
                            this.f62112c.call(call);
                            dVar.a(rx.subscriptions.f.e());
                            dVar.onError(new NullPointerException("The completable supplied is null"));
                            return;
                        } catch (Throwable th) {
                            rx.exceptions.a.e(th);
                            dVar.a(rx.subscriptions.f.e());
                            dVar.onError(new CompositeException(Arrays.asList(new NullPointerException("The completable supplied is null"), th)));
                            return;
                        }
                    }
                    bVar.G0(new a(new AtomicBoolean(), call, dVar));
                } catch (Throwable th2) {
                    try {
                        this.f62112c.call(call);
                        rx.exceptions.a.e(th2);
                        dVar.a(rx.subscriptions.f.e());
                        dVar.onError(th2);
                    } catch (Throwable th3) {
                        rx.exceptions.a.e(th2);
                        rx.exceptions.a.e(th3);
                        dVar.a(rx.subscriptions.f.e());
                        dVar.onError(new CompositeException(Arrays.asList(th2, th3)));
                    }
                }
            } catch (Throwable th4) {
                dVar.a(rx.subscriptions.f.e());
                dVar.onError(th4);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class d0 implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Iterable f62120a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f62121a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.b f62122b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ rx.d f62123c;

            a(AtomicBoolean atomicBoolean, rx.subscriptions.b bVar, rx.d dVar) {
                this.f62121a = atomicBoolean;
                this.f62122b = bVar;
                this.f62123c = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f62122b.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                if (this.f62121a.compareAndSet(false, true)) {
                    this.f62122b.unsubscribe();
                    this.f62123c.onCompleted();
                }
            }

            @Override // rx.d
            public void onError(Throwable th) {
                if (this.f62121a.compareAndSet(false, true)) {
                    this.f62122b.unsubscribe();
                    this.f62123c.onError(th);
                    return;
                }
                rx.plugins.c.I(th);
            }
        }

        d0(Iterable iterable) {
            this.f62120a = iterable;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            dVar.a(bVar);
            try {
                Iterator it = this.f62120a.iterator();
                if (it == null) {
                    dVar.onError(new NullPointerException("The iterator returned is null"));
                    return;
                }
                AtomicBoolean atomicBoolean = new AtomicBoolean();
                a aVar = new a(atomicBoolean, bVar, dVar);
                boolean z3 = true;
                while (!atomicBoolean.get() && !bVar.isUnsubscribed()) {
                    try {
                        if (!it.hasNext()) {
                            if (z3) {
                                dVar.onCompleted();
                                return;
                            }
                            return;
                        } else if (atomicBoolean.get() || bVar.isUnsubscribed()) {
                            return;
                        } else {
                            try {
                                b bVar2 = (b) it.next();
                                if (bVar2 == null) {
                                    Throwable nullPointerException = new NullPointerException("One of the sources is null");
                                    if (atomicBoolean.compareAndSet(false, true)) {
                                        bVar.unsubscribe();
                                        dVar.onError(nullPointerException);
                                        return;
                                    }
                                    rx.plugins.c.I(nullPointerException);
                                    return;
                                } else if (atomicBoolean.get() || bVar.isUnsubscribed()) {
                                    return;
                                } else {
                                    bVar2.G0(aVar);
                                    z3 = false;
                                }
                            } catch (Throwable th) {
                                if (atomicBoolean.compareAndSet(false, true)) {
                                    bVar.unsubscribe();
                                    dVar.onError(th);
                                    return;
                                }
                                rx.plugins.c.I(th);
                                return;
                            }
                        }
                    } catch (Throwable th2) {
                        if (atomicBoolean.compareAndSet(false, true)) {
                            bVar.unsubscribe();
                            dVar.onError(th2);
                            return;
                        }
                        rx.plugins.c.I(th2);
                        return;
                    }
                }
            } catch (Throwable th3) {
                dVar.onError(th3);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class e implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f62125a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable[] f62126b;

        e(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f62125a = countDownLatch;
            this.f62126b = thArr;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
        }

        @Override // rx.d
        public void onCompleted() {
            this.f62125a.countDown();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f62126b[0] = th;
            this.f62125a.countDown();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class e0 implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.o f62128a;

        e0(rx.functions.o oVar) {
            this.f62128a = oVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            try {
                b bVar = (b) this.f62128a.call();
                if (bVar == null) {
                    dVar.a(rx.subscriptions.f.e());
                    dVar.onError(new NullPointerException("The completable returned is null"));
                    return;
                }
                bVar.G0(dVar);
            } catch (Throwable th) {
                dVar.a(rx.subscriptions.f.e());
                dVar.onError(th);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class f implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f62129a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable[] f62130b;

        f(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f62129a = countDownLatch;
            this.f62130b = thArr;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
        }

        @Override // rx.d
        public void onCompleted() {
            this.f62129a.countDown();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f62130b[0] = th;
            this.f62129a.countDown();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class f0 implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.o f62132a;

        f0(rx.functions.o oVar) {
            this.f62132a = oVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            dVar.a(rx.subscriptions.f.e());
            try {
                th = (Throwable) this.f62132a.call();
            } catch (Throwable th) {
                th = th;
            }
            if (th == null) {
                th = new NullPointerException("The error supplied is null");
            }
            dVar.onError(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class g implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.h f62133a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f62134b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TimeUnit f62135c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ boolean f62136d;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.b f62138a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h.a f62139b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ rx.d f62140c;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Completable.java */
            /* renamed from: rx.b$g$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class C1264a implements rx.functions.a {
                C1264a() {
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        a.this.f62140c.onCompleted();
                    } finally {
                        a.this.f62139b.unsubscribe();
                    }
                }
            }

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Completable.java */
            /* renamed from: rx.b$g$a$b  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class C1265b implements rx.functions.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Throwable f62143a;

                C1265b(Throwable th) {
                    this.f62143a = th;
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        a.this.f62140c.onError(this.f62143a);
                    } finally {
                        a.this.f62139b.unsubscribe();
                    }
                }
            }

            a(rx.subscriptions.b bVar, h.a aVar, rx.d dVar) {
                this.f62138a = bVar;
                this.f62139b = aVar;
                this.f62140c = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f62138a.a(mVar);
                this.f62140c.a(this.f62138a);
            }

            @Override // rx.d
            public void onCompleted() {
                rx.subscriptions.b bVar = this.f62138a;
                h.a aVar = this.f62139b;
                C1264a c1264a = new C1264a();
                g gVar = g.this;
                bVar.a(aVar.e(c1264a, gVar.f62134b, gVar.f62135c));
            }

            @Override // rx.d
            public void onError(Throwable th) {
                if (g.this.f62136d) {
                    rx.subscriptions.b bVar = this.f62138a;
                    h.a aVar = this.f62139b;
                    C1265b c1265b = new C1265b(th);
                    g gVar = g.this;
                    bVar.a(aVar.e(c1265b, gVar.f62134b, gVar.f62135c));
                    return;
                }
                this.f62140c.onError(th);
            }
        }

        g(rx.h hVar, long j4, TimeUnit timeUnit, boolean z3) {
            this.f62133a = hVar;
            this.f62134b = j4;
            this.f62135c = timeUnit;
            this.f62136d = z3;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            h.a a4 = this.f62133a.a();
            bVar.a(a4);
            b.this.G0(new a(bVar, a4, dVar));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class g0 implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Throwable f62145a;

        g0(Throwable th) {
            this.f62145a = th;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            dVar.a(rx.subscriptions.f.e());
            dVar.onError(this.f62145a);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class h implements rx.functions.b<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62146a;

        h(rx.functions.b bVar) {
            this.f62146a = bVar;
        }

        @Override // rx.functions.b
        public void call(Throwable th) {
            this.f62146a.call(Notification.d(th));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class h0 implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f62148a;

        h0(rx.functions.a aVar) {
            this.f62148a = aVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.a aVar = new rx.subscriptions.a();
            dVar.a(aVar);
            try {
                this.f62148a.call();
                if (aVar.isUnsubscribed()) {
                    return;
                }
                dVar.onCompleted();
            } catch (Throwable th) {
                if (aVar.isUnsubscribed()) {
                    return;
                }
                dVar.onError(th);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class i implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62149a;

        i(rx.functions.b bVar) {
            this.f62149a = bVar;
        }

        @Override // rx.functions.a
        public void call() {
            this.f62149a.call(Notification.b());
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class i0 implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Callable f62151a;

        i0(Callable callable) {
            this.f62151a = callable;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.a aVar = new rx.subscriptions.a();
            dVar.a(aVar);
            try {
                this.f62151a.call();
                if (aVar.isUnsubscribed()) {
                    return;
                }
                dVar.onCompleted();
            } catch (Throwable th) {
                if (aVar.isUnsubscribed()) {
                    return;
                }
                dVar.onError(th);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class j implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f62152a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f62153b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62154c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62155d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f62156e;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.d f62158a;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Completable.java */
            /* renamed from: rx.b$j$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class C1266a implements rx.functions.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ rx.m f62160a;

                C1266a(rx.m mVar) {
                    this.f62160a = mVar;
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        j.this.f62156e.call();
                    } catch (Throwable th) {
                        rx.plugins.c.I(th);
                    }
                    this.f62160a.unsubscribe();
                }
            }

            a(rx.d dVar) {
                this.f62158a = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                try {
                    j.this.f62155d.call(mVar);
                    this.f62158a.a(rx.subscriptions.f.a(new C1266a(mVar)));
                } catch (Throwable th) {
                    mVar.unsubscribe();
                    this.f62158a.a(rx.subscriptions.f.e());
                    this.f62158a.onError(th);
                }
            }

            @Override // rx.d
            public void onCompleted() {
                try {
                    j.this.f62152a.call();
                    this.f62158a.onCompleted();
                    try {
                        j.this.f62153b.call();
                    } catch (Throwable th) {
                        rx.plugins.c.I(th);
                    }
                } catch (Throwable th2) {
                    this.f62158a.onError(th2);
                }
            }

            @Override // rx.d
            public void onError(Throwable th) {
                try {
                    j.this.f62154c.call(th);
                } catch (Throwable th2) {
                    th = new CompositeException(Arrays.asList(th, th2));
                }
                this.f62158a.onError(th);
                try {
                    j.this.f62153b.call();
                } catch (Throwable th3) {
                    rx.plugins.c.I(th3);
                }
            }
        }

        j(rx.functions.a aVar, rx.functions.a aVar2, rx.functions.b bVar, rx.functions.b bVar2, rx.functions.a aVar3) {
            this.f62152a = aVar;
            this.f62153b = aVar2;
            this.f62154c = bVar;
            this.f62155d = bVar2;
            this.f62156e = aVar3;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            b.this.G0(new a(dVar));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface j0 extends rx.functions.b<rx.d> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class k implements j0 {
        k() {
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            dVar.a(rx.subscriptions.f.e());
            dVar.onCompleted();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface k0 extends rx.functions.p<rx.d, rx.d> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class l implements rx.functions.b<Throwable> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f62162a;

        l(rx.functions.a aVar) {
            this.f62162a = aVar;
        }

        @Override // rx.functions.b
        public void call(Throwable th) {
            this.f62162a.call();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public interface l0 extends rx.functions.p<b, b> {
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class m implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f62164a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable[] f62165b;

        m(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f62164a = countDownLatch;
            this.f62165b = thArr;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
        }

        @Override // rx.d
        public void onCompleted() {
            this.f62164a.countDown();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f62165b[0] = th;
            this.f62164a.countDown();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class n implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CountDownLatch f62167a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Throwable[] f62168b;

        n(CountDownLatch countDownLatch, Throwable[] thArr) {
            this.f62167a = countDownLatch;
            this.f62168b = thArr;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
        }

        @Override // rx.d
        public void onCompleted() {
            this.f62167a.countDown();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f62168b[0] = th;
            this.f62167a.countDown();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class o implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ k0 f62170a;

        o(k0 k0Var) {
            this.f62170a = k0Var;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            try {
                b.this.G0(rx.plugins.c.C(this.f62170a).call(dVar));
            } catch (NullPointerException e4) {
                throw e4;
            } catch (Throwable th) {
                throw b.C0(th);
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class p implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.h f62172a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ h.a f62174a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ rx.d f62175b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ rx.internal.util.m f62176c;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Completable.java */
            /* renamed from: rx.b$p$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class C1267a implements rx.functions.a {
                C1267a() {
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        a.this.f62175b.onCompleted();
                    } finally {
                        a.this.f62176c.unsubscribe();
                    }
                }
            }

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Completable.java */
            /* renamed from: rx.b$p$a$b  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class C1268b implements rx.functions.a {

                /* renamed from: a  reason: collision with root package name */
                final /* synthetic */ Throwable f62179a;

                C1268b(Throwable th) {
                    this.f62179a = th;
                }

                @Override // rx.functions.a
                public void call() {
                    try {
                        a.this.f62175b.onError(this.f62179a);
                    } finally {
                        a.this.f62176c.unsubscribe();
                    }
                }
            }

            a(h.a aVar, rx.d dVar, rx.internal.util.m mVar) {
                this.f62174a = aVar;
                this.f62175b = dVar;
                this.f62176c = mVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f62176c.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                this.f62174a.c(new C1267a());
            }

            @Override // rx.d
            public void onError(Throwable th) {
                this.f62174a.c(new C1268b(th));
            }
        }

        p(rx.h hVar) {
            this.f62172a = hVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.internal.util.m mVar = new rx.internal.util.m();
            h.a a4 = this.f62172a.a();
            mVar.a(a4);
            dVar.a(mVar);
            b.this.G0(new a(a4, dVar, mVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class q implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.p f62181a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.d f62183a;

            a(rx.d dVar) {
                this.f62183a = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f62183a.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                this.f62183a.onCompleted();
            }

            @Override // rx.d
            public void onError(Throwable th) {
                boolean z3 = false;
                try {
                    z3 = ((Boolean) q.this.f62181a.call(th)).booleanValue();
                } catch (Throwable th2) {
                    rx.exceptions.a.e(th2);
                    th = new CompositeException(Arrays.asList(th, th2));
                }
                if (z3) {
                    this.f62183a.onCompleted();
                } else {
                    this.f62183a.onError(th);
                }
            }
        }

        q(rx.functions.p pVar) {
            this.f62181a = pVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            b.this.G0(new a(dVar));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class r implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.functions.p f62185a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.d f62187a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.e f62188b;

            /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
            /* compiled from: Completable.java */
            /* renamed from: rx.b$r$a$a  reason: collision with other inner class name */
            /* loaded from: E:\TSN-r\205dec\7343912.dex */
            class C1269a implements rx.d {
                C1269a() {
                }

                @Override // rx.d
                public void a(rx.m mVar) {
                    a.this.f62188b.b(mVar);
                }

                @Override // rx.d
                public void onCompleted() {
                    a.this.f62187a.onCompleted();
                }

                @Override // rx.d
                public void onError(Throwable th) {
                    a.this.f62187a.onError(th);
                }
            }

            a(rx.d dVar, rx.subscriptions.e eVar) {
                this.f62187a = dVar;
                this.f62188b = eVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f62188b.b(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                this.f62187a.onCompleted();
            }

            @Override // rx.d
            public void onError(Throwable th) {
                try {
                    b bVar = (b) r.this.f62185a.call(th);
                    if (bVar == null) {
                        this.f62187a.onError(new CompositeException(Arrays.asList(th, new NullPointerException("The completable returned is null"))));
                    } else {
                        bVar.G0(new C1269a());
                    }
                } catch (Throwable th2) {
                    this.f62187a.onError(new CompositeException(Arrays.asList(th, th2)));
                }
            }
        }

        r(rx.functions.p pVar) {
            this.f62185a = pVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            rx.subscriptions.e eVar = new rx.subscriptions.e();
            dVar.a(eVar);
            b.this.G0(new a(dVar, eVar));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class s implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.c f62191a;

        s(rx.subscriptions.c cVar) {
            this.f62191a = cVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f62191a.b(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            this.f62191a.unsubscribe();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            rx.plugins.c.I(th);
            this.f62191a.unsubscribe();
            b.u(th);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class t implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        boolean f62193a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f62194b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.c f62195c;

        t(rx.functions.a aVar, rx.subscriptions.c cVar) {
            this.f62194b = aVar;
            this.f62195c = cVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f62195c.b(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            if (this.f62193a) {
                return;
            }
            this.f62193a = true;
            try {
                this.f62194b.call();
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            rx.plugins.c.I(th);
            this.f62195c.unsubscribe();
            b.u(th);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class u implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        boolean f62197a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f62198b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.c f62199c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ rx.functions.b f62200d;

        u(rx.functions.a aVar, rx.subscriptions.c cVar, rx.functions.b bVar) {
            this.f62198b = aVar;
            this.f62199c = cVar;
            this.f62200d = bVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f62199c.b(mVar);
        }

        void b(Throwable th) {
            try {
                this.f62200d.call(th);
            } finally {
                try {
                } finally {
                }
            }
        }

        @Override // rx.d
        public void onCompleted() {
            if (this.f62197a) {
                return;
            }
            this.f62197a = true;
            try {
                this.f62198b.call();
                this.f62199c.unsubscribe();
            } catch (Throwable th) {
                b(th);
            }
        }

        @Override // rx.d
        public void onError(Throwable th) {
            if (!this.f62197a) {
                this.f62197a = true;
                b(th);
                return;
            }
            rx.plugins.c.I(th);
            b.u(th);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class v implements j0 {
        v() {
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            dVar.a(rx.subscriptions.f.e());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static class w implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b[] f62202a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.d {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ AtomicBoolean f62203a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ rx.subscriptions.b f62204b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ rx.d f62205c;

            a(AtomicBoolean atomicBoolean, rx.subscriptions.b bVar, rx.d dVar) {
                this.f62203a = atomicBoolean;
                this.f62204b = bVar;
                this.f62205c = dVar;
            }

            @Override // rx.d
            public void a(rx.m mVar) {
                this.f62204b.a(mVar);
            }

            @Override // rx.d
            public void onCompleted() {
                if (this.f62203a.compareAndSet(false, true)) {
                    this.f62204b.unsubscribe();
                    this.f62205c.onCompleted();
                }
            }

            @Override // rx.d
            public void onError(Throwable th) {
                if (this.f62203a.compareAndSet(false, true)) {
                    this.f62204b.unsubscribe();
                    this.f62205c.onError(th);
                    return;
                }
                rx.plugins.c.I(th);
            }
        }

        w(b[] bVarArr) {
            this.f62202a = bVarArr;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            b[] bVarArr;
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            dVar.a(bVar);
            AtomicBoolean atomicBoolean = new AtomicBoolean();
            a aVar = new a(atomicBoolean, bVar, dVar);
            for (b bVar2 : this.f62202a) {
                if (bVar.isUnsubscribed()) {
                    return;
                }
                if (bVar2 == null) {
                    Throwable nullPointerException = new NullPointerException("One of the sources is null");
                    if (atomicBoolean.compareAndSet(false, true)) {
                        bVar.unsubscribe();
                        dVar.onError(nullPointerException);
                        return;
                    }
                    rx.plugins.c.I(nullPointerException);
                    return;
                } else if (atomicBoolean.get() || bVar.isUnsubscribed()) {
                    return;
                } else {
                    bVar2.G0(aVar);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class x implements rx.d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f62207a;

        x(rx.l lVar) {
            this.f62207a = lVar;
        }

        @Override // rx.d
        public void a(rx.m mVar) {
            this.f62207a.add(mVar);
        }

        @Override // rx.d
        public void onCompleted() {
            this.f62207a.onCompleted();
        }

        @Override // rx.d
        public void onError(Throwable th) {
            this.f62207a.onError(th);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    class y implements j0 {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.h f62209a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: Completable.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.d f62211a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ h.a f62212b;

            a(rx.d dVar, h.a aVar) {
                this.f62211a = dVar;
                this.f62212b = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                try {
                    b.this.G0(this.f62211a);
                } finally {
                    this.f62212b.unsubscribe();
                }
            }
        }

        y(rx.h hVar) {
            this.f62209a = hVar;
        }

        @Override // rx.functions.b
        public void call(rx.d dVar) {
            h.a a4 = this.f62209a.a();
            a4.c(new a(dVar, a4));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: Completable.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class z<T> implements e.a<T> {
        z() {
        }

        @Override // rx.functions.b
        public /* bridge */ /* synthetic */ void call(Object obj) {
            call((rx.l) ((rx.l) obj));
        }

        public void call(rx.l<? super T> lVar) {
            b.this.H0(lVar);
        }
    }

    protected b(j0 j0Var) {
        this.f62083a = rx.plugins.c.F(j0Var);
    }

    public static b A0(long j4, TimeUnit timeUnit, rx.h hVar) {
        g0(timeUnit);
        g0(hVar);
        return p(new c(hVar, j4, timeUnit));
    }

    static NullPointerException C0(Throwable th) {
        NullPointerException nullPointerException = new NullPointerException("Actually not, but can't pass out an exception otherwise...");
        nullPointerException.initCause(th);
        return nullPointerException;
    }

    public static b D(Throwable th) {
        g0(th);
        return p(new g0(th));
    }

    public static b E(rx.functions.o<? extends Throwable> oVar) {
        g0(oVar);
        return p(new f0(oVar));
    }

    public static b F(rx.functions.a aVar) {
        g0(aVar);
        return p(new h0(aVar));
    }

    public static b G(Callable<?> callable) {
        g0(callable);
        return p(new i0(callable));
    }

    public static b H(rx.functions.b<rx.c> bVar) {
        return p(new rx.internal.operators.j(bVar));
    }

    public static b I(Future<?> future) {
        g0(future);
        return J(rx.e.v2(future));
    }

    private <T> void I0(rx.l<T> lVar, boolean z3) {
        g0(lVar);
        if (z3) {
            try {
                lVar.onStart();
            } catch (NullPointerException e4) {
                throw e4;
            } catch (Throwable th) {
                rx.exceptions.a.e(th);
                Throwable L2 = rx.plugins.c.L(th);
                rx.plugins.c.I(L2);
                throw C0(L2);
            }
        }
        G0(new x(lVar));
        rx.plugins.c.N(lVar);
    }

    public static b J(rx.e<?> eVar) {
        g0(eVar);
        return p(new a(eVar));
    }

    public static b K(rx.i<?> iVar) {
        g0(iVar);
        return p(new C1260b(iVar));
    }

    public static <R> b K0(rx.functions.o<R> oVar, rx.functions.p<? super R, ? extends b> pVar, rx.functions.b<? super R> bVar) {
        return L0(oVar, pVar, bVar, true);
    }

    public static <R> b L0(rx.functions.o<R> oVar, rx.functions.p<? super R, ? extends b> pVar, rx.functions.b<? super R> bVar, boolean z3) {
        g0(oVar);
        g0(pVar);
        g0(bVar);
        return p(new d(oVar, pVar, bVar, z3));
    }

    public static b O(Iterable<? extends b> iterable) {
        g0(iterable);
        return p(new rx.internal.operators.r(iterable));
    }

    public static b P(rx.e<? extends b> eVar) {
        return S(eVar, Integer.MAX_VALUE, false);
    }

    public static b Q(rx.e<? extends b> eVar, int i4) {
        return S(eVar, i4, false);
    }

    public static b R(b... bVarArr) {
        g0(bVarArr);
        if (bVarArr.length == 0) {
            return i();
        }
        if (bVarArr.length == 1) {
            return bVarArr[0];
        }
        return p(new rx.internal.operators.o(bVarArr));
    }

    protected static b S(rx.e<? extends b> eVar, int i4, boolean z3) {
        g0(eVar);
        if (i4 >= 1) {
            return p(new rx.internal.operators.n(eVar, i4, z3));
        }
        throw new IllegalArgumentException("maxConcurrency > 0 required but it was " + i4);
    }

    public static b T(Iterable<? extends b> iterable) {
        g0(iterable);
        return p(new rx.internal.operators.q(iterable));
    }

    public static b U(rx.e<? extends b> eVar) {
        return S(eVar, Integer.MAX_VALUE, true);
    }

    public static b V(rx.e<? extends b> eVar, int i4) {
        return S(eVar, i4, true);
    }

    public static b W(b... bVarArr) {
        g0(bVarArr);
        return p(new rx.internal.operators.p(bVarArr));
    }

    public static b Y() {
        b bVar = f62082c;
        j0 F = rx.plugins.c.F(bVar.f62083a);
        return F == bVar.f62083a ? bVar : new b(F, false);
    }

    public static b a(Iterable<? extends b> iterable) {
        g0(iterable);
        return p(new d0(iterable));
    }

    public static b b(b... bVarArr) {
        g0(bVarArr);
        if (bVarArr.length == 0) {
            return i();
        }
        if (bVarArr.length == 1) {
            return bVarArr[0];
        }
        return p(new w(bVarArr));
    }

    static <T> T g0(T t3) {
        t3.getClass();
        return t3;
    }

    public static b i() {
        b bVar = f62081b;
        j0 F = rx.plugins.c.F(bVar.f62083a);
        return F == bVar.f62083a ? bVar : new b(F, false);
    }

    public static b k(Iterable<? extends b> iterable) {
        g0(iterable);
        return p(new rx.internal.operators.m(iterable));
    }

    public static b l(rx.e<? extends b> eVar) {
        return m(eVar, 2);
    }

    public static b m(rx.e<? extends b> eVar, int i4) {
        g0(eVar);
        if (i4 >= 1) {
            return p(new rx.internal.operators.k(eVar, i4));
        }
        throw new IllegalArgumentException("prefetch > 0 required but it was " + i4);
    }

    public static b n(b... bVarArr) {
        g0(bVarArr);
        if (bVarArr.length == 0) {
            return i();
        }
        if (bVarArr.length == 1) {
            return bVarArr[0];
        }
        return p(new rx.internal.operators.l(bVarArr));
    }

    public static b p(j0 j0Var) {
        g0(j0Var);
        try {
            return new b(j0Var);
        } catch (NullPointerException e4) {
            throw e4;
        } catch (Throwable th) {
            rx.plugins.c.I(th);
            throw C0(th);
        }
    }

    public static b q(rx.functions.o<? extends b> oVar) {
        g0(oVar);
        return p(new e0(oVar));
    }

    static void u(Throwable th) {
        Thread currentThread = Thread.currentThread();
        currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th);
    }

    public static b z0(long j4, TimeUnit timeUnit) {
        return A0(j4, timeUnit, rx.schedulers.c.a());
    }

    public final b A(rx.functions.b<? super rx.m> bVar) {
        return z(bVar, rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a());
    }

    public final b B(rx.functions.a aVar) {
        return z(rx.functions.m.a(), new l(aVar), aVar, rx.functions.m.a(), rx.functions.m.a());
    }

    public final <R> R B0(rx.functions.p<? super b, R> pVar) {
        return pVar.call(this);
    }

    public final b C(rx.functions.a aVar) {
        return z(rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a(), aVar);
    }

    public final <T> rx.e<T> D0() {
        return rx.e.H6(new z());
    }

    public final <T> rx.i<T> E0(rx.functions.o<? extends T> oVar) {
        g0(oVar);
        return rx.i.m(new a0(oVar));
    }

    public final <T> rx.i<T> F0(T t3) {
        g0(t3);
        return E0(new b0(t3));
    }

    public final void G0(rx.d dVar) {
        g0(dVar);
        try {
            rx.plugins.c.D(this, this.f62083a).call(dVar);
        } catch (NullPointerException e4) {
            throw e4;
        } catch (Throwable th) {
            rx.exceptions.a.e(th);
            Throwable B = rx.plugins.c.B(th);
            rx.plugins.c.I(B);
            throw C0(B);
        }
    }

    public final <T> void H0(rx.l<T> lVar) {
        I0(lVar, true);
    }

    public final b J0(rx.h hVar) {
        g0(hVar);
        return p(new c0(hVar));
    }

    public final Throwable L() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        G0(new m(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            return thArr[0];
        }
        try {
            countDownLatch.await();
            return thArr[0];
        } catch (InterruptedException e4) {
            throw rx.exceptions.a.c(e4);
        }
    }

    public final Throwable M(long j4, TimeUnit timeUnit) {
        g0(timeUnit);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        G0(new n(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            return thArr[0];
        }
        try {
            if (countDownLatch.await(j4, timeUnit)) {
                return thArr[0];
            }
            rx.exceptions.a.c(new TimeoutException());
            return null;
        } catch (InterruptedException e4) {
            throw rx.exceptions.a.c(e4);
        }
    }

    public final b N(k0 k0Var) {
        g0(k0Var);
        return p(new o(k0Var));
    }

    public final b X(b bVar) {
        g0(bVar);
        return R(this, bVar);
    }

    public final b Z(rx.h hVar) {
        g0(hVar);
        return p(new p(hVar));
    }

    public final b a0() {
        return b0(rx.internal.util.n.b());
    }

    public final b b0(rx.functions.p<? super Throwable, Boolean> pVar) {
        g0(pVar);
        return p(new q(pVar));
    }

    public final b c(b bVar) {
        g0(bVar);
        return b(this, bVar);
    }

    public final b c0(rx.functions.p<? super Throwable, ? extends b> pVar) {
        g0(pVar);
        return p(new r(pVar));
    }

    public final b d(b bVar) {
        return o(bVar);
    }

    public final b d0() {
        return J(D0().f4());
    }

    public final <T> rx.e<T> e(rx.e<T> eVar) {
        g0(eVar);
        return eVar.y1(D0());
    }

    public final b e0(long j4) {
        return J(D0().g4(j4));
    }

    public final <T> rx.i<T> f(rx.i<T> iVar) {
        g0(iVar);
        return iVar.q(D0());
    }

    public final b f0(rx.functions.p<? super rx.e<? extends Void>, ? extends rx.e<?>> pVar) {
        g0(pVar);
        return J(D0().j4(pVar));
    }

    public final void g() {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        G0(new e(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            if (thArr[0] != null) {
                rx.exceptions.a.c(thArr[0]);
                return;
            }
            return;
        }
        try {
            countDownLatch.await();
            if (thArr[0] != null) {
                rx.exceptions.a.c(thArr[0]);
            }
        } catch (InterruptedException e4) {
            throw rx.exceptions.a.c(e4);
        }
    }

    public final boolean h(long j4, TimeUnit timeUnit) {
        g0(timeUnit);
        CountDownLatch countDownLatch = new CountDownLatch(1);
        Throwable[] thArr = new Throwable[1];
        G0(new f(countDownLatch, thArr));
        if (countDownLatch.getCount() == 0) {
            if (thArr[0] != null) {
                rx.exceptions.a.c(thArr[0]);
            }
            return true;
        }
        try {
            boolean await = countDownLatch.await(j4, timeUnit);
            if (await && thArr[0] != null) {
                rx.exceptions.a.c(thArr[0]);
            }
            return await;
        } catch (InterruptedException e4) {
            throw rx.exceptions.a.c(e4);
        }
    }

    public final b h0() {
        return J(D0().B4());
    }

    public final b i0(long j4) {
        return J(D0().C4(j4));
    }

    public final b j(l0 l0Var) {
        return (b) B0(l0Var);
    }

    public final b j0(rx.functions.q<Integer, Throwable, Boolean> qVar) {
        return J(D0().D4(qVar));
    }

    public final b k0(rx.functions.p<? super rx.e<? extends Throwable>, ? extends rx.e<?>> pVar) {
        return J(D0().E4(pVar));
    }

    public final b l0(b bVar) {
        g0(bVar);
        return n(bVar, this);
    }

    public final <T> rx.e<T> m0(rx.e<T> eVar) {
        g0(eVar);
        return D0().n5(eVar);
    }

    public final rx.m n0() {
        rx.subscriptions.c cVar = new rx.subscriptions.c();
        G0(new s(cVar));
        return cVar;
    }

    public final b o(b bVar) {
        g0(bVar);
        return n(this, bVar);
    }

    public final rx.m o0(rx.functions.a aVar) {
        g0(aVar);
        rx.subscriptions.c cVar = new rx.subscriptions.c();
        G0(new t(aVar, cVar));
        return cVar;
    }

    public final rx.m p0(rx.functions.a aVar, rx.functions.b<? super Throwable> bVar) {
        g0(aVar);
        g0(bVar);
        rx.subscriptions.c cVar = new rx.subscriptions.c();
        G0(new u(aVar, cVar, bVar));
        return cVar;
    }

    public final void q0(rx.d dVar) {
        if (!(dVar instanceof rx.observers.d)) {
            dVar = new rx.observers.d(dVar);
        }
        G0(dVar);
    }

    public final b r(long j4, TimeUnit timeUnit) {
        return t(j4, timeUnit, rx.schedulers.c.a(), false);
    }

    public final <T> void r0(rx.l<T> lVar) {
        lVar.onStart();
        if (!(lVar instanceof rx.observers.e)) {
            lVar = new rx.observers.e(lVar);
        }
        I0(lVar, false);
    }

    public final b s(long j4, TimeUnit timeUnit, rx.h hVar) {
        return t(j4, timeUnit, hVar, false);
    }

    public final b s0(rx.h hVar) {
        g0(hVar);
        return p(new y(hVar));
    }

    public final b t(long j4, TimeUnit timeUnit, rx.h hVar, boolean z3) {
        g0(timeUnit);
        g0(hVar);
        return p(new g(hVar, j4, timeUnit, z3));
    }

    public final rx.observers.a<Void> t0() {
        m3.a g4 = m3.a.g(Long.MAX_VALUE);
        r0(g4);
        return g4;
    }

    public final b u0(long j4, TimeUnit timeUnit) {
        return y0(j4, timeUnit, rx.schedulers.c.a(), null);
    }

    public final b v(rx.functions.a aVar) {
        return z(rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a(), aVar, rx.functions.m.a());
    }

    public final b v0(long j4, TimeUnit timeUnit, b bVar) {
        g0(bVar);
        return y0(j4, timeUnit, rx.schedulers.c.a(), bVar);
    }

    public final b w(rx.functions.a aVar) {
        return z(rx.functions.m.a(), rx.functions.m.a(), aVar, rx.functions.m.a(), rx.functions.m.a());
    }

    public final b w0(long j4, TimeUnit timeUnit, rx.h hVar) {
        return y0(j4, timeUnit, hVar, null);
    }

    public final b x(rx.functions.b<Notification<Object>> bVar) {
        if (bVar != null) {
            return z(rx.functions.m.a(), new h(bVar), new i(bVar), rx.functions.m.a(), rx.functions.m.a());
        }
        throw new IllegalArgumentException("onNotification is null");
    }

    public final b x0(long j4, TimeUnit timeUnit, rx.h hVar, b bVar) {
        g0(bVar);
        return y0(j4, timeUnit, hVar, bVar);
    }

    public final b y(rx.functions.b<? super Throwable> bVar) {
        return z(rx.functions.m.a(), bVar, rx.functions.m.a(), rx.functions.m.a(), rx.functions.m.a());
    }

    public final b y0(long j4, TimeUnit timeUnit, rx.h hVar, b bVar) {
        g0(timeUnit);
        g0(hVar);
        return p(new rx.internal.operators.s(this, j4, timeUnit, hVar, bVar));
    }

    protected final b z(rx.functions.b<? super rx.m> bVar, rx.functions.b<? super Throwable> bVar2, rx.functions.a aVar, rx.functions.a aVar2, rx.functions.a aVar3) {
        g0(bVar);
        g0(bVar2);
        g0(aVar);
        g0(aVar2);
        g0(aVar3);
        return p(new j(aVar, aVar2, bVar2, bVar, aVar3));
    }

    protected b(j0 j0Var, boolean z3) {
        this.f62083a = z3 ? rx.plugins.c.F(j0Var) : j0Var;
    }
}
