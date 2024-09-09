package rx.internal.schedulers;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import rx.b;
import rx.functions.p;
import rx.h;

/* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
/* compiled from: SchedulerWhen.java */
/* loaded from: E:\TSN-r\205dec\5406560.dex */
public class k extends rx.h implements rx.m {

    /* renamed from: d  reason: collision with root package name */
    static final rx.m f63829d = new c();

    /* renamed from: e  reason: collision with root package name */
    static final rx.m f63830e = rx.subscriptions.f.e();

    /* renamed from: a  reason: collision with root package name */
    private final rx.h f63831a;

    /* renamed from: b  reason: collision with root package name */
    private final rx.f<rx.e<rx.b>> f63832b;

    /* renamed from: c  reason: collision with root package name */
    private final rx.m f63833c;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SchedulerWhen.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public class a implements p<g, rx.b> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ h.a f63834a;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
        /* compiled from: SchedulerWhen.java */
        /* renamed from: rx.internal.schedulers.k$a$a  reason: collision with other inner class name */
        /* loaded from: E:\TSN-r\205dec\5406560.dex */
        public class C1315a implements b.j0 {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ g f63836a;

            C1315a(g gVar) {
                this.f63836a = gVar;
            }

            @Override // rx.functions.b
            public void call(rx.d dVar) {
                dVar.a(this.f63836a);
                this.f63836a.call(a.this.f63834a, dVar);
            }
        }

        a(h.a aVar) {
            this.f63834a = aVar;
        }

        @Override // rx.functions.p
        public rx.b call(g gVar) {
            return rx.b.p(new C1315a(gVar));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SchedulerWhen.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    class b extends h.a {

        /* renamed from: a  reason: collision with root package name */
        private final AtomicBoolean f63838a = new AtomicBoolean();

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ h.a f63839b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ rx.f f63840c;

        b(h.a aVar, rx.f fVar) {
            this.f63839b = aVar;
            this.f63840c = fVar;
        }

        public rx.m F(rx.functions.a aVar, long j4, TimeUnit timeUnit) {
            d dVar = new d(aVar, j4, timeUnit);
            this.f63840c.onNext(dVar);
            return dVar;
        }

        public rx.m d(rx.functions.a aVar) {
            e eVar = new e(aVar);
            this.f63840c.onNext(eVar);
            return eVar;
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return this.f63838a.get();
        }

        @Override // rx.m
        public void unsubscribe() {
            if (this.f63838a.compareAndSet(false, true)) {
                this.f63839b.unsubscribe();
                this.f63840c.onCompleted();
            }
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SchedulerWhen.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class c implements rx.m {
        c() {
        }

        @Override // rx.m
        public boolean isUnsubscribed() {
            return false;
        }

        @Override // rx.m
        public void unsubscribe() {
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SchedulerWhen.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class d extends g {

        /* renamed from: a  reason: collision with root package name */
        private final rx.functions.a f63842a;

        /* renamed from: b  reason: collision with root package name */
        private final long f63843b;

        /* renamed from: c  reason: collision with root package name */
        private final TimeUnit f63844c;

        public d(rx.functions.a aVar, long j4, TimeUnit timeUnit) {
            this.f63842a = aVar;
            this.f63843b = j4;
            this.f63844c = timeUnit;
        }

        @Override // rx.internal.schedulers.k.g
        protected rx.m b(h.a aVar, rx.d dVar) {
            return aVar.F(new f(this.f63842a, dVar), this.f63843b, this.f63844c);
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SchedulerWhen.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class e extends g {

        /* renamed from: a  reason: collision with root package name */
        private final rx.functions.a f63845a;

        public e(rx.functions.a aVar) {
            this.f63845a = aVar;
        }

        @Override // rx.internal.schedulers.k.g
        protected rx.m b(h.a aVar, rx.d dVar) {
            return aVar.d(new f(this.f63845a, dVar));
        }
    }

    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SchedulerWhen.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    static class f implements rx.functions.a {

        /* renamed from: a  reason: collision with root package name */
        private rx.d f63846a;

        /* renamed from: b  reason: collision with root package name */
        private rx.functions.a f63847b;

        public f(rx.functions.a aVar, rx.d dVar) {
            this.f63847b = aVar;
            this.f63846a = dVar;
        }

        @Override // rx.functions.a
        public void call() {
            try {
                this.f63847b.call();
            } finally {
                this.f63846a.onCompleted();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Classes with same name are omitted:
  E:\TSN-r\205dec\1574464.dex
 */
    /* compiled from: SchedulerWhen.java */
    /* loaded from: E:\TSN-r\205dec\5406560.dex */
    public static abstract class g extends AtomicReference<rx.m> implements rx.m {
        public g() {
            super(k.f63829d);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void call(h.a aVar, rx.d dVar) {
            rx.m mVar;
            rx.m mVar2 = get();
            if (mVar2 != k.f63830e && mVar2 == (mVar = k.f63829d)) {
                rx.m b4 = b(aVar, dVar);
                if (compareAndSet(mVar, b4)) {
                    return;
                }
                b4.unsubscribe();
            }
        }

        protected abstract rx.m b(h.a aVar, rx.d dVar);

        @Override // rx.m
        public boolean isUnsubscribed() {
            return get().isUnsubscribed();
        }

        @Override // rx.m
        public void unsubscribe() {
            rx.m mVar;
            rx.m mVar2 = k.f63830e;
            do {
                mVar = get();
                if (mVar == k.f63830e) {
                    return;
                }
            } while (!compareAndSet(mVar, mVar2));
            if (mVar != k.f63829d) {
                mVar.unsubscribe();
            }
        }
    }

    public k(p<rx.e<rx.e<rx.b>>, rx.b> pVar, rx.h hVar) {
        this.f63831a = hVar;
        rx.subjects.c x7 = rx.subjects.c.x7();
        this.f63832b = new rx.observers.f(x7);
        this.f63833c = pVar.call(x7.M3()).n0();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // rx.h
    public h.a a() {
        h.a a4 = this.f63831a.a();
        rx.internal.operators.g x7 = rx.internal.operators.g.x7();
        rx.observers.f fVar = new rx.observers.f(x7);
        Object b32 = x7.b3(new a(a4));
        b bVar = new b(a4, fVar);
        this.f63832b.onNext(b32);
        return bVar;
    }

    @Override // rx.m
    public boolean isUnsubscribed() {
        return this.f63833c.isUnsubscribed();
    }

    @Override // rx.m
    public void unsubscribe() {
        this.f63833c.unsubscribe();
    }
}
