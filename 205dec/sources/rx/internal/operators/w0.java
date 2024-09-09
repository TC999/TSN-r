package rx.internal.operators;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import rx.Notification;
import rx.e;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
/* compiled from: OnSubscribeRedo.java */
/* loaded from: E:\TSN-r\205dec\7343912.dex */
public final class w0<T> implements e.a<T> {

    /* renamed from: f  reason: collision with root package name */
    static final rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> f63492f = new a();

    /* renamed from: a  reason: collision with root package name */
    final rx.e<T> f63493a;

    /* renamed from: b  reason: collision with root package name */
    private final rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> f63494b;

    /* renamed from: c  reason: collision with root package name */
    final boolean f63495c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f63496d;

    /* renamed from: e  reason: collision with root package name */
    private final rx.h f63497e;

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    static class a implements rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeRedo.java */
        /* renamed from: rx.internal.operators.w0$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class C1303a implements rx.functions.p<Notification<?>, Notification<?>> {
            C1303a() {
            }

            @Override // rx.functions.p
            public Notification<?> call(Notification<?> notification) {
                return Notification.e(null);
            }
        }

        a() {
        }

        @Override // rx.functions.p
        public rx.e<?> call(rx.e<? extends Notification<?>> eVar) {
            return eVar.b3(new C1303a());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class b implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.l f63499a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.subjects.f f63500b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.internal.producers.a f63501c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ AtomicLong f63502d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ rx.subscriptions.e f63503e;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeRedo.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class a extends rx.l<T> {

            /* renamed from: a  reason: collision with root package name */
            boolean f63505a;

            a() {
            }

            private void g() {
                long j4;
                do {
                    j4 = b.this.f63502d.get();
                    if (j4 == Long.MAX_VALUE) {
                        return;
                    }
                } while (!b.this.f63502d.compareAndSet(j4, j4 - 1));
            }

            @Override // rx.f
            public void onCompleted() {
                if (this.f63505a) {
                    return;
                }
                this.f63505a = true;
                unsubscribe();
                b.this.f63500b.onNext(Notification.b());
            }

            @Override // rx.f
            public void onError(Throwable th) {
                if (this.f63505a) {
                    return;
                }
                this.f63505a = true;
                unsubscribe();
                b.this.f63500b.onNext(Notification.d(th));
            }

            @Override // rx.f
            public void onNext(T t3) {
                if (this.f63505a) {
                    return;
                }
                b.this.f63499a.onNext(t3);
                g();
                b.this.f63501c.b(1L);
            }

