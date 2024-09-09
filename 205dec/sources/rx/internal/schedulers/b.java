package rx.internal.schedulers;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import rx.h;
import rx.internal.util.RxThreadFactory;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: EventLoopsScheduler.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public final class b extends rx.h implements j {

    /* renamed from: c  reason: collision with root package name */
    static final String f63766c = "rx.scheduler.max-computation-threads";

    /* renamed from: d  reason: collision with root package name */
    static final int f63767d;

    /* renamed from: e  reason: collision with root package name */
    static final c f63768e;

    /* renamed from: f  reason: collision with root package name */
    static final C1313b f63769f;

    /* renamed from: a  reason: collision with root package name */
    final ThreadFactory f63770a;

    /* renamed from: b  reason: collision with root package name */
    final AtomicReference<C1313b> f63771b = new AtomicReference<>(f63769f);

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: EventLoopsScheduler.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static final class a extends h.a {

        /* renamed from: a  reason: collision with root package name */
        private final rx.internal.util.m f63772a;

        /* renamed from: b  reason: collision with root package name */
        private final rx.subscriptions.b f63773b;

        /* renamed from: c  reason: collision with root package name */
        private final rx.internal.util.m f63774c;

        /* renamed from: d  reason: collision with root package name */
        private final c f63775d;

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: EventLoopsScheduler.java */
        /* renamed from: rx.internal.schedulers.b$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        class C1311a implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.functions.a f63776a;

            C1311a(rx.functions.a aVar) {
                this.f63776a = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f63776a.call();
            }
        }

        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: EventLoopsScheduler.java */
        /* renamed from: rx.internal.schedulers.b$a$b  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        class C1312b implements rx.functions.a {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ rx.functions.a f63778a;

            C1312b(rx.functions.a aVar) {
                this.f63778a = aVar;
            }

            @Override // rx.functions.a
            public void call() {
                if (a.this.isUnsubscribed()) {
                    return;
                }
                this.f63778a.call();
            }
        }

        a(c cVar) {
            rx.internal.util.m mVar = new rx.internal.util.m();
            this.f63772a = mVar;
            rx.subscriptions.b bVar = new rx.subscriptions.b();
            this.f63773b = bVar;
            this.f63774c = new rx.internal.util.m(mVar, bVar);
            this.f63775d = cVar;
        }

        public rx.m F(rx.functions.a aVar, long j4, TimeUnit timeUnit) {
            if (isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            return this.f63775d.N(new C1312b(aVar), j4, timeUnit, this.f63773b);
        }

        public rx.m d(rx.functions.a aVar) {
            if (isUnsubscribed()) {
                return rx.subscriptions.f.e();
            }
            return this.f63775d.M(new C1311a(aVar), 0L, null, this.f63772a);
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f63774c.isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            this.f63774c.unsubscribe();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: EventLoopsScheduler.java */
    /* renamed from: rx.internal.schedulers.b$b  reason: collision with other inner class name */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class C1313b {

        /* renamed from: a  reason: collision with root package name */
        final int f63780a;

        /* renamed from: b  reason: collision with root package name */
        final c[] f63781b;

        /* renamed from: c  reason: collision with root package name */
        long f63782c;

        C1313b(ThreadFactory threadFactory, int i4) {
            this.f63780a = i4;
            this.f63781b = new c[i4];
            for (int i5 = 0; i5 < i4; i5++) {
                this.f63781b[i5] = new c(threadFactory);
            }
        }

        public c a() {
            int i4 = this.f63780a;
            if (i4 == 0) {
                return b.f63768e;
            }
            c[] cVarArr = this.f63781b;
            long j4 = this.f63782c;
            this.f63782c = 1 + j4;
            return cVarArr[(int) (j4 % i4)];
        }

        public void b() {
            for (c cVar : this.f63781b) {
                cVar.unsubscribe();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: EventLoopsScheduler.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static final class c extends h {
        c(ThreadFactory threadFactory) {
            super(threadFactory);
        }
    }

    static {
        int intValue = Integer.getInteger("rx.scheduler.max-computation-threads", 0).intValue();
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        if (intValue <= 0 || intValue > availableProcessors) {
            intValue = availableProcessors;
        }
        f63767d = intValue;
        c cVar = new c(RxThreadFactory.NONE);
        f63768e = cVar;
        cVar.unsubscribe();
        f63769f = new C1313b(null, 0);
    }

    public b(ThreadFactory threadFactory) {
        this.f63770a = threadFactory;
        start();
    }

    public rx.m F(rx.functions.a aVar) {
        return this.f63771b.get().a().L(aVar, -1L, TimeUnit.NANOSECONDS);
    }

    @Override // rx.h
    public h.a a() {
        return new a(this.f63771b.get().a());
    }

    @Override // rx.internal.schedulers.j
    public void shutdown() {
        C1313b c1313b;
        C1313b c1313b2;
        do {
            c1313b = this.f63771b.get();
            c1313b2 = f63769f;
            if (c1313b == c1313b2) {
                return;
            }
        } while (!this.f63771b.compareAndSet(c1313b, c1313b2));
        c1313b.b();
    }

    @Override // rx.internal.schedulers.j
    public void start() {
        C1313b c1313b = new C1313b(this.f63770a, f63767d);
        if (this.f63771b.compareAndSet(f63769f, c1313b)) {
            return;
        }
        c1313b.b();
    }
}