            @Override // rx.l, rx.observers.a
            public void setProducer(rx.g gVar) {
                b.this.f63501c.c(gVar);
            }
        }

        b(rx.l lVar, rx.subjects.f fVar, rx.internal.producers.a aVar, AtomicLong atomicLong, rx.subscriptions.e eVar) {
            this.f63499a = lVar;
            this.f63500b = fVar;
            this.f63501c = aVar;
            this.f63502d = atomicLong;
            this.f63503e = eVar;
        }

        @Override // rx.functions.a
        public void call() {
            if (this.f63499a.isUnsubscribed()) {
                return;
            }
            a aVar = new a();
            this.f63503e.b(aVar);
            w0.this.f63493a.I6(aVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class c implements e.b<Notification<?>, Notification<?>> {

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeRedo.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a extends rx.l<Notification<?>> {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.l f63508a;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(rx.l lVar, rx.l lVar2) {
                super(lVar);
                this.f63508a = lVar2;
            }

            @Override // rx.f
            /* renamed from: g */
            public void onNext(Notification<?> notification) {
                if (notification.k() && w0.this.f63495c) {
                    this.f63508a.onCompleted();
                } else if (notification.l() && w0.this.f63496d) {
                    this.f63508a.onError(notification.g());
                } else {
                    this.f63508a.onNext(notification);
                }
            }

            @Override // rx.f
            public void onCompleted() {
                this.f63508a.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                this.f63508a.onError(th);
            }

            @Override // rx.l, rx.observers.a
            public void setProducer(rx.g gVar) {
                gVar.request(Long.MAX_VALUE);
            }
        }

        c() {
        }

        @Override // rx.functions.p
        public rx.l<? super Notification<?>> call(rx.l<? super Notification<?>> lVar) {
            return new a(lVar, lVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class d implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ rx.e f63510a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.l f63511b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicLong f63512c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h.a f63513d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f63514e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f63515f;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeRedo.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        class a extends rx.l<Object> {
            a(rx.l lVar) {
                super(lVar);
            }

            @Override // rx.f
            public void onCompleted() {
                d.this.f63511b.onCompleted();
            }

            @Override // rx.f
            public void onError(Throwable th) {
                d.this.f63511b.onError(th);
            }

            @Override // rx.f
            public void onNext(Object obj) {
                if (d.this.f63511b.isUnsubscribed()) {
                    return;
                }
                if (d.this.f63512c.get() > 0) {
                    d dVar = d.this;
                    dVar.f63513d.c(dVar.f63514e);
                    return;
                }
                d.this.f63515f.compareAndSet(false, true);
            }

            @Override // rx.l, rx.observers.a
            public void setProducer(rx.g gVar) {
                gVar.request(Long.MAX_VALUE);
            }
        }

        d(rx.e eVar, rx.l lVar, AtomicLong atomicLong, h.a aVar, rx.functions.a aVar2, AtomicBoolean atomicBoolean) {
            this.f63510a = eVar;
            this.f63511b = lVar;
            this.f63512c = atomicLong;
            this.f63513d = aVar;
            this.f63514e = aVar2;
            this.f63515f = atomicBoolean;
        }

        @Override // rx.functions.a
        public void call() {
            this.f63510a.I6(new a(this.f63511b));
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public class e implements rx.g {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AtomicLong f63518a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ rx.internal.producers.a f63519b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ AtomicBoolean f63520c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ h.a f63521d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ rx.functions.a f63522e;

        e(AtomicLong atomicLong, rx.internal.producers.a aVar, AtomicBoolean atomicBoolean, h.a aVar2, rx.functions.a aVar3) {
            this.f63518a = atomicLong;
            this.f63519b = aVar;
            this.f63520c = atomicBoolean;
            this.f63521d = aVar2;
            this.f63522e = aVar3;
        }

        @Override // rx.g
        public void request(long j4) {
            if (j4 > 0) {
                rx.internal.operators.a.b(this.f63518a, j4);
                this.f63519b.request(j4);
                if (this.f63520c.compareAndSet(true, false)) {
                    this.f63521d.c(this.f63522e);
                }
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class f implements rx.functions.p<rx.e<? extends Notification<?>>, rx.e<?>> {

        /* renamed from: a  reason: collision with root package name */
        final long f63524a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeRedo.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.p<Notification<?>, Notification<?>> {

            /* renamed from: a  reason: collision with root package name */
            int f63525a;

            a() {
            }

            @Override // rx.functions.p
            public Notification<?> call(Notification<?> notification) {
                long j4 = f.this.f63524a;
                if (j4 == 0) {
                    return notification;
                }
                int i4 = this.f63525a + 1;
                this.f63525a = i4;
                return ((long) i4) <= j4 ? Notification.e(Integer.valueOf(i4)) : notification;
            }
        }

        public f(long j4) {
            this.f63524a = j4;
        }

        @Override // rx.functions.p
        public rx.e<?> call(rx.e<? extends Notification<?>> eVar) {
            return eVar.b3(new a()).A1();
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
    /* compiled from: OnSubscribeRedo.java */
    /* loaded from: E:\TSN-r\205dec\7343912.dex */
    public static final class g implements rx.functions.p<rx.e<? extends Notification<?>>, rx.e<? extends Notification<?>>> {

        /* renamed from: a  reason: collision with root package name */
        final rx.functions.q<Integer, Throwable, Boolean> f63527a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\5406560.dex
 */
        /* compiled from: OnSubscribeRedo.java */
        /* loaded from: E:\TSN-r\205dec\7343912.dex */
        public class a implements rx.functions.q<Notification<Integer>, Notification<?>, Notification<Integer>> {
            a() {
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // rx.functions.q
            public Notification<Integer> call(Notification<Integer> notification, Notification<?> notification2) {
                int intValue = notification.h().intValue();
                return g.this.f63527a.call(Integer.valueOf(intValue), notification2.g()).booleanValue() ? Notification.e(Integer.valueOf(intValue + 1)) : notification2;
            }
        }

        public g(rx.functions.q<Integer, Throwable, Boolean> qVar) {
            this.f63527a = qVar;
        }

        @Override // rx.functions.p
        public rx.e<? extends Notification<?>> call(rx.e<? extends Notification<?>> eVar) {
            return eVar.J4(Notification.e(0), new a());
        }
    }

    private w0(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar, boolean z3, boolean z4, rx.h hVar) {
        this.f63493a = eVar;
        this.f63494b = pVar;
        this.f63495c = z3;
        this.f63496d = z4;
        this.f63497e = hVar;
    }

    public static <T> rx.e<T> a(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar, rx.h hVar) {
        return rx.e.H6(new w0(eVar, pVar, false, false, hVar));
    }

    public static <T> rx.e<T> b(rx.e<T> eVar) {
        return e(eVar, rx.schedulers.c.m());
    }

    public static <T> rx.e<T> c(rx.e<T> eVar, long j4) {
        return d(eVar, j4, rx.schedulers.c.m());
    }

    public static <T> rx.e<T> d(rx.e<T> eVar, long j4, rx.h hVar) {
        if (j4 == 0) {
            return rx.e.S1();
        }
        if (j4 >= 0) {
            return g(eVar, new f(j4 - 1), hVar);
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> rx.e<T> e(rx.e<T> eVar, rx.h hVar) {
        return g(eVar, f63492f, hVar);
    }

    public static <T> rx.e<T> f(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar) {
        return rx.e.H6(new w0(eVar, pVar, false, true, rx.schedulers.c.m()));
    }

    public static <T> rx.e<T> g(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar, rx.h hVar) {
        return rx.e.H6(new w0(eVar, pVar, false, true, hVar));
    }

    public static <T> rx.e<T> h(rx.e<T> eVar) {
        return j(eVar, f63492f);
    }

    public static <T> rx.e<T> i(rx.e<T> eVar, long j4) {
        if (j4 >= 0) {
            return j4 == 0 ? eVar : j(eVar, new f(j4));
        }
        throw new IllegalArgumentException("count >= 0 expected");
    }

    public static <T> rx.e<T> j(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar) {
        return rx.e.H6(new w0(eVar, pVar, true, false, rx.schedulers.c.m()));
    }

    public static <T> rx.e<T> k(rx.e<T> eVar, rx.functions.p<? super rx.e<? extends Notification<?>>, ? extends rx.e<?>> pVar, rx.h hVar) {
        return rx.e.H6(new w0(eVar, pVar, true, false, hVar));
    }

    @Override // rx.functions.b
    public /* bridge */ /* synthetic */ void call(Object obj) {
        call((rx.l) ((rx.l) obj));
    }

    public void call(rx.l<? super T> lVar) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(true);
        AtomicLong atomicLong = new AtomicLong();
        h.a a4 = this.f63497e.a();
        lVar.add(a4);
        rx.subscriptions.e eVar = new rx.subscriptions.e();
        lVar.add(eVar);
        rx.subjects.e<T, T> w7 = rx.subjects.b.x7().w7();
        w7.q5(rx.observers.h.d());
        rx.internal.producers.a aVar = new rx.internal.producers.a();
        b bVar = new b(lVar, w7, aVar, atomicLong, eVar);
        a4.c(new d(this.f63494b.call(w7.Z2(new c())), lVar, atomicLong, a4, bVar, atomicBoolean));
        lVar.setProducer(new e(atomicLong, aVar, atomicBoolean, a4, bVar));
    }
}
